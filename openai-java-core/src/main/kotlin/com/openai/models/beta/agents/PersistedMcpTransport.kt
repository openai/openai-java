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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A credential-free transport used to connect to an MCP server. */
@JsonDeserialize(using = PersistedMcpTransport.Deserializer::class)
@JsonSerialize(using = PersistedMcpTransport.Serializer::class)
class PersistedMcpTransport
private constructor(
    private val http: Http? = null,
    private val stdio: Stdio? = null,
    private val _json: JsonValue? = null,
) {

    /** Connects to an MCP server over HTTP. */
    fun http(): Optional<Http> = Optional.ofNullable(http)

    /** Starts an MCP server as a local process. */
    fun stdio(): Optional<Stdio> = Optional.ofNullable(stdio)

    fun isHttp(): Boolean = http != null

    fun isStdio(): Boolean = stdio != null

    /** Connects to an MCP server over HTTP. */
    fun asHttp(): Http = http.getOrThrow("http")

    /** Starts an MCP server as a local process. */
    fun asStdio(): Stdio = stdio.getOrThrow("stdio")

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
     * Optional<String> result = persistedMcpTransport.accept(new PersistedMcpTransport.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitHttp(Http http) {
     *         return Optional.of(http.toString());
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
            http != null -> visitor.visitHttp(http)
            stdio != null -> visitor.visitStdio(stdio)
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
    fun validate(): PersistedMcpTransport = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitHttp(http: Http) {
                    http.validate()
                }

                override fun visitStdio(stdio: Stdio) {
                    stdio.validate()
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
                override fun visitHttp(http: Http) = http.validity()

                override fun visitStdio(stdio: Stdio) = stdio.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PersistedMcpTransport && http == other.http && stdio == other.stdio
    }

    override fun hashCode(): Int = Objects.hash(http, stdio)

    override fun toString(): String =
        when {
            http != null -> "PersistedMcpTransport{http=$http}"
            stdio != null -> "PersistedMcpTransport{stdio=$stdio}"
            _json != null -> "PersistedMcpTransport{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid PersistedMcpTransport")
        }

    companion object {

        /** Connects to an MCP server over HTTP. */
        @JvmStatic fun ofHttp(http: Http) = PersistedMcpTransport(http = http)

        /** Starts an MCP server as a local process. */
        @JvmStatic fun ofStdio(stdio: Stdio) = PersistedMcpTransport(stdio = stdio)
    }

    /**
     * An interface that defines how to map each variant of [PersistedMcpTransport] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Connects to an MCP server over HTTP. */
        fun visitHttp(http: Http): T

        /** Starts an MCP server as a local process. */
        fun visitStdio(stdio: Stdio): T

        /**
         * Maps an unknown variant of [PersistedMcpTransport] to a value of type [T].
         *
         * An instance of [PersistedMcpTransport] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown PersistedMcpTransport: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<PersistedMcpTransport>(PersistedMcpTransport::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): PersistedMcpTransport {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "http" -> {
                    return tryDeserialize(node, jacksonTypeRef<Http>())?.let {
                        PersistedMcpTransport(http = it, _json = json)
                    } ?: PersistedMcpTransport(_json = json)
                }
                "stdio" -> {
                    return tryDeserialize(node, jacksonTypeRef<Stdio>())?.let {
                        PersistedMcpTransport(stdio = it, _json = json)
                    } ?: PersistedMcpTransport(_json = json)
                }
            }

            return PersistedMcpTransport(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<PersistedMcpTransport>(PersistedMcpTransport::class) {

        override fun serialize(
            value: PersistedMcpTransport,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.http != null -> generator.writeObject(value.http)
                value.stdio != null -> generator.writeObject(value.stdio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid PersistedMcpTransport")
            }
        }
    }

    /** Connects to an MCP server over HTTP. */
    class Http
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val headers: JsonField<Headers>,
        private val serverUrl: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("server_url")
            @ExcludeMissing
            serverUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(headers, serverUrl, type, mutableMapOf())

        /**
         * Non-secret HTTP headers sent to the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun headers(): Headers = headers.getRequired("headers")

        /**
         * The URL of the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverUrl(): String = serverUrl.getRequired("server_url")

        /**
         * The type of the object. Always `http`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("http")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

        /**
         * Returns the raw JSON value of [serverUrl].
         *
         * Unlike [serverUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_url") @ExcludeMissing fun _serverUrl(): JsonField<String> = serverUrl

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
             * Returns a mutable builder for constructing an instance of [Http].
             *
             * The following fields are required:
             * ```java
             * .headers()
             * .serverUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Http]. */
        class Builder internal constructor() {

            private var headers: JsonField<Headers>? = null
            private var serverUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("http")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(http: Http) = apply {
                headers = http.headers
                serverUrl = http.serverUrl
                type = http.type
                additionalProperties = http.additionalProperties.toMutableMap()
            }

            /** Non-secret HTTP headers sent to the MCP server. */
            fun headers(headers: Headers) = headers(JsonField.of(headers))

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            /** The URL of the MCP server. */
            fun serverUrl(serverUrl: String) = serverUrl(JsonField.of(serverUrl))

            /**
             * Sets [Builder.serverUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverUrl(serverUrl: JsonField<String>) = apply { this.serverUrl = serverUrl }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("http")
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
             * Returns an immutable instance of [Http].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .headers()
             * .serverUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Http =
                Http(
                    checkRequired("headers", headers),
                    checkRequired("serverUrl", serverUrl),
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
        fun validate(): Http = apply {
            if (validated) {
                return@apply
            }

            headers().validate()
            serverUrl()
            _type().let {
                if (it != JsonValue.from("http")) {
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
            (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (serverUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("http")) 1 else 0 }

        /** Non-secret HTTP headers sent to the MCP server. */
        class Headers
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Headers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Headers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(headers: Headers) = apply {
                    additionalProperties = headers.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Headers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Headers = apply {
                if (validated) {
                    return@apply
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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Headers && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Headers{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Http &&
                headers == other.headers &&
                serverUrl == other.serverUrl &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(headers, serverUrl, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Http{headers=$headers, serverUrl=$serverUrl, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Starts an MCP server as a local process. */
    class Stdio
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val args: JsonField<List<String>>,
        private val command: JsonField<String>,
        private val cwd: JsonField<String>,
        private val envVars: JsonField<List<String>>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("args") @ExcludeMissing args: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("command") @ExcludeMissing command: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cwd") @ExcludeMissing cwd: JsonField<String> = JsonMissing.of(),
            @JsonProperty("env_vars")
            @ExcludeMissing
            envVars: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(args, command, cwd, envVars, type, mutableMapOf())

        /**
         * Arguments passed to the MCP server command.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun args(): List<String> = args.getRequired("args")

        /**
         * The command used to start the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun command(): String = command.getRequired("command")

        /**
         * The working directory used to start the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun cwd(): String = cwd.getRequired("cwd")

        /**
         * Environment variable names inherited from the execution environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun envVars(): List<String> = envVars.getRequired("env_vars")

        /**
         * The type of the object. Always `stdio`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("stdio")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [args].
         *
         * Unlike [args], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("args") @ExcludeMissing fun _args(): JsonField<List<String>> = args

        /**
         * Returns the raw JSON value of [command].
         *
         * Unlike [command], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("command") @ExcludeMissing fun _command(): JsonField<String> = command

        /**
         * Returns the raw JSON value of [cwd].
         *
         * Unlike [cwd], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cwd") @ExcludeMissing fun _cwd(): JsonField<String> = cwd

        /**
         * Returns the raw JSON value of [envVars].
         *
         * Unlike [envVars], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("env_vars") @ExcludeMissing fun _envVars(): JsonField<List<String>> = envVars

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
             * Returns a mutable builder for constructing an instance of [Stdio].
             *
             * The following fields are required:
             * ```java
             * .args()
             * .command()
             * .cwd()
             * .envVars()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Stdio]. */
        class Builder internal constructor() {

            private var args: JsonField<MutableList<String>>? = null
            private var command: JsonField<String>? = null
            private var cwd: JsonField<String>? = null
            private var envVars: JsonField<MutableList<String>>? = null
            private var type: JsonValue = JsonValue.from("stdio")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stdio: Stdio) = apply {
                args = stdio.args.map { it.toMutableList() }
                command = stdio.command
                cwd = stdio.cwd
                envVars = stdio.envVars.map { it.toMutableList() }
                type = stdio.type
                additionalProperties = stdio.additionalProperties.toMutableMap()
            }

            /** Arguments passed to the MCP server command. */
            fun args(args: List<String>) = args(JsonField.of(args))

            /**
             * Sets [Builder.args] to an arbitrary JSON value.
             *
             * You should usually call [Builder.args] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun args(args: JsonField<List<String>>) = apply {
                this.args = args.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [args].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addArg(arg: String) = apply {
                args =
                    (args ?: JsonField.of(mutableListOf())).also { checkKnown("args", it).add(arg) }
            }

            /** The command used to start the MCP server. */
            fun command(command: String) = command(JsonField.of(command))

            /**
             * Sets [Builder.command] to an arbitrary JSON value.
             *
             * You should usually call [Builder.command] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun command(command: JsonField<String>) = apply { this.command = command }

            /** The working directory used to start the MCP server. */
            fun cwd(cwd: String) = cwd(JsonField.of(cwd))

            /**
             * Sets [Builder.cwd] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cwd] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun cwd(cwd: JsonField<String>) = apply { this.cwd = cwd }

            /** Environment variable names inherited from the execution environment. */
            fun envVars(envVars: List<String>) = envVars(JsonField.of(envVars))

            /**
             * Sets [Builder.envVars] to an arbitrary JSON value.
             *
             * You should usually call [Builder.envVars] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun envVars(envVars: JsonField<List<String>>) = apply {
                this.envVars = envVars.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [envVars].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEnvVar(envVar: String) = apply {
                envVars =
                    (envVars ?: JsonField.of(mutableListOf())).also {
                        checkKnown("envVars", it).add(envVar)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("stdio")
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
             * Returns an immutable instance of [Stdio].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .args()
             * .command()
             * .cwd()
             * .envVars()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Stdio =
                Stdio(
                    checkRequired("args", args).map { it.toImmutable() },
                    checkRequired("command", command),
                    checkRequired("cwd", cwd),
                    checkRequired("envVars", envVars).map { it.toImmutable() },
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
        fun validate(): Stdio = apply {
            if (validated) {
                return@apply
            }

            args()
            command()
            cwd()
            envVars()
            _type().let {
                if (it != JsonValue.from("stdio")) {
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
            (args.asKnown().getOrNull()?.size ?: 0) +
                (if (command.asKnown().isPresent) 1 else 0) +
                (if (cwd.asKnown().isPresent) 1 else 0) +
                (envVars.asKnown().getOrNull()?.size ?: 0) +
                type.let { if (it == JsonValue.from("stdio")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Stdio &&
                args == other.args &&
                command == other.command &&
                cwd == other.cwd &&
                envVars == other.envVars &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(args, command, cwd, envVars, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Stdio{args=$args, command=$command, cwd=$cwd, envVars=$envVars, type=$type, additionalProperties=$additionalProperties}"
    }
}
