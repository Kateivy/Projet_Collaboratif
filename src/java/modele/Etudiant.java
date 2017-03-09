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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CHAFFORT
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByIdPersonne", query = "SELECT e FROM Etudiant e WHERE e.idPersonne = :idPersonne")})
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONNE")
    private Integer idPersonne;
    @ManyToMany(mappedBy = "etudiantCollection")
    private Collection<Session> sessionCollection;
    @JoinTable(name = "participant", joinColumns = {
        @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_EQUIPE", referencedColumnName = "ID_EQUIPE")})
    @ManyToMany
    private Collection<Equipe> equipeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreateur")
    private Collection<Equipe> equipeCollection1;
    @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public Etudiant() {
    }

    public Etudiant(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Collection<Session> getSessionCollection() {
        return sessionCollection;
    }

    public void setSessionCollection(Collection<Session> sessionCollection) {
        this.sessionCollection = sessionCollection;
    }

    public Collection<Equipe> getEquipeCollection() {
        return equipeCollection;
    }

    public void setEquipeCollection(Collection<Equipe> equipeCollection) {
        this.equipeCollection = equipeCollection;
    }

    public Collection<Equipe> getEquipeCollection1() {
        return equipeCollection1;
    }

    public void setEquipeCollection1(Collection<Equipe> equipeCollection1) {
        this.equipeCollection1 = equipeCollection1;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Etudiant[ idPersonne=" + idPersonne + " ]";
    }
    
}
