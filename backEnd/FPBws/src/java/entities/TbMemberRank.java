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
@Table(name = "tb_MemberRank", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMemberRank.findAll", query = "SELECT t FROM TbMemberRank t"),
    @NamedQuery(name = "TbMemberRank.findByCId", query = "SELECT t FROM TbMemberRank t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbMemberRank.findByCRankName", query = "SELECT t FROM TbMemberRank t WHERE t.cRankName = :cRankName"),
    @NamedQuery(name = "TbMemberRank.findByCPoint", query = "SELECT t FROM TbMemberRank t WHERE t.cPoint = :cPoint"),
    @NamedQuery(name = "TbMemberRank.findByCPromotion", query = "SELECT t FROM TbMemberRank t WHERE t.cPromotion = :cPromotion")})
public class TbMemberRank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Size(max = 50)
    @Column(name = "c_RankName")
    private String cRankName;
    @Column(name = "c_Point")
    private Integer cPoint;
    @Size(max = 500)
    @Column(name = "c_Promotion")
    private String cPromotion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRankId")
    private List<TbUser> tbUserList;

    public TbMemberRank() {
    }

    public TbMemberRank(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCRankName() {
        return cRankName;
    }

    public void setCRankName(String cRankName) {
        this.cRankName = cRankName;
    }

    public Integer getCPoint() {
        return cPoint;
    }

    public void setCPoint(Integer cPoint) {
        this.cPoint = cPoint;
    }

    public String getCPromotion() {
        return cPromotion;
    }

    public void setCPromotion(String cPromotion) {
        this.cPromotion = cPromotion;
    }

    @XmlTransient
    public List<TbUser> getTbUserList() {
        return tbUserList;
    }

    public void setTbUserList(List<TbUser> tbUserList) {
        this.tbUserList = tbUserList;
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
        if (!(object instanceof TbMemberRank)) {
            return false;
        }
        TbMemberRank other = (TbMemberRank) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbMemberRank[ cId=" + cId + " ]";
    }
    
}
