package dao;

import java.util.List;

import model.FirstX;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class FirstXDao
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

	public FirstXDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<FirstX> getFirstList()
	{
		String sql = "select * from FirstX";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<FirstX> ls = session.createSQLQuery(sql)
					.addEntity(FirstX.class).list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
