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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Input submitted to an existing session. */
@JsonDeserialize(using = AgentSessionInputParam.Deserializer::class)
@JsonSerialize(using = AgentSessionInputParam.Serializer::class)
class AgentSessionInputParam
private constructor(
    private val agentSessionInputComputerUseApprovalRequestResult:
        AgentSessionInputComputerUseApprovalRequestResult? =
        null,
    private val agentSessionInputMessage: AgentSessionInputMessage? = null,
    private val agentSessionInputCancel: JsonValue? = null,
    private val agentSessionInputToolResult: AgentSessionInputToolResult? = null,
    private val _json: JsonValue? = null,
) {

    /** Responds to a pending Computer Use approval request. */
    fun agentSessionInputComputerUseApprovalRequestResult():
        Optional<AgentSessionInputComputerUseApprovalRequestResult> =
        Optional.ofNullable(agentSessionInputComputerUseApprovalRequestResult)

    /** Adds one or more user messages and starts a turn. */
    fun agentSessionInputMessage(): Optional<AgentSessionInputMessage> =
        Optional.ofNullable(agentSessionInputMessage)

    /** Cancels the session's active turn. */
    fun agentSessionInputCancel(): Optional<JsonValue> =
        Optional.ofNullable(agentSessionInputCancel)

    /** Submits the result of a function call. */
    fun agentSessionInputToolResult(): Optional<AgentSessionInputToolResult> =
        Optional.ofNullable(agentSessionInputToolResult)

    fun isAgentSessionInputComputerUseApprovalRequestResult(): Boolean =
        agentSessionInputComputerUseApprovalRequestResult != null

    fun isAgentSessionInputMessage(): Boolean = agentSessionInputMessage != null

    fun isAgentSessionInputCancel(): Boolean = agentSessionInputCancel != null

    fun isAgentSessionInputToolResult(): Boolean = agentSessionInputToolResult != null

    /** Responds to a pending Computer Use approval request. */
    fun asAgentSessionInputComputerUseApprovalRequestResult():
        AgentSessionInputComputerUseApprovalRequestResult =
        agentSessionInputComputerUseApprovalRequestResult.getOrThrow(
            "agentSessionInputComputerUseApprovalRequestResult"
        )

    /** Adds one or more user messages and starts a turn. */
    fun asAgentSessionInputMessage(): AgentSessionInputMessage =
        agentSessionInputMessage.getOrThrow("agentSessionInputMessage")

    /** Cancels the session's active turn. */
    fun asAgentSessionInputCancel(): JsonValue =
        agentSessionInputCancel.getOrThrow("agentSessionInputCancel")

    /** Submits the result of a function call. */
    fun asAgentSessionInputToolResult(): AgentSessionInputToolResult =
        agentSessionInputToolResult.getOrThrow("agentSessionInputToolResult")

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
     * Optional<String> result = agentSessionInputParam.accept(new AgentSessionInputParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitAgentSessionInputComputerUseApprovalRequestResult(AgentSessionInputComputerUseApprovalRequestResult agentSessionInputComputerUseApprovalRequestResult) {
     *         return Optional.of(agentSessionInputComputerUseApprovalRequestResult.toString());
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
            agentSessionInputComputerUseApprovalRequestResult != null ->
                visitor.visitAgentSessionInputComputerUseApprovalRequestResult(
                    agentSessionInputComputerUseApprovalRequestResult
                )
            agentSessionInputMessage != null ->
                visitor.visitAgentSessionInputMessage(agentSessionInputMessage)
            agentSessionInputCancel != null ->
                visitor.visitAgentSessionInputCancel(agentSessionInputCancel)
            agentSessionInputToolResult != null ->
                visitor.visitAgentSessionInputToolResult(agentSessionInputToolResult)
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
    fun validate(): AgentSessionInputParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAgentSessionInputComputerUseApprovalRequestResult(
                    agentSessionInputComputerUseApprovalRequestResult:
                        AgentSessionInputComputerUseApprovalRequestResult
                ) {
                    agentSessionInputComputerUseApprovalRequestResult.validate()
                }

                override fun visitAgentSessionInputMessage(
                    agentSessionInputMessage: AgentSessionInputMessage
                ) {
                    agentSessionInputMessage.validate()
                }

                override fun visitAgentSessionInputCancel(agentSessionInputCancel: JsonValue) {
                    agentSessionInputCancel.let {
                        if (it != JsonValue.from(mapOf("type" to "agent.session.input.cancel"))) {
                            throw OpenAIInvalidDataException(
                                "'agentSessionInputCancel' is invalid, received $it"
                            )
                        }
                    }
                }

                override fun visitAgentSessionInputToolResult(
                    agentSessionInputToolResult: AgentSessionInputToolResult
                ) {
                    agentSessionInputToolResult.validate()
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
                override fun visitAgentSessionInputComputerUseApprovalRequestResult(
                    agentSessionInputComputerUseApprovalRequestResult:
                        AgentSessionInputComputerUseApprovalRequestResult
                ) = agentSessionInputComputerUseApprovalRequestResult.validity()

                override fun visitAgentSessionInputMessage(
                    agentSessionInputMessage: AgentSessionInputMessage
                ) = agentSessionInputMessage.validity()

                override fun visitAgentSessionInputCancel(agentSessionInputCancel: JsonValue) =
                    agentSessionInputCancel.let {
                        if (it == JsonValue.from(mapOf("type" to "agent.session.input.cancel"))) 1
                        else 0
                    }

                override fun visitAgentSessionInputToolResult(
                    agentSessionInputToolResult: AgentSessionInputToolResult
                ) = agentSessionInputToolResult.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSessionInputParam &&
            agentSessionInputComputerUseApprovalRequestResult ==
                other.agentSessionInputComputerUseApprovalRequestResult &&
            agentSessionInputMessage == other.agentSessionInputMessage &&
            agentSessionInputCancel == other.agentSessionInputCancel &&
            agentSessionInputToolResult == other.agentSessionInputToolResult
    }

    override fun hashCode(): Int =
        Objects.hash(
            agentSessionInputComputerUseApprovalRequestResult,
            agentSessionInputMessage,
            agentSessionInputCancel,
            agentSessionInputToolResult,
        )

    override fun toString(): String =
        when {
            agentSessionInputComputerUseApprovalRequestResult != null ->
                "AgentSessionInputParam{agentSessionInputComputerUseApprovalRequestResult=$agentSessionInputComputerUseApprovalRequestResult}"
            agentSessionInputMessage != null ->
                "AgentSessionInputParam{agentSessionInputMessage=$agentSessionInputMessage}"
            agentSessionInputCancel != null ->
                "AgentSessionInputParam{agentSessionInputCancel=$agentSessionInputCancel}"
            agentSessionInputToolResult != null ->
                "AgentSessionInputParam{agentSessionInputToolResult=$agentSessionInputToolResult}"
            _json != null -> "AgentSessionInputParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AgentSessionInputParam")
        }

    companion object {

        /** Responds to a pending Computer Use approval request. */
        @JvmStatic
        fun ofAgentSessionInputComputerUseApprovalRequestResult(
            agentSessionInputComputerUseApprovalRequestResult:
                AgentSessionInputComputerUseApprovalRequestResult
        ) =
            AgentSessionInputParam(
                agentSessionInputComputerUseApprovalRequestResult =
                    agentSessionInputComputerUseApprovalRequestResult
            )

        /** Adds one or more user messages and starts a turn. */
        @JvmStatic
        fun ofAgentSessionInputMessage(agentSessionInputMessage: AgentSessionInputMessage) =
            AgentSessionInputParam(agentSessionInputMessage = agentSessionInputMessage)

        /** Cancels the session's active turn. */
        @JvmStatic
        fun ofAgentSessionInputCancel() =
            AgentSessionInputParam(
                agentSessionInputCancel =
                    JsonValue.from(mapOf("type" to "agent.session.input.cancel"))
            )

        /** Submits the result of a function call. */
        @JvmStatic
        fun ofAgentSessionInputToolResult(
            agentSessionInputToolResult: AgentSessionInputToolResult
        ) = AgentSessionInputParam(agentSessionInputToolResult = agentSessionInputToolResult)
    }

    /**
     * An interface that defines how to map each variant of [AgentSessionInputParam] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Responds to a pending Computer Use approval request. */
        fun visitAgentSessionInputComputerUseApprovalRequestResult(
            agentSessionInputComputerUseApprovalRequestResult:
                AgentSessionInputComputerUseApprovalRequestResult
        ): T

        /** Adds one or more user messages and starts a turn. */
        fun visitAgentSessionInputMessage(agentSessionInputMessage: AgentSessionInputMessage): T

        /** Cancels the session's active turn. */
        fun visitAgentSessionInputCancel(agentSessionInputCancel: JsonValue): T

        /** Submits the result of a function call. */
        fun visitAgentSessionInputToolResult(
            agentSessionInputToolResult: AgentSessionInputToolResult
        ): T

        /**
         * Maps an unknown variant of [AgentSessionInputParam] to a value of type [T].
         *
         * An instance of [AgentSessionInputParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AgentSessionInputParam")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AgentSessionInputParam>(AgentSessionInputParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AgentSessionInputParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "agent.session.input.computer_use_approval_request_result" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionInputComputerUseApprovalRequestResult>(),
                        )
                        ?.let {
                            AgentSessionInputParam(
                                agentSessionInputComputerUseApprovalRequestResult = it,
                                _json = json,
                            )
                        } ?: AgentSessionInputParam(_json = json)
                }
                "agent.session.input.message" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionInputMessage>())?.let {
                        AgentSessionInputParam(agentSessionInputMessage = it, _json = json)
                    } ?: AgentSessionInputParam(_json = json)
                }
                "agent.session.input.cancel" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { AgentSessionInputParam(agentSessionInputCancel = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: AgentSessionInputParam(_json = json)
                }
                "agent.session.input.tool_result" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionInputToolResult>())
                        ?.let {
                            AgentSessionInputParam(agentSessionInputToolResult = it, _json = json)
                        } ?: AgentSessionInputParam(_json = json)
                }
            }

            return AgentSessionInputParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AgentSessionInputParam>(AgentSessionInputParam::class) {

        override fun serialize(
            value: AgentSessionInputParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.agentSessionInputComputerUseApprovalRequestResult != null ->
                    generator.writeObject(value.agentSessionInputComputerUseApprovalRequestResult)
                value.agentSessionInputMessage != null ->
                    generator.writeObject(value.agentSessionInputMessage)
                value.agentSessionInputCancel != null ->
                    generator.writeObject(value.agentSessionInputCancel)
                value.agentSessionInputToolResult != null ->
                    generator.writeObject(value.agentSessionInputToolResult)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AgentSessionInputParam")
            }
        }
    }

    /** Responds to a pending Computer Use approval request. */
    class AgentSessionInputComputerUseApprovalRequestResult
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val requestId: JsonField<String>,
        private val response: JsonField<Response>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("response")
            @ExcludeMissing
            response: JsonField<Response> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(requestId, response, type, mutableMapOf())

        /**
         * The registered request ID from the required action.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestId(): String = requestId.getRequired("request_id")

        /**
         * The response for this request type.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun response(): Response = response.getRequired("response")

        /**
         * The type of the object. Always
         * `agent.session.input.computer_use_approval_request_result`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("agent.session.input.computer_use_approval_request_result")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [response].
         *
         * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

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
             * [AgentSessionInputComputerUseApprovalRequestResult].
             *
             * The following fields are required:
             * ```java
             * .requestId()
             * .response()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AgentSessionInputComputerUseApprovalRequestResult]. */
        class Builder internal constructor() {

            private var requestId: JsonField<String>? = null
            private var response: JsonField<Response>? = null
            private var type: JsonValue =
                JsonValue.from("agent.session.input.computer_use_approval_request_result")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                agentSessionInputComputerUseApprovalRequestResult:
                    AgentSessionInputComputerUseApprovalRequestResult
            ) = apply {
                requestId = agentSessionInputComputerUseApprovalRequestResult.requestId
                response = agentSessionInputComputerUseApprovalRequestResult.response
                type = agentSessionInputComputerUseApprovalRequestResult.type
                additionalProperties =
                    agentSessionInputComputerUseApprovalRequestResult.additionalProperties
                        .toMutableMap()
            }

            /** The registered request ID from the required action. */
            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            /** The response for this request type. */
            fun response(response: Response) = response(JsonField.of(response))

            /**
             * Sets [Builder.response] to an arbitrary JSON value.
             *
             * You should usually call [Builder.response] with a well-typed [Response] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun response(response: JsonField<Response>) = apply { this.response = response }

            /**
             * Alias for calling [response] with
             * `Response.ofAgentBrowserAuthenticationSubmitParam(agentBrowserAuthenticationSubmitParam)`.
             */
            fun response(
                agentBrowserAuthenticationSubmitParam: AgentBrowserAuthenticationSubmitParam
            ) =
                response(
                    Response.ofAgentBrowserAuthenticationSubmitParam(
                        agentBrowserAuthenticationSubmitParam
                    )
                )

            /**
             * Alias for calling [response] with the following:
             * ```java
             * AgentBrowserAuthenticationSubmitParam.builder()
             *     .fields(fields)
             *     .build()
             * ```
             */
            fun agentBrowserAuthenticationSubmitParamResponse(
                fields: List<AgentBrowserAuthenticationSubmitParam.Field>
            ) = response(AgentBrowserAuthenticationSubmitParam.builder().fields(fields).build())

            /**
             * Alias for calling [response] with
             * `Response.ofAgentBrowserAuthenticationCancelParam(agentBrowserAuthenticationCancelParam)`.
             */
            fun response(
                agentBrowserAuthenticationCancelParam: AgentBrowserAuthenticationCancelParam
            ) =
                response(
                    Response.ofAgentBrowserAuthenticationCancelParam(
                        agentBrowserAuthenticationCancelParam
                    )
                )

            /**
             * Alias for calling [response] with
             * `Response.ofBrowserOriginAccess(browserOriginAccess)`.
             */
            fun response(browserOriginAccess: AgentBrowserOriginAccessParam) =
                response(Response.ofBrowserOriginAccess(browserOriginAccess))

            /**
             * Alias for calling [response] with the following:
             * ```java
             * AgentBrowserOriginAccessParam.builder()
             *     .decision(decision)
             *     .build()
             * ```
             */
            fun browserOriginAccessResponse(decision: AgentBrowserOriginAccessParam.Decision) =
                response(AgentBrowserOriginAccessParam.builder().decision(decision).build())

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("agent.session.input.computer_use_approval_request_result")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [AgentSessionInputComputerUseApprovalRequestResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .requestId()
             * .response()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AgentSessionInputComputerUseApprovalRequestResult =
                AgentSessionInputComputerUseApprovalRequestResult(
                    checkRequired("requestId", requestId),
                    checkRequired("response", response),
                    type,
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
        fun validate(): AgentSessionInputComputerUseApprovalRequestResult = apply {
            if (validated) {
                return@apply
            }

            requestId()
            response().validate()
            _type().let {
                if (
                    it != JsonValue.from("agent.session.input.computer_use_approval_request_result")
                ) {
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
            (if (requestId.asKnown().isPresent) 1 else 0) +
                (response.asKnown().getOrNull()?.validity() ?: 0) +
                type.let {
                    if (
                        it ==
                            JsonValue.from(
                                "agent.session.input.computer_use_approval_request_result"
                            )
                    )
                        1
                    else 0
                }

        /** The response for this request type. */
        @JsonDeserialize(using = Response.Deserializer::class)
        @JsonSerialize(using = Response.Serializer::class)
        class Response
        private constructor(
            private val agentBrowserAuthenticationSubmitParam:
                AgentBrowserAuthenticationSubmitParam? =
                null,
            private val agentBrowserAuthenticationCancelParam:
                AgentBrowserAuthenticationCancelParam? =
                null,
            private val browserOriginAccess: AgentBrowserOriginAccessParam? = null,
            private val _json: JsonValue? = null,
        ) {

            fun agentBrowserAuthenticationSubmitParam():
                Optional<AgentBrowserAuthenticationSubmitParam> =
                Optional.ofNullable(agentBrowserAuthenticationSubmitParam)

            fun agentBrowserAuthenticationCancelParam():
                Optional<AgentBrowserAuthenticationCancelParam> =
                Optional.ofNullable(agentBrowserAuthenticationCancelParam)

            fun browserOriginAccess(): Optional<AgentBrowserOriginAccessParam> =
                Optional.ofNullable(browserOriginAccess)

            fun isAgentBrowserAuthenticationSubmitParam(): Boolean =
                agentBrowserAuthenticationSubmitParam != null

            fun isAgentBrowserAuthenticationCancelParam(): Boolean =
                agentBrowserAuthenticationCancelParam != null

            fun isBrowserOriginAccess(): Boolean = browserOriginAccess != null

            fun asAgentBrowserAuthenticationSubmitParam(): AgentBrowserAuthenticationSubmitParam =
                agentBrowserAuthenticationSubmitParam.getOrThrow(
                    "agentBrowserAuthenticationSubmitParam"
                )

            fun asAgentBrowserAuthenticationCancelParam(): AgentBrowserAuthenticationCancelParam =
                agentBrowserAuthenticationCancelParam.getOrThrow(
                    "agentBrowserAuthenticationCancelParam"
                )

            fun asBrowserOriginAccess(): AgentBrowserOriginAccessParam =
                browserOriginAccess.getOrThrow("browserOriginAccess")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = response.accept(new Response.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitAgentBrowserAuthenticationSubmitParam(AgentBrowserAuthenticationSubmitParam agentBrowserAuthenticationSubmitParam) {
             *         return Optional.of(agentBrowserAuthenticationSubmitParam.toString());
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
                    agentBrowserAuthenticationSubmitParam != null ->
                        visitor.visitAgentBrowserAuthenticationSubmitParam(
                            agentBrowserAuthenticationSubmitParam
                        )
                    agentBrowserAuthenticationCancelParam != null ->
                        visitor.visitAgentBrowserAuthenticationCancelParam(
                            agentBrowserAuthenticationCancelParam
                        )
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Response = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitAgentBrowserAuthenticationSubmitParam(
                            agentBrowserAuthenticationSubmitParam:
                                AgentBrowserAuthenticationSubmitParam
                        ) {
                            agentBrowserAuthenticationSubmitParam.validate()
                        }

                        override fun visitAgentBrowserAuthenticationCancelParam(
                            agentBrowserAuthenticationCancelParam:
                                AgentBrowserAuthenticationCancelParam
                        ) {
                            agentBrowserAuthenticationCancelParam.validate()
                        }

                        override fun visitBrowserOriginAccess(
                            browserOriginAccess: AgentBrowserOriginAccessParam
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
                        override fun visitAgentBrowserAuthenticationSubmitParam(
                            agentBrowserAuthenticationSubmitParam:
                                AgentBrowserAuthenticationSubmitParam
                        ) = agentBrowserAuthenticationSubmitParam.validity()

                        override fun visitAgentBrowserAuthenticationCancelParam(
                            agentBrowserAuthenticationCancelParam:
                                AgentBrowserAuthenticationCancelParam
                        ) = agentBrowserAuthenticationCancelParam.validity()

                        override fun visitBrowserOriginAccess(
                            browserOriginAccess: AgentBrowserOriginAccessParam
                        ) = browserOriginAccess.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Response &&
                    agentBrowserAuthenticationSubmitParam ==
                        other.agentBrowserAuthenticationSubmitParam &&
                    agentBrowserAuthenticationCancelParam ==
                        other.agentBrowserAuthenticationCancelParam &&
                    browserOriginAccess == other.browserOriginAccess
            }

            override fun hashCode(): Int =
                Objects.hash(
                    agentBrowserAuthenticationSubmitParam,
                    agentBrowserAuthenticationCancelParam,
                    browserOriginAccess,
                )

            override fun toString(): String =
                when {
                    agentBrowserAuthenticationSubmitParam != null ->
                        "Response{agentBrowserAuthenticationSubmitParam=$agentBrowserAuthenticationSubmitParam}"
                    agentBrowserAuthenticationCancelParam != null ->
                        "Response{agentBrowserAuthenticationCancelParam=$agentBrowserAuthenticationCancelParam}"
                    browserOriginAccess != null ->
                        "Response{browserOriginAccess=$browserOriginAccess}"
                    _json != null -> "Response{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Response")
                }

            companion object {

                @JvmStatic
                fun ofAgentBrowserAuthenticationSubmitParam(
                    agentBrowserAuthenticationSubmitParam: AgentBrowserAuthenticationSubmitParam
                ) =
                    Response(
                        agentBrowserAuthenticationSubmitParam =
                            agentBrowserAuthenticationSubmitParam
                    )

                @JvmStatic
                fun ofAgentBrowserAuthenticationCancelParam(
                    agentBrowserAuthenticationCancelParam: AgentBrowserAuthenticationCancelParam
                ) =
                    Response(
                        agentBrowserAuthenticationCancelParam =
                            agentBrowserAuthenticationCancelParam
                    )

                @JvmStatic
                fun ofBrowserOriginAccess(browserOriginAccess: AgentBrowserOriginAccessParam) =
                    Response(browserOriginAccess = browserOriginAccess)
            }

            /**
             * An interface that defines how to map each variant of [Response] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitAgentBrowserAuthenticationSubmitParam(
                    agentBrowserAuthenticationSubmitParam: AgentBrowserAuthenticationSubmitParam
                ): T

                fun visitAgentBrowserAuthenticationCancelParam(
                    agentBrowserAuthenticationCancelParam: AgentBrowserAuthenticationCancelParam
                ): T

                fun visitBrowserOriginAccess(browserOriginAccess: AgentBrowserOriginAccessParam): T

                /**
                 * Maps an unknown variant of [Response] to a value of type [T].
                 *
                 * An instance of [Response] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Response")
                }
            }

            internal class Deserializer : BaseDeserializer<Response>(Response::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Response {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "browser_authentication" -> {
                            val bestMatches =
                                sequenceOf(
                                        tryDeserialize(
                                                node,
                                                jacksonTypeRef<
                                                    AgentBrowserAuthenticationSubmitParam
                                                >(),
                                            )
                                            ?.let {
                                                Response(
                                                    agentBrowserAuthenticationSubmitParam = it,
                                                    _json = json,
                                                )
                                            },
                                        tryDeserialize(
                                                node,
                                                jacksonTypeRef<
                                                    AgentBrowserAuthenticationCancelParam
                                                >(),
                                            )
                                            ?.let {
                                                Response(
                                                    agentBrowserAuthenticationCancelParam = it,
                                                    _json = json,
                                                )
                                            },
                                    )
                                    .filterNotNull()
                                    .allMaxBy { it.validity() }
                                    .toList()
                            return when (bestMatches.size) {
                                // This can happen if what we're deserializing is completely
                                // incompatible with all the possible variants (e.g. deserializing
                                // from boolean).
                                0 -> Response(_json = json)
                                1 -> bestMatches.single()
                                // If there's more than one match with the highest validity, then
                                // use the first completely valid match, or simply the first match
                                // if none are completely valid.
                                else ->
                                    bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                            }
                        }
                        "browser_origin_access" -> {
                            return tryDeserialize(
                                    node,
                                    jacksonTypeRef<AgentBrowserOriginAccessParam>(),
                                )
                                ?.let { Response(browserOriginAccess = it, _json = json) }
                                ?: Response(_json = json)
                        }
                    }

                    return Response(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Response>(Response::class) {

                override fun serialize(
                    value: Response,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.agentBrowserAuthenticationSubmitParam != null ->
                            generator.writeObject(value.agentBrowserAuthenticationSubmitParam)
                        value.agentBrowserAuthenticationCancelParam != null ->
                            generator.writeObject(value.agentBrowserAuthenticationCancelParam)
                        value.browserOriginAccess != null ->
                            generator.writeObject(value.browserOriginAccess)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Response")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentSessionInputComputerUseApprovalRequestResult &&
                requestId == other.requestId &&
                response == other.response &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(requestId, response, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AgentSessionInputComputerUseApprovalRequestResult{requestId=$requestId, response=$response, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Adds one or more user messages and starts a turn. */
    class AgentSessionInputMessage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val input: JsonField<List<AgentSessionInputMessageParam>>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input")
            @ExcludeMissing
            input: JsonField<List<AgentSessionInputMessageParam>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(input, type, mutableMapOf())

        /**
         * The user messages to add to the session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): List<AgentSessionInputMessageParam> = input.getRequired("input")

        /**
         * The type of the object. Always `agent.session.input.message`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("agent.session.input.message")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input")
        @ExcludeMissing
        fun _input(): JsonField<List<AgentSessionInputMessageParam>> = input

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
             * Returns a mutable builder for constructing an instance of [AgentSessionInputMessage].
             *
             * The following fields are required:
             * ```java
             * .input()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AgentSessionInputMessage]. */
        class Builder internal constructor() {

            private var input: JsonField<MutableList<AgentSessionInputMessageParam>>? = null
            private var type: JsonValue = JsonValue.from("agent.session.input.message")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agentSessionInputMessage: AgentSessionInputMessage) = apply {
                input = agentSessionInputMessage.input.map { it.toMutableList() }
                type = agentSessionInputMessage.type
                additionalProperties = agentSessionInputMessage.additionalProperties.toMutableMap()
            }

            /** The user messages to add to the session. */
            fun input(input: List<AgentSessionInputMessageParam>) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed
             * `List<AgentSessionInputMessageParam>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun input(input: JsonField<List<AgentSessionInputMessageParam>>) = apply {
                this.input = input.map { it.toMutableList() }
            }

            /**
             * Adds a single [AgentSessionInputMessageParam] to [Builder.input].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInput(input: AgentSessionInputMessageParam) = apply {
                this.input =
                    (this.input ?: JsonField.of(mutableListOf())).also {
                        checkKnown("input", it).add(input)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("agent.session.input.message")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [AgentSessionInputMessage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .input()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AgentSessionInputMessage =
                AgentSessionInputMessage(
                    checkRequired("input", input).map { it.toImmutable() },
                    type,
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
        fun validate(): AgentSessionInputMessage = apply {
            if (validated) {
                return@apply
            }

            input().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("agent.session.input.message")) {
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
            (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("agent.session.input.message")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentSessionInputMessage &&
                input == other.input &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(input, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AgentSessionInputMessage{input=$input, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Submits the result of a function call. */
    class AgentSessionInputToolResult
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val success: JsonField<Boolean>,
        private val turnId: JsonField<String>,
        private val type: JsonValue,
        private val error: JsonField<String>,
        private val output: JsonField<AgentFunctionCallOutputParam>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("turn_id") @ExcludeMissing turnId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output")
            @ExcludeMissing
            output: JsonField<AgentFunctionCallOutputParam> = JsonMissing.of(),
        ) : this(callId, success, turnId, type, error, output, mutableMapOf())

        /**
         * The ID of the function call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Whether the function call succeeded.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun success(): Boolean = success.getRequired("success")

        /**
         * The ID of the turn that requested the function call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun turnId(): String = turnId.getRequired("turn_id")

        /**
         * The type of the object. Always `agent.session.input.tool_result`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("agent.session.input.tool_result")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The error message when the call failed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * The function result when the call succeeded.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<AgentFunctionCallOutputParam> = output.getOptional("output")

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [success].
         *
         * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

        /**
         * Returns the raw JSON value of [turnId].
         *
         * Unlike [turnId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("turn_id") @ExcludeMissing fun _turnId(): JsonField<String> = turnId

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output")
        @ExcludeMissing
        fun _output(): JsonField<AgentFunctionCallOutputParam> = output

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
             * [AgentSessionInputToolResult].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .success()
             * .turnId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AgentSessionInputToolResult]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var success: JsonField<Boolean>? = null
            private var turnId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("agent.session.input.tool_result")
            private var error: JsonField<String> = JsonMissing.of()
            private var output: JsonField<AgentFunctionCallOutputParam> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agentSessionInputToolResult: AgentSessionInputToolResult) = apply {
                callId = agentSessionInputToolResult.callId
                success = agentSessionInputToolResult.success
                turnId = agentSessionInputToolResult.turnId
                type = agentSessionInputToolResult.type
                error = agentSessionInputToolResult.error
                output = agentSessionInputToolResult.output
                additionalProperties =
                    agentSessionInputToolResult.additionalProperties.toMutableMap()
            }

            /** The ID of the function call. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** Whether the function call succeeded. */
            fun success(success: Boolean) = success(JsonField.of(success))

            /**
             * Sets [Builder.success] to an arbitrary JSON value.
             *
             * You should usually call [Builder.success] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun success(success: JsonField<Boolean>) = apply { this.success = success }

            /** The ID of the turn that requested the function call. */
            fun turnId(turnId: String) = turnId(JsonField.of(turnId))

            /**
             * Sets [Builder.turnId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.turnId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun turnId(turnId: JsonField<String>) = apply { this.turnId = turnId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("agent.session.input.tool_result")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The error message when the call failed. */
            fun error(error: String?) = error(JsonField.ofNullable(error))

            /** Alias for calling [Builder.error] with `error.orElse(null)`. */
            fun error(error: Optional<String>) = error(error.getOrNull())

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            /** The function result when the call succeeded. */
            fun output(output: AgentFunctionCallOutputParam?) = output(JsonField.ofNullable(output))

            /** Alias for calling [Builder.output] with `output.orElse(null)`. */
            fun output(output: Optional<AgentFunctionCallOutputParam>) = output(output.getOrNull())

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed
             * [AgentFunctionCallOutputParam] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun output(output: JsonField<AgentFunctionCallOutputParam>) = apply {
                this.output = output
            }

            /** Alias for calling [output] with `AgentFunctionCallOutputParam.ofString(string)`. */
            fun output(string: String) = output(AgentFunctionCallOutputParam.ofString(string))

            /**
             * Alias for calling [output] with
             * `AgentFunctionCallOutputParam.ofInputContentParams(inputContentParams)`.
             */
            fun outputOfInputContentParams(inputContentParams: List<InputContentParam>) =
                output(AgentFunctionCallOutputParam.ofInputContentParams(inputContentParams))

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
             * Returns an immutable instance of [AgentSessionInputToolResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .success()
             * .turnId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AgentSessionInputToolResult =
                AgentSessionInputToolResult(
                    checkRequired("callId", callId),
                    checkRequired("success", success),
                    checkRequired("turnId", turnId),
                    type,
                    error,
                    output,
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
        fun validate(): AgentSessionInputToolResult = apply {
            if (validated) {
                return@apply
            }

            callId()
            success()
            turnId()
            _type().let {
                if (it != JsonValue.from("agent.session.input.tool_result")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            error()
            output().ifPresent { it.validate() }
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
                (if (success.asKnown().isPresent) 1 else 0) +
                (if (turnId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("agent.session.input.tool_result")) 1 else 0 } +
                (if (error.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentSessionInputToolResult &&
                callId == other.callId &&
                success == other.success &&
                turnId == other.turnId &&
                type == other.type &&
                error == other.error &&
                output == other.output &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(callId, success, turnId, type, error, output, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AgentSessionInputToolResult{callId=$callId, success=$success, turnId=$turnId, type=$type, error=$error, output=$output, additionalProperties=$additionalProperties}"
    }
}
