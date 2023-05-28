/**
 * MiniText.java
 * Created by Johnny-tech-droid on 27.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.InputEvent;

public class MiniText extends JFrame {

    private static JEditorPane eingabeFeld;

    public static JEditorPane getEingabeFeld() {
        return eingabeFeld;
    }


    private MeineAktionen oeffnenAct, speichernAct, speichernUnterAct, beendenAct, neuAct, druckenAct, webOeffnenAct;
    private static JPopupMenu kontext;
    private final GuiHelper guiHelper = new GuiHelper();
    // ------------------- Konstruktor ------------------- //

    public MiniText(String text) throws HeadlessException {
        super(text);
        setLayout(new BorderLayout());
        initActions();
        menu();
        add(symbolleiste(), BorderLayout.NORTH);
        kontextMenu();
        eingabeFeld = new JEditorPane();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        eingabeFeld.setEditorKit(htmlEditorKit);
        eingabeFeld.addMouseListener(new MeinKontextMenuListener());
        add(new JScrollPane(eingabeFeld), BorderLayout.CENTER);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        eingabeFeld.requestFocus();



    }
    // ------------------------------ INITIALIZE GUI METHODS --------------------- //
    private void kontextMenu() {
        kontext = new JPopupMenu();
        kontext.add(neuAct);
        kontext.add(oeffnenAct);
        kontext.add(webOeffnenAct);
    }

    private JToolBar symbolleiste() {
        JToolBar leiste = new JToolBar();
        addActionsToToolBar(leiste);
        guiHelper.addFormattingActions(leiste);
        leiste.addSeparator();
        guiHelper.addParagraphAlignmentActions(leiste);

        return leiste;
    }



    private void addActionsToToolBar(JToolBar leiste) {
        leiste.add(neuAct);
        leiste.add(oeffnenAct);
        leiste.add(webOeffnenAct);
        leiste.add(speichernAct);
        leiste.add(druckenAct);

        leiste.addSeparator();
    }

    private void menu() {
        JMenuBar menu = new JMenuBar();
        JMenu dateiMenu = new JMenu("Datei");
        JMenu dateiOeffnen = new JMenu("Oeffnen");

        dateiOeffnen.add(oeffnenAct);
        dateiOeffnen.add(webOeffnenAct);
        dateiMenu.add(neuAct);
        dateiMenu.add(dateiOeffnen);
        dateiMenu.add(speichernAct);
        dateiMenu.add(speichernUnterAct);
        dateiMenu.addSeparator();
        dateiMenu.add(druckenAct);
        dateiMenu.addSeparator();
        dateiMenu.add(beendenAct);
        menu.add(dateiMenu);
        this.setJMenuBar(menu);
    }

    // ------------------- Methoden ---------------------- //
    private void initActions() {
        neuAct = new MeineAktionen("Neu...",
                new ImageIcon("Assets/icons/new24.gif"),
                "Erstellt ein neues Dokument",
                KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK),
                "neu");
        druckenAct = new MeineAktionen("Drucken...",
                new ImageIcon("Assets/icons/print24.gif"),
                "Druckt das aktuelle Dokument",
                KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK),
                "drucken");
        speichernAct = new MeineAktionen("Speichern unter...",
                new ImageIcon("Assets/icons/save24.gif"),
                "Speichert das aktuelle Dokument",
                KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK),
                "speichern");
        speichernUnterAct = new MeineAktionen("Speichern unter...",
                null,
                "",
                null,
                "speichernUnter");
        oeffnenAct = new MeineAktionen("Oeffnen...",
                new ImageIcon("Assets/icons/open24.gif"),
                "Oeffnet ein vorhandenes Dokument",
                KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK),
                "oeffnen");
        webOeffnenAct = new MeineAktionen("Webseite...",
                new ImageIcon("Assets/icons/webComponent24.gif"),
                "Oeffnet eine Webseite",
                KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK),
                "webLaden");
        beendenAct = new MeineAktionen("Beenden",
                null,
                "",
                null,
                "beenden");


    }

    public static JPopupMenu getKontext() {
        return kontext;
    }




}
