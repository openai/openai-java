// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.finetuning.jobs.CheckpointService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see CheckpointService.list */
class CheckpointListPage
private constructor(
    private val service: CheckpointService,
    private val params: CheckpointListParams,
    private val response: CheckpointListPageResponse,
) : Page<FineTuningJobCheckpoint> {

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see CheckpointListPageResponse.data
     */
    fun data(): List<FineTuningJobCheckpoint> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see CheckpointListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<FineTuningJobCheckpoint> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): CheckpointListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CheckpointListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<FineTuningJobCheckpoint> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CheckpointListParams = params

    /** The response that this page was parsed from. */
    fun response(): CheckpointListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckpointListPage].
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

    /** A builder for [CheckpointListPage]. */
    class Builder internal constructor() {

        private var service: CheckpointService? = null
        private var params: CheckpointListParams? = null
        private var response: CheckpointListPageResponse? = null

        @JvmSynthetic
        internal fun from(checkpointListPage: CheckpointListPage) = apply {
            service = checkpointListPage.service
            params = checkpointListPage.params
            response = checkpointListPage.response
        }

        fun service(service: CheckpointService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CheckpointListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CheckpointListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CheckpointListPage].
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
        fun build(): CheckpointListPage =
            CheckpointListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CheckpointListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "CheckpointListPage{service=$service, params=$params, response=$response}"
}
