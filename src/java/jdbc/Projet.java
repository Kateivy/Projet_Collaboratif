/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import modele.*;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Projet implements Serializable {
    private Integer idProjet;
    private String titre;
    private String sujet;
    private Date dateCreation;
    private Date dateLimiteRendu;
    private int idCreateur;
    private int idSession;

    public Projet(Integer idProjet, String titre, String sujet, Date dateCreation, Date dateLimiteRendu, int idCreateur, int idSession) {
        this.idProjet = idProjet;
        this.titre = titre;
        this.sujet = sujet;
        this.dateCreation = dateCreation;
        this.dateLimiteRendu = dateLimiteRendu;
        this.idCreateur = idCreateur;
        this.idSession = idSession;
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

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    
    public void persist() {
         
   }
 }
