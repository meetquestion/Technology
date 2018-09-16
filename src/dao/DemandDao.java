package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import tools.ApplicationContextFactory;
import tools.StringUtil;

import model.T_DCWJXX;
import model.Tongjibean;


public class DemandDao
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

	public DemandDao()
	{
		super();
	}

	// ��ȡ���ݱ�����������
	public int getCount()
	{
		String sql = "select count(*) count from T_DCWJXX";
		int size = 0;
		try
		{
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			while (rs.next())
			{
				size = rs.getInt("count");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return size;
	}

	// ��ȡÿһ����ҳ������
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListByPage(int start, int size)
	{
		String sql = "select top " + size
				+ " * from T_DCWJXX where(WJID not in(select top " + start
				+ " WJID from T_DCWJXX))";

		Session session = sessionFactory.getCurrentSession();
		List<T_DCWJXX> ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		return ls;
	}

	public Tongjibean tongji()
	{
		Tongjibean tongjibean = new Tongjibean();
		String sql = "";
		try
		{
			Statement state = ApplicationContextFactory.getStatement();
			ResultSet rs = null;
			sql = "select count(*) as s from T_DCWJXX where SFSH=0";
			rs = state.executeQuery(sql);
			if (rs.next())
			{
				tongjibean.setWeishenhe(StringUtil.StringToInt(rs
						.getString("s")));
			}
			sql = "select count(*) as s from T_DCWJXX where SFSH!=0";
			rs = state.executeQuery(sql);
			if (rs.next())
			{
				tongjibean.setShenhe(StringUtil.StringToInt(rs.getString("s")));
			}
			sql = "select count(*) as s from T_DCWJXX where SFSH=1";
			rs = state.executeQuery(sql);
			if (rs.next())
			{
				tongjibean
						.setTongguo(StringUtil.StringToInt(rs.getString("s")));
			}
			sql = "select count(*) as s from T_DCWJXX where SFSH=2";
			rs = state.executeQuery(sql);
			if (rs.next())
			{
				tongjibean.setTuihui(StringUtil.StringToInt(rs.getString("s")));
			}
			tongjibean.setZong();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return tongjibean;
	}

	// ȥ����ҳ
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> xdshPolicy(String num, String sType0,
			String q0, String logic1, String sType1, String q1, String logic2,
			String sType2, String q2)
	{

		String sql = "select * from T_DCWJXX";
		// ƴ�Ĳ�ѯ���
		// ��Ϊֻ��һ�β�ѯ�����ʾ���Բ����ύ��������~~~~~~����ֿ�ָ��
		if (num.equals("1"))
		{
			// ֻ��һ����ѯ����
			sql += " where " + sType0 + " like '%" + q0 + "%'";
		}
		if (num.equals("2"))
		{
			// 2����ѯ����
			if (logic1.equals("AND"))
			{
				sql += " where " + sType0 + " like '%" + q0 + "%' " + logic1
						+ " " + sType1 + " like '%" + q1 + "%'";
			}
			if (logic1.equals("OR"))
			{
				sql += " where (" + sType0 + " like '%" + q0 + "%' " + logic1
						+ " " + sType1 + " like '%" + q1 + "%')";
			}
			if (logic1.equals("NOT"))
			{
				sql += " where " + sType0 + " like '%" + q0 + "%' " + "and "
						+ sType1 + " not like '%" + q1 + "%'";
			}
		}
		if (num.equals("3"))
		{
			// 3����ѯ����
			if (logic2.equals("AND"))
			{
				if (logic1.equals("AND"))
				{
					sql += " where " + sType0 + " like '%" + q0 + "%' "
							+ logic1 + " " + sType1 + " like '%" + q1 + "%' "
							+ logic2 + " " + sType2 + " like '%" + q2 + "%'";
				}
				if (logic1.equals("OR"))
				{
					sql += " where (" + sType0 + " like '%" + q0 + "%' "
							+ logic1 + " " + sType1 + " like '%" + q1 + "%' "
							+ logic2 + " " + sType2 + " like '%" + q2 + "%')";
				}
				if (logic1.equals("NOT"))
				{
					sql += " where " + sType0 + " like '%" + q0 + "%' "
							+ "and " + sType1 + " not like '%" + q1 + "%'"
							+ " and " + sType2 + " not like '%" + q2 + "%'";
				}
			}

			if (logic2.equals("OR"))
			{
				if (logic1.equals("AND"))
				{
					sql += " where " + sType0 + " like '%" + q0 + "%' "
							+ logic1 + " (" + sType1 + " like '%" + q1 + "%' "
							+ logic2 + " " + sType2 + " like '%" + q2 + "%' )";
				}
				if (logic1.equals("OR"))
				{
					sql += " where (" + sType0 + " like '%" + q0 + "%' "
							+ logic1 + " " + sType1 + " like '%" + q1 + "%' "
							+ logic2 + " " + sType2 + " like '%" + q2 + "%')";
				}
				if (logic1.equals("NOT"))
				{
					sql += " where (" + sType0 + " like '%" + q0 + "%' "
							+ "and " + sType1 + " not like '%" + q1 + "%') "
							+ logic2 + " " + sType2 + " like '%" + q2 + "%'";
				}
			}

			if (logic2.equals("NOT"))
			{

				if (logic1.equals("AND"))
				{
					sql += " where " + sType0 + " like '%" + q0 + "%' "
							+ logic1 + " " + sType1 + " like '%" + q1 + "%' "
							+ " and " + sType2 + " not like '%" + q2 + "%'";
				}
				if (logic1.equals("OR"))
				{
					sql += " where (" + sType0 + " like '%" + q0 + "%' "
							+ logic1 + " " + sType1 + " like '%" + q1 + "%') "
							+ " and " + sType2 + " not like '%" + q2 + "%'";
				}
				if (logic1.equals("NOT"))
				{
					sql += " where " + sType0 + " like '%" + q0 + "%' "
							+ "and " + sType1 + " not like '%" + q1 + "%'"
							+ " and " + sType2 + " not like '%" + q2 + "%'";
				}
			}

		}

		Session session = sessionFactory.getCurrentSession();
		List<T_DCWJXX> ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		return ls;
	}

	public void save(T_DCWJXX demandBean)
	{
		// ��ȡ���ݿ�����
		String sql = "insert into T_DCWJXX(WJID,username,SZDY,SFSH,JGMC,GLBM,TXDZ,DWWZ,DZYX,FRDB,YZBM,LXR,GDDH,YDDH,CZ,JGSX,"
				+ "JGJJ,JSXQMC,QSXQNF,JZXQNF,ZDKJXQGS,GJZ,YJLX,XKFL1,XKFL2,XKFL3,XQJSSSLY,QTJSMS,XQJSYYHY1,XQJSYYHY2,XQJSYYHY3,JSXQHZMS,HZYXDW,NTR,createDate) values('"
				+ demandBean.getWJID()
				+ "','"
				+ demandBean.getUsername()
				+ "','"
				+ demandBean.getSZDY()
				+ "','"
				+ demandBean.getSFSH()
				+ "','"
				+ demandBean.getJGMC()
				+ "','"
				+ demandBean.getGLBM()
				+ "','"
				+ demandBean.getTXDZ()
				+ "','"
				+ demandBean.getDWWZ()
				+ "','"
				+ demandBean.getDZYX()
				+ "','"
				+ demandBean.getFRDB()
				+ "','"
				+ demandBean.getYZBM()
				+ "','"
				+ demandBean.getLXR()
				+ "','"
				+ demandBean.getGDDH()
				+ "','"
				+ demandBean.getYDDH()
				+ "','"
				+ demandBean.getCZ()
				+ "','"
				+ demandBean.getJGSX()
				+ "','"
				+ demandBean.getJGJJ()
				+ "','"
				+ demandBean.getJSXQMC()
				+ "','"
				+ demandBean.getQSXQNF()
				+ "','"
				+ demandBean.getJZXQNF()
				+ "','"
				+ demandBean.getZDKJXQGS()
				+ "','"
				+ demandBean.getGJZ()
				+ "','"
				+ demandBean.getYJLX()
				+ "','"
				+ demandBean.getXKFL1()
				+ "','"
				+ demandBean.getXKFL2()
				+ "','"
				+ demandBean.getXKFL3()
				+ "','"
				+ demandBean.getXQJSSSLY()
				+ "','"
				+ demandBean.getQTJSMS()
				+ "','"
				+ demandBean.getXQJSYYHY1()
				+ "','"
				+ demandBean.getXQJSYYHY2()
				+ "','"
				+ demandBean.getXQJSYYHY3()
				+ "','"
				+ demandBean.getJSXQHZMS()
				+ "','"
				+ demandBean.getHZYXDW()
				+ "','"
				+ demandBean.getNTR()
				+ "','"
				+ demandBean.getCreateDate() + "')";

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
	 * �ж��Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	public boolean check(String JSXQMC)
	{
		// ����һ��ʼ����ע�ᣬ�����ֵ��Ϊtrue
		boolean flag = true;
		ResultSet rs = null;
		try
		{
			rs = ApplicationContextFactory.getResultSet("select JSXQMC from T_DCWJXX");
			while (rs.next())
			{
				if (JSXQMC.equals(rs.getString("JSXQMC")))
				{
					// ���ݱ����Ѵ��ڴ��˺���˵����������ӣ������ֵ��Ϊfalse
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
	 * ��ʾ�����о�������������
	 * 
	 * @return SELECT * FROM dbo.Member WHERE ID IN (SELECT MIN(ID) FROM
	 *         dbo.Member GROUP BY Name)
	 */
	public List<String> getTypeList()
	{
		String sql = "select distinct YJLX from T_DCWJXX";
		ResultSet rs = null;
		List<String> YJLXs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String YJLX;
			while (rs.next())
			{
				YJLX = rs.getString("YJLX");
				YJLXs.add(YJLX);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return YJLXs;
	}

	/* ��ʾѧ�Ʒ����һ�� */
	public List<String> getXKFLListA()
	{
		String sql = "select distinct XKFL1 from T_DCWJXX";
		ResultSet rs = null;
		List<String> XKFLs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String XKFL = null;
			while (rs.next())
			{
				XKFL = rs.getString("XKFL1");
				if (!XKFL.equals("0"))
				{
					XKFLs.add(XKFL);
				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return XKFLs;
	}

	/* ��ʾѧ�Ʒ���ڶ��� */
	public List<String> getXKFLListB(String type)
	{
		String sql = "select distinct XKFL2 from T_DCWJXX where XKFL1='" + type
				+ "'";
		ResultSet rs = null;
		List<String> XKFLs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String XKFL = null;
			while (rs.next())
			{
				XKFL = rs.getString("XKFL2");
				if (!XKFL.equals("0"))
				{
					XKFLs.add(XKFL);
				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return XKFLs;
	}

	/* ��ʾѧ�Ʒ�������� */
	public List<String> getXKFLListC(String type)
	{
		String sql = "select distinct XKFL3 from T_DCWJXX where XKFL2='" + type
				+ "'";
		ResultSet rs = null;
		List<String> XKFLs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String XKFL = null;
			while (rs.next())
			{
				XKFL = rs.getString("XKFL3");
				if (!XKFL.equals("0"))
				{
					XKFLs.add(XKFL);
				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return XKFLs;
	}

	/* ��ʾ���񾭼���ҵ��һ�� */
	public List<String> getXQJSYYHYListA()
	{
		String sql = "select distinct XQJSYYHY1 from T_DCWJXX";
		ResultSet rs = null;
		List<String> XQJSYYHYs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String XQJSYYHY = null;
			while (rs.next())
			{
				XQJSYYHY=rs.getString("XQJSYYHY1");
				if (!XQJSYYHY.equals("0"))
				{
					XQJSYYHYs.add(XQJSYYHY);
				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return XQJSYYHYs;
	}

	/* ��ʾ���񾭼÷���ڶ��� */
	public List<String> getXQJSYYHYListB(String type)
	{
		String sql = "select distinct XQJSYYHY2 from T_DCWJXX where XQJSYYHY1='"
				+ type + "'";
		ResultSet rs = null;
		List<String> XQJSYYHYs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String XQJSYYHY = null;
			while (rs.next())
			{
				XQJSYYHY = rs.getString("XQJSYYHY2");
				if (!XQJSYYHY.equals("0"))
				{
					XQJSYYHYs.add(XQJSYYHY);
				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return XQJSYYHYs;
	}

	/* ��ʾ���񾭼���ҵ��������� */
	public List<String> getXQJSYYHYListC(String type)
	{
		String sql = "select distinct XQJSYYHY3 from T_DCWJXX where XQJSYYHY2='"
				+ type + "'";
		ResultSet rs = null;
		List<String> XQJSYYHYs = new ArrayList<String>();
		try
		{
			rs = ApplicationContextFactory.getResultSet(sql);
			String XQJSYYHY = null;
			while (rs.next())
			{
				XQJSYYHY = rs.getString("XQJSYYHY3");
				if (!XQJSYYHY.equals("0"))
				{
					XQJSYYHYs.add(XQJSYYHY);
				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return XQJSYYHYs;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getList(String next)
	{
		String sql = "select * from T_DCWJXX where YJLX='" + next + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListAX(String next)
	{
		String sql = "select * from T_DCWJXX where XKFL1='" + next + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListBX(String next, String parent)
	{
		String sql = "select * from T_DCWJXX where XKFL2='" + next
				+ "' and XKFL1='" + parent + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListCX(String next, String parent)
	{
		String sql = "select * from T_DCWJXX where XKFL3='" + next
				+ "' and XKFL2='" + parent + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListAH(String next)
	{
		String sql = "select * from T_DCWJXX where XQJSYYHY1='" + next + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListBH(String next, String parent)
	{
		String sql = "select * from T_DCWJXX where XQJSYYHY2='" + next
				+ "' and XQJSYYHY1='" + parent + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListCH(String next, String parent)
	{
		String sql = "select * from T_DCWJXX where XQJSYYHY3='" + next
				+ "' and XQJSYYHY2='" + parent + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * ���б���ʽ��ʾ
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getList()
	{
		String sql = "select * from T_DCWJXX";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * ���б���ʽ��ʾ,�û����ύ���ʾ�
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getMyList(String username)
	{
		String sql = "select * from T_DCWJXX where username='" + username + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * ������������,ͨ��name
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getByName(String JSXQMC)
	{
		String sql = "select * from T_DCWJXX where JSXQMC like '%" + JSXQMC
				+ "%'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * ��ϸ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public T_DCWJXX getById(String WJID)
	{
		String sql = "select * from T_DCWJXX where WJID='" + WJID + "'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls.get(0);
	}

	/**
	 * ���б���ʽ��ʾδ��˵�������Ϣ
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T_DCWJXX> getListNo()
	{
		String sql = "select * from T_DCWJXX where SFSH='0'";
		List<T_DCWJXX> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			ls = session.createSQLQuery(sql).addEntity(T_DCWJXX.class).list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * ������˵�״̬
	 */
	public boolean updateSFSH(String WJID, int SFSH, String V)
	{
		String sql = "update T_DCWJXX set SFSH='" + SFSH + "',V='" + V
				+ "' where WJID='" + WJID + "'";
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
