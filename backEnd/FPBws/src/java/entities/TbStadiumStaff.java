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
@Table(name = "tb_StadiumStaff", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStadiumStaff.findAll", query = "SELECT t FROM TbStadiumStaff t"),
    @NamedQuery(name = "TbStadiumStaff.findByCId", query = "SELECT t FROM TbStadiumStaff t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbStadiumStaff.findByCIsOwner", query = "SELECT t FROM TbStadiumStaff t WHERE t.cIsOwner = :cIsOwner")})
public class TbStadiumStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_IsOwner")
    private boolean cIsOwner;
    @JoinColumn(name = "c_UserId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbUser cUserId;
    @JoinColumn(name = "c_StadiumId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbStadium cStadiumId;

    public TbStadiumStaff() {
    }

    public TbStadiumStaff(Integer cId) {
        this.cId = cId;
    }

    public TbStadiumStaff(Integer cId, boolean cIsOwner) {
        this.cId = cId;
        this.cIsOwner = cIsOwner;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public boolean getCIsOwner() {
        return cIsOwner;
    }

    public void setCIsOwner(boolean cIsOwner) {
        this.cIsOwner = cIsOwner;
    }

    public TbUser getCUserId() {
        return cUserId;
    }

    public void setCUserId(TbUser cUserId) {
        this.cUserId = cUserId;
    }

    public TbStadium getCStadiumId() {
        return cStadiumId;
    }

    public void setCStadiumId(TbStadium cStadiumId) {
        this.cStadiumId = cStadiumId;
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
        if (!(object instanceof TbStadiumStaff)) {
            return false;
        }
        TbStadiumStaff other = (TbStadiumStaff) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbStadiumStaff[ cId=" + cId + " ]";
    }
    
}
