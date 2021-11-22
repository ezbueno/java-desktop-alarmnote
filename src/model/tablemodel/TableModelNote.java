package model.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Note;

/**
 *
 * @author Ezandro Bueno
 */
public class TableModelNote extends AbstractTableModel {

    private final String[] columns;
    private final List<Note> rows;

    public TableModelNote() {
        this.columns = new String[]{"Nome", "Descrição", "Possui alarme?", "Data e hora do alarme"};
        this.rows = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Note note = this.rows.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return note.getName();
            case 1:
                return note.getDescription();
            case 2:
                return note.getAlarm();
            case 3:
                return note.getDateTimeAlarm();
            default:
                return null;
        }
    }  
}
