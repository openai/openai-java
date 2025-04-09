// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import com.openai.core.JsonValue
import com.openai.services.blocking.ModelService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * Lists the currently available models, and provides basic information about each one such as the
 * owner and availability.
 */
class ModelListPage
private constructor(
    private val modelsService: ModelService,
    private val params: ModelListParams,
    private val response: ModelListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ModelListPageResponse = response

    /**
     * Delegates to [ModelListPageResponse], but gracefully handles missing data.
     *
     * @see [ModelListPageResponse.data]
     */
    fun data(): List<Model> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [ModelListPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelListPage && modelsService == other.modelsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(modelsService, params, response) /* spotless:on */

    override fun toString() =
        "ModelListPage{modelsService=$modelsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<ModelListParams> = Optional.empty()

    fun getNextPage(): Optional<ModelListPage> {
        return getNextPageParams().map { modelsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            modelsService: ModelService,
            params: ModelListParams,
            response: ModelListPageResponse,
        ) = ModelListPage(modelsService, params, response)
    }

    class AutoPager(private val firstPage: ModelListPage) : Iterable<Model> {

        override fun iterator(): Iterator<Model> = iterator {
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

        fun stream(): Stream<Model> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
