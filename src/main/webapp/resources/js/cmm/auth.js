"use strict";
var auth = auth || {}
auth = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.'
    let _, js, auth_vue_js
    let init = ()=>{
        _ = $.ctx()
        js = $.js()
        auth_vue_js = js+'/vue/auth_vue.js'
    }
    let onCreate =()=>{
        init()
        $.getScript(auth_vue_js).done(()=>{
        	setContentView()
    		$('#a_go_join').click(e=>{
         		e.preventDefault()
         		join()
    		})
        }).fail(()=>{alert(WHEN_ERR)})
    }
    let setContentView =()=>{
    	 login()
    }
    let join=()=>{
        $('head').html(auth_vue.join_head()),
        $('body').html(auth_vue.join_body())
        $('<button>',{
            text: 'continue to check',
            href: '#',
            click: e=>{
                e.preventDefault();
                let data = {uid:$('#uid').val(),pwd:$('#pwd').val(),uname:$('#uname').val()}
                $.ajax({
                    url:_+'/users/',
                    type: 'POST',
                    dataType:'json',
                    data : JSON.stringify(data),
                    contentType : 'application/json',
                    success : d =>{
                        alert('AJAX 성공 : '+ d.msg)
                        if(d.msg ==='SUCCESS')
                        	login()
                        	else
                        		alert('회원가입실패');
                       
                    },
                    error : e =>{
                        alert('AJAX실패');
                    }
                })
            }
        })
        .addClass('btn btn-primary btn-lg btn-block')
        .appendTo('#btn_join')        
    }
    let login=()=>{
        let x ={css:$.css(),img:$.img()}
        $('head').html(auth_vue.login_head(x)),
        $('body').html(auth_vue.login_body(x))
        .addClass('text-center')
        $('<button>',{
            type:"submit",
            text : "Sign in",
            click : e=>{
                e.preventDefault()
                let data=
                	{uid:$('#uid').val(),
                    pwd:$('#pwd').val(),
                    uname:$('#uname').val()}
                $.ajax({
                    url:_+'/user/login',
                    type: 'POST',
                    data : JSON.stringify(data),
                    dataType:'json',
                    contentType : 'application/json',
                    success : d=>{
                        alert(d.uname+' 님 환영합니다.');    
                    },
                    error : e=>{
                        alert('에이작스실패');
                    }
                    
                })    
            }
        }).addClass("btn btn-lg btn-primary btn-block")
        .appendTo('#btn_login')
    
        
    }


    return {onCreate, join, login}
})();