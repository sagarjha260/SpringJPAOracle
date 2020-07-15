package SpringJPAORACLE.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import SpringJPAORACLE.Converter.ApplicationMetaDataConverter;

@Entity
@Table(name = "CovidData")
public class CovidData 
{	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COVID_SEQ")
	 * 
	 * @SequenceGenerator(sequenceName = "CovidData_seq", allocationSize = 1, name =
	 * "COVID_SEQ") private long id;
	 */
	
	@Id
	private long id;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Convert(converter=ApplicationMetaDataConverter.class)
	@Column(name = "covidResult")
	private CovidResult covidResult;
	
	public long getId() {
		return id;
	} 
	public void setId(long id) { 
		this.id= id; 
	}
	 
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public CovidResult getCovidResult() {
		return covidResult;
	}
	public void setCovidResult(CovidResult covidResult) {
		this.covidResult = covidResult;
	}

}
