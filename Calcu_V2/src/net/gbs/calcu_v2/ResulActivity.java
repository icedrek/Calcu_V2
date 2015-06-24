package net.gbs.calcu_v2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ResulActivity extends Activity {
	private TextView tv_resul;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resul);
		
		//Se asocia variable tv_resul con TextView del activity_resul
		tv_resul = (TextView) findViewById(R.id.TV_Resul);
		
		//Se recupera el valor enviado desde activity_main
		Bundle bundle = getIntent().getExtras();
		
		//Se escribe resultado en el TextView del activity_resul
		tv_resul.setText(bundle.getString("resultado"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resul, menu);
		return true;
	}

}
