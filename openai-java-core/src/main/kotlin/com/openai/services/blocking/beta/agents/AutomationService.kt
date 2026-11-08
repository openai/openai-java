// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.automations.Automation
import com.openai.models.beta.agents.automations.AutomationCreateParams
import com.openai.models.beta.agents.automations.AutomationDeleteParams
import com.openai.models.beta.agents.automations.AutomationDeleted
import com.openai.models.beta.agents.automations.AutomationListPage
import com.openai.models.beta.agents.automations.AutomationListParams
import com.openai.models.beta.agents.automations.AutomationPauseParams
import com.openai.models.beta.agents.automations.AutomationResumeParams
import com.openai.models.beta.agents.automations.AutomationRetrieveParams
import com.openai.models.beta.agents.automations.AutomationScheduleParam
import com.openai.models.beta.agents.automations.AutomationUpdateParams
import com.openai.services.blocking.beta.agents.automations.InvocationService
import java.util.function.Consumer

interface AutomationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AutomationService

    fun invocations(): InvocationService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Saves an active automation without invoking it immediately. */
    fun create(params: AutomationCreateParams): Automation = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AutomationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation

    /** @see create */
    fun create(
        automationScheduleParam: AutomationScheduleParam,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation =
        create(
            AutomationCreateParams.builder()
                .automationScheduleParam(automationScheduleParam)
                .build(),
            requestOptions,
        )

    /** @see create */
    fun create(automationScheduleParam: AutomationScheduleParam): Automation =
        create(automationScheduleParam, RequestOptions.none())

    /** Retrieves a project-owned automation. */
    fun retrieve(automationId: String): Automation =
        retrieve(automationId, AutomationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        automationId: String,
        params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation = retrieve(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        automationId: String,
        params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
    ): Automation = retrieve(automationId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AutomationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation

    /** @see retrieve */
    fun retrieve(params: AutomationRetrieveParams): Automation =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(automationId: String, requestOptions: RequestOptions): Automation =
        retrieve(automationId, AutomationRetrieveParams.none(), requestOptions)

    /** Updates supplied fields; target and metadata replace the whole field. */
    fun update(automationId: String): Automation =
        update(automationId, AutomationUpdateParams.none())

    /** @see update */
    fun update(
        automationId: String,
        params: AutomationUpdateParams = AutomationUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation = update(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see update */
    fun update(
        automationId: String,
        params: AutomationUpdateParams = AutomationUpdateParams.none(),
    ): Automation = update(automationId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AutomationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation

    /** @see update */
    fun update(params: AutomationUpdateParams): Automation = update(params, RequestOptions.none())

    /** @see update */
    fun update(automationId: String, requestOptions: RequestOptions): Automation =
        update(automationId, AutomationUpdateParams.none(), requestOptions)

    /** Lists project-owned automations, optionally filtered by target session. */
    fun list(): AutomationListPage = list(AutomationListParams.none())

    /** @see list */
    fun list(
        params: AutomationListParams = AutomationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationListPage

    /** @see list */
    fun list(params: AutomationListParams = AutomationListParams.none()): AutomationListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): AutomationListPage =
        list(AutomationListParams.none(), requestOptions)

    /**
     * Deletes the automation and prevents future invocations without deleting its target session.
     */
    fun delete(automationId: String): AutomationDeleted =
        delete(automationId, AutomationDeleteParams.none())

    /** @see delete */
    fun delete(
        automationId: String,
        params: AutomationDeleteParams = AutomationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationDeleted =
        delete(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see delete */
    fun delete(
        automationId: String,
        params: AutomationDeleteParams = AutomationDeleteParams.none(),
    ): AutomationDeleted = delete(automationId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AutomationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationDeleted

    /** @see delete */
    fun delete(params: AutomationDeleteParams): AutomationDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(automationId: String, requestOptions: RequestOptions): AutomationDeleted =
        delete(automationId, AutomationDeleteParams.none(), requestOptions)

    /** Pauses future scheduled delivery without stopping an active session. */
    fun pause(automationId: String): Automation = pause(automationId, AutomationPauseParams.none())

    /** @see pause */
    fun pause(
        automationId: String,
        params: AutomationPauseParams = AutomationPauseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation = pause(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see pause */
    fun pause(
        automationId: String,
        params: AutomationPauseParams = AutomationPauseParams.none(),
    ): Automation = pause(automationId, params, RequestOptions.none())

    /** @see pause */
    fun pause(
        params: AutomationPauseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation

    /** @see pause */
    fun pause(params: AutomationPauseParams): Automation = pause(params, RequestOptions.none())

    /** @see pause */
    fun pause(automationId: String, requestOptions: RequestOptions): Automation =
        pause(automationId, AutomationPauseParams.none(), requestOptions)

    /**
     * Resumes scheduled delivery; one-time automations without a pending invocation require a
     * future run_at.
     */
    fun resume(automationId: String): Automation =
        resume(automationId, AutomationResumeParams.none())

    /** @see resume */
    fun resume(
        automationId: String,
        params: AutomationResumeParams = AutomationResumeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation = resume(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see resume */
    fun resume(
        automationId: String,
        params: AutomationResumeParams = AutomationResumeParams.none(),
    ): Automation = resume(automationId, params, RequestOptions.none())

    /** @see resume */
    fun resume(
        params: AutomationResumeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Automation

    /** @see resume */
    fun resume(params: AutomationResumeParams): Automation = resume(params, RequestOptions.none())

    /** @see resume */
    fun resume(automationId: String, requestOptions: RequestOptions): Automation =
        resume(automationId, AutomationResumeParams.none(), requestOptions)

    /** A view of [AutomationService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AutomationService.WithRawResponse

        fun invocations(): InvocationService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /**
         * Returns a raw HTTP response for `post /agents/automations`, but is otherwise the same as
         * [AutomationService.create].
         */
        @MustBeClosed
        fun create(params: AutomationCreateParams): HttpResponseFor<Automation> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AutomationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation>

        /** @see create */
        @MustBeClosed
        fun create(
            automationScheduleParam: AutomationScheduleParam,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation> =
            create(
                AutomationCreateParams.builder()
                    .automationScheduleParam(automationScheduleParam)
                    .build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(automationScheduleParam: AutomationScheduleParam): HttpResponseFor<Automation> =
            create(automationScheduleParam, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /agents/automations/{automation_id}`, but is
         * otherwise the same as [AutomationService.retrieve].
         */
        @MustBeClosed
        fun retrieve(automationId: String): HttpResponseFor<Automation> =
            retrieve(automationId, AutomationRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            automationId: String,
            params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation> =
            retrieve(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            automationId: String,
            params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
        ): HttpResponseFor<Automation> = retrieve(automationId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AutomationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AutomationRetrieveParams): HttpResponseFor<Automation> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> =
            retrieve(automationId, AutomationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}`, but is
         * otherwise the same as [AutomationService.update].
         */
        @MustBeClosed
        fun update(automationId: String): HttpResponseFor<Automation> =
            update(automationId, AutomationUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            automationId: String,
            params: AutomationUpdateParams = AutomationUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation> =
            update(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            automationId: String,
            params: AutomationUpdateParams = AutomationUpdateParams.none(),
        ): HttpResponseFor<Automation> = update(automationId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: AutomationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation>

        /** @see update */
        @MustBeClosed
        fun update(params: AutomationUpdateParams): HttpResponseFor<Automation> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> =
            update(automationId, AutomationUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/automations`, but is otherwise the same as
         * [AutomationService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<AutomationListPage> = list(AutomationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AutomationListParams = AutomationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: AutomationListParams = AutomationListParams.none()
        ): HttpResponseFor<AutomationListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AutomationListPage> =
            list(AutomationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /agents/automations/{automation_id}`, but is
         * otherwise the same as [AutomationService.delete].
         */
        @MustBeClosed
        fun delete(automationId: String): HttpResponseFor<AutomationDeleted> =
            delete(automationId, AutomationDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            automationId: String,
            params: AutomationDeleteParams = AutomationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationDeleted> =
            delete(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            automationId: String,
            params: AutomationDeleteParams = AutomationDeleteParams.none(),
        ): HttpResponseFor<AutomationDeleted> = delete(automationId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AutomationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: AutomationDeleteParams): HttpResponseFor<AutomationDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutomationDeleted> =
            delete(automationId, AutomationDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}/pause`, but is
         * otherwise the same as [AutomationService.pause].
         */
        @MustBeClosed
        fun pause(automationId: String): HttpResponseFor<Automation> =
            pause(automationId, AutomationPauseParams.none())

        /** @see pause */
        @MustBeClosed
        fun pause(
            automationId: String,
            params: AutomationPauseParams = AutomationPauseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation> =
            pause(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see pause */
        @MustBeClosed
        fun pause(
            automationId: String,
            params: AutomationPauseParams = AutomationPauseParams.none(),
        ): HttpResponseFor<Automation> = pause(automationId, params, RequestOptions.none())

        /** @see pause */
        @MustBeClosed
        fun pause(
            params: AutomationPauseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation>

        /** @see pause */
        @MustBeClosed
        fun pause(params: AutomationPauseParams): HttpResponseFor<Automation> =
            pause(params, RequestOptions.none())

        /** @see pause */
        @MustBeClosed
        fun pause(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> =
            pause(automationId, AutomationPauseParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}/resume`, but is
         * otherwise the same as [AutomationService.resume].
         */
        @MustBeClosed
        fun resume(automationId: String): HttpResponseFor<Automation> =
            resume(automationId, AutomationResumeParams.none())

        /** @see resume */
        @MustBeClosed
        fun resume(
            automationId: String,
            params: AutomationResumeParams = AutomationResumeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation> =
            resume(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see resume */
        @MustBeClosed
        fun resume(
            automationId: String,
            params: AutomationResumeParams = AutomationResumeParams.none(),
        ): HttpResponseFor<Automation> = resume(automationId, params, RequestOptions.none())

        /** @see resume */
        @MustBeClosed
        fun resume(
            params: AutomationResumeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Automation>

        /** @see resume */
        @MustBeClosed
        fun resume(params: AutomationResumeParams): HttpResponseFor<Automation> =
            resume(params, RequestOptions.none())

        /** @see resume */
        @MustBeClosed
        fun resume(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> =
            resume(automationId, AutomationResumeParams.none(), requestOptions)
    }
}
