import textbox.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTest {
    @Test
    public void testWindowsButton() {
        TextBox text = new WindowsTextBox();
        assertEquals("Rendering Windows TextBox", text.render());
    }

    @Test
    public void testMacOSTextBox(){
        TextBox text = new MacOSTextBox();
        assertEquals("Rendering MacOS TextBox", text.render());
    }

    @Test
    public void testLinuxTextBox(){
        TextBox text = new LinuxTextBox();
        assertEquals("Rendering Linux TextBox", text.render());
    }

}