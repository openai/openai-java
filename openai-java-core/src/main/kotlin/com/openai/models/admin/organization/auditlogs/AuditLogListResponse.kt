// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.auditlogs

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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

/** A log of a user action or configuration change within this organization. */
class AuditLogListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val actor: JsonField<Actor>,
    private val effectiveAt: JsonField<Long>,
    private val type: JsonField<Type>,
    private val apiKeyCreated: JsonField<ApiKeyCreated>,
    private val apiKeyDeleted: JsonField<ApiKeyDeleted>,
    private val apiKeyUpdated: JsonField<ApiKeyUpdated>,
    private val certificateCreated: JsonField<CertificateCreated>,
    private val certificateDeleted: JsonField<CertificateDeleted>,
    private val certificateUpdated: JsonField<CertificateUpdated>,
    private val certificatesActivated: JsonField<CertificatesActivated>,
    private val certificatesDeactivated: JsonField<CertificatesDeactivated>,
    private val checkpointPermissionCreated: JsonField<CheckpointPermissionCreated>,
    private val checkpointPermissionDeleted: JsonField<CheckpointPermissionDeleted>,
    private val externalKeyRegistered: JsonField<ExternalKeyRegistered>,
    private val externalKeyRemoved: JsonField<ExternalKeyRemoved>,
    private val groupCreated: JsonField<GroupCreated>,
    private val groupDeleted: JsonField<GroupDeleted>,
    private val groupUpdated: JsonField<GroupUpdated>,
    private val inviteAccepted: JsonField<InviteAccepted>,
    private val inviteDeleted: JsonField<InviteDeleted>,
    private val inviteSent: JsonField<InviteSent>,
    private val ipAllowlistConfigActivated: JsonField<IpAllowlistConfigActivated>,
    private val ipAllowlistConfigDeactivated: JsonField<IpAllowlistConfigDeactivated>,
    private val ipAllowlistCreated: JsonField<IpAllowlistCreated>,
    private val ipAllowlistDeleted: JsonField<IpAllowlistDeleted>,
    private val ipAllowlistUpdated: JsonField<IpAllowlistUpdated>,
    private val loginFailed: JsonField<LoginFailed>,
    private val loginSucceeded: JsonValue,
    private val logoutFailed: JsonField<LogoutFailed>,
    private val logoutSucceeded: JsonValue,
    private val organizationUpdated: JsonField<OrganizationUpdated>,
    private val project: JsonField<Project>,
    private val projectArchived: JsonField<ProjectArchived>,
    private val projectCreated: JsonField<ProjectCreated>,
    private val projectDeleted: JsonField<ProjectDeleted>,
    private val projectUpdated: JsonField<ProjectUpdated>,
    private val rateLimitDeleted: JsonField<RateLimitDeleted>,
    private val rateLimitUpdated: JsonField<RateLimitUpdated>,
    private val roleAssignmentCreated: JsonField<RoleAssignmentCreated>,
    private val roleAssignmentDeleted: JsonField<RoleAssignmentDeleted>,
    private val roleCreated: JsonField<RoleCreated>,
    private val roleDeleted: JsonField<RoleDeleted>,
    private val roleUpdated: JsonField<RoleUpdated>,
    private val scimDisabled: JsonField<ScimDisabled>,
    private val scimEnabled: JsonField<ScimEnabled>,
    private val serviceAccountCreated: JsonField<ServiceAccountCreated>,
    private val serviceAccountDeleted: JsonField<ServiceAccountDeleted>,
    private val serviceAccountUpdated: JsonField<ServiceAccountUpdated>,
    private val userAdded: JsonField<UserAdded>,
    private val userDeleted: JsonField<UserDeleted>,
    private val userUpdated: JsonField<UserUpdated>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("actor") @ExcludeMissing actor: JsonField<Actor> = JsonMissing.of(),
        @JsonProperty("effective_at")
        @ExcludeMissing
        effectiveAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("api_key.created")
        @ExcludeMissing
        apiKeyCreated: JsonField<ApiKeyCreated> = JsonMissing.of(),
        @JsonProperty("api_key.deleted")
        @ExcludeMissing
        apiKeyDeleted: JsonField<ApiKeyDeleted> = JsonMissing.of(),
        @JsonProperty("api_key.updated")
        @ExcludeMissing
        apiKeyUpdated: JsonField<ApiKeyUpdated> = JsonMissing.of(),
        @JsonProperty("certificate.created")
        @ExcludeMissing
        certificateCreated: JsonField<CertificateCreated> = JsonMissing.of(),
        @JsonProperty("certificate.deleted")
        @ExcludeMissing
        certificateDeleted: JsonField<CertificateDeleted> = JsonMissing.of(),
        @JsonProperty("certificate.updated")
        @ExcludeMissing
        certificateUpdated: JsonField<CertificateUpdated> = JsonMissing.of(),
        @JsonProperty("certificates.activated")
        @ExcludeMissing
        certificatesActivated: JsonField<CertificatesActivated> = JsonMissing.of(),
        @JsonProperty("certificates.deactivated")
        @ExcludeMissing
        certificatesDeactivated: JsonField<CertificatesDeactivated> = JsonMissing.of(),
        @JsonProperty("checkpoint.permission.created")
        @ExcludeMissing
        checkpointPermissionCreated: JsonField<CheckpointPermissionCreated> = JsonMissing.of(),
        @JsonProperty("checkpoint.permission.deleted")
        @ExcludeMissing
        checkpointPermissionDeleted: JsonField<CheckpointPermissionDeleted> = JsonMissing.of(),
        @JsonProperty("external_key.registered")
        @ExcludeMissing
        externalKeyRegistered: JsonField<ExternalKeyRegistered> = JsonMissing.of(),
        @JsonProperty("external_key.removed")
        @ExcludeMissing
        externalKeyRemoved: JsonField<ExternalKeyRemoved> = JsonMissing.of(),
        @JsonProperty("group.created")
        @ExcludeMissing
        groupCreated: JsonField<GroupCreated> = JsonMissing.of(),
        @JsonProperty("group.deleted")
        @ExcludeMissing
        groupDeleted: JsonField<GroupDeleted> = JsonMissing.of(),
        @JsonProperty("group.updated")
        @ExcludeMissing
        groupUpdated: JsonField<GroupUpdated> = JsonMissing.of(),
        @JsonProperty("invite.accepted")
        @ExcludeMissing
        inviteAccepted: JsonField<InviteAccepted> = JsonMissing.of(),
        @JsonProperty("invite.deleted")
        @ExcludeMissing
        inviteDeleted: JsonField<InviteDeleted> = JsonMissing.of(),
        @JsonProperty("invite.sent")
        @ExcludeMissing
        inviteSent: JsonField<InviteSent> = JsonMissing.of(),
        @JsonProperty("ip_allowlist.config.activated")
        @ExcludeMissing
        ipAllowlistConfigActivated: JsonField<IpAllowlistConfigActivated> = JsonMissing.of(),
        @JsonProperty("ip_allowlist.config.deactivated")
        @ExcludeMissing
        ipAllowlistConfigDeactivated: JsonField<IpAllowlistConfigDeactivated> = JsonMissing.of(),
        @JsonProperty("ip_allowlist.created")
        @ExcludeMissing
        ipAllowlistCreated: JsonField<IpAllowlistCreated> = JsonMissing.of(),
        @JsonProperty("ip_allowlist.deleted")
        @ExcludeMissing
        ipAllowlistDeleted: JsonField<IpAllowlistDeleted> = JsonMissing.of(),
        @JsonProperty("ip_allowlist.updated")
        @ExcludeMissing
        ipAllowlistUpdated: JsonField<IpAllowlistUpdated> = JsonMissing.of(),
        @JsonProperty("login.failed")
        @ExcludeMissing
        loginFailed: JsonField<LoginFailed> = JsonMissing.of(),
        @JsonProperty("login.succeeded")
        @ExcludeMissing
        loginSucceeded: JsonValue = JsonMissing.of(),
        @JsonProperty("logout.failed")
        @ExcludeMissing
        logoutFailed: JsonField<LogoutFailed> = JsonMissing.of(),
        @JsonProperty("logout.succeeded")
        @ExcludeMissing
        logoutSucceeded: JsonValue = JsonMissing.of(),
        @JsonProperty("organization.updated")
        @ExcludeMissing
        organizationUpdated: JsonField<OrganizationUpdated> = JsonMissing.of(),
        @JsonProperty("project") @ExcludeMissing project: JsonField<Project> = JsonMissing.of(),
        @JsonProperty("project.archived")
        @ExcludeMissing
        projectArchived: JsonField<ProjectArchived> = JsonMissing.of(),
        @JsonProperty("project.created")
        @ExcludeMissing
        projectCreated: JsonField<ProjectCreated> = JsonMissing.of(),
        @JsonProperty("project.deleted")
        @ExcludeMissing
        projectDeleted: JsonField<ProjectDeleted> = JsonMissing.of(),
        @JsonProperty("project.updated")
        @ExcludeMissing
        projectUpdated: JsonField<ProjectUpdated> = JsonMissing.of(),
        @JsonProperty("rate_limit.deleted")
        @ExcludeMissing
        rateLimitDeleted: JsonField<RateLimitDeleted> = JsonMissing.of(),
        @JsonProperty("rate_limit.updated")
        @ExcludeMissing
        rateLimitUpdated: JsonField<RateLimitUpdated> = JsonMissing.of(),
        @JsonProperty("role.assignment.created")
        @ExcludeMissing
        roleAssignmentCreated: JsonField<RoleAssignmentCreated> = JsonMissing.of(),
        @JsonProperty("role.assignment.deleted")
        @ExcludeMissing
        roleAssignmentDeleted: JsonField<RoleAssignmentDeleted> = JsonMissing.of(),
        @JsonProperty("role.created")
        @ExcludeMissing
        roleCreated: JsonField<RoleCreated> = JsonMissing.of(),
        @JsonProperty("role.deleted")
        @ExcludeMissing
        roleDeleted: JsonField<RoleDeleted> = JsonMissing.of(),
        @JsonProperty("role.updated")
        @ExcludeMissing
        roleUpdated: JsonField<RoleUpdated> = JsonMissing.of(),
        @JsonProperty("scim.disabled")
        @ExcludeMissing
        scimDisabled: JsonField<ScimDisabled> = JsonMissing.of(),
        @JsonProperty("scim.enabled")
        @ExcludeMissing
        scimEnabled: JsonField<ScimEnabled> = JsonMissing.of(),
        @JsonProperty("service_account.created")
        @ExcludeMissing
        serviceAccountCreated: JsonField<ServiceAccountCreated> = JsonMissing.of(),
        @JsonProperty("service_account.deleted")
        @ExcludeMissing
        serviceAccountDeleted: JsonField<ServiceAccountDeleted> = JsonMissing.of(),
        @JsonProperty("service_account.updated")
        @ExcludeMissing
        serviceAccountUpdated: JsonField<ServiceAccountUpdated> = JsonMissing.of(),
        @JsonProperty("user.added")
        @ExcludeMissing
        userAdded: JsonField<UserAdded> = JsonMissing.of(),
        @JsonProperty("user.deleted")
        @ExcludeMissing
        userDeleted: JsonField<UserDeleted> = JsonMissing.of(),
        @JsonProperty("user.updated")
        @ExcludeMissing
        userUpdated: JsonField<UserUpdated> = JsonMissing.of(),
    ) : this(
        id,
        actor,
        effectiveAt,
        type,
        apiKeyCreated,
        apiKeyDeleted,
        apiKeyUpdated,
        certificateCreated,
        certificateDeleted,
        certificateUpdated,
        certificatesActivated,
        certificatesDeactivated,
        checkpointPermissionCreated,
        checkpointPermissionDeleted,
        externalKeyRegistered,
        externalKeyRemoved,
        groupCreated,
        groupDeleted,
        groupUpdated,
        inviteAccepted,
        inviteDeleted,
        inviteSent,
        ipAllowlistConfigActivated,
        ipAllowlistConfigDeactivated,
        ipAllowlistCreated,
        ipAllowlistDeleted,
        ipAllowlistUpdated,
        loginFailed,
        loginSucceeded,
        logoutFailed,
        logoutSucceeded,
        organizationUpdated,
        project,
        projectArchived,
        projectCreated,
        projectDeleted,
        projectUpdated,
        rateLimitDeleted,
        rateLimitUpdated,
        roleAssignmentCreated,
        roleAssignmentDeleted,
        roleCreated,
        roleDeleted,
        roleUpdated,
        scimDisabled,
        scimEnabled,
        serviceAccountCreated,
        serviceAccountDeleted,
        serviceAccountUpdated,
        userAdded,
        userDeleted,
        userUpdated,
        mutableMapOf(),
    )

    /**
     * The ID of this log.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The actor who performed the audit logged action.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun actor(): Actor = actor.getRequired("actor")

    /**
     * The Unix timestamp (in seconds) of the event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun effectiveAt(): Long = effectiveAt.getRequired("effective_at")

    /**
     * The event type.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun apiKeyCreated(): Optional<ApiKeyCreated> = apiKeyCreated.getOptional("api_key.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun apiKeyDeleted(): Optional<ApiKeyDeleted> = apiKeyDeleted.getOptional("api_key.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun apiKeyUpdated(): Optional<ApiKeyUpdated> = apiKeyUpdated.getOptional("api_key.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun certificateCreated(): Optional<CertificateCreated> =
        certificateCreated.getOptional("certificate.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun certificateDeleted(): Optional<CertificateDeleted> =
        certificateDeleted.getOptional("certificate.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun certificateUpdated(): Optional<CertificateUpdated> =
        certificateUpdated.getOptional("certificate.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun certificatesActivated(): Optional<CertificatesActivated> =
        certificatesActivated.getOptional("certificates.activated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun certificatesDeactivated(): Optional<CertificatesDeactivated> =
        certificatesDeactivated.getOptional("certificates.deactivated")

    /**
     * The project and fine-tuned model checkpoint that the checkpoint permission was created for.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun checkpointPermissionCreated(): Optional<CheckpointPermissionCreated> =
        checkpointPermissionCreated.getOptional("checkpoint.permission.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun checkpointPermissionDeleted(): Optional<CheckpointPermissionDeleted> =
        checkpointPermissionDeleted.getOptional("checkpoint.permission.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun externalKeyRegistered(): Optional<ExternalKeyRegistered> =
        externalKeyRegistered.getOptional("external_key.registered")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun externalKeyRemoved(): Optional<ExternalKeyRemoved> =
        externalKeyRemoved.getOptional("external_key.removed")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun groupCreated(): Optional<GroupCreated> = groupCreated.getOptional("group.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun groupDeleted(): Optional<GroupDeleted> = groupDeleted.getOptional("group.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun groupUpdated(): Optional<GroupUpdated> = groupUpdated.getOptional("group.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inviteAccepted(): Optional<InviteAccepted> = inviteAccepted.getOptional("invite.accepted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inviteDeleted(): Optional<InviteDeleted> = inviteDeleted.getOptional("invite.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inviteSent(): Optional<InviteSent> = inviteSent.getOptional("invite.sent")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ipAllowlistConfigActivated(): Optional<IpAllowlistConfigActivated> =
        ipAllowlistConfigActivated.getOptional("ip_allowlist.config.activated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ipAllowlistConfigDeactivated(): Optional<IpAllowlistConfigDeactivated> =
        ipAllowlistConfigDeactivated.getOptional("ip_allowlist.config.deactivated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ipAllowlistCreated(): Optional<IpAllowlistCreated> =
        ipAllowlistCreated.getOptional("ip_allowlist.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ipAllowlistDeleted(): Optional<IpAllowlistDeleted> =
        ipAllowlistDeleted.getOptional("ip_allowlist.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ipAllowlistUpdated(): Optional<IpAllowlistUpdated> =
        ipAllowlistUpdated.getOptional("ip_allowlist.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun loginFailed(): Optional<LoginFailed> = loginFailed.getOptional("login.failed")

    /**
     * This event has no additional fields beyond the standard audit log attributes.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = auditLogListResponse.loginSucceeded().convert(MyClass.class);
     * ```
     */
    @JsonProperty("login.succeeded")
    @ExcludeMissing
    fun _loginSucceeded(): JsonValue = loginSucceeded

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logoutFailed(): Optional<LogoutFailed> = logoutFailed.getOptional("logout.failed")

    /**
     * This event has no additional fields beyond the standard audit log attributes.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = auditLogListResponse.logoutSucceeded().convert(MyClass.class);
     * ```
     */
    @JsonProperty("logout.succeeded")
    @ExcludeMissing
    fun _logoutSucceeded(): JsonValue = logoutSucceeded

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun organizationUpdated(): Optional<OrganizationUpdated> =
        organizationUpdated.getOptional("organization.updated")

    /**
     * The project that the action was scoped to. Absent for actions not scoped to projects. Note
     * that any admin actions taken via Admin API keys are associated with the default project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun project(): Optional<Project> = project.getOptional("project")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun projectArchived(): Optional<ProjectArchived> =
        projectArchived.getOptional("project.archived")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun projectCreated(): Optional<ProjectCreated> = projectCreated.getOptional("project.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun projectDeleted(): Optional<ProjectDeleted> = projectDeleted.getOptional("project.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun projectUpdated(): Optional<ProjectUpdated> = projectUpdated.getOptional("project.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rateLimitDeleted(): Optional<RateLimitDeleted> =
        rateLimitDeleted.getOptional("rate_limit.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rateLimitUpdated(): Optional<RateLimitUpdated> =
        rateLimitUpdated.getOptional("rate_limit.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleAssignmentCreated(): Optional<RoleAssignmentCreated> =
        roleAssignmentCreated.getOptional("role.assignment.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleAssignmentDeleted(): Optional<RoleAssignmentDeleted> =
        roleAssignmentDeleted.getOptional("role.assignment.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleCreated(): Optional<RoleCreated> = roleCreated.getOptional("role.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleDeleted(): Optional<RoleDeleted> = roleDeleted.getOptional("role.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roleUpdated(): Optional<RoleUpdated> = roleUpdated.getOptional("role.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scimDisabled(): Optional<ScimDisabled> = scimDisabled.getOptional("scim.disabled")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scimEnabled(): Optional<ScimEnabled> = scimEnabled.getOptional("scim.enabled")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceAccountCreated(): Optional<ServiceAccountCreated> =
        serviceAccountCreated.getOptional("service_account.created")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceAccountDeleted(): Optional<ServiceAccountDeleted> =
        serviceAccountDeleted.getOptional("service_account.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceAccountUpdated(): Optional<ServiceAccountUpdated> =
        serviceAccountUpdated.getOptional("service_account.updated")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userAdded(): Optional<UserAdded> = userAdded.getOptional("user.added")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userDeleted(): Optional<UserDeleted> = userDeleted.getOptional("user.deleted")

    /**
     * The details for events with this `type`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userUpdated(): Optional<UserUpdated> = userUpdated.getOptional("user.updated")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [actor].
     *
     * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<Actor> = actor

    /**
     * Returns the raw JSON value of [effectiveAt].
     *
     * Unlike [effectiveAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("effective_at") @ExcludeMissing fun _effectiveAt(): JsonField<Long> = effectiveAt

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [apiKeyCreated].
     *
     * Unlike [apiKeyCreated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("api_key.created")
    @ExcludeMissing
    fun _apiKeyCreated(): JsonField<ApiKeyCreated> = apiKeyCreated

    /**
     * Returns the raw JSON value of [apiKeyDeleted].
     *
     * Unlike [apiKeyDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("api_key.deleted")
    @ExcludeMissing
    fun _apiKeyDeleted(): JsonField<ApiKeyDeleted> = apiKeyDeleted

    /**
     * Returns the raw JSON value of [apiKeyUpdated].
     *
     * Unlike [apiKeyUpdated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("api_key.updated")
    @ExcludeMissing
    fun _apiKeyUpdated(): JsonField<ApiKeyUpdated> = apiKeyUpdated

    /**
     * Returns the raw JSON value of [certificateCreated].
     *
     * Unlike [certificateCreated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("certificate.created")
    @ExcludeMissing
    fun _certificateCreated(): JsonField<CertificateCreated> = certificateCreated

    /**
     * Returns the raw JSON value of [certificateDeleted].
     *
     * Unlike [certificateDeleted], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("certificate.deleted")
    @ExcludeMissing
    fun _certificateDeleted(): JsonField<CertificateDeleted> = certificateDeleted

    /**
     * Returns the raw JSON value of [certificateUpdated].
     *
     * Unlike [certificateUpdated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("certificate.updated")
    @ExcludeMissing
    fun _certificateUpdated(): JsonField<CertificateUpdated> = certificateUpdated

    /**
     * Returns the raw JSON value of [certificatesActivated].
     *
     * Unlike [certificatesActivated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("certificates.activated")
    @ExcludeMissing
    fun _certificatesActivated(): JsonField<CertificatesActivated> = certificatesActivated

    /**
     * Returns the raw JSON value of [certificatesDeactivated].
     *
     * Unlike [certificatesDeactivated], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("certificates.deactivated")
    @ExcludeMissing
    fun _certificatesDeactivated(): JsonField<CertificatesDeactivated> = certificatesDeactivated

    /**
     * Returns the raw JSON value of [checkpointPermissionCreated].
     *
     * Unlike [checkpointPermissionCreated], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("checkpoint.permission.created")
    @ExcludeMissing
    fun _checkpointPermissionCreated(): JsonField<CheckpointPermissionCreated> =
        checkpointPermissionCreated

    /**
     * Returns the raw JSON value of [checkpointPermissionDeleted].
     *
     * Unlike [checkpointPermissionDeleted], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("checkpoint.permission.deleted")
    @ExcludeMissing
    fun _checkpointPermissionDeleted(): JsonField<CheckpointPermissionDeleted> =
        checkpointPermissionDeleted

    /**
     * Returns the raw JSON value of [externalKeyRegistered].
     *
     * Unlike [externalKeyRegistered], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("external_key.registered")
    @ExcludeMissing
    fun _externalKeyRegistered(): JsonField<ExternalKeyRegistered> = externalKeyRegistered

    /**
     * Returns the raw JSON value of [externalKeyRemoved].
     *
     * Unlike [externalKeyRemoved], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("external_key.removed")
    @ExcludeMissing
    fun _externalKeyRemoved(): JsonField<ExternalKeyRemoved> = externalKeyRemoved

    /**
     * Returns the raw JSON value of [groupCreated].
     *
     * Unlike [groupCreated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("group.created")
    @ExcludeMissing
    fun _groupCreated(): JsonField<GroupCreated> = groupCreated

    /**
     * Returns the raw JSON value of [groupDeleted].
     *
     * Unlike [groupDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("group.deleted")
    @ExcludeMissing
    fun _groupDeleted(): JsonField<GroupDeleted> = groupDeleted

    /**
     * Returns the raw JSON value of [groupUpdated].
     *
     * Unlike [groupUpdated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("group.updated")
    @ExcludeMissing
    fun _groupUpdated(): JsonField<GroupUpdated> = groupUpdated

    /**
     * Returns the raw JSON value of [inviteAccepted].
     *
     * Unlike [inviteAccepted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invite.accepted")
    @ExcludeMissing
    fun _inviteAccepted(): JsonField<InviteAccepted> = inviteAccepted

    /**
     * Returns the raw JSON value of [inviteDeleted].
     *
     * Unlike [inviteDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invite.deleted")
    @ExcludeMissing
    fun _inviteDeleted(): JsonField<InviteDeleted> = inviteDeleted

    /**
     * Returns the raw JSON value of [inviteSent].
     *
     * Unlike [inviteSent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invite.sent")
    @ExcludeMissing
    fun _inviteSent(): JsonField<InviteSent> = inviteSent

    /**
     * Returns the raw JSON value of [ipAllowlistConfigActivated].
     *
     * Unlike [ipAllowlistConfigActivated], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("ip_allowlist.config.activated")
    @ExcludeMissing
    fun _ipAllowlistConfigActivated(): JsonField<IpAllowlistConfigActivated> =
        ipAllowlistConfigActivated

    /**
     * Returns the raw JSON value of [ipAllowlistConfigDeactivated].
     *
     * Unlike [ipAllowlistConfigDeactivated], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("ip_allowlist.config.deactivated")
    @ExcludeMissing
    fun _ipAllowlistConfigDeactivated(): JsonField<IpAllowlistConfigDeactivated> =
        ipAllowlistConfigDeactivated

    /**
     * Returns the raw JSON value of [ipAllowlistCreated].
     *
     * Unlike [ipAllowlistCreated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("ip_allowlist.created")
    @ExcludeMissing
    fun _ipAllowlistCreated(): JsonField<IpAllowlistCreated> = ipAllowlistCreated

    /**
     * Returns the raw JSON value of [ipAllowlistDeleted].
     *
     * Unlike [ipAllowlistDeleted], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("ip_allowlist.deleted")
    @ExcludeMissing
    fun _ipAllowlistDeleted(): JsonField<IpAllowlistDeleted> = ipAllowlistDeleted

    /**
     * Returns the raw JSON value of [ipAllowlistUpdated].
     *
     * Unlike [ipAllowlistUpdated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("ip_allowlist.updated")
    @ExcludeMissing
    fun _ipAllowlistUpdated(): JsonField<IpAllowlistUpdated> = ipAllowlistUpdated

    /**
     * Returns the raw JSON value of [loginFailed].
     *
     * Unlike [loginFailed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("login.failed")
    @ExcludeMissing
    fun _loginFailed(): JsonField<LoginFailed> = loginFailed

    /**
     * Returns the raw JSON value of [logoutFailed].
     *
     * Unlike [logoutFailed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logout.failed")
    @ExcludeMissing
    fun _logoutFailed(): JsonField<LogoutFailed> = logoutFailed

    /**
     * Returns the raw JSON value of [organizationUpdated].
     *
     * Unlike [organizationUpdated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("organization.updated")
    @ExcludeMissing
    fun _organizationUpdated(): JsonField<OrganizationUpdated> = organizationUpdated

    /**
     * Returns the raw JSON value of [project].
     *
     * Unlike [project], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("project") @ExcludeMissing fun _project(): JsonField<Project> = project

    /**
     * Returns the raw JSON value of [projectArchived].
     *
     * Unlike [projectArchived], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("project.archived")
    @ExcludeMissing
    fun _projectArchived(): JsonField<ProjectArchived> = projectArchived

    /**
     * Returns the raw JSON value of [projectCreated].
     *
     * Unlike [projectCreated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("project.created")
    @ExcludeMissing
    fun _projectCreated(): JsonField<ProjectCreated> = projectCreated

    /**
     * Returns the raw JSON value of [projectDeleted].
     *
     * Unlike [projectDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("project.deleted")
    @ExcludeMissing
    fun _projectDeleted(): JsonField<ProjectDeleted> = projectDeleted

    /**
     * Returns the raw JSON value of [projectUpdated].
     *
     * Unlike [projectUpdated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("project.updated")
    @ExcludeMissing
    fun _projectUpdated(): JsonField<ProjectUpdated> = projectUpdated

    /**
     * Returns the raw JSON value of [rateLimitDeleted].
     *
     * Unlike [rateLimitDeleted], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("rate_limit.deleted")
    @ExcludeMissing
    fun _rateLimitDeleted(): JsonField<RateLimitDeleted> = rateLimitDeleted

    /**
     * Returns the raw JSON value of [rateLimitUpdated].
     *
     * Unlike [rateLimitUpdated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("rate_limit.updated")
    @ExcludeMissing
    fun _rateLimitUpdated(): JsonField<RateLimitUpdated> = rateLimitUpdated

    /**
     * Returns the raw JSON value of [roleAssignmentCreated].
     *
     * Unlike [roleAssignmentCreated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("role.assignment.created")
    @ExcludeMissing
    fun _roleAssignmentCreated(): JsonField<RoleAssignmentCreated> = roleAssignmentCreated

    /**
     * Returns the raw JSON value of [roleAssignmentDeleted].
     *
     * Unlike [roleAssignmentDeleted], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("role.assignment.deleted")
    @ExcludeMissing
    fun _roleAssignmentDeleted(): JsonField<RoleAssignmentDeleted> = roleAssignmentDeleted

    /**
     * Returns the raw JSON value of [roleCreated].
     *
     * Unlike [roleCreated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role.created")
    @ExcludeMissing
    fun _roleCreated(): JsonField<RoleCreated> = roleCreated

    /**
     * Returns the raw JSON value of [roleDeleted].
     *
     * Unlike [roleDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role.deleted")
    @ExcludeMissing
    fun _roleDeleted(): JsonField<RoleDeleted> = roleDeleted

    /**
     * Returns the raw JSON value of [roleUpdated].
     *
     * Unlike [roleUpdated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role.updated")
    @ExcludeMissing
    fun _roleUpdated(): JsonField<RoleUpdated> = roleUpdated

    /**
     * Returns the raw JSON value of [scimDisabled].
     *
     * Unlike [scimDisabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scim.disabled")
    @ExcludeMissing
    fun _scimDisabled(): JsonField<ScimDisabled> = scimDisabled

    /**
     * Returns the raw JSON value of [scimEnabled].
     *
     * Unlike [scimEnabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scim.enabled")
    @ExcludeMissing
    fun _scimEnabled(): JsonField<ScimEnabled> = scimEnabled

    /**
     * Returns the raw JSON value of [serviceAccountCreated].
     *
     * Unlike [serviceAccountCreated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("service_account.created")
    @ExcludeMissing
    fun _serviceAccountCreated(): JsonField<ServiceAccountCreated> = serviceAccountCreated

    /**
     * Returns the raw JSON value of [serviceAccountDeleted].
     *
     * Unlike [serviceAccountDeleted], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("service_account.deleted")
    @ExcludeMissing
    fun _serviceAccountDeleted(): JsonField<ServiceAccountDeleted> = serviceAccountDeleted

    /**
     * Returns the raw JSON value of [serviceAccountUpdated].
     *
     * Unlike [serviceAccountUpdated], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("service_account.updated")
    @ExcludeMissing
    fun _serviceAccountUpdated(): JsonField<ServiceAccountUpdated> = serviceAccountUpdated

    /**
     * Returns the raw JSON value of [userAdded].
     *
     * Unlike [userAdded], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user.added") @ExcludeMissing fun _userAdded(): JsonField<UserAdded> = userAdded

    /**
     * Returns the raw JSON value of [userDeleted].
     *
     * Unlike [userDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user.deleted")
    @ExcludeMissing
    fun _userDeleted(): JsonField<UserDeleted> = userDeleted

    /**
     * Returns the raw JSON value of [userUpdated].
     *
     * Unlike [userUpdated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user.updated")
    @ExcludeMissing
    fun _userUpdated(): JsonField<UserUpdated> = userUpdated

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
         * Returns a mutable builder for constructing an instance of [AuditLogListResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .actor()
         * .effectiveAt()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AuditLogListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var actor: JsonField<Actor>? = null
        private var effectiveAt: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
        private var apiKeyCreated: JsonField<ApiKeyCreated> = JsonMissing.of()
        private var apiKeyDeleted: JsonField<ApiKeyDeleted> = JsonMissing.of()
        private var apiKeyUpdated: JsonField<ApiKeyUpdated> = JsonMissing.of()
        private var certificateCreated: JsonField<CertificateCreated> = JsonMissing.of()
        private var certificateDeleted: JsonField<CertificateDeleted> = JsonMissing.of()
        private var certificateUpdated: JsonField<CertificateUpdated> = JsonMissing.of()
        private var certificatesActivated: JsonField<CertificatesActivated> = JsonMissing.of()
        private var certificatesDeactivated: JsonField<CertificatesDeactivated> = JsonMissing.of()
        private var checkpointPermissionCreated: JsonField<CheckpointPermissionCreated> =
            JsonMissing.of()
        private var checkpointPermissionDeleted: JsonField<CheckpointPermissionDeleted> =
            JsonMissing.of()
        private var externalKeyRegistered: JsonField<ExternalKeyRegistered> = JsonMissing.of()
        private var externalKeyRemoved: JsonField<ExternalKeyRemoved> = JsonMissing.of()
        private var groupCreated: JsonField<GroupCreated> = JsonMissing.of()
        private var groupDeleted: JsonField<GroupDeleted> = JsonMissing.of()
        private var groupUpdated: JsonField<GroupUpdated> = JsonMissing.of()
        private var inviteAccepted: JsonField<InviteAccepted> = JsonMissing.of()
        private var inviteDeleted: JsonField<InviteDeleted> = JsonMissing.of()
        private var inviteSent: JsonField<InviteSent> = JsonMissing.of()
        private var ipAllowlistConfigActivated: JsonField<IpAllowlistConfigActivated> =
            JsonMissing.of()
        private var ipAllowlistConfigDeactivated: JsonField<IpAllowlistConfigDeactivated> =
            JsonMissing.of()
        private var ipAllowlistCreated: JsonField<IpAllowlistCreated> = JsonMissing.of()
        private var ipAllowlistDeleted: JsonField<IpAllowlistDeleted> = JsonMissing.of()
        private var ipAllowlistUpdated: JsonField<IpAllowlistUpdated> = JsonMissing.of()
        private var loginFailed: JsonField<LoginFailed> = JsonMissing.of()
        private var loginSucceeded: JsonValue = JsonMissing.of()
        private var logoutFailed: JsonField<LogoutFailed> = JsonMissing.of()
        private var logoutSucceeded: JsonValue = JsonMissing.of()
        private var organizationUpdated: JsonField<OrganizationUpdated> = JsonMissing.of()
        private var project: JsonField<Project> = JsonMissing.of()
        private var projectArchived: JsonField<ProjectArchived> = JsonMissing.of()
        private var projectCreated: JsonField<ProjectCreated> = JsonMissing.of()
        private var projectDeleted: JsonField<ProjectDeleted> = JsonMissing.of()
        private var projectUpdated: JsonField<ProjectUpdated> = JsonMissing.of()
        private var rateLimitDeleted: JsonField<RateLimitDeleted> = JsonMissing.of()
        private var rateLimitUpdated: JsonField<RateLimitUpdated> = JsonMissing.of()
        private var roleAssignmentCreated: JsonField<RoleAssignmentCreated> = JsonMissing.of()
        private var roleAssignmentDeleted: JsonField<RoleAssignmentDeleted> = JsonMissing.of()
        private var roleCreated: JsonField<RoleCreated> = JsonMissing.of()
        private var roleDeleted: JsonField<RoleDeleted> = JsonMissing.of()
        private var roleUpdated: JsonField<RoleUpdated> = JsonMissing.of()
        private var scimDisabled: JsonField<ScimDisabled> = JsonMissing.of()
        private var scimEnabled: JsonField<ScimEnabled> = JsonMissing.of()
        private var serviceAccountCreated: JsonField<ServiceAccountCreated> = JsonMissing.of()
        private var serviceAccountDeleted: JsonField<ServiceAccountDeleted> = JsonMissing.of()
        private var serviceAccountUpdated: JsonField<ServiceAccountUpdated> = JsonMissing.of()
        private var userAdded: JsonField<UserAdded> = JsonMissing.of()
        private var userDeleted: JsonField<UserDeleted> = JsonMissing.of()
        private var userUpdated: JsonField<UserUpdated> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(auditLogListResponse: AuditLogListResponse) = apply {
            id = auditLogListResponse.id
            actor = auditLogListResponse.actor
            effectiveAt = auditLogListResponse.effectiveAt
            type = auditLogListResponse.type
            apiKeyCreated = auditLogListResponse.apiKeyCreated
            apiKeyDeleted = auditLogListResponse.apiKeyDeleted
            apiKeyUpdated = auditLogListResponse.apiKeyUpdated
            certificateCreated = auditLogListResponse.certificateCreated
            certificateDeleted = auditLogListResponse.certificateDeleted
            certificateUpdated = auditLogListResponse.certificateUpdated
            certificatesActivated = auditLogListResponse.certificatesActivated
            certificatesDeactivated = auditLogListResponse.certificatesDeactivated
            checkpointPermissionCreated = auditLogListResponse.checkpointPermissionCreated
            checkpointPermissionDeleted = auditLogListResponse.checkpointPermissionDeleted
            externalKeyRegistered = auditLogListResponse.externalKeyRegistered
            externalKeyRemoved = auditLogListResponse.externalKeyRemoved
            groupCreated = auditLogListResponse.groupCreated
            groupDeleted = auditLogListResponse.groupDeleted
            groupUpdated = auditLogListResponse.groupUpdated
            inviteAccepted = auditLogListResponse.inviteAccepted
            inviteDeleted = auditLogListResponse.inviteDeleted
            inviteSent = auditLogListResponse.inviteSent
            ipAllowlistConfigActivated = auditLogListResponse.ipAllowlistConfigActivated
            ipAllowlistConfigDeactivated = auditLogListResponse.ipAllowlistConfigDeactivated
            ipAllowlistCreated = auditLogListResponse.ipAllowlistCreated
            ipAllowlistDeleted = auditLogListResponse.ipAllowlistDeleted
            ipAllowlistUpdated = auditLogListResponse.ipAllowlistUpdated
            loginFailed = auditLogListResponse.loginFailed
            loginSucceeded = auditLogListResponse.loginSucceeded
            logoutFailed = auditLogListResponse.logoutFailed
            logoutSucceeded = auditLogListResponse.logoutSucceeded
            organizationUpdated = auditLogListResponse.organizationUpdated
            project = auditLogListResponse.project
            projectArchived = auditLogListResponse.projectArchived
            projectCreated = auditLogListResponse.projectCreated
            projectDeleted = auditLogListResponse.projectDeleted
            projectUpdated = auditLogListResponse.projectUpdated
            rateLimitDeleted = auditLogListResponse.rateLimitDeleted
            rateLimitUpdated = auditLogListResponse.rateLimitUpdated
            roleAssignmentCreated = auditLogListResponse.roleAssignmentCreated
            roleAssignmentDeleted = auditLogListResponse.roleAssignmentDeleted
            roleCreated = auditLogListResponse.roleCreated
            roleDeleted = auditLogListResponse.roleDeleted
            roleUpdated = auditLogListResponse.roleUpdated
            scimDisabled = auditLogListResponse.scimDisabled
            scimEnabled = auditLogListResponse.scimEnabled
            serviceAccountCreated = auditLogListResponse.serviceAccountCreated
            serviceAccountDeleted = auditLogListResponse.serviceAccountDeleted
            serviceAccountUpdated = auditLogListResponse.serviceAccountUpdated
            userAdded = auditLogListResponse.userAdded
            userDeleted = auditLogListResponse.userDeleted
            userUpdated = auditLogListResponse.userUpdated
            additionalProperties = auditLogListResponse.additionalProperties.toMutableMap()
        }

        /** The ID of this log. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The actor who performed the audit logged action. */
        fun actor(actor: Actor) = actor(JsonField.of(actor))

        /**
         * Sets [Builder.actor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actor] with a well-typed [Actor] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun actor(actor: JsonField<Actor>) = apply { this.actor = actor }

        /** The Unix timestamp (in seconds) of the event. */
        fun effectiveAt(effectiveAt: Long) = effectiveAt(JsonField.of(effectiveAt))

        /**
         * Sets [Builder.effectiveAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.effectiveAt] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun effectiveAt(effectiveAt: JsonField<Long>) = apply { this.effectiveAt = effectiveAt }

        /** The event type. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The details for events with this `type`. */
        fun apiKeyCreated(apiKeyCreated: ApiKeyCreated) = apiKeyCreated(JsonField.of(apiKeyCreated))

        /**
         * Sets [Builder.apiKeyCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKeyCreated] with a well-typed [ApiKeyCreated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun apiKeyCreated(apiKeyCreated: JsonField<ApiKeyCreated>) = apply {
            this.apiKeyCreated = apiKeyCreated
        }

        /** The details for events with this `type`. */
        fun apiKeyDeleted(apiKeyDeleted: ApiKeyDeleted) = apiKeyDeleted(JsonField.of(apiKeyDeleted))

        /**
         * Sets [Builder.apiKeyDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKeyDeleted] with a well-typed [ApiKeyDeleted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun apiKeyDeleted(apiKeyDeleted: JsonField<ApiKeyDeleted>) = apply {
            this.apiKeyDeleted = apiKeyDeleted
        }

        /** The details for events with this `type`. */
        fun apiKeyUpdated(apiKeyUpdated: ApiKeyUpdated) = apiKeyUpdated(JsonField.of(apiKeyUpdated))

        /**
         * Sets [Builder.apiKeyUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKeyUpdated] with a well-typed [ApiKeyUpdated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun apiKeyUpdated(apiKeyUpdated: JsonField<ApiKeyUpdated>) = apply {
            this.apiKeyUpdated = apiKeyUpdated
        }

        /** The details for events with this `type`. */
        fun certificateCreated(certificateCreated: CertificateCreated) =
            certificateCreated(JsonField.of(certificateCreated))

        /**
         * Sets [Builder.certificateCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.certificateCreated] with a well-typed
         * [CertificateCreated] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun certificateCreated(certificateCreated: JsonField<CertificateCreated>) = apply {
            this.certificateCreated = certificateCreated
        }

        /** The details for events with this `type`. */
        fun certificateDeleted(certificateDeleted: CertificateDeleted) =
            certificateDeleted(JsonField.of(certificateDeleted))

        /**
         * Sets [Builder.certificateDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.certificateDeleted] with a well-typed
         * [CertificateDeleted] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun certificateDeleted(certificateDeleted: JsonField<CertificateDeleted>) = apply {
            this.certificateDeleted = certificateDeleted
        }

        /** The details for events with this `type`. */
        fun certificateUpdated(certificateUpdated: CertificateUpdated) =
            certificateUpdated(JsonField.of(certificateUpdated))

        /**
         * Sets [Builder.certificateUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.certificateUpdated] with a well-typed
         * [CertificateUpdated] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun certificateUpdated(certificateUpdated: JsonField<CertificateUpdated>) = apply {
            this.certificateUpdated = certificateUpdated
        }

        /** The details for events with this `type`. */
        fun certificatesActivated(certificatesActivated: CertificatesActivated) =
            certificatesActivated(JsonField.of(certificatesActivated))

        /**
         * Sets [Builder.certificatesActivated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.certificatesActivated] with a well-typed
         * [CertificatesActivated] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun certificatesActivated(certificatesActivated: JsonField<CertificatesActivated>) = apply {
            this.certificatesActivated = certificatesActivated
        }

        /** The details for events with this `type`. */
        fun certificatesDeactivated(certificatesDeactivated: CertificatesDeactivated) =
            certificatesDeactivated(JsonField.of(certificatesDeactivated))

        /**
         * Sets [Builder.certificatesDeactivated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.certificatesDeactivated] with a well-typed
         * [CertificatesDeactivated] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun certificatesDeactivated(certificatesDeactivated: JsonField<CertificatesDeactivated>) =
            apply {
                this.certificatesDeactivated = certificatesDeactivated
            }

        /**
         * The project and fine-tuned model checkpoint that the checkpoint permission was created
         * for.
         */
        fun checkpointPermissionCreated(checkpointPermissionCreated: CheckpointPermissionCreated) =
            checkpointPermissionCreated(JsonField.of(checkpointPermissionCreated))

        /**
         * Sets [Builder.checkpointPermissionCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.checkpointPermissionCreated] with a well-typed
         * [CheckpointPermissionCreated] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun checkpointPermissionCreated(
            checkpointPermissionCreated: JsonField<CheckpointPermissionCreated>
        ) = apply { this.checkpointPermissionCreated = checkpointPermissionCreated }

        /** The details for events with this `type`. */
        fun checkpointPermissionDeleted(checkpointPermissionDeleted: CheckpointPermissionDeleted) =
            checkpointPermissionDeleted(JsonField.of(checkpointPermissionDeleted))

        /**
         * Sets [Builder.checkpointPermissionDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.checkpointPermissionDeleted] with a well-typed
         * [CheckpointPermissionDeleted] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun checkpointPermissionDeleted(
            checkpointPermissionDeleted: JsonField<CheckpointPermissionDeleted>
        ) = apply { this.checkpointPermissionDeleted = checkpointPermissionDeleted }

        /** The details for events with this `type`. */
        fun externalKeyRegistered(externalKeyRegistered: ExternalKeyRegistered) =
            externalKeyRegistered(JsonField.of(externalKeyRegistered))

        /**
         * Sets [Builder.externalKeyRegistered] to an arbitrary JSON value.
         *
         * You should usually call [Builder.externalKeyRegistered] with a well-typed
         * [ExternalKeyRegistered] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun externalKeyRegistered(externalKeyRegistered: JsonField<ExternalKeyRegistered>) = apply {
            this.externalKeyRegistered = externalKeyRegistered
        }

        /** The details for events with this `type`. */
        fun externalKeyRemoved(externalKeyRemoved: ExternalKeyRemoved) =
            externalKeyRemoved(JsonField.of(externalKeyRemoved))

        /**
         * Sets [Builder.externalKeyRemoved] to an arbitrary JSON value.
         *
         * You should usually call [Builder.externalKeyRemoved] with a well-typed
         * [ExternalKeyRemoved] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun externalKeyRemoved(externalKeyRemoved: JsonField<ExternalKeyRemoved>) = apply {
            this.externalKeyRemoved = externalKeyRemoved
        }

        /** The details for events with this `type`. */
        fun groupCreated(groupCreated: GroupCreated) = groupCreated(JsonField.of(groupCreated))

        /**
         * Sets [Builder.groupCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.groupCreated] with a well-typed [GroupCreated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun groupCreated(groupCreated: JsonField<GroupCreated>) = apply {
            this.groupCreated = groupCreated
        }

        /** The details for events with this `type`. */
        fun groupDeleted(groupDeleted: GroupDeleted) = groupDeleted(JsonField.of(groupDeleted))

        /**
         * Sets [Builder.groupDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.groupDeleted] with a well-typed [GroupDeleted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun groupDeleted(groupDeleted: JsonField<GroupDeleted>) = apply {
            this.groupDeleted = groupDeleted
        }

        /** The details for events with this `type`. */
        fun groupUpdated(groupUpdated: GroupUpdated) = groupUpdated(JsonField.of(groupUpdated))

        /**
         * Sets [Builder.groupUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.groupUpdated] with a well-typed [GroupUpdated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun groupUpdated(groupUpdated: JsonField<GroupUpdated>) = apply {
            this.groupUpdated = groupUpdated
        }

        /** The details for events with this `type`. */
        fun inviteAccepted(inviteAccepted: InviteAccepted) =
            inviteAccepted(JsonField.of(inviteAccepted))

        /**
         * Sets [Builder.inviteAccepted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inviteAccepted] with a well-typed [InviteAccepted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inviteAccepted(inviteAccepted: JsonField<InviteAccepted>) = apply {
            this.inviteAccepted = inviteAccepted
        }

        /** The details for events with this `type`. */
        fun inviteDeleted(inviteDeleted: InviteDeleted) = inviteDeleted(JsonField.of(inviteDeleted))

        /**
         * Sets [Builder.inviteDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inviteDeleted] with a well-typed [InviteDeleted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inviteDeleted(inviteDeleted: JsonField<InviteDeleted>) = apply {
            this.inviteDeleted = inviteDeleted
        }

        /** The details for events with this `type`. */
        fun inviteSent(inviteSent: InviteSent) = inviteSent(JsonField.of(inviteSent))

        /**
         * Sets [Builder.inviteSent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inviteSent] with a well-typed [InviteSent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inviteSent(inviteSent: JsonField<InviteSent>) = apply { this.inviteSent = inviteSent }

        /** The details for events with this `type`. */
        fun ipAllowlistConfigActivated(ipAllowlistConfigActivated: IpAllowlistConfigActivated) =
            ipAllowlistConfigActivated(JsonField.of(ipAllowlistConfigActivated))

        /**
         * Sets [Builder.ipAllowlistConfigActivated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ipAllowlistConfigActivated] with a well-typed
         * [IpAllowlistConfigActivated] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun ipAllowlistConfigActivated(
            ipAllowlistConfigActivated: JsonField<IpAllowlistConfigActivated>
        ) = apply { this.ipAllowlistConfigActivated = ipAllowlistConfigActivated }

        /** The details for events with this `type`. */
        fun ipAllowlistConfigDeactivated(
            ipAllowlistConfigDeactivated: IpAllowlistConfigDeactivated
        ) = ipAllowlistConfigDeactivated(JsonField.of(ipAllowlistConfigDeactivated))

        /**
         * Sets [Builder.ipAllowlistConfigDeactivated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ipAllowlistConfigDeactivated] with a well-typed
         * [IpAllowlistConfigDeactivated] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun ipAllowlistConfigDeactivated(
            ipAllowlistConfigDeactivated: JsonField<IpAllowlistConfigDeactivated>
        ) = apply { this.ipAllowlistConfigDeactivated = ipAllowlistConfigDeactivated }

        /** The details for events with this `type`. */
        fun ipAllowlistCreated(ipAllowlistCreated: IpAllowlistCreated) =
            ipAllowlistCreated(JsonField.of(ipAllowlistCreated))

        /**
         * Sets [Builder.ipAllowlistCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ipAllowlistCreated] with a well-typed
         * [IpAllowlistCreated] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun ipAllowlistCreated(ipAllowlistCreated: JsonField<IpAllowlistCreated>) = apply {
            this.ipAllowlistCreated = ipAllowlistCreated
        }

        /** The details for events with this `type`. */
        fun ipAllowlistDeleted(ipAllowlistDeleted: IpAllowlistDeleted) =
            ipAllowlistDeleted(JsonField.of(ipAllowlistDeleted))

        /**
         * Sets [Builder.ipAllowlistDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ipAllowlistDeleted] with a well-typed
         * [IpAllowlistDeleted] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun ipAllowlistDeleted(ipAllowlistDeleted: JsonField<IpAllowlistDeleted>) = apply {
            this.ipAllowlistDeleted = ipAllowlistDeleted
        }

        /** The details for events with this `type`. */
        fun ipAllowlistUpdated(ipAllowlistUpdated: IpAllowlistUpdated) =
            ipAllowlistUpdated(JsonField.of(ipAllowlistUpdated))

        /**
         * Sets [Builder.ipAllowlistUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ipAllowlistUpdated] with a well-typed
         * [IpAllowlistUpdated] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun ipAllowlistUpdated(ipAllowlistUpdated: JsonField<IpAllowlistUpdated>) = apply {
            this.ipAllowlistUpdated = ipAllowlistUpdated
        }

        /** The details for events with this `type`. */
        fun loginFailed(loginFailed: LoginFailed) = loginFailed(JsonField.of(loginFailed))

        /**
         * Sets [Builder.loginFailed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.loginFailed] with a well-typed [LoginFailed] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun loginFailed(loginFailed: JsonField<LoginFailed>) = apply {
            this.loginFailed = loginFailed
        }

        /** This event has no additional fields beyond the standard audit log attributes. */
        fun loginSucceeded(loginSucceeded: JsonValue) = apply {
            this.loginSucceeded = loginSucceeded
        }

        /** The details for events with this `type`. */
        fun logoutFailed(logoutFailed: LogoutFailed) = logoutFailed(JsonField.of(logoutFailed))

        /**
         * Sets [Builder.logoutFailed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logoutFailed] with a well-typed [LogoutFailed] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun logoutFailed(logoutFailed: JsonField<LogoutFailed>) = apply {
            this.logoutFailed = logoutFailed
        }

        /** This event has no additional fields beyond the standard audit log attributes. */
        fun logoutSucceeded(logoutSucceeded: JsonValue) = apply {
            this.logoutSucceeded = logoutSucceeded
        }

        /** The details for events with this `type`. */
        fun organizationUpdated(organizationUpdated: OrganizationUpdated) =
            organizationUpdated(JsonField.of(organizationUpdated))

        /**
         * Sets [Builder.organizationUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationUpdated] with a well-typed
         * [OrganizationUpdated] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun organizationUpdated(organizationUpdated: JsonField<OrganizationUpdated>) = apply {
            this.organizationUpdated = organizationUpdated
        }

        /**
         * The project that the action was scoped to. Absent for actions not scoped to projects.
         * Note that any admin actions taken via Admin API keys are associated with the default
         * project.
         */
        fun project(project: Project) = project(JsonField.of(project))

        /**
         * Sets [Builder.project] to an arbitrary JSON value.
         *
         * You should usually call [Builder.project] with a well-typed [Project] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun project(project: JsonField<Project>) = apply { this.project = project }

        /** The details for events with this `type`. */
        fun projectArchived(projectArchived: ProjectArchived) =
            projectArchived(JsonField.of(projectArchived))

        /**
         * Sets [Builder.projectArchived] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projectArchived] with a well-typed [ProjectArchived]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun projectArchived(projectArchived: JsonField<ProjectArchived>) = apply {
            this.projectArchived = projectArchived
        }

        /** The details for events with this `type`. */
        fun projectCreated(projectCreated: ProjectCreated) =
            projectCreated(JsonField.of(projectCreated))

        /**
         * Sets [Builder.projectCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projectCreated] with a well-typed [ProjectCreated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun projectCreated(projectCreated: JsonField<ProjectCreated>) = apply {
            this.projectCreated = projectCreated
        }

        /** The details for events with this `type`. */
        fun projectDeleted(projectDeleted: ProjectDeleted) =
            projectDeleted(JsonField.of(projectDeleted))

        /**
         * Sets [Builder.projectDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projectDeleted] with a well-typed [ProjectDeleted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun projectDeleted(projectDeleted: JsonField<ProjectDeleted>) = apply {
            this.projectDeleted = projectDeleted
        }

        /** The details for events with this `type`. */
        fun projectUpdated(projectUpdated: ProjectUpdated) =
            projectUpdated(JsonField.of(projectUpdated))

        /**
         * Sets [Builder.projectUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projectUpdated] with a well-typed [ProjectUpdated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun projectUpdated(projectUpdated: JsonField<ProjectUpdated>) = apply {
            this.projectUpdated = projectUpdated
        }

        /** The details for events with this `type`. */
        fun rateLimitDeleted(rateLimitDeleted: RateLimitDeleted) =
            rateLimitDeleted(JsonField.of(rateLimitDeleted))

        /**
         * Sets [Builder.rateLimitDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rateLimitDeleted] with a well-typed [RateLimitDeleted]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun rateLimitDeleted(rateLimitDeleted: JsonField<RateLimitDeleted>) = apply {
            this.rateLimitDeleted = rateLimitDeleted
        }

        /** The details for events with this `type`. */
        fun rateLimitUpdated(rateLimitUpdated: RateLimitUpdated) =
            rateLimitUpdated(JsonField.of(rateLimitUpdated))

        /**
         * Sets [Builder.rateLimitUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rateLimitUpdated] with a well-typed [RateLimitUpdated]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun rateLimitUpdated(rateLimitUpdated: JsonField<RateLimitUpdated>) = apply {
            this.rateLimitUpdated = rateLimitUpdated
        }

        /** The details for events with this `type`. */
        fun roleAssignmentCreated(roleAssignmentCreated: RoleAssignmentCreated) =
            roleAssignmentCreated(JsonField.of(roleAssignmentCreated))

        /**
         * Sets [Builder.roleAssignmentCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleAssignmentCreated] with a well-typed
         * [RoleAssignmentCreated] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun roleAssignmentCreated(roleAssignmentCreated: JsonField<RoleAssignmentCreated>) = apply {
            this.roleAssignmentCreated = roleAssignmentCreated
        }

        /** The details for events with this `type`. */
        fun roleAssignmentDeleted(roleAssignmentDeleted: RoleAssignmentDeleted) =
            roleAssignmentDeleted(JsonField.of(roleAssignmentDeleted))

        /**
         * Sets [Builder.roleAssignmentDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleAssignmentDeleted] with a well-typed
         * [RoleAssignmentDeleted] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun roleAssignmentDeleted(roleAssignmentDeleted: JsonField<RoleAssignmentDeleted>) = apply {
            this.roleAssignmentDeleted = roleAssignmentDeleted
        }

        /** The details for events with this `type`. */
        fun roleCreated(roleCreated: RoleCreated) = roleCreated(JsonField.of(roleCreated))

        /**
         * Sets [Builder.roleCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleCreated] with a well-typed [RoleCreated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun roleCreated(roleCreated: JsonField<RoleCreated>) = apply {
            this.roleCreated = roleCreated
        }

        /** The details for events with this `type`. */
        fun roleDeleted(roleDeleted: RoleDeleted) = roleDeleted(JsonField.of(roleDeleted))

        /**
         * Sets [Builder.roleDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleDeleted] with a well-typed [RoleDeleted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun roleDeleted(roleDeleted: JsonField<RoleDeleted>) = apply {
            this.roleDeleted = roleDeleted
        }

        /** The details for events with this `type`. */
        fun roleUpdated(roleUpdated: RoleUpdated) = roleUpdated(JsonField.of(roleUpdated))

        /**
         * Sets [Builder.roleUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roleUpdated] with a well-typed [RoleUpdated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun roleUpdated(roleUpdated: JsonField<RoleUpdated>) = apply {
            this.roleUpdated = roleUpdated
        }

        /** The details for events with this `type`. */
        fun scimDisabled(scimDisabled: ScimDisabled) = scimDisabled(JsonField.of(scimDisabled))

        /**
         * Sets [Builder.scimDisabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scimDisabled] with a well-typed [ScimDisabled] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scimDisabled(scimDisabled: JsonField<ScimDisabled>) = apply {
            this.scimDisabled = scimDisabled
        }

        /** The details for events with this `type`. */
        fun scimEnabled(scimEnabled: ScimEnabled) = scimEnabled(JsonField.of(scimEnabled))

        /**
         * Sets [Builder.scimEnabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scimEnabled] with a well-typed [ScimEnabled] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scimEnabled(scimEnabled: JsonField<ScimEnabled>) = apply {
            this.scimEnabled = scimEnabled
        }

        /** The details for events with this `type`. */
        fun serviceAccountCreated(serviceAccountCreated: ServiceAccountCreated) =
            serviceAccountCreated(JsonField.of(serviceAccountCreated))

        /**
         * Sets [Builder.serviceAccountCreated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceAccountCreated] with a well-typed
         * [ServiceAccountCreated] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun serviceAccountCreated(serviceAccountCreated: JsonField<ServiceAccountCreated>) = apply {
            this.serviceAccountCreated = serviceAccountCreated
        }

        /** The details for events with this `type`. */
        fun serviceAccountDeleted(serviceAccountDeleted: ServiceAccountDeleted) =
            serviceAccountDeleted(JsonField.of(serviceAccountDeleted))

        /**
         * Sets [Builder.serviceAccountDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceAccountDeleted] with a well-typed
         * [ServiceAccountDeleted] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun serviceAccountDeleted(serviceAccountDeleted: JsonField<ServiceAccountDeleted>) = apply {
            this.serviceAccountDeleted = serviceAccountDeleted
        }

        /** The details for events with this `type`. */
        fun serviceAccountUpdated(serviceAccountUpdated: ServiceAccountUpdated) =
            serviceAccountUpdated(JsonField.of(serviceAccountUpdated))

        /**
         * Sets [Builder.serviceAccountUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceAccountUpdated] with a well-typed
         * [ServiceAccountUpdated] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun serviceAccountUpdated(serviceAccountUpdated: JsonField<ServiceAccountUpdated>) = apply {
            this.serviceAccountUpdated = serviceAccountUpdated
        }

        /** The details for events with this `type`. */
        fun userAdded(userAdded: UserAdded) = userAdded(JsonField.of(userAdded))

        /**
         * Sets [Builder.userAdded] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userAdded] with a well-typed [UserAdded] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userAdded(userAdded: JsonField<UserAdded>) = apply { this.userAdded = userAdded }

        /** The details for events with this `type`. */
        fun userDeleted(userDeleted: UserDeleted) = userDeleted(JsonField.of(userDeleted))

        /**
         * Sets [Builder.userDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userDeleted] with a well-typed [UserDeleted] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun userDeleted(userDeleted: JsonField<UserDeleted>) = apply {
            this.userDeleted = userDeleted
        }

        /** The details for events with this `type`. */
        fun userUpdated(userUpdated: UserUpdated) = userUpdated(JsonField.of(userUpdated))

        /**
         * Sets [Builder.userUpdated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userUpdated] with a well-typed [UserUpdated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun userUpdated(userUpdated: JsonField<UserUpdated>) = apply {
            this.userUpdated = userUpdated
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
         * Returns an immutable instance of [AuditLogListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .actor()
         * .effectiveAt()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AuditLogListResponse =
            AuditLogListResponse(
                checkRequired("id", id),
                checkRequired("actor", actor),
                checkRequired("effectiveAt", effectiveAt),
                checkRequired("type", type),
                apiKeyCreated,
                apiKeyDeleted,
                apiKeyUpdated,
                certificateCreated,
                certificateDeleted,
                certificateUpdated,
                certificatesActivated,
                certificatesDeactivated,
                checkpointPermissionCreated,
                checkpointPermissionDeleted,
                externalKeyRegistered,
                externalKeyRemoved,
                groupCreated,
                groupDeleted,
                groupUpdated,
                inviteAccepted,
                inviteDeleted,
                inviteSent,
                ipAllowlistConfigActivated,
                ipAllowlistConfigDeactivated,
                ipAllowlistCreated,
                ipAllowlistDeleted,
                ipAllowlistUpdated,
                loginFailed,
                loginSucceeded,
                logoutFailed,
                logoutSucceeded,
                organizationUpdated,
                project,
                projectArchived,
                projectCreated,
                projectDeleted,
                projectUpdated,
                rateLimitDeleted,
                rateLimitUpdated,
                roleAssignmentCreated,
                roleAssignmentDeleted,
                roleCreated,
                roleDeleted,
                roleUpdated,
                scimDisabled,
                scimEnabled,
                serviceAccountCreated,
                serviceAccountDeleted,
                serviceAccountUpdated,
                userAdded,
                userDeleted,
                userUpdated,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AuditLogListResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        actor().validate()
        effectiveAt()
        type().validate()
        apiKeyCreated().ifPresent { it.validate() }
        apiKeyDeleted().ifPresent { it.validate() }
        apiKeyUpdated().ifPresent { it.validate() }
        certificateCreated().ifPresent { it.validate() }
        certificateDeleted().ifPresent { it.validate() }
        certificateUpdated().ifPresent { it.validate() }
        certificatesActivated().ifPresent { it.validate() }
        certificatesDeactivated().ifPresent { it.validate() }
        checkpointPermissionCreated().ifPresent { it.validate() }
        checkpointPermissionDeleted().ifPresent { it.validate() }
        externalKeyRegistered().ifPresent { it.validate() }
        externalKeyRemoved().ifPresent { it.validate() }
        groupCreated().ifPresent { it.validate() }
        groupDeleted().ifPresent { it.validate() }
        groupUpdated().ifPresent { it.validate() }
        inviteAccepted().ifPresent { it.validate() }
        inviteDeleted().ifPresent { it.validate() }
        inviteSent().ifPresent { it.validate() }
        ipAllowlistConfigActivated().ifPresent { it.validate() }
        ipAllowlistConfigDeactivated().ifPresent { it.validate() }
        ipAllowlistCreated().ifPresent { it.validate() }
        ipAllowlistDeleted().ifPresent { it.validate() }
        ipAllowlistUpdated().ifPresent { it.validate() }
        loginFailed().ifPresent { it.validate() }
        logoutFailed().ifPresent { it.validate() }
        organizationUpdated().ifPresent { it.validate() }
        project().ifPresent { it.validate() }
        projectArchived().ifPresent { it.validate() }
        projectCreated().ifPresent { it.validate() }
        projectDeleted().ifPresent { it.validate() }
        projectUpdated().ifPresent { it.validate() }
        rateLimitDeleted().ifPresent { it.validate() }
        rateLimitUpdated().ifPresent { it.validate() }
        roleAssignmentCreated().ifPresent { it.validate() }
        roleAssignmentDeleted().ifPresent { it.validate() }
        roleCreated().ifPresent { it.validate() }
        roleDeleted().ifPresent { it.validate() }
        roleUpdated().ifPresent { it.validate() }
        scimDisabled().ifPresent { it.validate() }
        scimEnabled().ifPresent { it.validate() }
        serviceAccountCreated().ifPresent { it.validate() }
        serviceAccountDeleted().ifPresent { it.validate() }
        serviceAccountUpdated().ifPresent { it.validate() }
        userAdded().ifPresent { it.validate() }
        userDeleted().ifPresent { it.validate() }
        userUpdated().ifPresent { it.validate() }
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (actor.asKnown().getOrNull()?.validity() ?: 0) +
            (if (effectiveAt.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (apiKeyCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (apiKeyDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (apiKeyUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (certificateCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (certificateDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (certificateUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (certificatesActivated.asKnown().getOrNull()?.validity() ?: 0) +
            (certificatesDeactivated.asKnown().getOrNull()?.validity() ?: 0) +
            (checkpointPermissionCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (checkpointPermissionDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (externalKeyRegistered.asKnown().getOrNull()?.validity() ?: 0) +
            (externalKeyRemoved.asKnown().getOrNull()?.validity() ?: 0) +
            (groupCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (groupDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (groupUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (inviteAccepted.asKnown().getOrNull()?.validity() ?: 0) +
            (inviteDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (inviteSent.asKnown().getOrNull()?.validity() ?: 0) +
            (ipAllowlistConfigActivated.asKnown().getOrNull()?.validity() ?: 0) +
            (ipAllowlistConfigDeactivated.asKnown().getOrNull()?.validity() ?: 0) +
            (ipAllowlistCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (ipAllowlistDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (ipAllowlistUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (loginFailed.asKnown().getOrNull()?.validity() ?: 0) +
            (logoutFailed.asKnown().getOrNull()?.validity() ?: 0) +
            (organizationUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (project.asKnown().getOrNull()?.validity() ?: 0) +
            (projectArchived.asKnown().getOrNull()?.validity() ?: 0) +
            (projectCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (projectDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (projectUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (rateLimitDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (rateLimitUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (roleAssignmentCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (roleAssignmentDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (roleCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (roleDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (roleUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (scimDisabled.asKnown().getOrNull()?.validity() ?: 0) +
            (scimEnabled.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceAccountCreated.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceAccountDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceAccountUpdated.asKnown().getOrNull()?.validity() ?: 0) +
            (userAdded.asKnown().getOrNull()?.validity() ?: 0) +
            (userDeleted.asKnown().getOrNull()?.validity() ?: 0) +
            (userUpdated.asKnown().getOrNull()?.validity() ?: 0)

    /** The actor who performed the audit logged action. */
    class Actor
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val apiKey: JsonField<ApiKey>,
        private val session: JsonField<Session>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("api_key") @ExcludeMissing apiKey: JsonField<ApiKey> = JsonMissing.of(),
            @JsonProperty("session") @ExcludeMissing session: JsonField<Session> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(apiKey, session, type, mutableMapOf())

        /**
         * The API Key used to perform the audit logged action.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun apiKey(): Optional<ApiKey> = apiKey.getOptional("api_key")

        /**
         * The session in which the audit logged action was performed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun session(): Optional<Session> = session.getOptional("session")

        /**
         * The type of actor. Is either `session` or `api_key`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [apiKey].
         *
         * Unlike [apiKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("api_key") @ExcludeMissing fun _apiKey(): JsonField<ApiKey> = apiKey

        /**
         * Returns the raw JSON value of [session].
         *
         * Unlike [session], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session") @ExcludeMissing fun _session(): JsonField<Session> = session

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

            /** Returns a mutable builder for constructing an instance of [Actor]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Actor]. */
        class Builder internal constructor() {

            private var apiKey: JsonField<ApiKey> = JsonMissing.of()
            private var session: JsonField<Session> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(actor: Actor) = apply {
                apiKey = actor.apiKey
                session = actor.session
                type = actor.type
                additionalProperties = actor.additionalProperties.toMutableMap()
            }

            /** The API Key used to perform the audit logged action. */
            fun apiKey(apiKey: ApiKey) = apiKey(JsonField.of(apiKey))

            /**
             * Sets [Builder.apiKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.apiKey] with a well-typed [ApiKey] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun apiKey(apiKey: JsonField<ApiKey>) = apply { this.apiKey = apiKey }

            /** The session in which the audit logged action was performed. */
            fun session(session: Session) = session(JsonField.of(session))

            /**
             * Sets [Builder.session] to an arbitrary JSON value.
             *
             * You should usually call [Builder.session] with a well-typed [Session] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun session(session: JsonField<Session>) = apply { this.session = session }

            /** The type of actor. Is either `session` or `api_key`. */
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
             * Returns an immutable instance of [Actor].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Actor = Actor(apiKey, session, type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Actor = apply {
            if (validated) {
                return@apply
            }

            apiKey().ifPresent { it.validate() }
            session().ifPresent { it.validate() }
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
            (apiKey.asKnown().getOrNull()?.validity() ?: 0) +
                (session.asKnown().getOrNull()?.validity() ?: 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** The API Key used to perform the audit logged action. */
        class ApiKey
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val serviceAccount: JsonField<ServiceAccount>,
            private val type: JsonField<Type>,
            private val user: JsonField<User>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("service_account")
                @ExcludeMissing
                serviceAccount: JsonField<ServiceAccount> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("user") @ExcludeMissing user: JsonField<User> = JsonMissing.of(),
            ) : this(id, serviceAccount, type, user, mutableMapOf())

            /**
             * The tracking id of the API key.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The service account that performed the audit logged action.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun serviceAccount(): Optional<ServiceAccount> =
                serviceAccount.getOptional("service_account")

            /**
             * The type of API key. Can be either `user` or `service_account`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

            /**
             * The user who performed the audit logged action.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun user(): Optional<User> = user.getOptional("user")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [serviceAccount].
             *
             * Unlike [serviceAccount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("service_account")
            @ExcludeMissing
            fun _serviceAccount(): JsonField<ServiceAccount> = serviceAccount

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [user].
             *
             * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<User> = user

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

                /** Returns a mutable builder for constructing an instance of [ApiKey]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ApiKey]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var serviceAccount: JsonField<ServiceAccount> = JsonMissing.of()
                private var type: JsonField<Type> = JsonMissing.of()
                private var user: JsonField<User> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(apiKey: ApiKey) = apply {
                    id = apiKey.id
                    serviceAccount = apiKey.serviceAccount
                    type = apiKey.type
                    user = apiKey.user
                    additionalProperties = apiKey.additionalProperties.toMutableMap()
                }

                /** The tracking id of the API key. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The service account that performed the audit logged action. */
                fun serviceAccount(serviceAccount: ServiceAccount) =
                    serviceAccount(JsonField.of(serviceAccount))

                /**
                 * Sets [Builder.serviceAccount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serviceAccount] with a well-typed
                 * [ServiceAccount] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun serviceAccount(serviceAccount: JsonField<ServiceAccount>) = apply {
                    this.serviceAccount = serviceAccount
                }

                /** The type of API key. Can be either `user` or `service_account`. */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** The user who performed the audit logged action. */
                fun user(user: User) = user(JsonField.of(user))

                /**
                 * Sets [Builder.user] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.user] with a well-typed [User] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun user(user: JsonField<User>) = apply { this.user = user }

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
                 * Returns an immutable instance of [ApiKey].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ApiKey =
                    ApiKey(id, serviceAccount, type, user, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ApiKey = apply {
                if (validated) {
                    return@apply
                }

                id()
                serviceAccount().ifPresent { it.validate() }
                type().ifPresent { it.validate() }
                user().ifPresent { it.validate() }
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (serviceAccount.asKnown().getOrNull()?.validity() ?: 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (user.asKnown().getOrNull()?.validity() ?: 0)

            /** The service account that performed the audit logged action. */
            class ServiceAccount
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
                 * The service account id.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<String> = id.getOptional("id")

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
                     * Returns a mutable builder for constructing an instance of [ServiceAccount].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ServiceAccount]. */
                class Builder internal constructor() {

                    private var id: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(serviceAccount: ServiceAccount) = apply {
                        id = serviceAccount.id
                        additionalProperties = serviceAccount.additionalProperties.toMutableMap()
                    }

                    /** The service account id. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [ServiceAccount].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): ServiceAccount =
                        ServiceAccount(id, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): ServiceAccount = apply {
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

                    return other is ServiceAccount &&
                        id == other.id &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ServiceAccount{id=$id, additionalProperties=$additionalProperties}"
            }

            /** The type of API key. Can be either `user` or `service_account`. */
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

                    @JvmField val USER = of("user")

                    @JvmField val SERVICE_ACCOUNT = of("service_account")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    USER,
                    SERVICE_ACCOUNT,
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
                    USER,
                    SERVICE_ACCOUNT,
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
                        USER -> Value.USER
                        SERVICE_ACCOUNT -> Value.SERVICE_ACCOUNT
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
                        USER -> Known.USER
                        SERVICE_ACCOUNT -> Known.SERVICE_ACCOUNT
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

            /** The user who performed the audit logged action. */
            class User
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val email: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("email")
                    @ExcludeMissing
                    email: JsonField<String> = JsonMissing.of(),
                ) : this(id, email, mutableMapOf())

                /**
                 * The user id.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<String> = id.getOptional("id")

                /**
                 * The user email.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun email(): Optional<String> = email.getOptional("email")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [email].
                 *
                 * Unlike [email], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

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

                    /** Returns a mutable builder for constructing an instance of [User]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [User]. */
                class Builder internal constructor() {

                    private var id: JsonField<String> = JsonMissing.of()
                    private var email: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(user: User) = apply {
                        id = user.id
                        email = user.email
                        additionalProperties = user.additionalProperties.toMutableMap()
                    }

                    /** The user id. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** The user email. */
                    fun email(email: String) = email(JsonField.of(email))

                    /**
                     * Sets [Builder.email] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.email] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun email(email: JsonField<String>) = apply { this.email = email }

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
                     * Returns an immutable instance of [User].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): User = User(id, email, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): User = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    email()
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
                    (if (id.asKnown().isPresent) 1 else 0) +
                        (if (email.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is User &&
                        id == other.id &&
                        email == other.email &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(id, email, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "User{id=$id, email=$email, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ApiKey &&
                    id == other.id &&
                    serviceAccount == other.serviceAccount &&
                    type == other.type &&
                    user == other.user &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, serviceAccount, type, user, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ApiKey{id=$id, serviceAccount=$serviceAccount, type=$type, user=$user, additionalProperties=$additionalProperties}"
        }

        /** The session in which the audit logged action was performed. */
        class Session
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val ipAddress: JsonField<String>,
            private val user: JsonField<User>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("ip_address")
                @ExcludeMissing
                ipAddress: JsonField<String> = JsonMissing.of(),
                @JsonProperty("user") @ExcludeMissing user: JsonField<User> = JsonMissing.of(),
            ) : this(ipAddress, user, mutableMapOf())

            /**
             * The IP address from which the action was performed.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun ipAddress(): Optional<String> = ipAddress.getOptional("ip_address")

            /**
             * The user who performed the audit logged action.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun user(): Optional<User> = user.getOptional("user")

            /**
             * Returns the raw JSON value of [ipAddress].
             *
             * Unlike [ipAddress], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("ip_address")
            @ExcludeMissing
            fun _ipAddress(): JsonField<String> = ipAddress

            /**
             * Returns the raw JSON value of [user].
             *
             * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<User> = user

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

                /** Returns a mutable builder for constructing an instance of [Session]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Session]. */
            class Builder internal constructor() {

                private var ipAddress: JsonField<String> = JsonMissing.of()
                private var user: JsonField<User> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(session: Session) = apply {
                    ipAddress = session.ipAddress
                    user = session.user
                    additionalProperties = session.additionalProperties.toMutableMap()
                }

                /** The IP address from which the action was performed. */
                fun ipAddress(ipAddress: String) = ipAddress(JsonField.of(ipAddress))

                /**
                 * Sets [Builder.ipAddress] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ipAddress] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun ipAddress(ipAddress: JsonField<String>) = apply { this.ipAddress = ipAddress }

                /** The user who performed the audit logged action. */
                fun user(user: User) = user(JsonField.of(user))

                /**
                 * Sets [Builder.user] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.user] with a well-typed [User] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun user(user: JsonField<User>) = apply { this.user = user }

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
                 * Returns an immutable instance of [Session].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Session = Session(ipAddress, user, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Session = apply {
                if (validated) {
                    return@apply
                }

                ipAddress()
                user().ifPresent { it.validate() }
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
                (if (ipAddress.asKnown().isPresent) 1 else 0) +
                    (user.asKnown().getOrNull()?.validity() ?: 0)

            /** The user who performed the audit logged action. */
            class User
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val email: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("email")
                    @ExcludeMissing
                    email: JsonField<String> = JsonMissing.of(),
                ) : this(id, email, mutableMapOf())

                /**
                 * The user id.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<String> = id.getOptional("id")

                /**
                 * The user email.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun email(): Optional<String> = email.getOptional("email")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [email].
                 *
                 * Unlike [email], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

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

                    /** Returns a mutable builder for constructing an instance of [User]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [User]. */
                class Builder internal constructor() {

                    private var id: JsonField<String> = JsonMissing.of()
                    private var email: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(user: User) = apply {
                        id = user.id
                        email = user.email
                        additionalProperties = user.additionalProperties.toMutableMap()
                    }

                    /** The user id. */
                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** The user email. */
                    fun email(email: String) = email(JsonField.of(email))

                    /**
                     * Sets [Builder.email] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.email] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun email(email: JsonField<String>) = apply { this.email = email }

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
                     * Returns an immutable instance of [User].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): User = User(id, email, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): User = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    email()
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
                    (if (id.asKnown().isPresent) 1 else 0) +
                        (if (email.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is User &&
                        id == other.id &&
                        email == other.email &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(id, email, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "User{id=$id, email=$email, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Session &&
                    ipAddress == other.ipAddress &&
                    user == other.user &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(ipAddress, user, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Session{ipAddress=$ipAddress, user=$user, additionalProperties=$additionalProperties}"
        }

        /** The type of actor. Is either `session` or `api_key`. */
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

                @JvmField val SESSION = of("session")

                @JvmField val API_KEY = of("api_key")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                SESSION,
                API_KEY,
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
                SESSION,
                API_KEY,
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
                    SESSION -> Value.SESSION
                    API_KEY -> Value.API_KEY
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
                    SESSION -> Known.SESSION
                    API_KEY -> Known.API_KEY
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

            return other is Actor &&
                apiKey == other.apiKey &&
                session == other.session &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(apiKey, session, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Actor{apiKey=$apiKey, session=$session, type=$type, additionalProperties=$additionalProperties}"
    }

    /** The event type. */
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

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
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
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
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

        private var validated: Boolean = false

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

    /** The details for events with this `type`. */
    class ApiKeyCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The tracking ID of the API key.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to create the API key.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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

            /** Returns a mutable builder for constructing an instance of [ApiKeyCreated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ApiKeyCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(apiKeyCreated: ApiKeyCreated) = apply {
                id = apiKeyCreated.id
                data = apiKeyCreated.data
                additionalProperties = apiKeyCreated.additionalProperties.toMutableMap()
            }

            /** The tracking ID of the API key. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to create the API key. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [ApiKeyCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ApiKeyCreated =
                ApiKeyCreated(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ApiKeyCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to create the API key. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val scopes: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("scopes")
                @ExcludeMissing
                scopes: JsonField<List<String>> = JsonMissing.of()
            ) : this(scopes, mutableMapOf())

            /**
             * A list of scopes allowed for the API key, e.g. `["api.model.request"]`
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun scopes(): Optional<List<String>> = scopes.getOptional("scopes")

            /**
             * Returns the raw JSON value of [scopes].
             *
             * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("scopes") @ExcludeMissing fun _scopes(): JsonField<List<String>> = scopes

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var scopes: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    scopes = data.scopes.map { it.toMutableList() }
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** A list of scopes allowed for the API key, e.g. `["api.model.request"]` */
                fun scopes(scopes: List<String>) = scopes(JsonField.of(scopes))

                /**
                 * Sets [Builder.scopes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.scopes] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun scopes(scopes: JsonField<List<String>>) = apply {
                    this.scopes = scopes.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [scopes].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addScope(scope: String) = apply {
                    scopes =
                        (scopes ?: JsonField.of(mutableListOf())).also {
                            checkKnown("scopes", it).add(scope)
                        }
                }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data =
                    Data(
                        (scopes ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                scopes()
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
            @JvmSynthetic internal fun validity(): Int = (scopes.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    scopes == other.scopes &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(scopes, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{scopes=$scopes, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ApiKeyCreated &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ApiKeyCreated{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ApiKeyDeleted
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
         * The tracking ID of the API key.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [ApiKeyDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ApiKeyDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(apiKeyDeleted: ApiKeyDeleted) = apply {
                id = apiKeyDeleted.id
                additionalProperties = apiKeyDeleted.additionalProperties.toMutableMap()
            }

            /** The tracking ID of the API key. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ApiKeyDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ApiKeyDeleted = ApiKeyDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ApiKeyDeleted = apply {
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

            return other is ApiKeyDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ApiKeyDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ApiKeyUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The tracking ID of the API key.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the API key.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [ApiKeyUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ApiKeyUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(apiKeyUpdated: ApiKeyUpdated) = apply {
                id = apiKeyUpdated.id
                changesRequested = apiKeyUpdated.changesRequested
                additionalProperties = apiKeyUpdated.additionalProperties.toMutableMap()
            }

            /** The tracking ID of the API key. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the API key. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [ApiKeyUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ApiKeyUpdated =
                ApiKeyUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ApiKeyUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the API key. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val scopes: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("scopes")
                @ExcludeMissing
                scopes: JsonField<List<String>> = JsonMissing.of()
            ) : this(scopes, mutableMapOf())

            /**
             * A list of scopes allowed for the API key, e.g. `["api.model.request"]`
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun scopes(): Optional<List<String>> = scopes.getOptional("scopes")

            /**
             * Returns the raw JSON value of [scopes].
             *
             * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("scopes") @ExcludeMissing fun _scopes(): JsonField<List<String>> = scopes

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var scopes: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    scopes = changesRequested.scopes.map { it.toMutableList() }
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** A list of scopes allowed for the API key, e.g. `["api.model.request"]` */
                fun scopes(scopes: List<String>) = scopes(JsonField.of(scopes))

                /**
                 * Sets [Builder.scopes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.scopes] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun scopes(scopes: JsonField<List<String>>) = apply {
                    this.scopes = scopes.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [scopes].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addScope(scope: String) = apply {
                    scopes =
                        (scopes ?: JsonField.of(mutableListOf())).also {
                            checkKnown("scopes", it).add(scope)
                        }
                }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(
                        (scopes ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                scopes()
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
            @JvmSynthetic internal fun validity(): Int = (scopes.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    scopes == other.scopes &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(scopes, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{scopes=$scopes, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ApiKeyUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ApiKeyUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class CertificateCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, name, mutableMapOf())

        /**
         * The certificate ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The name of the certificate.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [CertificateCreated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CertificateCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificateCreated: CertificateCreated) = apply {
                id = certificateCreated.id
                name = certificateCreated.name
                additionalProperties = certificateCreated.additionalProperties.toMutableMap()
            }

            /** The certificate ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The name of the certificate. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [CertificateCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CertificateCreated =
                CertificateCreated(id, name, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): CertificateCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificateCreated &&
                id == other.id &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificateCreated{id=$id, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class CertificateDeleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val certificate: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("certificate")
            @ExcludeMissing
            certificate: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, certificate, name, mutableMapOf())

        /**
         * The certificate ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The certificate content in PEM format.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun certificate(): Optional<String> = certificate.getOptional("certificate")

        /**
         * The name of the certificate.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [certificate].
         *
         * Unlike [certificate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("certificate")
        @ExcludeMissing
        fun _certificate(): JsonField<String> = certificate

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [CertificateDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CertificateDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var certificate: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificateDeleted: CertificateDeleted) = apply {
                id = certificateDeleted.id
                certificate = certificateDeleted.certificate
                name = certificateDeleted.name
                additionalProperties = certificateDeleted.additionalProperties.toMutableMap()
            }

            /** The certificate ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The certificate content in PEM format. */
            fun certificate(certificate: String) = certificate(JsonField.of(certificate))

            /**
             * Sets [Builder.certificate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.certificate] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun certificate(certificate: JsonField<String>) = apply {
                this.certificate = certificate
            }

            /** The name of the certificate. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [CertificateDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CertificateDeleted =
                CertificateDeleted(id, certificate, name, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): CertificateDeleted = apply {
            if (validated) {
                return@apply
            }

            id()
            certificate()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (certificate.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificateDeleted &&
                id == other.id &&
                certificate == other.certificate &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, certificate, name, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificateDeleted{id=$id, certificate=$certificate, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class CertificateUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, name, mutableMapOf())

        /**
         * The certificate ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The name of the certificate.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [CertificateUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CertificateUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificateUpdated: CertificateUpdated) = apply {
                id = certificateUpdated.id
                name = certificateUpdated.name
                additionalProperties = certificateUpdated.additionalProperties.toMutableMap()
            }

            /** The certificate ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The name of the certificate. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [CertificateUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CertificateUpdated =
                CertificateUpdated(id, name, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): CertificateUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificateUpdated &&
                id == other.id &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificateUpdated{id=$id, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class CertificatesActivated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val certificates: JsonField<List<Certificate>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("certificates")
            @ExcludeMissing
            certificates: JsonField<List<Certificate>> = JsonMissing.of()
        ) : this(certificates, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun certificates(): Optional<List<Certificate>> = certificates.getOptional("certificates")

        /**
         * Returns the raw JSON value of [certificates].
         *
         * Unlike [certificates], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("certificates")
        @ExcludeMissing
        fun _certificates(): JsonField<List<Certificate>> = certificates

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
             * Returns a mutable builder for constructing an instance of [CertificatesActivated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CertificatesActivated]. */
        class Builder internal constructor() {

            private var certificates: JsonField<MutableList<Certificate>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificatesActivated: CertificatesActivated) = apply {
                certificates = certificatesActivated.certificates.map { it.toMutableList() }
                additionalProperties = certificatesActivated.additionalProperties.toMutableMap()
            }

            fun certificates(certificates: List<Certificate>) =
                certificates(JsonField.of(certificates))

            /**
             * Sets [Builder.certificates] to an arbitrary JSON value.
             *
             * You should usually call [Builder.certificates] with a well-typed `List<Certificate>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun certificates(certificates: JsonField<List<Certificate>>) = apply {
                this.certificates = certificates.map { it.toMutableList() }
            }

            /**
             * Adds a single [Certificate] to [certificates].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCertificate(certificate: Certificate) = apply {
                certificates =
                    (certificates ?: JsonField.of(mutableListOf())).also {
                        checkKnown("certificates", it).add(certificate)
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
             * Returns an immutable instance of [CertificatesActivated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CertificatesActivated =
                CertificatesActivated(
                    (certificates ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CertificatesActivated = apply {
            if (validated) {
                return@apply
            }

            certificates().ifPresent { it.forEach { it.validate() } }
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
            (certificates.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class Certificate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, mutableMapOf())

            /**
             * The certificate ID.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The name of the certificate.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [Certificate]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Certificate]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(certificate: Certificate) = apply {
                    id = certificate.id
                    name = certificate.name
                    additionalProperties = certificate.additionalProperties.toMutableMap()
                }

                /** The certificate ID. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The name of the certificate. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [Certificate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Certificate =
                    Certificate(id, name, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Certificate = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
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
                (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Certificate &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Certificate{id=$id, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificatesActivated &&
                certificates == other.certificates &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(certificates, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificatesActivated{certificates=$certificates, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class CertificatesDeactivated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val certificates: JsonField<List<Certificate>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("certificates")
            @ExcludeMissing
            certificates: JsonField<List<Certificate>> = JsonMissing.of()
        ) : this(certificates, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun certificates(): Optional<List<Certificate>> = certificates.getOptional("certificates")

        /**
         * Returns the raw JSON value of [certificates].
         *
         * Unlike [certificates], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("certificates")
        @ExcludeMissing
        fun _certificates(): JsonField<List<Certificate>> = certificates

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
             * Returns a mutable builder for constructing an instance of [CertificatesDeactivated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CertificatesDeactivated]. */
        class Builder internal constructor() {

            private var certificates: JsonField<MutableList<Certificate>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(certificatesDeactivated: CertificatesDeactivated) = apply {
                certificates = certificatesDeactivated.certificates.map { it.toMutableList() }
                additionalProperties = certificatesDeactivated.additionalProperties.toMutableMap()
            }

            fun certificates(certificates: List<Certificate>) =
                certificates(JsonField.of(certificates))

            /**
             * Sets [Builder.certificates] to an arbitrary JSON value.
             *
             * You should usually call [Builder.certificates] with a well-typed `List<Certificate>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun certificates(certificates: JsonField<List<Certificate>>) = apply {
                this.certificates = certificates.map { it.toMutableList() }
            }

            /**
             * Adds a single [Certificate] to [certificates].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCertificate(certificate: Certificate) = apply {
                certificates =
                    (certificates ?: JsonField.of(mutableListOf())).also {
                        checkKnown("certificates", it).add(certificate)
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
             * Returns an immutable instance of [CertificatesDeactivated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CertificatesDeactivated =
                CertificatesDeactivated(
                    (certificates ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CertificatesDeactivated = apply {
            if (validated) {
                return@apply
            }

            certificates().ifPresent { it.forEach { it.validate() } }
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
            (certificates.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class Certificate
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, mutableMapOf())

            /**
             * The certificate ID.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The name of the certificate.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [Certificate]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Certificate]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(certificate: Certificate) = apply {
                    id = certificate.id
                    name = certificate.name
                    additionalProperties = certificate.additionalProperties.toMutableMap()
                }

                /** The certificate ID. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The name of the certificate. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [Certificate].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Certificate =
                    Certificate(id, name, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Certificate = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
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
                (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Certificate &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Certificate{id=$id, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CertificatesDeactivated &&
                certificates == other.certificates &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(certificates, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CertificatesDeactivated{certificates=$certificates, additionalProperties=$additionalProperties}"
    }

    /**
     * The project and fine-tuned model checkpoint that the checkpoint permission was created for.
     */
    class CheckpointPermissionCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The ID of the checkpoint permission.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to create the checkpoint permission.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
             * [CheckpointPermissionCreated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CheckpointPermissionCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(checkpointPermissionCreated: CheckpointPermissionCreated) = apply {
                id = checkpointPermissionCreated.id
                data = checkpointPermissionCreated.data
                additionalProperties =
                    checkpointPermissionCreated.additionalProperties.toMutableMap()
            }

            /** The ID of the checkpoint permission. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to create the checkpoint permission. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [CheckpointPermissionCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CheckpointPermissionCreated =
                CheckpointPermissionCreated(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): CheckpointPermissionCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to create the checkpoint permission. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val fineTunedModelCheckpoint: JsonField<String>,
            private val projectId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("fine_tuned_model_checkpoint")
                @ExcludeMissing
                fineTunedModelCheckpoint: JsonField<String> = JsonMissing.of(),
                @JsonProperty("project_id")
                @ExcludeMissing
                projectId: JsonField<String> = JsonMissing.of(),
            ) : this(fineTunedModelCheckpoint, projectId, mutableMapOf())

            /**
             * The ID of the fine-tuned model checkpoint.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fineTunedModelCheckpoint(): Optional<String> =
                fineTunedModelCheckpoint.getOptional("fine_tuned_model_checkpoint")

            /**
             * The ID of the project that the checkpoint permission was created for.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun projectId(): Optional<String> = projectId.getOptional("project_id")

            /**
             * Returns the raw JSON value of [fineTunedModelCheckpoint].
             *
             * Unlike [fineTunedModelCheckpoint], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("fine_tuned_model_checkpoint")
            @ExcludeMissing
            fun _fineTunedModelCheckpoint(): JsonField<String> = fineTunedModelCheckpoint

            /**
             * Returns the raw JSON value of [projectId].
             *
             * Unlike [projectId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("project_id")
            @ExcludeMissing
            fun _projectId(): JsonField<String> = projectId

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var fineTunedModelCheckpoint: JsonField<String> = JsonMissing.of()
                private var projectId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    fineTunedModelCheckpoint = data.fineTunedModelCheckpoint
                    projectId = data.projectId
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** The ID of the fine-tuned model checkpoint. */
                fun fineTunedModelCheckpoint(fineTunedModelCheckpoint: String) =
                    fineTunedModelCheckpoint(JsonField.of(fineTunedModelCheckpoint))

                /**
                 * Sets [Builder.fineTunedModelCheckpoint] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fineTunedModelCheckpoint] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun fineTunedModelCheckpoint(fineTunedModelCheckpoint: JsonField<String>) = apply {
                    this.fineTunedModelCheckpoint = fineTunedModelCheckpoint
                }

                /** The ID of the project that the checkpoint permission was created for. */
                fun projectId(projectId: String) = projectId(JsonField.of(projectId))

                /**
                 * Sets [Builder.projectId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.projectId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun projectId(projectId: JsonField<String>) = apply { this.projectId = projectId }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data =
                    Data(fineTunedModelCheckpoint, projectId, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                fineTunedModelCheckpoint()
                projectId()
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
                (if (fineTunedModelCheckpoint.asKnown().isPresent) 1 else 0) +
                    (if (projectId.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    fineTunedModelCheckpoint == other.fineTunedModelCheckpoint &&
                    projectId == other.projectId &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(fineTunedModelCheckpoint, projectId, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{fineTunedModelCheckpoint=$fineTunedModelCheckpoint, projectId=$projectId, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CheckpointPermissionCreated &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CheckpointPermissionCreated{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class CheckpointPermissionDeleted
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
         * The ID of the checkpoint permission.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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
             * Returns a mutable builder for constructing an instance of
             * [CheckpointPermissionDeleted].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CheckpointPermissionDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(checkpointPermissionDeleted: CheckpointPermissionDeleted) = apply {
                id = checkpointPermissionDeleted.id
                additionalProperties =
                    checkpointPermissionDeleted.additionalProperties.toMutableMap()
            }

            /** The ID of the checkpoint permission. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [CheckpointPermissionDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CheckpointPermissionDeleted =
                CheckpointPermissionDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): CheckpointPermissionDeleted = apply {
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

            return other is CheckpointPermissionDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CheckpointPermissionDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ExternalKeyRegistered
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The ID of the external key configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The configuration for the external key.
         *
         * This arbitrary value can be deserialized into a custom type using the `convert` method:
         * ```java
         * MyClass myObject = externalKeyRegistered.data().convert(MyClass.class);
         * ```
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

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
             * Returns a mutable builder for constructing an instance of [ExternalKeyRegistered].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExternalKeyRegistered]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(externalKeyRegistered: ExternalKeyRegistered) = apply {
                id = externalKeyRegistered.id
                data = externalKeyRegistered.data
                additionalProperties = externalKeyRegistered.additionalProperties.toMutableMap()
            }

            /** The ID of the external key configuration. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The configuration for the external key. */
            fun data(data: JsonValue) = apply { this.data = data }

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
             * Returns an immutable instance of [ExternalKeyRegistered].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ExternalKeyRegistered =
                ExternalKeyRegistered(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ExternalKeyRegistered = apply {
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

            return other is ExternalKeyRegistered &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExternalKeyRegistered{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ExternalKeyRemoved
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
         * The ID of the external key configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [ExternalKeyRemoved]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExternalKeyRemoved]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(externalKeyRemoved: ExternalKeyRemoved) = apply {
                id = externalKeyRemoved.id
                additionalProperties = externalKeyRemoved.additionalProperties.toMutableMap()
            }

            /** The ID of the external key configuration. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ExternalKeyRemoved].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ExternalKeyRemoved =
                ExternalKeyRemoved(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ExternalKeyRemoved = apply {
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

            return other is ExternalKeyRemoved &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExternalKeyRemoved{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class GroupCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The ID of the group.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Information about the created group.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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

            /** Returns a mutable builder for constructing an instance of [GroupCreated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GroupCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(groupCreated: GroupCreated) = apply {
                id = groupCreated.id
                data = groupCreated.data
                additionalProperties = groupCreated.additionalProperties.toMutableMap()
            }

            /** The ID of the group. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Information about the created group. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [GroupCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): GroupCreated = GroupCreated(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): GroupCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** Information about the created group. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val groupName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("group_name")
                @ExcludeMissing
                groupName: JsonField<String> = JsonMissing.of()
            ) : this(groupName, mutableMapOf())

            /**
             * The group name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun groupName(): Optional<String> = groupName.getOptional("group_name")

            /**
             * Returns the raw JSON value of [groupName].
             *
             * Unlike [groupName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("group_name")
            @ExcludeMissing
            fun _groupName(): JsonField<String> = groupName

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var groupName: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    groupName = data.groupName
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** The group name. */
                fun groupName(groupName: String) = groupName(JsonField.of(groupName))

                /**
                 * Sets [Builder.groupName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.groupName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun groupName(groupName: JsonField<String>) = apply { this.groupName = groupName }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data = Data(groupName, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                groupName()
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
            internal fun validity(): Int = (if (groupName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    groupName == other.groupName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(groupName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{groupName=$groupName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GroupCreated &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "GroupCreated{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class GroupDeleted
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
         * The ID of the group.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [GroupDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GroupDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(groupDeleted: GroupDeleted) = apply {
                id = groupDeleted.id
                additionalProperties = groupDeleted.additionalProperties.toMutableMap()
            }

            /** The ID of the group. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [GroupDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): GroupDeleted = GroupDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): GroupDeleted = apply {
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

            return other is GroupDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "GroupDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class GroupUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The ID of the group.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the group.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [GroupUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [GroupUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(groupUpdated: GroupUpdated) = apply {
                id = groupUpdated.id
                changesRequested = groupUpdated.changesRequested
                additionalProperties = groupUpdated.additionalProperties.toMutableMap()
            }

            /** The ID of the group. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the group. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [GroupUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): GroupUpdated =
                GroupUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): GroupUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the group. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val groupName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("group_name")
                @ExcludeMissing
                groupName: JsonField<String> = JsonMissing.of()
            ) : this(groupName, mutableMapOf())

            /**
             * The updated group name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun groupName(): Optional<String> = groupName.getOptional("group_name")

            /**
             * Returns the raw JSON value of [groupName].
             *
             * Unlike [groupName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("group_name")
            @ExcludeMissing
            fun _groupName(): JsonField<String> = groupName

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var groupName: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    groupName = changesRequested.groupName
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** The updated group name. */
                fun groupName(groupName: String) = groupName(JsonField.of(groupName))

                /**
                 * Sets [Builder.groupName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.groupName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun groupName(groupName: JsonField<String>) = apply { this.groupName = groupName }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(groupName, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                groupName()
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
            internal fun validity(): Int = (if (groupName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    groupName == other.groupName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(groupName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{groupName=$groupName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GroupUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "GroupUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class InviteAccepted
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
         * The ID of the invite.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [InviteAccepted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InviteAccepted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inviteAccepted: InviteAccepted) = apply {
                id = inviteAccepted.id
                additionalProperties = inviteAccepted.additionalProperties.toMutableMap()
            }

            /** The ID of the invite. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [InviteAccepted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InviteAccepted = InviteAccepted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): InviteAccepted = apply {
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

            return other is InviteAccepted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InviteAccepted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class InviteDeleted
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
         * The ID of the invite.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [InviteDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InviteDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inviteDeleted: InviteDeleted) = apply {
                id = inviteDeleted.id
                additionalProperties = inviteDeleted.additionalProperties.toMutableMap()
            }

            /** The ID of the invite. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [InviteDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InviteDeleted = InviteDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): InviteDeleted = apply {
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

            return other is InviteDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InviteDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class InviteSent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The ID of the invite.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to create the invite.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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

            /** Returns a mutable builder for constructing an instance of [InviteSent]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InviteSent]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inviteSent: InviteSent) = apply {
                id = inviteSent.id
                data = inviteSent.data
                additionalProperties = inviteSent.additionalProperties.toMutableMap()
            }

            /** The ID of the invite. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to create the invite. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [InviteSent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InviteSent = InviteSent(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): InviteSent = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to create the invite. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val email: JsonField<String>,
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            ) : this(email, role, mutableMapOf())

            /**
             * The email invited to the organization.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun email(): Optional<String> = email.getOptional("email")

            /**
             * The role the email was invited to be. Is either `owner` or `member`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [email].
             *
             * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var email: JsonField<String> = JsonMissing.of()
                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    email = data.email
                    role = data.role
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** The email invited to the organization. */
                fun email(email: String) = email(JsonField.of(email))

                /**
                 * Sets [Builder.email] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.email] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun email(email: JsonField<String>) = apply { this.email = email }

                /** The role the email was invited to be. Is either `owner` or `member`. */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data = Data(email, role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                email()
                role()
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
                (if (email.asKnown().isPresent) 1 else 0) + (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    email == other.email &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(email, role, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{email=$email, role=$role, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InviteSent &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InviteSent{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class IpAllowlistConfigActivated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val configs: JsonField<List<Config>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("configs")
            @ExcludeMissing
            configs: JsonField<List<Config>> = JsonMissing.of()
        ) : this(configs, mutableMapOf())

        /**
         * The configurations that were activated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun configs(): Optional<List<Config>> = configs.getOptional("configs")

        /**
         * Returns the raw JSON value of [configs].
         *
         * Unlike [configs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("configs") @ExcludeMissing fun _configs(): JsonField<List<Config>> = configs

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
             * [IpAllowlistConfigActivated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IpAllowlistConfigActivated]. */
        class Builder internal constructor() {

            private var configs: JsonField<MutableList<Config>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ipAllowlistConfigActivated: IpAllowlistConfigActivated) = apply {
                configs = ipAllowlistConfigActivated.configs.map { it.toMutableList() }
                additionalProperties =
                    ipAllowlistConfigActivated.additionalProperties.toMutableMap()
            }

            /** The configurations that were activated. */
            fun configs(configs: List<Config>) = configs(JsonField.of(configs))

            /**
             * Sets [Builder.configs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.configs] with a well-typed `List<Config>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun configs(configs: JsonField<List<Config>>) = apply {
                this.configs = configs.map { it.toMutableList() }
            }

            /**
             * Adds a single [Config] to [configs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addConfig(config: Config) = apply {
                configs =
                    (configs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("configs", it).add(config)
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
             * Returns an immutable instance of [IpAllowlistConfigActivated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IpAllowlistConfigActivated =
                IpAllowlistConfigActivated(
                    (configs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): IpAllowlistConfigActivated = apply {
            if (validated) {
                return@apply
            }

            configs().ifPresent { it.forEach { it.validate() } }
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
            (configs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class Config
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, mutableMapOf())

            /**
             * The ID of the IP allowlist configuration.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The name of the IP allowlist configuration.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [Config]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Config]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(config: Config) = apply {
                    id = config.id
                    name = config.name
                    additionalProperties = config.additionalProperties.toMutableMap()
                }

                /** The ID of the IP allowlist configuration. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The name of the IP allowlist configuration. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [Config].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Config = Config(id, name, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Config = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
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
                (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Config &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Config{id=$id, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IpAllowlistConfigActivated &&
                configs == other.configs &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(configs, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IpAllowlistConfigActivated{configs=$configs, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class IpAllowlistConfigDeactivated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val configs: JsonField<List<Config>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("configs")
            @ExcludeMissing
            configs: JsonField<List<Config>> = JsonMissing.of()
        ) : this(configs, mutableMapOf())

        /**
         * The configurations that were deactivated.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun configs(): Optional<List<Config>> = configs.getOptional("configs")

        /**
         * Returns the raw JSON value of [configs].
         *
         * Unlike [configs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("configs") @ExcludeMissing fun _configs(): JsonField<List<Config>> = configs

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
             * [IpAllowlistConfigDeactivated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IpAllowlistConfigDeactivated]. */
        class Builder internal constructor() {

            private var configs: JsonField<MutableList<Config>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ipAllowlistConfigDeactivated: IpAllowlistConfigDeactivated) = apply {
                configs = ipAllowlistConfigDeactivated.configs.map { it.toMutableList() }
                additionalProperties =
                    ipAllowlistConfigDeactivated.additionalProperties.toMutableMap()
            }

            /** The configurations that were deactivated. */
            fun configs(configs: List<Config>) = configs(JsonField.of(configs))

            /**
             * Sets [Builder.configs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.configs] with a well-typed `List<Config>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun configs(configs: JsonField<List<Config>>) = apply {
                this.configs = configs.map { it.toMutableList() }
            }

            /**
             * Adds a single [Config] to [configs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addConfig(config: Config) = apply {
                configs =
                    (configs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("configs", it).add(config)
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
             * Returns an immutable instance of [IpAllowlistConfigDeactivated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IpAllowlistConfigDeactivated =
                IpAllowlistConfigDeactivated(
                    (configs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): IpAllowlistConfigDeactivated = apply {
            if (validated) {
                return@apply
            }

            configs().ifPresent { it.forEach { it.validate() } }
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
            (configs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class Config
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, mutableMapOf())

            /**
             * The ID of the IP allowlist configuration.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The name of the IP allowlist configuration.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [Config]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Config]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(config: Config) = apply {
                    id = config.id
                    name = config.name
                    additionalProperties = config.additionalProperties.toMutableMap()
                }

                /** The ID of the IP allowlist configuration. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The name of the IP allowlist configuration. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [Config].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Config = Config(id, name, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Config = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
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
                (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Config &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Config{id=$id, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IpAllowlistConfigDeactivated &&
                configs == other.configs &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(configs, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IpAllowlistConfigDeactivated{configs=$configs, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class IpAllowlistCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val allowedIps: JsonField<List<String>>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("allowed_ips")
            @ExcludeMissing
            allowedIps: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, allowedIps, name, mutableMapOf())

        /**
         * The ID of the IP allowlist configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The IP addresses or CIDR ranges included in the configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedIps(): Optional<List<String>> = allowedIps.getOptional("allowed_ips")

        /**
         * The name of the IP allowlist configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [allowedIps].
         *
         * Unlike [allowedIps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("allowed_ips")
        @ExcludeMissing
        fun _allowedIps(): JsonField<List<String>> = allowedIps

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [IpAllowlistCreated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IpAllowlistCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var allowedIps: JsonField<MutableList<String>>? = null
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ipAllowlistCreated: IpAllowlistCreated) = apply {
                id = ipAllowlistCreated.id
                allowedIps = ipAllowlistCreated.allowedIps.map { it.toMutableList() }
                name = ipAllowlistCreated.name
                additionalProperties = ipAllowlistCreated.additionalProperties.toMutableMap()
            }

            /** The ID of the IP allowlist configuration. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The IP addresses or CIDR ranges included in the configuration. */
            fun allowedIps(allowedIps: List<String>) = allowedIps(JsonField.of(allowedIps))

            /**
             * Sets [Builder.allowedIps] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedIps] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun allowedIps(allowedIps: JsonField<List<String>>) = apply {
                this.allowedIps = allowedIps.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedIps].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedIp(allowedIp: String) = apply {
                allowedIps =
                    (allowedIps ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedIps", it).add(allowedIp)
                    }
            }

            /** The name of the IP allowlist configuration. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [IpAllowlistCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IpAllowlistCreated =
                IpAllowlistCreated(
                    id,
                    (allowedIps ?: JsonMissing.of()).map { it.toImmutable() },
                    name,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): IpAllowlistCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            allowedIps()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (allowedIps.asKnown().getOrNull()?.size ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IpAllowlistCreated &&
                id == other.id &&
                allowedIps == other.allowedIps &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, allowedIps, name, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IpAllowlistCreated{id=$id, allowedIps=$allowedIps, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class IpAllowlistDeleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val allowedIps: JsonField<List<String>>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("allowed_ips")
            @ExcludeMissing
            allowedIps: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, allowedIps, name, mutableMapOf())

        /**
         * The ID of the IP allowlist configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The IP addresses or CIDR ranges that were in the configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedIps(): Optional<List<String>> = allowedIps.getOptional("allowed_ips")

        /**
         * The name of the IP allowlist configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [allowedIps].
         *
         * Unlike [allowedIps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("allowed_ips")
        @ExcludeMissing
        fun _allowedIps(): JsonField<List<String>> = allowedIps

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [IpAllowlistDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IpAllowlistDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var allowedIps: JsonField<MutableList<String>>? = null
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ipAllowlistDeleted: IpAllowlistDeleted) = apply {
                id = ipAllowlistDeleted.id
                allowedIps = ipAllowlistDeleted.allowedIps.map { it.toMutableList() }
                name = ipAllowlistDeleted.name
                additionalProperties = ipAllowlistDeleted.additionalProperties.toMutableMap()
            }

            /** The ID of the IP allowlist configuration. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The IP addresses or CIDR ranges that were in the configuration. */
            fun allowedIps(allowedIps: List<String>) = allowedIps(JsonField.of(allowedIps))

            /**
             * Sets [Builder.allowedIps] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedIps] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun allowedIps(allowedIps: JsonField<List<String>>) = apply {
                this.allowedIps = allowedIps.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedIps].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedIp(allowedIp: String) = apply {
                allowedIps =
                    (allowedIps ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedIps", it).add(allowedIp)
                    }
            }

            /** The name of the IP allowlist configuration. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [IpAllowlistDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IpAllowlistDeleted =
                IpAllowlistDeleted(
                    id,
                    (allowedIps ?: JsonMissing.of()).map { it.toImmutable() },
                    name,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): IpAllowlistDeleted = apply {
            if (validated) {
                return@apply
            }

            id()
            allowedIps()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (allowedIps.asKnown().getOrNull()?.size ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IpAllowlistDeleted &&
                id == other.id &&
                allowedIps == other.allowedIps &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, allowedIps, name, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IpAllowlistDeleted{id=$id, allowedIps=$allowedIps, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class IpAllowlistUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val allowedIps: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("allowed_ips")
            @ExcludeMissing
            allowedIps: JsonField<List<String>> = JsonMissing.of(),
        ) : this(id, allowedIps, mutableMapOf())

        /**
         * The ID of the IP allowlist configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The updated set of IP addresses or CIDR ranges in the configuration.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedIps(): Optional<List<String>> = allowedIps.getOptional("allowed_ips")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [allowedIps].
         *
         * Unlike [allowedIps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("allowed_ips")
        @ExcludeMissing
        fun _allowedIps(): JsonField<List<String>> = allowedIps

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

            /** Returns a mutable builder for constructing an instance of [IpAllowlistUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [IpAllowlistUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var allowedIps: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ipAllowlistUpdated: IpAllowlistUpdated) = apply {
                id = ipAllowlistUpdated.id
                allowedIps = ipAllowlistUpdated.allowedIps.map { it.toMutableList() }
                additionalProperties = ipAllowlistUpdated.additionalProperties.toMutableMap()
            }

            /** The ID of the IP allowlist configuration. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The updated set of IP addresses or CIDR ranges in the configuration. */
            fun allowedIps(allowedIps: List<String>) = allowedIps(JsonField.of(allowedIps))

            /**
             * Sets [Builder.allowedIps] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedIps] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun allowedIps(allowedIps: JsonField<List<String>>) = apply {
                this.allowedIps = allowedIps.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedIps].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedIp(allowedIp: String) = apply {
                allowedIps =
                    (allowedIps ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedIps", it).add(allowedIp)
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
             * Returns an immutable instance of [IpAllowlistUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): IpAllowlistUpdated =
                IpAllowlistUpdated(
                    id,
                    (allowedIps ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): IpAllowlistUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            allowedIps()
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
            (if (id.asKnown().isPresent) 1 else 0) + (allowedIps.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is IpAllowlistUpdated &&
                id == other.id &&
                allowedIps == other.allowedIps &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, allowedIps, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "IpAllowlistUpdated{id=$id, allowedIps=$allowedIps, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class LoginFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val errorCode: JsonField<String>,
        private val errorMessage: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error_code")
            @ExcludeMissing
            errorCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("error_message")
            @ExcludeMissing
            errorMessage: JsonField<String> = JsonMissing.of(),
        ) : this(errorCode, errorMessage, mutableMapOf())

        /**
         * The error code of the failure.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun errorCode(): Optional<String> = errorCode.getOptional("error_code")

        /**
         * The error message of the failure.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun errorMessage(): Optional<String> = errorMessage.getOptional("error_message")

        /**
         * Returns the raw JSON value of [errorCode].
         *
         * Unlike [errorCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error_code") @ExcludeMissing fun _errorCode(): JsonField<String> = errorCode

        /**
         * Returns the raw JSON value of [errorMessage].
         *
         * Unlike [errorMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("error_message")
        @ExcludeMissing
        fun _errorMessage(): JsonField<String> = errorMessage

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

            /** Returns a mutable builder for constructing an instance of [LoginFailed]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LoginFailed]. */
        class Builder internal constructor() {

            private var errorCode: JsonField<String> = JsonMissing.of()
            private var errorMessage: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(loginFailed: LoginFailed) = apply {
                errorCode = loginFailed.errorCode
                errorMessage = loginFailed.errorMessage
                additionalProperties = loginFailed.additionalProperties.toMutableMap()
            }

            /** The error code of the failure. */
            fun errorCode(errorCode: String) = errorCode(JsonField.of(errorCode))

            /**
             * Sets [Builder.errorCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorCode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorCode(errorCode: JsonField<String>) = apply { this.errorCode = errorCode }

            /** The error message of the failure. */
            fun errorMessage(errorMessage: String) = errorMessage(JsonField.of(errorMessage))

            /**
             * Sets [Builder.errorMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorMessage(errorMessage: JsonField<String>) = apply {
                this.errorMessage = errorMessage
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
             * Returns an immutable instance of [LoginFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): LoginFailed =
                LoginFailed(errorCode, errorMessage, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): LoginFailed = apply {
            if (validated) {
                return@apply
            }

            errorCode()
            errorMessage()
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
            (if (errorCode.asKnown().isPresent) 1 else 0) +
                (if (errorMessage.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LoginFailed &&
                errorCode == other.errorCode &&
                errorMessage == other.errorMessage &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(errorCode, errorMessage, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LoginFailed{errorCode=$errorCode, errorMessage=$errorMessage, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class LogoutFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val errorCode: JsonField<String>,
        private val errorMessage: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("error_code")
            @ExcludeMissing
            errorCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("error_message")
            @ExcludeMissing
            errorMessage: JsonField<String> = JsonMissing.of(),
        ) : this(errorCode, errorMessage, mutableMapOf())

        /**
         * The error code of the failure.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun errorCode(): Optional<String> = errorCode.getOptional("error_code")

        /**
         * The error message of the failure.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun errorMessage(): Optional<String> = errorMessage.getOptional("error_message")

        /**
         * Returns the raw JSON value of [errorCode].
         *
         * Unlike [errorCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error_code") @ExcludeMissing fun _errorCode(): JsonField<String> = errorCode

        /**
         * Returns the raw JSON value of [errorMessage].
         *
         * Unlike [errorMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("error_message")
        @ExcludeMissing
        fun _errorMessage(): JsonField<String> = errorMessage

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

            /** Returns a mutable builder for constructing an instance of [LogoutFailed]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LogoutFailed]. */
        class Builder internal constructor() {

            private var errorCode: JsonField<String> = JsonMissing.of()
            private var errorMessage: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logoutFailed: LogoutFailed) = apply {
                errorCode = logoutFailed.errorCode
                errorMessage = logoutFailed.errorMessage
                additionalProperties = logoutFailed.additionalProperties.toMutableMap()
            }

            /** The error code of the failure. */
            fun errorCode(errorCode: String) = errorCode(JsonField.of(errorCode))

            /**
             * Sets [Builder.errorCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorCode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorCode(errorCode: JsonField<String>) = apply { this.errorCode = errorCode }

            /** The error message of the failure. */
            fun errorMessage(errorMessage: String) = errorMessage(JsonField.of(errorMessage))

            /**
             * Sets [Builder.errorMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorMessage(errorMessage: JsonField<String>) = apply {
                this.errorMessage = errorMessage
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
             * Returns an immutable instance of [LogoutFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): LogoutFailed =
                LogoutFailed(errorCode, errorMessage, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): LogoutFailed = apply {
            if (validated) {
                return@apply
            }

            errorCode()
            errorMessage()
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
            (if (errorCode.asKnown().isPresent) 1 else 0) +
                (if (errorMessage.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LogoutFailed &&
                errorCode == other.errorCode &&
                errorMessage == other.errorMessage &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(errorCode, errorMessage, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LogoutFailed{errorCode=$errorCode, errorMessage=$errorMessage, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class OrganizationUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The organization ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the organization settings.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [OrganizationUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OrganizationUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(organizationUpdated: OrganizationUpdated) = apply {
                id = organizationUpdated.id
                changesRequested = organizationUpdated.changesRequested
                additionalProperties = organizationUpdated.additionalProperties.toMutableMap()
            }

            /** The organization ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the organization settings. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [OrganizationUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): OrganizationUpdated =
                OrganizationUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): OrganizationUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the organization settings. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val apiCallLogging: JsonField<String>,
            private val apiCallLoggingProjectIds: JsonField<String>,
            private val description: JsonField<String>,
            private val name: JsonField<String>,
            private val threadsUiVisibility: JsonField<String>,
            private val title: JsonField<String>,
            private val usageDashboardVisibility: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("api_call_logging")
                @ExcludeMissing
                apiCallLogging: JsonField<String> = JsonMissing.of(),
                @JsonProperty("api_call_logging_project_ids")
                @ExcludeMissing
                apiCallLoggingProjectIds: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("threads_ui_visibility")
                @ExcludeMissing
                threadsUiVisibility: JsonField<String> = JsonMissing.of(),
                @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
                @JsonProperty("usage_dashboard_visibility")
                @ExcludeMissing
                usageDashboardVisibility: JsonField<String> = JsonMissing.of(),
            ) : this(
                apiCallLogging,
                apiCallLoggingProjectIds,
                description,
                name,
                threadsUiVisibility,
                title,
                usageDashboardVisibility,
                mutableMapOf(),
            )

            /**
             * How your organization logs data from supported API calls. One of `disabled`,
             * `enabled_per_call`, `enabled_for_all_projects`, or `enabled_for_selected_projects`
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun apiCallLogging(): Optional<String> = apiCallLogging.getOptional("api_call_logging")

            /**
             * The list of project ids if api_call_logging is set to `enabled_for_selected_projects`
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun apiCallLoggingProjectIds(): Optional<String> =
                apiCallLoggingProjectIds.getOptional("api_call_logging_project_ids")

            /**
             * The organization description.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * The organization name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Visibility of the threads page which shows messages created with the Assistants API
             * and Playground. One of `ANY_ROLE`, `OWNERS`, or `NONE`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun threadsUiVisibility(): Optional<String> =
                threadsUiVisibility.getOptional("threads_ui_visibility")

            /**
             * The organization title.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun title(): Optional<String> = title.getOptional("title")

            /**
             * Visibility of the usage dashboard which shows activity and costs for your
             * organization. One of `ANY_ROLE` or `OWNERS`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun usageDashboardVisibility(): Optional<String> =
                usageDashboardVisibility.getOptional("usage_dashboard_visibility")

            /**
             * Returns the raw JSON value of [apiCallLogging].
             *
             * Unlike [apiCallLogging], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("api_call_logging")
            @ExcludeMissing
            fun _apiCallLogging(): JsonField<String> = apiCallLogging

            /**
             * Returns the raw JSON value of [apiCallLoggingProjectIds].
             *
             * Unlike [apiCallLoggingProjectIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("api_call_logging_project_ids")
            @ExcludeMissing
            fun _apiCallLoggingProjectIds(): JsonField<String> = apiCallLoggingProjectIds

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [threadsUiVisibility].
             *
             * Unlike [threadsUiVisibility], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("threads_ui_visibility")
            @ExcludeMissing
            fun _threadsUiVisibility(): JsonField<String> = threadsUiVisibility

            /**
             * Returns the raw JSON value of [title].
             *
             * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

            /**
             * Returns the raw JSON value of [usageDashboardVisibility].
             *
             * Unlike [usageDashboardVisibility], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("usage_dashboard_visibility")
            @ExcludeMissing
            fun _usageDashboardVisibility(): JsonField<String> = usageDashboardVisibility

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var apiCallLogging: JsonField<String> = JsonMissing.of()
                private var apiCallLoggingProjectIds: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var threadsUiVisibility: JsonField<String> = JsonMissing.of()
                private var title: JsonField<String> = JsonMissing.of()
                private var usageDashboardVisibility: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    apiCallLogging = changesRequested.apiCallLogging
                    apiCallLoggingProjectIds = changesRequested.apiCallLoggingProjectIds
                    description = changesRequested.description
                    name = changesRequested.name
                    threadsUiVisibility = changesRequested.threadsUiVisibility
                    title = changesRequested.title
                    usageDashboardVisibility = changesRequested.usageDashboardVisibility
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /**
                 * How your organization logs data from supported API calls. One of `disabled`,
                 * `enabled_per_call`, `enabled_for_all_projects`, or
                 * `enabled_for_selected_projects`
                 */
                fun apiCallLogging(apiCallLogging: String) =
                    apiCallLogging(JsonField.of(apiCallLogging))

                /**
                 * Sets [Builder.apiCallLogging] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.apiCallLogging] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun apiCallLogging(apiCallLogging: JsonField<String>) = apply {
                    this.apiCallLogging = apiCallLogging
                }

                /**
                 * The list of project ids if api_call_logging is set to
                 * `enabled_for_selected_projects`
                 */
                fun apiCallLoggingProjectIds(apiCallLoggingProjectIds: String) =
                    apiCallLoggingProjectIds(JsonField.of(apiCallLoggingProjectIds))

                /**
                 * Sets [Builder.apiCallLoggingProjectIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.apiCallLoggingProjectIds] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun apiCallLoggingProjectIds(apiCallLoggingProjectIds: JsonField<String>) = apply {
                    this.apiCallLoggingProjectIds = apiCallLoggingProjectIds
                }

                /** The organization description. */
                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** The organization name. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Visibility of the threads page which shows messages created with the Assistants
                 * API and Playground. One of `ANY_ROLE`, `OWNERS`, or `NONE`.
                 */
                fun threadsUiVisibility(threadsUiVisibility: String) =
                    threadsUiVisibility(JsonField.of(threadsUiVisibility))

                /**
                 * Sets [Builder.threadsUiVisibility] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.threadsUiVisibility] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun threadsUiVisibility(threadsUiVisibility: JsonField<String>) = apply {
                    this.threadsUiVisibility = threadsUiVisibility
                }

                /** The organization title. */
                fun title(title: String) = title(JsonField.of(title))

                /**
                 * Sets [Builder.title] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.title] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun title(title: JsonField<String>) = apply { this.title = title }

                /**
                 * Visibility of the usage dashboard which shows activity and costs for your
                 * organization. One of `ANY_ROLE` or `OWNERS`.
                 */
                fun usageDashboardVisibility(usageDashboardVisibility: String) =
                    usageDashboardVisibility(JsonField.of(usageDashboardVisibility))

                /**
                 * Sets [Builder.usageDashboardVisibility] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.usageDashboardVisibility] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun usageDashboardVisibility(usageDashboardVisibility: JsonField<String>) = apply {
                    this.usageDashboardVisibility = usageDashboardVisibility
                }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(
                        apiCallLogging,
                        apiCallLoggingProjectIds,
                        description,
                        name,
                        threadsUiVisibility,
                        title,
                        usageDashboardVisibility,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                apiCallLogging()
                apiCallLoggingProjectIds()
                description()
                name()
                threadsUiVisibility()
                title()
                usageDashboardVisibility()
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
                (if (apiCallLogging.asKnown().isPresent) 1 else 0) +
                    (if (apiCallLoggingProjectIds.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (threadsUiVisibility.asKnown().isPresent) 1 else 0) +
                    (if (title.asKnown().isPresent) 1 else 0) +
                    (if (usageDashboardVisibility.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    apiCallLogging == other.apiCallLogging &&
                    apiCallLoggingProjectIds == other.apiCallLoggingProjectIds &&
                    description == other.description &&
                    name == other.name &&
                    threadsUiVisibility == other.threadsUiVisibility &&
                    title == other.title &&
                    usageDashboardVisibility == other.usageDashboardVisibility &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    apiCallLogging,
                    apiCallLoggingProjectIds,
                    description,
                    name,
                    threadsUiVisibility,
                    title,
                    usageDashboardVisibility,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{apiCallLogging=$apiCallLogging, apiCallLoggingProjectIds=$apiCallLoggingProjectIds, description=$description, name=$name, threadsUiVisibility=$threadsUiVisibility, title=$title, usageDashboardVisibility=$usageDashboardVisibility, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OrganizationUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OrganizationUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /**
     * The project that the action was scoped to. Absent for actions not scoped to projects. Note
     * that any admin actions taken via Admin API keys are associated with the default project.
     */
    class Project
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        ) : this(id, name, mutableMapOf())

        /**
         * The project ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The project title.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [Project]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Project]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(project: Project) = apply {
                id = project.id
                name = project.name
                additionalProperties = project.additionalProperties.toMutableMap()
            }

            /** The project ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The project title. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [Project].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Project = Project(id, name, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Project = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (name.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Project &&
                id == other.id &&
                name == other.name &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Project{id=$id, name=$name, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ProjectArchived
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
         * The project ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [ProjectArchived]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProjectArchived]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(projectArchived: ProjectArchived) = apply {
                id = projectArchived.id
                additionalProperties = projectArchived.additionalProperties.toMutableMap()
            }

            /** The project ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ProjectArchived].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ProjectArchived = ProjectArchived(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ProjectArchived = apply {
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

            return other is ProjectArchived &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ProjectArchived{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ProjectCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The project ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to create the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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

            /** Returns a mutable builder for constructing an instance of [ProjectCreated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProjectCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(projectCreated: ProjectCreated) = apply {
                id = projectCreated.id
                data = projectCreated.data
                additionalProperties = projectCreated.additionalProperties.toMutableMap()
            }

            /** The project ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to create the project. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [ProjectCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ProjectCreated =
                ProjectCreated(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ProjectCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to create the project. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val title: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            ) : this(name, title, mutableMapOf())

            /**
             * The project name.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * The title of the project as seen on the dashboard.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun title(): Optional<String> = title.getOptional("title")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [title].
             *
             * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var name: JsonField<String> = JsonMissing.of()
                private var title: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    name = data.name
                    title = data.title
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** The project name. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** The title of the project as seen on the dashboard. */
                fun title(title: String) = title(JsonField.of(title))

                /**
                 * Sets [Builder.title] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.title] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun title(title: JsonField<String>) = apply { this.title = title }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data = Data(name, title, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                name()
                title()
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
                (if (name.asKnown().isPresent) 1 else 0) + (if (title.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    name == other.name &&
                    title == other.title &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, title, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{name=$name, title=$title, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ProjectCreated &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ProjectCreated{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ProjectDeleted
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
         * The project ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [ProjectDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProjectDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(projectDeleted: ProjectDeleted) = apply {
                id = projectDeleted.id
                additionalProperties = projectDeleted.additionalProperties.toMutableMap()
            }

            /** The project ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ProjectDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ProjectDeleted = ProjectDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ProjectDeleted = apply {
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

            return other is ProjectDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ProjectDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ProjectUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The project ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [ProjectUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProjectUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(projectUpdated: ProjectUpdated) = apply {
                id = projectUpdated.id
                changesRequested = projectUpdated.changesRequested
                additionalProperties = projectUpdated.additionalProperties.toMutableMap()
            }

            /** The project ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the project. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [ProjectUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ProjectUpdated =
                ProjectUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ProjectUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the project. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val title: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of()
            ) : this(title, mutableMapOf())

            /**
             * The title of the project as seen on the dashboard.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun title(): Optional<String> = title.getOptional("title")

            /**
             * Returns the raw JSON value of [title].
             *
             * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var title: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    title = changesRequested.title
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** The title of the project as seen on the dashboard. */
                fun title(title: String) = title(JsonField.of(title))

                /**
                 * Sets [Builder.title] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.title] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun title(title: JsonField<String>) = apply { this.title = title }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(title, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                title()
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
            @JvmSynthetic internal fun validity(): Int = (if (title.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    title == other.title &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(title, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{title=$title, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ProjectUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ProjectUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RateLimitDeleted
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
         * The rate limit ID
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [RateLimitDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RateLimitDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rateLimitDeleted: RateLimitDeleted) = apply {
                id = rateLimitDeleted.id
                additionalProperties = rateLimitDeleted.additionalProperties.toMutableMap()
            }

            /** The rate limit ID */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [RateLimitDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RateLimitDeleted =
                RateLimitDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): RateLimitDeleted = apply {
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

            return other is RateLimitDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RateLimitDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RateLimitUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The rate limit ID
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the rate limits.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [RateLimitUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RateLimitUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(rateLimitUpdated: RateLimitUpdated) = apply {
                id = rateLimitUpdated.id
                changesRequested = rateLimitUpdated.changesRequested
                additionalProperties = rateLimitUpdated.additionalProperties.toMutableMap()
            }

            /** The rate limit ID */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the rate limits. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [RateLimitUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RateLimitUpdated =
                RateLimitUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): RateLimitUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the rate limits. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val batch1DayMaxInputTokens: JsonField<Long>,
            private val maxAudioMegabytesPer1Minute: JsonField<Long>,
            private val maxImagesPer1Minute: JsonField<Long>,
            private val maxRequestsPer1Day: JsonField<Long>,
            private val maxRequestsPer1Minute: JsonField<Long>,
            private val maxTokensPer1Minute: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("batch_1_day_max_input_tokens")
                @ExcludeMissing
                batch1DayMaxInputTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("max_audio_megabytes_per_1_minute")
                @ExcludeMissing
                maxAudioMegabytesPer1Minute: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("max_images_per_1_minute")
                @ExcludeMissing
                maxImagesPer1Minute: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("max_requests_per_1_day")
                @ExcludeMissing
                maxRequestsPer1Day: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("max_requests_per_1_minute")
                @ExcludeMissing
                maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("max_tokens_per_1_minute")
                @ExcludeMissing
                maxTokensPer1Minute: JsonField<Long> = JsonMissing.of(),
            ) : this(
                batch1DayMaxInputTokens,
                maxAudioMegabytesPer1Minute,
                maxImagesPer1Minute,
                maxRequestsPer1Day,
                maxRequestsPer1Minute,
                maxTokensPer1Minute,
                mutableMapOf(),
            )

            /**
             * The maximum batch input tokens per day. Only relevant for certain models.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun batch1DayMaxInputTokens(): Optional<Long> =
                batch1DayMaxInputTokens.getOptional("batch_1_day_max_input_tokens")

            /**
             * The maximum audio megabytes per minute. Only relevant for certain models.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun maxAudioMegabytesPer1Minute(): Optional<Long> =
                maxAudioMegabytesPer1Minute.getOptional("max_audio_megabytes_per_1_minute")

            /**
             * The maximum images per minute. Only relevant for certain models.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun maxImagesPer1Minute(): Optional<Long> =
                maxImagesPer1Minute.getOptional("max_images_per_1_minute")

            /**
             * The maximum requests per day. Only relevant for certain models.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun maxRequestsPer1Day(): Optional<Long> =
                maxRequestsPer1Day.getOptional("max_requests_per_1_day")

            /**
             * The maximum requests per minute.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun maxRequestsPer1Minute(): Optional<Long> =
                maxRequestsPer1Minute.getOptional("max_requests_per_1_minute")

            /**
             * The maximum tokens per minute.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun maxTokensPer1Minute(): Optional<Long> =
                maxTokensPer1Minute.getOptional("max_tokens_per_1_minute")

            /**
             * Returns the raw JSON value of [batch1DayMaxInputTokens].
             *
             * Unlike [batch1DayMaxInputTokens], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("batch_1_day_max_input_tokens")
            @ExcludeMissing
            fun _batch1DayMaxInputTokens(): JsonField<Long> = batch1DayMaxInputTokens

            /**
             * Returns the raw JSON value of [maxAudioMegabytesPer1Minute].
             *
             * Unlike [maxAudioMegabytesPer1Minute], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("max_audio_megabytes_per_1_minute")
            @ExcludeMissing
            fun _maxAudioMegabytesPer1Minute(): JsonField<Long> = maxAudioMegabytesPer1Minute

            /**
             * Returns the raw JSON value of [maxImagesPer1Minute].
             *
             * Unlike [maxImagesPer1Minute], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("max_images_per_1_minute")
            @ExcludeMissing
            fun _maxImagesPer1Minute(): JsonField<Long> = maxImagesPer1Minute

            /**
             * Returns the raw JSON value of [maxRequestsPer1Day].
             *
             * Unlike [maxRequestsPer1Day], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("max_requests_per_1_day")
            @ExcludeMissing
            fun _maxRequestsPer1Day(): JsonField<Long> = maxRequestsPer1Day

            /**
             * Returns the raw JSON value of [maxRequestsPer1Minute].
             *
             * Unlike [maxRequestsPer1Minute], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("max_requests_per_1_minute")
            @ExcludeMissing
            fun _maxRequestsPer1Minute(): JsonField<Long> = maxRequestsPer1Minute

            /**
             * Returns the raw JSON value of [maxTokensPer1Minute].
             *
             * Unlike [maxTokensPer1Minute], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("max_tokens_per_1_minute")
            @ExcludeMissing
            fun _maxTokensPer1Minute(): JsonField<Long> = maxTokensPer1Minute

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var batch1DayMaxInputTokens: JsonField<Long> = JsonMissing.of()
                private var maxAudioMegabytesPer1Minute: JsonField<Long> = JsonMissing.of()
                private var maxImagesPer1Minute: JsonField<Long> = JsonMissing.of()
                private var maxRequestsPer1Day: JsonField<Long> = JsonMissing.of()
                private var maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of()
                private var maxTokensPer1Minute: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    batch1DayMaxInputTokens = changesRequested.batch1DayMaxInputTokens
                    maxAudioMegabytesPer1Minute = changesRequested.maxAudioMegabytesPer1Minute
                    maxImagesPer1Minute = changesRequested.maxImagesPer1Minute
                    maxRequestsPer1Day = changesRequested.maxRequestsPer1Day
                    maxRequestsPer1Minute = changesRequested.maxRequestsPer1Minute
                    maxTokensPer1Minute = changesRequested.maxTokensPer1Minute
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** The maximum batch input tokens per day. Only relevant for certain models. */
                fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: Long) =
                    batch1DayMaxInputTokens(JsonField.of(batch1DayMaxInputTokens))

                /**
                 * Sets [Builder.batch1DayMaxInputTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.batch1DayMaxInputTokens] with a well-typed
                 * [Long] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun batch1DayMaxInputTokens(batch1DayMaxInputTokens: JsonField<Long>) = apply {
                    this.batch1DayMaxInputTokens = batch1DayMaxInputTokens
                }

                /** The maximum audio megabytes per minute. Only relevant for certain models. */
                fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: Long) =
                    maxAudioMegabytesPer1Minute(JsonField.of(maxAudioMegabytesPer1Minute))

                /**
                 * Sets [Builder.maxAudioMegabytesPer1Minute] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.maxAudioMegabytesPer1Minute] with a well-typed
                 * [Long] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun maxAudioMegabytesPer1Minute(maxAudioMegabytesPer1Minute: JsonField<Long>) =
                    apply {
                        this.maxAudioMegabytesPer1Minute = maxAudioMegabytesPer1Minute
                    }

                /** The maximum images per minute. Only relevant for certain models. */
                fun maxImagesPer1Minute(maxImagesPer1Minute: Long) =
                    maxImagesPer1Minute(JsonField.of(maxImagesPer1Minute))

                /**
                 * Sets [Builder.maxImagesPer1Minute] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.maxImagesPer1Minute] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun maxImagesPer1Minute(maxImagesPer1Minute: JsonField<Long>) = apply {
                    this.maxImagesPer1Minute = maxImagesPer1Minute
                }

                /** The maximum requests per day. Only relevant for certain models. */
                fun maxRequestsPer1Day(maxRequestsPer1Day: Long) =
                    maxRequestsPer1Day(JsonField.of(maxRequestsPer1Day))

                /**
                 * Sets [Builder.maxRequestsPer1Day] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.maxRequestsPer1Day] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun maxRequestsPer1Day(maxRequestsPer1Day: JsonField<Long>) = apply {
                    this.maxRequestsPer1Day = maxRequestsPer1Day
                }

                /** The maximum requests per minute. */
                fun maxRequestsPer1Minute(maxRequestsPer1Minute: Long) =
                    maxRequestsPer1Minute(JsonField.of(maxRequestsPer1Minute))

                /**
                 * Sets [Builder.maxRequestsPer1Minute] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.maxRequestsPer1Minute] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun maxRequestsPer1Minute(maxRequestsPer1Minute: JsonField<Long>) = apply {
                    this.maxRequestsPer1Minute = maxRequestsPer1Minute
                }

                /** The maximum tokens per minute. */
                fun maxTokensPer1Minute(maxTokensPer1Minute: Long) =
                    maxTokensPer1Minute(JsonField.of(maxTokensPer1Minute))

                /**
                 * Sets [Builder.maxTokensPer1Minute] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.maxTokensPer1Minute] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun maxTokensPer1Minute(maxTokensPer1Minute: JsonField<Long>) = apply {
                    this.maxTokensPer1Minute = maxTokensPer1Minute
                }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(
                        batch1DayMaxInputTokens,
                        maxAudioMegabytesPer1Minute,
                        maxImagesPer1Minute,
                        maxRequestsPer1Day,
                        maxRequestsPer1Minute,
                        maxTokensPer1Minute,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                batch1DayMaxInputTokens()
                maxAudioMegabytesPer1Minute()
                maxImagesPer1Minute()
                maxRequestsPer1Day()
                maxRequestsPer1Minute()
                maxTokensPer1Minute()
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
                (if (batch1DayMaxInputTokens.asKnown().isPresent) 1 else 0) +
                    (if (maxAudioMegabytesPer1Minute.asKnown().isPresent) 1 else 0) +
                    (if (maxImagesPer1Minute.asKnown().isPresent) 1 else 0) +
                    (if (maxRequestsPer1Day.asKnown().isPresent) 1 else 0) +
                    (if (maxRequestsPer1Minute.asKnown().isPresent) 1 else 0) +
                    (if (maxTokensPer1Minute.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    batch1DayMaxInputTokens == other.batch1DayMaxInputTokens &&
                    maxAudioMegabytesPer1Minute == other.maxAudioMegabytesPer1Minute &&
                    maxImagesPer1Minute == other.maxImagesPer1Minute &&
                    maxRequestsPer1Day == other.maxRequestsPer1Day &&
                    maxRequestsPer1Minute == other.maxRequestsPer1Minute &&
                    maxTokensPer1Minute == other.maxTokensPer1Minute &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    batch1DayMaxInputTokens,
                    maxAudioMegabytesPer1Minute,
                    maxImagesPer1Minute,
                    maxRequestsPer1Day,
                    maxRequestsPer1Minute,
                    maxTokensPer1Minute,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{batch1DayMaxInputTokens=$batch1DayMaxInputTokens, maxAudioMegabytesPer1Minute=$maxAudioMegabytesPer1Minute, maxImagesPer1Minute=$maxImagesPer1Minute, maxRequestsPer1Day=$maxRequestsPer1Day, maxRequestsPer1Minute=$maxRequestsPer1Minute, maxTokensPer1Minute=$maxTokensPer1Minute, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RateLimitUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RateLimitUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RoleAssignmentCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val principalId: JsonField<String>,
        private val principalType: JsonField<String>,
        private val resourceId: JsonField<String>,
        private val resourceType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("principal_id")
            @ExcludeMissing
            principalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("principal_type")
            @ExcludeMissing
            principalType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resource_id")
            @ExcludeMissing
            resourceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resource_type")
            @ExcludeMissing
            resourceType: JsonField<String> = JsonMissing.of(),
        ) : this(id, principalId, principalType, resourceId, resourceType, mutableMapOf())

        /**
         * The identifier of the role assignment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The principal (user or group) that received the role.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun principalId(): Optional<String> = principalId.getOptional("principal_id")

        /**
         * The type of principal (user or group) that received the role.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun principalType(): Optional<String> = principalType.getOptional("principal_type")

        /**
         * The resource the role assignment is scoped to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resourceId(): Optional<String> = resourceId.getOptional("resource_id")

        /**
         * The type of resource the role assignment is scoped to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resourceType(): Optional<String> = resourceType.getOptional("resource_type")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [principalId].
         *
         * Unlike [principalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("principal_id")
        @ExcludeMissing
        fun _principalId(): JsonField<String> = principalId

        /**
         * Returns the raw JSON value of [principalType].
         *
         * Unlike [principalType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("principal_type")
        @ExcludeMissing
        fun _principalType(): JsonField<String> = principalType

        /**
         * Returns the raw JSON value of [resourceId].
         *
         * Unlike [resourceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resource_id")
        @ExcludeMissing
        fun _resourceId(): JsonField<String> = resourceId

        /**
         * Returns the raw JSON value of [resourceType].
         *
         * Unlike [resourceType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("resource_type")
        @ExcludeMissing
        fun _resourceType(): JsonField<String> = resourceType

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
             * Returns a mutable builder for constructing an instance of [RoleAssignmentCreated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RoleAssignmentCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var principalId: JsonField<String> = JsonMissing.of()
            private var principalType: JsonField<String> = JsonMissing.of()
            private var resourceId: JsonField<String> = JsonMissing.of()
            private var resourceType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(roleAssignmentCreated: RoleAssignmentCreated) = apply {
                id = roleAssignmentCreated.id
                principalId = roleAssignmentCreated.principalId
                principalType = roleAssignmentCreated.principalType
                resourceId = roleAssignmentCreated.resourceId
                resourceType = roleAssignmentCreated.resourceType
                additionalProperties = roleAssignmentCreated.additionalProperties.toMutableMap()
            }

            /** The identifier of the role assignment. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The principal (user or group) that received the role. */
            fun principalId(principalId: String) = principalId(JsonField.of(principalId))

            /**
             * Sets [Builder.principalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.principalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun principalId(principalId: JsonField<String>) = apply {
                this.principalId = principalId
            }

            /** The type of principal (user or group) that received the role. */
            fun principalType(principalType: String) = principalType(JsonField.of(principalType))

            /**
             * Sets [Builder.principalType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.principalType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun principalType(principalType: JsonField<String>) = apply {
                this.principalType = principalType
            }

            /** The resource the role assignment is scoped to. */
            fun resourceId(resourceId: String) = resourceId(JsonField.of(resourceId))

            /**
             * Sets [Builder.resourceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resourceId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resourceId(resourceId: JsonField<String>) = apply { this.resourceId = resourceId }

            /** The type of resource the role assignment is scoped to. */
            fun resourceType(resourceType: String) = resourceType(JsonField.of(resourceType))

            /**
             * Sets [Builder.resourceType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resourceType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resourceType(resourceType: JsonField<String>) = apply {
                this.resourceType = resourceType
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
             * Returns an immutable instance of [RoleAssignmentCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RoleAssignmentCreated =
                RoleAssignmentCreated(
                    id,
                    principalId,
                    principalType,
                    resourceId,
                    resourceType,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RoleAssignmentCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            principalId()
            principalType()
            resourceId()
            resourceType()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (principalId.asKnown().isPresent) 1 else 0) +
                (if (principalType.asKnown().isPresent) 1 else 0) +
                (if (resourceId.asKnown().isPresent) 1 else 0) +
                (if (resourceType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RoleAssignmentCreated &&
                id == other.id &&
                principalId == other.principalId &&
                principalType == other.principalType &&
                resourceId == other.resourceId &&
                resourceType == other.resourceType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                principalId,
                principalType,
                resourceId,
                resourceType,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RoleAssignmentCreated{id=$id, principalId=$principalId, principalType=$principalType, resourceId=$resourceId, resourceType=$resourceType, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RoleAssignmentDeleted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val principalId: JsonField<String>,
        private val principalType: JsonField<String>,
        private val resourceId: JsonField<String>,
        private val resourceType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("principal_id")
            @ExcludeMissing
            principalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("principal_type")
            @ExcludeMissing
            principalType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resource_id")
            @ExcludeMissing
            resourceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resource_type")
            @ExcludeMissing
            resourceType: JsonField<String> = JsonMissing.of(),
        ) : this(id, principalId, principalType, resourceId, resourceType, mutableMapOf())

        /**
         * The identifier of the role assignment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The principal (user or group) that had the role removed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun principalId(): Optional<String> = principalId.getOptional("principal_id")

        /**
         * The type of principal (user or group) that had the role removed.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun principalType(): Optional<String> = principalType.getOptional("principal_type")

        /**
         * The resource the role assignment was scoped to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resourceId(): Optional<String> = resourceId.getOptional("resource_id")

        /**
         * The type of resource the role assignment was scoped to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resourceType(): Optional<String> = resourceType.getOptional("resource_type")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [principalId].
         *
         * Unlike [principalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("principal_id")
        @ExcludeMissing
        fun _principalId(): JsonField<String> = principalId

        /**
         * Returns the raw JSON value of [principalType].
         *
         * Unlike [principalType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("principal_type")
        @ExcludeMissing
        fun _principalType(): JsonField<String> = principalType

        /**
         * Returns the raw JSON value of [resourceId].
         *
         * Unlike [resourceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resource_id")
        @ExcludeMissing
        fun _resourceId(): JsonField<String> = resourceId

        /**
         * Returns the raw JSON value of [resourceType].
         *
         * Unlike [resourceType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("resource_type")
        @ExcludeMissing
        fun _resourceType(): JsonField<String> = resourceType

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
             * Returns a mutable builder for constructing an instance of [RoleAssignmentDeleted].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RoleAssignmentDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var principalId: JsonField<String> = JsonMissing.of()
            private var principalType: JsonField<String> = JsonMissing.of()
            private var resourceId: JsonField<String> = JsonMissing.of()
            private var resourceType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(roleAssignmentDeleted: RoleAssignmentDeleted) = apply {
                id = roleAssignmentDeleted.id
                principalId = roleAssignmentDeleted.principalId
                principalType = roleAssignmentDeleted.principalType
                resourceId = roleAssignmentDeleted.resourceId
                resourceType = roleAssignmentDeleted.resourceType
                additionalProperties = roleAssignmentDeleted.additionalProperties.toMutableMap()
            }

            /** The identifier of the role assignment. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The principal (user or group) that had the role removed. */
            fun principalId(principalId: String) = principalId(JsonField.of(principalId))

            /**
             * Sets [Builder.principalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.principalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun principalId(principalId: JsonField<String>) = apply {
                this.principalId = principalId
            }

            /** The type of principal (user or group) that had the role removed. */
            fun principalType(principalType: String) = principalType(JsonField.of(principalType))

            /**
             * Sets [Builder.principalType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.principalType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun principalType(principalType: JsonField<String>) = apply {
                this.principalType = principalType
            }

            /** The resource the role assignment was scoped to. */
            fun resourceId(resourceId: String) = resourceId(JsonField.of(resourceId))

            /**
             * Sets [Builder.resourceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resourceId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resourceId(resourceId: JsonField<String>) = apply { this.resourceId = resourceId }

            /** The type of resource the role assignment was scoped to. */
            fun resourceType(resourceType: String) = resourceType(JsonField.of(resourceType))

            /**
             * Sets [Builder.resourceType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resourceType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resourceType(resourceType: JsonField<String>) = apply {
                this.resourceType = resourceType
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
             * Returns an immutable instance of [RoleAssignmentDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RoleAssignmentDeleted =
                RoleAssignmentDeleted(
                    id,
                    principalId,
                    principalType,
                    resourceId,
                    resourceType,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RoleAssignmentDeleted = apply {
            if (validated) {
                return@apply
            }

            id()
            principalId()
            principalType()
            resourceId()
            resourceType()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (principalId.asKnown().isPresent) 1 else 0) +
                (if (principalType.asKnown().isPresent) 1 else 0) +
                (if (resourceId.asKnown().isPresent) 1 else 0) +
                (if (resourceType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RoleAssignmentDeleted &&
                id == other.id &&
                principalId == other.principalId &&
                principalType == other.principalType &&
                resourceId == other.resourceId &&
                resourceType == other.resourceType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                principalId,
                principalType,
                resourceId,
                resourceType,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RoleAssignmentDeleted{id=$id, principalId=$principalId, principalType=$principalType, resourceId=$resourceId, resourceType=$resourceType, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RoleCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val permissions: JsonField<List<String>>,
        private val resourceId: JsonField<String>,
        private val resourceType: JsonField<String>,
        private val roleName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("permissions")
            @ExcludeMissing
            permissions: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("resource_id")
            @ExcludeMissing
            resourceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("resource_type")
            @ExcludeMissing
            resourceType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("role_name")
            @ExcludeMissing
            roleName: JsonField<String> = JsonMissing.of(),
        ) : this(id, permissions, resourceId, resourceType, roleName, mutableMapOf())

        /**
         * The role ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The permissions granted by the role.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun permissions(): Optional<List<String>> = permissions.getOptional("permissions")

        /**
         * The resource the role is scoped to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resourceId(): Optional<String> = resourceId.getOptional("resource_id")

        /**
         * The type of resource the role belongs to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resourceType(): Optional<String> = resourceType.getOptional("resource_type")

        /**
         * The name of the role.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun roleName(): Optional<String> = roleName.getOptional("role_name")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [permissions].
         *
         * Unlike [permissions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("permissions")
        @ExcludeMissing
        fun _permissions(): JsonField<List<String>> = permissions

        /**
         * Returns the raw JSON value of [resourceId].
         *
         * Unlike [resourceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resource_id")
        @ExcludeMissing
        fun _resourceId(): JsonField<String> = resourceId

        /**
         * Returns the raw JSON value of [resourceType].
         *
         * Unlike [resourceType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("resource_type")
        @ExcludeMissing
        fun _resourceType(): JsonField<String> = resourceType

        /**
         * Returns the raw JSON value of [roleName].
         *
         * Unlike [roleName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role_name") @ExcludeMissing fun _roleName(): JsonField<String> = roleName

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

            /** Returns a mutable builder for constructing an instance of [RoleCreated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RoleCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var permissions: JsonField<MutableList<String>>? = null
            private var resourceId: JsonField<String> = JsonMissing.of()
            private var resourceType: JsonField<String> = JsonMissing.of()
            private var roleName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(roleCreated: RoleCreated) = apply {
                id = roleCreated.id
                permissions = roleCreated.permissions.map { it.toMutableList() }
                resourceId = roleCreated.resourceId
                resourceType = roleCreated.resourceType
                roleName = roleCreated.roleName
                additionalProperties = roleCreated.additionalProperties.toMutableMap()
            }

            /** The role ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The permissions granted by the role. */
            fun permissions(permissions: List<String>) = permissions(JsonField.of(permissions))

            /**
             * Sets [Builder.permissions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.permissions] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun permissions(permissions: JsonField<List<String>>) = apply {
                this.permissions = permissions.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [permissions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPermission(permission: String) = apply {
                permissions =
                    (permissions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("permissions", it).add(permission)
                    }
            }

            /** The resource the role is scoped to. */
            fun resourceId(resourceId: String) = resourceId(JsonField.of(resourceId))

            /**
             * Sets [Builder.resourceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resourceId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resourceId(resourceId: JsonField<String>) = apply { this.resourceId = resourceId }

            /** The type of resource the role belongs to. */
            fun resourceType(resourceType: String) = resourceType(JsonField.of(resourceType))

            /**
             * Sets [Builder.resourceType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resourceType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resourceType(resourceType: JsonField<String>) = apply {
                this.resourceType = resourceType
            }

            /** The name of the role. */
            fun roleName(roleName: String) = roleName(JsonField.of(roleName))

            /**
             * Sets [Builder.roleName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.roleName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun roleName(roleName: JsonField<String>) = apply { this.roleName = roleName }

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
             * Returns an immutable instance of [RoleCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RoleCreated =
                RoleCreated(
                    id,
                    (permissions ?: JsonMissing.of()).map { it.toImmutable() },
                    resourceId,
                    resourceType,
                    roleName,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RoleCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            permissions()
            resourceId()
            resourceType()
            roleName()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (permissions.asKnown().getOrNull()?.size ?: 0) +
                (if (resourceId.asKnown().isPresent) 1 else 0) +
                (if (resourceType.asKnown().isPresent) 1 else 0) +
                (if (roleName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RoleCreated &&
                id == other.id &&
                permissions == other.permissions &&
                resourceId == other.resourceId &&
                resourceType == other.resourceType &&
                roleName == other.roleName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, permissions, resourceId, resourceType, roleName, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RoleCreated{id=$id, permissions=$permissions, resourceId=$resourceId, resourceType=$resourceType, roleName=$roleName, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RoleDeleted
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
         * The role ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [RoleDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RoleDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(roleDeleted: RoleDeleted) = apply {
                id = roleDeleted.id
                additionalProperties = roleDeleted.additionalProperties.toMutableMap()
            }

            /** The role ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [RoleDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RoleDeleted = RoleDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): RoleDeleted = apply {
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

            return other is RoleDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "RoleDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class RoleUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The role ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the role.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [RoleUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RoleUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(roleUpdated: RoleUpdated) = apply {
                id = roleUpdated.id
                changesRequested = roleUpdated.changesRequested
                additionalProperties = roleUpdated.additionalProperties.toMutableMap()
            }

            /** The role ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the role. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [RoleUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): RoleUpdated =
                RoleUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): RoleUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the role. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val description: JsonField<String>,
            private val metadata: JsonValue,
            private val permissionsAdded: JsonField<List<String>>,
            private val permissionsRemoved: JsonField<List<String>>,
            private val resourceId: JsonField<String>,
            private val resourceType: JsonField<String>,
            private val roleName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("metadata") @ExcludeMissing metadata: JsonValue = JsonMissing.of(),
                @JsonProperty("permissions_added")
                @ExcludeMissing
                permissionsAdded: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("permissions_removed")
                @ExcludeMissing
                permissionsRemoved: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("resource_id")
                @ExcludeMissing
                resourceId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("resource_type")
                @ExcludeMissing
                resourceType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role_name")
                @ExcludeMissing
                roleName: JsonField<String> = JsonMissing.of(),
            ) : this(
                description,
                metadata,
                permissionsAdded,
                permissionsRemoved,
                resourceId,
                resourceType,
                roleName,
                mutableMapOf(),
            )

            /**
             * The updated role description, when provided.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Additional metadata stored on the role.
             *
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = changesRequested.metadata().convert(MyClass.class);
             * ```
             */
            @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

            /**
             * The permissions added to the role.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun permissionsAdded(): Optional<List<String>> =
                permissionsAdded.getOptional("permissions_added")

            /**
             * The permissions removed from the role.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun permissionsRemoved(): Optional<List<String>> =
                permissionsRemoved.getOptional("permissions_removed")

            /**
             * The resource the role is scoped to.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun resourceId(): Optional<String> = resourceId.getOptional("resource_id")

            /**
             * The type of resource the role belongs to.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun resourceType(): Optional<String> = resourceType.getOptional("resource_type")

            /**
             * The updated role name, when provided.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun roleName(): Optional<String> = roleName.getOptional("role_name")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [permissionsAdded].
             *
             * Unlike [permissionsAdded], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("permissions_added")
            @ExcludeMissing
            fun _permissionsAdded(): JsonField<List<String>> = permissionsAdded

            /**
             * Returns the raw JSON value of [permissionsRemoved].
             *
             * Unlike [permissionsRemoved], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("permissions_removed")
            @ExcludeMissing
            fun _permissionsRemoved(): JsonField<List<String>> = permissionsRemoved

            /**
             * Returns the raw JSON value of [resourceId].
             *
             * Unlike [resourceId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("resource_id")
            @ExcludeMissing
            fun _resourceId(): JsonField<String> = resourceId

            /**
             * Returns the raw JSON value of [resourceType].
             *
             * Unlike [resourceType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("resource_type")
            @ExcludeMissing
            fun _resourceType(): JsonField<String> = resourceType

            /**
             * Returns the raw JSON value of [roleName].
             *
             * Unlike [roleName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("role_name") @ExcludeMissing fun _roleName(): JsonField<String> = roleName

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var description: JsonField<String> = JsonMissing.of()
                private var metadata: JsonValue = JsonMissing.of()
                private var permissionsAdded: JsonField<MutableList<String>>? = null
                private var permissionsRemoved: JsonField<MutableList<String>>? = null
                private var resourceId: JsonField<String> = JsonMissing.of()
                private var resourceType: JsonField<String> = JsonMissing.of()
                private var roleName: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    description = changesRequested.description
                    metadata = changesRequested.metadata
                    permissionsAdded = changesRequested.permissionsAdded.map { it.toMutableList() }
                    permissionsRemoved =
                        changesRequested.permissionsRemoved.map { it.toMutableList() }
                    resourceId = changesRequested.resourceId
                    resourceType = changesRequested.resourceType
                    roleName = changesRequested.roleName
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** The updated role description, when provided. */
                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** Additional metadata stored on the role. */
                fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

                /** The permissions added to the role. */
                fun permissionsAdded(permissionsAdded: List<String>) =
                    permissionsAdded(JsonField.of(permissionsAdded))

                /**
                 * Sets [Builder.permissionsAdded] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.permissionsAdded] with a well-typed
                 * `List<String>` value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun permissionsAdded(permissionsAdded: JsonField<List<String>>) = apply {
                    this.permissionsAdded = permissionsAdded.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.permissionsAdded].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPermissionsAdded(permissionsAdded: String) = apply {
                    this.permissionsAdded =
                        (this.permissionsAdded ?: JsonField.of(mutableListOf())).also {
                            checkKnown("permissionsAdded", it).add(permissionsAdded)
                        }
                }

                /** The permissions removed from the role. */
                fun permissionsRemoved(permissionsRemoved: List<String>) =
                    permissionsRemoved(JsonField.of(permissionsRemoved))

                /**
                 * Sets [Builder.permissionsRemoved] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.permissionsRemoved] with a well-typed
                 * `List<String>` value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun permissionsRemoved(permissionsRemoved: JsonField<List<String>>) = apply {
                    this.permissionsRemoved = permissionsRemoved.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.permissionsRemoved].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPermissionsRemoved(permissionsRemoved: String) = apply {
                    this.permissionsRemoved =
                        (this.permissionsRemoved ?: JsonField.of(mutableListOf())).also {
                            checkKnown("permissionsRemoved", it).add(permissionsRemoved)
                        }
                }

                /** The resource the role is scoped to. */
                fun resourceId(resourceId: String) = resourceId(JsonField.of(resourceId))

                /**
                 * Sets [Builder.resourceId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.resourceId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun resourceId(resourceId: JsonField<String>) = apply {
                    this.resourceId = resourceId
                }

                /** The type of resource the role belongs to. */
                fun resourceType(resourceType: String) = resourceType(JsonField.of(resourceType))

                /**
                 * Sets [Builder.resourceType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.resourceType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun resourceType(resourceType: JsonField<String>) = apply {
                    this.resourceType = resourceType
                }

                /** The updated role name, when provided. */
                fun roleName(roleName: String) = roleName(JsonField.of(roleName))

                /**
                 * Sets [Builder.roleName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.roleName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun roleName(roleName: JsonField<String>) = apply { this.roleName = roleName }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(
                        description,
                        metadata,
                        (permissionsAdded ?: JsonMissing.of()).map { it.toImmutable() },
                        (permissionsRemoved ?: JsonMissing.of()).map { it.toImmutable() },
                        resourceId,
                        resourceType,
                        roleName,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                description()
                permissionsAdded()
                permissionsRemoved()
                resourceId()
                resourceType()
                roleName()
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
                (if (description.asKnown().isPresent) 1 else 0) +
                    (permissionsAdded.asKnown().getOrNull()?.size ?: 0) +
                    (permissionsRemoved.asKnown().getOrNull()?.size ?: 0) +
                    (if (resourceId.asKnown().isPresent) 1 else 0) +
                    (if (resourceType.asKnown().isPresent) 1 else 0) +
                    (if (roleName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    description == other.description &&
                    metadata == other.metadata &&
                    permissionsAdded == other.permissionsAdded &&
                    permissionsRemoved == other.permissionsRemoved &&
                    resourceId == other.resourceId &&
                    resourceType == other.resourceType &&
                    roleName == other.roleName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    description,
                    metadata,
                    permissionsAdded,
                    permissionsRemoved,
                    resourceId,
                    resourceType,
                    roleName,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{description=$description, metadata=$metadata, permissionsAdded=$permissionsAdded, permissionsRemoved=$permissionsRemoved, resourceId=$resourceId, resourceType=$resourceType, roleName=$roleName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RoleUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RoleUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ScimDisabled
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
         * The ID of the SCIM was disabled for.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [ScimDisabled]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ScimDisabled]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(scimDisabled: ScimDisabled) = apply {
                id = scimDisabled.id
                additionalProperties = scimDisabled.additionalProperties.toMutableMap()
            }

            /** The ID of the SCIM was disabled for. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ScimDisabled].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ScimDisabled = ScimDisabled(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ScimDisabled = apply {
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

            return other is ScimDisabled &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "ScimDisabled{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ScimEnabled
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
         * The ID of the SCIM was enabled for.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [ScimEnabled]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ScimEnabled]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(scimEnabled: ScimEnabled) = apply {
                id = scimEnabled.id
                additionalProperties = scimEnabled.additionalProperties.toMutableMap()
            }

            /** The ID of the SCIM was enabled for. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ScimEnabled].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ScimEnabled = ScimEnabled(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ScimEnabled = apply {
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

            return other is ScimEnabled &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "ScimEnabled{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ServiceAccountCreated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The service account ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to create the service account.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
             * Returns a mutable builder for constructing an instance of [ServiceAccountCreated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ServiceAccountCreated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(serviceAccountCreated: ServiceAccountCreated) = apply {
                id = serviceAccountCreated.id
                data = serviceAccountCreated.data
                additionalProperties = serviceAccountCreated.additionalProperties.toMutableMap()
            }

            /** The service account ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to create the service account. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [ServiceAccountCreated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ServiceAccountCreated =
                ServiceAccountCreated(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ServiceAccountCreated = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to create the service account. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of()
            ) : this(role, mutableMapOf())

            /**
             * The role of the service account. Is either `owner` or `member`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    role = data.role
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** The role of the service account. Is either `owner` or `member`. */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data = Data(role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                role()
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
            @JvmSynthetic internal fun validity(): Int = (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(role, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Data{role=$role, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ServiceAccountCreated &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ServiceAccountCreated{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ServiceAccountDeleted
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
         * The service account ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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
             * Returns a mutable builder for constructing an instance of [ServiceAccountDeleted].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ServiceAccountDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(serviceAccountDeleted: ServiceAccountDeleted) = apply {
                id = serviceAccountDeleted.id
                additionalProperties = serviceAccountDeleted.additionalProperties.toMutableMap()
            }

            /** The service account ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [ServiceAccountDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ServiceAccountDeleted =
                ServiceAccountDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ServiceAccountDeleted = apply {
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

            return other is ServiceAccountDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ServiceAccountDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class ServiceAccountUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The service account ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to updated the service account.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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
             * Returns a mutable builder for constructing an instance of [ServiceAccountUpdated].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ServiceAccountUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(serviceAccountUpdated: ServiceAccountUpdated) = apply {
                id = serviceAccountUpdated.id
                changesRequested = serviceAccountUpdated.changesRequested
                additionalProperties = serviceAccountUpdated.additionalProperties.toMutableMap()
            }

            /** The service account ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to updated the service account. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [ServiceAccountUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ServiceAccountUpdated =
                ServiceAccountUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ServiceAccountUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to updated the service account. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of()
            ) : this(role, mutableMapOf())

            /**
             * The role of the service account. Is either `owner` or `member`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    role = changesRequested.role
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** The role of the service account. Is either `owner` or `member`. */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                role()
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
            @JvmSynthetic internal fun validity(): Int = (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(role, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{role=$role, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ServiceAccountUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ServiceAccountUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class UserAdded
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val data: JsonField<Data>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        ) : this(id, data, mutableMapOf())

        /**
         * The user ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to add the user to the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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

            /** Returns a mutable builder for constructing an instance of [UserAdded]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UserAdded]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(userAdded: UserAdded) = apply {
                id = userAdded.id
                data = userAdded.data
                additionalProperties = userAdded.additionalProperties.toMutableMap()
            }

            /** The user ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to add the user to the project. */
            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

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
             * Returns an immutable instance of [UserAdded].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UserAdded = UserAdded(id, data, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): UserAdded = apply {
            if (validated) {
                return@apply
            }

            id()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) + (data.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to add the user to the project. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of()
            ) : this(role, mutableMapOf())

            /**
             * The role of the user. Is either `owner` or `member`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [Data]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    role = data.role
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** The role of the user. Is either `owner` or `member`. */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Data = Data(role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                role()
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
            @JvmSynthetic internal fun validity(): Int = (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(role, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Data{role=$role, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UserAdded &&
                id == other.id &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, data, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UserAdded{id=$id, data=$data, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class UserDeleted
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
         * The user ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

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

            /** Returns a mutable builder for constructing an instance of [UserDeleted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UserDeleted]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(userDeleted: UserDeleted) = apply {
                id = userDeleted.id
                additionalProperties = userDeleted.additionalProperties.toMutableMap()
            }

            /** The user ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

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
             * Returns an immutable instance of [UserDeleted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UserDeleted = UserDeleted(id, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): UserDeleted = apply {
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

            return other is UserDeleted &&
                id == other.id &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "UserDeleted{id=$id, additionalProperties=$additionalProperties}"
    }

    /** The details for events with this `type`. */
    class UserUpdated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val changesRequested: JsonField<ChangesRequested>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("changes_requested")
            @ExcludeMissing
            changesRequested: JsonField<ChangesRequested> = JsonMissing.of(),
        ) : this(id, changesRequested, mutableMapOf())

        /**
         * The project ID.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The payload used to update the user.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun changesRequested(): Optional<ChangesRequested> =
            changesRequested.getOptional("changes_requested")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [changesRequested].
         *
         * Unlike [changesRequested], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("changes_requested")
        @ExcludeMissing
        fun _changesRequested(): JsonField<ChangesRequested> = changesRequested

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

            /** Returns a mutable builder for constructing an instance of [UserUpdated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UserUpdated]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var changesRequested: JsonField<ChangesRequested> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(userUpdated: UserUpdated) = apply {
                id = userUpdated.id
                changesRequested = userUpdated.changesRequested
                additionalProperties = userUpdated.additionalProperties.toMutableMap()
            }

            /** The project ID. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The payload used to update the user. */
            fun changesRequested(changesRequested: ChangesRequested) =
                changesRequested(JsonField.of(changesRequested))

            /**
             * Sets [Builder.changesRequested] to an arbitrary JSON value.
             *
             * You should usually call [Builder.changesRequested] with a well-typed
             * [ChangesRequested] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun changesRequested(changesRequested: JsonField<ChangesRequested>) = apply {
                this.changesRequested = changesRequested
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
             * Returns an immutable instance of [UserUpdated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UserUpdated =
                UserUpdated(id, changesRequested, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): UserUpdated = apply {
            if (validated) {
                return@apply
            }

            id()
            changesRequested().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (changesRequested.asKnown().getOrNull()?.validity() ?: 0)

        /** The payload used to update the user. */
        class ChangesRequested
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of()
            ) : this(role, mutableMapOf())

            /**
             * The role of the user. Is either `owner` or `member`.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [ChangesRequested]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChangesRequested]. */
            class Builder internal constructor() {

                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(changesRequested: ChangesRequested) = apply {
                    role = changesRequested.role
                    additionalProperties = changesRequested.additionalProperties.toMutableMap()
                }

                /** The role of the user. Is either `owner` or `member`. */
                fun role(role: String) = role(JsonField.of(role))

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [ChangesRequested].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChangesRequested =
                    ChangesRequested(role, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ChangesRequested = apply {
                if (validated) {
                    return@apply
                }

                role()
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
            @JvmSynthetic internal fun validity(): Int = (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChangesRequested &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(role, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChangesRequested{role=$role, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UserUpdated &&
                id == other.id &&
                changesRequested == other.changesRequested &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, changesRequested, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UserUpdated{id=$id, changesRequested=$changesRequested, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AuditLogListResponse &&
            id == other.id &&
            actor == other.actor &&
            effectiveAt == other.effectiveAt &&
            type == other.type &&
            apiKeyCreated == other.apiKeyCreated &&
            apiKeyDeleted == other.apiKeyDeleted &&
            apiKeyUpdated == other.apiKeyUpdated &&
            certificateCreated == other.certificateCreated &&
            certificateDeleted == other.certificateDeleted &&
            certificateUpdated == other.certificateUpdated &&
            certificatesActivated == other.certificatesActivated &&
            certificatesDeactivated == other.certificatesDeactivated &&
            checkpointPermissionCreated == other.checkpointPermissionCreated &&
            checkpointPermissionDeleted == other.checkpointPermissionDeleted &&
            externalKeyRegistered == other.externalKeyRegistered &&
            externalKeyRemoved == other.externalKeyRemoved &&
            groupCreated == other.groupCreated &&
            groupDeleted == other.groupDeleted &&
            groupUpdated == other.groupUpdated &&
            inviteAccepted == other.inviteAccepted &&
            inviteDeleted == other.inviteDeleted &&
            inviteSent == other.inviteSent &&
            ipAllowlistConfigActivated == other.ipAllowlistConfigActivated &&
            ipAllowlistConfigDeactivated == other.ipAllowlistConfigDeactivated &&
            ipAllowlistCreated == other.ipAllowlistCreated &&
            ipAllowlistDeleted == other.ipAllowlistDeleted &&
            ipAllowlistUpdated == other.ipAllowlistUpdated &&
            loginFailed == other.loginFailed &&
            loginSucceeded == other.loginSucceeded &&
            logoutFailed == other.logoutFailed &&
            logoutSucceeded == other.logoutSucceeded &&
            organizationUpdated == other.organizationUpdated &&
            project == other.project &&
            projectArchived == other.projectArchived &&
            projectCreated == other.projectCreated &&
            projectDeleted == other.projectDeleted &&
            projectUpdated == other.projectUpdated &&
            rateLimitDeleted == other.rateLimitDeleted &&
            rateLimitUpdated == other.rateLimitUpdated &&
            roleAssignmentCreated == other.roleAssignmentCreated &&
            roleAssignmentDeleted == other.roleAssignmentDeleted &&
            roleCreated == other.roleCreated &&
            roleDeleted == other.roleDeleted &&
            roleUpdated == other.roleUpdated &&
            scimDisabled == other.scimDisabled &&
            scimEnabled == other.scimEnabled &&
            serviceAccountCreated == other.serviceAccountCreated &&
            serviceAccountDeleted == other.serviceAccountDeleted &&
            serviceAccountUpdated == other.serviceAccountUpdated &&
            userAdded == other.userAdded &&
            userDeleted == other.userDeleted &&
            userUpdated == other.userUpdated &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            actor,
            effectiveAt,
            type,
            apiKeyCreated,
            apiKeyDeleted,
            apiKeyUpdated,
            certificateCreated,
            certificateDeleted,
            certificateUpdated,
            certificatesActivated,
            certificatesDeactivated,
            checkpointPermissionCreated,
            checkpointPermissionDeleted,
            externalKeyRegistered,
            externalKeyRemoved,
            groupCreated,
            groupDeleted,
            groupUpdated,
            inviteAccepted,
            inviteDeleted,
            inviteSent,
            ipAllowlistConfigActivated,
            ipAllowlistConfigDeactivated,
            ipAllowlistCreated,
            ipAllowlistDeleted,
            ipAllowlistUpdated,
            loginFailed,
            loginSucceeded,
            logoutFailed,
            logoutSucceeded,
            organizationUpdated,
            project,
            projectArchived,
            projectCreated,
            projectDeleted,
            projectUpdated,
            rateLimitDeleted,
            rateLimitUpdated,
            roleAssignmentCreated,
            roleAssignmentDeleted,
            roleCreated,
            roleDeleted,
            roleUpdated,
            scimDisabled,
            scimEnabled,
            serviceAccountCreated,
            serviceAccountDeleted,
            serviceAccountUpdated,
            userAdded,
            userDeleted,
            userUpdated,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AuditLogListResponse{id=$id, actor=$actor, effectiveAt=$effectiveAt, type=$type, apiKeyCreated=$apiKeyCreated, apiKeyDeleted=$apiKeyDeleted, apiKeyUpdated=$apiKeyUpdated, certificateCreated=$certificateCreated, certificateDeleted=$certificateDeleted, certificateUpdated=$certificateUpdated, certificatesActivated=$certificatesActivated, certificatesDeactivated=$certificatesDeactivated, checkpointPermissionCreated=$checkpointPermissionCreated, checkpointPermissionDeleted=$checkpointPermissionDeleted, externalKeyRegistered=$externalKeyRegistered, externalKeyRemoved=$externalKeyRemoved, groupCreated=$groupCreated, groupDeleted=$groupDeleted, groupUpdated=$groupUpdated, inviteAccepted=$inviteAccepted, inviteDeleted=$inviteDeleted, inviteSent=$inviteSent, ipAllowlistConfigActivated=$ipAllowlistConfigActivated, ipAllowlistConfigDeactivated=$ipAllowlistConfigDeactivated, ipAllowlistCreated=$ipAllowlistCreated, ipAllowlistDeleted=$ipAllowlistDeleted, ipAllowlistUpdated=$ipAllowlistUpdated, loginFailed=$loginFailed, loginSucceeded=$loginSucceeded, logoutFailed=$logoutFailed, logoutSucceeded=$logoutSucceeded, organizationUpdated=$organizationUpdated, project=$project, projectArchived=$projectArchived, projectCreated=$projectCreated, projectDeleted=$projectDeleted, projectUpdated=$projectUpdated, rateLimitDeleted=$rateLimitDeleted, rateLimitUpdated=$rateLimitUpdated, roleAssignmentCreated=$roleAssignmentCreated, roleAssignmentDeleted=$roleAssignmentDeleted, roleCreated=$roleCreated, roleDeleted=$roleDeleted, roleUpdated=$roleUpdated, scimDisabled=$scimDisabled, scimEnabled=$scimEnabled, serviceAccountCreated=$serviceAccountCreated, serviceAccountDeleted=$serviceAccountDeleted, serviceAccountUpdated=$serviceAccountUpdated, userAdded=$userAdded, userDeleted=$userDeleted, userUpdated=$userUpdated, additionalProperties=$additionalProperties}"
}
