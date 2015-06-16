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
@Table(name = "tb_District", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDistrict.findAll", query = "SELECT t FROM TbDistrict t"),
    @NamedQuery(name = "TbDistrict.findByCId", query = "SELECT t FROM TbDistrict t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbDistrict.findByCDistrict", query = "SELECT t FROM TbDistrict t WHERE t.cDistrict = :cDistrict")})
public class TbDistrict implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_District")
    private String cDistrict;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDistrictId")
    private List<TbStadium> tbStadiumList;

    public TbDistrict() {
    }

    public TbDistrict(Integer cId) {
        this.cId = cId;
    }

    public TbDistrict(Integer cId, String cDistrict) {
        this.cId = cId;
        this.cDistrict = cDistrict;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCDistrict() {
        return cDistrict;
    }

    public void setCDistrict(String cDistrict) {
        this.cDistrict = cDistrict;
    }

    @XmlTransient
    public List<TbStadium> getTbStadiumList() {
        return tbStadiumList;
    }

    public void setTbStadiumList(List<TbStadium> tbStadiumList) {
        this.tbStadiumList = tbStadiumList;
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
        if (!(object instanceof TbDistrict)) {
            return false;
        }
        TbDistrict other = (TbDistrict) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbDistrict[ cId=" + cId + " ]";
    }
    
}
