// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.auditlogs

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** List user actions and configuration changes within this organization. */
class AuditLogListParams
private constructor(
    private val actorEmails: List<String>?,
    private val actorIds: List<String>?,
    private val after: String?,
    private val before: String?,
    private val effectiveAt: EffectiveAt?,
    private val eventTypes: List<EventType>?,
    private val limit: Long?,
    private val projectIds: List<String>?,
    private val resourceIds: List<String>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Return only events performed by users with these emails. */
    fun actorEmails(): Optional<List<String>> = Optional.ofNullable(actorEmails)

    /**
     * Return only events performed by these actors. Can be a user ID, a service account ID, or an
     * api key tracking ID.
     */
    fun actorIds(): Optional<List<String>> = Optional.ofNullable(actorIds)

    /**
     * A cursor for use in pagination. `after` is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo, your
     * subsequent call can include after=obj_foo in order to fetch the next page of the list.
     */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /**
     * A cursor for use in pagination. `before` is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, starting with obj_foo, your
     * subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Return only events whose `effective_at` (Unix seconds) is in this range. */
    fun effectiveAt(): Optional<EffectiveAt> = Optional.ofNullable(effectiveAt)

    /**
     * Return only events with a `type` in one of these values. For example, `project.created`. For
     * all options, see the documentation for the
     * [audit log object](https://platform.openai.com/docs/api-reference/audit-logs/object).
     */
    fun eventTypes(): Optional<List<EventType>> = Optional.ofNullable(eventTypes)

    /**
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the
     * default is 20.
     */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Return only events for these projects. */
    fun projectIds(): Optional<List<String>> = Optional.ofNullable(projectIds)

    /** Return only events performed on these targets. For example, a project ID updated. */
    fun resourceIds(): Optional<List<String>> = Optional.ofNullable(resourceIds)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): AuditLogListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [AuditLogListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AuditLogListParams]. */
    class Builder internal constructor() {

        private var actorEmails: MutableList<String>? = null
        private var actorIds: MutableList<String>? = null
        private var after: String? = null
        private var before: String? = null
        private var effectiveAt: EffectiveAt? = null
        private var eventTypes: MutableList<EventType>? = null
        private var limit: Long? = null
        private var projectIds: MutableList<String>? = null
        private var resourceIds: MutableList<String>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(auditLogListParams: AuditLogListParams) = apply {
            actorEmails = auditLogListParams.actorEmails?.toMutableList()
            actorIds = auditLogListParams.actorIds?.toMutableList()
            after = auditLogListParams.after
            before = auditLogListParams.before
            effectiveAt = auditLogListParams.effectiveAt
            eventTypes = auditLogListParams.eventTypes?.toMutableList()
            limit = auditLogListParams.limit
            projectIds = auditLogListParams.projectIds?.toMutableList()
            resourceIds = auditLogListParams.resourceIds?.toMutableList()
            additionalHeaders = auditLogListParams.additionalHeaders.toBuilder()
            additionalQueryParams = auditLogListParams.additionalQueryParams.toBuilder()
        }

        /** Return only events performed by users with these emails. */
        fun actorEmails(actorEmails: List<String>?) = apply {
            this.actorEmails = actorEmails?.toMutableList()
        }

        /** Alias for calling [Builder.actorEmails] with `actorEmails.orElse(null)`. */
        fun actorEmails(actorEmails: Optional<List<String>>) = actorEmails(actorEmails.getOrNull())

        /**
         * Adds a single [String] to [actorEmails].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addActorEmail(actorEmail: String) = apply {
            actorEmails = (actorEmails ?: mutableListOf()).apply { add(actorEmail) }
        }

        /**
         * Return only events performed by these actors. Can be a user ID, a service account ID, or
         * an api key tracking ID.
         */
        fun actorIds(actorIds: List<String>?) = apply { this.actorIds = actorIds?.toMutableList() }

        /** Alias for calling [Builder.actorIds] with `actorIds.orElse(null)`. */
        fun actorIds(actorIds: Optional<List<String>>) = actorIds(actorIds.getOrNull())

        /**
         * Adds a single [String] to [actorIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addActorId(actorId: String) = apply {
            actorIds = (actorIds ?: mutableListOf()).apply { add(actorId) }
        }

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
         * A cursor for use in pagination. `before` is an object ID that defines your place in the
         * list. For instance, if you make a list request and receive 100 objects, starting with
         * obj_foo, your subsequent call can include before=obj_foo in order to fetch the previous
         * page of the list.
         */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Return only events whose `effective_at` (Unix seconds) is in this range. */
        fun effectiveAt(effectiveAt: EffectiveAt?) = apply { this.effectiveAt = effectiveAt }

        /** Alias for calling [Builder.effectiveAt] with `effectiveAt.orElse(null)`. */
        fun effectiveAt(effectiveAt: Optional<EffectiveAt>) = effectiveAt(effectiveAt.getOrNull())

        /**
         * Return only events with a `type` in one of these values. For example, `project.created`.
         * For all options, see the documentation for the
         * [audit log object](https://platform.openai.com/docs/api-reference/audit-logs/object).
         */
        fun eventTypes(eventTypes: List<EventType>?) = apply {
            this.eventTypes = eventTypes?.toMutableList()
        }

        /** Alias for calling [Builder.eventTypes] with `eventTypes.orElse(null)`. */
        fun eventTypes(eventTypes: Optional<List<EventType>>) = eventTypes(eventTypes.getOrNull())

        /**
         * Adds a single [EventType] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: EventType) = apply {
            eventTypes = (eventTypes ?: mutableListOf()).apply { add(eventType) }
        }

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

        /** Return only events for these projects. */
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

        /** Return only events performed on these targets. For example, a project ID updated. */
        fun resourceIds(resourceIds: List<String>?) = apply {
            this.resourceIds = resourceIds?.toMutableList()
        }

        /** Alias for calling [Builder.resourceIds] with `resourceIds.orElse(null)`. */
        fun resourceIds(resourceIds: Optional<List<String>>) = resourceIds(resourceIds.getOrNull())

        /**
         * Adds a single [String] to [resourceIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResourceId(resourceId: String) = apply {
            resourceIds = (resourceIds ?: mutableListOf()).apply { add(resourceId) }
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
         * Returns an immutable instance of [AuditLogListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AuditLogListParams =
            AuditLogListParams(
                actorEmails?.toImmutable(),
                actorIds?.toImmutable(),
                after,
                before,
                effectiveAt,
                eventTypes?.toImmutable(),
                limit,
                projectIds?.toImmutable(),
                resourceIds?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                actorEmails?.forEach { put("actor_emails[]", it) }
                actorIds?.forEach { put("actor_ids[]", it) }
                after?.let { put("after", it) }
                before?.let { put("before", it) }
                effectiveAt?.let {
                    it.gt().ifPresent { put("effective_at[gt]", it.toString()) }
                    it.gte().ifPresent { put("effective_at[gte]", it.toString()) }
                    it.lt().ifPresent { put("effective_at[lt]", it.toString()) }
                    it.lte().ifPresent { put("effective_at[lte]", it.toString()) }
                    it._additionalProperties().keys().forEach { key ->
                        it._additionalProperties().values(key).forEach { value ->
                            put("effective_at[$key]", value)
                        }
                    }
                }
                eventTypes?.forEach { put("event_types[]", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                projectIds?.forEach { put("project_ids[]", it) }
                resourceIds?.forEach { put("resource_ids[]", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Return only events whose `effective_at` (Unix seconds) is in this range. */
    class EffectiveAt
    private constructor(
        private val gt: Long?,
        private val gte: Long?,
        private val lt: Long?,
        private val lte: Long?,
        private val additionalProperties: QueryParams,
    ) {

        /** Return only events whose `effective_at` (Unix seconds) is greater than this value. */
        fun gt(): Optional<Long> = Optional.ofNullable(gt)

        /**
         * Return only events whose `effective_at` (Unix seconds) is greater than or equal to this
         * value.
         */
        fun gte(): Optional<Long> = Optional.ofNullable(gte)

        /** Return only events whose `effective_at` (Unix seconds) is less than this value. */
        fun lt(): Optional<Long> = Optional.ofNullable(lt)

        /**
         * Return only events whose `effective_at` (Unix seconds) is less than or equal to this
         * value.
         */
        fun lte(): Optional<Long> = Optional.ofNullable(lte)

        /** Query params to send with the request. */
        fun _additionalProperties(): QueryParams = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [EffectiveAt]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EffectiveAt]. */
        class Builder internal constructor() {

            private var gt: Long? = null
            private var gte: Long? = null
            private var lt: Long? = null
            private var lte: Long? = null
            private var additionalProperties: QueryParams.Builder = QueryParams.builder()

            @JvmSynthetic
            internal fun from(effectiveAt: EffectiveAt) = apply {
                gt = effectiveAt.gt
                gte = effectiveAt.gte
                lt = effectiveAt.lt
                lte = effectiveAt.lte
                additionalProperties = effectiveAt.additionalProperties.toBuilder()
            }

            /**
             * Return only events whose `effective_at` (Unix seconds) is greater than this value.
             */
            fun gt(gt: Long?) = apply { this.gt = gt }

            /**
             * Alias for [Builder.gt].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun gt(gt: Long) = gt(gt as Long?)

            /** Alias for calling [Builder.gt] with `gt.orElse(null)`. */
            fun gt(gt: Optional<Long>) = gt(gt.getOrNull())

            /**
             * Return only events whose `effective_at` (Unix seconds) is greater than or equal to
             * this value.
             */
            fun gte(gte: Long?) = apply { this.gte = gte }

            /**
             * Alias for [Builder.gte].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun gte(gte: Long) = gte(gte as Long?)

            /** Alias for calling [Builder.gte] with `gte.orElse(null)`. */
            fun gte(gte: Optional<Long>) = gte(gte.getOrNull())

            /** Return only events whose `effective_at` (Unix seconds) is less than this value. */
            fun lt(lt: Long?) = apply { this.lt = lt }

            /**
             * Alias for [Builder.lt].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun lt(lt: Long) = lt(lt as Long?)

            /** Alias for calling [Builder.lt] with `lt.orElse(null)`. */
            fun lt(lt: Optional<Long>) = lt(lt.getOrNull())

            /**
             * Return only events whose `effective_at` (Unix seconds) is less than or equal to this
             * value.
             */
            fun lte(lte: Long?) = apply { this.lte = lte }

            /**
             * Alias for [Builder.lte].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun lte(lte: Long) = lte(lte as Long?)

            /** Alias for calling [Builder.lte] with `lte.orElse(null)`. */
            fun lte(lte: Optional<Long>) = lte(lte.getOrNull())

            fun additionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, Iterable<String>>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: String) = apply {
                additionalProperties.put(key, value)
            }

            fun putAdditionalProperties(key: String, values: Iterable<String>) = apply {
                additionalProperties.put(key, values)
            }

            fun putAllAdditionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, Iterable<String>>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun replaceAdditionalProperties(key: String, value: String) = apply {
                additionalProperties.replace(key, value)
            }

            fun replaceAdditionalProperties(key: String, values: Iterable<String>) = apply {
                additionalProperties.replace(key, values)
            }

            fun replaceAllAdditionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.replaceAll(additionalProperties)
            }

            fun replaceAllAdditionalProperties(
                additionalProperties: Map<String, Iterable<String>>
            ) = apply { this.additionalProperties.replaceAll(additionalProperties) }

            fun removeAdditionalProperties(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                additionalProperties.removeAll(keys)
            }

            /**
             * Returns an immutable instance of [EffectiveAt].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): EffectiveAt = EffectiveAt(gt, gte, lt, lte, additionalProperties.build())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EffectiveAt &&
                gt == other.gt &&
                gte == other.gte &&
                lt == other.lt &&
                lte == other.lte &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(gt, gte, lt, lte, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "EffectiveAt{gt=$gt, gte=$gte, lt=$lt, lte=$lte, additionalProperties=$additionalProperties}"
    }

    /** The event type. */
    class EventType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val API_KEY_CREATED = of("api_key.created")

            @JvmField val API_KEY_UPDATED = of("api_key.updated")

            @JvmField val API_KEY_DELETED = of("api_key.deleted")

            @JvmField val CERTIFICATE_CREATED = of("certificate.created")

            @JvmField val CERTIFICATE_UPDATED = of("certificate.updated")

            @JvmField val CERTIFICATE_DELETED = of("certificate.deleted")

            @JvmField val CERTIFICATES_ACTIVATED = of("certificates.activated")

            @JvmField val CERTIFICATES_DEACTIVATED = of("certificates.deactivated")

            @JvmField val CHECKPOINT_PERMISSION_CREATED = of("checkpoint.permission.created")

            @JvmField val CHECKPOINT_PERMISSION_DELETED = of("checkpoint.permission.deleted")

            @JvmField val EXTERNAL_KEY_REGISTERED = of("external_key.registered")

            @JvmField val EXTERNAL_KEY_REMOVED = of("external_key.removed")

            @JvmField val GROUP_CREATED = of("group.created")

            @JvmField val GROUP_UPDATED = of("group.updated")

            @JvmField val GROUP_DELETED = of("group.deleted")

            @JvmField val INVITE_SENT = of("invite.sent")

            @JvmField val INVITE_ACCEPTED = of("invite.accepted")

            @JvmField val INVITE_DELETED = of("invite.deleted")

            @JvmField val IP_ALLOWLIST_CREATED = of("ip_allowlist.created")

            @JvmField val IP_ALLOWLIST_UPDATED = of("ip_allowlist.updated")

            @JvmField val IP_ALLOWLIST_DELETED = of("ip_allowlist.deleted")

            @JvmField val IP_ALLOWLIST_CONFIG_ACTIVATED = of("ip_allowlist.config.activated")

            @JvmField val IP_ALLOWLIST_CONFIG_DEACTIVATED = of("ip_allowlist.config.deactivated")

            @JvmField val LOGIN_SUCCEEDED = of("login.succeeded")

            @JvmField val LOGIN_FAILED = of("login.failed")

            @JvmField val LOGOUT_SUCCEEDED = of("logout.succeeded")

            @JvmField val LOGOUT_FAILED = of("logout.failed")

            @JvmField val ORGANIZATION_UPDATED = of("organization.updated")

            @JvmField val PROJECT_CREATED = of("project.created")

            @JvmField val PROJECT_UPDATED = of("project.updated")

            @JvmField val PROJECT_ARCHIVED = of("project.archived")

            @JvmField val PROJECT_DELETED = of("project.deleted")

            @JvmField val RATE_LIMIT_UPDATED = of("rate_limit.updated")

            @JvmField val RATE_LIMIT_DELETED = of("rate_limit.deleted")

            @JvmField val RESOURCE_DELETED = of("resource.deleted")

            @JvmField val TUNNEL_CREATED = of("tunnel.created")

            @JvmField val TUNNEL_UPDATED = of("tunnel.updated")

            @JvmField val TUNNEL_DELETED = of("tunnel.deleted")

            @JvmField val ROLE_CREATED = of("role.created")

            @JvmField val ROLE_UPDATED = of("role.updated")

            @JvmField val ROLE_DELETED = of("role.deleted")

            @JvmField val ROLE_ASSIGNMENT_CREATED = of("role.assignment.created")

            @JvmField val ROLE_ASSIGNMENT_DELETED = of("role.assignment.deleted")

            @JvmField val SCIM_ENABLED = of("scim.enabled")

            @JvmField val SCIM_DISABLED = of("scim.disabled")

            @JvmField val SERVICE_ACCOUNT_CREATED = of("service_account.created")

            @JvmField val SERVICE_ACCOUNT_UPDATED = of("service_account.updated")

            @JvmField val SERVICE_ACCOUNT_DELETED = of("service_account.deleted")

            @JvmField val USER_ADDED = of("user.added")

            @JvmField val USER_UPDATED = of("user.updated")

            @JvmField val USER_DELETED = of("user.deleted")

            @JvmStatic fun of(value: String) = EventType(JsonField.of(value))
        }

        /** An enum containing [EventType]'s known values. */
        enum class Known {
            API_KEY_CREATED,
            API_KEY_UPDATED,
            API_KEY_DELETED,
            CERTIFICATE_CREATED,
            CERTIFICATE_UPDATED,
            CERTIFICATE_DELETED,
            CERTIFICATES_ACTIVATED,
            CERTIFICATES_DEACTIVATED,
            CHECKPOINT_PERMISSION_CREATED,
            CHECKPOINT_PERMISSION_DELETED,
            EXTERNAL_KEY_REGISTERED,
            EXTERNAL_KEY_REMOVED,
            GROUP_CREATED,
            GROUP_UPDATED,
            GROUP_DELETED,
            INVITE_SENT,
            INVITE_ACCEPTED,
            INVITE_DELETED,
            IP_ALLOWLIST_CREATED,
            IP_ALLOWLIST_UPDATED,
            IP_ALLOWLIST_DELETED,
            IP_ALLOWLIST_CONFIG_ACTIVATED,
            IP_ALLOWLIST_CONFIG_DEACTIVATED,
            LOGIN_SUCCEEDED,
            LOGIN_FAILED,
            LOGOUT_SUCCEEDED,
            LOGOUT_FAILED,
            ORGANIZATION_UPDATED,
            PROJECT_CREATED,
            PROJECT_UPDATED,
            PROJECT_ARCHIVED,
            PROJECT_DELETED,
            RATE_LIMIT_UPDATED,
            RATE_LIMIT_DELETED,
            RESOURCE_DELETED,
            TUNNEL_CREATED,
            TUNNEL_UPDATED,
            TUNNEL_DELETED,
            ROLE_CREATED,
            ROLE_UPDATED,
            ROLE_DELETED,
            ROLE_ASSIGNMENT_CREATED,
            ROLE_ASSIGNMENT_DELETED,
            SCIM_ENABLED,
            SCIM_DISABLED,
            SERVICE_ACCOUNT_CREATED,
            SERVICE_ACCOUNT_UPDATED,
            SERVICE_ACCOUNT_DELETED,
            USER_ADDED,
            USER_UPDATED,
            USER_DELETED,
        }

        /**
         * An enum containing [EventType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EventType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            API_KEY_CREATED,
            API_KEY_UPDATED,
            API_KEY_DELETED,
            CERTIFICATE_CREATED,
            CERTIFICATE_UPDATED,
            CERTIFICATE_DELETED,
            CERTIFICATES_ACTIVATED,
            CERTIFICATES_DEACTIVATED,
            CHECKPOINT_PERMISSION_CREATED,
            CHECKPOINT_PERMISSION_DELETED,
            EXTERNAL_KEY_REGISTERED,
            EXTERNAL_KEY_REMOVED,
            GROUP_CREATED,
            GROUP_UPDATED,
            GROUP_DELETED,
            INVITE_SENT,
            INVITE_ACCEPTED,
            INVITE_DELETED,
            IP_ALLOWLIST_CREATED,
            IP_ALLOWLIST_UPDATED,
            IP_ALLOWLIST_DELETED,
            IP_ALLOWLIST_CONFIG_ACTIVATED,
            IP_ALLOWLIST_CONFIG_DEACTIVATED,
            LOGIN_SUCCEEDED,
            LOGIN_FAILED,
            LOGOUT_SUCCEEDED,
            LOGOUT_FAILED,
            ORGANIZATION_UPDATED,
            PROJECT_CREATED,
            PROJECT_UPDATED,
            PROJECT_ARCHIVED,
            PROJECT_DELETED,
            RATE_LIMIT_UPDATED,
            RATE_LIMIT_DELETED,
            RESOURCE_DELETED,
            TUNNEL_CREATED,
            TUNNEL_UPDATED,
            TUNNEL_DELETED,
            ROLE_CREATED,
            ROLE_UPDATED,
            ROLE_DELETED,
            ROLE_ASSIGNMENT_CREATED,
            ROLE_ASSIGNMENT_DELETED,
            SCIM_ENABLED,
            SCIM_DISABLED,
            SERVICE_ACCOUNT_CREATED,
            SERVICE_ACCOUNT_UPDATED,
            SERVICE_ACCOUNT_DELETED,
            USER_ADDED,
            USER_UPDATED,
            USER_DELETED,
            /**
             * An enum member indicating that [EventType] was instantiated with an unknown value.
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
                API_KEY_CREATED -> Value.API_KEY_CREATED
                API_KEY_UPDATED -> Value.API_KEY_UPDATED
                API_KEY_DELETED -> Value.API_KEY_DELETED
                CERTIFICATE_CREATED -> Value.CERTIFICATE_CREATED
                CERTIFICATE_UPDATED -> Value.CERTIFICATE_UPDATED
                CERTIFICATE_DELETED -> Value.CERTIFICATE_DELETED
                CERTIFICATES_ACTIVATED -> Value.CERTIFICATES_ACTIVATED
                CERTIFICATES_DEACTIVATED -> Value.CERTIFICATES_DEACTIVATED
                CHECKPOINT_PERMISSION_CREATED -> Value.CHECKPOINT_PERMISSION_CREATED
                CHECKPOINT_PERMISSION_DELETED -> Value.CHECKPOINT_PERMISSION_DELETED
                EXTERNAL_KEY_REGISTERED -> Value.EXTERNAL_KEY_REGISTERED
                EXTERNAL_KEY_REMOVED -> Value.EXTERNAL_KEY_REMOVED
                GROUP_CREATED -> Value.GROUP_CREATED
                GROUP_UPDATED -> Value.GROUP_UPDATED
                GROUP_DELETED -> Value.GROUP_DELETED
                INVITE_SENT -> Value.INVITE_SENT
                INVITE_ACCEPTED -> Value.INVITE_ACCEPTED
                INVITE_DELETED -> Value.INVITE_DELETED
                IP_ALLOWLIST_CREATED -> Value.IP_ALLOWLIST_CREATED
                IP_ALLOWLIST_UPDATED -> Value.IP_ALLOWLIST_UPDATED
                IP_ALLOWLIST_DELETED -> Value.IP_ALLOWLIST_DELETED
                IP_ALLOWLIST_CONFIG_ACTIVATED -> Value.IP_ALLOWLIST_CONFIG_ACTIVATED
                IP_ALLOWLIST_CONFIG_DEACTIVATED -> Value.IP_ALLOWLIST_CONFIG_DEACTIVATED
                LOGIN_SUCCEEDED -> Value.LOGIN_SUCCEEDED
                LOGIN_FAILED -> Value.LOGIN_FAILED
                LOGOUT_SUCCEEDED -> Value.LOGOUT_SUCCEEDED
                LOGOUT_FAILED -> Value.LOGOUT_FAILED
                ORGANIZATION_UPDATED -> Value.ORGANIZATION_UPDATED
                PROJECT_CREATED -> Value.PROJECT_CREATED
                PROJECT_UPDATED -> Value.PROJECT_UPDATED
                PROJECT_ARCHIVED -> Value.PROJECT_ARCHIVED
                PROJECT_DELETED -> Value.PROJECT_DELETED
                RATE_LIMIT_UPDATED -> Value.RATE_LIMIT_UPDATED
                RATE_LIMIT_DELETED -> Value.RATE_LIMIT_DELETED
                RESOURCE_DELETED -> Value.RESOURCE_DELETED
                TUNNEL_CREATED -> Value.TUNNEL_CREATED
                TUNNEL_UPDATED -> Value.TUNNEL_UPDATED
                TUNNEL_DELETED -> Value.TUNNEL_DELETED
                ROLE_CREATED -> Value.ROLE_CREATED
                ROLE_UPDATED -> Value.ROLE_UPDATED
                ROLE_DELETED -> Value.ROLE_DELETED
                ROLE_ASSIGNMENT_CREATED -> Value.ROLE_ASSIGNMENT_CREATED
                ROLE_ASSIGNMENT_DELETED -> Value.ROLE_ASSIGNMENT_DELETED
                SCIM_ENABLED -> Value.SCIM_ENABLED
                SCIM_DISABLED -> Value.SCIM_DISABLED
                SERVICE_ACCOUNT_CREATED -> Value.SERVICE_ACCOUNT_CREATED
                SERVICE_ACCOUNT_UPDATED -> Value.SERVICE_ACCOUNT_UPDATED
                SERVICE_ACCOUNT_DELETED -> Value.SERVICE_ACCOUNT_DELETED
                USER_ADDED -> Value.USER_ADDED
                USER_UPDATED -> Value.USER_UPDATED
                USER_DELETED -> Value.USER_DELETED
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
                API_KEY_CREATED -> Known.API_KEY_CREATED
                API_KEY_UPDATED -> Known.API_KEY_UPDATED
                API_KEY_DELETED -> Known.API_KEY_DELETED
                CERTIFICATE_CREATED -> Known.CERTIFICATE_CREATED
                CERTIFICATE_UPDATED -> Known.CERTIFICATE_UPDATED
                CERTIFICATE_DELETED -> Known.CERTIFICATE_DELETED
                CERTIFICATES_ACTIVATED -> Known.CERTIFICATES_ACTIVATED
                CERTIFICATES_DEACTIVATED -> Known.CERTIFICATES_DEACTIVATED
                CHECKPOINT_PERMISSION_CREATED -> Known.CHECKPOINT_PERMISSION_CREATED
                CHECKPOINT_PERMISSION_DELETED -> Known.CHECKPOINT_PERMISSION_DELETED
                EXTERNAL_KEY_REGISTERED -> Known.EXTERNAL_KEY_REGISTERED
                EXTERNAL_KEY_REMOVED -> Known.EXTERNAL_KEY_REMOVED
                GROUP_CREATED -> Known.GROUP_CREATED
                GROUP_UPDATED -> Known.GROUP_UPDATED
                GROUP_DELETED -> Known.GROUP_DELETED
                INVITE_SENT -> Known.INVITE_SENT
                INVITE_ACCEPTED -> Known.INVITE_ACCEPTED
                INVITE_DELETED -> Known.INVITE_DELETED
                IP_ALLOWLIST_CREATED -> Known.IP_ALLOWLIST_CREATED
                IP_ALLOWLIST_UPDATED -> Known.IP_ALLOWLIST_UPDATED
                IP_ALLOWLIST_DELETED -> Known.IP_ALLOWLIST_DELETED
                IP_ALLOWLIST_CONFIG_ACTIVATED -> Known.IP_ALLOWLIST_CONFIG_ACTIVATED
                IP_ALLOWLIST_CONFIG_DEACTIVATED -> Known.IP_ALLOWLIST_CONFIG_DEACTIVATED
                LOGIN_SUCCEEDED -> Known.LOGIN_SUCCEEDED
                LOGIN_FAILED -> Known.LOGIN_FAILED
                LOGOUT_SUCCEEDED -> Known.LOGOUT_SUCCEEDED
                LOGOUT_FAILED -> Known.LOGOUT_FAILED
                ORGANIZATION_UPDATED -> Known.ORGANIZATION_UPDATED
                PROJECT_CREATED -> Known.PROJECT_CREATED
                PROJECT_UPDATED -> Known.PROJECT_UPDATED
                PROJECT_ARCHIVED -> Known.PROJECT_ARCHIVED
                PROJECT_DELETED -> Known.PROJECT_DELETED
                RATE_LIMIT_UPDATED -> Known.RATE_LIMIT_UPDATED
                RATE_LIMIT_DELETED -> Known.RATE_LIMIT_DELETED
                RESOURCE_DELETED -> Known.RESOURCE_DELETED
                TUNNEL_CREATED -> Known.TUNNEL_CREATED
                TUNNEL_UPDATED -> Known.TUNNEL_UPDATED
                TUNNEL_DELETED -> Known.TUNNEL_DELETED
                ROLE_CREATED -> Known.ROLE_CREATED
                ROLE_UPDATED -> Known.ROLE_UPDATED
                ROLE_DELETED -> Known.ROLE_DELETED
                ROLE_ASSIGNMENT_CREATED -> Known.ROLE_ASSIGNMENT_CREATED
                ROLE_ASSIGNMENT_DELETED -> Known.ROLE_ASSIGNMENT_DELETED
                SCIM_ENABLED -> Known.SCIM_ENABLED
                SCIM_DISABLED -> Known.SCIM_DISABLED
                SERVICE_ACCOUNT_CREATED -> Known.SERVICE_ACCOUNT_CREATED
                SERVICE_ACCOUNT_UPDATED -> Known.SERVICE_ACCOUNT_UPDATED
                SERVICE_ACCOUNT_DELETED -> Known.SERVICE_ACCOUNT_DELETED
                USER_ADDED -> Known.USER_ADDED
                USER_UPDATED -> Known.USER_UPDATED
                USER_DELETED -> Known.USER_DELETED
                else -> throw OpenAIInvalidDataException("Unknown EventType: $value")
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

        fun validate(): EventType = apply {
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

            return other is EventType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AuditLogListParams &&
            actorEmails == other.actorEmails &&
            actorIds == other.actorIds &&
            after == other.after &&
            before == other.before &&
            effectiveAt == other.effectiveAt &&
            eventTypes == other.eventTypes &&
            limit == other.limit &&
            projectIds == other.projectIds &&
            resourceIds == other.resourceIds &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            actorEmails,
            actorIds,
            after,
            before,
            effectiveAt,
            eventTypes,
            limit,
            projectIds,
            resourceIds,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "AuditLogListParams{actorEmails=$actorEmails, actorIds=$actorIds, after=$after, before=$before, effectiveAt=$effectiveAt, eventTypes=$eventTypes, limit=$limit, projectIds=$projectIds, resourceIds=$resourceIds, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
