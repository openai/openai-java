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
import com.openai.services.async.FileServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

class FileListPageAsync
private constructor(
    private val filesService: FileServiceAsync,
    private val params: FileListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<FileObject> = response().data()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileListPageAsync && filesService == other.filesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(filesService, params, response) /* spotless:on */

    override fun toString() =
        "FileListPageAsync{filesService=$filesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<FileListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(FileListParams.builder().from(params).after(data().last().id()).build())
    }

    fun getNextPage(): CompletableFuture<Optional<FileListPageAsync>> {
        return getNextPageParams()
            .map { filesService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(filesService: FileServiceAsync, params: FileListParams, response: Response) =
            FileListPageAsync(
                filesService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val data: JsonField<List<FileObject>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun data(): List<FileObject> = data.getNullable("data") ?: listOf()

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<FileObject>>> = Optional.ofNullable(data)

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

            private var data: JsonField<List<FileObject>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<FileObject>) = data(JsonField.of(data))

            @JsonProperty("data")
            fun data(data: JsonField<List<FileObject>>) = apply { this.data = data }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, additionalProperties.toImmutable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: FileListPageAsync,
    ) {

        fun forEach(action: Predicate<FileObject>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<FileListPageAsync>>.forEach(
                action: (FileObject) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<FileObject>> {
            val values = mutableListOf<FileObject>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
