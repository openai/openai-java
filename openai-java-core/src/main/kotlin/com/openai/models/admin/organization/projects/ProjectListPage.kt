// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.ProjectService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see ProjectService.list */
class ProjectListPage
private constructor(
    private val service: ProjectService,
    private val params: ProjectListParams,
    private val response: ProjectListPageResponse,
) : Page<Project> {

    /** @see ProjectListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<Project> = data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see ProjectListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see ProjectListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<Project> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ProjectListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ProjectListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Project> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ProjectListParams = params

    /** The response that this page was parsed from. */
    fun response(): ProjectListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectListPage].
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

    /** A builder for [ProjectListPage]. */
    class Builder internal constructor() {

        private var service: ProjectService? = null
        private var params: ProjectListParams? = null
        private var response: ProjectListPageResponse? = null

        @JvmSynthetic
        internal fun from(projectListPage: ProjectListPage) = apply {
            service = projectListPage.service
            params = projectListPage.params
            response = projectListPage.response
        }

        fun service(service: ProjectService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ProjectListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ProjectListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ProjectListPage].
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
        fun build(): ProjectListPage =
            ProjectListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ProjectListPage{service=$service, params=$params, response=$response}"
}
