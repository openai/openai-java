// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.servicetiersettings.ProjectServiceTierSettings
import com.openai.models.admin.organization.projects.servicetiersettings.ServiceTierSettingRetrieveParams
import com.openai.models.admin.organization.projects.servicetiersettings.ServiceTierSettingUpdateParams
import java.util.function.Consumer

interface ServiceTierSettingService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ServiceTierSettingService

    /** Retrieve the configured default and enabled service tiers for a project. */
    fun retrieve(projectId: String): ProjectServiceTierSettings =
        retrieve(projectId, ServiceTierSettingRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectServiceTierSettings =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
    ): ProjectServiceTierSettings = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ServiceTierSettingRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectServiceTierSettings

    /** @see retrieve */
    fun retrieve(params: ServiceTierSettingRetrieveParams): ProjectServiceTierSettings =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): ProjectServiceTierSettings =
        retrieve(projectId, ServiceTierSettingRetrieveParams.none(), requestOptions)

    /**
     * Update the default or enabled service tiers atomically. Supply at least one field. Omitted
     * fields keep their current values.
     */
    fun update(projectId: String): ProjectServiceTierSettings =
        update(projectId, ServiceTierSettingUpdateParams.none())

    /** @see update */
    fun update(
        projectId: String,
        params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectServiceTierSettings =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(
        projectId: String,
        params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
    ): ProjectServiceTierSettings = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ServiceTierSettingUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectServiceTierSettings

    /** @see update */
    fun update(params: ServiceTierSettingUpdateParams): ProjectServiceTierSettings =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(projectId: String, requestOptions: RequestOptions): ProjectServiceTierSettings =
        update(projectId, ServiceTierSettingUpdateParams.none(), requestOptions)

    /**
     * A view of [ServiceTierSettingService] that provides access to raw HTTP responses for each
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
        ): ServiceTierSettingService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/service_tier_settings`, but is otherwise the same as
         * [ServiceTierSettingService.retrieve].
         */
        @MustBeClosed
        fun retrieve(projectId: String): HttpResponseFor<ProjectServiceTierSettings> =
            retrieve(projectId, ServiceTierSettingRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectServiceTierSettings> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: ServiceTierSettingRetrieveParams = ServiceTierSettingRetrieveParams.none(),
        ): HttpResponseFor<ProjectServiceTierSettings> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ServiceTierSettingRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectServiceTierSettings>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ServiceTierSettingRetrieveParams
        ): HttpResponseFor<ProjectServiceTierSettings> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectServiceTierSettings> =
            retrieve(projectId, ServiceTierSettingRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/service_tier_settings`, but is otherwise the same as
         * [ServiceTierSettingService.update].
         */
        @MustBeClosed
        fun update(projectId: String): HttpResponseFor<ProjectServiceTierSettings> =
            update(projectId, ServiceTierSettingUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectServiceTierSettings> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: ServiceTierSettingUpdateParams = ServiceTierSettingUpdateParams.none(),
        ): HttpResponseFor<ProjectServiceTierSettings> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ServiceTierSettingUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectServiceTierSettings>

        /** @see update */
        @MustBeClosed
        fun update(
            params: ServiceTierSettingUpdateParams
        ): HttpResponseFor<ProjectServiceTierSettings> = update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectServiceTierSettings> =
            update(projectId, ServiceTierSettingUpdateParams.none(), requestOptions)
    }
}
