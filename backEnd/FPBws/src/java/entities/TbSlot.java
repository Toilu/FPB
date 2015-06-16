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
@Table(name = "tb_Slot", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSlot.findAll", query = "SELECT t FROM TbSlot t"),
    @NamedQuery(name = "TbSlot.findByCId", query = "SELECT t FROM TbSlot t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbSlot.findByCSlot", query = "SELECT t FROM TbSlot t WHERE t.cSlot = :cSlot"),
    @NamedQuery(name = "TbSlot.findByCDescription", query = "SELECT t FROM TbSlot t WHERE t.cDescription = :cDescription")})
public class TbSlot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Slot")
    private int cSlot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "c_Description")
    private String cDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cSlot")
    private List<TbPriceTable> tbPriceTableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cSlotId")
    private List<TbReservation> tbReservationList;

    public TbSlot() {
    }

    public TbSlot(Integer cId) {
        this.cId = cId;
    }

    public TbSlot(Integer cId, int cSlot, String cDescription) {
        this.cId = cId;
        this.cSlot = cSlot;
        this.cDescription = cDescription;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public int getCSlot() {
        return cSlot;
    }

    public void setCSlot(int cSlot) {
        this.cSlot = cSlot;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    @XmlTransient
    public List<TbPriceTable> getTbPriceTableList() {
        return tbPriceTableList;
    }

    public void setTbPriceTableList(List<TbPriceTable> tbPriceTableList) {
        this.tbPriceTableList = tbPriceTableList;
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
        if (!(object instanceof TbSlot)) {
            return false;
        }
        TbSlot other = (TbSlot) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbSlot[ cId=" + cId + " ]";
    }
    
}
