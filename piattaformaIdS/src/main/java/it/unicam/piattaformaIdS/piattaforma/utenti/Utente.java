package it.unicam.piattaformaIdS.piattaforma.utenti;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoUtente", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor(force = true)
@Getter
public abstract class Utente {
    public String username;
    @Id
    public String email;
    public String password;

    public Utente(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        String emailRegex = "^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,}$";
        if (email.matches(emailRegex)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Il formato della email non è valido!");
        }
    }

    public void setPassword(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{5,}$";
        if (password.matches(passwordPattern)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("La password deve contenere almeno una maiuscola, un numero ed un carattere" +
                    "speciale; inoltre, deve essere lunga almeno 5 caratteri!");
        }
    }

}
