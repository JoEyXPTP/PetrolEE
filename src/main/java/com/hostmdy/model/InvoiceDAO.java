package com.hostmdy.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class InvoiceDAO {

	private DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public InvoiceDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public int createInvoice(Invoice invoice) {
		int rowUpdated = 0;
//		private 
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `invoice` "
					+ "(`username`, `email`, `petrol_type`, `amount`, `total_price`, `date`) "
					+ "VALUES (?, ?, ?, ?, ?, ?);");
			pStmt.setString(1, invoice.getUsername());
			pStmt.setString(2, invoice.getEmail());
			pStmt.setString(3, invoice.getPetrol_type());
			pStmt.setDouble(4, invoice.getAmount());
			pStmt.setDouble(5, invoice.getTotal_price());
			Date date = Date.valueOf(invoice.getDate());
			pStmt.setDate(6, date);
			rowUpdated = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowUpdated;
	}
	
	public List<Invoice> getAllInvoice() {
		List<Invoice> invoiceList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("Select * from invoice;");
			
			while (rs.next()) {
				invoiceList.add(new Invoice(rs.getInt("id"), 
						rs.getString("username"), rs.getString("email"),
						rs.getString("petrol_type"), rs.getDouble("amount"),
						rs.getDouble("total_price"), LocalDate.parse(rs.getDate("date").toString())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return invoiceList;
	}
	
	public int updateInvoice(Invoice invoice, Petrol petrol) {
		int rowUpdated = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("UPDATE `invoice` "
					+ "SET `username` = ?, `email` = ?, `petrol_type` = ?, `amount` = ?, `total_price` = ?, `date` = ? "
					+ " WHERE (`id` = ?);");
			pStmt.setString(1, invoice.getUsername());
			pStmt.setString(2, invoice.getEmail());
			pStmt.setString(3, invoice.getPetrol_type());
			pStmt.setDouble(4, invoice.getAmount());
			Double total_price = (petrol.getUnit_price()) * invoice.getAmount();
			pStmt.setDouble(5, total_price);
			Date date = Date.valueOf(invoice.getDate());
			pStmt.setDate(6, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowUpdated;
	}
	
//	public int deleteInvoice(String email) {
//		int rowUpdated = 0;
//		try {
//			connection = dataSource.getConnection();
//			pStmt = connection.prepareStatement("Delete from invoice where emial = ?;");
//			pStmt.setString(1, email);
//			rowUpdated = pStmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			 close();
//		}
//		return rowUpdated;
//	}
}
