// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import com.openai.services.blocking.finetuning.checkpoints.PermissionService
import java.util.Collections
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
 *
 * This enables organization owners to share fine-tuned models with other projects in their
 * organization.
 */
class PermissionCreatePage
private constructor(
    private val permissionsService: PermissionService,
    private val params: PermissionCreateParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<PermissionCreateResponse> = response().data()

    fun object_(): String = response().object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PermissionCreatePage && permissionsService == other.permissionsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(permissionsService, params, response) /* spotless:on */

    override fun toString() =
        "PermissionCreatePage{permissionsService=$permissionsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<PermissionCreateParams> {
        return Optional.empty()
    }

    fun getNextPage(): Optional<PermissionCreatePage> {
        return getNextPageParams().map { permissionsService.create(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            permissionsService: PermissionService,
            params: PermissionCreateParams,
            response: Response,
        ) = PermissionCreatePage(permissionsService, params, response)
    }

    class Response(
        private val data: JsonField<List<PermissionCreateResponse>>,
        private val object_: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data")
            data: JsonField<List<PermissionCreateResponse>> = JsonMissing.of(),
            @JsonProperty("object") object_: JsonField<String> = JsonMissing.of(),
        ) : this(data, object_, mutableMapOf())

        fun data(): List<PermissionCreateResponse> =
            data.getOptional("data").getOrNull() ?: listOf()

        fun object_(): String = object_.getRequired("object")

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<PermissionCreateResponse>>> = Optional.ofNullable(data)

        @JsonProperty("object")
        fun _object_(): Optional<JsonField<String>> = Optional.ofNullable(object_)

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            data().map { it.validate() }
            object_()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
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

            /** Returns a mutable builder for constructing an instance of [PermissionCreatePage]. */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<PermissionCreateResponse>> = JsonMissing.of()
            private var object_: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.object_ = page.object_
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<PermissionCreateResponse>) = data(JsonField.of(data))

            fun data(data: JsonField<List<PermissionCreateResponse>>) = apply { this.data = data }

            fun object_(object_: String) = object_(JsonField.of(object_))

            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response = Response(data, object_, additionalProperties.toMutableMap())
        }
    }

    class AutoPager(private val firstPage: PermissionCreatePage) :
        Iterable<PermissionCreateResponse> {

        override fun iterator(): Iterator<PermissionCreateResponse> = iterator {
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

        fun stream(): Stream<PermissionCreateResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
