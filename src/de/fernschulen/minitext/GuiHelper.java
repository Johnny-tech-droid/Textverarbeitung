/**
 * GuiHelper.java
 * Created by Johnny-tech-droid on 28.05.23
 * Textverarbeitung
 * de.fernschulen.minitext
 */


package de.fernschulen.minitext;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class GuiHelper {
    public GuiHelper() {
    }

    protected void addParagraphAlignmentActions(JToolBar leiste) {
        Action linksAbsatz = createAlignmentActions("Linksbuendig", StyleConstants.ALIGN_LEFT, "Assets/icons/alignLeft24.gif");
        leiste.add(linksAbsatz);

        Action zentriertAbsatz = createAlignmentActions("Zentriert", StyleConstants.ALIGN_CENTER, "Assets/icons/alignCenter24.gif");
        leiste.add(zentriertAbsatz);

        Action rechtsAbsatz = createAlignmentActions("Rechtsbuendig", StyleConstants.ALIGN_RIGHT, "Assets/icons/alignRight24.gif");
        leiste.add(rechtsAbsatz);

        Action blockAbsatz = createAlignmentActions("Blocksatz formatieren", StyleConstants.ALIGN_JUSTIFIED, "Assets/icons/alignJustify24.gif");
        leiste.add(blockAbsatz);
    }

    protected void addFormattingActions(JToolBar leiste) {
        Action fettFormat = createFormatActions(new StyledEditorKit.BoldAction(), "Fett formatieren", "Assets/icons/bold24.gif");
        leiste.add(fettFormat);
        Action kursivFormat = createFormatActions(new StyledEditorKit.ItalicAction(), "Kursiv formatieren", "Assets/icons/italic24.gif");
        leiste.add(kursivFormat);
        Action unterstrichenFormat = createFormatActions(new StyledEditorKit.UnderlineAction(), "Unterstrichen formatieren", "Assets/icons/underline24.gif");
        leiste.add(unterstrichenFormat);
    }

    private Action createFormatActions(Action action, String description, String iconPath) {
        action.putValue(Action.SHORT_DESCRIPTION, description);
        action.putValue(Action.LARGE_ICON_KEY, new ImageIcon(iconPath));
        return action;
    }
    private Action createAlignmentActions(String alignment, int styleConstant, String iconPath) {
        Action action = new StyledEditorKit.AlignmentAction(alignment, styleConstant);
        action.putValue(Action.SHORT_DESCRIPTION, "");
        action.putValue(Action.LARGE_ICON_KEY, new ImageIcon(iconPath));
        return action;
    }

}
