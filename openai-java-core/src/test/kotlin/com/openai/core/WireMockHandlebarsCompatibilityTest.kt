package com.openai.core

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer
import java.net.HttpURLConnection
import java.net.URL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WireMockHandlebarsCompatibilityTest {

    @Test
    fun rendersResponseTemplate() {
        val server =
            WireMockServer(
                wireMockConfig().dynamicPort().extensions(ResponseTemplateTransformer(false))
            )
        server.start()

        try {
            server.stubFor(
                get(urlEqualTo("/greeting"))
                    .willReturn(
                        aResponse()
                            .withTransformers("response-template")
                            .withBody("Hello {{request.headers.X-Name}}!")
                    )
            )

            val connection =
                URL("${server.baseUrl()}/greeting").openConnection() as HttpURLConnection
            connection.setRequestProperty("X-Name", "SDK")

            assertThat(connection.inputStream.bufferedReader().use { it.readText() })
                .isEqualTo("Hello SDK!")
        } finally {
            server.stop()
        }
    }
}
