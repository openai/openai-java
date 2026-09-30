// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.sessions.artifacts.ArtifactContentParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactDeleteParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListPage
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactRetrieveParams
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifact
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifactDeleted
import java.util.function.Consumer

interface ArtifactService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ArtifactService

    /**
     * Retrieves immutable metadata for one durable session artifact. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun retrieve(artifactId: String, params: ArtifactRetrieveParams): SessionArtifact =
        retrieve(artifactId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        artifactId: String,
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionArtifact = retrieve(params.toBuilder().artifactId(artifactId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ArtifactRetrieveParams): SessionArtifact =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionArtifact

    /**
     * Lists immutable artifacts published by completed hosted session turns. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun list(sessionId: String): ArtifactListPage = list(sessionId, ArtifactListParams.none())

    /** @see list */
    fun list(
        sessionId: String,
        params: ArtifactListParams = ArtifactListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ArtifactListPage = list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see list */
    fun list(
        sessionId: String,
        params: ArtifactListParams = ArtifactListParams.none(),
    ): ArtifactListPage = list(sessionId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ArtifactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ArtifactListPage

    /** @see list */
    fun list(params: ArtifactListParams): ArtifactListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(sessionId: String, requestOptions: RequestOptions): ArtifactListPage =
        list(sessionId, ArtifactListParams.none(), requestOptions)

    /**
     * Deletes an immutable session artifact without deleting its live environment file or original
     * Files API object. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    fun delete(artifactId: String, params: ArtifactDeleteParams): SessionArtifactDeleted =
        delete(artifactId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        artifactId: String,
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionArtifactDeleted =
        delete(params.toBuilder().artifactId(artifactId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ArtifactDeleteParams): SessionArtifactDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionArtifactDeleted

    /**
     * Downloads immutable session artifact bytes after the execution environment expires. See
     * [session artifacts](https://developers.openai.com/api/docs/guides/agents-api/environments/files#openai-hosted-artifacts).
     */
    @MustBeClosed
    fun content(artifactId: String, params: ArtifactContentParams): HttpResponse =
        content(artifactId, params, RequestOptions.none())

    /** @see content */
    @MustBeClosed
    fun content(
        artifactId: String,
        params: ArtifactContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = content(params.toBuilder().artifactId(artifactId).build(), requestOptions)

    /** @see content */
    @MustBeClosed
    fun content(params: ArtifactContentParams): HttpResponse =
        content(params, RequestOptions.none())

    /** @see content */
    @MustBeClosed
    fun content(
        params: ArtifactContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** A view of [ArtifactService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ArtifactService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/artifacts/{artifact_id}`, but is otherwise the same as
         * [ArtifactService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            artifactId: String,
            params: ArtifactRetrieveParams,
        ): HttpResponseFor<SessionArtifact> = retrieve(artifactId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            artifactId: String,
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionArtifact> =
            retrieve(params.toBuilder().artifactId(artifactId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ArtifactRetrieveParams): HttpResponseFor<SessionArtifact> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionArtifact>

        /**
         * Returns a raw HTTP response for `get /agents/sessions/{session_id}/artifacts`, but is
         * otherwise the same as [ArtifactService.list].
         */
        @MustBeClosed
        fun list(sessionId: String): HttpResponseFor<ArtifactListPage> =
            list(sessionId, ArtifactListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: ArtifactListParams = ArtifactListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ArtifactListPage> =
            list(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            params: ArtifactListParams = ArtifactListParams.none(),
        ): HttpResponseFor<ArtifactListPage> = list(sessionId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ArtifactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ArtifactListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ArtifactListParams): HttpResponseFor<ArtifactListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            sessionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ArtifactListPage> =
            list(sessionId, ArtifactListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /agents/sessions/{session_id}/artifacts/{artifact_id}`, but is otherwise the same as
         * [ArtifactService.delete].
         */
        @MustBeClosed
        fun delete(
            artifactId: String,
            params: ArtifactDeleteParams,
        ): HttpResponseFor<SessionArtifactDeleted> =
            delete(artifactId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            artifactId: String,
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionArtifactDeleted> =
            delete(params.toBuilder().artifactId(artifactId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: ArtifactDeleteParams): HttpResponseFor<SessionArtifactDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionArtifactDeleted>

        /**
         * Returns a raw HTTP response for `get
         * /agents/sessions/{session_id}/artifacts/{artifact_id}/content`, but is otherwise the same
         * as [ArtifactService.content].
         */
        @MustBeClosed
        fun content(artifactId: String, params: ArtifactContentParams): HttpResponse =
            content(artifactId, params, RequestOptions.none())

        /** @see content */
        @MustBeClosed
        fun content(
            artifactId: String,
            params: ArtifactContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = content(params.toBuilder().artifactId(artifactId).build(), requestOptions)

        /** @see content */
        @MustBeClosed
        fun content(params: ArtifactContentParams): HttpResponse =
            content(params, RequestOptions.none())

        /** @see content */
        @MustBeClosed
        fun content(
            params: ArtifactContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
