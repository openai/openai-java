// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.sessions.ArtifactService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ArtifactService.list */
class ArtifactListPage
private constructor(
    private val service: ArtifactService,
    private val params: ArtifactListParams,
    private val response: ArtifactListPageResponse,
) : Page<SessionArtifact> {

    /**
     * Delegates to [ArtifactListPageResponse], but gracefully handles missing data.
     *
     * @see ArtifactListPageResponse.data
     */
    fun data(): List<SessionArtifact> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ArtifactListPageResponse], but gracefully handles missing data.
     *
     * @see ArtifactListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<SessionArtifact> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ArtifactListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): ArtifactListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<SessionArtifact> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ArtifactListParams = params

    /** The response that this page was parsed from. */
    fun response(): ArtifactListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ArtifactListPage].
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

    /** A builder for [ArtifactListPage]. */
    class Builder internal constructor() {

        private var service: ArtifactService? = null
        private var params: ArtifactListParams? = null
        private var response: ArtifactListPageResponse? = null

        @JvmSynthetic
        internal fun from(artifactListPage: ArtifactListPage) = apply {
            service = artifactListPage.service
            params = artifactListPage.params
            response = artifactListPage.response
        }

        fun service(service: ArtifactService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ArtifactListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ArtifactListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ArtifactListPage].
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
        fun build(): ArtifactListPage =
            ArtifactListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ArtifactListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ArtifactListPage{service=$service, params=$params, response=$response}"
}
