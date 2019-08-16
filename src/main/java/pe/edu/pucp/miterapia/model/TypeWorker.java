package pe.edu.pucp.miterapia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.pucp.miterapia.dto.TypeWorkerDTO;

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

    @Column(name = "active")
    private Integer active;
    public TypeWorkerDTO toDTO(){
        return new TypeWorkerDTO(
                this.getName(),
                this.getCharge(),
                this.getDescription()
        );
    }

    public TypeWorker(String name, Double charge, String description, Integer active) {
        this.name = name;
        this.charge = charge;
        this.description = description;
        this.active = active;
    }
}
