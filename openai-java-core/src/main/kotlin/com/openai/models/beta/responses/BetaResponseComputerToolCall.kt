// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A tool call to a computer use tool. See the
 * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
 * information.
 */
class BetaResponseComputerToolCall
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val callId: JsonField<String>,
    private val pendingSafetyChecks: JsonField<List<PendingSafetyCheck>>,
    private val status: JsonField<Status>,
    private val type: JsonField<Type>,
    private val action: JsonField<BetaComputerAction>,
    private val actions: JsonField<List<BetaComputerAction>>,
    private val agent: JsonField<Agent>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pending_safety_checks")
        @ExcludeMissing
        pendingSafetyChecks: JsonField<List<PendingSafetyCheck>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("action")
        @ExcludeMissing
        action: JsonField<BetaComputerAction> = JsonMissing.of(),
        @JsonProperty("actions")
        @ExcludeMissing
        actions: JsonField<List<BetaComputerAction>> = JsonMissing.of(),
        @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
    ) : this(id, callId, pendingSafetyChecks, status, type, action, actions, agent, mutableMapOf())

    /**
     * The unique ID of the computer call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * An identifier used when responding to the tool call with output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun callId(): String = callId.getRequired("call_id")

    /**
     * The pending safety checks for the computer call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pendingSafetyChecks(): List<PendingSafetyCheck> =
        pendingSafetyChecks.getRequired("pending_safety_checks")

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The type of the computer call. Always `computer_call`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * A click action.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun action(): Optional<BetaComputerAction> = action.getOptional("action")

    /**
     * Flattened batched actions for `computer_use`. Each action includes an `type` discriminator
     * and action-specific fields.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun actions(): Optional<List<BetaComputerAction>> = actions.getOptional("actions")

    /**
     * The agent that produced this item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agent(): Optional<Agent> = agent.getOptional("agent")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [callId].
     *
     * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

    /**
     * Returns the raw JSON value of [pendingSafetyChecks].
     *
     * Unlike [pendingSafetyChecks], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("pending_safety_checks")
    @ExcludeMissing
    fun _pendingSafetyChecks(): JsonField<List<PendingSafetyCheck>> = pendingSafetyChecks

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [action].
     *
     * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<BetaComputerAction> = action

    /**
     * Returns the raw JSON value of [actions].
     *
     * Unlike [actions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("actions")
    @ExcludeMissing
    fun _actions(): JsonField<List<BetaComputerAction>> = actions

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

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
         * Returns a mutable builder for constructing an instance of [BetaResponseComputerToolCall].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .callId()
         * .pendingSafetyChecks()
         * .status()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseComputerToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var callId: JsonField<String>? = null
        private var pendingSafetyChecks: JsonField<MutableList<PendingSafetyCheck>>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonField<Type>? = null
        private var action: JsonField<BetaComputerAction> = JsonMissing.of()
        private var actions: JsonField<MutableList<BetaComputerAction>>? = null
        private var agent: JsonField<Agent> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseComputerToolCall: BetaResponseComputerToolCall) = apply {
            id = betaResponseComputerToolCall.id
            callId = betaResponseComputerToolCall.callId
            pendingSafetyChecks =
                betaResponseComputerToolCall.pendingSafetyChecks.map { it.toMutableList() }
            status = betaResponseComputerToolCall.status
            type = betaResponseComputerToolCall.type
            action = betaResponseComputerToolCall.action
            actions = betaResponseComputerToolCall.actions.map { it.toMutableList() }
            agent = betaResponseComputerToolCall.agent
            additionalProperties = betaResponseComputerToolCall.additionalProperties.toMutableMap()
        }

        /** The unique ID of the computer call. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** An identifier used when responding to the tool call with output. */
        fun callId(callId: String) = callId(JsonField.of(callId))

        /**
         * Sets [Builder.callId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun callId(callId: JsonField<String>) = apply { this.callId = callId }

        /** The pending safety checks for the computer call. */
        fun pendingSafetyChecks(pendingSafetyChecks: List<PendingSafetyCheck>) =
            pendingSafetyChecks(JsonField.of(pendingSafetyChecks))

        /**
         * Sets [Builder.pendingSafetyChecks] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pendingSafetyChecks] with a well-typed
         * `List<PendingSafetyCheck>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun pendingSafetyChecks(pendingSafetyChecks: JsonField<List<PendingSafetyCheck>>) = apply {
            this.pendingSafetyChecks = pendingSafetyChecks.map { it.toMutableList() }
        }

        /**
         * Adds a single [PendingSafetyCheck] to [pendingSafetyChecks].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPendingSafetyCheck(pendingSafetyCheck: PendingSafetyCheck) = apply {
            pendingSafetyChecks =
                (pendingSafetyChecks ?: JsonField.of(mutableListOf())).also {
                    checkKnown("pendingSafetyChecks", it).add(pendingSafetyCheck)
                }
        }

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The type of the computer call. Always `computer_call`. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** A click action. */
        fun action(action: BetaComputerAction) = action(JsonField.of(action))

        /**
         * Sets [Builder.action] to an arbitrary JSON value.
         *
         * You should usually call [Builder.action] with a well-typed [BetaComputerAction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun action(action: JsonField<BetaComputerAction>) = apply { this.action = action }

        /** Alias for calling [action] with `BetaComputerAction.ofClick(click)`. */
        fun action(click: BetaComputerAction.Click) = action(BetaComputerAction.ofClick(click))

        /** Alias for calling [action] with `BetaComputerAction.ofDoubleClick(doubleClick)`. */
        fun action(doubleClick: BetaComputerAction.DoubleClick) =
            action(BetaComputerAction.ofDoubleClick(doubleClick))

        /** Alias for calling [action] with `BetaComputerAction.ofDrag(drag)`. */
        fun action(drag: BetaComputerAction.Drag) = action(BetaComputerAction.ofDrag(drag))

        /**
         * Alias for calling [action] with the following:
         * ```java
         * BetaComputerAction.Drag.builder()
         *     .path(path)
         *     .build()
         * ```
         */
        fun dragAction(path: List<BetaComputerAction.Drag.Path>) =
            action(BetaComputerAction.Drag.builder().path(path).build())

        /** Alias for calling [action] with `BetaComputerAction.ofKeypress(keypress)`. */
        fun action(keypress: BetaComputerAction.Keypress) =
            action(BetaComputerAction.ofKeypress(keypress))

        /**
         * Alias for calling [action] with the following:
         * ```java
         * BetaComputerAction.Keypress.builder()
         *     .keys(keys)
         *     .build()
         * ```
         */
        fun keypressAction(keys: List<String>) =
            action(BetaComputerAction.Keypress.builder().keys(keys).build())

        /** Alias for calling [action] with `BetaComputerAction.ofMove(move)`. */
        fun action(move: BetaComputerAction.Move) = action(BetaComputerAction.ofMove(move))

        /** Alias for calling [action] with `BetaComputerAction.ofScreenshot()`. */
        fun actionScreenshot() = action(BetaComputerAction.ofScreenshot())

        /** Alias for calling [action] with `BetaComputerAction.ofScroll(scroll)`. */
        fun action(scroll: BetaComputerAction.Scroll) = action(BetaComputerAction.ofScroll(scroll))

        /** Alias for calling [action] with `BetaComputerAction.ofType(type)`. */
        fun action(type: BetaComputerAction.Type) = action(BetaComputerAction.ofType(type))

        /**
         * Alias for calling [action] with the following:
         * ```java
         * BetaComputerAction.Type.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun typeAction(text: String) = action(BetaComputerAction.Type.builder().text(text).build())

        /** Alias for calling [action] with `BetaComputerAction.ofWait()`. */
        fun actionWait() = action(BetaComputerAction.ofWait())

        /**
         * Flattened batched actions for `computer_use`. Each action includes an `type`
         * discriminator and action-specific fields.
         */
        fun actions(actions: List<BetaComputerAction>) = actions(JsonField.of(actions))

        /**
         * Sets [Builder.actions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actions] with a well-typed `List<BetaComputerAction>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun actions(actions: JsonField<List<BetaComputerAction>>) = apply {
            this.actions = actions.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaComputerAction] to [actions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAction(action: BetaComputerAction) = apply {
            actions =
                (actions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("actions", it).add(action)
                }
        }

        /** Alias for calling [addAction] with `BetaComputerAction.ofClick(click)`. */
        fun addAction(click: BetaComputerAction.Click) =
            addAction(BetaComputerAction.ofClick(click))

        /** Alias for calling [addAction] with `BetaComputerAction.ofDoubleClick(doubleClick)`. */
        fun addAction(doubleClick: BetaComputerAction.DoubleClick) =
            addAction(BetaComputerAction.ofDoubleClick(doubleClick))

        /** Alias for calling [addAction] with `BetaComputerAction.ofDrag(drag)`. */
        fun addAction(drag: BetaComputerAction.Drag) = addAction(BetaComputerAction.ofDrag(drag))

        /**
         * Alias for calling [addAction] with the following:
         * ```java
         * BetaComputerAction.Drag.builder()
         *     .path(path)
         *     .build()
         * ```
         */
        fun addDragAction(path: List<BetaComputerAction.Drag.Path>) =
            addAction(BetaComputerAction.Drag.builder().path(path).build())

        /** Alias for calling [addAction] with `BetaComputerAction.ofKeypress(keypress)`. */
        fun addAction(keypress: BetaComputerAction.Keypress) =
            addAction(BetaComputerAction.ofKeypress(keypress))

        /**
         * Alias for calling [addAction] with the following:
         * ```java
         * BetaComputerAction.Keypress.builder()
         *     .keys(keys)
         *     .build()
         * ```
         */
        fun addKeypressAction(keys: List<String>) =
            addAction(BetaComputerAction.Keypress.builder().keys(keys).build())

        /** Alias for calling [addAction] with `BetaComputerAction.ofMove(move)`. */
        fun addAction(move: BetaComputerAction.Move) = addAction(BetaComputerAction.ofMove(move))

        /** Alias for calling [addAction] with `BetaComputerAction.ofScreenshot()`. */
        fun addActionScreenshot() = addAction(BetaComputerAction.ofScreenshot())

        /** Alias for calling [addAction] with `BetaComputerAction.ofScroll(scroll)`. */
        fun addAction(scroll: BetaComputerAction.Scroll) =
            addAction(BetaComputerAction.ofScroll(scroll))

        /** Alias for calling [addAction] with `BetaComputerAction.ofType(type)`. */
        fun addAction(type: BetaComputerAction.Type) = addAction(BetaComputerAction.ofType(type))

        /**
         * Alias for calling [addAction] with the following:
         * ```java
         * BetaComputerAction.Type.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun addTypeAction(text: String) =
            addAction(BetaComputerAction.Type.builder().text(text).build())

        /** Alias for calling [addAction] with `BetaComputerAction.ofWait()`. */
        fun addActionWait() = addAction(BetaComputerAction.ofWait())

        /** The agent that produced this item. */
        fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

        /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
        fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

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
         * Returns an immutable instance of [BetaResponseComputerToolCall].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .callId()
         * .pendingSafetyChecks()
         * .status()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseComputerToolCall =
            BetaResponseComputerToolCall(
                checkRequired("id", id),
                checkRequired("callId", callId),
                checkRequired("pendingSafetyChecks", pendingSafetyChecks).map { it.toImmutable() },
                checkRequired("status", status),
                checkRequired("type", type),
                action,
                (actions ?: JsonMissing.of()).map { it.toImmutable() },
                agent,
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
    fun validate(): BetaResponseComputerToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        callId()
        pendingSafetyChecks().forEach { it.validate() }
        status().validate()
        type().validate()
        action().ifPresent { it.validate() }
        actions().ifPresent { it.forEach { it.validate() } }
        agent().ifPresent { it.validate() }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
            (pendingSafetyChecks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (action.asKnown().getOrNull()?.validity() ?: 0) +
            (actions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (agent.asKnown().getOrNull()?.validity() ?: 0)

    /** A pending safety check for the computer call. */
    class PendingSafetyCheck
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val code: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(id, code, message, mutableMapOf())

        /**
         * The ID of the pending safety check.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The type of the pending safety check.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun code(): Optional<String> = code.getOptional("code")

        /**
         * Details about the pending safety check.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun message(): Optional<String> = message.getOptional("message")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
             * Returns a mutable builder for constructing an instance of [PendingSafetyCheck].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PendingSafetyCheck]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var code: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(pendingSafetyCheck: PendingSafetyCheck) = apply {
                id = pendingSafetyCheck.id
                code = pendingSafetyCheck.code
                message = pendingSafetyCheck.message
                additionalProperties = pendingSafetyCheck.additionalProperties.toMutableMap()
            }

            /** The ID of the pending safety check. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The type of the pending safety check. */
            fun code(code: String?) = code(JsonField.ofNullable(code))

            /** Alias for calling [Builder.code] with `code.orElse(null)`. */
            fun code(code: Optional<String>) = code(code.getOrNull())

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Details about the pending safety check. */
            fun message(message: String?) = message(JsonField.ofNullable(message))

            /** Alias for calling [Builder.message] with `message.orElse(null)`. */
            fun message(message: Optional<String>) = message(message.getOrNull())

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

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
             * Returns an immutable instance of [PendingSafetyCheck].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PendingSafetyCheck =
                PendingSafetyCheck(
                    checkRequired("id", id),
                    code,
                    message,
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
        fun validate(): PendingSafetyCheck = apply {
            if (validated) {
                return@apply
            }

            id()
            code()
            message()
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
                (if (code.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PendingSafetyCheck &&
                id == other.id &&
                code == other.code &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, code, message, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PendingSafetyCheck{id=$id, code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
     */
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

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            INCOMPLETE,
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
            IN_PROGRESS,
            COMPLETED,
            INCOMPLETE,
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
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                INCOMPLETE -> Value.INCOMPLETE
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
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                INCOMPLETE -> Known.INCOMPLETE
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

    /** The type of the computer call. Always `computer_call`. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val COMPUTER_CALL = of("computer_call")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            COMPUTER_CALL
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPUTER_CALL,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                COMPUTER_CALL -> Value.COMPUTER_CALL
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
                COMPUTER_CALL -> Known.COMPUTER_CALL
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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
        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The agent that produced this item. */
    class Agent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val agentName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("agent_name")
            @ExcludeMissing
            agentName: JsonField<String> = JsonMissing.of()
        ) : this(agentName, mutableMapOf())

        /**
         * The canonical name of the agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun agentName(): String = agentName.getRequired("agent_name")

        /**
         * Returns the raw JSON value of [agentName].
         *
         * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent_name") @ExcludeMissing fun _agentName(): JsonField<String> = agentName

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
             * .agentName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Agent]. */
        class Builder internal constructor() {

            private var agentName: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agent: Agent) = apply {
                agentName = agent.agentName
                additionalProperties = agent.additionalProperties.toMutableMap()
            }

            /** The canonical name of the agent that produced this item. */
            fun agentName(agentName: String) = agentName(JsonField.of(agentName))

            /**
             * Sets [Builder.agentName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

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
             * .agentName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Agent =
                Agent(checkRequired("agentName", agentName), additionalProperties.toMutableMap())
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

            agentName()
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
        @JvmSynthetic internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Agent &&
                agentName == other.agentName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseComputerToolCall &&
            id == other.id &&
            callId == other.callId &&
            pendingSafetyChecks == other.pendingSafetyChecks &&
            status == other.status &&
            type == other.type &&
            action == other.action &&
            actions == other.actions &&
            agent == other.agent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            callId,
            pendingSafetyChecks,
            status,
            type,
            action,
            actions,
            agent,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseComputerToolCall{id=$id, callId=$callId, pendingSafetyChecks=$pendingSafetyChecks, status=$status, type=$type, action=$action, actions=$actions, agent=$agent, additionalProperties=$additionalProperties}"
}
