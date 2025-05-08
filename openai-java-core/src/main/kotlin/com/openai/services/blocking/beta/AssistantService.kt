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
    fun retrieve(assistantId: String): Assistant =
        retrieve(assistantId, AssistantRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        assistantId: String,
        params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant = retrieve(params.toBuilder().assistantId(assistantId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        assistantId: String,
        params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
    ): Assistant = retrieve(assistantId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: AssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** @see [retrieve] */
    fun retrieve(params: AssistantRetrieveParams): Assistant =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(assistantId: String, requestOptions: RequestOptions): Assistant =
        retrieve(assistantId, AssistantRetrieveParams.none(), requestOptions)

    /** Modifies an assistant. */
    fun update(assistantId: String): Assistant = update(assistantId, AssistantUpdateParams.none())

    /** @see [update] */
    fun update(
        assistantId: String,
        params: AssistantUpdateParams = AssistantUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant = update(params.toBuilder().assistantId(assistantId).build(), requestOptions)

    /** @see [update] */
    fun update(
        assistantId: String,
        params: AssistantUpdateParams = AssistantUpdateParams.none(),
    ): Assistant = update(assistantId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: AssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Assistant

    /** @see [update] */
    fun update(params: AssistantUpdateParams): Assistant = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(assistantId: String, requestOptions: RequestOptions): Assistant =
        update(assistantId, AssistantUpdateParams.none(), requestOptions)

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
    fun delete(assistantId: String): AssistantDeleted =
        delete(assistantId, AssistantDeleteParams.none())

    /** @see [delete] */
    fun delete(
        assistantId: String,
        params: AssistantDeleteParams = AssistantDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AssistantDeleted =
        delete(params.toBuilder().assistantId(assistantId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        assistantId: String,
        params: AssistantDeleteParams = AssistantDeleteParams.none(),
    ): AssistantDeleted = delete(assistantId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: AssistantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AssistantDeleted

    /** @see [delete] */
    fun delete(params: AssistantDeleteParams): AssistantDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(assistantId: String, requestOptions: RequestOptions): AssistantDeleted =
        delete(assistantId, AssistantDeleteParams.none(), requestOptions)

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
        fun retrieve(assistantId: String): HttpResponseFor<Assistant> =
            retrieve(assistantId, AssistantRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            assistantId: String,
            params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant> =
            retrieve(params.toBuilder().assistantId(assistantId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            assistantId: String,
            params: AssistantRetrieveParams = AssistantRetrieveParams.none(),
        ): HttpResponseFor<Assistant> = retrieve(assistantId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: AssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: AssistantRetrieveParams): HttpResponseFor<Assistant> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            assistantId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Assistant> =
            retrieve(assistantId, AssistantRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantService.update].
         */
        @MustBeClosed
        fun update(assistantId: String): HttpResponseFor<Assistant> =
            update(assistantId, AssistantUpdateParams.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            assistantId: String,
            params: AssistantUpdateParams = AssistantUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant> =
            update(params.toBuilder().assistantId(assistantId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(
            assistantId: String,
            params: AssistantUpdateParams = AssistantUpdateParams.none(),
        ): HttpResponseFor<Assistant> = update(assistantId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: AssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Assistant>

        /** @see [update] */
        @MustBeClosed
        fun update(params: AssistantUpdateParams): HttpResponseFor<Assistant> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            assistantId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Assistant> =
            update(assistantId, AssistantUpdateParams.none(), requestOptions)

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
        fun delete(assistantId: String): HttpResponseFor<AssistantDeleted> =
            delete(assistantId, AssistantDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            assistantId: String,
            params: AssistantDeleteParams = AssistantDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AssistantDeleted> =
            delete(params.toBuilder().assistantId(assistantId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            assistantId: String,
            params: AssistantDeleteParams = AssistantDeleteParams.none(),
        ): HttpResponseFor<AssistantDeleted> = delete(assistantId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: AssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AssistantDeleted>

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: AssistantDeleteParams): HttpResponseFor<AssistantDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            assistantId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AssistantDeleted> =
            delete(assistantId, AssistantDeleteParams.none(), requestOptions)
    }
}
