// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionDeleteParams
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionRetrieveParams
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionUpdateParams
import com.openai.models.admin.organization.projects.modelpermissions.ProjectModelPermissions
import com.openai.models.admin.organization.projects.modelpermissions.ProjectModelPermissionsDeleted
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ModelPermissionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModelPermissionServiceAsync

    /** Returns model permissions for a project. */
    fun retrieve(projectId: String): CompletableFuture<ProjectModelPermissions> =
        retrieve(projectId, ModelPermissionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectModelPermissions> =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
    ): CompletableFuture<ProjectModelPermissions> =
        retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ModelPermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectModelPermissions>

    /** @see retrieve */
    fun retrieve(
        params: ModelPermissionRetrieveParams
    ): CompletableFuture<ProjectModelPermissions> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectModelPermissions> =
        retrieve(projectId, ModelPermissionRetrieveParams.none(), requestOptions)

    /** Updates model permissions for a project. */
    fun update(
        projectId: String,
        params: ModelPermissionUpdateParams,
    ): CompletableFuture<ProjectModelPermissions> = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        params: ModelPermissionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectModelPermissions> =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(params: ModelPermissionUpdateParams): CompletableFuture<ProjectModelPermissions> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ModelPermissionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectModelPermissions>

    /** Deletes model permissions for a project. */
    fun delete(projectId: String): CompletableFuture<ProjectModelPermissionsDeleted> =
        delete(projectId, ModelPermissionDeleteParams.none())

    /** @see delete */
    fun delete(
        projectId: String,
        params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectModelPermissionsDeleted> =
        delete(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see delete */
    fun delete(
        projectId: String,
        params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
    ): CompletableFuture<ProjectModelPermissionsDeleted> =
        delete(projectId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ModelPermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectModelPermissionsDeleted>

    /** @see delete */
    fun delete(
        params: ModelPermissionDeleteParams
    ): CompletableFuture<ProjectModelPermissionsDeleted> = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectModelPermissionsDeleted> =
        delete(projectId, ModelPermissionDeleteParams.none(), requestOptions)

    /**
     * A view of [ModelPermissionServiceAsync] that provides access to raw HTTP responses for each
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
        ): ModelPermissionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/model_permissions`, but is otherwise the same as
         * [ModelPermissionServiceAsync.retrieve].
         */
        fun retrieve(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            retrieve(projectId, ModelPermissionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: ModelPermissionRetrieveParams = ModelPermissionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ModelPermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>>

        /** @see retrieve */
        fun retrieve(
            params: ModelPermissionRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            retrieve(projectId, ModelPermissionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/model_permissions`, but is otherwise the same as
         * [ModelPermissionServiceAsync.update].
         */
        fun update(
            projectId: String,
            params: ModelPermissionUpdateParams,
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        fun update(
            projectId: String,
            params: ModelPermissionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        fun update(
            params: ModelPermissionUpdateParams
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ModelPermissionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>>

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/model_permissions`, but is otherwise the same as
         * [ModelPermissionServiceAsync.delete].
         */
        fun delete(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>> =
            delete(projectId, ModelPermissionDeleteParams.none())

        /** @see delete */
        fun delete(
            projectId: String,
            params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>> =
            delete(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see delete */
        fun delete(
            projectId: String,
            params: ModelPermissionDeleteParams = ModelPermissionDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>> =
            delete(projectId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ModelPermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>>

        /** @see delete */
        fun delete(
            params: ModelPermissionDeleteParams
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>> =
            delete(projectId, ModelPermissionDeleteParams.none(), requestOptions)
    }
}
