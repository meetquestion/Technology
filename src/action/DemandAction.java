package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import tools.ApplicationContextFactory;
import tools.Constants;
import tools.StringUtil;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import model.Admin;
import model.Tongjibean;
import dao.AdminDao;
import model.Code;
import dao.CodeDao;
import model.T_DCWJXX;
import dao.DemandDao;
import model.FirstH;
import dao.FirstHDao;
import model.FirstX;
import dao.FirstXDao;
import model.PagingBean;

public class DemandAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");

		if ("info".equals(method))
		{
			info(request, response);
		} else if ("addInfo".equals(method))
		{
			addInfo(request, response);
		} else if ("list".equals(method))
		{
			list(request, response);
		} else if ("list_type".equals(method))
		{
			list_type(request, response);
		} else if ("listFen".equals(method))
		{
			listFen(request, response);
		} else if ("selectList".equals(method))
		{
			selectList(request, response);
		} else if ("details".equals(method))
		{
			details(request, response);
		} else if ("myList".equals(method))
		{
			myList(request, response);// 我的需求问卷
		} else if ("myDetails".equals(method))
		{
			myDetails(request, response);// 我的需求问卷详情
		} else if ("list".equals(method))
		{
			list(request, response);
		} else if ("details".equals(method))
		{
			details(request, response);
		} else if ("preType".equals(method))
		{
			preType(request, response);
		} else if ("getNextA".equals(method))
		{
			getNextA(request, response);
		} else if ("getNextBX".equals(method))
		{
			getNextBX(request, response);
		} else if ("getNextCX".equals(method))
		{
			getNextCX(request, response);
		} else if ("getNextBH".equals(method))
		{
			getNextBH(request, response);
		} else if ("getNextCH".equals(method))
		{
			getNextCH(request, response);
		} else if ("getList".equals(method))
		{
			getList(request, response);
		} else if ("getListAX".equals(method))
		{
			getListAX(request, response);
		} else if ("getListBX".equals(method))
		{
			getListBX(request, response);
		} else if ("getListCX".equals(method))
		{
			getListCX(request, response);
		} else if ("getListAH".equals(method))
		{
			getListAH(request, response);
		} else if ("getListBH".equals(method))
		{
			getListBH(request, response);
		} else if ("getListBH".equals(method))
		{
			getListCH(request, response);
		} else if ("tongji".equals(method))
		{
			tongji(request, response);
		} else if ("check".equals(method))
		{
			check(request, response);// 更改审核的状态
		} else if ("demandList".equals(method))
		{
			demandList(request, response);
		} else if ("selectDemandList".equals(method))
		{
			selectDemandList(request, response);
		} else if ("demandDetails".equals(method))
		{
			demandDetails(request, response);
		} else if ("shenhechaxun".equals(method))
		{
			shenhechaxun(request, response);
		}
		return super.execute();
	}

	private void info(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		Admin admin = new Admin();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		admin = adminDao.getByUsername(username);

		try
		{
			Code codeBean = new Code();
			CodeDao codeDao = (CodeDao) application.getBean("myCodeDao");
			codeBean = codeDao.getByNum(admin.getCode());
			String code_name = codeBean.getCode_name();

			T_DCWJXX demandBean = new T_DCWJXX();
			demandBean.setJGMC(code_name);
			demandBean.setYZBM(admin.getPostal());
			demandBean.setTXDZ(admin.getAddress());
			// 需求编号，自动生成
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String WJID = formatter.format(currentTime);
			demandBean.setWJID(WJID);

			// 搜出一级学科分类
			FirstXDao firstXDao = (FirstXDao) application
					.getBean("myFirstXDao");
			List<FirstX> firstXBeans = firstXDao.getFirstList();

			// 搜出一级国民经济分类
			FirstHDao firstHDao = (FirstHDao) application
					.getBean("myFirstHDao");
			List<FirstH> firstHBeans = firstHDao.getFirstList();

			request.setAttribute("demandBean", demandBean);
			request.setAttribute("firstXBeans", firstXBeans);
			request.setAttribute("firstHBeans", firstHBeans);

			request.getRequestDispatcher("my/addInfo.jsp").forward(request,
					response);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void addInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String WJID = request.getParameter("WJID");
		String JGMC = request.getParameter("JGMC");
		String GLBM = request.getParameter("GLBM");
		String TXDZ = request.getParameter("TXDZ");
		String SZDY = request.getParameter("SZDY");
		String DWWZ = request.getParameter("DWWZ");
		String DZYX = request.getParameter("DZYX");
		String FRDB = request.getParameter("FRDB");
		String YZBM = request.getParameter("YZBM");
		String LXR = request.getParameter("LXR");
		String GDDH = request.getParameter("GDDH");
		String YDDH = request.getParameter("YDDH");
		String CZ = request.getParameter("CZ");
		String JGSX = request.getParameter("JGSX");
		String JGJJ = request.getParameter("JGJJ");
		String JSXQMC = request.getParameter("JSXQMC");
		int QSXQNF = Integer.parseInt(request.getParameter("QSXQNF"));
		int JZXQNF = Integer.parseInt(request.getParameter("JZXQNF"));
		String ZDKJXQGS1 = "1、主要问题：<p>" + request.getParameter("ZDKJXQGS1");
		String ZDKJXQGS2 = "<p>2、技术关键:<p>" + request.getParameter("ZDKJXQGS2");
		String ZDKJXQGS3 = "<p>3、预期目标:<p>" + request.getParameter("ZDKJXQGS3");
		String ZDKJXQGS = ZDKJXQGS1 + ZDKJXQGS2 + ZDKJXQGS3;
		String GJZ = "";
		String GJZ1 = request.getParameter("GJZ1");
		String GJZ2 = request.getParameter("GJZ2");
		String GJZ3 = request.getParameter("GJZ3");
		String GJZ4 = request.getParameter("GJZ4");
		String GJZ5 = request.getParameter("GJZ5");
		GJZ = GJZ1 + GJZ2 + GJZ3 + GJZ4 + GJZ5;
		String NTR = request.getParameter("NTR");
		String JSXQHZMS = request.getParameter("JSXQHZMS");
		String HZYXDW = request.getParameter("HZYXDW");
		String YJLX = request.getParameter("YJLX");

		String XKFL1 = request.getParameter("FirstXId");
		String XKFL2 = request.getParameter("SecondXId");
		String XKFL3 = request.getParameter("ThirdXId");

		/**
		 * 需求技术所属领域，复选框
		 */
		String[] fiel = request.getParameterValues("XQJSSSLY");

		String XQJSSSLY = "";
		if (fiel != null)
		{
			for (int j = 0; j < fiel.length; j++)
			{
				XQJSSSLY += "," + fiel[j];
			}
		}

		String QTJSMS = request.getParameter("QTJSMS");

		String XQJSYYHY1 = request.getParameter("FirstHId");
		String XQJSYYHY2 = request.getParameter("SecondHId");
		String XQJSYYHY3 = request.getParameter("ThirdHId");

		SimpleDateFormat createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		T_DCWJXX demandBean = new T_DCWJXX();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		demandBean.setWJID(WJID);
		demandBean.setUsername(username);
		demandBean.setJGMC(JGMC);
		demandBean.setGLBM(GLBM);
		demandBean.setTXDZ(TXDZ);
		demandBean.setSZDY(SZDY);
		demandBean.setDWWZ(DWWZ);
		demandBean.setDZYX(DZYX);
		demandBean.setFRDB(FRDB);
		demandBean.setYZBM(YZBM);
		demandBean.setLXR(LXR);
		demandBean.setGDDH(GDDH);
		demandBean.setYDDH(YDDH);
		demandBean.setCZ(CZ);
		demandBean.setJGSX(JGSX);
		demandBean.setJGJJ(JGJJ);
		demandBean.setJSXQMC(JSXQMC);
		demandBean.setQSXQNF(QSXQNF);
		demandBean.setJZXQNF(JZXQNF);
		demandBean.setZDKJXQGS(ZDKJXQGS);
		demandBean.setGJZ(GJZ);
		demandBean.setNTR(NTR);
		demandBean.setYJLX(YJLX);
		demandBean.setXKFL1(XKFL1);
		demandBean.setXKFL2(XKFL2);
		demandBean.setXKFL3(XKFL3);
		demandBean.setXQJSSSLY(XQJSSSLY);
		demandBean.setQTJSMS(QTJSMS);

		demandBean.setXQJSYYHY1(XQJSYYHY1);
		demandBean.setXQJSYYHY2(XQJSYYHY2);
		demandBean.setXQJSYYHY3(XQJSYYHY3);	
		demandBean.setJSXQHZMS(JSXQHZMS);
		demandBean.setHZYXDW(HZYXDW);

		demandBean.setCreateDate(createDate.format(new Date()));

		boolean flag = demandDao.check(JSXQMC);

		if (flag)
		{// 不存在，添加成功
			demandDao.save(demandBean);
			response.sendRedirect("my/addInfo.jsp?status=0");
		} else
		{// 存在，添加失败
			response.sendRedirect("my/addInfo.jsp?status=1");
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String status = request.getParameter("status");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		int currentPage = StringUtil.StringToInt(request
				.getParameter("currentPage"));
		int countSize = demandDao.getCount();
		PagingBean pagingBean = new PagingBean(currentPage, countSize,
				Constants.PAGE_SIZE_5);
		List<T_DCWJXX> demandBeans = demandDao.getListByPage(currentPage
				* Constants.PAGE_SIZE_5, countSize);
		pagingBean.setPrefixUrl(request.getContextPath()
				+ "/DemandServlet?method=list");
		pagingBean.setAnd(true);
		request.setAttribute("demandBeans", demandBeans);
		request.setAttribute("pagingBean", pagingBean);

		if (status != null)
		{
			request.getRequestDispatcher("first/list.jsp?status=" + status)
					.forward(request, response);
		} else
		{
			request.getRequestDispatcher("first/list.jsp").forward(request,
					response);
		}
	}

	private void list_type(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		List<T_DCWJXX> demandBeans = demandDao.getList();

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("first/list_type.jsp").forward(request,
				response);
	}

	private void listFen(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

		String num = request.getParameter("num");// 查询依据的个数
		// 申明
		String q0 = null;
		String q1 = null;
		String q2 = null;
		String logic1 = null;
		String logic2 = null;
		String sType0 = null;
		String sType1 = null;
		String sType2 = null;
		if (request.getParameter("q0") != null)
		{
			q0 = request.getParameter("q0");
			sType0 = request.getParameter("sType0");
		}
		if (request.getParameter("q1") != null)
		{
			q1 = request.getParameter("q1");
			logic1 = request.getParameter("logic1");
			sType1 = request.getParameter("sType1");
		}
		if (request.getParameter("q2") != null)
		{
			q2 = request.getParameter("q2");
			logic2 = request.getParameter("logic2");
			sType2 = request.getParameter("sType2");
		}

		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> xx = demandDao.xdshPolicy(num, sType0, q0, logic1,
				sType1, q1, logic2, sType2, q2);
		request.getSession().setAttribute("xxbeans", xx);
		if (xx.size() != 0)
		{
			request.getRequestDispatcher("/first/list_type.jsp").forward(
					request, response);
		} else
		{
			response.sendRedirect(request.getContextPath()
					+ "/first/list_type.jsp?status=1");
		}
	}

	private void selectList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String JSXQMC = request.getParameter("JSXQMC");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getByName(JSXQMC);

		if (demandBeans != null)
		{
			request.setAttribute("demandBeans", demandBeans);
			request.getRequestDispatcher("first/list.jsp?status=0").forward(
					request, response);
		} else
		{
			request.getRequestDispatcher("first/list.jsp?status=1").forward(
					request, response);
		}
	}

	private void details(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String WJID = request.getParameter("WJID");
		T_DCWJXX demandBean = new T_DCWJXX();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		demandBean = demandDao.getById(WJID);
		request.setAttribute("demandBean", demandBean);

		request.getRequestDispatcher("first/details.jsp").forward(request,
				response);
	}

	private void myDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String WJID = request.getParameter("WJID");
		T_DCWJXX demandBean = new T_DCWJXX();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		demandBean = demandDao.getById(WJID);
		request.setAttribute("demandBean", demandBean);

		request.getRequestDispatcher("my/myDetails.jsp").forward(request,
				response);
	}

	private void myList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		List<T_DCWJXX> demandBeans = demandDao.getMyList(username);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("my/myList.jsp")
				.forward(request, response);
	}

	private void preType(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		List<String> YJLXs = demandDao.getTypeList();

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(YJLXs));
		out.flush();
		out.close();
	}

	private void getNextA(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		String type = request.getParameter("id");

		List<String> NEXTs = new ArrayList<String>();

		if (type.equals("基础研究"))
		{
			NEXTs = demandDao.getXKFLListA();// 第一级
		} else
		{
			NEXTs = demandDao.getXQJSYYHYListA();// 第一级
		}

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}

	private void getNextBX(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		String type = request.getParameter("id");

		List<String> NEXTs = new ArrayList<String>();

		NEXTs = demandDao.getXKFLListB(type);

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}

	private void getNextCX(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		String type = request.getParameter("id");

		List<String> NEXTs = new ArrayList<String>();

		NEXTs = demandDao.getXKFLListC(type);

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}

	private void getNextBH(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		String type = request.getParameter("id");

		List<String> NEXTs = new ArrayList<String>();

		NEXTs = demandDao.getXQJSYYHYListB(type);

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}

	private void getNextCH(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		String type = request.getParameter("id");

		List<String> NEXTs = new ArrayList<String>();

		NEXTs = demandDao.getXQJSYYHYListC(type);

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}

	private void getList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getList(NEXT);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void getListAX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getListAX(NEXT);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void getListBX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		String parent = request.getParameter("parentId");

		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getListBX(NEXT, parent);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void getListCX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		String parent = request.getParameter("parentId");

		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getListCX(NEXT, parent);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void getListAH(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getListAH(NEXT);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void getListBH(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		String parent = request.getParameter("parentId");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getListBH(NEXT, parent);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void getListCH(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String NEXT = request.getParameter("id");
		String parent = request.getParameter("parentId");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getListCH(NEXT, parent);

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("type/demandList.jsp").forward(request,
				response);
	}

	private void tongji(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		Tongjibean tongjibean = demandDao.tongji();
		tongjibean.setWeishenhe1(tongjibean.jiussuan(tongjibean.getWeishenhe(),
				tongjibean.getZong()));
		tongjibean.setShenhe1(tongjibean.jiussuan(tongjibean.getShenhe(),
				tongjibean.getZong()));
		tongjibean.setTongguo1(tongjibean.jiussuan(tongjibean.getTongguo(),
				tongjibean.getZong()));
		tongjibean.setTuihui1(tongjibean.jiussuan(tongjibean.getTuihui(),
				tongjibean.getZong()));

		request.setAttribute("tongjibean", tongjibean);
		request.getRequestDispatcher(
				"jquery-css3-vote-bar-150326231418/tongji.jsp").forward(
				request, response);
	}

	private void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");

		String WJID = request.getParameter("WJID");
		int SFSH = Integer.parseInt(request.getParameter("SFSH"));
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		if (SFSH == 1)
		{
			demandDao.updateSFSH(WJID, SFSH, "空");
		} else
		{
			String V = request.getParameter("V");
			demandDao.updateSFSH(WJID, SFSH, V);
		}// 成功

		request.getRequestDispatcher("check/demandDetails.jsp?status=1")
				.forward(request, response);// 审核成功
	}

	private void demandList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");
		List<T_DCWJXX> demandBeans = demandDao.getListNo();

		request.setAttribute("demandBeans", demandBeans);
		request.getRequestDispatcher("check/demandList.jsp").forward(request,
				response);
	}

	private void selectDemandList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");

		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> demandBeans = demandDao.getByName(name);

		if (demandBeans != null)
		{
			request.setAttribute("demandBeans", demandBeans);
			request.getRequestDispatcher("check/demandList.jsp").forward(
					request, response);
		} else
		{
			request.getRequestDispatcher("check/demandList.jsp?status=1")
					.forward(request, response);
		}
	}

	private void demandDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String WJID = request.getParameter("WJID");

		T_DCWJXX demandBean = new T_DCWJXX();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		demandBean = demandDao.getById(WJID);
		request.setAttribute("demandBean", demandBean);

		request.getRequestDispatcher("check/demandDetails.jsp").forward(
				request, response);
	}

	private void shenhechaxun(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");// 查询依据的个数

		// 申明
		String q0 = null;
		String q1 = null;
		String q2 = null;
		String logic1 = null;
		String logic2 = null;
		String sType0 = null;
		String sType1 = null;
		String sType2 = null;
		if (request.getParameter("q0") != null)
		{
			q0 = request.getParameter("q0");
			sType0 = request.getParameter("sType0");
		}
		if (request.getParameter("q1") != null)
		{
			q1 = request.getParameter("q1");
			logic1 = request.getParameter("logic1");
			sType1 = request.getParameter("sType1");
		}
		if (request.getParameter("q2") != null)
		{
			q2 = request.getParameter("q2");
			logic2 = request.getParameter("logic2");
			sType2 = request.getParameter("sType2");
		}

		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		DemandDao demandDao = (DemandDao) application.getBean("myDemandDao");

		List<T_DCWJXX> xx = demandDao.xdshPolicy(num, sType0, q0, logic1,
				sType1, q1, logic2, sType2, q2);

		request.getSession().setAttribute("xxbeans", xx);
		if (xx.size() != 0)
		{
			request.getRequestDispatcher("/first/Type.jsp").forward(request,
					response);
		} else
		{
			response.sendRedirect(request.getContextPath()
					+ "/first/Type.jsp?status=1");
		}

	}
}