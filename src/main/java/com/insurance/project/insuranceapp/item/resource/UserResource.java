package com.insurance.project.insuranceapp.item.resource;

import com.insurance.project.insuranceapp.item.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserResource {

    @Min(0)
    private long id;
    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull
    @Size(min = 1)
    private String surname;
    @Email
    @NotNull
    @Size(min = 1)
    private String email;
    private String birthNumber;
    @NotNull
    @Size(min = 1)
    private String postalCode;
    @NotNull
    @Size(min = 1)
    private String city;
    @NotNull
    @Size(min = 1)
    private String street;
    @NotNull
    @Size(min = 1)
    private String house;
    private String correAddress;


    public UserResource(User user) {
        this.id=user.getId();
        this.name=user.getName();
        this.surname=user.getSurname();
        this.email=user.getEmail();
        this.birthNumber=user.getBirthNumber();
        this.postalCode=user.getPostalCode();
        this.city=user.getCity();
        this.street=user.getStreet();
        this.house=user.getHouse();
        this.correAddress=user.getCorreAddress();

    }

    public User toUser(long id) {
        return new User(
                id,
                name,
                surname,
                email,
                birthNumber,
                postalCode,
                city,
                street,
                house,
                correAddress

        );
    }

}
