package factory;

import button.Button;
import textbox.TextBox;


public interface UIFactory {
    Button createButton();
    TextBox createTextBox();
}
