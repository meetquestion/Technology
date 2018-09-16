package dao;

import java.util.List;

import model.FirstH;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class FirstHDao
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

	public FirstHDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<FirstH> getFirstList()
	{
		String sql = "select * from FirstH";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<FirstH> ls = session.createSQLQuery(sql).addEntity(FirstH.class)
					.list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
