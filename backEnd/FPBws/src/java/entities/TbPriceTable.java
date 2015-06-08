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
    @NamedQuery(name = "TbPriceTable.findByCTimeFrom", query = "SELECT t FROM TbPriceTable t WHERE t.cTimeFrom = :cTimeFrom"),
    @NamedQuery(name = "TbPriceTable.findByCTimeTo", query = "SELECT t FROM TbPriceTable t WHERE t.cTimeTo = :cTimeTo"),
    @NamedQuery(name = "TbPriceTable.findByCPrice", query = "SELECT t FROM TbPriceTable t WHERE t.cPrice = :cPrice")})
public class TbPriceTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Day")
    private int cDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_TimeFrom")
    private double cTimeFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_TimeTo")
    private double cTimeTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Price")
    private double cPrice;
    @JoinColumn(name = "c_FieldPriceId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbFieldPrice cFieldPriceId;

    public TbPriceTable() {
    }

    public TbPriceTable(Integer cId) {
        this.cId = cId;
    }

    public TbPriceTable(Integer cId, int cDay, double cTimeFrom, double cTimeTo, double cPrice) {
        this.cId = cId;
        this.cDay = cDay;
        this.cTimeFrom = cTimeFrom;
        this.cTimeTo = cTimeTo;
        this.cPrice = cPrice;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public int getCDay() {
        return cDay;
    }

    public void setCDay(int cDay) {
        this.cDay = cDay;
    }

    public double getCTimeFrom() {
        return cTimeFrom;
    }

    public void setCTimeFrom(double cTimeFrom) {
        this.cTimeFrom = cTimeFrom;
    }

    public double getCTimeTo() {
        return cTimeTo;
    }

    public void setCTimeTo(double cTimeTo) {
        this.cTimeTo = cTimeTo;
    }

    public double getCPrice() {
        return cPrice;
    }

    public void setCPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public TbFieldPrice getCFieldPriceId() {
        return cFieldPriceId;
    }

    public void setCFieldPriceId(TbFieldPrice cFieldPriceId) {
        this.cFieldPriceId = cFieldPriceId;
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
