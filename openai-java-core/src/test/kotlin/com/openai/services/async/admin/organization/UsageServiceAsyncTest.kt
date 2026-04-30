// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
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
internal class UsageServiceAsyncTest {

    @Test
    fun audioSpeeches() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.audioSpeeches(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun audioTranscriptions() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.audioTranscriptions(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun codeInterpreterSessions() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.codeInterpreterSessions(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun completions() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.completions(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun costs() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.costs(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun embeddings() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.embeddings(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun images() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.images(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun moderations() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.moderations(
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

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun vectorStores() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val usageServiceAsync = client.admin().organization().usage()

        val responseFuture =
            usageServiceAsync.vectorStores(
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

        val response = responseFuture.get()
        response.validate()
    }
}
