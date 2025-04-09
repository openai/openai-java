// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.checkRequired
import com.openai.services.blocking.beta.AssistantService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [AssistantService.list] */
class AssistantListPage
private constructor(
    private val service: AssistantService,
    private val params: AssistantListParams,
    private val response: AssistantListPageResponse,
) {

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see [AssistantListPageResponse.data]
     */
    fun data(): List<Assistant> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see [AssistantListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<AssistantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<AssistantListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: AssistantListPage) : Iterable<Assistant> {

        override fun iterator(): Iterator<Assistant> = iterator {
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

        fun stream(): Stream<Assistant> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "AssistantListPage{service=$service, params=$params, response=$response}"
}
