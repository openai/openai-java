// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

class BetaVectorStoreUpdateParams
constructor(
    private val vectorStoreId: String,
    private val body: BetaVectorStoreUpdateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun vectorStoreId(): String = vectorStoreId

    /** The expiration policy for a vector store. */
    fun expiresAfter(): Optional<ExpiresAfter> = body.expiresAfter()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    fun metadata(): Optional<JsonValue> = body.metadata()

    /** The name of the vector store. */
    fun name(): Optional<String> = body.name()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): BetaVectorStoreUpdateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> vectorStoreId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaVectorStoreUpdateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("expires_after") private val expiresAfter: ExpiresAfter?,
        @JsonProperty("metadata") private val metadata: JsonValue?,
        @JsonProperty("name") private val name: String?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The expiration policy for a vector store. */
        @JsonProperty("expires_after")
        fun expiresAfter(): Optional<ExpiresAfter> = Optional.ofNullable(expiresAfter)

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata")
        fun metadata(): Optional<JsonValue> = Optional.ofNullable(metadata)

        /** The name of the vector store. */
        @JsonProperty("name") fun name(): Optional<String> = Optional.ofNullable(name)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var expiresAfter: ExpiresAfter? = null
            private var metadata: JsonValue? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaVectorStoreUpdateBody: BetaVectorStoreUpdateBody) = apply {
                expiresAfter = betaVectorStoreUpdateBody.expiresAfter
                metadata = betaVectorStoreUpdateBody.metadata
                name = betaVectorStoreUpdateBody.name
                additionalProperties = betaVectorStoreUpdateBody.additionalProperties.toMutableMap()
            }

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: ExpiresAfter) = apply {
                this.expiresAfter = expiresAfter
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /** The name of the vector store. */
            fun name(name: String) = apply { this.name = name }

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

            fun build(): BetaVectorStoreUpdateBody =
                BetaVectorStoreUpdateBody(
                    expiresAfter,
                    metadata,
                    name,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaVectorStoreUpdateBody && expiresAfter == other.expiresAfter && metadata == other.metadata && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(expiresAfter, metadata, name, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaVectorStoreUpdateBody{expiresAfter=$expiresAfter, metadata=$metadata, name=$name, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var vectorStoreId: String? = null
        private var body: BetaVectorStoreUpdateBody.Builder = BetaVectorStoreUpdateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaVectorStoreUpdateParams: BetaVectorStoreUpdateParams) = apply {
            vectorStoreId = betaVectorStoreUpdateParams.vectorStoreId
            body = betaVectorStoreUpdateParams.body.toBuilder()
            additionalHeaders = betaVectorStoreUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaVectorStoreUpdateParams.additionalQueryParams.toBuilder()
        }

        fun vectorStoreId(vectorStoreId: String) = apply { this.vectorStoreId = vectorStoreId }

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: ExpiresAfter) = apply { body.expiresAfter(expiresAfter) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /** The name of the vector store. */
        fun name(name: String) = apply { body.name(name) }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun build(): BetaVectorStoreUpdateParams =
            BetaVectorStoreUpdateParams(
                checkNotNull(vectorStoreId) { "`vectorStoreId` is required but was not set" },
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** The expiration policy for a vector store. */
    @NoAutoDetect
    class ExpiresAfter
    @JsonCreator
    private constructor(
        @JsonProperty("anchor") private val anchor: Anchor,
        @JsonProperty("days") private val days: Long,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        @JsonProperty("anchor") fun anchor(): Anchor = anchor

        /** The number of days after the anchor time that the vector store will expire. */
        @JsonProperty("days") fun days(): Long = days

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var anchor: Anchor? = null
            private var days: Long? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(expiresAfter: ExpiresAfter) = apply {
                anchor = expiresAfter.anchor
                days = expiresAfter.days
                additionalProperties = expiresAfter.additionalProperties.toMutableMap()
            }

            /**
             * Anchor timestamp after which the expiration policy applies. Supported anchors:
             * `last_active_at`.
             */
            fun anchor(anchor: Anchor) = apply { this.anchor = anchor }

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: Long) = apply { this.days = days }

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

            fun build(): ExpiresAfter =
                ExpiresAfter(
                    checkNotNull(anchor) { "`anchor` is required but was not set" },
                    checkNotNull(days) { "`days` is required but was not set" },
                    additionalProperties.toImmutable(),
                )
        }

        class Anchor
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val LAST_ACTIVE_AT = of("last_active_at")

                @JvmStatic fun of(value: String) = Anchor(JsonField.of(value))
            }

            enum class Known {
                LAST_ACTIVE_AT,
            }

            enum class Value {
                LAST_ACTIVE_AT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    LAST_ACTIVE_AT -> Value.LAST_ACTIVE_AT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    LAST_ACTIVE_AT -> Known.LAST_ACTIVE_AT
                    else -> throw OpenAIInvalidDataException("Unknown Anchor: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Anchor && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ExpiresAfter && anchor == other.anchor && days == other.days && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(anchor, days, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExpiresAfter{anchor=$anchor, days=$days, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaVectorStoreUpdateParams && vectorStoreId == other.vectorStoreId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoreId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaVectorStoreUpdateParams{vectorStoreId=$vectorStoreId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
