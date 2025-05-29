// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.models.Model
import com.openai.models.models.ModelDeleteParams
import com.openai.models.models.ModelDeleted
import com.openai.models.models.ModelListPageAsync
import com.openai.models.models.ModelListParams
import com.openai.models.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture

interface ModelServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    fun retrieve(model: String): CompletableFuture<Model> =
        retrieve(model, ModelRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        model: String,
        params: ModelRetrieveParams = ModelRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Model> = retrieve(params.toBuilder().model(model).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        model: String,
        params: ModelRetrieveParams = ModelRetrieveParams.none(),
    ): CompletableFuture<Model> = retrieve(model, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Model>

    /** @see [retrieve] */
    fun retrieve(params: ModelRetrieveParams): CompletableFuture<Model> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(model: String, requestOptions: RequestOptions): CompletableFuture<Model> =
        retrieve(model, ModelRetrieveParams.none(), requestOptions)

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    fun list(): CompletableFuture<ModelListPageAsync> = list(ModelListParams.none())

    /** @see [list] */
    fun list(
        params: ModelListParams = ModelListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ModelListPageAsync>

    /** @see [list] */
    fun list(
        params: ModelListParams = ModelListParams.none()
    ): CompletableFuture<ModelListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<ModelListPageAsync> =
        list(ModelListParams.none(), requestOptions)

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization to delete a
     * model.
     */
    fun delete(model: String): CompletableFuture<ModelDeleted> =
        delete(model, ModelDeleteParams.none())

    /** @see [delete] */
    fun delete(
        model: String,
        params: ModelDeleteParams = ModelDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ModelDeleted> =
        delete(params.toBuilder().model(model).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        model: String,
        params: ModelDeleteParams = ModelDeleteParams.none(),
    ): CompletableFuture<ModelDeleted> = delete(model, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ModelDeleted>

    /** @see [delete] */
    fun delete(params: ModelDeleteParams): CompletableFuture<ModelDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(model: String, requestOptions: RequestOptions): CompletableFuture<ModelDeleted> =
        delete(model, ModelDeleteParams.none(), requestOptions)

    /** A view of [ModelServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /models/{model}`, but is otherwise the same as
         * [ModelServiceAsync.retrieve].
         */
        fun retrieve(model: String): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(model, ModelRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            model: String,
            params: ModelRetrieveParams = ModelRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(params.toBuilder().model(model).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            model: String,
            params: ModelRetrieveParams = ModelRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(model, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Model>>

        /** @see [retrieve] */
        fun retrieve(params: ModelRetrieveParams): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            model: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Model>> =
            retrieve(model, ModelRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /models`, but is otherwise the same as
         * [ModelServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ModelListPageAsync>> =
            list(ModelListParams.none())

        /** @see [list] */
        fun list(
            params: ModelListParams = ModelListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ModelListPageAsync>>

        /** @see [list] */
        fun list(
            params: ModelListParams = ModelListParams.none()
        ): CompletableFuture<HttpResponseFor<ModelListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ModelListPageAsync>> =
            list(ModelListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /models/{model}`, but is otherwise the same as
         * [ModelServiceAsync.delete].
         */
        fun delete(model: String): CompletableFuture<HttpResponseFor<ModelDeleted>> =
            delete(model, ModelDeleteParams.none())

        /** @see [delete] */
        fun delete(
            model: String,
            params: ModelDeleteParams = ModelDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ModelDeleted>> =
            delete(params.toBuilder().model(model).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            model: String,
            params: ModelDeleteParams = ModelDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ModelDeleted>> =
            delete(model, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: ModelDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ModelDeleted>>

        /** @see [delete] */
        fun delete(params: ModelDeleteParams): CompletableFuture<HttpResponseFor<ModelDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            model: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ModelDeleted>> =
            delete(model, ModelDeleteParams.none(), requestOptions)
    }
}
