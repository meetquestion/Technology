package dao;

import java.util.List;

import model.SecondH;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class SecondHDao
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

	public SecondHDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<SecondH> getSecondList(int parentId)
	{
		String sql = "select * from SecondH where parentId=" + parentId;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<SecondH> ls = session.createSQLQuery(sql)
					.addEntity(SecondH.class).list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
