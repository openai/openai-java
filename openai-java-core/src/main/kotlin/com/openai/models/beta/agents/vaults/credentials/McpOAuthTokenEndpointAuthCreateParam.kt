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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Client authentication credentials for OAuth token refresh. */
@JsonDeserialize(using = McpOAuthTokenEndpointAuthCreateParam.Deserializer::class)
@JsonSerialize(using = McpOAuthTokenEndpointAuthCreateParam.Serializer::class)
class McpOAuthTokenEndpointAuthCreateParam
private constructor(
    private val none: JsonValue? = null,
    private val clientSecretBasic: ClientSecretBasic? = null,
    private val clientSecretPost: ClientSecretPost? = null,
    private val _json: JsonValue? = null,
) {

    /** Sends the client ID without a client secret. */
    fun none(): Optional<JsonValue> = Optional.ofNullable(none)

    /** Sends the client ID and secret using HTTP Basic authentication. */
    fun clientSecretBasic(): Optional<ClientSecretBasic> = Optional.ofNullable(clientSecretBasic)

    /** Sends the client ID and secret in the token request body. */
    fun clientSecretPost(): Optional<ClientSecretPost> = Optional.ofNullable(clientSecretPost)

    fun isNone(): Boolean = none != null

    fun isClientSecretBasic(): Boolean = clientSecretBasic != null

    fun isClientSecretPost(): Boolean = clientSecretPost != null

    /** Sends the client ID without a client secret. */
    fun asNone(): JsonValue = none.getOrThrow("none")

    /** Sends the client ID and secret using HTTP Basic authentication. */
    fun asClientSecretBasic(): ClientSecretBasic = clientSecretBasic.getOrThrow("clientSecretBasic")

    /** Sends the client ID and secret in the token request body. */
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
     * Optional<String> result = mcpOAuthTokenEndpointAuthCreateParam.accept(new McpOAuthTokenEndpointAuthCreateParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitNone(JsonValue none) {
     *         return Optional.of(none.toString());
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
            none != null -> visitor.visitNone(none)
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
    fun validate(): McpOAuthTokenEndpointAuthCreateParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitNone(none: JsonValue) {
                    none.let {
                        if (it != JsonValue.from(mapOf("type" to "none"))) {
                            throw OpenAIInvalidDataException("'none' is invalid, received $it")
                        }
                    }
                }

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
                override fun visitNone(none: JsonValue) =
                    none.let { if (it == JsonValue.from(mapOf("type" to "none"))) 1 else 0 }

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

        return other is McpOAuthTokenEndpointAuthCreateParam &&
            none == other.none &&
            clientSecretBasic == other.clientSecretBasic &&
            clientSecretPost == other.clientSecretPost
    }

    override fun hashCode(): Int = Objects.hash(none, clientSecretBasic, clientSecretPost)

    override fun toString(): String =
        when {
            none != null -> "McpOAuthTokenEndpointAuthCreateParam{none=$none}"
            clientSecretBasic != null ->
                "McpOAuthTokenEndpointAuthCreateParam{clientSecretBasic=$clientSecretBasic}"
            clientSecretPost != null ->
                "McpOAuthTokenEndpointAuthCreateParam{clientSecretPost=$clientSecretPost}"
            _json != null -> "McpOAuthTokenEndpointAuthCreateParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid McpOAuthTokenEndpointAuthCreateParam")
        }

    companion object {

        /** Sends the client ID without a client secret. */
        @JvmStatic
        fun ofNone() =
            McpOAuthTokenEndpointAuthCreateParam(none = JsonValue.from(mapOf("type" to "none")))

        /** Sends the client ID and secret using HTTP Basic authentication. */
        @JvmStatic
        fun ofClientSecretBasic(clientSecretBasic: ClientSecretBasic) =
            McpOAuthTokenEndpointAuthCreateParam(clientSecretBasic = clientSecretBasic)

        /** Sends the client ID and secret in the token request body. */
        @JvmStatic
        fun ofClientSecretPost(clientSecretPost: ClientSecretPost) =
            McpOAuthTokenEndpointAuthCreateParam(clientSecretPost = clientSecretPost)
    }

    /**
     * An interface that defines how to map each variant of [McpOAuthTokenEndpointAuthCreateParam]
     * to a value of type [T].
     */
    interface Visitor<out T> {

        /** Sends the client ID without a client secret. */
        fun visitNone(none: JsonValue): T

        /** Sends the client ID and secret using HTTP Basic authentication. */
        fun visitClientSecretBasic(clientSecretBasic: ClientSecretBasic): T

        /** Sends the client ID and secret in the token request body. */
        fun visitClientSecretPost(clientSecretPost: ClientSecretPost): T

        /**
         * Maps an unknown variant of [McpOAuthTokenEndpointAuthCreateParam] to a value of type [T].
         *
         * An instance of [McpOAuthTokenEndpointAuthCreateParam] can contain an unknown variant if
         * it was deserialized from data that doesn't match any known variant. For example, if the
         * SDK is on an older version than the API, then the API may respond with new variants that
         * the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown McpOAuthTokenEndpointAuthCreateParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<McpOAuthTokenEndpointAuthCreateParam>(
            McpOAuthTokenEndpointAuthCreateParam::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): McpOAuthTokenEndpointAuthCreateParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "none" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { McpOAuthTokenEndpointAuthCreateParam(none = it, _json = json) }
                        ?.takeIf { it.isValid() }
                        ?: McpOAuthTokenEndpointAuthCreateParam(_json = json)
                }
                "client_secret_basic" -> {
                    return tryDeserialize(node, jacksonTypeRef<ClientSecretBasic>())?.let {
                        McpOAuthTokenEndpointAuthCreateParam(clientSecretBasic = it, _json = json)
                    } ?: McpOAuthTokenEndpointAuthCreateParam(_json = json)
                }
                "client_secret_post" -> {
                    return tryDeserialize(node, jacksonTypeRef<ClientSecretPost>())?.let {
                        McpOAuthTokenEndpointAuthCreateParam(clientSecretPost = it, _json = json)
                    } ?: McpOAuthTokenEndpointAuthCreateParam(_json = json)
                }
            }

            return McpOAuthTokenEndpointAuthCreateParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<McpOAuthTokenEndpointAuthCreateParam>(
            McpOAuthTokenEndpointAuthCreateParam::class
        ) {

        override fun serialize(
            value: McpOAuthTokenEndpointAuthCreateParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.none != null -> generator.writeObject(value.none)
                value.clientSecretBasic != null -> generator.writeObject(value.clientSecretBasic)
                value.clientSecretPost != null -> generator.writeObject(value.clientSecretPost)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid McpOAuthTokenEndpointAuthCreateParam")
            }
        }
    }

    /** Sends the client ID and secret using HTTP Basic authentication. */
    class ClientSecretBasic
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val clientSecret: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("client_secret")
            @ExcludeMissing
            clientSecret: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(clientSecret, type, mutableMapOf())

        /**
         * The OAuth client secret to store. Never returned in credential resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun clientSecret(): String = clientSecret.getRequired("client_secret")

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

            /**
             * Returns a mutable builder for constructing an instance of [ClientSecretBasic].
             *
             * The following fields are required:
             * ```java
             * .clientSecret()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClientSecretBasic]. */
        class Builder internal constructor() {

            private var clientSecret: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("client_secret_basic")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecretBasic: ClientSecretBasic) = apply {
                clientSecret = clientSecretBasic.clientSecret
                type = clientSecretBasic.type
                additionalProperties = clientSecretBasic.additionalProperties.toMutableMap()
            }

            /** The OAuth client secret to store. Never returned in credential resources. */
            fun clientSecret(clientSecret: String) = clientSecret(JsonField.of(clientSecret))

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
             *
             * The following fields are required:
             * ```java
             * .clientSecret()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ClientSecretBasic =
                ClientSecretBasic(
                    checkRequired("clientSecret", clientSecret),
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
        fun validate(): ClientSecretBasic = apply {
            if (validated) {
                return@apply
            }

            clientSecret()
            _type().let {
                if (it != JsonValue.from("client_secret_basic")) {
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
            (if (clientSecret.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("client_secret_basic")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ClientSecretBasic &&
                clientSecret == other.clientSecret &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(clientSecret, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecretBasic{clientSecret=$clientSecret, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Sends the client ID and secret in the token request body. */
    class ClientSecretPost
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val clientSecret: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("client_secret")
            @ExcludeMissing
            clientSecret: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(clientSecret, type, mutableMapOf())

        /**
         * The OAuth client secret to store. Never returned in credential resources.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun clientSecret(): String = clientSecret.getRequired("client_secret")

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

            /**
             * Returns a mutable builder for constructing an instance of [ClientSecretPost].
             *
             * The following fields are required:
             * ```java
             * .clientSecret()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ClientSecretPost]. */
        class Builder internal constructor() {

            private var clientSecret: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("client_secret_post")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(clientSecretPost: ClientSecretPost) = apply {
                clientSecret = clientSecretPost.clientSecret
                type = clientSecretPost.type
                additionalProperties = clientSecretPost.additionalProperties.toMutableMap()
            }

            /** The OAuth client secret to store. Never returned in credential resources. */
            fun clientSecret(clientSecret: String) = clientSecret(JsonField.of(clientSecret))

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
             *
             * The following fields are required:
             * ```java
             * .clientSecret()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ClientSecretPost =
                ClientSecretPost(
                    checkRequired("clientSecret", clientSecret),
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
        fun validate(): ClientSecretPost = apply {
            if (validated) {
                return@apply
            }

            clientSecret()
            _type().let {
                if (it != JsonValue.from("client_secret_post")) {
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
            (if (clientSecret.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("client_secret_post")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ClientSecretPost &&
                clientSecret == other.clientSecret &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(clientSecret, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ClientSecretPost{clientSecret=$clientSecret, type=$type, additionalProperties=$additionalProperties}"
    }
}
