package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumber extends JFrame {
    private int randomNumber;
    private int count = 3;

    private JTextField textField;

    public GuessNumber() {


        randomNumber = (int) (Math.random() * 10) + 1; // [1 ; 10]
        setTitle("Guess the number");
        setBounds(600, 300, 600, 140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        textField.setText("Программа загадала число от 1 до 10. На отгадывание 3 попытки");
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 18);
        textField.setFont(font);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 10));
        add(buttonsPanel, BorderLayout.CENTER);
        JButton[] buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].setFont(font);
            buttonsPanel.add(buttons[i]);
            int buttonIndex = i + 1;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryToAnswer(buttonIndex, buttons[buttonIndex - 1]);
                }
            });

            JButton buttonReset = new JButton("Перезапустить игру");
            buttonReset.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
            add(buttonReset, BorderLayout.SOUTH);
            buttonReset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    randomNumber = (int) (Math.random() * 10) + 1;
                    count = 3;
                    textField.setText("Программа загадала число от 1 до 10. На отгадывание 3 попытки");
                    resetButtons(buttons);
                }
            });
        }

        setVisible(true);
    }

    public void tryToAnswer(int answer, JButton button) {
        if (answer == randomNumber && count > 0) {
            textField.setText("Вы угадали! Ответ: " + randomNumber);
            button.setBackground(Color.GREEN);
            count = -1;
        } else if (answer > randomNumber && count > 1) {
            count--;
            button.setBackground(Color.red);
            textField.setText("Не угадали! Загаданное число меньше, осталось попыток " + count);

        } else if (answer < randomNumber && count > 1) {
            count--;
            button.setBackground(Color.red);
            textField.setText("Не угадали! Загаданное число больше, осталось попыток " + count);
        } else if (answer < randomNumber && count == 1 || answer > randomNumber && count == 1) {
            textField.setText("Вы проиграли, было загадано число " + randomNumber);
            button.setBackground(Color.red);
            count--;
        } else {
            textField.setText("Игра окончена, было загадано число " + randomNumber);
        }
    }

    public static void resetButtons(JButton[] buttons) {
        for (int j = 0; j < buttons.length; j++) {
            buttons[j].setBackground(null);
        }
    }
}
