// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * This tool searches the web for relevant results to use in a response. Learn more about the
 * [web search tool](https://platform.openai.com/docs/guides/tools-web-search).
 */
@NoAutoDetect
class WebSearchTool
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("search_context_size")
    @ExcludeMissing
    private val searchContextSize: JsonField<SearchContextSize> = JsonMissing.of(),
    @JsonProperty("user_location")
    @ExcludeMissing
    private val userLocation: JsonField<UserLocation> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The type of the web search tool. One of:
     * - `web_search_preview`
     * - `web_search_preview_2025_03_11`
     */
    fun type(): Type = type.getRequired("type")

    /**
     * High level guidance for the amount of context window space to use for the search. One of
     * `low`, `medium`, or `high`. `medium` is the default.
     */
    fun searchContextSize(): Optional<SearchContextSize> =
        Optional.ofNullable(searchContextSize.getNullable("search_context_size"))

    fun userLocation(): Optional<UserLocation> =
        Optional.ofNullable(userLocation.getNullable("user_location"))

    /**
     * The type of the web search tool. One of:
     * - `web_search_preview`
     * - `web_search_preview_2025_03_11`
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * High level guidance for the amount of context window space to use for the search. One of
     * `low`, `medium`, or `high`. `medium` is the default.
     */
    @JsonProperty("search_context_size")
    @ExcludeMissing
    fun _searchContextSize(): JsonField<SearchContextSize> = searchContextSize

    @JsonProperty("user_location")
    @ExcludeMissing
    fun _userLocation(): JsonField<UserLocation> = userLocation

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): WebSearchTool = apply {
        if (validated) {
            return@apply
        }

        type()
        searchContextSize()
        userLocation().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebSearchTool].
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebSearchTool]. */
    class Builder internal constructor() {

        private var type: JsonField<Type>? = null
        private var searchContextSize: JsonField<SearchContextSize> = JsonMissing.of()
        private var userLocation: JsonField<UserLocation> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webSearchTool: WebSearchTool) = apply {
            type = webSearchTool.type
            searchContextSize = webSearchTool.searchContextSize
            userLocation = webSearchTool.userLocation
            additionalProperties = webSearchTool.additionalProperties.toMutableMap()
        }

        /**
         * The type of the web search tool. One of:
         * - `web_search_preview`
         * - `web_search_preview_2025_03_11`
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * The type of the web search tool. One of:
         * - `web_search_preview`
         * - `web_search_preview_2025_03_11`
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /**
         * High level guidance for the amount of context window space to use for the search. One of
         * `low`, `medium`, or `high`. `medium` is the default.
         */
        fun searchContextSize(searchContextSize: SearchContextSize) =
            searchContextSize(JsonField.of(searchContextSize))

        /**
         * High level guidance for the amount of context window space to use for the search. One of
         * `low`, `medium`, or `high`. `medium` is the default.
         */
        fun searchContextSize(searchContextSize: JsonField<SearchContextSize>) = apply {
            this.searchContextSize = searchContextSize
        }

        fun userLocation(userLocation: UserLocation?) =
            userLocation(JsonField.ofNullable(userLocation))

        fun userLocation(userLocation: Optional<UserLocation>) =
            userLocation(userLocation.getOrNull())

        fun userLocation(userLocation: JsonField<UserLocation>) = apply {
            this.userLocation = userLocation
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): WebSearchTool =
            WebSearchTool(
                checkRequired("type", type),
                searchContextSize,
                userLocation,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * The type of the web search tool. One of:
     * - `web_search_preview`
     * - `web_search_preview_2025_03_11`
     */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val WEB_SEARCH_PREVIEW = of("web_search_preview")

            @JvmField val WEB_SEARCH_PREVIEW_2025_03_11 = of("web_search_preview_2025_03_11")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            WEB_SEARCH_PREVIEW,
            WEB_SEARCH_PREVIEW_2025_03_11,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            WEB_SEARCH_PREVIEW,
            WEB_SEARCH_PREVIEW_2025_03_11,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                WEB_SEARCH_PREVIEW -> Value.WEB_SEARCH_PREVIEW
                WEB_SEARCH_PREVIEW_2025_03_11 -> Value.WEB_SEARCH_PREVIEW_2025_03_11
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                WEB_SEARCH_PREVIEW -> Known.WEB_SEARCH_PREVIEW
                WEB_SEARCH_PREVIEW_2025_03_11 -> Known.WEB_SEARCH_PREVIEW_2025_03_11
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * High level guidance for the amount of context window space to use for the search. One of
     * `low`, `medium`, or `high`. `medium` is the default.
     */
    class SearchContextSize @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LOW = of("low")

            @JvmField val MEDIUM = of("medium")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = SearchContextSize(JsonField.of(value))
        }

        /** An enum containing [SearchContextSize]'s known values. */
        enum class Known {
            LOW,
            MEDIUM,
            HIGH,
        }

        /**
         * An enum containing [SearchContextSize]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [SearchContextSize] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LOW,
            MEDIUM,
            HIGH,
            /**
             * An enum member indicating that [SearchContextSize] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                LOW -> Value.LOW
                MEDIUM -> Value.MEDIUM
                HIGH -> Value.HIGH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                LOW -> Known.LOW
                MEDIUM -> Known.MEDIUM
                HIGH -> Known.HIGH
                else -> throw OpenAIInvalidDataException("Unknown SearchContextSize: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is SearchContextSize && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    @NoAutoDetect
    class UserLocation
    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
        @JsonProperty("city")
        @ExcludeMissing
        private val city: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country")
        @ExcludeMissing
        private val country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region")
        @ExcludeMissing
        private val region: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timezone")
        @ExcludeMissing
        private val timezone: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The type of location approximation. Always `approximate`. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /** Free text input for the city of the user, e.g. `San Francisco`. */
        fun city(): Optional<String> = Optional.ofNullable(city.getNullable("city"))

        /**
         * The two-letter [ISO country code](https://en.wikipedia.org/wiki/ISO_3166-1) of the user,
         * e.g. `US`.
         */
        fun country(): Optional<String> = Optional.ofNullable(country.getNullable("country"))

        /** Free text input for the region of the user, e.g. `California`. */
        fun region(): Optional<String> = Optional.ofNullable(region.getNullable("region"))

        /**
         * The [IANA timezone](https://timeapi.io/documentation/iana-timezones) of the user, e.g.
         * `America/Los_Angeles`.
         */
        fun timezone(): Optional<String> = Optional.ofNullable(timezone.getNullable("timezone"))

        /** Free text input for the city of the user, e.g. `San Francisco`. */
        @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * The two-letter [ISO country code](https://en.wikipedia.org/wiki/ISO_3166-1) of the user,
         * e.g. `US`.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /** Free text input for the region of the user, e.g. `California`. */
        @JsonProperty("region") @ExcludeMissing fun _region(): JsonField<String> = region

        /**
         * The [IANA timezone](https://timeapi.io/documentation/iana-timezones) of the user, e.g.
         * `America/Los_Angeles`.
         */
        @JsonProperty("timezone") @ExcludeMissing fun _timezone(): JsonField<String> = timezone

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): UserLocation = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("approximate")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            city()
            country()
            region()
            timezone()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [UserLocation]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UserLocation]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("approximate")
            private var city: JsonField<String> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var region: JsonField<String> = JsonMissing.of()
            private var timezone: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(userLocation: UserLocation) = apply {
                type = userLocation.type
                city = userLocation.city
                country = userLocation.country
                region = userLocation.region
                timezone = userLocation.timezone
                additionalProperties = userLocation.additionalProperties.toMutableMap()
            }

            /** The type of location approximation. Always `approximate`. */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Free text input for the city of the user, e.g. `San Francisco`. */
            fun city(city: String) = city(JsonField.of(city))

            /** Free text input for the city of the user, e.g. `San Francisco`. */
            fun city(city: JsonField<String>) = apply { this.city = city }

            /**
             * The two-letter [ISO country code](https://en.wikipedia.org/wiki/ISO_3166-1) of the
             * user, e.g. `US`.
             */
            fun country(country: String) = country(JsonField.of(country))

            /**
             * The two-letter [ISO country code](https://en.wikipedia.org/wiki/ISO_3166-1) of the
             * user, e.g. `US`.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /** Free text input for the region of the user, e.g. `California`. */
            fun region(region: String) = region(JsonField.of(region))

            /** Free text input for the region of the user, e.g. `California`. */
            fun region(region: JsonField<String>) = apply { this.region = region }

            /**
             * The [IANA timezone](https://timeapi.io/documentation/iana-timezones) of the user,
             * e.g. `America/Los_Angeles`.
             */
            fun timezone(timezone: String) = timezone(JsonField.of(timezone))

            /**
             * The [IANA timezone](https://timeapi.io/documentation/iana-timezones) of the user,
             * e.g. `America/Los_Angeles`.
             */
            fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): UserLocation =
                UserLocation(
                    type,
                    city,
                    country,
                    region,
                    timezone,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UserLocation && type == other.type && city == other.city && country == other.country && region == other.region && timezone == other.timezone && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, city, country, region, timezone, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UserLocation{type=$type, city=$city, country=$country, region=$region, timezone=$timezone, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WebSearchTool && type == other.type && searchContextSize == other.searchContextSize && userLocation == other.userLocation && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, searchContextSize, userLocation, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebSearchTool{type=$type, searchContextSize=$searchContextSize, userLocation=$userLocation, additionalProperties=$additionalProperties}"
}
