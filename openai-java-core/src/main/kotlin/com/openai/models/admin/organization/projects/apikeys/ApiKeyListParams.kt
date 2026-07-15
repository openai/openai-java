// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Returns a list of API keys in the project. */
class ApiKeyListParams
private constructor(
    private val projectId: String?,
    private val after: String?,
    private val limit: Long?,
    private val ownerProjectAccess: OwnerProjectAccess?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun projectId(): Optional<String> = Optional.ofNullable(projectId)

    /**
     * A cursor for use in pagination. `after` is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo, your
     * subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /**
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the
     * default is 20.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /**
     * Filter API keys by whether the owner currently has effective access to the project. Use
     * `active` for owners with access, `inactive` for owners without access, or `any` for all
     * enabled project API keys. If omitted, the endpoint applies its existing membership-based
     * visibility rules, which may exclude some enabled keys.
     */
    fun ownerProjectAccess(): Optional<OwnerProjectAccess> = Optional.ofNullable(ownerProjectAccess)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ApiKeyListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ApiKeyListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiKeyListParams]. */
    class Builder internal constructor() {

        private var projectId: String? = null
        private var after: String? = null
        private var limit: Long? = null
        private var ownerProjectAccess: OwnerProjectAccess? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(apiKeyListParams: ApiKeyListParams) = apply {
            projectId = apiKeyListParams.projectId
            after = apiKeyListParams.after
            limit = apiKeyListParams.limit
            ownerProjectAccess = apiKeyListParams.ownerProjectAccess
            additionalHeaders = apiKeyListParams.additionalHeaders.toBuilder()
            additionalQueryParams = apiKeyListParams.additionalQueryParams.toBuilder()
        }

        fun projectId(projectId: String?) = apply { this.projectId = projectId }

        /** Alias for calling [Builder.projectId] with `projectId.orElse(null)`. */
        fun projectId(projectId: Optional<String>) = projectId(projectId.getOrNull())

        /**
         * A cursor for use in pagination. `after` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, ending with
         * obj_foo, your subsequent call can include after=obj_foo in order to fetch the next page
         * of the list.
         */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /**
         * A limit on the number of objects to be returned. Limit can range between 1 and 100, and
         * the default is 20.
         */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /**
         * Filter API keys by whether the owner currently has effective access to the project. Use
         * `active` for owners with access, `inactive` for owners without access, or `any` for all
         * enabled project API keys. If omitted, the endpoint applies its existing membership-based
         * visibility rules, which may exclude some enabled keys.
         */
        fun ownerProjectAccess(ownerProjectAccess: OwnerProjectAccess?) = apply {
            this.ownerProjectAccess = ownerProjectAccess
        }

        /**
         * Alias for calling [Builder.ownerProjectAccess] with `ownerProjectAccess.orElse(null)`.
         */
        fun ownerProjectAccess(ownerProjectAccess: Optional<OwnerProjectAccess>) =
            ownerProjectAccess(ownerProjectAccess.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ApiKeyListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ApiKeyListParams =
            ApiKeyListParams(
                projectId,
                after,
                limit,
                ownerProjectAccess,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> projectId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                limit?.let { put("limit", it.toString()) }
                ownerProjectAccess?.let { put("owner_project_access", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Filter API keys by whether the owner currently has effective access to the project. Use
     * `active` for owners with access, `inactive` for owners without access, or `any` for all
     * enabled project API keys. If omitted, the endpoint applies its existing membership-based
     * visibility rules, which may exclude some enabled keys.
     */
    class OwnerProjectAccess
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ACTIVE = of("active")

            @JvmField val INACTIVE = of("inactive")

            @JvmField val ANY = of("any")

            @JvmStatic fun of(value: String) = OwnerProjectAccess(JsonField.of(value))
        }

        /** An enum containing [OwnerProjectAccess]'s known values. */
        enum class Known {
            ACTIVE,
            INACTIVE,
            ANY,
        }

        /**
         * An enum containing [OwnerProjectAccess]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OwnerProjectAccess] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACTIVE,
            INACTIVE,
            ANY,
            /**
             * An enum member indicating that [OwnerProjectAccess] was instantiated with an unknown
             * value.
             */
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
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
                ANY -> Value.ANY
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
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                ANY -> Known.ANY
                else -> throw OpenAIInvalidDataException("Unknown OwnerProjectAccess: $value")
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
        fun validate(): OwnerProjectAccess = apply {
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

            return other is OwnerProjectAccess && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiKeyListParams &&
            projectId == other.projectId &&
            after == other.after &&
            limit == other.limit &&
            ownerProjectAccess == other.ownerProjectAccess &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            projectId,
            after,
            limit,
            ownerProjectAccess,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ApiKeyListParams{projectId=$projectId, after=$after, limit=$limit, ownerProjectAccess=$ownerProjectAccess, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
