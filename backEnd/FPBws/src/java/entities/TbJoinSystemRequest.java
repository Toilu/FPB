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
@Table(name = "tb_JoinSystemRequest", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbJoinSystemRequest.findAll", query = "SELECT t FROM TbJoinSystemRequest t"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCId", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCFullName", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cFullName = :cFullName"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCAddress", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cAddress = :cAddress"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCPhone", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cPhone = :cPhone"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCEmail", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cEmail = :cEmail"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCStadiumName", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cStadiumName = :cStadiumName"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCStadiumAddress", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cStadiumAddress = :cStadiumAddress"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCNote", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cNote = :cNote"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCStatus", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cStatus = :cStatus"),
    @NamedQuery(name = "TbJoinSystemRequest.findByCCreateDate", query = "SELECT t FROM TbJoinSystemRequest t WHERE t.cCreateDate = :cCreateDate")})
public class TbJoinSystemRequest implements Serializable {
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
    @Size(min = 1, max = 100)
    @Column(name = "c_Address")
    private String cAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_Phone")
    private String cPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Email")
    private String cEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_StadiumName")
    private String cStadiumName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_StadiumAddress")
    private String cStadiumAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "c_Note")
    private String cNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Status")
    private String cStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cCreateDate;
    @JoinColumn(name = "c_UserId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cUserId;

    public TbJoinSystemRequest() {
    }

    public TbJoinSystemRequest(Integer cId) {
        this.cId = cId;
    }

    public TbJoinSystemRequest(Integer cId, String cFullName, String cAddress, String cPhone, String cEmail, String cStadiumName, String cStadiumAddress, String cNote, String cStatus, Date cCreateDate) {
        this.cId = cId;
        this.cFullName = cFullName;
        this.cAddress = cAddress;
        this.cPhone = cPhone;
        this.cEmail = cEmail;
        this.cStadiumName = cStadiumName;
        this.cStadiumAddress = cStadiumAddress;
        this.cNote = cNote;
        this.cStatus = cStatus;
        this.cCreateDate = cCreateDate;
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

    public String getCStadiumName() {
        return cStadiumName;
    }

    public void setCStadiumName(String cStadiumName) {
        this.cStadiumName = cStadiumName;
    }

    public String getCStadiumAddress() {
        return cStadiumAddress;
    }

    public void setCStadiumAddress(String cStadiumAddress) {
        this.cStadiumAddress = cStadiumAddress;
    }

    public String getCNote() {
        return cNote;
    }

    public void setCNote(String cNote) {
        this.cNote = cNote;
    }

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public Date getCCreateDate() {
        return cCreateDate;
    }

    public void setCCreateDate(Date cCreateDate) {
        this.cCreateDate = cCreateDate;
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
        if (!(object instanceof TbJoinSystemRequest)) {
            return false;
        }
        TbJoinSystemRequest other = (TbJoinSystemRequest) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbJoinSystemRequest[ cId=" + cId + " ]";
    }
    
}
