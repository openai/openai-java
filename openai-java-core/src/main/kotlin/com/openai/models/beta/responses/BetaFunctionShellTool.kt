// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A tool that allows the model to execute shell commands. */
class BetaFunctionShellTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val allowedCallers: JsonField<List<AllowedCaller>>,
    private val environment: JsonField<Environment>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("allowed_callers")
        @ExcludeMissing
        allowedCallers: JsonField<List<AllowedCaller>> = JsonMissing.of(),
        @JsonProperty("environment")
        @ExcludeMissing
        environment: JsonField<Environment> = JsonMissing.of(),
    ) : this(type, allowedCallers, environment, mutableMapOf())

    /**
     * The type of the shell tool. Always `shell`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("shell")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The tool invocation context(s).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedCallers(): Optional<List<AllowedCaller>> =
        allowedCallers.getOptional("allowed_callers")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun environment(): Optional<Environment> = environment.getOptional("environment")

    /**
     * Returns the raw JSON value of [allowedCallers].
     *
     * Unlike [allowedCallers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed_callers")
    @ExcludeMissing
    fun _allowedCallers(): JsonField<List<AllowedCaller>> = allowedCallers

    /**
     * Returns the raw JSON value of [environment].
     *
     * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("environment")
    @ExcludeMissing
    fun _environment(): JsonField<Environment> = environment

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

        /** Returns a mutable builder for constructing an instance of [BetaFunctionShellTool]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaFunctionShellTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("shell")
        private var allowedCallers: JsonField<MutableList<AllowedCaller>>? = null
        private var environment: JsonField<Environment> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaFunctionShellTool: BetaFunctionShellTool) = apply {
            type = betaFunctionShellTool.type
            allowedCallers = betaFunctionShellTool.allowedCallers.map { it.toMutableList() }
            environment = betaFunctionShellTool.environment
            additionalProperties = betaFunctionShellTool.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("shell")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The tool invocation context(s). */
        fun allowedCallers(allowedCallers: List<AllowedCaller>?) =
            allowedCallers(JsonField.ofNullable(allowedCallers))

        /** Alias for calling [Builder.allowedCallers] with `allowedCallers.orElse(null)`. */
        fun allowedCallers(allowedCallers: Optional<List<AllowedCaller>>) =
            allowedCallers(allowedCallers.getOrNull())

        /**
         * Sets [Builder.allowedCallers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedCallers] with a well-typed `List<AllowedCaller>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun allowedCallers(allowedCallers: JsonField<List<AllowedCaller>>) = apply {
            this.allowedCallers = allowedCallers.map { it.toMutableList() }
        }

        /**
         * Adds a single [AllowedCaller] to [allowedCallers].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedCaller(allowedCaller: AllowedCaller) = apply {
            allowedCallers =
                (allowedCallers ?: JsonField.of(mutableListOf())).also {
                    checkKnown("allowedCallers", it).add(allowedCaller)
                }
        }

        fun environment(environment: Environment?) = environment(JsonField.ofNullable(environment))

        /** Alias for calling [Builder.environment] with `environment.orElse(null)`. */
        fun environment(environment: Optional<Environment>) = environment(environment.getOrNull())

        /**
         * Sets [Builder.environment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.environment] with a well-typed [Environment] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun environment(environment: JsonField<Environment>) = apply {
            this.environment = environment
        }

        /** Alias for calling [environment] with `Environment.ofContainerAuto(containerAuto)`. */
        fun environment(containerAuto: BetaContainerAuto) =
            environment(Environment.ofContainerAuto(containerAuto))

        /** Alias for calling [environment] with `Environment.ofLocal(local)`. */
        fun environment(local: BetaLocalEnvironment) = environment(Environment.ofLocal(local))

        /**
         * Alias for calling [environment] with
         * `Environment.ofContainerReference(containerReference)`.
         */
        fun environment(containerReference: BetaContainerReference) =
            environment(Environment.ofContainerReference(containerReference))

        /**
         * Alias for calling [environment] with the following:
         * ```java
         * BetaContainerReference.builder()
         *     .containerId(containerId)
         *     .build()
         * ```
         */
        fun containerReferenceEnvironment(containerId: String) =
            environment(BetaContainerReference.builder().containerId(containerId).build())

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
         * Returns an immutable instance of [BetaFunctionShellTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BetaFunctionShellTool =
            BetaFunctionShellTool(
                type,
                (allowedCallers ?: JsonMissing.of()).map { it.toImmutable() },
                environment,
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): BetaFunctionShellTool = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("shell")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        allowedCallers().ifPresent { it.forEach { it.validate() } }
        environment().ifPresent { it.validate() }
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
        type.let { if (it == JsonValue.from("shell")) 1 else 0 } +
            (allowedCallers.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (environment.asKnown().getOrNull()?.validity() ?: 0)

    class AllowedCaller @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DIRECT = of("direct")

            @JvmField val PROGRAMMATIC = of("programmatic")

            @JvmStatic fun of(value: String) = AllowedCaller(JsonField.of(value))
        }

        /** An enum containing [AllowedCaller]'s known values. */
        enum class Known {
            DIRECT,
            PROGRAMMATIC,
        }

        /**
         * An enum containing [AllowedCaller]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AllowedCaller] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DIRECT,
            PROGRAMMATIC,
            /**
             * An enum member indicating that [AllowedCaller] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                DIRECT -> Value.DIRECT
                PROGRAMMATIC -> Value.PROGRAMMATIC
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                DIRECT -> Known.DIRECT
                PROGRAMMATIC -> Known.PROGRAMMATIC
                else -> throw OpenAIInvalidDataException("Unknown AllowedCaller: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

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
        fun validate(): AllowedCaller = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AllowedCaller && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    @JsonDeserialize(using = Environment.Deserializer::class)
    @JsonSerialize(using = Environment.Serializer::class)
    class Environment
    private constructor(
        private val containerAuto: BetaContainerAuto? = null,
        private val local: BetaLocalEnvironment? = null,
        private val containerReference: BetaContainerReference? = null,
        private val _json: JsonValue? = null,
    ) {

        fun containerAuto(): Optional<BetaContainerAuto> = Optional.ofNullable(containerAuto)

        fun local(): Optional<BetaLocalEnvironment> = Optional.ofNullable(local)

        fun containerReference(): Optional<BetaContainerReference> =
            Optional.ofNullable(containerReference)

        fun isContainerAuto(): Boolean = containerAuto != null

        fun isLocal(): Boolean = local != null

        fun isContainerReference(): Boolean = containerReference != null

        fun asContainerAuto(): BetaContainerAuto = containerAuto.getOrThrow("containerAuto")

        fun asLocal(): BetaLocalEnvironment = local.getOrThrow("local")

        fun asContainerReference(): BetaContainerReference =
            containerReference.getOrThrow("containerReference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = environment.accept(new Environment.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitContainerAuto(BetaContainerAuto containerAuto) {
         *         return Optional.of(containerAuto.toString());
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                containerAuto != null -> visitor.visitContainerAuto(containerAuto)
                local != null -> visitor.visitLocal(local)
                containerReference != null -> visitor.visitContainerReference(containerReference)
                else -> visitor.unknown(_json)
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
        fun validate(): Environment = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitContainerAuto(containerAuto: BetaContainerAuto) {
                        containerAuto.validate()
                    }

                    override fun visitLocal(local: BetaLocalEnvironment) {
                        local.validate()
                    }

                    override fun visitContainerReference(
                        containerReference: BetaContainerReference
                    ) {
                        containerReference.validate()
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
                    override fun visitContainerAuto(containerAuto: BetaContainerAuto) =
                        containerAuto.validity()

                    override fun visitLocal(local: BetaLocalEnvironment) = local.validity()

                    override fun visitContainerReference(
                        containerReference: BetaContainerReference
                    ) = containerReference.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Environment &&
                containerAuto == other.containerAuto &&
                local == other.local &&
                containerReference == other.containerReference
        }

        override fun hashCode(): Int = Objects.hash(containerAuto, local, containerReference)

        override fun toString(): String =
            when {
                containerAuto != null -> "Environment{containerAuto=$containerAuto}"
                local != null -> "Environment{local=$local}"
                containerReference != null -> "Environment{containerReference=$containerReference}"
                _json != null -> "Environment{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Environment")
            }

        companion object {

            @JvmStatic
            fun ofContainerAuto(containerAuto: BetaContainerAuto) =
                Environment(containerAuto = containerAuto)

            @JvmStatic fun ofLocal(local: BetaLocalEnvironment) = Environment(local = local)

            @JvmStatic
            fun ofContainerReference(containerReference: BetaContainerReference) =
                Environment(containerReference = containerReference)
        }

        /**
         * An interface that defines how to map each variant of [Environment] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitContainerAuto(containerAuto: BetaContainerAuto): T

            fun visitLocal(local: BetaLocalEnvironment): T

            fun visitContainerReference(containerReference: BetaContainerReference): T

            /**
             * Maps an unknown variant of [Environment] to a value of type [T].
             *
             * An instance of [Environment] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Environment: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Environment>(Environment::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Environment {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "container_auto" -> {
                        return tryDeserialize(node, jacksonTypeRef<BetaContainerAuto>())?.let {
                            Environment(containerAuto = it, _json = json)
                        } ?: Environment(_json = json)
                    }
                    "local" -> {
                        return tryDeserialize(node, jacksonTypeRef<BetaLocalEnvironment>())?.let {
                            Environment(local = it, _json = json)
                        } ?: Environment(_json = json)
                    }
                    "container_reference" -> {
                        return tryDeserialize(node, jacksonTypeRef<BetaContainerReference>())?.let {
                            Environment(containerReference = it, _json = json)
                        } ?: Environment(_json = json)
                    }
                }

                return Environment(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Environment>(Environment::class) {

            override fun serialize(
                value: Environment,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.containerAuto != null -> generator.writeObject(value.containerAuto)
                    value.local != null -> generator.writeObject(value.local)
                    value.containerReference != null ->
                        generator.writeObject(value.containerReference)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Environment")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaFunctionShellTool &&
            type == other.type &&
            allowedCallers == other.allowedCallers &&
            environment == other.environment &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, allowedCallers, environment, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaFunctionShellTool{type=$type, allowedCallers=$allowedCallers, environment=$environment, additionalProperties=$additionalProperties}"
}
