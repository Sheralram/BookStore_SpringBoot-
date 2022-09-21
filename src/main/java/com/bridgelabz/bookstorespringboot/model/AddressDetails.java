package com.bridgelabz.bookstorespringboot.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Entity
@Table(name="Address_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String name;
    private String pincode;
    private String locality;
    private String address;
    private String city;
    private String landmark;
    private int type;

    @JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user")
    private User user;

    public AddressDetails(String name, String pincode, String locality, String address, String city,
                          String landmark, int type, User user) {
        super();
        this.name = name;
        this.pincode = pincode;
        this.locality = locality;
        this.address = address;
        this.city = city;
        this.landmark = landmark;
        this.type = type;
        this.user = user;
    }
}
