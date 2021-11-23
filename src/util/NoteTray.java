package util;

import control.ScheduleControl;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Ezandro Bueno
 */
public class NoteTray {
    
    private TrayIcon trayIcon;
    private PopupMenu popup;
    private MenuItem openItem;
    private MenuItem exitItem;
    private Image image;
    private JFrame jFrame;
    private SystemTray tray;
    private ScheduleControl scheduleControl;
    
    public NoteTray(JFrame jFrame) {
        this.popup = new PopupMenu();
        this.openItem = new MenuItem("Abrir");
        this.exitItem = new MenuItem("Sair");
        this.image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tray.png"));
        this.trayIcon = new TrayIcon(image, "AlarmNote", this.popup);
        this.trayIcon.setImageAutoSize(true);
        this.jFrame = jFrame;
        this.scheduleControl = new ScheduleControl();
    }
    
    public void createNoteTray() {
        this.tray = SystemTray.getSystemTray();
        this.popup.add(this.openItem);
        this.popup.add(this.exitItem);
        this.openItem.addActionListener(this.getActionMaximize());
        this.trayIcon.addActionListener(this.getActionMaximize());
        this.exitItem.addActionListener(this.getActionClose());
        
        try {
            this.tray.add(this.trayIcon);
            this.scheduleControl.initAlarms(this.trayIcon);
        } catch (AWTException ex) {
            System.out.println("Erro ao carregar NoteTray!");
        }
    }
    
    public ActionListener getActionMaximize() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(true);
            }
        };
    }
    
    public ActionListener getActionClose() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }
    
    public void minimize() {
        this.trayIcon.displayMessage("Eiii", "Ainda continuo aqui o/", TrayIcon.MessageType.INFO);
    }
}
