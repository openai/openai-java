// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions

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
import com.openai.core.Params
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.EnvironmentParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a managed agent session, optionally submits initial input, and returns the session or
 * streams its events when stream is true. See
 * [running sessions](https://developers.openai.com/api/docs/guides/agents-api/sessions).
 */
class SessionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * An inline execution environment or a reference to an environment template.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun environment(): EnvironmentParam = body.environment()

    /**
     * Agent configuration. With `agent_id`, supplied fields override the saved agent for this
     * session. Without `agent_id`, `model` is required.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agent(): Optional<Agent> = body.agent()

    /**
     * The ID of a saved reusable agent. Omit `agent` to use its configuration unchanged.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agentId(): Optional<String> = body.agentId()

    /**
     * Initial input submitted when creating a session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun input(): Optional<Input> = body.input()

    /**
     * Up to 16 string key-value pairs, with keys up to 64 and values up to 512 characters. Omission
     * or null defaults to an empty map.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * The IDs of vaults made available to the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vaultIds(): Optional<List<String>> = body.vaultIds()

    /**
     * Returns the raw JSON value of [environment].
     *
     * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _environment(): JsonField<EnvironmentParam> = body._environment()

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agent(): JsonField<Agent> = body._agent()

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agentId(): JsonField<String> = body._agentId()

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _input(): JsonField<Input> = body._input()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [vaultIds].
     *
     * Unlike [vaultIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _vaultIds(): JsonField<List<String>> = body._vaultIds()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SessionCreateParams].
         *
         * The following fields are required:
         * ```java
         * .environment()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(sessionCreateParams: SessionCreateParams) = apply {
            body = sessionCreateParams.body.toBuilder()
            additionalHeaders = sessionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = sessionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [environment]
         * - [agent]
         * - [agentId]
         * - [input]
         * - [metadata]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** An inline execution environment or a reference to an environment template. */
        fun environment(environment: EnvironmentParam) = apply { body.environment(environment) }

        /**
         * Sets [Builder.environment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.environment] with a well-typed [EnvironmentParam] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun environment(environment: JsonField<EnvironmentParam>) = apply {
            body.environment(environment)
        }

        /** Alias for calling [environment] with `EnvironmentParam.ofNone()`. */
        fun environmentNone() = apply { body.environmentNone() }

        /** Alias for calling [environment] with `EnvironmentParam.ofOpenAIHosted(openaiHosted)`. */
        fun environment(openaiHosted: EnvironmentParam.OpenAIHosted) = apply {
            body.environment(openaiHosted)
        }

        /** Alias for calling [environment] with `EnvironmentParam.ofSelfHosted(selfHosted)`. */
        fun environment(selfHosted: EnvironmentParam.SelfHosted) = apply {
            body.environment(selfHosted)
        }

        /**
         * Alias for calling [environment] with the following:
         * ```java
         * EnvironmentParam.SelfHosted.builder()
         *     .workspaceDirectory(workspaceDirectory)
         *     .build()
         * ```
         */
        fun selfHostedEnvironment(workspaceDirectory: String) = apply {
            body.selfHostedEnvironment(workspaceDirectory)
        }

        /**
         * Agent configuration. With `agent_id`, supplied fields override the saved agent for this
         * session. Without `agent_id`, `model` is required.
         */
        fun agent(agent: Agent) = apply { body.agent(agent) }

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<Agent>) = apply { body.agent(agent) }

        /** The ID of a saved reusable agent. Omit `agent` to use its configuration unchanged. */
        fun agentId(agentId: String) = apply { body.agentId(agentId) }

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { body.agentId(agentId) }

        /** Initial input submitted when creating a session. */
        fun input(input: Input?) = apply { body.input(input) }

        /** Alias for calling [Builder.input] with `input.orElse(null)`. */
        fun input(input: Optional<Input>) = input(input.getOrNull())

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [Input] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<Input>) = apply { body.input(input) }

        /** Alias for calling [input] with `Input.ofString(string)`. */
        fun input(string: String) = apply { body.input(string) }

        /**
         * Alias for calling [input] with
         * `Input.ofAgentSessionInputMessageParams(agentSessionInputMessageParams)`.
         */
        fun inputOfAgentSessionInputMessageParams(
            agentSessionInputMessageParams: List<AgentSessionInputMessageParam>
        ) = apply { body.inputOfAgentSessionInputMessageParams(agentSessionInputMessageParams) }

        /**
         * Up to 16 string key-value pairs, with keys up to 64 and values up to 512 characters.
         * Omission or null defaults to an empty map.
         */
        fun metadata(metadata: Metadata?) = apply { body.metadata(metadata) }

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /** The IDs of vaults made available to the session. */
        fun vaultIds(vaultIds: List<String>?) = apply { body.vaultIds(vaultIds) }

        /** Alias for calling [Builder.vaultIds] with `vaultIds.orElse(null)`. */
        fun vaultIds(vaultIds: Optional<List<String>>) = vaultIds(vaultIds.getOrNull())

        /**
         * Sets [Builder.vaultIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vaultIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun vaultIds(vaultIds: JsonField<List<String>>) = apply { body.vaultIds(vaultIds) }

        /**
         * Adds a single [String] to [vaultIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVaultId(vaultId: String) = apply { body.addVaultId(vaultId) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [SessionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .environment()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SessionCreateParams =
            SessionCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Parameters for creating a Managed Agents session. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val environment: JsonField<EnvironmentParam>,
        private val agent: JsonField<Agent>,
        private val agentId: JsonField<String>,
        private val input: JsonField<Input>,
        private val metadata: JsonField<Metadata>,
        private val vaultIds: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("environment")
            @ExcludeMissing
            environment: JsonField<EnvironmentParam> = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<Input> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("vault_ids")
            @ExcludeMissing
            vaultIds: JsonField<List<String>> = JsonMissing.of(),
        ) : this(environment, agent, agentId, input, metadata, vaultIds, mutableMapOf())

        /**
         * An inline execution environment or a reference to an environment template.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun environment(): EnvironmentParam = environment.getRequired("environment")

        /**
         * Agent configuration. With `agent_id`, supplied fields override the saved agent for this
         * session. Without `agent_id`, `model` is required.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * The ID of a saved reusable agent. Omit `agent` to use its configuration unchanged.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agentId(): Optional<String> = agentId.getOptional("agent_id")

        /**
         * Initial input submitted when creating a session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun input(): Optional<Input> = input.getOptional("input")

        /**
         * Up to 16 string key-value pairs, with keys up to 64 and values up to 512 characters.
         * Omission or null defaults to an empty map.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * The IDs of vaults made available to the session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun vaultIds(): Optional<List<String>> = vaultIds.getOptional("vault_ids")

        /**
         * Returns the raw JSON value of [environment].
         *
         * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("environment")
        @ExcludeMissing
        fun _environment(): JsonField<EnvironmentParam> = environment

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [agentId].
         *
         * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<Input> = input

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [vaultIds].
         *
         * Unlike [vaultIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("vault_ids")
        @ExcludeMissing
        fun _vaultIds(): JsonField<List<String>> = vaultIds

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .environment()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var environment: JsonField<EnvironmentParam>? = null
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var agentId: JsonField<String> = JsonMissing.of()
            private var input: JsonField<Input> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var vaultIds: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                environment = body.environment
                agent = body.agent
                agentId = body.agentId
                input = body.input
                metadata = body.metadata
                vaultIds = body.vaultIds.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** An inline execution environment or a reference to an environment template. */
            fun environment(environment: EnvironmentParam) = environment(JsonField.of(environment))

            /**
             * Sets [Builder.environment] to an arbitrary JSON value.
             *
             * You should usually call [Builder.environment] with a well-typed [EnvironmentParam]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun environment(environment: JsonField<EnvironmentParam>) = apply {
                this.environment = environment
            }

            /** Alias for calling [environment] with `EnvironmentParam.ofNone()`. */
            fun environmentNone() = environment(EnvironmentParam.ofNone())

            /**
             * Alias for calling [environment] with `EnvironmentParam.ofOpenAIHosted(openaiHosted)`.
             */
            fun environment(openaiHosted: EnvironmentParam.OpenAIHosted) =
                environment(EnvironmentParam.ofOpenAIHosted(openaiHosted))

            /** Alias for calling [environment] with `EnvironmentParam.ofSelfHosted(selfHosted)`. */
            fun environment(selfHosted: EnvironmentParam.SelfHosted) =
                environment(EnvironmentParam.ofSelfHosted(selfHosted))

            /**
             * Alias for calling [environment] with the following:
             * ```java
             * EnvironmentParam.SelfHosted.builder()
             *     .workspaceDirectory(workspaceDirectory)
             *     .build()
             * ```
             */
            fun selfHostedEnvironment(workspaceDirectory: String) =
                environment(
                    EnvironmentParam.SelfHosted.builder()
                        .workspaceDirectory(workspaceDirectory)
                        .build()
                )

            /**
             * Agent configuration. With `agent_id`, supplied fields override the saved agent for
             * this session. Without `agent_id`, `model` is required.
             */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /**
             * The ID of a saved reusable agent. Omit `agent` to use its configuration unchanged.
             */
            fun agentId(agentId: String) = agentId(JsonField.of(agentId))

            /**
             * Sets [Builder.agentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

            /** Initial input submitted when creating a session. */
            fun input(input: Input?) = input(JsonField.ofNullable(input))

            /** Alias for calling [Builder.input] with `input.orElse(null)`. */
            fun input(input: Optional<Input>) = input(input.getOrNull())

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed [Input] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun input(input: JsonField<Input>) = apply { this.input = input }

            /** Alias for calling [input] with `Input.ofString(string)`. */
            fun input(string: String) = input(Input.ofString(string))

            /**
             * Alias for calling [input] with
             * `Input.ofAgentSessionInputMessageParams(agentSessionInputMessageParams)`.
             */
            fun inputOfAgentSessionInputMessageParams(
                agentSessionInputMessageParams: List<AgentSessionInputMessageParam>
            ) = input(Input.ofAgentSessionInputMessageParams(agentSessionInputMessageParams))

            /**
             * Up to 16 string key-value pairs, with keys up to 64 and values up to 512 characters.
             * Omission or null defaults to an empty map.
             */
            fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

            /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /** The IDs of vaults made available to the session. */
            fun vaultIds(vaultIds: List<String>?) = vaultIds(JsonField.ofNullable(vaultIds))

            /** Alias for calling [Builder.vaultIds] with `vaultIds.orElse(null)`. */
            fun vaultIds(vaultIds: Optional<List<String>>) = vaultIds(vaultIds.getOrNull())

            /**
             * Sets [Builder.vaultIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vaultIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun vaultIds(vaultIds: JsonField<List<String>>) = apply {
                this.vaultIds = vaultIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [vaultIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addVaultId(vaultId: String) = apply {
                vaultIds =
                    (vaultIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("vaultIds", it).add(vaultId)
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .environment()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("environment", environment),
                    agent,
                    agentId,
                    input,
                    metadata,
                    (vaultIds ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            environment().validate()
            agent().ifPresent { it.validate() }
            agentId()
            input().ifPresent { it.validate() }
            metadata().ifPresent { it.validate() }
            vaultIds()
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
            (environment.asKnown().getOrNull()?.validity() ?: 0) +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (agentId.asKnown().isPresent) 1 else 0) +
                (input.asKnown().getOrNull()?.validity() ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (vaultIds.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                environment == other.environment &&
                agent == other.agent &&
                agentId == other.agentId &&
                input == other.input &&
                metadata == other.metadata &&
                vaultIds == other.vaultIds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                environment,
                agent,
                agentId,
                input,
                metadata,
                vaultIds,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{environment=$environment, agent=$agent, agentId=$agentId, input=$input, metadata=$metadata, vaultIds=$vaultIds, additionalProperties=$additionalProperties}"
    }

    /**
     * Agent configuration. With `agent_id`, supplied fields override the saved agent for this
     * session. Without `agent_id`, `model` is required.
     */
    class Agent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val instructions: JsonField<String>,
        private val model: JsonField<String>,
        private val multiAgent: JsonField<MultiAgentConfigParam>,
        private val reasoning: JsonField<AgentReasoningParam>,
        private val serviceTier: JsonField<ServiceTier>,
        private val text: JsonField<AgentTextParam>,
        private val tools: JsonField<List<AgentToolParam>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("multi_agent")
            @ExcludeMissing
            multiAgent: JsonField<MultiAgentConfigParam> = JsonMissing.of(),
            @JsonProperty("reasoning")
            @ExcludeMissing
            reasoning: JsonField<AgentReasoningParam> = JsonMissing.of(),
            @JsonProperty("service_tier")
            @ExcludeMissing
            serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
            @JsonProperty("text")
            @ExcludeMissing
            text: JsonField<AgentTextParam> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<AgentToolParam>> = JsonMissing.of(),
        ) : this(
            instructions,
            model,
            multiAgent,
            reasoning,
            serviceTier,
            text,
            tools,
            mutableMapOf(),
        )

        /**
         * Additional instructions appended to the agent's default base instructions. Omit to leave
         * unchanged.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> = instructions.getOptional("instructions")

        /**
         * The model to use for the agent. The requested model name is preserved.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun model(): Optional<String> = model.getOptional("model")

        /**
         * Explicit configuration for creating and coordinating subagents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun multiAgent(): Optional<MultiAgentConfigParam> = multiAgent.getOptional("multi_agent")

        /**
         * Reasoning configuration for the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reasoning(): Optional<AgentReasoningParam> = reasoning.getOptional("reasoning")

        /**
         * The service tier used for model requests.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun serviceTier(): Optional<ServiceTier> = serviceTier.getOptional("service_tier")

        /**
         * Configuration for text generated by the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun text(): Optional<AgentTextParam> = text.getOptional("text")

        /**
         * Tools available to the agent. Omit to inherit, or pass null to clear them.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tools(): Optional<List<AgentToolParam>> = tools.getOptional("tools")

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [multiAgent].
         *
         * Unlike [multiAgent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("multi_agent")
        @ExcludeMissing
        fun _multiAgent(): JsonField<MultiAgentConfigParam> = multiAgent

        /**
         * Returns the raw JSON value of [reasoning].
         *
         * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reasoning")
        @ExcludeMissing
        fun _reasoning(): JsonField<AgentReasoningParam> = reasoning

        /**
         * Returns the raw JSON value of [serviceTier].
         *
         * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("service_tier")
        @ExcludeMissing
        fun _serviceTier(): JsonField<ServiceTier> = serviceTier

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<AgentTextParam> = text

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AgentToolParam>> = tools

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

            /** Returns a mutable builder for constructing an instance of [Agent]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Agent]. */
        class Builder internal constructor() {

            private var instructions: JsonField<String> = JsonMissing.of()
            private var model: JsonField<String> = JsonMissing.of()
            private var multiAgent: JsonField<MultiAgentConfigParam> = JsonMissing.of()
            private var reasoning: JsonField<AgentReasoningParam> = JsonMissing.of()
            private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
            private var text: JsonField<AgentTextParam> = JsonMissing.of()
            private var tools: JsonField<MutableList<AgentToolParam>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agent: Agent) = apply {
                instructions = agent.instructions
                model = agent.model
                multiAgent = agent.multiAgent
                reasoning = agent.reasoning
                serviceTier = agent.serviceTier
                text = agent.text
                tools = agent.tools.map { it.toMutableList() }
                additionalProperties = agent.additionalProperties.toMutableMap()
            }

            /**
             * Additional instructions appended to the agent's default base instructions. Omit to
             * leave unchanged.
             */
            fun instructions(instructions: String?) =
                instructions(JsonField.ofNullable(instructions))

            /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
            fun instructions(instructions: Optional<String>) =
                instructions(instructions.getOrNull())

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            /** The model to use for the agent. The requested model name is preserved. */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /** Explicit configuration for creating and coordinating subagents. */
            fun multiAgent(multiAgent: MultiAgentConfigParam?) =
                multiAgent(JsonField.ofNullable(multiAgent))

            /** Alias for calling [Builder.multiAgent] with `multiAgent.orElse(null)`. */
            fun multiAgent(multiAgent: Optional<MultiAgentConfigParam>) =
                multiAgent(multiAgent.getOrNull())

            /**
             * Sets [Builder.multiAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.multiAgent] with a well-typed
             * [MultiAgentConfigParam] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun multiAgent(multiAgent: JsonField<MultiAgentConfigParam>) = apply {
                this.multiAgent = multiAgent
            }

            /** Reasoning configuration for the agent. */
            fun reasoning(reasoning: AgentReasoningParam?) =
                reasoning(JsonField.ofNullable(reasoning))

            /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
            fun reasoning(reasoning: Optional<AgentReasoningParam>) =
                reasoning(reasoning.getOrNull())

            /**
             * Sets [Builder.reasoning] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoning] with a well-typed [AgentReasoningParam]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun reasoning(reasoning: JsonField<AgentReasoningParam>) = apply {
                this.reasoning = reasoning
            }

            /** The service tier used for model requests. */
            fun serviceTier(serviceTier: ServiceTier?) =
                serviceTier(JsonField.ofNullable(serviceTier))

            /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
            fun serviceTier(serviceTier: Optional<ServiceTier>) =
                serviceTier(serviceTier.getOrNull())

            /**
             * Sets [Builder.serviceTier] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serviceTier] with a well-typed [ServiceTier] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
                this.serviceTier = serviceTier
            }

            /** Configuration for text generated by the agent. */
            fun text(text: AgentTextParam?) = text(JsonField.ofNullable(text))

            /** Alias for calling [Builder.text] with `text.orElse(null)`. */
            fun text(text: Optional<AgentTextParam>) = text(text.getOrNull())

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [AgentTextParam] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun text(text: JsonField<AgentTextParam>) = apply { this.text = text }

            /** Tools available to the agent. Omit to inherit, or pass null to clear them. */
            fun tools(tools: List<AgentToolParam>?) = tools(JsonField.ofNullable(tools))

            /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
            fun tools(tools: Optional<List<AgentToolParam>>) = tools(tools.getOrNull())

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<AgentToolParam>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun tools(tools: JsonField<List<AgentToolParam>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [AgentToolParam] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: AgentToolParam) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /** Alias for calling [addTool] with `AgentToolParam.ofFunction(function)`. */
            fun addTool(function: AgentToolParam.Function) =
                addTool(AgentToolParam.ofFunction(function))

            /** Alias for calling [addTool] with `AgentToolParam.ofToolSearch()`. */
            fun addToolToolSearch() = addTool(AgentToolParam.ofToolSearch())

            /**
             * Alias for calling [addTool] with
             * `AgentToolParam.ofProgrammaticToolCalling(programmaticToolCalling)`.
             */
            fun addTool(programmaticToolCalling: AgentToolParam.ProgrammaticToolCalling) =
                addTool(AgentToolParam.ofProgrammaticToolCalling(programmaticToolCalling))

            /** Alias for calling [addTool] with `AgentToolParam.ofMcp(mcp)`. */
            fun addTool(mcp: AgentToolParam.Mcp) = addTool(AgentToolParam.ofMcp(mcp))

            /** Alias for calling [addTool] with `AgentToolParam.ofWebSearch(webSearch)`. */
            fun addTool(webSearch: AgentToolParam.WebSearch) =
                addTool(AgentToolParam.ofWebSearch(webSearch))

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
             * Returns an immutable instance of [Agent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Agent =
                Agent(
                    instructions,
                    model,
                    multiAgent,
                    reasoning,
                    serviceTier,
                    text,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Agent = apply {
            if (validated) {
                return@apply
            }

            instructions()
            model()
            multiAgent().ifPresent { it.validate() }
            reasoning().ifPresent { it.validate() }
            serviceTier().ifPresent { it.validate() }
            text().ifPresent { it.validate() }
            tools().ifPresent { it.forEach { it.validate() } }
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
            (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (multiAgent.asKnown().getOrNull()?.validity() ?: 0) +
                (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
                (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
                (text.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** The service tier used for model requests. */
        class ServiceTier @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                /** Selects the service tier automatically. */
                @JvmField val AUTO = of("auto")

                /** Uses the default service tier. */
                @JvmField val DEFAULT = of("default")

                /** Uses the flex service tier. */
                @JvmField val FLEX = of("flex")

                /** Uses the priority service tier. */
                @JvmField val PRIORITY = of("priority")

                /** Uses the fast service tier. */
                @JvmField val FAST = of("fast")

                @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
            }

            /** An enum containing [ServiceTier]'s known values. */
            enum class Known {
                /** Selects the service tier automatically. */
                AUTO,
                /** Uses the default service tier. */
                DEFAULT,
                /** Uses the flex service tier. */
                FLEX,
                /** Uses the priority service tier. */
                PRIORITY,
                /** Uses the fast service tier. */
                FAST,
            }

            /**
             * An enum containing [ServiceTier]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ServiceTier] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                /** Selects the service tier automatically. */
                AUTO,
                /** Uses the default service tier. */
                DEFAULT,
                /** Uses the flex service tier. */
                FLEX,
                /** Uses the priority service tier. */
                PRIORITY,
                /** Uses the fast service tier. */
                FAST,
                /**
                 * An enum member indicating that [ServiceTier] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    AUTO -> Value.AUTO
                    DEFAULT -> Value.DEFAULT
                    FLEX -> Value.FLEX
                    PRIORITY -> Value.PRIORITY
                    FAST -> Value.FAST
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    AUTO -> Known.AUTO
                    DEFAULT -> Known.DEFAULT
                    FLEX -> Known.FLEX
                    PRIORITY -> Known.PRIORITY
                    FAST -> Known.FAST
                    else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
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
            fun validate(): ServiceTier = apply {
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

                return other is ServiceTier && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Agent &&
                instructions == other.instructions &&
                model == other.model &&
                multiAgent == other.multiAgent &&
                reasoning == other.reasoning &&
                serviceTier == other.serviceTier &&
                text == other.text &&
                tools == other.tools &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                instructions,
                model,
                multiAgent,
                reasoning,
                serviceTier,
                text,
                tools,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Agent{instructions=$instructions, model=$model, multiAgent=$multiAgent, reasoning=$reasoning, serviceTier=$serviceTier, text=$text, tools=$tools, additionalProperties=$additionalProperties}"
    }

    /** Initial input submitted when creating a session. */
    @JsonDeserialize(using = Input.Deserializer::class)
    @JsonSerialize(using = Input.Serializer::class)
    class Input
    private constructor(
        private val string: String? = null,
        private val agentSessionInputMessageParams: List<AgentSessionInputMessageParam>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        /** A user message submitted to a session. */
        fun agentSessionInputMessageParams(): Optional<List<AgentSessionInputMessageParam>> =
            Optional.ofNullable(agentSessionInputMessageParams)

        fun isString(): Boolean = string != null

        fun isAgentSessionInputMessageParams(): Boolean = agentSessionInputMessageParams != null

        fun asString(): String = string.getOrThrow("string")

        /** A user message submitted to a session. */
        fun asAgentSessionInputMessageParams(): List<AgentSessionInputMessageParam> =
            agentSessionInputMessageParams.getOrThrow("agentSessionInputMessageParams")

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
         * Optional<String> result = input.accept(new Input.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitString(String string) {
         *         return Optional.of(string.toString());
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
                string != null -> visitor.visitString(string)
                agentSessionInputMessageParams != null ->
                    visitor.visitAgentSessionInputMessageParams(agentSessionInputMessageParams)
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
        fun validate(): Input = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitAgentSessionInputMessageParams(
                        agentSessionInputMessageParams: List<AgentSessionInputMessageParam>
                    ) {
                        agentSessionInputMessageParams.forEach { it.validate() }
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
                    override fun visitString(string: String) = 1

                    override fun visitAgentSessionInputMessageParams(
                        agentSessionInputMessageParams: List<AgentSessionInputMessageParam>
                    ) = agentSessionInputMessageParams.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Input &&
                string == other.string &&
                agentSessionInputMessageParams == other.agentSessionInputMessageParams
        }

        override fun hashCode(): Int = Objects.hash(string, agentSessionInputMessageParams)

        override fun toString(): String =
            when {
                string != null -> "Input{string=$string}"
                agentSessionInputMessageParams != null ->
                    "Input{agentSessionInputMessageParams=$agentSessionInputMessageParams}"
                _json != null -> "Input{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Input")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Input(string = string)

            /** A user message submitted to a session. */
            @JvmStatic
            fun ofAgentSessionInputMessageParams(
                agentSessionInputMessageParams: List<AgentSessionInputMessageParam>
            ) = Input(agentSessionInputMessageParams = agentSessionInputMessageParams.toImmutable())
        }

        /** An interface that defines how to map each variant of [Input] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            /** A user message submitted to a session. */
            fun visitAgentSessionInputMessageParams(
                agentSessionInputMessageParams: List<AgentSessionInputMessageParam>
            ): T

            /**
             * Maps an unknown variant of [Input] to a value of type [T].
             *
             * An instance of [Input] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Input: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Input>(Input::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Input {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Input(string = it, _json = json)
                            },
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<List<AgentSessionInputMessageParam>>(),
                                )
                                ?.let { Input(agentSessionInputMessageParams = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Input(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Input>(Input::class) {

            override fun serialize(
                value: Input,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.agentSessionInputMessageParams != null ->
                        generator.writeObject(value.agentSessionInputMessageParams)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Input")
                }
            }
        }
    }

    /**
     * Up to 16 string key-value pairs, with keys up to 64 and values up to 512 characters. Omission
     * or null defaults to an empty map.
     */
    class Metadata
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

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
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
        fun validate(): Metadata = apply {
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

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "SessionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
