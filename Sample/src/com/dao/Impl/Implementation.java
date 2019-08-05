package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BookingDetails;
import com.bean.MovieDetails;
import com.dao.OrgInterface;
import com.db.DBConnection;

public class Implementation implements OrgInterface {

	public boolean isPresent(String username, String password) {
		
		String sql = "select * from login";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		System.out.println("username and password recieved in isPresent ");
		
		List<String> usernameList = new ArrayList<>();
		List<String> passwordList  = new ArrayList<>();
		
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
			
				usernameList.add(resultSet.getString("username"));
				System.out.println(resultSet.getString("username"));
				passwordList.add(resultSet.getString("password"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DBConnection.close(connection, prepareStatement, resultSet);
		}
		
		boolean isPresented = false ;
		
		for(int i=0; i<usernameList.size(); i++) {
			
			if(username.equals(usernameList.get(i)) ){
				System.out.println(usernameList.get(i));
						if(password.equals(passwordList.get(i))) {
							isPresented = true ;
						}
			
			}
		
		}
		
		System.out.println(isPresented);
		return isPresented;
		
	}

	@Override
	public void bookingDetails(BookingDetails details) {
			
		System.out.println("Details recieved in InsertBookingDetails");
		String theater = details.getTheaterName();
		
		String sql = "insert into "+theater+"(movieName,movieShow,seatNumber,ticketPrice)"
								+ " values(?,?,?,?)";     
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try{
			
		connection  = DBConnection.getConnection();
		connection.setAutoCommit(false);
			
		System.out.println(details.getMovieName());
		
		prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setString(1, details.getMovieName());			
		prepareStatement.setString(2, details.getMovieShow());
		prepareStatement.setString(3, details.getSeatNumber());
		prepareStatement.setString(4, details.getTicketPrice());
		
		prepareStatement.executeUpdate();
		
		System.out.println("Values inserted in booking details table");
		
		connection.commit();
		
		}
		catch(Exception e){
			
			try{
				connection.rollback();
			}
		
			catch (Exception e1) {
				e1.printStackTrace();
			}
				e.printStackTrace();
		}
		
		finally {
			DBConnection.close(connection, prepareStatement, null);
		}
		
		
	}

	@Override
	public List<MovieDetails> showMovies() {
		
		System.out.println("Show Movies Called");
		
		String sql = "select * from login";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		List<MovieDetails> movieList = new ArrayList<>();
		MovieDetails movieDetails = new MovieDetails();
		
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				
				movieDetails.setMoviename( resultSet.getString("moviename") );
				movieDetails.setActor( resultSet.getString("actor") );
				movieDetails.setLanguages( resultSet.getString("languages") );
				movieDetails.setRating( resultSet.getString("ratings") );
				movieDetails.setPrice( resultSet.getInt("price") );
				
				movieList.add(movieDetails);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(connection, prepareStatement, resultSet);
		}
		
		return movieList;
		
	}

	@Override
	public void register(String username, String password) {
		
		System.out.println("Details recieved in register");
		
		String sql = "insert into login(username,password) values(?,?)";     
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try{
			
		connection  = DBConnection.getConnection();
		connection.setAutoCommit(false);
			
		
		prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setString(1, username);			
		prepareStatement.setString(2, password);
		
		prepareStatement.executeUpdate();
		
		System.out.println("Succesfully registered");
		
		connection.commit();
		
		}
		catch(Exception e){
			
			try{
				connection.rollback();
			}
		
			catch (Exception e1) {
				e1.printStackTrace();
			}
				e.printStackTrace();
		}
		
		finally {
			DBConnection.close(connection, prepareStatement, null);
		}
		
		
	}
	
}