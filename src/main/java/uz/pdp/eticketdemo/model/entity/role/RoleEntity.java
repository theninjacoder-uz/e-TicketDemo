package uz.pdp.eticketdemo.model.entity.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

}
