/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_StadiumReview", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStadiumReview.findAll", query = "SELECT t FROM TbStadiumReview t"),
    @NamedQuery(name = "TbStadiumReview.findByCId", query = "SELECT t FROM TbStadiumReview t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbStadiumReview.findByCReviewContent", query = "SELECT t FROM TbStadiumReview t WHERE t.cReviewContent = :cReviewContent"),
    @NamedQuery(name = "TbStadiumReview.findByCIsApproved", query = "SELECT t FROM TbStadiumReview t WHERE t.cIsApproved = :cIsApproved"),
    @NamedQuery(name = "TbStadiumReview.findByCCreateDate", query = "SELECT t FROM TbStadiumReview t WHERE t.cCreateDate = :cCreateDate")})
public class TbStadiumReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "c_ReviewContent")
    private String cReviewContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_IsApproved")
    private boolean cIsApproved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cCreateDate;
    @JoinColumn(name = "c_Approver", referencedColumnName = "c_Id")
    @ManyToOne
    private TbUser cApprover;
    @JoinColumn(name = "c_UserId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cUserId;
    @JoinColumn(name = "c_StadiumId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbStadium cStadiumId;

    public TbStadiumReview() {
    }

    public TbStadiumReview(Integer cId) {
        this.cId = cId;
    }

    public TbStadiumReview(Integer cId, String cReviewContent, boolean cIsApproved, Date cCreateDate) {
        this.cId = cId;
        this.cReviewContent = cReviewContent;
        this.cIsApproved = cIsApproved;
        this.cCreateDate = cCreateDate;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCReviewContent() {
        return cReviewContent;
    }

    public void setCReviewContent(String cReviewContent) {
        this.cReviewContent = cReviewContent;
    }

    public boolean getCIsApproved() {
        return cIsApproved;
    }

    public void setCIsApproved(boolean cIsApproved) {
        this.cIsApproved = cIsApproved;
    }

    public Date getCCreateDate() {
        return cCreateDate;
    }

    public void setCCreateDate(Date cCreateDate) {
        this.cCreateDate = cCreateDate;
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

    public TbStadium getCStadiumId() {
        return cStadiumId;
    }

    public void setCStadiumId(TbStadium cStadiumId) {
        this.cStadiumId = cStadiumId;
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
        if (!(object instanceof TbStadiumReview)) {
            return false;
        }
        TbStadiumReview other = (TbStadiumReview) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbStadiumReview[ cId=" + cId + " ]";
    }
    
}
