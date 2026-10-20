// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.environments.EnvironmentCreateParams
import com.openai.models.beta.agents.environments.EnvironmentInfo
import com.openai.models.beta.agents.environments.EnvironmentListPage
import com.openai.models.beta.agents.environments.EnvironmentListParams
import com.openai.models.beta.agents.environments.EnvironmentRetrieveParams
import com.openai.services.blocking.beta.agents.environments.FileService
import com.openai.services.blocking.beta.agents.environments.TemplateService
import java.util.function.Consumer

interface EnvironmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EnvironmentService

    fun files(): FileService

    fun templates(): TemplateService

    /**
     * Creates an OpenAI-hosted environment before creating a session. Requires access to the
     * prewarming beta.
     */
    fun create(params: EnvironmentCreateParams): EnvironmentInfo =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EnvironmentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentInfo

    /**
     * Retrieves an execution environment's connection status and safe installed metadata. See
     * [environment lifecycle](https://developers.openai.com/api/docs/guides/agents-api/environments/lifecycle).
     */
    fun retrieve(environmentId: String): EnvironmentInfo =
        retrieve(environmentId, EnvironmentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        environmentId: String,
        params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentInfo =
        retrieve(params.toBuilder().environmentId(environmentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        environmentId: String,
        params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
    ): EnvironmentInfo = retrieve(environmentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EnvironmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentInfo

    /** @see retrieve */
    fun retrieve(params: EnvironmentRetrieveParams): EnvironmentInfo =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(environmentId: String, requestOptions: RequestOptions): EnvironmentInfo =
        retrieve(environmentId, EnvironmentRetrieveParams.none(), requestOptions)

    /**
     * Lists OpenAI-hosted environments owned by the authenticated principal. Requires access to the
     * prewarming beta.
     */
    fun list(): EnvironmentListPage = list(EnvironmentListParams.none())

    /** @see list */
    fun list(
        params: EnvironmentListParams = EnvironmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentListPage

    /** @see list */
    fun list(params: EnvironmentListParams = EnvironmentListParams.none()): EnvironmentListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): EnvironmentListPage =
        list(EnvironmentListParams.none(), requestOptions)

    /**
     * A view of [EnvironmentService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EnvironmentService.WithRawResponse

        fun files(): FileService.WithRawResponse

        fun templates(): TemplateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/environments`, but is otherwise the same as
         * [EnvironmentService.create].
         */
        @MustBeClosed
        fun create(params: EnvironmentCreateParams): HttpResponseFor<EnvironmentInfo> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: EnvironmentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentInfo>

        /**
         * Returns a raw HTTP response for `get /agents/environments/{environment_id}`, but is
         * otherwise the same as [EnvironmentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(environmentId: String): HttpResponseFor<EnvironmentInfo> =
            retrieve(environmentId, EnvironmentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            environmentId: String,
            params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentInfo> =
            retrieve(params.toBuilder().environmentId(environmentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            environmentId: String,
            params: EnvironmentRetrieveParams = EnvironmentRetrieveParams.none(),
        ): HttpResponseFor<EnvironmentInfo> = retrieve(environmentId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: EnvironmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentInfo>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: EnvironmentRetrieveParams): HttpResponseFor<EnvironmentInfo> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            environmentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentInfo> =
            retrieve(environmentId, EnvironmentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/environments`, but is otherwise the same as
         * [EnvironmentService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<EnvironmentListPage> = list(EnvironmentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EnvironmentListParams = EnvironmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: EnvironmentListParams = EnvironmentListParams.none()
        ): HttpResponseFor<EnvironmentListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EnvironmentListPage> =
            list(EnvironmentListParams.none(), requestOptions)
    }
}
