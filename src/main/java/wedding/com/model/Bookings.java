package wedding.com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "booking_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date booking_date;
	
	private List<Integer> services = new ArrayList<Integer>();
	
	private double totalPrice;
	
	private String status;
	
	private String location;
	
	private String brideName;
	
	private String groomName;
	
	private int brideAge;
	
	private int groomAge;
	
	private String mobile;
	
	private String address;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinColumn(name = "user_id")
//	private Set<ServiceID> serviceIDs = new HashSet<>();

	
	
	public Bookings(Date booking_date, List<Integer> services, double totalPrice, String status, String location,
			String brideName, String groomName, int brideAge, int groomAge, String mobile, String address) {
		super();
		this.booking_date = booking_date;
		this.services = services;
		this.totalPrice = totalPrice;
		this.status = status;
		this.location = location;
		this.brideName = brideName;
		this.groomName = groomName;
		this.brideAge = brideAge;
		this.groomAge = groomAge;
		this.mobile = mobile;
		this.address = address;
	}

	public Bookings() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public List<Integer> getServices() {
		return services;
	}

	public void setServices(List<Integer> services) {
		this.services = services;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBrideName() {
		return brideName;
	}

	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}

	public String getGroomName() {
		return groomName;
	}

	public void setGroomName(String groomName) {
		this.groomName = groomName;
	}

	public int getBrideAge() {
		return brideAge;
	}

	public void setBrideAge(int brideAge) {
		this.brideAge = brideAge;
	}

	public int getGroomAge() {
		return groomAge;
	}

	public void setGroomAge(int groomAge) {
		this.groomAge = groomAge;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

//	public void setAddress(String address) {
//		this.address = address;
//	}
//	
//	public Set<ServiceID> getServiceIDs() {
//		return serviceIDs;
//	}
//
//	public void setServiceIDs(Set<ServiceID> serviceIDs) {
//		this.serviceIDs = serviceIDs;
//	}
//	
//	public void removeSeviceIds() {
//		this.serviceIDs.clear();
//	}

	@Override
	public String toString() {
		return "Bookings [id=" + id + ", booking_date=" + booking_date + ", services=" + services + ", totalPrice="
				+ totalPrice + ", status=" + status + ", location=" + location + ", brideName=" + brideName
				+ ", groomName=" + groomName + ", brideAge=" + brideAge + ", groomAge=" + groomAge + ", mobile="
				+ mobile + ", address=" + address + "]";
	}
	
	
	
	
	
	
}
