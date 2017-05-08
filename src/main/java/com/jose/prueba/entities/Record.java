package com.jose.prueba.entities;

import org.postgresql.util.PGmoney;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by optimus-desarrollo on 07/05/17.
 */

@XmlRootElement
@Entity(name = "records")
public class Record implements Serializable {
    public Record() {
    }

    public Record(BigDecimal amount, String name, Timestamp application_date, Timestamp delivery_date, String state) {

        this.amount = amount;
        this.name = name;
        this.application_date = application_date;
        this.delivery_date = delivery_date;
        this.state = state;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private String name;
    private Timestamp application_date;
    private Timestamp delivery_date;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getApplication_date() {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(application_date.getTime());
        return date;
    }

    public void setApplication_date(Timestamp application_date) {
        this.application_date = application_date;
    }

    public Calendar getDelivery_date() {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(delivery_date.getTime());
        return date;
    }

    public void setDelivery_date(Timestamp delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
