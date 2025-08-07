// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.threads.runs.StepService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see StepService.list */
@Deprecated("The Assistants API is deprecated in favor of the Responses API")
class StepListPage
private constructor(
    private val service: StepService,
    private val params: StepListParams,
    private val response: StepListPageResponse,
) : Page<RunStep> {

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see StepListPageResponse.data
     */
    fun data(): List<RunStep> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see StepListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<RunStep> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): StepListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): StepListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<RunStep> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): StepListParams = params

    /** The response that this page was parsed from. */
    fun response(): StepListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [StepListPage].
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

    /** A builder for [StepListPage]. */
    class Builder internal constructor() {

        private var service: StepService? = null
        private var params: StepListParams? = null
        private var response: StepListPageResponse? = null

        @JvmSynthetic
        internal fun from(stepListPage: StepListPage) = apply {
            service = stepListPage.service
            params = stepListPage.params
            response = stepListPage.response
        }

        fun service(service: StepService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: StepListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: StepListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [StepListPage].
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
        fun build(): StepListPage =
            StepListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StepListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "StepListPage{service=$service, params=$params, response=$response}"
}
