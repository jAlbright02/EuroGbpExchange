
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Currency implements ActionListener {

    double euro;
    double pounds;
    String exRate;
    private JFrame main;
    private JTextField input;
    private JButton convert;
    private JLabel output;
    private JLabel greeting;
    private JLabel hint;
    private JPanel box;
    private JPanel labelBox;
    private JPanel container;

    public Currency() {

        main = new JFrame();

        greeting = new JLabel("Currency Converter Application");

        input = new JTextField(5);

        hint = new JLabel("Euros: ");

        convert = new JButton("Convert");
        convert.addActionListener(this);

        output = new JLabel("Pounds: ");

        labelBox = new JPanel();
        labelBox.setLayout(new FlowLayout());
        labelBox.add(hint);
        labelBox.add(input);

        box = new JPanel();
        box.setLayout(new GridLayout(2, 1));
        box.add(convert);
        box.add(output);



        container = new JPanel();
        container.setLayout(new GridLayout(2, 1));
        container.add(labelBox);
        container.add(box);


        main.add(container, BorderLayout.CENTER);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setTitle("Currency Converter");
        main.pack();
        main.setVisible(true);


    }

    public static void main(String[] args) {
        new Currency();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        euro = Double.parseDouble(input.getText());
        exRate = new Money().exchangeRate();

        pounds = Double.parseDouble(exRate) * euro;

        String convPounds = ("Pounds: " + pounds);
        output.setText(convPounds);

    }

}
