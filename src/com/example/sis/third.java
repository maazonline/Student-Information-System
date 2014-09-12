package com.example.sis;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sis.CustomHttpClient;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class third extends Activity {
	String sp="";

	String subname;
	String  staffname;
	String  attendance;
	String notes;

	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
	TextView tv5;
	
	
	String cp="";
	String dp="";
	String dp2="";

	String sssp="";
	String Subjects[];
	String mon1,mon3,mon4,mon2;
	//String mon5,mon6;;

	
			
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		 StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		  .detectDiskReads().detectDiskWrites().detectNetwork() // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread
		  .penaltyLog().build()); 
		super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        sp=getIntent().getStringExtra("USN");
        cp=getIntent().getStringExtra("SUB");
        tv1 = (TextView) findViewById(R.id.textView6);
        tv2 = (TextView) findViewById(R.id.textView7);
        tv3 = (TextView) findViewById(R.id.textView8);
        tv4 = (TextView) findViewById(R.id.textView9);
        tv5 = (TextView) findViewById(R.id.textView10);
        
        
        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        
        // define the parameter
        postParameters.add(new BasicNameValuePair("usn",sp));
        postParameters.add(new BasicNameValuePair("sub",cp));
        Toast.makeText(getApplicationContext(),sp+" "+cp,Toast.LENGTH_SHORT).show();

        String response = null;

        
        try {
   response = CustomHttpClient.executeHttpPost(
     //"http://129.107.187.135/CSE5324/jsonscript.php", // your ip address if using localhost server
     "http://1447469_hosta@f10-preview.biz.nf/tinyprojects.co.nf/jsonscript03.php",  // in case of a remote server
     postParameters);
   
   // store the result returned by PHP script that runs MySQL query
   String result = response.toString();  
            
		//parse json data
       try{
         JSONArray jArray = new JSONArray(result);
               for(int i=0;i<jArray.length();i++){
                       JSONObject json_data = jArray.getJSONObject(i);
                       Log.i("log_tag","key3: "+json_data.getInt("key3")+
                               ", Sub name "+json_data.getString("subname")+
                               ", Staff name: "+json_data.getString("staffname")+
                               ", attendance "+json_data.getString("attendance")+
                               ", notes: "+json_data.getString("notes")
                            );
                       
                       subname=json_data.getString("subname");
                       staffname=json_data.getString("staffname");
                       attendance=json_data.getString("attendance");
                       notes= json_data.getString("notes");
                       tv1.setText(subname);
                       tv2.setText(staffname);
                       tv3.setText(attendance);
                       tv4.setText(notes);

                   
    }}
       catch(JSONException e){
               Log.e("log_tag", "Error parsing data "+e.toString());
       }
        }
       catch (Exception e) {
           Log.e("log_tag","Error in http connection!!" + e.toString());     
          }
        
	}}
        
       

