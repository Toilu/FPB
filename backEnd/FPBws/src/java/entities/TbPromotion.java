/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_Promotion", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPromotion.findAll", query = "SELECT t FROM TbPromotion t"),
    @NamedQuery(name = "TbPromotion.findByCId", query = "SELECT t FROM TbPromotion t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbPromotion.findByCPromotionFrom", query = "SELECT t FROM TbPromotion t WHERE t.cPromotionFrom = :cPromotionFrom"),
    @NamedQuery(name = "TbPromotion.findByCPromotionTo", query = "SELECT t FROM TbPromotion t WHERE t.cPromotionTo = :cPromotionTo"),
    @NamedQuery(name = "TbPromotion.findByCDiscount", query = "SELECT t FROM TbPromotion t WHERE t.cDiscount = :cDiscount"),
    @NamedQuery(name = "TbPromotion.findByCIsActive", query = "SELECT t FROM TbPromotion t WHERE t.cIsActive = :cIsActive")})
public class TbPromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "c_PromotionFrom")
    private String cPromotionFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "c_PromotionTo")
    private String cPromotionTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Discount")
    private double cDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_IsActive")
    private boolean cIsActive;
    @JoinColumn(name = "c_Creator", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cCreator;
    @JoinColumn(name = "c_FieldId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbField cFieldId;

    public TbPromotion() {
    }

    public TbPromotion(Integer cId) {
        this.cId = cId;
    }

    public TbPromotion(Integer cId, String cPromotionFrom, String cPromotionTo, double cDiscount, boolean cIsActive) {
        this.cId = cId;
        this.cPromotionFrom = cPromotionFrom;
        this.cPromotionTo = cPromotionTo;
        this.cDiscount = cDiscount;
        this.cIsActive = cIsActive;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCPromotionFrom() {
        return cPromotionFrom;
    }

    public void setCPromotionFrom(String cPromotionFrom) {
        this.cPromotionFrom = cPromotionFrom;
    }

    public String getCPromotionTo() {
        return cPromotionTo;
    }

    public void setCPromotionTo(String cPromotionTo) {
        this.cPromotionTo = cPromotionTo;
    }

    public double getCDiscount() {
        return cDiscount;
    }

    public void setCDiscount(double cDiscount) {
        this.cDiscount = cDiscount;
    }

    public boolean getCIsActive() {
        return cIsActive;
    }

    public void setCIsActive(boolean cIsActive) {
        this.cIsActive = cIsActive;
    }

    public TbUser getCCreator() {
        return cCreator;
    }

    public void setCCreator(TbUser cCreator) {
        this.cCreator = cCreator;
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
        if (!(object instanceof TbPromotion)) {
            return false;
        }
        TbPromotion other = (TbPromotion) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbPromotion[ cId=" + cId + " ]";
    }
    
}
