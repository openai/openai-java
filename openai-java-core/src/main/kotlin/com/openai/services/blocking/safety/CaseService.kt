// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.safety

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.safety.cases.CaseRetrieveParams
import com.openai.models.safety.cases.SafetyCase
import java.util.function.Consumer

interface CaseService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CaseService

    /** Get a safety case by ID. */
    fun retrieve(id: String): SafetyCase = retrieve(id, CaseRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CaseRetrieveParams = CaseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SafetyCase = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(id: String, params: CaseRetrieveParams = CaseRetrieveParams.none()): SafetyCase =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CaseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SafetyCase

    /** @see retrieve */
    fun retrieve(params: CaseRetrieveParams): SafetyCase = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): SafetyCase =
        retrieve(id, CaseRetrieveParams.none(), requestOptions)

    /** A view of [CaseService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CaseService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /safety/cases/{id}`, but is otherwise the same as
         * [CaseService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<SafetyCase> =
            retrieve(id, CaseRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: CaseRetrieveParams = CaseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SafetyCase> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: CaseRetrieveParams = CaseRetrieveParams.none(),
        ): HttpResponseFor<SafetyCase> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: CaseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SafetyCase>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: CaseRetrieveParams): HttpResponseFor<SafetyCase> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<SafetyCase> =
            retrieve(id, CaseRetrieveParams.none(), requestOptions)
    }
}
