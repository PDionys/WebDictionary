/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dictionary.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Denis
 */
@Entity
@Table(name = "PARTS_OF_SPEACH")
@NamedQueries({
    @NamedQuery(name = "PartsOfSpeach.findAll", query = "SELECT p FROM PartsOfSpeach p"),
    @NamedQuery(name = "PartsOfSpeach.findByPofId", query = "SELECT p FROM PartsOfSpeach p WHERE p.pofId = :pofId"),
    @NamedQuery(name = "PartsOfSpeach.findBywId", query = "SELECT p FROM PartsOfSpeach p WHERE p.wId = :wId"),
    @NamedQuery(name = "PartsOfSpeach.findByPof", query = "SELECT p FROM PartsOfSpeach p WHERE p.pof = :pof")})
public class PartsOfSpeach implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "POF_ID")
    private BigDecimal pofId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "POF")
    private String pof;
    @JoinColumn(name = "W_ID", referencedColumnName = "W_ID")
    @ManyToOne(optional = false)
    private Words wId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pofId")
    private Collection<Meanings> meaningsCollection;

    public PartsOfSpeach() {
    }

    public PartsOfSpeach(BigDecimal pofId) {
        this.pofId = pofId;
    }

    public PartsOfSpeach(BigDecimal pofId, String pof) {
        this.pofId = pofId;
        this.pof = pof;
    }

    public BigDecimal getPofId() {
        return pofId;
    }

    public void setPofId(BigDecimal pofId) {
        this.pofId = pofId;
    }

    public String getPof() {
        return pof;
    }

    public void setPof(String pof) {
        this.pof = pof;
    }

    public Words getWId() {
        return wId;
    }

    public void setWId(Words wId) {
        this.wId = wId;
    }

    public Collection<Meanings> getMeaningsCollection() {
        return meaningsCollection;
    }

    public void setMeaningsCollection(Collection<Meanings> meaningsCollection) {
        this.meaningsCollection = meaningsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pofId != null ? pofId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartsOfSpeach)) {
            return false;
        }
        PartsOfSpeach other = (PartsOfSpeach) object;
        if ((this.pofId == null && other.pofId != null) || (this.pofId != null && !this.pofId.equals(other.pofId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        
        return null;
    }
    
}
