"use strict"
var adm = adm || {} 
adm=(()=>{
	let _, js, css, img,navi_js, brd_js, navi_vue_js, brd_vue_js
	const WHEN_ERR = '호출하는 js를 찾을 수 없음'
	let init=()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		brd_js = js + '/brd/brd.js'
		brd_vue_js = js + '/vue/brd_vue.js'
		navi_js = js + '/cmm/navi.js'
		navi_vue_js = js + '/vue/navi_vue.js'
	}
	
	let onCreate=()=>{
		init()
		$.when(
		$.getScript(navi.js),
		$.getScript(navi_vue.js)
		).
		done(()=>{
			setContentView()
			navi.onCreate()
		}).fail(()=>{
			alert(WHEN_ERR)
		})
	}
	let setContentView=()=>{
		$('body').empty()
		$('form_join').remove()
		$(navi_vue.nav())
		.appendTo('body')
		$('<table id="tab"><tr></tr></table>')
        .css({border: '1px solid black', width: '80%', height :'90%', 'margin':'0 auto'})
        .appendTo('body')
        $.each(
                [{id:'left', width : '20%'},
                {id:'right', width:'80%'}],
                (i,j)=>{
                $('<td id="'+j.id+'"</td>')        
                .css({border: '2px solid black', 'j.width': '80%', 'vertical-align':'top'})
                .appendTo('#tab tr')
            })
	}
    
    return{onCreate}
})()