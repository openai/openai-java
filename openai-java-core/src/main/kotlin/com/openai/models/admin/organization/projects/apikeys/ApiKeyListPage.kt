// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.apikeys

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.projects.ApiKeyService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see ApiKeyService.list */
class ApiKeyListPage
private constructor(
    private val service: ApiKeyService,
    private val params: ApiKeyListParams,
    private val response: ApiKeyListPageResponse,
) : Page<ProjectApiKey> {

    /** @see ApiKeyListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<ProjectApiKey> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see ApiKeyListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see ApiKeyListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<ProjectApiKey> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ApiKeyListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ApiKeyListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ProjectApiKey> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ApiKeyListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiKeyListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ApiKeyListPage].
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

    /** A builder for [ApiKeyListPage]. */
    class Builder internal constructor() {

        private var service: ApiKeyService? = null
        private var params: ApiKeyListParams? = null
        private var response: ApiKeyListPageResponse? = null

        @JvmSynthetic
        internal fun from(apiKeyListPage: ApiKeyListPage) = apply {
            service = apiKeyListPage.service
            params = apiKeyListPage.params
            response = apiKeyListPage.response
        }

        fun service(service: ApiKeyService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ApiKeyListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiKeyListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ApiKeyListPage].
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
        fun build(): ApiKeyListPage =
            ApiKeyListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiKeyListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "ApiKeyListPage{service=$service, params=$params, response=$response}"
}
