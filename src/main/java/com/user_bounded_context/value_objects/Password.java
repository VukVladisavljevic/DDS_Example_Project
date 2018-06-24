package main.java.com.user_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Password {

    @Column(name = "password")
    private final String value;

    public Password () {
        this.value = null;
    }

    public Password(String pass){
        isValid(pass);

        this.value = pass;
    }

    public String getValue() {
        return value;
    }

    private void isValid(String value) {
        //Password - minimalna dužina bi trebala biti 8 karaktera,
        // i takođe bi trebalo proveriti kompleksnost lozinke
        // (da ima bar 1 malo slovo, 1 veliko slovo, 1 cifru);

        if(value.trim().length() < 8 || value.trim().length() > 32) {
            throw new DomainException("Password not valid, must be between 8 and 32 characters long");
        }

        String upperCaseChars = "(.*[A-Z].*)";
        if (!value.matches(upperCaseChars ))
        {
            throw new DomainException("Password not valid, must contain at least 1 upper case character");
        }

        String lowerCaseChars = "(.*[a-z].*)";
        if (!value.matches(lowerCaseChars ))
        {
            throw new DomainException("Password not valid, must contain at least 1 lower case character");
        }

        String digits = "(.*[0-9].*)";
        if (!value.matches(digits ))
        {
            throw new DomainException("Password not valid, must contain at least 1 digit character");
        }

        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!value.matches(specialChars ))
        {
            throw new DomainException("Password not valid, must contain at least 1 special character");
        }
    }

}
