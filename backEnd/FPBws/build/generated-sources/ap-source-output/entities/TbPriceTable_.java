package entities;

import entities.TbFieldPrice;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbPriceTable.class)
public class TbPriceTable_ { 

    public static volatile SingularAttribute<TbPriceTable, TbFieldPrice> cFieldPriceId;
    public static volatile SingularAttribute<TbPriceTable, Double> cTimeTo;
    public static volatile SingularAttribute<TbPriceTable, Double> cTimeFrom;
    public static volatile SingularAttribute<TbPriceTable, Double> cPrice;
    public static volatile SingularAttribute<TbPriceTable, Integer> cDay;
    public static volatile SingularAttribute<TbPriceTable, Integer> cId;

}