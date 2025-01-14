// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Represents a message within a [thread](https://platform.openai.com/docs/api-reference/threads).
 */
@NoAutoDetect
class Message
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("assistant_id")
    @ExcludeMissing
    private val assistantId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("attachments")
    @ExcludeMissing
    private val attachments: JsonField<List<Attachment>> = JsonMissing.of(),
    @JsonProperty("completed_at")
    @ExcludeMissing
    private val completedAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<List<MessageContent>> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("incomplete_at")
    @ExcludeMissing
    private val incompleteAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("incomplete_details")
    @ExcludeMissing
    private val incompleteDetails: JsonField<IncompleteDetails> = JsonMissing.of(),
    @JsonProperty("metadata") @ExcludeMissing private val metadata: JsonValue = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonProperty("run_id") @ExcludeMissing private val runId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("thread_id")
    @ExcludeMissing
    private val threadId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /**
     * If applicable, the ID of the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) that authored this
     * message.
     */
    fun assistantId(): Optional<String> =
        Optional.ofNullable(assistantId.getNullable("assistant_id"))

    /** A list of files attached to the message, and the tools they were added to. */
    fun attachments(): Optional<List<Attachment>> =
        Optional.ofNullable(attachments.getNullable("attachments"))

    /** The Unix timestamp (in seconds) for when the message was completed. */
    fun completedAt(): Optional<Long> = Optional.ofNullable(completedAt.getNullable("completed_at"))

    /** The content of the message in array of text and/or images. */
    fun content(): List<MessageContent> = content.getRequired("content")

    /** The Unix timestamp (in seconds) for when the message was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The Unix timestamp (in seconds) for when the message was marked as incomplete. */
    fun incompleteAt(): Optional<Long> =
        Optional.ofNullable(incompleteAt.getNullable("incomplete_at"))

    /** On an incomplete message, details about why the message is incomplete. */
    fun incompleteDetails(): Optional<IncompleteDetails> =
        Optional.ofNullable(incompleteDetails.getNullable("incomplete_details"))

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

    /** The object type, which is always `thread.message`. */
    fun object_(): Object = object_.getRequired("object")

    /** The entity that produced the message. One of `user` or `assistant`. */
    fun role(): Role = role.getRequired("role")

    /**
     * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) associated with the
     * creation of this message. Value is `null` when messages are created manually using the create
     * message or create thread endpoints.
     */
    fun runId(): Optional<String> = Optional.ofNullable(runId.getNullable("run_id"))

    /**
     * The status of the message, which can be either `in_progress`, `incomplete`, or `completed`.
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The [thread](https://platform.openai.com/docs/api-reference/threads) ID that this message
     * belongs to.
     */
    fun threadId(): String = threadId.getRequired("thread_id")

    /** The identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * If applicable, the ID of the
     * [assistant](https://platform.openai.com/docs/api-reference/assistants) that authored this
     * message.
     */
    @JsonProperty("assistant_id")
    @ExcludeMissing
    fun _assistantId(): JsonField<String> = assistantId

    /** A list of files attached to the message, and the tools they were added to. */
    @JsonProperty("attachments")
    @ExcludeMissing
    fun _attachments(): JsonField<List<Attachment>> = attachments

    /** The Unix timestamp (in seconds) for when the message was completed. */
    @JsonProperty("completed_at") @ExcludeMissing fun _completedAt(): JsonField<Long> = completedAt

    /** The content of the message in array of text and/or images. */
    @JsonProperty("content")
    @ExcludeMissing
    fun _content(): JsonField<List<MessageContent>> = content

    /** The Unix timestamp (in seconds) for when the message was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /** The Unix timestamp (in seconds) for when the message was marked as incomplete. */
    @JsonProperty("incomplete_at")
    @ExcludeMissing
    fun _incompleteAt(): JsonField<Long> = incompleteAt

    /** On an incomplete message, details about why the message is incomplete. */
    @JsonProperty("incomplete_details")
    @ExcludeMissing
    fun _incompleteDetails(): JsonField<IncompleteDetails> = incompleteDetails

    /** The object type, which is always `thread.message`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /** The entity that produced the message. One of `user` or `assistant`. */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

    /**
     * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) associated with the
     * creation of this message. Value is `null` when messages are created manually using the create
     * message or create thread endpoints.
     */
    @JsonProperty("run_id") @ExcludeMissing fun _runId(): JsonField<String> = runId

    /**
     * The status of the message, which can be either `in_progress`, `incomplete`, or `completed`.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * The [thread](https://platform.openai.com/docs/api-reference/threads) ID that this message
     * belongs to.
     */
    @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Message = apply {
        if (validated) {
            return@apply
        }

        id()
        assistantId()
        attachments().ifPresent { it.forEach { it.validate() } }
        completedAt()
        content().forEach { it.validate() }
        createdAt()
        incompleteAt()
        incompleteDetails().ifPresent { it.validate() }
        object_()
        role()
        runId()
        status()
        threadId()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String>? = null
        private var assistantId: JsonField<String>? = null
        private var attachments: JsonField<MutableList<Attachment>>? = null
        private var completedAt: JsonField<Long>? = null
        private var content: JsonField<MutableList<MessageContent>>? = null
        private var createdAt: JsonField<Long>? = null
        private var incompleteAt: JsonField<Long>? = null
        private var incompleteDetails: JsonField<IncompleteDetails>? = null
        private var metadata: JsonValue? = null
        private var object_: JsonField<Object>? = null
        private var role: JsonField<Role>? = null
        private var runId: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var threadId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(message: Message) = apply {
            id = message.id
            assistantId = message.assistantId
            attachments = message.attachments.map { it.toMutableList() }
            completedAt = message.completedAt
            content = message.content.map { it.toMutableList() }
            createdAt = message.createdAt
            incompleteAt = message.incompleteAt
            incompleteDetails = message.incompleteDetails
            metadata = message.metadata
            object_ = message.object_
            role = message.role
            runId = message.runId
            status = message.status
            threadId = message.threadId
            additionalProperties = message.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * If applicable, the ID of the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) that authored this
         * message.
         */
        fun assistantId(assistantId: String?) = assistantId(JsonField.ofNullable(assistantId))

        /**
         * If applicable, the ID of the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) that authored this
         * message.
         */
        fun assistantId(assistantId: Optional<String>) = assistantId(assistantId.orElse(null))

        /**
         * If applicable, the ID of the
         * [assistant](https://platform.openai.com/docs/api-reference/assistants) that authored this
         * message.
         */
        fun assistantId(assistantId: JsonField<String>) = apply { this.assistantId = assistantId }

        /** A list of files attached to the message, and the tools they were added to. */
        fun attachments(attachments: List<Attachment>?) =
            attachments(JsonField.ofNullable(attachments))

        /** A list of files attached to the message, and the tools they were added to. */
        fun attachments(attachments: Optional<List<Attachment>>) =
            attachments(attachments.orElse(null))

        /** A list of files attached to the message, and the tools they were added to. */
        fun attachments(attachments: JsonField<List<Attachment>>) = apply {
            this.attachments = attachments.map { it.toMutableList() }
        }

        /** A list of files attached to the message, and the tools they were added to. */
        fun addAttachment(attachment: Attachment) = apply {
            attachments =
                (attachments ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(attachment)
                }
        }

        /** The Unix timestamp (in seconds) for when the message was completed. */
        fun completedAt(completedAt: Long?) = completedAt(JsonField.ofNullable(completedAt))

        /** The Unix timestamp (in seconds) for when the message was completed. */
        fun completedAt(completedAt: Long) = completedAt(completedAt as Long?)

        /** The Unix timestamp (in seconds) for when the message was completed. */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun completedAt(completedAt: Optional<Long>) =
            completedAt(completedAt.orElse(null) as Long?)

        /** The Unix timestamp (in seconds) for when the message was completed. */
        fun completedAt(completedAt: JsonField<Long>) = apply { this.completedAt = completedAt }

        /** The content of the message in array of text and/or images. */
        fun content(content: List<MessageContent>) = content(JsonField.of(content))

        /** The content of the message in array of text and/or images. */
        fun content(content: JsonField<List<MessageContent>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /** The content of the message in array of text and/or images. */
        fun addContent(content: MessageContent) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(content)
                }
        }

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        fun addContent(imageFileContentBlock: ImageFileContentBlock) =
            addContent(MessageContent.ofImageFileContentBlock(imageFileContentBlock))

        /** References an image URL in the content of a message. */
        fun addContent(imageUrlContentBlock: ImageUrlContentBlock) =
            addContent(MessageContent.ofImageUrlContentBlock(imageUrlContentBlock))

        /** The text content that is part of a message. */
        fun addContent(textContentBlock: TextContentBlock) =
            addContent(MessageContent.ofTextContentBlock(textContentBlock))

        /** The refusal content generated by the assistant. */
        fun addContent(refusalContentBlock: RefusalContentBlock) =
            addContent(MessageContent.ofRefusalContentBlock(refusalContentBlock))

        /** The Unix timestamp (in seconds) for when the message was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the message was created. */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The Unix timestamp (in seconds) for when the message was marked as incomplete. */
        fun incompleteAt(incompleteAt: Long?) = incompleteAt(JsonField.ofNullable(incompleteAt))

        /** The Unix timestamp (in seconds) for when the message was marked as incomplete. */
        fun incompleteAt(incompleteAt: Long) = incompleteAt(incompleteAt as Long?)

        /** The Unix timestamp (in seconds) for when the message was marked as incomplete. */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun incompleteAt(incompleteAt: Optional<Long>) =
            incompleteAt(incompleteAt.orElse(null) as Long?)

        /** The Unix timestamp (in seconds) for when the message was marked as incomplete. */
        fun incompleteAt(incompleteAt: JsonField<Long>) = apply { this.incompleteAt = incompleteAt }

        /** On an incomplete message, details about why the message is incomplete. */
        fun incompleteDetails(incompleteDetails: IncompleteDetails?) =
            incompleteDetails(JsonField.ofNullable(incompleteDetails))

        /** On an incomplete message, details about why the message is incomplete. */
        fun incompleteDetails(incompleteDetails: Optional<IncompleteDetails>) =
            incompleteDetails(incompleteDetails.orElse(null))

        /** On an incomplete message, details about why the message is incomplete. */
        fun incompleteDetails(incompleteDetails: JsonField<IncompleteDetails>) = apply {
            this.incompleteDetails = incompleteDetails
        }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

        /** The object type, which is always `thread.message`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `thread.message`. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The entity that produced the message. One of `user` or `assistant`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The entity that produced the message. One of `user` or `assistant`. */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) associated with
         * the creation of this message. Value is `null` when messages are created manually using
         * the create message or create thread endpoints.
         */
        fun runId(runId: String?) = runId(JsonField.ofNullable(runId))

        /**
         * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) associated with
         * the creation of this message. Value is `null` when messages are created manually using
         * the create message or create thread endpoints.
         */
        fun runId(runId: Optional<String>) = runId(runId.orElse(null))

        /**
         * The ID of the [run](https://platform.openai.com/docs/api-reference/runs) associated with
         * the creation of this message. Value is `null` when messages are created manually using
         * the create message or create thread endpoints.
         */
        fun runId(runId: JsonField<String>) = apply { this.runId = runId }

        /**
         * The status of the message, which can be either `in_progress`, `incomplete`, or
         * `completed`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the message, which can be either `in_progress`, `incomplete`, or
         * `completed`.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * The [thread](https://platform.openai.com/docs/api-reference/threads) ID that this message
         * belongs to.
         */
        fun threadId(threadId: String) = threadId(JsonField.of(threadId))

        /**
         * The [thread](https://platform.openai.com/docs/api-reference/threads) ID that this message
         * belongs to.
         */
        fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

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

        fun build(): Message =
            Message(
                checkRequired("id", id),
                checkRequired("assistantId", assistantId),
                checkRequired("attachments", attachments).map { it.toImmutable() },
                checkRequired("completedAt", completedAt),
                checkRequired("content", content).map { it.toImmutable() },
                checkRequired("createdAt", createdAt),
                checkRequired("incompleteAt", incompleteAt),
                checkRequired("incompleteDetails", incompleteDetails),
                checkRequired("metadata", metadata),
                checkRequired("object_", object_),
                checkRequired("role", role),
                checkRequired("runId", runId),
                checkRequired("status", status),
                checkRequired("threadId", threadId),
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class Attachment
    @JsonCreator
    private constructor(
        @JsonProperty("file_id")
        @ExcludeMissing
        private val fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        private val tools: JsonField<List<Tool>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the file to attach to the message. */
        fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

        /** The tools to add this file to. */
        fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

        /** The ID of the file to attach to the message. */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /** The tools to add this file to. */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Attachment = apply {
            if (validated) {
                return@apply
            }

            fileId()
            tools().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var fileId: JsonField<String> = JsonMissing.of()
            private var tools: JsonField<MutableList<Tool>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attachment: Attachment) = apply {
                fileId = attachment.fileId
                tools = attachment.tools.map { it.toMutableList() }
                additionalProperties = attachment.additionalProperties.toMutableMap()
            }

            /** The ID of the file to attach to the message. */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /** The ID of the file to attach to the message. */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /** The tools to add this file to. */
            fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

            /** The tools to add this file to. */
            fun tools(tools: JsonField<List<Tool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /** The tools to add this file to. */
            fun addTool(tool: Tool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(tool)
                    }
            }

            /** The tools to add this file to. */
            fun addTool(codeInterpreterTool: CodeInterpreterTool) =
                addTool(Tool.ofCodeInterpreterTool(codeInterpreterTool))

            /** The tools to add this file to. */
            fun addTool(assistantToolsFileSearchTypeOnly: Tool.AssistantToolsFileSearchTypeOnly) =
                addTool(Tool.ofAssistantToolsFileSearchTypeOnly(assistantToolsFileSearchTypeOnly))

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

            fun build(): Attachment =
                Attachment(
                    fileId,
                    (tools ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        @JsonDeserialize(using = Tool.Deserializer::class)
        @JsonSerialize(using = Tool.Serializer::class)
        class Tool
        private constructor(
            private val codeInterpreterTool: CodeInterpreterTool? = null,
            private val assistantToolsFileSearchTypeOnly: AssistantToolsFileSearchTypeOnly? = null,
            private val _json: JsonValue? = null,
        ) {

            fun codeInterpreterTool(): Optional<CodeInterpreterTool> =
                Optional.ofNullable(codeInterpreterTool)

            fun assistantToolsFileSearchTypeOnly(): Optional<AssistantToolsFileSearchTypeOnly> =
                Optional.ofNullable(assistantToolsFileSearchTypeOnly)

            fun isCodeInterpreterTool(): Boolean = codeInterpreterTool != null

            fun isAssistantToolsFileSearchTypeOnly(): Boolean =
                assistantToolsFileSearchTypeOnly != null

            fun asCodeInterpreterTool(): CodeInterpreterTool =
                codeInterpreterTool.getOrThrow("codeInterpreterTool")

            fun asAssistantToolsFileSearchTypeOnly(): AssistantToolsFileSearchTypeOnly =
                assistantToolsFileSearchTypeOnly.getOrThrow("assistantToolsFileSearchTypeOnly")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    codeInterpreterTool != null ->
                        visitor.visitCodeInterpreterTool(codeInterpreterTool)
                    assistantToolsFileSearchTypeOnly != null ->
                        visitor.visitAssistantToolsFileSearchTypeOnly(
                            assistantToolsFileSearchTypeOnly
                        )
                    else -> visitor.unknown(_json)
                }
            }

            private var validated: Boolean = false

            fun validate(): Tool = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitCodeInterpreterTool(
                            codeInterpreterTool: CodeInterpreterTool
                        ) {
                            codeInterpreterTool.validate()
                        }

                        override fun visitAssistantToolsFileSearchTypeOnly(
                            assistantToolsFileSearchTypeOnly: AssistantToolsFileSearchTypeOnly
                        ) {
                            assistantToolsFileSearchTypeOnly.validate()
                        }
                    }
                )
                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Tool && codeInterpreterTool == other.codeInterpreterTool && assistantToolsFileSearchTypeOnly == other.assistantToolsFileSearchTypeOnly /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreterTool, assistantToolsFileSearchTypeOnly) /* spotless:on */

            override fun toString(): String =
                when {
                    codeInterpreterTool != null -> "Tool{codeInterpreterTool=$codeInterpreterTool}"
                    assistantToolsFileSearchTypeOnly != null ->
                        "Tool{assistantToolsFileSearchTypeOnly=$assistantToolsFileSearchTypeOnly}"
                    _json != null -> "Tool{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Tool")
                }

            companion object {

                @JvmStatic
                fun ofCodeInterpreterTool(codeInterpreterTool: CodeInterpreterTool) =
                    Tool(codeInterpreterTool = codeInterpreterTool)

                @JvmStatic
                fun ofAssistantToolsFileSearchTypeOnly(
                    assistantToolsFileSearchTypeOnly: AssistantToolsFileSearchTypeOnly
                ) = Tool(assistantToolsFileSearchTypeOnly = assistantToolsFileSearchTypeOnly)
            }

            interface Visitor<out T> {

                fun visitCodeInterpreterTool(codeInterpreterTool: CodeInterpreterTool): T

                fun visitAssistantToolsFileSearchTypeOnly(
                    assistantToolsFileSearchTypeOnly: AssistantToolsFileSearchTypeOnly
                ): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Tool: $json")
                }
            }

            class Deserializer : BaseDeserializer<Tool>(Tool::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>()) { it.validate() }
                        ?.let {
                            return Tool(codeInterpreterTool = it, _json = json)
                        }
                    tryDeserialize(node, jacksonTypeRef<AssistantToolsFileSearchTypeOnly>()) {
                            it.validate()
                        }
                        ?.let {
                            return Tool(assistantToolsFileSearchTypeOnly = it, _json = json)
                        }

                    return Tool(_json = json)
                }
            }

            class Serializer : BaseSerializer<Tool>(Tool::class) {

                override fun serialize(
                    value: Tool,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.codeInterpreterTool != null ->
                            generator.writeObject(value.codeInterpreterTool)
                        value.assistantToolsFileSearchTypeOnly != null ->
                            generator.writeObject(value.assistantToolsFileSearchTypeOnly)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Tool")
                    }
                }
            }

            @NoAutoDetect
            class AssistantToolsFileSearchTypeOnly
            @JsonCreator
            private constructor(
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The type of tool being defined: `file_search` */
                fun type(): Type = type.getRequired("type")

                /** The type of tool being defined: `file_search` */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): AssistantToolsFileSearchTypeOnly = apply {
                    if (validated) {
                        return@apply
                    }

                    type()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var type: JsonField<Type>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(
                        assistantToolsFileSearchTypeOnly: AssistantToolsFileSearchTypeOnly
                    ) = apply {
                        type = assistantToolsFileSearchTypeOnly.type
                        additionalProperties =
                            assistantToolsFileSearchTypeOnly.additionalProperties.toMutableMap()
                    }

                    /** The type of tool being defined: `file_search` */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** The type of tool being defined: `file_search` */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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

                    fun build(): AssistantToolsFileSearchTypeOnly =
                        AssistantToolsFileSearchTypeOnly(
                            checkRequired("type", type),
                            additionalProperties.toImmutable()
                        )
                }

                class Type
                @JsonCreator
                private constructor(
                    private val value: JsonField<String>,
                ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val FILE_SEARCH = of("file_search")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        FILE_SEARCH,
                    }

                    enum class Value {
                        FILE_SEARCH,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            FILE_SEARCH -> Value.FILE_SEARCH
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            FILE_SEARCH -> Known.FILE_SEARCH
                            else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                        }

                    fun asString(): String = _value().asStringOrThrow()

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is AssistantToolsFileSearchTypeOnly && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AssistantToolsFileSearchTypeOnly{type=$type, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Attachment && fileId == other.fileId && tools == other.tools && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(fileId, tools, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Attachment{fileId=$fileId, tools=$tools, additionalProperties=$additionalProperties}"
    }

    /** On an incomplete message, details about why the message is incomplete. */
    @NoAutoDetect
    class IncompleteDetails
    @JsonCreator
    private constructor(
        @JsonProperty("reason")
        @ExcludeMissing
        private val reason: JsonField<Reason> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The reason the message is incomplete. */
        fun reason(): Reason = reason.getRequired("reason")

        /** The reason the message is incomplete. */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): IncompleteDetails = apply {
            if (validated) {
                return@apply
            }

            reason()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var reason: JsonField<Reason>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(incompleteDetails: IncompleteDetails) = apply {
                reason = incompleteDetails.reason
                additionalProperties = incompleteDetails.additionalProperties.toMutableMap()
            }

            /** The reason the message is incomplete. */
            fun reason(reason: Reason) = reason(JsonField.of(reason))

            /** The reason the message is incomplete. */
            fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

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

            fun build(): IncompleteDetails =
                IncompleteDetails(
                    checkRequired("reason", reason),
                    additionalProperties.toImmutable()
                )
        }

        class Reason
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val CONTENT_FILTER = of("content_filter")

                @JvmField val MAX_TOKENS = of("max_tokens")

                @JvmField val RUN_CANCELLED = of("run_cancelled")

                @JvmField val RUN_EXPIRED = of("run_expired")

                @JvmField val RUN_FAILED = of("run_failed")

                @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
            }

            enum class Known {
                CONTENT_FILTER,
                MAX_TOKENS,
                RUN_CANCELLED,
                RUN_EXPIRED,
                RUN_FAILED,
            }

            enum class Value {
                CONTENT_FILTER,
                MAX_TOKENS,
                RUN_CANCELLED,
                RUN_EXPIRED,
                RUN_FAILED,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    CONTENT_FILTER -> Value.CONTENT_FILTER
                    MAX_TOKENS -> Value.MAX_TOKENS
                    RUN_CANCELLED -> Value.RUN_CANCELLED
                    RUN_EXPIRED -> Value.RUN_EXPIRED
                    RUN_FAILED -> Value.RUN_FAILED
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    CONTENT_FILTER -> Known.CONTENT_FILTER
                    MAX_TOKENS -> Known.MAX_TOKENS
                    RUN_CANCELLED -> Known.RUN_CANCELLED
                    RUN_EXPIRED -> Known.RUN_EXPIRED
                    RUN_FAILED -> Known.RUN_FAILED
                    else -> throw OpenAIInvalidDataException("Unknown Reason: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Reason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is IncompleteDetails && reason == other.reason && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(reason, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IncompleteDetails{reason=$reason, additionalProperties=$additionalProperties}"
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val THREAD_MESSAGE = of("thread.message")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            THREAD_MESSAGE,
        }

        enum class Value {
            THREAD_MESSAGE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                THREAD_MESSAGE -> Value.THREAD_MESSAGE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                THREAD_MESSAGE -> Known.THREAD_MESSAGE
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val USER = of("user")

            @JvmField val ASSISTANT = of("assistant")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            USER,
            ASSISTANT,
        }

        enum class Value {
            USER,
            ASSISTANT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                USER -> Value.USER
                ASSISTANT -> Value.ASSISTANT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                USER -> Known.USER
                ASSISTANT -> Known.ASSISTANT
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmField val COMPLETED = of("completed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            IN_PROGRESS,
            INCOMPLETE,
            COMPLETED,
        }

        enum class Value {
            IN_PROGRESS,
            INCOMPLETE,
            COMPLETED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IN_PROGRESS -> Value.IN_PROGRESS
                INCOMPLETE -> Value.INCOMPLETE
                COMPLETED -> Value.COMPLETED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IN_PROGRESS -> Known.IN_PROGRESS
                INCOMPLETE -> Known.INCOMPLETE
                COMPLETED -> Known.COMPLETED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

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

        return /* spotless:off */ other is Message && id == other.id && assistantId == other.assistantId && attachments == other.attachments && completedAt == other.completedAt && content == other.content && createdAt == other.createdAt && incompleteAt == other.incompleteAt && incompleteDetails == other.incompleteDetails && metadata == other.metadata && object_ == other.object_ && role == other.role && runId == other.runId && status == other.status && threadId == other.threadId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, assistantId, attachments, completedAt, content, createdAt, incompleteAt, incompleteDetails, metadata, object_, role, runId, status, threadId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Message{id=$id, assistantId=$assistantId, attachments=$attachments, completedAt=$completedAt, content=$content, createdAt=$createdAt, incompleteAt=$incompleteAt, incompleteDetails=$incompleteDetails, metadata=$metadata, object_=$object_, role=$role, runId=$runId, status=$status, threadId=$threadId, additionalProperties=$additionalProperties}"
}
