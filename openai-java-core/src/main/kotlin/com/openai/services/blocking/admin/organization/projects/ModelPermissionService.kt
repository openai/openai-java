// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionDeleteParams
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionRetrieveParams
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionUpdateParams
import com.openai.models.admin.organization.projects.modelpermissions.ProjectModelPermissions
import com.openai.models.admin.organization.projects.modelpermissions.ProjectModelPermissionsDeleted
import java.util.function.Consumer

interface ModelPermissionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModelPermissionService

    /** Returns model permissions for a project. */
    fun retrieve(projectId: String): ProjectModelPermissions =
        retrieve(projectId, ModelPermissionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectModelPermissions =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
    ): ProjectModelPermissions = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ModelPermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectModelPermissions

    /** @see retrieve */
    fun retrieve(params: ModelPermissionRetrieveParams): ProjectModelPermissions =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): ProjectModelPermissions =
        retrieve(projectId, ModelPermissionRetrieveParams.none(), requestOptions)

    /** Updates model permissions for a project. */
    fun update(projectId: String, params: ModelPermissionUpdateParams): ProjectModelPermissions =
        update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        params: ModelPermissionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectModelPermissions =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(params: ModelPermissionUpdateParams): ProjectModelPermissions =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ModelPermissionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectModelPermissions

    /** Deletes model permissions for a project. */
    fun delete(projectId: String): ProjectModelPermissionsDeleted =
        delete(projectId, ModelPermissionDeleteParams.none())

    /** @see delete */
    fun delete(
        projectId: String,
        params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectModelPermissionsDeleted =
        delete(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see delete */
    fun delete(
        projectId: String,
        params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
    ): ProjectModelPermissionsDeleted = delete(projectId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ModelPermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectModelPermissionsDeleted

    /** @see delete */
    fun delete(params: ModelPermissionDeleteParams): ProjectModelPermissionsDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(projectId: String, requestOptions: RequestOptions): ProjectModelPermissionsDeleted =
        delete(projectId, ModelPermissionDeleteParams.none(), requestOptions)

    /**
     * A view of [ModelPermissionService] that provides access to raw HTTP responses for each
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
        ): ModelPermissionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/model_permissions`, but is otherwise the same as
         * [ModelPermissionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(projectId: String): HttpResponseFor<ProjectModelPermissions> =
            retrieve(projectId, ModelPermissionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectModelPermissions> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
        ): HttpResponseFor<ProjectModelPermissions> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ModelPermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectModelPermissions>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ModelPermissionRetrieveParams
        ): HttpResponseFor<ProjectModelPermissions> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectModelPermissions> =
            retrieve(projectId, ModelPermissionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/model_permissions`, but is otherwise the same as
         * [ModelPermissionService.update].
         */
        @MustBeClosed
        fun update(
            projectId: String,
            params: ModelPermissionUpdateParams,
        ): HttpResponseFor<ProjectModelPermissions> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: ModelPermissionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectModelPermissions> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: ModelPermissionUpdateParams): HttpResponseFor<ProjectModelPermissions> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ModelPermissionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectModelPermissions>

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/model_permissions`, but is otherwise the same as
         * [ModelPermissionService.delete].
         */
        @MustBeClosed
        fun delete(projectId: String): HttpResponseFor<ProjectModelPermissionsDeleted> =
            delete(projectId, ModelPermissionDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            projectId: String,
            params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectModelPermissionsDeleted> =
            delete(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            projectId: String,
            params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
        ): HttpResponseFor<ProjectModelPermissionsDeleted> =
            delete(projectId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ModelPermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectModelPermissionsDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ModelPermissionDeleteParams
        ): HttpResponseFor<ProjectModelPermissionsDeleted> = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectModelPermissionsDeleted> =
            delete(projectId, ModelPermissionDeleteParams.none(), requestOptions)
    }
}
