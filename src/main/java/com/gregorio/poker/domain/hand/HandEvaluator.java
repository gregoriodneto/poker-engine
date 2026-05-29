package com.gregorio.poker.domain.hand;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.card.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandEvaluator {
    public HandEvaluator() { }

    public HandResult evaluate(List<Card> cards) {
        Map<Rank, Integer> handRanking = new HashMap<>();
        for (Card card: cards) {
            handRanking.put(card.getRank(), handRanking.getOrDefault(card.getRank(), 0) + 1);
        }

        return new HandResult(HandRank.ONE_PAIR);
    }
}