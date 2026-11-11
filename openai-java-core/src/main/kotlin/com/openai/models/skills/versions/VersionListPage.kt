// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.skills.versions

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.skills.VersionService
import java.util.Objects

/** @see VersionService.list */
class VersionListPage
private constructor(
    private val service: VersionService,
    private val params: VersionListParams,
    private val response: SkillVersionList,
) : Page<SkillVersion> {

    /** @see SkillVersionList.data */
    fun data() = response.data()

    fun dataOrThrow(): List<SkillVersion> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see SkillVersionList.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<SkillVersion> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): VersionListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): VersionListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<SkillVersion> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): VersionListParams = params

    /** The response that this page was parsed from. */
    fun response(): SkillVersionList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VersionListPage].
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

    /** A builder for [VersionListPage]. */
    class Builder internal constructor() {

        private var service: VersionService? = null
        private var params: VersionListParams? = null
        private var response: SkillVersionList? = null

        @JvmSynthetic
        internal fun from(versionListPage: VersionListPage) = apply {
            service = versionListPage.service
            params = versionListPage.params
            response = versionListPage.response
        }

        fun service(service: VersionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VersionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SkillVersionList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VersionListPage].
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
        fun build(): VersionListPage =
            VersionListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VersionListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "VersionListPage{service=$service, params=$params, response=$response}"
}
