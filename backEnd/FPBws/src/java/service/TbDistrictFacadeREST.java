/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.TbDistrict;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrator
 */
@Stateless
@Path("entities.tbdistrict")
public class TbDistrictFacadeREST extends AbstractFacade<TbDistrict> {
    @PersistenceContext(unitName = "FPBwsPU")
    private EntityManager em;

    public TbDistrictFacadeREST() {
        super(TbDistrict.class);
    }

    @POST
    @Override
    @Consumes({"application/json; charset=UTF-8"})
    public void create(TbDistrict entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json; charset=UTF-8"})
    public void edit(@PathParam("id") Integer id, TbDistrict entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json; charset=UTF-8"})
    public TbDistrict find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json; charset=UTF-8"})
    public List<TbDistrict> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json; charset=UTF-8"})
    public List<TbDistrict> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
