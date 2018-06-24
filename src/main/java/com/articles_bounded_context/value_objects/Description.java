package main.java.com.articles_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Description {

    @Column(name = "address")
    private final String value;

    public Description() {
        this.value = null;
    }

    public Description(String desc) {
        isValid(desc);

        this.value = desc;
    }

    private void isValid(String value) {

        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("Description can't be empty! " );
        }

        if(value.length() > 500){
            throw new DomainException("Provided description is longer than allowed 500 characters" );
        }
    }

    public String getValue() {
        return value;
    }
}