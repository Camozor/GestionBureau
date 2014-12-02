/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGestion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 11316834
 */
@Entity
@Table(name = "RESPONSABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r"),
    @NamedQuery(name = "Responsable.findByPersonneId", query = "SELECT r FROM Responsable r WHERE r.personneId = :personneId"),
    @NamedQuery(name = "Responsable.findByIdentifiant", query = "SELECT r FROM Responsable r WHERE r.identifiant = :identifiant"),
    @NamedQuery(name = "Responsable.findByMotDePasse", query = "SELECT r FROM Responsable r WHERE r.motDePasse = :motDePasse")})
public class Responsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONNE_ID")
    private Integer personneId;
    @Size(max = 30)
    @Column(name = "IDENTIFIANT")
    private String identifiant;
    @Size(max = 30)
    @Column(name = "MOT_DE_PASSE")
    private String motDePasse;
    @JoinColumn(name = "PERSONNE_ID", referencedColumnName = "PERSONNE_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public Responsable() {
    }

    public Responsable(Integer personneId) {
        this.personneId = personneId;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
        hash += (personneId != null ? personneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.personneId == null && other.personneId != null) || (this.personneId != null && !this.personneId.equals(other.personneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntitesGestionBureau.Responsable[ personneId=" + personneId + " ]";
    }
    
}
