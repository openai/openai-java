// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.environments

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.environments.files.EnvironmentFile
import com.openai.models.beta.agents.environments.files.FileCreateParams
import com.openai.models.beta.agents.environments.files.FileListPageAsync
import com.openai.models.beta.agents.environments.files.FileListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync

    /**
     * Copies inline bytes or a Files API file into a connected execution environment. See
     * [environment files](https://developers.openai.com/api/docs/guides/agents-api/environments/files).
     */
    fun create(environmentId: String): CompletableFuture<EnvironmentFile> =
        create(environmentId, FileCreateParams.none())

    /** @see create */
    fun create(
        environmentId: String,
        params: FileCreateParams = FileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentFile> =
        create(params.toBuilder().environmentId(environmentId).build(), requestOptions)

    /** @see create */
    fun create(
        environmentId: String,
        params: FileCreateParams = FileCreateParams.none(),
    ): CompletableFuture<EnvironmentFile> = create(environmentId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentFile>

    /** @see create */
    fun create(params: FileCreateParams): CompletableFuture<EnvironmentFile> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        environmentId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EnvironmentFile> =
        create(environmentId, FileCreateParams.none(), requestOptions)

    /**
     * Lists live files on a connected execution environment with optional directory filtering and
     * opaque cursor pagination. See
     * [environment files](https://developers.openai.com/api/docs/guides/agents-api/environments/files).
     */
    fun list(environmentId: String): CompletableFuture<FileListPageAsync> =
        list(environmentId, FileListParams.none())

    /** @see list */
    fun list(
        environmentId: String,
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync> =
        list(params.toBuilder().environmentId(environmentId).build(), requestOptions)

    /** @see list */
    fun list(
        environmentId: String,
        params: FileListParams = FileListParams.none(),
    ): CompletableFuture<FileListPageAsync> = list(environmentId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync>

    /** @see list */
    fun list(params: FileListParams): CompletableFuture<FileListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        environmentId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileListPageAsync> =
        list(environmentId, FileListParams.none(), requestOptions)

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/environments/{environment_id}/files`, but
         * is otherwise the same as [FileServiceAsync.create].
         */
        fun create(environmentId: String): CompletableFuture<HttpResponseFor<EnvironmentFile>> =
            create(environmentId, FileCreateParams.none())

        /** @see create */
        fun create(
            environmentId: String,
            params: FileCreateParams = FileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentFile>> =
            create(params.toBuilder().environmentId(environmentId).build(), requestOptions)

        /** @see create */
        fun create(
            environmentId: String,
            params: FileCreateParams = FileCreateParams.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentFile>> =
            create(environmentId, params, RequestOptions.none())

        /** @see create */
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentFile>>

        /** @see create */
        fun create(params: FileCreateParams): CompletableFuture<HttpResponseFor<EnvironmentFile>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            environmentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EnvironmentFile>> =
            create(environmentId, FileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/environments/{environment_id}/files`, but is
         * otherwise the same as [FileServiceAsync.list].
         */
        fun list(environmentId: String): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(environmentId, FileListParams.none())

        /** @see list */
        fun list(
            environmentId: String,
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params.toBuilder().environmentId(environmentId).build(), requestOptions)

        /** @see list */
        fun list(
            environmentId: String,
            params: FileListParams = FileListParams.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(environmentId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: FileListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>>

        /** @see list */
        fun list(params: FileListParams): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            environmentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(environmentId, FileListParams.none(), requestOptions)
    }
}
