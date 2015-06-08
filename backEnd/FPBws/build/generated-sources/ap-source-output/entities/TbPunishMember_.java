package entities;

import entities.TbUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbPunishMember.class)
public class TbPunishMember_ { 

    public static volatile SingularAttribute<TbPunishMember, String> cReason;
    public static volatile SingularAttribute<TbPunishMember, Boolean> cIsForever;
    public static volatile SingularAttribute<TbPunishMember, Date> cDate;
    public static volatile SingularAttribute<TbPunishMember, TbUser> cStaffId;
    public static volatile SingularAttribute<TbPunishMember, Date> cExpiredDate;
    public static volatile SingularAttribute<TbPunishMember, TbUser> cUserId;
    public static volatile SingularAttribute<TbPunishMember, Integer> cId;

}