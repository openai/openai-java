package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.Timeout;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

public final class OkHttpConfigurationExample {
    private OkHttpConfigurationExample() {}

    public static void main(String[] args) throws Exception {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(100);
        dispatcher.setMaxRequestsPerHost(20);
        OkHttpClient transport = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .connectionPool(new ConnectionPool(10, 5, TimeUnit.MINUTES))
                .connectTimeout(Duration.ofSeconds(15))
                .readTimeout(Duration.ofMinutes(2))
                .callTimeout(Duration.ofMinutes(5))
                .addInterceptor(chain -> chain.proceed(chain.request()
                        .newBuilder()
                        .header("X-Application", "java-example")
                        .build()))
                .build();
        try {
            OpenAIClient client = OpenAIOkHttpClient.builder()
                    .fromEnv()
                    .okHttpClient(transport)
                    .build();
            try {
                client.models().list().data().forEach(model -> System.out.println(model.id()));
            } finally {
                client.close();
            }

            // The same transport remains usable after the first SDK client is closed.
            // This client explicitly uses SDK timeouts instead of the native timeouts.
            OpenAIClientAsync asyncClient = OpenAIOkHttpClientAsync.builder()
                    .fromEnv()
                    .okHttpClient(transport)
                    .timeout(Timeout.builder().build())
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
        } finally {
            // The application owns these shared resources and releases them after all users finish.
            transport.dispatcher().executorService().shutdown();
            transport.connectionPool().evictAll();
            if (transport.cache() != null) transport.cache().close();
        }
    }
}
