package timetable.sixth.sem;



import timetable.sixth.sem.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;




public class sixthsemtimetableActivity extends Activity implements OnItemSelectedListener,OnClickListener {
    /** Called when the activity is first created. */
    TextView sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10;
    TextView sub11,sub12,sub13,sub14,sub15,sub16,sub17,sub18,sub19,sub20;
    TextView sub21,sub22,sub23,sub24,sub25,sub26,sub27,sub28,sub29,sub30;
    TextView sub31,sub32,sub33,sub34,sub35,sub36,sub37,sub38,sub39,sub40;
    String civ_array[]={"C1","C2","C3"}; // All these are for sections
    String mech_array[]={"M1","M2","M3"};
    String elec_array[]={"E1","E2","E3"};
    String ec_array[]={"EC1","EC2","EC3"};
    String cse_array[]={"CS1","CS2","CS3"};
    String ei[]={"E&I"};
    Integer currbranch;
    public static final String PREFS_NAME = "4thsemPrefs";  //This was for storing your branch to load it first at startup
    
    ArrayAdapter<String> civ_arr;
    ArrayAdapter<String> mech_arr;
    ArrayAdapter<String> ee_arr;
    ArrayAdapter<String> ec_arr;
    ArrayAdapter<String> cse_arr;
    ArrayAdapter<String> ei_arr;
    
    Spinner branch,section;

    public class subject
    {
    String shortname;
    String fullname;
    
    subject(String s,String f)
    {
    this.shortname=s;
    this.fullname=f;
    }
    }
/* Define your subjects here
 * Short code(or short subject name) first (this will be displayed in the timetable)
 *  Then the full name (this will be displayed on clicking/tapping the short name)
 *	IMPORTANT: Make sure the short code/name is exactly the same as the one defined 
 *				below in the time slots part. This is used to match the full names. 
 */
    
    subject[] civ=new subject[]{
    		new subject("CE-1201","Building Materials and Construction"),
    		new subject("CE-1202","Strength Surveying"),
    		new subject("CE-1203","Strength of Materials"),
    		new subject("CE-1204","Engineering Geology"),
    		new subject("MA-1201","Mathematics-III"),
    		new subject("CE-1211","Surveying Lab")
    };
    
    subject[] mech=new subject[]{
    		new subject("ME-1201","Thermodynamics"),
    		new subject("ME-1202","Theory of Mechanism"),
    		new subject("MA-1201","Mathematics-III"),
    		new subject("ME-1203","Manufacturing Process"),
    		new subject("ME-1204","Material Science"),
    		new subject("ME-1205","Machine Drawing")
    };
    
    subject[] cse=new subject[]{
    		new subject("OS","CS-1304: Operating System"),
    		new subject("Compiler","CS-1305: Compiler Design"),
    		new subject("DAA","CS-1306: Design & Analysis of Algorithms"),
    		new subject("DBMS","CS-1307: Database Management Systems"),
    		new subject("Softw. Engg.","CS-1308: Software Engineering"),
    		new subject("CS-1314","CS-1314: Operating System Lab"),
    		new subject("CS-1315","CS-1315: Database Management Systems Lab"),
    		new subject("CS-1316","CS-1316: Compiler Design Lab")
    };
    
    
    subject[] ei_subs=new subject[]{
    		new subject("MA-1201","Mathematics- III"),
    		new subject("EI-1201","Circuits and Networks"),
    		new subject("EI-1202","Analog Electronics"),
    		new subject("EI-1203","Electrical & Electronic Measurements and Instruments"),
    		new subject("EI-1204","Electromagnetic Field Theory"),
    		new subject("EI-1211","Circuits and Network Lab"),
    		new subject("EI-1212","Measurement Lab")
    };
    
    
    // subinit() used to make the timetable entries clickable
    
