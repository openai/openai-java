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
import com.openai.core.Enum
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

/** A Managed Agents session. */
class AgentSession
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val agent: JsonField<Agent>,
    private val createdAt: JsonField<Long>,
    private val environment: JsonField<Environment>,
    private val error: JsonField<String>,
    private val lastActiveAt: JsonField<Long>,
    private val metadata: JsonField<Metadata>,
    private val object_: JsonValue,
    private val requiredActions: JsonField<List<RequiredAction>>,
    private val status: JsonField<Status>,
    private val usage: JsonField<TokenUsage>,
    private val vaultIds: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("environment")
        @ExcludeMissing
        environment: JsonField<Environment> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
        @JsonProperty("last_active_at")
        @ExcludeMissing
        lastActiveAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("required_actions")
        @ExcludeMissing
        requiredActions: JsonField<List<RequiredAction>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<TokenUsage> = JsonMissing.of(),
        @JsonProperty("vault_ids")
        @ExcludeMissing
        vaultIds: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        id,
        agent,
        createdAt,
        environment,
        error,
        lastActiveAt,
        metadata,
        object_,
        requiredActions,
        status,
        usage,
        vaultIds,
        mutableMapOf(),
    )

    /**
     * The ID of the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The agent running in the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun agent(): Agent = agent.getRequired("agent")

    /**
     * The Unix timestamp, in seconds, when the session was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The execution environment for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun environment(): Environment = environment.getRequired("environment")

    /**
     * The error that caused the session to fail, if any.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<String> = error.getOptional("error")

    /**
     * The Unix timestamp, in seconds, when the session was last active.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastActiveAt(): Long = lastActiveAt.getRequired("last_active_at")

    /**
     * Custom string key-value pairs attached to the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun metadata(): Metadata = metadata.getRequired("metadata")

    /**
     * The object type. Always `agent.session`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("agent.session")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Actions that must be completed before the session can continue.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requiredActions(): List<RequiredAction> = requiredActions.getRequired("required_actions")

    /**
     * The current status of the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Best-effort token usage for the session, or null if unknown. Recorded usage may change.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<TokenUsage> = usage.getOptional("usage")

    /**
     * The IDs of vaults made available to the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vaultIds(): List<String> = vaultIds.getRequired("vault_ids")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [environment].
     *
     * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("environment")
    @ExcludeMissing
    fun _environment(): JsonField<Environment> = environment

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

    /**
     * Returns the raw JSON value of [lastActiveAt].
     *
     * Unlike [lastActiveAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_active_at")
    @ExcludeMissing
    fun _lastActiveAt(): JsonField<Long> = lastActiveAt

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [requiredActions].
     *
     * Unlike [requiredActions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required_actions")
    @ExcludeMissing
    fun _requiredActions(): JsonField<List<RequiredAction>> = requiredActions

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<TokenUsage> = usage

    /**
     * Returns the raw JSON value of [vaultIds].
     *
     * Unlike [vaultIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vault_ids") @ExcludeMissing fun _vaultIds(): JsonField<List<String>> = vaultIds

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
         * Returns a mutable builder for constructing an instance of [AgentSession].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .agent()
         * .createdAt()
         * .environment()
         * .error()
         * .lastActiveAt()
         * .metadata()
         * .requiredActions()
         * .status()
         * .usage()
         * .vaultIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentSession]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var agent: JsonField<Agent>? = null
        private var createdAt: JsonField<Long>? = null
        private var environment: JsonField<Environment>? = null
        private var error: JsonField<String>? = null
        private var lastActiveAt: JsonField<Long>? = null
        private var metadata: JsonField<Metadata>? = null
        private var object_: JsonValue = JsonValue.from("agent.session")
        private var requiredActions: JsonField<MutableList<RequiredAction>>? = null
        private var status: JsonField<Status>? = null
        private var usage: JsonField<TokenUsage>? = null
        private var vaultIds: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentSession: AgentSession) = apply {
            id = agentSession.id
            agent = agentSession.agent
            createdAt = agentSession.createdAt
            environment = agentSession.environment
            error = agentSession.error
            lastActiveAt = agentSession.lastActiveAt
            metadata = agentSession.metadata
            object_ = agentSession.object_
            requiredActions = agentSession.requiredActions.map { it.toMutableList() }
            status = agentSession.status
            usage = agentSession.usage
            vaultIds = agentSession.vaultIds.map { it.toMutableList() }
            additionalProperties = agentSession.additionalProperties.toMutableMap()
        }

        /** The ID of the session. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The agent running in the session. */
        fun agent(agent: Agent) = agent(JsonField.of(agent))

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

        /** The Unix timestamp, in seconds, when the session was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The execution environment for the session. */
        fun environment(environment: Environment) = environment(JsonField.of(environment))

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

        /** Alias for calling [environment] with `Environment.ofNone()`. */
        fun environmentNone() = environment(Environment.ofNone())

        /** Alias for calling [environment] with `Environment.ofOpenAIHosted(openaiHosted)`. */
        fun environment(openaiHosted: Environment.OpenAIHosted) =
            environment(Environment.ofOpenAIHosted(openaiHosted))

        /** Alias for calling [environment] with `Environment.ofSelfHosted(selfHosted)`. */
        fun environment(selfHosted: Environment.SelfHosted) =
            environment(Environment.ofSelfHosted(selfHosted))

        /** The error that caused the session to fail, if any. */
        fun error(error: String?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<String>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<String>) = apply { this.error = error }

        /** The Unix timestamp, in seconds, when the session was last active. */
        fun lastActiveAt(lastActiveAt: Long) = lastActiveAt(JsonField.of(lastActiveAt))

        /**
         * Sets [Builder.lastActiveAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastActiveAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastActiveAt(lastActiveAt: JsonField<Long>) = apply { this.lastActiveAt = lastActiveAt }

        /** Custom string key-value pairs attached to the session. */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent.session")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Actions that must be completed before the session can continue. */
        fun requiredActions(requiredActions: List<RequiredAction>) =
            requiredActions(JsonField.of(requiredActions))

        /**
         * Sets [Builder.requiredActions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredActions] with a well-typed
         * `List<RequiredAction>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun requiredActions(requiredActions: JsonField<List<RequiredAction>>) = apply {
            this.requiredActions = requiredActions.map { it.toMutableList() }
        }

        /**
         * Adds a single [RequiredAction] to [requiredActions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRequiredAction(requiredAction: RequiredAction) = apply {
            requiredActions =
                (requiredActions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("requiredActions", it).add(requiredAction)
                }
        }

        /**
         * Alias for calling [addRequiredAction] with
         * `RequiredAction.ofComputerUseApprovalRequest(computerUseApprovalRequest)`.
         */
        fun addRequiredAction(
            computerUseApprovalRequest: RequiredAction.ComputerUseApprovalRequest
        ) =
            addRequiredAction(
                RequiredAction.ofComputerUseApprovalRequest(computerUseApprovalRequest)
            )

        /**
         * Alias for calling [addRequiredAction] with `RequiredAction.ofFunctionCall(functionCall)`.
         */
        fun addRequiredAction(functionCall: RequiredAction.FunctionCall) =
            addRequiredAction(RequiredAction.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addRequiredAction] with
         * `RequiredAction.ofEnvironmentConnection(environmentConnection)`.
         */
        fun addRequiredAction(environmentConnection: RequiredAction.EnvironmentConnection) =
            addRequiredAction(RequiredAction.ofEnvironmentConnection(environmentConnection))

        /**
         * Alias for calling [addRequiredAction] with the following:
         * ```java
         * RequiredAction.EnvironmentConnection.builder()
         *     .environmentId(environmentId)
         *     .build()
         * ```
         */
        fun addEnvironmentConnectionRequiredAction(environmentId: String) =
            addRequiredAction(
                RequiredAction.EnvironmentConnection.builder().environmentId(environmentId).build()
            )

        /** The current status of the session. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * Best-effort token usage for the session, or null if unknown. Recorded usage may change.
         */
        fun usage(usage: TokenUsage?) = usage(JsonField.ofNullable(usage))

        /** Alias for calling [Builder.usage] with `usage.orElse(null)`. */
        fun usage(usage: Optional<TokenUsage>) = usage(usage.getOrNull())

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [TokenUsage] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usage(usage: JsonField<TokenUsage>) = apply { this.usage = usage }

        /** The IDs of vaults made available to the session. */
        fun vaultIds(vaultIds: List<String>) = vaultIds(JsonField.of(vaultIds))

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
         * Returns an immutable instance of [AgentSession].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .agent()
         * .createdAt()
         * .environment()
         * .error()
         * .lastActiveAt()
         * .metadata()
         * .requiredActions()
         * .status()
         * .usage()
         * .vaultIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentSession =
            AgentSession(
                checkRequired("id", id),
                checkRequired("agent", agent),
                checkRequired("createdAt", createdAt),
                checkRequired("environment", environment),
                checkRequired("error", error),
                checkRequired("lastActiveAt", lastActiveAt),
                checkRequired("metadata", metadata),
                object_,
                checkRequired("requiredActions", requiredActions).map { it.toImmutable() },
                checkRequired("status", status),
                checkRequired("usage", usage),
                checkRequired("vaultIds", vaultIds).map { it.toImmutable() },
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
    fun validate(): AgentSession = apply {
        if (validated) {
            return@apply
        }

        id()
        agent().validate()
        createdAt()
        environment().validate()
        error()
        lastActiveAt()
        metadata().validate()
        _object_().let {
            if (it != JsonValue.from("agent.session")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        requiredActions().forEach { it.validate() }
        status().validate()
        usage().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (agent.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (environment.asKnown().getOrNull()?.validity() ?: 0) +
            (if (error.asKnown().isPresent) 1 else 0) +
            (if (lastActiveAt.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("agent.session")) 1 else 0 } +
            (requiredActions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (vaultIds.asKnown().getOrNull()?.size ?: 0)

    /** The agent running in the session. */
    class Agent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val instructions: JsonField<String>,
        private val model: JsonField<String>,
        private val multiAgent: JsonField<MultiAgentConfig>,
        private val name: JsonField<String>,
        private val reasoning: JsonField<AgentReasoning>,
        private val serviceTier: JsonField<ServiceTier>,
        private val text: JsonField<AgentText>,
        private val tools: JsonField<List<AgentTool>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("multi_agent")
            @ExcludeMissing
            multiAgent: JsonField<MultiAgentConfig> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reasoning")
            @ExcludeMissing
            reasoning: JsonField<AgentReasoning> = JsonMissing.of(),
            @JsonProperty("service_tier")
            @ExcludeMissing
            serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<AgentText> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<AgentTool>> = JsonMissing.of(),
        ) : this(
            id,
            instructions,
            model,
            multiAgent,
            name,
            reasoning,
            serviceTier,
            text,
            tools,
            mutableMapOf(),
        )

        /**
         * The ID of the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Custom instructions appended to the agent's default base instructions.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun instructions(): Optional<String> = instructions.getOptional("instructions")

        /**
         * The model used by the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * Configuration for creating and coordinating subagents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun multiAgent(): MultiAgentConfig = multiAgent.getRequired("multi_agent")

        /**
         * The reusable agent's name when the session was created, or null if no name was saved.
         * Later changes to the agent's name do not affect this value.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * The agent's reasoning configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun reasoning(): AgentReasoning = reasoning.getRequired("reasoning")

        /**
         * The effective service-tier policy for model requests. Defaults to `auto`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serviceTier(): ServiceTier = serviceTier.getRequired("service_tier")

        /**
         * Configuration for text generated by the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun text(): AgentText = text.getRequired("text")

        /**
         * Tools available to the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tools(): List<AgentTool> = tools.getRequired("tools")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        fun _multiAgent(): JsonField<MultiAgentConfig> = multiAgent

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [reasoning].
         *
         * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reasoning")
        @ExcludeMissing
        fun _reasoning(): JsonField<AgentReasoning> = reasoning

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
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<AgentText> = text

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AgentTool>> = tools

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
             * Returns a mutable builder for constructing an instance of [Agent].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .instructions()
             * .model()
             * .multiAgent()
             * .name()
             * .reasoning()
             * .serviceTier()
             * .text()
             * .tools()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Agent]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var instructions: JsonField<String>? = null
            private var model: JsonField<String>? = null
            private var multiAgent: JsonField<MultiAgentConfig>? = null
            private var name: JsonField<String>? = null
            private var reasoning: JsonField<AgentReasoning>? = null
            private var serviceTier: JsonField<ServiceTier>? = null
            private var text: JsonField<AgentText>? = null
            private var tools: JsonField<MutableList<AgentTool>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agent: Agent) = apply {
                id = agent.id
                instructions = agent.instructions
                model = agent.model
                multiAgent = agent.multiAgent
                name = agent.name
                reasoning = agent.reasoning
                serviceTier = agent.serviceTier
                text = agent.text
                tools = agent.tools.map { it.toMutableList() }
                additionalProperties = agent.additionalProperties.toMutableMap()
            }

            /** The ID of the agent. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Custom instructions appended to the agent's default base instructions. */
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

            /** The model used by the agent. */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /** Configuration for creating and coordinating subagents. */
            fun multiAgent(multiAgent: MultiAgentConfig) = multiAgent(JsonField.of(multiAgent))

            /**
             * Sets [Builder.multiAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.multiAgent] with a well-typed [MultiAgentConfig]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun multiAgent(multiAgent: JsonField<MultiAgentConfig>) = apply {
                this.multiAgent = multiAgent
            }

            /**
             * The reusable agent's name when the session was created, or null if no name was saved.
             * Later changes to the agent's name do not affect this value.
             */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The agent's reasoning configuration. */
            fun reasoning(reasoning: AgentReasoning) = reasoning(JsonField.of(reasoning))

            /**
             * Sets [Builder.reasoning] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoning] with a well-typed [AgentReasoning] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reasoning(reasoning: JsonField<AgentReasoning>) = apply {
                this.reasoning = reasoning
            }

            /** The effective service-tier policy for model requests. Defaults to `auto`. */
            fun serviceTier(serviceTier: ServiceTier) = serviceTier(JsonField.of(serviceTier))

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
            fun text(text: AgentText) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [AgentText] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun text(text: JsonField<AgentText>) = apply { this.text = text }

            /** Tools available to the agent. */
            fun tools(tools: List<AgentTool>) = tools(JsonField.of(tools))

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<AgentTool>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<AgentTool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [AgentTool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: AgentTool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /** Alias for calling [addTool] with `AgentTool.ofFunction(function)`. */
            fun addTool(function: AgentTool.Function) = addTool(AgentTool.ofFunction(function))

            /**
             * Alias for calling [addTool] with
             * `AgentTool.ofProgrammaticToolCalling(programmaticToolCalling)`.
             */
            fun addTool(programmaticToolCalling: AgentTool.ProgrammaticToolCalling) =
                addTool(AgentTool.ofProgrammaticToolCalling(programmaticToolCalling))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * AgentTool.ProgrammaticToolCalling.builder()
             *     .enabled(enabled)
             *     .build()
             * ```
             */
            fun addProgrammaticToolCallingTool(enabled: Boolean) =
                addTool(AgentTool.ProgrammaticToolCalling.builder().enabled(enabled).build())

            /** Alias for calling [addTool] with `AgentTool.ofMcp(mcp)`. */
            fun addTool(mcp: AgentTool.Mcp) = addTool(AgentTool.ofMcp(mcp))

            /** Alias for calling [addTool] with `AgentTool.ofWebSearch(webSearch)`. */
            fun addTool(webSearch: AgentTool.WebSearch) = addTool(AgentTool.ofWebSearch(webSearch))

            /** Alias for calling [addTool] with `AgentTool.ofComputerUse(computerUse)`. */
            fun addTool(computerUse: AgentTool.ComputerUse) =
                addTool(AgentTool.ofComputerUse(computerUse))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * AgentTool.ComputerUse.builder()
             *     .includeScreenshots(includeScreenshots)
             *     .build()
             * ```
             */
            fun addComputerUseTool(includeScreenshots: Boolean) =
                addTool(
                    AgentTool.ComputerUse.builder().includeScreenshots(includeScreenshots).build()
                )

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
             *
             * The following fields are required:
             * ```java
             * .id()
             * .instructions()
             * .model()
             * .multiAgent()
             * .name()
             * .reasoning()
             * .serviceTier()
             * .text()
             * .tools()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Agent =
                Agent(
                    checkRequired("id", id),
                    checkRequired("instructions", instructions),
                    checkRequired("model", model),
                    checkRequired("multiAgent", multiAgent),
                    checkRequired("name", name),
                    checkRequired("reasoning", reasoning),
                    checkRequired("serviceTier", serviceTier),
                    checkRequired("text", text),
                    checkRequired("tools", tools).map { it.toImmutable() },
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

            id()
            instructions()
            model()
            multiAgent().validate()
            name()
            reasoning().validate()
            serviceTier().validate()
            text().validate()
            tools().forEach { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (multiAgent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
                (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
                (text.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** The effective service-tier policy for model requests. Defaults to `auto`. */
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

                @JvmField val AUTO = of("auto")

                @JvmField val DEFAULT = of("default")

                @JvmField val FLEX = of("flex")

                @JvmField val PRIORITY = of("priority")

                @JvmField val FAST = of("fast")

                @JvmField val ULTRAFAST = of("ultrafast")

                @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
            }

            /** An enum containing [ServiceTier]'s known values. */
            enum class Known {
                AUTO,
                DEFAULT,
                FLEX,
                PRIORITY,
                FAST,
                ULTRAFAST,
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
                AUTO,
                DEFAULT,
                FLEX,
                PRIORITY,
                FAST,
                ULTRAFAST,
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
                    ULTRAFAST -> Value.ULTRAFAST
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
                    ULTRAFAST -> Known.ULTRAFAST
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
                id == other.id &&
                instructions == other.instructions &&
                model == other.model &&
                multiAgent == other.multiAgent &&
                name == other.name &&
                reasoning == other.reasoning &&
                serviceTier == other.serviceTier &&
                text == other.text &&
                tools == other.tools &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                instructions,
                model,
                multiAgent,
                name,
                reasoning,
                serviceTier,
                text,
                tools,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Agent{id=$id, instructions=$instructions, model=$model, multiAgent=$multiAgent, name=$name, reasoning=$reasoning, serviceTier=$serviceTier, text=$text, tools=$tools, additionalProperties=$additionalProperties}"
    }

    /** Custom string key-value pairs attached to the session. */
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

    /** An action that must be completed before a session can continue. */
    @JsonDeserialize(using = RequiredAction.Deserializer::class)
    @JsonSerialize(using = RequiredAction.Serializer::class)
    class RequiredAction
    private constructor(
        private val computerUseApprovalRequest: ComputerUseApprovalRequest? = null,
        private val functionCall: FunctionCall? = null,
        private val environmentConnection: EnvironmentConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Respond to a computer-use request. */
        fun computerUseApprovalRequest(): Optional<ComputerUseApprovalRequest> =
            Optional.ofNullable(computerUseApprovalRequest)

        /** Run a function tool and submit its result. */
        fun functionCall(): Optional<FunctionCall> = Optional.ofNullable(functionCall)

        /** Reconnect a session environment. */
        fun environmentConnection(): Optional<EnvironmentConnection> =
            Optional.ofNullable(environmentConnection)

        fun isComputerUseApprovalRequest(): Boolean = computerUseApprovalRequest != null

        fun isFunctionCall(): Boolean = functionCall != null

        fun isEnvironmentConnection(): Boolean = environmentConnection != null

        /** Respond to a computer-use request. */
        fun asComputerUseApprovalRequest(): ComputerUseApprovalRequest =
            computerUseApprovalRequest.getOrThrow("computerUseApprovalRequest")

        /** Run a function tool and submit its result. */
        fun asFunctionCall(): FunctionCall = functionCall.getOrThrow("functionCall")

        /** Reconnect a session environment. */
        fun asEnvironmentConnection(): EnvironmentConnection =
            environmentConnection.getOrThrow("environmentConnection")

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
         * Optional<String> result = requiredAction.accept(new RequiredAction.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitComputerUseApprovalRequest(ComputerUseApprovalRequest computerUseApprovalRequest) {
         *         return Optional.of(computerUseApprovalRequest.toString());
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
                computerUseApprovalRequest != null ->
                    visitor.visitComputerUseApprovalRequest(computerUseApprovalRequest)
                functionCall != null -> visitor.visitFunctionCall(functionCall)
                environmentConnection != null ->
                    visitor.visitEnvironmentConnection(environmentConnection)
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
        fun validate(): RequiredAction = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitComputerUseApprovalRequest(
                        computerUseApprovalRequest: ComputerUseApprovalRequest
                    ) {
                        computerUseApprovalRequest.validate()
                    }

                    override fun visitFunctionCall(functionCall: FunctionCall) {
                        functionCall.validate()
                    }

                    override fun visitEnvironmentConnection(
                        environmentConnection: EnvironmentConnection
                    ) {
                        environmentConnection.validate()
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
                    override fun visitComputerUseApprovalRequest(
                        computerUseApprovalRequest: ComputerUseApprovalRequest
                    ) = computerUseApprovalRequest.validity()

                    override fun visitFunctionCall(functionCall: FunctionCall) =
                        functionCall.validity()

                    override fun visitEnvironmentConnection(
                        environmentConnection: EnvironmentConnection
                    ) = environmentConnection.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RequiredAction &&
                computerUseApprovalRequest == other.computerUseApprovalRequest &&
                functionCall == other.functionCall &&
                environmentConnection == other.environmentConnection
        }

        override fun hashCode(): Int =
            Objects.hash(computerUseApprovalRequest, functionCall, environmentConnection)

        override fun toString(): String =
            when {
                computerUseApprovalRequest != null ->
                    "RequiredAction{computerUseApprovalRequest=$computerUseApprovalRequest}"
                functionCall != null -> "RequiredAction{functionCall=$functionCall}"
                environmentConnection != null ->
                    "RequiredAction{environmentConnection=$environmentConnection}"
                _json != null -> "RequiredAction{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid RequiredAction")
            }

        companion object {

            /** Respond to a computer-use request. */
            @JvmStatic
            fun ofComputerUseApprovalRequest(
                computerUseApprovalRequest: ComputerUseApprovalRequest
            ) = RequiredAction(computerUseApprovalRequest = computerUseApprovalRequest)

            /** Run a function tool and submit its result. */
            @JvmStatic
            fun ofFunctionCall(functionCall: FunctionCall) =
                RequiredAction(functionCall = functionCall)

            /** Reconnect a session environment. */
            @JvmStatic
            fun ofEnvironmentConnection(environmentConnection: EnvironmentConnection) =
                RequiredAction(environmentConnection = environmentConnection)
        }

        /**
         * An interface that defines how to map each variant of [RequiredAction] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            /** Respond to a computer-use request. */
            fun visitComputerUseApprovalRequest(
                computerUseApprovalRequest: ComputerUseApprovalRequest
            ): T

            /** Run a function tool and submit its result. */
            fun visitFunctionCall(functionCall: FunctionCall): T

            /** Reconnect a session environment. */
            fun visitEnvironmentConnection(environmentConnection: EnvironmentConnection): T

            /**
             * Maps an unknown variant of [RequiredAction] to a value of type [T].
             *
             * An instance of [RequiredAction] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown RequiredAction")
            }
        }

        internal class Deserializer : BaseDeserializer<RequiredAction>(RequiredAction::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): RequiredAction {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "computer_use_approval_request" -> {
                        return tryDeserialize(node, jacksonTypeRef<ComputerUseApprovalRequest>())
                            ?.let { RequiredAction(computerUseApprovalRequest = it, _json = json) }
                            ?: RequiredAction(_json = json)
                    }
                    "function_call" -> {
                        return tryDeserialize(node, jacksonTypeRef<FunctionCall>())?.let {
                            RequiredAction(functionCall = it, _json = json)
                        } ?: RequiredAction(_json = json)
                    }
                    "environment_connection" -> {
                        return tryDeserialize(node, jacksonTypeRef<EnvironmentConnection>())?.let {
                            RequiredAction(environmentConnection = it, _json = json)
                        } ?: RequiredAction(_json = json)
                    }
                }

                return RequiredAction(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<RequiredAction>(RequiredAction::class) {

            override fun serialize(
                value: RequiredAction,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.computerUseApprovalRequest != null ->
                        generator.writeObject(value.computerUseApprovalRequest)
                    value.functionCall != null -> generator.writeObject(value.functionCall)
                    value.environmentConnection != null ->
                        generator.writeObject(value.environmentConnection)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid RequiredAction")
                }
            }
        }

        /** Respond to a computer-use request. */
        class ComputerUseApprovalRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val request: JsonField<Request>,
            private val requestId: JsonField<String>,
            private val turnId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("request")
                @ExcludeMissing
                request: JsonField<Request> = JsonMissing.of(),
                @JsonProperty("request_id")
                @ExcludeMissing
                requestId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("turn_id")
                @ExcludeMissing
                turnId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(request, requestId, turnId, type, mutableMapOf())

            /**
             * The information needed to render the request.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun request(): Request = request.getRequired("request")

            /**
             * The registered request ID to echo when responding.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestId(): String = requestId.getRequired("request_id")

            /**
             * The turn that requested approval.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun turnId(): String = turnId.getRequired("turn_id")

            /**
             * The type of the object. Always `computer_use_approval_request`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("computer_use_approval_request")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [request].
             *
             * Unlike [request], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

            /**
             * Returns the raw JSON value of [requestId].
             *
             * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("request_id")
            @ExcludeMissing
            fun _requestId(): JsonField<String> = requestId

            /**
             * Returns the raw JSON value of [turnId].
             *
             * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

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
                 * Returns a mutable builder for constructing an instance of
                 * [ComputerUseApprovalRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .request()
                 * .requestId()
                 * .turnId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ComputerUseApprovalRequest]. */
            class Builder internal constructor() {

                private var request: JsonField<Request>? = null
                private var requestId: JsonField<String>? = null
                private var turnId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("computer_use_approval_request")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(computerUseApprovalRequest: ComputerUseApprovalRequest) = apply {
                    request = computerUseApprovalRequest.request
                    requestId = computerUseApprovalRequest.requestId
                    turnId = computerUseApprovalRequest.turnId
                    type = computerUseApprovalRequest.type
                    additionalProperties =
                        computerUseApprovalRequest.additionalProperties.toMutableMap()
                }

                /** The information needed to render the request. */
                fun request(request: Request) = request(JsonField.of(request))

                /**
                 * Sets [Builder.request] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.request] with a well-typed [Request] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun request(request: JsonField<Request>) = apply { this.request = request }

                /**
                 * Alias for calling [request] with
                 * `Request.ofBrowserAuthentication(browserAuthentication)`.
                 */
                fun request(browserAuthentication: Request.BrowserAuthentication) =
                    request(Request.ofBrowserAuthentication(browserAuthentication))

                /**
                 * Alias for calling [request] with
                 * `Request.ofBrowserOriginAccess(browserOriginAccess)`.
                 */
                fun request(browserOriginAccess: Request.BrowserOriginAccess) =
                    request(Request.ofBrowserOriginAccess(browserOriginAccess))

                /** The registered request ID to echo when responding. */
                fun requestId(requestId: String) = requestId(JsonField.of(requestId))

                /**
                 * Sets [Builder.requestId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

                /** The turn that requested approval. */
                fun turnId(turnId: String) = turnId(JsonField.of(turnId))

                /**
                 * Sets [Builder.turnId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.turnId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("computer_use_approval_request")
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
                 * Returns an immutable instance of [ComputerUseApprovalRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .request()
                 * .requestId()
                 * .turnId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ComputerUseApprovalRequest =
                    ComputerUseApprovalRequest(
                        checkRequired("request", request),
                        checkRequired("requestId", requestId),
                        checkRequired("turnId", turnId),
                        type,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): ComputerUseApprovalRequest = apply {
                if (validated) {
                    return@apply
                }

                request().validate()
                requestId()
                turnId()
                _type().let {
                    if (it != JsonValue.from("computer_use_approval_request")) {
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
                (request.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (requestId.asKnown().isPresent) 1 else 0) +
                    (if (turnId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("computer_use_approval_request")) 1 else 0 }

            /** The information needed to render the request. */
            @JsonDeserialize(using = Request.Deserializer::class)
            @JsonSerialize(using = Request.Serializer::class)
            class Request
            private constructor(
                private val browserAuthentication: BrowserAuthentication? = null,
                private val browserOriginAccess: BrowserOriginAccess? = null,
                private val _json: JsonValue? = null,
            ) {

                /** A registered form awaiting the application's response. */
                fun browserAuthentication(): Optional<BrowserAuthentication> =
                    Optional.ofNullable(browserAuthentication)

                /** A browser origin awaiting the application's approval decision. */
                fun browserOriginAccess(): Optional<BrowserOriginAccess> =
                    Optional.ofNullable(browserOriginAccess)

                fun isBrowserAuthentication(): Boolean = browserAuthentication != null

                fun isBrowserOriginAccess(): Boolean = browserOriginAccess != null

                /** A registered form awaiting the application's response. */
                fun asBrowserAuthentication(): BrowserAuthentication =
                    browserAuthentication.getOrThrow("browserAuthentication")

                /** A browser origin awaiting the application's approval decision. */
                fun asBrowserOriginAccess(): BrowserOriginAccess =
                    browserOriginAccess.getOrThrow("browserOriginAccess")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = request.accept(new Request.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitBrowserAuthentication(BrowserAuthentication browserAuthentication) {
                 *         return Optional.of(browserAuthentication.toString());
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
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        browserAuthentication != null ->
                            visitor.visitBrowserAuthentication(browserAuthentication)
                        browserOriginAccess != null ->
                            visitor.visitBrowserOriginAccess(browserOriginAccess)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Request = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitBrowserAuthentication(
                                browserAuthentication: BrowserAuthentication
                            ) {
                                browserAuthentication.validate()
                            }

                            override fun visitBrowserOriginAccess(
                                browserOriginAccess: BrowserOriginAccess
                            ) {
                                browserOriginAccess.validate()
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
                            override fun visitBrowserAuthentication(
                                browserAuthentication: BrowserAuthentication
                            ) = browserAuthentication.validity()

                            override fun visitBrowserOriginAccess(
                                browserOriginAccess: BrowserOriginAccess
                            ) = browserOriginAccess.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Request &&
                        browserAuthentication == other.browserAuthentication &&
                        browserOriginAccess == other.browserOriginAccess
                }

                override fun hashCode(): Int =
                    Objects.hash(browserAuthentication, browserOriginAccess)

                override fun toString(): String =
                    when {
                        browserAuthentication != null ->
                            "Request{browserAuthentication=$browserAuthentication}"
                        browserOriginAccess != null ->
                            "Request{browserOriginAccess=$browserOriginAccess}"
                        _json != null -> "Request{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Request")
                    }

                companion object {

                    /** A registered form awaiting the application's response. */
                    @JvmStatic
                    fun ofBrowserAuthentication(browserAuthentication: BrowserAuthentication) =
                        Request(browserAuthentication = browserAuthentication)

                    /** A browser origin awaiting the application's approval decision. */
                    @JvmStatic
                    fun ofBrowserOriginAccess(browserOriginAccess: BrowserOriginAccess) =
                        Request(browserOriginAccess = browserOriginAccess)
                }

                /**
                 * An interface that defines how to map each variant of [Request] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    /** A registered form awaiting the application's response. */
                    fun visitBrowserAuthentication(browserAuthentication: BrowserAuthentication): T

                    /** A browser origin awaiting the application's approval decision. */
                    fun visitBrowserOriginAccess(browserOriginAccess: BrowserOriginAccess): T

                    /**
                     * Maps an unknown variant of [Request] to a value of type [T].
                     *
                     * An instance of [Request] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Request")
                    }
                }

                internal class Deserializer : BaseDeserializer<Request>(Request::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Request {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "browser_authentication" -> {
                                return tryDeserialize(node, jacksonTypeRef<BrowserAuthentication>())
                                    ?.let { Request(browserAuthentication = it, _json = json) }
                                    ?: Request(_json = json)
                            }
                            "browser_origin_access" -> {
                                return tryDeserialize(node, jacksonTypeRef<BrowserOriginAccess>())
                                    ?.let { Request(browserOriginAccess = it, _json = json) }
                                    ?: Request(_json = json)
                            }
                        }

                        return Request(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Request>(Request::class) {

                    override fun serialize(
                        value: Request,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.browserAuthentication != null ->
                                generator.writeObject(value.browserAuthentication)
                            value.browserOriginAccess != null ->
                                generator.writeObject(value.browserOriginAccess)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Request")
                        }
                    }
                }

                /** A registered form awaiting the application's response. */
                class BrowserAuthentication
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val credentialOrigin: JsonField<String>,
                    private val fields: JsonField<List<Field>>,
                    private val options: JsonField<List<Option>>,
                    private val reason: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("credential_origin")
                        @ExcludeMissing
                        credentialOrigin: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("fields")
                        @ExcludeMissing
                        fields: JsonField<List<Field>> = JsonMissing.of(),
                        @JsonProperty("options")
                        @ExcludeMissing
                        options: JsonField<List<Option>> = JsonMissing.of(),
                        @JsonProperty("reason")
                        @ExcludeMissing
                        reason: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(credentialOrigin, fields, options, reason, type, mutableMapOf())

                    /**
                     * The registered form or frame origin where values will be entered.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun credentialOrigin(): Optional<String> =
                        credentialOrigin.getOptional("credential_origin")

                    /**
                     * Controls to render. All submitted values are sensitive.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun fields(): List<Field> = fields.getRequired("fields")

                    /**
                     * Sign-in methods. Empty for a plain form.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun options(): List<Option> = options.getRequired("options")

                    /**
                     * Why the agent needs the user to sign in.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun reason(): Optional<String> = reason.getOptional("reason")

                    /**
                     * The type of the object. Always `browser_authentication`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("browser_authentication")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [credentialOrigin].
                     *
                     * Unlike [credentialOrigin], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("credential_origin")
                    @ExcludeMissing
                    fun _credentialOrigin(): JsonField<String> = credentialOrigin

                    /**
                     * Returns the raw JSON value of [fields].
                     *
                     * Unlike [fields], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("fields")
                    @ExcludeMissing
                    fun _fields(): JsonField<List<Field>> = fields

                    /**
                     * Returns the raw JSON value of [options].
                     *
                     * Unlike [options], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("options")
                    @ExcludeMissing
                    fun _options(): JsonField<List<Option>> = options

                    /**
                     * Returns the raw JSON value of [reason].
                     *
                     * Unlike [reason], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("reason")
                    @ExcludeMissing
                    fun _reason(): JsonField<String> = reason

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
                         * Returns a mutable builder for constructing an instance of
                         * [BrowserAuthentication].
                         *
                         * The following fields are required:
                         * ```java
                         * .credentialOrigin()
                         * .fields()
                         * .options()
                         * .reason()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [BrowserAuthentication]. */
                    class Builder internal constructor() {

                        private var credentialOrigin: JsonField<String>? = null
                        private var fields: JsonField<MutableList<Field>>? = null
                        private var options: JsonField<MutableList<Option>>? = null
                        private var reason: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("browser_authentication")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(browserAuthentication: BrowserAuthentication) = apply {
                            credentialOrigin = browserAuthentication.credentialOrigin
                            fields = browserAuthentication.fields.map { it.toMutableList() }
                            options = browserAuthentication.options.map { it.toMutableList() }
                            reason = browserAuthentication.reason
                            type = browserAuthentication.type
                            additionalProperties =
                                browserAuthentication.additionalProperties.toMutableMap()
                        }

                        /** The registered form or frame origin where values will be entered. */
                        fun credentialOrigin(credentialOrigin: String?) =
                            credentialOrigin(JsonField.ofNullable(credentialOrigin))

                        /**
                         * Alias for calling [Builder.credentialOrigin] with
                         * `credentialOrigin.orElse(null)`.
                         */
                        fun credentialOrigin(credentialOrigin: Optional<String>) =
                            credentialOrigin(credentialOrigin.getOrNull())

                        /**
                         * Sets [Builder.credentialOrigin] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.credentialOrigin] with a well-typed
                         * [String] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun credentialOrigin(credentialOrigin: JsonField<String>) = apply {
                            this.credentialOrigin = credentialOrigin
                        }

                        /** Controls to render. All submitted values are sensitive. */
                        fun fields(fields: List<Field>) = fields(JsonField.of(fields))

                        /**
                         * Sets [Builder.fields] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.fields] with a well-typed `List<Field>`
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun fields(fields: JsonField<List<Field>>) = apply {
                            this.fields = fields.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Field] to [fields].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addField(field: Field) = apply {
                            fields =
                                (fields ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("fields", it).add(field)
                                }
                        }

                        /** Sign-in methods. Empty for a plain form. */
                        fun options(options: List<Option>) = options(JsonField.of(options))

                        /**
                         * Sets [Builder.options] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.options] with a well-typed
                         * `List<Option>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun options(options: JsonField<List<Option>>) = apply {
                            this.options = options.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Option] to [options].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addOption(option: Option) = apply {
                            options =
                                (options ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("options", it).add(option)
                                }
                        }

                        /** Why the agent needs the user to sign in. */
                        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

                        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
                        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

                        /**
                         * Sets [Builder.reason] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.reason] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("browser_authentication")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [BrowserAuthentication].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .credentialOrigin()
                         * .fields()
                         * .options()
                         * .reason()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): BrowserAuthentication =
                            BrowserAuthentication(
                                checkRequired("credentialOrigin", credentialOrigin),
                                checkRequired("fields", fields).map { it.toImmutable() },
                                checkRequired("options", options).map { it.toImmutable() },
                                checkRequired("reason", reason),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): BrowserAuthentication = apply {
                        if (validated) {
                            return@apply
                        }

                        credentialOrigin()
                        fields().forEach { it.validate() }
                        options().forEach { it.validate() }
                        reason()
                        _type().let {
                            if (it != JsonValue.from("browser_authentication")) {
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
                        (if (credentialOrigin.asKnown().isPresent) 1 else 0) +
                            (fields.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                            (options.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                            (if (reason.asKnown().isPresent) 1 else 0) +
                            type.let {
                                if (it == JsonValue.from("browser_authentication")) 1 else 0
                            }

                    /** A control in a registered browser-login form. */
                    class Field
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val id: JsonField<String>,
                        private val label: JsonField<String>,
                        private val required: JsonField<Boolean>,
                        private val type: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("id")
                            @ExcludeMissing
                            id: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("label")
                            @ExcludeMissing
                            label: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("required")
                            @ExcludeMissing
                            required: JsonField<Boolean> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<String> = JsonMissing.of(),
                        ) : this(id, label, required, type, mutableMapOf())

                        /**
                         * The field ID to submit as field_id in a fields entry.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun id(): String = id.getRequired("id")

                        /**
                         * The label to display beside the control.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun label(): String = label.getRequired("label")

                        /**
                         * Whether this control requires a nonempty value.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun required(): Boolean = required.getRequired("required")

                        /**
                         * The rendering type, such as email, password, or text.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun type(): String = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [id].
                         *
                         * Unlike [id], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                        /**
                         * Returns the raw JSON value of [label].
                         *
                         * Unlike [label], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("label")
                        @ExcludeMissing
                        fun _label(): JsonField<String> = label

                        /**
                         * Returns the raw JSON value of [required].
                         *
                         * Unlike [required], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("required")
                        @ExcludeMissing
                        fun _required(): JsonField<Boolean> = required

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
                             * Returns a mutable builder for constructing an instance of [Field].
                             *
                             * The following fields are required:
                             * ```java
                             * .id()
                             * .label()
                             * .required()
                             * .type()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Field]. */
                        class Builder internal constructor() {

                            private var id: JsonField<String>? = null
                            private var label: JsonField<String>? = null
                            private var required: JsonField<Boolean>? = null
                            private var type: JsonField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(field: Field) = apply {
                                id = field.id
                                label = field.label
                                required = field.required
                                type = field.type
                                additionalProperties = field.additionalProperties.toMutableMap()
                            }

                            /** The field ID to submit as field_id in a fields entry. */
                            fun id(id: String) = id(JsonField.of(id))

                            /**
                             * Sets [Builder.id] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.id] with a well-typed [String] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun id(id: JsonField<String>) = apply { this.id = id }

                            /** The label to display beside the control. */
                            fun label(label: String) = label(JsonField.of(label))

                            /**
                             * Sets [Builder.label] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.label] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun label(label: JsonField<String>) = apply { this.label = label }

                            /** Whether this control requires a nonempty value. */
                            fun required(required: Boolean) = required(JsonField.of(required))

                            /**
                             * Sets [Builder.required] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.required] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun required(required: JsonField<Boolean>) = apply {
                                this.required = required
                            }

                            /** The rendering type, such as email, password, or text. */
                            fun type(type: String) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<String>) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Field].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .id()
                             * .label()
                             * .required()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Field =
                                Field(
                                    checkRequired("id", id),
                                    checkRequired("label", label),
                                    checkRequired("required", required),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Field = apply {
                            if (validated) {
                                return@apply
                            }

                            id()
                            label()
                            required()
                            type()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (id.asKnown().isPresent) 1 else 0) +
                                (if (label.asKnown().isPresent) 1 else 0) +
                                (if (required.asKnown().isPresent) 1 else 0) +
                                (if (type.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Field &&
                                id == other.id &&
                                label == other.label &&
                                required == other.required &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(id, label, required, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Field{id=$id, label=$label, required=$required, type=$type, additionalProperties=$additionalProperties}"
                    }

                    /** A sign-in method and the fields that belong to it. */
                    class Option
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val id: JsonField<String>,
                        private val fieldIds: JsonField<List<String>>,
                        private val label: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("id")
                            @ExcludeMissing
                            id: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("field_ids")
                            @ExcludeMissing
                            fieldIds: JsonField<List<String>> = JsonMissing.of(),
                            @JsonProperty("label")
                            @ExcludeMissing
                            label: JsonField<String> = JsonMissing.of(),
                        ) : this(id, fieldIds, label, mutableMapOf())

                        /**
                         * The option ID to submit as selected_option.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun id(): String = id.getRequired("id")

                        /**
                         * IDs from the registered fields that this method accepts.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun fieldIds(): List<String> = fieldIds.getRequired("field_ids")

                        /**
                         * The method label to display.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun label(): String = label.getRequired("label")

                        /**
                         * Returns the raw JSON value of [id].
                         *
                         * Unlike [id], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                        /**
                         * Returns the raw JSON value of [fieldIds].
                         *
                         * Unlike [fieldIds], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("field_ids")
                        @ExcludeMissing
                        fun _fieldIds(): JsonField<List<String>> = fieldIds

                        /**
                         * Returns the raw JSON value of [label].
                         *
                         * Unlike [label], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("label")
                        @ExcludeMissing
                        fun _label(): JsonField<String> = label

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
                             * Returns a mutable builder for constructing an instance of [Option].
                             *
                             * The following fields are required:
                             * ```java
                             * .id()
                             * .fieldIds()
                             * .label()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Option]. */
                        class Builder internal constructor() {

                            private var id: JsonField<String>? = null
                            private var fieldIds: JsonField<MutableList<String>>? = null
                            private var label: JsonField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(option: Option) = apply {
                                id = option.id
                                fieldIds = option.fieldIds.map { it.toMutableList() }
                                label = option.label
                                additionalProperties = option.additionalProperties.toMutableMap()
                            }

                            /** The option ID to submit as selected_option. */
                            fun id(id: String) = id(JsonField.of(id))

                            /**
                             * Sets [Builder.id] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.id] with a well-typed [String] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun id(id: JsonField<String>) = apply { this.id = id }

                            /** IDs from the registered fields that this method accepts. */
                            fun fieldIds(fieldIds: List<String>) = fieldIds(JsonField.of(fieldIds))

                            /**
                             * Sets [Builder.fieldIds] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.fieldIds] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun fieldIds(fieldIds: JsonField<List<String>>) = apply {
                                this.fieldIds = fieldIds.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [fieldIds].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addFieldId(fieldId: String) = apply {
                                fieldIds =
                                    (fieldIds ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("fieldIds", it).add(fieldId)
                                    }
                            }

                            /** The method label to display. */
                            fun label(label: String) = label(JsonField.of(label))

                            /**
                             * Sets [Builder.label] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.label] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun label(label: JsonField<String>) = apply { this.label = label }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Option].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .id()
                             * .fieldIds()
                             * .label()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Option =
                                Option(
                                    checkRequired("id", id),
                                    checkRequired("fieldIds", fieldIds).map { it.toImmutable() },
                                    checkRequired("label", label),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Option = apply {
                            if (validated) {
                                return@apply
                            }

                            id()
                            fieldIds()
                            label()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (id.asKnown().isPresent) 1 else 0) +
                                (fieldIds.asKnown().getOrNull()?.size ?: 0) +
                                (if (label.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Option &&
                                id == other.id &&
                                fieldIds == other.fieldIds &&
                                label == other.label &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(id, fieldIds, label, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Option{id=$id, fieldIds=$fieldIds, label=$label, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is BrowserAuthentication &&
                            credentialOrigin == other.credentialOrigin &&
                            fields == other.fields &&
                            options == other.options &&
                            reason == other.reason &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            credentialOrigin,
                            fields,
                            options,
                            reason,
                            type,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "BrowserAuthentication{credentialOrigin=$credentialOrigin, fields=$fields, options=$options, reason=$reason, type=$type, additionalProperties=$additionalProperties}"
                }

                /** A browser origin awaiting the application's approval decision. */
                class BrowserOriginAccess
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val origin: JsonField<String>,
                    private val reason: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("origin")
                        @ExcludeMissing
                        origin: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("reason")
                        @ExcludeMissing
                        reason: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(origin, reason, type, mutableMapOf())

                    /**
                     * The origin the browser needs permission to access.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun origin(): String = origin.getRequired("origin")

                    /**
                     * The browser's explanation for this request, or null when unavailable.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun reason(): Optional<String> = reason.getOptional("reason")

                    /**
                     * The type of the object. Always `browser_origin_access`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("browser_origin_access")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [origin].
                     *
                     * Unlike [origin], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("origin")
                    @ExcludeMissing
                    fun _origin(): JsonField<String> = origin

                    /**
                     * Returns the raw JSON value of [reason].
                     *
                     * Unlike [reason], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("reason")
                    @ExcludeMissing
                    fun _reason(): JsonField<String> = reason

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
                         * Returns a mutable builder for constructing an instance of
                         * [BrowserOriginAccess].
                         *
                         * The following fields are required:
                         * ```java
                         * .origin()
                         * .reason()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [BrowserOriginAccess]. */
                    class Builder internal constructor() {

                        private var origin: JsonField<String>? = null
                        private var reason: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("browser_origin_access")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(browserOriginAccess: BrowserOriginAccess) = apply {
                            origin = browserOriginAccess.origin
                            reason = browserOriginAccess.reason
                            type = browserOriginAccess.type
                            additionalProperties =
                                browserOriginAccess.additionalProperties.toMutableMap()
                        }

                        /** The origin the browser needs permission to access. */
                        fun origin(origin: String) = origin(JsonField.of(origin))

                        /**
                         * Sets [Builder.origin] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.origin] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun origin(origin: JsonField<String>) = apply { this.origin = origin }

                        /** The browser's explanation for this request, or null when unavailable. */
                        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

                        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
                        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

                        /**
                         * Sets [Builder.reason] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.reason] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("browser_origin_access")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [BrowserOriginAccess].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .origin()
                         * .reason()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): BrowserOriginAccess =
                            BrowserOriginAccess(
                                checkRequired("origin", origin),
                                checkRequired("reason", reason),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): BrowserOriginAccess = apply {
                        if (validated) {
                            return@apply
                        }

                        origin()
                        reason()
                        _type().let {
                            if (it != JsonValue.from("browser_origin_access")) {
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
                        (if (origin.asKnown().isPresent) 1 else 0) +
                            (if (reason.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("browser_origin_access")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is BrowserOriginAccess &&
                            origin == other.origin &&
                            reason == other.reason &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(origin, reason, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "BrowserOriginAccess{origin=$origin, reason=$reason, type=$type, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ComputerUseApprovalRequest &&
                    request == other.request &&
                    requestId == other.requestId &&
                    turnId == other.turnId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(request, requestId, turnId, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ComputerUseApprovalRequest{request=$request, requestId=$requestId, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
        }

        /** Run a function tool and submit its result. */
        class FunctionCall
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val arguments: JsonValue,
            private val callId: JsonField<String>,
            private val name: JsonField<String>,
            private val turnId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("arguments") @ExcludeMissing arguments: JsonValue = JsonMissing.of(),
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("turn_id")
                @ExcludeMissing
                turnId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(arguments, callId, name, turnId, type, mutableMapOf())

            /**
             * The arguments supplied by the model.
             *
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = functionCall.arguments().convert(MyClass.class);
             * ```
             */
            @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonValue = arguments

            /**
             * The ID to include when submitting the function result.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun callId(): String = callId.getRequired("call_id")

            /**
             * The function name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * The ID of the turn that requested the function call.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun turnId(): String = turnId.getRequired("turn_id")

            /**
             * The type of the object. Always `function_call`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("function_call")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [callId].
             *
             * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [turnId].
             *
             * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

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
                 * Returns a mutable builder for constructing an instance of [FunctionCall].
                 *
                 * The following fields are required:
                 * ```java
                 * .arguments()
                 * .callId()
                 * .name()
                 * .turnId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FunctionCall]. */
            class Builder internal constructor() {

                private var arguments: JsonValue? = null
                private var callId: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var turnId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("function_call")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(functionCall: FunctionCall) = apply {
                    arguments = functionCall.arguments
                    callId = functionCall.callId
                    name = functionCall.name
                    turnId = functionCall.turnId
                    type = functionCall.type
                    additionalProperties = functionCall.additionalProperties.toMutableMap()
                }

                /** The arguments supplied by the model. */
                fun arguments(arguments: JsonValue) = apply { this.arguments = arguments }

                /** The ID to include when submitting the function result. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** The function name. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** The ID of the turn that requested the function call. */
                fun turnId(turnId: String) = turnId(JsonField.of(turnId))

                /**
                 * Sets [Builder.turnId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.turnId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("function_call")
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
                 * Returns an immutable instance of [FunctionCall].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .arguments()
                 * .callId()
                 * .name()
                 * .turnId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FunctionCall =
                    FunctionCall(
                        checkRequired("arguments", arguments),
                        checkRequired("callId", callId),
                        checkRequired("name", name),
                        checkRequired("turnId", turnId),
                        type,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): FunctionCall = apply {
                if (validated) {
                    return@apply
                }

                callId()
                name()
                turnId()
                _type().let {
                    if (it != JsonValue.from("function_call")) {
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
                (if (callId.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (turnId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("function_call")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is FunctionCall &&
                    arguments == other.arguments &&
                    callId == other.callId &&
                    name == other.name &&
                    turnId == other.turnId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(arguments, callId, name, turnId, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FunctionCall{arguments=$arguments, callId=$callId, name=$name, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
        }

        /** Reconnect a session environment. */
        class EnvironmentConnection
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val environmentId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("environment_id")
                @ExcludeMissing
                environmentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(environmentId, type, mutableMapOf())

            /**
             * The ID of the environment to reconnect.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun environmentId(): String = environmentId.getRequired("environment_id")

            /**
             * The type of the object. Always `environment_connection`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("environment_connection")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [environmentId].
             *
             * Unlike [environmentId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("environment_id")
            @ExcludeMissing
            fun _environmentId(): JsonField<String> = environmentId

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
                 * Returns a mutable builder for constructing an instance of
                 * [EnvironmentConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .environmentId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EnvironmentConnection]. */
            class Builder internal constructor() {

                private var environmentId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("environment_connection")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(environmentConnection: EnvironmentConnection) = apply {
                    environmentId = environmentConnection.environmentId
                    type = environmentConnection.type
                    additionalProperties = environmentConnection.additionalProperties.toMutableMap()
                }

                /** The ID of the environment to reconnect. */
                fun environmentId(environmentId: String) =
                    environmentId(JsonField.of(environmentId))

                /**
                 * Sets [Builder.environmentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.environmentId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun environmentId(environmentId: JsonField<String>) = apply {
                    this.environmentId = environmentId
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("environment_connection")
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
                 * Returns an immutable instance of [EnvironmentConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .environmentId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): EnvironmentConnection =
                    EnvironmentConnection(
                        checkRequired("environmentId", environmentId),
                        type,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): EnvironmentConnection = apply {
                if (validated) {
                    return@apply
                }

                environmentId()
                _type().let {
                    if (it != JsonValue.from("environment_connection")) {
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
                (if (environmentId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("environment_connection")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EnvironmentConnection &&
                    environmentId == other.environmentId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(environmentId, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EnvironmentConnection{environmentId=$environmentId, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    /** The current status of the session. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            /**
             * The session has no turn in progress and is ready for input. A hosted environment may
             * still be provisioning.
             */
            @JvmField val IDLE = of("idle")

            /** The session is processing a turn. */
            @JvmField val IN_PROGRESS = of("in_progress")

            /** The session is waiting for one or more required actions. */
            @JvmField val REQUIRES_ACTION = of("requires_action")

            /** The session failed. */
            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            /**
             * The session has no turn in progress and is ready for input. A hosted environment may
             * still be provisioning.
             */
            IDLE,
            /** The session is processing a turn. */
            IN_PROGRESS,
            /** The session is waiting for one or more required actions. */
            REQUIRES_ACTION,
            /** The session failed. */
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /**
             * The session has no turn in progress and is ready for input. A hosted environment may
             * still be provisioning.
             */
            IDLE,
            /** The session is processing a turn. */
            IN_PROGRESS,
            /** The session is waiting for one or more required actions. */
            REQUIRES_ACTION,
            /** The session failed. */
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                IDLE -> Value.IDLE
                IN_PROGRESS -> Value.IN_PROGRESS
                REQUIRES_ACTION -> Value.REQUIRES_ACTION
                FAILED -> Value.FAILED
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
                IDLE -> Known.IDLE
                IN_PROGRESS -> Known.IN_PROGRESS
                REQUIRES_ACTION -> Known.REQUIRES_ACTION
                FAILED -> Known.FAILED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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
        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSession &&
            id == other.id &&
            agent == other.agent &&
            createdAt == other.createdAt &&
            environment == other.environment &&
            error == other.error &&
            lastActiveAt == other.lastActiveAt &&
            metadata == other.metadata &&
            object_ == other.object_ &&
            requiredActions == other.requiredActions &&
            status == other.status &&
            usage == other.usage &&
            vaultIds == other.vaultIds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            agent,
            createdAt,
            environment,
            error,
            lastActiveAt,
            metadata,
            object_,
            requiredActions,
            status,
            usage,
            vaultIds,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentSession{id=$id, agent=$agent, createdAt=$createdAt, environment=$environment, error=$error, lastActiveAt=$lastActiveAt, metadata=$metadata, object_=$object_, requiredActions=$requiredActions, status=$status, usage=$usage, vaultIds=$vaultIds, additionalProperties=$additionalProperties}"
}
