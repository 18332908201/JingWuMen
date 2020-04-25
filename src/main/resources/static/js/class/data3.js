layui.use('table', function(){
	  var table = layui.table;
	  
	  table.render({
	    elem: '#test'//table的id
	    ,url:'/class/classMainData'//路径
	    ,cols: [[//表格数据
	      {field:'id', title: '序号', type:'numbers'}
	      ,{field:'className', title: '课程名'}
	      ,{field:'classIntroduction', title: '课程介绍'}
	      ,{field:'classNumber', title: '课程人数'}
	      ,{field:'orderNumber', title: '已预定人数'}
	    ]]
	    ,method:'post'
	    ,page: true//分页
	  });
	  
	});