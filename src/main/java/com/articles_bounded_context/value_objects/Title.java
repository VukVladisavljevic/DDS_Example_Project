package main.java.com.articles_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Title {

    @Column(name = "title")
    private final String value;

    public Title() {
        this.value = null;
    }
    public Title( String value) {

        isValid(value);

        this.value = value;
    }

    private void isValid(String value){

        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("Title can't be empty! " );
        }

        if(value.length() > 500 ){
            throw new DomainException("Provided title is longer than maximum allowed characters" );
        }

    }

    public String getValue() {
        return value;
    }
}