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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_StadiumImage", catalog = "FPB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStadiumImage.findAll", query = "SELECT t FROM TbStadiumImage t"),
    @NamedQuery(name = "TbStadiumImage.findByCId", query = "SELECT t FROM TbStadiumImage t WHERE t.cId = :cId"),
    @NamedQuery(name = "TbStadiumImage.findByCPath", query = "SELECT t FROM TbStadiumImage t WHERE t.cPath = :cPath"),
    @NamedQuery(name = "TbStadiumImage.findByCTitle", query = "SELECT t FROM TbStadiumImage t WHERE t.cTitle = :cTitle"),
    @NamedQuery(name = "TbStadiumImage.findByCCaption", query = "SELECT t FROM TbStadiumImage t WHERE t.cCaption = :cCaption")})
public class TbStadiumImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_Id")
    private Integer cId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_Path")
    private String cPath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_Title")
    private String cTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_Caption")
    private String cCaption;
    @JoinColumn(name = "c_StadiumId", referencedColumnName = "c_Id")
    @ManyToOne(optional = false)
    private TbStadium cStadiumId;

    public TbStadiumImage() {
    }

    public TbStadiumImage(Integer cId) {
        this.cId = cId;
    }

    public TbStadiumImage(Integer cId, String cPath, String cTitle, String cCaption) {
        this.cId = cId;
        this.cPath = cPath;
        this.cTitle = cTitle;
        this.cCaption = cCaption;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCPath() {
        return cPath;
    }

    public void setCPath(String cPath) {
        this.cPath = cPath;
    }

    public String getCTitle() {
        return cTitle;
    }

    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getCCaption() {
        return cCaption;
    }

    public void setCCaption(String cCaption) {
        this.cCaption = cCaption;
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
        if (!(object instanceof TbStadiumImage)) {
            return false;
        }
        TbStadiumImage other = (TbStadiumImage) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TbStadiumImage[ cId=" + cId + " ]";
    }
    
}
