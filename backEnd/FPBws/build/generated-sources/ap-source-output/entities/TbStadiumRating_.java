package entities;

import entities.TbStadium;
import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbStadiumRating.class)
public class TbStadiumRating_ { 

    public static volatile SingularAttribute<TbStadiumRating, TbStadium> cStadiumId;
    public static volatile SingularAttribute<TbStadiumRating, TbUser> cUserId;
    public static volatile SingularAttribute<TbStadiumRating, Double> cRate;
    public static volatile SingularAttribute<TbStadiumRating, Integer> cId;

}