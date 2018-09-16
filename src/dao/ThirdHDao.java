package dao;

import java.util.List;

import model.ThirdH;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ThirdHDao
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

	public ThirdHDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ThirdH> getThirdList(int parentId)
	{
		String sql = "select * from ThirdH where parentId=" + parentId;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<ThirdH> ls = session.createSQLQuery(sql)
					.addEntity(ThirdH.class).list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
