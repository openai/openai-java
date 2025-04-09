// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.services.blocking.beta.AssistantService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Returns a list of assistants. */
class AssistantListPage
private constructor(
    private val assistantsService: AssistantService,
    private val params: AssistantListParams,
    private val response: AssistantListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): AssistantListPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantListPage && assistantsService == other.assistantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(assistantsService, params, response) /* spotless:on */

    override fun toString() =
        "AssistantListPage{assistantsService=$assistantsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<AssistantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<AssistantListPage> {
        return getNextPageParams().map { assistantsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            assistantsService: AssistantService,
            params: AssistantListParams,
            response: AssistantListPageResponse,
        ) = AssistantListPage(assistantsService, params, response)
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
}
