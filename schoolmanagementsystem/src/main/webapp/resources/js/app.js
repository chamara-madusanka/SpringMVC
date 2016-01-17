// Logout function
function formSubmit() {
	document.getElementById("logoutForm").submit();
}

jQuery(document).ready(function($) {

	$("#searchButton").click(function(event) {
		
		$('#searchTable').empty();

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		searchFunction();

	});

});

// Search Function
function searchFunction() {
	var search = {}
	search["firstName"] = $("#firstName").val();
	search["lastName"] = $("#lastName").val();
	search["studentID"] = $("#studentID").val();
	search["grade"] = $("#grade").val();
	search["gradeClass"] = $("#gradeClass").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		contentType : "application/json",
		url : "searchstudent",
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
                txt += "<tr><td>"+data[i].studentID+"</td><td>"+data[i].firstName+
                "</td><td>"+data[i].midName+
                "</td><td>"+data[i].lastName+
                "</td><td>"+data[i].birthdate+
                "</td><td>"+data[i].address+
                "</td><td>"+data[i].grade+
                "</td><td>"+data[i].gradeClass+
                "</td></tr>";
            }
        }
        if(txt != ""){
        	var header = "<tr><th width='80'>Student ID</th>" +
        						"<th width='120'>First Name</th>" +
        						"<th width='120'>Mid Name</th>" +
        						"<th width='120'>Last Name</th>" +
        						"<th width='120'>Birthdate</th>" +
        						"<th width='120'>Address</th>" +
        						"<th width='60'>Grade</th>" +
        						"<th width='60'>Class</th></tr>";
        	var table = header + txt;
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