layui.use('table', function(){
	  var table = layui.table;
	  
	  table.render({
	    elem: '#test'//table的id
	    ,url:'/class/classMainData'//路径
	    ,toolbar: '#toolbarDemo' //表格上方按钮
	    ,cols: [[//表格数据
	      {field:'id', title: 'ID', sort: true}
	      ,{field:'className', title: '课程名'}
	      ,{field:'classIntroduction', title: '课程介绍'}
	      ,{field:'classNumber', title: '课程人数'}
	      ,{field:'orderNumber', title: '已预定人数'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:130}
	    ]]
	    ,method:'post'
	    ,page: true//分页
	  });
	  
	});