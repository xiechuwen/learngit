SELECT * FROM demo.dept;
insert into dept values(0,'开发部')
insert into dept values(0,'产品部')
insert into dept values(0,'人事部')
insert into dept values(0,'总经办')

select * from position
insert into position values(0,'员工')
insert into position values(0,'组长')
insert into position values(0,'经理')

select * from type

insert into type values(0,'需求问题')
insert into type values(0,'BUG问题')
insert into type values(0,'其他问题')

select * from stype 
insert into stype values(0,'需求分析',1)
insert into stype values(0,'需求扩展',1)
insert into stype values(0,'需求难点',1)

insert into stype values(0,'JavaBUG',2)
insert into stype values(0,'AndroidBUG',2)
insert into stype values(0,'IosBUG',2)
insert into stype values(0,'编译BUG',2)
insert into stype values(0,'运行BUG',2)
insert into stype values(0,'其他BUG',2)


insert into stype values(0,'个人问题',3)
insert into stype values(0,'经费问题',3)
insert into stype values(0,'技术问题',3)
insert into stype values(0,'其他问题',3)

select * from emp

insert into emp values(0,'jack','JACK','jack',1,1)
insert into emp values(0,'bob','BOB','bob',1,2)

insert into emp values(0,'smith','SMITH','smith',2,1)
insert into emp values(0,'kaven','KAVEN','kaven',2,2)

insert into emp values(0,'jim','JIM','jim',3,1)
insert into emp values(0,'allen','ALLEN','allen',3,2)

insert into emp values(0,'bramble','BRAMBLE','bramble',4,3)


select * from message 

insert into message values(0,'2017-08-09','2017-08-07','服务器有问题,启动失败','已提交,待处理',3,4,2)