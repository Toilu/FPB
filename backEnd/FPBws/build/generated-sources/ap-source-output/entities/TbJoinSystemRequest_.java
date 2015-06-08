package entities;

import entities.TbUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbJoinSystemRequest.class)
public class TbJoinSystemRequest_ { 

    public static volatile SingularAttribute<TbJoinSystemRequest, String> cEmail;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cAddress;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cStadiumName;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cStadiumAddress;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cFullName;
    public static volatile SingularAttribute<TbJoinSystemRequest, TbUser> cUserId;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cStatus;
    public static volatile SingularAttribute<TbJoinSystemRequest, Date> cCreateDate;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cPhone;
    public static volatile SingularAttribute<TbJoinSystemRequest, String> cNote;
    public static volatile SingularAttribute<TbJoinSystemRequest, Integer> cId;

}