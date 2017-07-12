package com.doit.wheels.dao.entities;

import com.doit.wheels.dao.entities.basic.Contact;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends Contact {
    private String comment;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private List<CustomerContact> customerContacts;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonIgnore
    public List<CustomerContact> getCustomerContacts() {
        return customerContacts;
    }

    public void setCustomerContacts(List<CustomerContact> customerContacts) {
        this.customerContacts = customerContacts;
    }

    @JsonIgnore
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
