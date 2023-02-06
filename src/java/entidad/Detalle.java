/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByCodigoDetalle", query = "SELECT d FROM Detalle d WHERE d.codigoDetalle = :codigoDetalle")
    , @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalle.findByTotal", query = "SELECT d FROM Detalle d WHERE d.total = :total")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigoDetalle")
    private String codigoDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "codigoPlato", referencedColumnName = "codigoPlato")
    @ManyToOne(optional = false)
    private Plato codigoPlato;
    @JoinColumn(name = "codigoReserva", referencedColumnName = "codigoReserva")
    @ManyToOne(optional = false)
    private Reserva codigoReserva;

    public Detalle() {
    }

    public Detalle(String codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public Detalle(String codigoDetalle, int cantidad) {
        this.codigoDetalle = codigoDetalle;
        this.cantidad = cantidad;
    }

    public String getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(String codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Plato getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(Plato codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public Reserva getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Reserva codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDetalle != null ? codigoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.codigoDetalle == null && other.codigoDetalle != null) || (this.codigoDetalle != null && !this.codigoDetalle.equals(other.codigoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Detalle[ codigoDetalle=" + codigoDetalle + " ]";
    }
    
}
