package VO;

public class ProdVO {
   
	String prodId;
	String prodName;
	String prodLgu;
	String prodBuyer;
	int prodCost;
	int prodPrice;
	int  prodSale;
	String prodOutline;
	String prodDetail;
	
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdLgu() {
		return prodLgu;
	}
	public void setProdLgu(String prodLgu) {
		this.prodLgu = prodLgu;
	}
	public String getProdBuyer() {
		return prodBuyer;
	}
	public void setProdBuyer(String prodBuyer) {
		this.prodBuyer = prodBuyer;
	}
	public int getProdCost() {
		return prodCost;
	}
	public void setProdCost(int prodCost) {
		this.prodCost = prodCost;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdSale() {
		return prodSale;
	}
	public void setProdSale(int prodSale) {
		this.prodSale = prodSale;
	}
	public String getProdOutline() {
		return prodOutline;
	}
	public void setProdOutline(String prodOutline) {
		this.prodOutline = prodOutline;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	
	@Override
	public String toString() {
		return "ProdVO [prodId=" + prodId + ", prodName=" + prodName + ", prodLgu=" + prodLgu + ", prodBuyer="
				+ prodBuyer + ", prodCost=" + prodCost + ", prodPrice=" + prodPrice + ", prodSale=" + prodSale
				+ ", prodOutline=" + prodOutline + ", prodDetail=" + prodDetail + "]";
    }
	
}
