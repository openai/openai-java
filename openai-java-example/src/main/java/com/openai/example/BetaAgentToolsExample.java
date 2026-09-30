package com.openai.example;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.openai.client.OpenAIClient;
import com.openai.lib.beta.agents.AgentFunctionTool;
import com.openai.models.beta.agents.AgentSessionStreamParams;
import com.openai.models.beta.agents.sessions.SessionCreateParams;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/** Bind a read-only, Coinbase-style application action without exposing application dependencies. */
public final class BetaAgentToolsExample {
    @JsonTypeName("wallet_balance")
    @JsonClassDescription("Look up a wallet balance.")
    public static final class Balance {
        public String asset;
    }

    public static final class WalletActions {
        private final String network;

        public WalletActions(String network) {
            this.network = network;
        }

        public Map<String, String> balance(Balance args) {
            // Replace this synthetic response with your application's authorized wallet lookup.
            return Map.of("asset", args.asset, "network", network, "balance", "0");
        }
    }

    public static SessionCreateParams.Agent agent(String model, WalletActions wallet) {
        var balance = AgentFunctionTool.of(Balance.class, wallet::balance);
        return SessionCreateParams.Agent.builder()
                .model(model)
                .addTool(balance.definition())
                .build();
    }

    public static void followUp(OpenAIClient client, String sessionId, WalletActions wallet) {
        var balance = AgentFunctionTool.of(Balance.class, wallet::balance);
        var params = AgentSessionStreamParams.builder()
                .sessionId(sessionId)
                .input("What is my ETH balance?")
                .toolHandler(balance.name(), balance.handler())
                .build();
        try (var stream = client.beta().agents().sessions().stream(params)) {
            stream.stream()
                    .forEach(event -> event.turnOutputTextDelta().ifPresent(delta -> System.out.print(delta.delta())));
        }
    }

    public static AgentSessionStreamParams asyncParams(String sessionId, WalletActions wallet) {
        var balance = AgentFunctionTool.ofAsync(
                Balance.class, args -> CompletableFuture.completedFuture(wallet.balance(args)));
        return AgentSessionStreamParams.builder()
                .sessionId(sessionId)
                .input("What is my ETH balance?")
                .asyncToolHandler(balance.name(), balance.handler())
                .build();
    }
}
