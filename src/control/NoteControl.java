package control;

import entity.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Note;

/**
 *
 * @author Ezandro Bueno
 */
public class NoteControl {

    public List<Note> getNotes() {
        List<Note> listNotes = new ArrayList<>();
        EntityManager manager = HibernateUtil.getManager();

        try {
            listNotes = manager.createQuery("FROM Note").getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao listar notas: " + e.getMessage());
        } finally {
            manager.close();
        }
        return listNotes;
    }

    public void save(Note note) {
        EntityManager manager = HibernateUtil.getManager();

        try {
            manager.getTransaction().begin();
            manager.persist(note);
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao salvar nota: " + e.getMessage());
        } finally {
            manager.close();
        }
    }
}