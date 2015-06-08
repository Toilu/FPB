package entities;

import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbMemberRank.class)
public class TbMemberRank_ { 

    public static volatile SingularAttribute<TbMemberRank, String> cRankName;
    public static volatile SingularAttribute<TbMemberRank, String> cPromotion;
    public static volatile ListAttribute<TbMemberRank, TbUser> tbUserList;
    public static volatile SingularAttribute<TbMemberRank, Integer> cId;
    public static volatile SingularAttribute<TbMemberRank, Integer> cPoint;

}