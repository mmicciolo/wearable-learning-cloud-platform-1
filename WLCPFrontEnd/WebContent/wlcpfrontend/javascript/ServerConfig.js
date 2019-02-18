var ServerConfig = {
	
	getServerAddress : function() {
		var serverURL = "";
		if(window.location.host.includes("www.")) {
			serverURL = window.location.host.replace("www.", "");
		} else {
			serverURL = window.location.host;
		}
		if(serverURL.includes(":")) {
			return serverURL.replace(":8080", ":3333");
		} else {
			return serverURL + ":3333";
		}
	}
}