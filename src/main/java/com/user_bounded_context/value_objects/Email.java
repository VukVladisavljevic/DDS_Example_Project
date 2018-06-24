package main.java.com.user_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email  {

    @Column(name = "email")
    private final String value;

    public Email() {
        this.value = null;
    }

    public Email( String value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid Email value. Got " + value + ".");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValid(String value){

        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        return true;
    }

}
