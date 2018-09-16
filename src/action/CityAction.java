package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.City;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import tools.ApplicationContextFactory;
import tools.StringUtil;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import dao.CityDao;

public class CityAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if ("getCity".equals(method))
		{
			getCity(request, response);
		}
		return super.execute();
	}

	private void getCity(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{

		int parentId = StringUtil.StringToInt(request.getParameter("id"));
		ApplicationContext application = ApplicationContextFactory
				.getApplicationContext();
		CityDao cityDao = (CityDao) application.getBean("myCityDao");
		List<City> cityList = cityDao.getCityList(parentId);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(cityList));
		out.flush();
		out.close();
	}

}