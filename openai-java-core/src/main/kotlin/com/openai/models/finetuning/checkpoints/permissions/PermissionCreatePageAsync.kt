// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.JsonValue
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/**
 * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
 *
 * This enables organization owners to share fine-tuned models with other projects in their
 * organization.
 */
class PermissionCreatePageAsync
private constructor(
    private val permissionsService: PermissionServiceAsync,
    private val params: PermissionCreateParams,
    private val response: PermissionCreatePageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): PermissionCreatePageResponse = response

    /**
     * Delegates to [PermissionCreatePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionCreatePageResponse.data]
     */
    fun data(): List<PermissionCreateResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [PermissionCreatePageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PermissionCreatePageAsync && permissionsService == other.permissionsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(permissionsService, params, response) /* spotless:on */

    override fun toString() =
        "PermissionCreatePageAsync{permissionsService=$permissionsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<PermissionCreateParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<PermissionCreatePageAsync>> {
        return getNextPageParams()
            .map { permissionsService.create(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            permissionsService: PermissionServiceAsync,
            params: PermissionCreateParams,
            response: PermissionCreatePageResponse,
        ) = PermissionCreatePageAsync(permissionsService, params, response)
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
}
