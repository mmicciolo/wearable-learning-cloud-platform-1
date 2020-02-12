var ODataModel = {
		
	oDataModel : null,
	
	setupODataModel : function() {
		this.oDataModel = new sap.ui.model.odata.v2.ODataModel(this.getODataModelURL(), {success: this.success, error: this.error});
		this.oDataModel.setSizeLimit(1000);
		sap.ui.getCore().setModel(this.oDataModel, "odata");
	},
	
	getODataModel : function() {
		if(this.oDataModel == null) {
			this.setupODataModel();
		} else {
			return sap.ui.getCore().getModel("odata");
		}
	},
	
	getODataModelURL : function() {
		if(window.location.host.includes("www")) {
			if(window.location.host.includes(":")) {
				return "http://" + window.location.host.replace("www.", "") + "/WLCPWebApp/WLCPOData.svc";
			} else {
				return "http://" + window.location.host.replace("www.", "") + ":80" + "/WLCPWebApp/WLCPOData.svc";
			}
		} else {
			if(window.location.host.includes(":")) {
				return "http://" + window.location.host + "/WLCPWebApp/WLCPOData.svc";
			} else {
				return "http://" + window.location.host + ":80" + "/WLCPWebApp/WLCPOData.svc";
			}
		}
	},
	
	getWebAppURL : function() {
		if(window.location.host.includes("www")) {
			return "http://" + window.location.host.replace("www.", "") + "/WLCPWebApp";
		} else {
			return "http://" + window.location.host + "/WLCPWebApp";
		}
	},
	
	success : function() {
		
	},
	
	error : function() {
		
	}
}