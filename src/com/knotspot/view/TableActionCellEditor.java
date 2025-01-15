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
 */
public class TableActionCellEditor extends DefaultCellEditor{
    
    JPanel panel;

    public TableActionCellEditor(JPanel panel) {
        super(new JCheckBox());
        this.panel = panel;
    }
    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object o, boolean isSelected, int rowIndex, int columnIndex){
        panel.setBackground(table.getSelectionBackground());
        return panel;
    }
    
}
