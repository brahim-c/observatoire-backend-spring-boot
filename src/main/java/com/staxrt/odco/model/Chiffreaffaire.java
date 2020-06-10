
package com.staxrt.odco.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "chiffreaffaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chiffreaffaire.findAll", query = "SELECT c FROM Chiffreaffaire c"),
    @NamedQuery(name = "Chiffreaffaire.findByIdchiffreAffaire", query = "SELECT c FROM Chiffreaffaire c WHERE c.idchiffreAffaire = :idchiffreAffaire"),
    @NamedQuery(name = "Chiffreaffaire.findByValeur", query = "SELECT c FROM Chiffreaffaire c WHERE c.valeur = :valeur"),
    @NamedQuery(name = "Chiffreaffaire.findByDate", query = "SELECT c FROM Chiffreaffaire c WHERE c.date = :date")})
public class Chiffreaffaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chiffreAffaire", nullable = false)
    private Integer idchiffreAffaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur", nullable = false)
    private double valeur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @JsonBackReference
    @JoinColumn(name = "id_cooperative", referencedColumnName = "id_coop", nullable = false)
    @ManyToOne(optional = false)
    private Cooperative idCooperative;

    public Chiffreaffaire() {
    }

    public Chiffreaffaire(Integer idchiffreAffaire) {
        this.idchiffreAffaire = idchiffreAffaire;
    }

    public Chiffreaffaire(Integer idchiffreAffaire, double valeur, Date date) {
        this.idchiffreAffaire = idchiffreAffaire;
        this.valeur = valeur;
        this.date = date;
    }

    public Integer getIdchiffreAffaire() {
        return idchiffreAffaire;
    }

    public void setIdchiffreAffaire(Integer idchiffreAffaire) {
        this.idchiffreAffaire = idchiffreAffaire;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cooperative getIdCooperative() {
        return idCooperative;
    }

    public void setIdCooperative(Cooperative idCooperative) {
        this.idCooperative = idCooperative;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchiffreAffaire != null ? idchiffreAffaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chiffreaffaire)) {
            return false;
        }
        Chiffreaffaire other = (Chiffreaffaire) object;
        if ((this.idchiffreAffaire == null && other.idchiffreAffaire != null) || (this.idchiffreAffaire != null && !this.idchiffreAffaire.equals(other.idchiffreAffaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.entities.Chiffreaffaire[ idchiffreAffaire=" + idchiffreAffaire + " ]";
    }
    
}