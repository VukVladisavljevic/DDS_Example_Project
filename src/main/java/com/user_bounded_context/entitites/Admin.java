package main.java.com.user_bounded_context.entitites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="USER_ID")
@DiscriminatorValue("A")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin extends User {
}
