// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

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
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Classifies if text and/or image inputs are potentially harmful. Learn more in the
 * [moderation guide](https://platform.openai.com/docs/guides/moderation).
 */
class ModerationCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Input (or inputs) to classify. Can be a single string, an array of strings, or an array of
     * multi-modal input objects similar to other models.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): Input = body.input()

    /**
     * The content moderation model you would like to use. Learn more in
     * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn about
     * available models [here](https://platform.openai.com/docs/models#moderation).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun model(): Optional<ModerationModel> = body.model()

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<ModerationModel> = body._model()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ModerationCreateParams].
         *
         * The following fields are required:
         * ```java
         * .input()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ModerationCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
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
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [Input] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** Alias for calling [input] with `Input.ofString(string)`. */
        fun input(string: String) = apply { body.input(string) }

        /** Alias for calling [input] with `Input.ofStrings(strings)`. */
        fun inputOfStrings(strings: List<String>) = apply { body.inputOfStrings(strings) }

        /**
         * Alias for calling [input] with
         * `Input.ofModerationMultiModalArray(moderationMultiModalArray)`.
         */
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
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [ModerationModel] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun model(model: JsonField<ModerationModel>) = apply { body.model(model) }

        /**
         * Sets [model] to an arbitrary [String].
         *
         * You should usually call [model] with a well-typed [ModerationModel] constant instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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

        /**
         * Returns an immutable instance of [ModerationCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ModerationCreateParams =
            ModerationCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val input: JsonField<Input>,
        private val model: JsonField<ModerationModel>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("model")
            @ExcludeMissing
            model: JsonField<ModerationModel> = JsonMissing.of(),
        ) : this(input, model, mutableMapOf())

        /**
         * Input (or inputs) to classify. Can be a single string, an array of strings, or an array
         * of multi-modal input objects similar to other models.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): Input = input.getRequired("input")

        /**
         * The content moderation model you would like to use. Learn more in
         * [the moderation guide](https://platform.openai.com/docs/guides/moderation), and learn
         * about available models [here](https://platform.openai.com/docs/models#moderation).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<ModerationModel> = Optional.ofNullable(model.getNullable("model"))

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<ModerationModel> = model

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .input()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var input: JsonField<Input>? = null
            private var model: JsonField<ModerationModel> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                input = body.input
                model = body.model
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Input (or inputs) to classify. Can be a single string, an array of strings, or an
             * array of multi-modal input objects similar to other models.
             */
            fun input(input: Input) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofString(string)`. */
            fun input(string: String) = input(Input.ofString(string))

            /** Alias for calling [input] with `Input.ofStrings(strings)`. */
            fun inputOfStrings(strings: List<String>) = input(Input.ofStrings(strings))

            /**
             * Alias for calling [input] with
             * `Input.ofModerationMultiModalArray(moderationMultiModalArray)`.
             */
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
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [ModerationModel] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<ModerationModel>) = apply { this.model = model }

            /**
             * Sets [model] to an arbitrary [String].
             *
             * You should usually call [model] with a well-typed [ModerationModel] constant instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(value: String) = model(ModerationModel.of(value))

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

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .input()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(checkRequired("input", input), model, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            input().validate()
            model().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (input.asKnown().getOrNull()?.validity() ?: 0) +
                (model.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && input == other.input && model == other.model && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(input, model, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{input=$input, model=$model, additionalProperties=$additionalProperties}"
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

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                strings != null -> visitor.visitStrings(strings)
                moderationMultiModalArray != null ->
                    visitor.visitModerationMultiModalArray(moderationMultiModalArray)
                else -> visitor.unknown(_json)
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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun visitModerationMultiModalArray(
                        moderationMultiModalArray: List<ModerationMultiModalInput>
                    ) = moderationMultiModalArray.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

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

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            /** A string of text to classify for moderation. */
            fun visitString(string: String): T

            /** An array of strings to classify for moderation. */
            fun visitStrings(strings: List<String>): T

            /** An array of multi-modal inputs to the moderation model. */
            fun visitModerationMultiModalArray(
                moderationMultiModalArray: List<ModerationMultiModalInput>
            ): T

            /**
             * Maps an unknown variant of [Input] to a value of type [T].
             *
             * An instance of [Input] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Input(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                Input(strings = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<ModerationMultiModalInput>>())
                                ?.let { Input(moderationMultiModalArray = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> Input(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider,
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
