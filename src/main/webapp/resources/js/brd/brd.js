"use strict"
var brd = brd ||{}
brd = (()=>{
    let _, js, brd_vue_js
    let run =u=>$.getScript(u+'/resources/js/cmm/router.js',
    		()=>{$.extend(new Session(u));
    		onCreate();	
    		});
    let init =()=>{
        _ = $.ctx()
       js = $.js()
       brd_vue_js = js+'/vue/brd_vue.js'
    }
    let onCreate=()=>{
    	$.getScript(brd_vue_js,()=>{
        init()
        setContentView()
        $('<a>',{
            	href : '#',
            	click : e=>{
                	e.preventDefault()
                	write()
            	},
            	text : '글쓰기'
            	})
            .addClass('nav-link')
            .appendTo('#go_write')
    	})
    }
    let setContentView=()=>{
        
            $('head').html(brd_vue.brd_head({css: $.css(), img: $.img()}))
            $('body').addClass('text-center')
            .html(brd_vue.brd_body({css: $.css(), img: $.img()}))
            $('#recent_updates .media').remove()
            $('#recent_updates .d-block').remove()
            $('#recent_updates').append('<h1>등록된 글이 없습니다.</h1>')
        
    }
    let write=()=>{
    	alert('글쓰기로 이동')
    	$('#recent_updates').html(brd_vue.brd_write())
    	$('#suggestions').remove()
    }
    return {onCreate}
})()