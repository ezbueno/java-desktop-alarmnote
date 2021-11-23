package view;

import control.NoteControl;
import entity.HibernateUtil;
import java.awt.Frame;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Note;
import model.tablemodel.TableModelNote;
import util.DateUtil;
import util.NoteTray;

/**
 *
 * @author Ezandro Bueno
 */
public class Main extends javax.swing.JFrame {

    private NoteControl noteCtr;
    private DateUtil dateUtil;
    private TableModelNote model;
    private Note newNote;
    private NoteTray noteTray;
            
    public Main() {
        this.initComponents();

        this.noteCtr = new NoteControl();
        this.dateUtil = new DateUtil();
        this.txDate.setDate(new Date());
        this.model = (TableModelNote) this.tbNotes.getModel();
        this.noteTray = new NoteTray(this);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.noteTray.createNoteTray();

        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        HibernateUtil.getManager();

        this.setTableData();
    }

    private void setTableData() {
        this.model.setNotes(this.noteCtr.getNotes());
    }

    private Note getNoteScreen() {
        Note note = new Note();
        note.setName(this.txName.getText());
        note.setDescription(this.txaDescription.getText());
        note.setAlarm(this.cbActivateAlarm.isSelected() ? 1 : 0);
        note.setDateTimeAlarm(new Timestamp(dateUtil.convertToDate(this.txDate.getDate(), this.txHour.getText()).getTime()));
        return note;
    }

    private void clean() {
        this.txName.setText("");
        this.cbActivateAlarm.setSelected(false);
        this.txaDescription.setText("");
        this.txDate.setDate(new Date());
        this.txHour.setText("00:00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        cbActivateAlarm = new javax.swing.JCheckBox();
        btInclude = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txHour = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNotes = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nova nota"));

        jLabel1.setText("Nome:");

        txName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição:");

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        jScrollPane1.setViewportView(txaDescription);

        cbActivateAlarm.setText("Ativar alarme");

        btInclude.setText("Incluir");
        btInclude.setMaximumSize(new java.awt.Dimension(80, 30));
        btInclude.setMinimumSize(new java.awt.Dimension(80, 30));
        btInclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncludeActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de agendamento:");

        jLabel3.setText("Horário de agendamento:");

        try {
            txHour.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txHour.setText("00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cbActivateAlarm))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txHour, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbActivateAlarm)
                        .addComponent(jLabel5))
                    .addComponent(txDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btInclude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas cadastradas"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tbNotes.setModel(new TableModelNote());
        tbNotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNotesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNotes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel7.setPreferredSize(new java.awt.Dimension(75, 365));

        btEdit.setText("Editar");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("Excluir");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDelete)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNameActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        int rowSelected = this.tbNotes.getSelectedRow();

        if (rowSelected != -1) {
            this.newNote = this.model.getNote(rowSelected);
            this.loadData(this.newNote);
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void loadData(Note newNote) {
        this.txName.setText(this.newNote.getName());
        this.cbActivateAlarm.setSelected(this.newNote.getAlarm() == 1);
        this.txDate.setDate(this.newNote.getDateTimeAlarm());
        this.txHour.setText(this.dateUtil.getTimeFormatted(this.newNote.getDateTimeAlarm()));
        this.txaDescription.setText(this.newNote.getDescription());
    }

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int rowSelected = this.tbNotes.getSelectedRow();

        if (rowSelected != -1) {
            int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                Note note = this.model.getNote(rowSelected);
                this.noteCtr.delete(note);
                this.model.deleteNote(rowSelected);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um registro!");
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btIncludeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncludeActionPerformed
        Note note = this.getNoteScreen();
        
        if (this.newNote == null) {
            this.noteCtr.save(note);
            JOptionPane.showMessageDialog(null, "Nota incluída com sucesso!");
            this.model.addNote(note);            
        } else {
            note.setId(this.newNote.getId());
            this.noteCtr.update(note);
            JOptionPane.showMessageDialog(null, "Nota atualizada com sucesso!");
            this.model.updateNote(note);
            this.newNote = null;
        }        
        this.clean();
    }//GEN-LAST:event_btIncludeActionPerformed

    private void tbNotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNotesMouseClicked
        if (evt.getClickCount() == 2) {
            this.btEditActionPerformed(null);
        }
    }//GEN-LAST:event_tbNotesMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.noteTray.minimize();
    }//GEN-LAST:event_formWindowClosed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btInclude;
    private javax.swing.JCheckBox cbActivateAlarm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbNotes;
    private com.toedter.calendar.JDateChooser txDate;
    private javax.swing.JFormattedTextField txHour;
    private javax.swing.JTextField txName;
    private javax.swing.JTextArea txaDescription;
    // End of variables declaration//GEN-END:variables
}
