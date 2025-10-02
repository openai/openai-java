// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.realtime.calls.CallAcceptParams
import com.openai.models.realtime.calls.CallHangupParams
import com.openai.models.realtime.calls.CallReferParams
import com.openai.models.realtime.calls.CallRejectParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CallServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallServiceAsync

    /** Accept an incoming SIP call and configure the realtime session that will handle it. */
    fun accept(callId: String, params: CallAcceptParams): CompletableFuture<Void?> =
        accept(callId, params, RequestOptions.none())

    /** @see accept */
    fun accept(
        callId: String,
        params: CallAcceptParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = accept(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see accept */
    fun accept(params: CallAcceptParams): CompletableFuture<Void?> =
        accept(params, RequestOptions.none())

    /** @see accept */
    fun accept(
        params: CallAcceptParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** End an active Realtime API call, whether it was initiated over SIP or WebRTC. */
    fun hangup(callId: String): CompletableFuture<Void?> = hangup(callId, CallHangupParams.none())

    /** @see hangup */
    fun hangup(
        callId: String,
        params: CallHangupParams = CallHangupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = hangup(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see hangup */
    fun hangup(
        callId: String,
        params: CallHangupParams = CallHangupParams.none(),
    ): CompletableFuture<Void?> = hangup(callId, params, RequestOptions.none())

    /** @see hangup */
    fun hangup(
        params: CallHangupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see hangup */
    fun hangup(params: CallHangupParams): CompletableFuture<Void?> =
        hangup(params, RequestOptions.none())

    /** @see hangup */
    fun hangup(callId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        hangup(callId, CallHangupParams.none(), requestOptions)

    /** Transfer an active SIP call to a new destination using the SIP REFER verb. */
    fun refer(callId: String, params: CallReferParams): CompletableFuture<Void?> =
        refer(callId, params, RequestOptions.none())

    /** @see refer */
    fun refer(
        callId: String,
        params: CallReferParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = refer(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see refer */
    fun refer(params: CallReferParams): CompletableFuture<Void?> =
        refer(params, RequestOptions.none())

    /** @see refer */
    fun refer(
        params: CallReferParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** Decline an incoming SIP call by returning a SIP status code to the caller. */
    fun reject(callId: String): CompletableFuture<Void?> = reject(callId, CallRejectParams.none())

    /** @see reject */
    fun reject(
        callId: String,
        params: CallRejectParams = CallRejectParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = reject(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see reject */
    fun reject(
        callId: String,
        params: CallRejectParams = CallRejectParams.none(),
    ): CompletableFuture<Void?> = reject(callId, params, RequestOptions.none())

    /** @see reject */
    fun reject(
        params: CallRejectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see reject */
    fun reject(params: CallRejectParams): CompletableFuture<Void?> =
        reject(params, RequestOptions.none())

    /** @see reject */
    fun reject(callId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        reject(callId, CallRejectParams.none(), requestOptions)

    /** A view of [CallServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/accept`, but is otherwise
         * the same as [CallServiceAsync.accept].
         */
        fun accept(callId: String, params: CallAcceptParams): CompletableFuture<HttpResponse> =
            accept(callId, params, RequestOptions.none())

        /** @see accept */
        fun accept(
            callId: String,
            params: CallAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            accept(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see accept */
        fun accept(params: CallAcceptParams): CompletableFuture<HttpResponse> =
            accept(params, RequestOptions.none())

        /** @see accept */
        fun accept(
            params: CallAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/hangup`, but is otherwise
         * the same as [CallServiceAsync.hangup].
         */
        fun hangup(callId: String): CompletableFuture<HttpResponse> =
            hangup(callId, CallHangupParams.none())

        /** @see hangup */
        fun hangup(
            callId: String,
            params: CallHangupParams = CallHangupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            hangup(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see hangup */
        fun hangup(
            callId: String,
            params: CallHangupParams = CallHangupParams.none(),
        ): CompletableFuture<HttpResponse> = hangup(callId, params, RequestOptions.none())

        /** @see hangup */
        fun hangup(
            params: CallHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see hangup */
        fun hangup(params: CallHangupParams): CompletableFuture<HttpResponse> =
            hangup(params, RequestOptions.none())

        /** @see hangup */
        fun hangup(
            callId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = hangup(callId, CallHangupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/refer`, but is otherwise
         * the same as [CallServiceAsync.refer].
         */
        fun refer(callId: String, params: CallReferParams): CompletableFuture<HttpResponse> =
            refer(callId, params, RequestOptions.none())

        /** @see refer */
        fun refer(
            callId: String,
            params: CallReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            refer(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see refer */
        fun refer(params: CallReferParams): CompletableFuture<HttpResponse> =
            refer(params, RequestOptions.none())

        /** @see refer */
        fun refer(
            params: CallReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /realtime/calls/{call_id}/reject`, but is otherwise
         * the same as [CallServiceAsync.reject].
         */
        fun reject(callId: String): CompletableFuture<HttpResponse> =
            reject(callId, CallRejectParams.none())

        /** @see reject */
        fun reject(
            callId: String,
            params: CallRejectParams = CallRejectParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            reject(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see reject */
        fun reject(
            callId: String,
            params: CallRejectParams = CallRejectParams.none(),
        ): CompletableFuture<HttpResponse> = reject(callId, params, RequestOptions.none())

        /** @see reject */
        fun reject(
            params: CallRejectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see reject */
        fun reject(params: CallRejectParams): CompletableFuture<HttpResponse> =
            reject(params, RequestOptions.none())

        /** @see reject */
        fun reject(
            callId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = reject(callId, CallRejectParams.none(), requestOptions)
    }
}
