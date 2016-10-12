package spfworld.spfworld.fragment.find.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;

import spfworld.spfworld.R;

/**
 * Created by guozhengke on 2016/9/7.
 */
public class CallDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.call_diag,null);
        builder.setView(view).setPositiveButton("确定",
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                }).setNegativeButton("取消", null);
        return builder.create();
    }

    public void show(FragmentManager fragmentManager, String dialogFragment) {

    }
}
