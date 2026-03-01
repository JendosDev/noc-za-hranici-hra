import com.nocZaHranici.game.model.Quest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestTest {
    @Test
    void questActivationWorks() {
        Quest quest = new Quest("id", "name", "desc", null, null, null, "obj");

        quest.activate();

        assertTrue(quest.isActive());
    }
}
