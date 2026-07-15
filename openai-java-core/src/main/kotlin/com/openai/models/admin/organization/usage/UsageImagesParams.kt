// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get images usage details for the organization. */
class UsageImagesParams
private constructor(
    private val startTime: Long,
    private val apiKeyIds: List<String>?,
    private val bucketWidth: BucketWidth?,
    private val endTime: Long?,
    private val groupBy: List<GroupBy>?,
    private val limit: Long?,
    private val models: List<String>?,
    private val page: String?,
    private val projectIds: List<String>?,
    private val sizes: List<Size>?,
    private val sources: List<Source>?,
    private val userIds: List<String>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Start time (Unix seconds) of the query time range, inclusive. */
    fun startTime(): Long = startTime

    /** Return only usage for these API keys. */
    fun apiKeyIds(): Optional<List<String>> = Optional.ofNullable(apiKeyIds)

    /**
     * Width of each time bucket in response. Currently `1m`, `1h` and `1d` are supported, default
     * to `1d`.
     */
    fun bucketWidth(): Optional<BucketWidth> = Optional.ofNullable(bucketWidth)

    /** End time (Unix seconds) of the query time range, exclusive. */
    fun endTime(): Optional<Long> = Optional.ofNullable(endTime)

    /**
     * Group the usage data by the specified fields. Support fields include `project_id`, `user_id`,
     * `api_key_id`, `model`, `size`, `source` or any combination of them.
     */
    fun groupBy(): Optional<List<GroupBy>> = Optional.ofNullable(groupBy)

    /**
     * Specifies the number of buckets to return.
     * - `bucket_width=1d`: default: 7, max: 31
     * - `bucket_width=1h`: default: 24, max: 168
     * - `bucket_width=1m`: default: 60, max: 1440
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Return only usage for these models. */
    fun models(): Optional<List<String>> = Optional.ofNullable(models)

    /**
     * A cursor for use in pagination. Corresponding to the `next_page` field from the previous
     * response.
     */
    fun page(): Optional<String> = Optional.ofNullable(page)

    /** Return only usage for these projects. */
    fun projectIds(): Optional<List<String>> = Optional.ofNullable(projectIds)

    /**
     * Return only usages for these image sizes. Possible values are `256x256`, `512x512`,
     * `1024x1024`, `1792x1792`, `1024x1792` or any combination of them.
     */
    fun sizes(): Optional<List<Size>> = Optional.ofNullable(sizes)

    /**
     * Return only usages for these sources. Possible values are `image.generation`, `image.edit`,
     * `image.variation` or any combination of them.
     */
    fun sources(): Optional<List<Source>> = Optional.ofNullable(sources)

    /** Return only usage for these users. */
    fun userIds(): Optional<List<String>> = Optional.ofNullable(userIds)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UsageImagesParams].
         *
         * The following fields are required:
         * ```java
         * .startTime()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageImagesParams]. */
    class Builder internal constructor() {

        private var startTime: Long? = null
        private var apiKeyIds: MutableList<String>? = null
        private var bucketWidth: BucketWidth? = null
        private var endTime: Long? = null
        private var groupBy: MutableList<GroupBy>? = null
        private var limit: Long? = null
        private var models: MutableList<String>? = null
        private var page: String? = null
        private var projectIds: MutableList<String>? = null
        private var sizes: MutableList<Size>? = null
        private var sources: MutableList<Source>? = null
        private var userIds: MutableList<String>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(usageImagesParams: UsageImagesParams) = apply {
            startTime = usageImagesParams.startTime
            apiKeyIds = usageImagesParams.apiKeyIds?.toMutableList()
            bucketWidth = usageImagesParams.bucketWidth
            endTime = usageImagesParams.endTime
            groupBy = usageImagesParams.groupBy?.toMutableList()
            limit = usageImagesParams.limit
            models = usageImagesParams.models?.toMutableList()
            page = usageImagesParams.page
            projectIds = usageImagesParams.projectIds?.toMutableList()
            sizes = usageImagesParams.sizes?.toMutableList()
            sources = usageImagesParams.sources?.toMutableList()
            userIds = usageImagesParams.userIds?.toMutableList()
            additionalHeaders = usageImagesParams.additionalHeaders.toBuilder()
            additionalQueryParams = usageImagesParams.additionalQueryParams.toBuilder()
        }

        /** Start time (Unix seconds) of the query time range, inclusive. */
        fun startTime(startTime: Long) = apply { this.startTime = startTime }

        /** Return only usage for these API keys. */
        fun apiKeyIds(apiKeyIds: List<String>?) = apply {
            this.apiKeyIds = apiKeyIds?.toMutableList()
        }

        /** Alias for calling [Builder.apiKeyIds] with `apiKeyIds.orElse(null)`. */
        fun apiKeyIds(apiKeyIds: Optional<List<String>>) = apiKeyIds(apiKeyIds.getOrNull())

        /**
         * Adds a single [String] to [apiKeyIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addApiKeyId(apiKeyId: String) = apply {
            apiKeyIds = (apiKeyIds ?: mutableListOf()).apply { add(apiKeyId) }
        }

        /**
         * Width of each time bucket in response. Currently `1m`, `1h` and `1d` are supported,
         * default to `1d`.
         */
        fun bucketWidth(bucketWidth: BucketWidth?) = apply { this.bucketWidth = bucketWidth }

        /** Alias for calling [Builder.bucketWidth] with `bucketWidth.orElse(null)`. */
        fun bucketWidth(bucketWidth: Optional<BucketWidth>) = bucketWidth(bucketWidth.getOrNull())

        /** End time (Unix seconds) of the query time range, exclusive. */
        fun endTime(endTime: Long?) = apply { this.endTime = endTime }

        /**
         * Alias for [Builder.endTime].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun endTime(endTime: Long) = endTime(endTime as Long?)

        /** Alias for calling [Builder.endTime] with `endTime.orElse(null)`. */
        fun endTime(endTime: Optional<Long>) = endTime(endTime.getOrNull())

        /**
         * Group the usage data by the specified fields. Support fields include `project_id`,
         * `user_id`, `api_key_id`, `model`, `size`, `source` or any combination of them.
         */
        fun groupBy(groupBy: List<GroupBy>?) = apply { this.groupBy = groupBy?.toMutableList() }

        /** Alias for calling [Builder.groupBy] with `groupBy.orElse(null)`. */
        fun groupBy(groupBy: Optional<List<GroupBy>>) = groupBy(groupBy.getOrNull())

        /**
         * Adds a single [GroupBy] to [Builder.groupBy].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addGroupBy(groupBy: GroupBy) = apply {
            this.groupBy = (this.groupBy ?: mutableListOf()).apply { add(groupBy) }
        }

        /**
         * Specifies the number of buckets to return.
         * - `bucket_width=1d`: default: 7, max: 31
         * - `bucket_width=1h`: default: 24, max: 168
         * - `bucket_width=1m`: default: 60, max: 1440
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

        /** Return only usage for these models. */
        fun models(models: List<String>?) = apply { this.models = models?.toMutableList() }

        /** Alias for calling [Builder.models] with `models.orElse(null)`. */
        fun models(models: Optional<List<String>>) = models(models.getOrNull())

        /**
         * Adds a single [String] to [models].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addModel(model: String) = apply {
            models = (models ?: mutableListOf()).apply { add(model) }
        }

        /**
         * A cursor for use in pagination. Corresponding to the `next_page` field from the previous
         * response.
         */
        fun page(page: String?) = apply { this.page = page }

        /** Alias for calling [Builder.page] with `page.orElse(null)`. */
        fun page(page: Optional<String>) = page(page.getOrNull())

        /** Return only usage for these projects. */
        fun projectIds(projectIds: List<String>?) = apply {
            this.projectIds = projectIds?.toMutableList()
        }

        /** Alias for calling [Builder.projectIds] with `projectIds.orElse(null)`. */
        fun projectIds(projectIds: Optional<List<String>>) = projectIds(projectIds.getOrNull())

        /**
         * Adds a single [String] to [projectIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addProjectId(projectId: String) = apply {
            projectIds = (projectIds ?: mutableListOf()).apply { add(projectId) }
        }

        /**
         * Return only usages for these image sizes. Possible values are `256x256`, `512x512`,
         * `1024x1024`, `1792x1792`, `1024x1792` or any combination of them.
         */
        fun sizes(sizes: List<Size>?) = apply { this.sizes = sizes?.toMutableList() }

        /** Alias for calling [Builder.sizes] with `sizes.orElse(null)`. */
        fun sizes(sizes: Optional<List<Size>>) = sizes(sizes.getOrNull())

        /**
         * Adds a single [Size] to [sizes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSize(size: Size) = apply { sizes = (sizes ?: mutableListOf()).apply { add(size) } }

        /**
         * Return only usages for these sources. Possible values are `image.generation`,
         * `image.edit`, `image.variation` or any combination of them.
         */
        fun sources(sources: List<Source>?) = apply { this.sources = sources?.toMutableList() }

        /** Alias for calling [Builder.sources] with `sources.orElse(null)`. */
        fun sources(sources: Optional<List<Source>>) = sources(sources.getOrNull())

        /**
         * Adds a single [Source] to [sources].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSource(source: Source) = apply {
            sources = (sources ?: mutableListOf()).apply { add(source) }
        }

        /** Return only usage for these users. */
        fun userIds(userIds: List<String>?) = apply { this.userIds = userIds?.toMutableList() }

        /** Alias for calling [Builder.userIds] with `userIds.orElse(null)`. */
        fun userIds(userIds: Optional<List<String>>) = userIds(userIds.getOrNull())

        /**
         * Adds a single [String] to [userIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUserId(userId: String) = apply {
            userIds = (userIds ?: mutableListOf()).apply { add(userId) }
        }

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
         * Returns an immutable instance of [UsageImagesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .startTime()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsageImagesParams =
            UsageImagesParams(
                checkRequired("startTime", startTime),
                apiKeyIds?.toImmutable(),
                bucketWidth,
                endTime,
                groupBy?.toImmutable(),
                limit,
                models?.toImmutable(),
                page,
                projectIds?.toImmutable(),
                sizes?.toImmutable(),
                sources?.toImmutable(),
                userIds?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("start_time", startTime.toString())
                apiKeyIds?.forEach { put("api_key_ids[]", it) }
                bucketWidth?.let { put("bucket_width", it.toString()) }
                endTime?.let { put("end_time", it.toString()) }
                groupBy?.forEach { put("group_by[]", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                models?.forEach { put("models[]", it) }
                page?.let { put("page", it) }
                projectIds?.forEach { put("project_ids[]", it) }
                sizes?.forEach { put("sizes[]", it.toString()) }
                sources?.forEach { put("sources[]", it.toString()) }
                userIds?.forEach { put("user_ids[]", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Width of each time bucket in response. Currently `1m`, `1h` and `1d` are supported, default
     * to `1d`.
     */
    class BucketWidth @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val _1M = of("1m")

            @JvmField val _1H = of("1h")

            @JvmField val _1D = of("1d")

            @JvmStatic fun of(value: String) = BucketWidth(JsonField.of(value))
        }

        /** An enum containing [BucketWidth]'s known values. */
        enum class Known {
            _1M,
            _1H,
            _1D,
        }

        /**
         * An enum containing [BucketWidth]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [BucketWidth] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _1M,
            _1H,
            _1D,
            /**
             * An enum member indicating that [BucketWidth] was instantiated with an unknown value.
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
                _1M -> Value._1M
                _1H -> Value._1H
                _1D -> Value._1D
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
                _1M -> Known._1M
                _1H -> Known._1H
                _1D -> Known._1D
                else -> throw OpenAIInvalidDataException("Unknown BucketWidth: $value")
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
        fun validate(): BucketWidth = apply {
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

            return other is BucketWidth && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class GroupBy @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PROJECT_ID = of("project_id")

            @JvmField val USER_ID = of("user_id")

            @JvmField val API_KEY_ID = of("api_key_id")

            @JvmField val MODEL = of("model")

            @JvmField val SIZE = of("size")

            @JvmField val SOURCE = of("source")

            @JvmStatic fun of(value: String) = GroupBy(JsonField.of(value))
        }

        /** An enum containing [GroupBy]'s known values. */
        enum class Known {
            PROJECT_ID,
            USER_ID,
            API_KEY_ID,
            MODEL,
            SIZE,
            SOURCE,
        }

        /**
         * An enum containing [GroupBy]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [GroupBy] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PROJECT_ID,
            USER_ID,
            API_KEY_ID,
            MODEL,
            SIZE,
            SOURCE,
            /** An enum member indicating that [GroupBy] was instantiated with an unknown value. */
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
                PROJECT_ID -> Value.PROJECT_ID
                USER_ID -> Value.USER_ID
                API_KEY_ID -> Value.API_KEY_ID
                MODEL -> Value.MODEL
                SIZE -> Value.SIZE
                SOURCE -> Value.SOURCE
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
                PROJECT_ID -> Known.PROJECT_ID
                USER_ID -> Known.USER_ID
                API_KEY_ID -> Known.API_KEY_ID
                MODEL -> Known.MODEL
                SIZE -> Known.SIZE
                SOURCE -> Known.SOURCE
                else -> throw OpenAIInvalidDataException("Unknown GroupBy: $value")
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
        fun validate(): GroupBy = apply {
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

            return other is GroupBy && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Size @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val _256X256 = of("256x256")

            @JvmField val _512X512 = of("512x512")

            @JvmField val _1024X1024 = of("1024x1024")

            @JvmField val _1792X1792 = of("1792x1792")

            @JvmField val _1024X1792 = of("1024x1792")

            @JvmStatic fun of(value: String) = Size(JsonField.of(value))
        }

        /** An enum containing [Size]'s known values. */
        enum class Known {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1792,
            _1024X1792,
        }

        /**
         * An enum containing [Size]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Size] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _256X256,
            _512X512,
            _1024X1024,
            _1792X1792,
            _1024X1792,
            /** An enum member indicating that [Size] was instantiated with an unknown value. */
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
                _256X256 -> Value._256X256
                _512X512 -> Value._512X512
                _1024X1024 -> Value._1024X1024
                _1792X1792 -> Value._1792X1792
                _1024X1792 -> Value._1024X1792
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
                _256X256 -> Known._256X256
                _512X512 -> Known._512X512
                _1024X1024 -> Known._1024X1024
                _1792X1792 -> Known._1792X1792
                _1024X1792 -> Known._1024X1792
                else -> throw OpenAIInvalidDataException("Unknown Size: $value")
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
        fun validate(): Size = apply {
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

            return other is Size && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Source @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val IMAGE_GENERATION = of("image.generation")

            @JvmField val IMAGE_EDIT = of("image.edit")

            @JvmField val IMAGE_VARIATION = of("image.variation")

            @JvmStatic fun of(value: String) = Source(JsonField.of(value))
        }

        /** An enum containing [Source]'s known values. */
        enum class Known {
            IMAGE_GENERATION,
            IMAGE_EDIT,
            IMAGE_VARIATION,
        }

        /**
         * An enum containing [Source]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Source] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IMAGE_GENERATION,
            IMAGE_EDIT,
            IMAGE_VARIATION,
            /** An enum member indicating that [Source] was instantiated with an unknown value. */
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
                IMAGE_GENERATION -> Value.IMAGE_GENERATION
                IMAGE_EDIT -> Value.IMAGE_EDIT
                IMAGE_VARIATION -> Value.IMAGE_VARIATION
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
                IMAGE_GENERATION -> Known.IMAGE_GENERATION
                IMAGE_EDIT -> Known.IMAGE_EDIT
                IMAGE_VARIATION -> Known.IMAGE_VARIATION
                else -> throw OpenAIInvalidDataException("Unknown Source: $value")
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
        fun validate(): Source = apply {
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

            return other is Source && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageImagesParams &&
            startTime == other.startTime &&
            apiKeyIds == other.apiKeyIds &&
            bucketWidth == other.bucketWidth &&
            endTime == other.endTime &&
            groupBy == other.groupBy &&
            limit == other.limit &&
            models == other.models &&
            page == other.page &&
            projectIds == other.projectIds &&
            sizes == other.sizes &&
            sources == other.sources &&
            userIds == other.userIds &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            startTime,
            apiKeyIds,
            bucketWidth,
            endTime,
            groupBy,
            limit,
            models,
            page,
            projectIds,
            sizes,
            sources,
            userIds,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "UsageImagesParams{startTime=$startTime, apiKeyIds=$apiKeyIds, bucketWidth=$bucketWidth, endTime=$endTime, groupBy=$groupBy, limit=$limit, models=$models, page=$page, projectIds=$projectIds, sizes=$sizes, sources=$sources, userIds=$userIds, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
