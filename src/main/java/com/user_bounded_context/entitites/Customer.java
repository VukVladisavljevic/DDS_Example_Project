package main.java.com.user_bounded_context.entitites;

import com.purchase_bounded_context.entities.Purchase;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.user_bounded_context.value_objects.Address;

import javax.persistence.*;
import java.util.Collection;

@PrimaryKeyJoinColumn(name="USER_ID")
@DiscriminatorValue("G")
@Entity
public class Customer extends User{

    @Embedded
    private Address address;

    @JsonManagedReference(value="customer_purchases")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Purchase> purchasesMade;

    public Customer(){

    }

    public Customer(String email, String password, String name, String surname, String address) {
        super(email, password, name, surname);
        this.setAddress(address);
        this.userRole = UserRole.GUEST;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = new Address(address);
    }


    public Collection<Purchase> getPurchasesMade() {
        return purchasesMade;
    }

    public void setPurchasesMade(Collection<Purchase> purchasesMade) {
        this.purchasesMade = purchasesMade;
    }
}
