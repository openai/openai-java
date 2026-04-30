// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ServiceAccountServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceAccountServiceAsync = client.admin().organization().projects().serviceAccounts()

        val serviceAccountFuture =
            serviceAccountServiceAsync.create(
                ServiceAccountCreateParams.builder().projectId("project_id").name("name").build()
            )

        val serviceAccount = serviceAccountFuture.get()
        serviceAccount.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceAccountServiceAsync = client.admin().organization().projects().serviceAccounts()

        val projectServiceAccountFuture =
            serviceAccountServiceAsync.retrieve(
                ServiceAccountRetrieveParams.builder()
                    .projectId("project_id")
                    .serviceAccountId("service_account_id")
                    .build()
            )

        val projectServiceAccount = projectServiceAccountFuture.get()
        projectServiceAccount.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceAccountServiceAsync = client.admin().organization().projects().serviceAccounts()

        val pageFuture = serviceAccountServiceAsync.list("project_id")

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
        val serviceAccountServiceAsync = client.admin().organization().projects().serviceAccounts()

        val serviceAccountFuture =
            serviceAccountServiceAsync.delete(
                ServiceAccountDeleteParams.builder()
                    .projectId("project_id")
                    .serviceAccountId("service_account_id")
                    .build()
            )

        val serviceAccount = serviceAccountFuture.get()
        serviceAccount.validate()
    }
}
