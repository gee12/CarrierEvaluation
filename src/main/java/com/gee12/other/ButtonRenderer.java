package com.gee12.other;

import com.gee12.panels.MainFrame;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Иван
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer(Icon icon) {
        setOpaque(false);
//        setBorder(BorderFactory.createEmptyBorder());
        setIcon(icon);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
//        if (isSelected) {
//            setForeground(table.getSelectionForeground());
//            setBackground(table.getSelectionBackground());
//        } else {
//            setForeground(table.getForeground());
//            setBackground(UIManager.getColor("Button.background"));
//        }
//        setText((value == null) ? "" : value.toString());
        return this;
    }
}