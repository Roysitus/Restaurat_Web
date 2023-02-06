/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
    , @NamedQuery(name = "Plato.findByCodigoPlato", query = "SELECT p FROM Plato p WHERE p.codigoPlato = :codigoPlato")
    , @NamedQuery(name = "Plato.findByNombrePlato", query = "SELECT p FROM Plato p WHERE p.nombrePlato = :nombrePlato")
    , @NamedQuery(name = "Plato.findByOrigen", query = "SELECT p FROM Plato p WHERE p.origen = :origen")
    , @NamedQuery(name = "Plato.findByFoto", query = "SELECT p FROM Plato p WHERE p.foto = :foto")
    , @NamedQuery(name = "Plato.findByPrecio", query = "SELECT p FROM Plato p WHERE p.precio = :precio")
    , @NamedQuery(name = "Plato.findByCantidadPlato", query = "SELECT p FROM Plato p WHERE p.cantidadPlato = :cantidadPlato")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigoPlato")
    private String codigoPlato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombrePlato")
    private String nombrePlato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "foto")
    private String foto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadPlato")
    private int cantidadPlato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPlato")
    private Collection<Detalle> detalleCollection;

    public Plato() {
    }

    public Plato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public Plato(String codigoPlato, String nombrePlato, String origen, String foto, int cantidadPlato) {
        this.codigoPlato = codigoPlato;
        this.nombrePlato = nombrePlato;
        this.origen = origen;
        this.foto = foto;
        this.cantidadPlato = cantidadPlato;
    }

    public String getCodigoPlato() {
        return codigoPlato;
    }

    public void setCodigoPlato(String codigoPlato) {
        this.codigoPlato = codigoPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
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
        hash += (codigoPlato != null ? codigoPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.codigoPlato == null && other.codigoPlato != null) || (this.codigoPlato != null && !this.codigoPlato.equals(other.codigoPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Plato[ codigoPlato=" + codigoPlato + " ]";
    }
    
}
