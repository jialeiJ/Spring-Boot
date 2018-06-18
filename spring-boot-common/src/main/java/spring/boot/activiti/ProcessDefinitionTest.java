package spring.boot.activiti;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
//import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ProcessDefinitionTest {
	
ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**部署流程定义(从classpath)*/
	@Test
	public void deploymentProcessDefinition_classpath(){
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署有关的Service
		                 .createDeployment()//创建一个部署对象
		                 .name("流程定义")//添加部署的名称
		                 .addClasspathResource("diagrams/helloworld.bpmn")//从classpath资源中加载,一次只能加载一个文件
		                 .addClasspathResource("diagrams/helloworld.png")//从classpath资源中加载,一次只能加载一个文件
		                 .deploy();//完成部署
		System.out.println("部署ID: "+deployment.getId());//
		System.out.println("部署名称: "+deployment.getName());//helloworld入门程序
		
	}
	
	/**部署流程定义(从zip)*/
	@Test
	public void deploymentProcessDefinition_zip(){
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("diagrams/helloworld.zip");
		ZipInputStream zipInputStream = new ZipInputStream(is);
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署有关的Service
		                 .createDeployment()//创建一个部署对象
		                 .name("流程定义")//添加部署的名称
		                 .addZipInputStream(zipInputStream)//指定zip格式文件完成部署
		                 .deploy();//完成部署
		System.out.println("部署ID: "+deployment.getId());//
		System.out.println("部署名称: "+deployment.getName());//helloworld入门程序
		
	}
	
	/**查询流程定义*/
	@Test
	public void findProcessDefinition(){
		List<ProcessDefinition> list = processEngine.getRepositoryService()//与流程定义和部署有关的Service
		                 .createProcessDefinitionQuery()//创建流程定义的查询
		                 /**指定查询条件,where条件*/
		                 //.deploymentId(deploymentId)//使用部署对象ID查询
		                 //.processDefinitionId(processDefinitionId)//使用流程定义ID查询
		                 //.processDefinitionKey(processDefinitionKey)//使用流程定义的key查询
		                 //.processDefinitionNameLike(processDefinitionNameLike)//使用流程定义的名称模糊查询
		                 
		                 /**排序*/
		                 .orderByProcessDefinitionVersion().asc()//按照版本的升序排列
		                 //.orderByProcessDefinitionName().desc()//按照流程定义的名称降序排列
		                 
		                 /**返回的结果集*/
		                 .list();//返回一个集合列表
		                 //.singleResult()//返回唯一结果集
		                 //.count()//结果集数量
		                 //.listPage(firstResult, maxResults)//分页查询
		if(list!=null && list.size()>0){
			for (ProcessDefinition processDefinition : list) {
				System.out.println("流程定义ID:  "+processDefinition.getId());//流程定义的key+版本+随机生成数
				System.out.println("流程定义的名称:  "+processDefinition.getName());//对应helloworld.bpmn文件中的name属性值
				System.out.println("流程定义的key:  "+processDefinition.getKey());//对应helloworld.bpmn文件中的id属性值
				System.out.println("流程定义的版本:  "+processDefinition.getVersion());//当流程定义的key值相同的情况下,版本升级,默认1
				System.out.println("资源名称bpmn文件:  "+processDefinition.getResourceName());
				System.out.println("资源名称png文件:  "+processDefinition.getDiagramResourceName());
				System.out.println("部署对象ID:  "+processDefinition.getDeploymentId());
				System.out.println("------------------------------------");
			}
		}
		
	}
	
	/**删除流程定义*/
	@Test
	public void deleteProcessDefinition(){
		//使用部署ID,完成删除
		String deploymentId = "1";
		/**
		 * 不带级联的删除
		 *    只能删除没有启动的流程(进行了部署但是没有启动,如果流程启动就会报异常)
		 */
		processEngine.getRepositoryService()//
		                 .deleteDeployment(deploymentId);
		
		/**
		 * 级联删除
		 *    不管流程是否启动,都能删除
		 */
		processEngine.getRepositoryService()
		                 .deleteDeployment(deploymentId, true);//默认为false
		System.out.println("删除成功");
	}
	
	/**查看流程图
	 * @throws Exception */
	@Test
	public void viewProcessPic() throws Exception{
		/**将生成的图片放在文件夹下*/
		String deploymentId = "";
		//获取图片资源名称
		List<String> list = processEngine.getRepositoryService()
				        .getDeploymentResourceNames(deploymentId);
		//定义图片资源的名称
		String resourceName = "";
		if(list!=null && list.size()>0){
			for (String name : list) {
				if(name.indexOf(".png")>=0){
					resourceName = name;
				}
			}
		}
		
		//获取图片的输入流
		InputStream is = processEngine.getRepositoryService()
				     .getResourceAsStream(deploymentId, resourceName);
		
		//将图片生成到D盘的目录下
		File file = new File("D:/"+resourceName);
		//将输入流的图片写到D盘下
		//FileUtils.copyInputStreamToFile(is, file);
	}
	

}
