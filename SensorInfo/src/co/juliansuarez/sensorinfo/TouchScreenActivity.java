package co.juliansuarez.sensorinfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class TouchScreenActivity extends Activity  implements OnTouchListener{
	
	private View viewTouchArea;
	private TextView textViewXValue;
	private TextView textViewYValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touch_screen);
		
		viewTouchArea = findViewById(R.id.viewTouchArea);
		textViewXValue = (TextView) findViewById(R.id.textViewXValue);
		textViewYValue = (TextView) findViewById(R.id.textViewYValue);
		
		viewTouchArea.setOnTouchListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.touch_screen, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		synchronized (event) {
			textViewXValue.setText(Float.toString(event.getX()));
			textViewYValue.setText(Float.toString(event.getY()));
		}
		return false;
	}

}
