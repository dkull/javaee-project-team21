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
import ee.itcollege.example.entities.Regiment;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@RooToString
@RooEntity
public class RegimentHierarchy extends BaseEntity implements Serializable {
private static final long serialVersionUID = 1L;


//@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
//private Long id;

	@Size(max=250)
	@NotNull
	private String comment;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date untilDate;
    
	@ManyToOne
	private Regiment regiment;

	@ManyToOne
	private Regiment subRegiment;

	
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

	public Regiment getRegiment() {
	    return regiment;
	}

	public void setRegiment(Regiment param) {
	    this.regiment = param;
	}
    
	public Regiment getSubRegiment() {
	    return subRegiment;
	}

	public void setSubRegiment(Regiment param) {
	    this.subRegiment = param;
	}    

}
