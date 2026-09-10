// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.live

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface SessionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService

    /** Accept an incoming SIP call with Live startup configuration. */
    fun accept(sessionId: String, params: SessionAcceptParams) =
        accept(sessionId, params, RequestOptions.none())

    /** @see accept */
    fun accept(
        sessionId: String,
        params: SessionAcceptParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = accept(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see accept */
    fun accept(params: SessionAcceptParams) = accept(params, RequestOptions.none())

    /** @see accept */
    fun accept(params: SessionAcceptParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Get Live session content */
    @MustBeClosed
    fun downloadRecording(sessionId: String): HttpResponse =
        downloadRecording(sessionId, SessionDownloadRecordingParams.none())

    /** @see downloadRecording */
    @MustBeClosed
    fun downloadRecording(
        sessionId: String,
        params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse =
        downloadRecording(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see downloadRecording */
    @MustBeClosed
    fun downloadRecording(
        sessionId: String,
        params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
    ): HttpResponse = downloadRecording(sessionId, params, RequestOptions.none())

    /** @see downloadRecording */
    @MustBeClosed
    fun downloadRecording(
        params: SessionDownloadRecordingParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see downloadRecording */
    @MustBeClosed
    fun downloadRecording(params: SessionDownloadRecordingParams): HttpResponse =
        downloadRecording(params, RequestOptions.none())

    /** @see downloadRecording */
    @MustBeClosed
    fun downloadRecording(sessionId: String, requestOptions: RequestOptions): HttpResponse =
        downloadRecording(sessionId, SessionDownloadRecordingParams.none(), requestOptions)

    /** Fork a stored Live session onto a new WebRTC connection. */
    fun fork(sessionId: String, params: SessionForkParams): SessionForkResponse =
        fork(sessionId, params, RequestOptions.none())

    /** @see fork */
    fun fork(
        sessionId: String,
        params: SessionForkParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionForkResponse = fork(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see fork */
    fun fork(params: SessionForkParams): SessionForkResponse = fork(params, RequestOptions.none())

    /** @see fork */
    fun fork(
        params: SessionForkParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SessionForkResponse

    /** Hang up a Live session. */
    fun hangup(sessionId: String) = hangup(sessionId, SessionHangupParams.none())

    /** @see hangup */
    fun hangup(
        sessionId: String,
        params: SessionHangupParams = SessionHangupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = hangup(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see hangup */
    fun hangup(sessionId: String, params: SessionHangupParams = SessionHangupParams.none()) =
        hangup(sessionId, params, RequestOptions.none())

    /** @see hangup */
    fun hangup(params: SessionHangupParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see hangup */
    fun hangup(params: SessionHangupParams) = hangup(params, RequestOptions.none())

    /** @see hangup */
    fun hangup(sessionId: String, requestOptions: RequestOptions) =
        hangup(sessionId, SessionHangupParams.none(), requestOptions)

    /** Transfer a Live SIP call to another destination. */
    fun refer(sessionId: String, params: SessionReferParams) =
        refer(sessionId, params, RequestOptions.none())

    /** @see refer */
    fun refer(
        sessionId: String,
        params: SessionReferParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = refer(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see refer */
    fun refer(params: SessionReferParams) = refer(params, RequestOptions.none())

    /** @see refer */
    fun refer(params: SessionReferParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Reject an incoming SIP call. */
    fun reject(sessionId: String, params: SessionRejectParams) =
        reject(sessionId, params, RequestOptions.none())

    /** @see reject */
    fun reject(
        sessionId: String,
        params: SessionRejectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = reject(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see reject */
    fun reject(params: SessionRejectParams) = reject(params, RequestOptions.none())

    /** @see reject */
    fun reject(params: SessionRejectParams, requestOptions: RequestOptions = RequestOptions.none())

    /** A view of [SessionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/accept`, but is
         * otherwise the same as [SessionService.accept].
         */
        @MustBeClosed
        fun accept(sessionId: String, params: SessionAcceptParams): HttpResponse =
            accept(sessionId, params, RequestOptions.none())

        /** @see accept */
        @MustBeClosed
        fun accept(
            sessionId: String,
            params: SessionAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = accept(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see accept */
        @MustBeClosed
        fun accept(params: SessionAcceptParams): HttpResponse =
            accept(params, RequestOptions.none())

        /** @see accept */
        @MustBeClosed
        fun accept(
            params: SessionAcceptParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get /live/sessions/{session_id}/content`, but is
         * otherwise the same as [SessionService.downloadRecording].
         */
        @MustBeClosed
        fun downloadRecording(sessionId: String): HttpResponse =
            downloadRecording(sessionId, SessionDownloadRecordingParams.none())

        /** @see downloadRecording */
        @MustBeClosed
        fun downloadRecording(
            sessionId: String,
            params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            downloadRecording(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see downloadRecording */
        @MustBeClosed
        fun downloadRecording(
            sessionId: String,
            params: SessionDownloadRecordingParams = SessionDownloadRecordingParams.none(),
        ): HttpResponse = downloadRecording(sessionId, params, RequestOptions.none())

        /** @see downloadRecording */
        @MustBeClosed
        fun downloadRecording(
            params: SessionDownloadRecordingParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see downloadRecording */
        @MustBeClosed
        fun downloadRecording(params: SessionDownloadRecordingParams): HttpResponse =
            downloadRecording(params, RequestOptions.none())

        /** @see downloadRecording */
        @MustBeClosed
        fun downloadRecording(sessionId: String, requestOptions: RequestOptions): HttpResponse =
            downloadRecording(sessionId, SessionDownloadRecordingParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/fork`, but is otherwise
         * the same as [SessionService.fork].
         */
        @MustBeClosed
        fun fork(
            sessionId: String,
            params: SessionForkParams,
        ): HttpResponseFor<SessionForkResponse> = fork(sessionId, params, RequestOptions.none())

        /** @see fork */
        @MustBeClosed
        fun fork(
            sessionId: String,
            params: SessionForkParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionForkResponse> =
            fork(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see fork */
        @MustBeClosed
        fun fork(params: SessionForkParams): HttpResponseFor<SessionForkResponse> =
            fork(params, RequestOptions.none())

        /** @see fork */
        @MustBeClosed
        fun fork(
            params: SessionForkParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SessionForkResponse>

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/hangup`, but is
         * otherwise the same as [SessionService.hangup].
         */
        @MustBeClosed
        fun hangup(sessionId: String): HttpResponse = hangup(sessionId, SessionHangupParams.none())

        /** @see hangup */
        @MustBeClosed
        fun hangup(
            sessionId: String,
            params: SessionHangupParams = SessionHangupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = hangup(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see hangup */
        @MustBeClosed
        fun hangup(
            sessionId: String,
            params: SessionHangupParams = SessionHangupParams.none(),
        ): HttpResponse = hangup(sessionId, params, RequestOptions.none())

        /** @see hangup */
        @MustBeClosed
        fun hangup(
            params: SessionHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see hangup */
        @MustBeClosed
        fun hangup(params: SessionHangupParams): HttpResponse =
            hangup(params, RequestOptions.none())

        /** @see hangup */
        @MustBeClosed
        fun hangup(sessionId: String, requestOptions: RequestOptions): HttpResponse =
            hangup(sessionId, SessionHangupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/refer`, but is
         * otherwise the same as [SessionService.refer].
         */
        @MustBeClosed
        fun refer(sessionId: String, params: SessionReferParams): HttpResponse =
            refer(sessionId, params, RequestOptions.none())

        /** @see refer */
        @MustBeClosed
        fun refer(
            sessionId: String,
            params: SessionReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = refer(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see refer */
        @MustBeClosed
        fun refer(params: SessionReferParams): HttpResponse = refer(params, RequestOptions.none())

        /** @see refer */
        @MustBeClosed
        fun refer(
            params: SessionReferParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /live/sessions/{session_id}/reject`, but is
         * otherwise the same as [SessionService.reject].
         */
        @MustBeClosed
        fun reject(sessionId: String, params: SessionRejectParams): HttpResponse =
            reject(sessionId, params, RequestOptions.none())

        /** @see reject */
        @MustBeClosed
        fun reject(
            sessionId: String,
            params: SessionRejectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = reject(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see reject */
        @MustBeClosed
        fun reject(params: SessionRejectParams): HttpResponse =
            reject(params, RequestOptions.none())

        /** @see reject */
        @MustBeClosed
        fun reject(
            params: SessionRejectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
