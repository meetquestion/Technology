package dao;

import java.util.List;

import model.SecondX;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class SecondXDao
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

	public SecondXDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<SecondX> getSecondList(int parentId)
	{
		String sql = "select * from SecondX where parentId=" + parentId;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<SecondX> ls = session.createSQLQuery(sql)
					.addEntity(SecondX.class).list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
