package com.openai.core.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

final class HttpRequestBodyJavaTest {

    @Test
    void contentIsJavaDefaultMethod() throws Exception {
        assertThat(HttpRequestBody.class.getMethod("content").isDefault()).isTrue();

        HttpRequestBody body =
                new HttpRequestBody() {
                    @Override
                    public void writeTo(OutputStream outputStream) {
                        try {
                            outputStream.write("body".getBytes(StandardCharsets.UTF_8));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public String contentType() {
                        return "text/plain";
                    }

                    @Override
                    public long contentLength() {
                        return 4L;
                    }

                    @Override
                    public boolean repeatable() {
                        return true;
                    }

                    @Override
                    public void close() {}
                };

        try (InputStream content = body.content()) {
            byte[] bytes = new byte[4];
            assertThat(content.read(bytes)).isEqualTo(bytes.length);
            assertThat(bytes).isEqualTo("body".getBytes(StandardCharsets.UTF_8));
            assertThat(content.read()).isEqualTo(-1);
        }
    }
}
