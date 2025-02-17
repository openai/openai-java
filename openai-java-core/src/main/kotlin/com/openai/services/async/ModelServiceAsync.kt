// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.models.Model
import com.openai.models.ModelDeleteParams
import com.openai.models.ModelDeleted
import com.openai.models.ModelListPageAsync
import com.openai.models.ModelListParams
import com.openai.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture

interface ModelServiceAsync {

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    @JvmOverloads
    fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Model>

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    @JvmOverloads
    fun list(
        params: ModelListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ModelListPageAsync>

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization to delete a
     * model.
     */
    @JvmOverloads
    fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ModelDeleted>
}
