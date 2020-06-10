package com.staxrt.odco.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "cooperative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cooperative.findAll", query = "SELECT c FROM Cooperative c"),
    @NamedQuery(name = "Cooperative.findByIdCoop", query = "SELECT c FROM Cooperative c WHERE c.idCoop = :idCoop"),
    @NamedQuery(name = "Cooperative.findByNomCoop", query = "SELECT c FROM Cooperative c WHERE c.nomCoop = :nomCoop"),
    @NamedQuery(name = "Cooperative.findByImage", query = "SELECT c FROM Cooperative c WHERE c.image = :image"),
    @NamedQuery(name = "Cooperative.findByNomResponsable", query = "SELECT c FROM Cooperative c WHERE c.nomResponsable = :nomResponsable"),
    @NamedQuery(name = "Cooperative.findByAdresse", query = "SELECT c FROM Cooperative c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Cooperative.findByDateCreation", query = "SELECT c FROM Cooperative c WHERE c.dateCreation = :dateCreation"),
    @NamedQuery(name = "Cooperative.findByFax", query = "SELECT c FROM Cooperative c WHERE c.fax = :fax"),
    @NamedQuery(name = "Cooperative.findByTelephone", query = "SELECT c FROM Cooperative c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Cooperative.findByEmployeeFemmes", query = "SELECT c FROM Cooperative c WHERE c.employeeFemmes = :employeeFemmes"),
    @NamedQuery(name = "Cooperative.findByEmployeeHommes", query = "SELECT c FROM Cooperative c WHERE c.employeeHommes = :employeeHommes")})
public class Cooperative implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_coop", nullable = true)
    private Integer idCoop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_coop", nullable = false, length = 50)
    private String nomCoop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "image", nullable = false, length = 100)
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_responsable", nullable = false, length = 30)
    private String nomResponsable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse", nullable = false, length = 100)
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation", nullable = false)
    private String dateCreation;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fax", nullable = false, length = 10)
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telephone", nullable = false, length = 10)
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_femmes", nullable = false)
    private int employeeFemmes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_hommes", nullable = false)
    private int employeeHommes;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCooperative")
    private Collection<Chiffreaffaire> chiffreaffaireCollection;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoop")
    private Collection<Adherant> adherantCollection;
    
    @JsonBackReference
    @JoinColumn(name = "id_province", referencedColumnName = "id_province", nullable = false)
    @ManyToOne(optional = false)
    private Province idProvince;
    
    @JsonBackReference
    @JoinColumn(name = "id_region", referencedColumnName = "id_region", nullable = false)
    @ManyToOne(optional = false)
    private Region idRegion;
    
    @JsonBackReference
    @JoinColumn(name = "id_secteur", referencedColumnName = "id_secteur", nullable = false)
    @ManyToOne(optional = false)
    private Secteur idSecteur;

    public Cooperative() {
    }

    public Cooperative(Integer idCoop) {
        this.idCoop = idCoop;
    }

    public Cooperative(Integer idCoop, String nomCoop, String image, String nomResponsable, String adresse, String dateCreation, String fax, String telephone, String description, int employeeFemmes, int employeeHommes) {
        this.idCoop = idCoop;
        this.nomCoop = nomCoop;
        this.image = image;
        this.nomResponsable = nomResponsable;
        this.adresse = adresse;
        this.dateCreation = dateCreation;
        this.fax = fax;
        this.telephone = telephone;
        this.description = description;
        this.employeeFemmes = employeeFemmes;
        this.employeeHommes = employeeHommes;
    }

    public Integer getIdCoop() {
        return idCoop;
    }

    public void setIdCoop(Integer idCoop) {
        this.idCoop = idCoop;
    }

    public String getNomCoop() {
        return nomCoop;
    }

    public void setNomCoop(String nomCoop) {
        this.nomCoop = nomCoop;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeFemmes() {
        return employeeFemmes;
    }

    public void setEmployeeFemmes(int employeeFemmes) {
        this.employeeFemmes = employeeFemmes;
    }

    public int getEmployeeHommes() {
        return employeeHommes;
    }

    public void setEmployeeHommes(int employeeHommes) {
        this.employeeHommes = employeeHommes;
    }

    @XmlTransient
    public Collection<Chiffreaffaire> getChiffreaffaireCollection() {
        return chiffreaffaireCollection;
    }

    public void setChiffreaffaireCollection(Collection<Chiffreaffaire> chiffreaffaireCollection) {
        this.chiffreaffaireCollection = chiffreaffaireCollection;
    }

    @XmlTransient
    public Collection<Adherant> getAdherantCollection() {
        return adherantCollection;
    }

    public void setAdherantCollection(Collection<Adherant> adherantCollection) {
        this.adherantCollection = adherantCollection;
    }

    public Province getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Province idProvince) {
        this.idProvince = idProvince;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
    }

    public Secteur getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Secteur idSecteur) {
        this.idSecteur = idSecteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoop != null ? idCoop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cooperative)) {
            return false;
        }
        Cooperative other = (Cooperative) object;
        if ((this.idCoop == null && other.idCoop != null) || (this.idCoop != null && !this.idCoop.equals(other.idCoop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.entities.Cooperative[ idCoop=" + idCoop + " ]";
    }
    
}