package com.doit.wheels.dao.entities;

import com.doit.wheels.dao.entities.basic.AbstractModel;
import com.doit.wheels.utils.enums.StatusTypeEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class WheelRimPosition extends AbstractModel implements Comparable<WheelRimPosition>{

    private String positionNo;

    @ManyToOne
    @JsonManagedReference
    private Manufacturer manufacturerWheel;

    @ManyToOne
    @JsonManagedReference
    private Model model;

    @ManyToOne
    @JsonManagedReference
    private ModelType modelType;
    private Integer size;
    private Boolean hubCover;

    @ManyToOne
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JsonManagedReference
    private ValveType valveType;

    @ManyToOne
    @JsonManagedReference
    private Manufacturer manufacturerRim;

    @Enumerated(EnumType.STRING)
    private StatusTypeEnum status;
    private Integer width;
    private Integer height;
    private Integer diameter;
    private Integer indexVal;
    private String speed;

    private String qrCode;

    public WheelRimPosition() {}

    public String getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(String positionNo) {
        this.positionNo = positionNo;
    }

    public Manufacturer getManufacturerWheel() {
        return manufacturerWheel;
    }

    public void setManufacturerWheel(Manufacturer manufacturerWheel) {
        this.manufacturerWheel = manufacturerWheel;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getHubCover() {
        return hubCover;
    }

    public void setHubCover(Boolean hubCover) {
        this.hubCover = hubCover;
    }

    public ValveType getValveType() {
        return valveType;
    }

    public void setValveType(ValveType valveType) {
        this.valveType = valveType;
    }

    public Manufacturer getManufacturerRim() {
        return manufacturerRim;
    }

    public void setManufacturerRim(Manufacturer manufacturerRim) {
        this.manufacturerRim = manufacturerRim;
    }

    public StatusTypeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTypeEnum status) {
        this.status = status;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Integer getIndexVal() {
        return indexVal;
    }

    public void setIndexVal(Integer indexVal) {
        this.indexVal = indexVal;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public int compareTo(WheelRimPosition o) {
        return Integer.valueOf(this.getPositionNo()) - Integer.valueOf(o.getPositionNo());
    }
}
