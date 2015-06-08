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
@Table(name = "tb_FieldPrice", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFieldPrice.findAll", query = "SELECT t FROM TbFieldPrice t"),
    @NamedQuery(name = "TbFieldPrice.findByCId", query = "SELECT t FROM TbFieldPrice t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbFieldPrice.findByCFieldPriceName", query = "SELECT t FROM TbFieldPrice t WHERE t.cFieldPriceName = :cFieldPriceName"),
    @NamedQuery(name = "TbFieldPrice.findByCFieldPriceDescription", query = "SELECT t FROM TbFieldPrice t WHERE t.cFieldPriceDescription = :cFieldPriceDescription")})
public class TbFieldPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_FieldPriceName")
    private String cFieldPriceName;
    @Size(max = 200)
    @Column(name = "c_FieldPriceDescription")
    private String cFieldPriceDescription;
    @JoinColumn(name = "c_StadiumId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbStadium cStadiumId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cPriceId")
    private List<TbField> tbFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFieldPriceId")
    private List<TbPriceTable> tbPriceTableList;

    public TbFieldPrice() {
    }

    public TbFieldPrice(Integer cId) {
        this.cId = cId;
    }

    public TbFieldPrice(Integer cId, String cFieldPriceName) {
        this.cId = cId;
        this.cFieldPriceName = cFieldPriceName;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCFieldPriceName() {
        return cFieldPriceName;
    }

    public void setCFieldPriceName(String cFieldPriceName) {
        this.cFieldPriceName = cFieldPriceName;
    }

    public String getCFieldPriceDescription() {
        return cFieldPriceDescription;
    }

    public void setCFieldPriceDescription(String cFieldPriceDescription) {
        this.cFieldPriceDescription = cFieldPriceDescription;
    }

    public TbStadium getCStadiumId() {
        return cStadiumId;
    }

    public void setCStadiumId(TbStadium cStadiumId) {
        this.cStadiumId = cStadiumId;
    }

    @XmlTransient
    public List<TbField> getTbFieldList() {
        return tbFieldList;
    }

    public void setTbFieldList(List<TbField> tbFieldList) {
        this.tbFieldList = tbFieldList;
    }

    @XmlTransient
    public List<TbPriceTable> getTbPriceTableList() {
        return tbPriceTableList;
    }

    public void setTbPriceTableList(List<TbPriceTable> tbPriceTableList) {
        this.tbPriceTableList = tbPriceTableList;
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
        if (!(object instanceof TbFieldPrice)) {
            return false;
        }
        TbFieldPrice other = (TbFieldPrice) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbFieldPrice[ cId=" + cId + " ]";
    }
    
}
