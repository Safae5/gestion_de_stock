package com.aryama.gestiondestock.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creationDate", nullable = false, updatable = false)
    @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    @JsonIgnore
    private Instant lastModifiedDate;



}

