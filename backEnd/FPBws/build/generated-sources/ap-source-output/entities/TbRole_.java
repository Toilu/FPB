package entities;

import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbRole.class)
public class TbRole_ { 

    public static volatile SingularAttribute<TbRole, String> cDisplayName;
    public static volatile ListAttribute<TbRole, TbUser> tbUserList;
    public static volatile SingularAttribute<TbRole, Integer> cId;
    public static volatile SingularAttribute<TbRole, String> cRole;

}