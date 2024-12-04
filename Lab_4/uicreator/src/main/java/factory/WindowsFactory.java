package factory;

import button.Button;
import button.WindowsButton;
import textbox.TextBox;
import textbox.WindowsTextBox;


public class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {

        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {

        return new WindowsTextBox();
    }
}
