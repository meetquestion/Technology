package dao;

import java.util.List;

import model.Code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class CodeDao
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
	
	public CodeDao()
	{
		super();
	}
	
	/**
	 * 得到code的列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Code> getCodeList()
	{
		String sql = "select * from code";
		Session session = sessionFactory.getCurrentSession();
		List<Code> ls = session.createSQLQuery(sql).addEntity(Code.class)
				.list();
		return ls;
	}

	/**
	 * 通过num得到Bean
	 * 
	 * @param code_num
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Code getByNum(String code_num)
	{
		String sql = "select * from code where code_num='"
				+ code_num + "'";
		Session session = sessionFactory.getCurrentSession();
		List<Code> ls = session.createSQLQuery(sql).addEntity(Code.class)
				.list();
		return ls.get(0);
	}

}
