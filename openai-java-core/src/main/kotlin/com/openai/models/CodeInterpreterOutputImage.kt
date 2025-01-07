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

@NoAutoDetect
class CodeInterpreterOutputImage
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("image") @ExcludeMissing private val image: JsonField<Image> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the output in the outputs array. */
    fun index(): Long = index.getRequired("index")

    /** Always `image`. */
    fun type(): Type = type.getRequired("type")

    fun image(): Optional<Image> = Optional.ofNullable(image.getNullable("image"))

    /** The index of the output in the outputs array. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** Always `image`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonProperty("image") @ExcludeMissing fun _image(): JsonField<Image> = image

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CodeInterpreterOutputImage = apply {
        if (!validated) {
            index()
            type()
            image().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
        private var image: JsonField<Image> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(codeInterpreterOutputImage: CodeInterpreterOutputImage) = apply {
            index = codeInterpreterOutputImage.index
            type = codeInterpreterOutputImage.type
            image = codeInterpreterOutputImage.image
            additionalProperties = codeInterpreterOutputImage.additionalProperties.toMutableMap()
        }

        /** The index of the output in the outputs array. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the output in the outputs array. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** Always `image`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `image`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun image(image: Image) = image(JsonField.of(image))

        fun image(image: JsonField<Image>) = apply { this.image = image }

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

        fun build(): CodeInterpreterOutputImage =
            CodeInterpreterOutputImage(
                checkNotNull(index) { "`index` is required but was not set" },
                checkNotNull(type) { "`type` is required but was not set" },
                image,
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IMAGE = of("image")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            IMAGE,
        }

        enum class Value {
            IMAGE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IMAGE -> Value.IMAGE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IMAGE -> Known.IMAGE
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

    @NoAutoDetect
    class Image
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The [file](https://platform.openai.com/docs/api-reference/files) ID of the image. */
        fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

        /** The [file](https://platform.openai.com/docs/api-reference/files) ID of the image. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Image = apply {
            if (!validated) {
                fileId()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(image: Image) = apply {
                fileId = image.fileId
                additionalProperties = image.additionalProperties.toMutableMap()
            }

            /** The [file](https://platform.openai.com/docs/api-reference/files) ID of the image. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The [file](https://platform.openai.com/docs/api-reference/files) ID of the image. */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

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

            fun build(): Image = Image(fileId, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Image && fileId == other.fileId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Image{fileId=$fileId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CodeInterpreterOutputImage && index == other.index && type == other.type && image == other.image && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, image, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CodeInterpreterOutputImage{index=$index, type=$type, image=$image, additionalProperties=$additionalProperties}"
}
