package control;

import java.awt.TrayIcon;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Note;
import util.DateUtil;

/**
 *
 * @author Ezandro Bueno
 */
public class ScheduleControl {

    private final NoteControl noteCtr;
    private final DateUtil dateUtil;

    public ScheduleControl() {
        this.noteCtr = new NoteControl();
        this.dateUtil = new DateUtil();
    }

    private List<Note> itsTime() {
        List<Note> notes = this.noteCtr.getNotes();
        List<Note> alarmNotes = new ArrayList<>();

        for (Note note : notes) {
            if (note.getAlarm() == 1) {
                if (this.dateUtil.getDateTimeFormatted(note.getDateTimeAlarm())
                        .equals(this.dateUtil.getDateTimeFormatted(new Timestamp(new Date().getTime())))) {
                    alarmNotes.add(note);
                }
            }
        }
        return alarmNotes;
    }

    private void displayNotes(List<Note> alarms, TrayIcon trayIcon) {
        for (Note alarmNote : alarms) {
            trayIcon.displayMessage(alarmNote.getName(), alarmNote.getDescription(), TrayIcon.MessageType.INFO);
        }
    }

    public void initAlarms(TrayIcon trayIcon) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(60000);
                        List<Note> notes = itsTime();

                        if (!notes.isEmpty()) {
                            displayNotes(notes, trayIcon);
                        }

                    } catch (InterruptedException ex) {
                        System.out.println("Erro no monitoramento de alarmes: " + ex.getMessage());
                    }
                }
            }
        }.start();
    }
}
