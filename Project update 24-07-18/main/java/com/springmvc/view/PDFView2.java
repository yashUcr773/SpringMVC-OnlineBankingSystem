package com.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.springmvc.model.Transactions;
import com.springmvc.model.User;




public class PDFView2 extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		  User user = (User) model.get("user");
		  List<Transactions> transactions = (List<Transactions>) model.get("transactions");
		 
		  
		  String init=transactions.get(0).getDate(),end=transactions.get(transactions.size()-1).getDate();
		  
		  
		  
		  Image img = Image.getInstance("Logo.png");
		  img.setAbsolutePosition((document.getPageSize().getWidth()/2)-300, (document.getPageSize().getHeight()/2)+300);
		  img.scaleToFit(100, 100);
		  document.add(img);
		  
		  Image img2 = Image.getInstance("inverted logo.png");
		  img2.setAbsolutePosition((document.getPageSize().getWidth()/2)+200, (document.getPageSize().getHeight()/2)+300);
		  img2.scaleToFit(100, 100);
		  document.add(img2);
		  

		  
		  
		  
		  
			Font headingFont = FontFactory.getFont(FontFactory.COURIER,50,Font.BOLD,BaseColor.BLACK);
			Paragraph heading = new Paragraph("Devil's Vault",headingFont);
			heading.setSpacingAfter(10);
			heading.setAlignment(Element.ALIGN_CENTER);
			document.add(heading);
			document.add(Chunk.NEWLINE);	
			

			
		 
			Font subHeading = FontFactory.getFont(FontFactory.TIMES_ROMAN,20,Font.ITALIC,BaseColor.BLACK);
            Chunk title = new Chunk("All transactions for  ", subHeading);
            Paragraph p0 = new Paragraph(title);
            p0.setLeading(15,0);
            document.add(p0);
            document.add(Chunk.NEWLINE);
            
            Chunk timeperiod = new Chunk("Summary duration : "+  init +"  to " +  end, subHeading);
            timeperiod.setUnderline(1f, -5f);
            Paragraph p6 = new Paragraph(timeperiod);
            p6.setLeading(12,0);
            document.add(p6);
            
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            

			
			
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] {1.0f, 1.0f, 1.0f, 1.0f, 3.0f, 2.0f});
			table.setSpacingBefore(10);
			
			// define font for table header row
			Font font = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(BaseColor.WHITE);
			
			// define table header cell
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.BLUE);
			cell.setPadding(5);
			
			// write table header 
			cell.setPhrase(new Phrase("TransactionID", font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase("Sender", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Reciever", font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase("Amount (Rs.)", font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase("Timestamp", font));
			table.addCell(cell);
			
			cell.setPhrase(new Phrase("Remark", font));
			table.addCell(cell);
			
		  
		  for(Transactions t:transactions)
		  {
			  table.addCell(String.valueOf(t.getTransactionID()));
			  table.addCell(String.valueOf(t.getSender()));
			  table.addCell(String.valueOf(t.getRecipient()));
			  table.addCell(String.valueOf(t.getAmount()));
			  //table.addCell(String.valueOf(t.getDate()));
			  table.addCell(String.valueOf(t.getTimestamp()));
			  table.addCell(String.valueOf(t.getRemark()));
		  }
		  
		  document.add(table);

		
	}

}
