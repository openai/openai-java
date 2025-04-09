// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.services.async.vectorstores.FileServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [FileServiceAsync.content] */
class FileContentPageAsync
private constructor(
    private val service: FileServiceAsync,
    private val params: FileContentParams,
    private val response: FileContentPageResponse,
) {

    /**
     * Delegates to [FileContentPageResponse], but gracefully handles missing data.
     *
     * @see [FileContentPageResponse.data]
     */
    fun data(): List<FileContentResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [FileContentPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileContentParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<FileContentPageAsync>> =
        getNextPageParams()
            .map { service.content(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): FileContentParams = params

    /** The response that this page was parsed from. */
    fun response(): FileContentPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileContentPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileContentPageAsync]. */
    class Builder internal constructor() {

        private var service: FileServiceAsync? = null
        private var params: FileContentParams? = null
        private var response: FileContentPageResponse? = null

        @JvmSynthetic
        internal fun from(fileContentPageAsync: FileContentPageAsync) = apply {
            service = fileContentPageAsync.service
            params = fileContentPageAsync.params
            response = fileContentPageAsync.response
        }

        fun service(service: FileServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FileContentParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileContentPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileContentPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileContentPageAsync =
            FileContentPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: FileContentPageAsync) {

        fun forEach(
            action: Predicate<FileContentResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<FileContentPageAsync>>.forEach(
                action: (FileContentResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<FileContentResponse>> {
            val values = mutableListOf<FileContentResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileContentPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FileContentPageAsync{service=$service, params=$params, response=$response}"
}
