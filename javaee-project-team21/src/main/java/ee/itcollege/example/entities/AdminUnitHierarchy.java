package ee.itcollege.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooToString
@RooEntity
public class AdminUnitHierarchy extends BaseEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long id;

	@Size(max=250)
	@NotNull
	private String comment;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="d.MM.yyyy")
    private Date fromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="d.MM.yyyy")
    private Date untilDate;
	
	@ManyToOne
	private AdminUnit adminUnit;

	@ManyToOne
	private AdminUnit subUnit;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(Date untilDate) {
		this.untilDate = untilDate;
	}

	public AdminUnit getAdminUnit() {
	    return adminUnit;
	}

	public void setAdminUnit(AdminUnit param) {
	    this.adminUnit = param;
	}

	public AdminUnit getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(AdminUnit subUnit) {
		this.subUnit = subUnit;
	}
    
    

}
