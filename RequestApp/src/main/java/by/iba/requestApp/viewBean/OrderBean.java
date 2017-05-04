package by.iba.requestApp.viewBean;

import javax.persistence.Column;
import javax.persistence.Id;

public class OrderBean {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")	
	private int id;
		
	@Column(name="product_id")
	private int product;
	
	@Column(name="product_id")
	private int name;
	
	@Column(name="product_type")
	private int productType;
	
	@Column(name="count")
	private int count;
	
	@Column(name="price")
	private int price;
}
