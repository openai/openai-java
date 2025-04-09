// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.checkRequired
import com.openai.services.blocking.beta.threads.runs.StepService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [StepService.list] */
class StepListPage
private constructor(
    private val service: StepService,
    private val params: StepListParams,
    private val response: StepListPageResponse,
) {

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see [StepListPageResponse.data]
     */
    fun data(): List<RunStep> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see [StepListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<StepListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<StepListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: StepListPage) : Iterable<RunStep> {

        override fun iterator(): Iterator<RunStep> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<RunStep> {
            return StreamSupport.stream(spliterator(), false)
        }
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
