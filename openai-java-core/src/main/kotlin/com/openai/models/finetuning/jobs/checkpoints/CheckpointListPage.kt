// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.openai.services.blocking.finetuning.jobs.CheckpointService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List checkpoints for a fine-tuning job. */
class CheckpointListPage
private constructor(
    private val checkpointsService: CheckpointService,
    private val params: CheckpointListParams,
    private val response: CheckpointListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): CheckpointListPageResponse = response

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see [CheckpointListPageResponse.data]
     */
    fun data(): List<FineTuningJobCheckpoint> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see [CheckpointListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CheckpointListPage && checkpointsService == other.checkpointsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(checkpointsService, params, response) /* spotless:on */

    override fun toString() =
        "CheckpointListPage{checkpointsService=$checkpointsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<CheckpointListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<CheckpointListPage> {
        return getNextPageParams().map { checkpointsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            checkpointsService: CheckpointService,
            params: CheckpointListParams,
            response: CheckpointListPageResponse,
        ) = CheckpointListPage(checkpointsService, params, response)
    }

    class AutoPager(private val firstPage: CheckpointListPage) : Iterable<FineTuningJobCheckpoint> {

        override fun iterator(): Iterator<FineTuningJobCheckpoint> = iterator {
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

        fun stream(): Stream<FineTuningJobCheckpoint> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
