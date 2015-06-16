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
@Table(name = "tb_Role", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRole.findAll", query = "SELECT t FROM TbRole t"),
    @NamedQuery(name = "TbRole.findByCId", query = "SELECT t FROM TbRole t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbRole.findByCRole", query = "SELECT t FROM TbRole t WHERE t.cRole = :cRole"),
    @NamedQuery(name = "TbRole.findByCDisplayName", query = "SELECT t FROM TbRole t WHERE t.cDisplayName = :cDisplayName")})
public class TbRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_Role")
    private String cRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "c_DisplayName")
    private String cDisplayName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRoleId")
    private List<TbUser> tbUserList;

    public TbRole() {
    }

    public TbRole(Integer cId) {
        this.cId = cId;
    }

    public TbRole(Integer cId, String cRole, String cDisplayName) {
        this.cId = cId;
        this.cRole = cRole;
        this.cDisplayName = cDisplayName;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCRole() {
        return cRole;
    }

    public void setCRole(String cRole) {
        this.cRole = cRole;
    }

    public String getCDisplayName() {
        return cDisplayName;
    }

    public void setCDisplayName(String cDisplayName) {
        this.cDisplayName = cDisplayName;
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
        if (!(object instanceof TbRole)) {
            return false;
        }
        TbRole other = (TbRole) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbRole[ cId=" + cId + " ]";
    }
    
}
