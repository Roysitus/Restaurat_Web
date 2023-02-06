package controlador;

import EJB.DetalleFacadeLocal;
import EJB.ReservaFacadeLocal;
import entidad.Detalle;
import entidad.Mesa;
import entidad.Plato;
import entidad.Reserva;
import entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.MySQLConexion;

@ManagedBean
@SessionScoped
public class ManagedReserva {

    @EJB
    ReservaFacadeLocal reservaFacadeLocal;
    DetalleFacadeLocal detalleFacadeLocal;
    private List<Reserva> listaReserva;
    private List<Reserva> listaReservaCliente;
    private Reserva reserva;
    private Usuario usuario;
    private Detalle detalle;
    private Mesa mesa;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date fechadate;

    public List<Reserva> getListaReserva() {
        listaReserva = reservaFacadeLocal.findAll();
        return listaReserva;
    }
    
    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
    public List<Reserva> getListaReservaCliente() {
        BuscarReserva();
        return listaReservaCliente;
    }

    public void setListaReservaCliente(List<Reserva> listaReservaCliente) {
        this.listaReservaCliente = listaReservaCliente;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public Date getFechadate() {
        return fechadate;
    }

    public void setFechadate(Date fechadate) {
        this.fechadate = fechadate;
    }
      public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    @PostConstruct

    public void init() {
        this.reserva = new Reserva();
        this.usuario = new Usuario();
        this.mesa = new Mesa();
        this.fechadate = new Date();
    }

    public void insertarReserva() {
        reserva.setCodigoUsuario(usuario);
        reserva.setCodigoMesa(mesa);
        reserva.setFecha(fecha());
        String n1 = String.valueOf(usuario.getCodigoUsuario().charAt(0));
        String n2 = String.valueOf(mesa.getCodigoMesa().charAt(0));
        int r1 = (int) (Math.random() * (5000 - 1) + 1);
        String cod = "R" + n1 + n2 + r1;
        reserva.setCodigoReserva(cod);
        reservaFacadeLocal.create(reserva);
    }

    public void eliminarReserva(Reserva r) {
        this.reserva = r;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql="DELETE FROM detalle WHERE codigoReserva=?";
            PreparedStatement pr = cn.prepareStatement(sql);
            pr.setString(1, r.getCodigoReserva());
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        reservaFacadeLocal.remove(reserva);
        init();
    }

    public void cargarReserva(Reserva r) {
        this.reserva = r;
    }

    public void modificarReserva() {
        reserva.setCodigoMesa(mesa);
        reserva.setFecha(fecha());
        reservaFacadeLocal.edit(reserva);
    }

    public String fecha() {
        String fecha = sdf.format(fechadate);
        return fecha;
    }
    
    public void BuscarReserva(){
    listaReservaCliente = new ArrayList<>();
        for (Reserva x : reservaFacadeLocal.findAll()) {
            listaReservaCliente = new ArrayList<>();
            if (x.getCodigoReserva().equals(reserva.getCodigoReserva())) {
                listaReservaCliente.add(x);
            }
        }
    }

}
