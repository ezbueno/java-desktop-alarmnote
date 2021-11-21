package model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ezandro Bueno
 */

@Entity
public class Note implements Serializable {

    @Id
    private long id;
    
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    @Column(columnDefinition = "smallint default 0")
    private int alarm;
    
    private Timestamp dateTimeAlarm;
}
