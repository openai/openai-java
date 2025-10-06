// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.chatkit.ChatKitUploadFileParams
import com.openai.models.beta.chatkit.ChatKitUploadFileResponse
import com.openai.services.async.beta.chatkit.SessionServiceAsync
import com.openai.services.async.beta.chatkit.ThreadServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ChatKitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitServiceAsync

    fun sessions(): SessionServiceAsync

    fun threads(): ThreadServiceAsync

    /** Upload a ChatKit file */
    fun uploadFile(params: ChatKitUploadFileParams): CompletableFuture<ChatKitUploadFileResponse> =
        uploadFile(params, RequestOptions.none())

    /** @see uploadFile */
    fun uploadFile(
        params: ChatKitUploadFileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatKitUploadFileResponse>

    /**
     * A view of [ChatKitServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatKitServiceAsync.WithRawResponse

        fun sessions(): SessionServiceAsync.WithRawResponse

        fun threads(): ThreadServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chatkit/files`, but is otherwise the same as
         * [ChatKitServiceAsync.uploadFile].
         */
        fun uploadFile(
            params: ChatKitUploadFileParams
        ): CompletableFuture<HttpResponseFor<ChatKitUploadFileResponse>> =
            uploadFile(params, RequestOptions.none())

        /** @see uploadFile */
        fun uploadFile(
            params: ChatKitUploadFileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatKitUploadFileResponse>>
    }
}
