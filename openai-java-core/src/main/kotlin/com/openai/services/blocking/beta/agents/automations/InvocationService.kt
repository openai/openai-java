// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.automations

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.automations.invocations.AutomationInvocation
import com.openai.models.beta.agents.automations.invocations.InvocationCreateParams
import com.openai.models.beta.agents.automations.invocations.InvocationListPage
import com.openai.models.beta.agents.automations.invocations.InvocationListParams
import com.openai.models.beta.agents.automations.invocations.InvocationRetrieveParams
import java.util.function.Consumer

interface InvocationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvocationService

    /** Queues a manual delivery without changing the saved schedule. */
    fun create(automationId: String): AutomationInvocation =
        create(automationId, InvocationCreateParams.none())

    /** @see create */
    fun create(
        automationId: String,
        params: InvocationCreateParams = InvocationCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationInvocation =
        create(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see create */
    fun create(
        automationId: String,
        params: InvocationCreateParams = InvocationCreateParams.none(),
    ): AutomationInvocation = create(automationId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InvocationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationInvocation

    /** @see create */
    fun create(params: InvocationCreateParams): AutomationInvocation =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(automationId: String, requestOptions: RequestOptions): AutomationInvocation =
        create(automationId, InvocationCreateParams.none(), requestOptions)

    /** Retrieves a delivery record for a project-owned automation. */
    fun retrieve(invocationId: String, params: InvocationRetrieveParams): AutomationInvocation =
        retrieve(invocationId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        invocationId: String,
        params: InvocationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationInvocation =
        retrieve(params.toBuilder().invocationId(invocationId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: InvocationRetrieveParams): AutomationInvocation =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InvocationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutomationInvocation

    /** Lists delivery records for a project-owned automation. */
    fun list(automationId: String): InvocationListPage =
        list(automationId, InvocationListParams.none())

    /** @see list */
    fun list(
        automationId: String,
        params: InvocationListParams = InvocationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvocationListPage =
        list(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see list */
    fun list(
        automationId: String,
        params: InvocationListParams = InvocationListParams.none(),
    ): InvocationListPage = list(automationId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InvocationListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvocationListPage

    /** @see list */
    fun list(params: InvocationListParams): InvocationListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(automationId: String, requestOptions: RequestOptions): InvocationListPage =
        list(automationId, InvocationListParams.none(), requestOptions)

    /** A view of [InvocationService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvocationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}/invocations`,
         * but is otherwise the same as [InvocationService.create].
         */
        @MustBeClosed
        fun create(automationId: String): HttpResponseFor<AutomationInvocation> =
            create(automationId, InvocationCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            automationId: String,
            params: InvocationCreateParams = InvocationCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationInvocation> =
            create(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            automationId: String,
            params: InvocationCreateParams = InvocationCreateParams.none(),
        ): HttpResponseFor<AutomationInvocation> =
            create(automationId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InvocationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationInvocation>

        /** @see create */
        @MustBeClosed
        fun create(params: InvocationCreateParams): HttpResponseFor<AutomationInvocation> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutomationInvocation> =
            create(automationId, InvocationCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /agents/automations/{automation_id}/invocations/{invocation_id}`, but is otherwise the
         * same as [InvocationService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            invocationId: String,
            params: InvocationRetrieveParams,
        ): HttpResponseFor<AutomationInvocation> =
            retrieve(invocationId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            invocationId: String,
            params: InvocationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationInvocation> =
            retrieve(params.toBuilder().invocationId(invocationId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: InvocationRetrieveParams): HttpResponseFor<AutomationInvocation> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: InvocationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutomationInvocation>

        /**
         * Returns a raw HTTP response for `get /agents/automations/{automation_id}/invocations`,
         * but is otherwise the same as [InvocationService.list].
         */
        @MustBeClosed
        fun list(automationId: String): HttpResponseFor<InvocationListPage> =
            list(automationId, InvocationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            automationId: String,
            params: InvocationListParams = InvocationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvocationListPage> =
            list(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            automationId: String,
            params: InvocationListParams = InvocationListParams.none(),
        ): HttpResponseFor<InvocationListPage> = list(automationId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InvocationListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvocationListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: InvocationListParams): HttpResponseFor<InvocationListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            automationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvocationListPage> =
            list(automationId, InvocationListParams.none(), requestOptions)
    }
}
