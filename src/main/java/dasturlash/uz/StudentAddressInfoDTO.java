package dasturlash.uz;


public class StudentAddressInfoDTO {
    private Integer studentId;
    private String name;
    private String surname;
    private Integer addressId;
    private String city;
    private String region;

    public StudentAddressInfoDTO(Integer studentId, String name, String surname, Integer addressId, String city, String region) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.addressId = addressId;
        this.city = city;
        this.region = region;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
