// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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

/** A Realtime item responding to an MCP approval request. */
class RealtimeMcpApprovalResponse
private constructor(
    private val id: JsonField<String>,
    private val approvalRequestId: JsonField<String>,
    private val approve: JsonField<Boolean>,
    private val type: JsonValue,
    private val reason: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("approval_request_id")
        @ExcludeMissing
        approvalRequestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("approve") @ExcludeMissing approve: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
    ) : this(id, approvalRequestId, approve, type, reason, mutableMapOf())

    /**
     * The unique ID of the approval response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The ID of the approval request being answered.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun approvalRequestId(): String = approvalRequestId.getRequired("approval_request_id")

    /**
     * Whether the request was approved.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun approve(): Boolean = approve.getRequired("approve")

    /**
     * The type of the item. Always `mcp_approval_response`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("mcp_approval_response")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional reason for the decision.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [approvalRequestId].
     *
     * Unlike [approvalRequestId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("approval_request_id")
    @ExcludeMissing
    fun _approvalRequestId(): JsonField<String> = approvalRequestId

    /**
     * Returns the raw JSON value of [approve].
     *
     * Unlike [approve], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("approve") @ExcludeMissing fun _approve(): JsonField<Boolean> = approve

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
         * Returns a mutable builder for constructing an instance of [RealtimeMcpApprovalResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .approvalRequestId()
         * .approve()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeMcpApprovalResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var approvalRequestId: JsonField<String>? = null
        private var approve: JsonField<Boolean>? = null
        private var type: JsonValue = JsonValue.from("mcp_approval_response")
        private var reason: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeMcpApprovalResponse: RealtimeMcpApprovalResponse) = apply {
            id = realtimeMcpApprovalResponse.id
            approvalRequestId = realtimeMcpApprovalResponse.approvalRequestId
            approve = realtimeMcpApprovalResponse.approve
            type = realtimeMcpApprovalResponse.type
            reason = realtimeMcpApprovalResponse.reason
            additionalProperties = realtimeMcpApprovalResponse.additionalProperties.toMutableMap()
        }

        /** The unique ID of the approval response. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The ID of the approval request being answered. */
        fun approvalRequestId(approvalRequestId: String) =
            approvalRequestId(JsonField.of(approvalRequestId))

        /**
         * Sets [Builder.approvalRequestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.approvalRequestId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun approvalRequestId(approvalRequestId: JsonField<String>) = apply {
            this.approvalRequestId = approvalRequestId
        }

        /** Whether the request was approved. */
        fun approve(approve: Boolean) = approve(JsonField.of(approve))

        /**
         * Sets [Builder.approve] to an arbitrary JSON value.
         *
         * You should usually call [Builder.approve] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun approve(approve: JsonField<Boolean>) = apply { this.approve = approve }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("mcp_approval_response")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional reason for the decision. */
        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

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
         * Returns an immutable instance of [RealtimeMcpApprovalResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .approvalRequestId()
         * .approve()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeMcpApprovalResponse =
            RealtimeMcpApprovalResponse(
                checkRequired("id", id),
                checkRequired("approvalRequestId", approvalRequestId),
                checkRequired("approve", approve),
                type,
                reason,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeMcpApprovalResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        approvalRequestId()
        approve()
        _type().let {
            if (it != JsonValue.from("mcp_approval_response")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        reason()
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
            (if (approvalRequestId.asKnown().isPresent) 1 else 0) +
            (if (approve.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("mcp_approval_response")) 1 else 0 } +
            (if (reason.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeMcpApprovalResponse &&
            id == other.id &&
            approvalRequestId == other.approvalRequestId &&
            approve == other.approve &&
            type == other.type &&
            reason == other.reason &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, approvalRequestId, approve, type, reason, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeMcpApprovalResponse{id=$id, approvalRequestId=$approvalRequestId, approve=$approve, type=$type, reason=$reason, additionalProperties=$additionalProperties}"
}
