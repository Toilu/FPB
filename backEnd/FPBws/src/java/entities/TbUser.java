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
@Table(name = "tb_User", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUser.findAll", query = "SELECT t FROM TbUser t"),
    @NamedQuery(name = "TbUser.findByCId", query = "SELECT t FROM TbUser t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbUser.findByCUserName", query = "SELECT t FROM TbUser t WHERE t.cUserName = :cUserName"),
    @NamedQuery(name = "TbUser.findByCPassword", query = "SELECT t FROM TbUser t WHERE t.cPassword = :cPassword"),
    @NamedQuery(name = "TbUser.findByCFullName", query = "SELECT t FROM TbUser t WHERE t.cFullName = :cFullName"),
    @NamedQuery(name = "TbUser.findByCAddress", query = "SELECT t FROM TbUser t WHERE t.cAddress = :cAddress"),
    @NamedQuery(name = "TbUser.findByCPhoneNumber", query = "SELECT t FROM TbUser t WHERE t.cPhoneNumber = :cPhoneNumber"),
    @NamedQuery(name = "TbUser.findByCEmail", query = "SELECT t FROM TbUser t WHERE t.cEmail = :cEmail"),
    @NamedQuery(name = "TbUser.findByCJoinDate", query = "SELECT t FROM TbUser t WHERE t.cJoinDate = :cJoinDate"),
    @NamedQuery(name = "TbUser.findByCIsActive", query = "SELECT t FROM TbUser t WHERE t.cIsActive = :cIsActive")})
public class TbUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_UserName")
    private String cUserName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Password")
    private String cPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_FullName")
    private String cFullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_Address")
    private String cAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_PhoneNumber")
    private String cPhoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Email")
    private String cEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "c_JoinDate")
    private String cJoinDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_IsActive")
    private boolean cIsActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUserId")
    private List<TbJoinSystemRequest> tbJoinSystemRequestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUserId")
    private List<TbStadiumRating> tbStadiumRatingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cApprover")
    private List<TbStadiumReview> tbStadiumReviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUserId")
    private List<TbStadiumReview> tbStadiumReviewList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cMainOwner")
    private List<TbStadium> tbStadiumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUserId")
    private List<TbStadiumStaff> tbStadiumStaffList;
    @JoinColumn(name = "c_RoleId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbRole cRoleId;

    public TbUser() {
    }

    public TbUser(Integer cId) {
        this.cId = cId;
    }

    public TbUser(Integer cId, String cUserName, String cPassword, String cFullName, String cAddress, String cPhoneNumber, String cEmail, String cJoinDate, boolean cIsActive) {
        this.cId = cId;
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.cFullName = cFullName;
        this.cAddress = cAddress;
        this.cPhoneNumber = cPhoneNumber;
        this.cEmail = cEmail;
        this.cJoinDate = cJoinDate;
        this.cIsActive = cIsActive;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCUserName() {
        return cUserName;
    }

    public void setCUserName(String cUserName) {
        this.cUserName = cUserName;
    }

    public String getCPassword() {
        return cPassword;
    }

    public void setCPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getCFullName() {
        return cFullName;
    }

    public void setCFullName(String cFullName) {
        this.cFullName = cFullName;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
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

    public String getCJoinDate() {
        return cJoinDate;
    }

    public void setCJoinDate(String cJoinDate) {
        this.cJoinDate = cJoinDate;
    }

    public boolean getCIsActive() {
        return cIsActive;
    }

    public void setCIsActive(boolean cIsActive) {
        this.cIsActive = cIsActive;
    }

    @XmlTransient
    public List<TbJoinSystemRequest> getTbJoinSystemRequestList() {
        return tbJoinSystemRequestList;
    }

    public void setTbJoinSystemRequestList(List<TbJoinSystemRequest> tbJoinSystemRequestList) {
        this.tbJoinSystemRequestList = tbJoinSystemRequestList;
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

    @XmlTransient
    public List<TbStadiumReview> getTbStadiumReviewList1() {
        return tbStadiumReviewList1;
    }

    public void setTbStadiumReviewList1(List<TbStadiumReview> tbStadiumReviewList1) {
        this.tbStadiumReviewList1 = tbStadiumReviewList1;
    }

    @XmlTransient
    public List<TbStadium> getTbStadiumList() {
        return tbStadiumList;
    }

    public void setTbStadiumList(List<TbStadium> tbStadiumList) {
        this.tbStadiumList = tbStadiumList;
    }

    @XmlTransient
    public List<TbStadiumStaff> getTbStadiumStaffList() {
        return tbStadiumStaffList;
    }

    public void setTbStadiumStaffList(List<TbStadiumStaff> tbStadiumStaffList) {
        this.tbStadiumStaffList = tbStadiumStaffList;
    }

    public TbRole getCRoleId() {
        return cRoleId;
    }

    public void setCRoleId(TbRole cRoleId) {
        this.cRoleId = cRoleId;
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
        if (!(object instanceof TbUser)) {
            return false;
        }
        TbUser other = (TbUser) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbUser[ cId=" + cId + " ]";
    }
    
}
