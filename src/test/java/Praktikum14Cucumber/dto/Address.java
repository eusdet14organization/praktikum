package Praktikum14Cucumber.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {
    private String country;
    private String city;
    private String province;
    private String street;
    private String zipCode;
    private String phoneNumber;
}
