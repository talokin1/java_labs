import factory.*;
import button.Button;
import org.junit.jupiter.api.Test;
import textbox.TextBox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FactoryTest {

    @Test
    public void testWindowsFactory() {
        UIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        assertNotNull(button);
        assertNotNull(textBox);
        assertEquals("WindowsButton", button.getClass().getSimpleName());
        assertEquals("WindowsTextBox", textBox.getClass().getSimpleName());
    }

    @Test
    public void testMacOSFactory() {
        UIFactory factory = new MacOSFactory();
        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        assertNotNull(button);
        assertNotNull(textBox);
        assertEquals("MacOSButton", button.getClass().getSimpleName());
        assertEquals("MacOSTextBox", textBox.getClass().getSimpleName());
    }

    @Test
    public void testLinuxFactory() {
        UIFactory factory = new LinuxFactory();
        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        assertNotNull(button);
        assertNotNull(textBox);
        assertEquals("LinuxButton", button.getClass().getSimpleName());
        assertEquals("LinuxTextBox", textBox.getClass().getSimpleName());
    }
}
