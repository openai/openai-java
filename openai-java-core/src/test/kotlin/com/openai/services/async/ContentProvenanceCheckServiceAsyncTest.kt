// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.contentprovenancechecks.ContentProvenanceCheckCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentProvenanceCheckServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val contentProvenanceCheckServiceAsync = client.contentProvenanceChecks()

        val contentProvenanceCheckFuture =
            contentProvenanceCheckServiceAsync.create(
                ContentProvenanceCheckCreateParams.builder()
                    .file("Example data".byteInputStream())
                    .build()
            )

        val contentProvenanceCheck = contentProvenanceCheckFuture.get()
        contentProvenanceCheck.validate()
    }
}
