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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A developer, user, or assistant message supplied as text history before the Live session starts.
 */
@JsonDeserialize(using = InitialItem.Deserializer::class)
@JsonSerialize(using = InitialItem.Serializer::class)
class InitialItem
private constructor(
    private val developer: Developer? = null,
    private val user: User? = null,
    private val assistant: Assistant? = null,
    private val _json: JsonValue? = null,
) {

    /** A developer message included in the initial text history of a Live session. */
    fun developer(): Optional<Developer> = Optional.ofNullable(developer)

    /** A user message included in the initial text history of a Live session. */
    fun user(): Optional<User> = Optional.ofNullable(user)

    /** An assistant message included in the initial text history of a Live session. */
    fun assistant(): Optional<Assistant> = Optional.ofNullable(assistant)

    fun isDeveloper(): Boolean = developer != null

    fun isUser(): Boolean = user != null

    fun isAssistant(): Boolean = assistant != null

    /** A developer message included in the initial text history of a Live session. */
    fun asDeveloper(): Developer = developer.getOrThrow("developer")

    /** A user message included in the initial text history of a Live session. */
    fun asUser(): User = user.getOrThrow("user")

    /** An assistant message included in the initial text history of a Live session. */
    fun asAssistant(): Assistant = assistant.getOrThrow("assistant")

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
     * Optional<String> result = initialItem.accept(new InitialItem.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitDeveloper(Developer developer) {
     *         return Optional.of(developer.toString());
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
            developer != null -> visitor.visitDeveloper(developer)
            user != null -> visitor.visitUser(user)
            assistant != null -> visitor.visitAssistant(assistant)
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
    fun validate(): InitialItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitDeveloper(developer: Developer) {
                    developer.validate()
                }

                override fun visitUser(user: User) {
                    user.validate()
                }

                override fun visitAssistant(assistant: Assistant) {
                    assistant.validate()
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
                override fun visitDeveloper(developer: Developer) = developer.validity()

                override fun visitUser(user: User) = user.validity()

                override fun visitAssistant(assistant: Assistant) = assistant.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InitialItem &&
            developer == other.developer &&
            user == other.user &&
            assistant == other.assistant
    }

    override fun hashCode(): Int = Objects.hash(developer, user, assistant)

    override fun toString(): String =
        when {
            developer != null -> "InitialItem{developer=$developer}"
            user != null -> "InitialItem{user=$user}"
            assistant != null -> "InitialItem{assistant=$assistant}"
            _json != null -> "InitialItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid InitialItem")
        }

    companion object {

        /** A developer message included in the initial text history of a Live session. */
        @JvmStatic fun ofDeveloper(developer: Developer) = InitialItem(developer = developer)

        /** A user message included in the initial text history of a Live session. */
        @JvmStatic fun ofUser(user: User) = InitialItem(user = user)

        /** An assistant message included in the initial text history of a Live session. */
        @JvmStatic fun ofAssistant(assistant: Assistant) = InitialItem(assistant = assistant)
    }

    /**
     * An interface that defines how to map each variant of [InitialItem] to a value of type [T].
     */
    interface Visitor<out T> {

        /** A developer message included in the initial text history of a Live session. */
        fun visitDeveloper(developer: Developer): T

        /** A user message included in the initial text history of a Live session. */
        fun visitUser(user: User): T

        /** An assistant message included in the initial text history of a Live session. */
        fun visitAssistant(assistant: Assistant): T

        /**
         * Maps an unknown variant of [InitialItem] to a value of type [T].
         *
         * An instance of [InitialItem] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown InitialItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<InitialItem>(InitialItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): InitialItem {
            val json = JsonValue.fromJsonNode(node)
            val role = json.asObject().getOrNull()?.get("role")?.asString()?.getOrNull()

            when (role) {
                "developer" -> {
                    return tryDeserialize(node, jacksonTypeRef<Developer>())?.let {
                        InitialItem(developer = it, _json = json)
                    } ?: InitialItem(_json = json)
                }
                "user" -> {
                    return tryDeserialize(node, jacksonTypeRef<User>())?.let {
                        InitialItem(user = it, _json = json)
                    } ?: InitialItem(_json = json)
                }
                "assistant" -> {
                    return tryDeserialize(node, jacksonTypeRef<Assistant>())?.let {
                        InitialItem(assistant = it, _json = json)
                    } ?: InitialItem(_json = json)
                }
            }

            return InitialItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<InitialItem>(InitialItem::class) {

        override fun serialize(
            value: InitialItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.developer != null -> generator.writeObject(value.developer)
                value.user != null -> generator.writeObject(value.user)
                value.assistant != null -> generator.writeObject(value.assistant)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid InitialItem")
            }
        }
    }

    /** A developer message included in the initial text history of a Live session. */
    class Developer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<List<Content>>,
        private val role: JsonValue,
        private val id: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            content: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(content, role, id, status, type, mutableMapOf())

        /**
         * The message content. Supply exactly one text part for the initial Live conversation
         * history.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): List<Content> = content.getRequired("content")

        /**
         * The author of this history message. Always `developer`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("developer")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

        /**
         * An optional identifier for the supplied history message. Live uses the message’s role and
         * text to initialize the conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The supplied message’s status. Live uses its text as history and does not resume an
         * incomplete message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * The history item type. Always `message`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Developer].
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Developer]. */
        class Builder internal constructor() {

            private var content: JsonField<MutableList<Content>>? = null
            private var role: JsonValue = JsonValue.from("developer")
            private var id: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(developer: Developer) = apply {
                content = developer.content.map { it.toMutableList() }
                role = developer.role
                id = developer.id
                status = developer.status
                type = developer.type
                additionalProperties = developer.additionalProperties.toMutableMap()
            }

            /**
             * The message content. Supply exactly one text part for the initial Live conversation
             * history.
             */
            fun content(content: List<Content>) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed `List<Content>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<List<Content>>) = apply {
                this.content = content.map { it.toMutableList() }
            }

            /**
             * Adds a single [Content] to [Builder.content].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContent(content: Content) = apply {
                this.content =
                    (this.content ?: JsonField.of(mutableListOf())).also {
                        checkKnown("content", it).add(content)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("developer")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun role(role: JsonValue) = apply { this.role = role }

            /**
             * An optional identifier for the supplied history message. Live uses the message’s role
             * and text to initialize the conversation.
             */
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

            /**
             * The supplied message’s status. Live uses its text as history and does not resume an
             * incomplete message.
             */
            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /** The history item type. Always `message`. */
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
             * Returns an immutable instance of [Developer].
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
            fun build(): Developer =
                Developer(
                    checkRequired("content", content).map { it.toImmutable() },
                    role,
                    id,
                    status,
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
        fun validate(): Developer = apply {
            if (validated) {
                return@apply
            }

            content().forEach { it.validate() }
            _role().let {
                if (it != JsonValue.from("developer")) {
                    throw OpenAIInvalidDataException("'role' is invalid, received $it")
                }
            }
            id()
            status().ifPresent { it.validate() }
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
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                role.let { if (it == JsonValue.from("developer")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** Text supplied in a developer or user message when starting a Live session. */
        class Content
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val text: JsonField<String>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(text, type, mutableMapOf())

            /**
             * The message text to include in the Live session’s initial conversation history.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun text(): String = text.getRequired("text")

            /**
             * The text content type. Always `input_text`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Content].
                 *
                 * The following fields are required:
                 * ```java
                 * .text()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Content]. */
            class Builder internal constructor() {

                private var text: JsonField<String>? = null
                private var type: JsonField<Type> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(content: Content) = apply {
                    text = content.text
                    type = content.type
                    additionalProperties = content.additionalProperties.toMutableMap()
                }

                /**
                 * The message text to include in the Live session’s initial conversation history.
                 */
                fun text(text: String) = text(JsonField.of(text))

                /**
                 * Sets [Builder.text] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.text] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /** The text content type. Always `input_text`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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
                 * Returns an immutable instance of [Content].
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
                fun build(): Content =
                    Content(checkRequired("text", text), type, additionalProperties.toMutableMap())
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

                text()
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
                (if (text.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            /** The text content type. Always `input_text`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val INPUT_TEXT = of("input_text")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    INPUT_TEXT
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    INPUT_TEXT,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
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
                        INPUT_TEXT -> Value.INPUT_TEXT
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
                        INPUT_TEXT -> Known.INPUT_TEXT
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

                return other is Content &&
                    text == other.text &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
        }

        /**
         * The supplied message’s status. Live uses its text as history and does not resume an
         * incomplete message.
         */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmField val COMPLETED = of("completed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                INCOMPLETE,
                COMPLETED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                INCOMPLETE,
                COMPLETED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
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
                    INCOMPLETE -> Value.INCOMPLETE
                    COMPLETED -> Value.COMPLETED
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
                    INCOMPLETE -> Known.INCOMPLETE
                    COMPLETED -> Known.COMPLETED
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

        /** The history item type. Always `message`. */
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

            return other is Developer &&
                content == other.content &&
                role == other.role &&
                id == other.id &&
                status == other.status &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, role, id, status, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Developer{content=$content, role=$role, id=$id, status=$status, type=$type, additionalProperties=$additionalProperties}"
    }

    /** A user message included in the initial text history of a Live session. */
    class User
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<List<Content>>,
        private val role: JsonValue,
        private val id: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            content: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(content, role, id, status, type, mutableMapOf())

        /**
         * The message content. Supply exactly one text part for the initial Live conversation
         * history.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): List<Content> = content.getRequired("content")

        /**
         * The author of this history message. Always `user`.
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
         * An optional identifier for the supplied history message. Live uses the message’s role and
         * text to initialize the conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The supplied message’s status. Live uses its text as history and does not resume an
         * incomplete message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * The history item type. Always `message`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [User].
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [User]. */
        class Builder internal constructor() {

            private var content: JsonField<MutableList<Content>>? = null
            private var role: JsonValue = JsonValue.from("user")
            private var id: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(user: User) = apply {
                content = user.content.map { it.toMutableList() }
                role = user.role
                id = user.id
                status = user.status
                type = user.type
                additionalProperties = user.additionalProperties.toMutableMap()
            }

            /**
             * The message content. Supply exactly one text part for the initial Live conversation
             * history.
             */
            fun content(content: List<Content>) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed `List<Content>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<List<Content>>) = apply {
                this.content = content.map { it.toMutableList() }
            }

            /**
             * Adds a single [Content] to [Builder.content].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContent(content: Content) = apply {
                this.content =
                    (this.content ?: JsonField.of(mutableListOf())).also {
                        checkKnown("content", it).add(content)
                    }
            }

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

            /**
             * An optional identifier for the supplied history message. Live uses the message’s role
             * and text to initialize the conversation.
             */
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

            /**
             * The supplied message’s status. Live uses its text as history and does not resume an
             * incomplete message.
             */
            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /** The history item type. Always `message`. */
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
             * Returns an immutable instance of [User].
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
            fun build(): User =
                User(
                    checkRequired("content", content).map { it.toImmutable() },
                    role,
                    id,
                    status,
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
        fun validate(): User = apply {
            if (validated) {
                return@apply
            }

            content().forEach { it.validate() }
            _role().let {
                if (it != JsonValue.from("user")) {
                    throw OpenAIInvalidDataException("'role' is invalid, received $it")
                }
            }
            id()
            status().ifPresent { it.validate() }
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
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                role.let { if (it == JsonValue.from("user")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** Text supplied in a developer or user message when starting a Live session. */
        class Content
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val text: JsonField<String>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(text, type, mutableMapOf())

            /**
             * The message text to include in the Live session’s initial conversation history.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun text(): String = text.getRequired("text")

            /**
             * The text content type. Always `input_text`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Content].
                 *
                 * The following fields are required:
                 * ```java
                 * .text()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Content]. */
            class Builder internal constructor() {

                private var text: JsonField<String>? = null
                private var type: JsonField<Type> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(content: Content) = apply {
                    text = content.text
                    type = content.type
                    additionalProperties = content.additionalProperties.toMutableMap()
                }

                /**
                 * The message text to include in the Live session’s initial conversation history.
                 */
                fun text(text: String) = text(JsonField.of(text))

                /**
                 * Sets [Builder.text] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.text] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /** The text content type. Always `input_text`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
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
                 * Returns an immutable instance of [Content].
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
                fun build(): Content =
                    Content(checkRequired("text", text), type, additionalProperties.toMutableMap())
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

                text()
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
                (if (text.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            /** The text content type. Always `input_text`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val INPUT_TEXT = of("input_text")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    INPUT_TEXT
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    INPUT_TEXT,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
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
                        INPUT_TEXT -> Value.INPUT_TEXT
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
                        INPUT_TEXT -> Known.INPUT_TEXT
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

                return other is Content &&
                    text == other.text &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
        }

        /**
         * The supplied message’s status. Live uses its text as history and does not resume an
         * incomplete message.
         */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmField val COMPLETED = of("completed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                INCOMPLETE,
                COMPLETED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                INCOMPLETE,
                COMPLETED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
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
                    INCOMPLETE -> Value.INCOMPLETE
                    COMPLETED -> Value.COMPLETED
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
                    INCOMPLETE -> Known.INCOMPLETE
                    COMPLETED -> Known.COMPLETED
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

        /** The history item type. Always `message`. */
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

            return other is User &&
                content == other.content &&
                role == other.role &&
                id == other.id &&
                status == other.status &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, role, id, status, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "User{content=$content, role=$role, id=$id, status=$status, type=$type, additionalProperties=$additionalProperties}"
    }

    /** An assistant message included in the initial text history of a Live session. */
    class Assistant
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val content: JsonField<List<Content>>,
        private val role: JsonValue,
        private val id: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            content: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(content, role, id, status, type, mutableMapOf())

        /**
         * The message content. Supply exactly one text part for the initial Live conversation
         * history.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): List<Content> = content.getRequired("content")

        /**
         * The author of this history message. Always `assistant`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("assistant")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

        /**
         * An optional identifier for the supplied history message. Live uses the message’s role and
         * text to initialize the conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The supplied message’s status. Live uses its text as history and does not resume an
         * incomplete message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * The history item type. Always `message`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Assistant].
             *
             * The following fields are required:
             * ```java
             * .content()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Assistant]. */
        class Builder internal constructor() {

            private var content: JsonField<MutableList<Content>>? = null
            private var role: JsonValue = JsonValue.from("assistant")
            private var id: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(assistant: Assistant) = apply {
                content = assistant.content.map { it.toMutableList() }
                role = assistant.role
                id = assistant.id
                status = assistant.status
                type = assistant.type
                additionalProperties = assistant.additionalProperties.toMutableMap()
            }

            /**
             * The message content. Supply exactly one text part for the initial Live conversation
             * history.
             */
            fun content(content: List<Content>) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed `List<Content>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<List<Content>>) = apply {
                this.content = content.map { it.toMutableList() }
            }

            /**
             * Adds a single [Content] to [Builder.content].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContent(content: Content) = apply {
                this.content =
                    (this.content ?: JsonField.of(mutableListOf())).also {
                        checkKnown("content", it).add(content)
                    }
            }

            /** Alias for calling [addContent] with `Content.ofText(text)`. */
            fun addContent(text: Content.Text) = addContent(Content.ofText(text))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * Content.Text.builder()
             *     .type(InitialItem.Assistant.Content.Text.Type.TEXT)
             *     .text(text)
             *     .build()
             * ```
             */
            fun addTextContent(text: String) =
                addContent(
                    Content.Text.builder()
                        .type(InitialItem.Assistant.Content.Text.Type.TEXT)
                        .text(text)
                        .build()
                )

            /** Alias for calling [addContent] with `Content.ofOutputText(outputText)`. */
            fun addContent(outputText: Content.OutputText) =
                addContent(Content.ofOutputText(outputText))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * Content.OutputText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun addOutputTextContent(text: String) =
                addContent(Content.OutputText.builder().text(text).build())

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("assistant")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun role(role: JsonValue) = apply { this.role = role }

            /**
             * An optional identifier for the supplied history message. Live uses the message’s role
             * and text to initialize the conversation.
             */
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

            /**
             * The supplied message’s status. Live uses its text as history and does not resume an
             * incomplete message.
             */
            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /** The history item type. Always `message`. */
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
             * Returns an immutable instance of [Assistant].
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
            fun build(): Assistant =
                Assistant(
                    checkRequired("content", content).map { it.toImmutable() },
                    role,
                    id,
                    status,
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
        fun validate(): Assistant = apply {
            if (validated) {
                return@apply
            }

            content().forEach { it.validate() }
            _role().let {
                if (it != JsonValue.from("assistant")) {
                    throw OpenAIInvalidDataException("'role' is invalid, received $it")
                }
            }
            id()
            status().ifPresent { it.validate() }
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
            (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                role.let { if (it == JsonValue.from("assistant")) 1 else 0 } +
                (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** Assistant text supplied as conversation history when starting a Live session. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val text: Text? = null,
            private val outputText: OutputText? = null,
            private val _json: JsonValue? = null,
        ) {

            /** Assistant text supplied as conversation history when starting a Live session. */
            fun text(): Optional<Text> = Optional.ofNullable(text)

            /**
             * Assistant output text supplied as conversation history when starting a Live session.
             */
            fun outputText(): Optional<OutputText> = Optional.ofNullable(outputText)

            fun isText(): Boolean = text != null

            fun isOutputText(): Boolean = outputText != null

            /** Assistant text supplied as conversation history when starting a Live session. */
            fun asText(): Text = text.getOrThrow("text")

            /**
             * Assistant output text supplied as conversation history when starting a Live session.
             */
            fun asOutputText(): OutputText = outputText.getOrThrow("outputText")

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
             *     public Optional<String> visitText(Text text) {
             *         return Optional.of(text.toString());
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
                    text != null -> visitor.visitText(text)
                    outputText != null -> visitor.visitOutputText(outputText)
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
                        override fun visitText(text: Text) {
                            text.validate()
                        }

                        override fun visitOutputText(outputText: OutputText) {
                            outputText.validate()
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
                        override fun visitText(text: Text) = text.validity()

                        override fun visitOutputText(outputText: OutputText) = outputText.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content && text == other.text && outputText == other.outputText
            }

            override fun hashCode(): Int = Objects.hash(text, outputText)

            override fun toString(): String =
                when {
                    text != null -> "Content{text=$text}"
                    outputText != null -> "Content{outputText=$outputText}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** Assistant text supplied as conversation history when starting a Live session. */
                @JvmStatic fun ofText(text: Text) = Content(text = text)

                /**
                 * Assistant output text supplied as conversation history when starting a Live
                 * session.
                 */
                @JvmStatic
                fun ofOutputText(outputText: OutputText) = Content(outputText = outputText)
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** Assistant text supplied as conversation history when starting a Live session. */
                fun visitText(text: Text): T

                /**
                 * Assistant output text supplied as conversation history when starting a Live
                 * session.
                 */
                fun visitOutputText(outputText: OutputText): T

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
                    throw OpenAIInvalidDataException("Unknown Content: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "text" -> {
                            return tryDeserialize(node, jacksonTypeRef<Text>())?.let {
                                Content(text = it, _json = json)
                            } ?: Content(_json = json)
                        }
                        "output_text" -> {
                            return tryDeserialize(node, jacksonTypeRef<OutputText>())?.let {
                                Content(outputText = it, _json = json)
                            } ?: Content(_json = json)
                        }
                    }

                    return Content(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.text != null -> generator.writeObject(value.text)
                        value.outputText != null -> generator.writeObject(value.outputText)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }

            /** Assistant text supplied as conversation history when starting a Live session. */
            class Text
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val text: JsonField<String>,
                private val type: JsonField<Type>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                ) : this(text, type, mutableMapOf())

                /**
                 * The message text to include in the Live session’s initial conversation history.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * The text content type. Always `text`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<Type> = type.getOptional("type")

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
                     * Returns a mutable builder for constructing an instance of [Text].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Text]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(text: Text) = apply {
                        this.text = text.text
                        type = text.type
                        additionalProperties = text.additionalProperties.toMutableMap()
                    }

                    /**
                     * The message text to include in the Live session’s initial conversation
                     * history.
                     */
                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /** The text content type. Always `text`. */
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
                     * Returns an immutable instance of [Text].
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
                    fun build(): Text =
                        Text(checkRequired("text", text), type, additionalProperties.toMutableMap())
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
                fun validate(): Text = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
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
                    (if (text.asKnown().isPresent) 1 else 0) +
                        (type.asKnown().getOrNull()?.validity() ?: 0)

                /** The text content type. Always `text`. */
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

                        @JvmField val TEXT = of("text")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        TEXT
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
                        TEXT,
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
                            TEXT -> Value.TEXT
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
                            TEXT -> Known.TEXT
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

                    return other is Text &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Text{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            /**
             * Assistant output text supplied as conversation history when starting a Live session.
             */
            class OutputText
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
                 * The message text to include in the Live session’s initial conversation history.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * The text content type. Always `output_text`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("output_text")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
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

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [OutputText].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [OutputText]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("output_text")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(outputText: OutputText) = apply {
                        text = outputText.text
                        type = outputText.type
                        additionalProperties = outputText.additionalProperties.toMutableMap()
                    }

                    /**
                     * The message text to include in the Live session’s initial conversation
                     * history.
                     */
                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("output_text")
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
                     * Returns an immutable instance of [OutputText].
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
                    fun build(): OutputText =
                        OutputText(
                            checkRequired("text", text),
                            type,
                            additionalProperties.toMutableMap(),
                        )
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
                fun validate(): OutputText = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    _type().let {
                        if (it != JsonValue.from("output_text")) {
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
                        type.let { if (it == JsonValue.from("output_text")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OutputText &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "OutputText{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        /**
         * The supplied message’s status. Live uses its text as history and does not resume an
         * incomplete message.
         */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmField val COMPLETED = of("completed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                INCOMPLETE,
                COMPLETED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                INCOMPLETE,
                COMPLETED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
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
                    INCOMPLETE -> Value.INCOMPLETE
                    COMPLETED -> Value.COMPLETED
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
                    INCOMPLETE -> Known.INCOMPLETE
                    COMPLETED -> Known.COMPLETED
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

        /** The history item type. Always `message`. */
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

            return other is Assistant &&
                content == other.content &&
                role == other.role &&
                id == other.id &&
                status == other.status &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(content, role, id, status, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Assistant{content=$content, role=$role, id=$id, status=$status, type=$type, additionalProperties=$additionalProperties}"
    }
}
