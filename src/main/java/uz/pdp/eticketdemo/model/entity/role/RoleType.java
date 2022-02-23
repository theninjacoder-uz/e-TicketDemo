package uz.pdp.eticketdemo.model.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum RoleType {
    COMMON_USER(1),
    MANAGER(2),
    ADMIN(4),
    SUPER_ADMIN(8);


    RoleType(int i) {

    }
}

