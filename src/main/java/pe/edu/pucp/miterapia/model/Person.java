package pe.edu.pucp.miterapia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.pucp.miterapia.dto.PersonDTO;
import pe.edu.pucp.miterapia.util.PersonUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_person;

    @Column(name = "dni")
    private String dni;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "picture_addr")
    private String picture_addr;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "person_type")
    private Integer person_type;

    @Column(name = "active")
    private Integer active;

    public PersonDTO toDTO(){
        return new PersonDTO(
                this.getDni(),
                this.getFirst_name(),
                this.getLast_name(),
                this.getPhone_number(),
                this.getEmail(),
                this.getAddress(),
                this.getPicture_addr(),
                PersonUtil.genderToDTO(this.getGender()),
                PersonUtil.typeToDTO(this.getPerson_type())
        );
    }

    public Person(String dni, String first_name,
                  String last_name, String phone_number,
                  String email, String address,
                  String picture_addr, Integer gender,
                  Integer person_type, Integer active) {
        this.dni = dni;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.picture_addr = picture_addr;
        this.gender = gender;
        this.person_type = person_type;
        this.active = active;
    }
}
