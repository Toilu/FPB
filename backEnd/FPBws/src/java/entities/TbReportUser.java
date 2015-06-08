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
@Table(name = "tb_ReportUser", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbReportUser.findAll", query = "SELECT t FROM TbReportUser t"),
    @NamedQuery(name = "TbReportUser.findByCId", query = "SELECT t FROM TbReportUser t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbReportUser.findByCReason", query = "SELECT t FROM TbReportUser t WHERE t.cReason = :cReason"),
    @NamedQuery(name = "TbReportUser.findByCDate", query = "SELECT t FROM TbReportUser t WHERE t.cDate = :cDate")})
public class TbReportUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Reason")
    private String cReason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "c_Date")
    private String cDate;
    @JoinColumn(name = "c_ReportUserId", referencedColumnName = "c_Id")
    @ManyToOne
    private TbUser cReportUserId;
    @JoinColumn(name = "c_UserId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cUserId;
    @JoinColumn(name = "c_Reference", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbReservation cReference;

    public TbReportUser() {
    }

    public TbReportUser(Integer cId) {
        this.cId = cId;
    }

    public TbReportUser(Integer cId, String cReason, String cDate) {
        this.cId = cId;
        this.cReason = cReason;
        this.cDate = cDate;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCReason() {
        return cReason;
    }

    public void setCReason(String cReason) {
        this.cReason = cReason;
    }

    public String getCDate() {
        return cDate;
    }

    public void setCDate(String cDate) {
        this.cDate = cDate;
    }

    public TbUser getCReportUserId() {
        return cReportUserId;
    }

    public void setCReportUserId(TbUser cReportUserId) {
        this.cReportUserId = cReportUserId;
    }

    public TbUser getCUserId() {
        return cUserId;
    }

    public void setCUserId(TbUser cUserId) {
        this.cUserId = cUserId;
    }

    public TbReservation getCReference() {
        return cReference;
    }

    public void setCReference(TbReservation cReference) {
        this.cReference = cReference;
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
        if (!(object instanceof TbReportUser)) {
            return false;
        }
        TbReportUser other = (TbReportUser) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbReportUser[ cId=" + cId + " ]";
    }
    
}
