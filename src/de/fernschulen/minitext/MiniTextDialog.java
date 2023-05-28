/**
 * MiniTextDialog.java
 * Created by Johnny-tech-droid on 28.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MiniTextDialog {
    static class MeinFilter extends FileFilter {

        @Override
        public boolean accept(File f) {
            String name = f.getName().toLowerCase();
            return (f.isDirectory() || name.endsWith(".htm") || name.endsWith(".html")) || name.endsWith(".txt");
        }

        @Override
        public String getDescription() {
            return "HTML Files";
        }

    }
    public File oeffnenDialogZeigen() {
        JFileChooser oeffnenDialog = new JFileChooser();
        oeffnenDialog.setFileFilter(new MeinFilter());
        oeffnenDialog.setAcceptAllFileFilterUsed(false);
        int status = oeffnenDialog.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
            return oeffnenDialog.getSelectedFile();
        else
            return null;
    }
    public File speichernDialogZeigen() {
        JFileChooser speichernDialog = new JFileChooser();
        speichernDialog.setFileFilter(new MeinFilter());
        speichernDialog.setAcceptAllFileFilterUsed(false);
        int status = speichernDialog.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
            return speichernDialog.getSelectedFile();
        else return null;
    }
    public void allesLoeschenDialogZeigen() {
        JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), "Vorher speichern?", "Neues Dokument", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

    }
}
