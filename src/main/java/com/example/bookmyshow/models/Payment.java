package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity

public class Payment extends  BaseModel{
    private long amount;
    private long refNo;
    @Enumerated(EnumType.ORDINAL)

    private PaymentProvider paymentProvider;
    private PaymentStatus status;
    @Enumerated(EnumType.ORDINAL)

    private PaymentMethod paymentMethod;
    private int referenceNumber;
    private Date timeStamp;

}
