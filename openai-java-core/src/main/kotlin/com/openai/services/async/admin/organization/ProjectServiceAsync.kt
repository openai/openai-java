// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.Project
import com.openai.models.admin.organization.projects.ProjectArchiveParams
import com.openai.models.admin.organization.projects.ProjectCreateParams
import com.openai.models.admin.organization.projects.ProjectListPageAsync
import com.openai.models.admin.organization.projects.ProjectListParams
import com.openai.models.admin.organization.projects.ProjectRetrieveParams
import com.openai.models.admin.organization.projects.ProjectUpdateParams
import com.openai.services.async.admin.organization.projects.ApiKeyServiceAsync
import com.openai.services.async.admin.organization.projects.CertificateServiceAsync
import com.openai.services.async.admin.organization.projects.GroupServiceAsync
import com.openai.services.async.admin.organization.projects.RateLimitServiceAsync
import com.openai.services.async.admin.organization.projects.RoleServiceAsync
import com.openai.services.async.admin.organization.projects.ServiceAccountServiceAsync
import com.openai.services.async.admin.organization.projects.UserServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ProjectServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProjectServiceAsync

    fun users(): UserServiceAsync

    fun serviceAccounts(): ServiceAccountServiceAsync

    fun apiKeys(): ApiKeyServiceAsync

    fun rateLimits(): RateLimitServiceAsync

    fun groups(): GroupServiceAsync

    fun roles(): RoleServiceAsync

    fun certificates(): CertificateServiceAsync

    /**
     * Create a new project in the organization. Projects can be created and archived, but cannot be
     * deleted.
     */
    fun create(params: ProjectCreateParams): CompletableFuture<Project> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ProjectCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project>

    /** Retrieves a project. */
    fun retrieve(projectId: String): CompletableFuture<Project> =
        retrieve(projectId, ProjectRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project> =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
    ): CompletableFuture<Project> = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ProjectRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project>

    /** @see retrieve */
    fun retrieve(params: ProjectRetrieveParams): CompletableFuture<Project> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): CompletableFuture<Project> =
        retrieve(projectId, ProjectRetrieveParams.none(), requestOptions)

    /** Modifies a project in the organization. */
    fun update(projectId: String): CompletableFuture<Project> =
        update(projectId, ProjectUpdateParams.none())

    /** @see update */
    fun update(
        projectId: String,
        params: ProjectUpdateParams = ProjectUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project> =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(
        projectId: String,
        params: ProjectUpdateParams = ProjectUpdateParams.none(),
    ): CompletableFuture<Project> = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ProjectUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project>

    /** @see update */
    fun update(params: ProjectUpdateParams): CompletableFuture<Project> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(projectId: String, requestOptions: RequestOptions): CompletableFuture<Project> =
        update(projectId, ProjectUpdateParams.none(), requestOptions)

    /** Returns a list of projects. */
    fun list(): CompletableFuture<ProjectListPageAsync> = list(ProjectListParams.none())

    /** @see list */
    fun list(
        params: ProjectListParams = ProjectListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectListPageAsync>

    /** @see list */
    fun list(
        params: ProjectListParams = ProjectListParams.none()
    ): CompletableFuture<ProjectListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ProjectListPageAsync> =
        list(ProjectListParams.none(), requestOptions)

    /** Archives a project in the organization. Archived projects cannot be used or updated. */
    fun archive(projectId: String): CompletableFuture<Project> =
        archive(projectId, ProjectArchiveParams.none())

    /** @see archive */
    fun archive(
        projectId: String,
        params: ProjectArchiveParams = ProjectArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project> =
        archive(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see archive */
    fun archive(
        projectId: String,
        params: ProjectArchiveParams = ProjectArchiveParams.none(),
    ): CompletableFuture<Project> = archive(projectId, params, RequestOptions.none())

    /** @see archive */
    fun archive(
        params: ProjectArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Project>

    /** @see archive */
    fun archive(params: ProjectArchiveParams): CompletableFuture<Project> =
        archive(params, RequestOptions.none())

    /** @see archive */
    fun archive(projectId: String, requestOptions: RequestOptions): CompletableFuture<Project> =
        archive(projectId, ProjectArchiveParams.none(), requestOptions)

    /**
     * A view of [ProjectServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProjectServiceAsync.WithRawResponse

        fun users(): UserServiceAsync.WithRawResponse

        fun serviceAccounts(): ServiceAccountServiceAsync.WithRawResponse

        fun apiKeys(): ApiKeyServiceAsync.WithRawResponse

        fun rateLimits(): RateLimitServiceAsync.WithRawResponse

        fun groups(): GroupServiceAsync.WithRawResponse

        fun roles(): RoleServiceAsync.WithRawResponse

        fun certificates(): CertificateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/projects`, but is otherwise the same
         * as [ProjectServiceAsync.create].
         */
        fun create(params: ProjectCreateParams): CompletableFuture<HttpResponseFor<Project>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ProjectCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}`, but is
         * otherwise the same as [ProjectServiceAsync.retrieve].
         */
        fun retrieve(projectId: String): CompletableFuture<HttpResponseFor<Project>> =
            retrieve(projectId, ProjectRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Project>> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ProjectRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>>

        /** @see retrieve */
        fun retrieve(params: ProjectRetrieveParams): CompletableFuture<HttpResponseFor<Project>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> =
            retrieve(projectId, ProjectRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}`, but is
         * otherwise the same as [ProjectServiceAsync.update].
         */
        fun update(projectId: String): CompletableFuture<HttpResponseFor<Project>> =
            update(projectId, ProjectUpdateParams.none())

        /** @see update */
        fun update(
            projectId: String,
            params: ProjectUpdateParams = ProjectUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        fun update(
            projectId: String,
            params: ProjectUpdateParams = ProjectUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Project>> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ProjectUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>>

        /** @see update */
        fun update(params: ProjectUpdateParams): CompletableFuture<HttpResponseFor<Project>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> =
            update(projectId, ProjectUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/projects`, but is otherwise the same
         * as [ProjectServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ProjectListPageAsync>> =
            list(ProjectListParams.none())

        /** @see list */
        fun list(
            params: ProjectListParams = ProjectListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectListPageAsync>>

        /** @see list */
        fun list(
            params: ProjectListParams = ProjectListParams.none()
        ): CompletableFuture<HttpResponseFor<ProjectListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ProjectListPageAsync>> =
            list(ProjectListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/archive`, but
         * is otherwise the same as [ProjectServiceAsync.archive].
         */
        fun archive(projectId: String): CompletableFuture<HttpResponseFor<Project>> =
            archive(projectId, ProjectArchiveParams.none())

        /** @see archive */
        fun archive(
            projectId: String,
            params: ProjectArchiveParams = ProjectArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>> =
            archive(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see archive */
        fun archive(
            projectId: String,
            params: ProjectArchiveParams = ProjectArchiveParams.none(),
        ): CompletableFuture<HttpResponseFor<Project>> =
            archive(projectId, params, RequestOptions.none())

        /** @see archive */
        fun archive(
            params: ProjectArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Project>>

        /** @see archive */
        fun archive(params: ProjectArchiveParams): CompletableFuture<HttpResponseFor<Project>> =
            archive(params, RequestOptions.none())

        /** @see archive */
        fun archive(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> =
            archive(projectId, ProjectArchiveParams.none(), requestOptions)
    }
}
