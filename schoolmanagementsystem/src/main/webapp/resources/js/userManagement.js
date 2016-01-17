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


/* User search */
jQuery(document).ready(function($) {

	$("#userSearchButton").click(function(event) {
		
		$('#searchTable').empty();

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		searchFunction();

	});

});

// Search Function
function searchFunction() {
	var search = {}
	search["username"] = $("#username").val();
	search["password"] = $("#password").val();
	search["role"] = $("#userrole").val();
	search["enabled"] = $("#enabled").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		contentType : "application/json",
		url : "searchUsers",
		data : JSON.stringify(search),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
			enableSearchButton(true);
		}
	});
}

function enableSearchButton(flag) {
	$("#searchButton").prop("disabled", flag);
}

function display(data) {
	var len = data.length;
    var txt = "";
    if(len > 0){
        for(var i=0;i<len;i++){
            if(data[i].studentID){
                txt += "<tr><td>"+data[i].userName+"</td><td>"+data[i].userRole+
                "</td><td>"+data[i].enabled+
                "</td></tr>";
            }
        }
        if(txt != ""){
        	var header = "<tr><th width='80'>User Name</th>" +
        						"<th width='120'>User Role</th>" +
        						"<th width='120'>Enabled</th></tr>";
        	var table = header + txt;
        	$('#userListHeader').removeClass("hidden");
            $("#searchTable").append(table).removeClass("hidden");
        }
    }
}

jQuery(document).ready(function($) {
	$("#clearAllButton").click(function() {
		var form = document.getElementById("searchForm");
		form.reset();
	});
});