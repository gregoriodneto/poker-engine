package com.gregorio.poker.domain.table;

import com.gregorio.poker.domain.deck.Deck;
import com.gregorio.poker.domain.game.Modality;
import com.gregorio.poker.domain.hand.EvaluatedHand;
import com.gregorio.poker.domain.hand.HandEvaluator;
import com.gregorio.poker.domain.player.Player;
import com.gregorio.poker.exception.HandLimitExceededException;
import com.gregorio.poker.exception.QuantityPlayersExceededTableException;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final Deck deck;
    private final List<Player> players;
    private final Modality modality;
    private final int maxPlayers;
    private final HandEvaluator handEvaluator;
    private final List<EvaluatedHand> evaluatedHands;

    public Table(Modality modality, int maxPlayers) throws QuantityPlayersExceededTableException {
        if (maxPlayers > 9) {
            throw new QuantityPlayersExceededTableException("Uma mesa não pode ter mais de 9 posições.");
        }
        this.modality = modality;
        this.players = new ArrayList<>();
        this.maxPlayers = maxPlayers;
        this.deck = new Deck();
        this.handEvaluator = new HandEvaluator();
        this.evaluatedHands = new ArrayList<>();
    }

    public void addPlayer(Player player) throws QuantityPlayersExceededTableException {
        if (this.players.size() >= maxPlayers) {
            throw new QuantityPlayersExceededTableException("Quantidade de jogadores máximo atingido!");
        }
        this.players.add(player);
    }

    public void startGame() throws HandLimitExceededException {
        deck.shuffle();

        for (Player player : players) {
            for (int i = 0; i < modality.getValue(); i++) {
                player.receiveCard(deck.drawCard());
            }

            EvaluatedHand evaluatedHand = new EvaluatedHand(
                    player,
                    handEvaluator.evaluate(player.getHand())
            );

            evaluatedHands.add(evaluatedHand);
        }

        for (EvaluatedHand evaluate : evaluatedHands) {
            System.out.println(evaluate.toString());
        }
    }
}
