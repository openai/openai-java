// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.AutoPager
import com.openai.core.JsonValue
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.finetuning.checkpoints.PermissionService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see [PermissionService.create] */
class PermissionCreatePage
private constructor(
    private val service: PermissionService,
    private val params: PermissionCreateParams,
    private val response: PermissionCreatePageResponse,
) : Page<PermissionCreateResponse> {

    /**
     * Delegates to [PermissionCreatePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionCreatePageResponse.data]
     */
    fun data(): List<PermissionCreateResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [PermissionCreatePageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<PermissionCreateResponse> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): PermissionCreateParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): PermissionCreatePage = service.create(nextPageParams())

    fun autoPager(): AutoPager<PermissionCreateResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): PermissionCreateParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionCreatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionCreatePage].
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

    /** A builder for [PermissionCreatePage]. */
    class Builder internal constructor() {

        private var service: PermissionService? = null
        private var params: PermissionCreateParams? = null
        private var response: PermissionCreatePageResponse? = null

        @JvmSynthetic
        internal fun from(permissionCreatePage: PermissionCreatePage) = apply {
            service = permissionCreatePage.service
            params = permissionCreatePage.params
            response = permissionCreatePage.response
        }

        fun service(service: PermissionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionCreateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionCreatePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionCreatePage].
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
        fun build(): PermissionCreatePage =
            PermissionCreatePage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PermissionCreatePage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "PermissionCreatePage{service=$service, params=$params, response=$response}"
}
