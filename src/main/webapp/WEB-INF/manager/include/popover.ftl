	<!--提示模态框开始-->
	<@ms.modal modalName="popoverModal" title="提示">
		 <@ms.modalBody>
	     </@ms.modalBody>
	     <@ms.modalButton>
    		<@ms.button value="关闭" id="closePopoverModal"/>  
 		 </@ms.modalButton>
	</@ms.modal>
	<!--提示模态框结束-->
		
	<script>				
	var URL='';
	//模态框的操作
	$(function () {	
	 	$("#closePopoverModal").click(function(){
	 		$(".popoverModal").modal("hide");
	 	});
	});
	
	
	/**
	 * 弹窗提示
	 * tips 提示信息
	 * callBack 回调函数
	 */
	function showPopoverModal(tips,callBack) {
		$("#popoverModal .modal-body").html(tips);
		$("#popoverModal").modal();//打开
		$("#popoverModal").on("hide.bs.modal", function(e){
			callBack&&$.isFunction(callBack)&&callBack();
		});
	} 
	
	/**
	 * 自定义弹窗提示
	 * tips 提示信息
	 * style 自定义弹出框样式 {width:..,height:..,.....}
	 * callBack 回调函数
	 */
	function showCustomPopoverModal(tips, style, callBack) {
		$("#popoverModal .modal-body").html(tips);
		
		for(var key in style) {
			$("#popoverModal").css(key, style[key]);
		}
		$("#popoverModal").modal();//打开
		$("#popoverModal").on("hide.bs.modal", function(e){
			callBack&&$.isFunction(callBack)&&callBack();
		});
	}		
		
	</script>

