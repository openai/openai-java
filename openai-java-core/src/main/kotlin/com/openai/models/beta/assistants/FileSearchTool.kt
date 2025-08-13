// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class FileSearchTool
private constructor(
    private val type: JsonValue,
    private val fileSearch: JsonField<FileSearch>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("file_search")
        @ExcludeMissing
        fileSearch: JsonField<FileSearch> = JsonMissing.of(),
    ) : this(type, fileSearch, mutableMapOf())

    /**
     * The type of tool being defined: `file_search`
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
     * Overrides for the file search tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileSearch(): Optional<FileSearch> = fileSearch.getOptional("file_search")

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

        /** Returns a mutable builder for constructing an instance of [FileSearchTool]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileSearchTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("file_search")
        private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileSearchTool: FileSearchTool) = apply {
            type = fileSearchTool.type
            fileSearch = fileSearchTool.fileSearch
            additionalProperties = fileSearchTool.additionalProperties.toMutableMap()
        }

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

        /** Overrides for the file search tool. */
        fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

        /**
         * Sets [Builder.fileSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fileSearch(fileSearch: JsonField<FileSearch>) = apply { this.fileSearch = fileSearch }

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
         * Returns an immutable instance of [FileSearchTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileSearchTool =
            FileSearchTool(type, fileSearch, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): FileSearchTool = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("file_search")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        fileSearch().ifPresent { it.validate() }
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
        type.let { if (it == JsonValue.from("file_search")) 1 else 0 } +
            (fileSearch.asKnown().getOrNull()?.validity() ?: 0)

    /** Overrides for the file search tool. */
    class FileSearch
    private constructor(
        private val maxNumResults: JsonField<Long>,
        private val rankingOptions: JsonField<RankingOptions>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("max_num_results")
            @ExcludeMissing
            maxNumResults: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("ranking_options")
            @ExcludeMissing
            rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
        ) : this(maxNumResults, rankingOptions, mutableMapOf())

        /**
         * The maximum number of results the file search tool should output. The default is 20 for
         * `gpt-4*` models and 5 for `gpt-3.5-turbo`. This number should be between 1 and 50
         * inclusive.
         *
         * Note that the file search tool may output fewer than `max_num_results` results. See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxNumResults(): Optional<Long> = maxNumResults.getOptional("max_num_results")

        /**
         * The ranking options for the file search. If not specified, the file search tool will use
         * the `auto` ranker and a score_threshold of 0.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rankingOptions(): Optional<RankingOptions> =
            rankingOptions.getOptional("ranking_options")

        /**
         * Returns the raw JSON value of [maxNumResults].
         *
         * Unlike [maxNumResults], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("max_num_results")
        @ExcludeMissing
        fun _maxNumResults(): JsonField<Long> = maxNumResults

        /**
         * Returns the raw JSON value of [rankingOptions].
         *
         * Unlike [rankingOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("ranking_options")
        @ExcludeMissing
        fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

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

            private var maxNumResults: JsonField<Long> = JsonMissing.of()
            private var rankingOptions: JsonField<RankingOptions> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileSearch: FileSearch) = apply {
                maxNumResults = fileSearch.maxNumResults
                rankingOptions = fileSearch.rankingOptions
                additionalProperties = fileSearch.additionalProperties.toMutableMap()
            }

            /**
             * The maximum number of results the file search tool should output. The default is 20
             * for `gpt-4*` models and 5 for `gpt-3.5-turbo`. This number should be between 1 and 50
             * inclusive.
             *
             * Note that the file search tool may output fewer than `max_num_results` results. See
             * the
             * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
             * for more information.
             */
            fun maxNumResults(maxNumResults: Long) = maxNumResults(JsonField.of(maxNumResults))

            /**
             * Sets [Builder.maxNumResults] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxNumResults] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxNumResults(maxNumResults: JsonField<Long>) = apply {
                this.maxNumResults = maxNumResults
            }

            /**
             * The ranking options for the file search. If not specified, the file search tool will
             * use the `auto` ranker and a score_threshold of 0.
             *
             * See the
             * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
             * for more information.
             */
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
             * Returns an immutable instance of [FileSearch].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): FileSearch =
                FileSearch(maxNumResults, rankingOptions, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): FileSearch = apply {
            if (validated) {
                return@apply
            }

            maxNumResults()
            rankingOptions().ifPresent { it.validate() }
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
            (if (maxNumResults.asKnown().isPresent) 1 else 0) +
                (rankingOptions.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * The ranking options for the file search. If not specified, the file search tool will use
         * the `auto` ranker and a score_threshold of 0.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        class RankingOptions
        private constructor(
            private val scoreThreshold: JsonField<Double>,
            private val ranker: JsonField<Ranker>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("score_threshold")
                @ExcludeMissing
                scoreThreshold: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("ranker") @ExcludeMissing ranker: JsonField<Ranker> = JsonMissing.of(),
            ) : this(scoreThreshold, ranker, mutableMapOf())

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
             * The ranker to use for the file search. If not specified will use the `auto` ranker.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun ranker(): Optional<Ranker> = ranker.getOptional("ranker")

            /**
             * Returns the raw JSON value of [scoreThreshold].
             *
             * Unlike [scoreThreshold], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("score_threshold")
            @ExcludeMissing
            fun _scoreThreshold(): JsonField<Double> = scoreThreshold

            /**
             * Returns the raw JSON value of [ranker].
             *
             * Unlike [ranker], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ranker") @ExcludeMissing fun _ranker(): JsonField<Ranker> = ranker

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
                 * .scoreThreshold()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RankingOptions]. */
            class Builder internal constructor() {

                private var scoreThreshold: JsonField<Double>? = null
                private var ranker: JsonField<Ranker> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(rankingOptions: RankingOptions) = apply {
                    scoreThreshold = rankingOptions.scoreThreshold
                    ranker = rankingOptions.ranker
                    additionalProperties = rankingOptions.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [RankingOptions].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .scoreThreshold()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RankingOptions =
                    RankingOptions(
                        checkRequired("scoreThreshold", scoreThreshold),
                        ranker,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): RankingOptions = apply {
                if (validated) {
                    return@apply
                }

                scoreThreshold()
                ranker().ifPresent { it.validate() }
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
                (if (scoreThreshold.asKnown().isPresent) 1 else 0) +
                    (ranker.asKnown().getOrNull()?.validity() ?: 0)

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
                    scoreThreshold == other.scoreThreshold &&
                    ranker == other.ranker &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(scoreThreshold, ranker, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RankingOptions{scoreThreshold=$scoreThreshold, ranker=$ranker, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FileSearch &&
                maxNumResults == other.maxNumResults &&
                rankingOptions == other.rankingOptions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(maxNumResults, rankingOptions, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileSearch{maxNumResults=$maxNumResults, rankingOptions=$rankingOptions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileSearchTool &&
            type == other.type &&
            fileSearch == other.fileSearch &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, fileSearch, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchTool{type=$type, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
}
