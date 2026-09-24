// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Destination permissions for an environment-variable credential. These do not grant network access
 * to the environment.
 */
@JsonDeserialize(using = CredentialNetworkingParam.Deserializer::class)
@JsonSerialize(using = CredentialNetworkingParam.Serializer::class)
class CredentialNetworkingParam
private constructor(
    private val unrestricted: JsonValue? = null,
    private val limited: Limited? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Allows substitution for destinations permitted by the environment network policy. Requires
     * `environment.network.access` to be `restricted`, with explicit `allowed_domains`.
     */
    fun unrestricted(): Optional<JsonValue> = Optional.ofNullable(unrestricted)

    /**
     * Allows substitution only for the listed hosts. The environment network policy must also allow
     * these hosts.
     */
    fun limited(): Optional<Limited> = Optional.ofNullable(limited)

    fun isUnrestricted(): Boolean = unrestricted != null

    fun isLimited(): Boolean = limited != null

    /**
     * Allows substitution for destinations permitted by the environment network policy. Requires
     * `environment.network.access` to be `restricted`, with explicit `allowed_domains`.
     */
    fun asUnrestricted(): JsonValue = unrestricted.getOrThrow("unrestricted")

    /**
     * Allows substitution only for the listed hosts. The environment network policy must also allow
     * these hosts.
     */
    fun asLimited(): Limited = limited.getOrThrow("limited")

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
     * Optional<String> result = credentialNetworkingParam.accept(new CredentialNetworkingParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitUnrestricted(JsonValue unrestricted) {
     *         return Optional.of(unrestricted.toString());
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
            unrestricted != null -> visitor.visitUnrestricted(unrestricted)
            limited != null -> visitor.visitLimited(limited)
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
    fun validate(): CredentialNetworkingParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitUnrestricted(unrestricted: JsonValue) {
                    unrestricted.let {
                        if (it != JsonValue.from(mapOf("type" to "unrestricted"))) {
                            throw OpenAIInvalidDataException(
                                "'unrestricted' is invalid, received $it"
                            )
                        }
                    }
                }

                override fun visitLimited(limited: Limited) {
                    limited.validate()
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
                override fun visitUnrestricted(unrestricted: JsonValue) =
                    unrestricted.let {
                        if (it == JsonValue.from(mapOf("type" to "unrestricted"))) 1 else 0
                    }

                override fun visitLimited(limited: Limited) = limited.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CredentialNetworkingParam &&
            unrestricted == other.unrestricted &&
            limited == other.limited
    }

    override fun hashCode(): Int = Objects.hash(unrestricted, limited)

    override fun toString(): String =
        when {
            unrestricted != null -> "CredentialNetworkingParam{unrestricted=$unrestricted}"
            limited != null -> "CredentialNetworkingParam{limited=$limited}"
            _json != null -> "CredentialNetworkingParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CredentialNetworkingParam")
        }

    companion object {

        /**
         * Allows substitution for destinations permitted by the environment network policy.
         * Requires `environment.network.access` to be `restricted`, with explicit
         * `allowed_domains`.
         */
        @JvmStatic
        fun ofUnrestricted() =
            CredentialNetworkingParam(
                unrestricted = JsonValue.from(mapOf("type" to "unrestricted"))
            )

        /**
         * Allows substitution only for the listed hosts. The environment network policy must also
         * allow these hosts.
         */
        @JvmStatic fun ofLimited(limited: Limited) = CredentialNetworkingParam(limited = limited)
    }

    /**
     * An interface that defines how to map each variant of [CredentialNetworkingParam] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /**
         * Allows substitution for destinations permitted by the environment network policy.
         * Requires `environment.network.access` to be `restricted`, with explicit
         * `allowed_domains`.
         */
        fun visitUnrestricted(unrestricted: JsonValue): T

        /**
         * Allows substitution only for the listed hosts. The environment network policy must also
         * allow these hosts.
         */
        fun visitLimited(limited: Limited): T

        /**
         * Maps an unknown variant of [CredentialNetworkingParam] to a value of type [T].
         *
         * An instance of [CredentialNetworkingParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown CredentialNetworkingParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<CredentialNetworkingParam>(CredentialNetworkingParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CredentialNetworkingParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "unrestricted" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { CredentialNetworkingParam(unrestricted = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: CredentialNetworkingParam(_json = json)
                }
                "limited" -> {
                    return tryDeserialize(node, jacksonTypeRef<Limited>())?.let {
                        CredentialNetworkingParam(limited = it, _json = json)
                    } ?: CredentialNetworkingParam(_json = json)
                }
            }

            return CredentialNetworkingParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<CredentialNetworkingParam>(CredentialNetworkingParam::class) {

        override fun serialize(
            value: CredentialNetworkingParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.unrestricted != null -> generator.writeObject(value.unrestricted)
                value.limited != null -> generator.writeObject(value.limited)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CredentialNetworkingParam")
            }
        }
    }

    /**
     * Allows substitution only for the listed hosts. The environment network policy must also allow
     * these hosts.
     */
    class Limited
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val allowedHosts: JsonField<List<String>>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("allowed_hosts")
            @ExcludeMissing
            allowedHosts: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(allowedHosts, type, mutableMapOf())

        /**
         * The 1 to 16 distinct allowed hostnames or IPv4 addresses, normalized to lowercase.
         * Entries contain no scheme, path, port, or wildcard. IPv6 addresses are not supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun allowedHosts(): List<String> = allowedHosts.getRequired("allowed_hosts")

        /**
         * The type of the object. Always `limited`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("limited")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [allowedHosts].
         *
         * Unlike [allowedHosts], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("allowed_hosts")
        @ExcludeMissing
        fun _allowedHosts(): JsonField<List<String>> = allowedHosts

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
             * Returns a mutable builder for constructing an instance of [Limited].
             *
             * The following fields are required:
             * ```java
             * .allowedHosts()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Limited]. */
        class Builder internal constructor() {

            private var allowedHosts: JsonField<MutableList<String>>? = null
            private var type: JsonValue = JsonValue.from("limited")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(limited: Limited) = apply {
                allowedHosts = limited.allowedHosts.map { it.toMutableList() }
                type = limited.type
                additionalProperties = limited.additionalProperties.toMutableMap()
            }

            /**
             * The 1 to 16 distinct allowed hostnames or IPv4 addresses, normalized to lowercase.
             * Entries contain no scheme, path, port, or wildcard. IPv6 addresses are not supported.
             */
            fun allowedHosts(allowedHosts: List<String>) = allowedHosts(JsonField.of(allowedHosts))

            /**
             * Sets [Builder.allowedHosts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedHosts] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun allowedHosts(allowedHosts: JsonField<List<String>>) = apply {
                this.allowedHosts = allowedHosts.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedHosts].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedHost(allowedHost: String) = apply {
                allowedHosts =
                    (allowedHosts ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedHosts", it).add(allowedHost)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("limited")
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
             * Returns an immutable instance of [Limited].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .allowedHosts()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Limited =
                Limited(
                    checkRequired("allowedHosts", allowedHosts).map { it.toImmutable() },
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
        fun validate(): Limited = apply {
            if (validated) {
                return@apply
            }

            allowedHosts()
            _type().let {
                if (it != JsonValue.from("limited")) {
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
            (allowedHosts.asKnown().getOrNull()?.size ?: 0) +
                type.let { if (it == JsonValue.from("limited")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Limited &&
                allowedHosts == other.allowedHosts &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(allowedHosts, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Limited{allowedHosts=$allowedHosts, type=$type, additionalProperties=$additionalProperties}"
    }
}
