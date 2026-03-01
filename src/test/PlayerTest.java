import com.nocZaHranici.game.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlayerTest {
    @Test
    void playerTakesDamage() {
        Player player = new Player("test", 100, 10);

        player.setHealth(player.getHealth() - 20);

        assertEquals(80, player.getHealth());
    }

    @Test
    void potionHealsPlayer() {
        Player player = new Player("test", 100, 10);
        player.setHealth(50);

        player.setHealth(Math.min(player.getHealth() + 30, 100));

        assertEquals(80, player.getHealth());
    }

    @Test
    void playerAliveCheck() {
        Player player = new Player("test", 100, 10);
        player.setHealth(0);

        assertFalse(player.isAlive());
    }
}
