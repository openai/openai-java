// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta

import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.models.AssistantStreamEvent
import com.openai.models.BetaThreadCreateAndRunParams
import com.openai.models.BetaThreadCreateParams
import com.openai.models.BetaThreadDeleteParams
import com.openai.models.BetaThreadRetrieveParams
import com.openai.models.BetaThreadUpdateParams
import com.openai.models.Run
import com.openai.models.Thread
import com.openai.models.ThreadDeleted
import com.openai.services.async.beta.threads.MessageServiceAsync
import com.openai.services.async.beta.threads.RunServiceAsync
import java.util.concurrent.CompletableFuture

interface ThreadServiceAsync {

    fun runs(): RunServiceAsync

    fun messages(): MessageServiceAsync

    /** Create a thread. */
    @JvmOverloads
    fun create(
        params: BetaThreadCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Thread>

    /** Retrieves a thread. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Thread>

    /** Modifies a thread. */
    @JvmOverloads
    fun update(
        params: BetaThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Thread>

    /** Delete a thread. */
    @JvmOverloads
    fun delete(
        params: BetaThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ThreadDeleted>

    /** Create a thread and run it in one request. */
    @JvmOverloads
    fun createAndRun(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Run>

    /** Create a thread and run it in one request. */
    @JvmOverloads
    fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AsyncStreamResponse<AssistantStreamEvent>
}
