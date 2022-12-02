package kg.sklad.entities;

import kg.sklad.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userEmail;
    private String firstName;
    private String lastName;
    private String userPassword;
    private Roles role;
    private String activationCode;
    private int enable;
}
