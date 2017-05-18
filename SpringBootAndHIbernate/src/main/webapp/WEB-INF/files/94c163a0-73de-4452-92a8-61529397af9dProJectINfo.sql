select * from dept 

 select * from position
 
 
 select * from emp
 
 insert into emp values(0,'test','SMITH','test',1,1)
 
 insert into emp values(0,'rest','JACK','rest',1,2)
  
 insert into emp values(0,'pomt','JUSTIN','pomt',2,1)
  
   insert into emp values(0,'kill','BOB','kill',2,2)
 
    insert into emp values(0,'free','KALY','free',3,1)
    
     insert into emp values(0,'dom','ROBERT','dom',3,null)
     
     update emp set emp_position=2 where emp_no=6
     
     insert into emp values(0,'sax','ALLEN','sax',4,1)
     
     insert into emp values(0,'for','HALLEN','for',4,2)
     
     insert into emp values(0,'boss','BRAMBEL','boss',5,null)
     update emp set emp_real_name='BRAMBLE' where emp_no =10
     delete from emp where emp_no=9
     
     
     
     select * from type;
     
     insert into type values(0,'需求')
     
      insert into type values(0,'BUG')
      
     insert into type values(0,'其他')
     
     
     select * from stype
     insert into stype values(0,'设计需求',1)
     insert into stype values(0,'扩展需求',1)
     insert into stype values(0,'修改需求',1)
     insert into stype values(0,'其他需求',1)
     
     
	insert into stype values(0,'javaBUG',2)
	insert into stype values(0,'AndroidBUG',2)
    insert into stype values(0,'IosBUG',2)
    insert into stype values(0,'编译BUG',2)
    insert into stype values(0,'运行BUG',2)
    
    
    insert into stype values(0,'数据报表',3)
    insert into stype values(0,'计划报表',3)
    insert into stype values(0,'其他私事',4)
    
    
select * from dept