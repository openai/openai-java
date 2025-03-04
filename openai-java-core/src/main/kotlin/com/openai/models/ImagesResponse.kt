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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects

@NoAutoDetect
class ImagesResponse
@JsonCreator
private constructor(
    @JsonProperty("created")
    @ExcludeMissing
    private val created: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("data")
    @ExcludeMissing
    private val data: JsonField<List<Image>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun created(): Long = created.getRequired("created")

    fun data(): List<Image> = data.getRequired("data")

    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<Long> = created

    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Image>> = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ImagesResponse = apply {
        if (validated) {
            return@apply
        }

        created()
        data().forEach { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImagesResponse]. */
    class Builder internal constructor() {

        private var created: JsonField<Long>? = null
        private var data: JsonField<MutableList<Image>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imagesResponse: ImagesResponse) = apply {
            created = imagesResponse.created
            data = imagesResponse.data.map { it.toMutableList() }
            additionalProperties = imagesResponse.additionalProperties.toMutableMap()
        }

        fun created(created: Long) = created(JsonField.of(created))

        fun created(created: JsonField<Long>) = apply { this.created = created }

        fun data(data: List<Image>) = data(JsonField.of(data))

        fun data(data: JsonField<List<Image>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        fun addData(data: Image) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): ImagesResponse =
            ImagesResponse(
                checkRequired("created", created),
                checkRequired("data", data).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImagesResponse && created == other.created && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(created, data, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImagesResponse{created=$created, data=$data, additionalProperties=$additionalProperties}"
}
