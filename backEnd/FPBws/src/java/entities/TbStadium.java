/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_Stadium", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStadium.findAll", query = "SELECT t FROM TbStadium t"),
    @NamedQuery(name = "TbStadium.findByCId", query = "SELECT t FROM TbStadium t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbStadium.findByCName", query = "SELECT t FROM TbStadium t WHERE t.cName = :cName"),
    @NamedQuery(name = "TbStadium.findByCStreet", query = "SELECT t FROM TbStadium t WHERE t.cStreet = :cStreet"),
    @NamedQuery(name = "TbStadium.findByCWard", query = "SELECT t FROM TbStadium t WHERE t.cWard = :cWard"),
    @NamedQuery(name = "TbStadium.findByCDistrict", query = "SELECT t FROM TbStadium t WHERE t.cDistrict = :cDistrict"),
    @NamedQuery(name = "TbStadium.findByCPhone", query = "SELECT t FROM TbStadium t WHERE t.cPhone = :cPhone"),
    @NamedQuery(name = "TbStadium.findByCEmail", query = "SELECT t FROM TbStadium t WHERE t.cEmail = :cEmail"),
    @NamedQuery(name = "TbStadium.findByCIsActive", query = "SELECT t FROM TbStadium t WHERE t.cIsActive = :cIsActive"),
    @NamedQuery(name = "TbStadium.findByCOpenTime", query = "SELECT t FROM TbStadium t WHERE t.cOpenTime = :cOpenTime"),
    @NamedQuery(name = "TbStadium.findByCCloseTime", query = "SELECT t FROM TbStadium t WHERE t.cCloseTime = :cCloseTime"),
    @NamedQuery(name = "TbStadium.findByCExpiredDate", query = "SELECT t FROM TbStadium t WHERE t.cExpiredDate = :cExpiredDate")})
public class TbStadium implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_Name")
    private String cName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Street")
    private String cStreet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Ward")
    private String cWard;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_District")
    private String cDistrict;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_Phone")
    private String cPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_Email")
    private String cEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_IsActive")
    private boolean cIsActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_OpenTime")
    private double cOpenTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_CloseTime")
    private double cCloseTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "c_ExpiredDate")
    private String cExpiredDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumRating> tbStadiumRatingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumReview> tbStadiumReviewList;
    @JoinColumn(name = "c_MainOwner", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cMainOwner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumStaff> tbStadiumStaffList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbFieldPrice> tbFieldPriceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbField> tbFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumImage> tbStadiumImageList;

    public TbStadium() {
    }

    public TbStadium(Integer cId) {
        this.cId = cId;
    }

    public TbStadium(Integer cId, String cName, String cStreet, String cWard, String cDistrict, String cPhone, String cEmail, boolean cIsActive, double cOpenTime, double cCloseTime, String cExpiredDate) {
        this.cId = cId;
        this.cName = cName;
        this.cStreet = cStreet;
        this.cWard = cWard;
        this.cDistrict = cDistrict;
        this.cPhone = cPhone;
        this.cEmail = cEmail;
        this.cIsActive = cIsActive;
        this.cOpenTime = cOpenTime;
        this.cCloseTime = cCloseTime;
        this.cExpiredDate = cExpiredDate;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCStreet() {
        return cStreet;
    }

    public void setCStreet(String cStreet) {
        this.cStreet = cStreet;
    }

    public String getCWard() {
        return cWard;
    }

    public void setCWard(String cWard) {
        this.cWard = cWard;
    }

    public String getCDistrict() {
        return cDistrict;
    }

    public void setCDistrict(String cDistrict) {
        this.cDistrict = cDistrict;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public boolean getCIsActive() {
        return cIsActive;
    }

    public void setCIsActive(boolean cIsActive) {
        this.cIsActive = cIsActive;
    }

    public double getCOpenTime() {
        return cOpenTime;
    }

    public void setCOpenTime(double cOpenTime) {
        this.cOpenTime = cOpenTime;
    }

    public double getCCloseTime() {
        return cCloseTime;
    }

    public void setCCloseTime(double cCloseTime) {
        this.cCloseTime = cCloseTime;
    }

    public String getCExpiredDate() {
        return cExpiredDate;
    }

    public void setCExpiredDate(String cExpiredDate) {
        this.cExpiredDate = cExpiredDate;
    }

    @XmlTransient
    public List<TbStadiumRating> getTbStadiumRatingList() {
        return tbStadiumRatingList;
    }

    public void setTbStadiumRatingList(List<TbStadiumRating> tbStadiumRatingList) {
        this.tbStadiumRatingList = tbStadiumRatingList;
    }

    @XmlTransient
    public List<TbStadiumReview> getTbStadiumReviewList() {
        return tbStadiumReviewList;
    }

    public void setTbStadiumReviewList(List<TbStadiumReview> tbStadiumReviewList) {
        this.tbStadiumReviewList = tbStadiumReviewList;
    }

    public TbUser getCMainOwner() {
        return cMainOwner;
    }

    public void setCMainOwner(TbUser cMainOwner) {
        this.cMainOwner = cMainOwner;
    }

    @XmlTransient
    public List<TbStadiumStaff> getTbStadiumStaffList() {
        return tbStadiumStaffList;
    }

    public void setTbStadiumStaffList(List<TbStadiumStaff> tbStadiumStaffList) {
        this.tbStadiumStaffList = tbStadiumStaffList;
    }

    @XmlTransient
    public List<TbFieldPrice> getTbFieldPriceList() {
        return tbFieldPriceList;
    }

    public void setTbFieldPriceList(List<TbFieldPrice> tbFieldPriceList) {
        this.tbFieldPriceList = tbFieldPriceList;
    }

    @XmlTransient
    public List<TbField> getTbFieldList() {
        return tbFieldList;
    }

    public void setTbFieldList(List<TbField> tbFieldList) {
        this.tbFieldList = tbFieldList;
    }

    @XmlTransient
    public List<TbStadiumImage> getTbStadiumImageList() {
        return tbStadiumImageList;
    }

    public void setTbStadiumImageList(List<TbStadiumImage> tbStadiumImageList) {
        this.tbStadiumImageList = tbStadiumImageList;
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
        if (!(object instanceof TbStadium)) {
            return false;
        }
        TbStadium other = (TbStadium) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbStadium[ cId=" + cId + " ]";
    }
    
}
