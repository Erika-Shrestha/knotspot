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
 *                   
 * @author 
 * LMU ID: 23048598
 * COLLEGE ID: 230024
 * ErikaShrestha
 * The TableActionCellRenderer class is a custom renderer for a JTable cell 
 * that displays a JPanel as a component. 
 * It extends the DefaultCellRenderer class and overrides the getTableCellRendererComponent
 * method to return the provided panel with a background color 
 * set to the table's selection background to match the colors.
 */
public class TableActionCellRenderer extends DefaultTableCellRenderer {
    
    JPanel panel;  //Panel to be used for rendering a table cell
    
    /**
     * Constructor for the class
     * Initializes the renderer with a provided JPanel
     * @param panel the JPanel to be used as the renderer component in the table venueModfiyTbl
     */
    public TableActionCellRenderer(JPanel panel){
        this.panel=panel;
    };
    
    /**
     * Overridden method from DefaultCellRenderer. 
     * It provides the JPanel to be used and sets the background of the panel
     * to the table's selection background color based on whether 
     * the row is selected or if it's an even or odd row
     * @param table the JTable that the cell renderer is used in (venueModfiyTbl)
     * @param value  the value of the cell being rendered (not used in here)
     * @param isSelected true if the cell is selected, otherwise false
     * @param hasFocus true if the cell has focus, otherwise false
     * @param row the row index of the cell being rendered
     * @param column the column index of the cell being rendered
     * @return the JPanel component for the table cell renderer
     */
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
