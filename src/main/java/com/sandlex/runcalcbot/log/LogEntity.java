package com.sandlex.runcalcbot.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@EntityListeners(AuditingEntityListener.class)
class LogEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private Integer personId;

    @Column
    private String paceBlock;

    @Column
    private String schema;

    @NotEmpty
    @Column(nullable = false)
    private String result;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

}

