// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

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
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** One or more lifecycle statuses to include when listing vaults or credentials. */
@JsonDeserialize(using = VaultStatusFilter.Deserializer::class)
@JsonSerialize(using = VaultStatusFilter.Serializer::class)
class VaultStatusFilter
private constructor(
    private val vaultStatus: VaultStatus? = null,
    private val vaultStatuses: List<VaultStatus>? = null,
    private val _json: JsonValue? = null,
) {

    /** Whether a vault or credential is active or archived. */
    fun vaultStatus(): Optional<VaultStatus> = Optional.ofNullable(vaultStatus)

    fun vaultStatuses(): Optional<List<VaultStatus>> = Optional.ofNullable(vaultStatuses)

    fun isVaultStatus(): Boolean = vaultStatus != null

    fun isVaultStatuses(): Boolean = vaultStatuses != null

    /** Whether a vault or credential is active or archived. */
    fun asVaultStatus(): VaultStatus = vaultStatus.getOrThrow("vaultStatus")

    fun asVaultStatuses(): List<VaultStatus> = vaultStatuses.getOrThrow("vaultStatuses")

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
     * Optional<String> result = vaultStatusFilter.accept(new VaultStatusFilter.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitVaultStatus(VaultStatus vaultStatus) {
     *         return Optional.of(vaultStatus.toString());
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
            vaultStatus != null -> visitor.visitVaultStatus(vaultStatus)
            vaultStatuses != null -> visitor.visitVaultStatuses(vaultStatuses)
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
    fun validate(): VaultStatusFilter = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitVaultStatus(vaultStatus: VaultStatus) {
                    vaultStatus.validate()
                }

                override fun visitVaultStatuses(vaultStatuses: List<VaultStatus>) {
                    vaultStatuses.forEach { it.validate() }
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
                override fun visitVaultStatus(vaultStatus: VaultStatus) = vaultStatus.validity()

                override fun visitVaultStatuses(vaultStatuses: List<VaultStatus>) =
                    vaultStatuses.sumOf { it.validity().toInt() }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VaultStatusFilter &&
            vaultStatus == other.vaultStatus &&
            vaultStatuses == other.vaultStatuses
    }

    override fun hashCode(): Int = Objects.hash(vaultStatus, vaultStatuses)

    override fun toString(): String =
        when {
            vaultStatus != null -> "VaultStatusFilter{vaultStatus=$vaultStatus}"
            vaultStatuses != null -> "VaultStatusFilter{vaultStatuses=$vaultStatuses}"
            _json != null -> "VaultStatusFilter{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid VaultStatusFilter")
        }

    companion object {

        /** Whether a vault or credential is active or archived. */
        @JvmStatic
        fun ofVaultStatus(vaultStatus: VaultStatus) = VaultStatusFilter(vaultStatus = vaultStatus)

        @JvmStatic
        fun ofVaultStatuses(vaultStatuses: List<VaultStatus>) =
            VaultStatusFilter(vaultStatuses = vaultStatuses.toImmutable())
    }

    /**
     * An interface that defines how to map each variant of [VaultStatusFilter] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Whether a vault or credential is active or archived. */
        fun visitVaultStatus(vaultStatus: VaultStatus): T

        fun visitVaultStatuses(vaultStatuses: List<VaultStatus>): T

        /**
         * Maps an unknown variant of [VaultStatusFilter] to a value of type [T].
         *
         * An instance of [VaultStatusFilter] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown VaultStatusFilter: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<VaultStatusFilter>(VaultStatusFilter::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): VaultStatusFilter {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<VaultStatus>())?.let {
                            VaultStatusFilter(vaultStatus = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<VaultStatus>>())?.let {
                            VaultStatusFilter(vaultStatuses = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> VaultStatusFilter(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<VaultStatusFilter>(VaultStatusFilter::class) {

        override fun serialize(
            value: VaultStatusFilter,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.vaultStatus != null -> generator.writeObject(value.vaultStatus)
                value.vaultStatuses != null -> generator.writeObject(value.vaultStatuses)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid VaultStatusFilter")
            }
        }
    }
}
