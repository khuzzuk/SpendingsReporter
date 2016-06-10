package pl.spendings.users;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import pl.spendings.messages.annot.Message;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Entity @Table(name = "users")
@Message
public class User {
    @Id
    @GeneratedValue
    @Setter
    private long id;

    @NotNull
    @Size(min = 6, max = 30, message = "{password.valid}")
    @Column(name = "pass")
    @Getter @Setter
    private String password;

    @NotNull
    @Email(message = "{email.valid}")
    @Column(unique = true)
    @Getter @Setter
    private String email;

    public long getId() {
        return id;
    }
}
