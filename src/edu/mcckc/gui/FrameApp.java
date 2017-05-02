package edu.mcckc.gui;

import javax.swing.*;

/**
 * Created by rharris on 5/1/2017.
 */
public class FrameApp extends JFrame
{
    private PanelApp pnlApp;

    public FrameApp()
    {
        pnlApp = new PanelApp();
        add(pnlApp);
    }
}
