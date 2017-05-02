package edu.mcckc.gui;

import edu.mcckc.domain.PasswordManager;
import edu.mcckc.exceptions.PasswordException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private String specialCharacters = "+-=_@#$^&;:,.<>~[](){}?!|";

    public PanelApp()
    {
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}
