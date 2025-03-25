// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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

class ResponseComputerToolCallOutputItem
private constructor(
    private val id: JsonField<String>,
    private val callId: JsonField<String>,
    private val output: JsonField<ResponseComputerToolCallOutputScreenshot>,
    private val type: JsonValue,
    private val acknowledgedSafetyChecks: JsonField<List<AcknowledgedSafetyCheck>>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        output: JsonField<ResponseComputerToolCallOutputScreenshot> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("acknowledged_safety_checks")
        @ExcludeMissing
        acknowledgedSafetyChecks: JsonField<List<AcknowledgedSafetyCheck>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(id, callId, output, type, acknowledgedSafetyChecks, status, mutableMapOf())

    /**
     * The unique ID of the computer call tool output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The ID of the computer tool call that produced the output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun callId(): String = callId.getRequired("call_id")

    /**
     * A computer screenshot image used with the computer use tool.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun output(): ResponseComputerToolCallOutputScreenshot = output.getRequired("output")

    /**
     * The type of the computer tool call output. Always `computer_call_output`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("computer_call_output")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The safety checks reported by the API that have been acknowledged by the developer.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun acknowledgedSafetyChecks(): Optional<List<AcknowledgedSafetyCheck>> =
        Optional.ofNullable(acknowledgedSafetyChecks.getNullable("acknowledged_safety_checks"))

    /**
     * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
     * Populated when input items are returned via API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<Status> = Optional.ofNullable(status.getNullable("status"))

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
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<ResponseComputerToolCallOutputScreenshot> = output

    /**
     * Returns the raw JSON value of [acknowledgedSafetyChecks].
     *
     * Unlike [acknowledgedSafetyChecks], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("acknowledged_safety_checks")
    @ExcludeMissing
    fun _acknowledgedSafetyChecks(): JsonField<List<AcknowledgedSafetyCheck>> =
        acknowledgedSafetyChecks

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * [ResponseComputerToolCallOutputItem].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .callId()
         * .output()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseComputerToolCallOutputItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var callId: JsonField<String>? = null
        private var output: JsonField<ResponseComputerToolCallOutputScreenshot>? = null
        private var type: JsonValue = JsonValue.from("computer_call_output")
        private var acknowledgedSafetyChecks: JsonField<MutableList<AcknowledgedSafetyCheck>>? =
            null
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseComputerToolCallOutputItem: ResponseComputerToolCallOutputItem) =
            apply {
                id = responseComputerToolCallOutputItem.id
                callId = responseComputerToolCallOutputItem.callId
                output = responseComputerToolCallOutputItem.output
                type = responseComputerToolCallOutputItem.type
                acknowledgedSafetyChecks =
                    responseComputerToolCallOutputItem.acknowledgedSafetyChecks.map {
                        it.toMutableList()
                    }
                status = responseComputerToolCallOutputItem.status
                additionalProperties =
                    responseComputerToolCallOutputItem.additionalProperties.toMutableMap()
            }

        /** The unique ID of the computer call tool output. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The ID of the computer tool call that produced the output. */
        fun callId(callId: String) = callId(JsonField.of(callId))

        /**
         * Sets [Builder.callId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun callId(callId: JsonField<String>) = apply { this.callId = callId }

        /** A computer screenshot image used with the computer use tool. */
        fun output(output: ResponseComputerToolCallOutputScreenshot) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed
         * [ResponseComputerToolCallOutputScreenshot] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun output(output: JsonField<ResponseComputerToolCallOutputScreenshot>) = apply {
            this.output = output
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("computer_call_output")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The safety checks reported by the API that have been acknowledged by the developer. */
        fun acknowledgedSafetyChecks(acknowledgedSafetyChecks: List<AcknowledgedSafetyCheck>) =
            acknowledgedSafetyChecks(JsonField.of(acknowledgedSafetyChecks))

        /**
         * Sets [Builder.acknowledgedSafetyChecks] to an arbitrary JSON value.
         *
         * You should usually call [Builder.acknowledgedSafetyChecks] with a well-typed
         * `List<AcknowledgedSafetyCheck>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun acknowledgedSafetyChecks(
            acknowledgedSafetyChecks: JsonField<List<AcknowledgedSafetyCheck>>
        ) = apply {
            this.acknowledgedSafetyChecks = acknowledgedSafetyChecks.map { it.toMutableList() }
        }

        /**
         * Adds a single [AcknowledgedSafetyCheck] to [acknowledgedSafetyChecks].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAcknowledgedSafetyCheck(acknowledgedSafetyCheck: AcknowledgedSafetyCheck) = apply {
            acknowledgedSafetyChecks =
                (acknowledgedSafetyChecks ?: JsonField.of(mutableListOf())).also {
                    checkKnown("acknowledgedSafetyChecks", it).add(acknowledgedSafetyCheck)
                }
        }

        /**
         * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
         * Populated when input items are returned via API.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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
         * Returns an immutable instance of [ResponseComputerToolCallOutputItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .callId()
         * .output()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseComputerToolCallOutputItem =
            ResponseComputerToolCallOutputItem(
                checkRequired("id", id),
                checkRequired("callId", callId),
                checkRequired("output", output),
                type,
                (acknowledgedSafetyChecks ?: JsonMissing.of()).map { it.toImmutable() },
                status,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseComputerToolCallOutputItem = apply {
        if (validated) {
            return@apply
        }

        id()
        callId()
        output().validate()
        _type().let {
            if (it != JsonValue.from("computer_call_output")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        acknowledgedSafetyChecks().ifPresent { it.forEach { it.validate() } }
        status()
        validated = true
    }

    /** A pending safety check for the computer call. */
    class AcknowledgedSafetyCheck
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
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): String = code.getRequired("code")

        /**
         * Details about the pending safety check.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

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
             * Returns a mutable builder for constructing an instance of [AcknowledgedSafetyCheck].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AcknowledgedSafetyCheck]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var code: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(acknowledgedSafetyCheck: AcknowledgedSafetyCheck) = apply {
                id = acknowledgedSafetyCheck.id
                code = acknowledgedSafetyCheck.code
                message = acknowledgedSafetyCheck.message
                additionalProperties = acknowledgedSafetyCheck.additionalProperties.toMutableMap()
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
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Details about the pending safety check. */
            fun message(message: String) = message(JsonField.of(message))

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
             * Returns an immutable instance of [AcknowledgedSafetyCheck].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AcknowledgedSafetyCheck =
                AcknowledgedSafetyCheck(
                    checkRequired("id", id),
                    checkRequired("code", code),
                    checkRequired("message", message),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AcknowledgedSafetyCheck = apply {
            if (validated) {
                return@apply
            }

            id()
            code()
            message()
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is AcknowledgedSafetyCheck && id == other.id && code == other.code && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, code, message, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AcknowledgedSafetyCheck{id=$id, code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
     * Populated when input items are returned via API.
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseComputerToolCallOutputItem && id == other.id && callId == other.callId && output == other.output && type == other.type && acknowledgedSafetyChecks == other.acknowledgedSafetyChecks && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, callId, output, type, acknowledgedSafetyChecks, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseComputerToolCallOutputItem{id=$id, callId=$callId, output=$output, type=$type, acknowledgedSafetyChecks=$acknowledgedSafetyChecks, status=$status, additionalProperties=$additionalProperties}"
}
