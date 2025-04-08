// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

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

/** A JsonlRunDataSource object with that specifies a JSONL file that matches the eval */
class CreateEvalJsonlRunDataSource
private constructor(
    private val source: JsonField<Source>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("source") @ExcludeMissing source: JsonField<Source> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(source, type, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): Source = source.getRequired("source")

    /**
     * The type of data source. Always `jsonl`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("jsonl")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
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
         * Returns a mutable builder for constructing an instance of [CreateEvalJsonlRunDataSource].
         *
         * The following fields are required:
         * ```java
         * .source()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateEvalJsonlRunDataSource]. */
    class Builder internal constructor() {

        private var source: JsonField<Source>? = null
        private var type: JsonValue = JsonValue.from("jsonl")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createEvalJsonlRunDataSource: CreateEvalJsonlRunDataSource) = apply {
            source = createEvalJsonlRunDataSource.source
            type = createEvalJsonlRunDataSource.type
            additionalProperties = createEvalJsonlRunDataSource.additionalProperties.toMutableMap()
        }

        fun source(source: Source) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [Source] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<Source>) = apply { this.source = source }

        /** Alias for calling [source] with `Source.ofFileContent(fileContent)`. */
        fun source(fileContent: Source.FileContent) = source(Source.ofFileContent(fileContent))

        /**
         * Alias for calling [source] with the following:
         * ```java
         * Source.FileContent.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun fileContentSource(content: List<Source.FileContent.Content>) =
            source(Source.FileContent.builder().content(content).build())

        /** Alias for calling [source] with `Source.ofFileId(fileId)`. */
        fun source(fileId: Source.FileId) = source(Source.ofFileId(fileId))

        /**
         * Alias for calling [source] with the following:
         * ```java
         * Source.FileId.builder()
         *     .id(id)
         *     .build()
         * ```
         */
        fun fileIdSource(id: String) = source(Source.FileId.builder().id(id).build())

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("jsonl")
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
         * Returns an immutable instance of [CreateEvalJsonlRunDataSource].
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
        fun build(): CreateEvalJsonlRunDataSource =
            CreateEvalJsonlRunDataSource(
                checkRequired("source", source),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateEvalJsonlRunDataSource = apply {
        if (validated) {
            return@apply
        }

        source().validate()
        _type().let {
            if (it != JsonValue.from("jsonl")) {
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
        (source.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("jsonl")) 1 else 0 }

    @JsonDeserialize(using = Source.Deserializer::class)
    @JsonSerialize(using = Source.Serializer::class)
    class Source
    private constructor(
        private val fileContent: FileContent? = null,
        private val fileId: FileId? = null,
        private val _json: JsonValue? = null,
    ) {

        fun fileContent(): Optional<FileContent> = Optional.ofNullable(fileContent)

        fun fileId(): Optional<FileId> = Optional.ofNullable(fileId)

        fun isFileContent(): Boolean = fileContent != null

        fun isFileId(): Boolean = fileId != null

        fun asFileContent(): FileContent = fileContent.getOrThrow("fileContent")

        fun asFileId(): FileId = fileId.getOrThrow("fileId")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                fileContent != null -> visitor.visitFileContent(fileContent)
                fileId != null -> visitor.visitFileId(fileId)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Source = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFileContent(fileContent: FileContent) {
                        fileContent.validate()
                    }

                    override fun visitFileId(fileId: FileId) {
                        fileId.validate()
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
                    override fun visitFileContent(fileContent: FileContent) = fileContent.validity()

                    override fun visitFileId(fileId: FileId) = fileId.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Source && fileContent == other.fileContent && fileId == other.fileId /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileContent, fileId) /* spotless:on */

        override fun toString(): String =
            when {
                fileContent != null -> "Source{fileContent=$fileContent}"
                fileId != null -> "Source{fileId=$fileId}"
                _json != null -> "Source{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Source")
            }

        companion object {

            @JvmStatic
            fun ofFileContent(fileContent: FileContent) = Source(fileContent = fileContent)

            @JvmStatic fun ofFileId(fileId: FileId) = Source(fileId = fileId)
        }

        /** An interface that defines how to map each variant of [Source] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitFileContent(fileContent: FileContent): T

            fun visitFileId(fileId: FileId): T

            /**
             * Maps an unknown variant of [Source] to a value of type [T].
             *
             * An instance of [Source] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Source: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Source>(Source::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Source {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "file_content" -> {
                        return tryDeserialize(node, jacksonTypeRef<FileContent>())?.let {
                            Source(fileContent = it, _json = json)
                        } ?: Source(_json = json)
                    }
                    "file_id" -> {
                        return tryDeserialize(node, jacksonTypeRef<FileId>())?.let {
                            Source(fileId = it, _json = json)
                        } ?: Source(_json = json)
                    }
                }

                return Source(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Source>(Source::class) {

            override fun serialize(
                value: Source,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.fileContent != null -> generator.writeObject(value.fileContent)
                    value.fileId != null -> generator.writeObject(value.fileId)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Source")
                }
            }
        }

        class FileContent
        private constructor(
            private val content: JsonField<List<Content>>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<List<Content>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(content, type, mutableMapOf())

            /**
             * The content of the jsonl file.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun content(): List<Content> = content.getRequired("content")

            /**
             * The type of jsonl source. Always `file_content`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("file_content")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content")
            @ExcludeMissing
            fun _content(): JsonField<List<Content>> = content

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
                 * Returns a mutable builder for constructing an instance of [FileContent].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileContent]. */
            class Builder internal constructor() {

                private var content: JsonField<MutableList<Content>>? = null
                private var type: JsonValue = JsonValue.from("file_content")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileContent: FileContent) = apply {
                    content = fileContent.content.map { it.toMutableList() }
                    type = fileContent.type
                    additionalProperties = fileContent.additionalProperties.toMutableMap()
                }

                /** The content of the jsonl file. */
                fun content(content: List<Content>) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed `List<Content>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun content(content: JsonField<List<Content>>) = apply {
                    this.content = content.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Content] to [Builder.content].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addContent(content: Content) = apply {
                    this.content =
                        (this.content ?: JsonField.of(mutableListOf())).also {
                            checkKnown("content", it).add(content)
                        }
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("file_content")
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
                 * Returns an immutable instance of [FileContent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FileContent =
                    FileContent(
                        checkRequired("content", content).map { it.toImmutable() },
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileContent = apply {
                if (validated) {
                    return@apply
                }

                content().forEach { it.validate() }
                _type().let {
                    if (it != JsonValue.from("file_content")) {
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
                (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    type.let { if (it == JsonValue.from("file_content")) 1 else 0 }

            class Content
            private constructor(
                private val item: JsonField<Item>,
                private val sample: JsonField<Sample>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("item") @ExcludeMissing item: JsonField<Item> = JsonMissing.of(),
                    @JsonProperty("sample")
                    @ExcludeMissing
                    sample: JsonField<Sample> = JsonMissing.of(),
                ) : this(item, sample, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun item(): Item = item.getRequired("item")

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun sample(): Optional<Sample> = sample.getOptional("sample")

                /**
                 * Returns the raw JSON value of [item].
                 *
                 * Unlike [item], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<Item> = item

                /**
                 * Returns the raw JSON value of [sample].
                 *
                 * Unlike [sample], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("sample") @ExcludeMissing fun _sample(): JsonField<Sample> = sample

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
                     * Returns a mutable builder for constructing an instance of [Content].
                     *
                     * The following fields are required:
                     * ```java
                     * .item()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Content]. */
                class Builder internal constructor() {

                    private var item: JsonField<Item>? = null
                    private var sample: JsonField<Sample> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(content: Content) = apply {
                        item = content.item
                        sample = content.sample
                        additionalProperties = content.additionalProperties.toMutableMap()
                    }

                    fun item(item: Item) = item(JsonField.of(item))

                    /**
                     * Sets [Builder.item] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.item] with a well-typed [Item] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun item(item: JsonField<Item>) = apply { this.item = item }

                    fun sample(sample: Sample) = sample(JsonField.of(sample))

                    /**
                     * Sets [Builder.sample] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.sample] with a well-typed [Sample] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun sample(sample: JsonField<Sample>) = apply { this.sample = sample }

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
                     * Returns an immutable instance of [Content].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .item()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Content =
                        Content(
                            checkRequired("item", item),
                            sample,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Content = apply {
                    if (validated) {
                        return@apply
                    }

                    item().validate()
                    sample().ifPresent { it.validate() }
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
                    (item.asKnown().getOrNull()?.validity() ?: 0) +
                        (sample.asKnown().getOrNull()?.validity() ?: 0)

                class Item
                @JsonCreator
                private constructor(
                    @com.fasterxml.jackson.annotation.JsonValue
                    private val additionalProperties: Map<String, JsonValue>
                ) {

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /** Returns a mutable builder for constructing an instance of [Item]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Item]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(item: Item) = apply {
                            additionalProperties = item.additionalProperties.toMutableMap()
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Item].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Item = Item(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    fun validate(): Item = apply {
                        if (validated) {
                            return@apply
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Item && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() = "Item{additionalProperties=$additionalProperties}"
                }

                class Sample
                @JsonCreator
                private constructor(
                    @com.fasterxml.jackson.annotation.JsonValue
                    private val additionalProperties: Map<String, JsonValue>
                ) {

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /** Returns a mutable builder for constructing an instance of [Sample]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Sample]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(sample: Sample) = apply {
                            additionalProperties = sample.additionalProperties.toMutableMap()
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Sample].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Sample = Sample(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    fun validate(): Sample = apply {
                        if (validated) {
                            return@apply
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
                        additionalProperties.count { (_, value) ->
                            !value.isNull() && !value.isMissing()
                        }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Sample && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() = "Sample{additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Content && item == other.item && sample == other.sample && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(item, sample, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Content{item=$item, sample=$sample, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileContent && content == other.content && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileContent{content=$content, type=$type, additionalProperties=$additionalProperties}"
        }

        class FileId
        private constructor(
            private val id: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(id, type, mutableMapOf())

            /**
             * The identifier of the file.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * The type of jsonl source. Always `file_id`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("file_id")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                 * Returns a mutable builder for constructing an instance of [FileId].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileId]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("file_id")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileId: FileId) = apply {
                    id = fileId.id
                    type = fileId.type
                    additionalProperties = fileId.additionalProperties.toMutableMap()
                }

                /** The identifier of the file. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("file_id")
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
                 * Returns an immutable instance of [FileId].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FileId =
                    FileId(checkRequired("id", id), type, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): FileId = apply {
                if (validated) {
                    return@apply
                }

                id()
                _type().let {
                    if (it != JsonValue.from("file_id")) {
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("file_id")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileId && id == other.id && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileId{id=$id, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CreateEvalJsonlRunDataSource && source == other.source && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(source, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateEvalJsonlRunDataSource{source=$source, type=$type, additionalProperties=$additionalProperties}"
}
