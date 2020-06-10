package com.staxrt.odco.model;



import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "adherant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adherant.findAll", query = "SELECT a FROM Adherant a"),
    @NamedQuery(name = "Adherant.findById", query = "SELECT a FROM Adherant a WHERE a.id = :id"),
    @NamedQuery(name = "Adherant.findByNombreAd", query = "SELECT a FROM Adherant a WHERE a.nombreAd = :nombreAd"),
    @NamedQuery(name = "Adherant.findByDate", query = "SELECT a FROM Adherant a WHERE a.date = :date")})
public class Adherant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre_ad", nullable = false)
    private int nombreAd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @JsonBackReference
    @JoinColumn(name = "id_coop", referencedColumnName = "id_coop", nullable = false)
    @ManyToOne(optional = false)
    private Cooperative idCoop;

    public Adherant() {
    }

    public Adherant(Integer id) {
        this.id = id;
    }

    public Adherant(Integer id, int nombreAd, Date date) {
        this.id = id;
        this.nombreAd = nombreAd;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNombreAd() {
        return nombreAd;
    }

    public void setNombreAd(int nombreAd) {
        this.nombreAd = nombreAd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cooperative getIdCoop() {
        return idCoop;
    }

    public void setIdCoop(Cooperative idCoop) {
        this.idCoop = idCoop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adherant)) {
            return false;
        }
        Adherant other = (Adherant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.entities.Adherant[ id=" + id + " ]";
    }
    
}