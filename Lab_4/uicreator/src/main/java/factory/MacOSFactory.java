package factory;

import button.Button;
import button.MacOSButton;
import textbox.MacOSTextBox;
import textbox.TextBox;


public class MacOSFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacOSTextBox();
    }
}
