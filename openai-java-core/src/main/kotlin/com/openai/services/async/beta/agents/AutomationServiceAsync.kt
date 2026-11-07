// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.automations.Automation
import com.openai.models.beta.agents.automations.AutomationCreateParams
import com.openai.models.beta.agents.automations.AutomationDeleteParams
import com.openai.models.beta.agents.automations.AutomationDeleted
import com.openai.models.beta.agents.automations.AutomationListPageAsync
import com.openai.models.beta.agents.automations.AutomationListParams
import com.openai.models.beta.agents.automations.AutomationPauseParams
import com.openai.models.beta.agents.automations.AutomationResumeParams
import com.openai.models.beta.agents.automations.AutomationRetrieveParams
import com.openai.models.beta.agents.automations.AutomationScheduleParam
import com.openai.models.beta.agents.automations.AutomationUpdateParams
import com.openai.services.async.beta.agents.automations.InvocationServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AutomationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AutomationServiceAsync

    fun invocations(): InvocationServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Saves an active automation without invoking it immediately. */
    fun create(params: AutomationCreateParams): CompletableFuture<Automation> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AutomationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation>

    /** @see create */
    fun create(
        automationScheduleParam: AutomationScheduleParam,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation> =
        create(
            AutomationCreateParams.builder()
                .automationScheduleParam(automationScheduleParam)
                .build(),
            requestOptions,
        )

    /** @see create */
    fun create(automationScheduleParam: AutomationScheduleParam): CompletableFuture<Automation> =
        create(automationScheduleParam, RequestOptions.none())

    /** Retrieves a project-owned automation. */
    fun retrieve(automationId: String): CompletableFuture<Automation> =
        retrieve(automationId, AutomationRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        automationId: String,
        params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation> =
        retrieve(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        automationId: String,
        params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
    ): CompletableFuture<Automation> = retrieve(automationId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AutomationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation>

    /** @see retrieve */
    fun retrieve(params: AutomationRetrieveParams): CompletableFuture<Automation> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        automationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Automation> =
        retrieve(automationId, AutomationRetrieveParams.none(), requestOptions)

    /** Updates supplied fields; target and metadata replace the whole field. */
    fun update(automationId: String): CompletableFuture<Automation> =
        update(automationId, AutomationUpdateParams.none())

    /** @see update */
    fun update(
        automationId: String,
        params: AutomationUpdateParams = AutomationUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation> =
        update(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see update */
    fun update(
        automationId: String,
        params: AutomationUpdateParams = AutomationUpdateParams.none(),
    ): CompletableFuture<Automation> = update(automationId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AutomationUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation>

    /** @see update */
    fun update(params: AutomationUpdateParams): CompletableFuture<Automation> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        automationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Automation> =
        update(automationId, AutomationUpdateParams.none(), requestOptions)

    /** Lists project-owned automations, optionally filtered by target session. */
    fun list(): CompletableFuture<AutomationListPageAsync> = list(AutomationListParams.none())

    /** @see list */
    fun list(
        params: AutomationListParams = AutomationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationListPageAsync>

    /** @see list */
    fun list(
        params: AutomationListParams = AutomationListParams.none()
    ): CompletableFuture<AutomationListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AutomationListPageAsync> =
        list(AutomationListParams.none(), requestOptions)

    /**
     * Deletes the automation and prevents future invocations without deleting its target session.
     */
    fun delete(automationId: String): CompletableFuture<AutomationDeleted> =
        delete(automationId, AutomationDeleteParams.none())

    /** @see delete */
    fun delete(
        automationId: String,
        params: AutomationDeleteParams = AutomationDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationDeleted> =
        delete(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see delete */
    fun delete(
        automationId: String,
        params: AutomationDeleteParams = AutomationDeleteParams.none(),
    ): CompletableFuture<AutomationDeleted> = delete(automationId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AutomationDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationDeleted>

    /** @see delete */
    fun delete(params: AutomationDeleteParams): CompletableFuture<AutomationDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        automationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AutomationDeleted> =
        delete(automationId, AutomationDeleteParams.none(), requestOptions)

    /** Pauses future scheduled delivery without stopping an active session. */
    fun pause(automationId: String): CompletableFuture<Automation> =
        pause(automationId, AutomationPauseParams.none())

    /** @see pause */
    fun pause(
        automationId: String,
        params: AutomationPauseParams = AutomationPauseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation> =
        pause(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see pause */
    fun pause(
        automationId: String,
        params: AutomationPauseParams = AutomationPauseParams.none(),
    ): CompletableFuture<Automation> = pause(automationId, params, RequestOptions.none())

    /** @see pause */
    fun pause(
        params: AutomationPauseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation>

    /** @see pause */
    fun pause(params: AutomationPauseParams): CompletableFuture<Automation> =
        pause(params, RequestOptions.none())

    /** @see pause */
    fun pause(automationId: String, requestOptions: RequestOptions): CompletableFuture<Automation> =
        pause(automationId, AutomationPauseParams.none(), requestOptions)

    /**
     * Resumes scheduled delivery; one-time automations without a pending invocation require a
     * future run_at.
     */
    fun resume(automationId: String): CompletableFuture<Automation> =
        resume(automationId, AutomationResumeParams.none())

    /** @see resume */
    fun resume(
        automationId: String,
        params: AutomationResumeParams = AutomationResumeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation> =
        resume(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see resume */
    fun resume(
        automationId: String,
        params: AutomationResumeParams = AutomationResumeParams.none(),
    ): CompletableFuture<Automation> = resume(automationId, params, RequestOptions.none())

    /** @see resume */
    fun resume(
        params: AutomationResumeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Automation>

    /** @see resume */
    fun resume(params: AutomationResumeParams): CompletableFuture<Automation> =
        resume(params, RequestOptions.none())

    /** @see resume */
    fun resume(
        automationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Automation> =
        resume(automationId, AutomationResumeParams.none(), requestOptions)

    /**
     * A view of [AutomationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AutomationServiceAsync.WithRawResponse

        fun invocations(): InvocationServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /**
         * Returns a raw HTTP response for `post /agents/automations`, but is otherwise the same as
         * [AutomationServiceAsync.create].
         */
        fun create(params: AutomationCreateParams): CompletableFuture<HttpResponseFor<Automation>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AutomationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>>

        /** @see create */
        fun create(
            automationScheduleParam: AutomationScheduleParam,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            create(
                AutomationCreateParams.builder()
                    .automationScheduleParam(automationScheduleParam)
                    .build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            automationScheduleParam: AutomationScheduleParam
        ): CompletableFuture<HttpResponseFor<Automation>> =
            create(automationScheduleParam, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /agents/automations/{automation_id}`, but is
         * otherwise the same as [AutomationServiceAsync.retrieve].
         */
        fun retrieve(automationId: String): CompletableFuture<HttpResponseFor<Automation>> =
            retrieve(automationId, AutomationRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            automationId: String,
            params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            retrieve(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            automationId: String,
            params: AutomationRetrieveParams = AutomationRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            retrieve(automationId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AutomationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>>

        /** @see retrieve */
        fun retrieve(
            params: AutomationRetrieveParams
        ): CompletableFuture<HttpResponseFor<Automation>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Automation>> =
            retrieve(automationId, AutomationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}`, but is
         * otherwise the same as [AutomationServiceAsync.update].
         */
        fun update(automationId: String): CompletableFuture<HttpResponseFor<Automation>> =
            update(automationId, AutomationUpdateParams.none())

        /** @see update */
        fun update(
            automationId: String,
            params: AutomationUpdateParams = AutomationUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            update(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see update */
        fun update(
            automationId: String,
            params: AutomationUpdateParams = AutomationUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            update(automationId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: AutomationUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>>

        /** @see update */
        fun update(params: AutomationUpdateParams): CompletableFuture<HttpResponseFor<Automation>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Automation>> =
            update(automationId, AutomationUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/automations`, but is otherwise the same as
         * [AutomationServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AutomationListPageAsync>> =
            list(AutomationListParams.none())

        /** @see list */
        fun list(
            params: AutomationListParams = AutomationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationListPageAsync>>

        /** @see list */
        fun list(
            params: AutomationListParams = AutomationListParams.none()
        ): CompletableFuture<HttpResponseFor<AutomationListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AutomationListPageAsync>> =
            list(AutomationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /agents/automations/{automation_id}`, but is
         * otherwise the same as [AutomationServiceAsync.delete].
         */
        fun delete(automationId: String): CompletableFuture<HttpResponseFor<AutomationDeleted>> =
            delete(automationId, AutomationDeleteParams.none())

        /** @see delete */
        fun delete(
            automationId: String,
            params: AutomationDeleteParams = AutomationDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationDeleted>> =
            delete(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see delete */
        fun delete(
            automationId: String,
            params: AutomationDeleteParams = AutomationDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AutomationDeleted>> =
            delete(automationId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AutomationDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationDeleted>>

        /** @see delete */
        fun delete(
            params: AutomationDeleteParams
        ): CompletableFuture<HttpResponseFor<AutomationDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AutomationDeleted>> =
            delete(automationId, AutomationDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}/pause`, but is
         * otherwise the same as [AutomationServiceAsync.pause].
         */
        fun pause(automationId: String): CompletableFuture<HttpResponseFor<Automation>> =
            pause(automationId, AutomationPauseParams.none())

        /** @see pause */
        fun pause(
            automationId: String,
            params: AutomationPauseParams = AutomationPauseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            pause(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see pause */
        fun pause(
            automationId: String,
            params: AutomationPauseParams = AutomationPauseParams.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            pause(automationId, params, RequestOptions.none())

        /** @see pause */
        fun pause(
            params: AutomationPauseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>>

        /** @see pause */
        fun pause(params: AutomationPauseParams): CompletableFuture<HttpResponseFor<Automation>> =
            pause(params, RequestOptions.none())

        /** @see pause */
        fun pause(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Automation>> =
            pause(automationId, AutomationPauseParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}/resume`, but is
         * otherwise the same as [AutomationServiceAsync.resume].
         */
        fun resume(automationId: String): CompletableFuture<HttpResponseFor<Automation>> =
            resume(automationId, AutomationResumeParams.none())

        /** @see resume */
        fun resume(
            automationId: String,
            params: AutomationResumeParams = AutomationResumeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            resume(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see resume */
        fun resume(
            automationId: String,
            params: AutomationResumeParams = AutomationResumeParams.none(),
        ): CompletableFuture<HttpResponseFor<Automation>> =
            resume(automationId, params, RequestOptions.none())

        /** @see resume */
        fun resume(
            params: AutomationResumeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Automation>>

        /** @see resume */
        fun resume(params: AutomationResumeParams): CompletableFuture<HttpResponseFor<Automation>> =
            resume(params, RequestOptions.none())

        /** @see resume */
        fun resume(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Automation>> =
            resume(automationId, AutomationResumeParams.none(), requestOptions)
    }
}
