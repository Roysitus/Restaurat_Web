package controlador;

import EJB.MesaFacadeLocal;
import entidad.Mesa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedMesa {

    @EJB
    MesaFacadeLocal mesaFacadeLocal;
    private List<Mesa> listaMesa;
    private Mesa mesa;

    public List<Mesa> getListaMesa() {
        listaMesa=mesaFacadeLocal.findAll();
        return listaMesa;
    }

    public void setListaMesa(List<Mesa> listaMesa) {
        this.listaMesa = listaMesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @PostConstruct
    public void init() {
        this.mesa = new Mesa();
    }

    public void insertarMesa() {
        String tm = String.valueOf(mesa.getTipoMesa().charAt(0));
        int r1 = (int) (Math.random() * (5000 - 1) + 1);
        String codigo = "M" + tm + r1;
        this.mesa.setCodigoMesa(codigo);
        mesaFacadeLocal.create(mesa);
        init();
    }

    public void eliminarMesa(Mesa m) {
        mesaFacadeLocal.remove(m);
    }

    public void cargarMesa(Mesa m){
        this.mesa = m;
    }

    public void modificarMesa() {
        mesaFacadeLocal.edit(mesa);
        init();
    }
}
