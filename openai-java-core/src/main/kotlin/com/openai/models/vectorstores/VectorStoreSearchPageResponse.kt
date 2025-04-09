// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

class VectorStoreSearchPageResponse
private constructor(
    private val data: JsonField<List<VectorStoreSearchResponse>>,
    private val hasMore: JsonField<Boolean>,
    private val nextPage: JsonField<String>,
    private val object_: JsonValue,
    private val searchQuery: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        data: JsonField<List<VectorStoreSearchResponse>> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_page") @ExcludeMissing nextPage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("search_query")
        @ExcludeMissing
        searchQuery: JsonField<List<String>> = JsonMissing.of(),
    ) : this(data, hasMore, nextPage, object_, searchQuery, mutableMapOf())

    /**
     * The list of search result items.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<VectorStoreSearchResponse> = data.getRequired("data")

    /**
     * Indicates if there are more results to fetch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /**
     * The token for the next page, if any.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextPage(): Optional<String> = nextPage.getOptional("next_page")

    /**
     * The object type, which is always `vector_store.search_results.page`
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("vector_store.search_results.page")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun searchQuery(): List<String> = searchQuery.getRequired("search_query")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data")
    @ExcludeMissing
    fun _data(): JsonField<List<VectorStoreSearchResponse>> = data

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [nextPage].
     *
     * Unlike [nextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_page") @ExcludeMissing fun _nextPage(): JsonField<String> = nextPage

    /**
     * Returns the raw JSON value of [searchQuery].
     *
     * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("search_query")
    @ExcludeMissing
    fun _searchQuery(): JsonField<List<String>> = searchQuery

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
         * [VectorStoreSearchPageResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .hasMore()
         * .nextPage()
         * .searchQuery()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreSearchPageResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<VectorStoreSearchResponse>>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var nextPage: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("vector_store.search_results.page")
        private var searchQuery: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStoreSearchPageResponse: VectorStoreSearchPageResponse) = apply {
            data = vectorStoreSearchPageResponse.data.map { it.toMutableList() }
            hasMore = vectorStoreSearchPageResponse.hasMore
            nextPage = vectorStoreSearchPageResponse.nextPage
            object_ = vectorStoreSearchPageResponse.object_
            searchQuery = vectorStoreSearchPageResponse.searchQuery.map { it.toMutableList() }
            additionalProperties = vectorStoreSearchPageResponse.additionalProperties.toMutableMap()
        }

        /** The list of search result items. */
        fun data(data: List<VectorStoreSearchResponse>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed
         * `List<VectorStoreSearchResponse>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<List<VectorStoreSearchResponse>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [VectorStoreSearchResponse] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: VectorStoreSearchResponse) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** Indicates if there are more results to fetch. */
        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** The token for the next page, if any. */
        fun nextPage(nextPage: String?) = nextPage(JsonField.ofNullable(nextPage))

        /** Alias for calling [Builder.nextPage] with `nextPage.orElse(null)`. */
        fun nextPage(nextPage: Optional<String>) = nextPage(nextPage.getOrNull())

        /**
         * Sets [Builder.nextPage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextPage] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun nextPage(nextPage: JsonField<String>) = apply { this.nextPage = nextPage }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("vector_store.search_results.page")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        fun searchQuery(searchQuery: List<String>) = searchQuery(JsonField.of(searchQuery))

        /**
         * Sets [Builder.searchQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.searchQuery] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun searchQuery(searchQuery: JsonField<List<String>>) = apply {
            this.searchQuery = searchQuery.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [Builder.searchQuery].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSearchQuery(searchQuery: String) = apply {
            this.searchQuery =
                (this.searchQuery ?: JsonField.of(mutableListOf())).also {
                    checkKnown("searchQuery", it).add(searchQuery)
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

        /**
         * Returns an immutable instance of [VectorStoreSearchPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .hasMore()
         * .nextPage()
         * .searchQuery()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VectorStoreSearchPageResponse =
            VectorStoreSearchPageResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("hasMore", hasMore),
                checkRequired("nextPage", nextPage),
                object_,
                checkRequired("searchQuery", searchQuery).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): VectorStoreSearchPageResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        hasMore()
        nextPage()
        _object_().let {
            if (it != JsonValue.from("vector_store.search_results.page")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        searchQuery()
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
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextPage.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("vector_store.search_results.page")) 1 else 0 } +
            (searchQuery.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreSearchPageResponse && data == other.data && hasMore == other.hasMore && nextPage == other.nextPage && object_ == other.object_ && searchQuery == other.searchQuery && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, hasMore, nextPage, object_, searchQuery, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStoreSearchPageResponse{data=$data, hasMore=$hasMore, nextPage=$nextPage, object_=$object_, searchQuery=$searchQuery, additionalProperties=$additionalProperties}"
}
