

console.log("Reply Module.......")

//자동호출함수를 사용
var replyService=(function(){
	
	//등록
	function add(reply,callback,error){
		console.log("reply........");
		
		$.ajax({
			type:"post",
			url:"/replies/new",
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
			
		});
	}
	
	//목록
	function getList(param,callback,error){
		var bno=param.bno;
		var page=param.page || 1;
		$.getJSON("/replies/pages/"+bno+"/"+page+".json",
				function(data){
					if(callback){
						callback(data.replyCnt, data.list);
					}
				}
		).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	
	//시간출력
	function displayTime(timeValue){
		var today=new Date();
		var gap=today.getTime()-timeValue;
		
		var dateObj=new Date(timeValue);
		var str="";
		//댓글작성후 24시간이 안지났으면. 시:분:초 출력
		if(gap<1000*60*60*24){
			var hh=dateObj.getHours();
			var mi=dateObj.getMinutes();
			var ss=dateObj.getSeconds();
			
			return [(hh>9?'':'0')+hh,':',(mi>9?'':'0')+mi,':',(ss>9?'':'0')+ss].join('');		
		}else{
			var yy=dateObj.getFullYear();
			var mm=dateObj.getMonth()+1;
			var dd=dateObj.getDate();
			
			return [yy,'/',(mm>9?'':'0')+mm,'/',(dd>9?'':'0')+dd].join('');
		}
		
	}
	
	//상세보기
	function get(rno,callback,error){
		$.get("/replies/"+rno+".json",function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	//수정
	function update(reply,callback,error){
		console.log("RNO:"+reply.rno);
		$.ajax({
			type:"put",
			url: "/replies/"+reply.rno,
			data: JSON.stringify(reply),
			contentType:'application/json;charset=utf-8',
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}
	//삭제
	function remove(rno,callback,error){
		$.ajax({
			type:'delete',
			url:'/replies/'+rno,
			
			data: JSON.stringify({rno:rno, replyer:replyer}),
			
			contentType: "application/json; charset=utf-8",
			
			success:function(deleteResult,status,xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	return {
		add:add,
		getList:getList,
		displayTime:displayTime,
		get:get,
		update:update,
		remove:remove
	};
	
	})();







