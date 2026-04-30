// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.groups.GroupCreateParams
import com.openai.models.admin.organization.groups.GroupUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GroupServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupServiceAsync = client.admin().organization().groups()

        val groupFuture = groupServiceAsync.create(GroupCreateParams.builder().name("x").build())

        val group = groupFuture.get()
        group.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupServiceAsync = client.admin().organization().groups()

        val groupFuture =
            groupServiceAsync.update(
                GroupUpdateParams.builder().groupId("group_id").name("x").build()
            )

        val group = groupFuture.get()
        group.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupServiceAsync = client.admin().organization().groups()

        val pageFuture = groupServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupServiceAsync = client.admin().organization().groups()

        val groupFuture = groupServiceAsync.delete("group_id")

        val group = groupFuture.get()
        group.validate()
    }
}
