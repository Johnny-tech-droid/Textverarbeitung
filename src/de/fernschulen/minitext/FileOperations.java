/**
 * FileOperations.java
 * Created by Johnny-tech-droid on 27.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.print.PrinterException;
import java.io.*;


public class FileOperations {
    private File file;


    public void saveToFile() {
        HTMLEditorKit htmlFormat = new HTMLEditorKit();
        if (file == null) {
            MiniTextDialog dialog = new MiniTextDialog();
            file = dialog.speichernDialogZeigen();
        }
        if (file != null) {
            try {
                OutputStream output = new FileOutputStream(file);
                htmlFormat.write(output, MiniText.getEingabeFeld().getDocument(), 0,MiniText.getEingabeFeld().getDocument().getLength());

            } catch (BadLocationException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void openFile() {
      MiniTextDialog dialog = new MiniTextDialog();
      File fileLocal = dialog.oeffnenDialogZeigen();
      if (fileLocal != null) {
          try {
              MiniText.getEingabeFeld().read(new FileReader(fileLocal), null);
              file = fileLocal;
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      }
    }
    public void saveToFileAs() {
        MiniTextDialog dialog = new MiniTextDialog();
        File localFile = dialog.speichernDialogZeigen();
        if (localFile != null) {
            file = localFile;
            saveToFile();
        }
    }
    public void loadWebpage(String address) {
        if (address != null) {
            MiniText.getEingabeFeld().setText("");
            try {
                MiniText.getEingabeFeld().setPage(address);
                file = null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
    public void clearAll() {
        MiniTextDialog dialog = new MiniTextDialog();
        dialog.allesLoeschenDialogZeigen();
        if (JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            MiniText.getEingabeFeld().setText("");
        else
            saveToFileAs();


    }
    public void printDocument(boolean dialogZeigen) {
        try {
            if (!dialogZeigen)
                MiniText.getEingabeFeld().print();
            else
                MiniText.getEingabeFeld().print(null, null, false, null, null, true);
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Fehler beim Verarbeiten des Druckauftrags");
        }
    }
}
