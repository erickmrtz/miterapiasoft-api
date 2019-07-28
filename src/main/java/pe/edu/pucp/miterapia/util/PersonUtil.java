package pe.edu.pucp.miterapia.util;

public abstract class PersonUtil {
    private static final String PATIENT_STR = "PATIENT";
    private static final String WORKER_STR = "WORKER";

    private static final Integer PATIENT = 1;
    private static final Integer WORKER = 2;

    private static final String GENDER_MALE = "MALE";
    private static final String GENDER_FEMALE = "FEMALE";

    private static final Integer MALE = 0;
    private static final Integer FEMALE = 1;

    public static final String ID_INCORRECT = "DNI DOESN'T EXIST";

    public static String genderToDTO(Integer gender){
        if(gender.equals(PersonUtil.MALE)) return PersonUtil.GENDER_MALE;
        else return PersonUtil.GENDER_FEMALE;
    }

    public static String typeToDTO(Integer type_person){
        if(type_person.equals(PersonUtil.PATIENT)) return PersonUtil.PATIENT_STR;
        else return PersonUtil.WORKER_STR;
    }

    public static Integer dtoToGender(String gender){
        if(gender.toUpperCase().equals(PersonUtil.GENDER_MALE)) return PersonUtil.MALE;
        else return PersonUtil.FEMALE;
    }

    public static Integer dtoToType(String type_person){
        if(type_person.toUpperCase().equals(PersonUtil.PATIENT_STR)) return PersonUtil.PATIENT;
        else return PersonUtil.WORKER;
    }
}
