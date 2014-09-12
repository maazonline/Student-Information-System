package com.example.sis;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	static EditText usn;   // To take birthyear as input from user
	 EditText password;
	 Button submit;    
	 TextView tv;
    String returnString;
    Intent ij;
	 @Override
   protected void onCreate(Bundle savedInstanceState) {
		  StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		  .detectDiskReads().detectDiskWrites().detectNetwork() // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread
		  .penaltyLog().build()); 
		  requestWindowFeature(Window.FEATURE_NO_TITLE);
		        super.onCreate(savedInstanceState);
		
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       
       usn = (EditText) findViewById(R.id.editText1);
       password = (EditText) findViewById(R.id.editText2);
       submit = (Button) findViewById(R.id.button1);

       submit.setOnClickListener(new View.OnClickListener(){        
         
       	public void onClick(View v) {
            // declare parameters that are passed to PHP script i.e. the name "birthyear" and its value submitted by user   
            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            
            // define the parameter
            postParameters.add(new BasicNameValuePair("usn",usn.getText().toString())
            );
           
            String response = null;
            
            // call executeHttpPost method passing necessary parameters 
            try {
       response = CustomHttpClient.executeHttpPost(
         //"http://129.107.187.135/CSE5324/jsonscript.php", // your ip address if using localhost server
         "http://1447469_hosta@f10-preview.biz.nf/tinyprojects.co.nf/jsonscript.php",  // in case of a remote server
         postParameters);
       
       // store the result returned by PHP script that runs MySQL query
       String result = response.toString();  
                
			//parse json data
           try{
             JSONArray jArray = new JSONArray(result);
                   for(int i=0;i<jArray.length();i++){
                           JSONObject json_data = jArray.getJSONObject(i);
                           Log.i("log_tag","id: "+json_data.getInt("id")+
                                   ", Name: "+json_data.getString("Name")+
                                   ", Password: "+json_data.getString("Password")+
                                   ", Course: "+json_data.getString("Course")+
                                   ", USN: "+json_data.getString("USN")
                                );
                           
                           
                           if(json_data.getString("Password").equals(password.getText().toString()))
                           
                           {
                           
                           Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                           
                           Intent ij =new Intent(getApplicationContext(),second.class);
                           // put the name and phone(to be sent to other activity) in intent
                           ij.putExtra("USN",json_data.getString("USN")); 
                           ij.putExtra("Course",json_data.getString("Course"));      


                           startActivity(ij);
                           }
                           else
                           {
                           returnString= "Login failed";
                           Toast.makeText(getApplicationContext(),"Login Failed. Retry .",Toast.LENGTH_SHORT).show();

                           }
                   
                   
           }}
           catch(JSONException e){
                   Log.e("log_tag", "Error parsing data "+e.toString());
           }
       
           try{
            tv.setText(returnString);
           }
           catch(Exception e){
            Log.e("log_tag","Error in Display!" + e.toString());;          
           }   
      }
            catch (Exception e) {
       Log.e("log_tag","Error in http connection!!" + e.toString());     
       Toast.makeText(getApplicationContext(),"you have selected option A",Toast.LENGTH_SHORT).show();

            }
           }         
          });
      // Intent inta = new Intent(this,SecondActivity.class);
   //    inta.putExtra(passmessage,ssb);
     //  startActivity(inta);
	 }}