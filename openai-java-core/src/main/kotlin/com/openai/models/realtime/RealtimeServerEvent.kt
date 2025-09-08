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

/** A realtime server event. */
@JsonDeserialize(using = RealtimeServerEvent.Deserializer::class)
@JsonSerialize(using = RealtimeServerEvent.Serializer::class)
class RealtimeServerEvent
private constructor(
    private val conversationCreated: ConversationCreatedEvent? = null,
    private val conversationItemCreated: ConversationItemCreatedEvent? = null,
    private val conversationItemDeleted: ConversationItemDeletedEvent? = null,
    private val conversationItemInputAudioTranscriptionCompleted:
        ConversationItemInputAudioTranscriptionCompletedEvent? =
        null,
    private val conversationItemInputAudioTranscriptionDelta:
        ConversationItemInputAudioTranscriptionDeltaEvent? =
        null,
    private val conversationItemInputAudioTranscriptionFailed:
        ConversationItemInputAudioTranscriptionFailedEvent? =
        null,
    private val conversationItemRetrieved: ConversationItemRetrieved? = null,
    private val conversationItemTruncated: ConversationItemTruncatedEvent? = null,
    private val error: RealtimeErrorEvent? = null,
    private val inputAudioBufferCleared: InputAudioBufferClearedEvent? = null,
    private val inputAudioBufferCommitted: InputAudioBufferCommittedEvent? = null,
    private val inputAudioBufferSpeechStarted: InputAudioBufferSpeechStartedEvent? = null,
    private val inputAudioBufferSpeechStopped: InputAudioBufferSpeechStoppedEvent? = null,
    private val rateLimitsUpdated: RateLimitsUpdatedEvent? = null,
    private val responseOutputAudioDelta: ResponseAudioDeltaEvent? = null,
    private val responseOutputAudioDone: ResponseAudioDoneEvent? = null,
    private val responseOutputAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent? = null,
    private val responseOutputAudioTranscriptDone: ResponseAudioTranscriptDoneEvent? = null,
    private val responseContentPartAdded: ResponseContentPartAddedEvent? = null,
    private val responseContentPartDone: ResponseContentPartDoneEvent? = null,
    private val responseCreated: ResponseCreatedEvent? = null,
    private val responseDone: ResponseDoneEvent? = null,
    private val responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent? = null,
    private val responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent? = null,
    private val responseOutputItemAdded: ResponseOutputItemAddedEvent? = null,
    private val responseOutputItemDone: ResponseOutputItemDoneEvent? = null,
    private val responseOutputTextDelta: ResponseTextDeltaEvent? = null,
    private val responseOutputTextDone: ResponseTextDoneEvent? = null,
    private val sessionCreated: SessionCreatedEvent? = null,
    private val sessionUpdated: SessionUpdatedEvent? = null,
    private val transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent? = null,
    private val transcriptionSessionCreated: TranscriptionSessionCreated? = null,
    private val outputAudioBufferStarted: OutputAudioBufferStarted? = null,
    private val outputAudioBufferStopped: OutputAudioBufferStopped? = null,
    private val outputAudioBufferCleared: OutputAudioBufferCleared? = null,
    private val conversationItemAdded: ConversationItemAdded? = null,
    private val conversationItemDone: ConversationItemDone? = null,
    private val inputAudioBufferTimeoutTriggered: InputAudioBufferTimeoutTriggered? = null,
    private val conversationItemInputAudioTranscriptionSegment:
        ConversationItemInputAudioTranscriptionSegment? =
        null,
    private val mcpListToolsInProgress: McpListToolsInProgress? = null,
    private val mcpListToolsCompleted: McpListToolsCompleted? = null,
    private val mcpListToolsFailed: McpListToolsFailed? = null,
    private val responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDelta? = null,
    private val responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDone? = null,
    private val responseMcpCallInProgress: ResponseMcpCallInProgress? = null,
    private val responseMcpCallCompleted: ResponseMcpCallCompleted? = null,
    private val responseMcpCallFailed: ResponseMcpCallFailed? = null,
    private val _json: JsonValue? = null,
) {

    /** Returned when a conversation is created. Emitted right after session creation. */
    fun conversationCreated(): Optional<ConversationCreatedEvent> =
        Optional.ofNullable(conversationCreated)

    /**
     * Returned when a conversation item is created. There are several scenarios that produce this
     * event:
     * - The server is generating a Response, which if successful will produce either one or two
     *   Items, which will be of type `message` (role `assistant`) or type `function_call`.
     * - The input audio buffer has been committed, either by the client or the server (in
     *   `server_vad` mode). The server will take the content of the input audio buffer and add it
     *   to a new user message Item.
     * - The client has sent a `conversation.item.create` event to add a new Item to the
     *   Conversation.
     */
    fun conversationItemCreated(): Optional<ConversationItemCreatedEvent> =
        Optional.ofNullable(conversationItemCreated)

    /**
     * Returned when an item in the conversation is deleted by the client with a
     * `conversation.item.delete` event. This event is used to synchronize the server's
     * understanding of the conversation history with the client's view.
     */
    fun conversationItemDeleted(): Optional<ConversationItemDeletedEvent> =
        Optional.ofNullable(conversationItemDeleted)

    /**
     * This event is the output of audio transcription for user audio written to the user audio
     * buffer. Transcription begins when the input audio buffer is committed by the client or server
     * (when VAD is enabled). Transcription runs asynchronously with Response creation, so this
     * event may come before or after the Response events.
     *
     * Realtime API models accept audio natively, and thus input transcription is a separate process
     * run on a separate ASR (Automatic Speech Recognition) model. The transcript may diverge
     * somewhat from the model's interpretation, and should be treated as a rough guide.
     */
    fun conversationItemInputAudioTranscriptionCompleted():
        Optional<ConversationItemInputAudioTranscriptionCompletedEvent> =
        Optional.ofNullable(conversationItemInputAudioTranscriptionCompleted)

    /**
     * Returned when the text value of an input audio transcription content part is updated with
     * incremental transcription results.
     */
    fun conversationItemInputAudioTranscriptionDelta():
        Optional<ConversationItemInputAudioTranscriptionDeltaEvent> =
        Optional.ofNullable(conversationItemInputAudioTranscriptionDelta)

    /**
     * Returned when input audio transcription is configured, and a transcription request for a user
     * message failed. These events are separate from other `error` events so that the client can
     * identify the related Item.
     */
    fun conversationItemInputAudioTranscriptionFailed():
        Optional<ConversationItemInputAudioTranscriptionFailedEvent> =
        Optional.ofNullable(conversationItemInputAudioTranscriptionFailed)

    /**
     * Returned when a conversation item is retrieved with `conversation.item.retrieve`. This is
     * provided as a way to fetch the server's representation of an item, for example to get access
     * to the post-processed audio data after noise cancellation and VAD. It includes the full
     * content of the Item, including audio data.
     */
    fun conversationItemRetrieved(): Optional<ConversationItemRetrieved> =
        Optional.ofNullable(conversationItemRetrieved)

    /**
     * Returned when an earlier assistant audio message item is truncated by the client with a
     * `conversation.item.truncate` event. This event is used to synchronize the server's
     * understanding of the audio with the client's playback.
     *
     * This action will truncate the audio and remove the server-side text transcript to ensure
     * there is no text in the context that hasn't been heard by the user.
     */
    fun conversationItemTruncated(): Optional<ConversationItemTruncatedEvent> =
        Optional.ofNullable(conversationItemTruncated)

    /**
     * Returned when an error occurs, which could be a client problem or a server problem. Most
     * errors are recoverable and the session will stay open, we recommend to implementors to
     * monitor and log error messages by default.
     */
    fun error(): Optional<RealtimeErrorEvent> = Optional.ofNullable(error)

    /**
     * Returned when the input audio buffer is cleared by the client with a
     * `input_audio_buffer.clear` event.
     */
    fun inputAudioBufferCleared(): Optional<InputAudioBufferClearedEvent> =
        Optional.ofNullable(inputAudioBufferCleared)

    /**
     * Returned when an input audio buffer is committed, either by the client or automatically in
     * server VAD mode. The `item_id` property is the ID of the user message item that will be
     * created, thus a `conversation.item.created` event will also be sent to the client.
     */
    fun inputAudioBufferCommitted(): Optional<InputAudioBufferCommittedEvent> =
        Optional.ofNullable(inputAudioBufferCommitted)

    /**
     * Sent by the server when in `server_vad` mode to indicate that speech has been detected in the
     * audio buffer. This can happen any time audio is added to the buffer (unless speech is already
     * detected). The client may want to use this event to interrupt audio playback or provide
     * visual feedback to the user.
     *
     * The client should expect to receive a `input_audio_buffer.speech_stopped` event when speech
     * stops. The `item_id` property is the ID of the user message item that will be created when
     * speech stops and will also be included in the `input_audio_buffer.speech_stopped` event
     * (unless the client manually commits the audio buffer during VAD activation).
     */
    fun inputAudioBufferSpeechStarted(): Optional<InputAudioBufferSpeechStartedEvent> =
        Optional.ofNullable(inputAudioBufferSpeechStarted)

    /**
     * Returned in `server_vad` mode when the server detects the end of speech in the audio buffer.
     * The server will also send an `conversation.item.created` event with the user message item
     * that is created from the audio buffer.
     */
    fun inputAudioBufferSpeechStopped(): Optional<InputAudioBufferSpeechStoppedEvent> =
        Optional.ofNullable(inputAudioBufferSpeechStopped)

    /**
     * Emitted at the beginning of a Response to indicate the updated rate limits. When a Response
     * is created some tokens will be "reserved" for the output tokens, the rate limits shown here
     * reflect that reservation, which is then adjusted accordingly once the Response is completed.
     */
    fun rateLimitsUpdated(): Optional<RateLimitsUpdatedEvent> =
        Optional.ofNullable(rateLimitsUpdated)

    /** Returned when the model-generated audio is updated. */
    fun responseOutputAudioDelta(): Optional<ResponseAudioDeltaEvent> =
        Optional.ofNullable(responseOutputAudioDelta)

    /**
     * Returned when the model-generated audio is done. Also emitted when a Response is interrupted,
     * incomplete, or cancelled.
     */
    fun responseOutputAudioDone(): Optional<ResponseAudioDoneEvent> =
        Optional.ofNullable(responseOutputAudioDone)

    /** Returned when the model-generated transcription of audio output is updated. */
    fun responseOutputAudioTranscriptDelta(): Optional<ResponseAudioTranscriptDeltaEvent> =
        Optional.ofNullable(responseOutputAudioTranscriptDelta)

    /**
     * Returned when the model-generated transcription of audio output is done streaming. Also
     * emitted when a Response is interrupted, incomplete, or cancelled.
     */
    fun responseOutputAudioTranscriptDone(): Optional<ResponseAudioTranscriptDoneEvent> =
        Optional.ofNullable(responseOutputAudioTranscriptDone)

    /**
     * Returned when a new content part is added to an assistant message item during response
     * generation.
     */
    fun responseContentPartAdded(): Optional<ResponseContentPartAddedEvent> =
        Optional.ofNullable(responseContentPartAdded)

    /**
     * Returned when a content part is done streaming in an assistant message item. Also emitted
     * when a Response is interrupted, incomplete, or cancelled.
     */
    fun responseContentPartDone(): Optional<ResponseContentPartDoneEvent> =
        Optional.ofNullable(responseContentPartDone)

    /**
     * Returned when a new Response is created. The first event of response creation, where the
     * response is in an initial state of `in_progress`.
     */
    fun responseCreated(): Optional<ResponseCreatedEvent> = Optional.ofNullable(responseCreated)

    /**
     * Returned when a Response is done streaming. Always emitted, no matter the final state. The
     * Response object included in the `response.done` event will include all output Items in the
     * Response but will omit the raw audio data.
     *
     * Clients should check the `status` field of the Response to determine if it was successful
     * (`completed`) or if there was another outcome: `cancelled`, `failed`, or `incomplete`.
     *
     * A response will contain all output items that were generated during the response, excluding
     * any audio content.
     */
    fun responseDone(): Optional<ResponseDoneEvent> = Optional.ofNullable(responseDone)

    /** Returned when the model-generated function call arguments are updated. */
    fun responseFunctionCallArgumentsDelta(): Optional<ResponseFunctionCallArgumentsDeltaEvent> =
        Optional.ofNullable(responseFunctionCallArgumentsDelta)

    /**
     * Returned when the model-generated function call arguments are done streaming. Also emitted
     * when a Response is interrupted, incomplete, or cancelled.
     */
    fun responseFunctionCallArgumentsDone(): Optional<ResponseFunctionCallArgumentsDoneEvent> =
        Optional.ofNullable(responseFunctionCallArgumentsDone)

    /** Returned when a new Item is created during Response generation. */
    fun responseOutputItemAdded(): Optional<ResponseOutputItemAddedEvent> =
        Optional.ofNullable(responseOutputItemAdded)

    /**
     * Returned when an Item is done streaming. Also emitted when a Response is interrupted,
     * incomplete, or cancelled.
     */
    fun responseOutputItemDone(): Optional<ResponseOutputItemDoneEvent> =
        Optional.ofNullable(responseOutputItemDone)

    /** Returned when the text value of an "output_text" content part is updated. */
    fun responseOutputTextDelta(): Optional<ResponseTextDeltaEvent> =
        Optional.ofNullable(responseOutputTextDelta)

    /**
     * Returned when the text value of an "output_text" content part is done streaming. Also emitted
     * when a Response is interrupted, incomplete, or cancelled.
     */
    fun responseOutputTextDone(): Optional<ResponseTextDoneEvent> =
        Optional.ofNullable(responseOutputTextDone)

    /**
     * Returned when a Session is created. Emitted automatically when a new connection is
     * established as the first server event. This event will contain the default Session
     * configuration.
     */
    fun sessionCreated(): Optional<SessionCreatedEvent> = Optional.ofNullable(sessionCreated)

    /**
     * Returned when a session is updated with a `session.update` event, unless there is an error.
     */
    fun sessionUpdated(): Optional<SessionUpdatedEvent> = Optional.ofNullable(sessionUpdated)

    /**
     * Returned when a transcription session is updated with a `transcription_session.update` event,
     * unless there is an error.
     */
    fun transcriptionSessionUpdated(): Optional<TranscriptionSessionUpdatedEvent> =
        Optional.ofNullable(transcriptionSessionUpdated)

    /** Returned when a transcription session is created. */
    fun transcriptionSessionCreated(): Optional<TranscriptionSessionCreated> =
        Optional.ofNullable(transcriptionSessionCreated)

    /**
     * **WebRTC Only:** Emitted when the server begins streaming audio to the client. This event is
     * emitted after an audio content part has been added (`response.content_part.added`) to the
     * response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun outputAudioBufferStarted(): Optional<OutputAudioBufferStarted> =
        Optional.ofNullable(outputAudioBufferStarted)

    /**
     * **WebRTC Only:** Emitted when the output audio buffer has been completely drained on the
     * server, and no more audio is forthcoming. This event is emitted after the full response data
     * has been sent to the client (`response.done`).
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun outputAudioBufferStopped(): Optional<OutputAudioBufferStopped> =
        Optional.ofNullable(outputAudioBufferStopped)

    /**
     * **WebRTC Only:** Emitted when the output audio buffer is cleared. This happens either in VAD
     * mode when the user has interrupted (`input_audio_buffer.speech_started`), or when the client
     * has emitted the `output_audio_buffer.clear` event to manually cut off the current audio
     * response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun outputAudioBufferCleared(): Optional<OutputAudioBufferCleared> =
        Optional.ofNullable(outputAudioBufferCleared)

    /**
     * Sent by the server when an Item is added to the default Conversation. This can happen in
     * several cases:
     * - When the client sends a `conversation.item.create` event.
     * - When the input audio buffer is committed. In this case the item will be a user message
     *   containing the audio from the buffer.
     * - When the model is generating a Response. In this case the `conversation.item.added` event
     *   will be sent when the model starts generating a specific Item, and thus it will not yet
     *   have any content (and `status` will be `in_progress`).
     *
     * The event will include the full content of the Item (except when model is generating a
     * Response) except for audio data, which can be retrieved separately with a
     * `conversation.item.retrieve` event if necessary.
     */
    fun conversationItemAdded(): Optional<ConversationItemAdded> =
        Optional.ofNullable(conversationItemAdded)

    /**
     * Returned when a conversation item is finalized.
     *
     * The event will include the full content of the Item except for audio data, which can be
     * retrieved separately with a `conversation.item.retrieve` event if needed.
     */
    fun conversationItemDone(): Optional<ConversationItemDone> =
        Optional.ofNullable(conversationItemDone)

    /** Returned when the server VAD timeout is triggered for the input audio buffer. */
    fun inputAudioBufferTimeoutTriggered(): Optional<InputAudioBufferTimeoutTriggered> =
        Optional.ofNullable(inputAudioBufferTimeoutTriggered)

    /** Returned when an input audio transcription segment is identified for an item. */
    fun conversationItemInputAudioTranscriptionSegment():
        Optional<ConversationItemInputAudioTranscriptionSegment> =
        Optional.ofNullable(conversationItemInputAudioTranscriptionSegment)

    /** Returned when listing MCP tools is in progress for an item. */
    fun mcpListToolsInProgress(): Optional<McpListToolsInProgress> =
        Optional.ofNullable(mcpListToolsInProgress)

    /** Returned when listing MCP tools has completed for an item. */
    fun mcpListToolsCompleted(): Optional<McpListToolsCompleted> =
        Optional.ofNullable(mcpListToolsCompleted)

    /** Returned when listing MCP tools has failed for an item. */
    fun mcpListToolsFailed(): Optional<McpListToolsFailed> = Optional.ofNullable(mcpListToolsFailed)

    /** Returned when MCP tool call arguments are updated during response generation. */
    fun responseMcpCallArgumentsDelta(): Optional<ResponseMcpCallArgumentsDelta> =
        Optional.ofNullable(responseMcpCallArgumentsDelta)

    /** Returned when MCP tool call arguments are finalized during response generation. */
    fun responseMcpCallArgumentsDone(): Optional<ResponseMcpCallArgumentsDone> =
        Optional.ofNullable(responseMcpCallArgumentsDone)

    /** Returned when an MCP tool call has started and is in progress. */
    fun responseMcpCallInProgress(): Optional<ResponseMcpCallInProgress> =
        Optional.ofNullable(responseMcpCallInProgress)

    /** Returned when an MCP tool call has completed successfully. */
    fun responseMcpCallCompleted(): Optional<ResponseMcpCallCompleted> =
        Optional.ofNullable(responseMcpCallCompleted)

    /** Returned when an MCP tool call has failed. */
    fun responseMcpCallFailed(): Optional<ResponseMcpCallFailed> =
        Optional.ofNullable(responseMcpCallFailed)

    fun isConversationCreated(): Boolean = conversationCreated != null

    fun isConversationItemCreated(): Boolean = conversationItemCreated != null

    fun isConversationItemDeleted(): Boolean = conversationItemDeleted != null

    fun isConversationItemInputAudioTranscriptionCompleted(): Boolean =
        conversationItemInputAudioTranscriptionCompleted != null

    fun isConversationItemInputAudioTranscriptionDelta(): Boolean =
        conversationItemInputAudioTranscriptionDelta != null

    fun isConversationItemInputAudioTranscriptionFailed(): Boolean =
        conversationItemInputAudioTranscriptionFailed != null

    fun isConversationItemRetrieved(): Boolean = conversationItemRetrieved != null

    fun isConversationItemTruncated(): Boolean = conversationItemTruncated != null

    fun isError(): Boolean = error != null

    fun isInputAudioBufferCleared(): Boolean = inputAudioBufferCleared != null

    fun isInputAudioBufferCommitted(): Boolean = inputAudioBufferCommitted != null

    fun isInputAudioBufferSpeechStarted(): Boolean = inputAudioBufferSpeechStarted != null

    fun isInputAudioBufferSpeechStopped(): Boolean = inputAudioBufferSpeechStopped != null

    fun isRateLimitsUpdated(): Boolean = rateLimitsUpdated != null

    fun isResponseOutputAudioDelta(): Boolean = responseOutputAudioDelta != null

    fun isResponseOutputAudioDone(): Boolean = responseOutputAudioDone != null

    fun isResponseOutputAudioTranscriptDelta(): Boolean = responseOutputAudioTranscriptDelta != null

    fun isResponseOutputAudioTranscriptDone(): Boolean = responseOutputAudioTranscriptDone != null

    fun isResponseContentPartAdded(): Boolean = responseContentPartAdded != null

    fun isResponseContentPartDone(): Boolean = responseContentPartDone != null

    fun isResponseCreated(): Boolean = responseCreated != null

    fun isResponseDone(): Boolean = responseDone != null

    fun isResponseFunctionCallArgumentsDelta(): Boolean = responseFunctionCallArgumentsDelta != null

    fun isResponseFunctionCallArgumentsDone(): Boolean = responseFunctionCallArgumentsDone != null

    fun isResponseOutputItemAdded(): Boolean = responseOutputItemAdded != null

    fun isResponseOutputItemDone(): Boolean = responseOutputItemDone != null

    fun isResponseOutputTextDelta(): Boolean = responseOutputTextDelta != null

    fun isResponseOutputTextDone(): Boolean = responseOutputTextDone != null

    fun isSessionCreated(): Boolean = sessionCreated != null

    fun isSessionUpdated(): Boolean = sessionUpdated != null

    fun isTranscriptionSessionUpdated(): Boolean = transcriptionSessionUpdated != null

    fun isTranscriptionSessionCreated(): Boolean = transcriptionSessionCreated != null

    fun isOutputAudioBufferStarted(): Boolean = outputAudioBufferStarted != null

    fun isOutputAudioBufferStopped(): Boolean = outputAudioBufferStopped != null

    fun isOutputAudioBufferCleared(): Boolean = outputAudioBufferCleared != null

    fun isConversationItemAdded(): Boolean = conversationItemAdded != null

    fun isConversationItemDone(): Boolean = conversationItemDone != null

    fun isInputAudioBufferTimeoutTriggered(): Boolean = inputAudioBufferTimeoutTriggered != null

    fun isConversationItemInputAudioTranscriptionSegment(): Boolean =
        conversationItemInputAudioTranscriptionSegment != null

    fun isMcpListToolsInProgress(): Boolean = mcpListToolsInProgress != null

    fun isMcpListToolsCompleted(): Boolean = mcpListToolsCompleted != null

    fun isMcpListToolsFailed(): Boolean = mcpListToolsFailed != null

    fun isResponseMcpCallArgumentsDelta(): Boolean = responseMcpCallArgumentsDelta != null

    fun isResponseMcpCallArgumentsDone(): Boolean = responseMcpCallArgumentsDone != null

    fun isResponseMcpCallInProgress(): Boolean = responseMcpCallInProgress != null

    fun isResponseMcpCallCompleted(): Boolean = responseMcpCallCompleted != null

    fun isResponseMcpCallFailed(): Boolean = responseMcpCallFailed != null

    /** Returned when a conversation is created. Emitted right after session creation. */
    fun asConversationCreated(): ConversationCreatedEvent =
        conversationCreated.getOrThrow("conversationCreated")

    /**
     * Returned when a conversation item is created. There are several scenarios that produce this
     * event:
     * - The server is generating a Response, which if successful will produce either one or two
     *   Items, which will be of type `message` (role `assistant`) or type `function_call`.
     * - The input audio buffer has been committed, either by the client or the server (in
     *   `server_vad` mode). The server will take the content of the input audio buffer and add it
     *   to a new user message Item.
     * - The client has sent a `conversation.item.create` event to add a new Item to the
     *   Conversation.
     */
    fun asConversationItemCreated(): ConversationItemCreatedEvent =
        conversationItemCreated.getOrThrow("conversationItemCreated")

    /**
     * Returned when an item in the conversation is deleted by the client with a
     * `conversation.item.delete` event. This event is used to synchronize the server's
     * understanding of the conversation history with the client's view.
     */
    fun asConversationItemDeleted(): ConversationItemDeletedEvent =
        conversationItemDeleted.getOrThrow("conversationItemDeleted")

    /**
     * This event is the output of audio transcription for user audio written to the user audio
     * buffer. Transcription begins when the input audio buffer is committed by the client or server
     * (when VAD is enabled). Transcription runs asynchronously with Response creation, so this
     * event may come before or after the Response events.
     *
     * Realtime API models accept audio natively, and thus input transcription is a separate process
     * run on a separate ASR (Automatic Speech Recognition) model. The transcript may diverge
     * somewhat from the model's interpretation, and should be treated as a rough guide.
     */
    fun asConversationItemInputAudioTranscriptionCompleted():
        ConversationItemInputAudioTranscriptionCompletedEvent =
        conversationItemInputAudioTranscriptionCompleted.getOrThrow(
            "conversationItemInputAudioTranscriptionCompleted"
        )

    /**
     * Returned when the text value of an input audio transcription content part is updated with
     * incremental transcription results.
     */
    fun asConversationItemInputAudioTranscriptionDelta():
        ConversationItemInputAudioTranscriptionDeltaEvent =
        conversationItemInputAudioTranscriptionDelta.getOrThrow(
            "conversationItemInputAudioTranscriptionDelta"
        )

    /**
     * Returned when input audio transcription is configured, and a transcription request for a user
     * message failed. These events are separate from other `error` events so that the client can
     * identify the related Item.
     */
    fun asConversationItemInputAudioTranscriptionFailed():
        ConversationItemInputAudioTranscriptionFailedEvent =
        conversationItemInputAudioTranscriptionFailed.getOrThrow(
            "conversationItemInputAudioTranscriptionFailed"
        )

    /**
     * Returned when a conversation item is retrieved with `conversation.item.retrieve`. This is
     * provided as a way to fetch the server's representation of an item, for example to get access
     * to the post-processed audio data after noise cancellation and VAD. It includes the full
     * content of the Item, including audio data.
     */
    fun asConversationItemRetrieved(): ConversationItemRetrieved =
        conversationItemRetrieved.getOrThrow("conversationItemRetrieved")

    /**
     * Returned when an earlier assistant audio message item is truncated by the client with a
     * `conversation.item.truncate` event. This event is used to synchronize the server's
     * understanding of the audio with the client's playback.
     *
     * This action will truncate the audio and remove the server-side text transcript to ensure
     * there is no text in the context that hasn't been heard by the user.
     */
    fun asConversationItemTruncated(): ConversationItemTruncatedEvent =
        conversationItemTruncated.getOrThrow("conversationItemTruncated")

    /**
     * Returned when an error occurs, which could be a client problem or a server problem. Most
     * errors are recoverable and the session will stay open, we recommend to implementors to
     * monitor and log error messages by default.
     */
    fun asError(): RealtimeErrorEvent = error.getOrThrow("error")

    /**
     * Returned when the input audio buffer is cleared by the client with a
     * `input_audio_buffer.clear` event.
     */
    fun asInputAudioBufferCleared(): InputAudioBufferClearedEvent =
        inputAudioBufferCleared.getOrThrow("inputAudioBufferCleared")

    /**
     * Returned when an input audio buffer is committed, either by the client or automatically in
     * server VAD mode. The `item_id` property is the ID of the user message item that will be
     * created, thus a `conversation.item.created` event will also be sent to the client.
     */
    fun asInputAudioBufferCommitted(): InputAudioBufferCommittedEvent =
        inputAudioBufferCommitted.getOrThrow("inputAudioBufferCommitted")

    /**
     * Sent by the server when in `server_vad` mode to indicate that speech has been detected in the
     * audio buffer. This can happen any time audio is added to the buffer (unless speech is already
     * detected). The client may want to use this event to interrupt audio playback or provide
     * visual feedback to the user.
     *
     * The client should expect to receive a `input_audio_buffer.speech_stopped` event when speech
     * stops. The `item_id` property is the ID of the user message item that will be created when
     * speech stops and will also be included in the `input_audio_buffer.speech_stopped` event
     * (unless the client manually commits the audio buffer during VAD activation).
     */
    fun asInputAudioBufferSpeechStarted(): InputAudioBufferSpeechStartedEvent =
        inputAudioBufferSpeechStarted.getOrThrow("inputAudioBufferSpeechStarted")

    /**
     * Returned in `server_vad` mode when the server detects the end of speech in the audio buffer.
     * The server will also send an `conversation.item.created` event with the user message item
     * that is created from the audio buffer.
     */
    fun asInputAudioBufferSpeechStopped(): InputAudioBufferSpeechStoppedEvent =
        inputAudioBufferSpeechStopped.getOrThrow("inputAudioBufferSpeechStopped")

    /**
     * Emitted at the beginning of a Response to indicate the updated rate limits. When a Response
     * is created some tokens will be "reserved" for the output tokens, the rate limits shown here
     * reflect that reservation, which is then adjusted accordingly once the Response is completed.
     */
    fun asRateLimitsUpdated(): RateLimitsUpdatedEvent =
        rateLimitsUpdated.getOrThrow("rateLimitsUpdated")

    /** Returned when the model-generated audio is updated. */
    fun asResponseOutputAudioDelta(): ResponseAudioDeltaEvent =
        responseOutputAudioDelta.getOrThrow("responseOutputAudioDelta")

    /**
     * Returned when the model-generated audio is done. Also emitted when a Response is interrupted,
     * incomplete, or cancelled.
     */
    fun asResponseOutputAudioDone(): ResponseAudioDoneEvent =
        responseOutputAudioDone.getOrThrow("responseOutputAudioDone")

    /** Returned when the model-generated transcription of audio output is updated. */
    fun asResponseOutputAudioTranscriptDelta(): ResponseAudioTranscriptDeltaEvent =
        responseOutputAudioTranscriptDelta.getOrThrow("responseOutputAudioTranscriptDelta")

    /**
     * Returned when the model-generated transcription of audio output is done streaming. Also
     * emitted when a Response is interrupted, incomplete, or cancelled.
     */
    fun asResponseOutputAudioTranscriptDone(): ResponseAudioTranscriptDoneEvent =
        responseOutputAudioTranscriptDone.getOrThrow("responseOutputAudioTranscriptDone")

    /**
     * Returned when a new content part is added to an assistant message item during response
     * generation.
     */
    fun asResponseContentPartAdded(): ResponseContentPartAddedEvent =
        responseContentPartAdded.getOrThrow("responseContentPartAdded")

    /**
     * Returned when a content part is done streaming in an assistant message item. Also emitted
     * when a Response is interrupted, incomplete, or cancelled.
     */
    fun asResponseContentPartDone(): ResponseContentPartDoneEvent =
        responseContentPartDone.getOrThrow("responseContentPartDone")

    /**
     * Returned when a new Response is created. The first event of response creation, where the
     * response is in an initial state of `in_progress`.
     */
    fun asResponseCreated(): ResponseCreatedEvent = responseCreated.getOrThrow("responseCreated")

    /**
     * Returned when a Response is done streaming. Always emitted, no matter the final state. The
     * Response object included in the `response.done` event will include all output Items in the
     * Response but will omit the raw audio data.
     *
     * Clients should check the `status` field of the Response to determine if it was successful
     * (`completed`) or if there was another outcome: `cancelled`, `failed`, or `incomplete`.
     *
     * A response will contain all output items that were generated during the response, excluding
     * any audio content.
     */
    fun asResponseDone(): ResponseDoneEvent = responseDone.getOrThrow("responseDone")

    /** Returned when the model-generated function call arguments are updated. */
    fun asResponseFunctionCallArgumentsDelta(): ResponseFunctionCallArgumentsDeltaEvent =
        responseFunctionCallArgumentsDelta.getOrThrow("responseFunctionCallArgumentsDelta")

    /**
     * Returned when the model-generated function call arguments are done streaming. Also emitted
     * when a Response is interrupted, incomplete, or cancelled.
     */
    fun asResponseFunctionCallArgumentsDone(): ResponseFunctionCallArgumentsDoneEvent =
        responseFunctionCallArgumentsDone.getOrThrow("responseFunctionCallArgumentsDone")

    /** Returned when a new Item is created during Response generation. */
    fun asResponseOutputItemAdded(): ResponseOutputItemAddedEvent =
        responseOutputItemAdded.getOrThrow("responseOutputItemAdded")

    /**
     * Returned when an Item is done streaming. Also emitted when a Response is interrupted,
     * incomplete, or cancelled.
     */
    fun asResponseOutputItemDone(): ResponseOutputItemDoneEvent =
        responseOutputItemDone.getOrThrow("responseOutputItemDone")

    /** Returned when the text value of an "output_text" content part is updated. */
    fun asResponseOutputTextDelta(): ResponseTextDeltaEvent =
        responseOutputTextDelta.getOrThrow("responseOutputTextDelta")

    /**
     * Returned when the text value of an "output_text" content part is done streaming. Also emitted
     * when a Response is interrupted, incomplete, or cancelled.
     */
    fun asResponseOutputTextDone(): ResponseTextDoneEvent =
        responseOutputTextDone.getOrThrow("responseOutputTextDone")

    /**
     * Returned when a Session is created. Emitted automatically when a new connection is
     * established as the first server event. This event will contain the default Session
     * configuration.
     */
    fun asSessionCreated(): SessionCreatedEvent = sessionCreated.getOrThrow("sessionCreated")

    /**
     * Returned when a session is updated with a `session.update` event, unless there is an error.
     */
    fun asSessionUpdated(): SessionUpdatedEvent = sessionUpdated.getOrThrow("sessionUpdated")

    /**
     * Returned when a transcription session is updated with a `transcription_session.update` event,
     * unless there is an error.
     */
    fun asTranscriptionSessionUpdated(): TranscriptionSessionUpdatedEvent =
        transcriptionSessionUpdated.getOrThrow("transcriptionSessionUpdated")

    /** Returned when a transcription session is created. */
    fun asTranscriptionSessionCreated(): TranscriptionSessionCreated =
        transcriptionSessionCreated.getOrThrow("transcriptionSessionCreated")

    /**
     * **WebRTC Only:** Emitted when the server begins streaming audio to the client. This event is
     * emitted after an audio content part has been added (`response.content_part.added`) to the
     * response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun asOutputAudioBufferStarted(): OutputAudioBufferStarted =
        outputAudioBufferStarted.getOrThrow("outputAudioBufferStarted")

    /**
     * **WebRTC Only:** Emitted when the output audio buffer has been completely drained on the
     * server, and no more audio is forthcoming. This event is emitted after the full response data
     * has been sent to the client (`response.done`).
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun asOutputAudioBufferStopped(): OutputAudioBufferStopped =
        outputAudioBufferStopped.getOrThrow("outputAudioBufferStopped")

    /**
     * **WebRTC Only:** Emitted when the output audio buffer is cleared. This happens either in VAD
     * mode when the user has interrupted (`input_audio_buffer.speech_started`), or when the client
     * has emitted the `output_audio_buffer.clear` event to manually cut off the current audio
     * response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun asOutputAudioBufferCleared(): OutputAudioBufferCleared =
        outputAudioBufferCleared.getOrThrow("outputAudioBufferCleared")

    /**
     * Sent by the server when an Item is added to the default Conversation. This can happen in
     * several cases:
     * - When the client sends a `conversation.item.create` event.
     * - When the input audio buffer is committed. In this case the item will be a user message
     *   containing the audio from the buffer.
     * - When the model is generating a Response. In this case the `conversation.item.added` event
     *   will be sent when the model starts generating a specific Item, and thus it will not yet
     *   have any content (and `status` will be `in_progress`).
     *
     * The event will include the full content of the Item (except when model is generating a
     * Response) except for audio data, which can be retrieved separately with a
     * `conversation.item.retrieve` event if necessary.
     */
    fun asConversationItemAdded(): ConversationItemAdded =
        conversationItemAdded.getOrThrow("conversationItemAdded")

    /**
     * Returned when a conversation item is finalized.
     *
     * The event will include the full content of the Item except for audio data, which can be
     * retrieved separately with a `conversation.item.retrieve` event if needed.
     */
    fun asConversationItemDone(): ConversationItemDone =
        conversationItemDone.getOrThrow("conversationItemDone")

    /** Returned when the server VAD timeout is triggered for the input audio buffer. */
    fun asInputAudioBufferTimeoutTriggered(): InputAudioBufferTimeoutTriggered =
        inputAudioBufferTimeoutTriggered.getOrThrow("inputAudioBufferTimeoutTriggered")

    /** Returned when an input audio transcription segment is identified for an item. */
    fun asConversationItemInputAudioTranscriptionSegment():
        ConversationItemInputAudioTranscriptionSegment =
        conversationItemInputAudioTranscriptionSegment.getOrThrow(
            "conversationItemInputAudioTranscriptionSegment"
        )

    /** Returned when listing MCP tools is in progress for an item. */
    fun asMcpListToolsInProgress(): McpListToolsInProgress =
        mcpListToolsInProgress.getOrThrow("mcpListToolsInProgress")

    /** Returned when listing MCP tools has completed for an item. */
    fun asMcpListToolsCompleted(): McpListToolsCompleted =
        mcpListToolsCompleted.getOrThrow("mcpListToolsCompleted")

    /** Returned when listing MCP tools has failed for an item. */
    fun asMcpListToolsFailed(): McpListToolsFailed =
        mcpListToolsFailed.getOrThrow("mcpListToolsFailed")

    /** Returned when MCP tool call arguments are updated during response generation. */
    fun asResponseMcpCallArgumentsDelta(): ResponseMcpCallArgumentsDelta =
        responseMcpCallArgumentsDelta.getOrThrow("responseMcpCallArgumentsDelta")

    /** Returned when MCP tool call arguments are finalized during response generation. */
    fun asResponseMcpCallArgumentsDone(): ResponseMcpCallArgumentsDone =
        responseMcpCallArgumentsDone.getOrThrow("responseMcpCallArgumentsDone")

    /** Returned when an MCP tool call has started and is in progress. */
    fun asResponseMcpCallInProgress(): ResponseMcpCallInProgress =
        responseMcpCallInProgress.getOrThrow("responseMcpCallInProgress")

    /** Returned when an MCP tool call has completed successfully. */
    fun asResponseMcpCallCompleted(): ResponseMcpCallCompleted =
        responseMcpCallCompleted.getOrThrow("responseMcpCallCompleted")

    /** Returned when an MCP tool call has failed. */
    fun asResponseMcpCallFailed(): ResponseMcpCallFailed =
        responseMcpCallFailed.getOrThrow("responseMcpCallFailed")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            conversationCreated != null -> visitor.visitConversationCreated(conversationCreated)
            conversationItemCreated != null ->
                visitor.visitConversationItemCreated(conversationItemCreated)
            conversationItemDeleted != null ->
                visitor.visitConversationItemDeleted(conversationItemDeleted)
            conversationItemInputAudioTranscriptionCompleted != null ->
                visitor.visitConversationItemInputAudioTranscriptionCompleted(
                    conversationItemInputAudioTranscriptionCompleted
                )
            conversationItemInputAudioTranscriptionDelta != null ->
                visitor.visitConversationItemInputAudioTranscriptionDelta(
                    conversationItemInputAudioTranscriptionDelta
                )
            conversationItemInputAudioTranscriptionFailed != null ->
                visitor.visitConversationItemInputAudioTranscriptionFailed(
                    conversationItemInputAudioTranscriptionFailed
                )
            conversationItemRetrieved != null ->
                visitor.visitConversationItemRetrieved(conversationItemRetrieved)
            conversationItemTruncated != null ->
                visitor.visitConversationItemTruncated(conversationItemTruncated)
            error != null -> visitor.visitError(error)
            inputAudioBufferCleared != null ->
                visitor.visitInputAudioBufferCleared(inputAudioBufferCleared)
            inputAudioBufferCommitted != null ->
                visitor.visitInputAudioBufferCommitted(inputAudioBufferCommitted)
            inputAudioBufferSpeechStarted != null ->
                visitor.visitInputAudioBufferSpeechStarted(inputAudioBufferSpeechStarted)
            inputAudioBufferSpeechStopped != null ->
                visitor.visitInputAudioBufferSpeechStopped(inputAudioBufferSpeechStopped)
            rateLimitsUpdated != null -> visitor.visitRateLimitsUpdated(rateLimitsUpdated)
            responseOutputAudioDelta != null ->
                visitor.visitResponseOutputAudioDelta(responseOutputAudioDelta)
            responseOutputAudioDone != null ->
                visitor.visitResponseOutputAudioDone(responseOutputAudioDone)
            responseOutputAudioTranscriptDelta != null ->
                visitor.visitResponseOutputAudioTranscriptDelta(responseOutputAudioTranscriptDelta)
            responseOutputAudioTranscriptDone != null ->
                visitor.visitResponseOutputAudioTranscriptDone(responseOutputAudioTranscriptDone)
            responseContentPartAdded != null ->
                visitor.visitResponseContentPartAdded(responseContentPartAdded)
            responseContentPartDone != null ->
                visitor.visitResponseContentPartDone(responseContentPartDone)
            responseCreated != null -> visitor.visitResponseCreated(responseCreated)
            responseDone != null -> visitor.visitResponseDone(responseDone)
            responseFunctionCallArgumentsDelta != null ->
                visitor.visitResponseFunctionCallArgumentsDelta(responseFunctionCallArgumentsDelta)
            responseFunctionCallArgumentsDone != null ->
                visitor.visitResponseFunctionCallArgumentsDone(responseFunctionCallArgumentsDone)
            responseOutputItemAdded != null ->
                visitor.visitResponseOutputItemAdded(responseOutputItemAdded)
            responseOutputItemDone != null ->
                visitor.visitResponseOutputItemDone(responseOutputItemDone)
            responseOutputTextDelta != null ->
                visitor.visitResponseOutputTextDelta(responseOutputTextDelta)
            responseOutputTextDone != null ->
                visitor.visitResponseOutputTextDone(responseOutputTextDone)
            sessionCreated != null -> visitor.visitSessionCreated(sessionCreated)
            sessionUpdated != null -> visitor.visitSessionUpdated(sessionUpdated)
            transcriptionSessionUpdated != null ->
                visitor.visitTranscriptionSessionUpdated(transcriptionSessionUpdated)
            transcriptionSessionCreated != null ->
                visitor.visitTranscriptionSessionCreated(transcriptionSessionCreated)
            outputAudioBufferStarted != null ->
                visitor.visitOutputAudioBufferStarted(outputAudioBufferStarted)
            outputAudioBufferStopped != null ->
                visitor.visitOutputAudioBufferStopped(outputAudioBufferStopped)
            outputAudioBufferCleared != null ->
                visitor.visitOutputAudioBufferCleared(outputAudioBufferCleared)
            conversationItemAdded != null ->
                visitor.visitConversationItemAdded(conversationItemAdded)
            conversationItemDone != null -> visitor.visitConversationItemDone(conversationItemDone)
            inputAudioBufferTimeoutTriggered != null ->
                visitor.visitInputAudioBufferTimeoutTriggered(inputAudioBufferTimeoutTriggered)
            conversationItemInputAudioTranscriptionSegment != null ->
                visitor.visitConversationItemInputAudioTranscriptionSegment(
                    conversationItemInputAudioTranscriptionSegment
                )
            mcpListToolsInProgress != null ->
                visitor.visitMcpListToolsInProgress(mcpListToolsInProgress)
            mcpListToolsCompleted != null ->
                visitor.visitMcpListToolsCompleted(mcpListToolsCompleted)
            mcpListToolsFailed != null -> visitor.visitMcpListToolsFailed(mcpListToolsFailed)
            responseMcpCallArgumentsDelta != null ->
                visitor.visitResponseMcpCallArgumentsDelta(responseMcpCallArgumentsDelta)
            responseMcpCallArgumentsDone != null ->
                visitor.visitResponseMcpCallArgumentsDone(responseMcpCallArgumentsDone)
            responseMcpCallInProgress != null ->
                visitor.visitResponseMcpCallInProgress(responseMcpCallInProgress)
            responseMcpCallCompleted != null ->
                visitor.visitResponseMcpCallCompleted(responseMcpCallCompleted)
            responseMcpCallFailed != null ->
                visitor.visitResponseMcpCallFailed(responseMcpCallFailed)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeServerEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitConversationCreated(
                    conversationCreated: ConversationCreatedEvent
                ) {
                    conversationCreated.validate()
                }

                override fun visitConversationItemCreated(
                    conversationItemCreated: ConversationItemCreatedEvent
                ) {
                    conversationItemCreated.validate()
                }

                override fun visitConversationItemDeleted(
                    conversationItemDeleted: ConversationItemDeletedEvent
                ) {
                    conversationItemDeleted.validate()
                }

                override fun visitConversationItemInputAudioTranscriptionCompleted(
                    conversationItemInputAudioTranscriptionCompleted:
                        ConversationItemInputAudioTranscriptionCompletedEvent
                ) {
                    conversationItemInputAudioTranscriptionCompleted.validate()
                }

                override fun visitConversationItemInputAudioTranscriptionDelta(
                    conversationItemInputAudioTranscriptionDelta:
                        ConversationItemInputAudioTranscriptionDeltaEvent
                ) {
                    conversationItemInputAudioTranscriptionDelta.validate()
                }

                override fun visitConversationItemInputAudioTranscriptionFailed(
                    conversationItemInputAudioTranscriptionFailed:
                        ConversationItemInputAudioTranscriptionFailedEvent
                ) {
                    conversationItemInputAudioTranscriptionFailed.validate()
                }

                override fun visitConversationItemRetrieved(
                    conversationItemRetrieved: ConversationItemRetrieved
                ) {
                    conversationItemRetrieved.validate()
                }

                override fun visitConversationItemTruncated(
                    conversationItemTruncated: ConversationItemTruncatedEvent
                ) {
                    conversationItemTruncated.validate()
                }

                override fun visitError(error: RealtimeErrorEvent) {
                    error.validate()
                }

                override fun visitInputAudioBufferCleared(
                    inputAudioBufferCleared: InputAudioBufferClearedEvent
                ) {
                    inputAudioBufferCleared.validate()
                }

                override fun visitInputAudioBufferCommitted(
                    inputAudioBufferCommitted: InputAudioBufferCommittedEvent
                ) {
                    inputAudioBufferCommitted.validate()
                }

                override fun visitInputAudioBufferSpeechStarted(
                    inputAudioBufferSpeechStarted: InputAudioBufferSpeechStartedEvent
                ) {
                    inputAudioBufferSpeechStarted.validate()
                }

                override fun visitInputAudioBufferSpeechStopped(
                    inputAudioBufferSpeechStopped: InputAudioBufferSpeechStoppedEvent
                ) {
                    inputAudioBufferSpeechStopped.validate()
                }

                override fun visitRateLimitsUpdated(rateLimitsUpdated: RateLimitsUpdatedEvent) {
                    rateLimitsUpdated.validate()
                }

                override fun visitResponseOutputAudioDelta(
                    responseOutputAudioDelta: ResponseAudioDeltaEvent
                ) {
                    responseOutputAudioDelta.validate()
                }

                override fun visitResponseOutputAudioDone(
                    responseOutputAudioDone: ResponseAudioDoneEvent
                ) {
                    responseOutputAudioDone.validate()
                }

                override fun visitResponseOutputAudioTranscriptDelta(
                    responseOutputAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) {
                    responseOutputAudioTranscriptDelta.validate()
                }

                override fun visitResponseOutputAudioTranscriptDone(
                    responseOutputAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) {
                    responseOutputAudioTranscriptDone.validate()
                }

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: ResponseContentPartAddedEvent
                ) {
                    responseContentPartAdded.validate()
                }

                override fun visitResponseContentPartDone(
                    responseContentPartDone: ResponseContentPartDoneEvent
                ) {
                    responseContentPartDone.validate()
                }

                override fun visitResponseCreated(responseCreated: ResponseCreatedEvent) {
                    responseCreated.validate()
                }

                override fun visitResponseDone(responseDone: ResponseDoneEvent) {
                    responseDone.validate()
                }

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) {
                    responseFunctionCallArgumentsDelta.validate()
                }

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) {
                    responseFunctionCallArgumentsDone.validate()
                }

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: ResponseOutputItemAddedEvent
                ) {
                    responseOutputItemAdded.validate()
                }

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: ResponseOutputItemDoneEvent
                ) {
                    responseOutputItemDone.validate()
                }

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: ResponseTextDeltaEvent
                ) {
                    responseOutputTextDelta.validate()
                }

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: ResponseTextDoneEvent
                ) {
                    responseOutputTextDone.validate()
                }

                override fun visitSessionCreated(sessionCreated: SessionCreatedEvent) {
                    sessionCreated.validate()
                }

                override fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent) {
                    sessionUpdated.validate()
                }

                override fun visitTranscriptionSessionUpdated(
                    transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent
                ) {
                    transcriptionSessionUpdated.validate()
                }

                override fun visitTranscriptionSessionCreated(
                    transcriptionSessionCreated: TranscriptionSessionCreated
                ) {
                    transcriptionSessionCreated.validate()
                }

                override fun visitOutputAudioBufferStarted(
                    outputAudioBufferStarted: OutputAudioBufferStarted
                ) {
                    outputAudioBufferStarted.validate()
                }

                override fun visitOutputAudioBufferStopped(
                    outputAudioBufferStopped: OutputAudioBufferStopped
                ) {
                    outputAudioBufferStopped.validate()
                }

                override fun visitOutputAudioBufferCleared(
                    outputAudioBufferCleared: OutputAudioBufferCleared
                ) {
                    outputAudioBufferCleared.validate()
                }

                override fun visitConversationItemAdded(
                    conversationItemAdded: ConversationItemAdded
                ) {
                    conversationItemAdded.validate()
                }

                override fun visitConversationItemDone(conversationItemDone: ConversationItemDone) {
                    conversationItemDone.validate()
                }

                override fun visitInputAudioBufferTimeoutTriggered(
                    inputAudioBufferTimeoutTriggered: InputAudioBufferTimeoutTriggered
                ) {
                    inputAudioBufferTimeoutTriggered.validate()
                }

                override fun visitConversationItemInputAudioTranscriptionSegment(
                    conversationItemInputAudioTranscriptionSegment:
                        ConversationItemInputAudioTranscriptionSegment
                ) {
                    conversationItemInputAudioTranscriptionSegment.validate()
                }

                override fun visitMcpListToolsInProgress(
                    mcpListToolsInProgress: McpListToolsInProgress
                ) {
                    mcpListToolsInProgress.validate()
                }

                override fun visitMcpListToolsCompleted(
                    mcpListToolsCompleted: McpListToolsCompleted
                ) {
                    mcpListToolsCompleted.validate()
                }

                override fun visitMcpListToolsFailed(mcpListToolsFailed: McpListToolsFailed) {
                    mcpListToolsFailed.validate()
                }

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDelta
                ) {
                    responseMcpCallArgumentsDelta.validate()
                }

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDone
                ) {
                    responseMcpCallArgumentsDone.validate()
                }

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: ResponseMcpCallInProgress
                ) {
                    responseMcpCallInProgress.validate()
                }

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: ResponseMcpCallCompleted
                ) {
                    responseMcpCallCompleted.validate()
                }

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: ResponseMcpCallFailed
                ) {
                    responseMcpCallFailed.validate()
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
                override fun visitConversationCreated(
                    conversationCreated: ConversationCreatedEvent
                ) = conversationCreated.validity()

                override fun visitConversationItemCreated(
                    conversationItemCreated: ConversationItemCreatedEvent
                ) = conversationItemCreated.validity()

                override fun visitConversationItemDeleted(
                    conversationItemDeleted: ConversationItemDeletedEvent
                ) = conversationItemDeleted.validity()

                override fun visitConversationItemInputAudioTranscriptionCompleted(
                    conversationItemInputAudioTranscriptionCompleted:
                        ConversationItemInputAudioTranscriptionCompletedEvent
                ) = conversationItemInputAudioTranscriptionCompleted.validity()

                override fun visitConversationItemInputAudioTranscriptionDelta(
                    conversationItemInputAudioTranscriptionDelta:
                        ConversationItemInputAudioTranscriptionDeltaEvent
                ) = conversationItemInputAudioTranscriptionDelta.validity()

                override fun visitConversationItemInputAudioTranscriptionFailed(
                    conversationItemInputAudioTranscriptionFailed:
                        ConversationItemInputAudioTranscriptionFailedEvent
                ) = conversationItemInputAudioTranscriptionFailed.validity()

                override fun visitConversationItemRetrieved(
                    conversationItemRetrieved: ConversationItemRetrieved
                ) = conversationItemRetrieved.validity()

                override fun visitConversationItemTruncated(
                    conversationItemTruncated: ConversationItemTruncatedEvent
                ) = conversationItemTruncated.validity()

                override fun visitError(error: RealtimeErrorEvent) = error.validity()

                override fun visitInputAudioBufferCleared(
                    inputAudioBufferCleared: InputAudioBufferClearedEvent
                ) = inputAudioBufferCleared.validity()

                override fun visitInputAudioBufferCommitted(
                    inputAudioBufferCommitted: InputAudioBufferCommittedEvent
                ) = inputAudioBufferCommitted.validity()

                override fun visitInputAudioBufferSpeechStarted(
                    inputAudioBufferSpeechStarted: InputAudioBufferSpeechStartedEvent
                ) = inputAudioBufferSpeechStarted.validity()

                override fun visitInputAudioBufferSpeechStopped(
                    inputAudioBufferSpeechStopped: InputAudioBufferSpeechStoppedEvent
                ) = inputAudioBufferSpeechStopped.validity()

                override fun visitRateLimitsUpdated(rateLimitsUpdated: RateLimitsUpdatedEvent) =
                    rateLimitsUpdated.validity()

                override fun visitResponseOutputAudioDelta(
                    responseOutputAudioDelta: ResponseAudioDeltaEvent
                ) = responseOutputAudioDelta.validity()

                override fun visitResponseOutputAudioDone(
                    responseOutputAudioDone: ResponseAudioDoneEvent
                ) = responseOutputAudioDone.validity()

                override fun visitResponseOutputAudioTranscriptDelta(
                    responseOutputAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) = responseOutputAudioTranscriptDelta.validity()

                override fun visitResponseOutputAudioTranscriptDone(
                    responseOutputAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) = responseOutputAudioTranscriptDone.validity()

                override fun visitResponseContentPartAdded(
                    responseContentPartAdded: ResponseContentPartAddedEvent
                ) = responseContentPartAdded.validity()

                override fun visitResponseContentPartDone(
                    responseContentPartDone: ResponseContentPartDoneEvent
                ) = responseContentPartDone.validity()

                override fun visitResponseCreated(responseCreated: ResponseCreatedEvent) =
                    responseCreated.validity()

                override fun visitResponseDone(responseDone: ResponseDoneEvent) =
                    responseDone.validity()

                override fun visitResponseFunctionCallArgumentsDelta(
                    responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
                ) = responseFunctionCallArgumentsDelta.validity()

                override fun visitResponseFunctionCallArgumentsDone(
                    responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
                ) = responseFunctionCallArgumentsDone.validity()

                override fun visitResponseOutputItemAdded(
                    responseOutputItemAdded: ResponseOutputItemAddedEvent
                ) = responseOutputItemAdded.validity()

                override fun visitResponseOutputItemDone(
                    responseOutputItemDone: ResponseOutputItemDoneEvent
                ) = responseOutputItemDone.validity()

                override fun visitResponseOutputTextDelta(
                    responseOutputTextDelta: ResponseTextDeltaEvent
                ) = responseOutputTextDelta.validity()

                override fun visitResponseOutputTextDone(
                    responseOutputTextDone: ResponseTextDoneEvent
                ) = responseOutputTextDone.validity()

                override fun visitSessionCreated(sessionCreated: SessionCreatedEvent) =
                    sessionCreated.validity()

                override fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent) =
                    sessionUpdated.validity()

                override fun visitTranscriptionSessionUpdated(
                    transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent
                ) = transcriptionSessionUpdated.validity()

                override fun visitTranscriptionSessionCreated(
                    transcriptionSessionCreated: TranscriptionSessionCreated
                ) = transcriptionSessionCreated.validity()

                override fun visitOutputAudioBufferStarted(
                    outputAudioBufferStarted: OutputAudioBufferStarted
                ) = outputAudioBufferStarted.validity()

                override fun visitOutputAudioBufferStopped(
                    outputAudioBufferStopped: OutputAudioBufferStopped
                ) = outputAudioBufferStopped.validity()

                override fun visitOutputAudioBufferCleared(
                    outputAudioBufferCleared: OutputAudioBufferCleared
                ) = outputAudioBufferCleared.validity()

                override fun visitConversationItemAdded(
                    conversationItemAdded: ConversationItemAdded
                ) = conversationItemAdded.validity()

                override fun visitConversationItemDone(conversationItemDone: ConversationItemDone) =
                    conversationItemDone.validity()

                override fun visitInputAudioBufferTimeoutTriggered(
                    inputAudioBufferTimeoutTriggered: InputAudioBufferTimeoutTriggered
                ) = inputAudioBufferTimeoutTriggered.validity()

                override fun visitConversationItemInputAudioTranscriptionSegment(
                    conversationItemInputAudioTranscriptionSegment:
                        ConversationItemInputAudioTranscriptionSegment
                ) = conversationItemInputAudioTranscriptionSegment.validity()

                override fun visitMcpListToolsInProgress(
                    mcpListToolsInProgress: McpListToolsInProgress
                ) = mcpListToolsInProgress.validity()

                override fun visitMcpListToolsCompleted(
                    mcpListToolsCompleted: McpListToolsCompleted
                ) = mcpListToolsCompleted.validity()

                override fun visitMcpListToolsFailed(mcpListToolsFailed: McpListToolsFailed) =
                    mcpListToolsFailed.validity()

                override fun visitResponseMcpCallArgumentsDelta(
                    responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDelta
                ) = responseMcpCallArgumentsDelta.validity()

                override fun visitResponseMcpCallArgumentsDone(
                    responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDone
                ) = responseMcpCallArgumentsDone.validity()

                override fun visitResponseMcpCallInProgress(
                    responseMcpCallInProgress: ResponseMcpCallInProgress
                ) = responseMcpCallInProgress.validity()

                override fun visitResponseMcpCallCompleted(
                    responseMcpCallCompleted: ResponseMcpCallCompleted
                ) = responseMcpCallCompleted.validity()

                override fun visitResponseMcpCallFailed(
                    responseMcpCallFailed: ResponseMcpCallFailed
                ) = responseMcpCallFailed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeServerEvent &&
            conversationCreated == other.conversationCreated &&
            conversationItemCreated == other.conversationItemCreated &&
            conversationItemDeleted == other.conversationItemDeleted &&
            conversationItemInputAudioTranscriptionCompleted ==
                other.conversationItemInputAudioTranscriptionCompleted &&
            conversationItemInputAudioTranscriptionDelta ==
                other.conversationItemInputAudioTranscriptionDelta &&
            conversationItemInputAudioTranscriptionFailed ==
                other.conversationItemInputAudioTranscriptionFailed &&
            conversationItemRetrieved == other.conversationItemRetrieved &&
            conversationItemTruncated == other.conversationItemTruncated &&
            error == other.error &&
            inputAudioBufferCleared == other.inputAudioBufferCleared &&
            inputAudioBufferCommitted == other.inputAudioBufferCommitted &&
            inputAudioBufferSpeechStarted == other.inputAudioBufferSpeechStarted &&
            inputAudioBufferSpeechStopped == other.inputAudioBufferSpeechStopped &&
            rateLimitsUpdated == other.rateLimitsUpdated &&
            responseOutputAudioDelta == other.responseOutputAudioDelta &&
            responseOutputAudioDone == other.responseOutputAudioDone &&
            responseOutputAudioTranscriptDelta == other.responseOutputAudioTranscriptDelta &&
            responseOutputAudioTranscriptDone == other.responseOutputAudioTranscriptDone &&
            responseContentPartAdded == other.responseContentPartAdded &&
            responseContentPartDone == other.responseContentPartDone &&
            responseCreated == other.responseCreated &&
            responseDone == other.responseDone &&
            responseFunctionCallArgumentsDelta == other.responseFunctionCallArgumentsDelta &&
            responseFunctionCallArgumentsDone == other.responseFunctionCallArgumentsDone &&
            responseOutputItemAdded == other.responseOutputItemAdded &&
            responseOutputItemDone == other.responseOutputItemDone &&
            responseOutputTextDelta == other.responseOutputTextDelta &&
            responseOutputTextDone == other.responseOutputTextDone &&
            sessionCreated == other.sessionCreated &&
            sessionUpdated == other.sessionUpdated &&
            transcriptionSessionUpdated == other.transcriptionSessionUpdated &&
            transcriptionSessionCreated == other.transcriptionSessionCreated &&
            outputAudioBufferStarted == other.outputAudioBufferStarted &&
            outputAudioBufferStopped == other.outputAudioBufferStopped &&
            outputAudioBufferCleared == other.outputAudioBufferCleared &&
            conversationItemAdded == other.conversationItemAdded &&
            conversationItemDone == other.conversationItemDone &&
            inputAudioBufferTimeoutTriggered == other.inputAudioBufferTimeoutTriggered &&
            conversationItemInputAudioTranscriptionSegment ==
                other.conversationItemInputAudioTranscriptionSegment &&
            mcpListToolsInProgress == other.mcpListToolsInProgress &&
            mcpListToolsCompleted == other.mcpListToolsCompleted &&
            mcpListToolsFailed == other.mcpListToolsFailed &&
            responseMcpCallArgumentsDelta == other.responseMcpCallArgumentsDelta &&
            responseMcpCallArgumentsDone == other.responseMcpCallArgumentsDone &&
            responseMcpCallInProgress == other.responseMcpCallInProgress &&
            responseMcpCallCompleted == other.responseMcpCallCompleted &&
            responseMcpCallFailed == other.responseMcpCallFailed
    }

    override fun hashCode(): Int =
        Objects.hash(
            conversationCreated,
            conversationItemCreated,
            conversationItemDeleted,
            conversationItemInputAudioTranscriptionCompleted,
            conversationItemInputAudioTranscriptionDelta,
            conversationItemInputAudioTranscriptionFailed,
            conversationItemRetrieved,
            conversationItemTruncated,
            error,
            inputAudioBufferCleared,
            inputAudioBufferCommitted,
            inputAudioBufferSpeechStarted,
            inputAudioBufferSpeechStopped,
            rateLimitsUpdated,
            responseOutputAudioDelta,
            responseOutputAudioDone,
            responseOutputAudioTranscriptDelta,
            responseOutputAudioTranscriptDone,
            responseContentPartAdded,
            responseContentPartDone,
            responseCreated,
            responseDone,
            responseFunctionCallArgumentsDelta,
            responseFunctionCallArgumentsDone,
            responseOutputItemAdded,
            responseOutputItemDone,
            responseOutputTextDelta,
            responseOutputTextDone,
            sessionCreated,
            sessionUpdated,
            transcriptionSessionUpdated,
            transcriptionSessionCreated,
            outputAudioBufferStarted,
            outputAudioBufferStopped,
            outputAudioBufferCleared,
            conversationItemAdded,
            conversationItemDone,
            inputAudioBufferTimeoutTriggered,
            conversationItemInputAudioTranscriptionSegment,
            mcpListToolsInProgress,
            mcpListToolsCompleted,
            mcpListToolsFailed,
            responseMcpCallArgumentsDelta,
            responseMcpCallArgumentsDone,
            responseMcpCallInProgress,
            responseMcpCallCompleted,
            responseMcpCallFailed,
        )

    override fun toString(): String =
        when {
            conversationCreated != null ->
                "RealtimeServerEvent{conversationCreated=$conversationCreated}"
            conversationItemCreated != null ->
                "RealtimeServerEvent{conversationItemCreated=$conversationItemCreated}"
            conversationItemDeleted != null ->
                "RealtimeServerEvent{conversationItemDeleted=$conversationItemDeleted}"
            conversationItemInputAudioTranscriptionCompleted != null ->
                "RealtimeServerEvent{conversationItemInputAudioTranscriptionCompleted=$conversationItemInputAudioTranscriptionCompleted}"
            conversationItemInputAudioTranscriptionDelta != null ->
                "RealtimeServerEvent{conversationItemInputAudioTranscriptionDelta=$conversationItemInputAudioTranscriptionDelta}"
            conversationItemInputAudioTranscriptionFailed != null ->
                "RealtimeServerEvent{conversationItemInputAudioTranscriptionFailed=$conversationItemInputAudioTranscriptionFailed}"
            conversationItemRetrieved != null ->
                "RealtimeServerEvent{conversationItemRetrieved=$conversationItemRetrieved}"
            conversationItemTruncated != null ->
                "RealtimeServerEvent{conversationItemTruncated=$conversationItemTruncated}"
            error != null -> "RealtimeServerEvent{error=$error}"
            inputAudioBufferCleared != null ->
                "RealtimeServerEvent{inputAudioBufferCleared=$inputAudioBufferCleared}"
            inputAudioBufferCommitted != null ->
                "RealtimeServerEvent{inputAudioBufferCommitted=$inputAudioBufferCommitted}"
            inputAudioBufferSpeechStarted != null ->
                "RealtimeServerEvent{inputAudioBufferSpeechStarted=$inputAudioBufferSpeechStarted}"
            inputAudioBufferSpeechStopped != null ->
                "RealtimeServerEvent{inputAudioBufferSpeechStopped=$inputAudioBufferSpeechStopped}"
            rateLimitsUpdated != null -> "RealtimeServerEvent{rateLimitsUpdated=$rateLimitsUpdated}"
            responseOutputAudioDelta != null ->
                "RealtimeServerEvent{responseOutputAudioDelta=$responseOutputAudioDelta}"
            responseOutputAudioDone != null ->
                "RealtimeServerEvent{responseOutputAudioDone=$responseOutputAudioDone}"
            responseOutputAudioTranscriptDelta != null ->
                "RealtimeServerEvent{responseOutputAudioTranscriptDelta=$responseOutputAudioTranscriptDelta}"
            responseOutputAudioTranscriptDone != null ->
                "RealtimeServerEvent{responseOutputAudioTranscriptDone=$responseOutputAudioTranscriptDone}"
            responseContentPartAdded != null ->
                "RealtimeServerEvent{responseContentPartAdded=$responseContentPartAdded}"
            responseContentPartDone != null ->
                "RealtimeServerEvent{responseContentPartDone=$responseContentPartDone}"
            responseCreated != null -> "RealtimeServerEvent{responseCreated=$responseCreated}"
            responseDone != null -> "RealtimeServerEvent{responseDone=$responseDone}"
            responseFunctionCallArgumentsDelta != null ->
                "RealtimeServerEvent{responseFunctionCallArgumentsDelta=$responseFunctionCallArgumentsDelta}"
            responseFunctionCallArgumentsDone != null ->
                "RealtimeServerEvent{responseFunctionCallArgumentsDone=$responseFunctionCallArgumentsDone}"
            responseOutputItemAdded != null ->
                "RealtimeServerEvent{responseOutputItemAdded=$responseOutputItemAdded}"
            responseOutputItemDone != null ->
                "RealtimeServerEvent{responseOutputItemDone=$responseOutputItemDone}"
            responseOutputTextDelta != null ->
                "RealtimeServerEvent{responseOutputTextDelta=$responseOutputTextDelta}"
            responseOutputTextDone != null ->
                "RealtimeServerEvent{responseOutputTextDone=$responseOutputTextDone}"
            sessionCreated != null -> "RealtimeServerEvent{sessionCreated=$sessionCreated}"
            sessionUpdated != null -> "RealtimeServerEvent{sessionUpdated=$sessionUpdated}"
            transcriptionSessionUpdated != null ->
                "RealtimeServerEvent{transcriptionSessionUpdated=$transcriptionSessionUpdated}"
            transcriptionSessionCreated != null ->
                "RealtimeServerEvent{transcriptionSessionCreated=$transcriptionSessionCreated}"
            outputAudioBufferStarted != null ->
                "RealtimeServerEvent{outputAudioBufferStarted=$outputAudioBufferStarted}"
            outputAudioBufferStopped != null ->
                "RealtimeServerEvent{outputAudioBufferStopped=$outputAudioBufferStopped}"
            outputAudioBufferCleared != null ->
                "RealtimeServerEvent{outputAudioBufferCleared=$outputAudioBufferCleared}"
            conversationItemAdded != null ->
                "RealtimeServerEvent{conversationItemAdded=$conversationItemAdded}"
            conversationItemDone != null ->
                "RealtimeServerEvent{conversationItemDone=$conversationItemDone}"
            inputAudioBufferTimeoutTriggered != null ->
                "RealtimeServerEvent{inputAudioBufferTimeoutTriggered=$inputAudioBufferTimeoutTriggered}"
            conversationItemInputAudioTranscriptionSegment != null ->
                "RealtimeServerEvent{conversationItemInputAudioTranscriptionSegment=$conversationItemInputAudioTranscriptionSegment}"
            mcpListToolsInProgress != null ->
                "RealtimeServerEvent{mcpListToolsInProgress=$mcpListToolsInProgress}"
            mcpListToolsCompleted != null ->
                "RealtimeServerEvent{mcpListToolsCompleted=$mcpListToolsCompleted}"
            mcpListToolsFailed != null ->
                "RealtimeServerEvent{mcpListToolsFailed=$mcpListToolsFailed}"
            responseMcpCallArgumentsDelta != null ->
                "RealtimeServerEvent{responseMcpCallArgumentsDelta=$responseMcpCallArgumentsDelta}"
            responseMcpCallArgumentsDone != null ->
                "RealtimeServerEvent{responseMcpCallArgumentsDone=$responseMcpCallArgumentsDone}"
            responseMcpCallInProgress != null ->
                "RealtimeServerEvent{responseMcpCallInProgress=$responseMcpCallInProgress}"
            responseMcpCallCompleted != null ->
                "RealtimeServerEvent{responseMcpCallCompleted=$responseMcpCallCompleted}"
            responseMcpCallFailed != null ->
                "RealtimeServerEvent{responseMcpCallFailed=$responseMcpCallFailed}"
            _json != null -> "RealtimeServerEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeServerEvent")
        }

    companion object {

        /** Returned when a conversation is created. Emitted right after session creation. */
        @JvmStatic
        fun ofConversationCreated(conversationCreated: ConversationCreatedEvent) =
            RealtimeServerEvent(conversationCreated = conversationCreated)

        /**
         * Returned when a conversation item is created. There are several scenarios that produce
         * this event:
         * - The server is generating a Response, which if successful will produce either one or two
         *   Items, which will be of type `message` (role `assistant`) or type `function_call`.
         * - The input audio buffer has been committed, either by the client or the server (in
         *   `server_vad` mode). The server will take the content of the input audio buffer and add
         *   it to a new user message Item.
         * - The client has sent a `conversation.item.create` event to add a new Item to the
         *   Conversation.
         */
        @JvmStatic
        fun ofConversationItemCreated(conversationItemCreated: ConversationItemCreatedEvent) =
            RealtimeServerEvent(conversationItemCreated = conversationItemCreated)

        /**
         * Returned when an item in the conversation is deleted by the client with a
         * `conversation.item.delete` event. This event is used to synchronize the server's
         * understanding of the conversation history with the client's view.
         */
        @JvmStatic
        fun ofConversationItemDeleted(conversationItemDeleted: ConversationItemDeletedEvent) =
            RealtimeServerEvent(conversationItemDeleted = conversationItemDeleted)

        /**
         * This event is the output of audio transcription for user audio written to the user audio
         * buffer. Transcription begins when the input audio buffer is committed by the client or
         * server (when VAD is enabled). Transcription runs asynchronously with Response creation,
         * so this event may come before or after the Response events.
         *
         * Realtime API models accept audio natively, and thus input transcription is a separate
         * process run on a separate ASR (Automatic Speech Recognition) model. The transcript may
         * diverge somewhat from the model's interpretation, and should be treated as a rough guide.
         */
        @JvmStatic
        fun ofConversationItemInputAudioTranscriptionCompleted(
            conversationItemInputAudioTranscriptionCompleted:
                ConversationItemInputAudioTranscriptionCompletedEvent
        ) =
            RealtimeServerEvent(
                conversationItemInputAudioTranscriptionCompleted =
                    conversationItemInputAudioTranscriptionCompleted
            )

        /**
         * Returned when the text value of an input audio transcription content part is updated with
         * incremental transcription results.
         */
        @JvmStatic
        fun ofConversationItemInputAudioTranscriptionDelta(
            conversationItemInputAudioTranscriptionDelta:
                ConversationItemInputAudioTranscriptionDeltaEvent
        ) =
            RealtimeServerEvent(
                conversationItemInputAudioTranscriptionDelta =
                    conversationItemInputAudioTranscriptionDelta
            )

        /**
         * Returned when input audio transcription is configured, and a transcription request for a
         * user message failed. These events are separate from other `error` events so that the
         * client can identify the related Item.
         */
        @JvmStatic
        fun ofConversationItemInputAudioTranscriptionFailed(
            conversationItemInputAudioTranscriptionFailed:
                ConversationItemInputAudioTranscriptionFailedEvent
        ) =
            RealtimeServerEvent(
                conversationItemInputAudioTranscriptionFailed =
                    conversationItemInputAudioTranscriptionFailed
            )

        /**
         * Returned when a conversation item is retrieved with `conversation.item.retrieve`. This is
         * provided as a way to fetch the server's representation of an item, for example to get
         * access to the post-processed audio data after noise cancellation and VAD. It includes the
         * full content of the Item, including audio data.
         */
        @JvmStatic
        fun ofConversationItemRetrieved(conversationItemRetrieved: ConversationItemRetrieved) =
            RealtimeServerEvent(conversationItemRetrieved = conversationItemRetrieved)

        /**
         * Returned when an earlier assistant audio message item is truncated by the client with a
         * `conversation.item.truncate` event. This event is used to synchronize the server's
         * understanding of the audio with the client's playback.
         *
         * This action will truncate the audio and remove the server-side text transcript to ensure
         * there is no text in the context that hasn't been heard by the user.
         */
        @JvmStatic
        fun ofConversationItemTruncated(conversationItemTruncated: ConversationItemTruncatedEvent) =
            RealtimeServerEvent(conversationItemTruncated = conversationItemTruncated)

        /**
         * Returned when an error occurs, which could be a client problem or a server problem. Most
         * errors are recoverable and the session will stay open, we recommend to implementors to
         * monitor and log error messages by default.
         */
        @JvmStatic fun ofError(error: RealtimeErrorEvent) = RealtimeServerEvent(error = error)

        /**
         * Returned when the input audio buffer is cleared by the client with a
         * `input_audio_buffer.clear` event.
         */
        @JvmStatic
        fun ofInputAudioBufferCleared(inputAudioBufferCleared: InputAudioBufferClearedEvent) =
            RealtimeServerEvent(inputAudioBufferCleared = inputAudioBufferCleared)

        /**
         * Returned when an input audio buffer is committed, either by the client or automatically
         * in server VAD mode. The `item_id` property is the ID of the user message item that will
         * be created, thus a `conversation.item.created` event will also be sent to the client.
         */
        @JvmStatic
        fun ofInputAudioBufferCommitted(inputAudioBufferCommitted: InputAudioBufferCommittedEvent) =
            RealtimeServerEvent(inputAudioBufferCommitted = inputAudioBufferCommitted)

        /**
         * Sent by the server when in `server_vad` mode to indicate that speech has been detected in
         * the audio buffer. This can happen any time audio is added to the buffer (unless speech is
         * already detected). The client may want to use this event to interrupt audio playback or
         * provide visual feedback to the user.
         *
         * The client should expect to receive a `input_audio_buffer.speech_stopped` event when
         * speech stops. The `item_id` property is the ID of the user message item that will be
         * created when speech stops and will also be included in the
         * `input_audio_buffer.speech_stopped` event (unless the client manually commits the audio
         * buffer during VAD activation).
         */
        @JvmStatic
        fun ofInputAudioBufferSpeechStarted(
            inputAudioBufferSpeechStarted: InputAudioBufferSpeechStartedEvent
        ) = RealtimeServerEvent(inputAudioBufferSpeechStarted = inputAudioBufferSpeechStarted)

        /**
         * Returned in `server_vad` mode when the server detects the end of speech in the audio
         * buffer. The server will also send an `conversation.item.created` event with the user
         * message item that is created from the audio buffer.
         */
        @JvmStatic
        fun ofInputAudioBufferSpeechStopped(
            inputAudioBufferSpeechStopped: InputAudioBufferSpeechStoppedEvent
        ) = RealtimeServerEvent(inputAudioBufferSpeechStopped = inputAudioBufferSpeechStopped)

        /**
         * Emitted at the beginning of a Response to indicate the updated rate limits. When a
         * Response is created some tokens will be "reserved" for the output tokens, the rate limits
         * shown here reflect that reservation, which is then adjusted accordingly once the Response
         * is completed.
         */
        @JvmStatic
        fun ofRateLimitsUpdated(rateLimitsUpdated: RateLimitsUpdatedEvent) =
            RealtimeServerEvent(rateLimitsUpdated = rateLimitsUpdated)

        /** Returned when the model-generated audio is updated. */
        @JvmStatic
        fun ofResponseOutputAudioDelta(responseOutputAudioDelta: ResponseAudioDeltaEvent) =
            RealtimeServerEvent(responseOutputAudioDelta = responseOutputAudioDelta)

        /**
         * Returned when the model-generated audio is done. Also emitted when a Response is
         * interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseOutputAudioDone(responseOutputAudioDone: ResponseAudioDoneEvent) =
            RealtimeServerEvent(responseOutputAudioDone = responseOutputAudioDone)

        /** Returned when the model-generated transcription of audio output is updated. */
        @JvmStatic
        fun ofResponseOutputAudioTranscriptDelta(
            responseOutputAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
        ) =
            RealtimeServerEvent(
                responseOutputAudioTranscriptDelta = responseOutputAudioTranscriptDelta
            )

        /**
         * Returned when the model-generated transcription of audio output is done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseOutputAudioTranscriptDone(
            responseOutputAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
        ) =
            RealtimeServerEvent(
                responseOutputAudioTranscriptDone = responseOutputAudioTranscriptDone
            )

        /**
         * Returned when a new content part is added to an assistant message item during response
         * generation.
         */
        @JvmStatic
        fun ofResponseContentPartAdded(responseContentPartAdded: ResponseContentPartAddedEvent) =
            RealtimeServerEvent(responseContentPartAdded = responseContentPartAdded)

        /**
         * Returned when a content part is done streaming in an assistant message item. Also emitted
         * when a Response is interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseContentPartDone(responseContentPartDone: ResponseContentPartDoneEvent) =
            RealtimeServerEvent(responseContentPartDone = responseContentPartDone)

        /**
         * Returned when a new Response is created. The first event of response creation, where the
         * response is in an initial state of `in_progress`.
         */
        @JvmStatic
        fun ofResponseCreated(responseCreated: ResponseCreatedEvent) =
            RealtimeServerEvent(responseCreated = responseCreated)

        /**
         * Returned when a Response is done streaming. Always emitted, no matter the final state.
         * The Response object included in the `response.done` event will include all output Items
         * in the Response but will omit the raw audio data.
         *
         * Clients should check the `status` field of the Response to determine if it was successful
         * (`completed`) or if there was another outcome: `cancelled`, `failed`, or `incomplete`.
         *
         * A response will contain all output items that were generated during the response,
         * excluding any audio content.
         */
        @JvmStatic
        fun ofResponseDone(responseDone: ResponseDoneEvent) =
            RealtimeServerEvent(responseDone = responseDone)

        /** Returned when the model-generated function call arguments are updated. */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
        ) =
            RealtimeServerEvent(
                responseFunctionCallArgumentsDelta = responseFunctionCallArgumentsDelta
            )

        /**
         * Returned when the model-generated function call arguments are done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
        ) =
            RealtimeServerEvent(
                responseFunctionCallArgumentsDone = responseFunctionCallArgumentsDone
            )

        /** Returned when a new Item is created during Response generation. */
        @JvmStatic
        fun ofResponseOutputItemAdded(responseOutputItemAdded: ResponseOutputItemAddedEvent) =
            RealtimeServerEvent(responseOutputItemAdded = responseOutputItemAdded)

        /**
         * Returned when an Item is done streaming. Also emitted when a Response is interrupted,
         * incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseOutputItemDone(responseOutputItemDone: ResponseOutputItemDoneEvent) =
            RealtimeServerEvent(responseOutputItemDone = responseOutputItemDone)

        /** Returned when the text value of an "output_text" content part is updated. */
        @JvmStatic
        fun ofResponseOutputTextDelta(responseOutputTextDelta: ResponseTextDeltaEvent) =
            RealtimeServerEvent(responseOutputTextDelta = responseOutputTextDelta)

        /**
         * Returned when the text value of an "output_text" content part is done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseOutputTextDone(responseOutputTextDone: ResponseTextDoneEvent) =
            RealtimeServerEvent(responseOutputTextDone = responseOutputTextDone)

        /**
         * Returned when a Session is created. Emitted automatically when a new connection is
         * established as the first server event. This event will contain the default Session
         * configuration.
         */
        @JvmStatic
        fun ofSessionCreated(sessionCreated: SessionCreatedEvent) =
            RealtimeServerEvent(sessionCreated = sessionCreated)

        /**
         * Returned when a session is updated with a `session.update` event, unless there is an
         * error.
         */
        @JvmStatic
        fun ofSessionUpdated(sessionUpdated: SessionUpdatedEvent) =
            RealtimeServerEvent(sessionUpdated = sessionUpdated)

        /**
         * Returned when a transcription session is updated with a `transcription_session.update`
         * event, unless there is an error.
         */
        @JvmStatic
        fun ofTranscriptionSessionUpdated(
            transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent
        ) = RealtimeServerEvent(transcriptionSessionUpdated = transcriptionSessionUpdated)

        /** Returned when a transcription session is created. */
        @JvmStatic
        fun ofTranscriptionSessionCreated(
            transcriptionSessionCreated: TranscriptionSessionCreated
        ) = RealtimeServerEvent(transcriptionSessionCreated = transcriptionSessionCreated)

        /**
         * **WebRTC Only:** Emitted when the server begins streaming audio to the client. This event
         * is emitted after an audio content part has been added (`response.content_part.added`) to
         * the response.
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        @JvmStatic
        fun ofOutputAudioBufferStarted(outputAudioBufferStarted: OutputAudioBufferStarted) =
            RealtimeServerEvent(outputAudioBufferStarted = outputAudioBufferStarted)

        /**
         * **WebRTC Only:** Emitted when the output audio buffer has been completely drained on the
         * server, and no more audio is forthcoming. This event is emitted after the full response
         * data has been sent to the client (`response.done`).
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        @JvmStatic
        fun ofOutputAudioBufferStopped(outputAudioBufferStopped: OutputAudioBufferStopped) =
            RealtimeServerEvent(outputAudioBufferStopped = outputAudioBufferStopped)

        /**
         * **WebRTC Only:** Emitted when the output audio buffer is cleared. This happens either in
         * VAD mode when the user has interrupted (`input_audio_buffer.speech_started`), or when the
         * client has emitted the `output_audio_buffer.clear` event to manually cut off the current
         * audio response.
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        @JvmStatic
        fun ofOutputAudioBufferCleared(outputAudioBufferCleared: OutputAudioBufferCleared) =
            RealtimeServerEvent(outputAudioBufferCleared = outputAudioBufferCleared)

        /**
         * Sent by the server when an Item is added to the default Conversation. This can happen in
         * several cases:
         * - When the client sends a `conversation.item.create` event.
         * - When the input audio buffer is committed. In this case the item will be a user message
         *   containing the audio from the buffer.
         * - When the model is generating a Response. In this case the `conversation.item.added`
         *   event will be sent when the model starts generating a specific Item, and thus it will
         *   not yet have any content (and `status` will be `in_progress`).
         *
         * The event will include the full content of the Item (except when model is generating a
         * Response) except for audio data, which can be retrieved separately with a
         * `conversation.item.retrieve` event if necessary.
         */
        @JvmStatic
        fun ofConversationItemAdded(conversationItemAdded: ConversationItemAdded) =
            RealtimeServerEvent(conversationItemAdded = conversationItemAdded)

        /**
         * Returned when a conversation item is finalized.
         *
         * The event will include the full content of the Item except for audio data, which can be
         * retrieved separately with a `conversation.item.retrieve` event if needed.
         */
        @JvmStatic
        fun ofConversationItemDone(conversationItemDone: ConversationItemDone) =
            RealtimeServerEvent(conversationItemDone = conversationItemDone)

        /** Returned when the server VAD timeout is triggered for the input audio buffer. */
        @JvmStatic
        fun ofInputAudioBufferTimeoutTriggered(
            inputAudioBufferTimeoutTriggered: InputAudioBufferTimeoutTriggered
        ) = RealtimeServerEvent(inputAudioBufferTimeoutTriggered = inputAudioBufferTimeoutTriggered)

        /** Returned when an input audio transcription segment is identified for an item. */
        @JvmStatic
        fun ofConversationItemInputAudioTranscriptionSegment(
            conversationItemInputAudioTranscriptionSegment:
                ConversationItemInputAudioTranscriptionSegment
        ) =
            RealtimeServerEvent(
                conversationItemInputAudioTranscriptionSegment =
                    conversationItemInputAudioTranscriptionSegment
            )

        /** Returned when listing MCP tools is in progress for an item. */
        @JvmStatic
        fun ofMcpListToolsInProgress(mcpListToolsInProgress: McpListToolsInProgress) =
            RealtimeServerEvent(mcpListToolsInProgress = mcpListToolsInProgress)

        /** Returned when listing MCP tools has completed for an item. */
        @JvmStatic
        fun ofMcpListToolsCompleted(mcpListToolsCompleted: McpListToolsCompleted) =
            RealtimeServerEvent(mcpListToolsCompleted = mcpListToolsCompleted)

        /** Returned when listing MCP tools has failed for an item. */
        @JvmStatic
        fun ofMcpListToolsFailed(mcpListToolsFailed: McpListToolsFailed) =
            RealtimeServerEvent(mcpListToolsFailed = mcpListToolsFailed)

        /** Returned when MCP tool call arguments are updated during response generation. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDelta
        ) = RealtimeServerEvent(responseMcpCallArgumentsDelta = responseMcpCallArgumentsDelta)

        /** Returned when MCP tool call arguments are finalized during response generation. */
        @JvmStatic
        fun ofResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDone
        ) = RealtimeServerEvent(responseMcpCallArgumentsDone = responseMcpCallArgumentsDone)

        /** Returned when an MCP tool call has started and is in progress. */
        @JvmStatic
        fun ofResponseMcpCallInProgress(responseMcpCallInProgress: ResponseMcpCallInProgress) =
            RealtimeServerEvent(responseMcpCallInProgress = responseMcpCallInProgress)

        /** Returned when an MCP tool call has completed successfully. */
        @JvmStatic
        fun ofResponseMcpCallCompleted(responseMcpCallCompleted: ResponseMcpCallCompleted) =
            RealtimeServerEvent(responseMcpCallCompleted = responseMcpCallCompleted)

        /** Returned when an MCP tool call has failed. */
        @JvmStatic
        fun ofResponseMcpCallFailed(responseMcpCallFailed: ResponseMcpCallFailed) =
            RealtimeServerEvent(responseMcpCallFailed = responseMcpCallFailed)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeServerEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Returned when a conversation is created. Emitted right after session creation. */
        fun visitConversationCreated(conversationCreated: ConversationCreatedEvent): T

        /**
         * Returned when a conversation item is created. There are several scenarios that produce
         * this event:
         * - The server is generating a Response, which if successful will produce either one or two
         *   Items, which will be of type `message` (role `assistant`) or type `function_call`.
         * - The input audio buffer has been committed, either by the client or the server (in
         *   `server_vad` mode). The server will take the content of the input audio buffer and add
         *   it to a new user message Item.
         * - The client has sent a `conversation.item.create` event to add a new Item to the
         *   Conversation.
         */
        fun visitConversationItemCreated(conversationItemCreated: ConversationItemCreatedEvent): T

        /**
         * Returned when an item in the conversation is deleted by the client with a
         * `conversation.item.delete` event. This event is used to synchronize the server's
         * understanding of the conversation history with the client's view.
         */
        fun visitConversationItemDeleted(conversationItemDeleted: ConversationItemDeletedEvent): T

        /**
         * This event is the output of audio transcription for user audio written to the user audio
         * buffer. Transcription begins when the input audio buffer is committed by the client or
         * server (when VAD is enabled). Transcription runs asynchronously with Response creation,
         * so this event may come before or after the Response events.
         *
         * Realtime API models accept audio natively, and thus input transcription is a separate
         * process run on a separate ASR (Automatic Speech Recognition) model. The transcript may
         * diverge somewhat from the model's interpretation, and should be treated as a rough guide.
         */
        fun visitConversationItemInputAudioTranscriptionCompleted(
            conversationItemInputAudioTranscriptionCompleted:
                ConversationItemInputAudioTranscriptionCompletedEvent
        ): T

        /**
         * Returned when the text value of an input audio transcription content part is updated with
         * incremental transcription results.
         */
        fun visitConversationItemInputAudioTranscriptionDelta(
            conversationItemInputAudioTranscriptionDelta:
                ConversationItemInputAudioTranscriptionDeltaEvent
        ): T

        /**
         * Returned when input audio transcription is configured, and a transcription request for a
         * user message failed. These events are separate from other `error` events so that the
         * client can identify the related Item.
         */
        fun visitConversationItemInputAudioTranscriptionFailed(
            conversationItemInputAudioTranscriptionFailed:
                ConversationItemInputAudioTranscriptionFailedEvent
        ): T

        /**
         * Returned when a conversation item is retrieved with `conversation.item.retrieve`. This is
         * provided as a way to fetch the server's representation of an item, for example to get
         * access to the post-processed audio data after noise cancellation and VAD. It includes the
         * full content of the Item, including audio data.
         */
        fun visitConversationItemRetrieved(conversationItemRetrieved: ConversationItemRetrieved): T

        /**
         * Returned when an earlier assistant audio message item is truncated by the client with a
         * `conversation.item.truncate` event. This event is used to synchronize the server's
         * understanding of the audio with the client's playback.
         *
         * This action will truncate the audio and remove the server-side text transcript to ensure
         * there is no text in the context that hasn't been heard by the user.
         */
        fun visitConversationItemTruncated(
            conversationItemTruncated: ConversationItemTruncatedEvent
        ): T

        /**
         * Returned when an error occurs, which could be a client problem or a server problem. Most
         * errors are recoverable and the session will stay open, we recommend to implementors to
         * monitor and log error messages by default.
         */
        fun visitError(error: RealtimeErrorEvent): T

        /**
         * Returned when the input audio buffer is cleared by the client with a
         * `input_audio_buffer.clear` event.
         */
        fun visitInputAudioBufferCleared(inputAudioBufferCleared: InputAudioBufferClearedEvent): T

        /**
         * Returned when an input audio buffer is committed, either by the client or automatically
         * in server VAD mode. The `item_id` property is the ID of the user message item that will
         * be created, thus a `conversation.item.created` event will also be sent to the client.
         */
        fun visitInputAudioBufferCommitted(
            inputAudioBufferCommitted: InputAudioBufferCommittedEvent
        ): T

        /**
         * Sent by the server when in `server_vad` mode to indicate that speech has been detected in
         * the audio buffer. This can happen any time audio is added to the buffer (unless speech is
         * already detected). The client may want to use this event to interrupt audio playback or
         * provide visual feedback to the user.
         *
         * The client should expect to receive a `input_audio_buffer.speech_stopped` event when
         * speech stops. The `item_id` property is the ID of the user message item that will be
         * created when speech stops and will also be included in the
         * `input_audio_buffer.speech_stopped` event (unless the client manually commits the audio
         * buffer during VAD activation).
         */
        fun visitInputAudioBufferSpeechStarted(
            inputAudioBufferSpeechStarted: InputAudioBufferSpeechStartedEvent
        ): T

        /**
         * Returned in `server_vad` mode when the server detects the end of speech in the audio
         * buffer. The server will also send an `conversation.item.created` event with the user
         * message item that is created from the audio buffer.
         */
        fun visitInputAudioBufferSpeechStopped(
            inputAudioBufferSpeechStopped: InputAudioBufferSpeechStoppedEvent
        ): T

        /**
         * Emitted at the beginning of a Response to indicate the updated rate limits. When a
         * Response is created some tokens will be "reserved" for the output tokens, the rate limits
         * shown here reflect that reservation, which is then adjusted accordingly once the Response
         * is completed.
         */
        fun visitRateLimitsUpdated(rateLimitsUpdated: RateLimitsUpdatedEvent): T

        /** Returned when the model-generated audio is updated. */
        fun visitResponseOutputAudioDelta(responseOutputAudioDelta: ResponseAudioDeltaEvent): T

        /**
         * Returned when the model-generated audio is done. Also emitted when a Response is
         * interrupted, incomplete, or cancelled.
         */
        fun visitResponseOutputAudioDone(responseOutputAudioDone: ResponseAudioDoneEvent): T

        /** Returned when the model-generated transcription of audio output is updated. */
        fun visitResponseOutputAudioTranscriptDelta(
            responseOutputAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
        ): T

        /**
         * Returned when the model-generated transcription of audio output is done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        fun visitResponseOutputAudioTranscriptDone(
            responseOutputAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
        ): T

        /**
         * Returned when a new content part is added to an assistant message item during response
         * generation.
         */
        fun visitResponseContentPartAdded(
            responseContentPartAdded: ResponseContentPartAddedEvent
        ): T

        /**
         * Returned when a content part is done streaming in an assistant message item. Also emitted
         * when a Response is interrupted, incomplete, or cancelled.
         */
        fun visitResponseContentPartDone(responseContentPartDone: ResponseContentPartDoneEvent): T

        /**
         * Returned when a new Response is created. The first event of response creation, where the
         * response is in an initial state of `in_progress`.
         */
        fun visitResponseCreated(responseCreated: ResponseCreatedEvent): T

        /**
         * Returned when a Response is done streaming. Always emitted, no matter the final state.
         * The Response object included in the `response.done` event will include all output Items
         * in the Response but will omit the raw audio data.
         *
         * Clients should check the `status` field of the Response to determine if it was successful
         * (`completed`) or if there was another outcome: `cancelled`, `failed`, or `incomplete`.
         *
         * A response will contain all output items that were generated during the response,
         * excluding any audio content.
         */
        fun visitResponseDone(responseDone: ResponseDoneEvent): T

        /** Returned when the model-generated function call arguments are updated. */
        fun visitResponseFunctionCallArgumentsDelta(
            responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent
        ): T

        /**
         * Returned when the model-generated function call arguments are done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        fun visitResponseFunctionCallArgumentsDone(
            responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent
        ): T

        /** Returned when a new Item is created during Response generation. */
        fun visitResponseOutputItemAdded(responseOutputItemAdded: ResponseOutputItemAddedEvent): T

        /**
         * Returned when an Item is done streaming. Also emitted when a Response is interrupted,
         * incomplete, or cancelled.
         */
        fun visitResponseOutputItemDone(responseOutputItemDone: ResponseOutputItemDoneEvent): T

        /** Returned when the text value of an "output_text" content part is updated. */
        fun visitResponseOutputTextDelta(responseOutputTextDelta: ResponseTextDeltaEvent): T

        /**
         * Returned when the text value of an "output_text" content part is done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        fun visitResponseOutputTextDone(responseOutputTextDone: ResponseTextDoneEvent): T

        /**
         * Returned when a Session is created. Emitted automatically when a new connection is
         * established as the first server event. This event will contain the default Session
         * configuration.
         */
        fun visitSessionCreated(sessionCreated: SessionCreatedEvent): T

        /**
         * Returned when a session is updated with a `session.update` event, unless there is an
         * error.
         */
        fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent): T

        /**
         * Returned when a transcription session is updated with a `transcription_session.update`
         * event, unless there is an error.
         */
        fun visitTranscriptionSessionUpdated(
            transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent
        ): T

        /** Returned when a transcription session is created. */
        fun visitTranscriptionSessionCreated(
            transcriptionSessionCreated: TranscriptionSessionCreated
        ): T

        /**
         * **WebRTC Only:** Emitted when the server begins streaming audio to the client. This event
         * is emitted after an audio content part has been added (`response.content_part.added`) to
         * the response.
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        fun visitOutputAudioBufferStarted(outputAudioBufferStarted: OutputAudioBufferStarted): T

        /**
         * **WebRTC Only:** Emitted when the output audio buffer has been completely drained on the
         * server, and no more audio is forthcoming. This event is emitted after the full response
         * data has been sent to the client (`response.done`).
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        fun visitOutputAudioBufferStopped(outputAudioBufferStopped: OutputAudioBufferStopped): T

        /**
         * **WebRTC Only:** Emitted when the output audio buffer is cleared. This happens either in
         * VAD mode when the user has interrupted (`input_audio_buffer.speech_started`), or when the
         * client has emitted the `output_audio_buffer.clear` event to manually cut off the current
         * audio response.
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        fun visitOutputAudioBufferCleared(outputAudioBufferCleared: OutputAudioBufferCleared): T

        /**
         * Sent by the server when an Item is added to the default Conversation. This can happen in
         * several cases:
         * - When the client sends a `conversation.item.create` event.
         * - When the input audio buffer is committed. In this case the item will be a user message
         *   containing the audio from the buffer.
         * - When the model is generating a Response. In this case the `conversation.item.added`
         *   event will be sent when the model starts generating a specific Item, and thus it will
         *   not yet have any content (and `status` will be `in_progress`).
         *
         * The event will include the full content of the Item (except when model is generating a
         * Response) except for audio data, which can be retrieved separately with a
         * `conversation.item.retrieve` event if necessary.
         */
        fun visitConversationItemAdded(conversationItemAdded: ConversationItemAdded): T

        /**
         * Returned when a conversation item is finalized.
         *
         * The event will include the full content of the Item except for audio data, which can be
         * retrieved separately with a `conversation.item.retrieve` event if needed.
         */
        fun visitConversationItemDone(conversationItemDone: ConversationItemDone): T

        /** Returned when the server VAD timeout is triggered for the input audio buffer. */
        fun visitInputAudioBufferTimeoutTriggered(
            inputAudioBufferTimeoutTriggered: InputAudioBufferTimeoutTriggered
        ): T

        /** Returned when an input audio transcription segment is identified for an item. */
        fun visitConversationItemInputAudioTranscriptionSegment(
            conversationItemInputAudioTranscriptionSegment:
                ConversationItemInputAudioTranscriptionSegment
        ): T

        /** Returned when listing MCP tools is in progress for an item. */
        fun visitMcpListToolsInProgress(mcpListToolsInProgress: McpListToolsInProgress): T

        /** Returned when listing MCP tools has completed for an item. */
        fun visitMcpListToolsCompleted(mcpListToolsCompleted: McpListToolsCompleted): T

        /** Returned when listing MCP tools has failed for an item. */
        fun visitMcpListToolsFailed(mcpListToolsFailed: McpListToolsFailed): T

        /** Returned when MCP tool call arguments are updated during response generation. */
        fun visitResponseMcpCallArgumentsDelta(
            responseMcpCallArgumentsDelta: ResponseMcpCallArgumentsDelta
        ): T

        /** Returned when MCP tool call arguments are finalized during response generation. */
        fun visitResponseMcpCallArgumentsDone(
            responseMcpCallArgumentsDone: ResponseMcpCallArgumentsDone
        ): T

        /** Returned when an MCP tool call has started and is in progress. */
        fun visitResponseMcpCallInProgress(responseMcpCallInProgress: ResponseMcpCallInProgress): T

        /** Returned when an MCP tool call has completed successfully. */
        fun visitResponseMcpCallCompleted(responseMcpCallCompleted: ResponseMcpCallCompleted): T

        /** Returned when an MCP tool call has failed. */
        fun visitResponseMcpCallFailed(responseMcpCallFailed: ResponseMcpCallFailed): T

        /**
         * Maps an unknown variant of [RealtimeServerEvent] to a value of type [T].
         *
         * An instance of [RealtimeServerEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeServerEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeServerEvent>(RealtimeServerEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeServerEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "conversation.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationCreatedEvent>())?.let {
                        RealtimeServerEvent(conversationCreated = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemCreatedEvent>())
                        ?.let { RealtimeServerEvent(conversationItemCreated = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.deleted" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemDeletedEvent>())
                        ?.let { RealtimeServerEvent(conversationItemDeleted = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.input_audio_transcription.completed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ConversationItemInputAudioTranscriptionCompletedEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(
                                conversationItemInputAudioTranscriptionCompleted = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.input_audio_transcription.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ConversationItemInputAudioTranscriptionDeltaEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(
                                conversationItemInputAudioTranscriptionDelta = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.input_audio_transcription.failed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ConversationItemInputAudioTranscriptionFailedEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(
                                conversationItemInputAudioTranscriptionFailed = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.retrieved" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemRetrieved>())?.let {
                        RealtimeServerEvent(conversationItemRetrieved = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.truncated" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemTruncatedEvent>())
                        ?.let { RealtimeServerEvent(conversationItemTruncated = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "error" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeErrorEvent>())?.let {
                        RealtimeServerEvent(error = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "input_audio_buffer.cleared" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioBufferClearedEvent>())
                        ?.let { RealtimeServerEvent(inputAudioBufferCleared = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "input_audio_buffer.committed" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioBufferCommittedEvent>())
                        ?.let { RealtimeServerEvent(inputAudioBufferCommitted = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "input_audio_buffer.speech_started" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<InputAudioBufferSpeechStartedEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(inputAudioBufferSpeechStarted = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "input_audio_buffer.speech_stopped" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<InputAudioBufferSpeechStoppedEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(inputAudioBufferSpeechStopped = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "rate_limits.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<RateLimitsUpdatedEvent>())?.let {
                        RealtimeServerEvent(rateLimitsUpdated = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.output_audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDeltaEvent>())?.let {
                        RealtimeServerEvent(responseOutputAudioDelta = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.output_audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDoneEvent>())?.let {
                        RealtimeServerEvent(responseOutputAudioDone = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.output_audio_transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>())
                        ?.let {
                            RealtimeServerEvent(
                                responseOutputAudioTranscriptDelta = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.output_audio_transcript.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDoneEvent>())
                        ?.let {
                            RealtimeServerEvent(
                                responseOutputAudioTranscriptDone = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.content_part.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartAddedEvent>())
                        ?.let { RealtimeServerEvent(responseContentPartAdded = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "response.content_part.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseContentPartDoneEvent>())
                        ?.let { RealtimeServerEvent(responseContentPartDone = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "response.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCreatedEvent>())?.let {
                        RealtimeServerEvent(responseCreated = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseDoneEvent>())?.let {
                        RealtimeServerEvent(responseDone = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.function_call_arguments.delta" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsDeltaEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(
                                responseFunctionCallArgumentsDelta = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.function_call_arguments.done" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
                        )
                        ?.let {
                            RealtimeServerEvent(
                                responseFunctionCallArgumentsDone = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.output_item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemAddedEvent>())
                        ?.let { RealtimeServerEvent(responseOutputItemAdded = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "response.output_item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputItemDoneEvent>())
                        ?.let { RealtimeServerEvent(responseOutputItemDone = it, _json = json) }
                        ?: RealtimeServerEvent(_json = json)
                }
                "response.output_text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDeltaEvent>())?.let {
                        RealtimeServerEvent(responseOutputTextDelta = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.output_text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDoneEvent>())?.let {
                        RealtimeServerEvent(responseOutputTextDone = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "session.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionCreatedEvent>())?.let {
                        RealtimeServerEvent(sessionCreated = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "session.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUpdatedEvent>())?.let {
                        RealtimeServerEvent(sessionUpdated = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "transcription_session.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<TranscriptionSessionUpdatedEvent>())
                        ?.let {
                            RealtimeServerEvent(transcriptionSessionUpdated = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "transcription_session.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<TranscriptionSessionCreated>())
                        ?.let {
                            RealtimeServerEvent(transcriptionSessionCreated = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "output_audio_buffer.started" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioBufferStarted>())?.let {
                        RealtimeServerEvent(outputAudioBufferStarted = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "output_audio_buffer.stopped" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioBufferStopped>())?.let {
                        RealtimeServerEvent(outputAudioBufferStopped = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "output_audio_buffer.cleared" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioBufferCleared>())?.let {
                        RealtimeServerEvent(outputAudioBufferCleared = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.added" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemAdded>())?.let {
                        RealtimeServerEvent(conversationItemAdded = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemDone>())?.let {
                        RealtimeServerEvent(conversationItemDone = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "input_audio_buffer.timeout_triggered" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioBufferTimeoutTriggered>())
                        ?.let {
                            RealtimeServerEvent(inputAudioBufferTimeoutTriggered = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "conversation.item.input_audio_transcription.segment" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<ConversationItemInputAudioTranscriptionSegment>(),
                        )
                        ?.let {
                            RealtimeServerEvent(
                                conversationItemInputAudioTranscriptionSegment = it,
                                _json = json,
                            )
                        } ?: RealtimeServerEvent(_json = json)
                }
                "mcp_list_tools.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpListToolsInProgress>())?.let {
                        RealtimeServerEvent(mcpListToolsInProgress = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "mcp_list_tools.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpListToolsCompleted>())?.let {
                        RealtimeServerEvent(mcpListToolsCompleted = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "mcp_list_tools.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpListToolsFailed>())?.let {
                        RealtimeServerEvent(mcpListToolsFailed = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.mcp_call_arguments.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallArgumentsDelta>())
                        ?.let {
                            RealtimeServerEvent(responseMcpCallArgumentsDelta = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.mcp_call_arguments.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallArgumentsDone>())
                        ?.let {
                            RealtimeServerEvent(responseMcpCallArgumentsDone = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.mcp_call.in_progress" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallInProgress>())?.let {
                        RealtimeServerEvent(responseMcpCallInProgress = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.mcp_call.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallCompleted>())?.let {
                        RealtimeServerEvent(responseMcpCallCompleted = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.mcp_call.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseMcpCallFailed>())?.let {
                        RealtimeServerEvent(responseMcpCallFailed = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
            }

            return RealtimeServerEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<RealtimeServerEvent>(RealtimeServerEvent::class) {

        override fun serialize(
            value: RealtimeServerEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.conversationCreated != null ->
                    generator.writeObject(value.conversationCreated)
                value.conversationItemCreated != null ->
                    generator.writeObject(value.conversationItemCreated)
                value.conversationItemDeleted != null ->
                    generator.writeObject(value.conversationItemDeleted)
                value.conversationItemInputAudioTranscriptionCompleted != null ->
                    generator.writeObject(value.conversationItemInputAudioTranscriptionCompleted)
                value.conversationItemInputAudioTranscriptionDelta != null ->
                    generator.writeObject(value.conversationItemInputAudioTranscriptionDelta)
                value.conversationItemInputAudioTranscriptionFailed != null ->
                    generator.writeObject(value.conversationItemInputAudioTranscriptionFailed)
                value.conversationItemRetrieved != null ->
                    generator.writeObject(value.conversationItemRetrieved)
                value.conversationItemTruncated != null ->
                    generator.writeObject(value.conversationItemTruncated)
                value.error != null -> generator.writeObject(value.error)
                value.inputAudioBufferCleared != null ->
                    generator.writeObject(value.inputAudioBufferCleared)
                value.inputAudioBufferCommitted != null ->
                    generator.writeObject(value.inputAudioBufferCommitted)
                value.inputAudioBufferSpeechStarted != null ->
                    generator.writeObject(value.inputAudioBufferSpeechStarted)
                value.inputAudioBufferSpeechStopped != null ->
                    generator.writeObject(value.inputAudioBufferSpeechStopped)
                value.rateLimitsUpdated != null -> generator.writeObject(value.rateLimitsUpdated)
                value.responseOutputAudioDelta != null ->
                    generator.writeObject(value.responseOutputAudioDelta)
                value.responseOutputAudioDone != null ->
                    generator.writeObject(value.responseOutputAudioDone)
                value.responseOutputAudioTranscriptDelta != null ->
                    generator.writeObject(value.responseOutputAudioTranscriptDelta)
                value.responseOutputAudioTranscriptDone != null ->
                    generator.writeObject(value.responseOutputAudioTranscriptDone)
                value.responseContentPartAdded != null ->
                    generator.writeObject(value.responseContentPartAdded)
                value.responseContentPartDone != null ->
                    generator.writeObject(value.responseContentPartDone)
                value.responseCreated != null -> generator.writeObject(value.responseCreated)
                value.responseDone != null -> generator.writeObject(value.responseDone)
                value.responseFunctionCallArgumentsDelta != null ->
                    generator.writeObject(value.responseFunctionCallArgumentsDelta)
                value.responseFunctionCallArgumentsDone != null ->
                    generator.writeObject(value.responseFunctionCallArgumentsDone)
                value.responseOutputItemAdded != null ->
                    generator.writeObject(value.responseOutputItemAdded)
                value.responseOutputItemDone != null ->
                    generator.writeObject(value.responseOutputItemDone)
                value.responseOutputTextDelta != null ->
                    generator.writeObject(value.responseOutputTextDelta)
                value.responseOutputTextDone != null ->
                    generator.writeObject(value.responseOutputTextDone)
                value.sessionCreated != null -> generator.writeObject(value.sessionCreated)
                value.sessionUpdated != null -> generator.writeObject(value.sessionUpdated)
                value.transcriptionSessionUpdated != null ->
                    generator.writeObject(value.transcriptionSessionUpdated)
                value.transcriptionSessionCreated != null ->
                    generator.writeObject(value.transcriptionSessionCreated)
                value.outputAudioBufferStarted != null ->
                    generator.writeObject(value.outputAudioBufferStarted)
                value.outputAudioBufferStopped != null ->
                    generator.writeObject(value.outputAudioBufferStopped)
                value.outputAudioBufferCleared != null ->
                    generator.writeObject(value.outputAudioBufferCleared)
                value.conversationItemAdded != null ->
                    generator.writeObject(value.conversationItemAdded)
                value.conversationItemDone != null ->
                    generator.writeObject(value.conversationItemDone)
                value.inputAudioBufferTimeoutTriggered != null ->
                    generator.writeObject(value.inputAudioBufferTimeoutTriggered)
                value.conversationItemInputAudioTranscriptionSegment != null ->
                    generator.writeObject(value.conversationItemInputAudioTranscriptionSegment)
                value.mcpListToolsInProgress != null ->
                    generator.writeObject(value.mcpListToolsInProgress)
                value.mcpListToolsCompleted != null ->
                    generator.writeObject(value.mcpListToolsCompleted)
                value.mcpListToolsFailed != null -> generator.writeObject(value.mcpListToolsFailed)
                value.responseMcpCallArgumentsDelta != null ->
                    generator.writeObject(value.responseMcpCallArgumentsDelta)
                value.responseMcpCallArgumentsDone != null ->
                    generator.writeObject(value.responseMcpCallArgumentsDone)
                value.responseMcpCallInProgress != null ->
                    generator.writeObject(value.responseMcpCallInProgress)
                value.responseMcpCallCompleted != null ->
                    generator.writeObject(value.responseMcpCallCompleted)
                value.responseMcpCallFailed != null ->
                    generator.writeObject(value.responseMcpCallFailed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeServerEvent")
            }
        }
    }

    /**
     * Returned when a conversation item is retrieved with `conversation.item.retrieve`. This is
     * provided as a way to fetch the server's representation of an item, for example to get access
     * to the post-processed audio data after noise cancellation and VAD. It includes the full
     * content of the Item, including audio data.
     */
    class ConversationItemRetrieved
    private constructor(
        private val eventId: JsonField<String>,
        private val item: JsonField<ConversationItem>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("item")
            @ExcludeMissing
            item: JsonField<ConversationItem> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(eventId, item, type, mutableMapOf())

        /**
         * The unique ID of the server event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * A single item within a Realtime conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun item(): ConversationItem = item.getRequired("item")

        /**
         * The event type, must be `conversation.item.retrieved`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("conversation.item.retrieved")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [item].
         *
         * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ConversationItem> = item

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
             * [ConversationItemRetrieved].
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .item()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ConversationItemRetrieved]. */
        class Builder internal constructor() {

            private var eventId: JsonField<String>? = null
            private var item: JsonField<ConversationItem>? = null
            private var type: JsonValue = JsonValue.from("conversation.item.retrieved")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(conversationItemRetrieved: ConversationItemRetrieved) = apply {
                eventId = conversationItemRetrieved.eventId
                item = conversationItemRetrieved.item
                type = conversationItemRetrieved.type
                additionalProperties = conversationItemRetrieved.additionalProperties.toMutableMap()
            }

            /** The unique ID of the server event. */
            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** A single item within a Realtime conversation. */
            fun item(item: ConversationItem) = item(JsonField.of(item))

            /**
             * Sets [Builder.item] to an arbitrary JSON value.
             *
             * You should usually call [Builder.item] with a well-typed [ConversationItem] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun item(item: JsonField<ConversationItem>) = apply { this.item = item }

            /**
             * Alias for calling [item] with
             * `ConversationItem.ofRealtimeConversationItemSystemMessage(realtimeConversationItemSystemMessage)`.
             */
            fun item(realtimeConversationItemSystemMessage: RealtimeConversationItemSystemMessage) =
                item(
                    ConversationItem.ofRealtimeConversationItemSystemMessage(
                        realtimeConversationItemSystemMessage
                    )
                )

            /**
             * Alias for calling [item] with the following:
             * ```java
             * RealtimeConversationItemSystemMessage.builder()
             *     .content(content)
             *     .build()
             * ```
             */
            fun realtimeConversationItemSystemMessageItem(
                content: List<RealtimeConversationItemSystemMessage.Content>
            ) = item(RealtimeConversationItemSystemMessage.builder().content(content).build())

            /**
             * Alias for calling [item] with
             * `ConversationItem.ofRealtimeConversationItemUserMessage(realtimeConversationItemUserMessage)`.
             */
            fun item(realtimeConversationItemUserMessage: RealtimeConversationItemUserMessage) =
                item(
                    ConversationItem.ofRealtimeConversationItemUserMessage(
                        realtimeConversationItemUserMessage
                    )
                )

            /**
             * Alias for calling [item] with the following:
             * ```java
             * RealtimeConversationItemUserMessage.builder()
             *     .content(content)
             *     .build()
             * ```
             */
            fun realtimeConversationItemUserMessageItem(
                content: List<RealtimeConversationItemUserMessage.Content>
            ) = item(RealtimeConversationItemUserMessage.builder().content(content).build())

            /**
             * Alias for calling [item] with
             * `ConversationItem.ofRealtimeConversationItemAssistantMessage(realtimeConversationItemAssistantMessage)`.
             */
            fun item(
                realtimeConversationItemAssistantMessage: RealtimeConversationItemAssistantMessage
            ) =
                item(
                    ConversationItem.ofRealtimeConversationItemAssistantMessage(
                        realtimeConversationItemAssistantMessage
                    )
                )

            /**
             * Alias for calling [item] with the following:
             * ```java
             * RealtimeConversationItemAssistantMessage.builder()
             *     .content(content)
             *     .build()
             * ```
             */
            fun realtimeConversationItemAssistantMessageItem(
                content: List<RealtimeConversationItemAssistantMessage.Content>
            ) = item(RealtimeConversationItemAssistantMessage.builder().content(content).build())

            /** Alias for calling [item] with `ConversationItem.ofFunctionCall(functionCall)`. */
            fun item(functionCall: RealtimeConversationItemFunctionCall) =
                item(ConversationItem.ofFunctionCall(functionCall))

            /**
             * Alias for calling [item] with
             * `ConversationItem.ofFunctionCallOutput(functionCallOutput)`.
             */
            fun item(functionCallOutput: RealtimeConversationItemFunctionCallOutput) =
                item(ConversationItem.ofFunctionCallOutput(functionCallOutput))

            /**
             * Alias for calling [item] with
             * `ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
             */
            fun item(mcpApprovalResponse: RealtimeMcpApprovalResponse) =
                item(ConversationItem.ofMcpApprovalResponse(mcpApprovalResponse))

            /** Alias for calling [item] with `ConversationItem.ofMcpListTools(mcpListTools)`. */
            fun item(mcpListTools: RealtimeMcpListTools) =
                item(ConversationItem.ofMcpListTools(mcpListTools))

            /** Alias for calling [item] with `ConversationItem.ofMcpToolCall(mcpToolCall)`. */
            fun item(mcpToolCall: RealtimeMcpToolCall) =
                item(ConversationItem.ofMcpToolCall(mcpToolCall))

            /**
             * Alias for calling [item] with
             * `ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
             */
            fun item(mcpApprovalRequest: RealtimeMcpApprovalRequest) =
                item(ConversationItem.ofMcpApprovalRequest(mcpApprovalRequest))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("conversation.item.retrieved")
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
             * Returns an immutable instance of [ConversationItemRetrieved].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .item()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ConversationItemRetrieved =
                ConversationItemRetrieved(
                    checkRequired("eventId", eventId),
                    checkRequired("item", item),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): ConversationItemRetrieved = apply {
            if (validated) {
                return@apply
            }

            eventId()
            item().validate()
            _type().let {
                if (it != JsonValue.from("conversation.item.retrieved")) {
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
                (item.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("conversation.item.retrieved")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ConversationItemRetrieved &&
                eventId == other.eventId &&
                item == other.item &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventId, item, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ConversationItemRetrieved{eventId=$eventId, item=$item, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * **WebRTC Only:** Emitted when the server begins streaming audio to the client. This event is
     * emitted after an audio content part has been added (`response.content_part.added`) to the
     * response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    class OutputAudioBufferStarted
    private constructor(
        private val eventId: JsonField<String>,
        private val responseId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("response_id")
            @ExcludeMissing
            responseId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(eventId, responseId, type, mutableMapOf())

        /**
         * The unique ID of the server event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * The unique ID of the response that produced the audio.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun responseId(): String = responseId.getRequired("response_id")

        /**
         * The event type, must be `output_audio_buffer.started`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("output_audio_buffer.started")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [responseId].
         *
         * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response_id")
        @ExcludeMissing
        fun _responseId(): JsonField<String> = responseId

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
             * Returns a mutable builder for constructing an instance of [OutputAudioBufferStarted].
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .responseId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputAudioBufferStarted]. */
        class Builder internal constructor() {

            private var eventId: JsonField<String>? = null
            private var responseId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("output_audio_buffer.started")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputAudioBufferStarted: OutputAudioBufferStarted) = apply {
                eventId = outputAudioBufferStarted.eventId
                responseId = outputAudioBufferStarted.responseId
                type = outputAudioBufferStarted.type
                additionalProperties = outputAudioBufferStarted.additionalProperties.toMutableMap()
            }

            /** The unique ID of the server event. */
            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** The unique ID of the response that produced the audio. */
            fun responseId(responseId: String) = responseId(JsonField.of(responseId))

            /**
             * Sets [Builder.responseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("output_audio_buffer.started")
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
             * Returns an immutable instance of [OutputAudioBufferStarted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .responseId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OutputAudioBufferStarted =
                OutputAudioBufferStarted(
                    checkRequired("eventId", eventId),
                    checkRequired("responseId", responseId),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OutputAudioBufferStarted = apply {
            if (validated) {
                return@apply
            }

            eventId()
            responseId()
            _type().let {
                if (it != JsonValue.from("output_audio_buffer.started")) {
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
                (if (responseId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("output_audio_buffer.started")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputAudioBufferStarted &&
                eventId == other.eventId &&
                responseId == other.responseId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventId, responseId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputAudioBufferStarted{eventId=$eventId, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * **WebRTC Only:** Emitted when the output audio buffer has been completely drained on the
     * server, and no more audio is forthcoming. This event is emitted after the full response data
     * has been sent to the client (`response.done`).
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    class OutputAudioBufferStopped
    private constructor(
        private val eventId: JsonField<String>,
        private val responseId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("response_id")
            @ExcludeMissing
            responseId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(eventId, responseId, type, mutableMapOf())

        /**
         * The unique ID of the server event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * The unique ID of the response that produced the audio.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun responseId(): String = responseId.getRequired("response_id")

        /**
         * The event type, must be `output_audio_buffer.stopped`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("output_audio_buffer.stopped")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [responseId].
         *
         * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response_id")
        @ExcludeMissing
        fun _responseId(): JsonField<String> = responseId

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
             * Returns a mutable builder for constructing an instance of [OutputAudioBufferStopped].
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .responseId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputAudioBufferStopped]. */
        class Builder internal constructor() {

            private var eventId: JsonField<String>? = null
            private var responseId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("output_audio_buffer.stopped")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputAudioBufferStopped: OutputAudioBufferStopped) = apply {
                eventId = outputAudioBufferStopped.eventId
                responseId = outputAudioBufferStopped.responseId
                type = outputAudioBufferStopped.type
                additionalProperties = outputAudioBufferStopped.additionalProperties.toMutableMap()
            }

            /** The unique ID of the server event. */
            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** The unique ID of the response that produced the audio. */
            fun responseId(responseId: String) = responseId(JsonField.of(responseId))

            /**
             * Sets [Builder.responseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("output_audio_buffer.stopped")
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
             * Returns an immutable instance of [OutputAudioBufferStopped].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .responseId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OutputAudioBufferStopped =
                OutputAudioBufferStopped(
                    checkRequired("eventId", eventId),
                    checkRequired("responseId", responseId),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OutputAudioBufferStopped = apply {
            if (validated) {
                return@apply
            }

            eventId()
            responseId()
            _type().let {
                if (it != JsonValue.from("output_audio_buffer.stopped")) {
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
                (if (responseId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("output_audio_buffer.stopped")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputAudioBufferStopped &&
                eventId == other.eventId &&
                responseId == other.responseId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventId, responseId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputAudioBufferStopped{eventId=$eventId, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * **WebRTC Only:** Emitted when the output audio buffer is cleared. This happens either in VAD
     * mode when the user has interrupted (`input_audio_buffer.speech_started`), or when the client
     * has emitted the `output_audio_buffer.clear` event to manually cut off the current audio
     * response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    class OutputAudioBufferCleared
    private constructor(
        private val eventId: JsonField<String>,
        private val responseId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("response_id")
            @ExcludeMissing
            responseId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(eventId, responseId, type, mutableMapOf())

        /**
         * The unique ID of the server event.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun eventId(): String = eventId.getRequired("event_id")

        /**
         * The unique ID of the response that produced the audio.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun responseId(): String = responseId.getRequired("response_id")

        /**
         * The event type, must be `output_audio_buffer.cleared`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("output_audio_buffer.cleared")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [eventId].
         *
         * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

        /**
         * Returns the raw JSON value of [responseId].
         *
         * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("response_id")
        @ExcludeMissing
        fun _responseId(): JsonField<String> = responseId

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
             * Returns a mutable builder for constructing an instance of [OutputAudioBufferCleared].
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .responseId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputAudioBufferCleared]. */
        class Builder internal constructor() {

            private var eventId: JsonField<String>? = null
            private var responseId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("output_audio_buffer.cleared")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputAudioBufferCleared: OutputAudioBufferCleared) = apply {
                eventId = outputAudioBufferCleared.eventId
                responseId = outputAudioBufferCleared.responseId
                type = outputAudioBufferCleared.type
                additionalProperties = outputAudioBufferCleared.additionalProperties.toMutableMap()
            }

            /** The unique ID of the server event. */
            fun eventId(eventId: String) = eventId(JsonField.of(eventId))

            /**
             * Sets [Builder.eventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

            /** The unique ID of the response that produced the audio. */
            fun responseId(responseId: String) = responseId(JsonField.of(responseId))

            /**
             * Sets [Builder.responseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("output_audio_buffer.cleared")
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
             * Returns an immutable instance of [OutputAudioBufferCleared].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .eventId()
             * .responseId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OutputAudioBufferCleared =
                OutputAudioBufferCleared(
                    checkRequired("eventId", eventId),
                    checkRequired("responseId", responseId),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OutputAudioBufferCleared = apply {
            if (validated) {
                return@apply
            }

            eventId()
            responseId()
            _type().let {
                if (it != JsonValue.from("output_audio_buffer.cleared")) {
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
                (if (responseId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("output_audio_buffer.cleared")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputAudioBufferCleared &&
                eventId == other.eventId &&
                responseId == other.responseId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventId, responseId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputAudioBufferCleared{eventId=$eventId, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
    }
}
