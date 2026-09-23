// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.VaultService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see VaultService.list */
class VaultListPage
private constructor(
    private val service: VaultService,
    private val params: VaultListParams,
    private val response: VaultListPageResponse,
) : Page<Vault> {

    /**
     * Delegates to [VaultListPageResponse], but gracefully handles missing data.
     *
     * @see VaultListPageResponse.data
     */
    fun data(): List<Vault> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VaultListPageResponse], but gracefully handles missing data.
     *
     * @see VaultListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Vault> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): VaultListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): VaultListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Vault> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): VaultListParams = params

    /** The response that this page was parsed from. */
    fun response(): VaultListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VaultListPage].
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

    /** A builder for [VaultListPage]. */
    class Builder internal constructor() {

        private var service: VaultService? = null
        private var params: VaultListParams? = null
        private var response: VaultListPageResponse? = null

        @JvmSynthetic
        internal fun from(vaultListPage: VaultListPage) = apply {
            service = vaultListPage.service
            params = vaultListPage.params
            response = vaultListPage.response
        }

        fun service(service: VaultService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VaultListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VaultListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VaultListPage].
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
        fun build(): VaultListPage =
            VaultListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VaultListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "VaultListPage{service=$service, params=$params, response=$response}"
}
