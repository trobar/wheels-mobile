package com.doit.wheels.dao.entities;

import com.doit.wheels.dao.entities.basic.Description;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Guideline extends Description {

    @ManyToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "orders_guidelines",
            joinColumns = {@JoinColumn(name = "guideline_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")})
    @JsonIgnore
    private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Guideline){
            if (((Guideline) obj).getId().equals(this.getId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        long result = this.getId();
        result = 31 * result + getDescription().hashCode();
        return (int) result;
    }
}
