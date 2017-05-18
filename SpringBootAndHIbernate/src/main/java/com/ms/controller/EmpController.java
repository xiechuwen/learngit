package com.ms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ms.pojo.Emp;
import com.ms.service.EmpService;

@Controller
@EnableAutoConfiguration
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	
	@RequestMapping("/showLogin")
	public ModelAndView showLogin(ModelAndView mav,HttpSession session){
	    /*    DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
	        String date2=df2.format(new Date(0, 0, 0));
	        Date.valueOf(date2);
	        System.out.println("d================="+date2);
	        int a= 10/0;*/
		/*Calendar now = Calendar.getInstance();
        System.out.println("年：" + now.get(Calendar.YEAR));
        System.out.println("月：" + (now.get(Calendar.MONTH) + 1));
        System.out.println("日：" + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时：" + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + now.get(Calendar.MINUTE));
        System.out.println("秒：" + now.get(Calendar.SECOND));
        */
/*        Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=  sdf.format(d);
        java.sql.Date date2=new java.sql.Date(0);
        System.out.println("当前时间：" +date );*/
		
		Calendar now = Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=(now.get(Calendar.MONTH) + 1);
		int day=now.get(Calendar.DAY_OF_MONTH);
		int hour=now.get(Calendar.HOUR_OF_DAY);
		int ninutes=now.get(Calendar.MINUTE);
		int s= now.get(Calendar.SECOND);
		String yearString=String.valueOf(year);
		String monthString=String.valueOf(month);
		String dayString=String.valueOf(day);
		String hourString=String.valueOf(hour);
		String ninutesString=String.valueOf(ninutes);
		String sString=String.valueOf(s);
		
		String allDate=yearString+"/"+monthString+"/"+monthString+" "+hourString+":"+ninutesString+":"+sString;
		System.out.println(allDate);
		
		
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav,Emp emp,HttpRequest request,HttpSession session){
		System.out.println(emp.getEmpName()+emp.getPassWord());
		Emp emp1=empService.queryEmpByPassWord(emp.getEmpName(), emp.getPassWord());
		if(emp1!=null){
			session.setAttribute("emp1", emp1);
			System.out.println("********************emp:"+emp1.getEmpName());
			mav.setViewName("redirect:addMessageInfo");
		}else{
			mav.setViewName("login");
		}
		return mav;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/queryAllEmpByDeptNo")
	public void queryAllEmpByDeptNo(int deptNo,HttpServletResponse response) throws IOException{
		List<Emp> elist=empService.queryAllEmpByDeptNo(deptNo);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");  
		PrintWriter writer=response.getWriter();
	
		JSONArray json=new JSONArray();
		for (Emp emp : elist) {
			JSONObject jo=new JSONObject();
			jo.put("empNo", emp.getEmpNo());
			jo.put("empRealName",emp.getEmpRealName());
			json.add(jo);
		}
		/*ObjectMapper mapper=new ObjectMapper();
		mapper.writeValueAsString(slist);*/
		/*String str=null;*/
	/*	JSONObject.toJSONString(slist);*/

		writer.print(json);
		writer.flush();
		writer.close();
		/*return slist;*/
	}
	
	
	@RequestMapping("/showUpload")
	public ModelAndView showUpload(ModelAndView mav){
		mav.setViewName("NewFile");
		return mav;
	}
	
	
	
	

    @RequestMapping(value = {"/uploadFile"}, method = RequestMethod.POST, produces = {"text/javascript;charset=UTF-8"})  
    @ResponseBody  
    public String uploadFile(HttpServletRequest request, HttpServletResponse response)  
        throws IllegalStateException, IOException  
    {  
    	String dirPath = request.getSession().getServletContext().getRealPath("/WEB-INF/files/");  
        // 创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver =  
            new CommonsMultipartResolver(request.getSession().getServletContext());  
        // 判断 request 是否有文件上传,即多部分请求  
        if (multipartResolver.isMultipart(request))  
        {  
            // 转换成多部分request  
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            // 取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
             //此处只上传单个文件，如果需要多个文件只需要改为while循环上传  
            if (iter.hasNext())  
            {  
                // 记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int)System.currentTimeMillis();  
                // 取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if (file != null)  
                {  
                    // 取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if (StringUtils.isNotEmpty(myFileName.trim()))  
                    {  
                  /*      String endpoint = "http://oss-cn-shanghai.aliyuncs.com";  
                        // accessKey请登录https://ak-console.aliyun.com/#/查看  
                        String accessKeyId = "*******";  
                        String accessKeySecret = "*******";  
                          
                        // 创建OSSClient实例  
                        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
                        ossClient.putObject("oss对象存储的空间名称", file.getOriginalFilename(), file.getInputStream());  
                        // 使用访问OSS  
                          
                        // 关闭ossClient  
                        ossClient.shutdown();  */
                    	
                    	//重命名上传后的文件名  
                        String fileName = file.getOriginalFilename();  
                        //定义上传路径  
                        
                        String contentType=file.getContentType();
                        long fileSize=file.getSize();
                        file.transferTo(new File(dirPath,fileName));
                    }  
                }  
                // 记录上传该文件后的时间  
              
            }  
              
        }  
        return "success";  
    }  
	
	
}
