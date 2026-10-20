// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A command execution produced by the agent. */
class AgentCommandExecutionItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val command: JsonField<String>,
    private val cwd: JsonField<String>,
    private val durationMs: JsonField<Long>,
    private val exitCode: JsonField<Long>,
    private val output: JsonField<String>,
    private val status: JsonField<AgentFunctionCallStatus>,
    private val turnId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("command") @ExcludeMissing command: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cwd") @ExcludeMissing cwd: JsonField<String> = JsonMissing.of(),
        @JsonProperty("duration_ms") @ExcludeMissing durationMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("exit_code") @ExcludeMissing exitCode: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("output") @ExcludeMissing output: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<AgentFunctionCallStatus> = JsonMissing.of(),
        @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, command, cwd, durationMs, exitCode, output, status, turnId, type, mutableMapOf())

    /**
     * The ID of the command execution item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The command that was executed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun command(): String = command.getRequired("command")

    /**
     * The working directory used to execute the command.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cwd(): Optional<String> = cwd.getOptional("cwd")

    /**
     * The command duration in milliseconds.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun durationMs(): Optional<Long> = durationMs.getOptional("duration_ms")

    /**
     * The process exit code, if the command completed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exitCode(): Optional<Long> = exitCode.getOptional("exit_code")

    /**
     * The command output, if available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun output(): Optional<String> = output.getOptional("output")

    /**
     * The status of the command execution.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): AgentFunctionCallStatus = status.getRequired("status")

    /**
     * The ID of the turn that contains this item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun turnId(): String = turnId.getRequired("turn_id")

    /**
     * The item type. Always `command_execution`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("command_execution")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
     * Returns the raw JSON value of [durationMs].
     *
     * Unlike [durationMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration_ms") @ExcludeMissing fun _durationMs(): JsonField<Long> = durationMs

    /**
     * Returns the raw JSON value of [exitCode].
     *
     * Unlike [exitCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("exit_code") @ExcludeMissing fun _exitCode(): JsonField<Long> = exitCode

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status")
    @ExcludeMissing
    fun _status(): JsonField<AgentFunctionCallStatus> = status

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
         * Returns a mutable builder for constructing an instance of [AgentCommandExecutionItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .command()
         * .cwd()
         * .durationMs()
         * .exitCode()
         * .output()
         * .status()
         * .turnId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentCommandExecutionItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var command: JsonField<String>? = null
        private var cwd: JsonField<String>? = null
        private var durationMs: JsonField<Long>? = null
        private var exitCode: JsonField<Long>? = null
        private var output: JsonField<String>? = null
        private var status: JsonField<AgentFunctionCallStatus>? = null
        private var turnId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("command_execution")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentCommandExecutionItem: AgentCommandExecutionItem) = apply {
            id = agentCommandExecutionItem.id
            command = agentCommandExecutionItem.command
            cwd = agentCommandExecutionItem.cwd
            durationMs = agentCommandExecutionItem.durationMs
            exitCode = agentCommandExecutionItem.exitCode
            output = agentCommandExecutionItem.output
            status = agentCommandExecutionItem.status
            turnId = agentCommandExecutionItem.turnId
            type = agentCommandExecutionItem.type
            additionalProperties = agentCommandExecutionItem.additionalProperties.toMutableMap()
        }

        /** The ID of the command execution item. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The command that was executed. */
        fun command(command: String) = command(JsonField.of(command))

        /**
         * Sets [Builder.command] to an arbitrary JSON value.
         *
         * You should usually call [Builder.command] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun command(command: JsonField<String>) = apply { this.command = command }

        /** The working directory used to execute the command. */
        fun cwd(cwd: String?) = cwd(JsonField.ofNullable(cwd))

        /** Alias for calling [Builder.cwd] with `cwd.orElse(null)`. */
        fun cwd(cwd: Optional<String>) = cwd(cwd.getOrNull())

        /**
         * Sets [Builder.cwd] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cwd] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cwd(cwd: JsonField<String>) = apply { this.cwd = cwd }

        /** The command duration in milliseconds. */
        fun durationMs(durationMs: Long?) = durationMs(JsonField.ofNullable(durationMs))

        /**
         * Alias for [Builder.durationMs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun durationMs(durationMs: Long) = durationMs(durationMs as Long?)

        /** Alias for calling [Builder.durationMs] with `durationMs.orElse(null)`. */
        fun durationMs(durationMs: Optional<Long>) = durationMs(durationMs.getOrNull())

        /**
         * Sets [Builder.durationMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.durationMs] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun durationMs(durationMs: JsonField<Long>) = apply { this.durationMs = durationMs }

        /** The process exit code, if the command completed. */
        fun exitCode(exitCode: Long?) = exitCode(JsonField.ofNullable(exitCode))

        /**
         * Alias for [Builder.exitCode].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun exitCode(exitCode: Long) = exitCode(exitCode as Long?)

        /** Alias for calling [Builder.exitCode] with `exitCode.orElse(null)`. */
        fun exitCode(exitCode: Optional<Long>) = exitCode(exitCode.getOrNull())

        /**
         * Sets [Builder.exitCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exitCode] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun exitCode(exitCode: JsonField<Long>) = apply { this.exitCode = exitCode }

        /** The command output, if available. */
        fun output(output: String?) = output(JsonField.ofNullable(output))

        /** Alias for calling [Builder.output] with `output.orElse(null)`. */
        fun output(output: Optional<String>) = output(output.getOrNull())

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun output(output: JsonField<String>) = apply { this.output = output }

        /** The status of the command execution. */
        fun status(status: AgentFunctionCallStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [AgentFunctionCallStatus]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun status(status: JsonField<AgentFunctionCallStatus>) = apply { this.status = status }

        /** The ID of the turn that contains this item. */
        fun turnId(turnId: String) = turnId(JsonField.of(turnId))

        /**
         * Sets [Builder.turnId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.turnId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("command_execution")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [AgentCommandExecutionItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .command()
         * .cwd()
         * .durationMs()
         * .exitCode()
         * .output()
         * .status()
         * .turnId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentCommandExecutionItem =
            AgentCommandExecutionItem(
                checkRequired("id", id),
                checkRequired("command", command),
                checkRequired("cwd", cwd),
                checkRequired("durationMs", durationMs),
                checkRequired("exitCode", exitCode),
                checkRequired("output", output),
                checkRequired("status", status),
                checkRequired("turnId", turnId),
                type,
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
    fun validate(): AgentCommandExecutionItem = apply {
        if (validated) {
            return@apply
        }

        id()
        command()
        cwd()
        durationMs()
        exitCode()
        output()
        status().validate()
        turnId()
        _type().let {
            if (it != JsonValue.from("command_execution")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (command.asKnown().isPresent) 1 else 0) +
            (if (cwd.asKnown().isPresent) 1 else 0) +
            (if (durationMs.asKnown().isPresent) 1 else 0) +
            (if (exitCode.asKnown().isPresent) 1 else 0) +
            (if (output.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (turnId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("command_execution")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentCommandExecutionItem &&
            id == other.id &&
            command == other.command &&
            cwd == other.cwd &&
            durationMs == other.durationMs &&
            exitCode == other.exitCode &&
            output == other.output &&
            status == other.status &&
            turnId == other.turnId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            command,
            cwd,
            durationMs,
            exitCode,
            output,
            status,
            turnId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentCommandExecutionItem{id=$id, command=$command, cwd=$cwd, durationMs=$durationMs, exitCode=$exitCode, output=$output, status=$status, turnId=$turnId, type=$type, additionalProperties=$additionalProperties}"
}
