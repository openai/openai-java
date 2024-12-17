// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.models.Batch
import com.openai.models.BatchCancelParams
import com.openai.models.BatchCreateParams
import com.openai.models.BatchListPageAsync
import com.openai.models.BatchListParams
import com.openai.models.BatchRetrieveParams
import java.util.concurrent.CompletableFuture

interface BatchServiceAsync {

    /** Creates and executes a batch from an uploaded file of requests */
    @JvmOverloads
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Batch>

    /** Retrieves a batch. */
    @JvmOverloads
    fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Batch>

    /** List your organization's batches. */
    @JvmOverloads
    fun list(
        params: BatchListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BatchListPageAsync>

    /**
     * Cancels an in-progress batch. The batch will be in status `cancelling` for up to 10 minutes,
     * before changing to `cancelled`, where it will have partial results (if any) available in the
     * output file.
     */
    @JvmOverloads
    fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Batch>
}