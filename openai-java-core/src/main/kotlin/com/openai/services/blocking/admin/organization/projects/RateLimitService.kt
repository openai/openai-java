// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.ratelimits.ProjectRateLimit
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsPage
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsParams
import com.openai.models.admin.organization.projects.ratelimits.RateLimitUpdateRateLimitParams
import java.util.function.Consumer

interface RateLimitService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateLimitService

    /** Returns the rate limits per model for a project. */
    fun listRateLimits(projectId: String): RateLimitListRateLimitsPage =
        listRateLimits(projectId, RateLimitListRateLimitsParams.none())

    /** @see listRateLimits */
    fun listRateLimits(
        projectId: String,
        params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RateLimitListRateLimitsPage =
        listRateLimits(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see listRateLimits */
    fun listRateLimits(
        projectId: String,
        params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
    ): RateLimitListRateLimitsPage = listRateLimits(projectId, params, RequestOptions.none())

    /** @see listRateLimits */
    fun listRateLimits(
        params: RateLimitListRateLimitsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RateLimitListRateLimitsPage

    /** @see listRateLimits */
    fun listRateLimits(params: RateLimitListRateLimitsParams): RateLimitListRateLimitsPage =
        listRateLimits(params, RequestOptions.none())

    /** @see listRateLimits */
    fun listRateLimits(
        projectId: String,
        requestOptions: RequestOptions,
    ): RateLimitListRateLimitsPage =
        listRateLimits(projectId, RateLimitListRateLimitsParams.none(), requestOptions)

    /** Updates a project rate limit. */
    fun updateRateLimit(
        rateLimitId: String,
        params: RateLimitUpdateRateLimitParams,
    ): ProjectRateLimit = updateRateLimit(rateLimitId, params, RequestOptions.none())

    /** @see updateRateLimit */
    fun updateRateLimit(
        rateLimitId: String,
        params: RateLimitUpdateRateLimitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectRateLimit =
        updateRateLimit(params.toBuilder().rateLimitId(rateLimitId).build(), requestOptions)

    /** @see updateRateLimit */
    fun updateRateLimit(params: RateLimitUpdateRateLimitParams): ProjectRateLimit =
        updateRateLimit(params, RequestOptions.none())

    /** @see updateRateLimit */
    fun updateRateLimit(
        params: RateLimitUpdateRateLimitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectRateLimit

    /** A view of [RateLimitService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateLimitService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/rate_limits`,
         * but is otherwise the same as [RateLimitService.listRateLimits].
         */
        @MustBeClosed
        fun listRateLimits(projectId: String): HttpResponseFor<RateLimitListRateLimitsPage> =
            listRateLimits(projectId, RateLimitListRateLimitsParams.none())

        /** @see listRateLimits */
        @MustBeClosed
        fun listRateLimits(
            projectId: String,
            params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RateLimitListRateLimitsPage> =
            listRateLimits(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see listRateLimits */
        @MustBeClosed
        fun listRateLimits(
            projectId: String,
            params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
        ): HttpResponseFor<RateLimitListRateLimitsPage> =
            listRateLimits(projectId, params, RequestOptions.none())

        /** @see listRateLimits */
        @MustBeClosed
        fun listRateLimits(
            params: RateLimitListRateLimitsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RateLimitListRateLimitsPage>

        /** @see listRateLimits */
        @MustBeClosed
        fun listRateLimits(
            params: RateLimitListRateLimitsParams
        ): HttpResponseFor<RateLimitListRateLimitsPage> =
            listRateLimits(params, RequestOptions.none())

        /** @see listRateLimits */
        @MustBeClosed
        fun listRateLimits(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RateLimitListRateLimitsPage> =
            listRateLimits(projectId, RateLimitListRateLimitsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/rate_limits/{rate_limit_id}`, but is otherwise the
         * same as [RateLimitService.updateRateLimit].
         */
        @MustBeClosed
        fun updateRateLimit(
            rateLimitId: String,
            params: RateLimitUpdateRateLimitParams,
        ): HttpResponseFor<ProjectRateLimit> =
            updateRateLimit(rateLimitId, params, RequestOptions.none())

        /** @see updateRateLimit */
        @MustBeClosed
        fun updateRateLimit(
            rateLimitId: String,
            params: RateLimitUpdateRateLimitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectRateLimit> =
            updateRateLimit(params.toBuilder().rateLimitId(rateLimitId).build(), requestOptions)

        /** @see updateRateLimit */
        @MustBeClosed
        fun updateRateLimit(
            params: RateLimitUpdateRateLimitParams
        ): HttpResponseFor<ProjectRateLimit> = updateRateLimit(params, RequestOptions.none())

        /** @see updateRateLimit */
        @MustBeClosed
        fun updateRateLimit(
            params: RateLimitUpdateRateLimitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectRateLimit>
    }
}
