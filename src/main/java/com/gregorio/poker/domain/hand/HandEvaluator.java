package com.gregorio.poker.domain.hand;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.card.Rank;
import com.gregorio.poker.domain.card.Suit;

import java.util.*;

public class HandEvaluator {
    public HandEvaluator() { }

    public HandResult evaluate(List<Card> cards) {
        Map<Rank, Integer> handRanking = new HashMap<>();
        List<Suit> suitsHandPlayer = new ArrayList<>();
        for (Card card: cards) {
            suitsHandPlayer.add(card.getSuit());
            handRanking.put(card.getRank(), handRanking.getOrDefault(card.getRank(), 0) + 1);
        }

        HandRank rank = resultHandRank(handRanking, suitsHandPlayer);
        return new HandResult(rank);
    }

    private HandRank resultHandRank(Map<Rank, Integer> handRanking, List<Suit> suitsHandPlayer) {
        int pairCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        boolean isFlush = true;
        boolean isSequence = true;

        // Verificando sequência
        List<Integer> sequenceValuesRank = new ArrayList<>();

        handRanking.forEach((key, value) -> {
            sequenceValuesRank.add(key.getValue());
        });

        sequenceValuesRank.sort(Comparator.naturalOrder());

        if (sequenceValuesRank.size() <5) {
            isSequence = false;
        } else {
            for (int i = 0; i < sequenceValuesRank.size() - 1; i++) {
                if (sequenceValuesRank.get(i + 1) != sequenceValuesRank.get(i) + 1) {
                    isSequence = false;
                    break;
                }
            }
        }

        // Verificando flush
        Suit primarySuitHand = suitsHandPlayer.get(0);
        for (Suit suit : suitsHandPlayer) {
            if (!suit.equals(primarySuitHand)) {
                isFlush = false;
                break;
            }
        }

        // Verificando pontuacoes das maos
        for (Integer value: handRanking.values()) {
            switch (value) {
                case 2 -> pairCount++;
                case 3 -> threeCount++;
                case 4 -> fourCount++;
            }
        }

        return statementResultHandRank(pairCount, threeCount, fourCount, isSequence, isFlush);
    }

    private HandRank statementResultHandRank(int pairCount, int threeCount, int fourCount, boolean isSequence, boolean isFlush) {
        if (isSequence && isFlush) {
            return HandRank.STRAIGHT_FLUSH;
        }

        if (isSequence) {
            return HandRank.STRAIGHT;
        }

        if (isFlush) {
            return HandRank.FLUSH;
        }

        if (pairCount >= 1 && threeCount >= 1) {
            return HandRank.FULL_HOUSE;
        }

        if (fourCount == 1) {
            return HandRank.FOUR_OF_A_KIND;
        }

        if (threeCount == 1) {
            return HandRank.THREE_OF_A_KIND;
        }

        if (pairCount == 2) {
            return HandRank.TWO_PAIR;
        }

        if (pairCount == 1) {
            return HandRank.ONE_PAIR;
        }

        return HandRank.HIGH_CARD;
    }
}