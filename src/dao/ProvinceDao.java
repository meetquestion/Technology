package dao;

import java.util.List;

import model.Province;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ProvinceDao
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

	public ProvinceDao()
	{
		super();
	}

	// 通过province(id)获取provinceBean对象
	@SuppressWarnings("unchecked")
	@Transactional
	public Province getProvinceById(int id)
	{
		String sql = "select * from province where id=" + id;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Province> ls = session.createSQLQuery(sql)
					.addEntity(Province.class).list();
			return ls.get(0);
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取ProvinceBeans,LIST
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Province> getProvinceList()
	{
		String sql = "select * from province";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Province> ls = session.createSQLQuery(sql)
					.addEntity(Province.class).list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
