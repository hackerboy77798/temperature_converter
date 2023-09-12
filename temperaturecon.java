import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterApp {
    private Frame frame;
    private TextField inputField;
    private Label resultLabel;

    public TemperatureConverterApp() {
        frame = new Frame("Temperature Converter");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        Label inputLabel = new Label("Enter Temperature:");
        inputField = new TextField(15);
        Button convertButton = new Button("Convert");
        resultLabel = new Label("");

        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(convertButton);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputTemperature = Double.parseDouble(inputField.getText());
            String result = "";

            if (inputTemperature >= -273.15) {
                // Convert Celsius to Fahrenheit
                double fahrenheit = (inputTemperature * 9 / 5) + 32;

                // Convert Celsius to Kelvin
                double kelvin = inputTemperature + 273.15;

                result = "Fahrenheit: " + fahrenheit + "°F\nKelvin: " + kelvin + "K";
            } else {
                result = "Invalid input. Temperature must be greater than or equal to -273.15°C.";
            }

            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public void launch() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TemperatureConverterApp converterApp = new TemperatureConverterApp();
        converterApp.launch();
    }
}
