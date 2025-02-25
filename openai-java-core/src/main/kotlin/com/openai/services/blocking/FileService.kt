// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.FileContentParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileDeleted
import com.openai.models.FileListPage
import com.openai.models.FileListParams
import com.openai.models.FileObject
import com.openai.models.FileRetrieveParams

interface FileService {

    /** Returns information about a specific file. */
    @JvmOverloads
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileObject

    /** Returns a list of files. */
    @JvmOverloads
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /** Returns a list of files. */
    fun list(requestOptions: RequestOptions): FileListPage =
        list(FileListParams.none(), requestOptions)

    /** Delete a file. */
    @JvmOverloads
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileDeleted

    /** Returns the contents of the specified file. */
    @JvmOverloads
    @MustBeClosed
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse
}
