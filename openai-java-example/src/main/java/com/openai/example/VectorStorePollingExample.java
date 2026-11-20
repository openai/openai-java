package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.helpers.VectorStoreHelpers;
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams;
import com.openai.models.vectorstores.filebatches.VectorStoreFileBatch;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Upload local files to an existing vector store and wait for ingestion. */
public final class VectorStorePollingExample {
    private VectorStorePollingExample() {}

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: <vector-store-id> <file-path> [file-path ...]");
        }
        List<Path> paths = Arrays.stream(args).skip(1).map(Paths::get).collect(Collectors.toList());
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        try {
            VectorStoreHelpers helpers = VectorStoreHelpers.builder()
                    .client(client)
                    .timeout(Duration.ofMinutes(10))
                    .maxConcurrency(3)
                    .build();
            VectorStoreFileBatch batch = helpers.uploadAndPoll(
                    FileBatchCreateParams.builder().vectorStoreId(args[0]).build(), paths);
            // A terminal batch is not necessarily successful. Inspect counts for partial failures.
            System.out.println("Batch status: " + batch.status());
            System.out.println("Completed files: " + batch.fileCounts().completed());
            System.out.println("Failed files: " + batch.fileCounts().failed());
        } finally {
            client.close();
        }
    }
}
