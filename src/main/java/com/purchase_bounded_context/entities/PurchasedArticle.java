package main.java.com.purchase_bounded_context.entities;

import com.articles_bounded_context.value_objects.Quantity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class PurchasedArticle {

    @Id
    @GeneratedValue
    private int id;

    private long itemID;
    private Quantity itemCount;

    @JsonBackReference(value="customer_purchasedArticles")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    public PurchasedArticle() {}

    public PurchasedArticle(long itemID, int itemCount) {
        this.itemID = itemID;
        this.itemCount = new Quantity(itemCount);
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public Quantity getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = new Quantity(itemCount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
