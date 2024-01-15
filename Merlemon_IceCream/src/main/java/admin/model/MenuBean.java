package admin.model;

import java.io.InputStream;

public class MenuBean {

	private int menuId;
	private String menuName;
	private double menuPrice;
	private byte[] image;
	private InputStream imageS;
	private String encodedImage;
	private int staffId;
	
	public MenuBean() {
		super();
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public double getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(double menuPrice) {
		this.menuPrice = menuPrice;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public InputStream getImageS() {
		return imageS;
	}

	public void setImageS(InputStream imageS) {
		this.imageS = imageS;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	



}
