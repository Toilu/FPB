package entities;

import entities.TbStadium;
import entities.TbUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbStadiumReview.class)
public class TbStadiumReview_ { 

    public static volatile SingularAttribute<TbStadiumReview, TbUser> cApprover;
    public static volatile SingularAttribute<TbStadiumReview, Boolean> cIsApproved;
    public static volatile SingularAttribute<TbStadiumReview, TbStadium> cStadiumId;
    public static volatile SingularAttribute<TbStadiumReview, TbUser> cUserId;
    public static volatile SingularAttribute<TbStadiumReview, Date> cCreateDate;
    public static volatile SingularAttribute<TbStadiumReview, Integer> cId;
    public static volatile SingularAttribute<TbStadiumReview, String> cReviewContent;

}