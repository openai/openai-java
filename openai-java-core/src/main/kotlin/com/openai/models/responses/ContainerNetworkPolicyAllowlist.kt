// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContainerNetworkPolicyAllowlist
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowedDomains: JsonField<List<String>>,
    private val type: JsonValue,
    private val domainSecrets: JsonField<List<ContainerNetworkPolicyDomainSecret>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allowed_domains")
        @ExcludeMissing
        allowedDomains: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("domain_secrets")
        @ExcludeMissing
        domainSecrets: JsonField<List<ContainerNetworkPolicyDomainSecret>> = JsonMissing.of(),
    ) : this(allowedDomains, type, domainSecrets, mutableMapOf())

    /**
     * A list of allowed domains when type is `allowlist`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun allowedDomains(): List<String> = allowedDomains.getRequired("allowed_domains")

    /**
     * Allow outbound network access only to specified domains. Always `allowlist`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("allowlist")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Optional domain-scoped secrets for allowlisted domains.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun domainSecrets(): Optional<List<ContainerNetworkPolicyDomainSecret>> =
        domainSecrets.getOptional("domain_secrets")

    /**
     * Returns the raw JSON value of [allowedDomains].
     *
     * Unlike [allowedDomains], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed_domains")
    @ExcludeMissing
    fun _allowedDomains(): JsonField<List<String>> = allowedDomains

    /**
     * Returns the raw JSON value of [domainSecrets].
     *
     * Unlike [domainSecrets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("domain_secrets")
    @ExcludeMissing
    fun _domainSecrets(): JsonField<List<ContainerNetworkPolicyDomainSecret>> = domainSecrets

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
         * [ContainerNetworkPolicyAllowlist].
         *
         * The following fields are required:
         * ```java
         * .allowedDomains()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContainerNetworkPolicyAllowlist]. */
    class Builder internal constructor() {

        private var allowedDomains: JsonField<MutableList<String>>? = null
        private var type: JsonValue = JsonValue.from("allowlist")
        private var domainSecrets: JsonField<MutableList<ContainerNetworkPolicyDomainSecret>>? =
            null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(containerNetworkPolicyAllowlist: ContainerNetworkPolicyAllowlist) =
            apply {
                allowedDomains =
                    containerNetworkPolicyAllowlist.allowedDomains.map { it.toMutableList() }
                type = containerNetworkPolicyAllowlist.type
                domainSecrets =
                    containerNetworkPolicyAllowlist.domainSecrets.map { it.toMutableList() }
                additionalProperties =
                    containerNetworkPolicyAllowlist.additionalProperties.toMutableMap()
            }

        /** A list of allowed domains when type is `allowlist`. */
        fun allowedDomains(allowedDomains: List<String>) =
            allowedDomains(JsonField.of(allowedDomains))

        /**
         * Sets [Builder.allowedDomains] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedDomains] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowedDomains(allowedDomains: JsonField<List<String>>) = apply {
            this.allowedDomains = allowedDomains.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [allowedDomains].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedDomain(allowedDomain: String) = apply {
            allowedDomains =
                (allowedDomains ?: JsonField.of(mutableListOf())).also {
                    checkKnown("allowedDomains", it).add(allowedDomain)
                }
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("allowlist")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** Optional domain-scoped secrets for allowlisted domains. */
        fun domainSecrets(domainSecrets: List<ContainerNetworkPolicyDomainSecret>) =
            domainSecrets(JsonField.of(domainSecrets))

        /**
         * Sets [Builder.domainSecrets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.domainSecrets] with a well-typed
         * `List<ContainerNetworkPolicyDomainSecret>` value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun domainSecrets(domainSecrets: JsonField<List<ContainerNetworkPolicyDomainSecret>>) =
            apply {
                this.domainSecrets = domainSecrets.map { it.toMutableList() }
            }

        /**
         * Adds a single [ContainerNetworkPolicyDomainSecret] to [domainSecrets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDomainSecret(domainSecret: ContainerNetworkPolicyDomainSecret) = apply {
            domainSecrets =
                (domainSecrets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("domainSecrets", it).add(domainSecret)
                }
        }

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
         * Returns an immutable instance of [ContainerNetworkPolicyAllowlist].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .allowedDomains()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContainerNetworkPolicyAllowlist =
            ContainerNetworkPolicyAllowlist(
                checkRequired("allowedDomains", allowedDomains).map { it.toImmutable() },
                type,
                (domainSecrets ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContainerNetworkPolicyAllowlist = apply {
        if (validated) {
            return@apply
        }

        allowedDomains()
        _type().let {
            if (it != JsonValue.from("allowlist")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        domainSecrets().ifPresent { it.forEach { it.validate() } }
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
        (allowedDomains.asKnown().getOrNull()?.size ?: 0) +
            type.let { if (it == JsonValue.from("allowlist")) 1 else 0 } +
            (domainSecrets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContainerNetworkPolicyAllowlist &&
            allowedDomains == other.allowedDomains &&
            type == other.type &&
            domainSecrets == other.domainSecrets &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(allowedDomains, type, domainSecrets, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContainerNetworkPolicyAllowlist{allowedDomains=$allowedDomains, type=$type, domainSecrets=$domainSecrets, additionalProperties=$additionalProperties}"
}
