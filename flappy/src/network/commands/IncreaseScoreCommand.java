package network.commands;

import game.multiplayer.OnlineLocalGame;
import game.multiplayer.OnlineRemoteGame;
import network.Command;

/**
 *  Comunica l'aumento del punteggio
 */
public class IncreaseScoreCommand extends Command {
    private static final long serialVersionUID = -539210512249000002L;

    @Override
    public void execute(OnlineRemoteGame remoteGame, OnlineLocalGame localGame) {
        remoteGame.increaseScore();
    }
}
