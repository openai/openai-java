// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response resource. */
class RealtimeResponse
private constructor(
    private val id: JsonField<String>,
    private val conversationId: JsonField<String>,
    private val maxOutputTokens: JsonField<MaxOutputTokens>,
    private val metadata: JsonField<Metadata>,
    private val modalities: JsonField<List<Modality>>,
    private val object_: JsonField<Object>,
    private val output: JsonField<List<ConversationItem>>,
    private val outputAudioFormat: JsonField<OutputAudioFormat>,
    private val status: JsonField<Status>,
    private val statusDetails: JsonField<RealtimeResponseStatus>,
    private val temperature: JsonField<Double>,
    private val usage: JsonField<RealtimeResponseUsage>,
    private val voice: JsonField<Voice>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("conversation_id")
        @ExcludeMissing
        conversationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("modalities")
        @ExcludeMissing
        modalities: JsonField<List<Modality>> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        output: JsonField<List<ConversationItem>> = JsonMissing.of(),
        @JsonProperty("output_audio_format")
        @ExcludeMissing
        outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("status_details")
        @ExcludeMissing
        statusDetails: JsonField<RealtimeResponseStatus> = JsonMissing.of(),
        @JsonProperty("temperature")
        @ExcludeMissing
        temperature: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("usage")
        @ExcludeMissing
        usage: JsonField<RealtimeResponseUsage> = JsonMissing.of(),
        @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
    ) : this(
        id,
        conversationId,
        maxOutputTokens,
        metadata,
        modalities,
        object_,
        output,
        outputAudioFormat,
        status,
        statusDetails,
        temperature,
        usage,
        voice,
        mutableMapOf(),
    )

    /**
     * The unique ID of the response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Which conversation the response is added to, determined by the `conversation` field in the
     * `response.create` event. If `auto`, the response will be added to the default conversation
     * and the value of `conversation_id` will be an id like `conv_1234`. If `none`, the response
     * will not be added to any conversation and the value of `conversation_id` will be `null`. If
     * responses are being triggered by server VAD, the response will be added to the default
     * conversation, thus the `conversation_id` will be an id like `conv_1234`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversationId(): Optional<String> = conversationId.getOptional("conversation_id")

    /**
     * Maximum number of output tokens for a single assistant response, inclusive of tool calls,
     * that was used in this response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxOutputTokens(): Optional<MaxOutputTokens> =
        maxOutputTokens.getOptional("max_output_tokens")

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

    /**
     * The set of modalities the model used to respond. If there are multiple modalities, the model
     * will pick one, for example if `modalities` is `["text", "audio"]`, the model could be
     * responding in either text or audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun modalities(): Optional<List<Modality>> = modalities.getOptional("modalities")

    /**
     * The object type, must be `realtime.response`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * The list of output items generated by the response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun output(): Optional<List<ConversationItem>> = output.getOptional("output")

    /**
     * The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputAudioFormat(): Optional<OutputAudioFormat> =
        outputAudioFormat.getOptional("output_audio_format")

    /**
     * The final status of the response (`completed`, `cancelled`, `failed`, or `incomplete`,
     * `in_progress`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

    /**
     * Additional details about the status.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun statusDetails(): Optional<RealtimeResponseStatus> =
        statusDetails.getOptional("status_details")

    /**
     * Sampling temperature for the model, limited to [0.6, 1.2]. Defaults to 0.8.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = temperature.getOptional("temperature")

    /**
     * Usage statistics for the Response, this will correspond to billing. A Realtime API session
     * will maintain a conversation context and append new Items to the Conversation, thus output
     * from previous turns (text and audio tokens) will become the input for later turns.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<RealtimeResponseUsage> = usage.getOptional("usage")

    /**
     * The voice the model used to respond. Current voice options are `alloy`, `ash`, `ballad`,
     * `coral`, `echo`, `sage`, `shimmer`, and `verse`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun voice(): Optional<Voice> = voice.getOptional("voice")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [conversationId].
     *
     * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversation_id")
    @ExcludeMissing
    fun _conversationId(): JsonField<String> = conversationId

    /**
     * Returns the raw JSON value of [maxOutputTokens].
     *
     * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_output_tokens")
    @ExcludeMissing
    fun _maxOutputTokens(): JsonField<MaxOutputTokens> = maxOutputTokens

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [modalities].
     *
     * Unlike [modalities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("modalities")
    @ExcludeMissing
    fun _modalities(): JsonField<List<Modality>> = modalities

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<List<ConversationItem>> = output

    /**
     * Returns the raw JSON value of [outputAudioFormat].
     *
     * Unlike [outputAudioFormat], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("output_audio_format")
    @ExcludeMissing
    fun _outputAudioFormat(): JsonField<OutputAudioFormat> = outputAudioFormat

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [statusDetails].
     *
     * Unlike [statusDetails], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status_details")
    @ExcludeMissing
    fun _statusDetails(): JsonField<RealtimeResponseStatus> = statusDetails

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("temperature") @ExcludeMissing fun _temperature(): JsonField<Double> = temperature

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<RealtimeResponseUsage> = usage

    /**
     * Returns the raw JSON value of [voice].
     *
     * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<Voice> = voice

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

        /** Returns a mutable builder for constructing an instance of [RealtimeResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var conversationId: JsonField<String> = JsonMissing.of()
        private var maxOutputTokens: JsonField<MaxOutputTokens> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var modalities: JsonField<MutableList<Modality>>? = null
        private var object_: JsonField<Object> = JsonMissing.of()
        private var output: JsonField<MutableList<ConversationItem>>? = null
        private var outputAudioFormat: JsonField<OutputAudioFormat> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var statusDetails: JsonField<RealtimeResponseStatus> = JsonMissing.of()
        private var temperature: JsonField<Double> = JsonMissing.of()
        private var usage: JsonField<RealtimeResponseUsage> = JsonMissing.of()
        private var voice: JsonField<Voice> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeResponse: RealtimeResponse) = apply {
            id = realtimeResponse.id
            conversationId = realtimeResponse.conversationId
            maxOutputTokens = realtimeResponse.maxOutputTokens
            metadata = realtimeResponse.metadata
            modalities = realtimeResponse.modalities.map { it.toMutableList() }
            object_ = realtimeResponse.object_
            output = realtimeResponse.output.map { it.toMutableList() }
            outputAudioFormat = realtimeResponse.outputAudioFormat
            status = realtimeResponse.status
            statusDetails = realtimeResponse.statusDetails
            temperature = realtimeResponse.temperature
            usage = realtimeResponse.usage
            voice = realtimeResponse.voice
            additionalProperties = realtimeResponse.additionalProperties.toMutableMap()
        }

        /** The unique ID of the response. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Which conversation the response is added to, determined by the `conversation` field in
         * the `response.create` event. If `auto`, the response will be added to the default
         * conversation and the value of `conversation_id` will be an id like `conv_1234`. If
         * `none`, the response will not be added to any conversation and the value of
         * `conversation_id` will be `null`. If responses are being triggered by server VAD, the
         * response will be added to the default conversation, thus the `conversation_id` will be an
         * id like `conv_1234`.
         */
        fun conversationId(conversationId: String) = conversationId(JsonField.of(conversationId))

        /**
         * Sets [Builder.conversationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.conversationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun conversationId(conversationId: JsonField<String>) = apply {
            this.conversationId = conversationId
        }

        /**
         * Maximum number of output tokens for a single assistant response, inclusive of tool calls,
         * that was used in this response.
         */
        fun maxOutputTokens(maxOutputTokens: MaxOutputTokens) =
            maxOutputTokens(JsonField.of(maxOutputTokens))

        /**
         * Sets [Builder.maxOutputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxOutputTokens] with a well-typed [MaxOutputTokens]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun maxOutputTokens(maxOutputTokens: JsonField<MaxOutputTokens>) = apply {
            this.maxOutputTokens = maxOutputTokens
        }

        /** Alias for calling [maxOutputTokens] with `MaxOutputTokens.ofInteger(integer)`. */
        fun maxOutputTokens(integer: Long) = maxOutputTokens(MaxOutputTokens.ofInteger(integer))

        /** Alias for calling [maxOutputTokens] with `MaxOutputTokens.ofInf()`. */
        fun maxOutputTokensInf() = maxOutputTokens(MaxOutputTokens.ofInf())

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /**
         * The set of modalities the model used to respond. If there are multiple modalities, the
         * model will pick one, for example if `modalities` is `["text", "audio"]`, the model could
         * be responding in either text or audio.
         */
        fun modalities(modalities: List<Modality>) = modalities(JsonField.of(modalities))

        /**
         * Sets [Builder.modalities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modalities] with a well-typed `List<Modality>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun modalities(modalities: JsonField<List<Modality>>) = apply {
            this.modalities = modalities.map { it.toMutableList() }
        }

        /**
         * Adds a single [Modality] to [modalities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addModality(modality: Modality) = apply {
            modalities =
                (modalities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("modalities", it).add(modality)
                }
        }

        /** The object type, must be `realtime.response`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The list of output items generated by the response. */
        fun output(output: List<ConversationItem>) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed `List<ConversationItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun output(output: JsonField<List<ConversationItem>>) = apply {
            this.output = output.map { it.toMutableList() }
        }

        /**
         * Adds a single [ConversationItem] to [Builder.output].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOutput(output: ConversationItem) = apply {
            this.output =
                (this.output ?: JsonField.of(mutableListOf())).also {
                    checkKnown("output", it).add(output)
                }
        }

        /**
         * Alias for calling [addOutput] with
         * `ConversationItem.ofRealtimeConversationItemSystemMessage(realtimeConversationItemSystemMessage)`.
         */
        fun addOutput(
            realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage
        ) =
            addOutput(
                ConversationItem.ofRealtimeConversationItemSystemMessage(
                    realtimeConversationItemSystemMessage
                )
            )

        /**
         * Alias for calling [addOutput] with the following:
         * ```java
         * RealtimeConversationItemSystemMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addRealtimeConversationItemSystemMessageOutput(
            content: List<RealtimeConversationItemSystemMessage.Content>
        ) = addOutput(RealtimeConversationItemSystemMessage.builder().content(content).build())

        /**
         * Alias for calling [addOutput] with
         * `ConversationItem.ofRealtimeConversationItemUserMessage(realtimeConversationItemUserMessage)`.
         */
        fun addOutput(realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage) =
            addOutput(
                ConversationItem.ofRealtimeConversationItemUserMessage(
                    realtimeConversationItemUserMessage
                )
            )

        /**
         * Alias for calling [addOutput] with the following:
         * ```java
         * RealtimeConversationItemUserMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addRealtimeConversationItemUserMessageOutput(
            content: List<RealtimeConversationItemUserMessage.Content>
        ) = addOutput(RealtimeConversationItemUserMessage.builder().content(content).build())

        /**
         * Alias for calling [addOutput] with
         * `ConversationItem.ofRealtimeConversationItemAssistantMessage(realtimeConversationItemAssistantMessage)`.
         */
        fun addOutput(
            realtimeConversationItemAssistantMessage: RealtimeConversationItemAssistantMessage
        ) =
            addOutput(
                ConversationItem.ofRealtimeConversationItemAssistantMessage(
                    realtimeConversationItemAssistantMessage
                )
            )

        /**
         * Alias for calling [addOutput] with the following:
         * ```java
         * RealtimeConversationItemAssistantMessage.builder()
         *     .content(content)
         *     .build()
         * ```
         */
        fun addRealtimeConversationItemAssistantMessageOutput(
            content: List<RealtimeConversationItemAssistantMessage.Content>
        ) = addOutput(RealtimeConversationItemAssistantMessage.builder().content(content).build())

        /** Alias for calling [addOutput] with `ConversationItem.ofFunctionCall(functionCall)`. */
        fun addOutput(functionCall: RealtimeConversationItemFunctionCall) =
            addOutput(ConversationItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addOutput] with
         * `ConversationItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addOutput(functionCallOutput: RealtimeConversationItemFunctionCallOutput) =
            addOutput(ConversationItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [addOutput] with
         * `ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addOutput(mcpApprovalResponse: RealtimeMcpApprovalResponse) =
            addOutput(ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [addOutput] with `ConversationItem.ofMcpListTools(mcpListTools)`. */
        fun addOutput(mcpListTools: RealtimeMcpListTools) =
            addOutput(ConversationItem.ofMcpListTools(mcpListTools))

        /** Alias for calling [addOutput] with `ConversationItem.ofMcpToolCall(mcpToolCall)`. */
        fun addOutput(mcpToolCall: RealtimeMcpToolCall) =
            addOutput(ConversationItem.ofMcpToolCall(mcpToolCall))

        /**
         * Alias for calling [addOutput] with
         * `ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addOutput(mcpApprovalRequest: RealtimeMcpApprovalRequest) =
            addOutput(ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /** The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
        fun outputAudioFormat(outputAudioFormat: OutputAudioFormat) =
            outputAudioFormat(JsonField.of(outputAudioFormat))

        /**
         * Sets [Builder.outputAudioFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputAudioFormat] with a well-typed [OutputAudioFormat]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun outputAudioFormat(outputAudioFormat: JsonField<OutputAudioFormat>) = apply {
            this.outputAudioFormat = outputAudioFormat
        }

        /**
         * The final status of the response (`completed`, `cancelled`, `failed`, or `incomplete`,
         * `in_progress`).
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Additional details about the status. */
        fun statusDetails(statusDetails: RealtimeResponseStatus) =
            statusDetails(JsonField.of(statusDetails))

        /**
         * Sets [Builder.statusDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusDetails] with a well-typed
         * [RealtimeResponseStatus] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun statusDetails(statusDetails: JsonField<RealtimeResponseStatus>) = apply {
            this.statusDetails = statusDetails
        }

        /** Sampling temperature for the model, limited to [0.6, 1.2]. Defaults to 0.8. */
        fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { this.temperature = temperature }

        /**
         * Usage statistics for the Response, this will correspond to billing. A Realtime API
         * session will maintain a conversation context and append new Items to the Conversation,
         * thus output from previous turns (text and audio tokens) will become the input for later
         * turns.
         */
        fun usage(usage: RealtimeResponseUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [RealtimeResponseUsage] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun usage(usage: JsonField<RealtimeResponseUsage>) = apply { this.usage = usage }

        /**
         * The voice the model used to respond. Current voice options are `alloy`, `ash`, `ballad`,
         * `coral`, `echo`, `sage`, `shimmer`, and `verse`.
         */
        fun voice(voice: Voice) = voice(JsonField.of(voice))

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed [Voice] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

        /**
         * Sets [voice] to an arbitrary [String].
         *
         * You should usually call [voice] with a well-typed [Voice] constant instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(value: String) = voice(Voice.of(value))

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
         * Returns an immutable instance of [RealtimeResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeResponse =
            RealtimeResponse(
                id,
                conversationId,
                maxOutputTokens,
                metadata,
                (modalities ?: JsonMissing.of()).map { it.toImmutable() },
                object_,
                (output ?: JsonMissing.of()).map { it.toImmutable() },
                outputAudioFormat,
                status,
                statusDetails,
                temperature,
                usage,
                voice,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        conversationId()
        maxOutputTokens().ifPresent { it.validate() }
        metadata().ifPresent { it.validate() }
        modalities().ifPresent { it.forEach { it.validate() } }
        object_().ifPresent { it.validate() }
        output().ifPresent { it.forEach { it.validate() } }
        outputAudioFormat().ifPresent { it.validate() }
        status().ifPresent { it.validate() }
        statusDetails().ifPresent { it.validate() }
        temperature()
        usage().ifPresent { it.validate() }
        voice()
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
            (if (conversationId.asKnown().isPresent) 1 else 0) +
            (maxOutputTokens.asKnown().getOrNull()?.validity() ?: 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (modalities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (output.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (outputAudioFormat.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (statusDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (temperature.asKnown().isPresent) 1 else 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (if (voice.asKnown().isPresent) 1 else 0)

    /**
     * Maximum number of output tokens for a single assistant response, inclusive of tool calls,
     * that was used in this response.
     */
    @JsonDeserialize(using = MaxOutputTokens.Deserializer::class)
    @JsonSerialize(using = MaxOutputTokens.Serializer::class)
    class MaxOutputTokens
    private constructor(
        private val integer: Long? = null,
        private val inf: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun inf(): Optional<JsonValue> = Optional.ofNullable(inf)

        fun isInteger(): Boolean = integer != null

        fun isInf(): Boolean = inf != null

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun asInf(): JsonValue = inf.getOrThrow("inf")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                integer != null -> visitor.visitInteger(integer)
                inf != null -> visitor.visitInf(inf)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): MaxOutputTokens = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitInteger(integer: Long) {}

                    override fun visitInf(inf: JsonValue) {
                        inf.let {
                            if (it != JsonValue.from("inf")) {
                                throw OpenAIInvalidDataException("'inf' is invalid, received $it")
                            }
                        }
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
                    override fun visitInteger(integer: Long) = 1

                    override fun visitInf(inf: JsonValue) =
                        inf.let { if (it == JsonValue.from("inf")) 1 else 0 }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MaxOutputTokens && integer == other.integer && inf == other.inf
        }

        override fun hashCode(): Int = Objects.hash(integer, inf)

        override fun toString(): String =
            when {
                integer != null -> "MaxOutputTokens{integer=$integer}"
                inf != null -> "MaxOutputTokens{inf=$inf}"
                _json != null -> "MaxOutputTokens{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid MaxOutputTokens")
            }

        companion object {

            @JvmStatic fun ofInteger(integer: Long) = MaxOutputTokens(integer = integer)

            @JvmStatic fun ofInf() = MaxOutputTokens(inf = JsonValue.from("inf"))
        }

        /**
         * An interface that defines how to map each variant of [MaxOutputTokens] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitInteger(integer: Long): T

            fun visitInf(inf: JsonValue): T

            /**
             * Maps an unknown variant of [MaxOutputTokens] to a value of type [T].
             *
             * An instance of [MaxOutputTokens] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown MaxOutputTokens: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<MaxOutputTokens>(MaxOutputTokens::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): MaxOutputTokens {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { MaxOutputTokens(inf = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                MaxOutputTokens(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from object).
                    0 -> MaxOutputTokens(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<MaxOutputTokens>(MaxOutputTokens::class) {

            override fun serialize(
                value: MaxOutputTokens,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.integer != null -> generator.writeObject(value.integer)
                    value.inf != null -> generator.writeObject(value.inf)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid MaxOutputTokens")
                }
            }
        }
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
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

    class Modality @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val TEXT = of("text")

            @JvmField val AUDIO = of("audio")

            @JvmStatic fun of(value: String) = Modality(JsonField.of(value))
        }

        /** An enum containing [Modality]'s known values. */
        enum class Known {
            TEXT,
            AUDIO,
        }

        /**
         * An enum containing [Modality]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Modality] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TEXT,
            AUDIO,
            /** An enum member indicating that [Modality] was instantiated with an unknown value. */
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
                TEXT -> Value.TEXT
                AUDIO -> Value.AUDIO
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
                TEXT -> Known.TEXT
                AUDIO -> Known.AUDIO
                else -> throw OpenAIInvalidDataException("Unknown Modality: $value")
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

        fun validate(): Modality = apply {
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

            return other is Modality && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The object type, must be `realtime.response`. */
    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val REALTIME_RESPONSE = of("realtime.response")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            REALTIME_RESPONSE
        }

        /**
         * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Object] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            REALTIME_RESPONSE,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
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
                REALTIME_RESPONSE -> Value.REALTIME_RESPONSE
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
                REALTIME_RESPONSE -> Known.REALTIME_RESPONSE
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
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

        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The format of output audio. Options are `pcm16`, `g711_ulaw`, or `g711_alaw`. */
    class OutputAudioFormat @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val PCM16 = of("pcm16")

            @JvmField val G711_ULAW = of("g711_ulaw")

            @JvmField val G711_ALAW = of("g711_alaw")

            @JvmStatic fun of(value: String) = OutputAudioFormat(JsonField.of(value))
        }

        /** An enum containing [OutputAudioFormat]'s known values. */
        enum class Known {
            PCM16,
            G711_ULAW,
            G711_ALAW,
        }

        /**
         * An enum containing [OutputAudioFormat]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OutputAudioFormat] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PCM16,
            G711_ULAW,
            G711_ALAW,
            /**
             * An enum member indicating that [OutputAudioFormat] was instantiated with an unknown
             * value.
             */
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
                PCM16 -> Value.PCM16
                G711_ULAW -> Value.G711_ULAW
                G711_ALAW -> Value.G711_ALAW
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
                PCM16 -> Known.PCM16
                G711_ULAW -> Known.G711_ULAW
                G711_ALAW -> Known.G711_ALAW
                else -> throw OpenAIInvalidDataException("Unknown OutputAudioFormat: $value")
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

        fun validate(): OutputAudioFormat = apply {
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

            return other is OutputAudioFormat && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * The final status of the response (`completed`, `cancelled`, `failed`, or `incomplete`,
     * `in_progress`).
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

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmField val FAILED = of("failed")

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            COMPLETED,
            CANCELLED,
            FAILED,
            INCOMPLETE,
            IN_PROGRESS,
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
            COMPLETED,
            CANCELLED,
            FAILED,
            INCOMPLETE,
            IN_PROGRESS,
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
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
                FAILED -> Value.FAILED
                INCOMPLETE -> Value.INCOMPLETE
                IN_PROGRESS -> Value.IN_PROGRESS
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
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                FAILED -> Known.FAILED
                INCOMPLETE -> Known.INCOMPLETE
                IN_PROGRESS -> Known.IN_PROGRESS
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

    /**
     * The voice the model used to respond. Current voice options are `alloy`, `ash`, `ballad`,
     * `coral`, `echo`, `sage`, `shimmer`, and `verse`.
     */
    class Voice @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ALLOY = of("alloy")

            @JvmField val ASH = of("ash")

            @JvmField val BALLAD = of("ballad")

            @JvmField val CORAL = of("coral")

            @JvmField val ECHO = of("echo")

            @JvmField val SAGE = of("sage")

            @JvmField val SHIMMER = of("shimmer")

            @JvmField val VERSE = of("verse")

            @JvmField val MARIN = of("marin")

            @JvmField val CEDAR = of("cedar")

            @JvmStatic fun of(value: String) = Voice(JsonField.of(value))
        }

        /** An enum containing [Voice]'s known values. */
        enum class Known {
            ALLOY,
            ASH,
            BALLAD,
            CORAL,
            ECHO,
            SAGE,
            SHIMMER,
            VERSE,
            MARIN,
            CEDAR,
        }

        /**
         * An enum containing [Voice]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Voice] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ALLOY,
            ASH,
            BALLAD,
            CORAL,
            ECHO,
            SAGE,
            SHIMMER,
            VERSE,
            MARIN,
            CEDAR,
            /** An enum member indicating that [Voice] was instantiated with an unknown value. */
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
                ALLOY -> Value.ALLOY
                ASH -> Value.ASH
                BALLAD -> Value.BALLAD
                CORAL -> Value.CORAL
                ECHO -> Value.ECHO
                SAGE -> Value.SAGE
                SHIMMER -> Value.SHIMMER
                VERSE -> Value.VERSE
                MARIN -> Value.MARIN
                CEDAR -> Value.CEDAR
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
                ALLOY -> Known.ALLOY
                ASH -> Known.ASH
                BALLAD -> Known.BALLAD
                CORAL -> Known.CORAL
                ECHO -> Known.ECHO
                SAGE -> Known.SAGE
                SHIMMER -> Known.SHIMMER
                VERSE -> Known.VERSE
                MARIN -> Known.MARIN
                CEDAR -> Known.CEDAR
                else -> throw OpenAIInvalidDataException("Unknown Voice: $value")
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

        fun validate(): Voice = apply {
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

            return other is Voice && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeResponse &&
            id == other.id &&
            conversationId == other.conversationId &&
            maxOutputTokens == other.maxOutputTokens &&
            metadata == other.metadata &&
            modalities == other.modalities &&
            object_ == other.object_ &&
            output == other.output &&
            outputAudioFormat == other.outputAudioFormat &&
            status == other.status &&
            statusDetails == other.statusDetails &&
            temperature == other.temperature &&
            usage == other.usage &&
            voice == other.voice &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            conversationId,
            maxOutputTokens,
            metadata,
            modalities,
            object_,
            output,
            outputAudioFormat,
            status,
            statusDetails,
            temperature,
            usage,
            voice,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponse{id=$id, conversationId=$conversationId, maxOutputTokens=$maxOutputTokens, metadata=$metadata, modalities=$modalities, object_=$object_, output=$output, outputAudioFormat=$outputAudioFormat, status=$status, statusDetails=$statusDetails, temperature=$temperature, usage=$usage, voice=$voice, additionalProperties=$additionalProperties}"
}
