package com.company.ext.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "EXT_OWNERSHIP")
@Entity(name = "ext$Ownership")
@EnableRestore
@TrackEditScreenHistory
@NamePattern("%s|name")
public class Ownership extends StandardEntity {

    @Column(name = "NAME", length = 100)
    protected String name;

    @Column(name = "CODE", nullable = false, length = 50)
    protected String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}