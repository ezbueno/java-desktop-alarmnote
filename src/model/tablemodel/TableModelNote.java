package model.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Note;
import util.DateUtil;

/**
 *
 * @author Ezandro Bueno
 */
public class TableModelNote extends AbstractTableModel {

    private final String[] columns;
    private List<Note> rows;
    private final DateUtil dateUtil;

    public TableModelNote() {
        this.columns = new String[]{"Nome", "Descrição", "Possui alarme?", "Data e hora do alarme"};
        this.rows = new ArrayList<>();
        this.dateUtil = new DateUtil();
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
                return note.getAlarm() == 1 ? "Sim" : "Não";
            case 3:
                return this.dateUtil.getDateTimeFormatted(note.getDateTimeAlarm());
            default:
                return null;
        }
    }
    
    public void setNotes(List<Note> notes) {
        this.rows = notes;
        this.fireTableDataChanged();
    }
    
    public void addNote(Note note) {
        this.rows.add(note);
        int lastIndex = this.getRowCount() - 1;
        this.fireTableRowsInserted(lastIndex, lastIndex);
    }
}
