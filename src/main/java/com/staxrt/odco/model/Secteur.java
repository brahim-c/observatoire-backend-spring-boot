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
@Table(name = "secteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secteur.findAll", query = "SELECT s FROM Secteur s"),
    @NamedQuery(name = "Secteur.findByIdSecteur", query = "SELECT s FROM Secteur s WHERE s.idSecteur = :idSecteur"),
    @NamedQuery(name = "Secteur.findByNomSec", query = "SELECT s FROM Secteur s WHERE s.nomSec = :nomSec")})
public class Secteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secteur", nullable = false)
    private Integer idSecteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_sec", nullable = false, length = 30)
    private String nomSec;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSecteur")
    private Collection<Cooperative> cooperativeCollection;

    public Secteur() {
    }

    public Secteur(Integer idSecteur) {
        this.idSecteur = idSecteur;
    }

    public Secteur(Integer idSecteur, String nomSec) {
        this.idSecteur = idSecteur;
        this.nomSec = nomSec;
    }

    public Integer getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Integer idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getNomSec() {
        return nomSec;
    }

    public void setNomSec(String nomSec) {
        this.nomSec = nomSec;
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
        hash += (idSecteur != null ? idSecteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secteur)) {
            return false;
        }
        Secteur other = (Secteur) object;
        if ((this.idSecteur == null && other.idSecteur != null) || (this.idSecteur != null && !this.idSecteur.equals(other.idSecteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.entities.Secteur[ idSecteur=" + idSecteur + " ]";
    }
    
}