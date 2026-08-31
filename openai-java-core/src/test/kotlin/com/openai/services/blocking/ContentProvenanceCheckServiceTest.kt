// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.contentprovenancechecks.ContentProvenanceCheckCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentProvenanceCheckServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val contentProvenanceCheckService = client.contentProvenanceChecks()

        val contentProvenanceCheck =
            contentProvenanceCheckService.create(
                ContentProvenanceCheckCreateParams.builder()
                    .file("Example data".byteInputStream())
                    .build()
            )

        contentProvenanceCheck.validate()
    }
}
