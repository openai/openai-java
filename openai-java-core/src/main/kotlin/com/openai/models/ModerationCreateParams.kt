// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.*
import java.util.Objects
import java.util.Optional

class ModerationCreateParams
constructor(
    private val input: Input,
    private val model: Model?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun input(): Input = input

    fun model(): Optional<Model> = Optional.ofNullable(model)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    @JvmSynthetic
    internal fun getBody(): ModerationCreateBody {
        return ModerationCreateBody(
            input,
            model,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(builder = ModerationCreateBody.Builder::class)
    @NoAutoDetect
    class ModerationCreateBody
    internal constructor(
        private val input: Input?,
        private val model: Model?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        @JsonProperty("input") fun input(): Input? = input

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        @JsonProperty("model") fun model(): Model? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var input: Input? = null
            private var model: Model? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(moderationCreateBody: ModerationCreateBody) = apply {
                this.input = moderationCreateBody.input
                this.model = moderationCreateBody.model
                additionalProperties(moderationCreateBody.additionalProperties)
            }

            /**
             * Input (or inputs) to classify. Can be a single string, an array of strings, or an
             * array of multi-modal input objects similar to other models.
             */
            @JsonProperty("input") fun input(input: Input) = apply { this.input = input }

            /**
             * The content moderation model you would like to use. Learn more in
             * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
             * about available models [here](https://platform.openai.com/docs/models#moderation).
             */
            @JsonProperty("model") fun model(model: Model) = apply { this.model = model }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): ModerationCreateBody =
                ModerationCreateBody(
                    checkNotNull(input) { "`input` is required but was not set" },
                    model,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ModerationCreateBody && input == other.input && model == other.model && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(input, model, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ModerationCreateBody{input=$input, model=$model, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var input: Input? = null
        private var model: Model? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderationCreateParams: ModerationCreateParams) = apply {
            input = moderationCreateParams.input
            model = moderationCreateParams.model
            additionalHeaders = moderationCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = moderationCreateParams.additionalQueryParams.toBuilder()
            additionalBodyProperties =
                moderationCreateParams.additionalBodyProperties.toMutableMap()
        }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(input: Input) = apply { this.input = input }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(string: String) = apply { this.input = Input.ofString(string) }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun inputOfStrings(strings: List<String>) = apply { this.input = Input.ofStrings(strings) }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun inputOfModerationMultiModalArray(
            moderationMultiModalArray: List<ModerationMultiModalInput>
        ) = apply { this.input = Input.ofModerationMultiModalArray(moderationMultiModalArray) }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        fun model(model: Model) = apply { this.model = model }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        fun model(value: String) = apply { this.model = Model.of(value) }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): ModerationCreateParams =
            ModerationCreateParams(
                checkNotNull(input) { "`input` is required but was not set" },
                model,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }

    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val moderationMultiModalArray: List<ModerationMultiModalInput>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** A string of text to classify for moderation. */
        fun string(): Optional<String> = Optional.ofNullable(string)
        /** An array of strings to classify for moderation. */
        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)
        /** An array of multi-modal inputs to the moderation model. */
        fun moderationMultiModalArray(): Optional<List<ModerationMultiModalInput>> =
            Optional.ofNullable(moderationMultiModalArray)

        fun isString(): Boolean = string != null

        fun isStrings(): Boolean = strings != null

        fun isModerationMultiModalArray(): Boolean = moderationMultiModalArray != null

        fun asString(): String = string.getOrThrow("string")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun asModerationMultiModalArray(): List<ModerationMultiModalInput> =
            moderationMultiModalArray.getOrThrow("moderationMultiModalArray")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                moderationMultiModalArray != null ->
                    visitor.visitModerationMultiModalArray(moderationMultiModalArray)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Input = apply {
            if (!validated) {
                if (string == null && strings == null && moderationMultiModalArray == null) {
                    throw OpenAIInvalidDataException("Unknown Input: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Input && string == other.string && strings == other.strings && moderationMultiModalArray == other.moderationMultiModalArray /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, strings, moderationMultiModalArray) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                strings != null -> "Input{strings=$strings}"
                moderationMultiModalArray != null ->
                    "Input{moderationMultiModalArray=$moderationMultiModalArray}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            @JvmStatic fun ofStrings(strings: List<String>) = Input(strings = strings)

            @JvmStatic
            fun ofModerationMultiModalArray(
                moderationMultiModalArray: List<ModerationMultiModalInput>
            ) = Input(moderationMultiModalArray = moderationMultiModalArray)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun visitModerationMultiModalArray(
                moderationMultiModalArray: List<ModerationMultiModalInput>
            ): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Input(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Input(strings = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ModerationMultiModalInput>>())?.let {
                    return Input(moderationMultiModalArray = it, _json = json)
                }

                return Input(_json = json)
            }
        }

        class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value.moderationMultiModalArray != null ->
                        generator.writeObject(value.moderationMultiModalArray)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    class Model
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Model && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val OMNI_MODERATION_LATEST = Model(JsonField.of("omni-moderation-latest"))

            @JvmField
            val OMNI_MODERATION_2024_09_26 = Model(JsonField.of("omni-moderation-2024-09-26"))

            @JvmField val TEXT_MODERATION_LATEST = Model(JsonField.of("text-moderation-latest"))

            @JvmField val TEXT_MODERATION_STABLE = Model(JsonField.of("text-moderation-stable"))

            @JvmStatic fun of(value: String) = Model(JsonField.of(value))
        }

        enum class Known {
            OMNI_MODERATION_LATEST,
            OMNI_MODERATION_2024_09_26,
            TEXT_MODERATION_LATEST,
            TEXT_MODERATION_STABLE,
        }

        enum class Value {
            OMNI_MODERATION_LATEST,
            OMNI_MODERATION_2024_09_26,
            TEXT_MODERATION_LATEST,
            TEXT_MODERATION_STABLE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OMNI_MODERATION_LATEST -> Value.OMNI_MODERATION_LATEST
                OMNI_MODERATION_2024_09_26 -> Value.OMNI_MODERATION_2024_09_26
                TEXT_MODERATION_LATEST -> Value.TEXT_MODERATION_LATEST
                TEXT_MODERATION_STABLE -> Value.TEXT_MODERATION_STABLE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OMNI_MODERATION_LATEST -> Known.OMNI_MODERATION_LATEST
                OMNI_MODERATION_2024_09_26 -> Known.OMNI_MODERATION_2024_09_26
                TEXT_MODERATION_LATEST -> Known.TEXT_MODERATION_LATEST
                TEXT_MODERATION_STABLE -> Known.TEXT_MODERATION_STABLE
                else -> throw OpenAIInvalidDataException("Unknown Model: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationCreateParams && input == other.input && model == other.model && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams && additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(input, model, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */

    override fun toString() =
        "ModerationCreateParams{input=$input, model=$model, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
