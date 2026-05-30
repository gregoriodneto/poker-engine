package com.gregorio.poker.domain.hand;

import com.gregorio.poker.domain.player.Player;


public class EvaluatedHand {
    private final Player player;
    private final HandResult handRanking;

    public EvaluatedHand(Player player, HandResult handRanking) {
        this.player = player;
        this.handRanking = handRanking;
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
                '}';
    }
}
