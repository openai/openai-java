package com.openai.example;

public final class Main {
    private Main() {}

    public static void main(String[] args) throws Exception {
        CompletionsExample.main(args);
        CompletionsAsyncExample.main(args);
        CompletionsStreamingExample.main(args);
        CompletionsStreamingAsyncExample.main(args);
        CompletionsConversationExample.main(args);
        CompletionsConversationAsyncExample.main(args);
        AssistantExample.main(args);
    }
}
