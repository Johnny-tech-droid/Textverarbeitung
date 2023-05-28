/**
 * MeineAktionen.java
 * Created by Johnny-tech-droid on 27.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MeineAktionen extends AbstractAction {

    private final MiniTextController controller = new MiniTextController();
    public MeineAktionen(String text, ImageIcon icon, String bildschirmtipp, KeyStroke shortcut, String actionText) {
        super(text, icon);
        putValue(SHORT_DESCRIPTION, bildschirmtipp);
        putValue(ACCELERATOR_KEY, shortcut);
        putValue(ACTION_COMMAND_KEY, actionText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("neu"))
            controller.dateiNeu();
        if (e.getActionCommand().equals("oeffnen"))
            controller.dateiLaden();
        if (e.getActionCommand().equals("speichern"))
            controller.dateiSpeichern();
        if (e.getActionCommand().equals("beenden"))
            controller.beenden();
        if (e.getActionCommand().equals("drucken")) {
            if (e.getSource() instanceof JButton)
                controller.drucken();
            if (e.getSource() instanceof JMenuItem)
                controller.druckenInstant();
        }
        if (e.getActionCommand().equals("speichernUnter"))
            controller.dateiSpeichernUnter();
        if (e.getActionCommand().equals("webLaden"))
            controller.webLaden();
    }
}