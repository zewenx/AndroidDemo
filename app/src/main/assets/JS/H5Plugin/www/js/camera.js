document.addEventListener( "plusready",  function(){
    var _BARCODE = 'camera',
		B = window.plus.bridge;
    var camera ={
    		CameraFunction : function (Argus1, successCallback, errorCallback ) {
    			var success = typeof successCallback !== 'function' ? null : function(args) {
    				successCallback(args);
    			},
    			fail = typeof errorCallback !== 'function' ? null : function(code) {
    				errorCallback(code);
    			};
    			callbackID = B.callbackId(success, fail);
    			return B.exec(_BARCODE, "CameraFunction", [callbackID, Argus1]);
    		},
    };
    window.plus.camera = camera;
}, true );