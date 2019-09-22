package io.islandtime

import io.islandtime.zone.TimeZoneRules
import io.islandtime.zone.TimeZoneRulesException
import io.islandtime.zone.TimeZoneRulesProvider

inline class TimeZone(val regionId: String) : Comparable<TimeZone> {

    val isValid: Boolean
        get() = TimeZoneRulesProvider.availableRegionIds.contains(regionId)

    val rules: TimeZoneRules
        get() = TimeZoneRulesProvider.rulesFor(regionId)

    override fun compareTo(other: TimeZone): Int {
        return regionId.compareTo(other.regionId)
    }

    override fun toString(): String {
        return regionId
    }

    fun validated(): TimeZone {
        if (!isValid) {
            throw TimeZoneRulesException("'$regionId' is not supported by the current time zone rules provider")
        }
        return this
    }

    companion object {
        val UTC = TimeZone("Etc/UTC")
    }
}

fun String.toTimeZone() = TimeZone(this)

internal const val MAX_TIME_ZONE_STRING_LENGTH = 50