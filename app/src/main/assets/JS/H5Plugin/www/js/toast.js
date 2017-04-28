// 扩展API加载完毕后调用onPlusReady回调函数 
document.addEventListener( "plusready", onToast, true );

function onToast()  {
    B = window.plus.bridge;
    var toastutil = {
        ToastMessage : function (Argus1 ) {
            
            return B.execSync("toast", "toastMessage", [Argus1]);
        },
    };

    window.plus.toastutil = toastutil;


}