package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.Code;
import model.Province;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import tools.ApplicationContextFactory;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDao;
import dao.CodeDao;
import dao.ProvinceDao;

public class AdminAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception
	{
		// ApplicationContext application =
		// ApplicationContextFactory.getApplicationContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if ("login".equals(method))
		{
			login(request, response);
		} else if (("register").equals(method))
		{
			register(request, response);
		} else if ("ProvinceView".equals(method))
		{
			provinceView(request, response);
		} else if ("updateP".equals(method))
		{
			updateP(request, response);
		} else if ("end".equals(method))
		{
			end(request, response);
		} else if ("updateBefore".equals(method))
		{
			updateBefore(request, response);
		} else if ("update".equals(method))
		{
			update(request, response);
		} else if ("fenpeiBefore".equals(method))
		{
			fenpeiBefore(request, response);
		} else if ("addSFSH".equals(method))
		{
			addSFSH(request, response);
		} else if ("userList".equals(method))
		{
			userList(request, response);
		} else if ("updatePassword".equals(method))
		{
			updatePassword(request, response);
		} else if ("delete".equals(method))
		{
			delete(request, response);// 即不可登录
		}
		return super.execute();
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		Admin adminBean = new Admin();

		boolean flag = adminDao.checkReg(username);
		if (flag)
		{// 登录失败，username不存在
			response.sendRedirect(request.getContextPath()
					+ "/login.jsp?status=1"); // 不存在
		} else
		{
			// username存在
			adminBean = adminDao.check(username, password);
			if (adminBean != null)
			{// 密码正确
				System.out.println("密码正确");
				if (adminBean.getStatus() == 0)
				{
					request.getSession().setAttribute("adminBean", adminBean);
					response.sendRedirect(request.getContextPath()
							+ "/first/index.jsp");
				} else
				{
					request.getSession().setAttribute("adminBean", adminBean);
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}

			} else
			{// 密码不正确
				System.out.println("密码错误");
				response.sendRedirect(request.getContextPath()
						+ "/login.jsp?status=2");
			}
		}
	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String id_number = request.getParameter("id_number");
		String sex = request.getParameter("sex");
		int provinceId = Integer.parseInt(request.getParameter("ProvinceId"));
		int cityId = Integer.parseInt(request.getParameter("CityId"));
		String unit = request.getParameter("unit");
		String direction = request.getParameter("direction");
		String industry = request.getParameter("industry");
		String levels = request.getParameter("levels");
		String title = request.getParameter("title");
		String address = request.getParameter("address");
		String postal = request.getParameter("postal");
		String phone = request.getParameter("phone");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		String msn = request.getParameter("msn");

		Admin adminBean = new Admin();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");

		adminBean.setUsername(username);
		adminBean.setPassword(password);
		adminBean.setCode(code);
		adminBean.setName(name);
		adminBean.setId_number(id_number);
		adminBean.setSex(sex);
		adminBean.setProvinceId(provinceId);
		adminBean.setCityId(cityId);
		adminBean.setUnit(unit);
		adminBean.setDirection(direction);
		adminBean.setIndustry(industry);
		adminBean.setLevels(levels);
		adminBean.setTitle(title);
		adminBean.setAddress(address);
		adminBean.setPostal(postal);
		adminBean.setPhone(phone);
		adminBean.setTelephone(telephone);
		adminBean.setEmail(email);
		adminBean.setQq(qq);
		adminBean.setMsn(msn);

		boolean flag = adminDao.checkReg(username);
		if (flag)
		{// 不存在，注册成功
			adminDao.save(adminBean);
			response.sendRedirect("add.jsp?status=0");
		} else
		{// 存在，注册失败
			response.sendRedirect("add.jsp?status=1");
		}
	}

	private void provinceView(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		ProvinceDao provinceDao = (ProvinceDao) application
				.getBean("myProvinceDao");
		CodeDao codeDao = (CodeDao) application.getBean("myCodeDao");
		List<Province> provinceBeans = provinceDao.getProvinceList();
		// 找到机构代码的名称
		List<Code> codeBeans = codeDao.getCodeList();
		request.setAttribute("provinceBeans", provinceBeans);
		request.setAttribute("codeBeans", codeBeans);
		request.getRequestDispatcher("/servlet/add.jsp").forward(request, response);
	}

	private void updateP(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");// 原密码
		String p1 = request.getParameter("P1");
		String p2 = request.getParameter("P2");

		if (!p1.equals(password))
		{
			response.sendRedirect(request.getContextPath()
					+ "/my/myPass.jsp?status=0");
		} else
		{
			ApplicationContext application = ApplicationContextFactory
					.getApplicationContext();
			AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
			boolean flag = adminDao.update(username, p2);

			if (flag)
			{
				// 修改成功
				response.sendRedirect(request.getContextPath()
						+ "/my/myPass.jsp?status=1");
			} else
			{
				// 修改失败
				response.sendRedirect(request.getContextPath()
						+ "/my/myPass.jsp?status=2");
			}

		}
	}

	private void end(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		request.setCharacterEncoding("utf-8");
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	private void updateBefore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		Admin adminBean = adminDao.getByUsername(username);
		// 显示省份的LIST
		ProvinceDao provinceDao = (ProvinceDao) application
				.getBean("myProvinceDao");
		List<Province> provinceBeans = provinceDao.getProvinceList();
		request.setAttribute("provinceBeans", provinceBeans);
		request.setAttribute("adminBean", adminBean);
		request.getRequestDispatcher("/my/myInfo.jsp").forward(request,
				response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String id_number = request.getParameter("id_number");
		String sex = request.getParameter("sex");
		int provinceId = Integer.parseInt(request.getParameter("ProvinceId"));
		int cityId = Integer.parseInt(request.getParameter("CityId"));
		String unit = request.getParameter("unit");
		String direction = request.getParameter("direction");
		String industry = request.getParameter("industry");
		String levels = request.getParameter("levels");
		String title = request.getParameter("title");
		String address = request.getParameter("address");
		String postal = request.getParameter("postal");
		String phone = request.getParameter("phone");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		String msn = request.getParameter("msn");

		Admin adminBean = new Admin();
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");

		adminBean.setUsername(username);
		adminBean.setCode(code);
		adminBean.setName(name);
		adminBean.setId_number(id_number);
		adminBean.setSex(sex);
		adminBean.setProvinceId(provinceId);
		adminBean.setCityId(cityId);
		adminBean.setUnit(unit);
		adminBean.setDirection(direction);
		adminBean.setIndustry(industry);
		adminBean.setLevels(levels);
		adminBean.setTitle(title);
		adminBean.setAddress(address);
		adminBean.setPostal(postal);
		adminBean.setPhone(phone);
		adminBean.setTelephone(telephone);
		adminBean.setEmail(email);
		adminBean.setQq(qq);
		adminBean.setMsn(msn);

		boolean flag = adminDao.updateX(adminBean);
		if (flag)
		{// 更新成功
			response.sendRedirect("my/myInfo.jsp?status=0");
		} else
		{// 更新失败
			response.sendRedirect("my/myInfojspstatus=1");
		}
	}

	private void fenpeiBefore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		List<Admin> adminBeans = adminDao.getByStatus();

		request.setAttribute("adminBeans", adminBeans);
		request.getRequestDispatcher("first/fenpei.jsp").forward(request,
				response);
	}

	private void addSFSH(HttpServletRequest request,
			HttpServletResponse response)
	{

	}

	private void userList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		List<Admin> adminBeans = adminDao.getByStatusB();

		request.setAttribute("adminBeans", adminBeans);
		request.getRequestDispatcher("first/userList.jsp").forward(request,
				response);
	}

	private void updatePassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		adminDao.update(username, password);
		userList(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		AdminDao adminDao = (AdminDao) application.getBean("myAdminDao");
		String username = request.getParameter("username");
		adminDao.delete(username);
		userList(request, response);
	}
}