// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.Agent
import com.openai.models.beta.agents.AgentCreateParams
import com.openai.models.beta.agents.AgentDeleteParams
import com.openai.models.beta.agents.AgentDeleted
import com.openai.models.beta.agents.AgentListPageAsync
import com.openai.models.beta.agents.AgentListParams
import com.openai.models.beta.agents.AgentRetrieveParams
import com.openai.models.beta.agents.AgentUpdateParams
import com.openai.services.async.beta.agents.EnvironmentServiceAsync
import com.openai.services.async.beta.agents.SessionServiceAsync
import com.openai.services.async.beta.agents.VaultServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AgentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentServiceAsync

    fun environments(): EnvironmentServiceAsync

    fun vaults(): VaultServiceAsync

    fun sessions(): SessionServiceAsync

    /**
     * Creates a reusable agent without storing credentials. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun create(params: AgentCreateParams): CompletableFuture<Agent> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Agent>

    /**
     * Retrieves a reusable agent by ID. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun retrieve(agentId: String): CompletableFuture<Agent> =
        retrieve(agentId, AgentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Agent> =
        retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
    ): CompletableFuture<Agent> = retrieve(agentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Agent>

    /** @see retrieve */
    fun retrieve(params: AgentRetrieveParams): CompletableFuture<Agent> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(agentId: String, requestOptions: RequestOptions): CompletableFuture<Agent> =
        retrieve(agentId, AgentRetrieveParams.none(), requestOptions)

    /**
     * Updates a reusable agent. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun update(agentId: String): CompletableFuture<Agent> =
        update(agentId, AgentUpdateParams.none())

    /** @see update */
    fun update(
        agentId: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Agent> =
        update(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see update */
    fun update(
        agentId: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
    ): CompletableFuture<Agent> = update(agentId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Agent>

    /** @see update */
    fun update(params: AgentUpdateParams): CompletableFuture<Agent> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(agentId: String, requestOptions: RequestOptions): CompletableFuture<Agent> =
        update(agentId, AgentUpdateParams.none(), requestOptions)

    /**
     * Lists reusable agents in the current project. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun list(): CompletableFuture<AgentListPageAsync> = list(AgentListParams.none())

    /** @see list */
    fun list(
        params: AgentListParams = AgentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentListPageAsync>

    /** @see list */
    fun list(
        params: AgentListParams = AgentListParams.none()
    ): CompletableFuture<AgentListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AgentListPageAsync> =
        list(AgentListParams.none(), requestOptions)

    /**
     * Deletes a reusable agent. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun delete(agentId: String): CompletableFuture<AgentDeleted> =
        delete(agentId, AgentDeleteParams.none())

    /** @see delete */
    fun delete(
        agentId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentDeleted> =
        delete(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see delete */
    fun delete(
        agentId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
    ): CompletableFuture<AgentDeleted> = delete(agentId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AgentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentDeleted>

    /** @see delete */
    fun delete(params: AgentDeleteParams): CompletableFuture<AgentDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(agentId: String, requestOptions: RequestOptions): CompletableFuture<AgentDeleted> =
        delete(agentId, AgentDeleteParams.none(), requestOptions)

    /** A view of [AgentServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AgentServiceAsync.WithRawResponse

        fun environments(): EnvironmentServiceAsync.WithRawResponse

        fun vaults(): VaultServiceAsync.WithRawResponse

        fun sessions(): SessionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents`, but is otherwise the same as
         * [AgentServiceAsync.create].
         */
        fun create(params: AgentCreateParams): CompletableFuture<HttpResponseFor<Agent>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Agent>>

        /**
         * Returns a raw HTTP response for `get /agents/{agent_id}`, but is otherwise the same as
         * [AgentServiceAsync.retrieve].
         */
        fun retrieve(agentId: String): CompletableFuture<HttpResponseFor<Agent>> =
            retrieve(agentId, AgentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            agentId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Agent>> =
            retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            agentId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Agent>> =
            retrieve(agentId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Agent>>

        /** @see retrieve */
        fun retrieve(params: AgentRetrieveParams): CompletableFuture<HttpResponseFor<Agent>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            agentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Agent>> =
            retrieve(agentId, AgentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/{agent_id}`, but is otherwise the same as
         * [AgentServiceAsync.update].
         */
        fun update(agentId: String): CompletableFuture<HttpResponseFor<Agent>> =
            update(agentId, AgentUpdateParams.none())

        /** @see update */
        fun update(
            agentId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Agent>> =
            update(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see update */
        fun update(
            agentId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Agent>> =
            update(agentId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Agent>>

        /** @see update */
        fun update(params: AgentUpdateParams): CompletableFuture<HttpResponseFor<Agent>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            agentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Agent>> =
            update(agentId, AgentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents`, but is otherwise the same as
         * [AgentServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AgentListPageAsync>> =
            list(AgentListParams.none())

        /** @see list */
        fun list(
            params: AgentListParams = AgentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentListPageAsync>>

        /** @see list */
        fun list(
            params: AgentListParams = AgentListParams.none()
        ): CompletableFuture<HttpResponseFor<AgentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AgentListPageAsync>> =
            list(AgentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /agents/{agent_id}`, but is otherwise the same as
         * [AgentServiceAsync.delete].
         */
        fun delete(agentId: String): CompletableFuture<HttpResponseFor<AgentDeleted>> =
            delete(agentId, AgentDeleteParams.none())

        /** @see delete */
        fun delete(
            agentId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentDeleted>> =
            delete(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see delete */
        fun delete(
            agentId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AgentDeleted>> =
            delete(agentId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentDeleted>>

        /** @see delete */
        fun delete(params: AgentDeleteParams): CompletableFuture<HttpResponseFor<AgentDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            agentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AgentDeleted>> =
            delete(agentId, AgentDeleteParams.none(), requestOptions)
    }
}
