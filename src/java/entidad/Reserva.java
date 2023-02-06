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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByCodigoReserva", query = "SELECT r FROM Reserva r WHERE r.codigoReserva = :codigoReserva")
    , @NamedQuery(name = "Reserva.findByCantidadPersona", query = "SELECT r FROM Reserva r WHERE r.cantidadPersona = :cantidadPersona")
    , @NamedQuery(name = "Reserva.findByFecha", query = "SELECT r FROM Reserva r WHERE r.fecha = :fecha")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigoReserva")
    private String codigoReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadPersona")
    private int cantidadPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fecha")
    private String fecha;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private Usuario codigoUsuario;
    @JoinColumn(name = "codigoMesa", referencedColumnName = "codigoMesa")
    @ManyToOne(optional = false)
    private Mesa codigoMesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoReserva")
    private Collection<Detalle> detalleCollection;

    public Reserva() {
    }

    public Reserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Reserva(String codigoReserva, int cantidadPersona, String fecha) {
        this.codigoReserva = codigoReserva;
        this.cantidadPersona = cantidadPersona;
        this.fecha = fecha;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public int getCantidadPersona() {
        return cantidadPersona;
    }

    public void setCantidadPersona(int cantidadPersona) {
        this.cantidadPersona = cantidadPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Mesa getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(Mesa codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoReserva != null ? codigoReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codigoReserva == null && other.codigoReserva != null) || (this.codigoReserva != null && !this.codigoReserva.equals(other.codigoReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Reserva[ codigoReserva=" + codigoReserva + " ]";
    }
    
}
