// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.beta.vectorStores

import com.openai.core.RequestOptions
import com.openai.models.BetaVectorStoreFileCreateParams
import com.openai.models.BetaVectorStoreFileDeleteParams
import com.openai.models.BetaVectorStoreFileListPage
import com.openai.models.BetaVectorStoreFileListParams
import com.openai.models.BetaVectorStoreFileRetrieveParams
import com.openai.models.VectorStoreFile
import com.openai.models.VectorStoreFileDeleted

interface FileService {

    /**
     * Create a vector store file by attaching a
     * [File](https://platform.openai.com/docs/api-reference/files) to a
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
     */
    @JvmOverloads
    fun create(
        params: BetaVectorStoreFileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VectorStoreFile

    /** Retrieves a vector store file. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreFileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VectorStoreFile

    /** Returns a list of vector store files. */
    @JvmOverloads
    fun list(
        params: BetaVectorStoreFileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BetaVectorStoreFileListPage

    /**
     * Delete a vector store file. This will remove the file from the vector store but the file
     * itself will not be deleted. To delete the file, use the
     * [delete file](https://platform.openai.com/docs/api-reference/files/delete) endpoint.
     */
    @JvmOverloads
    fun delete(
        params: BetaVectorStoreFileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VectorStoreFileDeleted
}
