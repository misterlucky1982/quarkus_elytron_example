package nby.misterlucky.quarkus.identity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.*;
import nby.misterlucky.quarkus.util.CustomPasswordProvider;

@Entity
@Table(name = "quarkus_user")
@UserDefinition
public class User extends PanacheEntity {
    @Username
    @Column(name = "login")
    public String login;
    @Password(value = PasswordType.CUSTOM, provider = CustomPasswordProvider.class)
    @Column(name = "password")
    public String password;
    @Roles
    @Column(name = "role")
    public String role;
    @Column(name = "firstname")
    public String firstName;
    @Column(name = "lastname")
    public String lastName;
    @Column(name = "email")
    public String email;

    /*
    public static void add(String login, String firstname, String lastname, String password, String email, String role) {
        User user = new User();
        user.login = login;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.firstName = firstname;
        user.lastName = lastname;
        user.email = email;
        user.persist();
    }*/
}
