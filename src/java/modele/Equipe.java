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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdEquipe", query = "SELECT e FROM Equipe e WHERE e.idEquipe = :idEquipe"),
    @NamedQuery(name = "Equipe.findByTitre", query = "SELECT e FROM Equipe e WHERE e.titre = :titre"),
    @NamedQuery(name = "Equipe.findByCommentaire", query = "SELECT e FROM Equipe e WHERE e.commentaire = :commentaire"),
    @NamedQuery(name = "Equipe.findByDateCreation", query = "SELECT e FROM Equipe e WHERE e.dateCreation = :dateCreation")})
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EQUIPE")
    private Integer idEquipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "TITRE")
    private String titre;
    @Size(max = 128)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @ManyToMany(mappedBy = "equipeCollection")
    private Collection<Etudiant> etudiantCollection;
    @JoinColumn(name = "ID_CREATEUR", referencedColumnName = "ID_PERSONNE")
    @ManyToOne(optional = false)
    private Etudiant idCreateur;
    @JoinColumn(name = "ID_PROJET", referencedColumnName = "ID_PROJET")
    @ManyToOne(optional = false)
    private Projet idProjet;

    public Equipe() {
    }

    public Equipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Equipe(Integer idEquipe, String titre, Date dateCreation) {
        this.idEquipe = idEquipe;
        this.titre = titre;
        this.dateCreation = dateCreation;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @XmlTransient
    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }

    public Etudiant getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(Etudiant idCreateur) {
        this.idCreateur = idCreateur;
    }

    public Projet getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Projet idProjet) {
        this.idProjet = idProjet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipe != null ? idEquipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.idEquipe == null && other.idEquipe != null) || (this.idEquipe != null && !this.idEquipe.equals(other.idEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Equipe[ idEquipe=" + idEquipe + " ]";
    }
    
}
