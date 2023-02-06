/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Mesa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class MesaFacade extends AbstractFacade<Mesa> implements MesaFacadeLocal {

    @PersistenceContext(unitName = "ProyectoWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesaFacade() {
        super(Mesa.class);
    }
    
}
