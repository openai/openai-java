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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Occurs when a new [thread](https://platform.openai.com/docs/api-reference/threads/object) is
 * created.
 */
@NoAutoDetect
class ThreadStreamEvent
@JsonCreator
private constructor(
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Thread> = JsonMissing.of(),
    @JsonProperty("event") @ExcludeMissing private val event: JsonValue = JsonMissing.of(),
    @JsonProperty("enabled")
    @ExcludeMissing
    private val enabled: JsonField<Boolean> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Represents a thread that contains
     * [messages](https://platform.openai.com/docs/api-reference/messages).
     */
    fun data(): Thread = data.getRequired("data")

    @JsonProperty("event") @ExcludeMissing fun _event(): JsonValue = event

    /** Whether to enable input audio transcription. */
    fun enabled(): Optional<Boolean> = Optional.ofNullable(enabled.getNullable("enabled"))

    /**
     * Represents a thread that contains
     * [messages](https://platform.openai.com/docs/api-reference/messages).
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Thread> = data

    /** Whether to enable input audio transcription. */
    @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ThreadStreamEvent = apply {
        if (validated) {
            return@apply
        }

        data().validate()
        _event().let {
            if (it != JsonValue.from("thread.created")) {
                throw OpenAIInvalidDataException("'event' is invalid, received $it")
            }
        }
        enabled()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ThreadStreamEvent]. */
    class Builder internal constructor() {

        private var data: JsonField<Thread>? = null
        private var event: JsonValue = JsonValue.from("thread.created")
        private var enabled: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(threadStreamEvent: ThreadStreamEvent) = apply {
            data = threadStreamEvent.data
            event = threadStreamEvent.event
            enabled = threadStreamEvent.enabled
            additionalProperties = threadStreamEvent.additionalProperties.toMutableMap()
        }

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         */
        fun data(data: Thread) = data(JsonField.of(data))

        /**
         * Represents a thread that contains
         * [messages](https://platform.openai.com/docs/api-reference/messages).
         */
        fun data(data: JsonField<Thread>) = apply { this.data = data }

        fun event(event: JsonValue) = apply { this.event = event }

        /** Whether to enable input audio transcription. */
        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /** Whether to enable input audio transcription. */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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

        fun build(): ThreadStreamEvent =
            ThreadStreamEvent(
                checkRequired("data", data),
                event,
                enabled,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ThreadStreamEvent && data == other.data && event == other.event && enabled == other.enabled && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, event, enabled, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ThreadStreamEvent{data=$data, event=$event, enabled=$enabled, additionalProperties=$additionalProperties}"
}
