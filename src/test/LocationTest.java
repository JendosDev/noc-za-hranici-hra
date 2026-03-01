import com.nocZaHranici.game.model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LocationTest {
    @Test
    void locationReturnsNullForInvalidNpc() {
        Location location = new Location("id", "name", "desc"
        , false, false, false, false);

        assertNull(location.getNpc("neexistuje"));
    }
}
