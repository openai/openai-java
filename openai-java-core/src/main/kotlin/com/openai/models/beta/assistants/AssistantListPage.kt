// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.AssistantService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see AssistantService.list */
class AssistantListPage
private constructor(
    private val service: AssistantService,
    private val params: AssistantListParams,
    private val response: AssistantListPageResponse,
) : Page<Assistant> {

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see AssistantListPageResponse.data
     */
    fun data(): List<Assistant> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see AssistantListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Assistant> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AssistantListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): AssistantListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Assistant> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AssistantListParams = params

    /** The response that this page was parsed from. */
    fun response(): AssistantListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AssistantListPage].
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

    /** A builder for [AssistantListPage]. */
    class Builder internal constructor() {

        private var service: AssistantService? = null
        private var params: AssistantListParams? = null
        private var response: AssistantListPageResponse? = null

        @JvmSynthetic
        internal fun from(assistantListPage: AssistantListPage) = apply {
            service = assistantListPage.service
            params = assistantListPage.params
            response = assistantListPage.response
        }

        fun service(service: AssistantService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AssistantListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AssistantListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AssistantListPage].
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
        fun build(): AssistantListPage =
            AssistantListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AssistantListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "AssistantListPage{service=$service, params=$params, response=$response}"
}
