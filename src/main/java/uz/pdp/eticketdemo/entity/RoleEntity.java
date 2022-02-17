package uz.pdp.eticketdemo.entity;

import lombok.*;
import uz.pdp.eticketdemo.enums.RoleType;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public RoleEntity(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getAuthority() {
        return roleType.name();
    }

    // TODO: 2/17/2022 This class should be optimized add connection like monytoone
}
