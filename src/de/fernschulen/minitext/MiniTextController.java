/**
 * MiniTextController.java
 * Created by Johnny-tech-droid on 27.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import javax.swing.*;


public class MiniTextController {
    private final FileOperations fileOperations;

    public MiniTextController() {
        this.fileOperations = new FileOperations();
    }

    public void webLaden() {
        String address;
        address = JOptionPane.showInputDialog("Bitte geben Sie eine URL ein", "https://");
        fileOperations.loadWebpage(address);
    }
    public void dateiSpeichernUnter() {
        fileOperations.saveToFileAs();
    }
    public void drucken() {
        fileOperations.printDocument(true);
    }
    public void druckenInstant() {
        fileOperations.printDocument(false);
    }
    public void dateiSpeichern() {
        fileOperations.saveToFile();
    }
    public void dateiLaden() {
        fileOperations.openFile();
    }
    public void dateiNeu() {
        fileOperations.clearAll();
    }
    public void beenden() {
        if (JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                "Sind Sie sicher?",
                "Anwendung schliessen",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
