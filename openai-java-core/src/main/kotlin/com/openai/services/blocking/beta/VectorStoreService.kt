// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.beta

import com.openai.core.RequestOptions
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreListPage
import com.openai.models.BetaVectorStoreListParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.VectorStore
import com.openai.models.VectorStoreDeleted
import com.openai.services.blocking.beta.vectorStores.FileBatchService
import com.openai.services.blocking.beta.vectorStores.FileService

interface VectorStoreService {

    fun files(): FileService

    fun fileBatches(): FileBatchService

    /** Create a vector store. */
    @JvmOverloads
    fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Retrieves a vector store. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Modifies a vector store. */
    @JvmOverloads
    fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Returns a list of vector stores. */
    @JvmOverloads
    fun list(
        params: BetaVectorStoreListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaVectorStoreListPage

    /** Delete a vector store. */
    @JvmOverloads
    fun delete(
        params: BetaVectorStoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreDeleted
}
