// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.models

import com.openai.core.AutoPager
import com.openai.core.JsonValue
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.ModelService
import java.util.Objects

/** @see ModelService.list */
class ModelListPage
private constructor(
    private val service: ModelService,
    private val params: ModelListParams,
    private val response: ModelListPageResponse,
) : Page<Model> {

    /** @see ModelListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<Model> = data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see ModelListPageResponse.object_ */
    fun object_() = response.object_()

    fun object_OrThrow(): JsonValue =
        object_().orElseGet { response._object_().getRequired("object") }

    fun _object_() = response._object_()

    override fun items(): List<Model> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): ModelListParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): ModelListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Model> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ModelListParams = params

    /** The response that this page was parsed from. */
    fun response(): ModelListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ModelListPage].
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

    /** A builder for [ModelListPage]. */
    class Builder internal constructor() {

        private var service: ModelService? = null
        private var params: ModelListParams? = null
        private var response: ModelListPageResponse? = null

        @JvmSynthetic
        internal fun from(modelListPage: ModelListPage) = apply {
            service = modelListPage.service
            params = modelListPage.params
            response = modelListPage.response
        }

        fun service(service: ModelService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ModelListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ModelListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ModelListPage].
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
        fun build(): ModelListPage =
            ModelListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ModelListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "ModelListPage{service=$service, params=$params, response=$response}"
}
