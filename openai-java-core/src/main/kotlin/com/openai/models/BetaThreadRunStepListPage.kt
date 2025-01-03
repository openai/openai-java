// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.services.blocking.beta.threads.runs.StepService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

class BetaThreadRunStepListPage
private constructor(
    private val stepsService: StepService,
    private val params: BetaThreadRunStepListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<RunStep> = response().data()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadRunStepListPage && stepsService == other.stepsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(stepsService, params, response) /* spotless:on */

    override fun toString() =
        "BetaThreadRunStepListPage{stepsService=$stepsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<BetaThreadRunStepListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            BetaThreadRunStepListParams.builder().from(params).after(data().last().id()).build()
        )
    }

    fun getNextPage(): Optional<BetaThreadRunStepListPage> {
        return getNextPageParams().map { stepsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(stepsService: StepService, params: BetaThreadRunStepListParams, response: Response) =
            BetaThreadRunStepListPage(
                stepsService,
                params,
                response,
            )
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("data") private val data: JsonField<List<RunStep>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        private var validated: Boolean = false

        fun data(): List<RunStep> = data.getNullable("data") ?: listOf()

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<RunStep>>> = Optional.ofNullable(data)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                data().map { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, additionalProperties) /* spotless:on */

        override fun toString() = "Response{data=$data, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<RunStep>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<RunStep>) = data(JsonField.of(data))

            fun data(data: JsonField<List<RunStep>>) = apply { this.data = data }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, additionalProperties.toImmutable())
        }
    }

    class AutoPager
    constructor(
        private val firstPage: BetaThreadRunStepListPage,
    ) : Iterable<RunStep> {

        override fun iterator(): Iterator<RunStep> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().orElse(null) ?: break
                index = 0
            }
        }

        fun stream(): Stream<RunStep> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
