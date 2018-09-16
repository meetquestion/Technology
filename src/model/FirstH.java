package model;

public class FirstH implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public FirstH()
	{
	}

	public FirstH(Integer id)
	{
		this.id = id;
	}

	public FirstH(Integer id, String name)
	{
		this.id = id;
		this.name = name;
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
}