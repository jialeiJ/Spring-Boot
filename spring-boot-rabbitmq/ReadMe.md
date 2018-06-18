一、windows下安装rabbitMQ及操作常用命令

	1.安装Erlang(有的选择其他的安装方式，可能需要添加一下系统环境变量
	2.安装RabbitMQ(默认安装的RabbitMQ 监听端口是5672)
	3.配置
		激活 RabbitMQ's Management Plugin
		使用RabbitMQ 管理插件，可以更好的可视化方式查看Rabbit MQ 服务器实例的状态。
		打开命令窗口：
		输入命令：
		"..\RabbitMQ Server\rabbitmq_server-3.6.5\sbin>"rabbitmq-plugins.bat enable rabbitmq_management
	4.需要重启服务才行，使用命令：
		net stop RabbitMQ && net start RabbitMQ
	5.创建用户，密码，绑定角色
		使用rabbitmqctl控制台命令（位于..\RabbitMQ Server\rabbitmq_server-3.6.5\sbin>）来创建用户，密码，绑定权限等。
		注意：安装路径不同的请看仔细啊。
		rabbitmq的用户管理包括增加用户，删除用户，查看用户列表，修改用户密码。
		①查看已有用户及用户的角色：
			rabbitmqctl.bat list_users
		②新增一个用户：
			rabbitmqctl.bat add_user username password
		③查看用户username后面没有[administrator]
			administrator涉及到用户角色问题：
			rabbitmq用户角色可分为五类：超级管理员, 监控者, 策略制定者, 普通管理者以及其他。
			(1) 超级管理员(administrator)
				可登陆管理控制台(启用management plugin的情况下)，可查看所有的信息，并且可以对用户，策略(policy)进行操作。
			(2) 监控者(monitoring)
				可登陆管理控制台(启用management plugin的情况下)，同时可以查看rabbitmq节点的相关信息(进程数，内存使用情况，磁盘使用情况等) 
			(3) 策略制定者(policymaker)
				可登陆管理控制台(启用management plugin的情况下), 同时可以对policy进行管理。
			(4) 普通管理者(management)
				仅可登陆管理控制台(启用management plugin的情况下)，无法看到节点信息，也无法对策略进行管理。
			(5) 其他的
		④用户也可以同时具有多个角色,设置方式:
			rabbitmqctl.bat  set_user_tags  username tag1 tag2 ...
		⑥更改密码：
			rabbitmqctl change_password userName newPassword
		⑦删除用户：
			rabbitmqctl.bat delete_user username
		⑧命令框是只有一个用户了，你怎么操作啊？怎么查看执行情况啊/
			使用浏览器打开 http://localhost:15672 访问Rabbit Mq的管理控制台，使用刚才创建的账号登陆系统：
			无法登陆管理控制台，通常就是普通的生产者和消费者。
		⑨其实，除了可查看所有的信息 ，上面的命令 增删改查、权限设置，都可以在这个页面完成，还可以依据业务需求设置策略(policy)。
			权限设置
				用户有了角色，那也需要权限设置啊，别急，慢慢来：
				按照官方文档，用户权限指的是用户对exchange，queue的操作权限，包括配置权限，读写权限。
				我们配置权限会影响到exchange、queue的声明和删除。
				读写权限影响到从queue里取消息、向exchange发送消息以及queue和exchange的绑定(binding)操作。
				例如： 将queue绑定到某exchange上，需要具有queue的可写权限，以及exchange的可读权限；向exchange发送消息需要具有exchange的可写权限；从queue里取数据需要具有queue的可读权限
			权限相关命令为：
			(1) 设置用户权限
				rabbitmqctl  set_permissions  -p  VHostPath  User  ConfP  WriteP  ReadP
			(2) 查看(指定hostpath)所有用户的权限信息
				rabbitmqctl  list_permissions  [-p  VHostPath]
			(3) 查看指定用户的权限信息
				rabbitmqctl  list_user_permissions  User
			(4)  清除用户的权限信息
				rabbitmqctl  clear_permissions  [-p VHostPath]  User
			现在环境搭好了，用户、角色、权限全部设置好，开始进行code（原理整理，及编码 待续）
			给 username 变成 “超级管理员” 角色：
				rabbitmqctl.bat set_user_tags username administrator
注：Windows下安装RabbitMQ报错：unable to perform an operation on node时的解决方案
	需要保持C:\Windows下的.erlang.cookie和C:\Users\Administrator下的.erlang.cookie一致，将C:\Windows\System32\config\systemprofile的.erlang.cookie
		用其中的一个文件中的内容完全替换掉其他两个，这样使三个文件保持一致，然后打开下面这个窗口