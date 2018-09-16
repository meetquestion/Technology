package model;

public class Admin implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String code;
	private String name;
	private String id_number;
	private String sex;
	private Integer provinceId;
	private Integer cityId;
	private String unit;
	private String direction;
	private String industry;//所在行业
	private String levels;//教育水平
	private String title;//职称
	private String address;//通讯地址
	private String postal;//邮政编码
	private String phone;//电话
	private String telephone;//手机
	private String email;//电子邮件
	private String qq;
	private String msn;
	private Integer status;
	
	public Admin()
	{
	}


	public Admin(String username, String password, String code, String name,
			String id_number, String sex, Integer provinceId, Integer cityId,
			String unit, String direction, String industry, String levels,
			String title, String address, String postal, String phone,
			String telephone, String email, String qq, String msn,
			Integer status)
	{
		super();
		this.username = username;
		this.password = password;
		this.code = code;
		this.name = name;
		this.id_number = id_number;
		this.sex = sex;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.unit = unit;
		this.direction = direction;
		this.industry = industry;
		this.levels = levels;
		this.title = title;
		this.address = address;
		this.postal = postal;
		this.phone = phone;
		this.telephone = telephone;
		this.email = email;
		this.qq = qq;
		this.msn = msn;
		this.status = status;
	}



	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId_number()
	{
		return id_number;
	}

	public void setId_number(String id_number)
	{
		this.id_number = id_number;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Integer getProvinceId()
	{
		return provinceId;
	}

	public void setProvinceId(Integer provinceId)
	{
		this.provinceId = provinceId;
	}

	public Integer getCityId()
	{
		return cityId;
	}

	public void setCityId(Integer cityId)
	{
		this.cityId = cityId;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public String getDirection()
	{
		return direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}

	public String getIndustry()
	{
		return industry;
	}

	public void setIndustry(String industry)
	{
		this.industry = industry;
	}

	public String getLevels()
	{
		return levels;
	}

	public void setLevels(String levels)
	{
		this.levels = levels;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPostal()
	{
		return postal;
	}

	public void setPostal(String postal)
	{
		this.postal = postal;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public String getMsn()
	{
		return msn;
	}

	public void setMsn(String msn)
	{
		this.msn = msn;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}


}