package controlador;

import EJB.PlatoFacadeLocal;
import entidad.Plato;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class ManagedPlato {

    @EJB
    PlatoFacadeLocal platoFacadeLocal;
    private List<Plato> listaPlato;
    private Plato plato;
    String ruta = "C:\\Users\\usuario\\Desktop\\Programacion\\NetBeans 8.2\\ProyectoWeb\\web\\resources\\imagen";
    String nombreArchivo;

    public List<Plato> getListaPlato() {
        listaPlato=platoFacadeLocal.findAll();
        return listaPlato;
    }

    public void setListaPlato(List<Plato> listaPlato) {
        this.listaPlato = listaPlato;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    @PostConstruct

    public void init() {
        this.plato = new Plato();
    }

    public void insertarPlato() {

        this.plato.setFoto("/resources/imagen/" + nombreArchivo);
        String np = String.valueOf(plato.getNombrePlato().charAt(0));
        int r1 = (int) (Math.random() * (5000 - 1) + 1);
        String codigo = "P" + np + r1;
        plato.setCodigoPlato(codigo);
        platoFacadeLocal.create(plato);
        init();
    }

    public void eliminarPlato(Plato p) {
        platoFacadeLocal.remove(p);
        init();
    }

    public void cargarPlato(Plato p) {
        this.plato = p;
    }

    public void modificarPlato() {
        if (nombreArchivo == null) {
            for (Plato p : platoFacadeLocal.findAll()) {
                if (p.getCodigoPlato().equals(plato.getCodigoPlato())) {
                    this.plato.setFoto(p.getFoto());
                }
            }
            platoFacadeLocal.edit(plato);
            init();
        }
        if (nombreArchivo != null) {
            this.plato.setFoto("/resources/imagen/" + nombreArchivo);
            platoFacadeLocal.edit(plato);
            init();
        }
    }

    public void copiarImagen(FileUploadEvent e) {
        byte[] b = new byte[500000];
        int todo;
        try {
            UploadedFile uploadedFile = e.getFile();
            nombreArchivo = uploadedFile.getFileName();
            File file = new File(ruta, nombreArchivo);
            OutputStream out = new FileOutputStream(file);
            InputStream in = uploadedFile.getInputstream();
            while ((todo = in.read(b)) != -1) {
                out.write(b, 0, todo);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagedPlato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagedPlato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
