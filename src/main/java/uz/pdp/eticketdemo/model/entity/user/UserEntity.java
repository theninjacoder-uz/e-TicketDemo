package uz.pdp.eticketdemo.model.entity.user;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;
import uz.pdp.eticketdemo.model.entity.role.RoleEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column
    private String chatId;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private Boolean userStatus;

    private int user_role;

//    @ManyToMany
//    private List<RoleEntity> role;
}