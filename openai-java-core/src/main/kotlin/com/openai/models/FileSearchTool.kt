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
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class FileSearchTool
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("file_search")
    @ExcludeMissing
    private val fileSearch: JsonField<FileSearch> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The type of tool being defined: `file_search` */
    fun type(): Type = type.getRequired("type")

    /** Overrides for the file search tool. */
    fun fileSearch(): Optional<FileSearch> =
        Optional.ofNullable(fileSearch.getNullable("file_search"))

    /** The type of tool being defined: `file_search` */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /** Overrides for the file search tool. */
    @JsonProperty("file_search")
    @ExcludeMissing
    fun _fileSearch(): JsonField<FileSearch> = fileSearch

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FileSearchTool = apply {
        if (validated) {
            return@apply
        }

        type()
        fileSearch().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type>? = null
        private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileSearchTool: FileSearchTool) = apply {
            type = fileSearchTool.type
            fileSearch = fileSearchTool.fileSearch
            additionalProperties = fileSearchTool.additionalProperties.toMutableMap()
        }

        /** The type of tool being defined: `file_search` */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of tool being defined: `file_search` */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** Overrides for the file search tool. */
        fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

        /** Overrides for the file search tool. */
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

        fun build(): FileSearchTool =
            FileSearchTool(
                checkRequired("type", type),
                fileSearch,
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

            @JvmField val FILE_SEARCH = of("file_search")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FILE_SEARCH,
        }

        enum class Value {
            FILE_SEARCH,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FILE_SEARCH -> Value.FILE_SEARCH
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FILE_SEARCH -> Known.FILE_SEARCH
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

    /** Overrides for the file search tool. */
    @NoAutoDetect
    class FileSearch
    @JsonCreator
    private constructor(
        @JsonProperty("max_num_results")
        @ExcludeMissing
        private val maxNumResults: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("ranking_options")
        @ExcludeMissing
        private val rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The maximum number of results the file search tool should output. The default is 20 for
         * `gpt-4*` models and 5 for `gpt-3.5-turbo`. This number should be between 1 and 50
         * inclusive.
         *
         * Note that the file search tool may output fewer than `max_num_results` results. See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun maxNumResults(): Optional<Long> =
            Optional.ofNullable(maxNumResults.getNullable("max_num_results"))

        /**
         * The ranking options for the file search. If not specified, the file search tool will use
         * the `auto` ranker and a score_threshold of 0.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        fun rankingOptions(): Optional<RankingOptions> =
            Optional.ofNullable(rankingOptions.getNullable("ranking_options"))

        /**
         * The maximum number of results the file search tool should output. The default is 20 for
         * `gpt-4*` models and 5 for `gpt-3.5-turbo`. This number should be between 1 and 50
         * inclusive.
         *
         * Note that the file search tool may output fewer than `max_num_results` results. See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        @JsonProperty("max_num_results")
        @ExcludeMissing
        fun _maxNumResults(): JsonField<Long> = maxNumResults

        /**
         * The ranking options for the file search. If not specified, the file search tool will use
         * the `auto` ranker and a score_threshold of 0.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        @JsonProperty("ranking_options")
        @ExcludeMissing
        fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FileSearch = apply {
            if (validated) {
                return@apply
            }

            maxNumResults()
            rankingOptions().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

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
             * The maximum number of results the file search tool should output. The default is 20
             * for `gpt-4*` models and 5 for `gpt-3.5-turbo`. This number should be between 1 and 50
             * inclusive.
             *
             * Note that the file search tool may output fewer than `max_num_results` results. See
             * the
             * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
             * for more information.
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
             * The ranking options for the file search. If not specified, the file search tool will
             * use the `auto` ranker and a score_threshold of 0.
             *
             * See the
             * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
             * for more information.
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

            fun build(): FileSearch =
                FileSearch(
                    maxNumResults,
                    rankingOptions,
                    additionalProperties.toImmutable(),
                )
        }

        /**
         * The ranking options for the file search. If not specified, the file search tool will use
         * the `auto` ranker and a score_threshold of 0.
         *
         * See the
         * [file search tool documentation](https://platform.openai.com/docs/assistants/tools/file-search#customizing-file-search-settings)
         * for more information.
         */
        @NoAutoDetect
        class RankingOptions
        @JsonCreator
        private constructor(
            @JsonProperty("score_threshold")
            @ExcludeMissing
            private val scoreThreshold: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("ranker")
            @ExcludeMissing
            private val ranker: JsonField<Ranker> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The score threshold for the file search. All values must be a floating point number
             * between 0 and 1.
             */
            fun scoreThreshold(): Double = scoreThreshold.getRequired("score_threshold")

            /**
             * The ranker to use for the file search. If not specified will use the `auto` ranker.
             */
            fun ranker(): Optional<Ranker> = Optional.ofNullable(ranker.getNullable("ranker"))

            /**
             * The score threshold for the file search. All values must be a floating point number
             * between 0 and 1.
             */
            @JsonProperty("score_threshold")
            @ExcludeMissing
            fun _scoreThreshold(): JsonField<Double> = scoreThreshold

            /**
             * The ranker to use for the file search. If not specified will use the `auto` ranker.
             */
            @JsonProperty("ranker") @ExcludeMissing fun _ranker(): JsonField<Ranker> = ranker

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): RankingOptions = apply {
                if (validated) {
                    return@apply
                }

                scoreThreshold()
                ranker()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

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
                 * The score threshold for the file search. All values must be a floating point
                 * number between 0 and 1.
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
                 * The ranker to use for the file search. If not specified will use the `auto`
                 * ranker.
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

                fun build(): RankingOptions =
                    RankingOptions(
                        checkRequired("scoreThreshold", scoreThreshold),
                        ranker,
                        additionalProperties.toImmutable(),
                    )
            }

            class Ranker
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val AUTO = of("auto")

                    @JvmField val DEFAULT_2024_08_21 = of("default_2024_08_21")

                    @JvmStatic fun of(value: String) = Ranker(JsonField.of(value))
                }

                enum class Known {
                    AUTO,
                    DEFAULT_2024_08_21,
                }

                enum class Value {
                    AUTO,
                    DEFAULT_2024_08_21,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        AUTO -> Value.AUTO
                        DEFAULT_2024_08_21 -> Value.DEFAULT_2024_08_21
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        AUTO -> Known.AUTO
                        DEFAULT_2024_08_21 -> Known.DEFAULT_2024_08_21
                        else -> throw OpenAIInvalidDataException("Unknown Ranker: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Ranker && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is RankingOptions && scoreThreshold == other.scoreThreshold && ranker == other.ranker && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(scoreThreshold, ranker, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RankingOptions{scoreThreshold=$scoreThreshold, ranker=$ranker, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FileSearch && maxNumResults == other.maxNumResults && rankingOptions == other.rankingOptions && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(maxNumResults, rankingOptions, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileSearch{maxNumResults=$maxNumResults, rankingOptions=$rankingOptions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileSearchTool && type == other.type && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, fileSearch, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchTool{type=$type, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
}
