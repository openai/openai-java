// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Modifies a vector store. */
class BetaVectorStoreUpdateParams
private constructor(
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
    fun _metadata(): JsonValue = body._metadata()

    /** The name of the vector store. */
    fun name(): Optional<String> = body.name()

    /** The expiration policy for a vector store. */
    fun _expiresAfter(): JsonField<ExpiresAfter> = body._expiresAfter()

    /** The name of the vector store. */
    fun _name(): JsonField<String> = body._name()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

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
        @JsonProperty("expires_after")
        @ExcludeMissing
        private val expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonValue = JsonMissing.of(),
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The expiration policy for a vector store. */
        fun expiresAfter(): Optional<ExpiresAfter> =
            Optional.ofNullable(expiresAfter.getNullable("expires_after"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /** The name of the vector store. */
        fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

        /** The expiration policy for a vector store. */
        @JsonProperty("expires_after")
        @ExcludeMissing
        fun _expiresAfter(): JsonField<ExpiresAfter> = expiresAfter

        /** The name of the vector store. */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaVectorStoreUpdateBody = apply {
            if (validated) {
                return@apply
            }

            expiresAfter().ifPresent { it.validate() }
            name()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BetaVectorStoreUpdateBody]. */
        class Builder internal constructor() {

            private var expiresAfter: JsonField<ExpiresAfter> = JsonMissing.of()
            private var metadata: JsonValue = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaVectorStoreUpdateBody: BetaVectorStoreUpdateBody) = apply {
                expiresAfter = betaVectorStoreUpdateBody.expiresAfter
                metadata = betaVectorStoreUpdateBody.metadata
                name = betaVectorStoreUpdateBody.name
                additionalProperties = betaVectorStoreUpdateBody.additionalProperties.toMutableMap()
            }

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: ExpiresAfter?) =
                expiresAfter(JsonField.ofNullable(expiresAfter))

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: Optional<ExpiresAfter>) =
                expiresAfter(expiresAfter.orElse(null))

            /** The expiration policy for a vector store. */
            fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
                this.expiresAfter = expiresAfter
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /** The name of the vector store. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** The name of the vector store. */
            fun name(name: Optional<String>) = name(name.orElse(null))

            /** The name of the vector store. */
            fun name(name: JsonField<String>) = apply { this.name = name }

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

    /** A builder for [BetaVectorStoreUpdateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

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
        fun expiresAfter(expiresAfter: ExpiresAfter?) = apply { body.expiresAfter(expiresAfter) }

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: Optional<ExpiresAfter>) =
            expiresAfter(expiresAfter.orElse(null))

        /** The expiration policy for a vector store. */
        fun expiresAfter(expiresAfter: JsonField<ExpiresAfter>) = apply {
            body.expiresAfter(expiresAfter)
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /** The name of the vector store. */
        fun name(name: String?) = apply { body.name(name) }

        /** The name of the vector store. */
        fun name(name: Optional<String>) = name(name.orElse(null))

        /** The name of the vector store. */
        fun name(name: JsonField<String>) = apply { body.name(name) }

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

        fun build(): BetaVectorStoreUpdateParams =
            BetaVectorStoreUpdateParams(
                checkRequired("vectorStoreId", vectorStoreId),
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
        @JsonProperty("anchor") @ExcludeMissing private val anchor: JsonValue = JsonMissing.of(),
        @JsonProperty("days") @ExcludeMissing private val days: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Anchor timestamp after which the expiration policy applies. Supported anchors:
         * `last_active_at`.
         */
        @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

        /** The number of days after the anchor time that the vector store will expire. */
        fun days(): Long = days.getRequired("days")

        /** The number of days after the anchor time that the vector store will expire. */
        @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<Long> = days

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ExpiresAfter = apply {
            if (validated) {
                return@apply
            }

            _anchor().let {
                if (it != JsonValue.from("last_active_at")) {
                    throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
                }
            }
            days()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExpiresAfter]. */
        class Builder internal constructor() {

            private var anchor: JsonValue = JsonValue.from("last_active_at")
            private var days: JsonField<Long>? = null
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
            fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: Long) = days(JsonField.of(days))

            /** The number of days after the anchor time that the vector store will expire. */
            fun days(days: JsonField<Long>) = apply { this.days = days }

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
                    anchor,
                    checkRequired("days", days),
                    additionalProperties.toImmutable(),
                )
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
