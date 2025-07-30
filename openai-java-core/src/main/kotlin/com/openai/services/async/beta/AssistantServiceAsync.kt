// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.assistants.Assistant
import com.openai.models.beta.assistants.AssistantCreateParams
import com.openai.models.beta.assistants.AssistantDeleteParams
import com.openai.models.beta.assistants.AssistantDeleted
import com.openai.models.beta.assistants.AssistantListPageAsync
import com.openai.models.beta.assistants.AssistantListParams
import com.openai.models.beta.assistants.AssistantRetrieveParams
import com.openai.models.beta.assistants.AssistantUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AssistantServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AssistantServiceAsync

    /** Create an assistant with a model and instructions. */
    fun create(params: AssistantCreateParams): CompletableFuture<Assistant> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Retrieves an assistant. */
    fun retrieve(assistantId: String): CompletableFuture<Assistant> =
        retrieve(assistantId, AssistantRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        assistantId: String,
        params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant> =
        retrieve(params.toBuilder().assistantId(assistantId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        assistantId: String,
        params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
    ): CompletableFuture<Assistant> = retrieve(assistantId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** @see retrieve */
    fun retrieve(params: AssistantRetrieveParams): CompletableFuture<Assistant> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        assistantId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Assistant> =
        retrieve(assistantId, AssistantRetrieveParams.none(), requestOptions)

    /** Modifies an assistant. */
    fun update(assistantId: String): CompletableFuture<Assistant> =
        update(assistantId, AssistantUpdateParams.none())

    /** @see update */
    fun update(
        assistantId: String,
        params: AssistantUpdateParams = AssistantUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant> =
        update(params.toBuilder().assistantId(assistantId).build(), requestOptions)

    /** @see update */
    fun update(
        assistantId: String,
        params: AssistantUpdateParams = AssistantUpdateParams.none(),
    ): CompletableFuture<Assistant> = update(assistantId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** @see update */
    fun update(params: AssistantUpdateParams): CompletableFuture<Assistant> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(assistantId: String, requestOptions: RequestOptions): CompletableFuture<Assistant> =
        update(assistantId, AssistantUpdateParams.none(), requestOptions)

    /** Returns a list of assistants. */
    fun list(): CompletableFuture<AssistantListPageAsync> = list(AssistantListParams.none())

    /** @see list */
    fun list(
        params: AssistantListParams = AssistantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AssistantListPageAsync>

    /** @see list */
    fun list(
        params: AssistantListParams = AssistantListParams.none()
    ): CompletableFuture<AssistantListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AssistantListPageAsync> =
        list(AssistantListParams.none(), requestOptions)

    /** Delete an assistant. */
    fun delete(assistantId: String): CompletableFuture<AssistantDeleted> =
        delete(assistantId, AssistantDeleteParams.none())

    /** @see delete */
    fun delete(
        assistantId: String,
        params: AssistantDeleteParams = AssistantDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AssistantDeleted> =
        delete(params.toBuilder().assistantId(assistantId).build(), requestOptions)

    /** @see delete */
    fun delete(
        assistantId: String,
        params: AssistantDeleteParams = AssistantDeleteParams.none(),
    ): CompletableFuture<AssistantDeleted> = delete(assistantId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AssistantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AssistantDeleted>

    /** @see delete */
    fun delete(params: AssistantDeleteParams): CompletableFuture<AssistantDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        assistantId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AssistantDeleted> =
        delete(assistantId, AssistantDeleteParams.none(), requestOptions)

    /**
     * A view of [AssistantServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AssistantServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /assistants`, but is otherwise the same as
         * [AssistantServiceAsync.create].
         */
        fun create(params: AssistantCreateParams): CompletableFuture<HttpResponseFor<Assistant>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AssistantCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `get /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.retrieve].
         */
        fun retrieve(assistantId: String): CompletableFuture<HttpResponseFor<Assistant>> =
            retrieve(assistantId, AssistantRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            assistantId: String,
            params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>> =
            retrieve(params.toBuilder().assistantId(assistantId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            assistantId: String,
            params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>> =
            retrieve(assistantId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /** @see retrieve */
        fun retrieve(
            params: AssistantRetrieveParams
        ): CompletableFuture<HttpResponseFor<Assistant>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            assistantId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Assistant>> =
            retrieve(assistantId, AssistantRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.update].
         */
        fun update(assistantId: String): CompletableFuture<HttpResponseFor<Assistant>> =
            update(assistantId, AssistantUpdateParams.none())

        /** @see update */
        fun update(
            assistantId: String,
            params: AssistantUpdateParams = AssistantUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>> =
            update(params.toBuilder().assistantId(assistantId).build(), requestOptions)

        /** @see update */
        fun update(
            assistantId: String,
            params: AssistantUpdateParams = AssistantUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>> =
            update(assistantId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: AssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /** @see update */
        fun update(params: AssistantUpdateParams): CompletableFuture<HttpResponseFor<Assistant>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            assistantId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Assistant>> =
            update(assistantId, AssistantUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AssistantListPageAsync>> =
            list(AssistantListParams.none())

        /** @see list */
        fun list(
            params: AssistantListParams = AssistantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AssistantListPageAsync>>

        /** @see list */
        fun list(
            params: AssistantListParams = AssistantListParams.none()
        ): CompletableFuture<HttpResponseFor<AssistantListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AssistantListPageAsync>> =
            list(AssistantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.delete].
         */
        fun delete(assistantId: String): CompletableFuture<HttpResponseFor<AssistantDeleted>> =
            delete(assistantId, AssistantDeleteParams.none())

        /** @see delete */
        fun delete(
            assistantId: String,
            params: AssistantDeleteParams = AssistantDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>> =
            delete(params.toBuilder().assistantId(assistantId).build(), requestOptions)

        /** @see delete */
        fun delete(
            assistantId: String,
            params: AssistantDeleteParams = AssistantDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>> =
            delete(assistantId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>>

        /** @see delete */
        fun delete(
            params: AssistantDeleteParams
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            assistantId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>> =
            delete(assistantId, AssistantDeleteParams.none(), requestOptions)
    }
}
