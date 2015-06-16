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
@Table(name = "tb_FieldType", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFieldType.findAll", query = "SELECT t FROM TbFieldType t"),
    @NamedQuery(name = "TbFieldType.findByCId", query = "SELECT t FROM TbFieldType t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbFieldType.findByCFieldType", query = "SELECT t FROM TbFieldType t WHERE t.cFieldType = :cFieldType"),
    @NamedQuery(name = "TbFieldType.findByCDescription", query = "SELECT t FROM TbFieldType t WHERE t.cDescription = :cDescription")})
public class TbFieldType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Column(name = "c_FieldType")
    private Integer cFieldType;
    @Size(max = 50)
    @Column(name = "c_Description")
    private String cDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFieldTypeId")
    private List<TbField> tbFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFieldTypeId")
    private List<TbPriceTable> tbPriceTableList;

    public TbFieldType() {
    }

    public TbFieldType(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public Integer getCFieldType() {
        return cFieldType;
    }

    public void setCFieldType(Integer cFieldType) {
        this.cFieldType = cFieldType;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
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
        if (!(object instanceof TbFieldType)) {
            return false;
        }
        TbFieldType other = (TbFieldType) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbFieldType[ cId=" + cId + " ]";
    }
    
}
