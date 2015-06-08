package entities;

import entities.TbField;
import entities.TbFieldPrice;
import entities.TbStadiumImage;
import entities.TbStadiumRating;
import entities.TbStadiumReview;
import entities.TbStadiumStaff;
import entities.TbUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbStadium.class)
public class TbStadium_ { 

    public static volatile SingularAttribute<TbStadium, String> cWard;
    public static volatile SingularAttribute<TbStadium, String> cEmail;
    public static volatile SingularAttribute<TbStadium, Double> cOpenTime;
    public static volatile SingularAttribute<TbStadium, Boolean> cIsActive;
    public static volatile SingularAttribute<TbStadium, String> cDistrict;
    public static volatile SingularAttribute<TbStadium, String> cName;
    public static volatile SingularAttribute<TbStadium, String> cStreet;
    public static volatile ListAttribute<TbStadium, TbStadiumImage> tbStadiumImageList;
    public static volatile SingularAttribute<TbStadium, Double> cCloseTime;
    public static volatile ListAttribute<TbStadium, TbStadiumReview> tbStadiumReviewList;
    public static volatile SingularAttribute<TbStadium, String> cExpiredDate;
    public static volatile ListAttribute<TbStadium, TbFieldPrice> tbFieldPriceList;
    public static volatile ListAttribute<TbStadium, TbStadiumRating> tbStadiumRatingList;
    public static volatile ListAttribute<TbStadium, TbField> tbFieldList;
    public static volatile SingularAttribute<TbStadium, String> cPhone;
    public static volatile SingularAttribute<TbStadium, TbUser> cMainOwner;
    public static volatile SingularAttribute<TbStadium, Integer> cId;
    public static volatile ListAttribute<TbStadium, TbStadiumStaff> tbStadiumStaffList;

}