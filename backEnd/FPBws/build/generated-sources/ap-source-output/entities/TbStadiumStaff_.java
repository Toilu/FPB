package entities;

import entities.TbStadium;
import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbStadiumStaff.class)
public class TbStadiumStaff_ { 

    public static volatile SingularAttribute<TbStadiumStaff, TbStadium> cStadiumId;
    public static volatile SingularAttribute<TbStadiumStaff, TbUser> cUserId;
    public static volatile SingularAttribute<TbStadiumStaff, Boolean> cIsOwner;
    public static volatile SingularAttribute<TbStadiumStaff, Integer> cId;

}