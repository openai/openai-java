package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.http.HttpResponse;
import com.openai.models.batches.Batch;
import com.openai.models.batches.BatchCreateParams;
import com.openai.models.batches.BatchRetrieveParams;
import com.openai.models.batches.Endpoint;
import com.openai.models.files.FileContentParams;
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

/**
 * Example demonstrating how to use the Batch API asynchronously to process multiple requests efficiently.
 * 
 * The Batch API is useful when you need to process a large number of requests (up to 50,000)
 * within a 24-hour window. The input file can be up to 200 MB in size.
 * 
 * This example shows:
 * 1. Creating a JSONL file with multiple requests
 * 2. Uploading the file to OpenAI asynchronously
 * 3. Creating and executing a batch asynchronously
 * 4. Checking batch status asynchronously
 * 5. Processing the results asynchronously
 */
public class BatchProcessingAsyncExample {
    public static void main(String[] args) {
        // Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID` and `OPENAI_BASE_URL` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        try {
            // First, create a JSONL file containing your requests
            // Example content of requests.jsonl:
            // {"model": "gpt-4", "messages": [{"role": "user", "content": "Hello"}]}
            // {"model": "gpt-4", "messages": [{"role": "user", "content": "World"}]}

            // Upload the JSONL file asynchronously
            FileCreateParams fileParams = FileCreateParams.builder()
                .purpose(FilePurpose.BATCH)
                .file(Paths.get("requests.jsonl"))
                .build();
            CompletableFuture<FileObject> fileFuture = client.files().create(fileParams);

            // Create and execute the batch asynchronously
            fileFuture.thenCompose(file -> {
                BatchCreateParams batchParams = BatchCreateParams.builder()
                    .inputFileId(file.id())
                    .endpoint(Endpoint.CHAT_COMPLETIONS)
                    .build();
                return client.batches().create(batchParams);
            })
            // Check batch status asynchronously
            .thenCompose(batch -> client.batches().retrieve(
                BatchRetrieveParams.builder()
                    .batchId(batch.id())
                    .build()
            ))
            // Get batch results asynchronously
            .thenCompose(retrievedBatch -> {
                if (retrievedBatch.status().equals("completed")) {
                    String outputFileId = retrievedBatch.outputFileId().get();
                    return client.files().content(
                        FileContentParams.builder()
                            .fileId(outputFileId)
                            .build()
                    );
                }
                return CompletableFuture.completedFuture(null);
            })
            // Process the results
            .thenAccept(response -> {
                if (response != null) {
                    try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.body())
                    )) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Each line is a JSON object containing the response
                            // Process each response as needed
                            System.out.println("Response: " + line);
                        }
                    } catch (Exception e) {
                        System.out.println("Error processing results: " + e.getMessage());
                    }
                }
            })
            .exceptionally(e -> {
                System.out.println("Something went wrong!");
                e.printStackTrace();
                return null;
            })
            .join(); // Wait for all operations to complete
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
} 