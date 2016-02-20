$(document).ready(function($) {
	$('#cancelAddStudent').click(function() {
		window.location.href = "/schoolmanagementsystem/student";
	});
});

$(document).ready(function($) {
	
	$('#addStudent').click(function(event) {
		
		event.preventDefault();
		
		addStudent();
		
	});
	
});

/* Add Student function */
function addStudent() {
	
	var add = {};
	
	add["firstName"] = $('#firstname').val();
	add["midName"] = $('#midname').val();
	add["lastName"] = $('#lastname').val();
	add["birthdate"] = $('#birthDate').val();
	add["address"] = $('#address').val();
	add["grade"] = $('#grade').val();
	add["gradeClass"] = $('#class').val();
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajax({
		type : "POST",
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		contentType : "application/json",
		url : "addstudent",
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
					        	var form = document.getElementById("addStudentForm");
					    		form.reset();
					    		$(this).dialog("close");
					        },
					        "No" : function() {
					          $(this).dialog("close");
					          window.location.href = "/schoolmanagementsystem/student";
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
	
};

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