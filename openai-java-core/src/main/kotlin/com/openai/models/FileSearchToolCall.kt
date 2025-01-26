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
class FileSearchToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("file_search")
    @ExcludeMissing
    private val fileSearch: JsonField<FileSearch> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The ID of the tool call object. */
    fun id(): String = id.getRequired("id")

    /** For now, this is always going to be an empty object. */
    fun fileSearch(): FileSearch = fileSearch.getRequired("file_search")

    /**
     * The type of tool call. This is always going to be `file_search` for this type of tool call.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The ID of the tool call object. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** For now, this is always going to be an empty object. */
    @JsonProperty("file_search")
    @ExcludeMissing
    fun _fileSearch(): JsonField<FileSearch> = fileSearch

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

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

        /** The ID of the tool call object. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** For now, this is always going to be an empty object. */
        fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

        /** For now, this is always going to be an empty object. */
        fun fileSearch(fileSearch: JsonField<FileSearch>) = apply { this.fileSearch = fileSearch }

        /**
         * The type of tool call. This is always going to be `file_search` for this type of tool
         * call.
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

        fun build(): FileSearchToolCall =
            FileSearchToolCall(
                checkRequired("id", id),
                checkRequired("fileSearch", fileSearch),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** For now, this is always going to be an empty object. */
    @NoAutoDetect
    class FileSearch
    @JsonCreator
    private constructor(
        @JsonProperty("ranking_options")
        @ExcludeMissing
        private val rankingOptions: JsonField<RankingOptions> = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        private val results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ranking options for the file search. */
        fun rankingOptions(): Optional<RankingOptions> =
            Optional.ofNullable(rankingOptions.getNullable("ranking_options"))

        /** The results of the file search. */
        fun results(): Optional<List<Result>> = Optional.ofNullable(results.getNullable("results"))

        /** The ranking options for the file search. */
        @JsonProperty("ranking_options")
        @ExcludeMissing
        fun _rankingOptions(): JsonField<RankingOptions> = rankingOptions

        /** The results of the file search. */
        @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FileSearch = apply {
            if (validated) {
                return@apply
            }

            rankingOptions().ifPresent { it.validate() }
            results().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

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

            /** The ranking options for the file search. */
            fun rankingOptions(rankingOptions: JsonField<RankingOptions>) = apply {
                this.rankingOptions = rankingOptions
            }

            /** The results of the file search. */
            fun results(results: List<Result>) = results(JsonField.of(results))

            /** The results of the file search. */
            fun results(results: JsonField<List<Result>>) = apply {
                this.results = results.map { it.toMutableList() }
            }

            /** The results of the file search. */
            fun addResult(result: Result) = apply {
                results =
                    (results ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(result)
                    }
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
                    rankingOptions,
                    (results ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        /** The ranking options for the file search. */
        @NoAutoDetect
        class RankingOptions
        @JsonCreator
        private constructor(
            @JsonProperty("ranker")
            @ExcludeMissing
            private val ranker: JsonValue = JsonMissing.of(),
            @JsonProperty("score_threshold")
            @ExcludeMissing
            private val scoreThreshold: JsonField<Double> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ranker used for the file search. */
            @JsonProperty("ranker") @ExcludeMissing fun _ranker(): JsonValue = ranker

            /**
             * The score threshold for the file search. All values must be a floating point number
             * between 0 and 1.
             */
            fun scoreThreshold(): Double = scoreThreshold.getRequired("score_threshold")

            /**
             * The score threshold for the file search. All values must be a floating point number
             * between 0 and 1.
             */
            @JsonProperty("score_threshold")
            @ExcludeMissing
            fun _scoreThreshold(): JsonField<Double> = scoreThreshold

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): RankingOptions = apply {
                if (validated) {
                    return@apply
                }

                _ranker().let {
                    if (it != JsonValue.from("default_2024_08_21")) {
                        throw OpenAIInvalidDataException("'ranker' is invalid, received $it")
                    }
                }
                scoreThreshold()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder internal constructor() {

                private var ranker: JsonValue = JsonValue.from("default_2024_08_21")
                private var scoreThreshold: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(rankingOptions: RankingOptions) = apply {
                    ranker = rankingOptions.ranker
                    scoreThreshold = rankingOptions.scoreThreshold
                    additionalProperties = rankingOptions.additionalProperties.toMutableMap()
                }

                /** The ranker used for the file search. */
                fun ranker(ranker: JsonValue) = apply { this.ranker = ranker }

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
                        ranker,
                        checkRequired("scoreThreshold", scoreThreshold),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is RankingOptions && ranker == other.ranker && scoreThreshold == other.scoreThreshold && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(ranker, scoreThreshold, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RankingOptions{ranker=$ranker, scoreThreshold=$scoreThreshold, additionalProperties=$additionalProperties}"
        }

        /** A result instance of the file search. */
        @NoAutoDetect
        class Result
        @JsonCreator
        private constructor(
            @JsonProperty("file_id")
            @ExcludeMissing
            private val fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_name")
            @ExcludeMissing
            private val fileName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("score")
            @ExcludeMissing
            private val score: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<List<Content>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ID of the file that result was found in. */
            fun fileId(): String = fileId.getRequired("file_id")

            /** The name of the file that result was found in. */
            fun fileName(): String = fileName.getRequired("file_name")

            /**
             * The score of the result. All values must be a floating point number between 0 and 1.
             */
            fun score(): Double = score.getRequired("score")

            /**
             * The content of the result that was found. The content is only included if requested
             * via the include query parameter.
             */
            fun content(): Optional<List<Content>> =
                Optional.ofNullable(content.getNullable("content"))

            /** The ID of the file that result was found in. */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /** The name of the file that result was found in. */
            @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * The score of the result. All values must be a floating point number between 0 and 1.
             */
            @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

            /**
             * The content of the result that was found. The content is only included if requested
             * via the include query parameter.
             */
            @JsonProperty("content")
            @ExcludeMissing
            fun _content(): JsonField<List<Content>> = content

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

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

                /** The ID of the file that result was found in. */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The name of the file that result was found in. */
                fun fileName(fileName: String) = fileName(JsonField.of(fileName))

                /** The name of the file that result was found in. */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                /**
                 * The score of the result. All values must be a floating point number between 0
                 * and 1.
                 */
                fun score(score: Double) = score(JsonField.of(score))

                /**
                 * The score of the result. All values must be a floating point number between 0
                 * and 1.
                 */
                fun score(score: JsonField<Double>) = apply { this.score = score }

                /**
                 * The content of the result that was found. The content is only included if
                 * requested via the include query parameter.
                 */
                fun content(content: List<Content>) = content(JsonField.of(content))

                /**
                 * The content of the result that was found. The content is only included if
                 * requested via the include query parameter.
                 */
                fun content(content: JsonField<List<Content>>) = apply {
                    this.content = content.map { it.toMutableList() }
                }

                /**
                 * The content of the result that was found. The content is only included if
                 * requested via the include query parameter.
                 */
                fun addContent(content: Content) = apply {
                    this.content =
                        (this.content ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(content)
                        }
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

                fun build(): Result =
                    Result(
                        checkRequired("fileId", fileId),
                        checkRequired("fileName", fileName),
                        checkRequired("score", score),
                        (content ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class Content
            @JsonCreator
            private constructor(
                @JsonProperty("text")
                @ExcludeMissing
                private val text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The text content of the file. */
                fun text(): Optional<String> = Optional.ofNullable(text.getNullable("text"))

                /** The type of the content. */
                fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

                /** The text content of the file. */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                /** The type of the content. */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Content = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    type()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

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

                    /** The text content of the file. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /** The type of the content. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** The type of the content. */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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

                    fun build(): Content =
                        Content(
                            text,
                            type,
                            additionalProperties.toImmutable(),
                        )
                }

                /** The type of the content. */
                class Type
                @JsonCreator
                private constructor(
                    private val value: JsonField<String>,
                ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val TEXT = of("text")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        TEXT,
                    }

                    enum class Value {
                        TEXT,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            TEXT -> Value.TEXT
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            TEXT -> Known.TEXT
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

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Content && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Result && fileId == other.fileId && fileName == other.fileName && score == other.score && content == other.content && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileId, fileName, score, content, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Result{fileId=$fileId, fileName=$fileName, score=$score, content=$content, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FileSearch && rankingOptions == other.rankingOptions && results == other.results && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(rankingOptions, results, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileSearch{rankingOptions=$rankingOptions, results=$results, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileSearchToolCall && id == other.id && fileSearch == other.fileSearch && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, fileSearch, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileSearchToolCall{id=$id, fileSearch=$fileSearch, type=$type, additionalProperties=$additionalProperties}"
}
