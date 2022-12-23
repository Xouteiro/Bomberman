package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Enemy;
import feupL15G01.model.game.elements.Player;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;

    public EnemyController(Board board) {
        super(board);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Enemy enemy : getModel().getEnemies())
                moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }

    private void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmptyForEnemy(position)) {
            enemy.setPosition(position);
            Player player = getModel().getPlayer();
            if (player.getPosition().equals(position))
               player.removeLife();
        }
    }
}