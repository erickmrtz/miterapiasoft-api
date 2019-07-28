package pe.edu.pucp.miterapia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private String dni;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;
    private String picture_addr;
    private Integer gender;
    private String type;
}
