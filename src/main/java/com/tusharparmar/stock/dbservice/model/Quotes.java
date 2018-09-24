package com.tusharparmar.stock.dbservice.model;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Quotes
{
	@NotNull
	private String userName;

	private List<String> quotes;

	public Quotes(String userName, List<String> quotes)
	{
		this.userName = userName;
		this.quotes = quotes;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public List<String> getQuotes()
	{
		return quotes;
	}

	public void setQuotes(List<String> quote)
	{
		this.quotes = quote;
	}
}
