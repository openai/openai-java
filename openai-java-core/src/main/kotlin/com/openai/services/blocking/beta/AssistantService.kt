// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.Assistant
import com.openai.models.AssistantDeleted
import com.openai.models.BetaAssistantCreateParams
import com.openai.models.BetaAssistantDeleteParams
import com.openai.models.BetaAssistantListPage
import com.openai.models.BetaAssistantListParams
import com.openai.models.BetaAssistantRetrieveParams
import com.openai.models.BetaAssistantUpdateParams

interface AssistantService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create an assistant with a model and instructions. */
    fun create(params: BetaAssistantCreateParams): Assistant = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaAssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Retrieves an assistant. */
    fun retrieve(params: BetaAssistantRetrieveParams): Assistant =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaAssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Modifies an assistant. */
    fun update(params: BetaAssistantUpdateParams): Assistant = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaAssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Returns a list of assistants. */
    fun list(): BetaAssistantListPage = list(BetaAssistantListParams.none())

    /** @see [list] */
    fun list(
        params: BetaAssistantListParams = BetaAssistantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaAssistantListPage

    /** @see [list] */
    fun list(
        params: BetaAssistantListParams = BetaAssistantListParams.none()
    ): BetaAssistantListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): BetaAssistantListPage =
        list(BetaAssistantListParams.none(), requestOptions)

    /** Delete an assistant. */
    fun delete(params: BetaAssistantDeleteParams): AssistantDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaAssistantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AssistantDeleted

    /** A view of [AssistantService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /assistants`, but is otherwise the same as
         * [AssistantService.create].
         */
        @MustBeClosed
        fun create(params: BetaAssistantCreateParams): HttpResponseFor<Assistant> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaAssistantCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `get /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaAssistantRetrieveParams): HttpResponseFor<Assistant> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaAssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.update].
         */
        @MustBeClosed
        fun update(params: BetaAssistantUpdateParams): HttpResponseFor<Assistant> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaAssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<BetaAssistantListPage> = list(BetaAssistantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaAssistantListParams = BetaAssistantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaAssistantListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaAssistantListParams = BetaAssistantListParams.none()
        ): HttpResponseFor<BetaAssistantListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<BetaAssistantListPage> =
            list(BetaAssistantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.delete].
         */
        @MustBeClosed
        fun delete(params: BetaAssistantDeleteParams): HttpResponseFor<AssistantDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaAssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AssistantDeleted>
    }
}
