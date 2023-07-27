    <script src="${pageContext.request.contextPath}/templates/assets/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/jquery.countdown.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/slick.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/biolife.framework.js"></script>
    <script src="${pageContext.request.contextPath}/templates/assets/js/functions.js"></script>
    <script>
	function alertMessage(message) {
		  var x = document.getElementById("snackbar");
		  x.textContent = message;
		  x.className = "show";
		  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
		}

    </script>