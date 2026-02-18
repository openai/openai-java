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

    /**
     * Create a Realtime client secret with an associated session configuration.
     *
     * Client secrets are short-lived tokens that can be passed to a client app, such as a web
     * frontend or mobile client, which grants access to the Realtime API without leaking your main
     * API key. You can configure a custom TTL for each client secret.
     *
     * You can also attach session configuration options to the client secret, which will be applied
     * to any sessions created using that client secret, but these can also be overridden by the
     * client connection.
     *
     * [Learn more about authentication with client secrets over
     * WebRTC](https://platform.openai.com/docs/guides/realtime-webrtc).
     *
     * Returns the created client secret and the effective session object. The client secret is a
     * string that looks like `ek_1234`.
     */
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
