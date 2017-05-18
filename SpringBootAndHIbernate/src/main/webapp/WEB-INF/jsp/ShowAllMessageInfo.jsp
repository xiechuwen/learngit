<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/css/showAllMessageInfo.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="top">
			SHOW ALL PROBLEM
		</div>
		
		
		<div id="left">
			<div id="main" style="width:100%;height:100%;">
				
			</div>
			
			<!-- echarts -->
			   <script src="/js/echarts.min.js"></script>
				  <script type="text/javascript">
				    
				  		var myChart = echarts.init(document.getElementById('main')); 
				  		
				  	 	//ｏｐｔｉｏｎ
				  	 	
								  	 	option = {
				    title : {
				        text: 'BUG类型do比例',
				        subtext: '数据为实',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:['需求问题','BUG问题','其他问题']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType : {
				                show: true, 
				                type: ['pie', 'funnel'],
				                option: {
				                    funnel: {
				                        x: '25%',
				                        width: '50%',
				                        funnelAlign: 'left',
				                        max: 1548
				                    }
				                }
				            },
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    series : [
				        {
				            name:'访问来源',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:[
				                {value:335, name:'需求问题'},
				                {value:310, name:'BUG问题'},
				                {value:234, name:'其他问题'}
				            ]
				        }
				    ]
				};
				                    
								  	    
				        myChart.setOption(option); 
				   
	   			 </script>
		</div>

		<div id="right">
			<div id="main2" style="width:100%;height:100%;">
				
			</div>
			
			
			  <script type="text/javascript">
				    
				  		var myChart = echarts.init(document.getElementById('main2')); 
				  		
				  	 	//ｏｐｔｉｏｎ
												  	 	
							option = {
				    title : {
				        text: '详细问题do比例',
				        subtext: '数据为实'
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['2016年', '2017年']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType: {show: true, type: ['line', 'bar']},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'value',
				            boundaryGap : [0, 0.01]
				        }
				    ],
				    yAxis : [
				        {
				            type : 'category',
				            data : ['需求分析','需求扩展','需求难点','JavaBUG','AndroidBUG','IosBUG','编译BUG','运行BUG','其他BUG','个人问题',
				            	'经费问题','技术问题','其他问题','问题次数(次)']
				        }
				    ],
				    series : [
				        {
				            name:'2011年',
				            type:'bar',
				            data:[18203, 23489, 29034, 104970, 131744, 630230,55477,18203, 23489, 29034, 104970, 131744, 630230]
				        },
				        {
				            name:'2012年',
				            type:'bar',
				            data:[19325, 23438, 31000, 121594, 134141, 681807,66588,19325, 23438, 31000, 121594, 134141, 681807]
				        }
				    ]
				};
                    
                    
				        myChart.setOption(option); 
				   
	   			 </script>
			
		</div>
		
		
		<div id="bottom">
			<div id="bottom-top">
				我的信息中心
			</div>
			
			<!--类型提示-->
			<div id="info-type">
				<div id="type-id">问题编号</div>
				<div id="type-title">问题标题</div>
				<div id="type-create">创建时间</div>
				<div id="type-modify">修改时间</div>
				<div id="type-emp">创建人</div>
				<div id="type-type">类型</div>
				<div id="type-status">状态</div>
				<div id="type-nextEmp">处理人</div>
				<!-- <div id="deal"><a href="#">de</a></div>
				<div id="modify"><a href="#">mo</a></div>
				<div id="remove"><a href="#">re</a></div> -->
				<div id="do">操作</div>
			</div>
			
			
			
			<c:forEach items="${messageList}" var="ml">
				<!--主信息-->
				<div id="info">
					<div class="info-id">${ml.messageId}</div>
					<div class="info-title">${ml.messageTitle}</div>
					<div class="info-create">${ml.messageCreateTime}</div>
					<div class="info-modify">${ml.messageModify}</div>
					<div class="info-emp">${ml.messageEmp.empRealName}</div>
					<div class="info-type">${ml.messageType.typeName}</div>
					<div class="info-status">${ml.status}</div>
					<div class="info-nextEmp">${ml.messageNextDealEmp.empRealName}</div>
					<div id="deal"><a href="showMessageAndMessageDetailInfo?messageId=${ml.messageId}&&realDeal=1">de</a></div>
					<div id="lo"><a href="showMessageAndMessageDetailInfo?messageId=${ml.messageId}&&realDeal=2">lo</a></div>
					<div id="remove"><a href="#">re</a></div>
				</div>
			</c:forEach>
		
			
		<!-- 	
		<div id="info">
				<div class="info-id">11</div>
				<div class="info-title">是是是撒大所大所多实打实是</div>
				<div class="info-create">1997-05-08</div>
				<div class="info-modify">1997-05-08</div>
				<div class="info-emp">小时代</div>
				<div class="info-type">实打实大所多</div>
				<div class="info-status">暗色群翁群无</div>
				<div class="info-nextEmp">撒大声地</div>
				<div id="deal"><a href="#">de</a></div>
				<div id="modify"><a href="#">mo</a></div>
				<div id="remove"><a href="#">re</a></div>
			</div>
			
			
			<div id="info">
				<div class="info-id">11</div>
				<div class="info-title">是是是撒大所大所多实打实是</div>
				<div class="info-create">1997-05-08</div>
				<div class="info-modify">1997-05-08</div>
				<div class="info-emp">小时代</div>
				<div class="info-type">实打实大所多</div>
				<div class="info-status">暗色群翁群无</div>
				<div class="info-nextEmp">撒大声地</div>
				<div id="deal"><a href="#">de</a></div>
				<div id="modify"><a href="#">mo</a></div>
				<div id="remove"><a href="#">re</a></div>
			</div>
			 -->
			
			<div id="page">
				<div class="page-select">f</div>
				<div class="page-select">b</div>
				<div class="page-select">１</div>
				<div class="page-select">２</div>
				<div class="page-select">３</div>
				<div class="page-select">４</div>
				<div class="page-select">５</div>
				<div class="page-select">n</div>
				<div class="page-select">l</div>
			</div>
		
			
		</div>
	</div>
</body>
</html>