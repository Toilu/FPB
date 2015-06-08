package entities;

import entities.TbJoinSystemRequest;
import entities.TbMemberRank;
import entities.TbPromotion;
import entities.TbPunishMember;
import entities.TbReportUser;
import entities.TbReservation;
import entities.TbRole;
import entities.TbStadium;
import entities.TbStadiumRating;
import entities.TbStadiumReview;
import entities.TbStadiumStaff;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-07T13:23:40")
@StaticMetamodel(TbUser.class)
public class TbUser_ { 

    public static volatile SingularAttribute<TbUser, String> cEmail;
    public static volatile ListAttribute<TbUser, TbJoinSystemRequest> tbJoinSystemRequestList;
    public static volatile SingularAttribute<TbUser, String> cUserName;
    public static volatile SingularAttribute<TbUser, Boolean> cIsActive;
    public static volatile ListAttribute<TbUser, TbPromotion> tbPromotionList;
    public static volatile ListAttribute<TbUser, TbStadium> tbStadiumList;
    public static volatile ListAttribute<TbUser, TbPunishMember> tbPunishMemberList1;
    public static volatile ListAttribute<TbUser, TbStadiumReview> tbStadiumReviewList1;
    public static volatile ListAttribute<TbUser, TbReservation> tbReservationList1;
    public static volatile ListAttribute<TbUser, TbReservation> tbReservationList2;
    public static volatile ListAttribute<TbUser, TbReservation> tbReservationList3;
    public static volatile SingularAttribute<TbUser, String> cPhoneNumber;
    public static volatile SingularAttribute<TbUser, TbRole> cRoleId;
    public static volatile ListAttribute<TbUser, TbReportUser> tbReportUserList1;
    public static volatile SingularAttribute<TbUser, String> cPassword;
    public static volatile SingularAttribute<TbUser, String> cAddress;
    public static volatile SingularAttribute<TbUser, TbMemberRank> cRankId;
    public static volatile ListAttribute<TbUser, TbStadiumReview> tbStadiumReviewList;
    public static volatile ListAttribute<TbUser, TbPunishMember> tbPunishMemberList;
    public static volatile SingularAttribute<TbUser, String> cFullName;
    public static volatile ListAttribute<TbUser, TbReservation> tbReservationList;
    public static volatile ListAttribute<TbUser, TbStadiumRating> tbStadiumRatingList;
    public static volatile SingularAttribute<TbUser, Integer> cId;
    public static volatile ListAttribute<TbUser, TbStadiumStaff> tbStadiumStaffList;
    public static volatile SingularAttribute<TbUser, Integer> cPoint;
    public static volatile SingularAttribute<TbUser, String> cJoinDate;
    public static volatile ListAttribute<TbUser, TbReportUser> tbReportUserList;

}