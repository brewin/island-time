package io.islandtime.parser

import io.islandtime.base.DateProperty
import io.islandtime.base.DurationProperty
import io.islandtime.format.SignStyle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class WholeNumberParserTest {
    @Test
    fun `fixed length parser throws an exception if length is out of range`() {
        assertFailsWith<IllegalArgumentException> {
            temporalParser { wholeNumber(0) }
        }

        assertFailsWith<IllegalArgumentException> {
            temporalParser { wholeNumber(20) }
        }
    }

    @Test
    fun `fixed length parser parses exact number of digits`() {
        val dowParser = temporalParser {
            wholeNumber(1) {
                associateWith(DateProperty.DayOfWeek)
            }
        }

        assertEquals(9, dowParser.parse("9")[DateProperty.DayOfWeek])

        val dateParser = temporalParser {
            wholeNumber(3) {
                associateWith(DateProperty.DayOfYear)
            }
            wholeNumber(4) {
                associateWith(DateProperty.Year)
            }
        }

        val result = dateParser.parse("0653000")
        assertEquals(65, result[DateProperty.DayOfYear])
        assertEquals(3000, result[DateProperty.Year])
    }

    @Test
    fun `fixed length parser doesn't enforce sign style by default`() {
        val dowParser1 = temporalParser {
            wholeNumber(1) {
                associateWith(DateProperty.DayOfWeek)
            }
        }

        assertEquals(9, dowParser1.parse("+9")[DateProperty.DayOfWeek])

        val dowParser2 = temporalParser {
            wholeNumber(1) {
                associateWith(DateProperty.DayOfWeek)
            }
        }
        assertEquals(-9, dowParser2.parse("-9")[DateProperty.DayOfWeek])
    }

    @Test
    fun `enforces NEVER sign style`() {
        listOf(
            temporalParser {
                wholeNumber(1) {
                    associateWith(DateProperty.DayOfWeek)
                    enforceSignStyle(SignStyle.NEVER)
                }
            },
            temporalParser {
                wholeNumber {
                    associateWith(DateProperty.DayOfWeek)
                    enforceSignStyle(SignStyle.NEVER)
                }
            }
        ).forEach { parser ->
            assertFailsWith<TemporalParseException> { parser.parse("+9") }
            assertFailsWith<TemporalParseException> { parser.parse("-9") }
        }
    }

    @Test
    fun `enforces NEGATIVE_ONLY sign style`() {
        listOf(
            temporalParser {
                wholeNumber(1) {
                    associateWith(DateProperty.DayOfWeek)
                    enforceSignStyle(SignStyle.NEGATIVE_ONLY)
                }
            },
            temporalParser {
                wholeNumber {
                    associateWith(DateProperty.DayOfWeek)
                    enforceSignStyle(SignStyle.NEGATIVE_ONLY)
                }
            }
        ).forEach { parser ->
            assertFailsWith<TemporalParseException> { parser.parse("+9") }
            assertEquals(9, parser.parse("9")[DateProperty.DayOfWeek])
            assertEquals(-9, parser.parse("-9")[DateProperty.DayOfWeek])
        }
    }

    @Test
    fun `enforces ALWAYS sign style`() {
        listOf(
            temporalParser {
                wholeNumber(1) {
                    associateWith(DateProperty.DayOfWeek)
                    enforceSignStyle(SignStyle.ALWAYS)
                }
            },
            temporalParser {
                wholeNumber {
                    associateWith(DateProperty.DayOfWeek)
                    enforceSignStyle(SignStyle.ALWAYS)
                }
            }
        ).forEach { parser ->
            assertEquals(9, parser.parse("+9")[DateProperty.DayOfWeek])
            assertFailsWith<TemporalParseException> { parser.parse("9") }
            assertEquals(-9, parser.parse("-9")[DateProperty.DayOfWeek])
        }
    }

    @Test
    fun `variable length parser throws an exception if range is empty`() {
        assertFailsWith<IllegalArgumentException> {
            temporalParser { wholeNumber(IntRange.EMPTY) }
        }
    }

    @Test
    fun `variable length parser throws an exception if range is outside of 1-19`() {
        assertFailsWith<IllegalArgumentException> {
            temporalParser { wholeNumber(0..4) }
        }

        assertFailsWith<IllegalArgumentException> {
            temporalParser { wholeNumber(5..20) }
        }
    }

    @Test
    fun `variable length parser parses digits within length`() {
        val parser = temporalParser {
            wholeNumber(1..3) {
                associateWith(DateProperty.DayOfYear)
            }
        }

        assertEquals(4, parser.parse("4")[DateProperty.DayOfYear])
        assertEquals(400, parser.parse("400")[DateProperty.DayOfYear])

        val parserWithLiteral = temporalParser {
            wholeNumber(1..3) {
                associateWith(DateProperty.DayOfYear)
            }
            +'M'
        }

        assertEquals(-2, parserWithLiteral.parse("-2M")[DateProperty.DayOfYear])
        assertEquals(-20, parserWithLiteral.parse("-20M")[DateProperty.DayOfYear])
    }

    @Test
    fun `variable length parser throws an exception if minimum number of digits can't be parsed`() {
        val parser = temporalParser {
            wholeNumber(2..3) {
                associateWith(DateProperty.DayOfYear)
            }
            +"DOY"
        }

        assertFailsWith<TemporalParseException> { parser.parse("2DOY") }
        assertFailsWith<TemporalParseException> { parser.parse("-2DOY") }
    }

    @Test
    fun `variable length parser throws an exception if consecutive digits exceed the maximum`() {
        val parser = temporalParser {
            wholeNumber(2..3) {
                associateWith(DateProperty.DayOfYear)
            }
            wholeNumber(1..4) {
                associateWith(DateProperty.Year)
            }
        }

        assertFailsWith<TemporalParseException> { parser.parse("2001975") }
        assertFailsWith<TemporalParseException> { parser.parse("-1934-034") }
    }

    @Test
    fun `reports an error when there are no characters to parse`() {
        listOf(
            temporalParser {
                +' '
                wholeNumber(2)
            }, temporalParser {
                +' '
                wholeNumber()
            }
        ).forEach { parser ->
            val exception = assertFailsWith<TemporalParseException> { parser.parse(" ") }
            assertEquals(1, exception.errorIndex)
            assertEquals(" ", exception.parsedString)
        }
    }

    @Test
    fun `throws an exception on overflow`() {
        val parsers = listOf(
            temporalParser {
                +' '
                wholeNumber(19) {
                    onParsed { this[DurationProperty.Hours] = it }
                }
            }, temporalParser {
                +' '
                wholeNumber {
                    onParsed { this[DurationProperty.Hours] = it }
                }
            }
        )

        listOf(
            " 9223372036854775808",
            " -9223372036854775809",
            " +9300000000000000000"
        ).forEach { text ->
            parsers.forEach { parser ->
                val exception = assertFailsWith<TemporalParseException> { parser.parse(text) }
                assertEquals(1, exception.errorIndex)
                assertEquals(text, exception.parsedString)
                assertTrue { exception.cause is ArithmeticException }
            }
        }
    }
}