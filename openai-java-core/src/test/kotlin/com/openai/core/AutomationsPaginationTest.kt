package com.openai.core

import com.openai.client.OpenAIClientImpl
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.models.beta.agents.automations.Automation
import com.openai.models.beta.agents.automations.AutomationListParams
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class AutomationsPaginationTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun unknownVariantContinuesWithEnvelopeCursor(async: Boolean) {
        for (automatic in listOf(false, true)) {
            checkPagination(
                async,
                automatic,
                "future_schedule",
                "\"last_id\":\"envelope_cursor\",",
                true,
                false,
                "envelope_cursor",
            )
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun missingEnvelopeCursorFallsBackToItemId(async: Boolean) {
        for (automatic in listOf(false, true)) {
            for (variant in listOf("once", "periodic")) {
                checkPagination(async, automatic, variant, "", true, false, "item_cursor")
                checkPagination(
                    async,
                    automatic,
                    variant,
                    "\"last_id\":null,",
                    true,
                    false,
                    "item_cursor",
                )
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun envelopeCursorTakesPrecedenceOverRecognizedItemId(async: Boolean) {
        checkPagination(
            async,
            true,
            "once",
            "\"last_id\":\"envelope_cursor\",",
            true,
            false,
            "envelope_cursor",
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun terminalFlagStopsUnknownVariantWithoutCursor(async: Boolean) {
        checkPagination(async, true, "future_schedule", "", false, false, null)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun emptyPageStopsEvenWithEnvelopeCursor(async: Boolean) {
        checkPagination(async, true, "future_schedule", "\"last_id\":\"unused\",", true, true, null)
    }

    private fun checkPagination(
        async: Boolean,
        automatic: Boolean,
        variant: String,
        cursorField: String,
        hasMore: Boolean,
        empty: Boolean,
        expectedCursor: String?,
    ) {
        val items = if (empty) "[]" else """[{"id":"item_cursor","type":"$variant"}]"""
        val first = """{"data":$items,${cursorField}"has_more":$hasMore,"object":"list"}"""
        val last =
            """{"data":[{"id":"last_item","type":"once"}],"has_more":false,"object":"list"}"""
        val transport = mock<HttpClient>()
        val firstResponse = response(first)
        val lastResponse = response(last)
        if (async) {
            whenever(transport.executeAsync(any(), any()))
                .thenReturn(
                    CompletableFuture.completedFuture(firstResponse),
                    CompletableFuture.completedFuture(lastResponse),
                )
        } else {
            whenever(transport.execute(any(), any())).thenReturn(firstResponse, lastResponse)
        }
        val client =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .baseUrl("https://example.test")
                    .apiKey("test-key")
                    .build()
            )
        val params =
            AutomationListParams.builder().limit(2).order(AutomationListParams.Order.ASC).build()
        val collected = mutableListOf<Automation>()
        try {
            if (async) {
                val page =
                    client
                        .async()
                        .beta()
                        .agents()
                        .automations()
                        .list(params)
                        .get(10, TimeUnit.SECONDS)
                assertThat(page.hasNextPage()).isEqualTo(expectedCursor != null)
                if (automatic) {
                    page
                        .autoPager()
                        .subscribe({ collected.add(it) }, { it.run() })
                        .onCompleteFuture()
                        .get(10, TimeUnit.SECONDS)
                } else {
                    assertThat(page.nextPageParams().after()).contains(expectedCursor)
                    collected.addAll(page.items())
                    val next = page.nextPage().get(10, TimeUnit.SECONDS)
                    assertThat(next.hasNextPage()).isFalse()
                    collected.addAll(next.items())
                }
            } else {
                val page = client.beta().agents().automations().list(params)
                assertThat(page.hasNextPage()).isEqualTo(expectedCursor != null)
                if (automatic) {
                    collected.addAll(page.autoPager().toList())
                } else {
                    assertThat(page.nextPageParams().after()).contains(expectedCursor)
                    collected.addAll(page.items())
                    val next = page.nextPage()
                    assertThat(next.hasNextPage()).isFalse()
                    collected.addAll(next.items())
                }
            }
            assertThat(collected).hasSize(if (expectedCursor != null) 2 else if (empty) 0 else 1)
            if (variant == "future_schedule" && !empty) {
                assertThat(collected.first()._json()).isPresent()
            }
            val requests = argumentCaptor<HttpRequest>()
            val count = if (expectedCursor != null) 2 else 1
            if (async) verify(transport, times(count)).executeAsync(requests.capture(), any())
            else verify(transport, times(count)).execute(requests.capture(), any())
            for (request in requests.allValues) {
                assertThat(request.queryParams.values("limit")).containsExactly("2")
                assertThat(request.queryParams.values("order")).containsExactly("asc")
            }
            if (expectedCursor != null) {
                assertThat(requests.lastValue.queryParams.values("after"))
                    .containsExactly(expectedCursor)
            }
        } finally {
            client.close()
        }
    }

    private fun response(body: String): HttpResponse {
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(200)
        whenever(response.headers())
            .thenReturn(Headers.builder().put("Content-Type", "application/json").build())
        whenever(response.body()).thenReturn(ByteArrayInputStream(body.toByteArray()))
        return response
    }
}
