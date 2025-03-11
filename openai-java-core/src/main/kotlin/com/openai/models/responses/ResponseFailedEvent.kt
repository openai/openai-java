// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** An event that is emitted when a response fails. */
@NoAutoDetect
class ResponseFailedEvent
@JsonCreator
private constructor(
    @JsonProperty("response")
    @ExcludeMissing
    private val response: JsonField<Response> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The response that failed. */
    fun response(): Response = response.getRequired("response")

    /** The type of the event. Always `response.failed`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The response that failed. */
    @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseFailedEvent = apply {
        if (validated) {
            return@apply
        }

        response().validate()
        _type().let {
            if (it != JsonValue.from("response.failed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseFailedEvent].
         *
         * The following fields are required:
         * ```java
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFailedEvent]. */
    class Builder internal constructor() {

        private var response: JsonField<Response>? = null
        private var type: JsonValue = JsonValue.from("response.failed")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFailedEvent: ResponseFailedEvent) = apply {
            response = responseFailedEvent.response
            type = responseFailedEvent.type
            additionalProperties = responseFailedEvent.additionalProperties.toMutableMap()
        }

        /** The response that failed. */
        fun response(response: Response) = response(JsonField.of(response))

        /** The response that failed. */
        fun response(response: JsonField<Response>) = apply { this.response = response }

        /** The type of the event. Always `response.failed`. */
        fun type(type: JsonValue) = apply { this.type = type }

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

        fun build(): ResponseFailedEvent =
            ResponseFailedEvent(
                checkRequired("response", response),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseFailedEvent && response == other.response && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(response, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFailedEvent{response=$response, type=$type, additionalProperties=$additionalProperties}"
}
