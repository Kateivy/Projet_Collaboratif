/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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

/**
 *
 * @author CHAFFORT
 */
@Entity
@Table(name = "projet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p"),
    @NamedQuery(name = "Projet.findByIdProjet", query = "SELECT p FROM Projet p WHERE p.idProjet = :idProjet"),
    @NamedQuery(name = "Projet.findByTitre", query = "SELECT p FROM Projet p WHERE p.titre = :titre"),
    @NamedQuery(name = "Projet.findBySujet", query = "SELECT p FROM Projet p WHERE p.sujet = :sujet"),
    @NamedQuery(name = "Projet.findByDateCreation", query = "SELECT p FROM Projet p WHERE p.dateCreation = :dateCreation"),
    @NamedQuery(name = "Projet.findByDateLimiteRendu", query = "SELECT p FROM Projet p WHERE p.dateLimiteRendu = :dateLimiteRendu")})
public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROJET")
    private Integer idProjet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "SUJET")
    private String sujet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_LIMITE_RENDU")
    @Temporal(TemporalType.DATE)
    private Date dateLimiteRendu;
    @JoinColumn(name = "ID_CREATEUR", referencedColumnName = "ID_PERSONNE")
    @ManyToOne(optional = false)
    private Formateur idCreateur;
    @JoinColumn(name = "ID_SESSION", referencedColumnName = "ID_SESSION")
    @ManyToOne(optional = false)
    private Session idSession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjet")
    private Collection<Equipe> equipeCollection;

    public Projet() {
    }

    public Projet(Integer idProjet) {
        this.idProjet = idProjet;
    }

    public Projet(String titre, String sujet, Date dateCreation, Date dateLimiteRendu) {
        
        this.titre = titre;
        this.sujet = sujet;
        this.dateCreation = dateCreation;
        this.dateLimiteRendu = dateLimiteRendu;
    }

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateLimiteRendu() {
        return dateLimiteRendu;
    }

    public void setDateLimiteRendu(Date dateLimiteRendu) {
        this.dateLimiteRendu = dateLimiteRendu;
    }

    public Formateur getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(Formateur idCreateur) {
        this.idCreateur = idCreateur;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
    }

    @XmlTransient
    public Collection<Equipe> getEquipeCollection() {
        return equipeCollection;
    }

    public void setEquipeCollection(Collection<Equipe> equipeCollection) {
        this.equipeCollection = equipeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProjet != null ? idProjet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.idProjet == null && other.idProjet != null) || (this.idProjet != null && !this.idProjet.equals(other.idProjet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Projet[ idProjet=" + idProjet + " ]";
    }
    
}
