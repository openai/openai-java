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
import com.openai.services.blocking.ModelService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

/**
 * Lists the currently available models, and provides basic information about each one such as the
 * owner and availability.
 */
class ModelListPage
private constructor(
    private val modelsService: ModelService,
    private val params: ModelListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<Model> = response().data()

    fun object_(): String = response().object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelListPage && modelsService == other.modelsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(modelsService, params, response) /* spotless:on */

    override fun toString() =
        "ModelListPage{modelsService=$modelsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<ModelListParams> {
        return Optional.empty()
    }

    fun getNextPage(): Optional<ModelListPage> {
        return getNextPageParams().map { modelsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(modelsService: ModelService, params: ModelListParams, response: Response) =
            ModelListPage(modelsService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("data") private val data: JsonField<List<Model>> = JsonMissing.of(),
        @JsonProperty("object") private val object_: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun data(): List<Model> = data.getNullable("data") ?: listOf()

        fun object_(): String = object_.getRequired("object")

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<Model>>> = Optional.ofNullable(data)

        @JsonProperty("object")
        fun _object_(): Optional<JsonField<String>> = Optional.ofNullable(object_)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            data().map { it.validate() }
            object_()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, object_, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{data=$data, object_=$object_, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<Model>> = JsonMissing.of()
            private var object_: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.object_ = page.object_
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<Model>) = data(JsonField.of(data))

            fun data(data: JsonField<List<Model>>) = apply { this.data = data }

            fun object_(object_: String) = object_(JsonField.of(object_))

            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(data, object_, additionalProperties.toImmutable())
        }
    }

    class AutoPager(private val firstPage: ModelListPage) : Iterable<Model> {

        override fun iterator(): Iterator<Model> = iterator {
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

        fun stream(): Stream<Model> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
