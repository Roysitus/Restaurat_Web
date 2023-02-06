package controlador;

import EJB.DetalleFacadeLocal;
import EJB.ReservaFacadeLocal;
import entidad.Detalle;
import entidad.Plato;
import entidad.Reserva;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.MySQLConexion;

@SessionScoped
@ManagedBean
public class ManagedDetalle {

    @EJB
    DetalleFacadeLocal detalleFacadeLocal;
    private List<Detalle> listaDetalle;
    private List<Detalle> listaDetalleTotal;
    private Detalle detalle;
    private Plato plato;
    private Reserva reserva;

    public List<Detalle> getListaDetalle() {
        listaDetUsuario();
        return listaDetalle;
    }

    public List<Detalle> getListaDetalleTotal() {
        listaDetalleTotal = detalleFacadeLocal.findAll();
        return listaDetalleTotal;
    }

    public void setListaDetalleTotal(List<Detalle> listaDetalleTotal) {
        this.listaDetalleTotal = listaDetalleTotal;
    }

    public void setListaDetalle(List<Detalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @PostConstruct

    public void init() {
        this.detalle = new Detalle();
        this.plato = new Plato();
        this.reserva = new Reserva();
    }

    public void insertarDetalle() {
        detalle.setCodigoPlato(plato);
        detalle.setCodigoReserva(reserva);
        detalle.setTotal(calculartotal());
        String n1 = String.valueOf(plato.getCodigoPlato().charAt(0));
        String n2 = String.valueOf(reserva.getCodigoReserva().charAt(0));
        int r1 = (int) (Math.random() * (5000 - 1) + 1);
        String cod = "D" + n1 + n2 + r1;
        detalle.setCodigoDetalle(cod);
        detalleFacadeLocal.create(detalle);
    }

    public BigDecimal calculartotal() {
        Connection cn = MySQLConexion.getConexion();
        BigDecimal PrecioTotal;
        Double precio;
        Plato p = null;
        try {
            String sql = "select precio from plato where codigoPlato=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, plato.getCodigoPlato());
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                p = new Plato();
                p.setPrecio(rs.getBigDecimal(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        precio = p.getPrecio().doubleValue() * detalle.getCantidad();
        PrecioTotal = BigDecimal.valueOf(precio);
        return PrecioTotal;
    }

    public void eliminarDetalle(Detalle d) {
        detalleFacadeLocal.remove(d);
        /* detalle = new Detalle();
        plato = new Plato();*/
    }

    public void cargarDetalle(Detalle d) {
        this.detalle = d;
    }

    public void modificarDetalle() {
        detalle.setCodigoPlato(plato);
        detalle.setTotal(calculartotal());
        detalleFacadeLocal.edit(detalle);
        getListaDetalle();
        /* detalle = new Detalle();
        plato = new Plato();*/
    }

    public void listaDetUsuario() {
        listaDetalle = new ArrayList<>();
        for (Detalle x : detalleFacadeLocal.findAll()) {
            if (x.getCodigoReserva().getCodigoReserva().equals(reserva.getCodigoReserva())) {
                listaDetalle.add(x);
            }
            detalle = new Detalle();
            plato = new Plato();
        }
    }

    public double Monto() {
        double monto = 0;
        for(Detalle x:detalleFacadeLocal.findAll()){
        if (x.getCodigoReserva().getCodigoReserva().equals(reserva.getCodigoReserva())) {
                monto+=x.getTotal().doubleValue();
            }
        }
        return monto;
    }
}
