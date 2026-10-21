// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

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

/** Sent when an agent environment expires and can no longer resume from a snapshot. */
@JsonDeserialize(using = UnwrapWebhookEvent.Deserializer::class)
@JsonSerialize(using = UnwrapWebhookEvent.Serializer::class)
class UnwrapWebhookEvent
private constructor(
    private val agentEnvironmentExpired: AgentEnvironmentExpiredWebhookEvent? = null,
    private val agentEnvironmentFailed: AgentEnvironmentFailedWebhookEvent? = null,
    private val agentEnvironmentReady: AgentEnvironmentReadyWebhookEvent? = null,
    private val agentEnvironmentSuspended: AgentEnvironmentSuspendedWebhookEvent? = null,
    private val agentSessionActionRequired: AgentSessionActionRequiredWebhookEvent? = null,
    private val agentSessionCreated: AgentSessionCreatedWebhookEvent? = null,
    private val agentSessionFailed: AgentSessionFailedWebhookEvent? = null,
    private val agentSessionIdle: AgentSessionIdleWebhookEvent? = null,
    private val agentSessionInProgress: AgentSessionInProgressWebhookEvent? = null,
    private val batchCancelled: BatchCancelledWebhookEvent? = null,
    private val batchCompleted: BatchCompletedWebhookEvent? = null,
    private val batchExpired: BatchExpiredWebhookEvent? = null,
    private val batchFailed: BatchFailedWebhookEvent? = null,
    private val evalRunCanceled: EvalRunCanceledWebhookEvent? = null,
    private val evalRunFailed: EvalRunFailedWebhookEvent? = null,
    private val evalRunSucceeded: EvalRunSucceededWebhookEvent? = null,
    private val fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent? = null,
    private val fineTuningJobFailed: FineTuningJobFailedWebhookEvent? = null,
    private val fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent? = null,
    private val liveCallIncoming: LiveCallIncomingWebhookEvent? = null,
    private val liveTransportIncoming: LiveTransportIncomingWebhookEvent? = null,
    private val realtimeCallIncoming: RealtimeCallIncomingWebhookEvent? = null,
    private val responseCancelled: ResponseCancelledWebhookEvent? = null,
    private val responseCompleted: ResponseCompletedWebhookEvent? = null,
    private val responseFailed: ResponseFailedWebhookEvent? = null,
    private val responseIncomplete: ResponseIncompleteWebhookEvent? = null,
    private val safetyAlertCreated: SafetyAlertCreatedWebhookEvent? = null,
    private val safetyDeactivationIssued: SafetyDeactivationIssuedWebhookEvent? = null,
    private val safetyOrgAlertCreated: SafetyOrgAlertCreatedWebhookEvent? = null,
    private val safetyWarningIssued: SafetyWarningIssuedWebhookEvent? = null,
    private val _json: JsonValue? = null,
) {

    /** Sent when an agent environment expires and can no longer resume from a snapshot. */
    fun agentEnvironmentExpired(): Optional<AgentEnvironmentExpiredWebhookEvent> =
        Optional.ofNullable(agentEnvironmentExpired)

    /**
     * Sent when setup fails for a prewarmed OpenAI-hosted environment before it is attached to a
     * session.
     */
    fun agentEnvironmentFailed(): Optional<AgentEnvironmentFailedWebhookEvent> =
        Optional.ofNullable(agentEnvironmentFailed)

    /**
     * Sent when a prewarmed OpenAI-hosted environment finishes setup before being attached to a
     * session.
     */
    fun agentEnvironmentReady(): Optional<AgentEnvironmentReadyWebhookEvent> =
        Optional.ofNullable(agentEnvironmentReady)

    /** Sent when an agent environment is suspended and can resume from a snapshot. */
    fun agentEnvironmentSuspended(): Optional<AgentEnvironmentSuspendedWebhookEvent> =
        Optional.ofNullable(agentEnvironmentSuspended)

    /** Sent when an agent session requires an action. Retrieve the session for action details. */
    fun agentSessionActionRequired(): Optional<AgentSessionActionRequiredWebhookEvent> =
        Optional.ofNullable(agentSessionActionRequired)

    /** Sent when an agent session is created. */
    fun agentSessionCreated(): Optional<AgentSessionCreatedWebhookEvent> =
        Optional.ofNullable(agentSessionCreated)

    /** Sent when an agent session fails. */
    fun agentSessionFailed(): Optional<AgentSessionFailedWebhookEvent> =
        Optional.ofNullable(agentSessionFailed)

    /** Sent when an agent session becomes idle. */
    fun agentSessionIdle(): Optional<AgentSessionIdleWebhookEvent> =
        Optional.ofNullable(agentSessionIdle)

    /** Sent when an agent session enters the in-progress state. */
    fun agentSessionInProgress(): Optional<AgentSessionInProgressWebhookEvent> =
        Optional.ofNullable(agentSessionInProgress)

    /** Sent when a batch API request has been cancelled. */
    fun batchCancelled(): Optional<BatchCancelledWebhookEvent> = Optional.ofNullable(batchCancelled)

    /** Sent when a batch API request has been completed. */
    fun batchCompleted(): Optional<BatchCompletedWebhookEvent> = Optional.ofNullable(batchCompleted)

    /** Sent when a batch API request has expired. */
    fun batchExpired(): Optional<BatchExpiredWebhookEvent> = Optional.ofNullable(batchExpired)

    /** Sent when a batch API request has failed. */
    fun batchFailed(): Optional<BatchFailedWebhookEvent> = Optional.ofNullable(batchFailed)

    /** Sent when an eval run has been canceled. */
    fun evalRunCanceled(): Optional<EvalRunCanceledWebhookEvent> =
        Optional.ofNullable(evalRunCanceled)

    /** Sent when an eval run has failed. */
    fun evalRunFailed(): Optional<EvalRunFailedWebhookEvent> = Optional.ofNullable(evalRunFailed)

    /** Sent when an eval run has succeeded. */
    fun evalRunSucceeded(): Optional<EvalRunSucceededWebhookEvent> =
        Optional.ofNullable(evalRunSucceeded)

    /** Sent when a fine-tuning job has been cancelled. */
    fun fineTuningJobCancelled(): Optional<FineTuningJobCancelledWebhookEvent> =
        Optional.ofNullable(fineTuningJobCancelled)

    /** Sent when a fine-tuning job has failed. */
    fun fineTuningJobFailed(): Optional<FineTuningJobFailedWebhookEvent> =
        Optional.ofNullable(fineTuningJobFailed)

    /** Sent when a fine-tuning job has succeeded. */
    fun fineTuningJobSucceeded(): Optional<FineTuningJobSucceededWebhookEvent> =
        Optional.ofNullable(fineTuningJobSucceeded)

    /**
     * Deprecated: use `live.transport.incoming`. Retained for existing subscriptions during
     * migration; new subscriptions to this event are not allowed. Sent when an incoming API SIP
     * session is available for Live acceptance. The same pending session can also emit
     * `realtime.call.incoming`; the first successful Realtime or Live accept endpoint selects the
     * runtime surface.
     */
    @Deprecated("deprecated")
    fun liveCallIncoming(): Optional<LiveCallIncomingWebhookEvent> =
        Optional.ofNullable(liveCallIncoming)

    /**
     * Sent when an incoming API SIP session is available for Live acceptance. The same pending
     * session can also emit `realtime.call.incoming`; the first successful Realtime or Live accept
     * endpoint selects the runtime surface.
     */
    fun liveTransportIncoming(): Optional<LiveTransportIncomingWebhookEvent> =
        Optional.ofNullable(liveTransportIncoming)

    /**
     * Sent when an incoming API SIP session is available for Realtime acceptance. The same pending
     * session can also emit `live.transport.incoming`; the first successful Realtime or Live accept
     * endpoint selects the runtime surface.
     */
    fun realtimeCallIncoming(): Optional<RealtimeCallIncomingWebhookEvent> =
        Optional.ofNullable(realtimeCallIncoming)

    /** Sent when a background response has been cancelled. */
    fun responseCancelled(): Optional<ResponseCancelledWebhookEvent> =
        Optional.ofNullable(responseCancelled)

    /** Sent when a background response has been completed. */
    fun responseCompleted(): Optional<ResponseCompletedWebhookEvent> =
        Optional.ofNullable(responseCompleted)

    /** Sent when a background response has failed. */
    fun responseFailed(): Optional<ResponseFailedWebhookEvent> = Optional.ofNullable(responseFailed)

    /** Sent when a background response has been interrupted. */
    fun responseIncomplete(): Optional<ResponseIncompleteWebhookEvent> =
        Optional.ofNullable(responseIncomplete)

    /** Sent when an approved safety alert is available for an API project. */
    fun safetyAlertCreated(): Optional<SafetyAlertCreatedWebhookEvent> =
        Optional.ofNullable(safetyAlertCreated)

    /** Sent when a deactivation is issued for a safety identifier in your organization. */
    fun safetyDeactivationIssued(): Optional<SafetyDeactivationIssuedWebhookEvent> =
        Optional.ofNullable(safetyDeactivationIssued)

    /** Sent when an approved safety alert is available for an enterprise workspace. */
    fun safetyOrgAlertCreated(): Optional<SafetyOrgAlertCreatedWebhookEvent> =
        Optional.ofNullable(safetyOrgAlertCreated)

    /** Sent when a warning is issued for a safety identifier in your organization. */
    fun safetyWarningIssued(): Optional<SafetyWarningIssuedWebhookEvent> =
        Optional.ofNullable(safetyWarningIssued)

    fun isAgentEnvironmentExpired(): Boolean = agentEnvironmentExpired != null

    fun isAgentEnvironmentFailed(): Boolean = agentEnvironmentFailed != null

    fun isAgentEnvironmentReady(): Boolean = agentEnvironmentReady != null

    fun isAgentEnvironmentSuspended(): Boolean = agentEnvironmentSuspended != null

    fun isAgentSessionActionRequired(): Boolean = agentSessionActionRequired != null

    fun isAgentSessionCreated(): Boolean = agentSessionCreated != null

    fun isAgentSessionFailed(): Boolean = agentSessionFailed != null

    fun isAgentSessionIdle(): Boolean = agentSessionIdle != null

    fun isAgentSessionInProgress(): Boolean = agentSessionInProgress != null

    fun isBatchCancelled(): Boolean = batchCancelled != null

    fun isBatchCompleted(): Boolean = batchCompleted != null

    fun isBatchExpired(): Boolean = batchExpired != null

    fun isBatchFailed(): Boolean = batchFailed != null

    fun isEvalRunCanceled(): Boolean = evalRunCanceled != null

    fun isEvalRunFailed(): Boolean = evalRunFailed != null

    fun isEvalRunSucceeded(): Boolean = evalRunSucceeded != null

    fun isFineTuningJobCancelled(): Boolean = fineTuningJobCancelled != null

    fun isFineTuningJobFailed(): Boolean = fineTuningJobFailed != null

    fun isFineTuningJobSucceeded(): Boolean = fineTuningJobSucceeded != null

    @Deprecated("deprecated") fun isLiveCallIncoming(): Boolean = liveCallIncoming != null

    fun isLiveTransportIncoming(): Boolean = liveTransportIncoming != null

    fun isRealtimeCallIncoming(): Boolean = realtimeCallIncoming != null

    fun isResponseCancelled(): Boolean = responseCancelled != null

    fun isResponseCompleted(): Boolean = responseCompleted != null

    fun isResponseFailed(): Boolean = responseFailed != null

    fun isResponseIncomplete(): Boolean = responseIncomplete != null

    fun isSafetyAlertCreated(): Boolean = safetyAlertCreated != null

    fun isSafetyDeactivationIssued(): Boolean = safetyDeactivationIssued != null

    fun isSafetyOrgAlertCreated(): Boolean = safetyOrgAlertCreated != null

    fun isSafetyWarningIssued(): Boolean = safetyWarningIssued != null

    /** Sent when an agent environment expires and can no longer resume from a snapshot. */
    fun asAgentEnvironmentExpired(): AgentEnvironmentExpiredWebhookEvent =
        agentEnvironmentExpired.getOrThrow("agentEnvironmentExpired")

    /**
     * Sent when setup fails for a prewarmed OpenAI-hosted environment before it is attached to a
     * session.
     */
    fun asAgentEnvironmentFailed(): AgentEnvironmentFailedWebhookEvent =
        agentEnvironmentFailed.getOrThrow("agentEnvironmentFailed")

    /**
     * Sent when a prewarmed OpenAI-hosted environment finishes setup before being attached to a
     * session.
     */
    fun asAgentEnvironmentReady(): AgentEnvironmentReadyWebhookEvent =
        agentEnvironmentReady.getOrThrow("agentEnvironmentReady")

    /** Sent when an agent environment is suspended and can resume from a snapshot. */
    fun asAgentEnvironmentSuspended(): AgentEnvironmentSuspendedWebhookEvent =
        agentEnvironmentSuspended.getOrThrow("agentEnvironmentSuspended")

    /** Sent when an agent session requires an action. Retrieve the session for action details. */
    fun asAgentSessionActionRequired(): AgentSessionActionRequiredWebhookEvent =
        agentSessionActionRequired.getOrThrow("agentSessionActionRequired")

    /** Sent when an agent session is created. */
    fun asAgentSessionCreated(): AgentSessionCreatedWebhookEvent =
        agentSessionCreated.getOrThrow("agentSessionCreated")

    /** Sent when an agent session fails. */
    fun asAgentSessionFailed(): AgentSessionFailedWebhookEvent =
        agentSessionFailed.getOrThrow("agentSessionFailed")

    /** Sent when an agent session becomes idle. */
    fun asAgentSessionIdle(): AgentSessionIdleWebhookEvent =
        agentSessionIdle.getOrThrow("agentSessionIdle")

    /** Sent when an agent session enters the in-progress state. */
    fun asAgentSessionInProgress(): AgentSessionInProgressWebhookEvent =
        agentSessionInProgress.getOrThrow("agentSessionInProgress")

    /** Sent when a batch API request has been cancelled. */
    fun asBatchCancelled(): BatchCancelledWebhookEvent = batchCancelled.getOrThrow("batchCancelled")

    /** Sent when a batch API request has been completed. */
    fun asBatchCompleted(): BatchCompletedWebhookEvent = batchCompleted.getOrThrow("batchCompleted")

    /** Sent when a batch API request has expired. */
    fun asBatchExpired(): BatchExpiredWebhookEvent = batchExpired.getOrThrow("batchExpired")

    /** Sent when a batch API request has failed. */
    fun asBatchFailed(): BatchFailedWebhookEvent = batchFailed.getOrThrow("batchFailed")

    /** Sent when an eval run has been canceled. */
    fun asEvalRunCanceled(): EvalRunCanceledWebhookEvent =
        evalRunCanceled.getOrThrow("evalRunCanceled")

    /** Sent when an eval run has failed. */
    fun asEvalRunFailed(): EvalRunFailedWebhookEvent = evalRunFailed.getOrThrow("evalRunFailed")

    /** Sent when an eval run has succeeded. */
    fun asEvalRunSucceeded(): EvalRunSucceededWebhookEvent =
        evalRunSucceeded.getOrThrow("evalRunSucceeded")

    /** Sent when a fine-tuning job has been cancelled. */
    fun asFineTuningJobCancelled(): FineTuningJobCancelledWebhookEvent =
        fineTuningJobCancelled.getOrThrow("fineTuningJobCancelled")

    /** Sent when a fine-tuning job has failed. */
    fun asFineTuningJobFailed(): FineTuningJobFailedWebhookEvent =
        fineTuningJobFailed.getOrThrow("fineTuningJobFailed")

    /** Sent when a fine-tuning job has succeeded. */
    fun asFineTuningJobSucceeded(): FineTuningJobSucceededWebhookEvent =
        fineTuningJobSucceeded.getOrThrow("fineTuningJobSucceeded")

    /**
     * Deprecated: use `live.transport.incoming`. Retained for existing subscriptions during
     * migration; new subscriptions to this event are not allowed. Sent when an incoming API SIP
     * session is available for Live acceptance. The same pending session can also emit
     * `realtime.call.incoming`; the first successful Realtime or Live accept endpoint selects the
     * runtime surface.
     */
    @Deprecated("deprecated")
    fun asLiveCallIncoming(): LiveCallIncomingWebhookEvent =
        liveCallIncoming.getOrThrow("liveCallIncoming")

    /**
     * Sent when an incoming API SIP session is available for Live acceptance. The same pending
     * session can also emit `realtime.call.incoming`; the first successful Realtime or Live accept
     * endpoint selects the runtime surface.
     */
    fun asLiveTransportIncoming(): LiveTransportIncomingWebhookEvent =
        liveTransportIncoming.getOrThrow("liveTransportIncoming")

    /**
     * Sent when an incoming API SIP session is available for Realtime acceptance. The same pending
     * session can also emit `live.transport.incoming`; the first successful Realtime or Live accept
     * endpoint selects the runtime surface.
     */
    fun asRealtimeCallIncoming(): RealtimeCallIncomingWebhookEvent =
        realtimeCallIncoming.getOrThrow("realtimeCallIncoming")

    /** Sent when a background response has been cancelled. */
    fun asResponseCancelled(): ResponseCancelledWebhookEvent =
        responseCancelled.getOrThrow("responseCancelled")

    /** Sent when a background response has been completed. */
    fun asResponseCompleted(): ResponseCompletedWebhookEvent =
        responseCompleted.getOrThrow("responseCompleted")

    /** Sent when a background response has failed. */
    fun asResponseFailed(): ResponseFailedWebhookEvent = responseFailed.getOrThrow("responseFailed")

    /** Sent when a background response has been interrupted. */
    fun asResponseIncomplete(): ResponseIncompleteWebhookEvent =
        responseIncomplete.getOrThrow("responseIncomplete")

    /** Sent when an approved safety alert is available for an API project. */
    fun asSafetyAlertCreated(): SafetyAlertCreatedWebhookEvent =
        safetyAlertCreated.getOrThrow("safetyAlertCreated")

    /** Sent when a deactivation is issued for a safety identifier in your organization. */
    fun asSafetyDeactivationIssued(): SafetyDeactivationIssuedWebhookEvent =
        safetyDeactivationIssued.getOrThrow("safetyDeactivationIssued")

    /** Sent when an approved safety alert is available for an enterprise workspace. */
    fun asSafetyOrgAlertCreated(): SafetyOrgAlertCreatedWebhookEvent =
        safetyOrgAlertCreated.getOrThrow("safetyOrgAlertCreated")

    /** Sent when a warning is issued for a safety identifier in your organization. */
    fun asSafetyWarningIssued(): SafetyWarningIssuedWebhookEvent =
        safetyWarningIssued.getOrThrow("safetyWarningIssued")

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
     * Optional<String> result = unwrapWebhookEvent.accept(new UnwrapWebhookEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitAgentEnvironmentExpired(AgentEnvironmentExpiredWebhookEvent agentEnvironmentExpired) {
     *         return Optional.of(agentEnvironmentExpired.toString());
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
            agentEnvironmentExpired != null ->
                visitor.visitAgentEnvironmentExpired(agentEnvironmentExpired)
            agentEnvironmentFailed != null ->
                visitor.visitAgentEnvironmentFailed(agentEnvironmentFailed)
            agentEnvironmentReady != null ->
                visitor.visitAgentEnvironmentReady(agentEnvironmentReady)
            agentEnvironmentSuspended != null ->
                visitor.visitAgentEnvironmentSuspended(agentEnvironmentSuspended)
            agentSessionActionRequired != null ->
                visitor.visitAgentSessionActionRequired(agentSessionActionRequired)
            agentSessionCreated != null -> visitor.visitAgentSessionCreated(agentSessionCreated)
            agentSessionFailed != null -> visitor.visitAgentSessionFailed(agentSessionFailed)
            agentSessionIdle != null -> visitor.visitAgentSessionIdle(agentSessionIdle)
            agentSessionInProgress != null ->
                visitor.visitAgentSessionInProgress(agentSessionInProgress)
            batchCancelled != null -> visitor.visitBatchCancelled(batchCancelled)
            batchCompleted != null -> visitor.visitBatchCompleted(batchCompleted)
            batchExpired != null -> visitor.visitBatchExpired(batchExpired)
            batchFailed != null -> visitor.visitBatchFailed(batchFailed)
            evalRunCanceled != null -> visitor.visitEvalRunCanceled(evalRunCanceled)
            evalRunFailed != null -> visitor.visitEvalRunFailed(evalRunFailed)
            evalRunSucceeded != null -> visitor.visitEvalRunSucceeded(evalRunSucceeded)
            fineTuningJobCancelled != null ->
                visitor.visitFineTuningJobCancelled(fineTuningJobCancelled)
            fineTuningJobFailed != null -> visitor.visitFineTuningJobFailed(fineTuningJobFailed)
            fineTuningJobSucceeded != null ->
                visitor.visitFineTuningJobSucceeded(fineTuningJobSucceeded)
            liveCallIncoming != null -> visitor.visitLiveCallIncoming(liveCallIncoming)
            liveTransportIncoming != null ->
                visitor.visitLiveTransportIncoming(liveTransportIncoming)
            realtimeCallIncoming != null -> visitor.visitRealtimeCallIncoming(realtimeCallIncoming)
            responseCancelled != null -> visitor.visitResponseCancelled(responseCancelled)
            responseCompleted != null -> visitor.visitResponseCompleted(responseCompleted)
            responseFailed != null -> visitor.visitResponseFailed(responseFailed)
            responseIncomplete != null -> visitor.visitResponseIncomplete(responseIncomplete)
            safetyAlertCreated != null -> visitor.visitSafetyAlertCreated(safetyAlertCreated)
            safetyDeactivationIssued != null ->
                visitor.visitSafetyDeactivationIssued(safetyDeactivationIssued)
            safetyOrgAlertCreated != null ->
                visitor.visitSafetyOrgAlertCreated(safetyOrgAlertCreated)
            safetyWarningIssued != null -> visitor.visitSafetyWarningIssued(safetyWarningIssued)
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
    fun validate(): UnwrapWebhookEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAgentEnvironmentExpired(
                    agentEnvironmentExpired: AgentEnvironmentExpiredWebhookEvent
                ) {
                    agentEnvironmentExpired.validate()
                }

                override fun visitAgentEnvironmentFailed(
                    agentEnvironmentFailed: AgentEnvironmentFailedWebhookEvent
                ) {
                    agentEnvironmentFailed.validate()
                }

                override fun visitAgentEnvironmentReady(
                    agentEnvironmentReady: AgentEnvironmentReadyWebhookEvent
                ) {
                    agentEnvironmentReady.validate()
                }

                override fun visitAgentEnvironmentSuspended(
                    agentEnvironmentSuspended: AgentEnvironmentSuspendedWebhookEvent
                ) {
                    agentEnvironmentSuspended.validate()
                }

                override fun visitAgentSessionActionRequired(
                    agentSessionActionRequired: AgentSessionActionRequiredWebhookEvent
                ) {
                    agentSessionActionRequired.validate()
                }

                override fun visitAgentSessionCreated(
                    agentSessionCreated: AgentSessionCreatedWebhookEvent
                ) {
                    agentSessionCreated.validate()
                }

                override fun visitAgentSessionFailed(
                    agentSessionFailed: AgentSessionFailedWebhookEvent
                ) {
                    agentSessionFailed.validate()
                }

                override fun visitAgentSessionIdle(agentSessionIdle: AgentSessionIdleWebhookEvent) {
                    agentSessionIdle.validate()
                }

                override fun visitAgentSessionInProgress(
                    agentSessionInProgress: AgentSessionInProgressWebhookEvent
                ) {
                    agentSessionInProgress.validate()
                }

                override fun visitBatchCancelled(batchCancelled: BatchCancelledWebhookEvent) {
                    batchCancelled.validate()
                }

                override fun visitBatchCompleted(batchCompleted: BatchCompletedWebhookEvent) {
                    batchCompleted.validate()
                }

                override fun visitBatchExpired(batchExpired: BatchExpiredWebhookEvent) {
                    batchExpired.validate()
                }

                override fun visitBatchFailed(batchFailed: BatchFailedWebhookEvent) {
                    batchFailed.validate()
                }

                override fun visitEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent) {
                    evalRunCanceled.validate()
                }

                override fun visitEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent) {
                    evalRunFailed.validate()
                }

                override fun visitEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent) {
                    evalRunSucceeded.validate()
                }

                override fun visitFineTuningJobCancelled(
                    fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent
                ) {
                    fineTuningJobCancelled.validate()
                }

                override fun visitFineTuningJobFailed(
                    fineTuningJobFailed: FineTuningJobFailedWebhookEvent
                ) {
                    fineTuningJobFailed.validate()
                }

                override fun visitFineTuningJobSucceeded(
                    fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent
                ) {
                    fineTuningJobSucceeded.validate()
                }

                override fun visitLiveCallIncoming(liveCallIncoming: LiveCallIncomingWebhookEvent) {
                    liveCallIncoming.validate()
                }

                override fun visitLiveTransportIncoming(
                    liveTransportIncoming: LiveTransportIncomingWebhookEvent
                ) {
                    liveTransportIncoming.validate()
                }

                override fun visitRealtimeCallIncoming(
                    realtimeCallIncoming: RealtimeCallIncomingWebhookEvent
                ) {
                    realtimeCallIncoming.validate()
                }

                override fun visitResponseCancelled(
                    responseCancelled: ResponseCancelledWebhookEvent
                ) {
                    responseCancelled.validate()
                }

                override fun visitResponseCompleted(
                    responseCompleted: ResponseCompletedWebhookEvent
                ) {
                    responseCompleted.validate()
                }

                override fun visitResponseFailed(responseFailed: ResponseFailedWebhookEvent) {
                    responseFailed.validate()
                }

                override fun visitResponseIncomplete(
                    responseIncomplete: ResponseIncompleteWebhookEvent
                ) {
                    responseIncomplete.validate()
                }

                override fun visitSafetyAlertCreated(
                    safetyAlertCreated: SafetyAlertCreatedWebhookEvent
                ) {
                    safetyAlertCreated.validate()
                }

                override fun visitSafetyDeactivationIssued(
                    safetyDeactivationIssued: SafetyDeactivationIssuedWebhookEvent
                ) {
                    safetyDeactivationIssued.validate()
                }

                override fun visitSafetyOrgAlertCreated(
                    safetyOrgAlertCreated: SafetyOrgAlertCreatedWebhookEvent
                ) {
                    safetyOrgAlertCreated.validate()
                }

                override fun visitSafetyWarningIssued(
                    safetyWarningIssued: SafetyWarningIssuedWebhookEvent
                ) {
                    safetyWarningIssued.validate()
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
                override fun visitAgentEnvironmentExpired(
                    agentEnvironmentExpired: AgentEnvironmentExpiredWebhookEvent
                ) = agentEnvironmentExpired.validity()

                override fun visitAgentEnvironmentFailed(
                    agentEnvironmentFailed: AgentEnvironmentFailedWebhookEvent
                ) = agentEnvironmentFailed.validity()

                override fun visitAgentEnvironmentReady(
                    agentEnvironmentReady: AgentEnvironmentReadyWebhookEvent
                ) = agentEnvironmentReady.validity()

                override fun visitAgentEnvironmentSuspended(
                    agentEnvironmentSuspended: AgentEnvironmentSuspendedWebhookEvent
                ) = agentEnvironmentSuspended.validity()

                override fun visitAgentSessionActionRequired(
                    agentSessionActionRequired: AgentSessionActionRequiredWebhookEvent
                ) = agentSessionActionRequired.validity()

                override fun visitAgentSessionCreated(
                    agentSessionCreated: AgentSessionCreatedWebhookEvent
                ) = agentSessionCreated.validity()

                override fun visitAgentSessionFailed(
                    agentSessionFailed: AgentSessionFailedWebhookEvent
                ) = agentSessionFailed.validity()

                override fun visitAgentSessionIdle(agentSessionIdle: AgentSessionIdleWebhookEvent) =
                    agentSessionIdle.validity()

                override fun visitAgentSessionInProgress(
                    agentSessionInProgress: AgentSessionInProgressWebhookEvent
                ) = agentSessionInProgress.validity()

                override fun visitBatchCancelled(batchCancelled: BatchCancelledWebhookEvent) =
                    batchCancelled.validity()

                override fun visitBatchCompleted(batchCompleted: BatchCompletedWebhookEvent) =
                    batchCompleted.validity()

                override fun visitBatchExpired(batchExpired: BatchExpiredWebhookEvent) =
                    batchExpired.validity()

                override fun visitBatchFailed(batchFailed: BatchFailedWebhookEvent) =
                    batchFailed.validity()

                override fun visitEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent) =
                    evalRunCanceled.validity()

                override fun visitEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent) =
                    evalRunFailed.validity()

                override fun visitEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent) =
                    evalRunSucceeded.validity()

                override fun visitFineTuningJobCancelled(
                    fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent
                ) = fineTuningJobCancelled.validity()

                override fun visitFineTuningJobFailed(
                    fineTuningJobFailed: FineTuningJobFailedWebhookEvent
                ) = fineTuningJobFailed.validity()

                override fun visitFineTuningJobSucceeded(
                    fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent
                ) = fineTuningJobSucceeded.validity()

                override fun visitLiveCallIncoming(liveCallIncoming: LiveCallIncomingWebhookEvent) =
                    liveCallIncoming.validity()

                override fun visitLiveTransportIncoming(
                    liveTransportIncoming: LiveTransportIncomingWebhookEvent
                ) = liveTransportIncoming.validity()

                override fun visitRealtimeCallIncoming(
                    realtimeCallIncoming: RealtimeCallIncomingWebhookEvent
                ) = realtimeCallIncoming.validity()

                override fun visitResponseCancelled(
                    responseCancelled: ResponseCancelledWebhookEvent
                ) = responseCancelled.validity()

                override fun visitResponseCompleted(
                    responseCompleted: ResponseCompletedWebhookEvent
                ) = responseCompleted.validity()

                override fun visitResponseFailed(responseFailed: ResponseFailedWebhookEvent) =
                    responseFailed.validity()

                override fun visitResponseIncomplete(
                    responseIncomplete: ResponseIncompleteWebhookEvent
                ) = responseIncomplete.validity()

                override fun visitSafetyAlertCreated(
                    safetyAlertCreated: SafetyAlertCreatedWebhookEvent
                ) = safetyAlertCreated.validity()

                override fun visitSafetyDeactivationIssued(
                    safetyDeactivationIssued: SafetyDeactivationIssuedWebhookEvent
                ) = safetyDeactivationIssued.validity()

                override fun visitSafetyOrgAlertCreated(
                    safetyOrgAlertCreated: SafetyOrgAlertCreatedWebhookEvent
                ) = safetyOrgAlertCreated.validity()

                override fun visitSafetyWarningIssued(
                    safetyWarningIssued: SafetyWarningIssuedWebhookEvent
                ) = safetyWarningIssued.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UnwrapWebhookEvent &&
            agentEnvironmentExpired == other.agentEnvironmentExpired &&
            agentEnvironmentFailed == other.agentEnvironmentFailed &&
            agentEnvironmentReady == other.agentEnvironmentReady &&
            agentEnvironmentSuspended == other.agentEnvironmentSuspended &&
            agentSessionActionRequired == other.agentSessionActionRequired &&
            agentSessionCreated == other.agentSessionCreated &&
            agentSessionFailed == other.agentSessionFailed &&
            agentSessionIdle == other.agentSessionIdle &&
            agentSessionInProgress == other.agentSessionInProgress &&
            batchCancelled == other.batchCancelled &&
            batchCompleted == other.batchCompleted &&
            batchExpired == other.batchExpired &&
            batchFailed == other.batchFailed &&
            evalRunCanceled == other.evalRunCanceled &&
            evalRunFailed == other.evalRunFailed &&
            evalRunSucceeded == other.evalRunSucceeded &&
            fineTuningJobCancelled == other.fineTuningJobCancelled &&
            fineTuningJobFailed == other.fineTuningJobFailed &&
            fineTuningJobSucceeded == other.fineTuningJobSucceeded &&
            liveCallIncoming == other.liveCallIncoming &&
            liveTransportIncoming == other.liveTransportIncoming &&
            realtimeCallIncoming == other.realtimeCallIncoming &&
            responseCancelled == other.responseCancelled &&
            responseCompleted == other.responseCompleted &&
            responseFailed == other.responseFailed &&
            responseIncomplete == other.responseIncomplete &&
            safetyAlertCreated == other.safetyAlertCreated &&
            safetyDeactivationIssued == other.safetyDeactivationIssued &&
            safetyOrgAlertCreated == other.safetyOrgAlertCreated &&
            safetyWarningIssued == other.safetyWarningIssued
    }

    override fun hashCode(): Int =
        Objects.hash(
            agentEnvironmentExpired,
            agentEnvironmentFailed,
            agentEnvironmentReady,
            agentEnvironmentSuspended,
            agentSessionActionRequired,
            agentSessionCreated,
            agentSessionFailed,
            agentSessionIdle,
            agentSessionInProgress,
            batchCancelled,
            batchCompleted,
            batchExpired,
            batchFailed,
            evalRunCanceled,
            evalRunFailed,
            evalRunSucceeded,
            fineTuningJobCancelled,
            fineTuningJobFailed,
            fineTuningJobSucceeded,
            liveCallIncoming,
            liveTransportIncoming,
            realtimeCallIncoming,
            responseCancelled,
            responseCompleted,
            responseFailed,
            responseIncomplete,
            safetyAlertCreated,
            safetyDeactivationIssued,
            safetyOrgAlertCreated,
            safetyWarningIssued,
        )

    override fun toString(): String =
        when {
            agentEnvironmentExpired != null ->
                "UnwrapWebhookEvent{agentEnvironmentExpired=$agentEnvironmentExpired}"
            agentEnvironmentFailed != null ->
                "UnwrapWebhookEvent{agentEnvironmentFailed=$agentEnvironmentFailed}"
            agentEnvironmentReady != null ->
                "UnwrapWebhookEvent{agentEnvironmentReady=$agentEnvironmentReady}"
            agentEnvironmentSuspended != null ->
                "UnwrapWebhookEvent{agentEnvironmentSuspended=$agentEnvironmentSuspended}"
            agentSessionActionRequired != null ->
                "UnwrapWebhookEvent{agentSessionActionRequired=$agentSessionActionRequired}"
            agentSessionCreated != null ->
                "UnwrapWebhookEvent{agentSessionCreated=$agentSessionCreated}"
            agentSessionFailed != null ->
                "UnwrapWebhookEvent{agentSessionFailed=$agentSessionFailed}"
            agentSessionIdle != null -> "UnwrapWebhookEvent{agentSessionIdle=$agentSessionIdle}"
            agentSessionInProgress != null ->
                "UnwrapWebhookEvent{agentSessionInProgress=$agentSessionInProgress}"
            batchCancelled != null -> "UnwrapWebhookEvent{batchCancelled=$batchCancelled}"
            batchCompleted != null -> "UnwrapWebhookEvent{batchCompleted=$batchCompleted}"
            batchExpired != null -> "UnwrapWebhookEvent{batchExpired=$batchExpired}"
            batchFailed != null -> "UnwrapWebhookEvent{batchFailed=$batchFailed}"
            evalRunCanceled != null -> "UnwrapWebhookEvent{evalRunCanceled=$evalRunCanceled}"
            evalRunFailed != null -> "UnwrapWebhookEvent{evalRunFailed=$evalRunFailed}"
            evalRunSucceeded != null -> "UnwrapWebhookEvent{evalRunSucceeded=$evalRunSucceeded}"
            fineTuningJobCancelled != null ->
                "UnwrapWebhookEvent{fineTuningJobCancelled=$fineTuningJobCancelled}"
            fineTuningJobFailed != null ->
                "UnwrapWebhookEvent{fineTuningJobFailed=$fineTuningJobFailed}"
            fineTuningJobSucceeded != null ->
                "UnwrapWebhookEvent{fineTuningJobSucceeded=$fineTuningJobSucceeded}"
            liveCallIncoming != null -> "UnwrapWebhookEvent{liveCallIncoming=$liveCallIncoming}"
            liveTransportIncoming != null ->
                "UnwrapWebhookEvent{liveTransportIncoming=$liveTransportIncoming}"
            realtimeCallIncoming != null ->
                "UnwrapWebhookEvent{realtimeCallIncoming=$realtimeCallIncoming}"
            responseCancelled != null -> "UnwrapWebhookEvent{responseCancelled=$responseCancelled}"
            responseCompleted != null -> "UnwrapWebhookEvent{responseCompleted=$responseCompleted}"
            responseFailed != null -> "UnwrapWebhookEvent{responseFailed=$responseFailed}"
            responseIncomplete != null ->
                "UnwrapWebhookEvent{responseIncomplete=$responseIncomplete}"
            safetyAlertCreated != null ->
                "UnwrapWebhookEvent{safetyAlertCreated=$safetyAlertCreated}"
            safetyDeactivationIssued != null ->
                "UnwrapWebhookEvent{safetyDeactivationIssued=$safetyDeactivationIssued}"
            safetyOrgAlertCreated != null ->
                "UnwrapWebhookEvent{safetyOrgAlertCreated=$safetyOrgAlertCreated}"
            safetyWarningIssued != null ->
                "UnwrapWebhookEvent{safetyWarningIssued=$safetyWarningIssued}"
            _json != null -> "UnwrapWebhookEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
        }

    companion object {

        /** Sent when an agent environment expires and can no longer resume from a snapshot. */
        @JvmStatic
        fun ofAgentEnvironmentExpired(
            agentEnvironmentExpired: AgentEnvironmentExpiredWebhookEvent
        ) = UnwrapWebhookEvent(agentEnvironmentExpired = agentEnvironmentExpired)

        /**
         * Sent when setup fails for a prewarmed OpenAI-hosted environment before it is attached to
         * a session.
         */
        @JvmStatic
        fun ofAgentEnvironmentFailed(agentEnvironmentFailed: AgentEnvironmentFailedWebhookEvent) =
            UnwrapWebhookEvent(agentEnvironmentFailed = agentEnvironmentFailed)

        /**
         * Sent when a prewarmed OpenAI-hosted environment finishes setup before being attached to a
         * session.
         */
        @JvmStatic
        fun ofAgentEnvironmentReady(agentEnvironmentReady: AgentEnvironmentReadyWebhookEvent) =
            UnwrapWebhookEvent(agentEnvironmentReady = agentEnvironmentReady)

        /** Sent when an agent environment is suspended and can resume from a snapshot. */
        @JvmStatic
        fun ofAgentEnvironmentSuspended(
            agentEnvironmentSuspended: AgentEnvironmentSuspendedWebhookEvent
        ) = UnwrapWebhookEvent(agentEnvironmentSuspended = agentEnvironmentSuspended)

        /**
         * Sent when an agent session requires an action. Retrieve the session for action details.
         */
        @JvmStatic
        fun ofAgentSessionActionRequired(
            agentSessionActionRequired: AgentSessionActionRequiredWebhookEvent
        ) = UnwrapWebhookEvent(agentSessionActionRequired = agentSessionActionRequired)

        /** Sent when an agent session is created. */
        @JvmStatic
        fun ofAgentSessionCreated(agentSessionCreated: AgentSessionCreatedWebhookEvent) =
            UnwrapWebhookEvent(agentSessionCreated = agentSessionCreated)

        /** Sent when an agent session fails. */
        @JvmStatic
        fun ofAgentSessionFailed(agentSessionFailed: AgentSessionFailedWebhookEvent) =
            UnwrapWebhookEvent(agentSessionFailed = agentSessionFailed)

        /** Sent when an agent session becomes idle. */
        @JvmStatic
        fun ofAgentSessionIdle(agentSessionIdle: AgentSessionIdleWebhookEvent) =
            UnwrapWebhookEvent(agentSessionIdle = agentSessionIdle)

        /** Sent when an agent session enters the in-progress state. */
        @JvmStatic
        fun ofAgentSessionInProgress(agentSessionInProgress: AgentSessionInProgressWebhookEvent) =
            UnwrapWebhookEvent(agentSessionInProgress = agentSessionInProgress)

        /** Sent when a batch API request has been cancelled. */
        @JvmStatic
        fun ofBatchCancelled(batchCancelled: BatchCancelledWebhookEvent) =
            UnwrapWebhookEvent(batchCancelled = batchCancelled)

        /** Sent when a batch API request has been completed. */
        @JvmStatic
        fun ofBatchCompleted(batchCompleted: BatchCompletedWebhookEvent) =
            UnwrapWebhookEvent(batchCompleted = batchCompleted)

        /** Sent when a batch API request has expired. */
        @JvmStatic
        fun ofBatchExpired(batchExpired: BatchExpiredWebhookEvent) =
            UnwrapWebhookEvent(batchExpired = batchExpired)

        /** Sent when a batch API request has failed. */
        @JvmStatic
        fun ofBatchFailed(batchFailed: BatchFailedWebhookEvent) =
            UnwrapWebhookEvent(batchFailed = batchFailed)

        /** Sent when an eval run has been canceled. */
        @JvmStatic
        fun ofEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent) =
            UnwrapWebhookEvent(evalRunCanceled = evalRunCanceled)

        /** Sent when an eval run has failed. */
        @JvmStatic
        fun ofEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent) =
            UnwrapWebhookEvent(evalRunFailed = evalRunFailed)

        /** Sent when an eval run has succeeded. */
        @JvmStatic
        fun ofEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent) =
            UnwrapWebhookEvent(evalRunSucceeded = evalRunSucceeded)

        /** Sent when a fine-tuning job has been cancelled. */
        @JvmStatic
        fun ofFineTuningJobCancelled(fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent) =
            UnwrapWebhookEvent(fineTuningJobCancelled = fineTuningJobCancelled)

        /** Sent when a fine-tuning job has failed. */
        @JvmStatic
        fun ofFineTuningJobFailed(fineTuningJobFailed: FineTuningJobFailedWebhookEvent) =
            UnwrapWebhookEvent(fineTuningJobFailed = fineTuningJobFailed)

        /** Sent when a fine-tuning job has succeeded. */
        @JvmStatic
        fun ofFineTuningJobSucceeded(fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent) =
            UnwrapWebhookEvent(fineTuningJobSucceeded = fineTuningJobSucceeded)

        /**
         * Deprecated: use `live.transport.incoming`. Retained for existing subscriptions during
         * migration; new subscriptions to this event are not allowed. Sent when an incoming API SIP
         * session is available for Live acceptance. The same pending session can also emit
         * `realtime.call.incoming`; the first successful Realtime or Live accept endpoint selects
         * the runtime surface.
         */
        @Deprecated("deprecated")
        @JvmStatic
        fun ofLiveCallIncoming(liveCallIncoming: LiveCallIncomingWebhookEvent) =
            UnwrapWebhookEvent(liveCallIncoming = liveCallIncoming)

        /**
         * Sent when an incoming API SIP session is available for Live acceptance. The same pending
         * session can also emit `realtime.call.incoming`; the first successful Realtime or Live
         * accept endpoint selects the runtime surface.
         */
        @JvmStatic
        fun ofLiveTransportIncoming(liveTransportIncoming: LiveTransportIncomingWebhookEvent) =
            UnwrapWebhookEvent(liveTransportIncoming = liveTransportIncoming)

        /**
         * Sent when an incoming API SIP session is available for Realtime acceptance. The same
         * pending session can also emit `live.transport.incoming`; the first successful Realtime or
         * Live accept endpoint selects the runtime surface.
         */
        @JvmStatic
        fun ofRealtimeCallIncoming(realtimeCallIncoming: RealtimeCallIncomingWebhookEvent) =
            UnwrapWebhookEvent(realtimeCallIncoming = realtimeCallIncoming)

        /** Sent when a background response has been cancelled. */
        @JvmStatic
        fun ofResponseCancelled(responseCancelled: ResponseCancelledWebhookEvent) =
            UnwrapWebhookEvent(responseCancelled = responseCancelled)

        /** Sent when a background response has been completed. */
        @JvmStatic
        fun ofResponseCompleted(responseCompleted: ResponseCompletedWebhookEvent) =
            UnwrapWebhookEvent(responseCompleted = responseCompleted)

        /** Sent when a background response has failed. */
        @JvmStatic
        fun ofResponseFailed(responseFailed: ResponseFailedWebhookEvent) =
            UnwrapWebhookEvent(responseFailed = responseFailed)

        /** Sent when a background response has been interrupted. */
        @JvmStatic
        fun ofResponseIncomplete(responseIncomplete: ResponseIncompleteWebhookEvent) =
            UnwrapWebhookEvent(responseIncomplete = responseIncomplete)

        /** Sent when an approved safety alert is available for an API project. */
        @JvmStatic
        fun ofSafetyAlertCreated(safetyAlertCreated: SafetyAlertCreatedWebhookEvent) =
            UnwrapWebhookEvent(safetyAlertCreated = safetyAlertCreated)

        /** Sent when a deactivation is issued for a safety identifier in your organization. */
        @JvmStatic
        fun ofSafetyDeactivationIssued(
            safetyDeactivationIssued: SafetyDeactivationIssuedWebhookEvent
        ) = UnwrapWebhookEvent(safetyDeactivationIssued = safetyDeactivationIssued)

        /** Sent when an approved safety alert is available for an enterprise workspace. */
        @JvmStatic
        fun ofSafetyOrgAlertCreated(safetyOrgAlertCreated: SafetyOrgAlertCreatedWebhookEvent) =
            UnwrapWebhookEvent(safetyOrgAlertCreated = safetyOrgAlertCreated)

        /** Sent when a warning is issued for a safety identifier in your organization. */
        @JvmStatic
        fun ofSafetyWarningIssued(safetyWarningIssued: SafetyWarningIssuedWebhookEvent) =
            UnwrapWebhookEvent(safetyWarningIssued = safetyWarningIssued)
    }

    /**
     * An interface that defines how to map each variant of [UnwrapWebhookEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Sent when an agent environment expires and can no longer resume from a snapshot. */
        fun visitAgentEnvironmentExpired(
            agentEnvironmentExpired: AgentEnvironmentExpiredWebhookEvent
        ): T = unknown(JsonValue.from(agentEnvironmentExpired))

        /**
         * Sent when setup fails for a prewarmed OpenAI-hosted environment before it is attached to
         * a session.
         */
        fun visitAgentEnvironmentFailed(
            agentEnvironmentFailed: AgentEnvironmentFailedWebhookEvent
        ): T = unknown(JsonValue.from(agentEnvironmentFailed))

        /**
         * Sent when a prewarmed OpenAI-hosted environment finishes setup before being attached to a
         * session.
         */
        fun visitAgentEnvironmentReady(
            agentEnvironmentReady: AgentEnvironmentReadyWebhookEvent
        ): T = unknown(JsonValue.from(agentEnvironmentReady))

        /** Sent when an agent environment is suspended and can resume from a snapshot. */
        fun visitAgentEnvironmentSuspended(
            agentEnvironmentSuspended: AgentEnvironmentSuspendedWebhookEvent
        ): T = unknown(JsonValue.from(agentEnvironmentSuspended))

        /**
         * Sent when an agent session requires an action. Retrieve the session for action details.
         */
        fun visitAgentSessionActionRequired(
            agentSessionActionRequired: AgentSessionActionRequiredWebhookEvent
        ): T = unknown(JsonValue.from(agentSessionActionRequired))

        /** Sent when an agent session is created. */
        fun visitAgentSessionCreated(agentSessionCreated: AgentSessionCreatedWebhookEvent): T =
            unknown(JsonValue.from(agentSessionCreated))

        /** Sent when an agent session fails. */
        fun visitAgentSessionFailed(agentSessionFailed: AgentSessionFailedWebhookEvent): T =
            unknown(JsonValue.from(agentSessionFailed))

        /** Sent when an agent session becomes idle. */
        fun visitAgentSessionIdle(agentSessionIdle: AgentSessionIdleWebhookEvent): T =
            unknown(JsonValue.from(agentSessionIdle))

        /** Sent when an agent session enters the in-progress state. */
        fun visitAgentSessionInProgress(
            agentSessionInProgress: AgentSessionInProgressWebhookEvent
        ): T = unknown(JsonValue.from(agentSessionInProgress))

        /** Sent when a batch API request has been cancelled. */
        fun visitBatchCancelled(batchCancelled: BatchCancelledWebhookEvent): T

        /** Sent when a batch API request has been completed. */
        fun visitBatchCompleted(batchCompleted: BatchCompletedWebhookEvent): T

        /** Sent when a batch API request has expired. */
        fun visitBatchExpired(batchExpired: BatchExpiredWebhookEvent): T

        /** Sent when a batch API request has failed. */
        fun visitBatchFailed(batchFailed: BatchFailedWebhookEvent): T

        /** Sent when an eval run has been canceled. */
        fun visitEvalRunCanceled(evalRunCanceled: EvalRunCanceledWebhookEvent): T

        /** Sent when an eval run has failed. */
        fun visitEvalRunFailed(evalRunFailed: EvalRunFailedWebhookEvent): T

        /** Sent when an eval run has succeeded. */
        fun visitEvalRunSucceeded(evalRunSucceeded: EvalRunSucceededWebhookEvent): T

        /** Sent when a fine-tuning job has been cancelled. */
        fun visitFineTuningJobCancelled(
            fineTuningJobCancelled: FineTuningJobCancelledWebhookEvent
        ): T

        /** Sent when a fine-tuning job has failed. */
        fun visitFineTuningJobFailed(fineTuningJobFailed: FineTuningJobFailedWebhookEvent): T

        /** Sent when a fine-tuning job has succeeded. */
        fun visitFineTuningJobSucceeded(
            fineTuningJobSucceeded: FineTuningJobSucceededWebhookEvent
        ): T

        /**
         * Deprecated: use `live.transport.incoming`. Retained for existing subscriptions during
         * migration; new subscriptions to this event are not allowed. Sent when an incoming API SIP
         * session is available for Live acceptance. The same pending session can also emit
         * `realtime.call.incoming`; the first successful Realtime or Live accept endpoint selects
         * the runtime surface.
         */
        @Deprecated("deprecated")
        fun visitLiveCallIncoming(liveCallIncoming: LiveCallIncomingWebhookEvent): T

        /**
         * Sent when an incoming API SIP session is available for Live acceptance. The same pending
         * session can also emit `realtime.call.incoming`; the first successful Realtime or Live
         * accept endpoint selects the runtime surface.
         */
        fun visitLiveTransportIncoming(liveTransportIncoming: LiveTransportIncomingWebhookEvent): T

        /**
         * Sent when an incoming API SIP session is available for Realtime acceptance. The same
         * pending session can also emit `live.transport.incoming`; the first successful Realtime or
         * Live accept endpoint selects the runtime surface.
         */
        fun visitRealtimeCallIncoming(realtimeCallIncoming: RealtimeCallIncomingWebhookEvent): T

        /** Sent when a background response has been cancelled. */
        fun visitResponseCancelled(responseCancelled: ResponseCancelledWebhookEvent): T

        /** Sent when a background response has been completed. */
        fun visitResponseCompleted(responseCompleted: ResponseCompletedWebhookEvent): T

        /** Sent when a background response has failed. */
        fun visitResponseFailed(responseFailed: ResponseFailedWebhookEvent): T

        /** Sent when a background response has been interrupted. */
        fun visitResponseIncomplete(responseIncomplete: ResponseIncompleteWebhookEvent): T

        /** Sent when an approved safety alert is available for an API project. */
        fun visitSafetyAlertCreated(safetyAlertCreated: SafetyAlertCreatedWebhookEvent): T

        /** Sent when a deactivation is issued for a safety identifier in your organization. */
        fun visitSafetyDeactivationIssued(
            safetyDeactivationIssued: SafetyDeactivationIssuedWebhookEvent
        ): T = unknown(JsonValue.from(safetyDeactivationIssued))

        /** Sent when an approved safety alert is available for an enterprise workspace. */
        fun visitSafetyOrgAlertCreated(safetyOrgAlertCreated: SafetyOrgAlertCreatedWebhookEvent): T

        /** Sent when a warning is issued for a safety identifier in your organization. */
        fun visitSafetyWarningIssued(safetyWarningIssued: SafetyWarningIssuedWebhookEvent): T =
            unknown(JsonValue.from(safetyWarningIssued))

        /**
         * Maps an unknown variant of [UnwrapWebhookEvent] to a value of type [T].
         *
         * An instance of [UnwrapWebhookEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown UnwrapWebhookEvent")
        }
    }

    internal class Deserializer : BaseDeserializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UnwrapWebhookEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "agent.environment.expired" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentEnvironmentExpiredWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(agentEnvironmentExpired = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.environment.failed" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentEnvironmentFailedWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(agentEnvironmentFailed = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.environment.ready" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentEnvironmentReadyWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(agentEnvironmentReady = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.environment.suspended" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentEnvironmentSuspendedWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(agentEnvironmentSuspended = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.session.action_required" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionActionRequiredWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(agentSessionActionRequired = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.session.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionCreatedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(agentSessionCreated = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.session.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionFailedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(agentSessionFailed = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.session.idle" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentSessionIdleWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(agentSessionIdle = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "agent.session.in_progress" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<AgentSessionInProgressWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(agentSessionInProgress = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchCancelledWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchCancelled = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchCompletedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchCompleted = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.expired" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchExpiredWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchExpired = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "batch.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<BatchFailedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(batchFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "eval.run.canceled" -> {
                    return tryDeserialize(node, jacksonTypeRef<EvalRunCanceledWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(evalRunCanceled = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "eval.run.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EvalRunFailedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(evalRunFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "eval.run.succeeded" -> {
                    return tryDeserialize(node, jacksonTypeRef<EvalRunSucceededWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(evalRunSucceeded = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "fine_tuning.job.cancelled" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<FineTuningJobCancelledWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(fineTuningJobCancelled = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "fine_tuning.job.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<FineTuningJobFailedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(fineTuningJobFailed = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "fine_tuning.job.succeeded" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<FineTuningJobSucceededWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(fineTuningJobSucceeded = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "live.call.incoming" -> {
                    return tryDeserialize(node, jacksonTypeRef<LiveCallIncomingWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(liveCallIncoming = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "live.transport.incoming" -> {
                    return tryDeserialize(node, jacksonTypeRef<LiveTransportIncomingWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(liveTransportIncoming = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "realtime.call.incoming" -> {
                    return tryDeserialize(node, jacksonTypeRef<RealtimeCallIncomingWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(realtimeCallIncoming = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "response.cancelled" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCancelledWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(responseCancelled = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "response.completed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseCompletedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(responseCompleted = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "response.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFailedWebhookEvent>())?.let {
                        UnwrapWebhookEvent(responseFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "response.incomplete" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseIncompleteWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(responseIncomplete = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "safety.alert.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<SafetyAlertCreatedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(safetyAlertCreated = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "safety.deactivation_issued" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<SafetyDeactivationIssuedWebhookEvent>(),
                        )
                        ?.let { UnwrapWebhookEvent(safetyDeactivationIssued = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "safety.org_alert.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<SafetyOrgAlertCreatedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(safetyOrgAlertCreated = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
                "safety.warning_issued" -> {
                    return tryDeserialize(node, jacksonTypeRef<SafetyWarningIssuedWebhookEvent>())
                        ?.let { UnwrapWebhookEvent(safetyWarningIssued = it, _json = json) }
                        ?: UnwrapWebhookEvent(_json = json)
                }
            }

            return UnwrapWebhookEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun serialize(
            value: UnwrapWebhookEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.agentEnvironmentExpired != null ->
                    generator.writeObject(value.agentEnvironmentExpired)
                value.agentEnvironmentFailed != null ->
                    generator.writeObject(value.agentEnvironmentFailed)
                value.agentEnvironmentReady != null ->
                    generator.writeObject(value.agentEnvironmentReady)
                value.agentEnvironmentSuspended != null ->
                    generator.writeObject(value.agentEnvironmentSuspended)
                value.agentSessionActionRequired != null ->
                    generator.writeObject(value.agentSessionActionRequired)
                value.agentSessionCreated != null ->
                    generator.writeObject(value.agentSessionCreated)
                value.agentSessionFailed != null -> generator.writeObject(value.agentSessionFailed)
                value.agentSessionIdle != null -> generator.writeObject(value.agentSessionIdle)
                value.agentSessionInProgress != null ->
                    generator.writeObject(value.agentSessionInProgress)
                value.batchCancelled != null -> generator.writeObject(value.batchCancelled)
                value.batchCompleted != null -> generator.writeObject(value.batchCompleted)
                value.batchExpired != null -> generator.writeObject(value.batchExpired)
                value.batchFailed != null -> generator.writeObject(value.batchFailed)
                value.evalRunCanceled != null -> generator.writeObject(value.evalRunCanceled)
                value.evalRunFailed != null -> generator.writeObject(value.evalRunFailed)
                value.evalRunSucceeded != null -> generator.writeObject(value.evalRunSucceeded)
                value.fineTuningJobCancelled != null ->
                    generator.writeObject(value.fineTuningJobCancelled)
                value.fineTuningJobFailed != null ->
                    generator.writeObject(value.fineTuningJobFailed)
                value.fineTuningJobSucceeded != null ->
                    generator.writeObject(value.fineTuningJobSucceeded)
                value.liveCallIncoming != null -> generator.writeObject(value.liveCallIncoming)
                value.liveTransportIncoming != null ->
                    generator.writeObject(value.liveTransportIncoming)
                value.realtimeCallIncoming != null ->
                    generator.writeObject(value.realtimeCallIncoming)
                value.responseCancelled != null -> generator.writeObject(value.responseCancelled)
                value.responseCompleted != null -> generator.writeObject(value.responseCompleted)
                value.responseFailed != null -> generator.writeObject(value.responseFailed)
                value.responseIncomplete != null -> generator.writeObject(value.responseIncomplete)
                value.safetyAlertCreated != null -> generator.writeObject(value.safetyAlertCreated)
                value.safetyDeactivationIssued != null ->
                    generator.writeObject(value.safetyDeactivationIssued)
                value.safetyOrgAlertCreated != null ->
                    generator.writeObject(value.safetyOrgAlertCreated)
                value.safetyWarningIssued != null ->
                    generator.writeObject(value.safetyWarningIssued)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
            }
        }
    }
}
