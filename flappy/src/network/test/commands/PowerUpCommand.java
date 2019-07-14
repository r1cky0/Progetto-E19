package network.test.commands;

import game.OnlineLocalGame;
import game.RemoteGame;
import game.powerUps.PowerUp;
import logic.player.MultiModePlayer;

public class PowerUpCommand extends Command {
    private static final long serialVersionUID = -539210512249000007L;

    private PowerUp powerUp;

    public PowerUpCommand(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    @Override
    public void execute(RemoteGame remoteGame, OnlineLocalGame localGame) {
        if(powerUp.getAffectedGame()==PowerUp.LOCAL_GAME) {
            MultiModePlayer enemy = remoteGame.getPlayer();
            enemy.setCoins(enemy.getCoins() - powerUp.getPrice());
        }
        powerUp.execute(localGame, remoteGame);
    }
}
