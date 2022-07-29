package dev.practice.order.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    //@CreateDate : ZoneDateTime 지원 X
    @CreationTimestamp
    private ZonedDateTime createAt;
    //@LastModifiedDate : ZoneDateTime 지원 X
    @UpdateTimestamp
    private ZonedDateTime updateAt;
}
