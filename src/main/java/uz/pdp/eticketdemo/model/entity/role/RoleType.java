package uz.pdp.eticketdemo.model.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    COMMON_USER("COMMON_USER"),
    ADMIN("ADMIN"),
    MANAGER("MANAGER");

    private final String name;

    public static RoleType get(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        for (RoleType roleTypeEnum : RoleType.values()) {
            if (roleTypeEnum.getName().equalsIgnoreCase(type)) {
                return roleTypeEnum;
            }
        }
        return null;
    }
}

