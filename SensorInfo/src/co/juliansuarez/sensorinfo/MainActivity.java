package co.juliansuarez.sensorinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements
		OnItemClickListener {

	private ListView listView;

	private static final int ITEM_PROXIMITY = 0;
	private static final int ITEM_POSITION = 1;
	private static final int ITEM_TOUCH_SCREEN = 2;
	private static final int ITEM_ACCELEROMETER = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter
				.createFromResource(this, R.array.sensors_list,
						android.R.layout.simple_list_item_1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {
		switch (position) {
		case ITEM_PROXIMITY:
			startActivity(new Intent(getApplicationContext(),
					ProximityActivity.class));
			break;
		case ITEM_POSITION:
			startActivity(new Intent(getApplicationContext(),
					PositionActivity.class));
			break;
		case ITEM_TOUCH_SCREEN:
			startActivity(new Intent(getApplicationContext(),
					TouchScreenActivity.class));
			break;			
		case ITEM_ACCELEROMETER:
		default:
			startActivity(new Intent(getApplicationContext(),
					AccelerometerActivity.class));
			break;			
		}

	}

}
