// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Fine-tuning job event object */
@JsonDeserialize(builder = FineTuningJobEvent.Builder::class)
@NoAutoDetect
class FineTuningJobEvent
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val level: JsonField<Level>,
    private val message: JsonField<String>,
    private val object_: JsonField<Object>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun id(): String = id.getRequired("id")

    fun createdAt(): Long = createdAt.getRequired("created_at")

    fun level(): Level = level.getRequired("level")

    fun message(): String = message.getRequired("message")

    fun object_(): Object = object_.getRequired("object")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    @JsonProperty("level") @ExcludeMissing fun _level() = level

    @JsonProperty("message") @ExcludeMissing fun _message() = message

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): FineTuningJobEvent = apply {
        if (!validated) {
            id()
            createdAt()
            level()
            message()
            object_()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var level: JsonField<Level> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJobEvent: FineTuningJobEvent) = apply {
            this.id = fineTuningJobEvent.id
            this.createdAt = fineTuningJobEvent.createdAt
            this.level = fineTuningJobEvent.level
            this.message = fineTuningJobEvent.message
            this.object_ = fineTuningJobEvent.object_
            additionalProperties(fineTuningJobEvent.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun level(level: Level) = level(JsonField.of(level))

        @JsonProperty("level")
        @ExcludeMissing
        fun level(level: JsonField<Level>) = apply { this.level = level }

        fun message(message: String) = message(JsonField.of(message))

        @JsonProperty("message")
        @ExcludeMissing
        fun message(message: JsonField<String>) = apply { this.message = message }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): FineTuningJobEvent =
            FineTuningJobEvent(
                id,
                createdAt,
                level,
                message,
                object_,
                additionalProperties.toImmutable(),
            )
    }

    class Level
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Level && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val INFO = of("info")

            @JvmField val WARN = of("warn")

            @JvmField val ERROR = of("error")

            @JvmStatic fun of(value: String) = Level(JsonField.of(value))
        }

        enum class Known {
            INFO,
            WARN,
            ERROR,
        }

        enum class Value {
            INFO,
            WARN,
            ERROR,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                INFO -> Value.INFO
                WARN -> Value.WARN
                ERROR -> Value.ERROR
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                INFO -> Known.INFO
                WARN -> Known.WARN
                ERROR -> Known.ERROR
                else -> throw OpenAIInvalidDataException("Unknown Level: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val FINE_TUNING_JOB_EVENT = of("fine_tuning.job.event")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            FINE_TUNING_JOB_EVENT,
        }

        enum class Value {
            FINE_TUNING_JOB_EVENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FINE_TUNING_JOB_EVENT -> Value.FINE_TUNING_JOB_EVENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FINE_TUNING_JOB_EVENT -> Known.FINE_TUNING_JOB_EVENT
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobEvent && id == other.id && createdAt == other.createdAt && level == other.level && message == other.message && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, level, message, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobEvent{id=$id, createdAt=$createdAt, level=$level, message=$message, object_=$object_, additionalProperties=$additionalProperties}"
}
