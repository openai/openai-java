// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: BetaAssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Retrieves an assistant. */
    @JvmOverloads
    fun retrieve(
        params: BetaAssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Modifies an assistant. */
    @JvmOverloads
    fun update(
        params: BetaAssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Returns a list of assistants. */
    @JvmOverloads
    fun list(
        params: BetaAssistantListParams = BetaAssistantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaAssistantListPage

    /** Returns a list of assistants. */
    fun list(requestOptions: RequestOptions): BetaAssistantListPage =
        list(BetaAssistantListParams.none(), requestOptions)

    /** Delete an assistant. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: BetaAssistantCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `get /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaAssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: BetaAssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: BetaAssistantListParams = BetaAssistantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaAssistantListPage>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantService.list].
         */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<BetaAssistantListPage> =
            list(BetaAssistantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: BetaAssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AssistantDeleted>
    }
}
