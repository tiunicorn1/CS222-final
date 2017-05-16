package edu.mcckc.gui;

import edu.mcckc.domain.PasswordManager;
import edu.mcckc.exceptions.PasswordException;
import org.apache.log4j.Logger;
import sun.plugin2.main.client.MessagePassingOneWayJSObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by rharris on 5/1/2017.
 */
public class PanelApp extends JPanel implements ActionListener
{
    private PasswordManager generator;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel row5;
    private JPanel row6;
    private JPanel row7;
    private JLabel lblSpecialChars;
    private JTextField txtSpecialChars;
    private JLabel lblNewPassword;
    private JTextField txtNewPassword;
    private JCheckBox chkIncludeDigits;
    private JCheckBox chkIncludeSpecialChars;
    private JCheckBox chkIncludeEZToRead;
    private JRadioButton radAllUpperCase;
    private JRadioButton radAllLowerCase;
    private JRadioButton radMixedCase;
    private ButtonGroup radButtonGroup;

    private JLabel lblMinLength;
    private JTextField txtMinLength;
    private JLabel lblMaxLength;
    private JTextField txtMaxLength;


    private JButton btnGenerate;
    private String specialCharacters; //= "+-=_@#$^&;:,.<>~[](){}?!|";  // don't make this a hard code only this for testing only

    public PanelApp()
    {
        generator = new PasswordManager();

        row1 = new JPanel();
        row2 = new JPanel();
        row3 = new JPanel();
        row4 = new JPanel();
        row5 = new JPanel();
        row6 = new JPanel();
        row7 = new JPanel();

        lblSpecialChars = new JLabel("Special Characters:");
        txtSpecialChars = new JTextField(specialCharacters, 20);
        lblNewPassword = new JLabel("New Password:");
        txtNewPassword = new JTextField(40);

        chkIncludeDigits = new JCheckBox("Incl. Digits");
        chkIncludeSpecialChars = new JCheckBox("Incl. Special Chars");
        chkIncludeEZToRead = new JCheckBox(" Only EZ To Read Chars");

        radAllUpperCase = new JRadioButton("All Upper Case");
        radAllLowerCase = new JRadioButton("All Lower Case");
        radMixedCase = new JRadioButton("Mixed Case");
        radButtonGroup = new ButtonGroup();

        radButtonGroup.add(radAllUpperCase);
        radButtonGroup.add(radAllLowerCase);
        radButtonGroup.add(radMixedCase);

        lblMinLength = new JLabel("Min Length:");
        txtMinLength = new JTextField(5);
        lblMaxLength = new JLabel("Max Length:");
        txtMaxLength = new JTextField(5);

        btnGenerate = new JButton("Generate Password");

        row1.add(lblSpecialChars);
        row1.add(txtSpecialChars);

        row2.add(chkIncludeDigits);
        row2.add(chkIncludeSpecialChars);
        row2.add(chkIncludeEZToRead);

        row3.add(radAllUpperCase);
        row3.add(radAllLowerCase);
        row3.add(radMixedCase);

        row4.add(lblMinLength);
        row4.add(txtMinLength);

        row5.add(lblMaxLength);
        row5.add(txtMaxLength);

        row6.add(btnGenerate);

        row7.add(lblNewPassword);
        row7.add(txtNewPassword);

        setLayout(new GridLayout(7,1));

        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
        add(row6);
        add(row7);

        btnGenerate.addActionListener(this);
        btnGenerate.setActionCommand("generate");


    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        Logger.getLogger(this.getClass()).debug("Inside Panel App ActionPerformed ");

        if (e.getActionCommand().equalsIgnoreCase("generate")) {
            txtNewPassword.setText("Please enter valid data");
            specialCharacters = txtSpecialChars.getText();
            Logger.getLogger(this.getClass()).debug(txtSpecialChars);


            if (chkIncludeSpecialChars.isSelected() && txtSpecialChars.getText().equals(""))
            {

                txtSpecialChars.setText("Must Enter Special Character(s)");
                txtNewPassword.setText("Please enter valid data");
                Logger.getLogger(this.getClass()).debug(txtSpecialChars);

            }

            if (chkIncludeDigits.isSelected())
            {
                generator.setbIncludeDigits(true);
            }

            if (chkIncludeSpecialChars.isSelected())
            {
                generator.setbIncludeSpecialChars(true);
            }

            if (chkIncludeEZToRead.isSelected())
            {
                generator.setbIncludeEZToRead(true);
            }

            if (radAllUpperCase.isSelected())
            {
                generator.setbIncludeAllUpperCase(true);
            }

            if (radAllLowerCase.isSelected())
            {
                generator.setbIncludeAllLowerCase(true);
            }

            if (radMixedCase.isSelected())
            {
                generator.setbIncludeMixedCase(true);
            }

            generator.setMinLength(Integer.parseInt(txtMinLength.getText()));
            generator.setMaxLength(Integer.parseInt(txtMaxLength.getText()));
            Logger.getLogger(this.getClass()).debug("Min Length is: " + generator.getMinLength());
            Logger.getLogger(this.getClass()).debug("Max Length is: " + generator.getMaxLength());

            if (Integer.parseInt(txtMinLength.getText()) < 8)
            {
                txtNewPassword.setText("Minimum password length must be 8 characters");
                Logger.getLogger(this.getClass()).error("Minimum password length must be 8 characters");
            }

            if (Integer.parseInt(txtMinLength.getText()) > Integer.parseInt(txtMaxLength.getText()))
            {
                txtNewPassword.setText("MIN PW length must be less than the MAX PW length");
            }

            if ((Integer.parseInt(txtMinLength.getText()) >= 8 && (Integer.parseInt(txtMinLength.getText()) <= Integer.parseInt(txtMaxLength.getText()))))
            {
                try
                {

                    generator.generateNewPassword(Integer.parseInt(txtMinLength.getText()), Integer.parseInt(txtMaxLength.getText()), chkIncludeDigits.isSelected(), chkIncludeSpecialChars.isSelected(), chkIncludeEZToRead.isSelected(),
                            radAllUpperCase.isSelected(), radAllLowerCase.isSelected(), radMixedCase.isSelected(), specialCharacters);
                    txtNewPassword.setText(generator.getNewPassword());
                    Logger.getLogger(this.getClass()).debug(generator.getNewPassword());

                }
                catch (PasswordException pex)
                {
                    Logger.getLogger(this.getClass()).error(pex.toString());
                }
            }





            /*
            try
            {
                if (generator.getMinLength() < 8)
                {
                    txtNewPassword.setText("Minimum password length must be 8 characters");
                    Logger.getLogger(this.getClass()).error("Minimum password length must be 8 characters");
                }
                else if (generator.getMinLength() >= 8)
                {
                    if (generator.getMinLength() <= generator.getMaxLength())
                    {
                        generator.generateNewPassword();
                        txtNewPassword.setText(generator.getNewPassword());
                        Logger.getLogger(this.getClass()).debug(generator.getNewPassword());
                    }

                    txtNewPassword.setText("MIN PW length must be less than the MAX PW length");
                }


            }
            catch (Exception ex)
            {

                Logger.getLogger(this.getClass()).error(ex.toString());
            }
            */

        }

    }

}
