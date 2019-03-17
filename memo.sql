
2.1 标签表模型
-便签表
-编号 标题 内容 是否私密
-背景颜色 是否提醒 提醒时间
-创建时间 修改时间 所属分组

create table if not exists memo(
id int primary key aotu_increcment comment'标签编号',
title varchar(30) comment'标签标题',
content varchar(100) not null comment'标签内容',
is_select bit(1) comment'是否隐私,0非私密,1私密',
background enmun('红','黄','绿','蓝')comment'背景颜色',
is_call enmun('是','否')comment'是否提醒',
call_time datetime comment'提醒时间',
create_time datetime comment'创建时间',
modify_time timestamp comment'修改时间',
group int comment'分组编号'
);

2.2 标签组模型
-标签组
-编号 组名称 创建时间 修改时间
create tables if not exists memo_group(
id int primary key aotu_increcment comment'分组编号',
group_name varchar(10) not null comment'分组名称',
create_time datetime comment'创建时间',
modify_time timestamp comment'修改时间'
foreign key id references memo(groups)
);

2.3 便签分享模型
-便签分享
-编号 标签编号 分享备注 分享时间

create table if not exists memo_share(
id int primary key aotu_increcment comment'分享编号',
memo_id int not null comment'标签编号',
share_mark varchar(30) comment'分享备注',
share_time datetime comment'分享时间'
foreign key memo_id references memo(id)
);





















