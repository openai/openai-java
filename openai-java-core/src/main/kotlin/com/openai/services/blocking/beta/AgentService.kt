// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.Agent
import com.openai.models.beta.agents.AgentCreateParams
import com.openai.models.beta.agents.AgentDeleteParams
import com.openai.models.beta.agents.AgentDeleted
import com.openai.models.beta.agents.AgentListPage
import com.openai.models.beta.agents.AgentListParams
import com.openai.models.beta.agents.AgentRetrieveParams
import com.openai.models.beta.agents.AgentUpdateParams
import com.openai.services.blocking.beta.agents.EnvironmentService
import com.openai.services.blocking.beta.agents.SessionService
import com.openai.services.blocking.beta.agents.VaultService
import java.util.function.Consumer

interface AgentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentService

    fun environments(): EnvironmentService

    fun vaults(): VaultService

    fun sessions(): SessionService

    /**
     * Creates a reusable agent without storing credentials. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun create(params: AgentCreateParams): Agent = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Agent

    /**
     * Retrieves a reusable agent by ID. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun retrieve(agentId: String): Agent = retrieve(agentId, AgentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        agentId: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Agent = retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(agentId: String, params: AgentRetrieveParams = AgentRetrieveParams.none()): Agent =
        retrieve(agentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Agent

    /** @see retrieve */
    fun retrieve(params: AgentRetrieveParams): Agent = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(agentId: String, requestOptions: RequestOptions): Agent =
        retrieve(agentId, AgentRetrieveParams.none(), requestOptions)

    /**
     * Updates a reusable agent. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun update(agentId: String): Agent = update(agentId, AgentUpdateParams.none())

    /** @see update */
    fun update(
        agentId: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Agent = update(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see update */
    fun update(agentId: String, params: AgentUpdateParams = AgentUpdateParams.none()): Agent =
        update(agentId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Agent

    /** @see update */
    fun update(params: AgentUpdateParams): Agent = update(params, RequestOptions.none())

    /** @see update */
    fun update(agentId: String, requestOptions: RequestOptions): Agent =
        update(agentId, AgentUpdateParams.none(), requestOptions)

    /**
     * Lists reusable agents in the current project. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun list(): AgentListPage = list(AgentListParams.none())

    /** @see list */
    fun list(
        params: AgentListParams = AgentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentListPage

    /** @see list */
    fun list(params: AgentListParams = AgentListParams.none()): AgentListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): AgentListPage =
        list(AgentListParams.none(), requestOptions)

    /**
     * Deletes a reusable agent. See
     * [agent configuration](https://developers.openai.com/api/docs/guides/agents-api/configuration).
     */
    fun delete(agentId: String): AgentDeleted = delete(agentId, AgentDeleteParams.none())

    /** @see delete */
    fun delete(
        agentId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentDeleted = delete(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see delete */
    fun delete(
        agentId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
    ): AgentDeleted = delete(agentId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AgentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentDeleted

    /** @see delete */
    fun delete(params: AgentDeleteParams): AgentDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(agentId: String, requestOptions: RequestOptions): AgentDeleted =
        delete(agentId, AgentDeleteParams.none(), requestOptions)

    /** A view of [AgentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentService.WithRawResponse

        fun environments(): EnvironmentService.WithRawResponse

        fun vaults(): VaultService.WithRawResponse

        fun sessions(): SessionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /agents`, but is otherwise the same as
         * [AgentService.create].
         */
        @MustBeClosed
        fun create(params: AgentCreateParams): HttpResponseFor<Agent> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Agent>

        /**
         * Returns a raw HTTP response for `get /agents/{agent_id}`, but is otherwise the same as
         * [AgentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(agentId: String): HttpResponseFor<Agent> =
            retrieve(agentId, AgentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            agentId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Agent> =
            retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            agentId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
        ): HttpResponseFor<Agent> = retrieve(agentId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Agent>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AgentRetrieveParams): HttpResponseFor<Agent> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(agentId: String, requestOptions: RequestOptions): HttpResponseFor<Agent> =
            retrieve(agentId, AgentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /agents/{agent_id}`, but is otherwise the same as
         * [AgentService.update].
         */
        @MustBeClosed
        fun update(agentId: String): HttpResponseFor<Agent> =
            update(agentId, AgentUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            agentId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Agent> =
            update(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            agentId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
        ): HttpResponseFor<Agent> = update(agentId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Agent>

        /** @see update */
        @MustBeClosed
        fun update(params: AgentUpdateParams): HttpResponseFor<Agent> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(agentId: String, requestOptions: RequestOptions): HttpResponseFor<Agent> =
            update(agentId, AgentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /agents`, but is otherwise the same as
         * [AgentService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<AgentListPage> = list(AgentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AgentListParams = AgentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: AgentListParams = AgentListParams.none()): HttpResponseFor<AgentListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AgentListPage> =
            list(AgentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /agents/{agent_id}`, but is otherwise the same as
         * [AgentService.delete].
         */
        @MustBeClosed
        fun delete(agentId: String): HttpResponseFor<AgentDeleted> =
            delete(agentId, AgentDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            agentId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentDeleted> =
            delete(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            agentId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
        ): HttpResponseFor<AgentDeleted> = delete(agentId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: AgentDeleteParams): HttpResponseFor<AgentDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(agentId: String, requestOptions: RequestOptions): HttpResponseFor<AgentDeleted> =
            delete(agentId, AgentDeleteParams.none(), requestOptions)
    }
}
