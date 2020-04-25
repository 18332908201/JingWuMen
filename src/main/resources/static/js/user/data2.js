layui.use('table', function(){
	  var table = layui.table;
	  
	  table.render({
	    elem: '#test'//table的id
	    ,url:'/user/userMainData'//路径
	    ,cols: [[//表格数据
	      {field:'id', title: '序号', type:'numbers'}
	      ,{field:'username', title: '用户名'}
	      ,{field:'tag', title: '角色',templet: '#switchTpl', unresize: true}
	    ]]
	    ,method:'post'
	    ,page: true//分页
	  });
	  
	  
	});