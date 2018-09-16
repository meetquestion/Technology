package dao;

import java.util.List;

import model.City;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class CityDao
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
	
	public CityDao()
	{
		super();
	}

	// 通过city(id)获取cityBean对象
	@SuppressWarnings("unchecked")
	@Transactional
	public City getCityById(int id)
	{
		String sql = "select * from city where id=" + id;
		Session session = sessionFactory.getCurrentSession();
		List<City> ls = session.createSQLQuery(sql).addEntity(City.class)
				.list();
		return ls.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<City> getCityList(int provinceId)
	{
		String sql = "select * from city where province_id="
				+ provinceId;

		Session session = sessionFactory.getCurrentSession();
		List<City> ls = session.createSQLQuery(sql).addEntity(City.class)
				.list();
		return ls;
	}

}
