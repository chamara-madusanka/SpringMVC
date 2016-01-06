// Logout function
function formSubmit() {
	document.getElementById("logoutForm").submit();
}

jQuery(document).ready(function($) {

	$("#search-form").submit(function(event) {

		// Disble the search button
		$('#searchTable').empty();

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		searchFunction();

	});

});

// Search Function
function searchFunction() {
	var search = {}
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		contentType : "application/json",
		url : "searchstudent",
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
            $("#searchTable").append(txt).removeClass("hidden");
        }
    }
}