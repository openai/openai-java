// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
@JsonDeserialize(using = ChatCompletionContentPart.Deserializer::class)
@JsonSerialize(using = ChatCompletionContentPart.Serializer::class)
class ChatCompletionContentPart
private constructor(
    private val text: ChatCompletionContentPartText? = null,
    private val imageUrl: ChatCompletionContentPartImage? = null,
    private val inputAudio: ChatCompletionContentPartInputAudio? = null,
    private val file: File? = null,
    private val _json: JsonValue? = null,
) {

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun text(): Optional<ChatCompletionContentPartText> = Optional.ofNullable(text)

    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun imageUrl(): Optional<ChatCompletionContentPartImage> = Optional.ofNullable(imageUrl)

    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun inputAudio(): Optional<ChatCompletionContentPartInputAudio> =
        Optional.ofNullable(inputAudio)

    /**
     * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text generation.
     */
    fun file(): Optional<File> = Optional.ofNullable(file)

    fun isText(): Boolean = text != null

    fun isImageUrl(): Boolean = imageUrl != null

    fun isInputAudio(): Boolean = inputAudio != null

    fun isFile(): Boolean = file != null

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun asText(): ChatCompletionContentPartText = text.getOrThrow("text")

    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun asImageUrl(): ChatCompletionContentPartImage = imageUrl.getOrThrow("imageUrl")

    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun asInputAudio(): ChatCompletionContentPartInputAudio = inputAudio.getOrThrow("inputAudio")

    /**
     * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text generation.
     */
    fun asFile(): File = file.getOrThrow("file")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            text != null -> visitor.visitText(text)
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
            inputAudio != null -> visitor.visitInputAudio(inputAudio)
            file != null -> visitor.visitFile(file)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ChatCompletionContentPart = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: ChatCompletionContentPartText) {
                    text.validate()
                }

                override fun visitImageUrl(imageUrl: ChatCompletionContentPartImage) {
                    imageUrl.validate()
                }

                override fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio) {
                    inputAudio.validate()
                }

                override fun visitFile(file: File) {
                    file.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitText(text: ChatCompletionContentPartText) = text.validity()

                override fun visitImageUrl(imageUrl: ChatCompletionContentPartImage) =
                    imageUrl.validity()

                override fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio) =
                    inputAudio.validity()

                override fun visitFile(file: File) = file.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPart && text == other.text && imageUrl == other.imageUrl && inputAudio == other.inputAudio && file == other.file /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, imageUrl, inputAudio, file) /* spotless:on */

    override fun toString(): String =
        when {
            text != null -> "ChatCompletionContentPart{text=$text}"
            imageUrl != null -> "ChatCompletionContentPart{imageUrl=$imageUrl}"
            inputAudio != null -> "ChatCompletionContentPart{inputAudio=$inputAudio}"
            file != null -> "ChatCompletionContentPart{file=$file}"
            _json != null -> "ChatCompletionContentPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
        }

    companion object {

        /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
        @JvmStatic
        fun ofText(text: ChatCompletionContentPartText) = ChatCompletionContentPart(text = text)

        /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
        @JvmStatic
        fun ofImageUrl(imageUrl: ChatCompletionContentPartImage) =
            ChatCompletionContentPart(imageUrl = imageUrl)

        /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
        @JvmStatic
        fun ofInputAudio(inputAudio: ChatCompletionContentPartInputAudio) =
            ChatCompletionContentPart(inputAudio = inputAudio)

        /**
         * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text
         * generation.
         */
        @JvmStatic fun ofFile(file: File) = ChatCompletionContentPart(file = file)
    }

    /**
     * An interface that defines how to map each variant of [ChatCompletionContentPart] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
        fun visitText(text: ChatCompletionContentPartText): T

        /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
        fun visitImageUrl(imageUrl: ChatCompletionContentPartImage): T

        /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
        fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio): T

        /**
         * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text
         * generation.
         */
        fun visitFile(file: File): T

        /**
         * Maps an unknown variant of [ChatCompletionContentPart] to a value of type [T].
         *
         * An instance of [ChatCompletionContentPart] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionContentPart {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "text" -> {
                    return tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartText>())
                        ?.let { ChatCompletionContentPart(text = it, _json = json) }
                        ?: ChatCompletionContentPart(_json = json)
                }
                "image_url" -> {
                    return tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartImage>())
                        ?.let { ChatCompletionContentPart(imageUrl = it, _json = json) }
                        ?: ChatCompletionContentPart(_json = json)
                }
                "input_audio" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ChatCompletionContentPartInputAudio>(),
                        )
                        ?.let { ChatCompletionContentPart(inputAudio = it, _json = json) }
                        ?: ChatCompletionContentPart(_json = json)
                }
                "file" -> {
                    return tryDeserialize(node, jacksonTypeRef<File>())?.let {
                        ChatCompletionContentPart(file = it, _json = json)
                    } ?: ChatCompletionContentPart(_json = json)
                }
            }

            return ChatCompletionContentPart(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun serialize(
            value: ChatCompletionContentPart,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value.inputAudio != null -> generator.writeObject(value.inputAudio)
                value.file != null -> generator.writeObject(value.file)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
            }
        }
    }

    /**
     * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text generation.
     */
    class File
    private constructor(
        private val file: JsonField<FileObject>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("file") @ExcludeMissing file: JsonField<FileObject> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(file, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): FileObject = file.getRequired("file")

        /**
         * The type of the content part. Always `file`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("file")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [file].
         *
         * Unlike [file], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): JsonField<FileObject> = file

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [File].
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [File]. */
        class Builder internal constructor() {

            private var file: JsonField<FileObject>? = null
            private var type: JsonValue = JsonValue.from("file")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(file: File) = apply {
                this.file = file.file
                type = file.type
                additionalProperties = file.additionalProperties.toMutableMap()
            }

            fun file(file: FileObject) = file(JsonField.of(file))

            /**
             * Sets [Builder.file] to an arbitrary JSON value.
             *
             * You should usually call [Builder.file] with a well-typed [FileObject] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: JsonField<FileObject>) = apply { this.file = file }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("file")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [File].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): File =
                File(checkRequired("file", file), type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): File = apply {
            if (validated) {
                return@apply
            }

            file().validate()
            _type().let {
                if (it != JsonValue.from("file")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (file.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("file")) 1 else 0 }

        class FileObject
        private constructor(
            private val fileData: JsonField<String>,
            private val fileId: JsonField<String>,
            private val filename: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_data")
                @ExcludeMissing
                fileData: JsonField<String> = JsonMissing.of(),
                @JsonProperty("file_id")
                @ExcludeMissing
                fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("filename")
                @ExcludeMissing
                filename: JsonField<String> = JsonMissing.of(),
            ) : this(fileData, fileId, filename, mutableMapOf())

            /**
             * The base64 encoded file data, used when passing the file to the model as a string.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileData(): Optional<String> = fileData.getOptional("file_data")

            /**
             * The ID of an uploaded file to use as input.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileId(): Optional<String> = fileId.getOptional("file_id")

            /**
             * The name of the file, used when passing the file to the model as a string.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun filename(): Optional<String> = filename.getOptional("filename")

            /**
             * Returns the raw JSON value of [fileData].
             *
             * Unlike [fileData], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("file_data") @ExcludeMissing fun _fileData(): JsonField<String> = fileData

            /**
             * Returns the raw JSON value of [fileId].
             *
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /**
             * Returns the raw JSON value of [filename].
             *
             * Unlike [filename], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [FileObject]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileObject]. */
            class Builder internal constructor() {

                private var fileData: JsonField<String> = JsonMissing.of()
                private var fileId: JsonField<String> = JsonMissing.of()
                private var filename: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileObject: FileObject) = apply {
                    fileData = fileObject.fileData
                    fileId = fileObject.fileId
                    filename = fileObject.filename
                    additionalProperties = fileObject.additionalProperties.toMutableMap()
                }

                /**
                 * The base64 encoded file data, used when passing the file to the model as a
                 * string.
                 */
                fun fileData(fileData: String) = fileData(JsonField.of(fileData))

                /**
                 * Sets [Builder.fileData] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileData] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileData(fileData: JsonField<String>) = apply { this.fileData = fileData }

                /** The ID of an uploaded file to use as input. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /**
                 * Sets [Builder.fileId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The name of the file, used when passing the file to the model as a string. */
                fun filename(filename: String) = filename(JsonField.of(filename))

                /**
                 * Sets [Builder.filename] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.filename] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun filename(filename: JsonField<String>) = apply { this.filename = filename }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [FileObject].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): FileObject =
                    FileObject(fileData, fileId, filename, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): FileObject = apply {
                if (validated) {
                    return@apply
                }

                fileData()
                fileId()
                filename()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (fileData.asKnown().isPresent) 1 else 0) +
                    (if (fileId.asKnown().isPresent) 1 else 0) +
                    (if (filename.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileObject && fileData == other.fileData && fileId == other.fileId && filename == other.filename && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileData, fileId, filename, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileObject{fileData=$fileData, fileId=$fileId, filename=$filename, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is File && file == other.file && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "File{file=$file, type=$type, additionalProperties=$additionalProperties}"
    }
}
