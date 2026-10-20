// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.environments

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.environments.templates.EnvironmentTemplate
import com.openai.models.beta.agents.environments.templates.EnvironmentTemplateDeleted
import com.openai.models.beta.agents.environments.templates.TemplateCreateParams
import com.openai.models.beta.agents.environments.templates.TemplateDeleteParams
import com.openai.models.beta.agents.environments.templates.TemplateListPage
import com.openai.models.beta.agents.environments.templates.TemplateListParams
import com.openai.models.beta.agents.environments.templates.TemplateRetrieveParams
import com.openai.models.beta.agents.environments.templates.TemplateUpdateParams
import java.util.function.Consumer

interface TemplateService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateService

    /**
     * Creates reusable environment configuration without returning confidential setup commands or
     * environment values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun create(): EnvironmentTemplate = create(TemplateCreateParams.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams = TemplateCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplate

    /** @see create */
    fun create(params: TemplateCreateParams = TemplateCreateParams.none()): EnvironmentTemplate =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): EnvironmentTemplate =
        create(TemplateCreateParams.none(), requestOptions)

    /**
     * Retrieves reusable environment configuration without returning confidential values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun retrieve(environmentTemplateId: String): EnvironmentTemplate =
        retrieve(environmentTemplateId, TemplateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        environmentTemplateId: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplate =
        retrieve(
            params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
            requestOptions,
        )

    /** @see retrieve */
    fun retrieve(
        environmentTemplateId: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
    ): EnvironmentTemplate = retrieve(environmentTemplateId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplate

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): EnvironmentTemplate =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        environmentTemplateId: String,
        requestOptions: RequestOptions,
    ): EnvironmentTemplate =
        retrieve(environmentTemplateId, TemplateRetrieveParams.none(), requestOptions)

    /**
     * Updates reusable environment configuration without returning confidential values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun update(environmentTemplateId: String): EnvironmentTemplate =
        update(environmentTemplateId, TemplateUpdateParams.none())

    /** @see update */
    fun update(
        environmentTemplateId: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplate =
        update(
            params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
            requestOptions,
        )

    /** @see update */
    fun update(
        environmentTemplateId: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
    ): EnvironmentTemplate = update(environmentTemplateId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: TemplateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplate

    /** @see update */
    fun update(params: TemplateUpdateParams): EnvironmentTemplate =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(environmentTemplateId: String, requestOptions: RequestOptions): EnvironmentTemplate =
        update(environmentTemplateId, TemplateUpdateParams.none(), requestOptions)

    /**
     * Lists reusable environment templates without returning confidential values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun list(): TemplateListPage = list(TemplateListParams.none())

    /** @see list */
    fun list(
        params: TemplateListParams = TemplateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateListPage

    /** @see list */
    fun list(params: TemplateListParams = TemplateListParams.none()): TemplateListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): TemplateListPage =
        list(TemplateListParams.none(), requestOptions)

    /**
     * Deletes reusable environment configuration and all confidential template inputs. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun delete(environmentTemplateId: String): EnvironmentTemplateDeleted =
        delete(environmentTemplateId, TemplateDeleteParams.none())

    /** @see delete */
    fun delete(
        environmentTemplateId: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplateDeleted =
        delete(
            params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
            requestOptions,
        )

    /** @see delete */
    fun delete(
        environmentTemplateId: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
    ): EnvironmentTemplateDeleted = delete(environmentTemplateId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TemplateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvironmentTemplateDeleted

    /** @see delete */
    fun delete(params: TemplateDeleteParams): EnvironmentTemplateDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        environmentTemplateId: String,
        requestOptions: RequestOptions,
    ): EnvironmentTemplateDeleted =
        delete(environmentTemplateId, TemplateDeleteParams.none(), requestOptions)

    /** A view of [TemplateService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/environments/templates`, but is otherwise
         * the same as [TemplateService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<EnvironmentTemplate> = create(TemplateCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplate>

        /** @see create */
        @MustBeClosed
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none()
        ): HttpResponseFor<EnvironmentTemplate> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<EnvironmentTemplate> =
            create(TemplateCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /agents/environments/templates/{environment_template_id}`, but is otherwise the same as
         * [TemplateService.retrieve].
         */
        @MustBeClosed
        fun retrieve(environmentTemplateId: String): HttpResponseFor<EnvironmentTemplate> =
            retrieve(environmentTemplateId, TemplateRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            environmentTemplateId: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplate> =
            retrieve(
                params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
                requestOptions,
            )

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            environmentTemplateId: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        ): HttpResponseFor<EnvironmentTemplate> =
            retrieve(environmentTemplateId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplate>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TemplateRetrieveParams): HttpResponseFor<EnvironmentTemplate> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            environmentTemplateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentTemplate> =
            retrieve(environmentTemplateId, TemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /agents/environments/templates/{environment_template_id}`, but is otherwise the same as
         * [TemplateService.update].
         */
        @MustBeClosed
        fun update(environmentTemplateId: String): HttpResponseFor<EnvironmentTemplate> =
            update(environmentTemplateId, TemplateUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            environmentTemplateId: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplate> =
            update(
                params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
                requestOptions,
            )

        /** @see update */
        @MustBeClosed
        fun update(
            environmentTemplateId: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
        ): HttpResponseFor<EnvironmentTemplate> =
            update(environmentTemplateId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: TemplateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplate>

        /** @see update */
        @MustBeClosed
        fun update(params: TemplateUpdateParams): HttpResponseFor<EnvironmentTemplate> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            environmentTemplateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentTemplate> =
            update(environmentTemplateId, TemplateUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/environments/templates`, but is otherwise
         * the same as [TemplateService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<TemplateListPage> = list(TemplateListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TemplateListParams = TemplateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TemplateListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: TemplateListParams = TemplateListParams.none()
        ): HttpResponseFor<TemplateListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<TemplateListPage> =
            list(TemplateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /agents/environments/templates/{environment_template_id}`, but is otherwise the same as
         * [TemplateService.delete].
         */
        @MustBeClosed
        fun delete(environmentTemplateId: String): HttpResponseFor<EnvironmentTemplateDeleted> =
            delete(environmentTemplateId, TemplateDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            environmentTemplateId: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplateDeleted> =
            delete(
                params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
                requestOptions,
            )

        /** @see delete */
        @MustBeClosed
        fun delete(
            environmentTemplateId: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
        ): HttpResponseFor<EnvironmentTemplateDeleted> =
            delete(environmentTemplateId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvironmentTemplateDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: TemplateDeleteParams): HttpResponseFor<EnvironmentTemplateDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            environmentTemplateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentTemplateDeleted> =
            delete(environmentTemplateId, TemplateDeleteParams.none(), requestOptions)
    }
}
