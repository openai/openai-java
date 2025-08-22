// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class FileSearchToolCall
private constructor(
    private val id: JsonField<String>,
    private val fileSearch: JsonField<FileSearch>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("file_search")
        @ExcludeMissing
        fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, fileSearch, type, mutableMapOf())

    /**
     * The ID of the tool call object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * For now, this is always going to be an empty object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fileSearch(): FileSearch = fileSearch.getRequired("file_search")

    /**
     * The type of tool call. This is always going to be `file_search` for this type of tool call.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("file_search")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [fileSearch].
     *
     * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_search")
    @ExcludeMissing
    fun _fileSearch(): JsonField<FileSearch> = fileSearch

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
         * Returns a mutable builder for constructing an instance of [FileSearchToolCall].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .fileSearch()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileSearchToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var fileSearch: JsonField<FileSearch>? = null
        private var type: JsonValue = JsonValue.from("file_search")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileSearchToolCall: FileSearchToolCall) = apply {
            id = fileSearchToolCall.id
            fileSearch = fileSearchToolCall.fileSearch
            type = fileSearchToolCall.type
            additionalProperties = fileSearchToolCall.additionalProperties.toMutableMap()
        }

        /** The ID of the tool call object. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** For now, this is always going to be an empty object. */
        fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

        /**
         * Sets [Builder.fileSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fileSearch(fileSearch: JsonField<FileSearch>) = apply { this.fileSearch = fileSearch }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("file_search")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [FileSearchToolCall].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .fileSearch()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileSearchToolCall =
            FileSearchToolCall(
                checkRequired("id", id),
                checkRequired("fileSearch", fileSearch),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileSearchToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        fileSearch().validate()
        _type().let {
            if (it != JsonValue.from("file_search")) {
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (fileSearch.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("file_search")) 1 else 0 }

    /** For now, this is always going to be an empty object. */
    class FileSearch
    private constructor(
        private val rankingOptions: JsonField<RankingOptions>,
        private val results: JsonField<List<Result>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ranking_options")
            @ExcludeMissing
            rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
            @JsonProperty("results")
            @ExcludeMissing
            results: JsonField<List<Result>> = JsonMissing.of(),
        ) : this(rankingOptions, results, mutableMapOf())

        /**
         * The ranking options for the file search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rankingOptions(): Optional<RankingOptions> =
            rankingOptions.getOptional("ranking_options")

        /**
         * The results of the file search.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun results(): Optional<List<Result>> = results.getOptional("results")

        /**
         * Returns the raw JSON value of [rankingOptions].
         *
         * Unlike [rankingOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ranking_options")
        @ExcludeMissing
        fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

        /**
         * Returns the raw JSON value of [results].
         *
         * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

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

            /** Returns a mutable builder for constructing an instance of [FileSearch]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileSearch]. */
        class Builder internal constructor() {

            private var rankingOptions: JsonField<RankingOptions> = JsonMissing.of()
            private var results: JsonField<MutableList<Result>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileSearch: FileSearch) = apply {
                rankingOptions = fileSearch.rankingOptions
                results = fileSearch.results.map { it.toMutableList() }
                additionalProperties = fileSearch.additionalProperties.toMutableMap()
            }

            /** The ranking options for the file search. */
            fun rankingOptions(rankingOptions: RankingOptions) =
                rankingOptions(JsonField.of(rankingOptions))

            /**
             * Sets [Builder.rankingOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rankingOptions] with a well-typed [RankingOptions]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun rankingOptions(rankingOptions: JsonField<RankingOptions>) = apply {
                this.rankingOptions = rankingOptions
            }

            /** The results of the file search. */
            fun results(results: List<Result>) = results(JsonField.of(results))

            /**
             * Sets [Builder.results] to an arbitrary JSON value.
             *
             * You should usually call [Builder.results] with a well-typed `List<Result>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun results(results: JsonField<List<Result>>) = apply {
                this.results = results.map { it.toMutableList() }
            }

            /**
             * Adds a single [Result] to [results].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addResult(result: Result) = apply {
                results =
                    (results ?: JsonField.of(mutableListOf())).also {
                        checkKnown("results", it).add(result)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAlladditional_properties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAlladditional_properties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [FileSearch].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FileSearch =
                FileSearch(
                    rankingOptions,
                    (results ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): FileSearch = apply {
            if (validated) {
                return@apply
            }

            rankingOptions().ifPresent { it.validate() }
            results().ifPresent { it.forEach { it.validate() } }
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
            (rankingOptions.asKnown().getOrNull()?.validity() ?: 0) +
                (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** The ranking options for the file search. */
        class RankingOptions
        private constructor(
            private val ranker: JsonField<Ranker>,
            private val scoreThreshold: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("ranker")
                @ExcludeMissing
                ranker: JsonField<Ranker> = JsonMissing.of(),
                @JsonProperty("score_threshold")
                @ExcludeMissing
                scoreThreshold: JsonField<Double> = JsonMissing.of(),
            ) : this(ranker, scoreThreshold, mutableMapOf())

            /**
             * The ranker to use for the file search. If not specified will use the `auto` ranker.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun ranker(): Ranker = ranker.getRequired("ranker")

            /**
             * The score threshold for the file search. All values must be a floating point number
             * between 0 and 1.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun scoreThreshold(): Double = scoreThreshold.getRequired("score_threshold")

            /**
             * Returns the raw JSON value of [ranker].
             *
             * Unlike [ranker], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ranker") @ExcludeMissing fun _ranker(): JsonField<Ranker> = ranker

            /**
             * Returns the raw JSON value of [scoreThreshold].
             *
             * Unlike [scoreThreshold], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("score_threshold")
            @ExcludeMissing
            fun _scoreThreshold(): JsonField<Double> = scoreThreshold

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
                 * Returns a mutable builder for constructing an instance of [RankingOptions].
                 *
                 * The following fields are required:
                 * ```java
                 * .ranker()
                 * .scoreThreshold()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RankingOptions]. */
            class Builder internal constructor() {

                private var ranker: JsonField<Ranker>? = null
                private var scoreThreshold: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(rankingOptions: RankingOptions) = apply {
                    ranker = rankingOptions.ranker
                    scoreThreshold = rankingOptions.scoreThreshold
                    additionalProperties = rankingOptions.additionalProperties.toMutableMap()
                }

                /**
                 * The ranker to use for the file search. If not specified will use the `auto`
                 * ranker.
                 */
                fun ranker(ranker: Ranker) = ranker(JsonField.of(ranker))

                /**
                 * Sets [Builder.ranker] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ranker] with a well-typed [Ranker] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun ranker(ranker: JsonField<Ranker>) = apply { this.ranker = ranker }

                /**
                 * The score threshold for the file search. All values must be a floating point
                 * number between 0 and 1.
                 */
                fun scoreThreshold(scoreThreshold: Double) =
                    scoreThreshold(JsonField.of(scoreThreshold))

                /**
                 * Sets [Builder.scoreThreshold] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.scoreThreshold] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun scoreThreshold(scoreThreshold: JsonField<Double>) = apply {
                    this.scoreThreshold = scoreThreshold
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAlladditional_properties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAlladditional_properties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [RankingOptions].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .ranker()
                 * .scoreThreshold()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RankingOptions =
                    RankingOptions(
                        checkRequired("ranker", ranker),
                        checkRequired("scoreThreshold", scoreThreshold),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): RankingOptions = apply {
                if (validated) {
                    return@apply
                }

                ranker().validate()
                scoreThreshold()
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
                (ranker.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (scoreThreshold.asKnown().isPresent) 1 else 0)

            /**
             * The ranker to use for the file search. If not specified will use the `auto` ranker.
             */
            class Ranker @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val AUTO = of("auto")

                    @JvmField val DEFAULT_2024_08_21 = of("default_2024_08_21")

                    @JvmStatic fun of(value: String) = Ranker(JsonField.of(value))
                }

                /** An enum containing [Ranker]'s known values. */
                enum class Known {
                    AUTO,
                    DEFAULT_2024_08_21,
                }

                /**
                 * An enum containing [Ranker]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Ranker] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    AUTO,
                    DEFAULT_2024_08_21,
                    /**
                     * An enum member indicating that [Ranker] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        DEFAULT_2024_08_21 -> Value.DEFAULT_2024_08_21
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        DEFAULT_2024_08_21 -> Known.DEFAULT_2024_08_21
                        else -> throw OpenAIInvalidDataException("Unknown Ranker: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Ranker = apply {
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

                    return other is Ranker && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RankingOptions &&
                    ranker == other.ranker &&
                    scoreThreshold == other.scoreThreshold &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(ranker, scoreThreshold, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RankingOptions{ranker=$ranker, scoreThreshold=$scoreThreshold, additionalProperties=$additionalProperties}"
        }

        /** A result instance of the file search. */
        class Result
        private constructor(
            private val fileId: JsonField<String>,
            private val fileName: JsonField<String>,
            private val score: JsonField<Double>,
            private val content: JsonField<List<Content>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("file_name")
                @ExcludeMissing
                fileName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<List<Content>> = JsonMissing.of(),
            ) : this(fileId, fileName, score, content, mutableMapOf())

            /**
             * The ID of the file that result was found in.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fileId(): String = fileId.getRequired("file_id")

            /**
             * The name of the file that result was found in.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fileName(): String = fileName.getRequired("file_name")

            /**
             * The score of the result. All values must be a floating point number between 0 and 1.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun score(): Double = score.getRequired("score")

            /**
             * The content of the result that was found. The content is only included if requested
             * via the include query parameter.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun content(): Optional<List<Content>> = content.getOptional("content")

            /**
             * Returns the raw JSON value of [fileId].
             *
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /**
             * Returns the raw JSON value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * Returns the raw JSON value of [score].
             *
             * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

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
                 * Returns a mutable builder for constructing an instance of [Result].
                 *
                 * The following fields are required:
                 * ```java
                 * .fileId()
                 * .fileName()
                 * .score()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Result]. */
            class Builder internal constructor() {

                private var fileId: JsonField<String>? = null
                private var fileName: JsonField<String>? = null
                private var score: JsonField<Double>? = null
                private var content: JsonField<MutableList<Content>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(result: Result) = apply {
                    fileId = result.fileId
                    fileName = result.fileName
                    score = result.score
                    content = result.content.map { it.toMutableList() }
                    additionalProperties = result.additionalProperties.toMutableMap()
                }

                /** The ID of the file that result was found in. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /**
                 * Sets [Builder.fileId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The name of the file that result was found in. */
                fun fileName(fileName: String) = fileName(JsonField.of(fileName))

                /**
                 * Sets [Builder.fileName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                /**
                 * The score of the result. All values must be a floating point number between 0
                 * and 1.
                 */
                fun score(score: Double) = score(JsonField.of(score))

                /**
                 * Sets [Builder.score] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.score] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun score(score: JsonField<Double>) = apply { this.score = score }

                /**
                 * The content of the result that was found. The content is only included if
                 * requested via the include query parameter.
                 */
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

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAlladditional_properties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAlladditional_properties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Result].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .fileId()
                 * .fileName()
                 * .score()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Result =
                    Result(
                        checkRequired("fileId", fileId),
                        checkRequired("fileName", fileName),
                        checkRequired("score", score),
                        (content ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Result = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                fileName()
                score()
                content().ifPresent { it.forEach { it.validate() } }
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
                (if (fileId.asKnown().isPresent) 1 else 0) +
                    (if (fileName.asKnown().isPresent) 1 else 0) +
                    (if (score.asKnown().isPresent) 1 else 0) +
                    (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            class Content
            private constructor(
                private val text: JsonField<String>,
                private val type: JsonField<Type>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                ) : this(text, type, mutableMapOf())

                /**
                 * The text content of the file.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun text(): Optional<String> = text.getOptional("text")

                /**
                 * The type of the content.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<Type> = type.getOptional("type")

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

                    /** Returns a mutable builder for constructing an instance of [Content]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Content]. */
                class Builder internal constructor() {

                    private var text: JsonField<String> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(content: Content) = apply {
                        text = content.text
                        type = content.type
                        additionalProperties = content.additionalProperties.toMutableMap()
                    }

                    /** The text content of the file. */
                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /** The type of the content. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAlladditional_properties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAlladditional_properties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Content].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Content = Content(text, type, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Content = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    type().ifPresent { it.validate() }
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
                    (if (text.asKnown().isPresent) 1 else 0) +
                        (type.asKnown().getOrNull()?.validity() ?: 0)

                /** The type of the content. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val TEXT = of("text")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        TEXT
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        TEXT,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            TEXT -> Value.TEXT
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            TEXT -> Known.TEXT
                            else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            OpenAIInvalidDataException("Value is not a String")
                        }

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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Content &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Result &&
                    fileId == other.fileId &&
                    fileName == other.fileName &&
                    score == other.score &&
                    content == other.content &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(fileId, fileName, score, content, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Result{fileId=$fileId, fileName=$fileName, score=$score, content=$content, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FileSearch &&
                rankingOptions == other.rankingOptions &&
                results == other.results &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(rankingOptions, results, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileSearch{rankingOptions=$rankingOptions, results=$results, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileSearchToolCall &&
            id == other.id &&
            fileSearch == other.fileSearch &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, fileSearch, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchToolCall{id=$id, fileSearch=$fileSearch, type=$type, additionalProperties=$additionalProperties}"
}
