// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A realtime client event. */
@JsonDeserialize(using = RealtimeClientEvent.Deserializer::class)
@JsonSerialize(using = RealtimeClientEvent.Serializer::class)
class RealtimeClientEvent
private constructor(
    private val conversationItemCreate: ConversationItemCreateEvent? = null,
    private val conversationItemDelete: ConversationItemDeleteEvent? = null,
    private val conversationItemRetrieve: ConversationItemRetrieveEvent? = null,
    private val conversationItemTruncate: ConversationItemTruncateEvent? = null,
    private val inputAudioBufferAppend: InputAudioBufferAppendEvent? = null,
    private val inputAudioBufferClear: InputAudioBufferClearEvent? = null,
    private val outputAudioBufferClear: OutputAudioBufferClearEvent? = null,
    private val inputAudioBufferCommit: InputAudioBufferCommitEvent? = null,
    private val responseCancel: ResponseCancelEvent? = null,
    private val responseCreate: ResponseCreateEvent? = null,
    private val sessionUpdate: SessionUpdateEvent? = null,
    private val transcriptionSessionUpdate: TranscriptionSessionUpdate? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Add a new Item to the Conversation's context, including messages, function calls, and
     * function call responses. This event can be used both to populate a "history" of the
     * conversation and to add new items mid-stream, but has the current limitation that it cannot
     * populate assistant audio messages.
     *
     * If successful, the server will respond with a `conversation.item.created` event, otherwise an
     * `error` event will be sent.
     */
    fun conversationItemCreate(): Optional<ConversationItemCreateEvent> =
        Optional.ofNullable(conversationItemCreate)

    /**
     * Send this event when you want to remove any item from the conversation history. The server
     * will respond with a `conversation.item.deleted` event, unless the item does not exist in the
     * conversation history, in which case the server will respond with an error.
     */
    fun conversationItemDelete(): Optional<ConversationItemDeleteEvent> =
        Optional.ofNullable(conversationItemDelete)

    /**
     * Send this event when you want to retrieve the server's representation of a specific item in
     * the conversation history. This is useful, for example, to inspect user audio after noise
     * cancellation and VAD. The server will respond with a `conversation.item.retrieved` event,
     * unless the item does not exist in the conversation history, in which case the server will
     * respond with an error.
     */
    fun conversationItemRetrieve(): Optional<ConversationItemRetrieveEvent> =
        Optional.ofNullable(conversationItemRetrieve)

    /**
     * Send this event to truncate a previous assistant message’s audio. The server will produce
     * audio faster than realtime, so this event is useful when the user interrupts to truncate
     * audio that has already been sent to the client but not yet played. This will synchronize the
     * server's understanding of the audio with the client's playback.
     *
     * Truncating audio will delete the server-side text transcript to ensure there is not text in
     * the context that hasn't been heard by the user.
     *
     * If successful, the server will respond with a `conversation.item.truncated` event.
     */
    fun conversationItemTruncate(): Optional<ConversationItemTruncateEvent> =
        Optional.ofNullable(conversationItemTruncate)

    /**
     * Send this event to append audio bytes to the input audio buffer. The audio buffer is
     * temporary storage you can write to and later commit. In Server VAD mode, the audio buffer is
     * used to detect speech and the server will decide when to commit. When Server VAD is disabled,
     * you must commit the audio buffer manually.
     *
     * The client may choose how much audio to place in each event up to a maximum of 15 MiB, for
     * example streaming smaller chunks from the client may allow the VAD to be more responsive.
     * Unlike made other client events, the server will not send a confirmation response to this
     * event.
     */
    fun inputAudioBufferAppend(): Optional<InputAudioBufferAppendEvent> =
        Optional.ofNullable(inputAudioBufferAppend)

    /**
     * Send this event to clear the audio bytes in the buffer. The server will respond with an
     * `input_audio_buffer.cleared` event.
     */
    fun inputAudioBufferClear(): Optional<InputAudioBufferClearEvent> =
        Optional.ofNullable(inputAudioBufferClear)

    /**
     * **WebRTC Only:** Emit to cut off the current audio response. This will trigger the server to
     * stop generating audio and emit a `output_audio_buffer.cleared` event. This event should be
     * preceded by a `response.cancel` client event to stop the generation of the current response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun outputAudioBufferClear(): Optional<OutputAudioBufferClearEvent> =
        Optional.ofNullable(outputAudioBufferClear)

    /**
     * Send this event to commit the user input audio buffer, which will create a new user message
     * item in the conversation. This event will produce an error if the input audio buffer is
     * empty. When in Server VAD mode, the client does not need to send this event, the server will
     * commit the audio buffer automatically.
     *
     * Committing the input audio buffer will trigger input audio transcription (if enabled in
     * session configuration), but it will not create a response from the model. The server will
     * respond with an `input_audio_buffer.committed` event.
     */
    fun inputAudioBufferCommit(): Optional<InputAudioBufferCommitEvent> =
        Optional.ofNullable(inputAudioBufferCommit)

    /**
     * Send this event to cancel an in-progress response. The server will respond with a
     * `response.done` event with a status of `response.status=cancelled`. If there is no response
     * to cancel, the server will respond with an error.
     */
    fun responseCancel(): Optional<ResponseCancelEvent> = Optional.ofNullable(responseCancel)

    /**
     * This event instructs the server to create a Response, which means triggering model inference.
     * When in Server VAD mode, the server will create Responses automatically.
     *
     * A Response will include at least one Item, and may have two, in which case the second will be
     * a function call. These Items will be appended to the conversation history.
     *
     * The server will respond with a `response.created` event, events for Items and content
     * created, and finally a `response.done` event to indicate the Response is complete.
     *
     * The `response.create` event includes inference configuration like `instructions`, and
     * `temperature`. These fields will override the Session's configuration for this Response only.
     */
    fun responseCreate(): Optional<ResponseCreateEvent> = Optional.ofNullable(responseCreate)

    /**
     * Send this event to update the session’s default configuration. The client may send this event
     * at any time to update any field, except for `voice`. However, note that once a session has
     * been initialized with a particular `model`, it can’t be changed to another model using
     * `session.update`.
     *
     * When the server receives a `session.update`, it will respond with a `session.updated` event
     * showing the full, effective configuration. Only the fields that are present are updated. To
     * clear a field like `instructions`, pass an empty string.
     */
    fun sessionUpdate(): Optional<SessionUpdateEvent> = Optional.ofNullable(sessionUpdate)

    /** Send this event to update a transcription session. */
    fun transcriptionSessionUpdate(): Optional<TranscriptionSessionUpdate> =
        Optional.ofNullable(transcriptionSessionUpdate)

    fun isConversationItemCreate(): Boolean = conversationItemCreate != null

    fun isConversationItemDelete(): Boolean = conversationItemDelete != null

    fun isConversationItemRetrieve(): Boolean = conversationItemRetrieve != null

    fun isConversationItemTruncate(): Boolean = conversationItemTruncate != null

    fun isInputAudioBufferAppend(): Boolean = inputAudioBufferAppend != null

    fun isInputAudioBufferClear(): Boolean = inputAudioBufferClear != null

    fun isOutputAudioBufferClear(): Boolean = outputAudioBufferClear != null

    fun isInputAudioBufferCommit(): Boolean = inputAudioBufferCommit != null

    fun isResponseCancel(): Boolean = responseCancel != null

    fun isResponseCreate(): Boolean = responseCreate != null

    fun isSessionUpdate(): Boolean = sessionUpdate != null

    fun isTranscriptionSessionUpdate(): Boolean = transcriptionSessionUpdate != null

    /**
     * Add a new Item to the Conversation's context, including messages, function calls, and
     * function call responses. This event can be used both to populate a "history" of the
     * conversation and to add new items mid-stream, but has the current limitation that it cannot
     * populate assistant audio messages.
     *
     * If successful, the server will respond with a `conversation.item.created` event, otherwise an
     * `error` event will be sent.
     */
    fun asConversationItemCreate(): ConversationItemCreateEvent =
        conversationItemCreate.getOrThrow("conversationItemCreate")

    /**
     * Send this event when you want to remove any item from the conversation history. The server
     * will respond with a `conversation.item.deleted` event, unless the item does not exist in the
     * conversation history, in which case the server will respond with an error.
     */
    fun asConversationItemDelete(): ConversationItemDeleteEvent =
        conversationItemDelete.getOrThrow("conversationItemDelete")

    /**
     * Send this event when you want to retrieve the server's representation of a specific item in
     * the conversation history. This is useful, for example, to inspect user audio after noise
     * cancellation and VAD. The server will respond with a `conversation.item.retrieved` event,
     * unless the item does not exist in the conversation history, in which case the server will
     * respond with an error.
     */
    fun asConversationItemRetrieve(): ConversationItemRetrieveEvent =
        conversationItemRetrieve.getOrThrow("conversationItemRetrieve")

    /**
     * Send this event to truncate a previous assistant message’s audio. The server will produce
     * audio faster than realtime, so this event is useful when the user interrupts to truncate
     * audio that has already been sent to the client but not yet played. This will synchronize the
     * server's understanding of the audio with the client's playback.
     *
     * Truncating audio will delete the server-side text transcript to ensure there is not text in
     * the context that hasn't been heard by the user.
     *
     * If successful, the server will respond with a `conversation.item.truncated` event.
     */
    fun asConversationItemTruncate(): ConversationItemTruncateEvent =
        conversationItemTruncate.getOrThrow("conversationItemTruncate")

    /**
     * Send this event to append audio bytes to the input audio buffer. The audio buffer is
     * temporary storage you can write to and later commit. In Server VAD mode, the audio buffer is
     * used to detect speech and the server will decide when to commit. When Server VAD is disabled,
     * you must commit the audio buffer manually.
     *
     * The client may choose how much audio to place in each event up to a maximum of 15 MiB, for
     * example streaming smaller chunks from the client may allow the VAD to be more responsive.
     * Unlike made other client events, the server will not send a confirmation response to this
     * event.
     */
    fun asInputAudioBufferAppend(): InputAudioBufferAppendEvent =
        inputAudioBufferAppend.getOrThrow("inputAudioBufferAppend")

    /**
     * Send this event to clear the audio bytes in the buffer. The server will respond with an
     * `input_audio_buffer.cleared` event.
     */
    fun asInputAudioBufferClear(): InputAudioBufferClearEvent =
        inputAudioBufferClear.getOrThrow("inputAudioBufferClear")

    /**
     * **WebRTC Only:** Emit to cut off the current audio response. This will trigger the server to
     * stop generating audio and emit a `output_audio_buffer.cleared` event. This event should be
     * preceded by a `response.cancel` client event to stop the generation of the current response.
     * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
     */
    fun asOutputAudioBufferClear(): OutputAudioBufferClearEvent =
        outputAudioBufferClear.getOrThrow("outputAudioBufferClear")

    /**
     * Send this event to commit the user input audio buffer, which will create a new user message
     * item in the conversation. This event will produce an error if the input audio buffer is
     * empty. When in Server VAD mode, the client does not need to send this event, the server will
     * commit the audio buffer automatically.
     *
     * Committing the input audio buffer will trigger input audio transcription (if enabled in
     * session configuration), but it will not create a response from the model. The server will
     * respond with an `input_audio_buffer.committed` event.
     */
    fun asInputAudioBufferCommit(): InputAudioBufferCommitEvent =
        inputAudioBufferCommit.getOrThrow("inputAudioBufferCommit")

    /**
     * Send this event to cancel an in-progress response. The server will respond with a
     * `response.done` event with a status of `response.status=cancelled`. If there is no response
     * to cancel, the server will respond with an error.
     */
    fun asResponseCancel(): ResponseCancelEvent = responseCancel.getOrThrow("responseCancel")

    /**
     * This event instructs the server to create a Response, which means triggering model inference.
     * When in Server VAD mode, the server will create Responses automatically.
     *
     * A Response will include at least one Item, and may have two, in which case the second will be
     * a function call. These Items will be appended to the conversation history.
     *
     * The server will respond with a `response.created` event, events for Items and content
     * created, and finally a `response.done` event to indicate the Response is complete.
     *
     * The `response.create` event includes inference configuration like `instructions`, and
     * `temperature`. These fields will override the Session's configuration for this Response only.
     */
    fun asResponseCreate(): ResponseCreateEvent = responseCreate.getOrThrow("responseCreate")

    /**
     * Send this event to update the session’s default configuration. The client may send this event
     * at any time to update any field, except for `voice`. However, note that once a session has
     * been initialized with a particular `model`, it can’t be changed to another model using
     * `session.update`.
     *
     * When the server receives a `session.update`, it will respond with a `session.updated` event
     * showing the full, effective configuration. Only the fields that are present are updated. To
     * clear a field like `instructions`, pass an empty string.
     */
    fun asSessionUpdate(): SessionUpdateEvent = sessionUpdate.getOrThrow("sessionUpdate")

    /** Send this event to update a transcription session. */
    fun asTranscriptionSessionUpdate(): TranscriptionSessionUpdate =
        transcriptionSessionUpdate.getOrThrow("transcriptionSessionUpdate")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            conversationItemCreate != null ->
                visitor.visitConversationItemCreate(conversationItemCreate)
            conversationItemDelete != null ->
                visitor.visitConversationItemDelete(conversationItemDelete)
            conversationItemRetrieve != null ->
                visitor.visitConversationItemRetrieve(conversationItemRetrieve)
            conversationItemTruncate != null ->
                visitor.visitConversationItemTruncate(conversationItemTruncate)
            inputAudioBufferAppend != null ->
                visitor.visitInputAudioBufferAppend(inputAudioBufferAppend)
            inputAudioBufferClear != null ->
                visitor.visitInputAudioBufferClear(inputAudioBufferClear)
            outputAudioBufferClear != null ->
                visitor.visitOutputAudioBufferClear(outputAudioBufferClear)
            inputAudioBufferCommit != null ->
                visitor.visitInputAudioBufferCommit(inputAudioBufferCommit)
            responseCancel != null -> visitor.visitResponseCancel(responseCancel)
            responseCreate != null -> visitor.visitResponseCreate(responseCreate)
            sessionUpdate != null -> visitor.visitSessionUpdate(sessionUpdate)
            transcriptionSessionUpdate != null ->
                visitor.visitTranscriptionSessionUpdate(transcriptionSessionUpdate)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeClientEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitConversationItemCreate(
                    conversationItemCreate: ConversationItemCreateEvent
                ) {
                    conversationItemCreate.validate()
                }

                override fun visitConversationItemDelete(
                    conversationItemDelete: ConversationItemDeleteEvent
                ) {
                    conversationItemDelete.validate()
                }

                override fun visitConversationItemRetrieve(
                    conversationItemRetrieve: ConversationItemRetrieveEvent
                ) {
                    conversationItemRetrieve.validate()
                }

                override fun visitConversationItemTruncate(
                    conversationItemTruncate: ConversationItemTruncateEvent
                ) {
                    conversationItemTruncate.validate()
                }

                override fun visitInputAudioBufferAppend(
                    inputAudioBufferAppend: InputAudioBufferAppendEvent
                ) {
                    inputAudioBufferAppend.validate()
                }

                override fun visitInputAudioBufferClear(
                    inputAudioBufferClear: InputAudioBufferClearEvent
                ) {
                    inputAudioBufferClear.validate()
                }

                override fun visitOutputAudioBufferClear(
                    outputAudioBufferClear: OutputAudioBufferClearEvent
                ) {
                    outputAudioBufferClear.validate()
                }

                override fun visitInputAudioBufferCommit(
                    inputAudioBufferCommit: InputAudioBufferCommitEvent
                ) {
                    inputAudioBufferCommit.validate()
                }

                override fun visitResponseCancel(responseCancel: ResponseCancelEvent) {
                    responseCancel.validate()
                }

                override fun visitResponseCreate(responseCreate: ResponseCreateEvent) {
                    responseCreate.validate()
                }

                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) {
                    sessionUpdate.validate()
                }

                override fun visitTranscriptionSessionUpdate(
                    transcriptionSessionUpdate: TranscriptionSessionUpdate
                ) {
                    transcriptionSessionUpdate.validate()
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
                override fun visitConversationItemCreate(
                    conversationItemCreate: ConversationItemCreateEvent
                ) = conversationItemCreate.validity()

                override fun visitConversationItemDelete(
                    conversationItemDelete: ConversationItemDeleteEvent
                ) = conversationItemDelete.validity()

                override fun visitConversationItemRetrieve(
                    conversationItemRetrieve: ConversationItemRetrieveEvent
                ) = conversationItemRetrieve.validity()

                override fun visitConversationItemTruncate(
                    conversationItemTruncate: ConversationItemTruncateEvent
                ) = conversationItemTruncate.validity()

                override fun visitInputAudioBufferAppend(
                    inputAudioBufferAppend: InputAudioBufferAppendEvent
                ) = inputAudioBufferAppend.validity()

                override fun visitInputAudioBufferClear(
                    inputAudioBufferClear: InputAudioBufferClearEvent
                ) = inputAudioBufferClear.validity()

                override fun visitOutputAudioBufferClear(
                    outputAudioBufferClear: OutputAudioBufferClearEvent
                ) = outputAudioBufferClear.validity()

                override fun visitInputAudioBufferCommit(
                    inputAudioBufferCommit: InputAudioBufferCommitEvent
                ) = inputAudioBufferCommit.validity()

                override fun visitResponseCancel(responseCancel: ResponseCancelEvent) =
                    responseCancel.validity()

                override fun visitResponseCreate(responseCreate: ResponseCreateEvent) =
                    responseCreate.validity()

                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) =
                    sessionUpdate.validity()

                override fun visitTranscriptionSessionUpdate(
                    transcriptionSessionUpdate: TranscriptionSessionUpdate
                ) = transcriptionSessionUpdate.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeClientEvent &&
            conversationItemCreate == other.conversationItemCreate &&
            conversationItemDelete == other.conversationItemDelete &&
            conversationItemRetrieve == other.conversationItemRetrieve &&
            conversationItemTruncate == other.conversationItemTruncate &&
            inputAudioBufferAppend == other.inputAudioBufferAppend &&
            inputAudioBufferClear == other.inputAudioBufferClear &&
            outputAudioBufferClear == other.outputAudioBufferClear &&
            inputAudioBufferCommit == other.inputAudioBufferCommit &&
            responseCancel == other.responseCancel &&
            responseCreate == other.responseCreate &&
            sessionUpdate == other.sessionUpdate &&
            transcriptionSessionUpdate == other.transcriptionSessionUpdate
    }

    override fun hashCode(): Int =
        Objects.hash(
            conversationItemCreate,
            conversationItemDelete,
            conversationItemRetrieve,
            conversationItemTruncate,
            inputAudioBufferAppend,
            inputAudioBufferClear,
            outputAudioBufferClear,
            inputAudioBufferCommit,
            responseCancel,
            responseCreate,
            sessionUpdate,
            transcriptionSessionUpdate,
        )

    override fun toString(): String =
        when {
            conversationItemCreate != null ->
                "RealtimeClientEvent{conversationItemCreate=$conversationItemCreate}"
            conversationItemDelete != null ->
                "RealtimeClientEvent{conversationItemDelete=$conversationItemDelete}"
            conversationItemRetrieve != null ->
                "RealtimeClientEvent{conversationItemRetrieve=$conversationItemRetrieve}"
            conversationItemTruncate != null ->
                "RealtimeClientEvent{conversationItemTruncate=$conversationItemTruncate}"
            inputAudioBufferAppend != null ->
                "RealtimeClientEvent{inputAudioBufferAppend=$inputAudioBufferAppend}"
            inputAudioBufferClear != null ->
                "RealtimeClientEvent{inputAudioBufferClear=$inputAudioBufferClear}"
            outputAudioBufferClear != null ->
                "RealtimeClientEvent{outputAudioBufferClear=$outputAudioBufferClear}"
            inputAudioBufferCommit != null ->
                "RealtimeClientEvent{inputAudioBufferCommit=$inputAudioBufferCommit}"
            responseCancel != null -> "RealtimeClientEvent{responseCancel=$responseCancel}"
            responseCreate != null -> "RealtimeClientEvent{responseCreate=$responseCreate}"
            sessionUpdate != null -> "RealtimeClientEvent{sessionUpdate=$sessionUpdate}"
            transcriptionSessionUpdate != null ->
                "RealtimeClientEvent{transcriptionSessionUpdate=$transcriptionSessionUpdate}"
            _json != null -> "RealtimeClientEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeClientEvent")
        }

    companion object {

        /**
         * Add a new Item to the Conversation's context, including messages, function calls, and
         * function call responses. This event can be used both to populate a "history" of the
         * conversation and to add new items mid-stream, but has the current limitation that it
         * cannot populate assistant audio messages.
         *
         * If successful, the server will respond with a `conversation.item.created` event,
         * otherwise an `error` event will be sent.
         */
        @JvmStatic
        fun ofConversationItemCreate(conversationItemCreate: ConversationItemCreateEvent) =
            RealtimeClientEvent(conversationItemCreate = conversationItemCreate)

        /**
         * Send this event when you want to remove any item from the conversation history. The
         * server will respond with a `conversation.item.deleted` event, unless the item does not
         * exist in the conversation history, in which case the server will respond with an error.
         */
        @JvmStatic
        fun ofConversationItemDelete(conversationItemDelete: ConversationItemDeleteEvent) =
            RealtimeClientEvent(conversationItemDelete = conversationItemDelete)

        /**
         * Send this event when you want to retrieve the server's representation of a specific item
         * in the conversation history. This is useful, for example, to inspect user audio after
         * noise cancellation and VAD. The server will respond with a `conversation.item.retrieved`
         * event, unless the item does not exist in the conversation history, in which case the
         * server will respond with an error.
         */
        @JvmStatic
        fun ofConversationItemRetrieve(conversationItemRetrieve: ConversationItemRetrieveEvent) =
            RealtimeClientEvent(conversationItemRetrieve = conversationItemRetrieve)

        /**
         * Send this event to truncate a previous assistant message’s audio. The server will produce
         * audio faster than realtime, so this event is useful when the user interrupts to truncate
         * audio that has already been sent to the client but not yet played. This will synchronize
         * the server's understanding of the audio with the client's playback.
         *
         * Truncating audio will delete the server-side text transcript to ensure there is not text
         * in the context that hasn't been heard by the user.
         *
         * If successful, the server will respond with a `conversation.item.truncated` event.
         */
        @JvmStatic
        fun ofConversationItemTruncate(conversationItemTruncate: ConversationItemTruncateEvent) =
            RealtimeClientEvent(conversationItemTruncate = conversationItemTruncate)

        /**
         * Send this event to append audio bytes to the input audio buffer. The audio buffer is
         * temporary storage you can write to and later commit. In Server VAD mode, the audio buffer
         * is used to detect speech and the server will decide when to commit. When Server VAD is
         * disabled, you must commit the audio buffer manually.
         *
         * The client may choose how much audio to place in each event up to a maximum of 15 MiB,
         * for example streaming smaller chunks from the client may allow the VAD to be more
         * responsive. Unlike made other client events, the server will not send a confirmation
         * response to this event.
         */
        @JvmStatic
        fun ofInputAudioBufferAppend(inputAudioBufferAppend: InputAudioBufferAppendEvent) =
            RealtimeClientEvent(inputAudioBufferAppend = inputAudioBufferAppend)

        /**
         * Send this event to clear the audio bytes in the buffer. The server will respond with an
         * `input_audio_buffer.cleared` event.
         */
        @JvmStatic
        fun ofInputAudioBufferClear(inputAudioBufferClear: InputAudioBufferClearEvent) =
            RealtimeClientEvent(inputAudioBufferClear = inputAudioBufferClear)

        /**
         * **WebRTC Only:** Emit to cut off the current audio response. This will trigger the server
         * to stop generating audio and emit a `output_audio_buffer.cleared` event. This event
         * should be preceded by a `response.cancel` client event to stop the generation of the
         * current response.
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        @JvmStatic
        fun ofOutputAudioBufferClear(outputAudioBufferClear: OutputAudioBufferClearEvent) =
            RealtimeClientEvent(outputAudioBufferClear = outputAudioBufferClear)

        /**
         * Send this event to commit the user input audio buffer, which will create a new user
         * message item in the conversation. This event will produce an error if the input audio
         * buffer is empty. When in Server VAD mode, the client does not need to send this event,
         * the server will commit the audio buffer automatically.
         *
         * Committing the input audio buffer will trigger input audio transcription (if enabled in
         * session configuration), but it will not create a response from the model. The server will
         * respond with an `input_audio_buffer.committed` event.
         */
        @JvmStatic
        fun ofInputAudioBufferCommit(inputAudioBufferCommit: InputAudioBufferCommitEvent) =
            RealtimeClientEvent(inputAudioBufferCommit = inputAudioBufferCommit)

        /**
         * Send this event to cancel an in-progress response. The server will respond with a
         * `response.done` event with a status of `response.status=cancelled`. If there is no
         * response to cancel, the server will respond with an error.
         */
        @JvmStatic
        fun ofResponseCancel(responseCancel: ResponseCancelEvent) =
            RealtimeClientEvent(responseCancel = responseCancel)

        /**
         * This event instructs the server to create a Response, which means triggering model
         * inference. When in Server VAD mode, the server will create Responses automatically.
         *
         * A Response will include at least one Item, and may have two, in which case the second
         * will be a function call. These Items will be appended to the conversation history.
         *
         * The server will respond with a `response.created` event, events for Items and content
         * created, and finally a `response.done` event to indicate the Response is complete.
         *
         * The `response.create` event includes inference configuration like `instructions`, and
         * `temperature`. These fields will override the Session's configuration for this Response
         * only.
         */
        @JvmStatic
        fun ofResponseCreate(responseCreate: ResponseCreateEvent) =
            RealtimeClientEvent(responseCreate = responseCreate)

        /**
         * Send this event to update the session’s default configuration. The client may send this
         * event at any time to update any field, except for `voice`. However, note that once a
         * session has been initialized with a particular `model`, it can’t be changed to another
         * model using `session.update`.
         *
         * When the server receives a `session.update`, it will respond with a `session.updated`
         * event showing the full, effective configuration. Only the fields that are present are
         * updated. To clear a field like `instructions`, pass an empty string.
         */
        @JvmStatic
        fun ofSessionUpdate(sessionUpdate: SessionUpdateEvent) =
            RealtimeClientEvent(sessionUpdate = sessionUpdate)

        /** Send this event to update a transcription session. */
        @JvmStatic
        fun ofTranscriptionSessionUpdate(transcriptionSessionUpdate: TranscriptionSessionUpdate) =
            RealtimeClientEvent(transcriptionSessionUpdate = transcriptionSessionUpdate)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeClientEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * Add a new Item to the Conversation's context, including messages, function calls, and
         * function call responses. This event can be used both to populate a "history" of the
         * conversation and to add new items mid-stream, but has the current limitation that it
         * cannot populate assistant audio messages.
         *
         * If successful, the server will respond with a `conversation.item.created` event,
         * otherwise an `error` event will be sent.
         */
        fun visitConversationItemCreate(conversationItemCreate: ConversationItemCreateEvent): T

        /**
         * Send this event when you want to remove any item from the conversation history. The
         * server will respond with a `conversation.item.deleted` event, unless the item does not
         * exist in the conversation history, in which case the server will respond with an error.
         */
        fun visitConversationItemDelete(conversationItemDelete: ConversationItemDeleteEvent): T

        /**
         * Send this event when you want to retrieve the server's representation of a specific item
         * in the conversation history. This is useful, for example, to inspect user audio after
         * noise cancellation and VAD. The server will respond with a `conversation.item.retrieved`
         * event, unless the item does not exist in the conversation history, in which case the
         * server will respond with an error.
         */
        fun visitConversationItemRetrieve(
            conversationItemRetrieve: ConversationItemRetrieveEvent
        ): T

        /**
         * Send this event to truncate a previous assistant message’s audio. The server will produce
         * audio faster than realtime, so this event is useful when the user interrupts to truncate
         * audio that has already been sent to the client but not yet played. This will synchronize
         * the server's understanding of the audio with the client's playback.
         *
         * Truncating audio will delete the server-side text transcript to ensure there is not text
         * in the context that hasn't been heard by the user.
         *
         * If successful, the server will respond with a `conversation.item.truncated` event.
         */
        fun visitConversationItemTruncate(
            conversationItemTruncate: ConversationItemTruncateEvent
        ): T

        /**
         * Send this event to append audio bytes to the input audio buffer. The audio buffer is
         * temporary storage you can write to and later commit. In Server VAD mode, the audio buffer
         * is used to detect speech and the server will decide when to commit. When Server VAD is
         * disabled, you must commit the audio buffer manually.
         *
         * The client may choose how much audio to place in each event up to a maximum of 15 MiB,
         * for example streaming smaller chunks from the client may allow the VAD to be more
         * responsive. Unlike made other client events, the server will not send a confirmation
         * response to this event.
         */
        fun visitInputAudioBufferAppend(inputAudioBufferAppend: InputAudioBufferAppendEvent): T

        /**
         * Send this event to clear the audio bytes in the buffer. The server will respond with an
         * `input_audio_buffer.cleared` event.
         */
        fun visitInputAudioBufferClear(inputAudioBufferClear: InputAudioBufferClearEvent): T

        /**
         * **WebRTC Only:** Emit to cut off the current audio response. This will trigger the server
         * to stop generating audio and emit a `output_audio_buffer.cleared` event. This event
         * should be preceded by a `response.cancel` client event to stop the generation of the
         * current response.
         * [Learn more](https://platform.openai.com/docs/guides/realtime-conversations#client-and-server-events-for-audio-in-webrtc).
         */
        fun visitOutputAudioBufferClear(outputAudioBufferClear: OutputAudioBufferClearEvent): T

        /**
         * Send this event to commit the user input audio buffer, which will create a new user
         * message item in the conversation. This event will produce an error if the input audio
         * buffer is empty. When in Server VAD mode, the client does not need to send this event,
         * the server will commit the audio buffer automatically.
         *
         * Committing the input audio buffer will trigger input audio transcription (if enabled in
         * session configuration), but it will not create a response from the model. The server will
         * respond with an `input_audio_buffer.committed` event.
         */
        fun visitInputAudioBufferCommit(inputAudioBufferCommit: InputAudioBufferCommitEvent): T

        /**
         * Send this event to cancel an in-progress response. The server will respond with a
         * `response.done` event with a status of `response.status=cancelled`. If there is no
         * response to cancel, the server will respond with an error.
         */
        fun visitResponseCancel(responseCancel: ResponseCancelEvent): T

        /**
         * This event instructs the server to create a Response, which means triggering model
         * inference. When in Server VAD mode, the server will create Responses automatically.
         *
         * A Response will include at least one Item, and may have two, in which case the second
         * will be a function call. These Items will be appended to the conversation history.
         *
         * The server will respond with a `response.created` event, events for Items and content
         * created, and finally a `response.done` event to indicate the Response is complete.
         *
         * The `response.create` event includes inference configuration like `instructions`, and
         * `temperature`. These fields will override the Session's configuration for this Response
         * only.
         */
        fun visitResponseCreate(responseCreate: ResponseCreateEvent): T

        /**
         * Send this event to update the session’s default configuration. The client may send this
         * event at any time to update any field, except for `voice`. However, note that once a
         * session has been initialized with a particular `model`, it can’t be changed to another
         * model using `session.update`.
         *
         * When the server receives a `session.update`, it will respond with a `session.updated`
         * event showing the full, effective configuration. Only the fields that are present are
         * updated. To clear a field like `instructions`, pass an empty string.
         */
        fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent): T

        /** Send this event to update a transcription session. */
        fun visitTranscriptionSessionUpdate(
            transcriptionSessionUpdate: TranscriptionSessionUpdate
        ): T

        /**
         * Maps an unknown variant of [RealtimeClientEvent] to a value of type [T].
         *
         * An instance of [RealtimeClientEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeClientEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeClientEvent>(RealtimeClientEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeClientEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "conversation.item.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemCreateEvent>())
                        ?.let { RealtimeClientEvent(conversationItemCreate = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "conversation.item.delete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemDeleteEvent>())
                        ?.let { RealtimeClientEvent(conversationItemDelete = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "conversation.item.retrieve" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemRetrieveEvent>())
                        ?.let { RealtimeClientEvent(conversationItemRetrieve = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "conversation.item.truncate" -> {
                    return tryDeserialize(node, jacksonTypeRef<ConversationItemTruncateEvent>())
                        ?.let { RealtimeClientEvent(conversationItemTruncate = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "input_audio_buffer.append" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioBufferAppendEvent>())
                        ?.let { RealtimeClientEvent(inputAudioBufferAppend = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "input_audio_buffer.clear" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioBufferClearEvent>())?.let {
                        RealtimeClientEvent(inputAudioBufferClear = it, _json = json)
                    } ?: RealtimeClientEvent(_json = json)
                }
                "output_audio_buffer.clear" -> {
                    return tryDeserialize(node, jacksonTypeRef<OutputAudioBufferClearEvent>())
                        ?.let { RealtimeClientEvent(outputAudioBufferClear = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "input_audio_buffer.commit" -> {
                    return tryDeserialize(node, jacksonTypeRef<InputAudioBufferCommitEvent>())
                        ?.let { RealtimeClientEvent(inputAudioBufferCommit = it, _json = json) }
                        ?: RealtimeClientEvent(_json = json)
                }
                "response.cancel" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCancelEvent>())?.let {
                        RealtimeClientEvent(responseCancel = it, _json = json)
                    } ?: RealtimeClientEvent(_json = json)
                }
                "response.create" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCreateEvent>())?.let {
                        RealtimeClientEvent(responseCreate = it, _json = json)
                    } ?: RealtimeClientEvent(_json = json)
                }
                "session.update" -> {
                    return tryDeserialize(node, jacksonTypeRef<SessionUpdateEvent>())?.let {
                        RealtimeClientEvent(sessionUpdate = it, _json = json)
                    } ?: RealtimeClientEvent(_json = json)
                }
                "transcription_session.update" -> {
                    return tryDeserialize(node, jacksonTypeRef<TranscriptionSessionUpdate>())?.let {
                        RealtimeClientEvent(transcriptionSessionUpdate = it, _json = json)
                    } ?: RealtimeClientEvent(_json = json)
                }
            }

            return RealtimeClientEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<RealtimeClientEvent>(RealtimeClientEvent::class) {

        override fun serialize(
            value: RealtimeClientEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.conversationItemCreate != null ->
                    generator.writeObject(value.conversationItemCreate)
                value.conversationItemDelete != null ->
                    generator.writeObject(value.conversationItemDelete)
                value.conversationItemRetrieve != null ->
                    generator.writeObject(value.conversationItemRetrieve)
                value.conversationItemTruncate != null ->
                    generator.writeObject(value.conversationItemTruncate)
                value.inputAudioBufferAppend != null ->
                    generator.writeObject(value.inputAudioBufferAppend)
                value.inputAudioBufferClear != null ->
                    generator.writeObject(value.inputAudioBufferClear)
                value.outputAudioBufferClear != null ->
                    generator.writeObject(value.outputAudioBufferClear)
                value.inputAudioBufferCommit != null ->
                    generator.writeObject(value.inputAudioBufferCommit)
                value.responseCancel != null -> generator.writeObject(value.responseCancel)
                value.responseCreate != null -> generator.writeObject(value.responseCreate)
                value.sessionUpdate != null -> generator.writeObject(value.sessionUpdate)
                value.transcriptionSessionUpdate != null ->
                    generator.writeObject(value.transcriptionSessionUpdate)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeClientEvent")
            }
        }
    }
}
