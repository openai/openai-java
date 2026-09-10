// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A plaintext or encrypted content part exchanged between agents. */
@JsonDeserialize(using = AgentContent.Deserializer::class)
@JsonSerialize(using = AgentContent.Serializer::class)
class AgentContent
private constructor(
    private val outputText: OutputText? = null,
    private val encrypted: EncryptedContent? = null,
    private val _json: JsonValue? = null,
) {

    /** A text content part produced by the agent. */
    fun outputText(): Optional<OutputText> = Optional.ofNullable(outputText)

    /** Encrypted content exchanged between agents. */
    fun encrypted(): Optional<EncryptedContent> = Optional.ofNullable(encrypted)

    fun isOutputText(): Boolean = outputText != null

    fun isEncrypted(): Boolean = encrypted != null

    /** A text content part produced by the agent. */
    fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

    /** Encrypted content exchanged between agents. */
    fun asEncrypted(): EncryptedContent = encrypted.getOrThrow("encrypted")

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
     * Optional<String> result = agentContent.accept(new AgentContent.Visitor<Optional<String>>() {
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
            encrypted != null -> visitor.visitEncrypted(encrypted)
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
    fun validate(): AgentContent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitOutputText(outputText: OutputText) {
                    outputText.validate()
                }

                override fun visitEncrypted(encrypted: EncryptedContent) {
                    encrypted.validate()
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

                override fun visitEncrypted(encrypted: EncryptedContent) = encrypted.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentContent &&
            outputText == other.outputText &&
            encrypted == other.encrypted
    }

    override fun hashCode(): Int = Objects.hash(outputText, encrypted)

    override fun toString(): String =
        when {
            outputText != null -> "AgentContent{outputText=$outputText}"
            encrypted != null -> "AgentContent{encrypted=$encrypted}"
            _json != null -> "AgentContent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentContent")
        }

    companion object {

        /** A text content part produced by the agent. */
        @JvmStatic fun ofOutputText(outputText: OutputText) = AgentContent(outputText = outputText)

        /** Encrypted content exchanged between agents. */
        @JvmStatic
        fun ofEncrypted(encrypted: EncryptedContent) = AgentContent(encrypted = encrypted)
    }

    /**
     * An interface that defines how to map each variant of [AgentContent] to a value of type [T].
     */
    interface Visitor<out T> {

        /** A text content part produced by the agent. */
        fun visitOutputText(outputText: OutputText): T

        /** Encrypted content exchanged between agents. */
        fun visitEncrypted(encrypted: EncryptedContent): T

        /**
         * Maps an unknown variant of [AgentContent] to a value of type [T].
         *
         * An instance of [AgentContent] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentContent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AgentContent>(AgentContent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentContent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "output_text" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputText>())?.let {
                        AgentContent(outputText = it, _json = json)
                    } ?: AgentContent(_json = json)
                }
                "encrypted_content" -> {
                    return tryDeserialize(node, jacksonTypeRef<EncryptedContent>())?.let {
                        AgentContent(encrypted = it, _json = json)
                    } ?: AgentContent(_json = json)
                }
            }

            return AgentContent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AgentContent>(AgentContent::class) {

        override fun serialize(
            value: AgentContent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.outputText != null -> generator.writeObject(value.outputText)
                value.encrypted != null -> generator.writeObject(value.encrypted)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentContent")
            }
        }
    }

    /** Encrypted content exchanged between agents. */
    class EncryptedContent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val encryptedContent: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("encrypted_content")
            @ExcludeMissing
            encryptedContent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(encryptedContent, type, mutableMapOf())

        /**
         * The encrypted content payload.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun encryptedContent(): String = encryptedContent.getRequired("encrypted_content")

        /**
         * The content type. Always `encrypted_content`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("encrypted_content")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [encryptedContent].
         *
         * Unlike [encryptedContent], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("encrypted_content")
        @ExcludeMissing
        fun _encryptedContent(): JsonField<String> = encryptedContent

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
             * Returns a mutable builder for constructing an instance of [EncryptedContent].
             *
             * The following fields are required:
             * ```java
             * .encryptedContent()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EncryptedContent]. */
        class Builder internal constructor() {

            private var encryptedContent: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("encrypted_content")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(encryptedContent: EncryptedContent) = apply {
                this.encryptedContent = encryptedContent.encryptedContent
                type = encryptedContent.type
                additionalProperties = encryptedContent.additionalProperties.toMutableMap()
            }

            /** The encrypted content payload. */
            fun encryptedContent(encryptedContent: String) =
                encryptedContent(JsonField.of(encryptedContent))

            /**
             * Sets [Builder.encryptedContent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.encryptedContent] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun encryptedContent(encryptedContent: JsonField<String>) = apply {
                this.encryptedContent = encryptedContent
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("encrypted_content")
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
             * Returns an immutable instance of [EncryptedContent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .encryptedContent()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): EncryptedContent =
                EncryptedContent(
                    checkRequired("encryptedContent", encryptedContent),
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
        fun validate(): EncryptedContent = apply {
            if (validated) {
                return@apply
            }

            encryptedContent()
            _type().let {
                if (it != JsonValue.from("encrypted_content")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (encryptedContent.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("encrypted_content")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EncryptedContent &&
                encryptedContent == other.encryptedContent &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(encryptedContent, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "EncryptedContent{encryptedContent=$encryptedContent, type=$type, additionalProperties=$additionalProperties}"
    }
}
