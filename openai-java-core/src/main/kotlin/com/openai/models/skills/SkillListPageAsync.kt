// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.SkillServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see SkillServiceAsync.list */
class SkillListPageAsync
private constructor(
    private val service: SkillServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: SkillListParams,
    private val response: SkillList,
) : PageAsync<Skill> {

    /**
     * Delegates to [SkillList], but gracefully handles missing data.
     *
     * @see SkillList.data
     */
    fun data(): List<Skill> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [SkillList], but gracefully handles missing data.
     *
     * @see SkillList.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Skill> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): SkillListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<SkillListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Skill> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): SkillListParams = params

    /** The response that this page was parsed from. */
    fun response(): SkillList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SkillListPageAsync].
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

    /** A builder for [SkillListPageAsync]. */
    class Builder internal constructor() {

        private var service: SkillServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: SkillListParams? = null
        private var response: SkillList? = null

        @JvmSynthetic
        internal fun from(skillListPageAsync: SkillListPageAsync) = apply {
            service = skillListPageAsync.service
            streamHandlerExecutor = skillListPageAsync.streamHandlerExecutor
            params = skillListPageAsync.params
            response = skillListPageAsync.response
        }

        fun service(service: SkillServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: SkillListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SkillList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SkillListPageAsync].
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
        fun build(): SkillListPageAsync =
            SkillListPageAsync(
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

        return other is SkillListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "SkillListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
