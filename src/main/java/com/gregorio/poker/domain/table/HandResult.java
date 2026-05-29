package com.gregorio.poker.domain.table;

import com.gregorio.poker.domain.card.HandRank;

public class HandResult {
    private final HandRank handRank;

    public HandResult(HandRank handRank) {
        this.handRank = handRank;
    }

    public HandRank getHandRank() {
        return handRank;
    }
}
