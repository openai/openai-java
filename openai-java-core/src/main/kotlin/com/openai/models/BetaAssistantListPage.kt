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
import com.openai.services.blocking.beta.AssistantService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

/** Returns a list of assistants. */
class BetaAssistantListPage
private constructor(
    private val assistantsService: AssistantService,
    private val params: BetaAssistantListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<Assistant> = response().data()

    fun hasMore(): Optional<Boolean> = response().hasMore()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaAssistantListPage && assistantsService == other.assistantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(assistantsService, params, response) /* spotless:on */

    override fun toString() =
        "BetaAssistantListPage{assistantsService=$assistantsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<BetaAssistantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            BetaAssistantListParams.builder().from(params).after(data().last().id()).build()
        )
    }

    fun getNextPage(): Optional<BetaAssistantListPage> {
        return getNextPageParams().map { assistantsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            assistantsService: AssistantService,
            params: BetaAssistantListParams,
            response: Response,
        ) = BetaAssistantListPage(assistantsService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("data") private val data: JsonField<List<Assistant>> = JsonMissing.of(),
        @JsonProperty("has_more") private val hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun data(): List<Assistant> = data.getNullable("data") ?: listOf()

        fun hasMore(): Optional<Boolean> = Optional.ofNullable(hasMore.getNullable("has_more"))

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<Assistant>>> = Optional.ofNullable(data)

        @JsonProperty("has_more")
        fun _hasMore(): Optional<JsonField<Boolean>> = Optional.ofNullable(hasMore)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            data().map { it.validate() }
            hasMore()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && hasMore == other.hasMore && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, hasMore, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{data=$data, hasMore=$hasMore, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<Assistant>> = JsonMissing.of()
            private var hasMore: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.hasMore = page.hasMore
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<Assistant>) = data(JsonField.of(data))

            fun data(data: JsonField<List<Assistant>>) = apply { this.data = data }

            fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

            fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, hasMore, additionalProperties.toImmutable())
        }
    }

    class AutoPager(private val firstPage: BetaAssistantListPage) : Iterable<Assistant> {

        override fun iterator(): Iterator<Assistant> = iterator {
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

        fun stream(): Stream<Assistant> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
