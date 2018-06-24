package main.java.com.user_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Address{

    @Column(name = "address")
    private final String value;

    public Address() {
        this.value = null;
    }

    public Address(String address){
        isValid(address);

        this.value = address;
    }

    private void isValid(String value){

        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("Address not valid, can't be empty");
        }

        String chars = "(.*[A-Za-z0-9].*)";
        if (!value.matches(chars)) {
            throw new DomainException("Surname not valid, can contain only letters and digits");
        }
    }

    public String getValue() {
        return value;
    }

}
