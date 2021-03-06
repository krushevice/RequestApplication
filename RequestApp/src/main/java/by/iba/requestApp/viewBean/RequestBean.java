package by.iba.requestApp.viewBean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class RequestBean {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")	
	private int id;
	
	@Column(name="product_id")
	@NotNull(message = "Please select a product")
	private int product;
	
	@Column(name="product_type")
	@NotNull(message = "Please select a product type")
	private int productType;
	
	@Column(name="count")
	private int count;

	@Column(name="price")
	private int price;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="status")
	private int status;
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;// = new Date();
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}		
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "RequestBean [id=" + id + ", product=" + product + ", productType=" + productType + ", count=" + count
				+ ", price=" + price + ", userId=" + userId + ", status=" + status + ", date=" + date + "]";
	}	

}
