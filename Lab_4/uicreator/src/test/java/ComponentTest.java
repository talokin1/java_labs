import button.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentTest {

    @Test
    public void testWindowsButton() {
        Button button = new WindowsButton();
        assertEquals("Rendering Windows Button", button.render());
    }

    @Test
    public void testMacOSButton() {
        Button button = new MacOSButton();
        assertEquals("Rendering MacOS Button", button.render());
    }

    @Test
    public void testLinuxButton() {
        Button button = new LinuxButton();
        assertEquals("Rendering Linux Button", button.render());
    }
}
