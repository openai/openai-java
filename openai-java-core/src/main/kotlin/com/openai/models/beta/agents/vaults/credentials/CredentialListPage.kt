// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.vaults.CredentialService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see CredentialService.list */
class CredentialListPage
private constructor(
    private val service: CredentialService,
    private val params: CredentialListParams,
    private val response: CredentialListPageResponse,
) : Page<Credential> {

    /**
     * Delegates to [CredentialListPageResponse], but gracefully handles missing data.
     *
     * @see CredentialListPageResponse.data
     */
    fun data(): List<Credential> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CredentialListPageResponse], but gracefully handles missing data.
     *
     * @see CredentialListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Credential> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): CredentialListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CredentialListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Credential> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CredentialListParams = params

    /** The response that this page was parsed from. */
    fun response(): CredentialListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CredentialListPage].
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

    /** A builder for [CredentialListPage]. */
    class Builder internal constructor() {

        private var service: CredentialService? = null
        private var params: CredentialListParams? = null
        private var response: CredentialListPageResponse? = null

        @JvmSynthetic
        internal fun from(credentialListPage: CredentialListPage) = apply {
            service = credentialListPage.service
            params = credentialListPage.params
            response = credentialListPage.response
        }

        fun service(service: CredentialService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CredentialListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CredentialListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CredentialListPage].
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
        fun build(): CredentialListPage =
            CredentialListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CredentialListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CredentialListPage{service=$service, params=$params, response=$response}"
}
