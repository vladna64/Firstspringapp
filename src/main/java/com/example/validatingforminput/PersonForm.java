package com.example.validatingforminput;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serial;
public class PersonForm {
    @NotNull
    @Serial
    private long id;
    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max= 45)
    private String lastname;
    @NotNull
    @Min(18)
    private Integer age;
    @NotNull
    private Boolean start;
    @NotNull
    private Double procent;
    @NotNull
    private char des_score;

    public PersonForm(long id, String firstname, String lastname, Integer age, Boolean start, Double procent, char des_score) {
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.age=age;
        this.start=start;
        this.procent=procent;
        this.des_score=des_score;
    }

    public PersonForm() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String  lastname) {
        this.lastname = lastname;
    }
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getStart() {
        return this.start;
    }

    public void setStart(Boolean  start) {
        this.start = start;
    }

    public Double getProcent() {
        return this.procent;
    }

    public void setProcent(Double  procent) {
        this.procent = procent;
    }

    public char getDes_score() {
        return this.des_score;
    }

    public void setDes_score(char  des_score) {
        this.des_score = des_score;
    }

    public String toString() {
        return "Person(Firstname: " + this.firstname + ", Lastname: " + this.lastname + ", Start: " + this.start + "Age:"+ this.age +", Procent: " + this.procent + ", Des_score: " + this.des_score + ")";
    }
    private static final Logger log = LoggerFactory.getLogger(ValidatingforminputApplication.class);
}
