// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.Project
import com.openai.models.admin.organization.projects.ProjectArchiveParams
import com.openai.models.admin.organization.projects.ProjectCreateParams
import com.openai.models.admin.organization.projects.ProjectListPage
import com.openai.models.admin.organization.projects.ProjectListParams
import com.openai.models.admin.organization.projects.ProjectRetrieveParams
import com.openai.models.admin.organization.projects.ProjectUpdateParams
import com.openai.services.blocking.admin.organization.projects.ApiKeyService
import com.openai.services.blocking.admin.organization.projects.CertificateService
import com.openai.services.blocking.admin.organization.projects.GroupService
import com.openai.services.blocking.admin.organization.projects.RateLimitService
import com.openai.services.blocking.admin.organization.projects.RoleService
import com.openai.services.blocking.admin.organization.projects.ServiceAccountService
import com.openai.services.blocking.admin.organization.projects.UserService
import java.util.function.Consumer

interface ProjectService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProjectService

    fun users(): UserService

    fun serviceAccounts(): ServiceAccountService

    fun apiKeys(): ApiKeyService

    fun rateLimits(): RateLimitService

    fun groups(): GroupService

    fun roles(): RoleService

    fun certificates(): CertificateService

    /**
     * Create a new project in the organization. Projects can be created and archived, but cannot be
     * deleted.
     */
    fun create(params: ProjectCreateParams): Project = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ProjectCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** Retrieves a project. */
    fun retrieve(projectId: String): Project = retrieve(projectId, ProjectRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project = retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
    ): Project = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ProjectRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** @see retrieve */
    fun retrieve(params: ProjectRetrieveParams): Project = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): Project =
        retrieve(projectId, ProjectRetrieveParams.none(), requestOptions)

    /** Modifies a project in the organization. */
    fun update(projectId: String): Project = update(projectId, ProjectUpdateParams.none())

    /** @see update */
    fun update(
        projectId: String,
        params: ProjectUpdateParams = ProjectUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project = update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(
        projectId: String,
        params: ProjectUpdateParams = ProjectUpdateParams.none(),
    ): Project = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ProjectUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** @see update */
    fun update(params: ProjectUpdateParams): Project = update(params, RequestOptions.none())

    /** @see update */
    fun update(projectId: String, requestOptions: RequestOptions): Project =
        update(projectId, ProjectUpdateParams.none(), requestOptions)

    /** Returns a list of projects. */
    fun list(): ProjectListPage = list(ProjectListParams.none())

    /** @see list */
    fun list(
        params: ProjectListParams = ProjectListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectListPage

    /** @see list */
    fun list(params: ProjectListParams = ProjectListParams.none()): ProjectListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ProjectListPage =
        list(ProjectListParams.none(), requestOptions)

    /** Archives a project in the organization. Archived projects cannot be used or updated. */
    fun archive(projectId: String): Project = archive(projectId, ProjectArchiveParams.none())

    /** @see archive */
    fun archive(
        projectId: String,
        params: ProjectArchiveParams = ProjectArchiveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project = archive(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see archive */
    fun archive(
        projectId: String,
        params: ProjectArchiveParams = ProjectArchiveParams.none(),
    ): Project = archive(projectId, params, RequestOptions.none())

    /** @see archive */
    fun archive(
        params: ProjectArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** @see archive */
    fun archive(params: ProjectArchiveParams): Project = archive(params, RequestOptions.none())

    /** @see archive */
    fun archive(projectId: String, requestOptions: RequestOptions): Project =
        archive(projectId, ProjectArchiveParams.none(), requestOptions)

    /** A view of [ProjectService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProjectService.WithRawResponse

        fun users(): UserService.WithRawResponse

        fun serviceAccounts(): ServiceAccountService.WithRawResponse

        fun apiKeys(): ApiKeyService.WithRawResponse

        fun rateLimits(): RateLimitService.WithRawResponse

        fun groups(): GroupService.WithRawResponse

        fun roles(): RoleService.WithRawResponse

        fun certificates(): CertificateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/projects`, but is otherwise the same
         * as [ProjectService.create].
         */
        @MustBeClosed
        fun create(params: ProjectCreateParams): HttpResponseFor<Project> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ProjectCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}`, but is
         * otherwise the same as [ProjectService.retrieve].
         */
        @MustBeClosed
        fun retrieve(projectId: String): HttpResponseFor<Project> =
            retrieve(projectId, ProjectRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
        ): HttpResponseFor<Project> = retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ProjectRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ProjectRetrieveParams): HttpResponseFor<Project> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(projectId: String, requestOptions: RequestOptions): HttpResponseFor<Project> =
            retrieve(projectId, ProjectRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}`, but is
         * otherwise the same as [ProjectService.update].
         */
        @MustBeClosed
        fun update(projectId: String): HttpResponseFor<Project> =
            update(projectId, ProjectUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: ProjectUpdateParams = ProjectUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: ProjectUpdateParams = ProjectUpdateParams.none(),
        ): HttpResponseFor<Project> = update(projectId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ProjectUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /** @see update */
        @MustBeClosed
        fun update(params: ProjectUpdateParams): HttpResponseFor<Project> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(projectId: String, requestOptions: RequestOptions): HttpResponseFor<Project> =
            update(projectId, ProjectUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/projects`, but is otherwise the same
         * as [ProjectService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<ProjectListPage> = list(ProjectListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ProjectListParams = ProjectListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ProjectListParams = ProjectListParams.none()
        ): HttpResponseFor<ProjectListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ProjectListPage> =
            list(ProjectListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/archive`, but
         * is otherwise the same as [ProjectService.archive].
         */
        @MustBeClosed
        fun archive(projectId: String): HttpResponseFor<Project> =
            archive(projectId, ProjectArchiveParams.none())

        /** @see archive */
        @MustBeClosed
        fun archive(
            projectId: String,
            params: ProjectArchiveParams = ProjectArchiveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project> =
            archive(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see archive */
        @MustBeClosed
        fun archive(
            projectId: String,
            params: ProjectArchiveParams = ProjectArchiveParams.none(),
        ): HttpResponseFor<Project> = archive(projectId, params, RequestOptions.none())

        /** @see archive */
        @MustBeClosed
        fun archive(
            params: ProjectArchiveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /** @see archive */
        @MustBeClosed
        fun archive(params: ProjectArchiveParams): HttpResponseFor<Project> =
            archive(params, RequestOptions.none())

        /** @see archive */
        @MustBeClosed
        fun archive(projectId: String, requestOptions: RequestOptions): HttpResponseFor<Project> =
            archive(projectId, ProjectArchiveParams.none(), requestOptions)
    }
}
