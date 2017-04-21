package by.iba.requestApp.viewBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class RequestBean {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")	
	private int id;
	
	@Column(name="product")
	private int product;
	
	@Column(name="productType")
	private int productType;
	
	@Column(name="count")
	private int count;
	
	@Column(name="price")
	private int price;
	
	
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
				+ ", price=" + price + "]";
	}	

}
