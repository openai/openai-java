// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.openai.core.RequestOptions
import com.openai.models.Model
import com.openai.models.ModelDeleteParams
import com.openai.models.ModelDeleted
import com.openai.models.ModelListPage
import com.openai.models.ModelListParams
import com.openai.models.ModelRetrieveParams

interface ModelService {

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
}
