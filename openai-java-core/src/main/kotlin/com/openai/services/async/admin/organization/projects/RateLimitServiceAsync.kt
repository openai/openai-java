// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.ratelimits.ProjectRateLimit
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsPageAsync
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsParams
import com.openai.models.admin.organization.projects.ratelimits.RateLimitUpdateRateLimitParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface RateLimitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateLimitServiceAsync

    /** Returns the rate limits per model for a project. */
    fun listRateLimits(projectId: String): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        listRateLimits(projectId, RateLimitListRateLimitsParams.none())

    /** @see listRateLimits */
    fun listRateLimits(
        projectId: String,
        params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        listRateLimits(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see listRateLimits */
    fun listRateLimits(
        projectId: String,
        params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
    ): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        listRateLimits(projectId, params, RequestOptions.none())

    /** @see listRateLimits */
    fun listRateLimits(
        params: RateLimitListRateLimitsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RateLimitListRateLimitsPageAsync>

    /** @see listRateLimits */
    fun listRateLimits(
        params: RateLimitListRateLimitsParams
    ): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        listRateLimits(params, RequestOptions.none())

    /** @see listRateLimits */
    fun listRateLimits(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        listRateLimits(projectId, RateLimitListRateLimitsParams.none(), requestOptions)

    /** Updates a project rate limit. */
    fun updateRateLimit(
        rateLimitId: String,
        params: RateLimitUpdateRateLimitParams,
    ): CompletableFuture<ProjectRateLimit> =
        updateRateLimit(rateLimitId, params, RequestOptions.none())

    /** @see updateRateLimit */
    fun updateRateLimit(
        rateLimitId: String,
        params: RateLimitUpdateRateLimitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectRateLimit> =
        updateRateLimit(params.toBuilder().rateLimitId(rateLimitId).build(), requestOptions)

    /** @see updateRateLimit */
    fun updateRateLimit(
        params: RateLimitUpdateRateLimitParams
    ): CompletableFuture<ProjectRateLimit> = updateRateLimit(params, RequestOptions.none())

    /** @see updateRateLimit */
    fun updateRateLimit(
        params: RateLimitUpdateRateLimitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectRateLimit>

    /**
     * A view of [RateLimitServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RateLimitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/rate_limits`,
         * but is otherwise the same as [RateLimitServiceAsync.listRateLimits].
         */
        fun listRateLimits(
            projectId: String
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>> =
            listRateLimits(projectId, RateLimitListRateLimitsParams.none())

        /** @see listRateLimits */
        fun listRateLimits(
            projectId: String,
            params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>> =
            listRateLimits(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see listRateLimits */
        fun listRateLimits(
            projectId: String,
            params: RateLimitListRateLimitsParams = RateLimitListRateLimitsParams.none(),
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>> =
            listRateLimits(projectId, params, RequestOptions.none())

        /** @see listRateLimits */
        fun listRateLimits(
            params: RateLimitListRateLimitsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>>

        /** @see listRateLimits */
        fun listRateLimits(
            params: RateLimitListRateLimitsParams
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>> =
            listRateLimits(params, RequestOptions.none())

        /** @see listRateLimits */
        fun listRateLimits(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>> =
            listRateLimits(projectId, RateLimitListRateLimitsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/rate_limits/{rate_limit_id}`, but is otherwise the
         * same as [RateLimitServiceAsync.updateRateLimit].
         */
        fun updateRateLimit(
            rateLimitId: String,
            params: RateLimitUpdateRateLimitParams,
        ): CompletableFuture<HttpResponseFor<ProjectRateLimit>> =
            updateRateLimit(rateLimitId, params, RequestOptions.none())

        /** @see updateRateLimit */
        fun updateRateLimit(
            rateLimitId: String,
            params: RateLimitUpdateRateLimitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectRateLimit>> =
            updateRateLimit(params.toBuilder().rateLimitId(rateLimitId).build(), requestOptions)

        /** @see updateRateLimit */
        fun updateRateLimit(
            params: RateLimitUpdateRateLimitParams
        ): CompletableFuture<HttpResponseFor<ProjectRateLimit>> =
            updateRateLimit(params, RequestOptions.none())

        /** @see updateRateLimit */
        fun updateRateLimit(
            params: RateLimitUpdateRateLimitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectRateLimit>>
    }
}
