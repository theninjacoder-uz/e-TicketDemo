package uz.pdp.eticketdemo.model.entity.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    private String chatId;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

//    @Column(columnDefinition = "boolean default true")
//    private Boolean userStatus;

    private Integer user_role;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<RoleEntity> roleList;

}