// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.usage.UsageAudioSpeechesParams
import com.openai.models.admin.organization.usage.UsageAudioTranscriptionsParams
import com.openai.models.admin.organization.usage.UsageCodeInterpreterSessionsParams
import com.openai.models.admin.organization.usage.UsageCompletionsParams
import com.openai.models.admin.organization.usage.UsageCostsParams
import com.openai.models.admin.organization.usage.UsageEmbeddingsParams
import com.openai.models.admin.organization.usage.UsageImagesParams
import com.openai.models.admin.organization.usage.UsageModerationsParams
import com.openai.models.admin.organization.usage.UsageVectorStoresParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UsageServiceTest {

    @Test
    fun audioSpeeches() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.audioSpeeches(
                UsageAudioSpeechesParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .bucketWidth(UsageAudioSpeechesParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageAudioSpeechesParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .addModel("string")
                    .page("page")
                    .addProjectId("string")
                    .addUserId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun audioTranscriptions() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.audioTranscriptions(
                UsageAudioTranscriptionsParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .bucketWidth(UsageAudioTranscriptionsParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageAudioTranscriptionsParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .addModel("string")
                    .page("page")
                    .addProjectId("string")
                    .addUserId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun codeInterpreterSessions() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.codeInterpreterSessions(
                UsageCodeInterpreterSessionsParams.builder()
                    .startTime(0L)
                    .bucketWidth(UsageCodeInterpreterSessionsParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageCodeInterpreterSessionsParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .page("page")
                    .addProjectId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun completions() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.completions(
                UsageCompletionsParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .batch(true)
                    .bucketWidth(UsageCompletionsParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageCompletionsParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .addModel("string")
                    .page("page")
                    .addProjectId("string")
                    .addUserId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun costs() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.costs(
                UsageCostsParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .bucketWidth(UsageCostsParams.BucketWidth._1D)
                    .endTime(0L)
                    .addGroupBy(UsageCostsParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .page("page")
                    .addProjectId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun embeddings() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.embeddings(
                UsageEmbeddingsParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .bucketWidth(UsageEmbeddingsParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageEmbeddingsParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .addModel("string")
                    .page("page")
                    .addProjectId("string")
                    .addUserId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun images() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.images(
                UsageImagesParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .bucketWidth(UsageImagesParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageImagesParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .addModel("string")
                    .page("page")
                    .addProjectId("string")
                    .addSize(UsageImagesParams.Size._256X256)
                    .addSource(UsageImagesParams.Source.IMAGE_GENERATION)
                    .addUserId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun moderations() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.moderations(
                UsageModerationsParams.builder()
                    .startTime(0L)
                    .addApiKeyId("string")
                    .bucketWidth(UsageModerationsParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageModerationsParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .addModel("string")
                    .page("page")
                    .addProjectId("string")
                    .addUserId("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun vectorStores() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageService = client.admin().organization().usage()

        val response =
            usageService.vectorStores(
                UsageVectorStoresParams.builder()
                    .startTime(0L)
                    .bucketWidth(UsageVectorStoresParams.BucketWidth._1M)
                    .endTime(0L)
                    .addGroupBy(UsageVectorStoresParams.GroupBy.PROJECT_ID)
                    .limit(0L)
                    .page("page")
                    .addProjectId("string")
                    .build()
            )

        response.validate()
    }
}
