layui.use('table', function(){
	  var table = layui.table;
	  
	  table.render({
	    elem: '#test'//table的id
	    ,url:'/user/userMainData'//路径
	    ,toolbar: '#toolbarDemo' //表格上方按钮
	    ,cols: [[//表格数据
	      {field:'id', title: '序号', type:'numbers'}
	      ,{field:'username', title: '用户名'}
	      ,{field:'phoneNumber', title: '手机号'}
	      ,{field:'inTime', title: '入会时间',sort: true}
	      ,{field:'address', title: '详细地址'}
	      ,{field:'tag', title: '角色'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:130}
	    ]]
	    ,method:'post'
	    ,page: true//分页
	  });
	  
	});