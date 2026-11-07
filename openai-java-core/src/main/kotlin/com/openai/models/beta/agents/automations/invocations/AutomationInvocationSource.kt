// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

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

@JsonDeserialize(using = AutomationInvocationSource.Deserializer::class)
@JsonSerialize(using = AutomationInvocationSource.Serializer::class)
class AutomationInvocationSource
private constructor(
    private val manual: JsonValue? = null,
    private val automation: AutomationInvocationSourceAutomation? = null,
    private val _json: JsonValue? = null,
) {

    fun manual(): Optional<JsonValue> = Optional.ofNullable(manual)

    fun automation(): Optional<AutomationInvocationSourceAutomation> =
        Optional.ofNullable(automation)

    fun isManual(): Boolean = manual != null

    fun isAutomation(): Boolean = automation != null

    fun asManual(): JsonValue = manual.getOrThrow("manual")

    fun asAutomation(): AutomationInvocationSourceAutomation = automation.getOrThrow("automation")

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
     * Optional<String> result = automationInvocationSource.accept(new AutomationInvocationSource.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitManual(JsonValue manual) {
     *         return Optional.of(manual.toString());
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
            manual != null -> visitor.visitManual(manual)
            automation != null -> visitor.visitAutomation(automation)
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
    fun validate(): AutomationInvocationSource = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitManual(manual: JsonValue) {
                    manual.let {
                        if (it != JsonValue.from(mapOf("type" to "manual"))) {
                            throw OpenAIInvalidDataException("'manual' is invalid, received $it")
                        }
                    }
                }

                override fun visitAutomation(automation: AutomationInvocationSourceAutomation) {
                    automation.validate()
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
                override fun visitManual(manual: JsonValue) =
                    manual.let { if (it == JsonValue.from(mapOf("type" to "manual"))) 1 else 0 }

                override fun visitAutomation(automation: AutomationInvocationSourceAutomation) =
                    automation.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationInvocationSource &&
            manual == other.manual &&
            automation == other.automation &&
            (manual != null || automation != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (manual == null && automation == null) Objects.hash(_json)
        else Objects.hash(manual, automation)

    override fun toString(): String =
        when {
            manual != null -> "AutomationInvocationSource{manual=$manual}"
            automation != null -> "AutomationInvocationSource{automation=$automation}"
            _json != null -> "AutomationInvocationSource{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AutomationInvocationSource")
        }

    companion object {

        @JvmStatic
        fun ofManual() =
            AutomationInvocationSource(manual = JsonValue.from(mapOf("type" to "manual")))

        @JvmStatic
        fun ofAutomation(automation: AutomationInvocationSourceAutomation) =
            AutomationInvocationSource(automation = automation)
    }

    /**
     * An interface that defines how to map each variant of [AutomationInvocationSource] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        fun visitManual(manual: JsonValue): T

        fun visitAutomation(automation: AutomationInvocationSourceAutomation): T

        /**
         * Maps an unknown variant of [AutomationInvocationSource] to a value of type [T].
         *
         * An instance of [AutomationInvocationSource] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AutomationInvocationSource")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AutomationInvocationSource>(AutomationInvocationSource::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AutomationInvocationSource {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "manual" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { AutomationInvocationSource(manual = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: AutomationInvocationSource(_json = json)
                }
                "automation" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AutomationInvocationSourceAutomation>(),
                        )
                        ?.let { AutomationInvocationSource(automation = it, _json = json) }
                        ?: AutomationInvocationSource(_json = json)
                }
            }

            return AutomationInvocationSource(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AutomationInvocationSource>(AutomationInvocationSource::class) {

        override fun serialize(
            value: AutomationInvocationSource,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.manual != null -> generator.writeObject(value.manual)
                value.automation != null -> generator.writeObject(value.automation)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AutomationInvocationSource")
            }
        }
    }
}
