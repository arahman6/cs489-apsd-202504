package edu.miu.cs.cs489.adsdentalapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "surgeries")
@Data
@NoArgsConstructor
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "surgery_id")
    private Long id;

    @Column(name = "surgery_no", unique = true, nullable = false)
    private String surgeryNo;

    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


    public Surgery(String surgeryNo, String name, Address address) {
        this.surgeryNo = surgeryNo;
        this.name = name;
        this.address = address;
    }

}
