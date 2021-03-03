


package application.utility;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfGenerator implements DBOperations {
	

	public static void EmailPDF() {
		String sender = ""; // enter valid email of sender
		String recipient = ""; // replace with user input for email
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
						return new PasswordAuthentication(sender,""); // (user name of sender, "password of email")
					}
		});
			
		ByteArrayOutputStream outputStream = null;
		
		try {
			//construct text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(content);
			
			//write PDF content to output stream
			outputStream = new ByteArrayOutputStream();
			generatePDF(outputStream);
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



	public static void generatePDF(ByteArrayOutputStream outputStream) throws SQLException {
		
		//NOT NULL POINTER SO NEED TO KNOW WHERE TO CALL TO GET CART
		
		String sql = RETRIEVE_CART_ITEMS;
		
		Connection conn = SingletonDB.getConnection();
		PreparedStatement ptstRetrieveCartItems = conn.prepareStatement(sql);
		ResultSet rs = ptstRetrieveCartItems.executeQuery();
		
		if(rs.next()) {
			
			String name = rs.getString("productName");
			String price = rs.getString("productPrice");
			String img = rs.getString("productImgPath");
			String count = rs.getString("productCount");
			
				
				try {
					
					Document pdfsup = new Document(PageSize.A4, 50, 50, 50, 50);
					PdfWriter writer = PdfWriter.getInstance(pdfsup, outputStream);
					
					
					pdfsup.open();
					pdfsup.add(new Paragraph("Receipt PDF"));
					pdfsup.add(new Paragraph("This is your receipt", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD)));
					pdfsup.add(new Paragraph("------------------------------------------------------------------------------------"));
					
					PdfPTable tablesup = new PdfPTable(4);
					
					PdfPCell cell = new PdfPCell(new Paragraph("Product Information: "));
					
					tablesup.addCell(cell);
					
					tablesup.addCell("Product Name");
					tablesup.addCell(name);
					tablesup.addCell("Product Price");
					tablesup.addCell(price);
					tablesup.addCell("Amount");
					tablesup.addCell(count);
					tablesup.addCell(img);
					pdfsup.close();
					
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}else {
			System.out.println("No Selection");
		}
	
			
		}
	
	
	
	
		
		
	}



