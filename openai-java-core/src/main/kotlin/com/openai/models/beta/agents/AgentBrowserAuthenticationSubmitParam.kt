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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class AgentBrowserAuthenticationSubmitParam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val action: JsonValue,
    private val fields: JsonField<List<Field>>,
    private val type: JsonValue,
    private val selectedOption: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("action") @ExcludeMissing action: JsonValue = JsonMissing.of(),
        @JsonProperty("fields") @ExcludeMissing fields: JsonField<List<Field>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("selected_option")
        @ExcludeMissing
        selectedOption: JsonField<String> = JsonMissing.of(),
    ) : this(action, fields, type, selectedOption, mutableMapOf())

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("submit")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonValue = action

    /**
     * Values for up to six active fields in the required action. The submitted field-value mapping
     * and selected option must fit within 120 KiB of JSON.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fields(): List<Field> = fields.getRequired("fields")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("browser_authentication")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The chosen method. Required when the required action contains options.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun selectedOption(): Optional<String> = selectedOption.getOptional("selected_option")

    /**
     * Returns the raw JSON value of [fields].
     *
     * Unlike [fields], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fields") @ExcludeMissing fun _fields(): JsonField<List<Field>> = fields

    /**
     * Returns the raw JSON value of [selectedOption].
     *
     * Unlike [selectedOption], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("selected_option")
    @ExcludeMissing
    fun _selectedOption(): JsonField<String> = selectedOption

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
         * [AgentBrowserAuthenticationSubmitParam].
         *
         * The following fields are required:
         * ```java
         * .fields()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentBrowserAuthenticationSubmitParam]. */
    class Builder internal constructor() {

        private var action: JsonValue = JsonValue.from("submit")
        private var fields: JsonField<MutableList<Field>>? = null
        private var type: JsonValue = JsonValue.from("browser_authentication")
        private var selectedOption: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            agentBrowserAuthenticationSubmitParam: AgentBrowserAuthenticationSubmitParam
        ) = apply {
            action = agentBrowserAuthenticationSubmitParam.action
            fields = agentBrowserAuthenticationSubmitParam.fields.map { it.toMutableList() }
            type = agentBrowserAuthenticationSubmitParam.type
            selectedOption = agentBrowserAuthenticationSubmitParam.selectedOption
            additionalProperties =
                agentBrowserAuthenticationSubmitParam.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("submit")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun action(action: JsonValue) = apply { this.action = action }

        /**
         * Values for up to six active fields in the required action. The submitted field-value
         * mapping and selected option must fit within 120 KiB of JSON.
         */
        fun fields(fields: List<Field>) = fields(JsonField.of(fields))

        /**
         * Sets [Builder.fields] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fields] with a well-typed `List<Field>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fields(fields: JsonField<List<Field>>) = apply {
            this.fields = fields.map { it.toMutableList() }
        }

        /**
         * Adds a single [Field] to [fields].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addField(field: Field) = apply {
            fields =
                (fields ?: JsonField.of(mutableListOf())).also {
                    checkKnown("fields", it).add(field)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("browser_authentication")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** The chosen method. Required when the required action contains options. */
        fun selectedOption(selectedOption: String?) =
            selectedOption(JsonField.ofNullable(selectedOption))

        /** Alias for calling [Builder.selectedOption] with `selectedOption.orElse(null)`. */
        fun selectedOption(selectedOption: Optional<String>) =
            selectedOption(selectedOption.getOrNull())

        /**
         * Sets [Builder.selectedOption] to an arbitrary JSON value.
         *
         * You should usually call [Builder.selectedOption] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun selectedOption(selectedOption: JsonField<String>) = apply {
            this.selectedOption = selectedOption
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
         * Returns an immutable instance of [AgentBrowserAuthenticationSubmitParam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .fields()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentBrowserAuthenticationSubmitParam =
            AgentBrowserAuthenticationSubmitParam(
                action,
                checkRequired("fields", fields).map { it.toImmutable() },
                type,
                selectedOption,
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
    fun validate(): AgentBrowserAuthenticationSubmitParam = apply {
        if (validated) {
            return@apply
        }

        _action().let {
            if (it != JsonValue.from("submit")) {
                throw OpenAIInvalidDataException("'action' is invalid, received $it")
            }
        }
        fields().forEach { it.validate() }
        _type().let {
            if (it != JsonValue.from("browser_authentication")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        selectedOption()
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
        action.let { if (it == JsonValue.from("submit")) 1 else 0 } +
            (fields.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            type.let { if (it == JsonValue.from("browser_authentication")) 1 else 0 } +
            (if (selectedOption.asKnown().isPresent) 1 else 0)

    /** One user-entered value, including non-password fields such as an email address. */
    class Field
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val fieldId: JsonField<String>,
        private val value: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("field_id") @ExcludeMissing fieldId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
        ) : this(fieldId, value, mutableMapOf())

        /**
         * The field ID from the required action.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fieldId(): String = fieldId.getRequired("field_id")

        /**
         * The value to enter into the registered control.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun value(): String = value.getRequired("value")

        /**
         * Returns the raw JSON value of [fieldId].
         *
         * Unlike [fieldId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("field_id") @ExcludeMissing fun _fieldId(): JsonField<String> = fieldId

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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
             * .fieldId()
             * .value()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Field]. */
        class Builder internal constructor() {

            private var fieldId: JsonField<String>? = null
            private var value: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(field: Field) = apply {
                fieldId = field.fieldId
                value = field.value
                additionalProperties = field.additionalProperties.toMutableMap()
            }

            /** The field ID from the required action. */
            fun fieldId(fieldId: String) = fieldId(JsonField.of(fieldId))

            /**
             * Sets [Builder.fieldId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fieldId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fieldId(fieldId: JsonField<String>) = apply { this.fieldId = fieldId }

            /** The value to enter into the registered control. */
            fun value(value: String) = value(JsonField.of(value))

            /**
             * Sets [Builder.value] to an arbitrary JSON value.
             *
             * You should usually call [Builder.value] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun value(value: JsonField<String>) = apply { this.value = value }

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
             * Returns an immutable instance of [Field].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .fieldId()
             * .value()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Field =
                Field(
                    checkRequired("fieldId", fieldId),
                    checkRequired("value", value),
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
        fun validate(): Field = apply {
            if (validated) {
                return@apply
            }

            fieldId()
            value()
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
            (if (fieldId.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Field &&
                fieldId == other.fieldId &&
                value == other.value &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(fieldId, value, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Field{fieldId=$fieldId, value=$value, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentBrowserAuthenticationSubmitParam &&
            action == other.action &&
            fields == other.fields &&
            type == other.type &&
            selectedOption == other.selectedOption &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(action, fields, type, selectedOption, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentBrowserAuthenticationSubmitParam{action=$action, fields=$fields, type=$type, selectedOption=$selectedOption, additionalProperties=$additionalProperties}"
}
