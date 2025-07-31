// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.models.Model
import com.openai.models.models.ModelDeleteParams
import com.openai.models.models.ModelDeleted
import com.openai.models.models.ModelListPage
import com.openai.models.models.ModelListParams
import com.openai.models.models.ModelRetrieveParams
import java.util.function.Consumer

interface ModelService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModelService

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    fun retrieve(model: String): Model = retrieve(model, ModelRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        model: String,
        params: ModelRetrieveParams = ModelRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Model = retrieve(params.toBuilder().model(model).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(model: String, params: ModelRetrieveParams = ModelRetrieveParams.none()): Model =
        retrieve(model, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Model

    /** @see retrieve */
    fun retrieve(params: ModelRetrieveParams): Model = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(model: String, requestOptions: RequestOptions): Model =
        retrieve(model, ModelRetrieveParams.none(), requestOptions)

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    fun list(): ModelListPage = list(ModelListParams.none())

    /** @see list */
    fun list(
        params: ModelListParams = ModelListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelListPage

    /** @see list */
    fun list(params: ModelListParams = ModelListParams.none()): ModelListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ModelListPage =
        list(ModelListParams.none(), requestOptions)

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization to delete a
     * model.
     */
    fun delete(model: String): ModelDeleted = delete(model, ModelDeleteParams.none())

    /** @see delete */
    fun delete(
        model: String,
        params: ModelDeleteParams = ModelDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelDeleted = delete(params.toBuilder().model(model).build(), requestOptions)

    /** @see delete */
    fun delete(model: String, params: ModelDeleteParams = ModelDeleteParams.none()): ModelDeleted =
        delete(model, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelDeleted

    /** @see delete */
    fun delete(params: ModelDeleteParams): ModelDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(model: String, requestOptions: RequestOptions): ModelDeleted =
        delete(model, ModelDeleteParams.none(), requestOptions)

    /** A view of [ModelService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModelService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /models/{model}`, but is otherwise the same as
         * [ModelService.retrieve].
         */
        @MustBeClosed
        fun retrieve(model: String): HttpResponseFor<Model> =
            retrieve(model, ModelRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            model: String,
            params: ModelRetrieveParams = ModelRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Model> =
            retrieve(params.toBuilder().model(model).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            model: String,
            params: ModelRetrieveParams = ModelRetrieveParams.none(),
        ): HttpResponseFor<Model> = retrieve(model, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Model>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ModelRetrieveParams): HttpResponseFor<Model> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(model: String, requestOptions: RequestOptions): HttpResponseFor<Model> =
            retrieve(model, ModelRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /models`, but is otherwise the same as
         * [ModelService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<ModelListPage> = list(ModelListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ModelListParams = ModelListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ModelListParams = ModelListParams.none()): HttpResponseFor<ModelListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ModelListPage> =
            list(ModelListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /models/{model}`, but is otherwise the same as
         * [ModelService.delete].
         */
        @MustBeClosed
        fun delete(model: String): HttpResponseFor<ModelDeleted> =
            delete(model, ModelDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            model: String,
            params: ModelDeleteParams = ModelDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelDeleted> =
            delete(params.toBuilder().model(model).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            model: String,
            params: ModelDeleteParams = ModelDeleteParams.none(),
        ): HttpResponseFor<ModelDeleted> = delete(model, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ModelDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ModelDeleteParams): HttpResponseFor<ModelDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(model: String, requestOptions: RequestOptions): HttpResponseFor<ModelDeleted> =
            delete(model, ModelDeleteParams.none(), requestOptions)
    }
}
