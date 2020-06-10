package com.staxrt.odco.model;



import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdRegion", query = "SELECT r FROM Region r WHERE r.idRegion = :idRegion"),
    @NamedQuery(name = "Region.findByNomRegion", query = "SELECT r FROM Region r WHERE r.nomRegion = :nomRegion")})
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_region", nullable = false)
    private Integer idRegion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom_region", nullable = false, length = 60)
    private String nomRegion;
    
    
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegion")
    private Collection<Cooperative> cooperativeCollection;

    public Region() {
    }

    public Region(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Region(Integer idRegion, String nomRegion) {
        this.idRegion = idRegion;
        this.nomRegion = nomRegion;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

   
    @XmlTransient
    public Collection<Cooperative> getCooperativeCollection() {
        return cooperativeCollection;
    }

    public void setCooperativeCollection(Collection<Cooperative> cooperativeCollection) {
        this.cooperativeCollection = cooperativeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegion != null ? idRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idRegion == null && other.idRegion != null) || (this.idRegion != null && !this.idRegion.equals(other.idRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.entities.Region[ idRegion=" + idRegion + " ]";
    }
    
}