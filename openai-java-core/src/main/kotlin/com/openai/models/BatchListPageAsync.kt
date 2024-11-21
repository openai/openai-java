// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.services.async.BatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

class BatchListPageAsync
private constructor(
    private val batchesService: BatchServiceAsync,
    private val params: BatchListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<Batch> = response().data()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchListPageAsync && batchesService == other.batchesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(batchesService, params, response) /* spotless:on */

    override fun toString() =
        "BatchListPageAsync{batchesService=$batchesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<BatchListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(BatchListParams.builder().from(params).after(data().last().id()).build())
    }

    fun getNextPage(): CompletableFuture<Optional<BatchListPageAsync>> {
        return getNextPageParams()
            .map { batchesService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(batchesService: BatchServiceAsync, params: BatchListParams, response: Response) =
            BatchListPageAsync(
                batchesService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val data: JsonField<List<Batch>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun data(): List<Batch> = data.getNullable("data") ?: listOf()

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<Batch>>> = Optional.ofNullable(data)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                data().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, additionalProperties) /* spotless:on */

        override fun toString() = "Response{data=$data, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<Batch>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<Batch>) = data(JsonField.of(data))

            @JsonProperty("data")
            fun data(data: JsonField<List<Batch>>) = apply { this.data = data }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, additionalProperties.toImmutable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: BatchListPageAsync,
    ) {

        fun forEach(action: Predicate<Batch>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<BatchListPageAsync>>.forEach(
                action: (Batch) -> Boolean,
                executor: Executor
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.data().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Batch>> {
            val values = mutableListOf<Batch>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}