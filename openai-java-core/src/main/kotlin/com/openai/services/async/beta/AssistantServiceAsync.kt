// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta

import com.openai.core.RequestOptions
import com.openai.models.Assistant
import com.openai.models.AssistantDeleted
import com.openai.models.BetaAssistantCreateParams
import com.openai.models.BetaAssistantDeleteParams
import com.openai.models.BetaAssistantListPageAsync
import com.openai.models.BetaAssistantListParams
import com.openai.models.BetaAssistantRetrieveParams
import com.openai.models.BetaAssistantUpdateParams
import java.util.concurrent.CompletableFuture

interface AssistantServiceAsync {

    /** Create an assistant with a model and instructions. */
    @JvmOverloads
    fun create(
        params: BetaAssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Retrieves an assistant. */
    @JvmOverloads
    fun retrieve(
        params: BetaAssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Modifies an assistant. */
    @JvmOverloads
    fun update(
        params: BetaAssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Returns a list of assistants. */
    @JvmOverloads
    fun list(
        params: BetaAssistantListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaAssistantListPageAsync>

    /** Delete an assistant. */
    @JvmOverloads
    fun delete(
        params: BetaAssistantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AssistantDeleted>
}
