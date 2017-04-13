package entity;

public class Marriage {
	private String smNum;
	private String smName;
	private int smAge;
	private String smJob;
	private String smPhone;
	public String getSmNum() {
		return smNum;
	}
	public void setSmNum(String smNum) {
		this.smNum = smNum;
	}
	public String getSmName() {
		return smName;
	}
	public void setSmName(String smName) {
		this.smName = smName;
	}
	public int getSmAge() {
		return smAge;
	}
	public void setSmAge(int smAge) {
		this.smAge = smAge;
	}
	public String getSmJob() {
		return smJob;
	}
	public void setSmJob(String smJob) {
		this.smJob = smJob;
	}
	public String getSmPhone() {
		return smPhone;
	}
	public void setSmPhone(String smPhone) {
		this.smPhone = smPhone;
	}
	@Override
	public String toString() {
		return "Marriage [smNum=" + smNum + ", smName=" + smName + ", smAge="
				+ smAge + ", smJob=" + smJob + ", smPhone=" + smPhone + "]";
	}
    
}
