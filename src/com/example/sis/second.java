package com.example.sis;

import java.util.ArrayList;
import java.util.Calendar;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class second extends Activity {
	TextView tv1;
	TextView tv2;

	String sp="";
	String cp="";
	String dp="";
	String dp2="";

	String sssp="";
	String suj="";
	String Subjects[];
	String mon1,mon3,mon4,mon2;
	 String usn,course,day,day1,day2,day3,day4,day5,day6;
	 String listview_array[] = { "ONE", "TWO", "THREE", "FOUR","FIVE","SIX" };
	 int j=1;
	 private ListView lv;
	/** Called when the activity is first created. */
	@Override
		  protected void onCreate(Bundle savedInstanceState) {
			  StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
			  .detectDiskReads().detectDiskWrites().detectNetwork() // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread
			  .penaltyLog().build()); 
			        super.onCreate(savedInstanceState);
			
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.second);
	      
	       usn=getIntent().getStringExtra("USN");
	       course=getIntent().getStringExtra("Course");
	       sp=usn;
	       lv = (ListView) findViewById(R.id.listView1);	   
	       tv1=(TextView) findViewById(R.id.textView2);
	       
		    Calendar calendar = Calendar.getInstance();
		    int j = calendar.get(Calendar.DAY_OF_WEEK);
	            // declare parameters that are passed to PHP script i.e. the name "birthyear" and its value submitted by user   
	            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
	            switch(j)
	            {
	            case 2:day="Mon";
	            break;
	            case 3:day="Tue";
	            break;
	            case 4:day="Wed";
	            break;
	            case 5:day="Thu";
	            break;
	            case 6:day="Fri";
	            break;
	            case 7:day="Sat";
	            break;
	            default:break;
	            }
	            // define the parameter
	            postParameters.add(new BasicNameValuePair("day",day)
	    	    	    );
	            postParameters.add(new BasicNameValuePair("Course",course)
	            );
	            
	           tv1.setText(day);
	            String response = null;
	            
	            // call executeHttpPost method passing necessary parameters 
	            try {
	       response = CustomHttpClient.executeHttpPost(
	         //"http://129.107.187.135/CSE5324/jsonscript.php", // your ip address if using localhost server
	         "http://1447469_hosta@f10-preview.biz.nf/tinyprojects.co.nf/jsonscriptwday.php",  // in case of a remote server
	         postParameters);
	       
	       // store the result returned by PHP script that runs MySQL query
	       String result = response.toString();  
	                
				//parse json data
	           try{
	             JSONArray jArray = new JSONArray(result);
	                   for(int i=0;i<jArray.length();i++){
	                	   if(j==2)
	                	   {
	                           JSONObject json_data = jArray.getJSONObject(i);
	                           Log.i("log_tag","key2: "+json_data.getInt("key2")+
	                                   ", day1: "+json_data.getString("mon1")+
	                                   ", day2: "+json_data.getString("mon2")+
	                                   ", day3: "+json_data.getString("mon3")+
	                                   ", day4:"+json_data.getString("mon4")+
	                                   ", day5: "+json_data.getString("mon5")+
	                                   ", day6: "+json_data.getString("mon6")
	                                  
	                                );
	                           day1=json_data.getString("mon1");
	                           day2=json_data.getString("mon2");
	                           day3=json_data.getString("mon3");
	                           day4=json_data.getString("mon4");
	                           day5=json_data.getString("mon5");
	                           day6=json_data.getString("mon6");
	                	   }
	                	   else if(j==3)
	                	   {
	                           JSONObject json_data = jArray.getJSONObject(i);
	                           Log.i("log_tag","key2: "+json_data.getInt("key2")+
	                                   ", day1: "+json_data.getString("tue1")+
	                                   ", day2: "+json_data.getString("tue2")+
	                                   ", day3: "+json_data.getString("tue3")+
	                                   ", day4:"+json_data.getString("tue4")+
	                                   ", day5: "+json_data.getString("tue5")+
	                                   ", day6: "+json_data.getString("tue6")
	                                  
	                                );
	                           day1=json_data.getString("tue1");
	                           day2=json_data.getString("tue2");
	                           day3=json_data.getString("tue3");
	                           day4=json_data.getString("tue4");
	                           day5=json_data.getString("tue5");
	                           day6=json_data.getString("tue6");
	                	   }
	                	   else if(j==4)
	                	   {
	                           JSONObject json_data = jArray.getJSONObject(i);
	                           Log.i("log_tag","key2: "+json_data.getInt("key2")+
	                                   ", day1: "+json_data.getString("wed1")+
	                                   ", day2: "+json_data.getString("wed2")+
	                                   ", day3: "+json_data.getString("wed3")+
	                                   ", day4:"+json_data.getString("wed4")+
	                                   ", day5: "+json_data.getString("wed5")+
	                                   ", day6: "+json_data.getString("wed6")
	                                  
	                                );
	                           day1=json_data.getString("wed1");
	                           day2=json_data.getString("wed2");
	                           day3=json_data.getString("wed3");
	                           day4=json_data.getString("wed4");
	                           day5=json_data.getString("wed5");
	                           day6=json_data.getString("wed6");
	                	   }
	                	   else if(j==5)
	                	   {
	                           JSONObject json_data = jArray.getJSONObject(i);
	                           Log.i("log_tag","key2: "+json_data.getInt("key2")+
	                                   ", day1: "+json_data.getString("thu1")+
	                                   ", day2: "+json_data.getString("thu2")+
	                                   ", day3: "+json_data.getString("thu3")+
	                                   ", day4:"+json_data.getString("thu4")+
	                                   ", day5: "+json_data.getString("thu5")+
	                                   ", day6: "+json_data.getString("thu6")
	                                  
	                                );
	                           day1=json_data.getString("thu1");
	                           day2=json_data.getString("thu2");
	                           day3=json_data.getString("thu3");
	                           day4=json_data.getString("thu4");
	                           day5=json_data.getString("thu5");
	                           day6=json_data.getString("thu6");
	                	   }
	                	   else if(j==6)
	                	   {
	                           JSONObject json_data = jArray.getJSONObject(i);
	                           Log.i("log_tag","key2: "+json_data.getInt("key2")+
	                                   ", day1: "+json_data.getString("fri1")+
	                                   ", day2: "+json_data.getString("fri2")+
	                                   ", day3: "+json_data.getString("fri3")+
	                                   ", day4:"+json_data.getString("fri4")+
	                                   ", day5: "+json_data.getString("fri5")+
	                                   ", day6: "+json_data.getString("fri6")
	                                  
	                                );
	                           day1=json_data.getString("fri1");
	                           day2=json_data.getString("fri2");
	                           day3=json_data.getString("fri3");
	                           day4=json_data.getString("fri4");
	                           day5=json_data.getString("fri5");
	                           day6=json_data.getString("fri6");
	                	   }
	                	   else if(j==7)
	                	   {
	                           JSONObject json_data = jArray.getJSONObject(i);
	                           Log.i("log_tag","key2: "+json_data.getInt("key2")+
	                                   ", day1: "+json_data.getString("sat1")+
	                                   ", day2: "+json_data.getString("sat22")+
	                                   ", day3: "+json_data.getString("sat3")+
	                                   ", day4:"+json_data.getString("sat4")+
	                                   ", day5: "+json_data.getString("sat5")+
	                                   ", day6: "+json_data.getString("sat6")
	                                  
	                                );
	                           day1=json_data.getString("sat1");
	                           day2=json_data.getString("sat2");
	                           day3=json_data.getString("sat3");
	                           day4=json_data.getString("sat4");
	                           day5=json_data.getString("sat5");
	                           day6=json_data.getString("sat6");
	                	   }
	                           
	                	   listview_array[0]="08:00-09:00 A.M -- "+day1;
	                       listview_array[1]="09:00-10:00 A.M -- "+day2;
	                       listview_array[2]="10:30-11:30 A.M -- "+day3;
	                       listview_array[3]="11:30-12:30 P.M -- "+day4;
	                       listview_array[4]="01:00-02:00 P.M -- "+day5;
	                       listview_array[5]="02:00-03:00 P.M -- "+day6;
	                   
	                   
	           }}
	           catch(JSONException e){
	                   Log.e("log_tag", "Error parsing data "+e.toString());
	           }
	       
	            
	      }
	            catch (Exception e) {
	       Log.e("log_tag","Error in http connection!!" + e.toString());     
	      }
	            lv.setAdapter(new ArrayAdapter<String>(this,
	            	      android.R.layout.simple_list_item_1, listview_array));
	            	      lv.setTextFilterEnabled(true);
	            	      lv.setOnItemClickListener(new OnItemClickListener()
	            	      {
	            	    	  public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
	            	          {
	            	    		  
	            	    		  
	            	        	  dp2=(String) lv.getItemAtPosition(position);
	            	        	  suj=dp2.substring(19);
	            	        /* AlertDialog.Builder adb = new AlertDialog.Builder(
	            	        		  SecondActivity.this);
	            	          adb.setTitle("ListView OnClick");
	            	          adb.setMessage("Selected Item is = "
	            	          + lv.getItemAtPosition(position));
	            	          adb.setPositiveButton("Ok", null);
	            	          adb.show();     */                 
	            	        	  Intent intent2 =new Intent(getApplicationContext(),third.class);
	            	              // put the name and phone(to be sent to other activity) in intent
	            	              intent2.putExtra("USN",sp); 
	            	              intent2.putExtra("SUB",suj); 
	            	              startActivity(intent2);

	            	                                                          }

	            	    	
	            	                                          });
	      // Intent inta = new Intent(this,SecondActivity.class);
	   //    inta.putExtra(passmessage,ssb);
	     //  startActivity(inta);
		 
	};}
