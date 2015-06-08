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
@Table(name = "tb_PunishMember", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPunishMember.findAll", query = "SELECT t FROM TbPunishMember t"),
    @NamedQuery(name = "TbPunishMember.findByCId", query = "SELECT t FROM TbPunishMember t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbPunishMember.findByCReason", query = "SELECT t FROM TbPunishMember t WHERE t.cReason = :cReason"),
    @NamedQuery(name = "TbPunishMember.findByCDate", query = "SELECT t FROM TbPunishMember t WHERE t.cDate = :cDate"),
    @NamedQuery(name = "TbPunishMember.findByCExpiredDate", query = "SELECT t FROM TbPunishMember t WHERE t.cExpiredDate = :cExpiredDate"),
    @NamedQuery(name = "TbPunishMember.findByCIsForever", query = "SELECT t FROM TbPunishMember t WHERE t.cIsForever = :cIsForever")})
public class TbPunishMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_Reason")
    private String cReason;
    @Column(name = "c_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cDate;
    @Column(name = "c_ExpiredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cExpiredDate;
    @Column(name = "c_IsForever")
    private Boolean cIsForever;
    @JoinColumn(name = "c_StaffId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cStaffId;
    @JoinColumn(name = "c_UserId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cUserId;

    public TbPunishMember() {
    }

    public TbPunishMember(Integer cId) {
        this.cId = cId;
    }

    public TbPunishMember(Integer cId, String cReason) {
        this.cId = cId;
        this.cReason = cReason;
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

    public Date getCDate() {
        return cDate;
    }

    public void setCDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getCExpiredDate() {
        return cExpiredDate;
    }

    public void setCExpiredDate(Date cExpiredDate) {
        this.cExpiredDate = cExpiredDate;
    }

    public Boolean getCIsForever() {
        return cIsForever;
    }

    public void setCIsForever(Boolean cIsForever) {
        this.cIsForever = cIsForever;
    }

    public TbUser getCStaffId() {
        return cStaffId;
    }

    public void setCStaffId(TbUser cStaffId) {
        this.cStaffId = cStaffId;
    }

    public TbUser getCUserId() {
        return cUserId;
    }

    public void setCUserId(TbUser cUserId) {
        this.cUserId = cUserId;
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
        if (!(object instanceof TbPunishMember)) {
            return false;
        }
        TbPunishMember other = (TbPunishMember) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbPunishMember[ cId=" + cId + " ]";
    }
    
}
