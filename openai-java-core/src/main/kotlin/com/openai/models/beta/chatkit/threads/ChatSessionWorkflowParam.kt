// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Workflow reference and overrides applied to the chat session. */
class ChatSessionWorkflowParam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val stateVariables: JsonField<StateVariables>,
    private val tracing: JsonField<Tracing>,
    private val version: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("state_variables")
        @ExcludeMissing
        stateVariables: JsonField<StateVariables> = JsonMissing.of(),
        @JsonProperty("tracing") @ExcludeMissing tracing: JsonField<Tracing> = JsonMissing.of(),
        @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
    ) : this(id, stateVariables, tracing, version, mutableMapOf())

    /**
     * Identifier for the workflow invoked by the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * State variables forwarded to the workflow. Keys may be up to 64 characters, values must be
     * primitive types, and the map defaults to an empty object.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun stateVariables(): Optional<StateVariables> = stateVariables.getOptional("state_variables")

    /**
     * Optional tracing overrides for the workflow invocation. When omitted, tracing is enabled by
     * default.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tracing(): Optional<Tracing> = tracing.getOptional("tracing")

    /**
     * Specific workflow version to run. Defaults to the latest deployed version.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun version(): Optional<String> = version.getOptional("version")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [stateVariables].
     *
     * Unlike [stateVariables], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("state_variables")
    @ExcludeMissing
    fun _stateVariables(): JsonField<StateVariables> = stateVariables

    /**
     * Returns the raw JSON value of [tracing].
     *
     * Unlike [tracing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tracing") @ExcludeMissing fun _tracing(): JsonField<Tracing> = tracing

    /**
     * Returns the raw JSON value of [version].
     *
     * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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
         * Returns a mutable builder for constructing an instance of [ChatSessionWorkflowParam].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionWorkflowParam]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var stateVariables: JsonField<StateVariables> = JsonMissing.of()
        private var tracing: JsonField<Tracing> = JsonMissing.of()
        private var version: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSessionWorkflowParam: ChatSessionWorkflowParam) = apply {
            id = chatSessionWorkflowParam.id
            stateVariables = chatSessionWorkflowParam.stateVariables
            tracing = chatSessionWorkflowParam.tracing
            version = chatSessionWorkflowParam.version
            additionalProperties = chatSessionWorkflowParam.additionalProperties.toMutableMap()
        }

        /** Identifier for the workflow invoked by the session. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * State variables forwarded to the workflow. Keys may be up to 64 characters, values must
         * be primitive types, and the map defaults to an empty object.
         */
        fun stateVariables(stateVariables: StateVariables) =
            stateVariables(JsonField.of(stateVariables))

        /**
         * Sets [Builder.stateVariables] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stateVariables] with a well-typed [StateVariables] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun stateVariables(stateVariables: JsonField<StateVariables>) = apply {
            this.stateVariables = stateVariables
        }

        /**
         * Optional tracing overrides for the workflow invocation. When omitted, tracing is enabled
         * by default.
         */
        fun tracing(tracing: Tracing) = tracing(JsonField.of(tracing))

        /**
         * Sets [Builder.tracing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tracing] with a well-typed [Tracing] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tracing(tracing: JsonField<Tracing>) = apply { this.tracing = tracing }

        /** Specific workflow version to run. Defaults to the latest deployed version. */
        fun version(version: String) = version(JsonField.of(version))

        /**
         * Sets [Builder.version] to an arbitrary JSON value.
         *
         * You should usually call [Builder.version] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun version(version: JsonField<String>) = apply { this.version = version }

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
         * Returns an immutable instance of [ChatSessionWorkflowParam].
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
        fun build(): ChatSessionWorkflowParam =
            ChatSessionWorkflowParam(
                checkRequired("id", id),
                stateVariables,
                tracing,
                version,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionWorkflowParam = apply {
        if (validated) {
            return@apply
        }

        id()
        stateVariables().ifPresent { it.validate() }
        tracing().ifPresent { it.validate() }
        version()
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
            (stateVariables.asKnown().getOrNull()?.validity() ?: 0) +
            (tracing.asKnown().getOrNull()?.validity() ?: 0) +
            (if (version.asKnown().isPresent) 1 else 0)

    /**
     * State variables forwarded to the workflow. Keys may be up to 64 characters, values must be
     * primitive types, and the map defaults to an empty object.
     */
    class StateVariables
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

            /** Returns a mutable builder for constructing an instance of [StateVariables]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StateVariables]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stateVariables: StateVariables) = apply {
                additionalProperties = stateVariables.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [StateVariables].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): StateVariables = StateVariables(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): StateVariables = apply {
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

            return other is StateVariables && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "StateVariables{additionalProperties=$additionalProperties}"
    }

    /**
     * Optional tracing overrides for the workflow invocation. When omitted, tracing is enabled by
     * default.
     */
    class Tracing
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Whether tracing is enabled during the session. Defaults to true.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun enabled(): Optional<Boolean> = enabled.getOptional("enabled")

        /**
         * Returns the raw JSON value of [enabled].
         *
         * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

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

            /** Returns a mutable builder for constructing an instance of [Tracing]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Tracing]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tracing: Tracing) = apply {
                enabled = tracing.enabled
                additionalProperties = tracing.additionalProperties.toMutableMap()
            }

            /** Whether tracing is enabled during the session. Defaults to true. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [Tracing].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Tracing = Tracing(enabled, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Tracing = apply {
            if (validated) {
                return@apply
            }

            enabled()
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
        @JvmSynthetic internal fun validity(): Int = (if (enabled.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tracing &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Tracing{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionWorkflowParam &&
            id == other.id &&
            stateVariables == other.stateVariables &&
            tracing == other.tracing &&
            version == other.version &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, stateVariables, tracing, version, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSessionWorkflowParam{id=$id, stateVariables=$stateVariables, tracing=$tracing, version=$version, additionalProperties=$additionalProperties}"
}
