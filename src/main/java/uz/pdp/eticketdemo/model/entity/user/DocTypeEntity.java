package uz.pdp.eticketdemo.model.entity.user;

import lombok.*;
import uz.pdp.eticketdemo.model.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "doc_type")
public class DocTypeEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
