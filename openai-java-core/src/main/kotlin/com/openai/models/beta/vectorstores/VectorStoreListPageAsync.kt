// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.services.async.beta.VectorStoreServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

/** Returns a list of vector stores. */
class VectorStoreListPageAsync
private constructor(
    private val vectorStoresService: VectorStoreServiceAsync,
    private val params: VectorStoreListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<VectorStore> = response().data()

    fun hasMore(): Optional<Boolean> = response().hasMore()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreListPageAsync && vectorStoresService == other.vectorStoresService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoresService, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreListPageAsync{vectorStoresService=$vectorStoresService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<VectorStoreListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            VectorStoreListParams.builder().from(params).after(data().last().id()).build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<VectorStoreListPageAsync>> {
        return getNextPageParams()
            .map { vectorStoresService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            vectorStoresService: VectorStoreServiceAsync,
            params: VectorStoreListParams,
            response: Response,
        ) = VectorStoreListPageAsync(vectorStoresService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("data") private val data: JsonField<List<VectorStore>> = JsonMissing.of(),
        @JsonProperty("has_more") private val hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun data(): List<VectorStore> = data.getNullable("data") ?: listOf()

        fun hasMore(): Optional<Boolean> = Optional.ofNullable(hasMore.getNullable("has_more"))

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<VectorStore>>> = Optional.ofNullable(data)

        @JsonProperty("has_more")
        fun _hasMore(): Optional<JsonField<Boolean>> = Optional.ofNullable(hasMore)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            data().map { it.validate() }
            hasMore()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && hasMore == other.hasMore && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, hasMore, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{data=$data, hasMore=$hasMore, additionalProperties=$additionalProperties}"

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [VectorStoreListPageAsync].
             */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<VectorStore>> = JsonMissing.of()
            private var hasMore: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.hasMore = page.hasMore
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<VectorStore>) = data(JsonField.of(data))

            fun data(data: JsonField<List<VectorStore>>) = apply { this.data = data }

            fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

            fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, hasMore, additionalProperties.toImmutable())
        }
    }

    class AutoPager(private val firstPage: VectorStoreListPageAsync) {

        fun forEach(action: Predicate<VectorStore>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<VectorStoreListPageAsync>>.forEach(
                action: (VectorStore) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.data().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<VectorStore>> {
            val values = mutableListOf<VectorStore>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
