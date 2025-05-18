package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
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

/**
 * Example demonstrating how to use the Batch API to process multiple requests efficiently.
 * 
 * The Batch API is useful when you need to process a large number of requests (up to 50,000)
 * within a 24-hour window. The input file can be up to 200 MB in size.
 * 
 * This example shows:
 * 1. Creating a JSONL file with multiple requests
 * 2. Uploading the file to OpenAI
 * 3. Creating and executing a batch
 * 4. Checking batch status
 * 5. Processing the results
 */
public class BatchProcessingExample {
    public static void main(String[] args) {
        // Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID` and `OPENAI_BASE_URL` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        try {
            // First, create a JSONL file containing your requests
            // Example content of requests.jsonl:
            // {"model": "gpt-4", "messages": [{"role": "user", "content": "Hello"}]}
            // {"model": "gpt-4", "messages": [{"role": "user", "content": "World"}]}

            // Upload the JSONL file
            FileCreateParams fileParams = FileCreateParams.builder()
                .purpose(FilePurpose.BATCH)
                .file(Paths.get("requests.jsonl"))
                .build();
            FileObject file = client.files().create(fileParams);

            // Create and execute the batch
            BatchCreateParams batchParams = BatchCreateParams.builder()
                .inputFileId(file.id())
                .endpoint(Endpoint.CHAT_COMPLETIONS)
                .build();
            Batch batch = client.batches().create(batchParams);

            // Check batch status
            Batch retrievedBatch = client.batches().retrieve(
                BatchRetrieveParams.builder()
                    .batchId(batch.id())
                    .build()
            );

            // Get batch results
            if (retrievedBatch.status().equals("completed")) {
                // Download and process the output file
                String outputFileId = retrievedBatch.outputFileId().get();
                
                // Download the output file
                try (HttpResponse response = client.files().content(
                    FileContentParams.builder()
                        .fileId(outputFileId)
                        .build()
                )) {
                    // Process the output file line by line
                    try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.body())
                    )) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Each line is a JSON object containing the response
                            // Process each response as needed
                            System.out.println("Response: " + line);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
} 