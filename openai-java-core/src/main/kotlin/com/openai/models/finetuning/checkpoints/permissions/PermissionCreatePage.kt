// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.JsonValue
import com.openai.services.blocking.finetuning.checkpoints.PermissionService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
 *
 * This enables organization owners to share fine-tuned models with other projects in their
 * organization.
 */
class PermissionCreatePage
private constructor(
    private val permissionsService: PermissionService,
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

        return /* spotless:off */ other is PermissionCreatePage && permissionsService == other.permissionsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(permissionsService, params, response) /* spotless:on */

    override fun toString() =
        "PermissionCreatePage{permissionsService=$permissionsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<PermissionCreateParams> = Optional.empty()

    fun getNextPage(): Optional<PermissionCreatePage> {
        return getNextPageParams().map { permissionsService.create(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            permissionsService: PermissionService,
            params: PermissionCreateParams,
            response: PermissionCreatePageResponse,
        ) = PermissionCreatePage(permissionsService, params, response)
    }

    class AutoPager(private val firstPage: PermissionCreatePage) :
        Iterable<PermissionCreateResponse> {

        override fun iterator(): Iterator<PermissionCreateResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<PermissionCreateResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
