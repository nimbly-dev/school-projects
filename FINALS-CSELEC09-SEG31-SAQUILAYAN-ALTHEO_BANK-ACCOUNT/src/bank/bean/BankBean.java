package bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="BankCustomerAccount")
public class BankBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="clientAccountName", nullable=false, length=50)
	private String clientAccountName;
	
	@Column(name="clientAccountType", nullable=false, length=50)
	private String clientAccountType;
	
	@Column(name="clientBalance", nullable=false)
	private double clientBalance;
	
	@Column(name="clientCurrentDeductionValue", nullable=false, precision=2)
	private double clientCurrentDeductionValue;
	
	@Column(name="newBalance", nullable=false, precision=2)
	private double newBalance;



	
	public String getClientAccountName() {
		return clientAccountName;
	}
	public void setClientAccountName(String clientAccountName) {
		this.clientAccountName = clientAccountName;
	}
	public String getClientAccountType() {
		return clientAccountType;
	}
	public void setClientAccountType(String clientAccountType) {
		this.clientAccountType = clientAccountType;
	}
	public double getClientBalance() {
		return clientBalance;
	}
	public void setClientBalance(double clientBalance) {
		this.clientBalance = clientBalance;
	}
	public double getClientCurrentDeductionValue() {
		return clientCurrentDeductionValue;
	}
	public void setClientCurrentDeductionValue(double clientCurrentDeductionValue) {
		this.clientCurrentDeductionValue = clientCurrentDeductionValue;
	}
	public double getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public void process() {
		computeFinalBalance();
	}
	
	private void computeFinalBalance() {

		if(this.clientBalance <= 2000 && this.clientAccountType.contentEquals("Savings")) {//Is savings and less than 2000
			this.clientCurrentDeductionValue = 200;//Set the deduction value
			this.newBalance = this.clientBalance - this.clientCurrentDeductionValue;
		}
		else if(this.clientBalance <= 5000 && this.clientAccountType.contentEquals("Current")) {//Is Current Account and less than 5000
			this.clientCurrentDeductionValue = 500;
			this.newBalance = this.clientBalance - this.clientCurrentDeductionValue;
		}else {//No deductions
			this.clientCurrentDeductionValue = 0;
			this.newBalance = 0;
		}
	
	}
	
	
}
