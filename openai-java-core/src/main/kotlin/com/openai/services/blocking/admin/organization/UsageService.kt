// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface UsageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService

    /** Get audio speeches usage details for the organization. */
    fun audioSpeeches(params: UsageAudioSpeechesParams): UsageAudioSpeechesResponse =
        audioSpeeches(params, RequestOptions.none())

    /** @see audioSpeeches */
    fun audioSpeeches(
        params: UsageAudioSpeechesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageAudioSpeechesResponse

    /** Get audio transcriptions usage details for the organization. */
    fun audioTranscriptions(
        params: UsageAudioTranscriptionsParams
    ): UsageAudioTranscriptionsResponse = audioTranscriptions(params, RequestOptions.none())

    /** @see audioTranscriptions */
    fun audioTranscriptions(
        params: UsageAudioTranscriptionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageAudioTranscriptionsResponse

    /** Get code interpreter sessions usage details for the organization. */
    fun codeInterpreterSessions(
        params: UsageCodeInterpreterSessionsParams
    ): UsageCodeInterpreterSessionsResponse = codeInterpreterSessions(params, RequestOptions.none())

    /** @see codeInterpreterSessions */
    fun codeInterpreterSessions(
        params: UsageCodeInterpreterSessionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageCodeInterpreterSessionsResponse

    /** Get completions usage details for the organization. */
    fun completions(params: UsageCompletionsParams): UsageCompletionsResponse =
        completions(params, RequestOptions.none())

    /** @see completions */
    fun completions(
        params: UsageCompletionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageCompletionsResponse

    /** Get costs details for the organization. */
    fun costs(params: UsageCostsParams): UsageCostsResponse = costs(params, RequestOptions.none())

    /** @see costs */
    fun costs(
        params: UsageCostsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageCostsResponse

    /** Get embeddings usage details for the organization. */
    fun embeddings(params: UsageEmbeddingsParams): UsageEmbeddingsResponse =
        embeddings(params, RequestOptions.none())

    /** @see embeddings */
    fun embeddings(
        params: UsageEmbeddingsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageEmbeddingsResponse

    /** Get images usage details for the organization. */
    fun images(params: UsageImagesParams): UsageImagesResponse =
        images(params, RequestOptions.none())

    /** @see images */
    fun images(
        params: UsageImagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageImagesResponse

    /** Get moderations usage details for the organization. */
    fun moderations(params: UsageModerationsParams): UsageModerationsResponse =
        moderations(params, RequestOptions.none())

    /** @see moderations */
    fun moderations(
        params: UsageModerationsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageModerationsResponse

    /** Get vector stores usage details for the organization. */
    fun vectorStores(params: UsageVectorStoresParams): UsageVectorStoresResponse =
        vectorStores(params, RequestOptions.none())

    /** @see vectorStores */
    fun vectorStores(
        params: UsageVectorStoresParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageVectorStoresResponse

    /** A view of [UsageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/usage/audio_speeches`, but is
         * otherwise the same as [UsageService.audioSpeeches].
         */
        @MustBeClosed
        fun audioSpeeches(
            params: UsageAudioSpeechesParams
        ): HttpResponseFor<UsageAudioSpeechesResponse> =
            audioSpeeches(params, RequestOptions.none())

        /** @see audioSpeeches */
        @MustBeClosed
        fun audioSpeeches(
            params: UsageAudioSpeechesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageAudioSpeechesResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/audio_transcriptions`, but is
         * otherwise the same as [UsageService.audioTranscriptions].
         */
        @MustBeClosed
        fun audioTranscriptions(
            params: UsageAudioTranscriptionsParams
        ): HttpResponseFor<UsageAudioTranscriptionsResponse> =
            audioTranscriptions(params, RequestOptions.none())

        /** @see audioTranscriptions */
        @MustBeClosed
        fun audioTranscriptions(
            params: UsageAudioTranscriptionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageAudioTranscriptionsResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/code_interpreter_sessions`, but
         * is otherwise the same as [UsageService.codeInterpreterSessions].
         */
        @MustBeClosed
        fun codeInterpreterSessions(
            params: UsageCodeInterpreterSessionsParams
        ): HttpResponseFor<UsageCodeInterpreterSessionsResponse> =
            codeInterpreterSessions(params, RequestOptions.none())

        /** @see codeInterpreterSessions */
        @MustBeClosed
        fun codeInterpreterSessions(
            params: UsageCodeInterpreterSessionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageCodeInterpreterSessionsResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/completions`, but is otherwise
         * the same as [UsageService.completions].
         */
        @MustBeClosed
        fun completions(params: UsageCompletionsParams): HttpResponseFor<UsageCompletionsResponse> =
            completions(params, RequestOptions.none())

        /** @see completions */
        @MustBeClosed
        fun completions(
            params: UsageCompletionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageCompletionsResponse>

        /**
         * Returns a raw HTTP response for `get /organization/costs`, but is otherwise the same as
         * [UsageService.costs].
         */
        @MustBeClosed
        fun costs(params: UsageCostsParams): HttpResponseFor<UsageCostsResponse> =
            costs(params, RequestOptions.none())

        /** @see costs */
        @MustBeClosed
        fun costs(
            params: UsageCostsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageCostsResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/embeddings`, but is otherwise
         * the same as [UsageService.embeddings].
         */
        @MustBeClosed
        fun embeddings(params: UsageEmbeddingsParams): HttpResponseFor<UsageEmbeddingsResponse> =
            embeddings(params, RequestOptions.none())

        /** @see embeddings */
        @MustBeClosed
        fun embeddings(
            params: UsageEmbeddingsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageEmbeddingsResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/images`, but is otherwise the
         * same as [UsageService.images].
         */
        @MustBeClosed
        fun images(params: UsageImagesParams): HttpResponseFor<UsageImagesResponse> =
            images(params, RequestOptions.none())

        /** @see images */
        @MustBeClosed
        fun images(
            params: UsageImagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageImagesResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/moderations`, but is otherwise
         * the same as [UsageService.moderations].
         */
        @MustBeClosed
        fun moderations(params: UsageModerationsParams): HttpResponseFor<UsageModerationsResponse> =
            moderations(params, RequestOptions.none())

        /** @see moderations */
        @MustBeClosed
        fun moderations(
            params: UsageModerationsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageModerationsResponse>

        /**
         * Returns a raw HTTP response for `get /organization/usage/vector_stores`, but is otherwise
         * the same as [UsageService.vectorStores].
         */
        @MustBeClosed
        fun vectorStores(
            params: UsageVectorStoresParams
        ): HttpResponseFor<UsageVectorStoresResponse> = vectorStores(params, RequestOptions.none())

        /** @see vectorStores */
        @MustBeClosed
        fun vectorStores(
            params: UsageVectorStoresParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageVectorStoresResponse>
    }
}
