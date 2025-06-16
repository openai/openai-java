// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.finetuning.checkpoints.PermissionService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [PermissionService.retrieve] */
class PermissionRetrievePage
private constructor(
    private val service: PermissionService,
    private val params: PermissionRetrieveParams,
    private val response: PermissionRetrievePageResponse,
) : Page<PermissionRetrieveResponse> {

    /**
     * Delegates to [PermissionRetrievePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionRetrievePageResponse.data]
     */
    fun data(): List<PermissionRetrieveResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [PermissionRetrievePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionRetrievePageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<PermissionRetrieveResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): PermissionRetrieveParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): PermissionRetrievePage = service.retrieve(nextPageParams())

    fun autoPager(): AutoPager<PermissionRetrieveResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): PermissionRetrieveParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionRetrievePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionRetrievePage].
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

    /** A builder for [PermissionRetrievePage]. */
    class Builder internal constructor() {

        private var service: PermissionService? = null
        private var params: PermissionRetrieveParams? = null
        private var response: PermissionRetrievePageResponse? = null

        @JvmSynthetic
        internal fun from(permissionRetrievePage: PermissionRetrievePage) = apply {
            service = permissionRetrievePage.service
            params = permissionRetrievePage.params
            response = permissionRetrievePage.response
        }

        fun service(service: PermissionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionRetrieveParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionRetrievePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionRetrievePage].
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
        fun build(): PermissionRetrievePage =
            PermissionRetrievePage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PermissionRetrievePage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "PermissionRetrievePage{service=$service, params=$params, response=$response}"
}
