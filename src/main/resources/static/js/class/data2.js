layui.use('table', function(){
	  var table = layui.table;
	  
	  table.render({
	    elem: '#test'//table的id
	    ,url:'/class/classOrderShowData'//路径
	    ,cols: [[//表格数据
	      {field:'id', title: 'ID', sort: true}
	      ,{field:'userName', title: '用户名'}
	      ,{field:'className', title: '课程名'}
	      ,{field:'createTime', title: '创建时间'}
	    ]]
	    ,method:'post'
	    ,page: true//分页
	  });
	  
	});