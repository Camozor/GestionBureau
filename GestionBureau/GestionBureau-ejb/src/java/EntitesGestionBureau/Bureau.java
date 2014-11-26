/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitesGestionBureau;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 11316834
 */
@Entity
@Table(name = "BUREAU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bureau.findAll", query = "SELECT b FROM Bureau b"),
    @NamedQuery(name = "Bureau.findByBureauId", query = "SELECT b FROM Bureau b WHERE b.bureauId = :bureauId"),
    @NamedQuery(name = "Bureau.findByBatiment", query = "SELECT b FROM Bureau b WHERE b.batiment = :batiment"),
    @NamedQuery(name = "Bureau.findByNumero", query = "SELECT b FROM Bureau b WHERE b.numero = :numero"),
    @NamedQuery(name = "Bureau.findByEtage", query = "SELECT b FROM Bureau b WHERE b.etage = :etage"),
    @NamedQuery(name = "Bureau.findByNbMaxPersonne", query = "SELECT b FROM Bureau b WHERE b.nbMaxPersonne = :nbMaxPersonne")})
public class Bureau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUREAU_ID")
    private Integer bureauId;
    @Size(max = 1)
    @Column(name = "BATIMENT")
    private String batiment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ETAGE")
    private String etage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NB_MAX_PERSONNE")
    private int nbMaxPersonne;

    public Bureau() {
    }

    public Bureau(Integer bureauId) {
        this.bureauId = bureauId;
    }

    public Bureau(Integer bureauId, String numero, String etage, int nbMaxPersonne) {
        this.bureauId = bureauId;
        this.numero = numero;
        this.etage = etage;
        this.nbMaxPersonne = nbMaxPersonne;
    }

    public Integer getBureauId() {
        return bureauId;
    }

    public void setBureauId(Integer bureauId) {
        this.bureauId = bureauId;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public int getNbMaxPersonne() {
        return nbMaxPersonne;
    }

    public void setNbMaxPersonne(int nbMaxPersonne) {
        this.nbMaxPersonne = nbMaxPersonne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bureauId != null ? bureauId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bureau)) {
            return false;
        }
        Bureau other = (Bureau) object;
        if ((this.bureauId == null && other.bureauId != null) || (this.bureauId != null && !this.bureauId.equals(other.bureauId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntitesGestionBureau.Bureau[ bureauId=" + bureauId + " ]";
    }
    
}
