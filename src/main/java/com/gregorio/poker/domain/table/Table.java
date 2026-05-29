package com.gregorio.poker.domain.table;

import com.gregorio.poker.domain.deck.Deck;
import com.gregorio.poker.domain.game.Modality;
import com.gregorio.poker.domain.player.Player;
import com.gregorio.poker.exception.QuantityPlayersExceededTableException;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final Deck deck;
    private final List<Player> players;
    private final Modality modality;
    private final int quantity;

    public Table(Deck deck, Modality modality, int quantity) throws QuantityPlayersExceededTableException {
        this.deck = deck;
        this.modality = modality;
        this.players = new ArrayList<>();
        if (quantity > 9) {
            throw new QuantityPlayersExceededTableException("Uma mesa não pode ter mais de 9 posições.");
        }
        this.quantity = quantity;
    }

    public void addPlayer(Player player) throws QuantityPlayersExceededTableException {
        if (this.players.size() >= quantity) {
            throw new QuantityPlayersExceededTableException("Quantidade de jogadores máximo atingido!");
        }
        this.players.add(player);
    }

    public void startGame() throws Exception {
        deck.shuffle();

        for (Player player : players) {
            player.receiveCard(deck.drawCard());
            player.receiveCard(deck.drawCard());
        }
    }
}
