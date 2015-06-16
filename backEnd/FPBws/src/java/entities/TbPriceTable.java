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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_PriceTable", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPriceTable.findAll", query = "SELECT t FROM TbPriceTable t"),
    @NamedQuery(name = "TbPriceTable.findByCId", query = "SELECT t FROM TbPriceTable t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbPriceTable.findByCDay", query = "SELECT t FROM TbPriceTable t WHERE t.cDay = :cDay"),
    @NamedQuery(name = "TbPriceTable.findByCPrice", query = "SELECT t FROM TbPriceTable t WHERE t.cPrice = :cPrice")})
public class TbPriceTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Column(name = "c_Day")
    private Integer cDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Price")
    private double cPrice;
    @JoinColumn(name = "c_StadiumId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbStadium cStadiumId;
    @JoinColumn(name = "c_Slot", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbSlot cSlot;
    @JoinColumn(name = "c_FieldTypeId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbFieldType cFieldTypeId;

    public TbPriceTable() {
    }

    public TbPriceTable(Integer cId) {
        this.cId = cId;
    }

    public TbPriceTable(Integer cId, double cPrice) {
        this.cId = cId;
        this.cPrice = cPrice;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public Integer getCDay() {
        return cDay;
    }

    public void setCDay(Integer cDay) {
        this.cDay = cDay;
    }

    public double getCPrice() {
        return cPrice;
    }

    public void setCPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public TbStadium getCStadiumId() {
        return cStadiumId;
    }

    public void setCStadiumId(TbStadium cStadiumId) {
        this.cStadiumId = cStadiumId;
    }

    public TbSlot getCSlot() {
        return cSlot;
    }

    public void setCSlot(TbSlot cSlot) {
        this.cSlot = cSlot;
    }

    public TbFieldType getCFieldTypeId() {
        return cFieldTypeId;
    }

    public void setCFieldTypeId(TbFieldType cFieldTypeId) {
        this.cFieldTypeId = cFieldTypeId;
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
        if (!(object instanceof TbPriceTable)) {
            return false;
        }
        TbPriceTable other = (TbPriceTable) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbPriceTable[ cId=" + cId + " ]";
    }
    
}
