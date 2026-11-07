// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.agents.AutomationServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see AutomationServiceAsync.list */
class AutomationListPageAsync
private constructor(
    private val service: AutomationServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: AutomationListParams,
    private val response: AutomationListPageResponse,
) : PageAsync<Automation> {

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

    override fun nextPage(): CompletableFuture<AutomationListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Automation> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): AutomationListParams = params

    /** The response that this page was parsed from. */
    fun response(): AutomationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AutomationListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutomationListPageAsync]. */
    class Builder internal constructor() {

        private var service: AutomationServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: AutomationListParams? = null
        private var response: AutomationListPageResponse? = null

        @JvmSynthetic
        internal fun from(automationListPageAsync: AutomationListPageAsync) = apply {
            service = automationListPageAsync.service
            streamHandlerExecutor = automationListPageAsync.streamHandlerExecutor
            params = automationListPageAsync.params
            response = automationListPageAsync.response
        }

        fun service(service: AutomationServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: AutomationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AutomationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AutomationListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AutomationListPageAsync =
            AutomationListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "AutomationListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
