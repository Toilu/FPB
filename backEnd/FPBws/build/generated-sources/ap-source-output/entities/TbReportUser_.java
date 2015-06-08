package entities;

import entities.TbReservation;
import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbReportUser.class)
public class TbReportUser_ { 

    public static volatile SingularAttribute<TbReportUser, String> cReason;
    public static volatile SingularAttribute<TbReportUser, TbReservation> cReference;
    public static volatile SingularAttribute<TbReportUser, String> cDate;
    public static volatile SingularAttribute<TbReportUser, TbUser> cUserId;
    public static volatile SingularAttribute<TbReportUser, TbUser> cReportUserId;
    public static volatile SingularAttribute<TbReportUser, Integer> cId;

}