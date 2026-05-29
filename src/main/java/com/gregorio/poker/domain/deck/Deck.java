package com.gregorio.poker.domain.deck;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.card.Rank;
import com.gregorio.poker.domain.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();

        initializeDeck();
    }

    // Embaralhar o deck
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    // Tirar carta
    public Card drawCard() {
        return this.cards.removeFirst();
    }

    // Quantidade de cartas restantes
    public int remainingCards() {
        return this.cards.size();
    }

    // Inicializando o Deck
    private void initializeDeck() {
        final Suit[] suits = Suit.values();
        final Rank[] ranks = Rank.values();

        for (Suit suit: suits) {
            for (Rank rank : ranks) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }
}
