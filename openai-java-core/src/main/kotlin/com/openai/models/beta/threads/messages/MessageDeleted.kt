// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

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

@NoAutoDetect
class MessageDeleted
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("deleted")
    @ExcludeMissing
    private val deleted: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    fun deleted(): Boolean = deleted.getRequired("deleted")

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("deleted") @ExcludeMissing fun _deleted(): JsonField<Boolean> = deleted

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageDeleted = apply {
        if (validated) {
            return@apply
        }

        id()
        deleted()
        _object_().let {
            if (it != JsonValue.from("thread.message.deleted")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageDeleted].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deleted()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageDeleted]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var deleted: JsonField<Boolean>? = null
        private var object_: JsonValue = JsonValue.from("thread.message.deleted")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageDeleted: MessageDeleted) = apply {
            id = messageDeleted.id
            deleted = messageDeleted.deleted
            object_ = messageDeleted.object_
            additionalProperties = messageDeleted.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

        fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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

        fun build(): MessageDeleted =
            MessageDeleted(
                checkRequired("id", id),
                checkRequired("deleted", deleted),
                object_,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageDeleted && id == other.id && deleted == other.deleted && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, deleted, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageDeleted{id=$id, deleted=$deleted, object_=$object_, additionalProperties=$additionalProperties}"
}
