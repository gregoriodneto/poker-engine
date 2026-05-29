package com.gregorio;

import com.gregorio.poker.domain.game.Modality;
import com.gregorio.poker.domain.deck.Deck;
import com.gregorio.poker.domain.player.Player;
import com.gregorio.poker.domain.table.Table;

public class Main {
    public static void main(String[] args) throws Exception {
        Player player = new Player("Greg", Modality.TEXAS);

        Table table = new Table(Modality.TEXAS, 9);
        table.addPlayer(player);

        table.startGame();

        System.out.println(player.showHand());
    }
}