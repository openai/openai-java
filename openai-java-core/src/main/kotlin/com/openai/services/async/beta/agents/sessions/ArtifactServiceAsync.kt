// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.artifacts.ArtifactContentParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactDeleteParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListPageAsync
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactRetrieveParams
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifact
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifactDeleted
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ArtifactServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ArtifactServiceAsync

    /**
     * Retrieves immutable metadata for one durable session artifact. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun retrieve(
        artifactId: String,
        params: ArtifactRetrieveParams,
    ): CompletableFuture<SessionArtifact> = retrieve(artifactId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        artifactId: String,
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionArtifact> =
        retrieve(params.toBuilder().artifactId(artifactId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ArtifactRetrieveParams): CompletableFuture<SessionArtifact> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionArtifact>

    /**
     * Lists immutable artifacts published by completed hosted session turns. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun list(sessionId: String): CompletableFuture<ArtifactListPageAsync> =
        list(sessionId, ArtifactListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: ArtifactListParams = ArtifactListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ArtifactListPageAsync> =
        list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: ArtifactListParams = ArtifactListParams.none(),
    ): CompletableFuture<ArtifactListPageAsync> = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ArtifactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ArtifactListPageAsync>

    /** @see list */
    fun list(params: ArtifactListParams): CompletableFuture<ArtifactListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ArtifactListPageAsync> =
        list(sessionId, ArtifactListParams.none(), requestOptions)

    /**
     * Deletes an immutable session artifact without deleting its live environment file or original
     * Files API object. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun delete(
        artifactId: String,
        params: ArtifactDeleteParams,
    ): CompletableFuture<SessionArtifactDeleted> = delete(artifactId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        artifactId: String,
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionArtifactDeleted> =
        delete(params.toBuilder().artifactId(artifactId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ArtifactDeleteParams): CompletableFuture<SessionArtifactDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionArtifactDeleted>

    /**
     * Downloads immutable session artifact bytes after the execution environment expires. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun content(
        artifactId: String,
        params: ArtifactContentParams,
    ): CompletableFuture<HttpResponse> = content(artifactId, params, RequestOptions.none())

    /** @see content */
    fun content(
        artifactId: String,
        params: ArtifactContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        content(params.toBuilder().artifactId(artifactId).build(), requestOptions)

    /** @see content */
    fun content(params: ArtifactContentParams): CompletableFuture<HttpResponse> =
        content(params, RequestOptions.none())

    /** @see content */
    fun content(
        params: ArtifactContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /**
     * A view of [ArtifactServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ArtifactServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/artifacts/{artifact_id}`, but is otherwise the same as
         * [ArtifactServiceAsync.retrieve].
         */
        fun retrieve(
            artifactId: String,
            params: ArtifactRetrieveParams,
        ): CompletableFuture<HttpResponseFor<SessionArtifact>> =
            retrieve(artifactId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            artifactId: String,
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionArtifact>> =
            retrieve(params.toBuilder().artifactId(artifactId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: ArtifactRetrieveParams
        ): CompletableFuture<HttpResponseFor<SessionArtifact>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionArtifact>>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/artifacts`, but is
         * otherwise the same as [ArtifactServiceAsync.list].
         */
        fun list(sessionId: String): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>> =
            list(sessionId, ArtifactListParams.none())

        /** @see list */
        fun list(
            sessionId: String,
            params: ArtifactListParams = ArtifactListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        fun list(
            sessionId: String,
            params: ArtifactListParams = ArtifactListParams.none(),
        ): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>> =
            list(sessionId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ArtifactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>>

        /** @see list */
        fun list(
            params: ArtifactListParams
        ): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>> =
            list(sessionId, ArtifactListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /agents/sessions/{session_id}/artifacts/{artifact_id}`, but is otherwise the same as
         * [ArtifactServiceAsync.delete].
         */
        fun delete(
            artifactId: String,
            params: ArtifactDeleteParams,
        ): CompletableFuture<HttpResponseFor<SessionArtifactDeleted>> =
            delete(artifactId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            artifactId: String,
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionArtifactDeleted>> =
            delete(params.toBuilder().artifactId(artifactId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: ArtifactDeleteParams
        ): CompletableFuture<HttpResponseFor<SessionArtifactDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionArtifactDeleted>>

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/artifacts/{artifact_id}/content`, but is otherwise the same
         * as [ArtifactServiceAsync.content].
         */
        fun content(
            artifactId: String,
            params: ArtifactContentParams,
        ): CompletableFuture<HttpResponse> = content(artifactId, params, RequestOptions.none())

        /** @see content */
        fun content(
            artifactId: String,
            params: ArtifactContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            content(params.toBuilder().artifactId(artifactId).build(), requestOptions)

        /** @see content */
        fun content(params: ArtifactContentParams): CompletableFuture<HttpResponse> =
            content(params, RequestOptions.none())

        /** @see content */
        fun content(
            params: ArtifactContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
