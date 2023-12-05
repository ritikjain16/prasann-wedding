package wedding.com.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import jakarta.validation.constraints.Size;

@Entity
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//
//	@Column(unique = true, nullable = false)
	private String sname;
//
//	@Column(nullable = false)
//	@Size(min = 3, max = 30)
	private String event;
//
//	@Size(max = 20)
	private double cost;

	private String location;

	private int capacity;

	private String cap_type;

	private String imgUrl;

	public Services() {
		super();
	}

	public Services(String sname, String event, double cost, String location, int capacity, String cap_type,
			String imgUrl) {
		super();
		this.sname = sname;
		this.event = event;
		this.cost = cost;
		this.location = location;
		this.capacity = capacity;
		this.cap_type = cap_type;
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCap_type() {
		return cap_type;
	}

	public void setCap_type(String cap_type) {
		this.cap_type = cap_type;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Services [id=" + id + ", sname=" + sname + ", event=" + event + ", cost=" + cost + ", location="
				+ location + ", capacity=" + capacity + "]";
	}

}
