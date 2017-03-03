/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CHAFFORT
 */
@Entity
@Table(name = "session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findByIdSession", query = "SELECT s FROM Session s WHERE s.idSession = :idSession"),
    @NamedQuery(name = "Session.findByTitre", query = "SELECT s FROM Session s WHERE s.titre = :titre"),
    @NamedQuery(name = "Session.findByDescription", query = "SELECT s FROM Session s WHERE s.description = :description")})
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SESSION")
    private Integer idSession;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "TITRE")
    private String titre;
    @Size(max = 128)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinTable(name = "etudiant_promotion", joinColumns = {
        @JoinColumn(name = "ID_SESSION", referencedColumnName = "ID_SESSION")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE")})
    @ManyToMany
    private Collection<Etudiant> etudiantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<Projet> projetCollection;

    public Session() {
    }

    public Session(Integer idSession) {
        this.idSession = idSession;
    }

    public Session(Integer idSession, String titre) {
        this.idSession = idSession;
        this.titre = titre;
    }

    public Integer getIdSession() {
        return idSession;
    }

    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }

    @XmlTransient
    public Collection<Projet> getProjetCollection() {
        return projetCollection;
    }

    public void setProjetCollection(Collection<Projet> projetCollection) {
        this.projetCollection = projetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSession != null ? idSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.idSession == null && other.idSession != null) || (this.idSession != null && !this.idSession.equals(other.idSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Session[ idSession=" + idSession + " ]";
    }
    
}
