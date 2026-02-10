// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.SkillService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see SkillService.list */
class SkillListPage
private constructor(
    private val service: SkillService,
    private val params: SkillListParams,
    private val response: SkillList,
) : Page<Skill> {

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

    override fun nextPage(): SkillListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Skill> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SkillListParams = params

    /** The response that this page was parsed from. */
    fun response(): SkillList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SkillListPage].
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

    /** A builder for [SkillListPage]. */
    class Builder internal constructor() {

        private var service: SkillService? = null
        private var params: SkillListParams? = null
        private var response: SkillList? = null

        @JvmSynthetic
        internal fun from(skillListPage: SkillListPage) = apply {
            service = skillListPage.service
            params = skillListPage.params
            response = skillListPage.response
        }

        fun service(service: SkillService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SkillListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SkillList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SkillListPage].
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
        fun build(): SkillListPage =
            SkillListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SkillListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "SkillListPage{service=$service, params=$params, response=$response}"
}
