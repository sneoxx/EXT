/*
 * Copyright (c) ${YEAR} ${PACKAGE_NAME}
 */

package com.company.ext.entity;

import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.thesis.core.entity.Company;

import javax.persistence.*;

@Extends(Company.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("F")
@Entity(name = "ext$Company")
public class ExtCompany extends Company {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNERSHIP_ID")
    protected Ownership ownership;

    public Ownership getOwnership() {
        return ownership;
    }

    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }
}
