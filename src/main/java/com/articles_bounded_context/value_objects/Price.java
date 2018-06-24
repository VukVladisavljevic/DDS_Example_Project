package main.java.com.articles_bounded_context.value_objects;

import com.infrastructure.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price{

    @Column(name = "price")
    private final double value;

    public Price() {
        this.value = 0;
    }

    public Price(final double value) {

        if (!isValid(value)) {
            throw new DomainException("Price value not valid. Got " + value);
        }
        this.value = value;

    }

    private boolean isValid(double value) {
        if(value <= 0 || value >= 100000) {
            return false;
        }

        return true;
    }

    public double getValue() {
        return value;
    }

}
