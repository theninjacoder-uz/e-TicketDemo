package uz.pdp.eticketdemo.model.entity.train;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.ticket.ServicesEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "wagon_type")
public class WagonTypeEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double price;

    @ManyToMany
    private List<ServicesEntity> services;

}
