// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.assistants.Assistant
import com.openai.models.beta.assistants.AssistantCreateParams
import com.openai.models.beta.assistants.AssistantDeleteParams
import com.openai.models.beta.assistants.AssistantDeleted
import com.openai.models.beta.assistants.AssistantListPage
import com.openai.models.beta.assistants.AssistantListParams
import com.openai.models.beta.assistants.AssistantRetrieveParams
import com.openai.models.beta.assistants.AssistantUpdateParams

interface AssistantService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create an assistant with a model and instructions. */
    fun create(params: AssistantCreateParams): Assistant = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Retrieves an assistant. */
    fun retrieve(params: AssistantRetrieveParams): Assistant =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: AssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Modifies an assistant. */
    fun update(params: AssistantUpdateParams): Assistant = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: AssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** Returns a list of assistants. */
    fun list(): AssistantListPage = list(AssistantListParams.none())

    /** @see [list] */
    fun list(
        params: AssistantListParams = AssistantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AssistantListPage

    /** @see [list] */
    fun list(params: AssistantListParams = AssistantListParams.none()): AssistantListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): AssistantListPage =
        list(AssistantListParams.none(), requestOptions)

    /** Delete an assistant. */
    fun delete(params: AssistantDeleteParams): AssistantDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: AssistantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AssistantDeleted

    /** A view of [AssistantService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /assistants`, but is otherwise the same as
         * [AssistantService.create].
         */
        @MustBeClosed
        fun create(params: AssistantCreateParams): HttpResponseFor<Assistant> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AssistantCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `get /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: AssistantRetrieveParams): HttpResponseFor<Assistant> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: AssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.update].
         */
        @MustBeClosed
        fun update(params: AssistantUpdateParams): HttpResponseFor<Assistant> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: AssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<AssistantListPage> = list(AssistantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: AssistantListParams = AssistantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AssistantListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: AssistantListParams = AssistantListParams.none()
        ): HttpResponseFor<AssistantListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AssistantListPage> =
            list(AssistantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.delete].
         */
        @MustBeClosed
        fun delete(params: AssistantDeleteParams): HttpResponseFor<AssistantDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: AssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AssistantDeleted>
    }
}
