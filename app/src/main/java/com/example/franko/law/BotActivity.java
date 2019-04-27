package com.example.franko.law;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.ibm.watson.developer_cloud.assistant.v2.Assistant;
import com.ibm.watson.developer_cloud.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.DialogRuntimeResponseGeneric;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageInput;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v2.model.MessageResponse;
import com.ibm.watson.developer_cloud.assistant.v2.model.RuntimeIntent;
import com.ibm.watson.developer_cloud.assistant.v2.model.SessionResponse;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

public class BotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.criminal_care));

        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh);
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        WebView webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebClient(refreshLayout));
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://assistant-chat-eu-gb.watsonplatform.net/web/public/d08ded43-79d1-42d2-a915-ba35263d9744");

    }



   /* private TextView chatDisplayTV;
    private EditText userStatementET;
    Button sendbut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        chatDisplayTV = findViewById(R.id.tv_chat_display);
        userStatementET = findViewById(R.id.msgtyped1);
        sendbut = findViewById(R.id.send_btn1);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.criminal_care));

        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    // Suppress log messages in stdout.
    LogManager.getLogManager().reset();




    // Main input/output loop
        sendbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set up Assistant service.
                IamOptions iamOptions = new IamOptions.Builder().apiKey("0BsD31Ao-erBjgqMZ5HSv2KsoSalo-oHjU4MZ9hd0eaj").build();
                Assistant service = new Assistant("2018-09-20", iamOptions);
                String assistantId = "2a384453-c7d3-47c1-b05f-968fc355251e"; // replace with assistant ID

                // Create session.
                CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(assistantId).build();
                SessionResponse session = service.createSession(createSessionOptions).execute();
                String sessionId = session.getSessionId();

                // Initialize with empty value to start the conversation.
                String inputText = "";
                do {
                    // Send message to assistant.
                    MessageInput input = new MessageInput.Builder().text(inputText).build();
                    MessageOptions messageOptions = new MessageOptions.Builder(assistantId, sessionId)
                            .input(input)
                            .build();
                    MessageResponse response = service.message(messageOptions).execute();

                    // If an intent was detected, print it to the console.
                    List<RuntimeIntent> responseIntents = response.getOutput().getIntents();
                    if(responseIntents.size() > 0) {
                        System.out.println("Detected intent: #" + responseIntents.get(0).getIntent());
                    }

                    // Print the output from dialog, if any. Assumes a single text response.
                    List<DialogRuntimeResponseGeneric> responseGeneric = response.getOutput().getGeneric();
                    if(responseGeneric.size() > 0) {
                        System.out.println(response.getOutput().getGeneric().get(0).getText());
                    }

                    // Prompt for next round of input.
                    System.out.print(">> ");
                    inputText = System.console().readLine();
                } while(!inputText.equals("quit"));

                // We're done, so we delete the session.
                DeleteSessionOptions deleteSessionOptions = new DeleteSessionOptions.Builder(assistantId, sessionId).build();
                service.deleteSession(deleteSessionOptions).execute();
            }
        });*/

}

