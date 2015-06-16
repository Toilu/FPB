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
    @NamedQuery(name = "TbStadium.findByCAddress", query = "SELECT t FROM TbStadium t WHERE t.cAddress = :cAddress"),
    @NamedQuery(name = "TbStadium.findByCPhone", query = "SELECT t FROM TbStadium t WHERE t.cPhone = :cPhone"),
    @NamedQuery(name = "TbStadium.findByCEmail", query = "SELECT t FROM TbStadium t WHERE t.cEmail = :cEmail"),
    @NamedQuery(name = "TbStadium.findByCIsActive", query = "SELECT t FROM TbStadium t WHERE t.cIsActive = :cIsActive")})
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
    @Column(name = "c_Address")
    private String cAddress;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbField> tbFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumImage> tbStadiumImageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbPriceTable> tbPriceTableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumRating> tbStadiumRatingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumReview> tbStadiumReviewList;
    @JoinColumn(name = "c_MainOwner", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cMainOwner;
    @JoinColumn(name = "c_DistrictId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbDistrict cDistrictId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cStadiumId")
    private List<TbStadiumStaff> tbStadiumStaffList;

    public TbStadium() {
    }

    public TbStadium(Integer cId) {
        this.cId = cId;
    }

    public TbStadium(Integer cId, String cName, String cAddress, String cPhone, String cEmail, boolean cIsActive) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
        this.cPhone = cPhone;
        this.cEmail = cEmail;
        this.cIsActive = cIsActive;
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

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
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

    @XmlTransient
    public List<TbPriceTable> getTbPriceTableList() {
        return tbPriceTableList;
    }

    public void setTbPriceTableList(List<TbPriceTable> tbPriceTableList) {
        this.tbPriceTableList = tbPriceTableList;
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

    public TbDistrict getCDistrictId() {
        return cDistrictId;
    }

    public void setCDistrictId(TbDistrict cDistrictId) {
        this.cDistrictId = cDistrictId;
    }

    @XmlTransient
    public List<TbStadiumStaff> getTbStadiumStaffList() {
        return tbStadiumStaffList;
    }

    public void setTbStadiumStaffList(List<TbStadiumStaff> tbStadiumStaffList) {
        this.tbStadiumStaffList = tbStadiumStaffList;
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
