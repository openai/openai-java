// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.FileContentParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileDeleted
import com.openai.models.FileListPageAsync
import com.openai.models.FileListParams
import com.openai.models.FileObject
import com.openai.models.FileRetrieveParams
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /** Returns information about a specific file. */
    @JvmOverloads
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileObject>

    /** Returns a list of files. */
    @JvmOverloads
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileListPageAsync>

    /** Delete a file. */
    @JvmOverloads
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<FileDeleted>

    /** Returns the contents of the specified file. */
    @JvmOverloads
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<HttpResponse>
}
