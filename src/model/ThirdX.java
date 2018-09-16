package model;

public class ThirdX implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer parentId;

	public ThirdX()
	{
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

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}
}