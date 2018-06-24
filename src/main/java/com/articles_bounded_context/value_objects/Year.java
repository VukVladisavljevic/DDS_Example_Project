package main.java.com.articles_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Year  {

    @Column(name = "year")
    private final int value;

    public Year() {
        this.value = 0;
    }

    public Year( int value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid year value. Got " + value + ".");
        }

        this.value = value;
    }

    private boolean isValid(int value){
        if (value >= 2100 || value <= 0) {
            return false;
        }

        return true;
    }

    public int getValue() {
        return value;
    }
}
