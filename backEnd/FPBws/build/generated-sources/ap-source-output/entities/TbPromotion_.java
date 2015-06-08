package entities;

import entities.TbField;
import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbPromotion.class)
public class TbPromotion_ { 

    public static volatile SingularAttribute<TbPromotion, String> cPromotionFrom;
    public static volatile SingularAttribute<TbPromotion, Boolean> cIsActive;
    public static volatile SingularAttribute<TbPromotion, TbField> cFieldId;
    public static volatile SingularAttribute<TbPromotion, String> cPromotionTo;
    public static volatile SingularAttribute<TbPromotion, TbUser> cCreator;
    public static volatile SingularAttribute<TbPromotion, Integer> cId;
    public static volatile SingularAttribute<TbPromotion, Double> cDiscount;

}