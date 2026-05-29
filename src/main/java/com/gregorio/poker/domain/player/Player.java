package com.gregorio.poker.domain.player;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.game.Modality;
import com.gregorio.poker.exception.HandLimitExceededException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final String name;
    private final Modality pokerModality;
    private final List<Card> hand;

    public Player(String name, Modality pokerModality) {
        this.name = name;
        this.pokerModality = pokerModality;
        this.hand = new ArrayList<>();
    }

    public void receiveCard(Card card) throws Exception {
        if (this.hand.size() >= pokerModality.getValue()) {
            throw new HandLimitExceededException("Não pode ultrapassar o número máximo de cartas da modalidade selecionada.");
        }

        this.hand.add(card);
    }

    public List<Card> getHand() {
        return Collections.unmodifiableList(this.hand);
    }

    public String showHand() {
        StringBuilder info = new StringBuilder("Player: " + name + "\n");
        for (Card card: hand) {
            info.append(card.toString()).append("\n");
        }
        return info.toString();
    }
}
