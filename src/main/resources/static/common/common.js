/**
 *数据重载
 */
function reload2(tableId,curr,queryJson){
    var  jsonText;
 	table.reload(tableId, {
 		method:"post",
        page: {
          curr: curr //重新从第 1 页开始
        }
        ,where: queryJson
    });
}
/**
 * 弹出模态框 参数参见示例代码
 */
 function pubDialog(layerOpt){
 	var loaded;
	layerOpt.id="pubDialog-" + new Date().getTime();
	if(!layerOpt.width){
		layerOpt.width="800px";
	}
	if(!layerOpt.params){
		layerOpt.params={};
	}
	
	if(!layerOpt.height){
		layerOpt.height="600px";
	}
	layerOpt.width+=""
	layerOpt.height+=""
	if(layerOpt.width.indexOf("px")==-1){
		layerOpt.width+="px";
	}
	if(layerOpt.height.indexOf("px")==-1){
		layerOpt.height+="px";
	}
	
	//if(!layerOpt.top){
	//	layerOpt.top=true;
	//}
	//得到顶层
	//创建传值得表单
	var createForm = function (option, target){
		var dialogForm='<form id="dialogForm" action="'+option.url+'" method="post" target="'+target+'"></form>';
		$("body").append(dialogForm);
		if(option.params) {
			for(name1 in option.params) {
				$("#dialogForm").append('<input type="hidden" name="'+name1+ '" value="'+option.params[name1]+'">');
			}
		}
	}
	layerOpt.area = [layerOpt.width,"85%"];
	if(layerOpt.isAllHi){
		layerOpt.area = [layerOpt.width,layerOpt.height];
		}
	//layerOpt.content = "<c:url value="/pages/loading.html" />";
	layerOpt.type = 2;
	layerOpt.fixed = true;
	layerOpt.maxmin = false;
	layerOpt.resize = false;
   	layerOpt.anim = 2;
   	layerOpt.isOutAnim = 3;

   //layerOpt.offset = '3px';
   	//layerOpt.offset= 'r';
   	//layerOpt.shade = [0.1, '#999'];
   	layerOpt.shade = [0.1, '#999'];
   	//layerOpt.shadeClose = true;
	var success=layerOpt.success;
	layerOpt.success = function (object, index){
		if(!loaded){
			createForm(layerOpt,object.find("iframe[name^='layui-layer-iframe']")[0]["name"]);
			$("#dialogForm").submit();
		     $("#dialogForm").remove();
		     loaded=true;
		}
		opened_pub_dialog_index=index;
		if(success){
			success.call(this,object, index);
		}
	}

	var isChildFrame = false;
	if(window.name.indexOf("layui-layer-iframe")>-1){
		isChildFrame = true;
	}
	var returnFun = "returnValue";
	if(typeof(layerOpt.returnFun)!="undefined"){
		returnFun = layerOpt.returnFun;
	}
	
	if(typeof(layerOpt.callBackFun)!="undefined"){
		layerOpt.btn = ["确定"];
		 
		if(layerOpt.top){
			layerOpt.btn1 = function (index,obj){
				var frame=window.top.window[obj.find("iframe[name^='layui-layer-iframe']")[0]["name"]];
				var returnVal=frame.eval(returnFun + "()");
				if(returnVal!='notclose'){
					layerOpt.callBackFun.call(this, returnVal);
					window.top.layer.close(index);
				}
			}
		}else if(isChildFrame){
			layerOpt.btn1 = function (index,obj){
				var frame=parent.window[obj.find("iframe[name^='layui-layer-iframe']")[0]["name"]];
				var returnVal=frame.eval(returnFun + "()");
				if(returnVal!='notclose'){
					layerOpt.callBackFun.call(this, returnVal);
					parent.layer.close(index);
				}
			}
		} else {
			layerOpt.btn1 = function (index,obj){
				var frame=window[obj.find("iframe[name^='layui-layer-iframe']")[0]["name"]];
				var returnVal=frame.eval(returnFun + "()");
				if(returnVal!='notclose'){
					layerOpt.callBackFun.call(this, returnVal);
					layer.close(index);
				}
			}
		}
	}
	//使用无标题样式
	layerOpt.title = "";
	
	if(layerOpt.top){
		window.top.layer.open(layerOpt);
		if(layerOpt.isfull) {//是否默认全屏
			window.top.layer.full(layer.index);
		}
	}else if(isChildFrame){
		parent.layer.open(layerOpt);
		if(layerOpt.isfull) {
			parent.layer.full(layer.index);
		}
	} else {
		layer.open(layerOpt);
		if(layerOpt.isfull) {
			layer.full(layer.index);
		}
	}
}

var opened_pub_dialog_index;
/**在layui使用条件下，该方法的调用方为弹出窗口
  *调用方法为parent.closeDialog()
  *关闭弹出框
  *
*/
function closeDialog(){
	layer.close(opened_pub_dialog_index);
}
/**李欣专用*/
function closeDialog1(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
/** 
提示框 参数：信息
todo 待修改
*/
function alertMsg(msg){
window.top.layer.msg(msg);
}
/*
*将form中的数据转化成JSON OBJECT
*/
function formData2JsonObj(formId){
	var params = $("#"+formId).serializeArray();  
    var values = {};  
    for( x in params ){  
    	values[params[x].name] = params[x].value;  
    }  
    var a=arguments;
    for(var i=1, len = a.length; i < len; i=i+2){
    	values[a[i]] = a[i+1]; 
    }
    var stringObj = JSON.stringify(values);
    //console.log(stringObj)
    return eval("("+stringObj+")");
}
/**
获取选中内容
tableId 为lay-data 中 id 
*/
function getCheckDataJson(tableId){
	var checkStatus = table.checkStatus(tableId),data = checkStatus.data;
    return  data
}
/**
获取选中条数
tableId 为lay-data 中 id 
*/
function getCheckLength(tableId){ //获取选中数目
	var checkStatus = table.checkStatus(tableId);
	var data = checkStatus.data;
    return data.length
}
/** 
确认框 参数：信息，确认事件，取消事件。
*/
var returnVal=false;
function confirmMsg(option){
	 layui.use('layer', function(){ //独立版的layer无需执行这一句
		var $ = layui.jquery, layer = layui.layer; 
		layer.confirm(option.msg,{
			btn:['确定','取消'],
			btn1:function(index,layero){
				 if(option.okFunction && typeof option.okFunction == "function"){
					 option.okFunction();
			     }
				 layer.close(index);
			},
			btn2:function(index,layero){
				 if(option.cancelFunction && typeof option.cancelFunction == "function"){
					 option.cancelFunction();
				 }
				 layer.close(index);
			}
		});
	});    
}