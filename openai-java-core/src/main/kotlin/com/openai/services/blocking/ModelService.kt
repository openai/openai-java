// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.Model
import com.openai.models.ModelDeleteParams
import com.openai.models.ModelDeleted
import com.openai.models.ModelListPage
import com.openai.models.ModelListParams
import com.openai.models.ModelRetrieveParams

interface ModelService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    @JvmOverloads
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Model

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    @JvmOverloads
    fun list(
        params: ModelListParams = ModelListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelListPage

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    fun list(requestOptions: RequestOptions): ModelListPage =
        list(ModelListParams.none(), requestOptions)

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization to delete a
     * model.
     */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Model>

        /**
         * Returns a raw HTTP response for `get /models`, but is otherwise the same as
         * [ModelService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: ModelListParams = ModelListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelListPage>

        /**
         * Returns a raw HTTP response for `get /models`, but is otherwise the same as
         * [ModelService.list].
         */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ModelListPage> =
            list(ModelListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /models/{model}`, but is otherwise the same as
         * [ModelService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: ModelDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelDeleted>
    }
}
