// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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

/** Captured stdout and stderr for a portion of a function shell tool call output. */
class ResponseFunctionShellCallOutputContent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val outcome: JsonField<Outcome>,
    private val stderr: JsonField<String>,
    private val stdout: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("outcome") @ExcludeMissing outcome: JsonField<Outcome> = JsonMissing.of(),
        @JsonProperty("stderr") @ExcludeMissing stderr: JsonField<String> = JsonMissing.of(),
        @JsonProperty("stdout") @ExcludeMissing stdout: JsonField<String> = JsonMissing.of(),
    ) : this(outcome, stderr, stdout, mutableMapOf())

    /**
     * The exit or timeout outcome associated with this chunk.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outcome(): Outcome = outcome.getRequired("outcome")

    /**
     * Captured stderr output for this chunk of the shell call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stderr(): String = stderr.getRequired("stderr")

    /**
     * Captured stdout output for this chunk of the shell call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stdout(): String = stdout.getRequired("stdout")

    /**
     * Returns the raw JSON value of [outcome].
     *
     * Unlike [outcome], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("outcome") @ExcludeMissing fun _outcome(): JsonField<Outcome> = outcome

    /**
     * Returns the raw JSON value of [stderr].
     *
     * Unlike [stderr], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stderr") @ExcludeMissing fun _stderr(): JsonField<String> = stderr

    /**
     * Returns the raw JSON value of [stdout].
     *
     * Unlike [stdout], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stdout") @ExcludeMissing fun _stdout(): JsonField<String> = stdout

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
         * [ResponseFunctionShellCallOutputContent].
         *
         * The following fields are required:
         * ```java
         * .outcome()
         * .stderr()
         * .stdout()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFunctionShellCallOutputContent]. */
    class Builder internal constructor() {

        private var outcome: JsonField<Outcome>? = null
        private var stderr: JsonField<String>? = null
        private var stdout: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            responseFunctionShellCallOutputContent: ResponseFunctionShellCallOutputContent
        ) = apply {
            outcome = responseFunctionShellCallOutputContent.outcome
            stderr = responseFunctionShellCallOutputContent.stderr
            stdout = responseFunctionShellCallOutputContent.stdout
            additionalProperties =
                responseFunctionShellCallOutputContent.additionalProperties.toMutableMap()
        }

        /** The exit or timeout outcome associated with this chunk. */
        fun outcome(outcome: Outcome) = outcome(JsonField.of(outcome))

        /**
         * Sets [Builder.outcome] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outcome] with a well-typed [Outcome] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun outcome(outcome: JsonField<Outcome>) = apply { this.outcome = outcome }

        /** Alias for calling [outcome] with `Outcome.ofTimeout()`. */
        fun outcomeTimeout() = outcome(Outcome.ofTimeout())

        /** Alias for calling [outcome] with `Outcome.ofExit(exit)`. */
        fun outcome(exit: Outcome.Exit) = outcome(Outcome.ofExit(exit))

        /**
         * Alias for calling [outcome] with the following:
         * ```java
         * Outcome.Exit.builder()
         *     .exitCode(exitCode)
         *     .build()
         * ```
         */
        fun exitOutcome(exitCode: Long) = outcome(Outcome.Exit.builder().exitCode(exitCode).build())

        /** Captured stderr output for this chunk of the shell call. */
        fun stderr(stderr: String) = stderr(JsonField.of(stderr))

        /**
         * Sets [Builder.stderr] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stderr] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stderr(stderr: JsonField<String>) = apply { this.stderr = stderr }

        /** Captured stdout output for this chunk of the shell call. */
        fun stdout(stdout: String) = stdout(JsonField.of(stdout))

        /**
         * Sets [Builder.stdout] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stdout] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stdout(stdout: JsonField<String>) = apply { this.stdout = stdout }

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
         * Returns an immutable instance of [ResponseFunctionShellCallOutputContent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .outcome()
         * .stderr()
         * .stdout()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseFunctionShellCallOutputContent =
            ResponseFunctionShellCallOutputContent(
                checkRequired("outcome", outcome),
                checkRequired("stderr", stderr),
                checkRequired("stdout", stdout),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseFunctionShellCallOutputContent = apply {
        if (validated) {
            return@apply
        }

        outcome().validate()
        stderr()
        stdout()
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
        (outcome.asKnown().getOrNull()?.validity() ?: 0) +
            (if (stderr.asKnown().isPresent) 1 else 0) +
            (if (stdout.asKnown().isPresent) 1 else 0)

    /** The exit or timeout outcome associated with this chunk. */
    @JsonDeserialize(using = Outcome.Deserializer::class)
    @JsonSerialize(using = Outcome.Serializer::class)
    class Outcome
    private constructor(
        private val timeout: JsonValue? = null,
        private val exit: Exit? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Indicates that the function shell call exceeded its configured time limit. */
        fun timeout(): Optional<JsonValue> = Optional.ofNullable(timeout)

        /** Indicates that the shell commands finished and returned an exit code. */
        fun exit(): Optional<Exit> = Optional.ofNullable(exit)

        fun isTimeout(): Boolean = timeout != null

        fun isExit(): Boolean = exit != null

        /** Indicates that the function shell call exceeded its configured time limit. */
        fun asTimeout(): JsonValue = timeout.getOrThrow("timeout")

        /** Indicates that the shell commands finished and returned an exit code. */
        fun asExit(): Exit = exit.getOrThrow("exit")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                timeout != null -> visitor.visitTimeout(timeout)
                exit != null -> visitor.visitExit(exit)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Outcome = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTimeout(timeout: JsonValue) {
                        timeout.let {
                            if (it != JsonValue.from(mapOf("type" to "timeout"))) {
                                throw OpenAIInvalidDataException(
                                    "'timeout' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitExit(exit: Exit) {
                        exit.validate()
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
                    override fun visitTimeout(timeout: JsonValue) =
                        timeout.let {
                            if (it == JsonValue.from(mapOf("type" to "timeout"))) 1 else 0
                        }

                    override fun visitExit(exit: Exit) = exit.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Outcome && timeout == other.timeout && exit == other.exit
        }

        override fun hashCode(): Int = Objects.hash(timeout, exit)

        override fun toString(): String =
            when {
                timeout != null -> "Outcome{timeout=$timeout}"
                exit != null -> "Outcome{exit=$exit}"
                _json != null -> "Outcome{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Outcome")
            }

        companion object {

            /** Indicates that the function shell call exceeded its configured time limit. */
            @JvmStatic
            fun ofTimeout() = Outcome(timeout = JsonValue.from(mapOf("type" to "timeout")))

            /** Indicates that the shell commands finished and returned an exit code. */
            @JvmStatic fun ofExit(exit: Exit) = Outcome(exit = exit)
        }

        /**
         * An interface that defines how to map each variant of [Outcome] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Indicates that the function shell call exceeded its configured time limit. */
            fun visitTimeout(timeout: JsonValue): T

            /** Indicates that the shell commands finished and returned an exit code. */
            fun visitExit(exit: Exit): T

            /**
             * Maps an unknown variant of [Outcome] to a value of type [T].
             *
             * An instance of [Outcome] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Outcome: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Outcome>(Outcome::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Outcome {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "timeout" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Outcome(timeout = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Outcome(_json = json)
                    }
                    "exit" -> {
                        return tryDeserialize(node, jacksonTypeRef<Exit>())?.let {
                            Outcome(exit = it, _json = json)
                        } ?: Outcome(_json = json)
                    }
                }

                return Outcome(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Outcome>(Outcome::class) {

            override fun serialize(
                value: Outcome,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.timeout != null -> generator.writeObject(value.timeout)
                    value.exit != null -> generator.writeObject(value.exit)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Outcome")
                }
            }
        }

        /** Indicates that the shell commands finished and returned an exit code. */
        class Exit
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val exitCode: JsonField<Long>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("exit_code")
                @ExcludeMissing
                exitCode: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(exitCode, type, mutableMapOf())

            /**
             * The exit code returned by the shell process.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun exitCode(): Long = exitCode.getRequired("exit_code")

            /**
             * The outcome type. Always `exit`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("exit")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [exitCode].
             *
             * Unlike [exitCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("exit_code") @ExcludeMissing fun _exitCode(): JsonField<Long> = exitCode

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
                 * Returns a mutable builder for constructing an instance of [Exit].
                 *
                 * The following fields are required:
                 * ```java
                 * .exitCode()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Exit]. */
            class Builder internal constructor() {

                private var exitCode: JsonField<Long>? = null
                private var type: JsonValue = JsonValue.from("exit")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(exit: Exit) = apply {
                    exitCode = exit.exitCode
                    type = exit.type
                    additionalProperties = exit.additionalProperties.toMutableMap()
                }

                /** The exit code returned by the shell process. */
                fun exitCode(exitCode: Long) = exitCode(JsonField.of(exitCode))

                /**
                 * Sets [Builder.exitCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.exitCode] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun exitCode(exitCode: JsonField<Long>) = apply { this.exitCode = exitCode }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("exit")
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
                 * Returns an immutable instance of [Exit].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .exitCode()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Exit =
                    Exit(
                        checkRequired("exitCode", exitCode),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Exit = apply {
                if (validated) {
                    return@apply
                }

                exitCode()
                _type().let {
                    if (it != JsonValue.from("exit")) {
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
                (if (exitCode.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("exit")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Exit &&
                    exitCode == other.exitCode &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(exitCode, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Exit{exitCode=$exitCode, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseFunctionShellCallOutputContent &&
            outcome == other.outcome &&
            stderr == other.stderr &&
            stdout == other.stdout &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(outcome, stderr, stdout, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFunctionShellCallOutputContent{outcome=$outcome, stderr=$stderr, stdout=$stdout, additionalProperties=$additionalProperties}"
}
