$(function(){
	$.post(
		"GetNickName.do",
		{data:1},
		function(data){
			if(data.status==1){
				$("#nickname").val(data.msg);
			}else{
				alert("请先登录");
			}
		},"json"
	);
	
	$("#rent").datagrid({
//		data:[
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c001',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c002',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//			{carid:'c003',name:'帕萨特',dayrent:'50',weekrent:'100',monthrent:'500',deposit:'500',type:'轿车',color:'黑色',overdateprice:'100'},
//		],
		
		onClickRow:function(rowIndex, rowData){
			
			$('#rent-dlg').dialog('open').dialog('setTitle','Edit User');
			$('#rent-fm').form('load',rowData);
			//url = 'update_user.php?id='+rowData.carid;
			var row = $("#rent").datagrid('getSelected');
			
			$("#rent-price").val(row.dayrent);
		}
		
	});
	$("#rent-method").combobox({
		onChange:function(){
			var mehtod = $("#rent-method").val();
			var aprice;
			var row = $("#rent").datagrid('getSelected');
			
			if(row!=null){
				
				switch (mehtod){
					case "day":
						aprice = row.dayrent;
						break;
					case "week":
						aprice = row.weekrent;
						break;
					case "month":
						aprice = row.monthrent;
						break;
					default:
						break;
				}
				var price = $('#rentdays').val() * aprice;
				$("#rent-price").val(price);
			}
			
		},
	})
	$('#rentdays').numberspinner({
	    min: 1,
	    max: 100,
	    value:1,
	    onSpinUp:function(){
			var mehtod = $("#rent-method").val();
			var aprice;
			var row = $("#rent").datagrid('getSelected');
			
			switch (mehtod){
				case "day":
					aprice = row.dayrent;
					break;
				case "week":
					aprice = row.weekrent;
					break;
				case "month":
					aprice = row.monthrent;
					break;
				default:
					break;
			}
			var price = $(this).val() * aprice;
			$("#rent-price").val(price);
		},
       	onSpinDown:function(){
			var mehtod = $("#rent-method").val();
			var aprice;
			var row = $("#rent").datagrid('getSelected');
			
			switch (mehtod){
				case "day":
					aprice = row.dayrent;
					break;
				case "week":
					aprice = row.weekrent;
					break;
				case "month":
					aprice = row.monthrent;
					break;
				default:
					break;
			}
			var price = $(this).val() * aprice;
			$("#rent-price").val(price);
		},
	    
	});
	
	$("#userInfoUpdate").form({
		url:'UpdateClientInfo',
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			$.messager.alert('修改失败', data, 'info');
		}
	})
	
	
	
})
function confirmRent(){
	$.post("ConfirmRentCar",{
		carid:$("#carid").val(),
		method:$("#rent-method").val(),
		rentdays:$("#rentdays").val(),
		price:$("#rent-price").val(),
	},function(resp){
		if(resp == null){
			$.messager.alert("提示",'服务器异常', 'info');
		}else{
			if(resp.status == 1){
				$.messager.alert("提示",'租车成功', 'info');
				$('#rent-dlg').dialog('close');		// close the dialog
				$('#lease-info').datagrid('reload');
			}else{
				$.messager.alert("提示",'租车失败', 'info');
			}
		}
	},'json')
}

