<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试</title>
<script type="text/javascript" src="jquery-1.11.0.min.js"></script>
</head>
<body>
   <table id="tab" border="1" width="600" style="border-style:hidden; border-width: 0.1em; ">
      <tr>
         <td><input name="quanxuan" type="checkbox"></td>
         <td>ID</td>
         <td>NAME</td>
         <td>AGE</td>
         <td>ADDRESS</td>
      </tr>
      <tr>
         <td><input type="checkbox"></td>
         <td>1</td>
         <td>2</td>
         <td>3</td>
         <td></td>
      </tr>
      <tr>
         <td><input type="checkbox"></td>
         <td>5</td>
         <td>6</td>
         <td>7</td>
         <td>8</td>
      </tr>
      <tr>
         <td><input type="checkbox"></td>
         <td>9</td>
         <td>10</td>
         <td>11</td>
         <td>12</td>
      </tr>
   </table>
   <input type="button" value="导出数据到桌面">

</body>
<script type="text/javascript">
//$("#tab tr").length;//行数
//$("#tab tr:eq(0) td").length;//列数
//$("#tab tr:eq(0) td")[0].innerHTML;//取值
var rows = $("#tab tr").length;
var cols = $("#tab tr:eq(0) td").length;
/* 全选与反选  */
$("input[name='quanxuan']").click(function(){
	if($(this).is(':checked')){
		$("#tab input[type=checkbox]").prop('checked',true);
		$("#tab tr:eq(0) td:eq(0)").find('input').is(':checked');
	}else{
		$("#tab input[type=checkbox]").prop('checked',false);
	}
	
});
/* 获取需要导入Execl的内容  */
function getResult(){
	var result="";
	for(var i=1;i<rows;i++){//行
		alert($("#tab tr:eq("+i+") td:eq(0)").find('input').is(':checked'));
		if($("#tab tr:eq("+i+") td:eq(0)").find('input').is(':checked')){
			for(var j=1;j<cols;j++){//列
			//if($("#tab tr:eq("+i+") td")[j].value)
				//alert($("#tab tr:eq("+i+") td")[j].innerHTML)
				if(j<cols-1){
					 result += $("#tab tr:eq("+i+") td")[j].innerHTML+",";
				}else{
					result += $("#tab tr:eq("+i+") td")[j].innerHTML+";";
				}
			}
		}
	}
	return result;
}
/* 发送导出Execl请求 */
$('input[type=button]').click(function(){
	$.ajax({
		type:'POST',
		url:'ExcelServlet',
		data:{
			result:getResult()
		},
		success:function(response,status,xhr){
			alert('导出成功');
		}
	});
});
</script>
</html>