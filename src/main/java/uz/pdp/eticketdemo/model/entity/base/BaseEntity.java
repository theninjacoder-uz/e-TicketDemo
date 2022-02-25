package uz.pdp.eticketdemo.model.entity.base;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ColumnDefault("true")
    protected boolean isActive;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdDate;

    @UpdateTimestamp
    protected LocalDateTime updatedDate;

    @LastModifiedBy
    protected String updatedBy;

    @CreatedBy
    @Column(updatable = false)
    protected String createdBy;
}
