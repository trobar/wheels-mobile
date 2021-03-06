package com.doit.wheels.dao.entities;

import com.doit.wheels.dao.entities.basic.AbstractModel;
import com.doit.wheels.utils.enums.StatusTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractModel {

    private String orderNo;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date created;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date lastUpdated;

    @ManyToOne
    @JsonIgnore
    private User createdByUser;

    @ManyToOne
    @JsonIgnore
    private User lastUpdatedByUser;

    @Enumerated(EnumType.STRING)
    private StatusTypeEnum status = StatusTypeEnum.IN_CREATION;

    @ManyToOne
    @JsonManagedReference
    private Customer customer;

    private String customerNumberOrder;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date deadlineFinish;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date deadlineDelivery;

    @Column(length = 1000)
    private String comment;

    @ManyToOne
    @JsonManagedReference
    private User driver;

    @Lob
    @JsonIgnore
    private byte[] wheelsRimPicture1;

    @Lob
    @JsonIgnore
    private byte[] wheelsRimPicture2;

    @Lob
    @JsonIgnore
    private byte[] wheelsRimPicture3;

    @Lob
    @JsonIgnore
    private byte[] wheelsRimPicture4;

    @Lob
    private byte[] signaturePicture;

    @Column
    private String signatureName;

    private String qrCode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_wheel_rim_positions",joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "wheel_rim_position_id") })
    @JsonManagedReference
    private Set<WheelRimPosition> wheelRimPositions;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "orders_guidelines",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "guideline_id")})
    @JsonIgnore
    @JsonManagedReference
    private Set<Guideline> guidelines = new HashSet<>();

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<PrintJob> printJobs;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerNumberOrder() {
        return customerNumberOrder;
    }

    public void setCustomerNumberOrder(String customerNumberOrder) {
        this.customerNumberOrder = customerNumberOrder;
    }

    public Date getDeadlineFinish() {
        return deadlineFinish;
    }

    public void setDeadlineFinish(Date deadlineFinish) {
        this.deadlineFinish = deadlineFinish;
    }

    public Date getDeadlineDelivery() {
        return deadlineDelivery;
    }

    public void setDeadlineDelivery(Date deadlineDelivery) {
        this.deadlineDelivery = deadlineDelivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public User getLastUpdatedByUser() {
        return lastUpdatedByUser;
    }

    public void setLastUpdatedByUser(User lastUpdatedByUser) {
        this.lastUpdatedByUser = lastUpdatedByUser;
    }

    public StatusTypeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTypeEnum status) {
        this.status = status;
    }

    public Set<WheelRimPosition> getWheelRimPositions() {
        return wheelRimPositions;
    }

    public void setWheelRimPositions(Set<WheelRimPosition> wheelRimPositions) {
        this.wheelRimPositions = wheelRimPositions;
    }

    public Set<Guideline> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(Set<Guideline> guidelines) {
        this.guidelines = guidelines;
    }

    public List<PrintJob> getPrintJobs() {
        return printJobs;
    }

    public void setPrintJobs(List<PrintJob> printJobs) {
        this.printJobs = printJobs;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public byte[] getWheelsRimPicture1() {
        return wheelsRimPicture1;
    }

    public void setWheelsRimPicture1(byte[] wheelsRimPicture1) {
        this.wheelsRimPicture1 = wheelsRimPicture1;
    }

    public byte[] getWheelsRimPicture2() {
        return wheelsRimPicture2;
    }

    public void setWheelsRimPicture2(byte[] wheelsRimPicture2) {
        this.wheelsRimPicture2 = wheelsRimPicture2;
    }

    public byte[] getWheelsRimPicture3() {
        return wheelsRimPicture3;
    }

    public void setWheelsRimPicture3(byte[] wheelsRimPicture3) {
        this.wheelsRimPicture3 = wheelsRimPicture3;
    }

    public byte[] getWheelsRimPicture4() {
        return wheelsRimPicture4;
    }

    public void setWheelsRimPicture4(byte[] wheelsRimPicture4) {
        this.wheelsRimPicture4 = wheelsRimPicture4;
    }

    public byte[] getSignaturePicture() {
        return signaturePicture;
    }

    public void setSignaturePicture(byte[] signaturePicture) {
        this.signaturePicture = signaturePicture;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }
}
