package com.openai.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams;
import java.util.List;

public final class StructuredOutputsExample {

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

    private StructuredOutputsExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        StructuredChatCompletionCreateParams<BookList> createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4O_MINI)
                .maxCompletionTokens(2048)
                .responseFormat(BookList.class)
                .addUserMessage("List some famous late twentieth century novels.")
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .flatMap(bookList -> bookList.books.stream())
                .forEach(book -> System.out.println(" - " + book));
    }
}
