// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.chatkit

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ThreadServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().chatkit().threads()

        val chatkitThreadFuture = threadServiceAsync.retrieve("cthr_123")

        val chatkitThread = chatkitThreadFuture.get()
        chatkitThread.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().chatkit().threads()

        val pageFuture = threadServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().chatkit().threads()

        val threadFuture = threadServiceAsync.delete("cthr_123")

        val thread = threadFuture.get()
        thread.validate()
    }

    @Test
    fun listItems() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.beta().chatkit().threads()

        val pageFuture = threadServiceAsync.listItems("cthr_123")

        val page = pageFuture.get()
        page.response().validate()
    }
}
