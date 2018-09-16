package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SecondH;
import model.SecondX;
import model.ThirdH;
import model.ThirdX;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import tools.ApplicationContextFactory;
import tools.StringUtil;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

import dao.SecondHDao;
import dao.SecondXDao;
import dao.ThirdHDao;
import dao.ThirdXDao;

public class XQAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");

		if ("getSecondX".equals(method))
		{
			getSecondX(request, response);
		} else if ("getThirdX".equals(method))
		{
			getThirdX(request, response);
		} else if ("getSecondH".equals(method))
		{
			getSecondH(request, response);
		} else if ("getThirdH".equals(method))
		{
			getThirdH(request, response);
		}
		return super.execute();
	}

	private void getSecondX(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		int parentId = StringUtil.StringToInt(request.getParameter("id"));
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		SecondXDao secondXDao = (SecondXDao) application
				.getBean("mySecondXDao");
		List<SecondX> secondList = secondXDao.getSecondList(parentId);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(secondList));
		out.flush();
		out.close();
	}

	private void getThirdX(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		int parentId = StringUtil.StringToInt(request.getParameter("id"));
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		ThirdXDao thirdXDao = (ThirdXDao) application.getBean("myThirdXDao");
		List<ThirdX> thirdList = thirdXDao.getThirdList(parentId);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(thirdList));
		out.flush();
		out.close();
	}

	private void getSecondH(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		int parentId = StringUtil.StringToInt(request.getParameter("id"));
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		SecondHDao secondHDao = (SecondHDao) application
				.getBean("mySecondHDao");
		List<SecondH> secondList = secondHDao.getSecondList(parentId);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(secondList));
		out.flush();
		out.close();
	}

	private void getThirdH(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		int parentId = StringUtil.StringToInt(request.getParameter("id"));
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		ThirdHDao thirdHDao = (ThirdHDao) application.getBean("myThirdHDao");
		List<ThirdH> thirdList = thirdHDao.getThirdList(parentId);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(thirdList));
		out.flush();
		out.close();

	}
}