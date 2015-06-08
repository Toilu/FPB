package entities;

import entities.TbField;
import entities.TbReportUser;
import entities.TbUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbReservation.class)
public class TbReservation_ { 

    public static volatile SingularAttribute<TbReservation, String> cPhoneNumber;
    public static volatile SingularAttribute<TbReservation, String> cEmail;
    public static volatile SingularAttribute<TbReservation, Double> cDuration;
    public static volatile SingularAttribute<TbReservation, TbUser> cApprover;
    public static volatile SingularAttribute<TbReservation, String> cDate;
    public static volatile SingularAttribute<TbReservation, Date> cCreatedDate;
    public static volatile SingularAttribute<TbReservation, String> cStatus;
    public static volatile SingularAttribute<TbReservation, Boolean> cNeedRival;
    public static volatile SingularAttribute<TbReservation, Double> cStartTime;
    public static volatile SingularAttribute<TbReservation, String> cRivalPhone;
    public static volatile SingularAttribute<TbReservation, Double> cPrice;
    public static volatile SingularAttribute<TbReservation, TbUser> cRivalId;
    public static volatile SingularAttribute<TbReservation, String> cFullName;
    public static volatile SingularAttribute<TbReservation, String> cRivalName;
    public static volatile SingularAttribute<TbReservation, TbUser> cUserId;
    public static volatile SingularAttribute<TbReservation, TbField> cFieldId;
    public static volatile SingularAttribute<TbReservation, String> cRivalStatus;
    public static volatile SingularAttribute<TbReservation, Integer> cId;
    public static volatile SingularAttribute<TbReservation, Double> cDiscount;
    public static volatile SingularAttribute<TbReservation, TbUser> cRivalFinder;
    public static volatile SingularAttribute<TbReservation, String> cVerifyCode;
    public static volatile SingularAttribute<TbReservation, String> cRivalEmail;
    public static volatile ListAttribute<TbReservation, TbReportUser> tbReportUserList;

}