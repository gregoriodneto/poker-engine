package com.gregorio.poker.domain.table;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.card.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandEvaluator {
    public HandEvaluator() { }

    public Map<Rank, Integer> evaluate(List<Card> cards) {
        Map<Rank, Integer> handRanking = new HashMap<>();
        for (Card card: cards) {
            if (handRanking.containsKey(card.getRank())) {
                handRanking.put(card.getRank(), handRanking.get(card.getRank()) + 1);
            } else {
                handRanking.put(card.getRank(), 1);
            }
        }

        return handRanking;
    }
}