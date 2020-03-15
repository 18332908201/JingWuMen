layui.use('table', function(){
	  var table = layui.table;
	  
	  table.render({
	    elem: '#test'//table的id
	    ,url:'/notice/noticeMainData'//路径
	    ,toolbar: '#toolbarDemo' //表格上方按钮
	    ,cols: [[//表格数据
	      {field:'id', title: 'ID', sort: true}
	      ,{field:'title', title: '标题'}
	      ,{field:'body', title: '内容主体'}
	      ,{field:'createTime', title: '创建时间',sort: true}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:130}
	    ]]
	    ,method:'post'
	    ,page: true//分页
	  });
	  
	});