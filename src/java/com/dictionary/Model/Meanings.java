/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dictionary.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Denis
 */
@Entity
@Table(name = "MEANINGS")
@NamedQueries({
    @NamedQuery(name = "Meanings.findAll", query = "SELECT m FROM Meanings m"),
    @NamedQuery(name = "Meanings.findByMId", query = "SELECT m FROM Meanings m WHERE m.mId = :mId"),
    @NamedQuery(name = "Meanings.findByMvalue", query = "SELECT m FROM Meanings m WHERE m.mvalue = :mvalue")})
public class Meanings implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "M_ID")
    private BigDecimal mId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MVALUE")
    private String mvalue;
    @JoinColumn(name = "POF_ID", referencedColumnName = "POF_ID")
    @ManyToOne(optional = false)
    private PartsOfSpeach pofId;

    public Meanings() {
    }

    public Meanings(BigDecimal mId) {
        this.mId = mId;
    }

    public Meanings(BigDecimal mId, String mvalue) {
        this.mId = mId;
        this.mvalue = mvalue;
    }

    public BigDecimal getMId() {
        return mId;
    }

    public void setMId(BigDecimal mId) {
        this.mId = mId;
    }

    public String getMvalue() {
        return mvalue;
    }

    public void setMvalue(String mvalue) {
        this.mvalue = mvalue;
    }

    public PartsOfSpeach getPofId() {
        return pofId;
    }

    public void setPofId(PartsOfSpeach pofId) {
        this.pofId = pofId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meanings)) {
            return false;
        }
        Meanings other = (Meanings) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dictionary.Model.Meanings[ mId=" + mId + " ]";
    }
    
}
