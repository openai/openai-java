// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A tool call to a computer use tool. See the
 * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
 * information.
 */
@NoAutoDetect
class ResponseComputerToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("action")
    @ExcludeMissing
    private val action: JsonField<Action> = JsonMissing.of(),
    @JsonProperty("call_id")
    @ExcludeMissing
    private val callId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("pending_safety_checks")
    @ExcludeMissing
    private val pendingSafetyChecks: JsonField<List<PendingSafetyCheck>> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The unique ID of the computer call. */
    fun id(): String = id.getRequired("id")

    /** A click action. */
    fun action(): Action = action.getRequired("action")

    /** An identifier used when responding to the tool call with output. */
    fun callId(): String = callId.getRequired("call_id")

    /** The pending safety checks for the computer call. */
    fun pendingSafetyChecks(): List<PendingSafetyCheck> =
        pendingSafetyChecks.getRequired("pending_safety_checks")

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
     */
    fun status(): Status = status.getRequired("status")

    /** The type of the computer call. Always `computer_call`. */
    fun type(): Type = type.getRequired("type")

    /** The unique ID of the computer call. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** A click action. */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

    /** An identifier used when responding to the tool call with output. */
    @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

    /** The pending safety checks for the computer call. */
    @JsonProperty("pending_safety_checks")
    @ExcludeMissing
    fun _pendingSafetyChecks(): JsonField<List<PendingSafetyCheck>> = pendingSafetyChecks

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /** The type of the computer call. Always `computer_call`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseComputerToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        action().validate()
        callId()
        pendingSafetyChecks().forEach { it.validate() }
        status()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseComputerToolCall].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .action()
         * .callId()
         * .pendingSafetyChecks()
         * .status()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseComputerToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var action: JsonField<Action>? = null
        private var callId: JsonField<String>? = null
        private var pendingSafetyChecks: JsonField<MutableList<PendingSafetyCheck>>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseComputerToolCall: ResponseComputerToolCall) = apply {
            id = responseComputerToolCall.id
            action = responseComputerToolCall.action
            callId = responseComputerToolCall.callId
            pendingSafetyChecks =
                responseComputerToolCall.pendingSafetyChecks.map { it.toMutableList() }
            status = responseComputerToolCall.status
            type = responseComputerToolCall.type
            additionalProperties = responseComputerToolCall.additionalProperties.toMutableMap()
        }

        /** The unique ID of the computer call. */
        fun id(id: String) = id(JsonField.of(id))

        /** The unique ID of the computer call. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A click action. */
        fun action(action: Action) = action(JsonField.of(action))

        /** A click action. */
        fun action(action: JsonField<Action>) = apply { this.action = action }

        /** A click action. */
        fun action(click: Action.Click) = action(Action.ofClick(click))

        /** A double click action. */
        fun action(doubleClick: Action.DoubleClick) = action(Action.ofDoubleClick(doubleClick))

        /** A drag action. */
        fun action(drag: Action.Drag) = action(Action.ofDrag(drag))

        /** A drag action. */
        fun dragAction(path: List<Action.Drag.Path>) =
            action(Action.Drag.builder().path(path).build())

        /** A collection of keypresses the model would like to perform. */
        fun action(keypress: Action.Keypress) = action(Action.ofKeypress(keypress))

        /** A collection of keypresses the model would like to perform. */
        fun keypressAction(keys: List<String>) =
            action(Action.Keypress.builder().keys(keys).build())

        /** A mouse move action. */
        fun action(move: Action.Move) = action(Action.ofMove(move))

        /** A screenshot action. */
        fun actionScreenshot() = action(Action.ofScreenshot())

        /** A scroll action. */
        fun action(scroll: Action.Scroll) = action(Action.ofScroll(scroll))

        /** An action to type in text. */
        fun action(type: Action.Type) = action(Action.ofType(type))

        /** An action to type in text. */
        fun typeAction(text: String) = action(Action.Type.builder().text(text).build())

        /** A wait action. */
        fun actionWait() = action(Action.ofWait())

        /** An identifier used when responding to the tool call with output. */
        fun callId(callId: String) = callId(JsonField.of(callId))

        /** An identifier used when responding to the tool call with output. */
        fun callId(callId: JsonField<String>) = apply { this.callId = callId }

        /** The pending safety checks for the computer call. */
        fun pendingSafetyChecks(pendingSafetyChecks: List<PendingSafetyCheck>) =
            pendingSafetyChecks(JsonField.of(pendingSafetyChecks))

        /** The pending safety checks for the computer call. */
        fun pendingSafetyChecks(pendingSafetyChecks: JsonField<List<PendingSafetyCheck>>) = apply {
            this.pendingSafetyChecks = pendingSafetyChecks.map { it.toMutableList() }
        }

        /** The pending safety checks for the computer call. */
        fun addPendingSafetyCheck(pendingSafetyCheck: PendingSafetyCheck) = apply {
            pendingSafetyChecks =
                (pendingSafetyChecks ?: JsonField.of(mutableListOf())).also {
                    checkKnown("pendingSafetyChecks", it).add(pendingSafetyCheck)
                }
        }

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The type of the computer call. Always `computer_call`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the computer call. Always `computer_call`. */
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

        fun build(): ResponseComputerToolCall =
            ResponseComputerToolCall(
                checkRequired("id", id),
                checkRequired("action", action),
                checkRequired("callId", callId),
                checkRequired("pendingSafetyChecks", pendingSafetyChecks).map { it.toImmutable() },
                checkRequired("status", status),
                checkRequired("type", type),
                additionalProperties.toImmutable(),
            )
    }

    /** A click action. */
    @JsonDeserialize(using = Action.Deserializer::class)
    @JsonSerialize(using = Action.Serializer::class)
    class Action
    private constructor(
        private val click: Click? = null,
        private val doubleClick: DoubleClick? = null,
        private val drag: Drag? = null,
        private val keypress: Keypress? = null,
        private val move: Move? = null,
        private val screenshot: JsonValue? = null,
        private val scroll: Scroll? = null,
        private val type: Type? = null,
        private val wait: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A click action. */
        fun click(): Optional<Click> = Optional.ofNullable(click)

        /** A double click action. */
        fun doubleClick(): Optional<DoubleClick> = Optional.ofNullable(doubleClick)

        /** A drag action. */
        fun drag(): Optional<Drag> = Optional.ofNullable(drag)

        /** A collection of keypresses the model would like to perform. */
        fun keypress(): Optional<Keypress> = Optional.ofNullable(keypress)

        /** A mouse move action. */
        fun move(): Optional<Move> = Optional.ofNullable(move)

        /** A screenshot action. */
        fun screenshot(): Optional<JsonValue> = Optional.ofNullable(screenshot)

        /** A scroll action. */
        fun scroll(): Optional<Scroll> = Optional.ofNullable(scroll)

        /** An action to type in text. */
        fun type(): Optional<Type> = Optional.ofNullable(type)

        /** A wait action. */
        fun wait(): Optional<JsonValue> = Optional.ofNullable(wait)

        fun isClick(): Boolean = click != null

        fun isDoubleClick(): Boolean = doubleClick != null

        fun isDrag(): Boolean = drag != null

        fun isKeypress(): Boolean = keypress != null

        fun isMove(): Boolean = move != null

        fun isScreenshot(): Boolean = screenshot != null

        fun isScroll(): Boolean = scroll != null

        fun isType(): Boolean = type != null

        fun isWait(): Boolean = wait != null

        /** A click action. */
        fun asClick(): Click = click.getOrThrow("click")

        /** A double click action. */
        fun asDoubleClick(): DoubleClick = doubleClick.getOrThrow("doubleClick")

        /** A drag action. */
        fun asDrag(): Drag = drag.getOrThrow("drag")

        /** A collection of keypresses the model would like to perform. */
        fun asKeypress(): Keypress = keypress.getOrThrow("keypress")

        /** A mouse move action. */
        fun asMove(): Move = move.getOrThrow("move")

        /** A screenshot action. */
        fun asScreenshot(): JsonValue = screenshot.getOrThrow("screenshot")

        /** A scroll action. */
        fun asScroll(): Scroll = scroll.getOrThrow("scroll")

        /** An action to type in text. */
        fun asType(): Type = type.getOrThrow("type")

        /** A wait action. */
        fun asWait(): JsonValue = wait.getOrThrow("wait")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                click != null -> visitor.visitClick(click)
                doubleClick != null -> visitor.visitDoubleClick(doubleClick)
                drag != null -> visitor.visitDrag(drag)
                keypress != null -> visitor.visitKeypress(keypress)
                move != null -> visitor.visitMove(move)
                screenshot != null -> visitor.visitScreenshot(screenshot)
                scroll != null -> visitor.visitScroll(scroll)
                type != null -> visitor.visitType(type)
                wait != null -> visitor.visitWait(wait)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Action = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitClick(click: Click) {
                        click.validate()
                    }

                    override fun visitDoubleClick(doubleClick: DoubleClick) {
                        doubleClick.validate()
                    }

                    override fun visitDrag(drag: Drag) {
                        drag.validate()
                    }

                    override fun visitKeypress(keypress: Keypress) {
                        keypress.validate()
                    }

                    override fun visitMove(move: Move) {
                        move.validate()
                    }

                    override fun visitScreenshot(screenshot: JsonValue) {
                        screenshot.let {
                            if (it != JsonValue.from(mapOf("type" to "screenshot"))) {
                                throw OpenAIInvalidDataException(
                                    "'screenshot' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitScroll(scroll: Scroll) {
                        scroll.validate()
                    }

                    override fun visitType(type: Type) {
                        type.validate()
                    }

                    override fun visitWait(wait: JsonValue) {
                        wait.let {
                            if (it != JsonValue.from(mapOf("type" to "wait"))) {
                                throw OpenAIInvalidDataException("'wait' is invalid, received $it")
                            }
                        }
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Action && click == other.click && doubleClick == other.doubleClick && drag == other.drag && keypress == other.keypress && move == other.move && screenshot == other.screenshot && scroll == other.scroll && type == other.type && wait == other.wait /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(click, doubleClick, drag, keypress, move, screenshot, scroll, type, wait) /* spotless:on */

        override fun toString(): String =
            when {
                click != null -> "Action{click=$click}"
                doubleClick != null -> "Action{doubleClick=$doubleClick}"
                drag != null -> "Action{drag=$drag}"
                keypress != null -> "Action{keypress=$keypress}"
                move != null -> "Action{move=$move}"
                screenshot != null -> "Action{screenshot=$screenshot}"
                scroll != null -> "Action{scroll=$scroll}"
                type != null -> "Action{type=$type}"
                wait != null -> "Action{wait=$wait}"
                _json != null -> "Action{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Action")
            }

        companion object {

            /** A click action. */
            @JvmStatic fun ofClick(click: Click) = Action(click = click)

            /** A double click action. */
            @JvmStatic
            fun ofDoubleClick(doubleClick: DoubleClick) = Action(doubleClick = doubleClick)

            /** A drag action. */
            @JvmStatic fun ofDrag(drag: Drag) = Action(drag = drag)

            /** A collection of keypresses the model would like to perform. */
            @JvmStatic fun ofKeypress(keypress: Keypress) = Action(keypress = keypress)

            /** A mouse move action. */
            @JvmStatic fun ofMove(move: Move) = Action(move = move)

            /** A screenshot action. */
            @JvmStatic
            fun ofScreenshot() = Action(screenshot = JsonValue.from(mapOf("type" to "screenshot")))

            /** A scroll action. */
            @JvmStatic fun ofScroll(scroll: Scroll) = Action(scroll = scroll)

            /** An action to type in text. */
            @JvmStatic fun ofType(type: Type) = Action(type = type)

            /** A wait action. */
            @JvmStatic fun ofWait() = Action(wait = JsonValue.from(mapOf("type" to "wait")))
        }

        /** An interface that defines how to map each variant of [Action] to a value of type [T]. */
        interface Visitor<out T> {

            /** A click action. */
            fun visitClick(click: Click): T

            /** A double click action. */
            fun visitDoubleClick(doubleClick: DoubleClick): T

            /** A drag action. */
            fun visitDrag(drag: Drag): T

            /** A collection of keypresses the model would like to perform. */
            fun visitKeypress(keypress: Keypress): T

            /** A mouse move action. */
            fun visitMove(move: Move): T

            /** A screenshot action. */
            fun visitScreenshot(screenshot: JsonValue): T

            /** A scroll action. */
            fun visitScroll(scroll: Scroll): T

            /** An action to type in text. */
            fun visitType(type: Type): T

            /** A wait action. */
            fun visitWait(wait: JsonValue): T

            /**
             * Maps an unknown variant of [Action] to a value of type [T].
             *
             * An instance of [Action] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Action: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Action>(Action::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Action {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "click" -> {
                        tryDeserialize(node, jacksonTypeRef<Click>()) { it.validate() }
                            ?.let {
                                return Action(click = it, _json = json)
                            }
                    }
                    "double_click" -> {
                        tryDeserialize(node, jacksonTypeRef<DoubleClick>()) { it.validate() }
                            ?.let {
                                return Action(doubleClick = it, _json = json)
                            }
                    }
                    "drag" -> {
                        tryDeserialize(node, jacksonTypeRef<Drag>()) { it.validate() }
                            ?.let {
                                return Action(drag = it, _json = json)
                            }
                    }
                    "keypress" -> {
                        tryDeserialize(node, jacksonTypeRef<Keypress>()) { it.validate() }
                            ?.let {
                                return Action(keypress = it, _json = json)
                            }
                    }
                    "move" -> {
                        tryDeserialize(node, jacksonTypeRef<Move>()) { it.validate() }
                            ?.let {
                                return Action(move = it, _json = json)
                            }
                    }
                    "screenshot" -> {
                        tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                it.let {
                                    if (it != JsonValue.from(mapOf("type" to "screenshot"))) {
                                        throw OpenAIInvalidDataException(
                                            "'screenshot' is invalid, received $it"
                                        )
                                    }
                                }
                            }
                            ?.let {
                                return Action(screenshot = it, _json = json)
                            }
                    }
                    "scroll" -> {
                        tryDeserialize(node, jacksonTypeRef<Scroll>()) { it.validate() }
                            ?.let {
                                return Action(scroll = it, _json = json)
                            }
                    }
                    "type" -> {
                        tryDeserialize(node, jacksonTypeRef<Type>()) { it.validate() }
                            ?.let {
                                return Action(type = it, _json = json)
                            }
                    }
                    "wait" -> {
                        tryDeserialize(node, jacksonTypeRef<JsonValue>()) {
                                it.let {
                                    if (it != JsonValue.from(mapOf("type" to "wait"))) {
                                        throw OpenAIInvalidDataException(
                                            "'wait' is invalid, received $it"
                                        )
                                    }
                                }
                            }
                            ?.let {
                                return Action(wait = it, _json = json)
                            }
                    }
                }

                return Action(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Action>(Action::class) {

            override fun serialize(
                value: Action,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.click != null -> generator.writeObject(value.click)
                    value.doubleClick != null -> generator.writeObject(value.doubleClick)
                    value.drag != null -> generator.writeObject(value.drag)
                    value.keypress != null -> generator.writeObject(value.keypress)
                    value.move != null -> generator.writeObject(value.move)
                    value.screenshot != null -> generator.writeObject(value.screenshot)
                    value.scroll != null -> generator.writeObject(value.scroll)
                    value.type != null -> generator.writeObject(value.type)
                    value.wait != null -> generator.writeObject(value.wait)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Action")
                }
            }
        }

        /** A click action. */
        @NoAutoDetect
        class Click
        @JsonCreator
        private constructor(
            @JsonProperty("button")
            @ExcludeMissing
            private val button: JsonField<Button> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("x") @ExcludeMissing private val x: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("y") @ExcludeMissing private val y: JsonField<Long> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * Indicates which mouse button was pressed during the click. One of `left`, `right`,
             * `wheel`, `back`, or `forward`.
             */
            fun button(): Button = button.getRequired("button")

            /**
             * Specifies the event type. For a click action, this property is always set to `click`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The x-coordinate where the click occurred. */
            fun x(): Long = x.getRequired("x")

            /** The y-coordinate where the click occurred. */
            fun y(): Long = y.getRequired("y")

            /**
             * Indicates which mouse button was pressed during the click. One of `left`, `right`,
             * `wheel`, `back`, or `forward`.
             */
            @JsonProperty("button") @ExcludeMissing fun _button(): JsonField<Button> = button

            /** The x-coordinate where the click occurred. */
            @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<Long> = x

            /** The y-coordinate where the click occurred. */
            @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Long> = y

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Click = apply {
                if (validated) {
                    return@apply
                }

                button()
                _type().let {
                    if (it != JsonValue.from("click")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                x()
                y()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Click].
                 *
                 * The following fields are required:
                 * ```java
                 * .button()
                 * .x()
                 * .y()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Click]. */
            class Builder internal constructor() {

                private var button: JsonField<Button>? = null
                private var type: JsonValue = JsonValue.from("click")
                private var x: JsonField<Long>? = null
                private var y: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(click: Click) = apply {
                    button = click.button
                    type = click.type
                    x = click.x
                    y = click.y
                    additionalProperties = click.additionalProperties.toMutableMap()
                }

                /**
                 * Indicates which mouse button was pressed during the click. One of `left`,
                 * `right`, `wheel`, `back`, or `forward`.
                 */
                fun button(button: Button) = button(JsonField.of(button))

                /**
                 * Indicates which mouse button was pressed during the click. One of `left`,
                 * `right`, `wheel`, `back`, or `forward`.
                 */
                fun button(button: JsonField<Button>) = apply { this.button = button }

                /**
                 * Specifies the event type. For a click action, this property is always set to
                 * `click`.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The x-coordinate where the click occurred. */
                fun x(x: Long) = x(JsonField.of(x))

                /** The x-coordinate where the click occurred. */
                fun x(x: JsonField<Long>) = apply { this.x = x }

                /** The y-coordinate where the click occurred. */
                fun y(y: Long) = y(JsonField.of(y))

                /** The y-coordinate where the click occurred. */
                fun y(y: JsonField<Long>) = apply { this.y = y }

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

                fun build(): Click =
                    Click(
                        checkRequired("button", button),
                        type,
                        checkRequired("x", x),
                        checkRequired("y", y),
                        additionalProperties.toImmutable(),
                    )
            }

            /**
             * Indicates which mouse button was pressed during the click. One of `left`, `right`,
             * `wheel`, `back`, or `forward`.
             */
            class Button @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val LEFT = of("left")

                    @JvmField val RIGHT = of("right")

                    @JvmField val WHEEL = of("wheel")

                    @JvmField val BACK = of("back")

                    @JvmField val FORWARD = of("forward")

                    @JvmStatic fun of(value: String) = Button(JsonField.of(value))
                }

                /** An enum containing [Button]'s known values. */
                enum class Known {
                    LEFT,
                    RIGHT,
                    WHEEL,
                    BACK,
                    FORWARD,
                }

                /**
                 * An enum containing [Button]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Button] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    LEFT,
                    RIGHT,
                    WHEEL,
                    BACK,
                    FORWARD,
                    /**
                     * An enum member indicating that [Button] was instantiated with an unknown
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
                        LEFT -> Value.LEFT
                        RIGHT -> Value.RIGHT
                        WHEEL -> Value.WHEEL
                        BACK -> Value.BACK
                        FORWARD -> Value.FORWARD
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
                        LEFT -> Known.LEFT
                        RIGHT -> Known.RIGHT
                        WHEEL -> Known.WHEEL
                        BACK -> Known.BACK
                        FORWARD -> Known.FORWARD
                        else -> throw OpenAIInvalidDataException("Unknown Button: $value")
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

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Button && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Click && button == other.button && type == other.type && x == other.x && y == other.y && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(button, type, x, y, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Click{button=$button, type=$type, x=$x, y=$y, additionalProperties=$additionalProperties}"
        }

        /** A double click action. */
        @NoAutoDetect
        class DoubleClick
        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("x") @ExcludeMissing private val x: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("y") @ExcludeMissing private val y: JsonField<Long> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * Specifies the event type. For a double click action, this property is always set to
             * `double_click`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The x-coordinate where the double click occurred. */
            fun x(): Long = x.getRequired("x")

            /** The y-coordinate where the double click occurred. */
            fun y(): Long = y.getRequired("y")

            /** The x-coordinate where the double click occurred. */
            @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<Long> = x

            /** The y-coordinate where the double click occurred. */
            @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Long> = y

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): DoubleClick = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("double_click")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                x()
                y()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [DoubleClick].
                 *
                 * The following fields are required:
                 * ```java
                 * .x()
                 * .y()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DoubleClick]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("double_click")
                private var x: JsonField<Long>? = null
                private var y: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(doubleClick: DoubleClick) = apply {
                    type = doubleClick.type
                    x = doubleClick.x
                    y = doubleClick.y
                    additionalProperties = doubleClick.additionalProperties.toMutableMap()
                }

                /**
                 * Specifies the event type. For a double click action, this property is always set
                 * to `double_click`.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The x-coordinate where the double click occurred. */
                fun x(x: Long) = x(JsonField.of(x))

                /** The x-coordinate where the double click occurred. */
                fun x(x: JsonField<Long>) = apply { this.x = x }

                /** The y-coordinate where the double click occurred. */
                fun y(y: Long) = y(JsonField.of(y))

                /** The y-coordinate where the double click occurred. */
                fun y(y: JsonField<Long>) = apply { this.y = y }

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

                fun build(): DoubleClick =
                    DoubleClick(
                        type,
                        checkRequired("x", x),
                        checkRequired("y", y),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is DoubleClick && type == other.type && x == other.x && y == other.y && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, x, y, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DoubleClick{type=$type, x=$x, y=$y, additionalProperties=$additionalProperties}"
        }

        /** A drag action. */
        @NoAutoDetect
        class Drag
        @JsonCreator
        private constructor(
            @JsonProperty("path")
            @ExcludeMissing
            private val path: JsonField<List<Path>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * An array of coordinates representing the path of the drag action. Coordinates will
             * appear as an array of objects, eg
             *
             * ```
             * [
             *   { x: 100, y: 200 },
             *   { x: 200, y: 300 }
             * ]
             * ```
             */
            fun path(): List<Path> = path.getRequired("path")

            /**
             * Specifies the event type. For a drag action, this property is always set to `drag`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * An array of coordinates representing the path of the drag action. Coordinates will
             * appear as an array of objects, eg
             *
             * ```
             * [
             *   { x: 100, y: 200 },
             *   { x: 200, y: 300 }
             * ]
             * ```
             */
            @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<List<Path>> = path

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Drag = apply {
                if (validated) {
                    return@apply
                }

                path().forEach { it.validate() }
                _type().let {
                    if (it != JsonValue.from("drag")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Drag].
                 *
                 * The following fields are required:
                 * ```java
                 * .path()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Drag]. */
            class Builder internal constructor() {

                private var path: JsonField<MutableList<Path>>? = null
                private var type: JsonValue = JsonValue.from("drag")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(drag: Drag) = apply {
                    path = drag.path.map { it.toMutableList() }
                    type = drag.type
                    additionalProperties = drag.additionalProperties.toMutableMap()
                }

                /**
                 * An array of coordinates representing the path of the drag action. Coordinates
                 * will appear as an array of objects, eg
                 *
                 * ```
                 * [
                 *   { x: 100, y: 200 },
                 *   { x: 200, y: 300 }
                 * ]
                 * ```
                 */
                fun path(path: List<Path>) = path(JsonField.of(path))

                /**
                 * An array of coordinates representing the path of the drag action. Coordinates
                 * will appear as an array of objects, eg
                 *
                 * ```
                 * [
                 *   { x: 100, y: 200 },
                 *   { x: 200, y: 300 }
                 * ]
                 * ```
                 */
                fun path(path: JsonField<List<Path>>) = apply {
                    this.path = path.map { it.toMutableList() }
                }

                /**
                 * An array of coordinates representing the path of the drag action. Coordinates
                 * will appear as an array of objects, eg
                 *
                 * ```
                 * [
                 *   { x: 100, y: 200 },
                 *   { x: 200, y: 300 }
                 * ]
                 * ```
                 */
                fun addPath(path: Path) = apply {
                    this.path =
                        (this.path ?: JsonField.of(mutableListOf())).also {
                            checkKnown("path", it).add(path)
                        }
                }

                /**
                 * Specifies the event type. For a drag action, this property is always set to
                 * `drag`.
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

                fun build(): Drag =
                    Drag(
                        checkRequired("path", path).map { it.toImmutable() },
                        type,
                        additionalProperties.toImmutable(),
                    )
            }

            /** A series of x/y coordinate pairs in the drag path. */
            @NoAutoDetect
            class Path
            @JsonCreator
            private constructor(
                @JsonProperty("x")
                @ExcludeMissing
                private val x: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("y")
                @ExcludeMissing
                private val y: JsonField<Long> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The x-coordinate. */
                fun x(): Long = x.getRequired("x")

                /** The y-coordinate. */
                fun y(): Long = y.getRequired("y")

                /** The x-coordinate. */
                @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<Long> = x

                /** The y-coordinate. */
                @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Long> = y

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Path = apply {
                    if (validated) {
                        return@apply
                    }

                    x()
                    y()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [Path].
                     *
                     * The following fields are required:
                     * ```java
                     * .x()
                     * .y()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Path]. */
                class Builder internal constructor() {

                    private var x: JsonField<Long>? = null
                    private var y: JsonField<Long>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(path: Path) = apply {
                        x = path.x
                        y = path.y
                        additionalProperties = path.additionalProperties.toMutableMap()
                    }

                    /** The x-coordinate. */
                    fun x(x: Long) = x(JsonField.of(x))

                    /** The x-coordinate. */
                    fun x(x: JsonField<Long>) = apply { this.x = x }

                    /** The y-coordinate. */
                    fun y(y: Long) = y(JsonField.of(y))

                    /** The y-coordinate. */
                    fun y(y: JsonField<Long>) = apply { this.y = y }

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

                    fun build(): Path =
                        Path(
                            checkRequired("x", x),
                            checkRequired("y", y),
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Path && x == other.x && y == other.y && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(x, y, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Path{x=$x, y=$y, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Drag && path == other.path && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(path, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Drag{path=$path, type=$type, additionalProperties=$additionalProperties}"
        }

        /** A collection of keypresses the model would like to perform. */
        @NoAutoDetect
        class Keypress
        @JsonCreator
        private constructor(
            @JsonProperty("keys")
            @ExcludeMissing
            private val keys: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The combination of keys the model is requesting to be pressed. This is an array of
             * strings, each representing a key.
             */
            fun keys(): List<String> = keys.getRequired("keys")

            /**
             * Specifies the event type. For a keypress action, this property is always set to
             * `keypress`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The combination of keys the model is requesting to be pressed. This is an array of
             * strings, each representing a key.
             */
            @JsonProperty("keys") @ExcludeMissing fun _keys(): JsonField<List<String>> = keys

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Keypress = apply {
                if (validated) {
                    return@apply
                }

                keys()
                _type().let {
                    if (it != JsonValue.from("keypress")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Keypress].
                 *
                 * The following fields are required:
                 * ```java
                 * .keys()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Keypress]. */
            class Builder internal constructor() {

                private var keys: JsonField<MutableList<String>>? = null
                private var type: JsonValue = JsonValue.from("keypress")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(keypress: Keypress) = apply {
                    keys = keypress.keys.map { it.toMutableList() }
                    type = keypress.type
                    additionalProperties = keypress.additionalProperties.toMutableMap()
                }

                /**
                 * The combination of keys the model is requesting to be pressed. This is an array
                 * of strings, each representing a key.
                 */
                fun keys(keys: List<String>) = keys(JsonField.of(keys))

                /**
                 * The combination of keys the model is requesting to be pressed. This is an array
                 * of strings, each representing a key.
                 */
                fun keys(keys: JsonField<List<String>>) = apply {
                    this.keys = keys.map { it.toMutableList() }
                }

                /**
                 * The combination of keys the model is requesting to be pressed. This is an array
                 * of strings, each representing a key.
                 */
                fun addKey(key: String) = apply {
                    keys =
                        (keys ?: JsonField.of(mutableListOf())).also {
                            checkKnown("keys", it).add(key)
                        }
                }

                /**
                 * Specifies the event type. For a keypress action, this property is always set to
                 * `keypress`.
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

                fun build(): Keypress =
                    Keypress(
                        checkRequired("keys", keys).map { it.toImmutable() },
                        type,
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Keypress && keys == other.keys && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(keys, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Keypress{keys=$keys, type=$type, additionalProperties=$additionalProperties}"
        }

        /** A mouse move action. */
        @NoAutoDetect
        class Move
        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("x") @ExcludeMissing private val x: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("y") @ExcludeMissing private val y: JsonField<Long> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * Specifies the event type. For a move action, this property is always set to `move`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The x-coordinate to move to. */
            fun x(): Long = x.getRequired("x")

            /** The y-coordinate to move to. */
            fun y(): Long = y.getRequired("y")

            /** The x-coordinate to move to. */
            @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<Long> = x

            /** The y-coordinate to move to. */
            @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Long> = y

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Move = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("move")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                x()
                y()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Move].
                 *
                 * The following fields are required:
                 * ```java
                 * .x()
                 * .y()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Move]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("move")
                private var x: JsonField<Long>? = null
                private var y: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(move: Move) = apply {
                    type = move.type
                    x = move.x
                    y = move.y
                    additionalProperties = move.additionalProperties.toMutableMap()
                }

                /**
                 * Specifies the event type. For a move action, this property is always set to
                 * `move`.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The x-coordinate to move to. */
                fun x(x: Long) = x(JsonField.of(x))

                /** The x-coordinate to move to. */
                fun x(x: JsonField<Long>) = apply { this.x = x }

                /** The y-coordinate to move to. */
                fun y(y: Long) = y(JsonField.of(y))

                /** The y-coordinate to move to. */
                fun y(y: JsonField<Long>) = apply { this.y = y }

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

                fun build(): Move =
                    Move(
                        type,
                        checkRequired("x", x),
                        checkRequired("y", y),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Move && type == other.type && x == other.x && y == other.y && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, x, y, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Move{type=$type, x=$x, y=$y, additionalProperties=$additionalProperties}"
        }

        /** A scroll action. */
        @NoAutoDetect
        class Scroll
        @JsonCreator
        private constructor(
            @JsonProperty("scroll_x")
            @ExcludeMissing
            private val scrollX: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("scroll_y")
            @ExcludeMissing
            private val scrollY: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("x") @ExcludeMissing private val x: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("y") @ExcludeMissing private val y: JsonField<Long> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The horizontal scroll distance. */
            fun scrollX(): Long = scrollX.getRequired("scroll_x")

            /** The vertical scroll distance. */
            fun scrollY(): Long = scrollY.getRequired("scroll_y")

            /**
             * Specifies the event type. For a scroll action, this property is always set to
             * `scroll`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The x-coordinate where the scroll occurred. */
            fun x(): Long = x.getRequired("x")

            /** The y-coordinate where the scroll occurred. */
            fun y(): Long = y.getRequired("y")

            /** The horizontal scroll distance. */
            @JsonProperty("scroll_x") @ExcludeMissing fun _scrollX(): JsonField<Long> = scrollX

            /** The vertical scroll distance. */
            @JsonProperty("scroll_y") @ExcludeMissing fun _scrollY(): JsonField<Long> = scrollY

            /** The x-coordinate where the scroll occurred. */
            @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<Long> = x

            /** The y-coordinate where the scroll occurred. */
            @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Long> = y

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Scroll = apply {
                if (validated) {
                    return@apply
                }

                scrollX()
                scrollY()
                _type().let {
                    if (it != JsonValue.from("scroll")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                x()
                y()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Scroll].
                 *
                 * The following fields are required:
                 * ```java
                 * .scrollX()
                 * .scrollY()
                 * .x()
                 * .y()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Scroll]. */
            class Builder internal constructor() {

                private var scrollX: JsonField<Long>? = null
                private var scrollY: JsonField<Long>? = null
                private var type: JsonValue = JsonValue.from("scroll")
                private var x: JsonField<Long>? = null
                private var y: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(scroll: Scroll) = apply {
                    scrollX = scroll.scrollX
                    scrollY = scroll.scrollY
                    type = scroll.type
                    x = scroll.x
                    y = scroll.y
                    additionalProperties = scroll.additionalProperties.toMutableMap()
                }

                /** The horizontal scroll distance. */
                fun scrollX(scrollX: Long) = scrollX(JsonField.of(scrollX))

                /** The horizontal scroll distance. */
                fun scrollX(scrollX: JsonField<Long>) = apply { this.scrollX = scrollX }

                /** The vertical scroll distance. */
                fun scrollY(scrollY: Long) = scrollY(JsonField.of(scrollY))

                /** The vertical scroll distance. */
                fun scrollY(scrollY: JsonField<Long>) = apply { this.scrollY = scrollY }

                /**
                 * Specifies the event type. For a scroll action, this property is always set to
                 * `scroll`.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The x-coordinate where the scroll occurred. */
                fun x(x: Long) = x(JsonField.of(x))

                /** The x-coordinate where the scroll occurred. */
                fun x(x: JsonField<Long>) = apply { this.x = x }

                /** The y-coordinate where the scroll occurred. */
                fun y(y: Long) = y(JsonField.of(y))

                /** The y-coordinate where the scroll occurred. */
                fun y(y: JsonField<Long>) = apply { this.y = y }

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

                fun build(): Scroll =
                    Scroll(
                        checkRequired("scrollX", scrollX),
                        checkRequired("scrollY", scrollY),
                        type,
                        checkRequired("x", x),
                        checkRequired("y", y),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Scroll && scrollX == other.scrollX && scrollY == other.scrollY && type == other.type && x == other.x && y == other.y && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(scrollX, scrollY, type, x, y, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Scroll{scrollX=$scrollX, scrollY=$scrollY, type=$type, x=$x, y=$y, additionalProperties=$additionalProperties}"
        }

        /** An action to type in text. */
        @NoAutoDetect
        class Type
        @JsonCreator
        private constructor(
            @JsonProperty("text")
            @ExcludeMissing
            private val text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The text to type. */
            fun text(): String = text.getRequired("text")

            /**
             * Specifies the event type. For a type action, this property is always set to `type`.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The text to type. */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Type = apply {
                if (validated) {
                    return@apply
                }

                text()
                _type().let {
                    if (it != JsonValue.from("type")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Type].
                 *
                 * The following fields are required:
                 * ```java
                 * .text()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Type]. */
            class Builder internal constructor() {

                private var text: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("type")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(type: Type) = apply {
                    text = type.text
                    this.type = type.type
                    additionalProperties = type.additionalProperties.toMutableMap()
                }

                /** The text to type. */
                fun text(text: String) = text(JsonField.of(text))

                /** The text to type. */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /**
                 * Specifies the event type. For a type action, this property is always set to
                 * `type`.
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

                fun build(): Type =
                    Type(checkRequired("text", text), type, additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Type && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Type{text=$text, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    /** A pending safety check for the computer call. */
    @NoAutoDetect
    class PendingSafetyCheck
    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("code")
        @ExcludeMissing
        private val code: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message")
        @ExcludeMissing
        private val message: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The ID of the pending safety check. */
        fun id(): String = id.getRequired("id")

        /** The type of the pending safety check. */
        fun code(): String = code.getRequired("code")

        /** Details about the pending safety check. */
        fun message(): String = message.getRequired("message")

        /** The ID of the pending safety check. */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /** The type of the pending safety check. */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /** Details about the pending safety check. */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): PendingSafetyCheck = apply {
            if (validated) {
                return@apply
            }

            id()
            code()
            message()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [PendingSafetyCheck].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PendingSafetyCheck]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var code: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(pendingSafetyCheck: PendingSafetyCheck) = apply {
                id = pendingSafetyCheck.id
                code = pendingSafetyCheck.code
                message = pendingSafetyCheck.message
                additionalProperties = pendingSafetyCheck.additionalProperties.toMutableMap()
            }

            /** The ID of the pending safety check. */
            fun id(id: String) = id(JsonField.of(id))

            /** The ID of the pending safety check. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The type of the pending safety check. */
            fun code(code: String) = code(JsonField.of(code))

            /** The type of the pending safety check. */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Details about the pending safety check. */
            fun message(message: String) = message(JsonField.of(message))

            /** Details about the pending safety check. */
            fun message(message: JsonField<String>) = apply { this.message = message }

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

            fun build(): PendingSafetyCheck =
                PendingSafetyCheck(
                    checkRequired("id", id),
                    checkRequired("code", code),
                    checkRequired("message", message),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PendingSafetyCheck && id == other.id && code == other.code && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, code, message, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PendingSafetyCheck{id=$id, code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    /**
     * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated when
     * items are returned via API.
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

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val COMPLETED = of("completed")

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            COMPLETED,
            INCOMPLETE,
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
            IN_PROGRESS,
            COMPLETED,
            INCOMPLETE,
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
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETED -> Value.COMPLETED
                INCOMPLETE -> Value.INCOMPLETE
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
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETED -> Known.COMPLETED
                INCOMPLETE -> Known.INCOMPLETE
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The type of the computer call. Always `computer_call`. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val COMPUTER_CALL = of("computer_call")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            COMPUTER_CALL
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPUTER_CALL,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                COMPUTER_CALL -> Value.COMPUTER_CALL
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
                COMPUTER_CALL -> Known.COMPUTER_CALL
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

        return /* spotless:off */ other is ResponseComputerToolCall && id == other.id && action == other.action && callId == other.callId && pendingSafetyChecks == other.pendingSafetyChecks && status == other.status && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, action, callId, pendingSafetyChecks, status, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseComputerToolCall{id=$id, action=$action, callId=$callId, pendingSafetyChecks=$pendingSafetyChecks, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
