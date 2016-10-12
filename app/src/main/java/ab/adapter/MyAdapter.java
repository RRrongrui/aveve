package ab.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import spfworld.spfworld.R;


public class MyAdapter extends CommonAdapter<String> {

    /**
     * 用户选择的图片，存储为图片的完整路径
     */
    public ArrayList<String> mSelectedImage = new ArrayList<String>();

    /**
     * 文件夹路径
     */
    private String mDirPath;

    private ChooseImages chooseImages;

    private int canChooseNum = 9;

    public ArrayList<String> getmSelectedImage() {
        return mSelectedImage;
    }

    public MyAdapter(Context context, List<String> mDatas, int itemLayoutId, String dirPath) {
        super(context, mDatas, itemLayoutId);
        this.mDirPath = dirPath;
    }

    public void setChooseImages(ChooseImages chooseImages) {
        this.chooseImages = chooseImages;
    }

    public void setCanChooseNum(int canChooseNum) {
        this.canChooseNum = canChooseNum;
    }

    @Override
    public void convert(ViewHolder helper, final String item, int position) {
        // 设置no_pic
        ImageView id_item_image = helper.getView(R.id.id_item_image);
        ImageButton id_item_select = helper.getView(R.id.id_item_select);
        id_item_image.setImageResource(R.mipmap.pictures_no);
        // 设置no_selected
        id_item_select.setImageResource(R.mipmap.picture_unselected);
        // 设置图片
        ImageLoader.getInstance().displayImage("file://" + mDirPath + "/" + item,id_item_image);
        final ImageView mImageView = helper.getView(R.id.id_item_image);
        final ImageView mSelect = helper.getView(R.id.id_item_select);

        mImageView.setColorFilter(null);
        // 设置ImageView的点击事件
        mImageView.setOnClickListener(new OnClickListener() {
            // 选择，则将图片变暗，反之则反之
            @Override
            public void onClick(View v) {
                // 已经选择过该图片
                if (mSelectedImage.contains(mDirPath + "/" + item)) {
                    mSelectedImage.remove(mDirPath + "/" + item);
                    mSelect.setImageResource(R.mipmap.picture_unselected);
                    mImageView.setColorFilter(null);
                } else {// 未选择该图片
                    if (mSelectedImage.size() == canChooseNum) {
                        Toast.makeText(mContext, "最多选择" + canChooseNum + "张",0).show();
                        return;
                    }
                    mSelectedImage.add(mDirPath + "/" + item);
                    mSelect.setImageResource(R.mipmap.pictures_selected);
                    mImageView.setColorFilter(Color.parseColor("#77000000"));
                }

                if (chooseImages != null) {
                    chooseImages.imgListSize();
                }
            }
        });

        /**
         * 已经选择过的图片，显示出选择过的效果
         */
        if (mSelectedImage.contains(mDirPath + "/" + item)) {
            mSelect.setImageResource(R.mipmap.pictures_selected);
            mImageView.setColorFilter(Color.parseColor("#77000000"));
        }

    }

    public interface ChooseImages {
        /**
         * 获取选择图片列表数量
         */
        void imgListSize();
    }
}
