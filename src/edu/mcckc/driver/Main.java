package edu.mcckc.driver;

import edu.mcckc.gui.FrameApp;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        FrameApp frmApp = new FrameApp();
        frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmApp.setSize(600, 400);
        frmApp.setVisible(true);
    }
}
