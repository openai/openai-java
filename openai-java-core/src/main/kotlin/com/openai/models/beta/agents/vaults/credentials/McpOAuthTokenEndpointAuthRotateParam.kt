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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Client-secret updates that preserve the credential's OAuth authentication method. */
@JsonDeserialize(using = McpOAuthTokenEndpointAuthRotateParam.Deserializer::class)
@JsonSerialize(using = McpOAuthTokenEndpointAuthRotateParam.Serializer::class)
class McpOAuthTokenEndpointAuthRotateParam
private constructor(
    private val clientSecretBasic: ClientSecretBasic? = null,
    private val clientSecretPost: ClientSecretPost? = null,
    private val _json: JsonValue? = null,
) {

    /** Updates credentials sent using HTTP Basic authentication. */
    fun clientSecretBasic(): Optional<ClientSecretBasic> = Optional.ofNullable(clientSecretBasic)

    /** Updates credentials sent in the token request body. */
    fun clientSecretPost(): Optional<ClientSecretPost> = Optional.ofNullable(clientSecretPost)

    fun isClientSecretBasic(): Boolean = clientSecretBasic != null

    fun isClientSecretPost(): Boolean = clientSecretPost != null

    /** Updates credentials sent using HTTP Basic authentication. */
    fun asClientSecretBasic(): ClientSecretBasic = clientSecretBasic.getOrThrow("clientSecretBasic")

    /** Updates credentials sent in the token request body. */
    fun asClientSecretPost(): ClientSecretPost = clientSecretPost.getOrThrow("clientSecretPost")

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
     * Optional<String> result = mcpOAuthTokenEndpointAuthRotateParam.accept(new McpOAuthTokenEndpointAuthRotateParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitClientSecretBasic(ClientSecretBasic clientSecretBasic) {
     *         return Optional.of(clientSecretBasic.toString());
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
            clientSecretBasic != null -> visitor.visitClientSecretBasic(clientSecretBasic)
            clientSecretPost != null -> visitor.visitClientSecretPost(clientSecretPost)
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
    fun validate(): McpOAuthTokenEndpointAuthRotateParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitClientSecretBasic(clientSecretBasic: ClientSecretBasic) {
                    clientSecretBasic.validate()
                }

                override fun visitClientSecretPost(clientSecretPost: ClientSecretPost) {
                    clientSecretPost.validate()
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
                override fun visitClientSecretBasic(clientSecretBasic: ClientSecretBasic) =
                    clientSecretBasic.validity()

                override fun visitClientSecretPost(clientSecretPost: ClientSecretPost) =
                    clientSecretPost.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is McpOAuthTokenEndpointAuthRotateParam &&
            clientSecretBasic == other.clientSecretBasic &&
            clientSecretPost == other.clientSecretPost
    }

    override fun hashCode(): Int = Objects.hash(clientSecretBasic, clientSecretPost)

    override fun toString(): String =
        when {
            clientSecretBasic != null ->
                "McpOAuthTokenEndpointAuthRotateParam{clientSecretBasic=$clientSecretBasic}"
            clientSecretPost != null ->
                "McpOAuthTokenEndpointAuthRotateParam{clientSecretPost=$clientSecretPost}"
            _json != null -> "McpOAuthTokenEndpointAuthRotateParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid McpOAuthTokenEndpointAuthRotateParam")
        }

    companion object {

        /** Updates credentials sent using HTTP Basic authentication. */
        @JvmStatic
        fun ofClientSecretBasic(clientSecretBasic: ClientSecretBasic) =
            McpOAuthTokenEndpointAuthRotateParam(clientSecretBasic = clientSecretBasic)

        /** Updates credentials sent in the token request body. */
        @JvmStatic
        fun ofClientSecretPost(clientSecretPost: ClientSecretPost) =
            McpOAuthTokenEndpointAuthRotateParam(clientSecretPost = clientSecretPost)
    }

    /**
     * An interface that defines how to map each variant of [McpOAuthTokenEndpointAuthRotateParam]
     * to a value of type [T].
     */
    interface Visitor<out T> {

        /** Updates credentials sent using HTTP Basic authentication. */
        fun visitClientSecretBasic(clientSecretBasic: ClientSecretBasic): T

        /** Updates credentials sent in the token request body. */
        fun visitClientSecretPost(clientSecretPost: ClientSecretPost): T

        /**
         * Maps an unknown variant of [McpOAuthTokenEndpointAuthRotateParam] to a value of type [T].
         *
         * An instance of [McpOAuthTokenEndpointAuthRotateParam] can contain an unknown variant if
         * it was deserialized from data that doesn't match any known variant. For example, if the
         * SDK is on an older version than the API, then the API may respond with new variants that
         * the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown McpOAuthTokenEndpointAuthRotateParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<McpOAuthTokenEndpointAuthRotateParam>(
            McpOAuthTokenEndpointAuthRotateParam::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): McpOAuthTokenEndpointAuthRotateParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "client_secret_basic" -> {
                    return tryDeserialize(node, jacksonTypeRef<ClientSecretBasic>())?.let {
                        McpOAuthTokenEndpointAuthRotateParam(clientSecretBasic = it, _json = json)
                    } ?: McpOAuthTokenEndpointAuthRotateParam(_json = json)
                }
                "client_secret_post" -> {
                    return tryDeserialize(node, jacksonTypeRef<ClientSecretPost>())?.let {
                        McpOAuthTokenEndpointAuthRotateParam(clientSecretPost = it, _json = json)
                    } ?: McpOAuthTokenEndpointAuthRotateParam(_json = json)
                }
            }

            return McpOAuthTokenEndpointAuthRotateParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<McpOAuthTokenEndpointAuthRotateParam>(
            McpOAuthTokenEndpointAuthRotateParam::class
        ) {

        override fun serialize(
            value: McpOAuthTokenEndpointAuthRotateParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.clientSecretBasic != null -> generator.writeObject(value.clientSecretBasic)
                value.clientSecretPost != null -> generator.writeObject(value.clientSecretPost)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid McpOAuthTokenEndpointAuthRotateParam")
            }
        }
    }

    /** Updates credentials sent using HTTP Basic authentication. */
    class ClientSecretBasic
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonValue,
        private val clientSecret: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("client_secret")
            @ExcludeMissing
            clientSecret: JsonField<String> = JsonMissing.of(),
        ) : this(type, clientSecret, mutableMapOf())

        /**
         * The type of the object. Always `client_secret_basic`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("client_secret_basic")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The replacement OAuth client secret. Omit or pass `null` to keep the stored secret. This
         * secret is never returned in resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clientSecret(): Optional<String> = clientSecret.getOptional("client_secret")

        /**
         * Returns the raw JSON value of [clientSecret].
         *
         * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("client_secret")
        @ExcludeMissing
        fun _clientSecret(): JsonField<String> = clientSecret

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

            /** Returns a mutable builder for constructing an instance of [ClientSecretBasic]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClientSecretBasic]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("client_secret_basic")
            private var clientSecret: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecretBasic: ClientSecretBasic) = apply {
                type = clientSecretBasic.type
                clientSecret = clientSecretBasic.clientSecret
                additionalProperties = clientSecretBasic.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("client_secret_basic")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The replacement OAuth client secret. Omit or pass `null` to keep the stored secret.
             * This secret is never returned in resources.
             */
            fun clientSecret(clientSecret: String?) =
                clientSecret(JsonField.ofNullable(clientSecret))

            /** Alias for calling [Builder.clientSecret] with `clientSecret.orElse(null)`. */
            fun clientSecret(clientSecret: Optional<String>) =
                clientSecret(clientSecret.getOrNull())

            /**
             * Sets [Builder.clientSecret] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientSecret] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientSecret(clientSecret: JsonField<String>) = apply {
                this.clientSecret = clientSecret
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

            /**
             * Returns an immutable instance of [ClientSecretBasic].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ClientSecretBasic =
                ClientSecretBasic(type, clientSecret, additionalProperties.toMutableMap())
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
        fun validate(): ClientSecretBasic = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("client_secret_basic")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            clientSecret()
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
            type.let { if (it == JsonValue.from("client_secret_basic")) 1 else 0 } +
                (if (clientSecret.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ClientSecretBasic &&
                type == other.type &&
                clientSecret == other.clientSecret &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, clientSecret, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecretBasic{type=$type, clientSecret=$clientSecret, additionalProperties=$additionalProperties}"
    }

    /** Updates credentials sent in the token request body. */
    class ClientSecretPost
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonValue,
        private val clientSecret: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("client_secret")
            @ExcludeMissing
            clientSecret: JsonField<String> = JsonMissing.of(),
        ) : this(type, clientSecret, mutableMapOf())

        /**
         * The type of the object. Always `client_secret_post`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("client_secret_post")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The replacement OAuth client secret. Omit or pass `null` to keep the stored secret. This
         * secret is never returned in resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clientSecret(): Optional<String> = clientSecret.getOptional("client_secret")

        /**
         * Returns the raw JSON value of [clientSecret].
         *
         * Unlike [clientSecret], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("client_secret")
        @ExcludeMissing
        fun _clientSecret(): JsonField<String> = clientSecret

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

            /** Returns a mutable builder for constructing an instance of [ClientSecretPost]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClientSecretPost]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("client_secret_post")
            private var clientSecret: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecretPost: ClientSecretPost) = apply {
                type = clientSecretPost.type
                clientSecret = clientSecretPost.clientSecret
                additionalProperties = clientSecretPost.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("client_secret_post")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The replacement OAuth client secret. Omit or pass `null` to keep the stored secret.
             * This secret is never returned in resources.
             */
            fun clientSecret(clientSecret: String?) =
                clientSecret(JsonField.ofNullable(clientSecret))

            /** Alias for calling [Builder.clientSecret] with `clientSecret.orElse(null)`. */
            fun clientSecret(clientSecret: Optional<String>) =
                clientSecret(clientSecret.getOrNull())

            /**
             * Sets [Builder.clientSecret] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientSecret] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientSecret(clientSecret: JsonField<String>) = apply {
                this.clientSecret = clientSecret
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

            /**
             * Returns an immutable instance of [ClientSecretPost].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ClientSecretPost =
                ClientSecretPost(type, clientSecret, additionalProperties.toMutableMap())
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
        fun validate(): ClientSecretPost = apply {
            if (validated) {
                return@apply
            }

            _type().let {
                if (it != JsonValue.from("client_secret_post")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            clientSecret()
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
            type.let { if (it == JsonValue.from("client_secret_post")) 1 else 0 } +
                (if (clientSecret.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ClientSecretPost &&
                type == other.type &&
                clientSecret == other.clientSecret &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, clientSecret, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecretPost{type=$type, clientSecret=$clientSecret, additionalProperties=$additionalProperties}"
    }
}
