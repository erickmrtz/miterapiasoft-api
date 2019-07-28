package pe.edu.pucp.miterapia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Worker")
@Getter
@Setter
@NoArgsConstructor
public class Worker {
    @Id
    @Column(name = "id_worker")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_worker;

    @JoinColumn(name = "id_person")
    @OneToOne
    private Person person;

    @JoinColumn(name = "id_typeWorker")
    @OneToOne
    private TypeWorker typeWorker;

    @Column(name = "id_calendar")
    private String id_calendar;
}
