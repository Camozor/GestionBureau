/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGestion;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "PERSONNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByPersonneId", query = "SELECT p FROM Personne p WHERE p.personneId = :personneId"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personne.findByMail", query = "SELECT p FROM Personne p WHERE p.mail = :mail"),
    @NamedQuery(name = "Personne.findByEquipe", query = "SELECT p FROM Personne p WHERE p.equipe = :equipe"),
    @NamedQuery(name = "Personne.findByDateDebut", query = "SELECT p FROM Personne p WHERE p.dateDebut = :dateDebut"),
    @NamedQuery(name = "Personne.findByDateFin", query = "SELECT p FROM Personne p WHERE p.dateFin = :dateFin")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONNE_ID")
    private Integer personneId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EQUIPE")
    private String equipe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "BUREAU_ID", referencedColumnName = "BUREAU_ID")
    @ManyToOne
    private Bureau bureauId;

    public Personne() {
    }

    public Personne(Integer personneId) {
        this.personneId = personneId;
    }

    public Personne(Integer personneId, String nom, String prenom, String mail, String equipe, Date dateDebut) {
        this.personneId = personneId;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.equipe = equipe;
        this.dateDebut = dateDebut;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Bureau getBureauId() {
        return bureauId;
    }

    public void setBureauId(Bureau bureauId) {
        this.bureauId = bureauId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personneId != null ? personneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.personneId == null && other.personneId != null) || (this.personneId != null && !this.personneId.equals(other.personneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityGestion.Personne[ personneId=" + personneId + " ]";
    }
    
}
