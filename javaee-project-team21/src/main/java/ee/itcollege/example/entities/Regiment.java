package ee.itcollege.example.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.example.entities.AdminUnit;
import javax.persistence.ManyToOne;
import ee.itcollege.example.entities.RegimentHierarchy;
import java.util.Collection;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@RooToString
@RooEntity

public class Regiment extends BaseEntity implements Serializable {
private static final long serialVersionUID = 1L;
//public class Regiment {
	
//	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long id;

	@Size(min=2, max=30)
	@NotNull
	private String name;
    
	@NotNull
	private String code;

	@Size(max=250)
    private String comment;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date untilDate;
    
    private String changedBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date changedDate;
    
    private String closedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date closedDate = GeneralFunctions.notDeleted;
	
	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	
	@ManyToOne
	private AdminUnit adminUnit;

	@OneToMany(mappedBy = "regiment")
	private Collection<RegimentHierarchy> regimentHierarchys;

	@OneToMany(mappedBy = "subRegiment")
	private Collection<RegimentHierarchy> subRegimentHierarchys;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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
	
	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	public String getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	
	@Transactional
	public void remove() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		setClosedBy(auth.getName());
		setClosedDate(new Date());
	}

	public AdminUnit getAdminUnit() {
	    return adminUnit;
	}

	public void setAdminUnit(AdminUnit param) {
	    this.adminUnit = param;
	}

	public Collection<RegimentHierarchy> getRegimentHierarchys() {
	    return regimentHierarchys;
	}

	public void setRegimentHierarchys(Collection<RegimentHierarchy> param) {
	    this.regimentHierarchys = param;
	}
	
	public Collection<RegimentHierarchy> getSubRegimentHierarchys() {
	    return subRegimentHierarchys;
	}

	public void setSubRegimentHierarchys(Collection<RegimentHierarchy> param) {
	    this.subRegimentHierarchys = param;
	}
	
    public static long countRegiments() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Regiment o WHERE closedDate > curtime()", Long.class).getSingleResult();
    }
    
    public static List<Regiment> findAllRegiments() {
        return entityManager().createQuery("SELECT o FROM Regiment o WHERE closedDate > curtime()", Regiment.class).getResultList();
    }
    
    public static List<Regiment> findRegimentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Regiment o WHERE closedDate > curtime()", Regiment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
