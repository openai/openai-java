// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.environments

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.environments.templates.EnvironmentTemplate
import com.openai.models.beta.agents.environments.templates.EnvironmentTemplateDeleted
import com.openai.models.beta.agents.environments.templates.TemplateCreateParams
import com.openai.models.beta.agents.environments.templates.TemplateDeleteParams
import com.openai.models.beta.agents.environments.templates.TemplateListPageAsync
import com.openai.models.beta.agents.environments.templates.TemplateListParams
import com.openai.models.beta.agents.environments.templates.TemplateRetrieveParams
import com.openai.models.beta.agents.environments.templates.TemplateUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TemplateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateServiceAsync

    /**
     * Creates reusable environment configuration without returning confidential setup commands or
     * environment values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun create(): CompletableFuture<EnvironmentTemplate> = create(TemplateCreateParams.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams = TemplateCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplate>

    /** @see create */
    fun create(
        params: TemplateCreateParams = TemplateCreateParams.none()
    ): CompletableFuture<EnvironmentTemplate> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<EnvironmentTemplate> =
        create(TemplateCreateParams.none(), requestOptions)

    /**
     * Retrieves reusable environment configuration without returning confidential values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun retrieve(environmentTemplateId: String): CompletableFuture<EnvironmentTemplate> =
        retrieve(environmentTemplateId, TemplateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        environmentTemplateId: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplate> =
        retrieve(
            params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
            requestOptions,
        )

    /** @see retrieve */
    fun retrieve(
        environmentTemplateId: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
    ): CompletableFuture<EnvironmentTemplate> =
        retrieve(environmentTemplateId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplate>

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): CompletableFuture<EnvironmentTemplate> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        environmentTemplateId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EnvironmentTemplate> =
        retrieve(environmentTemplateId, TemplateRetrieveParams.none(), requestOptions)

    /**
     * Updates reusable environment configuration without returning confidential values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun update(environmentTemplateId: String): CompletableFuture<EnvironmentTemplate> =
        update(environmentTemplateId, TemplateUpdateParams.none())

    /** @see update */
    fun update(
        environmentTemplateId: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplate> =
        update(
            params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
            requestOptions,
        )

    /** @see update */
    fun update(
        environmentTemplateId: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
    ): CompletableFuture<EnvironmentTemplate> =
        update(environmentTemplateId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: TemplateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplate>

    /** @see update */
    fun update(params: TemplateUpdateParams): CompletableFuture<EnvironmentTemplate> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        environmentTemplateId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EnvironmentTemplate> =
        update(environmentTemplateId, TemplateUpdateParams.none(), requestOptions)

    /**
     * Lists reusable environment templates without returning confidential values. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun list(): CompletableFuture<TemplateListPageAsync> = list(TemplateListParams.none())

    /** @see list */
    fun list(
        params: TemplateListParams = TemplateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateListPageAsync>

    /** @see list */
    fun list(
        params: TemplateListParams = TemplateListParams.none()
    ): CompletableFuture<TemplateListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<TemplateListPageAsync> =
        list(TemplateListParams.none(), requestOptions)

    /**
     * Deletes reusable environment configuration and all confidential template inputs. See
     * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
     */
    fun delete(environmentTemplateId: String): CompletableFuture<EnvironmentTemplateDeleted> =
        delete(environmentTemplateId, TemplateDeleteParams.none())

    /** @see delete */
    fun delete(
        environmentTemplateId: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplateDeleted> =
        delete(
            params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
            requestOptions,
        )

    /** @see delete */
    fun delete(
        environmentTemplateId: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
    ): CompletableFuture<EnvironmentTemplateDeleted> =
        delete(environmentTemplateId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TemplateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EnvironmentTemplateDeleted>

    /** @see delete */
    fun delete(params: TemplateDeleteParams): CompletableFuture<EnvironmentTemplateDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        environmentTemplateId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EnvironmentTemplateDeleted> =
        delete(environmentTemplateId, TemplateDeleteParams.none(), requestOptions)

    /**
     * A view of [TemplateServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TemplateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents/environments/templates`, but is otherwise
         * the same as [TemplateServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            create(TemplateCreateParams.none())

        /** @see create */
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>>

        /** @see create */
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none()
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            create(TemplateCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /agents/environments/templates/{environment_template_id}`, but is otherwise the same as
         * [TemplateServiceAsync.retrieve].
         */
        fun retrieve(
            environmentTemplateId: String
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            retrieve(environmentTemplateId, TemplateRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            environmentTemplateId: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            retrieve(
                params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
                requestOptions,
            )

        /** @see retrieve */
        fun retrieve(
            environmentTemplateId: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            retrieve(environmentTemplateId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>>

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            environmentTemplateId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            retrieve(environmentTemplateId, TemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /agents/environments/templates/{environment_template_id}`, but is otherwise the same as
         * [TemplateServiceAsync.update].
         */
        fun update(
            environmentTemplateId: String
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            update(environmentTemplateId, TemplateUpdateParams.none())

        /** @see update */
        fun update(
            environmentTemplateId: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            update(
                params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
                requestOptions,
            )

        /** @see update */
        fun update(
            environmentTemplateId: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            update(environmentTemplateId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: TemplateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>>

        /** @see update */
        fun update(
            params: TemplateUpdateParams
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            environmentTemplateId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplate>> =
            update(environmentTemplateId, TemplateUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents/environments/templates`, but is otherwise
         * the same as [TemplateServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<TemplateListPageAsync>> =
            list(TemplateListParams.none())

        /** @see list */
        fun list(
            params: TemplateListParams = TemplateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateListPageAsync>>

        /** @see list */
        fun list(
            params: TemplateListParams = TemplateListParams.none()
        ): CompletableFuture<HttpResponseFor<TemplateListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TemplateListPageAsync>> =
            list(TemplateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /agents/environments/templates/{environment_template_id}`, but is otherwise the same as
         * [TemplateServiceAsync.delete].
         */
        fun delete(
            environmentTemplateId: String
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplateDeleted>> =
            delete(environmentTemplateId, TemplateDeleteParams.none())

        /** @see delete */
        fun delete(
            environmentTemplateId: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplateDeleted>> =
            delete(
                params.toBuilder().environmentTemplateId(environmentTemplateId).build(),
                requestOptions,
            )

        /** @see delete */
        fun delete(
            environmentTemplateId: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplateDeleted>> =
            delete(environmentTemplateId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplateDeleted>>

        /** @see delete */
        fun delete(
            params: TemplateDeleteParams
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplateDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            environmentTemplateId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EnvironmentTemplateDeleted>> =
            delete(environmentTemplateId, TemplateDeleteParams.none(), requestOptions)
    }
}
