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

@NoAutoDetect
class AssistantDeleted
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("deleted")
    @ExcludeMissing
    private val deleted: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    fun deleted(): Boolean = deleted.getRequired("deleted")

    fun object_(): Object = object_.getRequired("object")

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("deleted") @ExcludeMissing fun _deleted(): JsonField<Boolean> = deleted

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): AssistantDeleted = apply {
        if (validated) {
            return@apply
        }

        id()
        deleted()
        object_()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String>? = null
        private var deleted: JsonField<Boolean>? = null
        private var object_: JsonField<Object>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(assistantDeleted: AssistantDeleted) = apply {
            id = assistantDeleted.id
            deleted = assistantDeleted.deleted
            object_ = assistantDeleted.object_
            additionalProperties = assistantDeleted.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

        fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

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

        fun build(): AssistantDeleted =
            AssistantDeleted(
                checkNotNull(id) { "`id` is required but was not set" },
                checkNotNull(deleted) { "`deleted` is required but was not set" },
                checkNotNull(object_) { "`object_` is required but was not set" },
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ASSISTANT_DELETED = of("assistant.deleted")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            ASSISTANT_DELETED,
        }

        enum class Value {
            ASSISTANT_DELETED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ASSISTANT_DELETED -> Value.ASSISTANT_DELETED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ASSISTANT_DELETED -> Known.ASSISTANT_DELETED
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantDeleted && id == other.id && deleted == other.deleted && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, deleted, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AssistantDeleted{id=$id, deleted=$deleted, object_=$object_, additionalProperties=$additionalProperties}"
}
