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
import java.util.Optional

/** Fine-tuning job event object */
@JsonDeserialize(builder = FineTuningJobEvent.Builder::class)
@NoAutoDetect
class FineTuningJobEvent
private constructor(
    private val object_: JsonField<Object>,
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val level: JsonField<Level>,
    private val message: JsonField<String>,
    private val type: JsonField<Type>,
    private val data: JsonValue,
    private val additionalProperties: Map<String, JsonValue>,
) {

    /** The object type, which is always "fine_tuning.job.event". */
    fun object_(): Object = object_.getRequired("object")

    /** The object identifier. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The log level of the event. */
    fun level(): Level = level.getRequired("level")

    /** The message of the event. */
    fun message(): String = message.getRequired("message")

    /** The type of event. */
    fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

    /** The object type, which is always "fine_tuning.job.event". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The object identifier. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The log level of the event. */
    @JsonProperty("level") @ExcludeMissing fun _level() = level

    /** The message of the event. */
    @JsonProperty("message") @ExcludeMissing fun _message() = message

    /** The type of event. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** The data associated with the event. */
    @JsonProperty("data") @ExcludeMissing fun _data() = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FineTuningJobEvent = apply {
        if (!validated) {
            object_()
            id()
            createdAt()
            level()
            message()
            type()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var object_: JsonField<Object> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var level: JsonField<Level> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var data: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fineTuningJobEvent: FineTuningJobEvent) = apply {
            object_ = fineTuningJobEvent.object_
            id = fineTuningJobEvent.id
            createdAt = fineTuningJobEvent.createdAt
            level = fineTuningJobEvent.level
            message = fineTuningJobEvent.message
            type = fineTuningJobEvent.type
            data = fineTuningJobEvent.data
            additionalProperties = fineTuningJobEvent.additionalProperties.toMutableMap()
        }

        /** The object type, which is always "fine_tuning.job.event". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "fine_tuning.job.event". */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The object identifier. */
        fun id(id: String) = id(JsonField.of(id))

        /** The object identifier. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the fine-tuning job was created. */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The log level of the event. */
        fun level(level: Level) = level(JsonField.of(level))

        /** The log level of the event. */
        @JsonProperty("level")
        @ExcludeMissing
        fun level(level: JsonField<Level>) = apply { this.level = level }

        /** The message of the event. */
        fun message(message: String) = message(JsonField.of(message))

        /** The message of the event. */
        @JsonProperty("message")
        @ExcludeMissing
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** The type of event. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of event. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The data associated with the event. */
        @JsonProperty("data") @ExcludeMissing fun data(data: JsonValue) = apply { this.data = data }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        @JsonAnySetter
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

        fun build(): FineTuningJobEvent =
            FineTuningJobEvent(
                object_,
                id,
                createdAt,
                level,
                message,
                type,
                data,
                additionalProperties.toImmutable(),
            )
    }

    class Level
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Level && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MESSAGE = of("message")

            @JvmField val METRICS = of("metrics")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            MESSAGE,
            METRICS,
        }

        enum class Value {
            MESSAGE,
            METRICS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                MESSAGE -> Value.MESSAGE
                METRICS -> Value.METRICS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                MESSAGE -> Known.MESSAGE
                METRICS -> Known.METRICS
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FineTuningJobEvent && object_ == other.object_ && id == other.id && createdAt == other.createdAt && level == other.level && message == other.message && type == other.type && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(object_, id, createdAt, level, message, type, data, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FineTuningJobEvent{object_=$object_, id=$id, createdAt=$createdAt, level=$level, message=$message, type=$type, data=$data, additionalProperties=$additionalProperties}"
}
