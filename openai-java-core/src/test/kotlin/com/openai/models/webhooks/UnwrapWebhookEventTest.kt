// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UnwrapWebhookEventTest {

    @Test
    fun ofBatchCancelled() {
        val batchCancelled =
            BatchCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCancelledWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofBatchCancelled(batchCancelled)

        assertThat(unwrapWebhookEvent.batchCancelled()).contains(batchCancelled)
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofBatchCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofBatchCancelled(
                BatchCancelledWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(BatchCancelledWebhookEvent.Data.builder().id("id").build())
                    .object_(BatchCancelledWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofBatchCompleted() {
        val batchCompleted =
            BatchCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchCompletedWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofBatchCompleted(batchCompleted)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).contains(batchCompleted)
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofBatchCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofBatchCompleted(
                BatchCompletedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(BatchCompletedWebhookEvent.Data.builder().id("id").build())
                    .object_(BatchCompletedWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofBatchExpired() {
        val batchExpired =
            BatchExpiredWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchExpiredWebhookEvent.Data.builder().id("id").build())
                .object_(BatchExpiredWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofBatchExpired(batchExpired)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).contains(batchExpired)
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofBatchExpiredRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofBatchExpired(
                BatchExpiredWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(BatchExpiredWebhookEvent.Data.builder().id("id").build())
                    .object_(BatchExpiredWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofBatchFailed() {
        val batchFailed =
            BatchFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(BatchFailedWebhookEvent.Data.builder().id("id").build())
                .object_(BatchFailedWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofBatchFailed(batchFailed)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).contains(batchFailed)
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofBatchFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofBatchFailed(
                BatchFailedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(BatchFailedWebhookEvent.Data.builder().id("id").build())
                    .object_(BatchFailedWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEvalRunCanceled() {
        val evalRunCanceled =
            EvalRunCanceledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunCanceledWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEvalRunCanceled(evalRunCanceled)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).contains(evalRunCanceled)
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofEvalRunCanceledRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEvalRunCanceled(
                EvalRunCanceledWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(EvalRunCanceledWebhookEvent.Data.builder().id("id").build())
                    .object_(EvalRunCanceledWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEvalRunFailed() {
        val evalRunFailed =
            EvalRunFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunFailedWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunFailedWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEvalRunFailed(evalRunFailed)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).contains(evalRunFailed)
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofEvalRunFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEvalRunFailed(
                EvalRunFailedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(EvalRunFailedWebhookEvent.Data.builder().id("id").build())
                    .object_(EvalRunFailedWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEvalRunSucceeded() {
        val evalRunSucceeded =
            EvalRunSucceededWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(EvalRunSucceededWebhookEvent.Data.builder().id("id").build())
                .object_(EvalRunSucceededWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEvalRunSucceeded(evalRunSucceeded)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).contains(evalRunSucceeded)
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofEvalRunSucceededRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEvalRunSucceeded(
                EvalRunSucceededWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(EvalRunSucceededWebhookEvent.Data.builder().id("id").build())
                    .object_(EvalRunSucceededWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofFineTuningJobCancelled() {
        val fineTuningJobCancelled =
            FineTuningJobCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobCancelledWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFineTuningJobCancelled(fineTuningJobCancelled)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).contains(fineTuningJobCancelled)
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofFineTuningJobCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFineTuningJobCancelled(
                FineTuningJobCancelledWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(FineTuningJobCancelledWebhookEvent.Data.builder().id("id").build())
                    .object_(FineTuningJobCancelledWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofFineTuningJobFailed() {
        val fineTuningJobFailed =
            FineTuningJobFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobFailedWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobFailedWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFineTuningJobFailed(fineTuningJobFailed)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).contains(fineTuningJobFailed)
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofFineTuningJobFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFineTuningJobFailed(
                FineTuningJobFailedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(FineTuningJobFailedWebhookEvent.Data.builder().id("id").build())
                    .object_(FineTuningJobFailedWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofFineTuningJobSucceeded() {
        val fineTuningJobSucceeded =
            FineTuningJobSucceededWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
                .object_(FineTuningJobSucceededWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofFineTuningJobSucceeded(fineTuningJobSucceeded)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).contains(fineTuningJobSucceeded)
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofFineTuningJobSucceededRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofFineTuningJobSucceeded(
                FineTuningJobSucceededWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(FineTuningJobSucceededWebhookEvent.Data.builder().id("id").build())
                    .object_(FineTuningJobSucceededWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofLiveCallIncoming() {
        val liveCallIncoming =
            LiveCallIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    LiveCallIncomingWebhookEvent.Data.builder()
                        .sessionId("session_id")
                        .addSipHeader(
                            LiveCallIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .build()
                )
                .object_(LiveCallIncomingWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofLiveCallIncoming(liveCallIncoming)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).contains(liveCallIncoming)
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofLiveCallIncomingRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofLiveCallIncoming(
                LiveCallIncomingWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(
                        LiveCallIncomingWebhookEvent.Data.builder()
                            .sessionId("session_id")
                            .addSipHeader(
                                LiveCallIncomingWebhookEvent.Data.SipHeader.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .build()
                    )
                    .object_(LiveCallIncomingWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofRealtimeCallIncoming() {
        val realtimeCallIncoming =
            RealtimeCallIncomingWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    RealtimeCallIncomingWebhookEvent.Data.builder()
                        .callId("call_id")
                        .addSipHeader(
                            RealtimeCallIncomingWebhookEvent.Data.SipHeader.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .build()
                )
                .object_(RealtimeCallIncomingWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofRealtimeCallIncoming(realtimeCallIncoming)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).contains(realtimeCallIncoming)
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofRealtimeCallIncomingRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofRealtimeCallIncoming(
                RealtimeCallIncomingWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(
                        RealtimeCallIncomingWebhookEvent.Data.builder()
                            .callId("call_id")
                            .addSipHeader(
                                RealtimeCallIncomingWebhookEvent.Data.SipHeader.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .build()
                    )
                    .object_(RealtimeCallIncomingWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofResponseCancelled() {
        val responseCancelled =
            ResponseCancelledWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCancelledWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCancelledWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofResponseCancelled(responseCancelled)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).contains(responseCancelled)
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofResponseCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofResponseCancelled(
                ResponseCancelledWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(ResponseCancelledWebhookEvent.Data.builder().id("id").build())
                    .object_(ResponseCancelledWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofResponseCompleted() {
        val responseCompleted =
            ResponseCompletedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseCompletedWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofResponseCompleted(responseCompleted)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).contains(responseCompleted)
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofResponseCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofResponseCompleted(
                ResponseCompletedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(ResponseCompletedWebhookEvent.Data.builder().id("id").build())
                    .object_(ResponseCompletedWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofResponseFailed() {
        val responseFailed =
            ResponseFailedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseFailedWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseFailedWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofResponseFailed(responseFailed)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).contains(responseFailed)
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofResponseFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofResponseFailed(
                ResponseFailedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(ResponseFailedWebhookEvent.Data.builder().id("id").build())
                    .object_(ResponseFailedWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofResponseIncomplete() {
        val responseIncomplete =
            ResponseIncompleteWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
                .object_(ResponseIncompleteWebhookEvent.Object.EVENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofResponseIncomplete(responseIncomplete)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).contains(responseIncomplete)
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofResponseIncompleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofResponseIncomplete(
                ResponseIncompleteWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(ResponseIncompleteWebhookEvent.Data.builder().id("id").build())
                    .object_(ResponseIncompleteWebhookEvent.Object.EVENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofSafetyAlertCreated() {
        val safetyAlertCreated =
            SafetyAlertCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyAlertCreatedWebhookEvent.Data.builder()
                        .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofSafetyAlertCreated(safetyAlertCreated)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).contains(safetyAlertCreated)
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).isEmpty
    }

    @Test
    fun ofSafetyAlertCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofSafetyAlertCreated(
                SafetyAlertCreatedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(
                        SafetyAlertCreatedWebhookEvent.Data.builder()
                            .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofSafetyOrgAlertCreated() {
        val safetyOrgAlertCreated =
            SafetyOrgAlertCreatedWebhookEvent.builder()
                .id("id")
                .createdAt(0L)
                .data(
                    SafetyOrgAlertCreatedWebhookEvent.Data.builder()
                        .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofSafetyOrgAlertCreated(safetyOrgAlertCreated)

        assertThat(unwrapWebhookEvent.batchCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.batchCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.batchExpired()).isEmpty
        assertThat(unwrapWebhookEvent.batchFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunCanceled()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunFailed()).isEmpty
        assertThat(unwrapWebhookEvent.evalRunSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobFailed()).isEmpty
        assertThat(unwrapWebhookEvent.fineTuningJobSucceeded()).isEmpty
        assertThat(unwrapWebhookEvent.liveCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.realtimeCallIncoming()).isEmpty
        assertThat(unwrapWebhookEvent.responseCancelled()).isEmpty
        assertThat(unwrapWebhookEvent.responseCompleted()).isEmpty
        assertThat(unwrapWebhookEvent.responseFailed()).isEmpty
        assertThat(unwrapWebhookEvent.responseIncomplete()).isEmpty
        assertThat(unwrapWebhookEvent.safetyAlertCreated()).isEmpty
        assertThat(unwrapWebhookEvent.safetyOrgAlertCreated()).contains(safetyOrgAlertCreated)
    }

    @Test
    fun ofSafetyOrgAlertCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofSafetyOrgAlertCreated(
                SafetyOrgAlertCreatedWebhookEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .data(
                        SafetyOrgAlertCreatedWebhookEvent.Data.builder()
                            .id("alert_ecc2efdd09bd231a9ad9bd2aada37aa7")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val unwrapWebhookEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<UnwrapWebhookEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { unwrapWebhookEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
