package uz.pdp.eticketdemo.model.entity.ticket;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "services")
public class ServicesEntity extends BaseEntity {

    private String name;

    private String description;

    private double price;

}
