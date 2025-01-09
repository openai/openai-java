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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Classifies if text and/or image inputs are potentially harmful. Learn more in the
 * [moderation guide](https://platform.openai.com/docs/guides/moderation).
 */
class ModerationCreateParams
constructor(
    private val body: ModerationCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /**
     * Input (or inputs) to classify. Can be a single string, an array of strings, or an array of
     * multi-modal input objects similar to other models.
     */
    fun input(): Input = body.input()

    /**
     * The content moderation model you would like to use. Learn more in
     * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn about
     * available models [here](https://platform.openai.com/docs/models#moderation).
     */
    fun model(): Optional<ModerationModel> = body.model()

    /**
     * Input (or inputs) to classify. Can be a single string, an array of strings, or an array of
     * multi-modal input objects similar to other models.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * The content moderation model you would like to use. Learn more in
     * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn about
     * available models [here](https://platform.openai.com/docs/models#moderation).
     */
    fun _model(): JsonField<ModerationModel> = body._model()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getBody(): ModerationCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class ModerationCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("input")
        @ExcludeMissing
        private val input: JsonField<Input> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<ModerationModel> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(): Input = input.getRequired("input")

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        fun model(): Optional<ModerationModel> = Optional.ofNullable(model.getNullable("model"))

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ModerationModel> = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ModerationCreateBody = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            model()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var input: JsonField<Input>? = null
            private var model: JsonField<ModerationModel> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(moderationCreateBody: ModerationCreateBody) = apply {
                input = moderationCreateBody.input
                model = moderationCreateBody.model
                additionalProperties = moderationCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * Input (or inputs) to classify. Can be a single string, an array of strings, or an
             * array of multi-modal input objects similar to other models.
             */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Input (or inputs) to classify. Can be a single string, an array of strings, or an
             * array of multi-modal input objects similar to other models.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** A string of text to classify for moderation. */
            fun input(string: String) = input(Input.ofString(string))

            /** An array of strings to classify for moderation. */
            fun inputOfStrings(strings: List<String>) = input(Input.ofStrings(strings))

            /** An array of multi-modal inputs to the moderation model. */
            fun inputOfModerationMultiModalArray(
                moderationMultiModalArray: List<ModerationMultiModalInput>
            ) = input(Input.ofModerationMultiModalArray(moderationMultiModalArray))

            /**
             * The content moderation model you would like to use. Learn more in
             * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
             * about available models [here](https://platform.openai.com/docs/models#moderation).
             */
            fun model(model: ModerationModel) = model(JsonField.of(model))

            /**
             * The content moderation model you would like to use. Learn more in
             * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
             * about available models [here](https://platform.openai.com/docs/models#moderation).
             */
            fun model(model: JsonField<ModerationModel>) = apply { this.model = model }

            /**
             * The content moderation model you would like to use. Learn more in
             * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
             * about available models [here](https://platform.openai.com/docs/models#moderation).
             */
            fun model(value: String) = apply { model(ModerationModel.of(value)) }

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

        private var body: ModerationCreateBody.Builder = ModerationCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(moderationCreateParams: ModerationCreateParams) = apply {
            body = moderationCreateParams.body.toBuilder()
            additionalHeaders = moderationCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = moderationCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(input: Input) = apply { body.input(input) }

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** A string of text to classify for moderation. */
        fun input(string: String) = apply { body.input(string) }

        /** An array of strings to classify for moderation. */
        fun inputOfStrings(strings: List<String>) = apply { body.inputOfStrings(strings) }

        /** An array of multi-modal inputs to the moderation model. */
        fun inputOfModerationMultiModalArray(
            moderationMultiModalArray: List<ModerationMultiModalInput>
        ) = apply { body.inputOfModerationMultiModalArray(moderationMultiModalArray) }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        fun model(model: ModerationModel) = apply { body.model(model) }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        fun model(model: JsonField<ModerationModel>) = apply { body.model(model) }

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         */
        fun model(value: String) = apply { body.model(value) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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

        fun build(): ModerationCreateParams =
            ModerationCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * Input (or inputs) to classify. Can be a single string, an array of strings, or an array of
     * multi-modal input objects similar to other models.
     */
    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val strings: List<String>? = null,
        private val moderationMultiModalArray: List<ModerationMultiModalInput>? = null,
        private val _json: JsonValue? = null,
    ) {

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

        /** A string of text to classify for moderation. */
        fun asString(): String = string.getOrThrow("string")

        /** An array of strings to classify for moderation. */
        fun asStrings(): List<String> = strings.getOrThrow("strings")

        /** An array of multi-modal inputs to the moderation model. */
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

        private var validated: Boolean = false

        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitStrings(strings: List<String>) {}

                    override fun visitModerationMultiModalArray(
                        moderationMultiModalArray: List<ModerationMultiModalInput>
                    ) {
                        moderationMultiModalArray.forEach { it.validate() }
                    }
                }
            )
            validated = true
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

            /** A string of text to classify for moderation. */
            @JvmStatic fun ofString(string: String) = Input(string = string)

            /** An array of strings to classify for moderation. */
            @JvmStatic fun ofStrings(strings: List<String>) = Input(strings = strings)

            /** An array of multi-modal inputs to the moderation model. */
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
                tryDeserialize(node, jacksonTypeRef<List<ModerationMultiModalInput>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ModerationCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
