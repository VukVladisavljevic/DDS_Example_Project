package main.java.com.user_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Surname {

    @Column(name = "surname")
    private final String value;

    @SuppressWarnings("unused")
    public Surname() {
        this.value = null;
    }

    public Surname(String value) {

        isValid(value);

        this.value = value;

    }

    private void isValid(String value) {

        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("Surname not valid, can't be empty");
        }

        String chars = "(.*[A-Za-z].*)";
        if (!value.matches(chars)) {
            throw new DomainException("Surname not valid, can contain only letters");
        }
    }

    public String getValue() {
        return value;
    }

}
