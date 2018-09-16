package model;

public class T_DCWJXX implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private String WJID;//需求编号
	private String username;	//用户名
	private String SZDY;//所在地域
	private int SFSH;	//0表示未通过，1表示通过，缺省取值为0
	private String V;
	private String JGMC;//机构全称
	private String GLBM;//归口管理部门
	private String TXDZ;//通讯地址
	private String DWWZ;//网址
	private String DZYX;//电子邮箱
	private String FRDB;//法人代表
	private String YZBM;//邮政编码
	private String LXR;//联系人
	private String GDDH;//固定电话
	private String YDDH;//移动电话
	private String CZ;//传真
	private String JGSX;//机构属性
	private String JGJJ;//机构简介
	private String JSXQMC;//技术需求名称
	private Integer QSXQNF;
	private Integer JZXQNF;
	private String ZDKJXQGS;
	private String GJZ;
	private String YJLX;
	private String XKFL1;
	private String XKFL2;
	private String XKFL3;
	private String XQJSSSLY;
	private String QTJSMS;
	private String XQJSYYHY1;
	private String XQJSYYHY2;
	private String XQJSYYHY3;
	private String JSXQHZMS;
	private String HZYXDW;
	private String NTR;
	private String createDate;
	
	public T_DCWJXX()
	{
		super();
	}
	public T_DCWJXX(String wJID, String username, String sZDY, int sFSH,
			String jGMC, String gLBM, String tXDZ, String dWWZ, String dZYX,
			String fRDB, String yZBM, String lXR, String gDDH, String yDDH,
			String cZ, String jGSX, String jGJJ, String jSXQMC, Integer qSXQNF,
			Integer jZXQNF, String zDKJXQGS, String gJZ, String yJLX,
			String xKFL1, String xKFL2, String xKFL3, String xQJSSSLY,
			String qTJSMS, String xQJSYYHY1, String xQJSYYHY2,
			String xQJSYYHY3, String jSXQHZMS, String hZYXDW, String nTR,
			String createDate)
	{
		super();
		WJID = wJID;
		this.username = username;
		SZDY = sZDY;
		SFSH = sFSH;
		JGMC = jGMC;
		GLBM = gLBM;
		TXDZ = tXDZ;
		DWWZ = dWWZ;
		DZYX = dZYX;
		FRDB = fRDB;
		YZBM = yZBM;
		LXR = lXR;
		GDDH = gDDH;
		YDDH = yDDH;
		CZ = cZ;
		JGSX = jGSX;
		JGJJ = jGJJ;
		JSXQMC = jSXQMC;
		QSXQNF = qSXQNF;
		JZXQNF = jZXQNF;
		ZDKJXQGS = zDKJXQGS;
		GJZ = gJZ;
		YJLX = yJLX;
		XKFL1 = xKFL1;
		XKFL2 = xKFL2;
		XKFL3 = xKFL3;
		XQJSSSLY = xQJSSSLY;
		QTJSMS = qTJSMS;
		XQJSYYHY1 = xQJSYYHY1;
		XQJSYYHY2 = xQJSYYHY2;
		XQJSYYHY3 = xQJSYYHY3;
		JSXQHZMS = jSXQHZMS;
		HZYXDW = hZYXDW;
		NTR = nTR;
		this.createDate = createDate;
	}
	public String getWJID()
	{
		return WJID;
	}
	public void setWJID(String wJID)
	{
		WJID = wJID;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getSZDY()
	{
		return SZDY;
	}
	public void setSZDY(String sZDY)
	{
		SZDY = sZDY;
	}
	public int getSFSH()
	{
		return SFSH;
	}
	public void setSFSH(int sFSH)
	{
		SFSH = sFSH;
	}
	public String getJGMC()
	{
		return JGMC;
	}
	public void setJGMC(String jGMC)
	{
		JGMC = jGMC;
	}
	public String getGLBM()
	{
		return GLBM;
	}
	public void setGLBM(String gLBM)
	{
		GLBM = gLBM;
	}
	public String getTXDZ()
	{
		return TXDZ;
	}
	public void setTXDZ(String tXDZ)
	{
		TXDZ = tXDZ;
	}
	public String getDWWZ()
	{
		return DWWZ;
	}
	public void setDWWZ(String dWWZ)
	{
		DWWZ = dWWZ;
	}
	public String getDZYX()
	{
		return DZYX;
	}
	public void setDZYX(String dZYX)
	{
		DZYX = dZYX;
	}
	public String getFRDB()
	{
		return FRDB;
	}
	public void setFRDB(String fRDB)
	{
		FRDB = fRDB;
	}
	public String getYZBM()
	{
		return YZBM;
	}
	public void setYZBM(String yZBM)
	{
		YZBM = yZBM;
	}
	public String getLXR()
	{
		return LXR;
	}
	public void setLXR(String lXR)
	{
		LXR = lXR;
	}
	public String getGDDH()
	{
		return GDDH;
	}
	public void setGDDH(String gDDH)
	{
		GDDH = gDDH;
	}
	public String getYDDH()
	{
		return YDDH;
	}
	public void setYDDH(String yDDH)
	{
		YDDH = yDDH;
	}
	public String getCZ()
	{
		return CZ;
	}
	public void setCZ(String cZ)
	{
		CZ = cZ;
	}
	public String getJGSX()
	{
		return JGSX;
	}
	public void setJGSX(String jGSX)
	{
		JGSX = jGSX;
	}
	public String getJGJJ()
	{
		return JGJJ;
	}
	public void setJGJJ(String jGJJ)
	{
		JGJJ = jGJJ;
	}
	public String getJSXQMC()
	{
		return JSXQMC;
	}
	public void setJSXQMC(String jSXQMC)
	{
		JSXQMC = jSXQMC;
	}
	public Integer getQSXQNF()
	{
		return QSXQNF;
	}
	public void setQSXQNF(Integer qSXQNF)
	{
		QSXQNF = qSXQNF;
	}
	public Integer getJZXQNF()
	{
		return JZXQNF;
	}
	public void setJZXQNF(Integer jZXQNF)
	{
		JZXQNF = jZXQNF;
	}
	public String getZDKJXQGS()
	{
		return ZDKJXQGS;
	}
	public void setZDKJXQGS(String zDKJXQGS)
	{
		ZDKJXQGS = zDKJXQGS;
	}
	public String getGJZ()
	{
		return GJZ;
	}
	public void setGJZ(String gJZ)
	{
		GJZ = gJZ;
	}
	public String getYJLX()
	{
		return YJLX;
	}
	public void setYJLX(String yJLX)
	{
		YJLX = yJLX;
	}
	public String getXKFL1()
	{
		return XKFL1;
	}
	public void setXKFL1(String xKFL1)
	{
		XKFL1 = xKFL1;
	}
	public String getXKFL2()
	{
		return XKFL2;
	}
	public void setXKFL2(String xKFL2)
	{
		XKFL2 = xKFL2;
	}
	public String getXKFL3()
	{
		return XKFL3;
	}
	public void setXKFL3(String xKFL3)
	{
		XKFL3 = xKFL3;
	}
	public String getXQJSSSLY()
	{
		return XQJSSSLY;
	}
	public void setXQJSSSLY(String xQJSSSLY)
	{
		XQJSSSLY = xQJSSSLY;
	}
	public String getQTJSMS()
	{
		return QTJSMS;
	}
	public void setQTJSMS(String qTJSMS)
	{
		QTJSMS = qTJSMS;
	}
	public String getXQJSYYHY1()
	{
		return XQJSYYHY1;
	}
	public void setXQJSYYHY1(String xQJSYYHY1)
	{
		XQJSYYHY1 = xQJSYYHY1;
	}
	public String getXQJSYYHY2()
	{
		return XQJSYYHY2;
	}
	public void setXQJSYYHY2(String xQJSYYHY2)
	{
		XQJSYYHY2 = xQJSYYHY2;
	}
	public String getXQJSYYHY3()
	{
		return XQJSYYHY3;
	}
	public void setXQJSYYHY3(String xQJSYYHY3)
	{
		XQJSYYHY3 = xQJSYYHY3;
	}
	public String getJSXQHZMS()
	{
		return JSXQHZMS;
	}
	public void setJSXQHZMS(String jSXQHZMS)
	{
		JSXQHZMS = jSXQHZMS;
	}
	public String getHZYXDW()
	{
		return HZYXDW;
	}
	public void setHZYXDW(String hZYXDW)
	{
		HZYXDW = hZYXDW;
	}
	public String getNTR()
	{
		return NTR;
	}
	public void setNTR(String nTR)
	{
		NTR = nTR;
	}
	public String getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
	public String getV()
	{
		return V;
	}
	public void setV(String v)
	{
		V = v;
	}
}