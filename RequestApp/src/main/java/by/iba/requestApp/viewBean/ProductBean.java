package by.iba.requestApp.viewBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductBean {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")	
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private int productPrice;
	
	@Column(name="product_types")
	private int productTypes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + ", productTypes=" + productTypes + "]";
	}

}
