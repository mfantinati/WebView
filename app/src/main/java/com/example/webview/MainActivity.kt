package com.example.webview

import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        webview.webViewClient = MyWebViewClient()

        btn_procurar.setOnClickListener {
            webview.loadUrl("https://"+ et_procurar.text.toString())
        }

        btn_voltar.setOnClickListener {
            if(webview.canGoBack())
                webview.goBack()
            else
                Toast.makeText(context,"Não é possivel retornar",Toast.LENGTH_LONG).show()
        }

     
    }

    class MyWebViewClient : WebViewClient(){

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
           view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true

        }
    }


}