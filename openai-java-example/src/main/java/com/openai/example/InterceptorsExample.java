package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import okhttp3.Interceptor;

public final class InterceptorsExample {
    private InterceptorsExample() {}

    public static void main(String[] args) {
        Interceptor applicationHeader = chain -> chain.proceed(chain.request()
                .newBuilder()
                .header("X-Application", "java-example")
                .build());

        OpenAIClient client = OpenAIOkHttpClient.builder()
                .fromEnv()
                .addInterceptor(applicationHeader)
                .build();
        try {
            client.models().list().data().forEach(model -> System.out.println(model.id()));
        } finally {
            client.close();
        }

        OpenAIClientAsync asyncClient = OpenAIOkHttpClientAsync.builder()
                .fromEnv()
                .addInterceptor(applicationHeader)
                .build();
        try {
            asyncClient
                    .models()
                    .list()
                    .thenAccept(page -> page.data().forEach(model -> System.out.println(model.id())))
                    .join();
        } finally {
            asyncClient.close();
        }
    }
}
