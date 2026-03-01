import com.nocZaHranici.game.model.NPC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NPCTest {
    @Test
    void npcDiesWhenHealthZero() {
        NPC npc = new NPC("test", "Test", "desc", 10, 5, "loc");

        npc.takeDamage(10);

        assertFalse(npc.isAlive());
    }

    @Test
    void cannotAttackDeadNpc() {
        NPC npc = new NPC("test", "Test", "desc", 0, 5, "loc");

        assertFalse(npc.isAlive());
    }
}
