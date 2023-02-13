package com.example.model;
import com.example.annotation.PersonValidationInterface;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
@Entity
//@Getter
//@Setter
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ToString(includeFieldNames=true)
public class PersonForm {
    @NotNull
    @Id
    @Serial
    private long id;
    @NotNull
    @PersonValidationInterface
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max= 45)
    @PersonValidationInterface
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
}
