// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.realtime.calls.CallAcceptParams
import com.openai.models.realtime.calls.CallHangupParams
import com.openai.models.realtime.calls.CallReferParams
import com.openai.models.realtime.calls.CallRejectParams
import java.util.function.Consumer

interface CallService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallService

    /** Accept an incoming SIP call and configure the realtime session that will handle it. */
    fun accept(callId: String, params: CallAcceptParams) =
        accept(callId, params, RequestOptions.none())

    /** @see accept */
    fun accept(
        callId: String,
        params: CallAcceptParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = accept(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see accept */
    fun accept(params: CallAcceptParams) = accept(params, RequestOptions.none())

    /** @see accept */
    fun accept(params: CallAcceptParams, requestOptions: RequestOptions = RequestOptions.none())

    /** End an active Realtime API call, whether it was initiated over SIP or WebRTC. */
    fun hangup(callId: String) = hangup(callId, CallHangupParams.none())

    /** @see hangup */
    fun hangup(
        callId: String,
        params: CallHangupParams = CallHangupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = hangup(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see hangup */
    fun hangup(callId: String, params: CallHangupParams = CallHangupParams.none()) =
        hangup(callId, params, RequestOptions.none())

    /** @see hangup */
    fun hangup(params: CallHangupParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see hangup */
    fun hangup(params: CallHangupParams) = hangup(params, RequestOptions.none())

    /** @see hangup */
    fun hangup(callId: String, requestOptions: RequestOptions) =
        hangup(callId, CallHangupParams.none(), requestOptions)

    /** Transfer an active SIP call to a new destination using the SIP REFER verb. */
    fun refer(callId: String, params: CallReferParams) =
        refer(callId, params, RequestOptions.none())

    /** @see refer */
    fun refer(
        callId: String,
        params: CallReferParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = refer(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see refer */
    fun refer(params: CallReferParams) = refer(params, RequestOptions.none())

    /** @see refer */
    fun refer(params: CallReferParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Decline an incoming SIP call by returning a SIP status code to the caller. */
    fun reject(callId: String) = reject(callId, CallRejectParams.none())

    /** @see reject */
    fun reject(
        callId: String,
        params: CallRejectParams = CallRejectParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = reject(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see reject */
    fun reject(callId: String, params: CallRejectParams = CallRejectParams.none()) =
        reject(callId, params, RequestOptions.none())

    /** @see reject */
    fun reject(params: CallRejectParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see reject */
    fun reject(params: CallRejectParams) = reject(params, RequestOptions.none())

    /** @see reject */
    fun reject(callId: String, requestOptions: RequestOptions) =
        reject(callId, CallRejectParams.none(), requestOptions)

    /** A view of [CallService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/accept`, but is otherwise
         * the same as [CallService.accept].
         */
        @MustBeClosed
        fun accept(callId: String, params: CallAcceptParams): HttpResponse =
            accept(callId, params, RequestOptions.none())

        /** @see accept */
        @MustBeClosed
        fun accept(
            callId: String,
            params: CallAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = accept(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see accept */
        @MustBeClosed
        fun accept(params: CallAcceptParams): HttpResponse = accept(params, RequestOptions.none())

        /** @see accept */
        @MustBeClosed
        fun accept(
            params: CallAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/hangup`, but is otherwise
         * the same as [CallService.hangup].
         */
        @MustBeClosed
        fun hangup(callId: String): HttpResponse = hangup(callId, CallHangupParams.none())

        /** @see hangup */
        @MustBeClosed
        fun hangup(
            callId: String,
            params: CallHangupParams = CallHangupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = hangup(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see hangup */
        @MustBeClosed
        fun hangup(
            callId: String,
            params: CallHangupParams = CallHangupParams.none(),
        ): HttpResponse = hangup(callId, params, RequestOptions.none())

        /** @see hangup */
        @MustBeClosed
        fun hangup(
            params: CallHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see hangup */
        @MustBeClosed
        fun hangup(params: CallHangupParams): HttpResponse = hangup(params, RequestOptions.none())

        /** @see hangup */
        @MustBeClosed
        fun hangup(callId: String, requestOptions: RequestOptions): HttpResponse =
            hangup(callId, CallHangupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/refer`, but is otherwise
         * the same as [CallService.refer].
         */
        @MustBeClosed
        fun refer(callId: String, params: CallReferParams): HttpResponse =
            refer(callId, params, RequestOptions.none())

        /** @see refer */
        @MustBeClosed
        fun refer(
            callId: String,
            params: CallReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = refer(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see refer */
        @MustBeClosed
        fun refer(params: CallReferParams): HttpResponse = refer(params, RequestOptions.none())

        /** @see refer */
        @MustBeClosed
        fun refer(
            params: CallReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/reject`, but is otherwise
         * the same as [CallService.reject].
         */
        @MustBeClosed
        fun reject(callId: String): HttpResponse = reject(callId, CallRejectParams.none())

        /** @see reject */
        @MustBeClosed
        fun reject(
            callId: String,
            params: CallRejectParams = CallRejectParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = reject(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see reject */
        @MustBeClosed
        fun reject(
            callId: String,
            params: CallRejectParams = CallRejectParams.none(),
        ): HttpResponse = reject(callId, params, RequestOptions.none())

        /** @see reject */
        @MustBeClosed
        fun reject(
            params: CallRejectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see reject */
        @MustBeClosed
        fun reject(params: CallRejectParams): HttpResponse = reject(params, RequestOptions.none())

        /** @see reject */
        @MustBeClosed
        fun reject(callId: String, requestOptions: RequestOptions): HttpResponse =
            reject(callId, CallRejectParams.none(), requestOptions)
    }
}
