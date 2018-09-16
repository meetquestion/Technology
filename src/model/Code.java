package model;

public class Code implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code_name;
	private String code_num;

	public Code()
	{
	}
	
	public Code(Integer id, String code_name, String code_num)
	{
		super();
		this.id = id;
		this.code_name = code_name;
		this.code_num = code_num;
	}



	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCode_name()
	{
		return code_name;
	}

	public void setCode_name(String code_name)
	{
		this.code_name = code_name;
	}

	public String getCode_num()
	{
		return code_num;
	}

	public void setCode_num(String code_num)
	{
		this.code_num = code_num;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}