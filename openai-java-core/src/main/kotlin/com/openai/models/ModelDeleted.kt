// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import java.util.Objects

@JsonDeserialize(builder = ModelDeleted.Builder::class)
@NoAutoDetect
class ModelDeleted
private constructor(
    private val id: JsonField<String>,
    private val deleted: JsonField<Boolean>,
    private val object_: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    fun id(): String = id.getRequired("id")

    fun deleted(): Boolean = deleted.getRequired("deleted")

    fun object_(): String = object_.getRequired("object")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("deleted") @ExcludeMissing fun _deleted() = deleted

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ModelDeleted = apply {
        if (!validated) {
            id()
            deleted()
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
        private var deleted: JsonField<Boolean> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(modelDeleted: ModelDeleted) = apply {
            id = modelDeleted.id
            deleted = modelDeleted.deleted
            object_ = modelDeleted.object_
            additionalProperties = modelDeleted.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun deleted(deleted: Boolean) = deleted(JsonField.of(deleted))

        @JsonProperty("deleted")
        @ExcludeMissing
        fun deleted(deleted: JsonField<Boolean>) = apply { this.deleted = deleted }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

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

        fun build(): ModelDeleted =
            ModelDeleted(
                id,
                deleted,
                object_,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelDeleted && id == other.id && deleted == other.deleted && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, deleted, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ModelDeleted{id=$id, deleted=$deleted, object_=$object_, additionalProperties=$additionalProperties}"
}
