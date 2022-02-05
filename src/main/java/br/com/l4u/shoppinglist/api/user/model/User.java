package br.com.l4u.shoppinglist.api.user.model;

import br.com.l4u.user.Gender;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String displayName;
    private Gender gender;
    private LocalDate birthday;
}
