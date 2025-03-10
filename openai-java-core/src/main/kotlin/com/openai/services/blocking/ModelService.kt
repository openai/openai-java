// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.models.Model
import com.openai.models.models.ModelDeleteParams
import com.openai.models.models.ModelDeleted
import com.openai.models.models.ModelListPage
import com.openai.models.models.ModelListParams
import com.openai.models.models.ModelRetrieveParams

interface ModelService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    fun retrieve(params: ModelRetrieveParams): Model = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Model

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    fun list(): ModelListPage = list(ModelListParams.none())

    /** @see [list] */
    fun list(
        params: ModelListParams = ModelListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelListPage

    /** @see [list] */
    fun list(params: ModelListParams = ModelListParams.none()): ModelListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): ModelListPage =
        list(ModelListParams.none(), requestOptions)

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization to delete a
     * model.
     */
    fun delete(params: ModelDeleteParams): ModelDeleted = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelDeleted

    /** A view of [ModelService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /models/{model}`, but is otherwise the same as
         * [ModelService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: ModelRetrieveParams): HttpResponseFor<Model> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Model>

        /**
         * Returns a raw HTTP response for `get /models`, but is otherwise the same as
         * [ModelService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<ModelListPage> = list(ModelListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: ModelListParams = ModelListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: ModelListParams = ModelListParams.none()): HttpResponseFor<ModelListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ModelListPage> =
            list(ModelListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /models/{model}`, but is otherwise the same as
         * [ModelService.delete].
         */
        @MustBeClosed
        fun delete(params: ModelDeleteParams): HttpResponseFor<ModelDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ModelDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelDeleted>
    }
}
