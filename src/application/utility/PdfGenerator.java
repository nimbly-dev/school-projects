
package application.utility;

import java.io.ByteArrayOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cart.model.CartItemBean;
import payment.controller.paymentInfoBean;
import product.model.Facade;


public  class PdfGenerator implements DBOperations, Facade{
	

	
	private void EmailPDF() {
		paymentInfoBean paymentData = new paymentInfoBean();
		String sender = "bscsmail.se31@gmail.com"; // enter valid email of sender
		String recipient = "owenclamor22@gmail.com"; // replace with user input for email
		String content = "dummy content"; //replace with proper content
		String subject = "dummy subject"; //replace with proper subject
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sender,"BSCS-SE31"); // (user name of sender, "password of email")
					}
		});
			
		ByteArrayOutputStream outputStream = null;
		
		try {
			//construct text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(content);
			
			//write PDF content to output stream
			outputStream = new ByteArrayOutputStream();
			GeneratePDF(outputStream);
			byte[] bytes = outputStream.toByteArray();
			
			//construct PDF body
			DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
			MimeBodyPart pdfBodyPart = new MimeBodyPart();
			pdfBodyPart.setDataHandler(new DataHandler(dataSource));
			pdfBodyPart.setFileName("test.pdf");
			
			//construct the mime multi part
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(textBodyPart);
			mimeMultipart.addBodyPart(pdfBodyPart);
			
			//create the sender/recipient addresses
			InternetAddress iaSender = new InternetAddress(sender);
			InternetAddress iaRecipient = new InternetAddress(recipient);
			
			//construct the mime message
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setSender(iaSender);
			mimeMessage.setSubject(subject);
			mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
			mimeMessage.setContent(mimeMultipart);
			
			//send off the email
			Transport.send(mimeMessage);

			System.out.println("sent from " + sender +
					", to " + recipient);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//clean off
			if(null != outputStream) {
				try { outputStream.close(); outputStream = null; }
				catch(Exception ex) { }
			}
		}
		
	}

	
	private void GeneratePDF(ByteArrayOutputStream outputStream) throws SQLException, DocumentException, MalformedURLException, IOException{
		//NOT NULL POINTER SO NEED TO KNOW WHERE TO CALL TO GET CART
		
				
				
				
					
//					String name = rs.getString("productName");
//					String price = rs.getString("productPrice");
//					String img = rs.getString("productImgPath");
//					String count = rs.getString("productCount");
					
//					System.out.println(name);
//					System.out.println(price);
//					System.out.println(count);
						
						
							
							Document pdfsup = new Document(PageSize.A4, 50, 50, 50, 50);
							PdfWriter writer = PdfWriter.getInstance(pdfsup, outputStream);
							
					
							pdfsup.open();
							
							String sql = RETRIEVE_PRODUCT_CART;
							paymentInfoBean paymentData = new paymentInfoBean();
							Connection conn = SingletonDB.getConnection();
							PreparedStatement ptstRetrieveCartItems = conn.prepareStatement(sql);
							ResultSet rs = ptstRetrieveCartItems.executeQuery();
							
			
							
							pdfsup.add(new Paragraph("Receipt PDF"));
							pdfsup.add(new Paragraph("This is your receipt", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
							pdfsup.add(new Paragraph("------------------------------------------------------------------------------------"));
							
							while(rs.next()) {
								
							try {
								
								Paragraph pdfResult = new Paragraph(rs.getString("productName") + "  " +rs.getString("productPrice") + ".00 PHP         " +  rs.getString("productCount") + "x");
								pdfsup.add(pdfResult);
							
							} catch (DocumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
						
							
							}
							pdfsup.close();
	}
	
	@Override
	public void PDFfunctions() {
		// TODO Auto-generated method stub
		 
		 EmailPDF();
	}


	@Override
	public boolean checkCardLuhn(String cardNo) {
		return false;
		// TODO Auto-generated method stub
		
	}


		
}
			
				
				
	
	
	
	
		
		
	



