package ee.itcollege.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.example.entities.AdminUnitType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@RooToString
@RooEntity
public class AdminUnitTypeHierarchy extends BaseEntity implements Serializable {
private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long id;

	@Size(max=250)
	@NotNull
	private String comment;
	
	@ManyToOne
	private AdminUnitType adminUnitType;

	@ManyToOne
	private AdminUnitType subAdminUnitType;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AdminUnitType getAdminUnitType() {
	    return adminUnitType;
	}

	public void setAdminUnitType(AdminUnitType param) {
	    this.adminUnitType = param;
	}
    
	public AdminUnitType getSubAdminUnitType() {
	    return subAdminUnitType;
	}

	public void setSubAdminUnitType(AdminUnitType param) {
	    this.subAdminUnitType = param;
	}
        

}
