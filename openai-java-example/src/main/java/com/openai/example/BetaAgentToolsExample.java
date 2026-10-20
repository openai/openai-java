package com.openai.example;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.openai.client.OpenAIClient;
import com.openai.helpers.beta.agents.AgentFunctionTool;
import com.openai.models.beta.agents.AgentSessionStreamParams;
import com.openai.models.beta.agents.sessions.SessionCreateParams;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/** Bind a read-only catalog lookup without exposing application dependencies. */
public final class BetaAgentToolsExample {
    @JsonTypeName("lookup_item")
    @JsonClassDescription("Look up a catalog item.")
    public static final class LookupItem {
        public String itemId;
    }

    public static final class CatalogActions {
        private final String catalogId;

        public CatalogActions(String catalogId) {
            this.catalogId = catalogId;
        }

        public Map<String, String> lookup(LookupItem args) {
            // Replace this synthetic response with your application's authorized catalog lookup.
            return Map.of("itemId", args.itemId, "catalogId", catalogId, "name", "Example item");
        }
    }

    public static SessionCreateParams.Agent agent(String model, CatalogActions catalog) {
        var lookup = AgentFunctionTool.of(LookupItem.class, catalog::lookup);
        return SessionCreateParams.Agent.builder()
                .model(model)
                .addTool(lookup.definition())
                .build();
    }

    public static void followUp(OpenAIClient client, String sessionId, CatalogActions catalog) {
        var lookup = AgentFunctionTool.of(LookupItem.class, catalog::lookup);
        var params = AgentSessionStreamParams.builder()
                .sessionId(sessionId)
                .input("Look up item ITEM_A.")
                .toolHandler(lookup.name(), lookup.handler())
                .build();
        try (var stream = client.beta().agents().sessions().stream(params)) {
            stream.stream()
                    .forEach(event -> event.turnOutputTextDelta().ifPresent(delta -> System.out.print(delta.delta())));
        }
    }

    public static AgentSessionStreamParams asyncParams(String sessionId, CatalogActions catalog) {
        var lookup = AgentFunctionTool.ofAsync(
                LookupItem.class, args -> CompletableFuture.completedFuture(catalog.lookup(args)));
        return AgentSessionStreamParams.builder()
                .sessionId(sessionId)
                .input("Look up item ITEM_A.")
                .asyncToolHandler(lookup.name(), lookup.handler())
                .build();
    }
}
