/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author usuario
 */
@Entity
@Table(name = "mesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m")
    , @NamedQuery(name = "Mesa.findByCodigoMesa", query = "SELECT m FROM Mesa m WHERE m.codigoMesa = :codigoMesa")
    , @NamedQuery(name = "Mesa.findByTipoMesa", query = "SELECT m FROM Mesa m WHERE m.tipoMesa = :tipoMesa")
    , @NamedQuery(name = "Mesa.findByEstadoMesa", query = "SELECT m FROM Mesa m WHERE m.estadoMesa = :estadoMesa")
    , @NamedQuery(name = "Mesa.findByCantidadMesa", query = "SELECT m FROM Mesa m WHERE m.cantidadMesa = :cantidadMesa")})
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigoMesa")
    private String codigoMesa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipoMesa")
    private String tipoMesa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estadoMesa")
    private String estadoMesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadMesa")
    private int cantidadMesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMesa")
    private Collection<Reserva> reservaCollection;

    public Mesa() {
    }

    public Mesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public Mesa(String codigoMesa, String tipoMesa, String estadoMesa, int cantidadMesa) {
        this.codigoMesa = codigoMesa;
        this.tipoMesa = tipoMesa;
        this.estadoMesa = estadoMesa;
        this.cantidadMesa = cantidadMesa;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCantidadMesa() {
        return cantidadMesa;
    }

    public void setCantidadMesa(int cantidadMesa) {
        this.cantidadMesa = cantidadMesa;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMesa != null ? codigoMesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.codigoMesa == null && other.codigoMesa != null) || (this.codigoMesa != null && !this.codigoMesa.equals(other.codigoMesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Mesa[ codigoMesa=" + codigoMesa + " ]";
    }
    
}
