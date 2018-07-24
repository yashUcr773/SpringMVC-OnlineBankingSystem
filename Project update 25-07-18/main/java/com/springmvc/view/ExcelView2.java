package com.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.springmvc.model.Transactions;
import com.springmvc.model.User;

public class ExcelView2 extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		
		
		HSSFSheet excelSheet = (HSSFSheet) workbook.createSheet("Transactions");
		setExcelHeader(excelSheet);
		
		
		
		List<Transactions> transactions = (List<Transactions>) model.get("transactions");
		setExcelRows(excelSheet,transactions);
		
	}

	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("TransactionId");
		excelHeader.createCell(1).setCellValue("Sender A/C Number");
		excelHeader.createCell(3).setCellValue("Reciever A/C Number");
		excelHeader.createCell(5).setCellValue("Amount");
		excelHeader.createCell(6).setCellValue("Remark");
		excelHeader.createCell(8).setCellValue("Date");
		excelHeader.createCell(9).setCellValue("Timestamp");
	}
	
	public void setExcelRows(HSSFSheet excelSheet, List<Transactions> transactions){
		int record = 1;
		
		
		for (Transactions t : transactions) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(t.getTransactionID());
			excelRow.createCell(2).setCellValue(t.getSender());
			excelRow.createCell(4).setCellValue(t.getRecipient());
			excelRow.createCell(5).setCellValue(t.getAmount());
			excelRow.createCell(6).setCellValue(t.getRemark());
			excelRow.createCell(8).setCellValue(t.getDate());
			excelRow.createCell(9).setCellValue(t.getTimestamp());
		}
	}
}
