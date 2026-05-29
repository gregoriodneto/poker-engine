package com.gregorio.poker.domain.hand;

public class HandResult {
    private final HandRank handRank;

    public HandResult(HandRank handRank) {
        this.handRank = handRank;
    }

    public HandRank getHandRank() {
        return handRank;
    }
}
