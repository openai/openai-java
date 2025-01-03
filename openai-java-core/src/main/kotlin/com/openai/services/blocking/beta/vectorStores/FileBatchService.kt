// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.beta.vectorStores

import com.openai.core.RequestOptions
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesPage
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import com.openai.models.VectorStoreFileBatch

interface FileBatchService {

    /** Create a vector store file batch. */
    @JvmOverloads
    fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VectorStoreFileBatch

    /** Retrieves a vector store file batch. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VectorStoreFileBatch

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    @JvmOverloads
    fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VectorStoreFileBatch

    /** Returns a list of vector store files in a batch. */
    @JvmOverloads
    fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BetaVectorStoreFileBatchListFilesPage
}
