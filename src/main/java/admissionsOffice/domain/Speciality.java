package ua.lviv.lgs.admissionsOffice.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "speciality")
public class Speciality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "speciality_id")
	private Integer id;
	@Column
	@NotBlank(message = "Название специальности не может быть пустым!")
	private String title;
	@Column
	@NotNull(message = "План набора не может быть пустым!")
	@Min(value = 1, message = "План набора не может быть равен нулю!")
	private Integer enrollmentPlan;
	@Column
	private boolean recruitmentCompleted;

	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "speciality")
	@Column(nullable = false)
	private Set<Application> applications;

	
	public Speciality() {	}

	public Speciality(String title, Integer enrollmentPlan) {
		this.title = title;
		this.enrollmentPlan = enrollmentPlan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEnrollmentPlan() {
		return enrollmentPlan;
	}

	public void setEnrollmentPlan(Integer enrollmentPlan) {
		this.enrollmentPlan = enrollmentPlan;
	}

	public boolean isRecruitmentCompleted() {
		return recruitmentCompleted;
	}

	public void setRecruitmentCompleted(boolean recruitmentCompleted) {
		this.recruitmentCompleted = recruitmentCompleted;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((enrollmentPlan == null) ? 0 : enrollmentPlan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speciality other = (Speciality) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (enrollmentPlan == null) {
			if (other.enrollmentPlan != null)
				return false;
		} else if (!enrollmentPlan.equals(other.enrollmentPlan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Speciality [id=" + id + ", title=" + title + ", enrollmentPlan=" + enrollmentPlan + "]";
	}
}
