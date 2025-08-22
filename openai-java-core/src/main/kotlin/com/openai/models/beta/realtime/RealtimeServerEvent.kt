// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
    private val error: ErrorEvent? = null,
    private val inputAudioBufferCleared: InputAudioBufferClearedEvent? = null,
    private val inputAudioBufferCommitted: InputAudioBufferCommittedEvent? = null,
    private val inputAudioBufferSpeechStarted: InputAudioBufferSpeechStartedEvent? = null,
    private val inputAudioBufferSpeechStopped: InputAudioBufferSpeechStoppedEvent? = null,
    private val rateLimitsUpdated: RateLimitsUpdatedEvent? = null,
    private val responseAudioDelta: ResponseAudioDeltaEvent? = null,
    private val responseAudioDone: ResponseAudioDoneEvent? = null,
    private val responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent? = null,
    private val responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent? = null,
    private val responseContentPartAdded: ResponseContentPartAddedEvent? = null,
    private val responseContentPartDone: ResponseContentPartDoneEvent? = null,
    private val responseCreated: ResponseCreatedEvent? = null,
    private val responseDone: ResponseDoneEvent? = null,
    private val responseFunctionCallArgumentsDelta: ResponseFunctionCallArgumentsDeltaEvent? = null,
    private val responseFunctionCallArgumentsDone: ResponseFunctionCallArgumentsDoneEvent? = null,
    private val responseOutputItemAdded: ResponseOutputItemAddedEvent? = null,
    private val responseOutputItemDone: ResponseOutputItemDoneEvent? = null,
    private val responseTextDelta: ResponseTextDeltaEvent? = null,
    private val responseTextDone: ResponseTextDoneEvent? = null,
    private val sessionCreated: SessionCreatedEvent? = null,
    private val sessionUpdated: SessionUpdatedEvent? = null,
    private val transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent? = null,
    private val outputAudioBufferStarted: OutputAudioBufferStarted? = null,
    private val outputAudioBufferStopped: OutputAudioBufferStopped? = null,
    private val outputAudioBufferCleared: OutputAudioBufferCleared? = null,
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
     * (in `server_vad` mode). Transcription runs asynchronously with Response creation, so this
     * event may come before or after the Response events.
     *
     * Realtime API models accept audio natively, and thus input transcription is a separate process
     * run on a separate ASR (Automatic Speech Recognition) model. The transcript may diverge
     * somewhat from the model's interpretation, and should be treated as a rough guide.
     */
    fun conversationItemInputAudioTranscriptionCompleted():
        Optional<ConversationItemInputAudioTranscriptionCompletedEvent> =
        Optional.ofNullable(conversationItemInputAudioTranscriptionCompleted)

    /** Returned when the text value of an input audio transcription content part is updated. */
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

    /** Returned when a conversation item is retrieved with `conversation.item.retrieve`. */
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
    fun error(): Optional<ErrorEvent> = Optional.ofNullable(error)

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
    fun responseAudioDelta(): Optional<ResponseAudioDeltaEvent> =
        Optional.ofNullable(responseAudioDelta)

    /**
     * Returned when the model-generated audio is done. Also emitted when a Response is interrupted,
     * incomplete, or cancelled.
     */
    fun responseAudioDone(): Optional<ResponseAudioDoneEvent> =
        Optional.ofNullable(responseAudioDone)

    /** Returned when the model-generated transcription of audio output is updated. */
    fun responseAudioTranscriptDelta(): Optional<ResponseAudioTranscriptDeltaEvent> =
        Optional.ofNullable(responseAudioTranscriptDelta)

    /**
     * Returned when the model-generated transcription of audio output is done streaming. Also
     * emitted when a Response is interrupted, incomplete, or cancelled.
     */
    fun responseAudioTranscriptDone(): Optional<ResponseAudioTranscriptDoneEvent> =
        Optional.ofNullable(responseAudioTranscriptDone)

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

    /** Returned when the text value of a "text" content part is updated. */
    fun responseTextDelta(): Optional<ResponseTextDeltaEvent> =
        Optional.ofNullable(responseTextDelta)

    /**
     * Returned when the text value of a "text" content part is done streaming. Also emitted when a
     * Response is interrupted, incomplete, or cancelled.
     */
    fun responseTextDone(): Optional<ResponseTextDoneEvent> = Optional.ofNullable(responseTextDone)

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

    fun isResponseAudioDelta(): Boolean = responseAudioDelta != null

    fun isResponseAudioDone(): Boolean = responseAudioDone != null

    fun isResponseAudioTranscriptDelta(): Boolean = responseAudioTranscriptDelta != null

    fun isResponseAudioTranscriptDone(): Boolean = responseAudioTranscriptDone != null

    fun isResponseContentPartAdded(): Boolean = responseContentPartAdded != null

    fun isResponseContentPartDone(): Boolean = responseContentPartDone != null

    fun isResponseCreated(): Boolean = responseCreated != null

    fun isResponseDone(): Boolean = responseDone != null

    fun isResponseFunctionCallArgumentsDelta(): Boolean = responseFunctionCallArgumentsDelta != null

    fun isResponseFunctionCallArgumentsDone(): Boolean = responseFunctionCallArgumentsDone != null

    fun isResponseOutputItemAdded(): Boolean = responseOutputItemAdded != null

    fun isResponseOutputItemDone(): Boolean = responseOutputItemDone != null

    fun isResponseTextDelta(): Boolean = responseTextDelta != null

    fun isResponseTextDone(): Boolean = responseTextDone != null

    fun isSessionCreated(): Boolean = sessionCreated != null

    fun isSessionUpdated(): Boolean = sessionUpdated != null

    fun isTranscriptionSessionUpdated(): Boolean = transcriptionSessionUpdated != null

    fun isOutputAudioBufferStarted(): Boolean = outputAudioBufferStarted != null

    fun isOutputAudioBufferStopped(): Boolean = outputAudioBufferStopped != null

    fun isOutputAudioBufferCleared(): Boolean = outputAudioBufferCleared != null

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
     * (in `server_vad` mode). Transcription runs asynchronously with Response creation, so this
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

    /** Returned when the text value of an input audio transcription content part is updated. */
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

    /** Returned when a conversation item is retrieved with `conversation.item.retrieve`. */
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
    fun asError(): ErrorEvent = error.getOrThrow("error")

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
    fun asResponseAudioDelta(): ResponseAudioDeltaEvent =
        responseAudioDelta.getOrThrow("responseAudioDelta")

    /**
     * Returned when the model-generated audio is done. Also emitted when a Response is interrupted,
     * incomplete, or cancelled.
     */
    fun asResponseAudioDone(): ResponseAudioDoneEvent =
        responseAudioDone.getOrThrow("responseAudioDone")

    /** Returned when the model-generated transcription of audio output is updated. */
    fun asResponseAudioTranscriptDelta(): ResponseAudioTranscriptDeltaEvent =
        responseAudioTranscriptDelta.getOrThrow("responseAudioTranscriptDelta")

    /**
     * Returned when the model-generated transcription of audio output is done streaming. Also
     * emitted when a Response is interrupted, incomplete, or cancelled.
     */
    fun asResponseAudioTranscriptDone(): ResponseAudioTranscriptDoneEvent =
        responseAudioTranscriptDone.getOrThrow("responseAudioTranscriptDone")

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

    /** Returned when the text value of a "text" content part is updated. */
    fun asResponseTextDelta(): ResponseTextDeltaEvent =
        responseTextDelta.getOrThrow("responseTextDelta")

    /**
     * Returned when the text value of a "text" content part is done streaming. Also emitted when a
     * Response is interrupted, incomplete, or cancelled.
     */
    fun asResponseTextDone(): ResponseTextDoneEvent =
        responseTextDone.getOrThrow("responseTextDone")

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
            responseAudioDelta != null -> visitor.visitResponseAudioDelta(responseAudioDelta)
            responseAudioDone != null -> visitor.visitResponseAudioDone(responseAudioDone)
            responseAudioTranscriptDelta != null ->
                visitor.visitResponseAudioTranscriptDelta(responseAudioTranscriptDelta)
            responseAudioTranscriptDone != null ->
                visitor.visitResponseAudioTranscriptDone(responseAudioTranscriptDone)
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
            responseTextDelta != null -> visitor.visitResponseTextDelta(responseTextDelta)
            responseTextDone != null -> visitor.visitResponseTextDone(responseTextDone)
            sessionCreated != null -> visitor.visitSessionCreated(sessionCreated)
            sessionUpdated != null -> visitor.visitSessionUpdated(sessionUpdated)
            transcriptionSessionUpdated != null ->
                visitor.visitTranscriptionSessionUpdated(transcriptionSessionUpdated)
            outputAudioBufferStarted != null ->
                visitor.visitOutputAudioBufferStarted(outputAudioBufferStarted)
            outputAudioBufferStopped != null ->
                visitor.visitOutputAudioBufferStopped(outputAudioBufferStopped)
            outputAudioBufferCleared != null ->
                visitor.visitOutputAudioBufferCleared(outputAudioBufferCleared)
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

                override fun visitError(error: ErrorEvent) {
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

                override fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent) {
                    responseAudioDelta.validate()
                }

                override fun visitResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent) {
                    responseAudioDone.validate()
                }

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) {
                    responseAudioTranscriptDelta.validate()
                }

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) {
                    responseAudioTranscriptDone.validate()
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

                override fun visitResponseTextDelta(responseTextDelta: ResponseTextDeltaEvent) {
                    responseTextDelta.validate()
                }

                override fun visitResponseTextDone(responseTextDone: ResponseTextDoneEvent) {
                    responseTextDone.validate()
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

                override fun visitError(error: ErrorEvent) = error.validity()

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

                override fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent) =
                    responseAudioDelta.validity()

                override fun visitResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent) =
                    responseAudioDone.validity()

                override fun visitResponseAudioTranscriptDelta(
                    responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
                ) = responseAudioTranscriptDelta.validity()

                override fun visitResponseAudioTranscriptDone(
                    responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
                ) = responseAudioTranscriptDone.validity()

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

                override fun visitResponseTextDelta(responseTextDelta: ResponseTextDeltaEvent) =
                    responseTextDelta.validity()

                override fun visitResponseTextDone(responseTextDone: ResponseTextDoneEvent) =
                    responseTextDone.validity()

                override fun visitSessionCreated(sessionCreated: SessionCreatedEvent) =
                    sessionCreated.validity()

                override fun visitSessionUpdated(sessionUpdated: SessionUpdatedEvent) =
                    sessionUpdated.validity()

                override fun visitTranscriptionSessionUpdated(
                    transcriptionSessionUpdated: TranscriptionSessionUpdatedEvent
                ) = transcriptionSessionUpdated.validity()

                override fun visitOutputAudioBufferStarted(
                    outputAudioBufferStarted: OutputAudioBufferStarted
                ) = outputAudioBufferStarted.validity()

                override fun visitOutputAudioBufferStopped(
                    outputAudioBufferStopped: OutputAudioBufferStopped
                ) = outputAudioBufferStopped.validity()

                override fun visitOutputAudioBufferCleared(
                    outputAudioBufferCleared: OutputAudioBufferCleared
                ) = outputAudioBufferCleared.validity()

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
            responseAudioDelta == other.responseAudioDelta &&
            responseAudioDone == other.responseAudioDone &&
            responseAudioTranscriptDelta == other.responseAudioTranscriptDelta &&
            responseAudioTranscriptDone == other.responseAudioTranscriptDone &&
            responseContentPartAdded == other.responseContentPartAdded &&
            responseContentPartDone == other.responseContentPartDone &&
            responseCreated == other.responseCreated &&
            responseDone == other.responseDone &&
            responseFunctionCallArgumentsDelta == other.responseFunctionCallArgumentsDelta &&
            responseFunctionCallArgumentsDone == other.responseFunctionCallArgumentsDone &&
            responseOutputItemAdded == other.responseOutputItemAdded &&
            responseOutputItemDone == other.responseOutputItemDone &&
            responseTextDelta == other.responseTextDelta &&
            responseTextDone == other.responseTextDone &&
            sessionCreated == other.sessionCreated &&
            sessionUpdated == other.sessionUpdated &&
            transcriptionSessionUpdated == other.transcriptionSessionUpdated &&
            outputAudioBufferStarted == other.outputAudioBufferStarted &&
            outputAudioBufferStopped == other.outputAudioBufferStopped &&
            outputAudioBufferCleared == other.outputAudioBufferCleared
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
            responseAudioDelta,
            responseAudioDone,
            responseAudioTranscriptDelta,
            responseAudioTranscriptDone,
            responseContentPartAdded,
            responseContentPartDone,
            responseCreated,
            responseDone,
            responseFunctionCallArgumentsDelta,
            responseFunctionCallArgumentsDone,
            responseOutputItemAdded,
            responseOutputItemDone,
            responseTextDelta,
            responseTextDone,
            sessionCreated,
            sessionUpdated,
            transcriptionSessionUpdated,
            outputAudioBufferStarted,
            outputAudioBufferStopped,
            outputAudioBufferCleared,
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
            responseAudioDelta != null ->
                "RealtimeServerEvent{responseAudioDelta=$responseAudioDelta}"
            responseAudioDone != null -> "RealtimeServerEvent{responseAudioDone=$responseAudioDone}"
            responseAudioTranscriptDelta != null ->
                "RealtimeServerEvent{responseAudioTranscriptDelta=$responseAudioTranscriptDelta}"
            responseAudioTranscriptDone != null ->
                "RealtimeServerEvent{responseAudioTranscriptDone=$responseAudioTranscriptDone}"
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
            responseTextDelta != null -> "RealtimeServerEvent{responseTextDelta=$responseTextDelta}"
            responseTextDone != null -> "RealtimeServerEvent{responseTextDone=$responseTextDone}"
            sessionCreated != null -> "RealtimeServerEvent{sessionCreated=$sessionCreated}"
            sessionUpdated != null -> "RealtimeServerEvent{sessionUpdated=$sessionUpdated}"
            transcriptionSessionUpdated != null ->
                "RealtimeServerEvent{transcriptionSessionUpdated=$transcriptionSessionUpdated}"
            outputAudioBufferStarted != null ->
                "RealtimeServerEvent{outputAudioBufferStarted=$outputAudioBufferStarted}"
            outputAudioBufferStopped != null ->
                "RealtimeServerEvent{outputAudioBufferStopped=$outputAudioBufferStopped}"
            outputAudioBufferCleared != null ->
                "RealtimeServerEvent{outputAudioBufferCleared=$outputAudioBufferCleared}"
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
         * server (in `server_vad` mode). Transcription runs asynchronously with Response creation,
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

        /** Returned when the text value of an input audio transcription content part is updated. */
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

        /** Returned when a conversation item is retrieved with `conversation.item.retrieve`. */
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
        @JvmStatic fun ofError(error: ErrorEvent) = RealtimeServerEvent(error = error)

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
        fun ofResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent) =
            RealtimeServerEvent(responseAudioDelta = responseAudioDelta)

        /**
         * Returned when the model-generated audio is done. Also emitted when a Response is
         * interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent) =
            RealtimeServerEvent(responseAudioDone = responseAudioDone)

        /** Returned when the model-generated transcription of audio output is updated. */
        @JvmStatic
        fun ofResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
        ) = RealtimeServerEvent(responseAudioTranscriptDelta = responseAudioTranscriptDelta)

        /**
         * Returned when the model-generated transcription of audio output is done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseAudioTranscriptDone(
            responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
        ) = RealtimeServerEvent(responseAudioTranscriptDone = responseAudioTranscriptDone)

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

        /** Returned when the text value of a "text" content part is updated. */
        @JvmStatic
        fun ofResponseTextDelta(responseTextDelta: ResponseTextDeltaEvent) =
            RealtimeServerEvent(responseTextDelta = responseTextDelta)

        /**
         * Returned when the text value of a "text" content part is done streaming. Also emitted
         * when a Response is interrupted, incomplete, or cancelled.
         */
        @JvmStatic
        fun ofResponseTextDone(responseTextDone: ResponseTextDoneEvent) =
            RealtimeServerEvent(responseTextDone = responseTextDone)

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
         * server (in `server_vad` mode). Transcription runs asynchronously with Response creation,
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

        /** Returned when the text value of an input audio transcription content part is updated. */
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

        /** Returned when a conversation item is retrieved with `conversation.item.retrieve`. */
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
        fun visitError(error: ErrorEvent): T

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
        fun visitResponseAudioDelta(responseAudioDelta: ResponseAudioDeltaEvent): T

        /**
         * Returned when the model-generated audio is done. Also emitted when a Response is
         * interrupted, incomplete, or cancelled.
         */
        fun visitResponseAudioDone(responseAudioDone: ResponseAudioDoneEvent): T

        /** Returned when the model-generated transcription of audio output is updated. */
        fun visitResponseAudioTranscriptDelta(
            responseAudioTranscriptDelta: ResponseAudioTranscriptDeltaEvent
        ): T

        /**
         * Returned when the model-generated transcription of audio output is done streaming. Also
         * emitted when a Response is interrupted, incomplete, or cancelled.
         */
        fun visitResponseAudioTranscriptDone(
            responseAudioTranscriptDone: ResponseAudioTranscriptDoneEvent
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

        /** Returned when the text value of a "text" content part is updated. */
        fun visitResponseTextDelta(responseTextDelta: ResponseTextDeltaEvent): T

        /**
         * Returned when the text value of a "text" content part is done streaming. Also emitted
         * when a Response is interrupted, incomplete, or cancelled.
         */
        fun visitResponseTextDone(responseTextDone: ResponseTextDoneEvent): T

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
                    return tryDeserialize(node, jacksonTypeRef<ErrorEvent>())?.let {
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
                "response.audio.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDeltaEvent>())?.let {
                        RealtimeServerEvent(responseAudioDelta = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.audio.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioDoneEvent>())?.let {
                        RealtimeServerEvent(responseAudioDone = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.audio_transcript.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>())
                        ?.let {
                            RealtimeServerEvent(responseAudioTranscriptDelta = it, _json = json)
                        } ?: RealtimeServerEvent(_json = json)
                }
                "response.audio_transcript.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseAudioTranscriptDoneEvent>())
                        ?.let {
                            RealtimeServerEvent(responseAudioTranscriptDone = it, _json = json)
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
                "response.text.delta" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDeltaEvent>())?.let {
                        RealtimeServerEvent(responseTextDelta = it, _json = json)
                    } ?: RealtimeServerEvent(_json = json)
                }
                "response.text.done" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseTextDoneEvent>())?.let {
                        RealtimeServerEvent(responseTextDone = it, _json = json)
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
                value.responseAudioDelta != null -> generator.writeObject(value.responseAudioDelta)
                value.responseAudioDone != null -> generator.writeObject(value.responseAudioDone)
                value.responseAudioTranscriptDelta != null ->
                    generator.writeObject(value.responseAudioTranscriptDelta)
                value.responseAudioTranscriptDone != null ->
                    generator.writeObject(value.responseAudioTranscriptDone)
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
                value.responseTextDelta != null -> generator.writeObject(value.responseTextDelta)
                value.responseTextDone != null -> generator.writeObject(value.responseTextDone)
                value.sessionCreated != null -> generator.writeObject(value.sessionCreated)
                value.sessionUpdated != null -> generator.writeObject(value.sessionUpdated)
                value.transcriptionSessionUpdated != null ->
                    generator.writeObject(value.transcriptionSessionUpdated)
                value.outputAudioBufferStarted != null ->
                    generator.writeObject(value.outputAudioBufferStarted)
                value.outputAudioBufferStopped != null ->
                    generator.writeObject(value.outputAudioBufferStopped)
                value.outputAudioBufferCleared != null ->
                    generator.writeObject(value.outputAudioBufferCleared)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeServerEvent")
            }
        }
    }

    /** Returned when a conversation item is retrieved with `conversation.item.retrieve`. */
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
         * The item to add to the conversation.
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

            /** The item to add to the conversation. */
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
                putAlladditional_properties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAlladditional_properties(keys: Set<String>) = apply {
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
                putAlladditional_properties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAlladditional_properties(keys: Set<String>) = apply {
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
                putAlladditional_properties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAlladditional_properties(keys: Set<String>) = apply {
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
                putAlladditional_properties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAlladditional_properties(keys: Set<String>) = apply {
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
