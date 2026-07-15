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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class RealtimeAudioConfigOutput
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val format: JsonField<RealtimeAudioFormats>,
    private val speed: JsonField<Double>,
    private val voice: JsonField<Voice>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("format")
        @ExcludeMissing
        format: JsonField<RealtimeAudioFormats> = JsonMissing.of(),
        @JsonProperty("speed") @ExcludeMissing speed: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("voice") @ExcludeMissing voice: JsonField<Voice> = JsonMissing.of(),
    ) : this(format, speed, voice, mutableMapOf())

    /**
     * The format of the output audio.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<RealtimeAudioFormats> = format.getOptional("format")

    /**
     * The speed of the model's spoken response as a multiple of the original speed. 1.0 is the
     * default speed. 0.25 is the minimum speed. 1.5 is the maximum speed. This value can only be
     * changed in between model turns, not while a response is in progress.
     *
     * This parameter is a post-processing adjustment to the audio after it is generated, it's also
     * possible to prompt the model to speak faster or slower.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun speed(): Optional<Double> = speed.getOptional("speed")

    /**
     * The voice the model uses to respond. Supported built-in voices are `alloy`, `ash`, `ballad`,
     * `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`. You may also provide a
     * custom voice object with an `id`, for example `{ "id": "voice_1234" }`. Voice cannot be
     * changed during the session once the model has responded with audio at least once. We
     * recommend `marin` and `cedar` for best quality.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun voice(): Optional<Voice> = voice.getOptional("voice")

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<RealtimeAudioFormats> = format

    /**
     * Returns the raw JSON value of [speed].
     *
     * Unlike [speed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("speed") @ExcludeMissing fun _speed(): JsonField<Double> = speed

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

        /**
         * Returns a mutable builder for constructing an instance of [RealtimeAudioConfigOutput].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeAudioConfigOutput]. */
    class Builder internal constructor() {

        private var format: JsonField<RealtimeAudioFormats> = JsonMissing.of()
        private var speed: JsonField<Double> = JsonMissing.of()
        private var voice: JsonField<Voice> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeAudioConfigOutput: RealtimeAudioConfigOutput) = apply {
            format = realtimeAudioConfigOutput.format
            speed = realtimeAudioConfigOutput.speed
            voice = realtimeAudioConfigOutput.voice
            additionalProperties = realtimeAudioConfigOutput.additionalProperties.toMutableMap()
        }

        /** The format of the output audio. */
        fun format(format: RealtimeAudioFormats) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [RealtimeAudioFormats] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun format(format: JsonField<RealtimeAudioFormats>) = apply { this.format = format }

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcm(audioPcm)`. */
        fun format(audioPcm: RealtimeAudioFormats.AudioPcm) =
            format(RealtimeAudioFormats.ofAudioPcm(audioPcm))

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcmu(audioPcmu)`. */
        fun format(audioPcmu: RealtimeAudioFormats.AudioPcmu) =
            format(RealtimeAudioFormats.ofAudioPcmu(audioPcmu))

        /** Alias for calling [format] with `RealtimeAudioFormats.ofAudioPcma(audioPcma)`. */
        fun format(audioPcma: RealtimeAudioFormats.AudioPcma) =
            format(RealtimeAudioFormats.ofAudioPcma(audioPcma))

        /**
         * The speed of the model's spoken response as a multiple of the original speed. 1.0 is the
         * default speed. 0.25 is the minimum speed. 1.5 is the maximum speed. This value can only
         * be changed in between model turns, not while a response is in progress.
         *
         * This parameter is a post-processing adjustment to the audio after it is generated, it's
         * also possible to prompt the model to speak faster or slower.
         */
        fun speed(speed: Double) = speed(JsonField.of(speed))

        /**
         * Sets [Builder.speed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.speed] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun speed(speed: JsonField<Double>) = apply { this.speed = speed }

        /**
         * The voice the model uses to respond. Supported built-in voices are `alloy`, `ash`,
         * `ballad`, `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`. You may also
         * provide a custom voice object with an `id`, for example `{ "id": "voice_1234" }`. Voice
         * cannot be changed during the session once the model has responded with audio at least
         * once. We recommend `marin` and `cedar` for best quality.
         */
        fun voice(voice: Voice) = voice(JsonField.of(voice))

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed [Voice] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(voice: JsonField<Voice>) = apply { this.voice = voice }

        /** Alias for calling [voice] with `Voice.ofString(string)`. */
        fun voice(string: String) = voice(Voice.ofString(string))

        /** Alias for calling [voice] with `Voice.ofUnionMember1(unionMember1)`. */
        fun voice(unionMember1: Voice.UnionMember1) = voice(Voice.ofUnionMember1(unionMember1))

        /** Alias for calling [voice] with `Voice.ofId(id)`. */
        fun voice(id: Voice.Id) = voice(Voice.ofId(id))

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
         * Returns an immutable instance of [RealtimeAudioConfigOutput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeAudioConfigOutput =
            RealtimeAudioConfigOutput(format, speed, voice, additionalProperties.toMutableMap())
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
    fun validate(): RealtimeAudioConfigOutput = apply {
        if (validated) {
            return@apply
        }

        format().ifPresent { it.validate() }
        speed()
        voice().ifPresent { it.validate() }
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
        (format.asKnown().getOrNull()?.validity() ?: 0) +
            (if (speed.asKnown().isPresent) 1 else 0) +
            (voice.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * The voice the model uses to respond. Supported built-in voices are `alloy`, `ash`, `ballad`,
     * `coral`, `echo`, `sage`, `shimmer`, `verse`, `marin`, and `cedar`. You may also provide a
     * custom voice object with an `id`, for example `{ "id": "voice_1234" }`. Voice cannot be
     * changed during the session once the model has responded with audio at least once. We
     * recommend `marin` and `cedar` for best quality.
     */
    @JsonDeserialize(using = Voice.Deserializer::class)
    @JsonSerialize(using = Voice.Serializer::class)
    class Voice
    private constructor(
        private val string: String? = null,
        private val unionMember1: UnionMember1? = null,
        private val id: Id? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        /** Custom voice reference. */
        fun id(): Optional<Id> = Optional.ofNullable(id)

        fun isString(): Boolean = string != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        fun isId(): Boolean = id != null

        fun asString(): String = string.getOrThrow("string")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        /** Custom voice reference. */
        fun asId(): Id = id.getOrThrow("id")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = voice.accept(new Voice.Visitor<Optional<String>>() {
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                id != null -> visitor.visitId(id)
                else -> visitor.unknown(_json)
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
        fun validate(): Voice = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitUnionMember1(unionMember1: UnionMember1) {
                        unionMember1.validate()
                    }

                    override fun visitId(id: Id) {
                        id.validate()
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

                    override fun visitUnionMember1(unionMember1: UnionMember1) =
                        unionMember1.validity()

                    override fun visitId(id: Id) = id.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Voice &&
                string == other.string &&
                unionMember1 == other.unionMember1 &&
                id == other.id
        }

        override fun hashCode(): Int = Objects.hash(string, unionMember1, id)

        override fun toString(): String =
            when {
                string != null -> "Voice{string=$string}"
                unionMember1 != null -> "Voice{unionMember1=$unionMember1}"
                id != null -> "Voice{id=$id}"
                _json != null -> "Voice{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Voice")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Voice(string = string)

            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Voice(unionMember1 = unionMember1)

            /** Custom voice reference. */
            @JvmStatic fun ofId(id: Id) = Voice(id = id)
        }

        /** An interface that defines how to map each variant of [Voice] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

            /** Custom voice reference. */
            fun visitId(id: Id): T

            /**
             * Maps an unknown variant of [Voice] to a value of type [T].
             *
             * An instance of [Voice] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Voice: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Voice>(Voice::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Voice {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                Voice(unionMember1 = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Id>())?.let {
                                Voice(id = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Voice(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Voice(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Voice>(Voice::class) {

            override fun serialize(
                value: Voice,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value.id != null -> generator.writeObject(value.id)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Voice")
                }
            }
        }

        class UnionMember1 @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmStatic fun of(value: String) = UnionMember1(JsonField.of(value))
            }

            /** An enum containing [UnionMember1]'s known values. */
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
             * An enum containing [UnionMember1]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [UnionMember1] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
                /**
                 * An enum member indicating that [UnionMember1] was instantiated with an unknown
                 * value.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
                    else -> throw OpenAIInvalidDataException("Unknown UnionMember1: $value")
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
            fun validate(): UnionMember1 = apply {
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

                return other is UnionMember1 && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Custom voice reference. */
        class Id
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of()
            ) : this(id, mutableMapOf())

            /**
             * The custom voice ID, e.g. `voice_1234`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                 * Returns a mutable builder for constructing an instance of [Id].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Id]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(id: Id) = apply {
                    this.id = id.id
                    additionalProperties = id.additionalProperties.toMutableMap()
                }

                /** The custom voice ID, e.g. `voice_1234`. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

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
                 * Returns an immutable instance of [Id].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Id = Id(checkRequired("id", id), additionalProperties.toMutableMap())
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
            fun validate(): Id = apply {
                if (validated) {
                    return@apply
                }

                id()
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
            @JvmSynthetic internal fun validity(): Int = (if (id.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Id &&
                    id == other.id &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Id{id=$id, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeAudioConfigOutput &&
            format == other.format &&
            speed == other.speed &&
            voice == other.voice &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(format, speed, voice, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeAudioConfigOutput{format=$format, speed=$speed, voice=$voice, additionalProperties=$additionalProperties}"
}
