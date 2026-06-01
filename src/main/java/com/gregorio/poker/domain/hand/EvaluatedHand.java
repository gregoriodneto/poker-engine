package com.gregorio.poker.domain.hand;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.player.Player;

import java.util.ArrayList;
import java.util.List;


public class EvaluatedHand {
    private final Player player;
    private final HandResult handRanking;
    private final List<Card> cardsOnTheTableAndThePlayer;

    public EvaluatedHand(Player player, HandResult handRanking, List<Card> cardsOnTheTableAndThePlayer) {
        this.player = player;
        this.handRanking = handRanking;
        this.cardsOnTheTableAndThePlayer = cardsOnTheTableAndThePlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public HandResult getHandRanking() {
        return handRanking;
    }

    @Override
    public String toString() {
        return "EvaluatedHand{" +
                "player=" + player.toString() +
                ", handRanking=" + handRanking.getHandRank() +
                ", cardsOnTheTableAndThePlayer=" + cardsOnTheTableAndThePlayer +
                '}';
    }
}
