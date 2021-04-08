package bank.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bank.bean.*;

public class DetermineBankTypeAction extends ActionSupport implements ModelDriven <BankBean>{
	
	private BankBean account = new BankBean();
	
	public String execute() {
		
		account.process();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		
		if(account.getClientAccountName() != null && account.getClientAccountType() != null && account.getClientBalance() != 0) {
			account.process();
			
			System.out.println("An Account has been added with the following credentials ");
			System.out.println("Account Name: "+ account.getClientAccountName());
			System.out.println("Account Type: "+ account.getClientAccountType());
			System.out.println("Balance Deductable Value: " + account.getClientCurrentDeductionValue());
			if(account.getClientCurrentDeductionValue() != 0) { //Has Deduction
				System.out.println("\nBalance has been deducted");
				if(account.getClientCurrentDeductionValue() == 500) {
					System.out.println("Account Past Balance: "+ account.getClientBalance());
				}else {
					System.out.println("Account Past Balance: "+ account.getClientBalance());
				}
				System.out.println("Balance Deductable Value: " +account.getClientCurrentDeductionValue());
				System.out.println("Account New Balance: " + account.getNewBalance());
				System.out.println("Account Type: " + account.getClientAccountType());
			}else { //No deductables
				System.out.println("\nBalance has no deductables");
				System.out.println("Account Balance: "+ account.getClientBalance());
				System.out.println("Account Type: " + account.getClientAccountType());
			}
		}
			
		return SUCCESS;
	}
	
	public BankBean getAccount() {
		return account;
	}
	
	public void setBank(BankBean account) {
		this.account = account;
	}

	@Override
	public BankBean getModel() {
		// TODO Auto-generated method stub
		return account;
	}

}
