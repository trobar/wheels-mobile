package com.doit.wheels.dao.entities;

import com.doit.wheels.dao.entities.basic.Contact;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends Contact {
    private String comment;

    @OneToMany(mappedBy = "customer")
    @Cascade(CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<CustomerContact> customerContacts;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Order> orders;

    public Customer() {}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<CustomerContact> getCustomerContacts() {
        return customerContacts;
    }

    public void setCustomerContacts(List<CustomerContact> customerContacts) {
        this.customerContacts = customerContacts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getFullName(){
        return this.getFirstname() + " " + this.getLastname();
    }
}
