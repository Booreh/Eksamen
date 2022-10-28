package forms;

import models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tools.JsonFileHandler;

public class rentYourCarGUI extends JFrame {

    private JPanel mainPanel;
    private JPanel cardLayoutPanel;
    private JPanel registerUserPanel;
    private JLabel createAccountLabel;
    private JPanel registerFormPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel lastNameLabel;
    private JTextField lastNameInput;
    private JLabel ageLabel;
    private JTextField ageInput;
    private JLabel addressLabel;
    private JTextField addressInput;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberInput;
    private JLabel emailLabel;
    private JTextField emailInput;
    private JLabel passwordLabel;
    private JTextField passwordInput;
    private JPanel registerActionPanel;
    private JButton submitButton;

    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User createdUser = new User(firstNameInput.getText(),
                        lastNameInput.getText(), Integer.parseInt(ageInput.getText()), addressInput.getText(),
                        Integer.parseInt(phoneNumberInput.getText()),
                        emailInput.getText(), passwordInput.getText());
                System.out.println(createdUser);

                JsonFileHandler registerUserInformation = new JsonFileHandler();
                registerUserInformation.userToJson(createdUser);
                registerUserInformation.readUserFromJson();
            }



        });



    }

}
