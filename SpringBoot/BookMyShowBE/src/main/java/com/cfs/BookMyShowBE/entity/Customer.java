package com.cfs.BookMyShowBE.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers" , uniqueConstraints = {
        @UniqueConstraint(name = "uk_customer_phone",columnNames = "phone"),
        @UniqueConstraint(name="uk_customer_email",columnNames = "email")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public Customer()
    {

    }
    private String name;

    @Column(nullable = false,length = 200)
    @NotBlank(message = "email should not be blanked")
    private String email;

    @Column(nullable = false,length = 20)
    private String phone;

//
}
