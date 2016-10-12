package ab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

import ab.adapter.MyAdapter;
import ab.bean.ImageFloder;
import spfworld.spfworld.R;


public class SelectImageActivity extends Activity implements MyAdapter.ChooseImages {
	private GridView mGirdView;
	private MyAdapter mAdapter;
	/**
	 * 所有的图片
	 */
	private List<String> mImgs;

	private TextView mChooseDir;
	private TextView mImageCount;
	private Button sendBtn;

	private int num = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_image);
		mGirdView = (GridView) findViewById(R.id.id_gridView);
		mChooseDir = (TextView) findViewById(R.id.id_choose_dir);
		mImageCount = (TextView) findViewById(R.id.id_total_count);




		/**
		 * 可以看到文件夹的路径和图片的路径分开保存，极大的减少了内存的消耗；
		 */
		ImageFloder item = (ImageFloder) getIntent().getSerializableExtra("images");
		File file = new File(item.getDir());
		mImgs = Arrays.asList(file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".jpeg"))
					return true;
				return false;
			}
		}));
		mAdapter = new MyAdapter(getApplicationContext(), mImgs, R.layout.grid_item, file.getAbsolutePath());
		mAdapter.setCanChooseNum(getIntent().getIntExtra("size", 3));
		mAdapter.setChooseImages(this);
		mGirdView.setAdapter(mAdapter);
		mImageCount.setText(item.getCount() + "张");
		mChooseDir.setText(item.getName());

	}

	@Override
	public void imgListSize() {
		num = mAdapter.mSelectedImage.size();
	}

}
