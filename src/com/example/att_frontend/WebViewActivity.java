package com.example.att_frontend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
 
public class WebViewActivity extends Activity {
 
	WebView webView;
	Context mContext;
	
public WebViewActivity(){
		super();
	}
	

	public WebViewActivity(Context c){
		
		mContext = c;
	}
	
	 @JavascriptInterface
	    public void openDoor(String toast) {
	        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	    }
	 
	 @JavascriptInterface
	    public void backHome() {
		 Toast.makeText(mContext, "back home", Toast.LENGTH_SHORT).show();
		 Intent intent = new Intent(mContext, MainActivity.class);
		    startActivity(intent);
	    }
	 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		
		webView = (WebView) findViewById(R.id.webView1);
		webView.addJavascriptInterface(new WebViewActivity(this), "Android");
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://192.168.1.107/attendancesystem/emplogin.php");
		webView.setWebViewClient(new WebViewClient() {
		        public boolean shouldOverrideUrlLoading(WebView view, String url) {
		            return false;
		        }
		    });
	}
 
}
