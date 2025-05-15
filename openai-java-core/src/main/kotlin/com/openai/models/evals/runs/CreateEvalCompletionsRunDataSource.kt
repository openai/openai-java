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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.EvalItem
import com.openai.models.responses.EasyInputMessage
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A CompletionsRunDataSource object describing a model sampling configuration. */
class CreateEvalCompletionsRunDataSource
private constructor(
    private val source: JsonField<Source>,
    private val type: JsonField<Type>,
    private val inputMessages: JsonField<InputMessages>,
    private val model: JsonField<String>,
    private val samplingParams: JsonField<SamplingParams>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("source") @ExcludeMissing source: JsonField<Source> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("input_messages")
        @ExcludeMissing
        inputMessages: JsonField<InputMessages> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sampling_params")
        @ExcludeMissing
        samplingParams: JsonField<SamplingParams> = JsonMissing.of(),
    ) : this(source, type, inputMessages, model, samplingParams, mutableMapOf())

    /**
     * A StoredCompletionsRunDataSource configuration describing a set of filters
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): Source = source.getRequired("source")

    /**
     * The type of run data source. Always `completions`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputMessages(): Optional<InputMessages> = inputMessages.getOptional("input_messages")

    /**
     * The name of the model to use for generating completions (e.g. "o3-mini").
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<String> = model.getOptional("model")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun samplingParams(): Optional<SamplingParams> = samplingParams.getOptional("sampling_params")

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [inputMessages].
     *
     * Unlike [inputMessages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input_messages")
    @ExcludeMissing
    fun _inputMessages(): JsonField<InputMessages> = inputMessages

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [samplingParams].
     *
     * Unlike [samplingParams], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sampling_params")
    @ExcludeMissing
    fun _samplingParams(): JsonField<SamplingParams> = samplingParams

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
         * [CreateEvalCompletionsRunDataSource].
         *
         * The following fields are required:
         * ```java
         * .source()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateEvalCompletionsRunDataSource]. */
    class Builder internal constructor() {

        private var source: JsonField<Source>? = null
        private var type: JsonField<Type>? = null
        private var inputMessages: JsonField<InputMessages> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var samplingParams: JsonField<SamplingParams> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createEvalCompletionsRunDataSource: CreateEvalCompletionsRunDataSource) =
            apply {
                source = createEvalCompletionsRunDataSource.source
                type = createEvalCompletionsRunDataSource.type
                inputMessages = createEvalCompletionsRunDataSource.inputMessages
                model = createEvalCompletionsRunDataSource.model
                samplingParams = createEvalCompletionsRunDataSource.samplingParams
                additionalProperties =
                    createEvalCompletionsRunDataSource.additionalProperties.toMutableMap()
            }

        /** A StoredCompletionsRunDataSource configuration describing a set of filters */
        fun source(source: Source) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [Source] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<Source>) = apply { this.source = source }

        /** Alias for calling [source] with `Source.ofFileContent(fileContent)`. */
        fun source(fileContent: EvalJsonlFileContentSource) =
            source(Source.ofFileContent(fileContent))

        /**
         * Alias for calling [source] with the following:
         * ```java
         * EvalJsonlFileContentSource.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun fileContentSource(content: List<EvalJsonlFileContentSource.Content>) =
            source(EvalJsonlFileContentSource.builder().content(content).build())

        /** Alias for calling [source] with `Source.ofFileId(fileId)`. */
        fun source(fileId: EvalJsonlFileIdSource) = source(Source.ofFileId(fileId))

        /**
         * Alias for calling [source] with the following:
         * ```java
         * EvalJsonlFileIdSource.builder()
         *     .id(id)
         *     .build()
         * ```
         */
        fun fileIdSource(id: String) = source(EvalJsonlFileIdSource.builder().id(id).build())

        /** Alias for calling [source] with `Source.ofStoredCompletions(storedCompletions)`. */
        fun source(storedCompletions: Source.StoredCompletions) =
            source(Source.ofStoredCompletions(storedCompletions))

        /** The type of run data source. Always `completions`. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun inputMessages(inputMessages: InputMessages) = inputMessages(JsonField.of(inputMessages))

        /**
         * Sets [Builder.inputMessages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputMessages] with a well-typed [InputMessages] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inputMessages(inputMessages: JsonField<InputMessages>) = apply {
            this.inputMessages = inputMessages
        }

        /** Alias for calling [inputMessages] with `InputMessages.ofTemplate(template)`. */
        fun inputMessages(template: InputMessages.Template) =
            inputMessages(InputMessages.ofTemplate(template))

        /**
         * Alias for calling [inputMessages] with the following:
         * ```java
         * InputMessages.Template.builder()
         *     .template(template)
         *     .build()
         * ```
         */
        fun templateInputMessages(template: List<InputMessages.Template.InnerTemplate>) =
            inputMessages(InputMessages.Template.builder().template(template).build())

        /**
         * Alias for calling [inputMessages] with `InputMessages.ofItemReference(itemReference)`.
         */
        fun inputMessages(itemReference: InputMessages.ItemReference) =
            inputMessages(InputMessages.ofItemReference(itemReference))

        /**
         * Alias for calling [inputMessages] with the following:
         * ```java
         * InputMessages.ItemReference.builder()
         *     .itemReference(itemReference)
         *     .build()
         * ```
         */
        fun itemReferenceInputMessages(itemReference: String) =
            inputMessages(
                InputMessages.ItemReference.builder().itemReference(itemReference).build()
            )

        /** The name of the model to use for generating completions (e.g. "o3-mini"). */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        fun samplingParams(samplingParams: SamplingParams) =
            samplingParams(JsonField.of(samplingParams))

        /**
         * Sets [Builder.samplingParams] to an arbitrary JSON value.
         *
         * You should usually call [Builder.samplingParams] with a well-typed [SamplingParams] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun samplingParams(samplingParams: JsonField<SamplingParams>) = apply {
            this.samplingParams = samplingParams
        }

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
         * Returns an immutable instance of [CreateEvalCompletionsRunDataSource].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .source()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreateEvalCompletionsRunDataSource =
            CreateEvalCompletionsRunDataSource(
                checkRequired("source", source),
                checkRequired("type", type),
                inputMessages,
                model,
                samplingParams,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateEvalCompletionsRunDataSource = apply {
        if (validated) {
            return@apply
        }

        source().validate()
        type().validate()
        inputMessages().ifPresent { it.validate() }
        model()
        samplingParams().ifPresent { it.validate() }
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (inputMessages.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (samplingParams.asKnown().getOrNull()?.validity() ?: 0)

    /** A StoredCompletionsRunDataSource configuration describing a set of filters */
    @JsonDeserialize(using = Source.Deserializer::class)
    @JsonSerialize(using = Source.Serializer::class)
    class Source
    private constructor(
        private val fileContent: EvalJsonlFileContentSource? = null,
        private val fileId: EvalJsonlFileIdSource? = null,
        private val storedCompletions: StoredCompletions? = null,
        private val _json: JsonValue? = null,
    ) {

        fun fileContent(): Optional<EvalJsonlFileContentSource> = Optional.ofNullable(fileContent)

        fun fileId(): Optional<EvalJsonlFileIdSource> = Optional.ofNullable(fileId)

        /** A StoredCompletionsRunDataSource configuration describing a set of filters */
        fun storedCompletions(): Optional<StoredCompletions> =
            Optional.ofNullable(storedCompletions)

        fun isFileContent(): Boolean = fileContent != null

        fun isFileId(): Boolean = fileId != null

        fun isStoredCompletions(): Boolean = storedCompletions != null

        fun asFileContent(): EvalJsonlFileContentSource = fileContent.getOrThrow("fileContent")

        fun asFileId(): EvalJsonlFileIdSource = fileId.getOrThrow("fileId")

        /** A StoredCompletionsRunDataSource configuration describing a set of filters */
        fun asStoredCompletions(): StoredCompletions =
            storedCompletions.getOrThrow("storedCompletions")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                fileContent != null -> visitor.visitFileContent(fileContent)
                fileId != null -> visitor.visitFileId(fileId)
                storedCompletions != null -> visitor.visitStoredCompletions(storedCompletions)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Source = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFileContent(fileContent: EvalJsonlFileContentSource) {
                        fileContent.validate()
                    }

                    override fun visitFileId(fileId: EvalJsonlFileIdSource) {
                        fileId.validate()
                    }

                    override fun visitStoredCompletions(storedCompletions: StoredCompletions) {
                        storedCompletions.validate()
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
                    override fun visitFileContent(fileContent: EvalJsonlFileContentSource) =
                        fileContent.validity()

                    override fun visitFileId(fileId: EvalJsonlFileIdSource) = fileId.validity()

                    override fun visitStoredCompletions(storedCompletions: StoredCompletions) =
                        storedCompletions.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Source && fileContent == other.fileContent && fileId == other.fileId && storedCompletions == other.storedCompletions /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileContent, fileId, storedCompletions) /* spotless:on */

        override fun toString(): String =
            when {
                fileContent != null -> "Source{fileContent=$fileContent}"
                fileId != null -> "Source{fileId=$fileId}"
                storedCompletions != null -> "Source{storedCompletions=$storedCompletions}"
                _json != null -> "Source{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Source")
            }

        companion object {

            @JvmStatic
            fun ofFileContent(fileContent: EvalJsonlFileContentSource) =
                Source(fileContent = fileContent)

            @JvmStatic fun ofFileId(fileId: EvalJsonlFileIdSource) = Source(fileId = fileId)

            /** A StoredCompletionsRunDataSource configuration describing a set of filters */
            @JvmStatic
            fun ofStoredCompletions(storedCompletions: StoredCompletions) =
                Source(storedCompletions = storedCompletions)
        }

        /** An interface that defines how to map each variant of [Source] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitFileContent(fileContent: EvalJsonlFileContentSource): T

            fun visitFileId(fileId: EvalJsonlFileIdSource): T

            /** A StoredCompletionsRunDataSource configuration describing a set of filters */
            fun visitStoredCompletions(storedCompletions: StoredCompletions): T

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
                        return tryDeserialize(node, jacksonTypeRef<EvalJsonlFileContentSource>())
                            ?.let { Source(fileContent = it, _json = json) } ?: Source(_json = json)
                    }
                    "file_id" -> {
                        return tryDeserialize(node, jacksonTypeRef<EvalJsonlFileIdSource>())?.let {
                            Source(fileId = it, _json = json)
                        } ?: Source(_json = json)
                    }
                    "stored_completions" -> {
                        return tryDeserialize(node, jacksonTypeRef<StoredCompletions>())?.let {
                            Source(storedCompletions = it, _json = json)
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
                    value.storedCompletions != null ->
                        generator.writeObject(value.storedCompletions)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Source")
                }
            }
        }

        /** A StoredCompletionsRunDataSource configuration describing a set of filters */
        class StoredCompletions
        private constructor(
            private val type: JsonValue,
            private val createdAfter: JsonField<Long>,
            private val createdBefore: JsonField<Long>,
            private val limit: JsonField<Long>,
            private val metadata: JsonField<Metadata>,
            private val model: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("created_after")
                @ExcludeMissing
                createdAfter: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("created_before")
                @ExcludeMissing
                createdBefore: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("metadata")
                @ExcludeMissing
                metadata: JsonField<Metadata> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            ) : this(type, createdAfter, createdBefore, limit, metadata, model, mutableMapOf())

            /**
             * The type of source. Always `stored_completions`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("stored_completions")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * An optional Unix timestamp to filter items created after this time.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdAfter(): Optional<Long> = createdAfter.getOptional("created_after")

            /**
             * An optional Unix timestamp to filter items created before this time.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdBefore(): Optional<Long> = createdBefore.getOptional("created_before")

            /**
             * An optional maximum number of items to return.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun limit(): Optional<Long> = limit.getOptional("limit")

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

            /**
             * An optional model to filter by (e.g., 'gpt-4o').
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<String> = model.getOptional("model")

            /**
             * Returns the raw JSON value of [createdAfter].
             *
             * Unlike [createdAfter], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_after")
            @ExcludeMissing
            fun _createdAfter(): JsonField<Long> = createdAfter

            /**
             * Returns the raw JSON value of [createdBefore].
             *
             * Unlike [createdBefore], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_before")
            @ExcludeMissing
            fun _createdBefore(): JsonField<Long> = createdBefore

            /**
             * Returns the raw JSON value of [limit].
             *
             * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

            /**
             * Returns the raw JSON value of [metadata].
             *
             * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("metadata")
            @ExcludeMissing
            fun _metadata(): JsonField<Metadata> = metadata

            /**
             * Returns the raw JSON value of [model].
             *
             * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
                 * Returns a mutable builder for constructing an instance of [StoredCompletions].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [StoredCompletions]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("stored_completions")
                private var createdAfter: JsonField<Long> = JsonMissing.of()
                private var createdBefore: JsonField<Long> = JsonMissing.of()
                private var limit: JsonField<Long> = JsonMissing.of()
                private var metadata: JsonField<Metadata> = JsonMissing.of()
                private var model: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(storedCompletions: StoredCompletions) = apply {
                    type = storedCompletions.type
                    createdAfter = storedCompletions.createdAfter
                    createdBefore = storedCompletions.createdBefore
                    limit = storedCompletions.limit
                    metadata = storedCompletions.metadata
                    model = storedCompletions.model
                    additionalProperties = storedCompletions.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("stored_completions")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** An optional Unix timestamp to filter items created after this time. */
                fun createdAfter(createdAfter: Long?) =
                    createdAfter(JsonField.ofNullable(createdAfter))

                /**
                 * Alias for [Builder.createdAfter].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun createdAfter(createdAfter: Long) = createdAfter(createdAfter as Long?)

                /** Alias for calling [Builder.createdAfter] with `createdAfter.orElse(null)`. */
                fun createdAfter(createdAfter: Optional<Long>) =
                    createdAfter(createdAfter.getOrNull())

                /**
                 * Sets [Builder.createdAfter] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAfter] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun createdAfter(createdAfter: JsonField<Long>) = apply {
                    this.createdAfter = createdAfter
                }

                /** An optional Unix timestamp to filter items created before this time. */
                fun createdBefore(createdBefore: Long?) =
                    createdBefore(JsonField.ofNullable(createdBefore))

                /**
                 * Alias for [Builder.createdBefore].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun createdBefore(createdBefore: Long) = createdBefore(createdBefore as Long?)

                /** Alias for calling [Builder.createdBefore] with `createdBefore.orElse(null)`. */
                fun createdBefore(createdBefore: Optional<Long>) =
                    createdBefore(createdBefore.getOrNull())

                /**
                 * Sets [Builder.createdBefore] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdBefore] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun createdBefore(createdBefore: JsonField<Long>) = apply {
                    this.createdBefore = createdBefore
                }

                /** An optional maximum number of items to return. */
                fun limit(limit: Long?) = limit(JsonField.ofNullable(limit))

                /**
                 * Alias for [Builder.limit].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun limit(limit: Long) = limit(limit as Long?)

                /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
                fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

                /**
                 * Sets [Builder.limit] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.limit] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 */
                fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
                fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

                /**
                 * Sets [Builder.metadata] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.metadata] with a well-typed [Metadata] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

                /** An optional model to filter by (e.g., 'gpt-4o'). */
                fun model(model: String?) = model(JsonField.ofNullable(model))

                /** Alias for calling [Builder.model] with `model.orElse(null)`. */
                fun model(model: Optional<String>) = model(model.getOrNull())

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

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
                 * Returns an immutable instance of [StoredCompletions].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): StoredCompletions =
                    StoredCompletions(
                        type,
                        createdAfter,
                        createdBefore,
                        limit,
                        metadata,
                        model,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): StoredCompletions = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("stored_completions")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                createdAfter()
                createdBefore()
                limit()
                metadata().ifPresent { it.validate() }
                model()
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
                type.let { if (it == JsonValue.from("stored_completions")) 1 else 0 } +
                    (if (createdAfter.asKnown().isPresent) 1 else 0) +
                    (if (createdBefore.asKnown().isPresent) 1 else 0) +
                    (if (limit.asKnown().isPresent) 1 else 0) +
                    (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (model.asKnown().isPresent) 1 else 0)

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            class Metadata
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

                    /** Returns a mutable builder for constructing an instance of [Metadata]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Metadata]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(metadata: Metadata) = apply {
                        additionalProperties = metadata.additionalProperties.toMutableMap()
                    }

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
                     * Returns an immutable instance of [Metadata].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Metadata = Metadata(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): Metadata = apply {
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

                    return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is StoredCompletions && type == other.type && createdAfter == other.createdAfter && createdBefore == other.createdBefore && limit == other.limit && metadata == other.metadata && model == other.model && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, createdAfter, createdBefore, limit, metadata, model, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "StoredCompletions{type=$type, createdAfter=$createdAfter, createdBefore=$createdBefore, limit=$limit, metadata=$metadata, model=$model, additionalProperties=$additionalProperties}"
        }
    }

    /** The type of run data source. Always `completions`. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COMPLETIONS = of("completions")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            COMPLETIONS
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPLETIONS,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                COMPLETIONS -> Value.COMPLETIONS
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                COMPLETIONS -> Known.COMPLETIONS
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    @JsonDeserialize(using = InputMessages.Deserializer::class)
    @JsonSerialize(using = InputMessages.Serializer::class)
    class InputMessages
    private constructor(
        private val template: Template? = null,
        private val itemReference: ItemReference? = null,
        private val _json: JsonValue? = null,
    ) {

        fun template(): Optional<Template> = Optional.ofNullable(template)

        fun itemReference(): Optional<ItemReference> = Optional.ofNullable(itemReference)

        fun isTemplate(): Boolean = template != null

        fun isItemReference(): Boolean = itemReference != null

        fun asTemplate(): Template = template.getOrThrow("template")

        fun asItemReference(): ItemReference = itemReference.getOrThrow("itemReference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                template != null -> visitor.visitTemplate(template)
                itemReference != null -> visitor.visitItemReference(itemReference)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): InputMessages = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTemplate(template: Template) {
                        template.validate()
                    }

                    override fun visitItemReference(itemReference: ItemReference) {
                        itemReference.validate()
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
                    override fun visitTemplate(template: Template) = template.validity()

                    override fun visitItemReference(itemReference: ItemReference) =
                        itemReference.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InputMessages && template == other.template && itemReference == other.itemReference /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(template, itemReference) /* spotless:on */

        override fun toString(): String =
            when {
                template != null -> "InputMessages{template=$template}"
                itemReference != null -> "InputMessages{itemReference=$itemReference}"
                _json != null -> "InputMessages{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid InputMessages")
            }

        companion object {

            @JvmStatic fun ofTemplate(template: Template) = InputMessages(template = template)

            @JvmStatic
            fun ofItemReference(itemReference: ItemReference) =
                InputMessages(itemReference = itemReference)
        }

        /**
         * An interface that defines how to map each variant of [InputMessages] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitTemplate(template: Template): T

            fun visitItemReference(itemReference: ItemReference): T

            /**
             * Maps an unknown variant of [InputMessages] to a value of type [T].
             *
             * An instance of [InputMessages] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown InputMessages: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<InputMessages>(InputMessages::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): InputMessages {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "template" -> {
                        return tryDeserialize(node, jacksonTypeRef<Template>())?.let {
                            InputMessages(template = it, _json = json)
                        } ?: InputMessages(_json = json)
                    }
                    "item_reference" -> {
                        return tryDeserialize(node, jacksonTypeRef<ItemReference>())?.let {
                            InputMessages(itemReference = it, _json = json)
                        } ?: InputMessages(_json = json)
                    }
                }

                return InputMessages(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<InputMessages>(InputMessages::class) {

            override fun serialize(
                value: InputMessages,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.template != null -> generator.writeObject(value.template)
                    value.itemReference != null -> generator.writeObject(value.itemReference)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid InputMessages")
                }
            }
        }

        class Template
        private constructor(
            private val template: JsonField<List<InnerTemplate>>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("template")
                @ExcludeMissing
                template: JsonField<List<InnerTemplate>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(template, type, mutableMapOf())

            /**
             * A list of chat messages forming the prompt or context. May include variable
             * references to the "item" namespace, ie {{item.name}}.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun template(): List<InnerTemplate> = template.getRequired("template")

            /**
             * The type of input messages. Always `template`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("template")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [template].
             *
             * Unlike [template], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("template")
            @ExcludeMissing
            fun _template(): JsonField<List<InnerTemplate>> = template

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
                 * Returns a mutable builder for constructing an instance of [Template].
                 *
                 * The following fields are required:
                 * ```java
                 * .template()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Template]. */
            class Builder internal constructor() {

                private var template: JsonField<MutableList<InnerTemplate>>? = null
                private var type: JsonValue = JsonValue.from("template")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(template: Template) = apply {
                    this.template = template.template.map { it.toMutableList() }
                    type = template.type
                    additionalProperties = template.additionalProperties.toMutableMap()
                }

                /**
                 * A list of chat messages forming the prompt or context. May include variable
                 * references to the "item" namespace, ie {{item.name}}.
                 */
                fun template(template: List<InnerTemplate>) = template(JsonField.of(template))

                /**
                 * Sets [Builder.template] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.template] with a well-typed
                 * `List<InnerTemplate>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun template(template: JsonField<List<InnerTemplate>>) = apply {
                    this.template = template.map { it.toMutableList() }
                }

                /**
                 * Adds a single [InnerTemplate] to [Builder.template].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTemplate(template: InnerTemplate) = apply {
                    this.template =
                        (this.template ?: JsonField.of(mutableListOf())).also {
                            checkKnown("template", it).add(template)
                        }
                }

                /**
                 * Alias for calling [addTemplate] with
                 * `InnerTemplate.ofEasyInputMessage(easyInputMessage)`.
                 */
                fun addTemplate(easyInputMessage: EasyInputMessage) =
                    addTemplate(InnerTemplate.ofEasyInputMessage(easyInputMessage))

                /** Alias for calling [addTemplate] with `InnerTemplate.ofEvalItem(evalItem)`. */
                fun addTemplate(evalItem: EvalItem) =
                    addTemplate(InnerTemplate.ofEvalItem(evalItem))

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("template")
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
                 * Returns an immutable instance of [Template].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .template()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Template =
                    Template(
                        checkRequired("template", template).map { it.toImmutable() },
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Template = apply {
                if (validated) {
                    return@apply
                }

                template().forEach { it.validate() }
                _type().let {
                    if (it != JsonValue.from("template")) {
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
                (template.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    type.let { if (it == JsonValue.from("template")) 1 else 0 }

            /**
             * A message input to the model with a role indicating instruction following hierarchy.
             * Instructions given with the `developer` or `system` role take precedence over
             * instructions given with the `user` role. Messages with the `assistant` role are
             * presumed to have been generated by the model in previous interactions.
             */
            @JsonDeserialize(using = InnerTemplate.Deserializer::class)
            @JsonSerialize(using = InnerTemplate.Serializer::class)
            class InnerTemplate
            private constructor(
                private val easyInputMessage: EasyInputMessage? = null,
                private val evalItem: EvalItem? = null,
                private val _json: JsonValue? = null,
            ) {

                /**
                 * A message input to the model with a role indicating instruction following
                 * hierarchy. Instructions given with the `developer` or `system` role take
                 * precedence over instructions given with the `user` role. Messages with the
                 * `assistant` role are presumed to have been generated by the model in previous
                 * interactions.
                 */
                fun easyInputMessage(): Optional<EasyInputMessage> =
                    Optional.ofNullable(easyInputMessage)

                /**
                 * A message input to the model with a role indicating instruction following
                 * hierarchy. Instructions given with the `developer` or `system` role take
                 * precedence over instructions given with the `user` role. Messages with the
                 * `assistant` role are presumed to have been generated by the model in previous
                 * interactions.
                 */
                fun evalItem(): Optional<EvalItem> = Optional.ofNullable(evalItem)

                fun isEasyInputMessage(): Boolean = easyInputMessage != null

                fun isEvalItem(): Boolean = evalItem != null

                /**
                 * A message input to the model with a role indicating instruction following
                 * hierarchy. Instructions given with the `developer` or `system` role take
                 * precedence over instructions given with the `user` role. Messages with the
                 * `assistant` role are presumed to have been generated by the model in previous
                 * interactions.
                 */
                fun asEasyInputMessage(): EasyInputMessage =
                    easyInputMessage.getOrThrow("easyInputMessage")

                /**
                 * A message input to the model with a role indicating instruction following
                 * hierarchy. Instructions given with the `developer` or `system` role take
                 * precedence over instructions given with the `user` role. Messages with the
                 * `assistant` role are presumed to have been generated by the model in previous
                 * interactions.
                 */
                fun asEvalItem(): EvalItem = evalItem.getOrThrow("evalItem")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        easyInputMessage != null -> visitor.visitEasyInputMessage(easyInputMessage)
                        evalItem != null -> visitor.visitEvalItem(evalItem)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): InnerTemplate = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitEasyInputMessage(easyInputMessage: EasyInputMessage) {
                                easyInputMessage.validate()
                            }

                            override fun visitEvalItem(evalItem: EvalItem) {
                                evalItem.validate()
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
                            override fun visitEasyInputMessage(easyInputMessage: EasyInputMessage) =
                                easyInputMessage.validity()

                            override fun visitEvalItem(evalItem: EvalItem) = evalItem.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is InnerTemplate && easyInputMessage == other.easyInputMessage && evalItem == other.evalItem /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(easyInputMessage, evalItem) /* spotless:on */

                override fun toString(): String =
                    when {
                        easyInputMessage != null ->
                            "InnerTemplate{easyInputMessage=$easyInputMessage}"
                        evalItem != null -> "InnerTemplate{evalItem=$evalItem}"
                        _json != null -> "InnerTemplate{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid InnerTemplate")
                    }

                companion object {

                    /**
                     * A message input to the model with a role indicating instruction following
                     * hierarchy. Instructions given with the `developer` or `system` role take
                     * precedence over instructions given with the `user` role. Messages with the
                     * `assistant` role are presumed to have been generated by the model in previous
                     * interactions.
                     */
                    @JvmStatic
                    fun ofEasyInputMessage(easyInputMessage: EasyInputMessage) =
                        InnerTemplate(easyInputMessage = easyInputMessage)

                    /**
                     * A message input to the model with a role indicating instruction following
                     * hierarchy. Instructions given with the `developer` or `system` role take
                     * precedence over instructions given with the `user` role. Messages with the
                     * `assistant` role are presumed to have been generated by the model in previous
                     * interactions.
                     */
                    @JvmStatic
                    fun ofEvalItem(evalItem: EvalItem) = InnerTemplate(evalItem = evalItem)
                }

                /**
                 * An interface that defines how to map each variant of [InnerTemplate] to a value
                 * of type [T].
                 */
                interface Visitor<out T> {

                    /**
                     * A message input to the model with a role indicating instruction following
                     * hierarchy. Instructions given with the `developer` or `system` role take
                     * precedence over instructions given with the `user` role. Messages with the
                     * `assistant` role are presumed to have been generated by the model in previous
                     * interactions.
                     */
                    fun visitEasyInputMessage(easyInputMessage: EasyInputMessage): T

                    /**
                     * A message input to the model with a role indicating instruction following
                     * hierarchy. Instructions given with the `developer` or `system` role take
                     * precedence over instructions given with the `user` role. Messages with the
                     * `assistant` role are presumed to have been generated by the model in previous
                     * interactions.
                     */
                    fun visitEvalItem(evalItem: EvalItem): T

                    /**
                     * Maps an unknown variant of [InnerTemplate] to a value of type [T].
                     *
                     * An instance of [InnerTemplate] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown InnerTemplate: $json")
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<InnerTemplate>(InnerTemplate::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): InnerTemplate {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        if (type == "message") {
                            val bestMatches =
                                sequenceOf(
                                        tryDeserialize(node, jacksonTypeRef<EasyInputMessage>())
                                            ?.let {
                                                InnerTemplate(easyInputMessage = it, _json = json)
                                            },
                                        tryDeserialize(node, jacksonTypeRef<EvalItem>())?.let {
                                            InnerTemplate(evalItem = it, _json = json)
                                        },
                                    )
                                    .filterNotNull()
                                    .allMaxBy { it.validity() }
                                    .toList()
                            return when (bestMatches.size) {
                                // This can happen if what we're deserializing is completely
                                // incompatible with all the possible variants (e.g. deserializing
                                // from boolean).
                                0 -> InnerTemplate(_json = json)
                                1 -> bestMatches.single()
                                // If there's more than one match with the highest validity, then
                                // use the first completely valid match, or simply the first match
                                // if none are completely valid.
                                else ->
                                    bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                            }
                        }

                        return InnerTemplate(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<InnerTemplate>(InnerTemplate::class) {

                    override fun serialize(
                        value: InnerTemplate,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.easyInputMessage != null ->
                                generator.writeObject(value.easyInputMessage)
                            value.evalItem != null -> generator.writeObject(value.evalItem)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid InnerTemplate")
                        }
                    }
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Template && template == other.template && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(template, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Template{template=$template, type=$type, additionalProperties=$additionalProperties}"
        }

        class ItemReference
        private constructor(
            private val itemReference: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("item_reference")
                @ExcludeMissing
                itemReference: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(itemReference, type, mutableMapOf())

            /**
             * A reference to a variable in the "item" namespace. Ie, "item.name"
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun itemReference(): String = itemReference.getRequired("item_reference")

            /**
             * The type of input messages. Always `item_reference`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("item_reference")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [itemReference].
             *
             * Unlike [itemReference], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("item_reference")
            @ExcludeMissing
            fun _itemReference(): JsonField<String> = itemReference

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
                 * Returns a mutable builder for constructing an instance of [ItemReference].
                 *
                 * The following fields are required:
                 * ```java
                 * .itemReference()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ItemReference]. */
            class Builder internal constructor() {

                private var itemReference: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("item_reference")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(itemReference: ItemReference) = apply {
                    this.itemReference = itemReference.itemReference
                    type = itemReference.type
                    additionalProperties = itemReference.additionalProperties.toMutableMap()
                }

                /** A reference to a variable in the "item" namespace. Ie, "item.name" */
                fun itemReference(itemReference: String) =
                    itemReference(JsonField.of(itemReference))

                /**
                 * Sets [Builder.itemReference] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.itemReference] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun itemReference(itemReference: JsonField<String>) = apply {
                    this.itemReference = itemReference
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("item_reference")
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
                 * Returns an immutable instance of [ItemReference].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .itemReference()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ItemReference =
                    ItemReference(
                        checkRequired("itemReference", itemReference),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ItemReference = apply {
                if (validated) {
                    return@apply
                }

                itemReference()
                _type().let {
                    if (it != JsonValue.from("item_reference")) {
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
                (if (itemReference.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("item_reference")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ItemReference && itemReference == other.itemReference && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(itemReference, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ItemReference{itemReference=$itemReference, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    class SamplingParams
    private constructor(
        private val maxCompletionTokens: JsonField<Long>,
        private val seed: JsonField<Long>,
        private val temperature: JsonField<Double>,
        private val topP: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("max_completion_tokens")
            @ExcludeMissing
            maxCompletionTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("seed") @ExcludeMissing seed: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("top_p") @ExcludeMissing topP: JsonField<Double> = JsonMissing.of(),
        ) : this(maxCompletionTokens, seed, temperature, topP, mutableMapOf())

        /**
         * The maximum number of tokens in the generated output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxCompletionTokens(): Optional<Long> =
            maxCompletionTokens.getOptional("max_completion_tokens")

        /**
         * A seed value to initialize the randomness, during sampling.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun seed(): Optional<Long> = seed.getOptional("seed")

        /**
         * A higher temperature increases randomness in the outputs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * An alternative to temperature for nucleus sampling; 1.0 includes all tokens.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topP(): Optional<Double> = topP.getOptional("top_p")

        /**
         * Returns the raw JSON value of [maxCompletionTokens].
         *
         * Unlike [maxCompletionTokens], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("max_completion_tokens")
        @ExcludeMissing
        fun _maxCompletionTokens(): JsonField<Long> = maxCompletionTokens

        /**
         * Returns the raw JSON value of [seed].
         *
         * Unlike [seed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("seed") @ExcludeMissing fun _seed(): JsonField<Long> = seed

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [topP].
         *
         * Unlike [topP], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("top_p") @ExcludeMissing fun _topP(): JsonField<Double> = topP

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

            /** Returns a mutable builder for constructing an instance of [SamplingParams]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SamplingParams]. */
        class Builder internal constructor() {

            private var maxCompletionTokens: JsonField<Long> = JsonMissing.of()
            private var seed: JsonField<Long> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var topP: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(samplingParams: SamplingParams) = apply {
                maxCompletionTokens = samplingParams.maxCompletionTokens
                seed = samplingParams.seed
                temperature = samplingParams.temperature
                topP = samplingParams.topP
                additionalProperties = samplingParams.additionalProperties.toMutableMap()
            }

            /** The maximum number of tokens in the generated output. */
            fun maxCompletionTokens(maxCompletionTokens: Long) =
                maxCompletionTokens(JsonField.of(maxCompletionTokens))

            /**
             * Sets [Builder.maxCompletionTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxCompletionTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxCompletionTokens(maxCompletionTokens: JsonField<Long>) = apply {
                this.maxCompletionTokens = maxCompletionTokens
            }

            /** A seed value to initialize the randomness, during sampling. */
            fun seed(seed: Long) = seed(JsonField.of(seed))

            /**
             * Sets [Builder.seed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.seed] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun seed(seed: JsonField<Long>) = apply { this.seed = seed }

            /** A higher temperature increases randomness in the outputs. */
            fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

            /**
             * Sets [Builder.temperature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /** An alternative to temperature for nucleus sampling; 1.0 includes all tokens. */
            fun topP(topP: Double) = topP(JsonField.of(topP))

            /**
             * Sets [Builder.topP] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topP] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun topP(topP: JsonField<Double>) = apply { this.topP = topP }

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
             * Returns an immutable instance of [SamplingParams].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): SamplingParams =
                SamplingParams(
                    maxCompletionTokens,
                    seed,
                    temperature,
                    topP,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): SamplingParams = apply {
            if (validated) {
                return@apply
            }

            maxCompletionTokens()
            seed()
            temperature()
            topP()
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
            (if (maxCompletionTokens.asKnown().isPresent) 1 else 0) +
                (if (seed.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (topP.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is SamplingParams && maxCompletionTokens == other.maxCompletionTokens && seed == other.seed && temperature == other.temperature && topP == other.topP && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(maxCompletionTokens, seed, temperature, topP, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SamplingParams{maxCompletionTokens=$maxCompletionTokens, seed=$seed, temperature=$temperature, topP=$topP, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CreateEvalCompletionsRunDataSource && source == other.source && type == other.type && inputMessages == other.inputMessages && model == other.model && samplingParams == other.samplingParams && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(source, type, inputMessages, model, samplingParams, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateEvalCompletionsRunDataSource{source=$source, type=$type, inputMessages=$inputMessages, model=$model, samplingParams=$samplingParams, additionalProperties=$additionalProperties}"
}
