package com.gregorio;

import com.gregorio.poker.domain.card.Card;
import com.gregorio.poker.domain.deck.Deck;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();

        Card drawCard1 = deck.drawCard();
        Card drawCard2 = deck.drawCard();
        System.out.println("Drawn card: " + drawCard1);
        System.out.println("Drawn card: " + drawCard2);

        System.out.println(deck.remainingCards());
    }
}