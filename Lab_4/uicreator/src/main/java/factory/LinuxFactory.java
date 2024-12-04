package factory;

import button.Button;
import button.LinuxButton;
import textbox.LinuxTextBox;
import textbox.TextBox;


public class LinuxFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextBox createTextBox() {
        return new LinuxTextBox();
    }
}
