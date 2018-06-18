package spring.boot.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloWorld {
	
ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**部署流程定义*/
	@Test
	public void deploymentProcessDefinition(){
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署有关的Service
		                 .createDeployment()//创建一个部署对象
		                 .name("helloworld入门程序")//添加部署的名称
		                 .addClasspathResource("diagrams/helloworld.bpmn")//从classpath资源中加载,一次只能加载一个文件
		                 .addClasspathResource("diagrams/helloworld.png")//从classpath资源中加载,一次只能加载一个文件
		                 .deploy();//完成部署
		System.out.println("部署ID: "+deployment.getId());//1
		System.out.println("部署名称: "+deployment.getName());//helloworld入门程序
		
	}
	
	/**启动流程实例*/
	@Test
	public void startProcessDefinition(){
		
		String processDefinitionKey = "helloworld";
		 ProcessInstance processInstance = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象有关的Service
		                 .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中的id的属性值
		System.out.println("流程实例ID: "+processInstance.getId());//流程实例ID   101
		System.out.println("流程定义ID: "+processInstance.getProcessDefinitionId());//流程定义ID  helloworld:1:4
		
	}
	
	/**查询当前人的个人任务*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "王五";//"李四";//"张三";
		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理有关的Service
		                 .createTaskQuery()//创建任务查询对象
		                 .taskAssignee(assignee)//指定个人任务查询，指定办理人
		                 .list();
		if(list!=null && list.size()>0){
			for (Task task : list) {
				System.out.println("任务ID:  "+task.getId());//任务ID:  104-任务ID:  202
				System.out.println("任务名称:  "+task.getName());//任务名称:  提交申请-任务名称:  审批【部门经理】
				System.out.println("任务的创建时间:  "+task.getCreateTime());//任务的创建时间:  Sun Aug 13 18:19:25 CST 2017-任务的创建时间:  Sun Aug 13 19:33:02 CST 2017
				System.out.println("任务的办理人:  "+task.getAssignee());//任务的办理人:  张三-任务的办理人:  李四
				System.out.println("流程实例ID:  "+task.getProcessInstanceId());//流程实例ID:  101-流程实例ID:  101
				System.out.println("执行对象ID:  "+task.getExecutionId());//执行对象ID:  101-执行对象ID:  101
				System.out.println("流程定义ID:  "+task.getProcessDefinitionId());//流程定义ID:  helloworld:1:4-流程定义ID:  helloworld:1:4
				System.out.println("----------------------------------");
			}
		}
	}
	/* 
	  任务ID:  104                               -任务ID:  202                              -任务ID:  302
	  任务名称:  提交申请                                                                            -任务名称:  审批【部门经理】                                                           -任务名称:  审批【总经理】
	  任务的创建时间:  Sun Aug 13 18:19:25 CST 2017 -任务的创建时间:  Sun Aug 13 19:33:02 CST 2017 -任务的创建时间:  Sun Aug 13 19:35:41 CST 2017
	  任务的办理人:  张三                                                                            -任务的办理人:  李四                                                                           -任务的办理人:  王五
	  流程实例ID:  101                            -流程实例ID:  101                            -流程实例ID:  101
	  执行对象ID:  101                            -执行对象ID:  101                            -执行对象ID:  101
	  流程定义ID:  helloworld:1:4                 -流程定义ID:  helloworld:1:4                 -流程定义ID:  helloworld:1:4
	*/
	
	/**完成我的任务*/
	@Test
	public void completeMyPersonalTask(){
		//任务ID
		String taskId = "202";//"104";//完成任务104后,李四可以查询自己任务,任务ID为202,完成任务202后王五可以查询自己的任务,完成王五任务就结束
		processEngine.getTaskService()//与正在执行的任务管理有关的Service
		                 .complete(taskId);
		System.out.println("完成任务ID为    "+taskId+" 的任务");
	}

}
