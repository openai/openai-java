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
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when a text annotation is added. */
@NoAutoDetect
class ResponseTextAnnotationDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("annotation")
    @ExcludeMissing
    private val annotation: JsonField<Annotation> = JsonMissing.of(),
    @JsonProperty("annotation_index")
    @ExcludeMissing
    private val annotationIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("content_index")
    @ExcludeMissing
    private val contentIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("item_id")
    @ExcludeMissing
    private val itemId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** A citation to a file. */
    fun annotation(): Annotation = annotation.getRequired("annotation")

    /** The index of the annotation that was added. */
    fun annotationIndex(): Long = annotationIndex.getRequired("annotation_index")

    /** The index of the content part that the text annotation was added to. */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /** The ID of the output item that the text annotation was added to. */
    fun itemId(): String = itemId.getRequired("item_id")

    /** The index of the output item that the text annotation was added to. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.output_text.annotation.added`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** A citation to a file. */
    @JsonProperty("annotation")
    @ExcludeMissing
    fun _annotation(): JsonField<Annotation> = annotation

    /** The index of the annotation that was added. */
    @JsonProperty("annotation_index")
    @ExcludeMissing
    fun _annotationIndex(): JsonField<Long> = annotationIndex

    /** The index of the content part that the text annotation was added to. */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /** The ID of the output item that the text annotation was added to. */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /** The index of the output item that the text annotation was added to. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /** A citation to a file. */
        fun annotation(annotation: JsonField<Annotation>) = apply { this.annotation = annotation }

        /** A citation to a file. */
        fun annotation(fileCitation: Annotation.FileCitation) =
            annotation(Annotation.ofFileCitation(fileCitation))

        /** A citation for a web resource used to generate a model response. */
        fun annotation(urlCitation: Annotation.UrlCitation) =
            annotation(Annotation.ofUrlCitation(urlCitation))

        /** A path to a file. */
        fun annotation(filePath: Annotation.FilePath) = annotation(Annotation.ofFilePath(filePath))

        /** The index of the annotation that was added. */
        fun annotationIndex(annotationIndex: Long) = annotationIndex(JsonField.of(annotationIndex))

        /** The index of the annotation that was added. */
        fun annotationIndex(annotationIndex: JsonField<Long>) = apply {
            this.annotationIndex = annotationIndex
        }

        /** The index of the content part that the text annotation was added to. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /** The index of the content part that the text annotation was added to. */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The ID of the output item that the text annotation was added to. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /** The ID of the output item that the text annotation was added to. */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the text annotation was added to. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the text annotation was added to. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.output_text.annotation.added`. */
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

        fun build(): ResponseTextAnnotationDeltaEvent =
            ResponseTextAnnotationDeltaEvent(
                checkRequired("annotation", annotation),
                checkRequired("annotationIndex", annotationIndex),
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toImmutable(),
            )
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
                        tryDeserialize(node, jacksonTypeRef<FileCitation>()) { it.validate() }
                            ?.let {
                                return Annotation(fileCitation = it, _json = json)
                            }
                    }
                    "url_citation" -> {
                        tryDeserialize(node, jacksonTypeRef<UrlCitation>()) { it.validate() }
                            ?.let {
                                return Annotation(urlCitation = it, _json = json)
                            }
                    }
                    "file_path" -> {
                        tryDeserialize(node, jacksonTypeRef<FilePath>()) { it.validate() }
                            ?.let {
                                return Annotation(filePath = it, _json = json)
                            }
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
        @NoAutoDetect
        class FileCitation
        @JsonCreator
        private constructor(
            @JsonProperty("file_id")
            @ExcludeMissing
            private val fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("index")
            @ExcludeMissing
            private val index: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ID of the file. */
            fun fileId(): String = fileId.getRequired("file_id")

            /** The index of the file in the list of files. */
            fun index(): Long = index.getRequired("index")

            /** The type of the file citation. Always `file_citation`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The ID of the file. */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /** The index of the file in the list of files. */
            @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                /** The ID of the file. */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The index of the file in the list of files. */
                fun index(index: Long) = index(JsonField.of(index))

                /** The index of the file in the list of files. */
                fun index(index: JsonField<Long>) = apply { this.index = index }

                /** The type of the file citation. Always `file_citation`. */
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

                fun build(): FileCitation =
                    FileCitation(
                        checkRequired("fileId", fileId),
                        checkRequired("index", index),
                        type,
                        additionalProperties.toImmutable(),
                    )
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
        @NoAutoDetect
        class UrlCitation
        @JsonCreator
        private constructor(
            @JsonProperty("end_index")
            @ExcludeMissing
            private val endIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("start_index")
            @ExcludeMissing
            private val startIndex: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("title")
            @ExcludeMissing
            private val title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("url")
            @ExcludeMissing
            private val url: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The index of the last character of the URL citation in the message. */
            fun endIndex(): Long = endIndex.getRequired("end_index")

            /** The index of the first character of the URL citation in the message. */
            fun startIndex(): Long = startIndex.getRequired("start_index")

            /** The title of the web resource. */
            fun title(): String = title.getRequired("title")

            /** The type of the URL citation. Always `url_citation`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The URL of the web resource. */
            fun url(): String = url.getRequired("url")

            /** The index of the last character of the URL citation in the message. */
            @JsonProperty("end_index") @ExcludeMissing fun _endIndex(): JsonField<Long> = endIndex

            /** The index of the first character of the URL citation in the message. */
            @JsonProperty("start_index")
            @ExcludeMissing
            fun _startIndex(): JsonField<Long> = startIndex

            /** The title of the web resource. */
            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

            /** The URL of the web resource. */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                /** The index of the last character of the URL citation in the message. */
                fun endIndex(endIndex: JsonField<Long>) = apply { this.endIndex = endIndex }

                /** The index of the first character of the URL citation in the message. */
                fun startIndex(startIndex: Long) = startIndex(JsonField.of(startIndex))

                /** The index of the first character of the URL citation in the message. */
                fun startIndex(startIndex: JsonField<Long>) = apply { this.startIndex = startIndex }

                /** The title of the web resource. */
                fun title(title: String) = title(JsonField.of(title))

                /** The title of the web resource. */
                fun title(title: JsonField<String>) = apply { this.title = title }

                /** The type of the URL citation. Always `url_citation`. */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The URL of the web resource. */
                fun url(url: String) = url(JsonField.of(url))

                /** The URL of the web resource. */
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

                fun build(): UrlCitation =
                    UrlCitation(
                        checkRequired("endIndex", endIndex),
                        checkRequired("startIndex", startIndex),
                        checkRequired("title", title),
                        type,
                        checkRequired("url", url),
                        additionalProperties.toImmutable(),
                    )
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
        @NoAutoDetect
        class FilePath
        @JsonCreator
        private constructor(
            @JsonProperty("file_id")
            @ExcludeMissing
            private val fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("index")
            @ExcludeMissing
            private val index: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ID of the file. */
            fun fileId(): String = fileId.getRequired("file_id")

            /** The index of the file in the list of files. */
            fun index(): Long = index.getRequired("index")

            /** The type of the file path. Always `file_path`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The ID of the file. */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /** The index of the file in the list of files. */
            @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                /** The ID of the file. */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The index of the file in the list of files. */
                fun index(index: Long) = index(JsonField.of(index))

                /** The index of the file in the list of files. */
                fun index(index: JsonField<Long>) = apply { this.index = index }

                /** The type of the file path. Always `file_path`. */
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

                fun build(): FilePath =
                    FilePath(
                        checkRequired("fileId", fileId),
                        checkRequired("index", index),
                        type,
                        additionalProperties.toImmutable(),
                    )
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
