// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.realtime.translations

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateRequest
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateResponse
import com.openai.models.realtime.translations.clientsecrets.ClientSecretCreateParams
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

    /**
     * Create a Realtime translation client secret with an associated translation session
     * configuration.
     *
     * Client secrets are short-lived tokens that can be passed to a client app, such as a web
     * frontend or mobile client, which grants access to the Realtime Translation API without
     * leaking your main API key. You can configure a custom TTL for each client secret.
     *
     * Returns the created client secret and the effective translation session object. The client
     * secret is a string that looks like `ek_1234`.
     */
    fun create(params: ClientSecretCreateParams): RealtimeTranslationClientSecretCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ClientSecretCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RealtimeTranslationClientSecretCreateResponse

    /** @see create */
    fun create(
        realtimeTranslationClientSecretCreateRequest: RealtimeTranslationClientSecretCreateRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RealtimeTranslationClientSecretCreateResponse =
        create(
            ClientSecretCreateParams.builder()
                .realtimeTranslationClientSecretCreateRequest(
                    realtimeTranslationClientSecretCreateRequest
                )
                .build(),
            requestOptions,
        )

    /** @see create */
    fun create(
        realtimeTranslationClientSecretCreateRequest: RealtimeTranslationClientSecretCreateRequest
    ): RealtimeTranslationClientSecretCreateResponse =
        create(realtimeTranslationClientSecretCreateRequest, RequestOptions.none())

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
         * Returns a raw HTTP response for `post /realtime/translations/client_secrets`, but is
         * otherwise the same as [ClientSecretService.create].
         */
        @MustBeClosed
        fun create(
            params: ClientSecretCreateParams
        ): HttpResponseFor<RealtimeTranslationClientSecretCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ClientSecretCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RealtimeTranslationClientSecretCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            realtimeTranslationClientSecretCreateRequest:
                RealtimeTranslationClientSecretCreateRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RealtimeTranslationClientSecretCreateResponse> =
            create(
                ClientSecretCreateParams.builder()
                    .realtimeTranslationClientSecretCreateRequest(
                        realtimeTranslationClientSecretCreateRequest
                    )
                    .build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(
            realtimeTranslationClientSecretCreateRequest:
                RealtimeTranslationClientSecretCreateRequest
        ): HttpResponseFor<RealtimeTranslationClientSecretCreateResponse> =
            create(realtimeTranslationClientSecretCreateRequest, RequestOptions.none())
    }
}
