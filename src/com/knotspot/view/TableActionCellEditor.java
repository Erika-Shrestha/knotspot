/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.view;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;


/**
 *
 * @author 
 * LMU ID: 23048598
 * COLLEGE ID: 230024
 * ErikaShrestha
 * The TableActionCellEditor class is a custom editor for a JTable cell 
 * that displays a JPanel as a component. 
 * It extends the DefaultCellEditor class and overrides the getTableCellEditorComponent
 * method to return the provided panel with a background color 
 * set to the table's selection background to match the colors.
 */
public class TableActionCellEditor extends DefaultCellEditor{
    
    JPanel panel; //panel used when editing a cell
    
    /**
     * Constructor for the class
     * Initializes the editor with a JCheckBox (since DefaultCellEditor requires a dummy component)
     * @param panel the JPanel to be used as the editor component in the table venueModfiyTbl
     */
    public TableActionCellEditor(JPanel panel) {
        super(new JCheckBox());
        this.panel = panel;
    }
    
    /**
     * Overridden method from DefaultCellEditor. 
     * It provides the JPanel to be used and sets the background of the panel
     * to the table's selection background color
     * @param table the JTable that the cell editor is used in (venueModfiyTbl)
     * @param o the value of cell being edited (not implemented here)
     * @param isSelected true if cell is edited, otherwise false
     * @param rowIndex the row index of the cell being edited
     * @param columnIndex the column index of the cell being edited
     * @return the JPanel component used for the editor
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object o, boolean isSelected, int rowIndex, int columnIndex){
        panel.setBackground(table.getSelectionBackground());
        return panel;
    }
    
}
