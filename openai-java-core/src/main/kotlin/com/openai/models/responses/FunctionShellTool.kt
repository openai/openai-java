// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A tool that allows the model to execute shell commands. */
class FunctionShellTool
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val environment: JsonField<Environment>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("environment")
        @ExcludeMissing
        environment: JsonField<Environment> = JsonMissing.of(),
    ) : this(type, environment, mutableMapOf())

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
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun environment(): Optional<Environment> = environment.getOptional("environment")

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

        /** Returns a mutable builder for constructing an instance of [FunctionShellTool]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FunctionShellTool]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("shell")
        private var environment: JsonField<Environment> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(functionShellTool: FunctionShellTool) = apply {
            type = functionShellTool.type
            environment = functionShellTool.environment
            additionalProperties = functionShellTool.additionalProperties.toMutableMap()
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
        fun environment(containerAuto: ContainerAuto) =
            environment(Environment.ofContainerAuto(containerAuto))

        /** Alias for calling [environment] with `Environment.ofLocal(local)`. */
        fun environment(local: LocalEnvironment) = environment(Environment.ofLocal(local))

        /**
         * Alias for calling [environment] with
         * `Environment.ofContainerReference(containerReference)`.
         */
        fun environment(containerReference: ContainerReference) =
            environment(Environment.ofContainerReference(containerReference))

        /**
         * Alias for calling [environment] with the following:
         * ```java
         * ContainerReference.builder()
         *     .containerId(containerId)
         *     .build()
         * ```
         */
        fun containerReferenceEnvironment(containerId: String) =
            environment(ContainerReference.builder().containerId(containerId).build())

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
         * Returns an immutable instance of [FunctionShellTool].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FunctionShellTool =
            FunctionShellTool(type, environment, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): FunctionShellTool = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("shell")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
            (environment.asKnown().getOrNull()?.validity() ?: 0)

    @JsonDeserialize(using = Environment.Deserializer::class)
    @JsonSerialize(using = Environment.Serializer::class)
    class Environment
    private constructor(
        private val containerAuto: ContainerAuto? = null,
        private val local: LocalEnvironment? = null,
        private val containerReference: ContainerReference? = null,
        private val _json: JsonValue? = null,
    ) {

        fun containerAuto(): Optional<ContainerAuto> = Optional.ofNullable(containerAuto)

        fun local(): Optional<LocalEnvironment> = Optional.ofNullable(local)

        fun containerReference(): Optional<ContainerReference> =
            Optional.ofNullable(containerReference)

        fun isContainerAuto(): Boolean = containerAuto != null

        fun isLocal(): Boolean = local != null

        fun isContainerReference(): Boolean = containerReference != null

        fun asContainerAuto(): ContainerAuto = containerAuto.getOrThrow("containerAuto")

        fun asLocal(): LocalEnvironment = local.getOrThrow("local")

        fun asContainerReference(): ContainerReference =
            containerReference.getOrThrow("containerReference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                containerAuto != null -> visitor.visitContainerAuto(containerAuto)
                local != null -> visitor.visitLocal(local)
                containerReference != null -> visitor.visitContainerReference(containerReference)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Environment = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitContainerAuto(containerAuto: ContainerAuto) {
                        containerAuto.validate()
                    }

                    override fun visitLocal(local: LocalEnvironment) {
                        local.validate()
                    }

                    override fun visitContainerReference(containerReference: ContainerReference) {
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
                    override fun visitContainerAuto(containerAuto: ContainerAuto) =
                        containerAuto.validity()

                    override fun visitLocal(local: LocalEnvironment) = local.validity()

                    override fun visitContainerReference(containerReference: ContainerReference) =
                        containerReference.validity()

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
            fun ofContainerAuto(containerAuto: ContainerAuto) =
                Environment(containerAuto = containerAuto)

            @JvmStatic fun ofLocal(local: LocalEnvironment) = Environment(local = local)

            @JvmStatic
            fun ofContainerReference(containerReference: ContainerReference) =
                Environment(containerReference = containerReference)
        }

        /**
         * An interface that defines how to map each variant of [Environment] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitContainerAuto(containerAuto: ContainerAuto): T

            fun visitLocal(local: LocalEnvironment): T

            fun visitContainerReference(containerReference: ContainerReference): T

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
                        return tryDeserialize(node, jacksonTypeRef<ContainerAuto>())?.let {
                            Environment(containerAuto = it, _json = json)
                        } ?: Environment(_json = json)
                    }
                    "local" -> {
                        return tryDeserialize(node, jacksonTypeRef<LocalEnvironment>())?.let {
                            Environment(local = it, _json = json)
                        } ?: Environment(_json = json)
                    }
                    "container_reference" -> {
                        return tryDeserialize(node, jacksonTypeRef<ContainerReference>())?.let {
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

        return other is FunctionShellTool &&
            type == other.type &&
            environment == other.environment &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(type, environment, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FunctionShellTool{type=$type, environment=$environment, additionalProperties=$additionalProperties}"
}
