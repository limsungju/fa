package kr.co.itcen.fa.vo.menu08;

import org.apache.ibatis.type.Alias;

@Alias("building08vo")
public class BuildingVo {

	private String id;
	private String customerNo;
	private String customerName;
	private String managerName;
	private String taxbillNo;
	private Long voucherNo;
	private String sectionNo;
	private String sectionName;
	private Long area;
	private String combineNo;
	private String ownerName;
	private String wideAddress;
	private String cityAddress;
	private String detailAddress;
	private Long floor;
	private Long basement;
	private String purpose;
	private String material;
	private String publicValue;
	private String acqPrice;
	private String etcCost;
	private String acqTax;
	private String payDate;
	private String taxKind;
	private String flag;
	private String insertUserid;
	private String insertDay;
	private String updateUserid;
	private String updateDay;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getTaxbillNo() {
		return taxbillNo;
	}
	public void setTaxbillNo(String taxbillNo) {
		this.taxbillNo = taxbillNo;
	}
	public Long getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(Long voucherNo) {
		this.voucherNo = voucherNo;
	}
	public String getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Long getArea() {
		return area;
	}
	public void setArea(Long area) {
		this.area = area;
	}
	public String getCombineNo() {
		return combineNo;
	}
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getWideAddress() {
		return wideAddress;
	}
	public void setWideAddress(String wideAddress) {
		this.wideAddress = wideAddress;
	}
	public String getCityAddress() {
		return cityAddress;
	}
	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public Long getFloor() {
		return floor;
	}
	public void setFloor(Long floor) {
		this.floor = floor;
	}
	public Long getBasement() {
		return basement;
	}
	public void setBasement(Long basement) {
		this.basement = basement;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getPublicValue() {
		return publicValue;
	}
	public void setPublicValue(String publicValue) {
		this.publicValue = publicValue;
	}
	public String getAcqPrice() {
		return acqPrice;
	}
	public void setAcqPrice(String acqPrice) {
		this.acqPrice = acqPrice;
	}
	public String getEtcCost() {
		return etcCost;
	}
	public void setEtcCost(String etcCost) {
		this.etcCost = etcCost;
	}
	public String getAcqTax() {
		return acqTax;
	}
	public void setAcqTax(String acqTax) {
		this.acqTax = acqTax;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getTaxKind() {
		return taxKind;
	}
	public void setTaxKind(String taxKind) {
		this.taxKind = taxKind;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getInsertUserid() {
		return insertUserid;
	}
	public void setInsertUserid(String insertUserid) {
		this.insertUserid = insertUserid;
	}
	public String getInsertDay() {
		return insertDay;
	}
	public void setInsertDay(String insertDay) {
		this.insertDay = insertDay;
	}
	public String getUpdateUserid() {
		return updateUserid;
	}
	public void setUpdateUserid(String updateUserid) {
		this.updateUserid = updateUserid;
	}
	public String getUpdateDay() {
		return updateDay;
	}
	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}
	@Override
	public String toString() {
		return "BuildingVo [id=" + id + ", customerNo=" + customerNo + ", customerName=" + customerName
				+ ", managerName=" + managerName + ", taxbillNo=" + taxbillNo + ", voucherNo=" + voucherNo
				+ ", sectionNo=" + sectionNo + ", sectionName=" + sectionName + ", area=" + area + ", combineNo="
				+ combineNo + ", ownerName=" + ownerName + ", wideAddress=" + wideAddress + ", cityAddress="
				+ cityAddress + ", detailAddress=" + detailAddress + ", floor=" + floor + ", basement=" + basement
				+ ", purpose=" + purpose + ", material=" + material + ", publicValue=" + publicValue + ", acqPrice="
				+ acqPrice + ", etcCost=" + etcCost + ", acqTax=" + acqTax + ", payDate=" + payDate + ", taxKind="
				+ taxKind + ", flag=" + flag + ", insertUserid=" + insertUserid + ", insertDay=" + insertDay
				+ ", updateUserid=" + updateUserid + ", updateDay=" + updateDay + "]";
	}
	
}
