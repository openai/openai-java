// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta

import com.openai.core.RequestOptions
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreListPageAsync
import com.openai.models.BetaVectorStoreListParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.VectorStore
import com.openai.models.VectorStoreDeleted
import com.openai.services.async.beta.vectorStores.FileBatchServiceAsync
import com.openai.services.async.beta.vectorStores.FileServiceAsync
import java.util.concurrent.CompletableFuture

interface VectorStoreServiceAsync {

    fun files(): FileServiceAsync

    fun fileBatches(): FileBatchServiceAsync

    /** Create a vector store. */
    @JvmOverloads
    fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Retrieves a vector store. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Modifies a vector store. */
    @JvmOverloads
    fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Returns a list of vector stores. */
    @JvmOverloads
    fun list(
        params: BetaVectorStoreListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaVectorStoreListPageAsync>

    /** Delete a vector store. */
    @JvmOverloads
    fun delete(
        params: BetaVectorStoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreDeleted>
}
