package net.gbs.calcu_v2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText et_oper1, et_oper2;
	private Double oper1, oper2, resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_oper1 = (EditText) findViewById(R.id.ET_Oper1);
        et_oper2 = (EditText) findViewById(R.id.ET_Oper2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void ejecuta(View v){
    	try{
	    	oper1 = Double.parseDouble(et_oper1.getText().toString());
	    	oper2 = Double.parseDouble(et_oper2.getText().toString());
	    	
	    	String operacion = v.getTag().toString();
	    	
	    	if (operacion.equals("+")){   		
	        	resul = oper1 + oper2;
	    	} 
	    		
	    	if (operacion.equals("-")){
	    		resul = oper1 - oper2;	
	    	}
	    	
	    	if (operacion.equals("*")){
	    		resul = oper1 * oper2;
	    	}
	    	
	    	if (operacion.equals("/")){
	    		if(oper2 == 0.0){
	    			operacion = "1";
	    		}else{
	    			resul = oper1 / oper2;
	    		}			
	    	}
	    	
	    	resultado(oper1 ,oper2, resul, operacion);
    	} catch (NumberFormatException e){
    		resultado(0.0, 0.0, 0.0, "2");
    	}
    }
    
    public void resultado(Double op1, Double op2, Double res, String oper) {
    	Intent intent = new Intent(this, ResulActivity.class);
    	
    	if(oper != "1" && oper != "2") {
    		intent.putExtra("resultado", op1.toString() +" " + oper + " " + op2.toString() + " = " + res.toString());
    	}
    	
    	if(oper.equals("1")){
    		intent.putExtra("resultado", "División por 0 no permitida.");
    	} 
    	
    	if(oper.equals("2")){
    		intent.putExtra("resultado", "Los operandos no pueden estar vacíos.");
    	}
    	
    	startActivity(intent);
    }
}
