package pe.edu.pucp.miterapia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TypeWorker")
@Getter
@Setter
@NoArgsConstructor
public class TypeWorker {
    @Id
    @Column(name = "id_typeWorker")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_typeWorker;

    @Column(name = "name")
    private String name;

    @Column(name = "charge")
    private Double charge;

    @Column(name = "description")
    private String description;
}
