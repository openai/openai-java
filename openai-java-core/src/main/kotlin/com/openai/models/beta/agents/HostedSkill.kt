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

/** A skill installed in an OpenAI-hosted environment. */
@JsonDeserialize(using = HostedSkill.Deserializer::class)
@JsonSerialize(using = HostedSkill.Serializer::class)
class HostedSkill
private constructor(
    private val skillReference: HostedSkillReference? = null,
    private val inline: Inline? = null,
    private val _json: JsonValue? = null,
) {

    /** A skill installed from the Skills API. */
    fun skillReference(): Optional<HostedSkillReference> = Optional.ofNullable(skillReference)

    /** A skill installed from an inline ZIP archive. */
    fun inline(): Optional<Inline> = Optional.ofNullable(inline)

    fun isSkillReference(): Boolean = skillReference != null

    fun isInline(): Boolean = inline != null

    /** A skill installed from the Skills API. */
    fun asSkillReference(): HostedSkillReference = skillReference.getOrThrow("skillReference")

    /** A skill installed from an inline ZIP archive. */
    fun asInline(): Inline = inline.getOrThrow("inline")

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
     * Optional<String> result = hostedSkill.accept(new HostedSkill.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSkillReference(HostedSkillReference skillReference) {
     *         return Optional.of(skillReference.toString());
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
            skillReference != null -> visitor.visitSkillReference(skillReference)
            inline != null -> visitor.visitInline(inline)
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
    fun validate(): HostedSkill = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitSkillReference(skillReference: HostedSkillReference) {
                    skillReference.validate()
                }

                override fun visitInline(inline: Inline) {
                    inline.validate()
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
                override fun visitSkillReference(skillReference: HostedSkillReference) =
                    skillReference.validity()

                override fun visitInline(inline: Inline) = inline.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is HostedSkill &&
            skillReference == other.skillReference &&
            inline == other.inline
    }

    override fun hashCode(): Int = Objects.hash(skillReference, inline)

    override fun toString(): String =
        when {
            skillReference != null -> "HostedSkill{skillReference=$skillReference}"
            inline != null -> "HostedSkill{inline=$inline}"
            _json != null -> "HostedSkill{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid HostedSkill")
        }

    companion object {

        /** A skill installed from the Skills API. */
        @JvmStatic
        fun ofSkillReference(skillReference: HostedSkillReference) =
            HostedSkill(skillReference = skillReference)

        /** A skill installed from an inline ZIP archive. */
        @JvmStatic fun ofInline(inline: Inline) = HostedSkill(inline = inline)
    }

    /**
     * An interface that defines how to map each variant of [HostedSkill] to a value of type [T].
     */
    interface Visitor<out T> {

        /** A skill installed from the Skills API. */
        fun visitSkillReference(skillReference: HostedSkillReference): T

        /** A skill installed from an inline ZIP archive. */
        fun visitInline(inline: Inline): T

        /**
         * Maps an unknown variant of [HostedSkill] to a value of type [T].
         *
         * An instance of [HostedSkill] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown HostedSkill: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<HostedSkill>(HostedSkill::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): HostedSkill {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "skill_reference" -> {
                    return tryDeserialize(node, jacksonTypeRef<HostedSkillReference>())?.let {
                        HostedSkill(skillReference = it, _json = json)
                    } ?: HostedSkill(_json = json)
                }
                "inline" -> {
                    return tryDeserialize(node, jacksonTypeRef<Inline>())?.let {
                        HostedSkill(inline = it, _json = json)
                    } ?: HostedSkill(_json = json)
                }
            }

            return HostedSkill(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<HostedSkill>(HostedSkill::class) {

        override fun serialize(
            value: HostedSkill,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.skillReference != null -> generator.writeObject(value.skillReference)
                value.inline != null -> generator.writeObject(value.inline)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid HostedSkill")
            }
        }
    }

    /** A skill installed from an inline ZIP archive. */
    class Inline
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(description, name, type, mutableMapOf())

        /**
         * The installed skill description.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun description(): String = description.getRequired("description")

        /**
         * The installed skill name.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The type of the object. Always `inline`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("inline")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * Returns a mutable builder for constructing an instance of [Inline].
             *
             * The following fields are required:
             * ```java
             * .description()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Inline]. */
        class Builder internal constructor() {

            private var description: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("inline")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inline: Inline) = apply {
                description = inline.description
                name = inline.name
                type = inline.type
                additionalProperties = inline.additionalProperties.toMutableMap()
            }

            /** The installed skill description. */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** The installed skill name. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("inline")
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
             * Returns an immutable instance of [Inline].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .description()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Inline =
                Inline(
                    checkRequired("description", description),
                    checkRequired("name", name),
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
        fun validate(): Inline = apply {
            if (validated) {
                return@apply
            }

            description()
            name()
            _type().let {
                if (it != JsonValue.from("inline")) {
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("inline")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Inline &&
                description == other.description &&
                name == other.name &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(description, name, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Inline{description=$description, name=$name, type=$type, additionalProperties=$additionalProperties}"
    }
}
