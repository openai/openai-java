// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [PermissionServiceAsync.create] */
class PermissionCreatePageAsync
private constructor(
    private val service: PermissionServiceAsync,
    private val params: PermissionCreateParams,
    private val response: PermissionCreatePageResponse,
) {

    /**
     * Delegates to [PermissionCreatePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionCreatePageResponse.data]
     */
    fun data(): List<PermissionCreateResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [PermissionCreatePageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<PermissionCreateParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<PermissionCreatePageAsync>> =
        getNextPageParams()
            .map { service.create(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): PermissionCreateParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionCreatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionCreatePageAsync].
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

    /** A builder for [PermissionCreatePageAsync]. */
    class Builder internal constructor() {

        private var service: PermissionServiceAsync? = null
        private var params: PermissionCreateParams? = null
        private var response: PermissionCreatePageResponse? = null

        @JvmSynthetic
        internal fun from(permissionCreatePageAsync: PermissionCreatePageAsync) = apply {
            service = permissionCreatePageAsync.service
            params = permissionCreatePageAsync.params
            response = permissionCreatePageAsync.response
        }

        fun service(service: PermissionServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionCreateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionCreatePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionCreatePageAsync].
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
        fun build(): PermissionCreatePageAsync =
            PermissionCreatePageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: PermissionCreatePageAsync) {

        fun forEach(
            action: Predicate<PermissionCreateResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<PermissionCreatePageAsync>>.forEach(
                action: (PermissionCreateResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<PermissionCreateResponse>> {
            val values = mutableListOf<PermissionCreateResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PermissionCreatePageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "PermissionCreatePageAsync{service=$service, params=$params, response=$response}"
}
