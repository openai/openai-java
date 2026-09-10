// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.live

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.live.sessions.SessionAcceptParams
import com.openai.models.live.sessions.SessionDownloadRecordingParams
import com.openai.models.live.sessions.SessionForkParams
import com.openai.models.live.sessions.SessionForkResponse
import com.openai.models.live.sessions.SessionHangupParams
import com.openai.models.live.sessions.SessionReferParams
import com.openai.models.live.sessions.SessionRejectParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SessionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionServiceAsync

    /** Accept an incoming SIP call with Live startup configuration. */
    fun accept(sessionId: String, params: SessionAcceptParams): CompletableFuture<Void?> =
        accept(sessionId, params, RequestOptions.none())

    /** @see accept */
    fun accept(
        sessionId: String,
        params: SessionAcceptParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        accept(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see accept */
    fun accept(params: SessionAcceptParams): CompletableFuture<Void?> =
        accept(params, RequestOptions.none())

    /** @see accept */
    fun accept(
        params: SessionAcceptParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** Get Live session content */
    fun downloadRecording(sessionId: String): CompletableFuture<HttpResponse> =
        downloadRecording(sessionId, SessionDownloadRecordingParams.none())

    /** @see downloadRecording */
    fun downloadRecording(
        sessionId: String,
        params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        downloadRecording(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see downloadRecording */
    fun downloadRecording(
        sessionId: String,
        params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
    ): CompletableFuture<HttpResponse> = downloadRecording(sessionId, params, RequestOptions.none())

    /** @see downloadRecording */
    fun downloadRecording(
        params: SessionDownloadRecordingParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see downloadRecording */
    fun downloadRecording(params: SessionDownloadRecordingParams): CompletableFuture<HttpResponse> =
        downloadRecording(params, RequestOptions.none())

    /** @see downloadRecording */
    fun downloadRecording(
        sessionId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        downloadRecording(sessionId, SessionDownloadRecordingParams.none(), requestOptions)

    /** Fork a stored Live session onto a new WebRTC connection. */
    fun fork(sessionId: String, params: SessionForkParams): CompletableFuture<SessionForkResponse> =
        fork(sessionId, params, RequestOptions.none())

    /** @see fork */
    fun fork(
        sessionId: String,
        params: SessionForkParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionForkResponse> =
        fork(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see fork */
    fun fork(params: SessionForkParams): CompletableFuture<SessionForkResponse> =
        fork(params, RequestOptions.none())

    /** @see fork */
    fun fork(
        params: SessionForkParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SessionForkResponse>

    /** Hang up a Live session. */
    fun hangup(sessionId: String): CompletableFuture<Void?> =
        hangup(sessionId, SessionHangupParams.none())

    /** @see hangup */
    fun hangup(
        sessionId: String,
        params: SessionHangupParams = SessionHangupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        hangup(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see hangup */
    fun hangup(
        sessionId: String,
        params: SessionHangupParams = SessionHangupParams.none(),
    ): CompletableFuture<Void?> = hangup(sessionId, params, RequestOptions.none())

    /** @see hangup */
    fun hangup(
        params: SessionHangupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see hangup */
    fun hangup(params: SessionHangupParams): CompletableFuture<Void?> =
        hangup(params, RequestOptions.none())

    /** @see hangup */
    fun hangup(sessionId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        hangup(sessionId, SessionHangupParams.none(), requestOptions)

    /** Transfer a Live SIP call to another destination. */
    fun refer(sessionId: String, params: SessionReferParams): CompletableFuture<Void?> =
        refer(sessionId, params, RequestOptions.none())

    /** @see refer */
    fun refer(
        sessionId: String,
        params: SessionReferParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        refer(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see refer */
    fun refer(params: SessionReferParams): CompletableFuture<Void?> =
        refer(params, RequestOptions.none())

    /** @see refer */
    fun refer(
        params: SessionReferParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** Reject an incoming SIP call. */
    fun reject(sessionId: String, params: SessionRejectParams): CompletableFuture<Void?> =
        reject(sessionId, params, RequestOptions.none())

    /** @see reject */
    fun reject(
        sessionId: String,
        params: SessionRejectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        reject(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see reject */
    fun reject(params: SessionRejectParams): CompletableFuture<Void?> =
        reject(params, RequestOptions.none())

    /** @see reject */
    fun reject(
        params: SessionRejectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * A view of [SessionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SessionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/accept`, but is
         * otherwise the same as [SessionServiceAsync.accept].
         */
        fun accept(
            sessionId: String,
            params: SessionAcceptParams,
        ): CompletableFuture<HttpResponse> = accept(sessionId, params, RequestOptions.none())

        /** @see accept */
        fun accept(
            sessionId: String,
            params: SessionAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            accept(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see accept */
        fun accept(params: SessionAcceptParams): CompletableFuture<HttpResponse> =
            accept(params, RequestOptions.none())

        /** @see accept */
        fun accept(
            params: SessionAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `get /live/sessions/{session_id}/content`, but is
         * otherwise the same as [SessionServiceAsync.downloadRecording].
         */
        fun downloadRecording(sessionId: String): CompletableFuture<HttpResponse> =
            downloadRecording(sessionId, SessionDownloadRecordingParams.none())

        /** @see downloadRecording */
        fun downloadRecording(
            sessionId: String,
            params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            downloadRecording(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see downloadRecording */
        fun downloadRecording(
            sessionId: String,
            params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
        ): CompletableFuture<HttpResponse> =
            downloadRecording(sessionId, params, RequestOptions.none())

        /** @see downloadRecording */
        fun downloadRecording(
            params: SessionDownloadRecordingParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see downloadRecording */
        fun downloadRecording(
            params: SessionDownloadRecordingParams
        ): CompletableFuture<HttpResponse> = downloadRecording(params, RequestOptions.none())

        /** @see downloadRecording */
        fun downloadRecording(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            downloadRecording(sessionId, SessionDownloadRecordingParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/fork`, but is otherwise
         * the same as [SessionServiceAsync.fork].
         */
        fun fork(
            sessionId: String,
            params: SessionForkParams,
        ): CompletableFuture<HttpResponseFor<SessionForkResponse>> =
            fork(sessionId, params, RequestOptions.none())

        /** @see fork */
        fun fork(
            sessionId: String,
            params: SessionForkParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionForkResponse>> =
            fork(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see fork */
        fun fork(
            params: SessionForkParams
        ): CompletableFuture<HttpResponseFor<SessionForkResponse>> =
            fork(params, RequestOptions.none())

        /** @see fork */
        fun fork(
            params: SessionForkParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SessionForkResponse>>

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/hangup`, but is
         * otherwise the same as [SessionServiceAsync.hangup].
         */
        fun hangup(sessionId: String): CompletableFuture<HttpResponse> =
            hangup(sessionId, SessionHangupParams.none())

        /** @see hangup */
        fun hangup(
            sessionId: String,
            params: SessionHangupParams = SessionHangupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            hangup(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see hangup */
        fun hangup(
            sessionId: String,
            params: SessionHangupParams = SessionHangupParams.none(),
        ): CompletableFuture<HttpResponse> = hangup(sessionId, params, RequestOptions.none())

        /** @see hangup */
        fun hangup(
            params: SessionHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see hangup */
        fun hangup(params: SessionHangupParams): CompletableFuture<HttpResponse> =
            hangup(params, RequestOptions.none())

        /** @see hangup */
        fun hangup(
            sessionId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            hangup(sessionId, SessionHangupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/refer`, but is
         * otherwise the same as [SessionServiceAsync.refer].
         */
        fun refer(sessionId: String, params: SessionReferParams): CompletableFuture<HttpResponse> =
            refer(sessionId, params, RequestOptions.none())

        /** @see refer */
        fun refer(
            sessionId: String,
            params: SessionReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            refer(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see refer */
        fun refer(params: SessionReferParams): CompletableFuture<HttpResponse> =
            refer(params, RequestOptions.none())

        /** @see refer */
        fun refer(
            params: SessionReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/reject`, but is
         * otherwise the same as [SessionServiceAsync.reject].
         */
        fun reject(
            sessionId: String,
            params: SessionRejectParams,
        ): CompletableFuture<HttpResponse> = reject(sessionId, params, RequestOptions.none())

        /** @see reject */
        fun reject(
            sessionId: String,
            params: SessionRejectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            reject(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see reject */
        fun reject(params: SessionRejectParams): CompletableFuture<HttpResponse> =
            reject(params, RequestOptions.none())

        /** @see reject */
        fun reject(
            params: SessionRejectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
