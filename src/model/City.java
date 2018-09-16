package model;

import java.sql.Timestamp;

public class City implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String postcode;
	private Timestamp createDate;
	private Integer provinceId;

	public City()
	{
	}

	public City(String name, String postcode, Timestamp createDate,
			Integer provinceId)
	{
		this.name = name;
		this.postcode = postcode;
		this.createDate = createDate;
		this.provinceId = provinceId;
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

	public Integer getProvinceId()
	{
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId)
	{
		this.provinceId = provinceId;
	}

}