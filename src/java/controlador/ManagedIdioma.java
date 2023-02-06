/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped

public class ManagedIdioma {
    
    
    public void cambiarIdioma(ValueChangeEvent e){
        FacesContext fc = FacesContext.getCurrentInstance();
        UIViewRoot ui = fc.getViewRoot();
        ui.setLocale(new Locale(e.getNewValue().toString()));
    }
}
