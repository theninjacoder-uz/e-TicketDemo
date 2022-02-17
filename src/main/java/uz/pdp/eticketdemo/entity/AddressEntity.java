package uz.pdp.eticketdemo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country_name;

    @Column(nullable = false)
    private String region_name;

    @Column(nullable = false)
    private String city_name;

    @Column(nullable = false)
    private String street_name;

    @Column(nullable = false)
    private Integer home_number;
    

    // TODO: 2/17/2022 connections ManyToOne
}
