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
@JsonDeserialize(using = PersistedMcpTransportParam.Deserializer::class)
@JsonSerialize(using = PersistedMcpTransportParam.Serializer::class)
class PersistedMcpTransportParam
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
     * Optional<String> result = persistedMcpTransportParam.accept(new PersistedMcpTransportParam.Visitor<Optional<String>>() {
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
    fun validate(): PersistedMcpTransportParam = apply {
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

        return other is PersistedMcpTransportParam && http == other.http && stdio == other.stdio
    }

    override fun hashCode(): Int = Objects.hash(http, stdio)

    override fun toString(): String =
        when {
            http != null -> "PersistedMcpTransportParam{http=$http}"
            stdio != null -> "PersistedMcpTransportParam{stdio=$stdio}"
            _json != null -> "PersistedMcpTransportParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid PersistedMcpTransportParam")
        }

    companion object {

        /** Connects to an MCP server over HTTP. */
        @JvmStatic fun ofHttp(http: Http) = PersistedMcpTransportParam(http = http)

        /** Starts an MCP server as a local process. */
        @JvmStatic fun ofStdio(stdio: Stdio) = PersistedMcpTransportParam(stdio = stdio)
    }

    /**
     * An interface that defines how to map each variant of [PersistedMcpTransportParam] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Connects to an MCP server over HTTP. */
        fun visitHttp(http: Http): T

        /** Starts an MCP server as a local process. */
        fun visitStdio(stdio: Stdio): T

        /**
         * Maps an unknown variant of [PersistedMcpTransportParam] to a value of type [T].
         *
         * An instance of [PersistedMcpTransportParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown PersistedMcpTransportParam: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<PersistedMcpTransportParam>(PersistedMcpTransportParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): PersistedMcpTransportParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "http" -> {
                    return tryDeserialize(node, jacksonTypeRef<Http>())?.let {
                        PersistedMcpTransportParam(http = it, _json = json)
                    } ?: PersistedMcpTransportParam(_json = json)
                }
                "stdio" -> {
                    return tryDeserialize(node, jacksonTypeRef<Stdio>())?.let {
                        PersistedMcpTransportParam(stdio = it, _json = json)
                    } ?: PersistedMcpTransportParam(_json = json)
                }
            }

            return PersistedMcpTransportParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<PersistedMcpTransportParam>(PersistedMcpTransportParam::class) {

        override fun serialize(
            value: PersistedMcpTransportParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.http != null -> generator.writeObject(value.http)
                value.stdio != null -> generator.writeObject(value.stdio)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid PersistedMcpTransportParam")
            }
        }
    }

    /** Connects to an MCP server over HTTP. */
    class Http
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val serverUrl: JsonField<String>,
        private val type: JsonValue,
        private val headers: JsonField<Headers>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("server_url")
            @ExcludeMissing
            serverUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
        ) : this(serverUrl, type, headers, mutableMapOf())

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
         * Non-secret HTTP headers sent to the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

        /**
         * Returns the raw JSON value of [serverUrl].
         *
         * Unlike [serverUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_url") @ExcludeMissing fun _serverUrl(): JsonField<String> = serverUrl

        /**
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

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
             * .serverUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Http]. */
        class Builder internal constructor() {

            private var serverUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("http")
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(http: Http) = apply {
                serverUrl = http.serverUrl
                type = http.type
                headers = http.headers
                additionalProperties = http.additionalProperties.toMutableMap()
            }

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

            /** Non-secret HTTP headers sent to the MCP server. */
            fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

            /** Alias for calling [Builder.headers] with `headers.orElse(null)`. */
            fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

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
             * .serverUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Http =
                Http(
                    checkRequired("serverUrl", serverUrl),
                    type,
                    headers,
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

            serverUrl()
            _type().let {
                if (it != JsonValue.from("http")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            headers().ifPresent { it.validate() }
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
            (if (serverUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("http")) 1 else 0 } +
                (headers.asKnown().getOrNull()?.validity() ?: 0)

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
                serverUrl == other.serverUrl &&
                type == other.type &&
                headers == other.headers &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(serverUrl, type, headers, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Http{serverUrl=$serverUrl, type=$type, headers=$headers, additionalProperties=$additionalProperties}"
    }

    /** Starts an MCP server as a local process. */
    class Stdio
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val command: JsonField<String>,
        private val cwd: JsonField<String>,
        private val type: JsonValue,
        private val args: JsonField<List<String>>,
        private val envVars: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("command") @ExcludeMissing command: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cwd") @ExcludeMissing cwd: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("args") @ExcludeMissing args: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("env_vars")
            @ExcludeMissing
            envVars: JsonField<List<String>> = JsonMissing.of(),
        ) : this(command, cwd, type, args, envVars, mutableMapOf())

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
         * Arguments passed to the MCP server command.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun args(): Optional<List<String>> = args.getOptional("args")

        /**
         * Environment variable names to inherit from the selected execution environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun envVars(): Optional<List<String>> = envVars.getOptional("env_vars")

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
         * Returns the raw JSON value of [args].
         *
         * Unlike [args], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("args") @ExcludeMissing fun _args(): JsonField<List<String>> = args

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
             * .command()
             * .cwd()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Stdio]. */
        class Builder internal constructor() {

            private var command: JsonField<String>? = null
            private var cwd: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("stdio")
            private var args: JsonField<MutableList<String>>? = null
            private var envVars: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stdio: Stdio) = apply {
                command = stdio.command
                cwd = stdio.cwd
                type = stdio.type
                args = stdio.args.map { it.toMutableList() }
                envVars = stdio.envVars.map { it.toMutableList() }
                additionalProperties = stdio.additionalProperties.toMutableMap()
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

            /** Arguments passed to the MCP server command. */
            fun args(args: List<String>?) = args(JsonField.ofNullable(args))

            /** Alias for calling [Builder.args] with `args.orElse(null)`. */
            fun args(args: Optional<List<String>>) = args(args.getOrNull())

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

            /** Environment variable names to inherit from the selected execution environment. */
            fun envVars(envVars: List<String>?) = envVars(JsonField.ofNullable(envVars))

            /** Alias for calling [Builder.envVars] with `envVars.orElse(null)`. */
            fun envVars(envVars: Optional<List<String>>) = envVars(envVars.getOrNull())

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
             * .command()
             * .cwd()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Stdio =
                Stdio(
                    checkRequired("command", command),
                    checkRequired("cwd", cwd),
                    type,
                    (args ?: JsonMissing.of()).map { it.toImmutable() },
                    (envVars ?: JsonMissing.of()).map { it.toImmutable() },
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

            command()
            cwd()
            _type().let {
                if (it != JsonValue.from("stdio")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            args()
            envVars()
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
            (if (command.asKnown().isPresent) 1 else 0) +
                (if (cwd.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("stdio")) 1 else 0 } +
                (args.asKnown().getOrNull()?.size ?: 0) +
                (envVars.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Stdio &&
                command == other.command &&
                cwd == other.cwd &&
                type == other.type &&
                args == other.args &&
                envVars == other.envVars &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(command, cwd, type, args, envVars, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Stdio{command=$command, cwd=$cwd, type=$type, args=$args, envVars=$envVars, additionalProperties=$additionalProperties}"
    }
}
