package controlador;

import EJB.UsuarioFacadeLocal;
import entidad.Detalle;
import entidad.Mesa;
import entidad.Plato;
import entidad.Reserva;
import entidad.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedUsuario {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private Reserva reserva;
    private Mesa mesa;
    private Plato plato;
    private Detalle detalle;
    Date t;
    SimpleDateFormat sdf = new SimpleDateFormat("yyM");

    public List<Usuario> getListaUsuario() {
        listaUsuario = usuarioFacadeLocal.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.reserva = new Reserva();
        this.detalle = new Detalle();
        this.mesa = new Mesa();
        this.plato = new Plato();
    }

    public void insertarUsuario() {
        t = new Date();
        String fecha = sdf.format(t);
        int r1 = (int) (Math.random() * (5000 - 1) + 1);
        String n = String.valueOf(usuario.getNombreUsuario().toUpperCase().charAt(0));
        String a = String.valueOf(usuario.getApellidoUsuario().toUpperCase().charAt(0));
        String codigo = "U" + n + a + fecha + r1;
        usuario.setCodigoUsuario(codigo);
        usuarioFacadeLocal.create(usuario);
        init();
    }

    public void eliminarUsuario(Usuario u) {
        usuarioFacadeLocal.remove(u);
        init();
    }

    public void cargarDatos(Usuario u) {
        this.usuario = u;
    }

    public void modificarUsuario() {
        usuarioFacadeLocal.edit(usuario);
        init();
    }

    public void buscarUsuario() {
        listaUsuario = usuarioFacadeLocal.findAll();
        for (Usuario x : listaUsuario) {
            if (x.getCorreo().equals(usuario.getCorreo()) && x.getContraseña().equals(usuario.getContraseña())) {
                this.usuario = x;
            }
        }
    }
}
