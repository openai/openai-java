// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Append an input item for future decisions without starting an evaluation or changing Live voice
 * context.
 */
class DecisionItemCreateEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val item: JsonField<Item>,
    private val type: JsonValue,
    private val eventId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item") @ExcludeMissing item: JsonField<Item> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
    ) : this(item, type, eventId, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): Item = item.getRequired("item")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("decision.item.create")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional client identifier for correlating this command with a server event's client_event_id
     * or error.client_event_id.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventId(): Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<Item> = item

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "item" to this.item,
            "type" to this.type,
            "event_id" to this.eventId,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DecisionItemCreateEvent].
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionItemCreateEvent]. */
    class Builder internal constructor() {

        private var item: JsonField<Item>? = null
        private var type: JsonValue = JsonValue.from("decision.item.create")
        private var eventId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionItemCreateEvent: DecisionItemCreateEvent) = apply {
            item = decisionItemCreateEvent.item
            type = decisionItemCreateEvent.type
            eventId = decisionItemCreateEvent.eventId
            additionalProperties = decisionItemCreateEvent.additionalProperties.toMutableMap()
        }

        fun item(item: Item) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [Item] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun item(item: JsonField<Item>) = apply { this.item = item }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("decision.item.create")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Optional client identifier for correlating this command with a server event's
         * client_event_id or error.client_event_id.
         */
        fun eventId(eventId: String?) = eventId(JsonField.ofNullable(eventId))

        /** Alias for calling [Builder.eventId] with `eventId.orElse(null)`. */
        fun eventId(eventId: Optional<String>) = eventId(eventId.getOrNull())

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

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
         * Returns an immutable instance of [DecisionItemCreateEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .item()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionItemCreateEvent =
            DecisionItemCreateEvent(
                checkRequired("item", item),
                type,
                eventId,
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
    fun validate(): DecisionItemCreateEvent = apply {
        if (validated) {
            return@apply
        }

        item().validate()
        _type().let {
            if (it != JsonValue.from("decision.item.create")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        eventId()
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
        (item.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("decision.item.create")) 1 else 0 } +
            (if (eventId.asKnown().isPresent) 1 else 0)

    class Item
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<Content>,
        private val role: JsonValue,
        private val id: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<Content> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(content, role, id, type, mutableMapOf())

        /**
         * The text input to the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): Content = content.getRequired("content")

        /**
         * The message role. Always `user`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("user")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

        /**
         * The unique ID of this message item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "content" to this.content,
                "role" to this.role,
                "id" to this.id,
                "type" to this.type,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Item].
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Item]. */
        class Builder internal constructor() {

            private var content: JsonField<Content>? = null
            private var role: JsonValue = JsonValue.from("user")
            private var id: JsonField<String> = JsonMissing.of()
            private var type: JsonField<Type> = JsonField.of(Type.MESSAGE)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(item: Item) = apply {
                content = item.content
                role = item.role
                id = item.id
                type = item.type
                additionalProperties = item.additionalProperties.toMutableMap()
            }

            /** The text input to the model. */
            fun content(content: Content) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [Content] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<Content>) = apply { this.content = content }

            /** Alias for calling [content] with `Content.ofString(string)`. */
            fun content(string: String) = content(Content.ofString(string))

            /**
             * Alias for calling [content] with
             * `Content.ofDecisionItemCreateEventItemContentItems(decisionItemCreateEventItemContentItems)`.
             */
            fun contentOfDecisionItemCreateEventItemContentItems(
                decisionItemCreateEventItemContentItems:
                    List<Content.DecisionItemCreateEventItemContentItem>
            ) =
                content(
                    Content.ofDecisionItemCreateEventItemContentItems(
                        decisionItemCreateEventItemContentItems
                    )
                )

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("user")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun role(role: JsonValue) = apply { this.role = role }

            /** The unique ID of this message item. */
            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [Item].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Item =
                Item(
                    checkRequired("content", content),
                    role,
                    id,
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
        fun validate(): Item = apply {
            if (validated) {
                return@apply
            }

            content().validate()
            _role().let {
                if (it != JsonValue.from("user")) {
                    throw OpenAIInvalidDataException("'role' is invalid, received $it")
                }
            }
            id()
            type().ifPresent { it.validate() }
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
            (content.asKnown().getOrNull()?.validity() ?: 0) +
                role.let { if (it == JsonValue.from("user")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** The text input to the model. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val string: String? = null,
            private val decisionItemCreateEventItemContentItems:
                List<DecisionItemCreateEventItemContentItem>? =
                null,
            private val _json: JsonValue? = null,
        ) {

            /** The text input to the model. */
            fun string(): Optional<String> = Optional.ofNullable(string)

            fun decisionItemCreateEventItemContentItems():
                Optional<List<DecisionItemCreateEventItemContentItem>> =
                Optional.ofNullable(decisionItemCreateEventItemContentItems)

            fun isString(): Boolean = string != null

            fun isDecisionItemCreateEventItemContentItems(): Boolean =
                decisionItemCreateEventItemContentItems != null

            /** The text input to the model. */
            fun asString(): String = string.getOrThrow("string")

            fun asDecisionItemCreateEventItemContentItems():
                List<DecisionItemCreateEventItemContentItem> =
                decisionItemCreateEventItemContentItems.getOrThrow(
                    "decisionItemCreateEventItemContentItems"
                )

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
             * Optional<String> result = content.accept(new Content.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitString(String string) {
             *         return Optional.of(string.toString());
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
                    string != null -> visitor.visitString(string)
                    decisionItemCreateEventItemContentItems != null ->
                        visitor.visitDecisionItemCreateEventItemContentItems(
                            decisionItemCreateEventItemContentItems
                        )
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
            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitDecisionItemCreateEventItemContentItems(
                            decisionItemCreateEventItemContentItems:
                                List<DecisionItemCreateEventItemContentItem>
                        ) {
                            decisionItemCreateEventItemContentItems.forEach { it.validate() }
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
                        override fun visitString(string: String) = 1

                        override fun visitDecisionItemCreateEventItemContentItems(
                            decisionItemCreateEventItemContentItems:
                                List<DecisionItemCreateEventItemContentItem>
                        ) = decisionItemCreateEventItemContentItems.sumOf { it.validity().toInt() }

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content &&
                    string == other.string &&
                    decisionItemCreateEventItemContentItems ==
                        other.decisionItemCreateEventItemContentItems
            }

            override fun hashCode(): Int =
                Objects.hash(string, decisionItemCreateEventItemContentItems)

            override fun toString(): String =
                when {
                    string != null -> "Content{string=$string}"
                    decisionItemCreateEventItemContentItems != null ->
                        "Content{decisionItemCreateEventItemContentItems=$decisionItemCreateEventItemContentItems}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** The text input to the model. */
                @JvmStatic fun ofString(string: String) = Content(string = string)

                @JvmStatic
                fun ofDecisionItemCreateEventItemContentItems(
                    decisionItemCreateEventItemContentItems:
                        List<DecisionItemCreateEventItemContentItem>
                ) =
                    Content(
                        decisionItemCreateEventItemContentItems =
                            decisionItemCreateEventItemContentItems.toImmutable()
                    )
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** The text input to the model. */
                fun visitString(string: String): T

                fun visitDecisionItemCreateEventItemContentItems(
                    decisionItemCreateEventItemContentItems:
                        List<DecisionItemCreateEventItemContentItem>
                ): T

                /**
                 * Maps an unknown variant of [Content] to a value of type [T].
                 *
                 * An instance of [Content] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Content")
                }
            }

            internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Content(string = it, _json = json)
                                },
                                tryDeserialize(
                                        node,
                                        jacksonTypeRef<
                                            List<DecisionItemCreateEventItemContentItem>
                                        >(),
                                    )
                                    ?.let {
                                        Content(
                                            decisionItemCreateEventItemContentItems = it,
                                            _json = json,
                                        )
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Content(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.decisionItemCreateEventItemContentItems != null ->
                            generator.writeObject(value.decisionItemCreateEventItemContentItems)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }

            @JsonDeserialize(using = DecisionItemCreateEventItemContentItem.Deserializer::class)
            @JsonSerialize(using = DecisionItemCreateEventItemContentItem.Serializer::class)
            class DecisionItemCreateEventItemContentItem
            private constructor(
                private val inputText: InputText? = null,
                private val inputImage: InputImage? = null,
                private val _json: JsonValue? = null,
            ) {

                fun inputText(): Optional<InputText> = Optional.ofNullable(inputText)

                fun inputImage(): Optional<InputImage> = Optional.ofNullable(inputImage)

                fun isInputText(): Boolean = inputText != null

                fun isInputImage(): Boolean = inputImage != null

                fun asInputText(): InputText = inputText.getOrThrow("inputText")

                fun asInputImage(): InputImage = inputImage.getOrThrow("inputImage")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = decisionItemCreateEventItemContentItem.accept(new DecisionItemCreateEventItemContentItem.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitInputText(InputText inputText) {
                 *         return Optional.of(inputText.toString());
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
                        inputText != null -> visitor.visitInputText(inputText)
                        inputImage != null -> visitor.visitInputImage(inputImage)
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): DecisionItemCreateEventItemContentItem = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitInputText(inputText: InputText) {
                                inputText.validate()
                            }

                            override fun visitInputImage(inputImage: InputImage) {
                                inputImage.validate()
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
                            override fun visitInputText(inputText: InputText) = inputText.validity()

                            override fun visitInputImage(inputImage: InputImage) =
                                inputImage.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is DecisionItemCreateEventItemContentItem &&
                        inputText == other.inputText &&
                        inputImage == other.inputImage
                }

                override fun hashCode(): Int = Objects.hash(inputText, inputImage)

                override fun toString(): String =
                    when {
                        inputText != null ->
                            "DecisionItemCreateEventItemContentItem{inputText=$inputText}"
                        inputImage != null ->
                            "DecisionItemCreateEventItemContentItem{inputImage=$inputImage}"
                        _json != null -> "DecisionItemCreateEventItemContentItem{_unknown=$_json}"
                        else ->
                            throw IllegalStateException(
                                "Invalid DecisionItemCreateEventItemContentItem"
                            )
                    }

                companion object {

                    @JvmStatic
                    fun ofInputText(inputText: InputText) =
                        DecisionItemCreateEventItemContentItem(inputText = inputText)

                    @JvmStatic
                    fun ofInputImage(inputImage: InputImage) =
                        DecisionItemCreateEventItemContentItem(inputImage = inputImage)
                }

                /**
                 * An interface that defines how to map each variant of
                 * [DecisionItemCreateEventItemContentItem] to a value of type [T].
                 */
                interface Visitor<out T> {

                    fun visitInputText(inputText: InputText): T

                    fun visitInputImage(inputImage: InputImage): T

                    /**
                     * Maps an unknown variant of [DecisionItemCreateEventItemContentItem] to a
                     * value of type [T].
                     *
                     * An instance of [DecisionItemCreateEventItemContentItem] can contain an
                     * unknown variant if it was deserialized from data that doesn't match any known
                     * variant. For example, if the SDK is on an older version than the API, then
                     * the API may respond with new variants that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException(
                            "Unknown DecisionItemCreateEventItemContentItem"
                        )
                    }
                }

                internal class Deserializer :
                    BaseDeserializer<DecisionItemCreateEventItemContentItem>(
                        DecisionItemCreateEventItemContentItem::class
                    ) {

                    override fun ObjectCodec.deserialize(
                        node: JsonNode
                    ): DecisionItemCreateEventItemContentItem {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "input_text" -> {
                                return tryDeserialize(node, jacksonTypeRef<InputText>())?.let {
                                    DecisionItemCreateEventItemContentItem(
                                        inputText = it,
                                        _json = json,
                                    )
                                } ?: DecisionItemCreateEventItemContentItem(_json = json)
                            }
                            "input_image" -> {
                                return tryDeserialize(node, jacksonTypeRef<InputImage>())?.let {
                                    DecisionItemCreateEventItemContentItem(
                                        inputImage = it,
                                        _json = json,
                                    )
                                } ?: DecisionItemCreateEventItemContentItem(_json = json)
                            }
                        }

                        return DecisionItemCreateEventItemContentItem(_json = json)
                    }
                }

                internal class Serializer :
                    BaseSerializer<DecisionItemCreateEventItemContentItem>(
                        DecisionItemCreateEventItemContentItem::class
                    ) {

                    override fun serialize(
                        value: DecisionItemCreateEventItemContentItem,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.inputText != null -> generator.writeObject(value.inputText)
                            value.inputImage != null -> generator.writeObject(value.inputImage)
                            value._json != null -> generator.writeObject(value._json)
                            else ->
                                throw IllegalStateException(
                                    "Invalid DecisionItemCreateEventItemContentItem"
                                )
                        }
                    }
                }

                class InputText
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val text: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("text")
                        @ExcludeMissing
                        text: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(text, type, mutableMapOf())

                    /**
                     * The text input to the model.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun text(): String = text.getRequired("text")

                    /**
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("input_text")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Returns the raw JSON value of [text].
                     *
                     * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "text" to this.text,
                            "type" to this.type,
                        )

                    /**
                     * Returns the legacy additional-properties view.
                     *
                     * @deprecated Use [_allProperties] to access both declared and additional JSON
                     *   properties. This accessor retains its legacy additional-properties
                     *   behavior.
                     */
                    @Deprecated(
                        "Use _allProperties() to access both declared and additional JSON properties."
                    )
                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [InputText].
                         *
                         * The following fields are required:
                         * ```java
                         * .text()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InputText]. */
                    class Builder internal constructor() {

                        private var text: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("input_text")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(inputText: InputText) = apply {
                            text = inputText.text
                            type = inputText.type
                            additionalProperties = inputText.additionalProperties.toMutableMap()
                        }

                        /** The text input to the model. */
                        fun text(text: String) = text(JsonField.of(text))

                        /**
                         * Sets [Builder.text] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.text] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun text(text: JsonField<String>) = apply { this.text = text }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("input_text")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [InputText].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .text()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InputText =
                            InputText(
                                checkRequired("text", text),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): InputText = apply {
                        if (validated) {
                            return@apply
                        }

                        text()
                        _type().let {
                            if (it != JsonValue.from("input_text")) {
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
                        (if (text.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("input_text")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InputText &&
                            text == other.text &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(text, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
                }

                class InputImage
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val imageUrl: JsonField<String>,
                    private val type: JsonValue,
                    private val detail: JsonField<Detail>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("image_url")
                        @ExcludeMissing
                        imageUrl: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("detail")
                        @ExcludeMissing
                        detail: JsonField<Detail> = JsonMissing.of(),
                    ) : this(imageUrl, type, detail, mutableMapOf())

                    /**
                     * A base64-encoded image data URL or a publicly accessible HTTP(S) image URL.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun imageUrl(): String = imageUrl.getRequired("image_url")

                    /**
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("input_image")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * The detail level of the image to be sent to the model. One of `high`, `low`,
                     * `auto`, or `original`. Defaults to `auto`.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun detail(): Optional<Detail> = detail.getOptional("detail")

                    /**
                     * Returns the raw JSON value of [imageUrl].
                     *
                     * Unlike [imageUrl], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("image_url")
                    @ExcludeMissing
                    fun _imageUrl(): JsonField<String> = imageUrl

                    /**
                     * Returns the raw JSON value of [detail].
                     *
                     * Unlike [detail], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("detail")
                    @ExcludeMissing
                    fun _detail(): JsonField<Detail> = detail

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "image_url" to this.imageUrl,
                            "type" to this.type,
                            "detail" to this.detail,
                        )

                    /**
                     * Returns the legacy additional-properties view.
                     *
                     * @deprecated Use [_allProperties] to access both declared and additional JSON
                     *   properties. This accessor retains its legacy additional-properties
                     *   behavior.
                     */
                    @Deprecated(
                        "Use _allProperties() to access both declared and additional JSON properties."
                    )
                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [InputImage].
                         *
                         * The following fields are required:
                         * ```java
                         * .imageUrl()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [InputImage]. */
                    class Builder internal constructor() {

                        private var imageUrl: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("input_image")
                        private var detail: JsonField<Detail> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(inputImage: InputImage) = apply {
                            imageUrl = inputImage.imageUrl
                            type = inputImage.type
                            detail = inputImage.detail
                            additionalProperties = inputImage.additionalProperties.toMutableMap()
                        }

                        /**
                         * A base64-encoded image data URL or a publicly accessible HTTP(S) image
                         * URL.
                         */
                        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                        /**
                         * Sets [Builder.imageUrl] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.imageUrl] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun imageUrl(imageUrl: JsonField<String>) = apply {
                            this.imageUrl = imageUrl
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("input_image")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /**
                         * The detail level of the image to be sent to the model. One of `high`,
                         * `low`, `auto`, or `original`. Defaults to `auto`.
                         */
                        fun detail(detail: Detail?) = detail(JsonField.ofNullable(detail))

                        /** Alias for calling [Builder.detail] with `detail.orElse(null)`. */
                        fun detail(detail: Optional<Detail>) = detail(detail.getOrNull())

                        /**
                         * Sets [Builder.detail] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.detail] with a well-typed [Detail] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [InputImage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .imageUrl()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): InputImage =
                            InputImage(
                                checkRequired("imageUrl", imageUrl),
                                type,
                                detail,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): InputImage = apply {
                        if (validated) {
                            return@apply
                        }

                        imageUrl()
                        _type().let {
                            if (it != JsonValue.from("input_image")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
                        detail().ifPresent { it.validate() }
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
                        (if (imageUrl.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("input_image")) 1 else 0 } +
                            (detail.asKnown().getOrNull()?.validity() ?: 0)

                    /**
                     * The detail level of the image to be sent to the model. One of `high`, `low`,
                     * `auto`, or `original`. Defaults to `auto`.
                     */
                    class Detail
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val LOW = of("low")

                            @JvmField val HIGH = of("high")

                            @JvmField val AUTO = of("auto")

                            @JvmField val ORIGINAL = of("original")

                            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
                        }

                        /** An enum containing [Detail]'s known values. */
                        enum class Known {
                            LOW,
                            HIGH,
                            AUTO,
                            ORIGINAL,
                        }

                        /**
                         * An enum containing [Detail]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Detail] can contain an unknown value in a couple of
                         * cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            LOW,
                            HIGH,
                            AUTO,
                            ORIGINAL,
                            /**
                             * An enum member indicating that [Detail] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                LOW -> Value.LOW
                                HIGH -> Value.HIGH
                                AUTO -> Value.AUTO
                                ORIGINAL -> Value.ORIGINAL
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                LOW -> Known.LOW
                                HIGH -> Known.HIGH
                                AUTO -> Known.AUTO
                                ORIGINAL -> Known.ORIGINAL
                                else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Detail = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Detail && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InputImage &&
                            imageUrl == other.imageUrl &&
                            type == other.type &&
                            detail == other.detail &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(imageUrl, type, detail, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "InputImage{imageUrl=$imageUrl, type=$type, detail=$detail, additionalProperties=$additionalProperties}"
                }
            }
        }

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val MESSAGE = of("message")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                MESSAGE
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MESSAGE,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    MESSAGE -> Value.MESSAGE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    MESSAGE -> Known.MESSAGE
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

            return other is Item &&
                content == other.content &&
                role == other.role &&
                id == other.id &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, role, id, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Item{content=$content, role=$role, id=$id, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionItemCreateEvent &&
            item == other.item &&
            type == other.type &&
            eventId == other.eventId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(item, type, eventId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionItemCreateEvent{item=$item, type=$type, eventId=$eventId, additionalProperties=$additionalProperties}"
}
