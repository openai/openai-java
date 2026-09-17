// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.environments

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.environments.files.FileCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.beta().agents().environments().files()

        val environmentFileFuture =
            fileServiceAsync.create(
                FileCreateParams.builder()
                    .environmentId("environment_id")
                    .hostedEnvironmentFileParam(
                        HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                    )
                    .build()
            )

        val environmentFile = environmentFileFuture.get()
        environmentFile.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.beta().agents().environments().files()

        val pageFuture = fileServiceAsync.list("environment_id")

        val page = pageFuture.get()
        page.response().validate()
    }
}
