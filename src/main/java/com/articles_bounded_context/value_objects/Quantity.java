package main.java.com.articles_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Quantity{

    @Column(name = "units")
    private final int value;

    @SuppressWarnings("unused")
    public Quantity() {
        this.value = 0;
    }

    public Quantity(int value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid quantity value. Got " + value + ".");
        }

        this.value = value;

    }

    private boolean isValid(int value){
        if (value >= 1000 || value <= 0) {
            return false;
        }

        return true;
    }

    public int getValue() {
        return value;
    }

}
