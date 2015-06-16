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
@Table(name = "tb_Reservation", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbReservation.findAll", query = "SELECT t FROM TbReservation t"),
    @NamedQuery(name = "TbReservation.findByCId", query = "SELECT t FROM TbReservation t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbReservation.findByCFullName", query = "SELECT t FROM TbReservation t WHERE t.cFullName = :cFullName"),
    @NamedQuery(name = "TbReservation.findByCPhoneNumber", query = "SELECT t FROM TbReservation t WHERE t.cPhoneNumber = :cPhoneNumber"),
    @NamedQuery(name = "TbReservation.findByCEmail", query = "SELECT t FROM TbReservation t WHERE t.cEmail = :cEmail"),
    @NamedQuery(name = "TbReservation.findByCDate", query = "SELECT t FROM TbReservation t WHERE t.cDate = :cDate"),
    @NamedQuery(name = "TbReservation.findByCPrice", query = "SELECT t FROM TbReservation t WHERE t.cPrice = :cPrice"),
    @NamedQuery(name = "TbReservation.findByCVerifyCode", query = "SELECT t FROM TbReservation t WHERE t.cVerifyCode = :cVerifyCode"),
    @NamedQuery(name = "TbReservation.findByCCreatedDate", query = "SELECT t FROM TbReservation t WHERE t.cCreatedDate = :cCreatedDate")})
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
    @Column(name = "c_Price")
    private double cPrice;
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
    @JoinColumn(name = "c_SlotId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbSlot cSlotId;
    @JoinColumn(name = "c_FieldId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbField cFieldId;

    public TbReservation() {
    }

    public TbReservation(Integer cId) {
        this.cId = cId;
    }

    public TbReservation(Integer cId, String cFullName, String cPhoneNumber, String cDate, double cPrice, String cVerifyCode, Date cCreatedDate) {
        this.cId = cId;
        this.cFullName = cFullName;
        this.cPhoneNumber = cPhoneNumber;
        this.cDate = cDate;
        this.cPrice = cPrice;
        this.cVerifyCode = cVerifyCode;
        this.cCreatedDate = cCreatedDate;
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

    public double getCPrice() {
        return cPrice;
    }

    public void setCPrice(double cPrice) {
        this.cPrice = cPrice;
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

    public TbSlot getCSlotId() {
        return cSlotId;
    }

    public void setCSlotId(TbSlot cSlotId) {
        this.cSlotId = cSlotId;
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
