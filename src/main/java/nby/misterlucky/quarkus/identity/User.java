package nby.misterlucky.quarkus.identity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.PasswordType;
import io.quarkus.security.jpa.Password;
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

    public static User findByLogin(String login) {
        return (User) find("login", login).singleResultOptional().orElseThrow(NoSuchUserIdentityException::new);
    }

}
