package entities;

import entities.TbField;
import entities.TbPriceTable;
import entities.TbStadium;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbFieldPrice.class)
public class TbFieldPrice_ { 

    public static volatile SingularAttribute<TbFieldPrice, TbStadium> cStadiumId;
    public static volatile SingularAttribute<TbFieldPrice, String> cFieldPriceDescription;
    public static volatile ListAttribute<TbFieldPrice, TbField> tbFieldList;
    public static volatile SingularAttribute<TbFieldPrice, Integer> cId;
    public static volatile SingularAttribute<TbFieldPrice, String> cFieldPriceName;
    public static volatile ListAttribute<TbFieldPrice, TbPriceTable> tbPriceTableList;

}