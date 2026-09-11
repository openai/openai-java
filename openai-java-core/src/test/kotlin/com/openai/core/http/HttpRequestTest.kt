package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class HttpRequestTest {

    enum class UrlTestCase(val request: HttpRequest, val expectedUrl: String) {
        BASE_URL_ONLY(
            HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://api.example.com").build(),
            expectedUrl = "https://api.example.com",
        ),
        BASE_URL_WITH_TRAILING_SLASH(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com/")
                .build(),
            expectedUrl = "https://api.example.com/",
        ),
        SINGLE_PATH_SEGMENT(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .build(),
            expectedUrl = "https://api.example.com/users",
        ),
        MULTIPLE_PATH_SEGMENTS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegments("users", "123", "profile")
                .build(),
            expectedUrl = "https://api.example.com/users/123/profile",
        ),
        PATH_SEGMENT_WITH_SPECIAL_CHARS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("user name")
                .build(),
            expectedUrl = "https://api.example.com/user+name",
        ),
        SINGLE_QUERY_PARAM(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .putQueryParam("limit", "10")
                .build(),
            expectedUrl = "https://api.example.com/users?limit=10",
        ),
        MULTIPLE_QUERY_PARAMS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .putQueryParam("limit", "10")
                .putQueryParam("offset", "20")
                .build(),
            expectedUrl = "https://api.example.com/users?limit=10&offset=20",
        ),
        QUERY_PARAM_WITH_SPECIAL_CHARS(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("search")
                .putQueryParam("q", "hello world")
                .build(),
            expectedUrl = "https://api.example.com/search?q=hello+world",
        ),
        MULTIPLE_VALUES_SAME_PARAM(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com")
                .addPathSegment("users")
                .putQueryParams("tags", listOf("admin", "user"))
                .build(),
            expectedUrl = "https://api.example.com/users?tags=admin&tags=user",
        ),
        BASE_URL_WITH_TRAILING_SLASH_AND_PATH(
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.example.com/")
                .addPathSegment("users")
                .build(),
            expectedUrl = "https://api.example.com/users",
        ),
        COMPLEX_URL(
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://api.example.com")
                .addPathSegments("v1", "users", "123")
                .putQueryParams("include", listOf("profile", "settings"))
                .putQueryParam("format", "json")
                .build(),
            expectedUrl =
                "https://api.example.com/v1/users/123?include=profile&include=settings&format=json",
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun url(testCase: UrlTestCase) {
        val actualUrl = testCase.request.url()

        assertThat(actualUrl).isEqualTo(testCase.expectedUrl)
    }
}
