/**
 * MeinKontextMenuListener.java
 * Created by Johnny-tech-droid on 27.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeinKontextMenuListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseReleased(e);
            if (e.isPopupTrigger()){
                MiniText.getKontext().show(e.getComponent(), e.getX(), e.getY());

            }
    }
}
