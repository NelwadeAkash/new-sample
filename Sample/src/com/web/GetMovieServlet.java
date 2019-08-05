package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MovieDetails;
import com.dao.Impl.Implementation;

@WebServlet(name="getmovies" , urlPatterns = "/show")
public class GetMovieServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Implementation impl = new Implementation();
		List<MovieDetails> movieList = impl.showMovies();
		
		System.out.println(movieList);
		
		req.setAttribute( "movieList" , movieList );
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/showMovie.jsp");
		dispatcher.forward(req, resp);
		
		//PrintWriter out = resp.getWriter();
		
		//List<MovieDetails> movieList = ( List<MovieDetails> ) request.getAttribute("movieList");

		/*out.println("<tr> <th> <h2> MovieName </h2> </th> <th> <h2> Actor </h2> </th> <th> <h2> Languages </h2> </th> <th> <h2> Ratings </h2> </th> <th> <h2> Price </h2> </th> </tr> <h2>");


		for(MovieDetails movies : movieList){
			out.println("<tr><td>"+movies.getMoviename()+"</td>"+
							"<td>"+movies.getActor()+"</td>"+
							"<td>"+movies.getLanguages()+"</td>"+
							"<td>"+movies.getRating()+"</td>"+
							"<td>"+movies.getPrice()+"</td></tr>");
		}
*/		
	}
	
}
