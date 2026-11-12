// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = DecisionAssistantMessageContentPart.Deserializer::class)
@JsonSerialize(using = DecisionAssistantMessageContentPart.Serializer::class)
class DecisionAssistantMessageContentPart
private constructor(
    private val outputText: OutputText? = null,
    private val refusal: Refusal? = null,
    private val _json: JsonValue? = null,
) {

    fun outputText(): Optional<OutputText> = Optional.ofNullable(outputText)

    fun refusal(): Optional<Refusal> = Optional.ofNullable(refusal)

    fun isOutputText(): Boolean = outputText != null

    fun isRefusal(): Boolean = refusal != null

    fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

    fun asRefusal(): Refusal = refusal.getOrThrow("refusal")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = decisionAssistantMessageContentPart.accept(new DecisionAssistantMessageContentPart.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitOutputText(OutputText outputText) {
     *         return Optional.of(outputText.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            outputText != null -> visitor.visitOutputText(outputText)
            refusal != null -> visitor.visitRefusal(refusal)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): DecisionAssistantMessageContentPart = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitOutputText(outputText: OutputText) {
                    outputText.validate()
                }

                override fun visitRefusal(refusal: Refusal) {
                    refusal.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitOutputText(outputText: OutputText) = outputText.validity()

                override fun visitRefusal(refusal: Refusal) = refusal.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionAssistantMessageContentPart &&
            outputText == other.outputText &&
            refusal == other.refusal &&
            (outputText != null || refusal != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (outputText == null && refusal == null) Objects.hash(_json)
        else Objects.hash(outputText, refusal)

    override fun toString(): String =
        when {
            outputText != null -> "DecisionAssistantMessageContentPart{outputText=$outputText}"
            refusal != null -> "DecisionAssistantMessageContentPart{refusal=$refusal}"
            _json != null -> "DecisionAssistantMessageContentPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid DecisionAssistantMessageContentPart")
        }

    companion object {

        @JvmStatic
        fun ofOutputText(outputText: OutputText) =
            DecisionAssistantMessageContentPart(outputText = outputText)

        @JvmStatic
        fun ofRefusal(refusal: Refusal) = DecisionAssistantMessageContentPart(refusal = refusal)
    }

    /**
     * An interface that defines how to map each variant of [DecisionAssistantMessageContentPart] to
     * a value of type [T].
     */
    interface Visitor<out T> {

        fun visitOutputText(outputText: OutputText): T = unknown(JsonValue.from(outputText))

        fun visitRefusal(refusal: Refusal): T = unknown(JsonValue.from(refusal))

        /**
         * Maps an unknown variant of [DecisionAssistantMessageContentPart] to a value of type [T].
         *
         * An instance of [DecisionAssistantMessageContentPart] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown DecisionAssistantMessageContentPart")
        }
    }

    internal class Deserializer :
        BaseDeserializer<DecisionAssistantMessageContentPart>(
            DecisionAssistantMessageContentPart::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): DecisionAssistantMessageContentPart {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "output_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputText>())?.let {
                        DecisionAssistantMessageContentPart(outputText = it, _json = json)
                    } ?: DecisionAssistantMessageContentPart(_json = json)
                }
                "refusal" -> {
                    return tryDeserialize(node, jacksonTypeRef<Refusal>())?.let {
                        DecisionAssistantMessageContentPart(refusal = it, _json = json)
                    } ?: DecisionAssistantMessageContentPart(_json = json)
                }
            }

            return DecisionAssistantMessageContentPart(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<DecisionAssistantMessageContentPart>(
            DecisionAssistantMessageContentPart::class
        ) {

        override fun serialize(
            value: DecisionAssistantMessageContentPart,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.outputText != null -> generator.writeObject(value.outputText)
                value.refusal != null -> generator.writeObject(value.refusal)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid DecisionAssistantMessageContentPart")
            }
        }
    }

    class OutputText
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val text: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(text, type, mutableMapOf())

        /**
         * The text content. The schema requires this property. Returns empty if the JSON property
         * is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun text(): java.util.Optional<String> = text.getOptional("text")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun textOrThrow(): String = text.getRequired("text")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("output_text")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(additionalProperties, "text" to this.text, "type" to this.type)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [OutputText].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputText]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("output_text")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputText: OutputText) = apply {
                text = outputText.text
                type = outputText.type
                additionalProperties = outputText.additionalProperties.toMutableMap()
            }

            /** The text content. */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("output_text")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [OutputText].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OutputText =
                OutputText(checkRequired("text", text), type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): OutputText = apply {
            if (validated) {
                return@apply
            }

            textOrThrow()
            typeOrThrow()
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
            (if (text.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("output_text")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputText &&
                text == other.text &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
    }

    class Refusal
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val refusal: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("refusal") @ExcludeMissing refusal: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(refusal, type, mutableMapOf())

        /**
         * The refusal text. The schema requires this property. Returns empty if the JSON property
         * is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun refusal(): java.util.Optional<String> = refusal.getOptional("refusal")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun refusalOrThrow(): String = refusal.getRequired("refusal")

        /**
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("refusal")) ->
                    throw OpenAIInvalidDataException("`type` is invalid")
                else -> java.util.Optional.of(raw)
            }
        }

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

        /**
         * Returns the raw JSON value of [refusal].
         *
         * Unlike [refusal], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "refusal" to this.refusal,
                "type" to this.type,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Refusal].
             *
             * The following fields are required:
             * ```java
             * .refusal()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Refusal]. */
        class Builder internal constructor() {

            private var refusal: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("refusal")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(refusal: Refusal) = apply {
                this.refusal = refusal.refusal
                type = refusal.type
                additionalProperties = refusal.additionalProperties.toMutableMap()
            }

            /** The refusal text. */
            fun refusal(refusal: String) = refusal(JsonField.of(refusal))

            /**
             * Sets [Builder.refusal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refusal] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("refusal")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [Refusal].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .refusal()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Refusal =
                Refusal(
                    checkRequired("refusal", refusal),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Refusal = apply {
            if (validated) {
                return@apply
            }

            refusalOrThrow()
            typeOrThrow()
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
            (if (refusal.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("refusal")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Refusal &&
                refusal == other.refusal &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(refusal, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Refusal{refusal=$refusal, type=$type, additionalProperties=$additionalProperties}"
    }
}
