// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.servicetiersettings.ProjectServiceTierSettings
import com.openai.models.admin.organization.projects.servicetiersettings.ServiceTierSettingRetrieveParams
import com.openai.models.admin.organization.projects.servicetiersettings.ServiceTierSettingUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ServiceTierSettingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ServiceTierSettingServiceAsync

    /** Retrieve the configured default and enabled service tiers for a project. */
    fun retrieve(projectId: String): CompletableFuture<ProjectServiceTierSettings> =
        retrieve(projectId, ServiceTierSettingRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectServiceTierSettings> =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
    ): CompletableFuture<ProjectServiceTierSettings> =
        retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ServiceTierSettingRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectServiceTierSettings>

    /** @see retrieve */
    fun retrieve(
        params: ServiceTierSettingRetrieveParams
    ): CompletableFuture<ProjectServiceTierSettings> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectServiceTierSettings> =
        retrieve(projectId, ServiceTierSettingRetrieveParams.none(), requestOptions)

    /**
     * Update the default or enabled service tiers atomically. Supply at least one field. Omitted
     * fields keep their current values.
     */
    fun update(projectId: String): CompletableFuture<ProjectServiceTierSettings> =
        update(projectId, ServiceTierSettingUpdateParams.none())

    /** @see update */
    fun update(
        projectId: String,
        params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectServiceTierSettings> =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(
        projectId: String,
        params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
    ): CompletableFuture<ProjectServiceTierSettings> =
        update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ServiceTierSettingUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectServiceTierSettings>

    /** @see update */
    fun update(
        params: ServiceTierSettingUpdateParams
    ): CompletableFuture<ProjectServiceTierSettings> = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectServiceTierSettings> =
        update(projectId, ServiceTierSettingUpdateParams.none(), requestOptions)

    /**
     * A view of [ServiceTierSettingServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ServiceTierSettingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/service_tier_settings`, but is otherwise the same as
         * [ServiceTierSettingServiceAsync.retrieve].
         */
        fun retrieve(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            retrieve(projectId, ServiceTierSettingRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ServiceTierSettingRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>>

        /** @see retrieve */
        fun retrieve(
            params: ServiceTierSettingRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            retrieve(projectId, ServiceTierSettingRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/service_tier_settings`, but is otherwise the same as
         * [ServiceTierSettingServiceAsync.update].
         */
        fun update(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            update(projectId, ServiceTierSettingUpdateParams.none())

        /** @see update */
        fun update(
            projectId: String,
            params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        fun update(
            projectId: String,
            params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ServiceTierSettingUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>>

        /** @see update */
        fun update(
            params: ServiceTierSettingUpdateParams
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectServiceTierSettings>> =
            update(projectId, ServiceTierSettingUpdateParams.none(), requestOptions)
    }
}
