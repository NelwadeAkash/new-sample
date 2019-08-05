package com.dao;

import java.util.List;
import com.bean.BookingDetails;
import com.bean.MovieDetails;

public interface OrgInterface {
	
	public boolean isPresent(String username , String password);
	
	public void register(String username , String password);
	
	public void bookingDetails(BookingDetails details);
	
	public List<MovieDetails> showMovies();
	
}
