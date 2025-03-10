// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

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

@NoAutoDetect
class CodeInterpreterOutputImage
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonProperty("image") @ExcludeMissing private val image: JsonField<Image> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the output in the outputs array. */
    fun index(): Long = index.getRequired("index")

    /** Always `image`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    fun image(): Optional<Image> = Optional.ofNullable(image.getNullable("image"))

    /** The index of the output in the outputs array. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    @JsonProperty("image") @ExcludeMissing fun _image(): JsonField<Image> = image

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CodeInterpreterOutputImage = apply {
        if (validated) {
            return@apply
        }

        index()
        _type().let {
            if (it != JsonValue.from("image")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        image().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CodeInterpreterOutputImage].
         *
         * The following fields are required:
         * ```java
         * .index()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CodeInterpreterOutputImage]. */
    class Builder internal constructor() {

        private var index: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("image")
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
        fun type(type: JsonValue) = apply { this.type = type }

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
                checkRequired("index", index),
                type,
                image,
                additionalProperties.toImmutable(),
            )
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
            if (validated) {
                return@apply
            }

            fileId()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Image]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Image]. */
        class Builder internal constructor() {

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
