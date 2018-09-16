package model;

import java.sql.Timestamp;

public class Province implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String postcode;
	private Timestamp createDate;

	public Province()
	{
	}

	public Province(String name, String postcode, Timestamp createDate)
	{
		this.name = name;
		this.postcode = postcode;
		this.createDate = createDate;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPostcode()
	{
		return this.postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public Timestamp getCreateDate()
	{
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate)
	{
		this.createDate = createDate;
	}
}