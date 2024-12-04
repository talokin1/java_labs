import application.*;
import factory.MacOSFactory;
import factory.UIFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppTest {

    @Test
    public void testAppWithMacOSFactory() {
        UIFactory factory = new MacOSFactory();
        App app = new App(factory);
        assertDoesNotThrow(app::render);
    }
}
