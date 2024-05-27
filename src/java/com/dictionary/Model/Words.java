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
@Table(name = "WORDS")
@NamedQueries({
    @NamedQuery(name = "Words.findAll", query = "SELECT w FROM Words w"),
    @NamedQuery(name = "Words.findByWId", query = "SELECT w FROM Words w WHERE w.wId = :wId"),
    @NamedQuery(name = "Words.findAllByWord", query = "SELECT w FROM Words w WHERE w.word LIKE :keyword"),
    @NamedQuery(name = "Words.findByWord", query = "SELECT w FROM Words w WHERE w.word = :word")})
public class Words implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "W_ID")
    private BigDecimal wId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "WORD")
    private String word;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wId")
    private Collection<PartsOfSpeach> partsOfSpeachCollection;

    public Words() {
    }

    public Words(BigDecimal wId) {
        this.wId = wId;
    }

    public Words(BigDecimal wId, String word) {
        this.wId = wId;
        this.word = word;
    }
    
    public Words(String word) {
        this.word = word;
    }

    public BigDecimal getWId() {
        return wId;
    }

    public void setWId(BigDecimal wId) {
        this.wId = wId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Collection<PartsOfSpeach> getPartsOfSpeachCollection() {
        return partsOfSpeachCollection;
    }

    public void setPartsOfSpeachCollection(Collection<PartsOfSpeach> partsOfSpeachCollection) {
        this.partsOfSpeachCollection = partsOfSpeachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wId != null ? wId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Words)) {
            return false;
        }
        Words other = (Words) object;
        if ((this.wId == null && other.wId != null) || (this.wId != null && !this.wId.equals(other.wId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        int i = 0;
        for(PartsOfSpeach pof : partsOfSpeachCollection){
            if(i == partsOfSpeachCollection.size()-1)
                result+=pof.getPof();
            else result+=pof.getPof()+";";
            i++;
        }
        
        return result;
    }
    
    public String toStringPoF(){
        String result = "";
        int i = 1;
        for(PartsOfSpeach pof : partsOfSpeachCollection){
            int k = 0;
            for(Meanings m : pof.getMeaningsCollection()){
                if(i == partsOfSpeachCollection.size() && k == pof.getMeaningsCollection().size()-1)
                    result+= i + "." + m.getMvalue();
                else result+= i + "." + m.getMvalue() + "\n";
                k++;
            }
            i++;
        }
        
        return result;
    }
    
}
