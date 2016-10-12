package spfworld.spfworld.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import spfworld.spfworld.MainActivity;
import spfworld.spfworld.R;
import spfworld.spfworld.adapter.CityAdapter;
import spfworld.spfworld.entity.CityItem;
import spfworld.spfworld.entity.Content;
import spfworld.spfworld.utils.city.CityData;
import spfworld.spfworld.utils.city.ContactItemInterface;
import spfworld.spfworld.utils.city.ContactListViewImpl;


public class CityListActivity extends Activity implements TextWatcher
{
	private Context context_ = CityListActivity.this;
	private ContactListViewImpl listview;
	private EditText searchBox;
	private String searchString;
	private Object searchLock = new Object();
	boolean inSearchMode = false;

	private final static String TAG = "MainActivity2";

	List<ContactItemInterface> contactList;
	List<ContactItemInterface> filterList;
	private SearchListTask curSearchTask = null;
	private FragmentManager manager;
	private FragmentTransaction transaction;
	private ImageView city_back;
	private GridView city_gridView;
	private String texts[]=null;
	private TextView city;
	private TextView city1;
	private TextView city2;
	private TextView city3;
	private TextView city4;
	private TextView city5;
	private TextView city6;
	private TextView city7;
	private TextView city8;
	private TextView city9;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.citylist);
		x.view().inject(this);
		city_back= (ImageView) findViewById(R.id.city_back);
		city= (TextView) findViewById(R.id.city);
		city1= (TextView) findViewById(R.id.city1);
		city2= (TextView) findViewById(R.id.tv_city2);
		city3= (TextView) findViewById(R.id.tv_city3);
		city4= (TextView) findViewById(R.id.city4);
		city5= (TextView) findViewById(R.id.tv_city5);
		city6= (TextView) findViewById(R.id.tv_city6);
		city7= (TextView) findViewById(R.id.city7);
		city8= (TextView) findViewById(R.id.tv_city8);
		city9= (TextView) findViewById(R.id.tv_city9);
		city.setText(Content.mapcity);
		city.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city=Content.mapcity;
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="北京";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="三亚";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="西安";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="武汉";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="上海";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="深圳";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="宁波";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="南京";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Content.city="温州";
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		city_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(CityListActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		manager=getFragmentManager();
		filterList = new ArrayList<ContactItemInterface>();
		contactList = CityData.getSampleContactList();

		CityAdapter adapter = new CityAdapter(this,R.layout.city_item, contactList);

		listview = (ContactListViewImpl) this.findViewById(R.id.listview);
		listview.setFastScrollEnabled(true);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView parent, View v, int position,
					long id)
			{
				List<ContactItemInterface> searchList = inSearchMode ? filterList
						: contactList;
				Content.city=searchList.get(position).getDisplayInfo();
				Intent intent=new Intent(CityListActivity.this, MainActivity.class);
				startActivity(intent);

			}
		});
		searchBox = (EditText) findViewById(R.id.input_search_query);
		searchBox.addTextChangedListener(this);
	}

	@Override
	public void afterTextChanged(Editable s)
	{
		searchString = searchBox.getText().toString().trim().toUpperCase();

		if (curSearchTask != null
				&& curSearchTask.getStatus() != AsyncTask.Status.FINISHED)
		{
			try
			{
				curSearchTask.cancel(true);
			} catch (Exception e)
			{
				Log.i(TAG, "Fail to cancel running search task");
			}

		}
		curSearchTask = new SearchListTask();
		curSearchTask.execute(searchString); 
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after)
	{
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count)
	{
		// do nothing
	}

	private class SearchListTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params)
		{
			filterList.clear();

			String keyword = params[0];

			inSearchMode = (keyword.length() > 0);

			if (inSearchMode)
			{
				// get all the items matching this
				for (ContactItemInterface item : contactList)
				{
					CityItem contact = (CityItem) item;

					boolean isPinyin = contact.getFullName().toUpperCase().indexOf(keyword) > -1;
					boolean isChinese = contact.getNickName().indexOf(keyword) > -1;

					if (isPinyin || isChinese)
					{
						filterList.add(item);
					}

				}

			}
			return null;
		}

		protected void onPostExecute(String result)
		{

			synchronized (searchLock)
			{

				if (inSearchMode)
				{

					CityAdapter adapter = new CityAdapter(context_,R.layout.city_item, filterList);
					adapter.setInSearchMode(true);
					listview.setInSearchMode(true);
					listview.setAdapter(adapter);
				} else
				{
					CityAdapter adapter = new CityAdapter(context_,R.layout.city_item, contactList);
					adapter.setInSearchMode(false);
					listview.setInSearchMode(false);
					listview.setAdapter(adapter);
				}
			}

		}
	}

}
