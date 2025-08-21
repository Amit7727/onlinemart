package orderservice.entity;

import jakarta.persistence.*;
@Entity
@Table(name="orders")
public class Order {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private Long userId;
  private String productId;
  private Integer quantity;
  private Double total;
  public Long getId() {
	return id;
  }
  public void setId(Long id) {
	this.id = id;
  }
  public Long getUserId() {
	return userId;
  }
  public void setUserId(Long userId) {
	this.userId = userId;
  }
  public String getProductId() {
	return productId;
  }
  public void setProductId(String productId) {
	this.productId = productId;
  }
  public Integer getQuantity() {
	return quantity;
  }
  public void setQuantity(Integer quantity) {
	this.quantity = quantity;
  }
  public Double getTotal() {
	return total;
  }
  public void setTotal(Double total) {
	this.total = total;
  }
  
  
}
