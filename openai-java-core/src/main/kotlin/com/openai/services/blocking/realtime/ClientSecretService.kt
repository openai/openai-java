// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams
import com.openai.models.realtime.clientsecrets.ClientSecretCreateResponse
import java.util.function.Consumer

interface ClientSecretService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ClientSecretService

    /** Create a Realtime session and client secret for either realtime or transcription. */
    fun create(): ClientSecretCreateResponse = create(ClientSecretCreateParams.none())

    /** @see create */
    fun create(
        params: ClientSecretCreateParams = ClientSecretCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ClientSecretCreateResponse

    /** @see create */
    fun create(
        params: ClientSecretCreateParams = ClientSecretCreateParams.none()
    ): ClientSecretCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ClientSecretCreateResponse =
        create(ClientSecretCreateParams.none(), requestOptions)

    /**
     * A view of [ClientSecretService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /realtime/client_secrets`, but is otherwise the
         * same as [ClientSecretService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ClientSecretCreateResponse> =
            create(ClientSecretCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ClientSecretCreateParams = ClientSecretCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ClientSecretCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ClientSecretCreateParams = ClientSecretCreateParams.none()
        ): HttpResponseFor<ClientSecretCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ClientSecretCreateResponse> =
            create(ClientSecretCreateParams.none(), requestOptions)
    }
}
