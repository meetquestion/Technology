package dao;

import java.util.List;

import model.ThirdX;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ThirdXDao
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

	public ThirdXDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ThirdX> getThirdList(int parentId)
	{

		String sql = "select * from ThirdX where parentId=" + parentId;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<ThirdX> ls = session.createSQLQuery(sql)
					.addEntity(ThirdX.class).list();
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
