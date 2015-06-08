/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Administrator
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.TbFieldFacadeREST.class);
        resources.add(service.TbFieldPriceFacadeREST.class);
        resources.add(service.TbJoinSystemRequestFacadeREST.class);
        resources.add(service.TbMemberRankFacadeREST.class);
        resources.add(service.TbPriceTableFacadeREST.class);
        resources.add(service.TbPromotionFacadeREST.class);
        resources.add(service.TbPunishMemberFacadeREST.class);
        resources.add(service.TbReportUserFacadeREST.class);
        resources.add(service.TbReservationFacadeREST.class);
        resources.add(service.TbRoleFacadeREST.class);
        resources.add(service.TbStadiumFacadeREST.class);
        resources.add(service.TbStadiumImageFacadeREST.class);
        resources.add(service.TbStadiumRatingFacadeREST.class);
        resources.add(service.TbStadiumReviewFacadeREST.class);
        resources.add(service.TbStadiumStaffFacadeREST.class);
        resources.add(service.TbUserFacadeREST.class);
    }
    
}
