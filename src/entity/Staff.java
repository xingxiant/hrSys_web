package entity;
/**
 * ÊµÌåÄÚÈÝ
 * @author APPle
 *
 */
public class Staff {

	private String siNum;  //1
	private String siPwd;
	private String siName;
	private String siSex;
	private int siAge;
	private String siPhone;
	private String siMail;
	private String siAdress;
	private int siIsMar;
	private String cjJobNum;
	private int siTime;    //11
	public int getSiTime() {
		return siTime;
	}
	public void setSiTime(int siTime) {
		this.siTime = siTime;
	}
	public String getSiNum() {
		return siNum;
	}
	public void setSiNum(String siNum) {
		this.siNum = siNum;
	}
	public String getSiPwd() {
		return siPwd;
	}
	public void setSiPwd(String siPwd) {
		this.siPwd = siPwd;
	}
	public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
	public String getSiSex() {
		return siSex;
	}
	public void setSiSex(String siSex) {
		this.siSex = siSex;
	}
	public int getSiAge() {
		return siAge;
	}
	public void setSiAge(int siAge) {
		this.siAge = siAge;
	}
	public String getSiPhone() {
		return siPhone;
	}
	public void setSiPhone(String siPhone) {
		this.siPhone = siPhone;
	}
	public String getSiMail() {
		return siMail;
	}
	public void setSiMail(String siMail) {
		this.siMail = siMail;
	}
	public String getSiAdress() {
		return siAdress;
	}
	public void setSiAdress(String siAdress) {
		this.siAdress = siAdress;
	}
	public int getSiIsMar() {
		return siIsMar;
	}
	public void setSiIsMar(int siIsMar) {
		this.siIsMar = siIsMar;
	}
	public String getCjJobNum() {
		return cjJobNum;
	}
	public void setCjJobNum(String cjJobNum) {
		this.cjJobNum = cjJobNum;
	}
	@Override
	public String toString() {
		return "Contact [siNum=" + siNum + ", siPwd=" + siPwd + ", siName="
				+ siName + ", siSex=" + siSex + ", siAge=" + siAge
				+ ", siPhone=" + siPhone + ", siMail=" + siMail + ", siAdress="
				+ siAdress + ", siIsMar=" + siIsMar + ", sicjobNum="
				+ cjJobNum + "]";
	}
	
	
}
