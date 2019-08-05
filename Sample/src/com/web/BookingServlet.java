package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookingDetails;
import com.dao.Impl.Implementation;

@WebServlet(name="book" , urlPatterns="/book")
public class BookingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String movieName = req.getParameter("moviename");
		String theaterName = req.getParameter("theatername");		
		String movieShow = req.getParameter("show");
		
		String[] seats = req.getParameterValues("seat");
		String seatNumber = "" ;
		for(int i=0;i<seats.length;i++) {
			
			if(i==((seats.length)-1)) {
				seatNumber+=(seats[i]);
			}
			else {
			seatNumber+=(seats[i]+",");
			}
		}
		
		String ticketPrice = req.getParameter("price");
		
		BookingDetails bookDetails = new BookingDetails();
		
		bookDetails.setMovieName(movieName);
		bookDetails.setTheaterName(theaterName);
		bookDetails.setMovieShow(movieShow);
		bookDetails.setSeatNumber(seatNumber);
		bookDetails.setTicketPrice(ticketPrice);
		
		System.out.println("MovieName :"+bookDetails.getMovieName());
		
		Implementation impl = new Implementation();
		impl.bookingDetails(bookDetails);
		
		PrintWriter out = resp.getWriter();
		out.println(" <h2> You're Ticket has Booked Succcessfully </h2> !!");
		
	}

	
	
}
