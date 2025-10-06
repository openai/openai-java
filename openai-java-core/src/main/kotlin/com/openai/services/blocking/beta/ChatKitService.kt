// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.chatkit.ChatKitUploadFileParams
import com.openai.models.beta.chatkit.ChatKitUploadFileResponse
import com.openai.services.blocking.beta.chatkit.SessionService
import com.openai.services.blocking.beta.chatkit.ThreadService
import java.util.function.Consumer

interface ChatKitService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitService

    fun sessions(): SessionService

    fun threads(): ThreadService

    /** Upload a ChatKit file */
    fun uploadFile(params: ChatKitUploadFileParams): ChatKitUploadFileResponse =
        uploadFile(params, RequestOptions.none())

    /** @see uploadFile */
    fun uploadFile(
        params: ChatKitUploadFileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatKitUploadFileResponse

    /** A view of [ChatKitService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitService.WithRawResponse

        fun sessions(): SessionService.WithRawResponse

        fun threads(): ThreadService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /chatkit/files`, but is otherwise the same as
         * [ChatKitService.uploadFile].
         */
        @MustBeClosed
        fun uploadFile(
            params: ChatKitUploadFileParams
        ): HttpResponseFor<ChatKitUploadFileResponse> = uploadFile(params, RequestOptions.none())

        /** @see uploadFile */
        @MustBeClosed
        fun uploadFile(
            params: ChatKitUploadFileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatKitUploadFileResponse>
    }
}
