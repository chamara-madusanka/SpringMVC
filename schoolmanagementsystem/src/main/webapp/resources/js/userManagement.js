$(document).ready(function($) {
	$('#cancelAddUser').click(function() {
		window.location.href = "/schoolmanagementsystem/user";
	});
});

$(document).ready(function($) {
	
	$('#addUser').click(function(event) {
		
		// Prevent the form from submitting via the browser.
		event.preventDefault();

		addFunction();

	});

});

/* Add user function */
function addFunction() {
	var add = {}
	add["username"] = $("#username").val();
	add["password"] = $("#password").val();
	add["role"] = $("#userrole").val();
	add["enabled"] = $("#enabled").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		contentType : "application/json",
		url : "adduser",
		data : JSON.stringify(add),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			if(data.response) {
				$("#dialog").dialog({
				   autoOpen: false,
				   height: 240,
				   resizable: false,
				   modal: true,
				   buttons : {
				        "Yes" : function() {
				        	var form = document.getElementById("searchForm");
				    		form.reset();
				    		$(this).dialog("close");
				        },
				        "No" : function() {
				          $(this).dialog("close");
				          window.location.href = "/schoolmanagementsystem/user";
				        }
				   }
			    });
				
				$("#dialog").dialog("open");
			} else {
				errorPopup();
			}
		},
		error : function(e) {
			errorPopup();
		},
		done : function(e) {
			console.log("DONE");
			alert("done");
		}
	});
}

function errorPopup() {
	$("#dialogError").dialog({
		   autoOpen: false,
		   height: 240,
		   resizable: false,
		   modal: true,
		   buttons : {
		        "Ok" : function() {
		    		$(this).dialog("close");
		        }
		   }
	    });
		
	$("#dialogError").dialog("open");
}