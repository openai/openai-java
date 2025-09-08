// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams
import com.openai.models.realtime.clientsecrets.ClientSecretCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ClientSecretServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ClientSecretServiceAsync

    /** Create a Realtime client secret with an associated session configuration. */
    fun create(): CompletableFuture<ClientSecretCreateResponse> =
        create(ClientSecretCreateParams.none())

    /** @see create */
    fun create(
        params: ClientSecretCreateParams = ClientSecretCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ClientSecretCreateResponse>

    /** @see create */
    fun create(
        params: ClientSecretCreateParams = ClientSecretCreateParams.none()
    ): CompletableFuture<ClientSecretCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ClientSecretCreateResponse> =
        create(ClientSecretCreateParams.none(), requestOptions)

    /**
     * A view of [ClientSecretServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /realtime/client_secrets`, but is otherwise the
         * same as [ClientSecretServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ClientSecretCreateResponse>> =
            create(ClientSecretCreateParams.none())

        /** @see create */
        fun create(
            params: ClientSecretCreateParams = ClientSecretCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ClientSecretCreateResponse>>

        /** @see create */
        fun create(
            params: ClientSecretCreateParams = ClientSecretCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ClientSecretCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ClientSecretCreateResponse>> =
            create(ClientSecretCreateParams.none(), requestOptions)
    }
}
