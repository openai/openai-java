package com.openai.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.helpers.ResponseAccumulator;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.StructuredResponseCreateParams;
import java.util.List;

public final class ResponsesStructuredOutputsStreamingAsyncExample {

    public static class Person {
        @JsonPropertyDescription("The first name and surname of the person.")
        public String name;

        public int birthYear;

        @JsonPropertyDescription("The year the person died, or 'present' if the person is living.")
        public String deathYear;

        @Override
        public String toString() {
            return name + " (" + birthYear + '-' + deathYear + ')';
        }
    }

    public static class Book {
        public String title;

        public Person author;

        @JsonPropertyDescription("The year in which the book was first published.")
        public int publicationYear;

        public String genre;

        @JsonIgnore
        public String isbn;

        @Override
        public String toString() {
            return '"' + title + "\" (" + publicationYear + ") [" + genre + "] by " + author;
        }
    }

    public static class BookList {
        public List<Book> books;
    }

    private ResponsesStructuredOutputsStreamingAsyncExample() {}

    public static void main(String[] args) {
        // Configure using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        StructuredResponseCreateParams<BookList> createParams = ResponseCreateParams.builder()
                .input("List some famous late twentieth century novels.")
                .text(BookList.class)
                .model(ChatModel.GPT_4O)
                .build();

        ResponseAccumulator accumulator = ResponseAccumulator.create();

        client.responses()
                .createStreaming(createParams)
                .subscribe(event -> accumulator
                        .accumulate(event)
                        .outputTextDelta()
                        .ifPresent(textEvent -> System.out.print(textEvent.delta())))
                .onCompleteFuture()
                .join();
        System.out.println();

        accumulator.response(BookList.class).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .flatMap(bookList -> bookList.books.stream())
                .forEach(book -> System.out.println(" - " + book));
    }
}
