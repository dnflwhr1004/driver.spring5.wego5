function join(x){
	$.ajax({
    	url : _+'/user/join',
    	type : 'POST',
    	dataType : 'json',
    	data : JSON.stringify(data),
    	contentType : 'application/json',
    	success : d => {
    		alert('AJAX 성공 아이디: '+d.uid+', 성공비번: '+d.pwd)
    		let x = {css: $.css(), img: $.img()}
    		$('head')
	        .html(auth_vue.login_head(x))
	        $('body')
	        .addClass('text-center')
	        .html(auth_vue.login_body(x))
	    
	        $('<button>',{
	        	type : "submit",
	        	text : "Sign in",
	        	click : e => {
	        		e.preventDefault()
	        		
	        	}
	        })
	        .addClass("btn btn-lg btn-primary btn-block")
	        .appendTo('#btn_login')
	        
    	},
    	error : e => {
    		alert('AJAX 실패');
    	}
    })
}