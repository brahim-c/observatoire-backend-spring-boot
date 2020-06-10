package com.staxrt.odco.model;



import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "province")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByIdProvince", query = "SELECT p FROM Province p WHERE p.idProvince = :idProvince"),
    @NamedQuery(name = "Province.findByNomProvince", query = "SELECT p FROM Province p WHERE p.nomProvince = :nomProvince")})
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_province", nullable = false)
    private Integer idProvince;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_province", nullable = false, length = 50)
    private String nomProvince;
    @JoinColumn(name = "id_regn", referencedColumnName = "id_region", nullable = false)
    @ManyToOne(optional = false)
    private Region idRegn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProvince")
    private Collection<Cooperative> cooperativeCollection;

    public Province() {
    }

    public Province(Integer idProvince) {
        this.idProvince = idProvince;
    }

    public Province(Integer idProvince, String nomProvince) {
        this.idProvince = idProvince;
        this.nomProvince = nomProvince;
    }

    public Integer getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Integer idProvince) {
        this.idProvince = idProvince;
    }

    public String getNomProvince() {
        return nomProvince;
    }

    public void setNomProvince(String nomProvince) {
        this.nomProvince = nomProvince;
    }

    public Region getIdRegn() {
        return idRegn;
    }

    public void setIdRegn(Region idRegn) {
        this.idRegn = idRegn;
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
        hash += (idProvince != null ? idProvince.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.idProvince == null && other.idProvince != null) || (this.idProvince != null && !this.idProvince.equals(other.idProvince))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.entities.Province[ idProvince=" + idProvince + " ]";
    }
    
}