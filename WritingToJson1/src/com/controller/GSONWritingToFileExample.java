package com.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.Country;

@WebServlet("/GSONWritingToFileExample")
public class GSONWritingToFileExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GSONWritingToFileExample() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.toString());
		System.out.println(request.getQueryString());
		System.out.println(request.getParameterMap());
		System.out.println(request.getParameter("name"));
		Country countryObj = new Country();
		countryObj.setName("country");

		List<String> listOfStates = new ArrayList<String>();
		listOfStates.add("Madya Prades");
		listOfStates.add("Maharastra");
		listOfStates.add("Rajathan");

		Gson gson = new Gson();

		// convert java object to JSON format,
		// and returned as JSON formatted String.
		String json = gson.toJson(countryObj);
		try {
			//write converted JSON data to a file name "COuntryGSON.json"
			FileWriter writer = new FileWriter("data.json");
			writer.write(json);
			writer.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(json);
	

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// this country is comming from the user input!
		// from the country="country"
		// in user.country
		String country = json;
		out.write("<h1> A new country " + country + " has been added!");
		out.flush();
		out.close();

		doGet(request, response);
	}

}
