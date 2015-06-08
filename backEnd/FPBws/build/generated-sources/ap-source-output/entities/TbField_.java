package entities;

import entities.TbField;
import entities.TbFieldPrice;
import entities.TbPromotion;
import entities.TbReservation;
import entities.TbStadium;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbField.class)
public class TbField_ { 

    public static volatile SingularAttribute<TbField, TbFieldPrice> cPriceId;
    public static volatile SingularAttribute<TbField, Boolean> cIsActive;
    public static volatile SingularAttribute<TbField, TbStadium> cStadiumId;
    public static volatile SingularAttribute<TbField, TbField> cParentField;
    public static volatile ListAttribute<TbField, TbReservation> tbReservationList;
    public static volatile ListAttribute<TbField, TbField> tbFieldList;
    public static volatile SingularAttribute<TbField, Integer> cFieldType;
    public static volatile SingularAttribute<TbField, Integer> cId;
    public static volatile ListAttribute<TbField, TbPromotion> tbPromotionList;
    public static volatile SingularAttribute<TbField, String> cNumber;

}