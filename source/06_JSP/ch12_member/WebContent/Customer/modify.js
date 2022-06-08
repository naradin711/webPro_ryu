function infoConfirm(){
	if(modify_frm.cpw.value != modify_frm.pwChk.value){
		alert('새비밀번호를 확인하세요');
		modify_frm.cpw.value = '';
		modify_frm.pwChk.value = '';
		modify_frm.cpw.focus();
		return false;
	}
}
