// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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

/** Emitted when a text annotation is added. */
class ResponseTextAnnotationDeltaEvent
private constructor(
    private val annotation: JsonField<Annotation>,
    private val annotationIndex: JsonField<Long>,
    private val contentIndex: JsonField<Long>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("annotation")
        @ExcludeMissing
        annotation: JsonField<Annotation> = JsonMissing.of(),
        @JsonProperty("annotation_index")
        @ExcludeMissing
        annotationIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(annotation, annotationIndex, contentIndex, itemId, outputIndex, type, mutableMapOf())

    /**
     * A citation to a file.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun annotation(): Annotation = annotation.getRequired("annotation")

    /**
     * The index of the annotation that was added.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun annotationIndex(): Long = annotationIndex.getRequired("annotation_index")

    /**
     * The index of the content part that the text annotation was added to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /**
     * The ID of the output item that the text annotation was added to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item that the text annotation was added to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The type of the event. Always `response.output_text.annotation.added`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.output_text.annotation.added")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [annotation].
     *
     * Unlike [annotation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotation")
    @ExcludeMissing
    fun _annotation(): JsonField<Annotation> = annotation

    /**
     * Returns the raw JSON value of [annotationIndex].
     *
     * Unlike [annotationIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotation_index")
    @ExcludeMissing
    fun _annotationIndex(): JsonField<Long> = annotationIndex

    /**
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /**
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

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
         * Returns a mutable builder for constructing an instance of
         * [ResponseTextAnnotationDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .annotation()
         * .annotationIndex()
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseTextAnnotationDeltaEvent]. */
    class Builder internal constructor() {

        private var annotation: JsonField<Annotation>? = null
        private var annotationIndex: JsonField<Long>? = null
        private var contentIndex: JsonField<Long>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.output_text.annotation.added")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseTextAnnotationDeltaEvent: ResponseTextAnnotationDeltaEvent) =
            apply {
                annotation = responseTextAnnotationDeltaEvent.annotation
                annotationIndex = responseTextAnnotationDeltaEvent.annotationIndex
                contentIndex = responseTextAnnotationDeltaEvent.contentIndex
                itemId = responseTextAnnotationDeltaEvent.itemId
                outputIndex = responseTextAnnotationDeltaEvent.outputIndex
                type = responseTextAnnotationDeltaEvent.type
                additionalProperties =
                    responseTextAnnotationDeltaEvent.additionalProperties.toMutableMap()
            }

        /** A citation to a file. */
        fun annotation(annotation: Annotation) = annotation(JsonField.of(annotation))

        /**
         * Sets [Builder.annotation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotation] with a well-typed [Annotation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun annotation(annotation: JsonField<Annotation>) = apply { this.annotation = annotation }

        /** Alias for calling [annotation] with `Annotation.ofFileCitation(fileCitation)`. */
        fun annotation(fileCitation: Annotation.FileCitation) =
            annotation(Annotation.ofFileCitation(fileCitation))

        /** Alias for calling [annotation] with `Annotation.ofUrlCitation(urlCitation)`. */
        fun annotation(urlCitation: Annotation.UrlCitation) =
            annotation(Annotation.ofUrlCitation(urlCitation))

        /** Alias for calling [annotation] with `Annotation.ofFilePath(filePath)`. */
        fun annotation(filePath: Annotation.FilePath) = annotation(Annotation.ofFilePath(filePath))

        /** The index of the annotation that was added. */
        fun annotationIndex(annotationIndex: Long) = annotationIndex(JsonField.of(annotationIndex))

        /**
         * Sets [Builder.annotationIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotationIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun annotationIndex(annotationIndex: JsonField<Long>) = apply {
            this.annotationIndex = annotationIndex
        }

        /** The index of the content part that the text annotation was added to. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The ID of the output item that the text annotation was added to. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the text annotation was added to. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.output_text.annotation.added")
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
         * Returns an immutable instance of [ResponseTextAnnotationDeltaEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .annotation()
         * .annotationIndex()
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseTextAnnotationDeltaEvent =
            ResponseTextAnnotationDeltaEvent(
                checkRequired("annotation", annotation),
                checkRequired("annotationIndex", annotationIndex),
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseTextAnnotationDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        annotation().validate()
        annotationIndex()
        contentIndex()
        itemId()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.output_text.annotation.added")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    /** A citation to a file. */
    @JsonDeserialize(using = Annotation.Deserializer::class)
    @JsonSerialize(using = Annotation.Serializer::class)
    class Annotation
    private constructor(
        private val fileCitation: FileCitation? = null,
        private val urlCitation: UrlCitation? = null,
        private val filePath: FilePath? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A citation to a file. */
        fun fileCitation(): Optional<FileCitation> = Optional.ofNullable(fileCitation)

        /** A citation for a web resource used to generate a model response. */
        fun urlCitation(): Optional<UrlCitation> = Optional.ofNullable(urlCitation)

        /** A path to a file. */
        fun filePath(): Optional<FilePath> = Optional.ofNullable(filePath)

        fun isFileCitation(): Boolean = fileCitation != null

        fun isUrlCitation(): Boolean = urlCitation != null

        fun isFilePath(): Boolean = filePath != null

        /** A citation to a file. */
        fun asFileCitation(): FileCitation = fileCitation.getOrThrow("fileCitation")

        /** A citation for a web resource used to generate a model response. */
        fun asUrlCitation(): UrlCitation = urlCitation.getOrThrow("urlCitation")

        /** A path to a file. */
        fun asFilePath(): FilePath = filePath.getOrThrow("filePath")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                fileCitation != null -> visitor.visitFileCitation(fileCitation)
                urlCitation != null -> visitor.visitUrlCitation(urlCitation)
                filePath != null -> visitor.visitFilePath(filePath)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Annotation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFileCitation(fileCitation: FileCitation) {
                        fileCitation.validate()
                    }

                    override fun visitUrlCitation(urlCitation: UrlCitation) {
                        urlCitation.validate()
                    }

                    override fun visitFilePath(filePath: FilePath) {
                        filePath.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Annotation && fileCitation == other.fileCitation && urlCitation == other.urlCitation && filePath == other.filePath /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileCitation, urlCitation, filePath) /* spotless:on */

        override fun toString(): String =
            when {
                fileCitation != null -> "Annotation{fileCitation=$fileCitation}"
                urlCitation != null -> "Annotation{urlCitation=$urlCitation}"
                filePath != null -> "Annotation{filePath=$filePath}"
                _json != null -> "Annotation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Annotation")
            }

        companion object {

            /** A citation to a file. */
            @JvmStatic
            fun ofFileCitation(fileCitation: FileCitation) = Annotation(fileCitation = fileCitation)

            /** A citation for a web resource used to generate a model response. */
            @JvmStatic
            fun ofUrlCitation(urlCitation: UrlCitation) = Annotation(urlCitation = urlCitation)

            /** A path to a file. */
            @JvmStatic fun ofFilePath(filePath: FilePath) = Annotation(filePath = filePath)
        }

        /**
         * An interface that defines how to map each variant of [Annotation] to a value of type [T].
         */
        interface Visitor<out T> {

            /** A citation to a file. */
            fun visitFileCitation(fileCitation: FileCitation): T

            /** A citation for a web resource used to generate a model response. */
            fun visitUrlCitation(urlCitation: UrlCitation): T

            /** A path to a file. */
            fun visitFilePath(filePath: FilePath): T

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
                    "file_citation" -> {
                        return Annotation(
                            fileCitation = deserialize(node, jacksonTypeRef<FileCitation>()),
                            _json = json,
                        )
                    }
                    "url_citation" -> {
                        return Annotation(
                            urlCitation = deserialize(node, jacksonTypeRef<UrlCitation>()),
                            _json = json,
                        )
                    }
                    "file_path" -> {
                        return Annotation(
                            filePath = deserialize(node, jacksonTypeRef<FilePath>()),
                            _json = json,
                        )
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
                    value.fileCitation != null -> generator.writeObject(value.fileCitation)
                    value.urlCitation != null -> generator.writeObject(value.urlCitation)
                    value.filePath != null -> generator.writeObject(value.filePath)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Annotation")
                }
            }
        }

        /** A citation to a file. */
        class FileCitation
        private constructor(
            private val fileId: JsonField<String>,
            private val index: JsonField<Long>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(fileId, index, type, mutableMapOf())

            /**
             * The ID of the file.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fileId(): String = fileId.getRequired("file_id")

            /**
             * The index of the file in the list of files.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun index(): Long = index.getRequired("index")

            /**
             * The type of the file citation. Always `file_citation`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("file_citation")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [fileId].
             *
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /**
             * Returns the raw JSON value of [index].
             *
             * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

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
                 * Returns a mutable builder for constructing an instance of [FileCitation].
                 *
                 * The following fields are required:
                 * ```java
                 * .fileId()
                 * .index()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileCitation]. */
            class Builder internal constructor() {

                private var fileId: JsonField<String>? = null
                private var index: JsonField<Long>? = null
                private var type: JsonValue = JsonValue.from("file_citation")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileCitation: FileCitation) = apply {
                    fileId = fileCitation.fileId
                    index = fileCitation.index
                    type = fileCitation.type
                    additionalProperties = fileCitation.additionalProperties.toMutableMap()
                }

                /** The ID of the file. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /**
                 * Sets [Builder.fileId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The index of the file in the list of files. */
                fun index(index: Long) = index(JsonField.of(index))

                /**
                 * Sets [Builder.index] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.index] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun index(index: JsonField<Long>) = apply { this.index = index }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("file_citation")
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
                 * Returns an immutable instance of [FileCitation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .fileId()
                 * .index()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FileCitation =
                    FileCitation(
                        checkRequired("fileId", fileId),
                        checkRequired("index", index),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileCitation = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                index()
                _type().let {
                    if (it != JsonValue.from("file_citation")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileCitation && fileId == other.fileId && index == other.index && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileId, index, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileCitation{fileId=$fileId, index=$index, type=$type, additionalProperties=$additionalProperties}"
        }

        /** A citation for a web resource used to generate a model response. */
        class UrlCitation
        private constructor(
            private val endIndex: JsonField<Long>,
            private val startIndex: JsonField<Long>,
            private val title: JsonField<String>,
            private val type: JsonValue,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("end_index")
                @ExcludeMissing
                endIndex: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("start_index")
                @ExcludeMissing
                startIndex: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(endIndex, startIndex, title, type, url, mutableMapOf())

            /**
             * The index of the last character of the URL citation in the message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun endIndex(): Long = endIndex.getRequired("end_index")

            /**
             * The index of the first character of the URL citation in the message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun startIndex(): Long = startIndex.getRequired("start_index")

            /**
             * The title of the web resource.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun title(): String = title.getRequired("title")

            /**
             * The type of the URL citation. Always `url_citation`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("url_citation")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The URL of the web resource.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun url(): String = url.getRequired("url")

            /**
             * Returns the raw JSON value of [endIndex].
             *
             * Unlike [endIndex], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

            /**
             * Returns the raw JSON value of [startIndex].
             *
             * Unlike [startIndex], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("start_index")
            @ExcludeMissing
            fun _startIndex(): JsonField<Long> = startIndex

            /**
             * Returns the raw JSON value of [title].
             *
             * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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
                 * Returns a mutable builder for constructing an instance of [UrlCitation].
                 *
                 * The following fields are required:
                 * ```java
                 * .endIndex()
                 * .startIndex()
                 * .title()
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UrlCitation]. */
            class Builder internal constructor() {

                private var endIndex: JsonField<Long>? = null
                private var startIndex: JsonField<Long>? = null
                private var title: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("url_citation")
                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(urlCitation: UrlCitation) = apply {
                    endIndex = urlCitation.endIndex
                    startIndex = urlCitation.startIndex
                    title = urlCitation.title
                    type = urlCitation.type
                    url = urlCitation.url
                    additionalProperties = urlCitation.additionalProperties.toMutableMap()
                }

                /** The index of the last character of the URL citation in the message. */
                fun endIndex(endIndex: Long) = endIndex(JsonField.of(endIndex))

                /**
                 * Sets [Builder.endIndex] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.endIndex] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

                /** The index of the first character of the URL citation in the message. */
                fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

                /**
                 * Sets [Builder.startIndex] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.startIndex] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

                /** The title of the web resource. */
                fun title(title: String) = title(JsonField.of(title))

                /**
                 * Sets [Builder.title] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.title] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun title(title: JsonField<String>) = apply { this.title = title }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("url_citation")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The URL of the web resource. */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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
                 * Returns an immutable instance of [UrlCitation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .endIndex()
                 * .startIndex()
                 * .title()
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UrlCitation =
                    UrlCitation(
                        checkRequired("endIndex", endIndex),
                        checkRequired("startIndex", startIndex),
                        checkRequired("title", title),
                        type,
                        checkRequired("url", url),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): UrlCitation = apply {
                if (validated) {
                    return@apply
                }

                endIndex()
                startIndex()
                title()
                _type().let {
                    if (it != JsonValue.from("url_citation")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                url()
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is UrlCitation && endIndex == other.endIndex && startIndex == other.startIndex && title == other.title && type == other.type && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(endIndex, startIndex, title, type, url, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UrlCitation{endIndex=$endIndex, startIndex=$startIndex, title=$title, type=$type, url=$url, additionalProperties=$additionalProperties}"
        }

        /** A path to a file. */
        class FilePath
        private constructor(
            private val fileId: JsonField<String>,
            private val index: JsonField<Long>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(fileId, index, type, mutableMapOf())

            /**
             * The ID of the file.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fileId(): String = fileId.getRequired("file_id")

            /**
             * The index of the file in the list of files.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun index(): Long = index.getRequired("index")

            /**
             * The type of the file path. Always `file_path`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("file_path")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [fileId].
             *
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /**
             * Returns the raw JSON value of [index].
             *
             * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

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
                 * Returns a mutable builder for constructing an instance of [FilePath].
                 *
                 * The following fields are required:
                 * ```java
                 * .fileId()
                 * .index()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FilePath]. */
            class Builder internal constructor() {

                private var fileId: JsonField<String>? = null
                private var index: JsonField<Long>? = null
                private var type: JsonValue = JsonValue.from("file_path")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(filePath: FilePath) = apply {
                    fileId = filePath.fileId
                    index = filePath.index
                    type = filePath.type
                    additionalProperties = filePath.additionalProperties.toMutableMap()
                }

                /** The ID of the file. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /**
                 * Sets [Builder.fileId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The index of the file in the list of files. */
                fun index(index: Long) = index(JsonField.of(index))

                /**
                 * Sets [Builder.index] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.index] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun index(index: JsonField<Long>) = apply { this.index = index }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("file_path")
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
                 * Returns an immutable instance of [FilePath].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .fileId()
                 * .index()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FilePath =
                    FilePath(
                        checkRequired("fileId", fileId),
                        checkRequired("index", index),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FilePath = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                index()
                _type().let {
                    if (it != JsonValue.from("file_path")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FilePath && fileId == other.fileId && index == other.index && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileId, index, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FilePath{fileId=$fileId, index=$index, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseTextAnnotationDeltaEvent && annotation == other.annotation && annotationIndex == other.annotationIndex && contentIndex == other.contentIndex && itemId == other.itemId && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(annotation, annotationIndex, contentIndex, itemId, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseTextAnnotationDeltaEvent{annotation=$annotation, annotationIndex=$annotationIndex, contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
