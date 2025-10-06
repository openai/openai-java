// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Assistant response text accompanied by optional annotations. */
class ChatKitResponseOutputText
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val annotations: JsonField<List<Annotation>>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("annotations")
        @ExcludeMissing
        annotations: JsonField<List<Annotation>> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(annotations, text, type, mutableMapOf())

    /**
     * Ordered list of annotations attached to the response text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun annotations(): List<Annotation> = annotations.getRequired("annotations")

    /**
     * Assistant generated text.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Type discriminator that is always `output_text`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("output_text")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [annotations].
     *
     * Unlike [annotations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotations")
    @ExcludeMissing
    fun _annotations(): JsonField<List<Annotation>> = annotations

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
         * Returns a mutable builder for constructing an instance of [ChatKitResponseOutputText].
         *
         * The following fields are required:
         * ```java
         * .annotations()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatKitResponseOutputText]. */
    class Builder internal constructor() {

        private var annotations: JsonField<MutableList<Annotation>>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("output_text")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatkitResponseOutputText: ChatKitResponseOutputText) = apply {
            annotations = chatkitResponseOutputText.annotations.map { it.toMutableList() }
            text = chatkitResponseOutputText.text
            type = chatkitResponseOutputText.type
            additionalProperties = chatkitResponseOutputText.additionalProperties.toMutableMap()
        }

        /** Ordered list of annotations attached to the response text. */
        fun annotations(annotations: List<Annotation>) = annotations(JsonField.of(annotations))

        /**
         * Sets [Builder.annotations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotations] with a well-typed `List<Annotation>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun annotations(annotations: JsonField<List<Annotation>>) = apply {
            this.annotations = annotations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Annotation] to [annotations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAnnotation(annotation: Annotation) = apply {
            annotations =
                (annotations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("annotations", it).add(annotation)
                }
        }

        /** Alias for calling [addAnnotation] with `Annotation.ofFile(file)`. */
        fun addAnnotation(file: Annotation.File) = addAnnotation(Annotation.ofFile(file))

        /**
         * Alias for calling [addAnnotation] with the following:
         * ```java
         * Annotation.File.builder()
         *     .source(source)
         *     .build()
         * ```
         */
        fun addFileAnnotation(source: Annotation.File.Source) =
            addAnnotation(Annotation.File.builder().source(source).build())

        /** Alias for calling [addAnnotation] with `Annotation.ofUrl(url)`. */
        fun addAnnotation(url: Annotation.Url) = addAnnotation(Annotation.ofUrl(url))

        /**
         * Alias for calling [addAnnotation] with the following:
         * ```java
         * Annotation.Url.builder()
         *     .source(source)
         *     .build()
         * ```
         */
        fun addUrlAnnotation(source: Annotation.Url.Source) =
            addAnnotation(Annotation.Url.builder().source(source).build())

        /** Assistant generated text. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("output_text")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [ChatKitResponseOutputText].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .annotations()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatKitResponseOutputText =
            ChatKitResponseOutputText(
                checkRequired("annotations", annotations).map { it.toImmutable() },
                checkRequired("text", text),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatKitResponseOutputText = apply {
        if (validated) {
            return@apply
        }

        annotations().forEach { it.validate() }
        text()
        _type().let {
            if (it != JsonValue.from("output_text")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (annotations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("output_text")) 1 else 0 }

    /** Annotation object describing a cited source. */
    @JsonDeserialize(using = Annotation.Deserializer::class)
    @JsonSerialize(using = Annotation.Serializer::class)
    class Annotation
    private constructor(
        private val file: File? = null,
        private val url: Url? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Annotation that references an uploaded file. */
        fun file(): Optional<File> = Optional.ofNullable(file)

        /** Annotation that references a URL. */
        fun url(): Optional<Url> = Optional.ofNullable(url)

        fun isFile(): Boolean = file != null

        fun isUrl(): Boolean = url != null

        /** Annotation that references an uploaded file. */
        fun asFile(): File = file.getOrThrow("file")

        /** Annotation that references a URL. */
        fun asUrl(): Url = url.getOrThrow("url")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                file != null -> visitor.visitFile(file)
                url != null -> visitor.visitUrl(url)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Annotation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFile(file: File) {
                        file.validate()
                    }

                    override fun visitUrl(url: Url) {
                        url.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitFile(file: File) = file.validity()

                    override fun visitUrl(url: Url) = url.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Annotation && file == other.file && url == other.url
        }

        override fun hashCode(): Int = Objects.hash(file, url)

        override fun toString(): String =
            when {
                file != null -> "Annotation{file=$file}"
                url != null -> "Annotation{url=$url}"
                _json != null -> "Annotation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Annotation")
            }

        companion object {

            /** Annotation that references an uploaded file. */
            @JvmStatic fun ofFile(file: File) = Annotation(file = file)

            /** Annotation that references a URL. */
            @JvmStatic fun ofUrl(url: Url) = Annotation(url = url)
        }

        /**
         * An interface that defines how to map each variant of [Annotation] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Annotation that references an uploaded file. */
            fun visitFile(file: File): T

            /** Annotation that references a URL. */
            fun visitUrl(url: Url): T

            /**
             * Maps an unknown variant of [Annotation] to a value of type [T].
             *
             * An instance of [Annotation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Annotation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Annotation>(Annotation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Annotation {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "file" -> {
                        return tryDeserialize(node, jacksonTypeRef<File>())?.let {
                            Annotation(file = it, _json = json)
                        } ?: Annotation(_json = json)
                    }
                    "url" -> {
                        return tryDeserialize(node, jacksonTypeRef<Url>())?.let {
                            Annotation(url = it, _json = json)
                        } ?: Annotation(_json = json)
                    }
                }

                return Annotation(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Annotation>(Annotation::class) {

            override fun serialize(
                value: Annotation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.file != null -> generator.writeObject(value.file)
                    value.url != null -> generator.writeObject(value.url)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Annotation")
                }
            }
        }

        /** Annotation that references an uploaded file. */
        class File
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val source: JsonField<Source>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("source")
                @ExcludeMissing
                source: JsonField<Source> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(source, type, mutableMapOf())

            /**
             * File attachment referenced by the annotation.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun source(): Source = source.getRequired("source")

            /**
             * Type discriminator that is always `file` for this annotation.
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
             * Returns the raw JSON value of [source].
             *
             * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

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
                 * .source()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [File]. */
            class Builder internal constructor() {

                private var source: JsonField<Source>? = null
                private var type: JsonValue = JsonValue.from("file")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(file: File) = apply {
                    source = file.source
                    type = file.type
                    additionalProperties = file.additionalProperties.toMutableMap()
                }

                /** File attachment referenced by the annotation. */
                fun source(source: Source) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [Source] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<Source>) = apply { this.source = source }

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
                 * Returns an immutable instance of [File].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .source()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): File =
                    File(checkRequired("source", source), type, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): File = apply {
                if (validated) {
                    return@apply
                }

                source().validate()
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
                (source.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("file")) 1 else 0 }

            /** File attachment referenced by the annotation. */
            class Source
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val filename: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("filename")
                    @ExcludeMissing
                    filename: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(filename, type, mutableMapOf())

                /**
                 * Filename referenced by the annotation.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun filename(): String = filename.getRequired("filename")

                /**
                 * Type discriminator that is always `file`.
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
                 * Returns the raw JSON value of [filename].
                 *
                 * Unlike [filename], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("filename")
                @ExcludeMissing
                fun _filename(): JsonField<String> = filename

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
                     * Returns a mutable builder for constructing an instance of [Source].
                     *
                     * The following fields are required:
                     * ```java
                     * .filename()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Source]. */
                class Builder internal constructor() {

                    private var filename: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("file")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(source: Source) = apply {
                        filename = source.filename
                        type = source.type
                        additionalProperties = source.additionalProperties.toMutableMap()
                    }

                    /** Filename referenced by the annotation. */
                    fun filename(filename: String) = filename(JsonField.of(filename))

                    /**
                     * Sets [Builder.filename] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.filename] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun filename(filename: JsonField<String>) = apply { this.filename = filename }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
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
                     * Returns an immutable instance of [Source].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .filename()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Source =
                        Source(
                            checkRequired("filename", filename),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Source = apply {
                    if (validated) {
                        return@apply
                    }

                    filename()
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
                    (if (filename.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("file")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Source &&
                        filename == other.filename &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(filename, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Source{filename=$filename, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is File &&
                    source == other.source &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(source, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "File{source=$source, type=$type, additionalProperties=$additionalProperties}"
        }

        /** Annotation that references a URL. */
        class Url
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val source: JsonField<Source>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("source")
                @ExcludeMissing
                source: JsonField<Source> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(source, type, mutableMapOf())

            /**
             * URL referenced by the annotation.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun source(): Source = source.getRequired("source")

            /**
             * Type discriminator that is always `url` for this annotation.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("url")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [source].
             *
             * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

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
                 * Returns a mutable builder for constructing an instance of [Url].
                 *
                 * The following fields are required:
                 * ```java
                 * .source()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Url]. */
            class Builder internal constructor() {

                private var source: JsonField<Source>? = null
                private var type: JsonValue = JsonValue.from("url")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(url: Url) = apply {
                    source = url.source
                    type = url.type
                    additionalProperties = url.additionalProperties.toMutableMap()
                }

                /** URL referenced by the annotation. */
                fun source(source: Source) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [Source] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<Source>) = apply { this.source = source }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("url")
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
                 * Returns an immutable instance of [Url].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .source()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Url =
                    Url(checkRequired("source", source), type, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Url = apply {
                if (validated) {
                    return@apply
                }

                source().validate()
                _type().let {
                    if (it != JsonValue.from("url")) {
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
                (source.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("url")) 1 else 0 }

            /** URL referenced by the annotation. */
            class Source
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val type: JsonValue,
                private val url: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                ) : this(type, url, mutableMapOf())

                /**
                 * Type discriminator that is always `url`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("url")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * URL referenced by the annotation.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                     * Returns a mutable builder for constructing an instance of [Source].
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Source]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("url")
                    private var url: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(source: Source) = apply {
                        type = source.type
                        url = source.url
                        additionalProperties = source.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("url")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /** URL referenced by the annotation. */
                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun url(url: JsonField<String>) = apply { this.url = url }

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
                     * Returns an immutable instance of [Source].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Source =
                        Source(type, checkRequired("url", url), additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Source = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("url")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    url()
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
                    type.let { if (it == JsonValue.from("url")) 1 else 0 } +
                        (if (url.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Source &&
                        type == other.type &&
                        url == other.url &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(type, url, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Source{type=$type, url=$url, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Url &&
                    source == other.source &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(source, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Url{source=$source, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatKitResponseOutputText &&
            annotations == other.annotations &&
            text == other.text &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(annotations, text, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatKitResponseOutputText{annotations=$annotations, text=$text, type=$type, additionalProperties=$additionalProperties}"
}
