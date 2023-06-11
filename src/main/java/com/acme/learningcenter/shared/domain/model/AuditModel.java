package com.acme.learningcenter.shared.domain.model;

import jakarta.persistence.Column;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.io.Serializable;
import java.util.Date;

public abstract class AuditModel implements Serializable {

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @Column(name="updated_at", nullable = false)
    private Date updateAt;
}
