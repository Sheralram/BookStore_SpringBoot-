package com.bridgelabz.bookstorespringboot.model;



import javax.persistence.*;

import com.bridgelabz.bookstorespringboot.dto.AddressDetailsDto;
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


    public AddressDetails(AddressDetailsDto detailsDto , User user) {
        this.name = detailsDto.getName();
        this.pincode = detailsDto.getPincode();
        this.locality = detailsDto.getLocality();
        this.address = detailsDto.getAddress();
        this.city = detailsDto.getCity();
        this.landmark = detailsDto.getLandmark();
        this.user = user;
    }
}
