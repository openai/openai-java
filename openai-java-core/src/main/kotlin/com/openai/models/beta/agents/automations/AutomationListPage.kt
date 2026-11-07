// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.AutomationService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see AutomationService.list */
class AutomationListPage
private constructor(
    private val service: AutomationService,
    private val params: AutomationListParams,
    private val response: AutomationListPageResponse,
) : Page<Automation> {

    /**
     * Delegates to [AutomationListPageResponse], but gracefully handles missing data.
     *
     * @see AutomationListPageResponse.data
     */
    fun data(): List<Automation> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AutomationListPageResponse], but gracefully handles missing data.
     *
     * @see AutomationListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Automation> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): AutomationListParams =
        params
            .toBuilder()
            .after(
                items()
                    .last()
                    .accept(
                        object : Automation.Visitor<Optional<String>> {
                            override fun visitPeriodic(
                                periodic: PeriodicAutomation
                            ): Optional<String> = periodic._id().getOptional("id")

                            override fun visitOnce(once: OneTimeAutomation): Optional<String> =
                                once._id().getOptional("id")
                        }
                    )
            )
            .build()

    override fun nextPage(): AutomationListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Automation> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AutomationListParams = params

    /** The response that this page was parsed from. */
    fun response(): AutomationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AutomationListPage].
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

    /** A builder for [AutomationListPage]. */
    class Builder internal constructor() {

        private var service: AutomationService? = null
        private var params: AutomationListParams? = null
        private var response: AutomationListPageResponse? = null

        @JvmSynthetic
        internal fun from(automationListPage: AutomationListPage) = apply {
            service = automationListPage.service
            params = automationListPage.params
            response = automationListPage.response
        }

        fun service(service: AutomationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AutomationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AutomationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AutomationListPage].
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
        fun build(): AutomationListPage =
            AutomationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "AutomationListPage{service=$service, params=$params, response=$response}"
}
