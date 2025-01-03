// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
    @JsonProperty("enabled")
    @ExcludeMissing
    private val enabled: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("event") @ExcludeMissing private val event: JsonField<Event> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Thread> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Whether to enable input audio transcription. */
    fun enabled(): Optional<Boolean> = Optional.ofNullable(enabled.getNullable("enabled"))

    fun event(): Event = event.getRequired("event")

    /**
     * Represents a thread that contains
     * [messages](https://platform.openai.com/docs/api-reference/messages).
     */
    fun data(): Thread = data.getRequired("data")

    /** Whether to enable input audio transcription. */
    @JsonProperty("enabled") @ExcludeMissing fun _enabled() = enabled

    @JsonProperty("event") @ExcludeMissing fun _event() = event

    /**
     * Represents a thread that contains
     * [messages](https://platform.openai.com/docs/api-reference/messages).
     */
    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ThreadStreamEvent = apply {
        if (!validated) {
            enabled()
            event()
            data().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var enabled: JsonField<Boolean> = JsonMissing.of()
        private var event: JsonField<Event> = JsonMissing.of()
        private var data: JsonField<Thread> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(threadStreamEvent: ThreadStreamEvent) = apply {
            enabled = threadStreamEvent.enabled
            event = threadStreamEvent.event
            data = threadStreamEvent.data
            additionalProperties = threadStreamEvent.additionalProperties.toMutableMap()
        }

        /** Whether to enable input audio transcription. */
        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /** Whether to enable input audio transcription. */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

        fun event(event: Event) = event(JsonField.of(event))

        fun event(event: JsonField<Event>) = apply { this.event = event }

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
                enabled,
                event,
                data,
                additionalProperties.toImmutable(),
            )
    }

    class Event
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val THREAD_CREATED = of("thread.created")

            @JvmStatic fun of(value: String) = Event(JsonField.of(value))
        }

        enum class Known {
            THREAD_CREATED,
        }

        enum class Value {
            THREAD_CREATED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                THREAD_CREATED -> Value.THREAD_CREATED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                THREAD_CREATED -> Known.THREAD_CREATED
                else -> throw OpenAIInvalidDataException("Unknown Event: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Event && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ThreadStreamEvent && enabled == other.enabled && event == other.event && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(enabled, event, data, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ThreadStreamEvent{enabled=$enabled, event=$event, data=$data, additionalProperties=$additionalProperties}"
}
