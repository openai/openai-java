// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.environments.EnvironmentInfo
import com.openai.models.beta.agents.environments.EnvironmentRetrieveParams
import com.openai.services.async.beta.agents.environments.FileServiceAsync
import com.openai.services.async.beta.agents.environments.TemplateServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EnvironmentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EnvironmentServiceAsync

    fun files(): FileServiceAsync

    fun templates(): TemplateServiceAsync

    /**
     * Retrieves an execution environment's connection status and safe installed metadata. See
     * [environment lifecycle](https://developers.openai.com/api/docs/guides/agents-api/environments/lifecycle).
     */
    fun retrieve(environmentId: String): CompletableFuture<EnvironmentInfo> =
        retrieve(environmentId, EnvironmentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        environmentId: String,
        params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentInfo> =
        retrieve(params.toBuilder().environmentId(environmentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        environmentId: String,
        params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
    ): CompletableFuture<EnvironmentInfo> = retrieve(environmentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EnvironmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentInfo>

    /** @see retrieve */
    fun retrieve(params: EnvironmentRetrieveParams): CompletableFuture<EnvironmentInfo> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        environmentId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EnvironmentInfo> =
        retrieve(environmentId, EnvironmentRetrieveParams.none(), requestOptions)

    /**
     * A view of [EnvironmentServiceAsync] that provides access to raw HTTP responses for each
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
        ): EnvironmentServiceAsync.WithRawResponse

        fun files(): FileServiceAsync.WithRawResponse

        fun templates(): TemplateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /agents/environments/{environment_id}`, but is
         * otherwise the same as [EnvironmentServiceAsync.retrieve].
         */
        fun retrieve(environmentId: String): CompletableFuture<HttpResponseFor<EnvironmentInfo>> =
            retrieve(environmentId, EnvironmentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            environmentId: String,
            params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentInfo>> =
            retrieve(params.toBuilder().environmentId(environmentId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            environmentId: String,
            params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentInfo>> =
            retrieve(environmentId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: EnvironmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentInfo>>

        /** @see retrieve */
        fun retrieve(
            params: EnvironmentRetrieveParams
        ): CompletableFuture<HttpResponseFor<EnvironmentInfo>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            environmentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EnvironmentInfo>> =
            retrieve(environmentId, EnvironmentRetrieveParams.none(), requestOptions)
    }
}
