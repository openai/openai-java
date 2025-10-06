// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A paginated list of thread items rendered for the ChatKit API. */
class ChatKitThreadItemList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<Data>>,
    private val firstId: JsonField<String>,
    private val hasMore: JsonField<Boolean>,
    private val lastId: JsonField<String>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
        @JsonProperty("first_id") @ExcludeMissing firstId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_id") @ExcludeMissing lastId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(data, firstId, hasMore, lastId, object_, mutableMapOf())

    /**
     * A list of items
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<Data> = data.getRequired("data")

    /**
     * The ID of the first item in the list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun firstId(): Optional<String> = firstId.getOptional("first_id")

    /**
     * Whether there are more items available.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /**
     * The ID of the last item in the list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastId(): Optional<String> = lastId.getOptional("last_id")

    /**
     * The type of object returned, must be `list`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("list")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

    /**
     * Returns the raw JSON value of [firstId].
     *
     * Unlike [firstId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("first_id") @ExcludeMissing fun _firstId(): JsonField<String> = firstId

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [lastId].
     *
     * Unlike [lastId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_id") @ExcludeMissing fun _lastId(): JsonField<String> = lastId

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
         * Returns a mutable builder for constructing an instance of [ChatKitThreadItemList].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatKitThreadItemList]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var firstId: JsonField<String>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var lastId: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("list")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatkitThreadItemList: ChatKitThreadItemList) = apply {
            data = chatkitThreadItemList.data.map { it.toMutableList() }
            firstId = chatkitThreadItemList.firstId
            hasMore = chatkitThreadItemList.hasMore
            lastId = chatkitThreadItemList.lastId
            object_ = chatkitThreadItemList.object_
            additionalProperties = chatkitThreadItemList.additionalProperties.toMutableMap()
        }

        /** A list of items */
        fun data(data: List<Data>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<Data>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<List<Data>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [Data] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: Data) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** Alias for calling [addData] with `Data.ofChatKitUserMessage(chatkitUserMessage)`. */
        fun addData(chatkitUserMessage: ChatKitThreadUserMessageItem) =
            addData(Data.ofChatKitUserMessage(chatkitUserMessage))

        /**
         * Alias for calling [addData] with
         * `Data.ofChatKitAssistantMessage(chatkitAssistantMessage)`.
         */
        fun addData(chatkitAssistantMessage: ChatKitThreadAssistantMessageItem) =
            addData(Data.ofChatKitAssistantMessage(chatkitAssistantMessage))

        /** Alias for calling [addData] with `Data.ofChatKitWidget(chatkitWidget)`. */
        fun addData(chatkitWidget: ChatKitWidgetItem) = addData(Data.ofChatKitWidget(chatkitWidget))

        /**
         * Alias for calling [addData] with `Data.ofChatKitClientToolCall(chatkitClientToolCall)`.
         */
        fun addData(chatkitClientToolCall: Data.ChatKitClientToolCall) =
            addData(Data.ofChatKitClientToolCall(chatkitClientToolCall))

        /** Alias for calling [addData] with `Data.ofChatKitTask(chatkitTask)`. */
        fun addData(chatkitTask: Data.ChatKitTask) = addData(Data.ofChatKitTask(chatkitTask))

        /** Alias for calling [addData] with `Data.ofChatKitTaskGroup(chatkitTaskGroup)`. */
        fun addData(chatkitTaskGroup: Data.ChatKitTaskGroup) =
            addData(Data.ofChatKitTaskGroup(chatkitTaskGroup))

        /** The ID of the first item in the list. */
        fun firstId(firstId: String?) = firstId(JsonField.ofNullable(firstId))

        /** Alias for calling [Builder.firstId] with `firstId.orElse(null)`. */
        fun firstId(firstId: Optional<String>) = firstId(firstId.getOrNull())

        /**
         * Sets [Builder.firstId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.firstId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun firstId(firstId: JsonField<String>) = apply { this.firstId = firstId }

        /** Whether there are more items available. */
        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** The ID of the last item in the list. */
        fun lastId(lastId: String?) = lastId(JsonField.ofNullable(lastId))

        /** Alias for calling [Builder.lastId] with `lastId.orElse(null)`. */
        fun lastId(lastId: Optional<String>) = lastId(lastId.getOrNull())

        /**
         * Sets [Builder.lastId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastId(lastId: JsonField<String>) = apply { this.lastId = lastId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("list")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [ChatKitThreadItemList].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatKitThreadItemList =
            ChatKitThreadItemList(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("firstId", firstId),
                checkRequired("hasMore", hasMore),
                checkRequired("lastId", lastId),
                object_,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatKitThreadItemList = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        firstId()
        hasMore()
        lastId()
        _object_().let {
            if (it != JsonValue.from("list")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (firstId.asKnown().isPresent) 1 else 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (lastId.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("list")) 1 else 0 }

    /** User-authored messages within a thread. */
    @JsonDeserialize(using = Data.Deserializer::class)
    @JsonSerialize(using = Data.Serializer::class)
    class Data
    private constructor(
        private val chatkitUserMessage: ChatKitThreadUserMessageItem? = null,
        private val chatkitAssistantMessage: ChatKitThreadAssistantMessageItem? = null,
        private val chatkitWidget: ChatKitWidgetItem? = null,
        private val chatkitClientToolCall: ChatKitClientToolCall? = null,
        private val chatkitTask: ChatKitTask? = null,
        private val chatkitTaskGroup: ChatKitTaskGroup? = null,
        private val _json: JsonValue? = null,
    ) {

        /** User-authored messages within a thread. */
        fun chatkitUserMessage(): Optional<ChatKitThreadUserMessageItem> =
            Optional.ofNullable(chatkitUserMessage)

        /** Assistant-authored message within a thread. */
        fun chatkitAssistantMessage(): Optional<ChatKitThreadAssistantMessageItem> =
            Optional.ofNullable(chatkitAssistantMessage)

        /** Thread item that renders a widget payload. */
        fun chatkitWidget(): Optional<ChatKitWidgetItem> = Optional.ofNullable(chatkitWidget)

        /** Record of a client side tool invocation initiated by the assistant. */
        fun chatkitClientToolCall(): Optional<ChatKitClientToolCall> =
            Optional.ofNullable(chatkitClientToolCall)

        /** Task emitted by the workflow to show progress and status updates. */
        fun chatkitTask(): Optional<ChatKitTask> = Optional.ofNullable(chatkitTask)

        /** Collection of workflow tasks grouped together in the thread. */
        fun chatkitTaskGroup(): Optional<ChatKitTaskGroup> = Optional.ofNullable(chatkitTaskGroup)

        fun isChatKitUserMessage(): Boolean = chatkitUserMessage != null

        fun isChatKitAssistantMessage(): Boolean = chatkitAssistantMessage != null

        fun isChatKitWidget(): Boolean = chatkitWidget != null

        fun isChatKitClientToolCall(): Boolean = chatkitClientToolCall != null

        fun isChatKitTask(): Boolean = chatkitTask != null

        fun isChatKitTaskGroup(): Boolean = chatkitTaskGroup != null

        /** User-authored messages within a thread. */
        fun asChatKitUserMessage(): ChatKitThreadUserMessageItem =
            chatkitUserMessage.getOrThrow("chatkitUserMessage")

        /** Assistant-authored message within a thread. */
        fun asChatKitAssistantMessage(): ChatKitThreadAssistantMessageItem =
            chatkitAssistantMessage.getOrThrow("chatkitAssistantMessage")

        /** Thread item that renders a widget payload. */
        fun asChatKitWidget(): ChatKitWidgetItem = chatkitWidget.getOrThrow("chatkitWidget")

        /** Record of a client side tool invocation initiated by the assistant. */
        fun asChatKitClientToolCall(): ChatKitClientToolCall =
            chatkitClientToolCall.getOrThrow("chatkitClientToolCall")

        /** Task emitted by the workflow to show progress and status updates. */
        fun asChatKitTask(): ChatKitTask = chatkitTask.getOrThrow("chatkitTask")

        /** Collection of workflow tasks grouped together in the thread. */
        fun asChatKitTaskGroup(): ChatKitTaskGroup = chatkitTaskGroup.getOrThrow("chatkitTaskGroup")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                chatkitUserMessage != null -> visitor.visitChatKitUserMessage(chatkitUserMessage)
                chatkitAssistantMessage != null ->
                    visitor.visitChatKitAssistantMessage(chatkitAssistantMessage)
                chatkitWidget != null -> visitor.visitChatKitWidget(chatkitWidget)
                chatkitClientToolCall != null ->
                    visitor.visitChatKitClientToolCall(chatkitClientToolCall)
                chatkitTask != null -> visitor.visitChatKitTask(chatkitTask)
                chatkitTaskGroup != null -> visitor.visitChatKitTaskGroup(chatkitTaskGroup)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitChatKitUserMessage(
                        chatkitUserMessage: ChatKitThreadUserMessageItem
                    ) {
                        chatkitUserMessage.validate()
                    }

                    override fun visitChatKitAssistantMessage(
                        chatkitAssistantMessage: ChatKitThreadAssistantMessageItem
                    ) {
                        chatkitAssistantMessage.validate()
                    }

                    override fun visitChatKitWidget(chatkitWidget: ChatKitWidgetItem) {
                        chatkitWidget.validate()
                    }

                    override fun visitChatKitClientToolCall(
                        chatkitClientToolCall: ChatKitClientToolCall
                    ) {
                        chatkitClientToolCall.validate()
                    }

                    override fun visitChatKitTask(chatkitTask: ChatKitTask) {
                        chatkitTask.validate()
                    }

                    override fun visitChatKitTaskGroup(chatkitTaskGroup: ChatKitTaskGroup) {
                        chatkitTaskGroup.validate()
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
                    override fun visitChatKitUserMessage(
                        chatkitUserMessage: ChatKitThreadUserMessageItem
                    ) = chatkitUserMessage.validity()

                    override fun visitChatKitAssistantMessage(
                        chatkitAssistantMessage: ChatKitThreadAssistantMessageItem
                    ) = chatkitAssistantMessage.validity()

                    override fun visitChatKitWidget(chatkitWidget: ChatKitWidgetItem) =
                        chatkitWidget.validity()

                    override fun visitChatKitClientToolCall(
                        chatkitClientToolCall: ChatKitClientToolCall
                    ) = chatkitClientToolCall.validity()

                    override fun visitChatKitTask(chatkitTask: ChatKitTask) = chatkitTask.validity()

                    override fun visitChatKitTaskGroup(chatkitTaskGroup: ChatKitTaskGroup) =
                        chatkitTaskGroup.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                chatkitUserMessage == other.chatkitUserMessage &&
                chatkitAssistantMessage == other.chatkitAssistantMessage &&
                chatkitWidget == other.chatkitWidget &&
                chatkitClientToolCall == other.chatkitClientToolCall &&
                chatkitTask == other.chatkitTask &&
                chatkitTaskGroup == other.chatkitTaskGroup
        }

        override fun hashCode(): Int =
            Objects.hash(
                chatkitUserMessage,
                chatkitAssistantMessage,
                chatkitWidget,
                chatkitClientToolCall,
                chatkitTask,
                chatkitTaskGroup,
            )

        override fun toString(): String =
            when {
                chatkitUserMessage != null -> "Data{chatkitUserMessage=$chatkitUserMessage}"
                chatkitAssistantMessage != null ->
                    "Data{chatkitAssistantMessage=$chatkitAssistantMessage}"
                chatkitWidget != null -> "Data{chatkitWidget=$chatkitWidget}"
                chatkitClientToolCall != null ->
                    "Data{chatkitClientToolCall=$chatkitClientToolCall}"
                chatkitTask != null -> "Data{chatkitTask=$chatkitTask}"
                chatkitTaskGroup != null -> "Data{chatkitTaskGroup=$chatkitTaskGroup}"
                _json != null -> "Data{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Data")
            }

        companion object {

            /** User-authored messages within a thread. */
            @JvmStatic
            fun ofChatKitUserMessage(chatkitUserMessage: ChatKitThreadUserMessageItem) =
                Data(chatkitUserMessage = chatkitUserMessage)

            /** Assistant-authored message within a thread. */
            @JvmStatic
            fun ofChatKitAssistantMessage(
                chatkitAssistantMessage: ChatKitThreadAssistantMessageItem
            ) = Data(chatkitAssistantMessage = chatkitAssistantMessage)

            /** Thread item that renders a widget payload. */
            @JvmStatic
            fun ofChatKitWidget(chatkitWidget: ChatKitWidgetItem) =
                Data(chatkitWidget = chatkitWidget)

            /** Record of a client side tool invocation initiated by the assistant. */
            @JvmStatic
            fun ofChatKitClientToolCall(chatkitClientToolCall: ChatKitClientToolCall) =
                Data(chatkitClientToolCall = chatkitClientToolCall)

            /** Task emitted by the workflow to show progress and status updates. */
            @JvmStatic fun ofChatKitTask(chatkitTask: ChatKitTask) = Data(chatkitTask = chatkitTask)

            /** Collection of workflow tasks grouped together in the thread. */
            @JvmStatic
            fun ofChatKitTaskGroup(chatkitTaskGroup: ChatKitTaskGroup) =
                Data(chatkitTaskGroup = chatkitTaskGroup)
        }

        /** An interface that defines how to map each variant of [Data] to a value of type [T]. */
        interface Visitor<out T> {

            /** User-authored messages within a thread. */
            fun visitChatKitUserMessage(chatkitUserMessage: ChatKitThreadUserMessageItem): T

            /** Assistant-authored message within a thread. */
            fun visitChatKitAssistantMessage(
                chatkitAssistantMessage: ChatKitThreadAssistantMessageItem
            ): T

            /** Thread item that renders a widget payload. */
            fun visitChatKitWidget(chatkitWidget: ChatKitWidgetItem): T

            /** Record of a client side tool invocation initiated by the assistant. */
            fun visitChatKitClientToolCall(chatkitClientToolCall: ChatKitClientToolCall): T

            /** Task emitted by the workflow to show progress and status updates. */
            fun visitChatKitTask(chatkitTask: ChatKitTask): T

            /** Collection of workflow tasks grouped together in the thread. */
            fun visitChatKitTaskGroup(chatkitTaskGroup: ChatKitTaskGroup): T

            /**
             * Maps an unknown variant of [Data] to a value of type [T].
             *
             * An instance of [Data] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Data: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Data>(Data::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Data {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "chatkit.user_message" -> {
                        return tryDeserialize(node, jacksonTypeRef<ChatKitThreadUserMessageItem>())
                            ?.let { Data(chatkitUserMessage = it, _json = json) }
                            ?: Data(_json = json)
                    }
                    "chatkit.assistant_message" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<ChatKitThreadAssistantMessageItem>(),
                            )
                            ?.let { Data(chatkitAssistantMessage = it, _json = json) }
                            ?: Data(_json = json)
                    }
                    "chatkit.widget" -> {
                        return tryDeserialize(node, jacksonTypeRef<ChatKitWidgetItem>())?.let {
                            Data(chatkitWidget = it, _json = json)
                        } ?: Data(_json = json)
                    }
                    "chatkit.client_tool_call" -> {
                        return tryDeserialize(node, jacksonTypeRef<ChatKitClientToolCall>())?.let {
                            Data(chatkitClientToolCall = it, _json = json)
                        } ?: Data(_json = json)
                    }
                    "chatkit.task" -> {
                        return tryDeserialize(node, jacksonTypeRef<ChatKitTask>())?.let {
                            Data(chatkitTask = it, _json = json)
                        } ?: Data(_json = json)
                    }
                    "chatkit.task_group" -> {
                        return tryDeserialize(node, jacksonTypeRef<ChatKitTaskGroup>())?.let {
                            Data(chatkitTaskGroup = it, _json = json)
                        } ?: Data(_json = json)
                    }
                }

                return Data(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Data>(Data::class) {

            override fun serialize(
                value: Data,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.chatkitUserMessage != null ->
                        generator.writeObject(value.chatkitUserMessage)
                    value.chatkitAssistantMessage != null ->
                        generator.writeObject(value.chatkitAssistantMessage)
                    value.chatkitWidget != null -> generator.writeObject(value.chatkitWidget)
                    value.chatkitClientToolCall != null ->
                        generator.writeObject(value.chatkitClientToolCall)
                    value.chatkitTask != null -> generator.writeObject(value.chatkitTask)
                    value.chatkitTaskGroup != null -> generator.writeObject(value.chatkitTaskGroup)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Data")
                }
            }
        }

        /** Record of a client side tool invocation initiated by the assistant. */
        class ChatKitClientToolCall
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val arguments: JsonField<String>,
            private val callId: JsonField<String>,
            private val createdAt: JsonField<Long>,
            private val name: JsonField<String>,
            private val object_: JsonValue,
            private val output: JsonField<String>,
            private val status: JsonField<Status>,
            private val threadId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("arguments")
                @ExcludeMissing
                arguments: JsonField<String> = JsonMissing.of(),
                @JsonProperty("call_id")
                @ExcludeMissing
                callId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("created_at")
                @ExcludeMissing
                createdAt: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                @JsonProperty("output")
                @ExcludeMissing
                output: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status")
                @ExcludeMissing
                status: JsonField<Status> = JsonMissing.of(),
                @JsonProperty("thread_id")
                @ExcludeMissing
                threadId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(
                id,
                arguments,
                callId,
                createdAt,
                name,
                object_,
                output,
                status,
                threadId,
                type,
                mutableMapOf(),
            )

            /**
             * Identifier of the thread item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * JSON-encoded arguments that were sent to the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun arguments(): String = arguments.getRequired("arguments")

            /**
             * Identifier for the client tool call.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun callId(): String = callId.getRequired("call_id")

            /**
             * Unix timestamp (in seconds) for when the item was created.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun createdAt(): Long = createdAt.getRequired("created_at")

            /**
             * Tool name that was invoked.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Type discriminator that is always `chatkit.thread_item`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("chatkit.thread_item")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

            /**
             * JSON-encoded output captured from the tool. Defaults to null while execution is in
             * progress.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun output(): Optional<String> = output.getOptional("output")

            /**
             * Execution status for the tool call.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun status(): Status = status.getRequired("status")

            /**
             * Identifier of the parent thread.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun threadId(): String = threadId.getRequired("thread_id")

            /**
             * Type discriminator that is always `chatkit.client_tool_call`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("chatkit.client_tool_call")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [arguments].
             *
             * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("arguments")
            @ExcludeMissing
            fun _arguments(): JsonField<String> = arguments

            /**
             * Returns the raw JSON value of [callId].
             *
             * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<Long> = createdAt

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [output].
             *
             * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

            /**
             * Returns the raw JSON value of [status].
             *
             * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

            /**
             * Returns the raw JSON value of [threadId].
             *
             * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

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
                 * [ChatKitClientToolCall].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .arguments()
                 * .callId()
                 * .createdAt()
                 * .name()
                 * .output()
                 * .status()
                 * .threadId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChatKitClientToolCall]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var arguments: JsonField<String>? = null
                private var callId: JsonField<String>? = null
                private var createdAt: JsonField<Long>? = null
                private var name: JsonField<String>? = null
                private var object_: JsonValue = JsonValue.from("chatkit.thread_item")
                private var output: JsonField<String>? = null
                private var status: JsonField<Status>? = null
                private var threadId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("chatkit.client_tool_call")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(chatkitClientToolCall: ChatKitClientToolCall) = apply {
                    id = chatkitClientToolCall.id
                    arguments = chatkitClientToolCall.arguments
                    callId = chatkitClientToolCall.callId
                    createdAt = chatkitClientToolCall.createdAt
                    name = chatkitClientToolCall.name
                    object_ = chatkitClientToolCall.object_
                    output = chatkitClientToolCall.output
                    status = chatkitClientToolCall.status
                    threadId = chatkitClientToolCall.threadId
                    type = chatkitClientToolCall.type
                    additionalProperties = chatkitClientToolCall.additionalProperties.toMutableMap()
                }

                /** Identifier of the thread item. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** JSON-encoded arguments that were sent to the tool. */
                fun arguments(arguments: String) = arguments(JsonField.of(arguments))

                /**
                 * Sets [Builder.arguments] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.arguments] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

                /** Identifier for the client tool call. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /**
                 * Sets [Builder.callId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.callId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** Unix timestamp (in seconds) for when the item was created. */
                fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

                /** Tool name that was invoked. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("chatkit.thread_item")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                /**
                 * JSON-encoded output captured from the tool. Defaults to null while execution is
                 * in progress.
                 */
                fun output(output: String?) = output(JsonField.ofNullable(output))

                /** Alias for calling [Builder.output] with `output.orElse(null)`. */
                fun output(output: Optional<String>) = output(output.getOrNull())

                /**
                 * Sets [Builder.output] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.output] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun output(output: JsonField<String>) = apply { this.output = output }

                /** Execution status for the tool call. */
                fun status(status: Status) = status(JsonField.of(status))

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [Status] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

                /** Identifier of the parent thread. */
                fun threadId(threadId: String) = threadId(JsonField.of(threadId))

                /**
                 * Sets [Builder.threadId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.threadId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("chatkit.client_tool_call")
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
                 * Returns an immutable instance of [ChatKitClientToolCall].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .arguments()
                 * .callId()
                 * .createdAt()
                 * .name()
                 * .output()
                 * .status()
                 * .threadId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ChatKitClientToolCall =
                    ChatKitClientToolCall(
                        checkRequired("id", id),
                        checkRequired("arguments", arguments),
                        checkRequired("callId", callId),
                        checkRequired("createdAt", createdAt),
                        checkRequired("name", name),
                        object_,
                        checkRequired("output", output),
                        checkRequired("status", status),
                        checkRequired("threadId", threadId),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChatKitClientToolCall = apply {
                if (validated) {
                    return@apply
                }

                id()
                arguments()
                callId()
                createdAt()
                name()
                _object_().let {
                    if (it != JsonValue.from("chatkit.thread_item")) {
                        throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                    }
                }
                output()
                status().validate()
                threadId()
                _type().let {
                    if (it != JsonValue.from("chatkit.client_tool_call")) {
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (arguments.asKnown().isPresent) 1 else 0) +
                    (if (callId.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    object_.let { if (it == JsonValue.from("chatkit.thread_item")) 1 else 0 } +
                    (if (output.asKnown().isPresent) 1 else 0) +
                    (status.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (threadId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("chatkit.client_tool_call")) 1 else 0 }

            /** Execution status for the tool call. */
            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val IN_PROGRESS = of("in_progress")

                    @JvmField val COMPLETED = of("completed")

                    @JvmStatic fun of(value: String) = Status(JsonField.of(value))
                }

                /** An enum containing [Status]'s known values. */
                enum class Known {
                    IN_PROGRESS,
                    COMPLETED,
                }

                /**
                 * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Status] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IN_PROGRESS,
                    COMPLETED,
                    /**
                     * An enum member indicating that [Status] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        IN_PROGRESS -> Value.IN_PROGRESS
                        COMPLETED -> Value.COMPLETED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        IN_PROGRESS -> Known.IN_PROGRESS
                        COMPLETED -> Known.COMPLETED
                        else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

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

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChatKitClientToolCall &&
                    id == other.id &&
                    arguments == other.arguments &&
                    callId == other.callId &&
                    createdAt == other.createdAt &&
                    name == other.name &&
                    object_ == other.object_ &&
                    output == other.output &&
                    status == other.status &&
                    threadId == other.threadId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    arguments,
                    callId,
                    createdAt,
                    name,
                    object_,
                    output,
                    status,
                    threadId,
                    type,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChatKitClientToolCall{id=$id, arguments=$arguments, callId=$callId, createdAt=$createdAt, name=$name, object_=$object_, output=$output, status=$status, threadId=$threadId, type=$type, additionalProperties=$additionalProperties}"
        }

        /** Task emitted by the workflow to show progress and status updates. */
        class ChatKitTask
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val createdAt: JsonField<Long>,
            private val heading: JsonField<String>,
            private val object_: JsonValue,
            private val summary: JsonField<String>,
            private val taskType: JsonField<TaskType>,
            private val threadId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("created_at")
                @ExcludeMissing
                createdAt: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("heading")
                @ExcludeMissing
                heading: JsonField<String> = JsonMissing.of(),
                @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                @JsonProperty("summary")
                @ExcludeMissing
                summary: JsonField<String> = JsonMissing.of(),
                @JsonProperty("task_type")
                @ExcludeMissing
                taskType: JsonField<TaskType> = JsonMissing.of(),
                @JsonProperty("thread_id")
                @ExcludeMissing
                threadId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(
                id,
                createdAt,
                heading,
                object_,
                summary,
                taskType,
                threadId,
                type,
                mutableMapOf(),
            )

            /**
             * Identifier of the thread item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * Unix timestamp (in seconds) for when the item was created.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun createdAt(): Long = createdAt.getRequired("created_at")

            /**
             * Optional heading for the task. Defaults to null when not provided.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun heading(): Optional<String> = heading.getOptional("heading")

            /**
             * Type discriminator that is always `chatkit.thread_item`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("chatkit.thread_item")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

            /**
             * Optional summary that describes the task. Defaults to null when omitted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun summary(): Optional<String> = summary.getOptional("summary")

            /**
             * Subtype for the task.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun taskType(): TaskType = taskType.getRequired("task_type")

            /**
             * Identifier of the parent thread.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun threadId(): String = threadId.getRequired("thread_id")

            /**
             * Type discriminator that is always `chatkit.task`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("chatkit.task")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<Long> = createdAt

            /**
             * Returns the raw JSON value of [heading].
             *
             * Unlike [heading], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("heading") @ExcludeMissing fun _heading(): JsonField<String> = heading

            /**
             * Returns the raw JSON value of [summary].
             *
             * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<String> = summary

            /**
             * Returns the raw JSON value of [taskType].
             *
             * Unlike [taskType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("task_type")
            @ExcludeMissing
            fun _taskType(): JsonField<TaskType> = taskType

            /**
             * Returns the raw JSON value of [threadId].
             *
             * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

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
                 * Returns a mutable builder for constructing an instance of [ChatKitTask].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .createdAt()
                 * .heading()
                 * .summary()
                 * .taskType()
                 * .threadId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChatKitTask]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var createdAt: JsonField<Long>? = null
                private var heading: JsonField<String>? = null
                private var object_: JsonValue = JsonValue.from("chatkit.thread_item")
                private var summary: JsonField<String>? = null
                private var taskType: JsonField<TaskType>? = null
                private var threadId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("chatkit.task")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(chatkitTask: ChatKitTask) = apply {
                    id = chatkitTask.id
                    createdAt = chatkitTask.createdAt
                    heading = chatkitTask.heading
                    object_ = chatkitTask.object_
                    summary = chatkitTask.summary
                    taskType = chatkitTask.taskType
                    threadId = chatkitTask.threadId
                    type = chatkitTask.type
                    additionalProperties = chatkitTask.additionalProperties.toMutableMap()
                }

                /** Identifier of the thread item. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Unix timestamp (in seconds) for when the item was created. */
                fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

                /** Optional heading for the task. Defaults to null when not provided. */
                fun heading(heading: String?) = heading(JsonField.ofNullable(heading))

                /** Alias for calling [Builder.heading] with `heading.orElse(null)`. */
                fun heading(heading: Optional<String>) = heading(heading.getOrNull())

                /**
                 * Sets [Builder.heading] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.heading] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun heading(heading: JsonField<String>) = apply { this.heading = heading }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("chatkit.thread_item")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                /** Optional summary that describes the task. Defaults to null when omitted. */
                fun summary(summary: String?) = summary(JsonField.ofNullable(summary))

                /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
                fun summary(summary: Optional<String>) = summary(summary.getOrNull())

                /**
                 * Sets [Builder.summary] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.summary] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun summary(summary: JsonField<String>) = apply { this.summary = summary }

                /** Subtype for the task. */
                fun taskType(taskType: TaskType) = taskType(JsonField.of(taskType))

                /**
                 * Sets [Builder.taskType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.taskType] with a well-typed [TaskType] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun taskType(taskType: JsonField<TaskType>) = apply { this.taskType = taskType }

                /** Identifier of the parent thread. */
                fun threadId(threadId: String) = threadId(JsonField.of(threadId))

                /**
                 * Sets [Builder.threadId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.threadId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("chatkit.task")
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
                 * Returns an immutable instance of [ChatKitTask].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .createdAt()
                 * .heading()
                 * .summary()
                 * .taskType()
                 * .threadId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ChatKitTask =
                    ChatKitTask(
                        checkRequired("id", id),
                        checkRequired("createdAt", createdAt),
                        checkRequired("heading", heading),
                        object_,
                        checkRequired("summary", summary),
                        checkRequired("taskType", taskType),
                        checkRequired("threadId", threadId),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChatKitTask = apply {
                if (validated) {
                    return@apply
                }

                id()
                createdAt()
                heading()
                _object_().let {
                    if (it != JsonValue.from("chatkit.thread_item")) {
                        throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                    }
                }
                summary()
                taskType().validate()
                threadId()
                _type().let {
                    if (it != JsonValue.from("chatkit.task")) {
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (heading.asKnown().isPresent) 1 else 0) +
                    object_.let { if (it == JsonValue.from("chatkit.thread_item")) 1 else 0 } +
                    (if (summary.asKnown().isPresent) 1 else 0) +
                    (taskType.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (threadId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("chatkit.task")) 1 else 0 }

            /** Subtype for the task. */
            class TaskType @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val CUSTOM = of("custom")

                    @JvmField val THOUGHT = of("thought")

                    @JvmStatic fun of(value: String) = TaskType(JsonField.of(value))
                }

                /** An enum containing [TaskType]'s known values. */
                enum class Known {
                    CUSTOM,
                    THOUGHT,
                }

                /**
                 * An enum containing [TaskType]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [TaskType] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CUSTOM,
                    THOUGHT,
                    /**
                     * An enum member indicating that [TaskType] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        CUSTOM -> Value.CUSTOM
                        THOUGHT -> Value.THOUGHT
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        CUSTOM -> Known.CUSTOM
                        THOUGHT -> Known.THOUGHT
                        else -> throw OpenAIInvalidDataException("Unknown TaskType: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): TaskType = apply {
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

                    return other is TaskType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChatKitTask &&
                    id == other.id &&
                    createdAt == other.createdAt &&
                    heading == other.heading &&
                    object_ == other.object_ &&
                    summary == other.summary &&
                    taskType == other.taskType &&
                    threadId == other.threadId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    createdAt,
                    heading,
                    object_,
                    summary,
                    taskType,
                    threadId,
                    type,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChatKitTask{id=$id, createdAt=$createdAt, heading=$heading, object_=$object_, summary=$summary, taskType=$taskType, threadId=$threadId, type=$type, additionalProperties=$additionalProperties}"
        }

        /** Collection of workflow tasks grouped together in the thread. */
        class ChatKitTaskGroup
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val createdAt: JsonField<Long>,
            private val object_: JsonValue,
            private val tasks: JsonField<List<Task>>,
            private val threadId: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("created_at")
                @ExcludeMissing
                createdAt: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
                @JsonProperty("tasks")
                @ExcludeMissing
                tasks: JsonField<List<Task>> = JsonMissing.of(),
                @JsonProperty("thread_id")
                @ExcludeMissing
                threadId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(id, createdAt, object_, tasks, threadId, type, mutableMapOf())

            /**
             * Identifier of the thread item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * Unix timestamp (in seconds) for when the item was created.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun createdAt(): Long = createdAt.getRequired("created_at")

            /**
             * Type discriminator that is always `chatkit.thread_item`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("chatkit.thread_item")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

            /**
             * Tasks included in the group.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tasks(): List<Task> = tasks.getRequired("tasks")

            /**
             * Identifier of the parent thread.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun threadId(): String = threadId.getRequired("thread_id")

            /**
             * Type discriminator that is always `chatkit.task_group`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("chatkit.task_group")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<Long> = createdAt

            /**
             * Returns the raw JSON value of [tasks].
             *
             * Unlike [tasks], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tasks") @ExcludeMissing fun _tasks(): JsonField<List<Task>> = tasks

            /**
             * Returns the raw JSON value of [threadId].
             *
             * Unlike [threadId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("thread_id") @ExcludeMissing fun _threadId(): JsonField<String> = threadId

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
                 * Returns a mutable builder for constructing an instance of [ChatKitTaskGroup].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .createdAt()
                 * .tasks()
                 * .threadId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChatKitTaskGroup]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var createdAt: JsonField<Long>? = null
                private var object_: JsonValue = JsonValue.from("chatkit.thread_item")
                private var tasks: JsonField<MutableList<Task>>? = null
                private var threadId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("chatkit.task_group")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(chatkitTaskGroup: ChatKitTaskGroup) = apply {
                    id = chatkitTaskGroup.id
                    createdAt = chatkitTaskGroup.createdAt
                    object_ = chatkitTaskGroup.object_
                    tasks = chatkitTaskGroup.tasks.map { it.toMutableList() }
                    threadId = chatkitTaskGroup.threadId
                    type = chatkitTaskGroup.type
                    additionalProperties = chatkitTaskGroup.additionalProperties.toMutableMap()
                }

                /** Identifier of the thread item. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Unix timestamp (in seconds) for when the item was created. */
                fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("chatkit.thread_item")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun object_(object_: JsonValue) = apply { this.object_ = object_ }

                /** Tasks included in the group. */
                fun tasks(tasks: List<Task>) = tasks(JsonField.of(tasks))

                /**
                 * Sets [Builder.tasks] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tasks] with a well-typed `List<Task>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tasks(tasks: JsonField<List<Task>>) = apply {
                    this.tasks = tasks.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Task] to [tasks].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTask(task: Task) = apply {
                    tasks =
                        (tasks ?: JsonField.of(mutableListOf())).also {
                            checkKnown("tasks", it).add(task)
                        }
                }

                /** Identifier of the parent thread. */
                fun threadId(threadId: String) = threadId(JsonField.of(threadId))

                /**
                 * Sets [Builder.threadId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.threadId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun threadId(threadId: JsonField<String>) = apply { this.threadId = threadId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("chatkit.task_group")
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
                 * Returns an immutable instance of [ChatKitTaskGroup].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .createdAt()
                 * .tasks()
                 * .threadId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ChatKitTaskGroup =
                    ChatKitTaskGroup(
                        checkRequired("id", id),
                        checkRequired("createdAt", createdAt),
                        object_,
                        checkRequired("tasks", tasks).map { it.toImmutable() },
                        checkRequired("threadId", threadId),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChatKitTaskGroup = apply {
                if (validated) {
                    return@apply
                }

                id()
                createdAt()
                _object_().let {
                    if (it != JsonValue.from("chatkit.thread_item")) {
                        throw OpenAIInvalidDataException("'object_' is invalid, received $it")
                    }
                }
                tasks().forEach { it.validate() }
                threadId()
                _type().let {
                    if (it != JsonValue.from("chatkit.task_group")) {
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    object_.let { if (it == JsonValue.from("chatkit.thread_item")) 1 else 0 } +
                    (tasks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (threadId.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("chatkit.task_group")) 1 else 0 }

            /** Task entry that appears within a TaskGroup. */
            class Task
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val heading: JsonField<String>,
                private val summary: JsonField<String>,
                private val type: JsonField<Type>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("heading")
                    @ExcludeMissing
                    heading: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("summary")
                    @ExcludeMissing
                    summary: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                ) : this(heading, summary, type, mutableMapOf())

                /**
                 * Optional heading for the grouped task. Defaults to null when not provided.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun heading(): Optional<String> = heading.getOptional("heading")

                /**
                 * Optional summary that describes the grouped task. Defaults to null when omitted.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun summary(): Optional<String> = summary.getOptional("summary")

                /**
                 * Subtype for the grouped task.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): Type = type.getRequired("type")

                /**
                 * Returns the raw JSON value of [heading].
                 *
                 * Unlike [heading], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("heading") @ExcludeMissing fun _heading(): JsonField<String> = heading

                /**
                 * Returns the raw JSON value of [summary].
                 *
                 * Unlike [summary], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<String> = summary

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                     * Returns a mutable builder for constructing an instance of [Task].
                     *
                     * The following fields are required:
                     * ```java
                     * .heading()
                     * .summary()
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Task]. */
                class Builder internal constructor() {

                    private var heading: JsonField<String>? = null
                    private var summary: JsonField<String>? = null
                    private var type: JsonField<Type>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(task: Task) = apply {
                        heading = task.heading
                        summary = task.summary
                        type = task.type
                        additionalProperties = task.additionalProperties.toMutableMap()
                    }

                    /**
                     * Optional heading for the grouped task. Defaults to null when not provided.
                     */
                    fun heading(heading: String?) = heading(JsonField.ofNullable(heading))

                    /** Alias for calling [Builder.heading] with `heading.orElse(null)`. */
                    fun heading(heading: Optional<String>) = heading(heading.getOrNull())

                    /**
                     * Sets [Builder.heading] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.heading] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun heading(heading: JsonField<String>) = apply { this.heading = heading }

                    /**
                     * Optional summary that describes the grouped task. Defaults to null when
                     * omitted.
                     */
                    fun summary(summary: String?) = summary(JsonField.ofNullable(summary))

                    /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
                    fun summary(summary: Optional<String>) = summary(summary.getOrNull())

                    /**
                     * Sets [Builder.summary] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.summary] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun summary(summary: JsonField<String>) = apply { this.summary = summary }

                    /** Subtype for the grouped task. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
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

                    /**
                     * Returns an immutable instance of [Task].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .heading()
                     * .summary()
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Task =
                        Task(
                            checkRequired("heading", heading),
                            checkRequired("summary", summary),
                            checkRequired("type", type),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Task = apply {
                    if (validated) {
                        return@apply
                    }

                    heading()
                    summary()
                    type().validate()
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
                    (if (heading.asKnown().isPresent) 1 else 0) +
                        (if (summary.asKnown().isPresent) 1 else 0) +
                        (type.asKnown().getOrNull()?.validity() ?: 0)

                /** Subtype for the grouped task. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val CUSTOM = of("custom")

                        @JvmField val THOUGHT = of("thought")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        CUSTOM,
                        THOUGHT,
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        CUSTOM,
                        THOUGHT,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            CUSTOM -> Value.CUSTOM
                            THOUGHT -> Value.THOUGHT
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            CUSTOM -> Known.CUSTOM
                            THOUGHT -> Known.THOUGHT
                            else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            OpenAIInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Type = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Task &&
                        heading == other.heading &&
                        summary == other.summary &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(heading, summary, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Task{heading=$heading, summary=$summary, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChatKitTaskGroup &&
                    id == other.id &&
                    createdAt == other.createdAt &&
                    object_ == other.object_ &&
                    tasks == other.tasks &&
                    threadId == other.threadId &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, createdAt, object_, tasks, threadId, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChatKitTaskGroup{id=$id, createdAt=$createdAt, object_=$object_, tasks=$tasks, threadId=$threadId, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatKitThreadItemList &&
            data == other.data &&
            firstId == other.firstId &&
            hasMore == other.hasMore &&
            lastId == other.lastId &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, firstId, hasMore, lastId, object_, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatKitThreadItemList{data=$data, firstId=$firstId, hasMore=$hasMore, lastId=$lastId, object_=$object_, additionalProperties=$additionalProperties}"
}
