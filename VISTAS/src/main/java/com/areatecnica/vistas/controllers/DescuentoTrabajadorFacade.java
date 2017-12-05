/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.controllers;

import com.areatecnica.vistas.entity.DescuentoTrabajador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ian Franco
 */
@Stateless
public class DescuentoTrabajadorFacade extends AbstractFacade<DescuentoTrabajador> {

    @PersistenceContext(unitName = "com.areatecnica_vistas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DescuentoTrabajadorFacade() {
        super(DescuentoTrabajador.class);
    }
    
}
