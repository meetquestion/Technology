package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Admin;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import tools.ApplicationContextFactory;

public class AdminDao
{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public AdminDao()
	{
		super();
	}
	/**
	 * ����û������ݿ���
	 * 
	 * @param adminBean
	 */
	public void save(Admin adminBean)
	{
		// ��ȡ���ݿ�����
		String sql = "insert into admin(username,password,code,name,id_number,sex,provinceId,cityId,unit,direction,industry,"
				+ "levels,title,address,postal,phone,telephone,email,qq,msn) values('"
				+ adminBean.getUsername()
				+ "','"
				+ adminBean.getPassword()
				+ "','"
				+ adminBean.getCode()
				+ "','"
				+ adminBean.getName()
				+ "','"
				+ adminBean.getId_number()
				+ "','"
				+ adminBean.getSex()
				+ "','"
				+ adminBean.getProvinceId()
				+ "','"
				+ adminBean.getCityId()
				+ "','"
				+ adminBean.getUnit()
				+ "','"
				+ adminBean.getDirection()
				+ "','"
				+ adminBean.getIndustry()
				+ "','"
				+ adminBean.getLevels()
				+ "','"
				+ adminBean.getTitle()
				+ "','"
				+ adminBean.getAddress()
				+ "','"
				+ adminBean.getPostal()
				+ "','"
				+ adminBean.getPhone()
				+ "','"
				+ adminBean.getTelephone()
				+ "','"
				+ adminBean.getEmail()
				+ "','" + adminBean.getQq() + "','" + adminBean.getMsn() + "')";
		try
		{
			ApplicationContextFactory.executeUpdate(sql);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Ȩ�޹���
	 */
	public boolean up(String username, int status)
	{
		String sql = "update admin set status=" + status + " where username='"
				+ username + "'";
		try
		{
			ApplicationContextFactory.executeUpdate(sql);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ��ȡ�û���Ϣ�б�
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Admin> getByStatus()
	{
		String sql = "select * from admin where status='3'";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Admin> ls = session.createSQLQuery(sql).addEntity(Admin.class).list();
			return ls;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ�û���Ϣ�б�
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Admin> getByStatusB()
	{
		String sql = "select * from admin where status!='3'";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Admin> ls = session.createSQLQuery(sql).addEntity(Admin.class).list();
			return ls;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ�û���Ϣ�б�
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Admin> get()
	{
		String sql = "select * from admin";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Admin> ls = session.createSQLQuery(sql).addEntity(Admin.class).list();
			return ls;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���»�����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateX(Admin adminBean)
	{
		String sql = "update admin set code='" + adminBean.getCode()
				+ "',name='" + adminBean.getName() + "',id_number='"
				+ adminBean.getId_number() + "',sex='" + adminBean.getSex()
				+ "',provinceId='" + adminBean.getProvinceId() + "',cityId='"
				+ adminBean.getCityId() + "',unit='" + adminBean.getUnit()
				+ "',direction='" + adminBean.getDirection() + "',industry='"
				+ adminBean.getIndustry() + "',levels='"
				+ adminBean.getLevels() + "',title='" + adminBean.getTitle()
				+ "',address='" + adminBean.getAddress() + "',postal='"
				+ adminBean.getPostal() + "',phone='" + adminBean.getPhone()
				+ "',telephone='" + adminBean.getTelephone() + "',email='"
				+ adminBean.getEmail() + "',qq='" + adminBean.getQq()
				+ "',msn='" + adminBean.getMsn() + "' where username='"
				+ adminBean.getUsername() + "'";
		try
		{
			ApplicationContextFactory.executeUpdate(sql);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * �ж��Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkReg(String username)
	{
		// ����һ��ʼ����ע�ᣬ�����ֵ��Ϊtrue
		boolean flag = true;
		// ��ѯ�û��Ƿ��Ѵ���
		ResultSet rs = null;
		try
		{
			rs = ApplicationContextFactory.getResultSet("select username from admin");
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			while (rs.next())
			{
				if (username.equals(rs.getString("username")))
				{
					// admin���ݱ����Ѵ��ڴ��˺���˵��������ע�ᣬ�����ֵ��Ϊfalse
					flag = false;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * �ж��Ƿ񱻷����ɫ
	 * @throws SQLException 
	 */
	public int checkF(String username) throws SQLException
	{
		int f = 0;
		ResultSet rs = ApplicationContextFactory.getResultSet("select * from admin where username='"
				+ username + "'");
		try
		{
			while (rs.next())
			{
				f = rs.getInt("status");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * ��¼��֤
	 */
	public Admin check(String username, String password)
	{
		ResultSet rs = null;
		try
		{
			rs = ApplicationContextFactory.getResultSet("select * from admin where username='"
					+ username + "'");
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		Admin adminBean = null;
		try
		{
			if (rs.next())
			{
				if (password.equals(rs.getString("password")))
				{
					adminBean = new Admin();
					adminBean.setUsername(username);
					adminBean.setPassword(password);
					adminBean.setCode(rs.getString("code"));
					adminBean.setName(rs.getString("name"));
					adminBean.setId_number(rs.getString("id_number"));
					adminBean.setSex(rs.getString("sex"));
					adminBean.setProvinceId(rs.getInt("provinceId"));
					adminBean.setCityId(rs.getInt("cityId"));
					adminBean.setUnit(rs.getString("unit"));
					adminBean.setDirection(rs.getString("direction"));
					adminBean.setIndustry(rs.getString("industry"));
					adminBean.setLevels(rs.getString("levels"));
					adminBean.setTitle(rs.getString("title"));
					adminBean.setAddress(rs.getString("address"));
					adminBean.setPostal(rs.getString("postal"));
					adminBean.setPhone(rs.getString("phone"));
					adminBean.setTelephone(rs.getString("telephone"));
					adminBean.setEmail(rs.getString("email"));
					adminBean.setQq(rs.getString("qq"));
					adminBean.setMsn(rs.getString("msn"));
					adminBean.setStatus(rs.getInt("status"));
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return adminBean;
	}

	/**
	 * ͨ��username�õ�Bean
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Admin getByUsername(String username)
	{
		try
		{
			String sql = "select * from admin where username='"
					+ username + "'";

			Session session = sessionFactory.getCurrentSession();
			List<Admin> ls = session.createSQLQuery(sql).addEntity(Admin.class).list();
			return ls.get(0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �޸�����
	 * 
	 * @param id
	 * @return
	 */
	public boolean update(String username, String password)
	{
		String sql = "update admin set password='" + password
				+ "' where username='" + username + "'";
		try
		{
			ApplicationContextFactory.executeUpdate(sql);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ע���û�
	 */
	public boolean delete(String username)
	{
		String sql = "delete from admin where username='" + username + "'";
		try
		{
			ApplicationContextFactory.executeUpdate(sql);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
