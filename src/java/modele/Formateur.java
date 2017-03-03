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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CHAFFORT
 */
@Entity
@Table(name = "formateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formateur.findAll", query = "SELECT f FROM Formateur f"),
    @NamedQuery(name = "Formateur.findByIdPersonne", query = "SELECT f FROM Formateur f WHERE f.idPersonne = :idPersonne")})
public class Formateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONNE")
    private Integer idPersonne;
    @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreateur")
    private Collection<Projet> projetCollection;

    public Formateur() {
    }

    public Formateur(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
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
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formateur)) {
            return false;
        }
        Formateur other = (Formateur) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Formateur[ idPersonne=" + idPersonne + " ]";
    }
    
}
