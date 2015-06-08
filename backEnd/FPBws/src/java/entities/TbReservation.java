/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_Reservation", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbReservation.findAll", query = "SELECT t FROM TbReservation t"),
    @NamedQuery(name = "TbReservation.findByCId", query = "SELECT t FROM TbReservation t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbReservation.findByCFullName", query = "SELECT t FROM TbReservation t WHERE t.cFullName = :cFullName"),
    @NamedQuery(name = "TbReservation.findByCPhoneNumber", query = "SELECT t FROM TbReservation t WHERE t.cPhoneNumber = :cPhoneNumber"),
    @NamedQuery(name = "TbReservation.findByCEmail", query = "SELECT t FROM TbReservation t WHERE t.cEmail = :cEmail"),
    @NamedQuery(name = "TbReservation.findByCDate", query = "SELECT t FROM TbReservation t WHERE t.cDate = :cDate"),
    @NamedQuery(name = "TbReservation.findByCStartTime", query = "SELECT t FROM TbReservation t WHERE t.cStartTime = :cStartTime"),
    @NamedQuery(name = "TbReservation.findByCDuration", query = "SELECT t FROM TbReservation t WHERE t.cDuration = :cDuration"),
    @NamedQuery(name = "TbReservation.findByCPrice", query = "SELECT t FROM TbReservation t WHERE t.cPrice = :cPrice"),
    @NamedQuery(name = "TbReservation.findByCDiscount", query = "SELECT t FROM TbReservation t WHERE t.cDiscount = :cDiscount"),
    @NamedQuery(name = "TbReservation.findByCVerifyCode", query = "SELECT t FROM TbReservation t WHERE t.cVerifyCode = :cVerifyCode"),
    @NamedQuery(name = "TbReservation.findByCCreatedDate", query = "SELECT t FROM TbReservation t WHERE t.cCreatedDate = :cCreatedDate"),
    @NamedQuery(name = "TbReservation.findByCStatus", query = "SELECT t FROM TbReservation t WHERE t.cStatus = :cStatus"),
    @NamedQuery(name = "TbReservation.findByCNeedRival", query = "SELECT t FROM TbReservation t WHERE t.cNeedRival = :cNeedRival"),
    @NamedQuery(name = "TbReservation.findByCRivalName", query = "SELECT t FROM TbReservation t WHERE t.cRivalName = :cRivalName"),
    @NamedQuery(name = "TbReservation.findByCRivalPhone", query = "SELECT t FROM TbReservation t WHERE t.cRivalPhone = :cRivalPhone"),
    @NamedQuery(name = "TbReservation.findByCRivalEmail", query = "SELECT t FROM TbReservation t WHERE t.cRivalEmail = :cRivalEmail"),
    @NamedQuery(name = "TbReservation.findByCRivalStatus", query = "SELECT t FROM TbReservation t WHERE t.cRivalStatus = :cRivalStatus")})
