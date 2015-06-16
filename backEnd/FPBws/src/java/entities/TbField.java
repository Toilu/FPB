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
@Table(name = "tb_Field", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbField.findAll", query = "SELECT t FROM TbField t"),
    @NamedQuery(name = "TbField.findByCId", query = "SELECT t FROM TbField t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbField.findByCNumber", query = "SELECT t FROM TbField t WHERE t.cNumber = :cNumber"),
    @NamedQuery(name = "TbField.findByCIsActive", query = "SELECT t FROM TbField t WHERE t.cIsActive = :cIsActive")})
public class TbField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "c_Number")
    private String cNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_IsActive")
    private boolean cIsActive;
    @JoinColumn(name = "c_StadiumId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbStadium cStadiumId;
    @JoinColumn(name = "c_FieldTypeId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbFieldType cFieldTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFieldId")
    private List<TbReservation> tbReservationList;

    public TbField() {
    }

    public TbField(Integer cId) {
        this.cId = cId;
    }

    public TbField(Integer cId, String cNumber, boolean cIsActive) {
        this.cId = cId;
        this.cNumber = cNumber;
        this.cIsActive = cIsActive;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCNumber() {
        return cNumber;
    }

    public void setCNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public boolean getCIsActive() {
        return cIsActive;
    }

    public void setCIsActive(boolean cIsActive) {
        this.cIsActive = cIsActive;
    }

    public TbStadium getCStadiumId() {
        return cStadiumId;
    }

    public void setCStadiumId(TbStadium cStadiumId) {
        this.cStadiumId = cStadiumId;
    }

    public TbFieldType getCFieldTypeId() {
        return cFieldTypeId;
    }

    public void setCFieldTypeId(TbFieldType cFieldTypeId) {
        this.cFieldTypeId = cFieldTypeId;
    }

    @XmlTransient
    public List<TbReservation> getTbReservationList() {
        return tbReservationList;
    }

    public void setTbReservationList(List<TbReservation> tbReservationList) {
        this.tbReservationList = tbReservationList;
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
        if (!(object instanceof TbField)) {
            return false;
        }
        TbField other = (TbField) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbField[ cId=" + cId + " ]";
    }
    
}
