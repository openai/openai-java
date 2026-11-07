// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

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

/** A saved automation and its schedule. */
@JsonDeserialize(using = Automation.Deserializer::class)
@JsonSerialize(using = Automation.Serializer::class)
class Automation
private constructor(
    private val periodic: PeriodicAutomation? = null,
    private val once: OneTimeAutomation? = null,
    private val _json: JsonValue? = null,
) {

    /** Fields shared by periodic and one-time automations. */
    fun periodic(): Optional<PeriodicAutomation> = Optional.ofNullable(periodic)

    /** Fields shared by periodic and one-time automations. */
    fun once(): Optional<OneTimeAutomation> = Optional.ofNullable(once)

    fun isPeriodic(): Boolean = periodic != null

    fun isOnce(): Boolean = once != null

    /** Fields shared by periodic and one-time automations. */
    fun asPeriodic(): PeriodicAutomation = periodic.getOrThrow("periodic")

    /** Fields shared by periodic and one-time automations. */
    fun asOnce(): OneTimeAutomation = once.getOrThrow("once")

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
     * Optional<String> result = automation.accept(new Automation.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitPeriodic(PeriodicAutomation periodic) {
     *         return Optional.of(periodic.toString());
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
            periodic != null -> visitor.visitPeriodic(periodic)
            once != null -> visitor.visitOnce(once)
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
    fun validate(): Automation = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitPeriodic(periodic: PeriodicAutomation) {
                    periodic.validate()
                }

                override fun visitOnce(once: OneTimeAutomation) {
                    once.validate()
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
                override fun visitPeriodic(periodic: PeriodicAutomation) = periodic.validity()

                override fun visitOnce(once: OneTimeAutomation) = once.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Automation &&
            periodic == other.periodic &&
            once == other.once &&
            (periodic != null || once != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (periodic == null && once == null) Objects.hash(_json) else Objects.hash(periodic, once)

    override fun toString(): String =
        when {
            periodic != null -> "Automation{periodic=$periodic}"
            once != null -> "Automation{once=$once}"
            _json != null -> "Automation{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Automation")
        }

    companion object {

        /** Fields shared by periodic and one-time automations. */
        @JvmStatic fun ofPeriodic(periodic: PeriodicAutomation) = Automation(periodic = periodic)

        /** Fields shared by periodic and one-time automations. */
        @JvmStatic fun ofOnce(once: OneTimeAutomation) = Automation(once = once)
    }

    /** An interface that defines how to map each variant of [Automation] to a value of type [T]. */
    interface Visitor<out T> {

        /** Fields shared by periodic and one-time automations. */
        fun visitPeriodic(periodic: PeriodicAutomation): T

        /** Fields shared by periodic and one-time automations. */
        fun visitOnce(once: OneTimeAutomation): T

        /**
         * Maps an unknown variant of [Automation] to a value of type [T].
         *
         * An instance of [Automation] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown Automation")
        }
    }

    internal class Deserializer : BaseDeserializer<Automation>(Automation::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Automation {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "periodic" -> {
                    return tryDeserialize(node, jacksonTypeRef<PeriodicAutomation>())?.let {
                        Automation(periodic = it, _json = json)
                    } ?: Automation(_json = json)
                }
                "once" -> {
                    return tryDeserialize(node, jacksonTypeRef<OneTimeAutomation>())?.let {
                        Automation(once = it, _json = json)
                    } ?: Automation(_json = json)
                }
            }

            return Automation(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<Automation>(Automation::class) {

        override fun serialize(
            value: Automation,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.periodic != null -> generator.writeObject(value.periodic)
                value.once != null -> generator.writeObject(value.once)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Automation")
            }
        }
    }
}
