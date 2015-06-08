/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.TbMemberRank;
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
@Path("entities.tbmemberrank")
public class TbMemberRankFacadeREST extends AbstractFacade<TbMemberRank> {
    @PersistenceContext(unitName = "FPBwsPU")
    private EntityManager em;

    public TbMemberRankFacadeREST() {
        super(TbMemberRank.class);
    }

    @POST
    @Override
    @Consumes("application/json; charset=UTF-8")
    public void create(TbMemberRank entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json; charset=UTF-8")
    public void edit(@PathParam("id") Integer id, TbMemberRank entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public TbMemberRank find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json; charset=UTF-8")
    public List<TbMemberRank> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json; charset=UTF-8")
    public List<TbMemberRank> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
