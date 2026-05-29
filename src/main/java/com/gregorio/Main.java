package com.gregorio;

import com.gregorio.poker.domain.game.Modality;
import com.gregorio.poker.domain.deck.Deck;
import com.gregorio.poker.domain.player.Player;

public class Main {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();

        deck.shuffle();

        Player player = new Player("Greg", Modality.TEXAS);
        player.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());

        System.out.println(player.showHand());

        System.out.println(deck.remainingCards());
    }
}