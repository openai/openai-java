// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.agents.environments.TemplateServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see TemplateServiceAsync.list */
class TemplateListPageAsync
private constructor(
    private val service: TemplateServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: TemplateListParams,
    private val response: TemplateListPageResponse,
) : PageAsync<EnvironmentTemplate> {

    /**
     * Delegates to [TemplateListPageResponse], but gracefully handles missing data.
     *
     * @see TemplateListPageResponse.data
     */
    fun data(): List<EnvironmentTemplate> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [TemplateListPageResponse], but gracefully handles missing data.
     *
     * @see TemplateListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<EnvironmentTemplate> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): TemplateListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<TemplateListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<EnvironmentTemplate> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): TemplateListParams = params

    /** The response that this page was parsed from. */
    fun response(): TemplateListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TemplateListPageAsync].
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

    /** A builder for [TemplateListPageAsync]. */
    class Builder internal constructor() {

        private var service: TemplateServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: TemplateListParams? = null
        private var response: TemplateListPageResponse? = null

        @JvmSynthetic
        internal fun from(templateListPageAsync: TemplateListPageAsync) = apply {
            service = templateListPageAsync.service
            streamHandlerExecutor = templateListPageAsync.streamHandlerExecutor
            params = templateListPageAsync.params
            response = templateListPageAsync.response
        }

        fun service(service: TemplateServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: TemplateListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TemplateListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TemplateListPageAsync].
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
        fun build(): TemplateListPageAsync =
            TemplateListPageAsync(
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

        return other is TemplateListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "TemplateListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
