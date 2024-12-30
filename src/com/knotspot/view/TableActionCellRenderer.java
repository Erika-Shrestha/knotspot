/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *                      (class le k garcha)
 * @author 
 * LMU ID: 23048598
 * COLLEGE ID: 230024
 * ErikaShrestha
 */
public class TableActionCellRenderer extends DefaultTableCellRenderer {
    
    JPanel panel;
    
    public TableActionCellRenderer(JPanel panel){
        this.panel=panel;
    };
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column){
        Component com= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //to set background for the inserted cell panels
        if(isSelected==false && row % 2==0){
            panel.setBackground(Color.WHITE);
        }
        else{
            panel.setBackground(com.getBackground());
        }
        return panel;
    };
    
       
}