    public void subinit()
    {
    	sub1=(TextView)findViewById(R.id.sub1);
        sub2=(TextView)findViewById(R.id.sub2);
        sub3=(TextView)findViewById(R.id.sub3);
        sub4=(TextView)findViewById(R.id.sub4);
        sub5=(TextView)findViewById(R.id.sub5);
        sub6=(TextView)findViewById(R.id.sub6);
        sub7=(TextView)findViewById(R.id.sub7);
        sub8=(TextView)findViewById(R.id.sub8);
        sub9=(TextView)findViewById(R.id.sub9);
        sub10=(TextView)findViewById(R.id.sub10);
        sub11=(TextView)findViewById(R.id.sub11);
        sub12=(TextView)findViewById(R.id.sub12);
        sub13=(TextView)findViewById(R.id.sub13);
        sub14=(TextView)findViewById(R.id.sub14);
        sub15=(TextView)findViewById(R.id.sub15);
        sub16=(TextView)findViewById(R.id.sub16);
        sub17=(TextView)findViewById(R.id.sub17);
        sub18=(TextView)findViewById(R.id.sub18);
        sub19=(TextView)findViewById(R.id.sub19);
        sub20=(TextView)findViewById(R.id.sub20);
        sub21=(TextView)findViewById(R.id.sub21);
        sub22=(TextView)findViewById(R.id.sub22);
        sub23=(TextView)findViewById(R.id.sub23);
        sub24=(TextView)findViewById(R.id.sub24);
        sub25=(TextView)findViewById(R.id.sub25);
        sub26=(TextView)findViewById(R.id.sub26);
        sub27=(TextView)findViewById(R.id.sub27);
        sub28=(TextView)findViewById(R.id.sub28);
        sub29=(TextView)findViewById(R.id.sub29);
        sub30=(TextView)findViewById(R.id.sub30);
        sub31=(TextView)findViewById(R.id.sub31);
        sub32=(TextView)findViewById(R.id.sub32);
        sub33=(TextView)findViewById(R.id.sub33);
        sub34=(TextView)findViewById(R.id.sub34);
        sub35=(TextView)findViewById(R.id.sub35);
        sub36=(TextView)findViewById(R.id.sub36);
        sub37=(TextView)findViewById(R.id.sub37);
        sub38=(TextView)findViewById(R.id.sub38);
        sub39=(TextView)findViewById(R.id.sub39);
        sub40=(TextView)findViewById(R.id.sub40);

 

			sub1.setOnClickListener(this);
			sub2.setOnClickListener(this);
		    sub3.setOnClickListener(this);
        sub4.setOnClickListener(this);
        sub5.setOnClickListener(this);
        sub6.setOnClickListener(this);
        sub7.setOnClickListener(this);
        sub8.setOnClickListener(this);
        sub9.setOnClickListener(this);
        sub10.setOnClickListener(this);
        sub11.setOnClickListener(this);
        sub12.setOnClickListener(this);
        sub13.setOnClickListener(this);
        sub14.setOnClickListener(this);
        sub15.setOnClickListener(this);
        sub16.setOnClickListener(this);
        sub17.setOnClickListener(this);
        sub18.setOnClickListener(this);
        sub19.setOnClickListener(this);
        sub20.setOnClickListener(this);
        
        sub21.setOnClickListener(this);
        sub22.setOnClickListener(this);
        sub23.setOnClickListener(this);
        sub24.setOnClickListener(this);
        sub25.setOnClickListener(this);
        sub26.setOnClickListener(this);
        sub27.setOnClickListener(this);
        sub28.setOnClickListener(this);
        sub29.setOnClickListener(this);
        sub30.setOnClickListener(this);
 
        sub31.setOnClickListener(this);
        sub32.setOnClickListener(this);
        sub33.setOnClickListener(this);
        sub34.setOnClickListener(this);
        sub35.setOnClickListener(this);
        sub36.setOnClickListener(this);
        sub37.setOnClickListener(this);
        sub38.setOnClickListener(this);
        sub39.setOnClickListener(this);
        sub40.setOnClickListener(this);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll);
        subinit();
        String branch_array[]={
        		"Civil Engineering",
        		"Mechanical Engineering",
        		"Electrical Engineering",
        		"Electronics & Communication Engineering",
        		"Computer Science Engineering",
        		"Electronics & Instrumentation Engineering"}; // Defining the branch names

  
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String savedbranch=settings.getString("savbranch", "cse");
        Integer savedsection=settings.getInt("savsec", 0);
        branch=(Spinner)findViewById(R.id.branchspinner);
        ArrayAdapter<String> branch_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, branch_array);
        branch_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(branch_arr);
        branch.setOnItemSelectedListener(this);
        if(savedbranch=="civ")
        	branch.setSelection(0);
        else if(savedbranch=="mech")
        	branch.setSelection(1);
        else if(savedbranch=="ee")
        	branch.setSelection(2);
        else if(savedbranch=="ec")
        	branch.setSelection(3);
        else if(savedbranch=="cse")
        	branch.setSelection(4);
        else if(savedbranch=="ei")
        	branch.setSelection(5);
        	
        section=(Spinner)findViewById(R.id.sectionspinner);
        section.setOnItemSelectedListener(this);
        section.setSelection(savedsection);
    }
    
    // resetsubs() used to blank out all entries before filling the correct values
    
    public void resetsubs()
    {
    	sub1.setText(" ");
    	sub2.setText(" ");
    	sub3.setText(" ");
    	sub4.setText(" ");
    	sub5.setText(" ");
    	sub6.setText(" ");
    	sub7.setText(" ");
    	sub8.setText(" ");
    	sub9.setText(" ");
    	sub10.setText(" ");
    	sub11.setText(" ");
    	sub12.setText(" ");
    	sub13.setText(" ");
    	sub14.setText(" ");
    	sub15.setText(" ");
    	sub16.setText(" ");
    	sub17.setText(" ");
    	sub18.setText(" ");
    	sub19.setText(" ");
    	sub20.setText(" ");
    	sub21.setText(" ");
    	sub22.setText(" ");
    	sub23.setText(" ");
    	sub24.setText(" ");
    	sub25.setText(" ");
    	sub26.setText(" ");
    	sub27.setText(" ");
    	sub28.setText(" ");
    	sub29.setText(" ");
    	sub30.setText(" ");
    	sub31.setText(" ");
    	sub32.setText(" ");
    	sub33.setText(" ");
    	sub34.setText(" ");
    	sub35.setText(" ");
    	sub36.setText(" ");
    	sub37.setText(" ");
    	sub38.setText(" ");
    	sub39.setText(" ");
    	sub40.setText(" ");
    	
    }
    
    /* TIME SLOT SUBJECT ENTRY STARTS BELOW
     * 
     * The timetable structure looks like this:
     * 
     * 		 8am   9am   10am   11am   1pm    2pm    3pm    4pm    5pm
     *  Mon  sub1  sub6  sub11  sub16  sub21  sub26  sub31  sub36  sub41
     *  Tue  sub2  sub7  ...
     *  Wed  sub3  sub8  ...
     *  Thu  sub4  sub9  ...
     *  Fri  sub5  sub10 ...
     *  
     *  Set the value of sub1, sub2 etc to the subject short names
     *  Make sure the short names/codes used here are exactly the same as the ones
     *  used above in the place where you have defined the full names. This is 
     *  because the short names used here and the ones above are matched to show
     *  the full names on clicking.
     *  
     *  Set the general subjects first and within the if conditionals, set the
     *  section-specific subjects (tutorials and labs)
     */
    public void civilpop(int sec)
    {
    	sub6.setText("SD-I");
    	sub11.setText("EE");
    	sub16.setText("HS-1201");

    	sub7.setText("EE");
    	sub12.setText("SA-I");
    	sub17.setText("HS-1201");

    	sub8.setText("SD-I");
    	sub13.setText("Hydra");
    	sub23.setText("SA-I");

    	sub14.setText("SA-I");
    	sub19.setText("Hydra");
    	sub24.setText("HS-1201");

    	sub10.setText("SD-I");
    	sub15.setText("EE");
    	sub20.setText("Hydra");
    
    if (sec==0) //c1
    {
    	sub26.setText("Hydra (T)");
    	sub27.setText("     <[CE-XXXX]");
    	sub32.setText("[HydraLab]>    ");


    	sub28.setText("SA-I (T)");
    	sub33.setText("SD-I (T)");
    	sub35.setText("     <[CE-XXXX]");
    	sub40.setText("[EG Lab]>    ");
    }
    else if(sec==1) //c2
    {
    	sub21.setText("SA-I (T)");
    	sub18.setText("Hydra (T)");
    	sub31.setText("     <[CE-XXXX]");
    	sub36.setText("[HydraLab]>    ");
    	sub32.setText("SD-I (T)");
    	sub34.setText("     <[CE-XXXX]");
    	sub39.setText("[EG Lab]>    ");
    }
    else  //c3
    {
    	sub33.setText("     <[CE-XXXX]");
    	sub38.setText("[EG Lab]>    ");
    	sub29.setText("SD-I (T)");
    	sub34.setText("     <[CE-XXXX]");
    	sub39.setText("[HydraLab]>    ");
    	sub25.setText("SA-I (T)");
    	sub30.setText("Hydra (T)");
    }
    }
    public void mechpop(int sec)
    {
    	sub6.setText("MOS");
    	sub11.setText("IM");
    	sub16.setText("HS-1201");
    	sub17.setText("HS-1201");
    	sub7.setText("FM-I");
    	sub22.setText("TD-II");
    	sub24.setText("HS-1201");
    	sub8.setText("IM");
    	sub13.setText("FM-I");
    	sub18.setText("TD-II");
    	sub23.setText("MOS");
    	sub9.setText("FM-I");
    	sub19.setText("TD-II");
    	sub10.setText("IM");
    	sub15.setText("MOS");
    	
    if(sec==0)  //m1
    {
    	sub21.setText("IM (T)");
    	sub26.setText("TD-II (T)");
    	sub33.setText("     <[ME-XXXX]");
    	sub38.setText("[WP-II]>    ");
    	sub29.setText("FM (T)");
    	sub34.setText("     <[ME-XXXX]");
    	sub39.setText("[ME Lab-I]>    ");
    	sub20.setText("MOS (T)");
    }
    else if(sec==1)  //m2
    {
    	sub31.setText("FM (T)");
    	sub27.setText("TD-II (T)");
    	sub32.setText("     <[ME-XXXX]");
    	sub37.setText("[ME Lab-I]>    ");
    	sub28.setText("MOS (T)");
    	sub39.setText("IM (T)");
    }
    else  //m3
    {
    	sub12.setText("MOS (T)");
    	sub32.setText("IM (T)");
    	sub33.setText("TD-II (T)");
    	sub30.setText("FM (T)");
    	sub35.setText("     <[ME-XXXX]");
    	sub40.setText("[ME Lab-I]>    ");
    }
    }
    public void electricpop(int sec)
    {
    	sub6.setText("DEC");
    	sub11.setText("PS-I");
    	sub16.setText("SS");

    	sub7.setText("EM-I");
    	sub12.setText("SS");
    	sub22.setText("HS-1201");

    	sub3.setText("PS-I");
    	sub8.setText("DEC");
    	sub28.setText("HS-1201");

    	sub9.setText("EM-I");
    	sub14.setText("SS");
    	sub19.setText("DEC");

    	sub5.setText("EM-I");
    	sub10.setText("PS-I");
    	sub25.setText("HS-1201");
    if(sec==0)  //e1
    {
    	sub26.setText("PS-I (T)");
    	sub31.setText("     <[EE-XXXX]");
    	sub36.setText("[ADE Lab]>    ");
    	sub18.setText("SS (T)");
    	sub24.setText("EM-I (T)");
    	sub35.setText("     <[EE-XXXX]");
    	sub40.setText("[SS Lab]>    ");
    }
    else if(sec==1) //e2
    {
    	sub21.setText("EM-I (T)");
    	sub31.setText("     <[EE-XXXX]");
    	sub36.setText("[SS Lab]>    ");
    	sub27.setText("PS-I (T)");
    	sub23.setText("SS (T)");
    	sub33.setText("     <[EE-XXXX]");
    	sub38.setText("[ADE Lab]>    ");
    }
    else  //EE3
    {
    	sub13.setText("EM-I (T)");
    	sub33.setText("     <[EE-XXXX]");
    	sub38.setText("[SS Lab]>    ");
    	sub29.setText("PS-I (T)");
    	sub15.setText("SS (T)");
    	sub35.setText("     <[EE-XXXX]");
    	sub40.setText("[ADE Lab]>    ");
    }
    }
    public void ecpop(int sec)
    {
    	sub6.setText("EC-1207");
    	sub11.setText("EC-1205");
    	sub16.setText("EC-1206");
    	sub21.setText("EC-1204");

    	sub7.setText("EC-1207");
    	sub12.setText("EC-1204");
    	sub17.setText("EC-1205");

    	sub13.setText("EC-1206");
    	sub18.setText("HS-1201");

    	sub9.setText("EC-1204");
    	sub14.setText("HS-1201");

    	sub10.setText("EC-1205");
    	sub15.setText("EC-1206");
    	sub20.setText("EC-1207");
    	sub25.setText("HS-1201");
    	
    	if(sec==0) //ec1
    	{
    		sub26.setText("EC-1205 (T)");
    		sub31.setText("EC-1206 (T)");
    		sub32.setText("EC-1204 (T)");
    		sub33.setText("     <[EC-1212]");
    		sub38.setText("[EC1212 Lab]>    ");
    		sub24.setText("EC-1207 (T)");
    	}
    	else if(sec==1)  //ec2
    	{
    		sub22.setText("EC-1207 (T)");
    		sub27.setText("EC-1206 (T)");
    		sub37.setText("EC-1205 (T)");
    		sub28.setText("EC-1204 (T)");
    		sub35.setText("     <[EC-1212]");
    		sub40.setText("[EC1212 Lab]>    ");
    	}
    	else  //ec3
    	{
    		sub32.setText("     <[EC-1212]");
    		sub37.setText("[EC1212 Lab]>    ");
    		sub23.setText("EC-1205 (T)");
    		sub34.setText("EC-1206 (T)");
    		sub30.setText("EC-1207 (T)");
    		sub35.setText("EC-1204 (T)");
    	}
    }
    public void cspop(int sec)
    {
    
    sub1.setText("DAA");
    sub2.setText("DAA");
    sub3.setText("DAA");
    sub4.setText("DAA");
    sub5.setText("DAA");
 
    sub6.setText("DAA");
    sub7.setText("Compiler");
    sub8.setText("DAA");
    sub9.setText("Compiler");
    sub10.setText("DAA");
    
    sub11.setText("OS");
    sub12.setText("OS");
    sub13.setText("Softw. Engg.");
    sub14.setText("Softw. Engg.");
    sub15.setText("Compiler");
    
    sub16.setText("DBMS");
    sub17.setText("Softw. Engg.");
    sub18.setText("OS");
    sub19.setText("DBMS");
    sub20.setText("DBMS");
    
    
    
    if(sec==0) //cs1
    {
    	sub29.setText("Softw. Engg. (T)");


    	sub31.setText("   <[Compiler");
    	sub36.setText("Lab]>           ");	
    	sub32.setText("   <[OS");
    	sub37.setText("Lab]>           ");
    	sub23.setText("   <[DBMS");
    	sub28.setText("Lab]>           ");
    }
    else if(sec==1) //cs2
    {
    	sub26.setText("Softw. Engg. (T)");

    	

    	sub22.setText("   <[Compiler");
    	sub27.setText("Lab]>           ");
    	sub33.setText("   <[OS");
    	sub38.setText("Lab]>           ");
    	sub24.setText("   <[DBMS");
    	sub29.setText("Lab]>           ");

    }
    else //cs3
    {
    	sub27.setText("Softw. Engg. (T)");
  
    	
    	sub21.setText("   <[OS");
    	sub26.setText("Lab]>           ");
    	sub34.setText("   <[Compiler");
    	sub39.setText("Lab]>           ");
    	sub35.setText("   <[DBMS");
    	sub40.setText("Lab]>           ");
    }
    }
    public void eipop()
    {
    	sub6.setText("CS-I");
        sub11.setText("AE");
        sub16.setText("TS");
        sub21.setText("TS (T1)");
        sub26.setText("    <[EI-XXXX]");
        sub31.setText("[TS Lab]>        ");
        
        sub7.setText("CS-I");
        sub12.setText("AE");
        sub17.setText("DE");
        sub22.setText("HS-1201");
          sub27.setText("    <[EI-XXXX]");
        sub32.setText("[ADE Lab]>      ");
        
        sub13.setText("CS-I");
        sub18.setText("TS");
        sub28.setText("HS-1201");
        sub33.setText("CS-I (T1)");
        
        sub9.setText("DE");
        sub14.setText("AE");
        sub19.setText("TS");
        sub24.setText("    <[EI-XXXX]");
            sub29.setText("[CS Lab]>      ");

        sub15.setText("DE");
        sub20.setText("CS-I(T2)");
        sub25.setText("HS-1201");
        sub30.setText("TS(T2)");
    }
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		int brposition=branch.getSelectedItemPosition();
		int secposition=section.getSelectedItemPosition();
		civ_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, civ_array);
		mech_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mech_array);
		ee_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elec_array);
		ec_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ec_array);
		cse_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cse_array);
		ei_arr=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ei);

        civ_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mech_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ee_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ec_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cse_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ei_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        currbranch=brposition;
        resetsubs();
		if(arg0==branch)
		{
			// IMPORTANT: Remove this comment part below to enable all branches 
			
			
		/*	if(brposition==0)
				section.setAdapter(civ_arr);
			else if(brposition==1)
				section.setAdapter(mech_arr);
			else if(brposition==2)
				section.setAdapter(ee_arr);
			else if(brposition==3)
				section.setAdapter(ec_arr);
			else if(brposition==4)
				section.setAdapter(cse_arr);
			else if(brposition==5)
				section.setAdapter(ei_arr);*/
			if(brposition==4)
				section.setAdapter(cse_arr);
			else
				Toast.makeText(this, "Too lazy to update other branches", 3000).show();  // :P
		}
		else if(arg0==section)
		{
			switch(brposition)
			{
			case 0:
				civilpop(secposition); //Set the subjects list according to Civil Branch
				break;
			case 1:
				mechpop(secposition);
				break;
			case 2:
				electricpop(secposition);
				break;
			case 3:
				ecpop(secposition);
				break;
			case 4:
				cspop(secposition);
				break;
			case 5:
				eipop();
				break;
			}
			
		}

	
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		TextView b=(TextView)v;
		String s=b.getText().toString();
		subject currbr[]=new subject[10];
		int i;
		//Toast.makeText(this, s, 3000).show();
		switch(currbranch)
		{
		case 4:
			currbr=cse;
		}
		for(i=0;i<currbr.length;i++)
		{
			if(currbr[i].shortname==s)
					break; // Full name found
			
		}
		if(i<currbr.length)
		Toast.makeText(this, currbr[i].fullname, 3000).show();
		
		
	}
}