// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.automations

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.automations.invocations.AutomationInvocation
import com.openai.models.beta.agents.automations.invocations.InvocationCreateParams
import com.openai.models.beta.agents.automations.invocations.InvocationListPageAsync
import com.openai.models.beta.agents.automations.invocations.InvocationListParams
import com.openai.models.beta.agents.automations.invocations.InvocationRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InvocationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvocationServiceAsync

    /** Queues a manual delivery without changing the saved schedule. */
    fun create(automationId: String): CompletableFuture<AutomationInvocation> =
        create(automationId, InvocationCreateParams.none())

    /** @see create */
    fun create(
        automationId: String,
        params: InvocationCreateParams = InvocationCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationInvocation> =
        create(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see create */
    fun create(
        automationId: String,
        params: InvocationCreateParams = InvocationCreateParams.none(),
    ): CompletableFuture<AutomationInvocation> = create(automationId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InvocationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationInvocation>

    /** @see create */
    fun create(params: InvocationCreateParams): CompletableFuture<AutomationInvocation> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        automationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AutomationInvocation> =
        create(automationId, InvocationCreateParams.none(), requestOptions)

    /** Retrieves a delivery record for a project-owned automation. */
    fun retrieve(
        invocationId: String,
        params: InvocationRetrieveParams,
    ): CompletableFuture<AutomationInvocation> =
        retrieve(invocationId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        invocationId: String,
        params: InvocationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationInvocation> =
        retrieve(params.toBuilder().invocationId(invocationId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: InvocationRetrieveParams): CompletableFuture<AutomationInvocation> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InvocationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutomationInvocation>

    /** Lists delivery records for a project-owned automation. */
    fun list(automationId: String): CompletableFuture<InvocationListPageAsync> =
        list(automationId, InvocationListParams.none())

    /** @see list */
    fun list(
        automationId: String,
        params: InvocationListParams = InvocationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvocationListPageAsync> =
        list(params.toBuilder().automationId(automationId).build(), requestOptions)

    /** @see list */
    fun list(
        automationId: String,
        params: InvocationListParams = InvocationListParams.none(),
    ): CompletableFuture<InvocationListPageAsync> =
        list(automationId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InvocationListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvocationListPageAsync>

    /** @see list */
    fun list(params: InvocationListParams): CompletableFuture<InvocationListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        automationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvocationListPageAsync> =
        list(automationId, InvocationListParams.none(), requestOptions)

    /**
     * A view of [InvocationServiceAsync] that provides access to raw HTTP responses for each
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
        ): InvocationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/automations/{automation_id}/invocations`,
         * but is otherwise the same as [InvocationServiceAsync.create].
         */
        fun create(automationId: String): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            create(automationId, InvocationCreateParams.none())

        /** @see create */
        fun create(
            automationId: String,
            params: InvocationCreateParams = InvocationCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            create(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see create */
        fun create(
            automationId: String,
            params: InvocationCreateParams = InvocationCreateParams.none(),
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            create(automationId, params, RequestOptions.none())

        /** @see create */
        fun create(
            params: InvocationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>>

        /** @see create */
        fun create(
            params: InvocationCreateParams
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            create(automationId, InvocationCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /agents/automations/{automation_id}/invocations/{invocation_id}`, but is otherwise the
         * same as [InvocationServiceAsync.retrieve].
         */
        fun retrieve(
            invocationId: String,
            params: InvocationRetrieveParams,
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            retrieve(invocationId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            invocationId: String,
            params: InvocationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            retrieve(params.toBuilder().invocationId(invocationId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: InvocationRetrieveParams
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: InvocationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutomationInvocation>>

        /**
         * Returns a raw HTTP response for `get /agents/automations/{automation_id}/invocations`,
         * but is otherwise the same as [InvocationServiceAsync.list].
         */
        fun list(
            automationId: String
        ): CompletableFuture<HttpResponseFor<InvocationListPageAsync>> =
            list(automationId, InvocationListParams.none())

        /** @see list */
        fun list(
            automationId: String,
            params: InvocationListParams = InvocationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvocationListPageAsync>> =
            list(params.toBuilder().automationId(automationId).build(), requestOptions)

        /** @see list */
        fun list(
            automationId: String,
            params: InvocationListParams = InvocationListParams.none(),
        ): CompletableFuture<HttpResponseFor<InvocationListPageAsync>> =
            list(automationId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: InvocationListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvocationListPageAsync>>

        /** @see list */
        fun list(
            params: InvocationListParams
        ): CompletableFuture<HttpResponseFor<InvocationListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            automationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvocationListPageAsync>> =
            list(automationId, InvocationListParams.none(), requestOptions)
    }
}
