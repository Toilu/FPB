/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.TbField;
import entities.TbReservation;
import java.sql.Date;
import java.util.ArrayList;
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
@Path("entities.tbfield")
public class TbFieldFacadeREST extends AbstractFacade<TbField> {

    @PersistenceContext(unitName = "FPBwsPU")
    private EntityManager em;

    public TbFieldFacadeREST() {
        super(TbField.class);
    }

    @POST
    @Override
    @Consumes({"application/json; charset=UTF-8"})
    public void create(TbField entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json; charset=UTF-8"})
    public void edit(@PathParam("id") Integer id, TbField entity) {
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
    public TbField find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json; charset=UTF-8"})
    public List<TbField> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json; charset=UTF-8"})
    public List<TbField> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("stadiumid/{stadiumid}/date/{date}/slot/{slot}")
    @Produces({"application/json; charset=UTF-8"})
    public List<TbField> FieldFilter(
            @PathParam("stadiumid") int stadiumid, @PathParam("date") String date, @PathParam("slot") int slot) {
        // Lấy danh sách sân đã đặt
        List<TbReservation> ListReservation = em.createNamedQuery("TbReservation.findAll").getResultList();
        // lấy hết sân
        List<TbField> ListField = em.createNamedQuery("TbField.findAll").getResultList();

        for (int i = 0; i < ListReservation.size(); i++) {
            for (int j = 0; j < ListField.size(); j++) {
                if (ListReservation.get(i).getCFieldId().getCId().equals(ListField.get(j).getCId())) {
                    if (ListReservation.get(i).getCDate().equals(date)) {
                        if (ListReservation.get(i).getCSlotId().getCId().equals(slot)) {
                            /*             
                             TbField temp = new TbField();
                             temp.setCId(ListField.get(j).getCId());
                             temp.setCStadiumId(ListField.get(j).getCStadiumId());
                             temp.setCNumber(ListField.get(j).getCNumber());
                             temp.setCFieldTypeId(ListField.get(j).getCFieldTypeId());
                             temp.setCIsActive(ListField.get(j).getCIsActive());
                             Listtemps.add(temp);
                             */
                            ListField.remove(j);
                        }
                    }
                }

            }
        }

        return ListField;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
