package com.openai.services

import com.openai.core.ClientOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpResponse
import com.openai.models.containers.ContainerDeleteParams
import com.openai.models.containers.files.FileDeleteParams
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.calls.CallAcceptParams
import com.openai.models.realtime.calls.CallHangupParams
import com.openai.models.realtime.calls.CallReferParams
import com.openai.models.realtime.calls.CallRejectParams
import com.openai.models.responses.ResponseDeleteParams
import com.openai.services.async.ContainerServiceAsyncImpl
import com.openai.services.async.ResponseServiceAsyncImpl
import com.openai.services.async.containers.FileServiceAsyncImpl
import com.openai.services.async.realtime.CallServiceAsyncImpl
import com.openai.services.blocking.ContainerServiceImpl
import com.openai.services.blocking.ResponseServiceImpl
import com.openai.services.blocking.containers.FileServiceImpl
import com.openai.services.blocking.realtime.CallServiceImpl
import java.util.concurrent.CompletableFuture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class HighLevelUnitMethodsCloseResponseTest {

    @Test
    fun containerDelete_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            ContainerServiceImpl(options)
                .delete(ContainerDeleteParams.builder().containerId("container_id").build())
        }
    }

    @Test
    fun responseDelete_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            ResponseServiceImpl(options)
                .delete(ResponseDeleteParams.builder().responseId("response_id").build())
        }
    }

    @Test
    fun containerFileDelete_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            FileServiceImpl(options)
                .delete(
                    FileDeleteParams.builder().containerId("container_id").fileId("file_id").build()
                )
        }
    }

    @Test
    fun realtimeCallAccept_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            CallServiceImpl(options)
                .accept(
                    CallAcceptParams.builder()
                        .callId("call_id")
                        .realtimeSessionCreateRequest(
                            RealtimeSessionCreateRequest.builder().build()
                        )
                        .build()
                )
        }
    }

    @Test
    fun realtimeCallHangup_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            CallServiceImpl(options).hangup(CallHangupParams.builder().callId("call_id").build())
        }
    }

    @Test
    fun realtimeCallRefer_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            CallServiceImpl(options)
                .refer(
                    CallReferParams.builder()
                        .callId("call_id")
                        .targetUri("tel:+14155550123")
                        .build()
                )
        }
    }

    @Test
    fun realtimeCallReject_closesSuccessfulBlockingResponse() {
        assertBlockingResponseClosed { options ->
            CallServiceImpl(options)
                .reject(CallRejectParams.builder().callId("call_id").statusCode(486L).build())
        }
    }

    @Test
    fun containerDelete_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            ContainerServiceAsyncImpl(options)
                .delete(ContainerDeleteParams.builder().containerId("container_id").build())
        }
    }

    @Test
    fun responseDelete_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            ResponseServiceAsyncImpl(options)
                .delete(ResponseDeleteParams.builder().responseId("response_id").build())
        }
    }

    @Test
    fun containerFileDelete_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            FileServiceAsyncImpl(options)
                .delete(
                    FileDeleteParams.builder().containerId("container_id").fileId("file_id").build()
                )
        }
    }

    @Test
    fun realtimeCallAccept_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            CallServiceAsyncImpl(options)
                .accept(
                    CallAcceptParams.builder()
                        .callId("call_id")
                        .realtimeSessionCreateRequest(
                            RealtimeSessionCreateRequest.builder().build()
                        )
                        .build()
                )
        }
    }

    @Test
    fun realtimeCallHangup_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            CallServiceAsyncImpl(options)
                .hangup(CallHangupParams.builder().callId("call_id").build())
        }
    }

    @Test
    fun realtimeCallRefer_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            CallServiceAsyncImpl(options)
                .refer(
                    CallReferParams.builder()
                        .callId("call_id")
                        .targetUri("tel:+14155550123")
                        .build()
                )
        }
    }

    @Test
    fun realtimeCallReject_closesSuccessfulAsyncResponse() {
        assertAsyncResponseClosed { options ->
            CallServiceAsyncImpl(options)
                .reject(CallRejectParams.builder().callId("call_id").statusCode(486L).build())
        }
    }

    private fun assertBlockingResponseClosed(call: (ClientOptions) -> Unit) {
        val httpClient = mock<HttpClient>()
        val response = mockResponse()
        doReturn(response).whenever(httpClient).execute(any(), any())

        call(clientOptions(httpClient))

        verify(response, times(1)).close()
    }

    private fun assertAsyncResponseClosed(call: (ClientOptions) -> CompletableFuture<Void?>) {
        val httpClient = mock<HttpClient>()
        val response = mockResponse()
        doReturn(CompletableFuture.completedFuture(response))
            .whenever(httpClient)
            .executeAsync(any(), any())

        call(clientOptions(httpClient)).get()

        verify(response, times(1)).close()
    }

    private fun clientOptions(httpClient: HttpClient): ClientOptions =
        ClientOptions.builder()
            .httpClient(httpClient)
            .checkJacksonVersionCompatibility(false)
            .apiKey("My API Key")
            .adminApiKey("My Admin API Key")
            .build()

    private fun mockResponse(): HttpResponse =
        mock<HttpResponse>().also {
            whenever(it.statusCode()).thenReturn(204)
            whenever(it.headers()).thenReturn(Headers.builder().build())
        }
}
