// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.environments

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.environments.files.EnvironmentFile
import com.openai.models.beta.agents.environments.files.FileCreateParams
import com.openai.models.beta.agents.environments.files.FileListPage
import com.openai.models.beta.agents.environments.files.FileListParams
import java.util.function.Consumer

interface FileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService

    /**
     * Copies inline bytes or a Files API file into a connected execution environment. See
     * [environment files](https://developers.openai.com/api/docs/guides/agents-api/environments/files).
     */
    fun create(environmentId: String): EnvironmentFile =
        create(environmentId, FileCreateParams.none())

    /** @see create */
    fun create(
        environmentId: String,
        params: FileCreateParams = FileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentFile =
        create(params.toBuilder().environmentId(environmentId).build(), requestOptions)

    /** @see create */
    fun create(
        environmentId: String,
        params: FileCreateParams = FileCreateParams.none(),
    ): EnvironmentFile = create(environmentId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentFile

    /** @see create */
    fun create(params: FileCreateParams): EnvironmentFile = create(params, RequestOptions.none())

    /** @see create */
    fun create(environmentId: String, requestOptions: RequestOptions): EnvironmentFile =
        create(environmentId, FileCreateParams.none(), requestOptions)

    /**
     * Lists live files on a connected execution environment with optional directory filtering and
     * opaque cursor pagination. See
     * [environment files](https://developers.openai.com/api/docs/guides/agents-api/environments/files).
     */
    fun list(environmentId: String): FileListPage = list(environmentId, FileListParams.none())

    /** @see list */
    fun list(
        environmentId: String,
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage = list(params.toBuilder().environmentId(environmentId).build(), requestOptions)

    /** @see list */
    fun list(environmentId: String, params: FileListParams = FileListParams.none()): FileListPage =
        list(environmentId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /** @see list */
    fun list(params: FileListParams): FileListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(environmentId: String, requestOptions: RequestOptions): FileListPage =
        list(environmentId, FileListParams.none(), requestOptions)

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/environments/{environment_id}/files`, but
         * is otherwise the same as [FileService.create].
         */
        @MustBeClosed
        fun create(environmentId: String): HttpResponseFor<EnvironmentFile> =
            create(environmentId, FileCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            environmentId: String,
            params: FileCreateParams = FileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentFile> =
            create(params.toBuilder().environmentId(environmentId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            environmentId: String,
            params: FileCreateParams = FileCreateParams.none(),
        ): HttpResponseFor<EnvironmentFile> = create(environmentId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentFile>

        /** @see create */
        @MustBeClosed
        fun create(params: FileCreateParams): HttpResponseFor<EnvironmentFile> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            environmentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentFile> =
            create(environmentId, FileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/environments/{environment_id}/files`, but is
         * otherwise the same as [FileService.list].
         */
        @MustBeClosed
        fun list(environmentId: String): HttpResponseFor<FileListPage> =
            list(environmentId, FileListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            environmentId: String,
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage> =
            list(params.toBuilder().environmentId(environmentId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            environmentId: String,
            params: FileListParams = FileListParams.none(),
        ): HttpResponseFor<FileListPage> = list(environmentId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: FileListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: FileListParams): HttpResponseFor<FileListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            environmentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileListPage> =
            list(environmentId, FileListParams.none(), requestOptions)
    }
}
