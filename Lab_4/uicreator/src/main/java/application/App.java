package application;

import button.Button;
import factory.LinuxFactory;
import factory.MacOSFactory;
import factory.UIFactory;
import factory.WindowsFactory;
import textbox.TextBox;
import java.util.HashMap;
import java.util.Map;


public class App {
    private final Button button;
    private final TextBox textBox;

    public App(UIFactory factory) {
        this.button = factory.createButton();
        this.textBox = factory.createTextBox();
    }
    
    public void render() {
        button.render();
        textBox.render();
    }

    public static void main(String[] args) {
        String os = "macOS";

        Map<String, UIFactory> factoryMap = new HashMap<>();
        factoryMap.put("Windows", new WindowsFactory());
        factoryMap.put("macOS", new MacOSFactory());
        factoryMap.put("Linux", new LinuxFactory());

        UIFactory factory = factoryMap.get(os);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown OS: " + os);
        }

        App app = new App(factory);
        app.render();
    }
}
