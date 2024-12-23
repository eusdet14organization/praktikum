package Praktikum14Cucumber.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String password;
}