public class TbReservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_FullName")
    private String cFullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_PhoneNumber")
    private String cPhoneNumber;
    @Size(max = 50)
    @Column(name = "c_Email")
    private String cEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "c_Date")
    private String cDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_StartTime")
    private double cStartTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Duration")
    private double cDuration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Price")
    private double cPrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "c_Discount")
    private Double cDiscount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_VerifyCode")
    private String cVerifyCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cCreatedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_Status")
    private String cStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_NeedRival")
    private boolean cNeedRival;
    @Size(max = 50)
    @Column(name = "c_RivalName")
    private String cRivalName;
    @Size(max = 20)
    @Column(name = "c_RivalPhone")
    private String cRivalPhone;
    @Size(max = 50)
    @Column(name = "c_RivalEmail")
    private String cRivalEmail;
    @Size(max = 50)
    @Column(name = "c_RivalStatus")
    private String cRivalStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cReference")
    private List<TbReportUser> tbReportUserList;
    @JoinColumn(name = "c_RivalFinder", referencedColumnName = "c_Id")
    @ManyToOne
    private TbUser cRivalFinder;
    @JoinColumn(name = "c_RivalId", referencedColumnName = "c_Id")
    @ManyToOne
    private TbUser cRivalId;
    @JoinColumn(name = "c_Approver", referencedColumnName = "c_Id")
    @ManyToOne
    private TbUser cApprover;
    @JoinColumn(name = "c_UserId", referencedColumnName = "c_Id")
    @ManyToOne
    private TbUser cUserId;
    @JoinColumn(name = "c_FieldId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbField cFieldId;

    public TbReservation() {
    }

    public TbReservation(Integer cId) {
        this.cId = cId;
    }

    public TbReservation(Integer cId, String cFullName, String cPhoneNumber, String cDate, double cStartTime, double cDuration, double cPrice, String cVerifyCode, Date cCreatedDate, String cStatus, boolean cNeedRival) {
        this.cId = cId;
        this.cFullName = cFullName;
        this.cPhoneNumber = cPhoneNumber;
        this.cDate = cDate;
        this.cStartTime = cStartTime;
        this.cDuration = cDuration;
        this.cPrice = cPrice;
        this.cVerifyCode = cVerifyCode;
        this.cCreatedDate = cCreatedDate;
        this.cStatus = cStatus;
        this.cNeedRival = cNeedRival;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCFullName() {
        return cFullName;
    }

    public void setCFullName(String cFullName) {
        this.cFullName = cFullName;
    }

    public String getCPhoneNumber() {
        return cPhoneNumber;
    }

    public void setCPhoneNumber(String cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCDate() {
        return cDate;
    }

    public void setCDate(String cDate) {
        this.cDate = cDate;
    }

    public double getCStartTime() {
        return cStartTime;
    }

    public void setCStartTime(double cStartTime) {
        this.cStartTime = cStartTime;
    }

    public double getCDuration() {
        return cDuration;
    }

    public void setCDuration(double cDuration) {
        this.cDuration = cDuration;
    }

    public double getCPrice() {
        return cPrice;
    }

    public void setCPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public Double getCDiscount() {
        return cDiscount;
    }

    public void setCDiscount(Double cDiscount) {
        this.cDiscount = cDiscount;
    }

    public String getCVerifyCode() {
        return cVerifyCode;
    }

    public void setCVerifyCode(String cVerifyCode) {
        this.cVerifyCode = cVerifyCode;
    }

    public Date getCCreatedDate() {
        return cCreatedDate;
    }

    public void setCCreatedDate(Date cCreatedDate) {
        this.cCreatedDate = cCreatedDate;
    }

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public boolean getCNeedRival() {
        return cNeedRival;
    }

    public void setCNeedRival(boolean cNeedRival) {
        this.cNeedRival = cNeedRival;
    }

    public String getCRivalName() {
        return cRivalName;
    }

    public void setCRivalName(String cRivalName) {
        this.cRivalName = cRivalName;
    }

    public String getCRivalPhone() {
        return cRivalPhone;
    }

    public void setCRivalPhone(String cRivalPhone) {
        this.cRivalPhone = cRivalPhone;
    }

    public String getCRivalEmail() {
        return cRivalEmail;
    }

    public void setCRivalEmail(String cRivalEmail) {
        this.cRivalEmail = cRivalEmail;
    }

    public String getCRivalStatus() {
        return cRivalStatus;
    }

    public void setCRivalStatus(String cRivalStatus) {
        this.cRivalStatus = cRivalStatus;
    }

    @XmlTransient
    public List<TbReportUser> getTbReportUserList() {
        return tbReportUserList;
    }

    public void setTbReportUserList(List<TbReportUser> tbReportUserList) {
        this.tbReportUserList = tbReportUserList;
    }

    public TbUser getCRivalFinder() {
        return cRivalFinder;
    }

    public void setCRivalFinder(TbUser cRivalFinder) {
        this.cRivalFinder = cRivalFinder;
    }

    public TbUser getCRivalId() {
        return cRivalId;
    }

    public void setCRivalId(TbUser cRivalId) {
        this.cRivalId = cRivalId;
    }

    public TbUser getCApprover() {
        return cApprover;
    }

    public void setCApprover(TbUser cApprover) {
        this.cApprover = cApprover;
    }

    public TbUser getCUserId() {
        return cUserId;
    }

    public void setCUserId(TbUser cUserId) {
        this.cUserId = cUserId;
    }

    public TbField getCFieldId() {
        return cFieldId;
    }

    public void setCFieldId(TbField cFieldId) {
        this.cFieldId = cFieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbReservation)) {
            return false;
        }
        TbReservation other = (TbReservation) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbReservation[ cId=" + cId + " ]";
    }
    
}
