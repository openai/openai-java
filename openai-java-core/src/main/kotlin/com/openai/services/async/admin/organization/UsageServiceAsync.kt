// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.usage.UsageAudioSpeechesParams
import com.openai.models.admin.organization.usage.UsageAudioSpeechesResponse
import com.openai.models.admin.organization.usage.UsageAudioTranscriptionsParams
import com.openai.models.admin.organization.usage.UsageAudioTranscriptionsResponse
import com.openai.models.admin.organization.usage.UsageCodeInterpreterSessionsParams
import com.openai.models.admin.organization.usage.UsageCodeInterpreterSessionsResponse
import com.openai.models.admin.organization.usage.UsageCompletionsParams
import com.openai.models.admin.organization.usage.UsageCompletionsResponse
import com.openai.models.admin.organization.usage.UsageCostsParams
import com.openai.models.admin.organization.usage.UsageCostsResponse
import com.openai.models.admin.organization.usage.UsageEmbeddingsParams
import com.openai.models.admin.organization.usage.UsageEmbeddingsResponse
import com.openai.models.admin.organization.usage.UsageImagesParams
import com.openai.models.admin.organization.usage.UsageImagesResponse
import com.openai.models.admin.organization.usage.UsageModerationsParams
import com.openai.models.admin.organization.usage.UsageModerationsResponse
import com.openai.models.admin.organization.usage.UsageVectorStoresParams
import com.openai.models.admin.organization.usage.UsageVectorStoresResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface UsageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageServiceAsync

    /** Get audio speeches usage details for the organization. */
    fun audioSpeeches(
        params: UsageAudioSpeechesParams
    ): CompletableFuture<UsageAudioSpeechesResponse> = audioSpeeches(params, RequestOptions.none())

    /** @see audioSpeeches */
    fun audioSpeeches(
        params: UsageAudioSpeechesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageAudioSpeechesResponse>

    /** Get audio transcriptions usage details for the organization. */
    fun audioTranscriptions(
        params: UsageAudioTranscriptionsParams
    ): CompletableFuture<UsageAudioTranscriptionsResponse> =
        audioTranscriptions(params, RequestOptions.none())

    /** @see audioTranscriptions */
    fun audioTranscriptions(
        params: UsageAudioTranscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageAudioTranscriptionsResponse>

    /** Get code interpreter sessions usage details for the organization. */
    fun codeInterpreterSessions(
        params: UsageCodeInterpreterSessionsParams
    ): CompletableFuture<UsageCodeInterpreterSessionsResponse> =
        codeInterpreterSessions(params, RequestOptions.none())

    /** @see codeInterpreterSessions */
    fun codeInterpreterSessions(
        params: UsageCodeInterpreterSessionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageCodeInterpreterSessionsResponse>

    /** Get completions usage details for the organization. */
    fun completions(params: UsageCompletionsParams): CompletableFuture<UsageCompletionsResponse> =
        completions(params, RequestOptions.none())

    /** @see completions */
    fun completions(
        params: UsageCompletionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageCompletionsResponse>

    /** Get costs details for the organization. */
    fun costs(params: UsageCostsParams): CompletableFuture<UsageCostsResponse> =
        costs(params, RequestOptions.none())

    /** @see costs */
    fun costs(
        params: UsageCostsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageCostsResponse>

    /** Get embeddings usage details for the organization. */
    fun embeddings(params: UsageEmbeddingsParams): CompletableFuture<UsageEmbeddingsResponse> =
        embeddings(params, RequestOptions.none())

    /** @see embeddings */
    fun embeddings(
        params: UsageEmbeddingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageEmbeddingsResponse>

    /** Get images usage details for the organization. */
    fun images(params: UsageImagesParams): CompletableFuture<UsageImagesResponse> =
        images(params, RequestOptions.none())

    /** @see images */
    fun images(
        params: UsageImagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageImagesResponse>

    /** Get moderations usage details for the organization. */
    fun moderations(params: UsageModerationsParams): CompletableFuture<UsageModerationsResponse> =
        moderations(params, RequestOptions.none())

    /** @see moderations */
    fun moderations(
        params: UsageModerationsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageModerationsResponse>

    /** Get vector stores usage details for the organization. */
    fun vectorStores(
        params: UsageVectorStoresParams
    ): CompletableFuture<UsageVectorStoresResponse> = vectorStores(params, RequestOptions.none())

    /** @see vectorStores */
    fun vectorStores(
        params: UsageVectorStoresParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageVectorStoresResponse>

    /** A view of [UsageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/usage/audio_speeches`, but is
         * otherwise the same as [UsageServiceAsync.audioSpeeches].
         */
        fun audioSpeeches(
            params: UsageAudioSpeechesParams
        ): CompletableFuture<HttpResponseFor<UsageAudioSpeechesResponse>> =
            audioSpeeches(params, RequestOptions.none())

        /** @see audioSpeeches */
        fun audioSpeeches(
            params: UsageAudioSpeechesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageAudioSpeechesResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/audio_transcriptions`, but is
         * otherwise the same as [UsageServiceAsync.audioTranscriptions].
         */
        fun audioTranscriptions(
            params: UsageAudioTranscriptionsParams
        ): CompletableFuture<HttpResponseFor<UsageAudioTranscriptionsResponse>> =
            audioTranscriptions(params, RequestOptions.none())

        /** @see audioTranscriptions */
        fun audioTranscriptions(
            params: UsageAudioTranscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageAudioTranscriptionsResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/code_interpreter_sessions`, but
         * is otherwise the same as [UsageServiceAsync.codeInterpreterSessions].
         */
        fun codeInterpreterSessions(
            params: UsageCodeInterpreterSessionsParams
        ): CompletableFuture<HttpResponseFor<UsageCodeInterpreterSessionsResponse>> =
            codeInterpreterSessions(params, RequestOptions.none())

        /** @see codeInterpreterSessions */
        fun codeInterpreterSessions(
            params: UsageCodeInterpreterSessionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageCodeInterpreterSessionsResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/completions`, but is otherwise
         * the same as [UsageServiceAsync.completions].
         */
        fun completions(
            params: UsageCompletionsParams
        ): CompletableFuture<HttpResponseFor<UsageCompletionsResponse>> =
            completions(params, RequestOptions.none())

        /** @see completions */
        fun completions(
            params: UsageCompletionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageCompletionsResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/costs`, but is otherwise the same as
         * [UsageServiceAsync.costs].
         */
        fun costs(
            params: UsageCostsParams
        ): CompletableFuture<HttpResponseFor<UsageCostsResponse>> =
            costs(params, RequestOptions.none())

        /** @see costs */
        fun costs(
            params: UsageCostsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageCostsResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/embeddings`, but is otherwise
         * the same as [UsageServiceAsync.embeddings].
         */
        fun embeddings(
            params: UsageEmbeddingsParams
        ): CompletableFuture<HttpResponseFor<UsageEmbeddingsResponse>> =
            embeddings(params, RequestOptions.none())

        /** @see embeddings */
        fun embeddings(
            params: UsageEmbeddingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageEmbeddingsResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/images`, but is otherwise the
         * same as [UsageServiceAsync.images].
         */
        fun images(
            params: UsageImagesParams
        ): CompletableFuture<HttpResponseFor<UsageImagesResponse>> =
            images(params, RequestOptions.none())

        /** @see images */
        fun images(
            params: UsageImagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageImagesResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/moderations`, but is otherwise
         * the same as [UsageServiceAsync.moderations].
         */
        fun moderations(
            params: UsageModerationsParams
        ): CompletableFuture<HttpResponseFor<UsageModerationsResponse>> =
            moderations(params, RequestOptions.none())

        /** @see moderations */
        fun moderations(
            params: UsageModerationsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageModerationsResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/usage/vector_stores`, but is otherwise
         * the same as [UsageServiceAsync.vectorStores].
         */
        fun vectorStores(
            params: UsageVectorStoresParams
        ): CompletableFuture<HttpResponseFor<UsageVectorStoresResponse>> =
            vectorStores(params, RequestOptions.none())

        /** @see vectorStores */
        fun vectorStores(
            params: UsageVectorStoresParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageVectorStoresResponse>>
    }
}
