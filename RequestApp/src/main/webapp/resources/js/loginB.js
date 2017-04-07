/**
 * 
 */
$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

/*function validate(){
	alert("1");
	if($("#username").val()==""){
		alert("Username can't be empty!");
		$("#username").focus();
		return false;
	}
	if($("#password").val()==""){
		alert("Password can't be empty!");
		$("#password").focus(); 
		return false;
	}
}

function validateReg(){
	alert("2");
	if($("#username").val()==""){
		alert("Username can't be empty!");
		$("#username").focus();
		return false;
	}
	if($("#password").val()==""){
		alert("Password can't be empty!");
		$("#password").focus(); 
		return false;
	}
	if($("#password").val()!=$("#confirm-password").val()){
		alert("Password isn't the same!");
		$("#password").focus(); 
		return false;
	}
}*/