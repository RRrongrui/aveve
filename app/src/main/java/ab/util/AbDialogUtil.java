/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ab.util;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Calendar;

import ab.ProgressWheel;
import ab.fragment.AbAlertDialogFragment;
import ab.fragment.AbAlertDialogFragment.AbDialogOnClickListener;
import ab.fragment.AbDialogFragment.AbDialogOnLoadListener;
import ab.fragment.AbLoadDialogFragment;
import ab.fragment.AbProgressDialogFragment;
import ab.fragment.AbProgressDialogFragment2;
import ab.fragment.AbRefreshDialogFragment;
import ab.fragment.AbSampleDialogFragment;
import ab.sweetdailog.SweetAlertDialog;
import ab.sweetdailog.SweetAlertDialog.OnSweetClickListener;
import ab.util.model.ChoiceDate;
import ab.view.OnWheelChangedListener;
import ab.view.WheelView;
import ab.view.wheel.adapters.ArrayWheelAdapter;
import spfworld.spfworld.R;


// TODO: Auto-generated Javadoc
/**
 * © 2012 amsoft.cn 名称：AbDialogUtil.java 描述：Dialog工具类.
 * 
 * @author 还如一梦中
 * @version v1.0
 * @date：2014-07-02 下午11:52:13
 */
@SuppressLint("NewApi")
public class AbDialogUtil {

	/** dialog tag */
	private static String mDialogTag = "dialog";

	/**
	 * 全屏显示一个对话框不影响下面的View的点击
	 * 
	 * @param view
	 * @return
	 */
	public static AbSampleDialogFragment showTipsDialog(View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light);
		newFragment.setContentView(view);

		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		// 作为全屏显示,使用“content”作为fragment容器的基本视图,这始终是Activity的基本视图
		ft.add(android.R.id.content, newFragment, mDialogTag)
				.addToBackStack(null).commit();

		return newFragment;
	}

	/**
	 * 全屏显示一个对话框
	 * 
	 * @param view
	 * @return
	 */
	public static AbSampleDialogFragment showFullScreenDialog(View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NORMAL,
						android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框(有背景层)
	 * 
	 * @param view
	 */
	public static AbSampleDialogFragment showDialog(View view) {
		return showDialog(view, Gravity.CENTER);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框(有背景层).
	 * 
	 * @param view
	 * @param gravity
	 *            位置
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int gravity) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light_Dialog, gravity);
		newFragment.setContentView(view);

		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);

		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框(有背景层)
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter,
			int animExit, int animPopEnter, int animPopExit) {
		return showDialog(view, animEnter, animExit, animPopEnter, animPopExit,
				Gravity.CENTER);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框(有背景层).
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param gravity
	 *            位置
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter,
			int animExit, int animPopEnter, int animPopExit, int gravity) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light_Dialog, gravity);
		newFragment.setContentView(view);
		// 自定义转场动画
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		ft.setCustomAnimations(animEnter, animExit, animPopEnter, animPopExit);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框(有背景层)
	 * 
	 * @param view
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view,
			DialogInterface.OnCancelListener onCancelListener) {
		return showDialog(view, Gravity.CENTER, onCancelListener);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框(有背景层).
	 * 
	 * @param view
	 * @param gravity
	 *            位置
	 * @param onCancelListener
	 *            　取消事件
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int gravity,
			DialogInterface.OnCancelListener onCancelListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light_Dialog, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.setOnCancelListener(onCancelListener);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框(有背景层).
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter,
			int animExit, int animPopEnter, int animPopExit,
			DialogInterface.OnCancelListener onCancelListener) {
		return showDialog(view, animEnter, animExit, animPopEnter, animPopExit,
				Gravity.CENTER, onCancelListener);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框(有背景层).
	 * 
	 * @param view
	 * @param animEnter
	 * @param animExit
	 * @param animPopEnter
	 * @param animPopExit
	 * @param gravity
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showDialog(View view, int animEnter,
			int animExit, int animPopEnter, int animPopExit, int gravity,
			DialogInterface.OnCancelListener onCancelListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light_Dialog, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		ft.setCustomAnimations(animEnter, animExit, animPopEnter, animPopExit);
		newFragment.setOnCancelListener(onCancelListener);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框(无背景层)
	 * 
	 * @param view
	 */
	public static AbSampleDialogFragment showPanel(View view) {
		return showPanel(view, Gravity.CENTER);
	}

	/**
	 * 
	 * 描述：显示一个自定义的对话框(无背景层).
	 * 
	 * @param view
	 * @param gravity
	 * @return
	 */
	public static AbSampleDialogFragment showPanel(View view, int gravity) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Light_Panel, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个自定义的对话框(无背景层)
	 * 
	 * @param view
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showPanel(View view,
			DialogInterface.OnCancelListener onCancelListener) {
		return showPanel(view, Gravity.CENTER, onCancelListener);
	}

	/**
	 * 显示一个自定义的对话框(无背景层)
	 * 
	 * @param view
	 * @param onCancelListener
	 * @return
	 */
	public static AbSampleDialogFragment showPanel(View view, int gravity,
			DialogInterface.OnCancelListener onCancelListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		// Create and show the dialog.
		AbSampleDialogFragment newFragment = AbSampleDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Light_Panel, gravity);
		newFragment.setContentView(view);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.setOnCancelListener(onCancelListener);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （图标，标题，String内容）.
	 * 
	 * @param context
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static AbAlertDialogFragment showAlertDialog(Context context,
			int icon, String title, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				icon, title, message, null, null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（图标，标题，string内容，确认，取消）.
	 * 
	 * @param context
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param message
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static AbAlertDialogFragment showAlertDialog(Context context,
			int icon, String title, String message,
			AbDialogOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				icon, title, message, null, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（标题，String内容，确认，取消）.
	 * 
	 * @param context
	 * @param title
	 *            对话框标题内容
	 * @param message
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static AbAlertDialogFragment showAlertDialog(Context context,
			String title, String message,
			AbDialogOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				0, title, message, null, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（View内容）.
	 * 
	 * @param view
	 *            对话框标题内容
	 */
	public static AbAlertDialogFragment showAlertDialog(View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				0, null, null, view, null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（String内容）.
	 * 
	 * @param context
	 * @param title
	 *            对话框标题内容
	 */
	public static AbAlertDialogFragment showAlertDialog(Context context,
			String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				0, null, message, null, null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （图标，标题，View内容）.
	 * 
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static AbAlertDialogFragment showAlertDialog(int icon, String title,
			View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				icon, title, null, view, null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（图标，标题，View内容，确认，取消）.
	 * 
	 * @param icon
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static AbAlertDialogFragment showAlertDialog(int icon, String title,
			View view, AbDialogOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				icon, title, null, view, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （标题，View内容）.
	 * 
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static AbAlertDialogFragment showAlertDialog(String title, View view) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				0, title, null, view, null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 显示一个一般的对话框（标题，View内容，确认，取消）.
	 * 
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 * @param onClickListener
	 *            点击确认按钮的事件监听
	 */
	public static AbAlertDialogFragment showAlertDialog(String title,
			View view, AbDialogOnClickListener onClickListener) {
		FragmentActivity activity = (FragmentActivity) view.getContext();
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				0, title, null, view, onClickListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：对话框dialog （标题，String内容）.
	 * 
	 * @param context
	 * @param title
	 *            对话框标题内容
	 * @param view
	 *            对话框提示内容
	 */
	public static AbAlertDialogFragment showAlertDialog(Context context,
			String title, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbAlertDialogFragment newFragment = AbAlertDialogFragment.newInstance(
				0, title, message, null, null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示进度框.zz
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 *            用默认请写0
	 * @param message
	 *            the message
	 */
	public static AbProgressDialogFragment showProgressDialog(Context context,
			int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbProgressDialogFragment newFragment = AbProgressDialogFragment
				.newInstance(indeterminateDrawable, message);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示进度框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 *            用默认请写0
	 * @param message
	 *            the message
	 */
	public static AbProgressDialogFragment2 showProgressDialog2(
			Context context, int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbProgressDialogFragment2 newFragment = AbProgressDialogFragment2
				.newInstance(indeterminateDrawable, message);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 */
	public static AbLoadDialogFragment showLoadDialog(Context context,
			int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbLoadDialogFragment newFragment = AbLoadDialogFragment.newInstance(
				DialogFragment.STYLE_NO_TITLE,
				android.R.style.Theme_Holo_Light_Dialog);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 */
	public static AbLoadDialogFragment showLoadDialog(Context context,
			int indeterminateDrawable, String message,
			AbDialogOnLoadListener abDialogOnLoadListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbLoadDialogFragment newFragment = AbLoadDialogFragment.newInstance(
				DialogFragment.STYLE_NO_TITLE,
				android.R.style.Theme_Holo_Light_Dialog);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(abDialogOnLoadListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 */
	public static AbLoadDialogFragment showLoadPanel(Context context,
			int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbLoadDialogFragment newFragment = AbLoadDialogFragment.newInstance(
				DialogFragment.STYLE_NO_TITLE,
				android.R.style.Theme_Light_Panel);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示加载框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 * @param abDialogOnRefreshListener
	 */
	public static AbLoadDialogFragment showLoadPanel(Context context,
			int indeterminateDrawable, String message,
			AbDialogOnLoadListener abDialogOnLoadListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbLoadDialogFragment newFragment = AbLoadDialogFragment.newInstance(
				DialogFragment.STYLE_NO_TITLE,
				android.R.style.Theme_Light_Panel);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(abDialogOnLoadListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 * @param abDialogOnRefreshListener
	 */
	public static AbRefreshDialogFragment showRefreshDialog(Context context,
			int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbRefreshDialogFragment newFragment = AbRefreshDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light_Dialog);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 * @param indeterminateDrawable
	 * @param message
	 * @param abDialogOnRefreshListener
	 * @return
	 */
	public static AbRefreshDialogFragment showRefreshDialog(Context context,
			int indeterminateDrawable, String message,
			AbDialogOnLoadListener abDialogOnLoadListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbRefreshDialogFragment newFragment = AbRefreshDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Holo_Light_Dialog);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(abDialogOnLoadListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 *            the context
	 * @param indeterminateDrawable
	 * @param message
	 *            the message
	 */
	public static AbRefreshDialogFragment showRefreshPanel(Context context,
			int indeterminateDrawable, String message) {
		FragmentActivity activity = (FragmentActivity) context;
		AbRefreshDialogFragment newFragment = AbRefreshDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Light_Panel);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(null);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：显示刷新框.
	 * 
	 * @param context
	 * @param indeterminateDrawable
	 * @param message
	 * @param abDialogOnRefreshListener
	 * @return
	 */
	public static AbRefreshDialogFragment showRefreshPanel(Context context,
			int indeterminateDrawable, String message,
			AbDialogOnLoadListener abDialogOnLoadListener) {
		FragmentActivity activity = (FragmentActivity) context;
		AbRefreshDialogFragment newFragment = AbRefreshDialogFragment
				.newInstance(DialogFragment.STYLE_NO_TITLE,
						android.R.style.Theme_Light_Panel);
		newFragment.setIndeterminateDrawable(indeterminateDrawable);
		newFragment.setMessage(message);
		newFragment.setAbDialogOnLoadListener(abDialogOnLoadListener);
		FragmentTransaction ft = activity.getFragmentManager()
				.beginTransaction();
		// 指定一个系统转场动画
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		newFragment.show(ft, mDialogTag);
		return newFragment;
	}

	/**
	 * 描述：移除Fragment.
	 * 
	 * @param context
	 *            the context
	 */
	public static void removeDialog(Context context) {
		try {
			FragmentActivity activity = (FragmentActivity) context;
			FragmentTransaction ft = activity.getFragmentManager()
					.beginTransaction();
			// 指定一个系统转场动画
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
			Fragment prev = activity.getFragmentManager().findFragmentByTag(
					mDialogTag);
			if (prev != null) {
				ft.remove(prev);
			}
			ft.addToBackStack(null);
			if (context != null) {
				ft.commit();
			}
		} catch (Exception e) {
			// 可能有Activity已经被销毁的异常
			e.printStackTrace();
		}
	}

	/**
	 * 描述：移除Fragment和View
	 * 
	 * @param view
	 */
	public static void removeDialog(View view) {
		removeDialog(view.getContext());
		AbViewUtil.removeSelfFromParent(view);
	}

	/**
	 * 显示基本对话框
	 * 
	 * @param content
	 *            内容
	 * @param title
	 *            标题
	 * @param isShowConfirm
	 *            是否显示确认按钮
	 * @return sweetAlertDialog
	 */
	public static SweetAlertDialog showBasicDialog(Context context,
			String content) {
		SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context);
		sweetAlertDialog.setContentText(content);
		sweetAlertDialog.show();
		return sweetAlertDialog;
	}

	/**
	 * 显示错误信息dialog
	 * 
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param butText
	 *            button文本内容
	 * @return
	 */
	public static SweetAlertDialog showErroDialog(Context context,
			String title, String content, String butText,
			OnSweetClickListener onSweetClickListener) {
		SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context,
				SweetAlertDialog.ERROR_TYPE);
		sweetAlertDialog.setContentText(AbStrUtil.parseEmpty(content));
		sweetAlertDialog.setTitleText(AbStrUtil.parseEmpty(title));
		sweetAlertDialog.setConfirmText(AbStrUtil.parseEmpty(butText));
		sweetAlertDialog.setConfirmClickListener(onSweetClickListener);
		sweetAlertDialog.show();
		return sweetAlertDialog;
	}

	/**
	 * 显示成功信息dialog
	 * 
	 * @param title
	 * @param content
	 * @param butText
	 * @return
	 */
	public static SweetAlertDialog showSuccessDialog(Context context,
			String title, String content, String butText) {
		SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context,
				SweetAlertDialog.SUCCESS_TYPE);
		sweetAlertDialog.setContentText(AbStrUtil.parseEmpty(content));
		sweetAlertDialog.setTitleText(AbStrUtil.parseEmpty(title));
		sweetAlertDialog.setConfirmText(AbStrUtil.parseEmpty(butText));
		sweetAlertDialog.show();
		return sweetAlertDialog;
	}

	/**
	 * 显示成功信息dialog
	 * 
	 * @param title
	 * @param content
	 * @param butText
	 * @return
	 */
	public SweetAlertDialog showSuccessDialog2(Context context, String title,
			String content, String butText, OnSweetClickListener onClickListener) {
		SweetAlertDialog showSuccessDialog = showSuccessDialog(context, title,
				content, butText);
		showSuccessDialog.setConfirmClickListener(onClickListener);
		return showSuccessDialog;
	}

	/**
	 * 显示警告信息对话框
	 * 
	 * @param title
	 * @param content
	 * @param butText
	 * @return
	 */
	public SweetAlertDialog showWarningDialog(Context context, String title,
			String content, String confirmButText,
			OnSweetClickListener onSweetClickListener) {
		SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context,
				SweetAlertDialog.WARNING_TYPE);
		sweetAlertDialog.setContentText(AbStrUtil.parseEmpty(content));
		sweetAlertDialog.setTitleText(AbStrUtil.parseEmpty(title));
		sweetAlertDialog.setConfirmText(AbStrUtil.parseEmpty(confirmButText));
		sweetAlertDialog.setConfirmClickListener(onSweetClickListener);
		sweetAlertDialog.show();
		return sweetAlertDialog;
	}

	/**
	 * 显示警告信息对话框2
	 * 
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param confirmButText
	 *            确认按钮内容
	 * @param onConfirmListener
	 *            确认按钮监听
	 * @param onCancleListener
	 *            取消按钮监听
	 * @return
	 */
	public static SweetAlertDialog showWarningDialog2(Context context,
			String title, String content, String confirmButText,
			OnSweetClickListener onConfirmListener, String cancelConent,
			OnSweetClickListener onCancleListener) {
		SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context,
				SweetAlertDialog.WARNING_TYPE);
		sweetAlertDialog.setContentText(AbStrUtil.parseEmpty(content));
		sweetAlertDialog.setTitleText(AbStrUtil.parseEmpty(title));
		sweetAlertDialog.setConfirmText(AbStrUtil.parseEmpty(confirmButText));
		sweetAlertDialog.setConfirmClickListener(onConfirmListener);
		sweetAlertDialog.showCancelButton(true);
		sweetAlertDialog.setCancelText(AbStrUtil.parseEmpty(cancelConent));
		sweetAlertDialog.setCancelClickListener(onCancleListener);
		sweetAlertDialog.show();
		return sweetAlertDialog;
	}

	/**
	 * 得到自定义的progressDialog
	 * 
	 * @param context
	 * @param msg
	 * @return
	 */
	public static Dialog createLoadingDialog(Context context, String msg) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(
				R.layout.herily_alertex_dialog_custom_frame_layout, null);// 得到加载view
		ProgressWheel spaceshipImage = (ProgressWheel) v
				.findViewById(R.id.customFrameLoadImg);
		spaceshipImage.stopSpinning();
		spaceshipImage.startSpinning();
		TextView tipTextView = (TextView) v.findViewById(R.id.customFrameMsg);// 提示文字
		tipTextView.setText(msg);// 设置加载信息
		Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
		loadingDialog.setCancelable(false);// 不可以用“返回键”取消
		loadingDialog.setContentView(v, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
		return loadingDialog;
	}

	/**
	 * 弹出popupwindow
	 */
	public static PopupWindow showPopWindow(Context context, View targetView,
			View contentView, Integer width) {
		PopupWindow popupWindow = null;
		popupWindow = new PopupWindow(contentView, -2, -2);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
		if (width != null) {
			popupWindow.setWidth(width);
		}
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAsDropDown(targetView);
		return popupWindow;
	}

	/**
	 * 弹出popupwindow
	 */
	public static PopupWindow showPopWindow2(Context context, View targetView,
			View contentView, Integer width) {
		PopupWindow popupWindow = null;
		popupWindow = new PopupWindow(contentView, -2, -2);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
		if (width != null) {
			popupWindow.setWidth(width);
		}
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAtLocation(targetView, Gravity.BOTTOM, 0, 0);
		return popupWindow;
	}

	/**
	 * 弹出popupwindow
	 */
	public static PopupWindow showPopWindow3(Context context, View targetView,
			View contentView, Integer width) {
		PopupWindow popupWindow = null;
		popupWindow = new PopupWindow(contentView, -2, -2);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
		if (width != null) {
			popupWindow.setWidth(width);
		}
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAtLocation(targetView, Gravity.CENTER_VERTICAL
				| Gravity.CENTER_HORIZONTAL, 0, 0);
		return popupWindow;
	}

	/**
	 * 弹出年月日时分秒选择器popup
	 */
	// 滚轮上的数据，字符串数组
	public static String[] yearArrayString = null;
	public static String[] dayArrayString = null;
	public static String[] monthArrayString = null;
	public static String[] hourArrayString = null;
	public static String[] minuteArrayString = null;

	public static Calendar c = null;
	private static WheelView yearWV = null;
	private static WheelView monthWV = null;
	private static WheelView dayWV = null;
	private static WheelView hourWV = null;
	private static WheelView minuteWV = null;

	public static MyPop showDatePopWindow(Context context, View contentView,
			View targetView) {
		// 得到相应的数组
		yearArrayString = getYEARArray(2016, 30);
		monthArrayString = getDayArray(12);
		hourArrayString = getHMArray(24);
		minuteArrayString = getHMArray(60);
		// 获取当前系统时间
		c = Calendar.getInstance();
		PopupWindow popupWindow = new PopupWindow(contentView, -2, -2);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
		popupWindow
				.setWidth(context.getResources().getDisplayMetrics().widthPixels);
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAtLocation(targetView, Gravity.BOTTOM, 0, 0);
		yearWV = (WheelView) contentView.findViewById(R.id.time_year);
		monthWV = (WheelView) contentView.findViewById(R.id.time_month);
		dayWV = (WheelView) contentView.findViewById(R.id.time_day);
		hourWV = (WheelView) contentView.findViewById(R.id.time_hour);
		minuteWV = (WheelView) contentView.findViewById(R.id.time_minute);

		// 设置每个滚轮的行数
		yearWV.setVisibleItems(5);
		monthWV.setVisibleItems(5);
		dayWV.setVisibleItems(5);
		hourWV.setVisibleItems(5);
		minuteWV.setVisibleItems(5);

		// 设置滚轮的标签
		yearWV.setLabel("年");
		monthWV.setLabel("月");
		dayWV.setLabel("日");
		hourWV.setLabel("时");
		minuteWV.setLabel("分");
		yearWV.setCyclic(true);
		monthWV.setCyclic(true);
		dayWV.setCyclic(true);
		hourWV.setCyclic(true);
		minuteWV.setCyclic(true);
		setData();
		return new MyPop(popupWindow, yearWV, monthWV, dayWV, hourWV, minuteWV);
	}

	/**
	 * 年月日
	 */
	public static MyPop showDatePopWindowDate(Context context,
			View contentView, View targetView) {
		// 得到相应的数组
		yearArrayString = getYEARArray(2016, 36);
		monthArrayString = getDayArray(12);
		hourArrayString = getHMArray(24);
		minuteArrayString = getHMArray(60);
		// 获取当前系统时间
		c = Calendar.getInstance();
		PopupWindow popupWindow = new PopupWindow(contentView, -2, -2);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		popupWindow
				.setWidth(context.getResources().getDisplayMetrics().widthPixels);
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAtLocation(targetView, Gravity.BOTTOM, 0, 0);
		yearWV = (WheelView) contentView.findViewById(R.id.time_year);
		monthWV = (WheelView) contentView.findViewById(R.id.time_month);
		dayWV = (WheelView) contentView.findViewById(R.id.time_day);
		hourWV = (WheelView) contentView.findViewById(R.id.time_hour);
		minuteWV = (WheelView) contentView.findViewById(R.id.time_minute);
		hourWV.setVisibility(View.GONE);
		minuteWV.setVisibility(View.GONE);
		// 设置每个滚轮的行数
		yearWV.setVisibleItems(5);
		monthWV.setVisibleItems(5);
		dayWV.setVisibleItems(5);
		hourWV.setVisibleItems(5);
		minuteWV.setVisibleItems(5);

		// 设置滚轮的标签
		yearWV.setLabel("年");
		monthWV.setLabel("月");
		dayWV.setLabel("日");
		hourWV.setLabel("时");
		minuteWV.setLabel("分");
		yearWV.setCyclic(true);
		monthWV.setCyclic(true);
		dayWV.setCyclic(true);
		hourWV.setCyclic(true);
		minuteWV.setCyclic(true);
		setData();
		return new MyPop(popupWindow, yearWV, monthWV, dayWV, hourWV, minuteWV);
	}

	/**
	 * 时分
	 */
	public static MyPop showDatePopWindowHour(Context context,
			View contentView, View targetView) {
		// 得到相应的数组
		hourArrayString = getHMArray(24);
		// 获取当前系统时间
		c = Calendar.getInstance();
		PopupWindow popupWindow = new PopupWindow(contentView, -2, -2);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		popupWindow
				.setWidth(context.getResources().getDisplayMetrics().widthPixels);
		popupWindow.setOutsideTouchable(true);
		popupWindow.showAtLocation(targetView, Gravity.BOTTOM, 0, 0);

		hourWV = (WheelView) contentView.findViewById(R.id.time_hour);
		// 设置每个滚轮的行数
		hourWV.setVisibleItems(5);
		// 设置滚轮的标签
		hourWV.setLabel(":00");
		hourWV.setCyclic(true);
		setHourData();
		return new MyPop(popupWindow, yearWV, monthWV, dayWV, hourWV, minuteWV);
	}

	/**
	 * 给滚轮提供数据
	 */
	private static void setHourData() {
		// 给滚轮提供数据
		hourWV.setAdapter(new ArrayWheelAdapter<String>(hourArrayString));
		// 把当前系统时间显示为滚轮默认时间
		setOriHourTime();
	}

	/**
	 * 给滚轮提供数据
	 */
	private static void setData() {
		// 给滚轮提供数据
		yearWV.setAdapter(new ArrayWheelAdapter<String>(yearArrayString));
		monthWV.setAdapter(new ArrayWheelAdapter<String>(monthArrayString));
		hourWV.setAdapter(new ArrayWheelAdapter<String>(hourArrayString));
		minuteWV.setAdapter(new ArrayWheelAdapter<String>(minuteArrayString));
		yearWV.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				// 获取年和月
				int year = Integer.parseInt(yearArrayString[yearWV
						.getCurrentItem()]);
				int month = Integer.parseInt(monthArrayString[monthWV
						.getCurrentItem()]);
				// 根据年和月生成天数数组
				dayArrayString = getDayArray(getDay(year, month));
				// 给天数的滚轮设置数据
				dayWV.setAdapter(new ArrayWheelAdapter<String>(dayArrayString));
				// 防止数组越界
				if (dayWV.getCurrentItem() >= dayArrayString.length) {
					dayWV.setCurrentItem(dayArrayString.length - 1);
				}
			}
		});
		// 当月变化时显示的时间
		monthWV.addChangingListener(new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				// 获取年和月
				int year = Integer.parseInt(yearArrayString[yearWV
						.getCurrentItem()]);
				int month = Integer.parseInt(monthArrayString[monthWV
						.getCurrentItem()]);
				// 根据年和月生成天数数组
				dayArrayString = getDayArray(getDay(year, month));
				// 给天数的滚轮设置数据
				dayWV.setAdapter(new ArrayWheelAdapter<String>(dayArrayString));
				// 防止数组越界
				if (dayWV.getCurrentItem() >= dayArrayString.length) {
					dayWV.setCurrentItem(dayArrayString.length - 1);
				}
			}
		});
		// 把当前系统时间显示为滚轮默认时间
		setOriTime();
	}

	public static ChoiceDate date;

	// 显示时间
	public static ChoiceDate showDate() {
		ChoiceDate choiceDate = new ChoiceDate(
				yearArrayString[yearWV.getCurrentItem()],
				monthArrayString[monthWV.getCurrentItem()],
				dayArrayString[dayWV.getCurrentItem()],
				hourArrayString[hourWV.getCurrentItem()],
				minuteArrayString[minuteWV.getCurrentItem()]);
		return choiceDate;
	}

	// 显示时间
	public static ChoiceDate showDateHour() {
		ChoiceDate choiceDate = new ChoiceDate("", "", "",
				hourArrayString[hourWV.getCurrentItem()], "");
		return choiceDate;
	}

	// 设定初始时间
	public static void setOriTime() {
		yearWV.setCurrentItem(getNumData(c.get(Calendar.YEAR) + "",
				yearArrayString));
		int month=c.get(Calendar.MONTH) + 1;
		String strMonth="";
		if(month<10){
			strMonth="0"+month;
		}else{
			strMonth=""+month;
		}
		monthWV.setCurrentItem(getNumData(strMonth,monthArrayString) + 0);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		String strHour;
		if(hour<10){
			strHour="0"+hour;
		}else{
			strHour=""+hour;
		}
		hourWV.setCurrentItem(getNumData(strHour,hourArrayString));
		int minute = c.get(Calendar.MINUTE);
		String strMinute;
		if(minute<10){
			strMinute="0"+minute;
		}else{
			strMinute=""+minute;
		}
		minuteWV.setCurrentItem(getNumData(strMinute,minuteArrayString));
		
		dayArrayString = getDayArray(getDay(c.get(Calendar.YEAR),
				c.get(Calendar.MONTH)));
		dayWV.setAdapter(new ArrayWheelAdapter<String>(dayArrayString));
		
		int day=c.get(Calendar.DAY_OF_MONTH);
		String strDay="";
		if(day<10){
			strDay="0"+day;
		}else{
			strDay=""+day;
		}
		dayWV.setCurrentItem(getNumData(strDay,dayArrayString));
	}

	// 设定初始时间
	public static void setOriHourTime() {

		hourWV.setCurrentItem(getNumData(c.get(Calendar.HOUR_OF_DAY) + "",
				hourArrayString));

	}

	// 在数组Array[]中找出字符串s的位置
	public static int getNumData(String s, String[] Array) {
		int num = 0;
		for (int i = 0; i < Array.length; i++) {
			if (s.equals(Array[i])) {
				num = i;
				break;
			}
		}
		return num;
	}

	// 根据当前年份和月份判断这个月的天数
	public static int getDay(int year, int month) {
		int day;
		if (year % 4 == 0 && year % 100 != 0) { // 闰年
			if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				day = 31;
			} else if (month == 2) {
				day = 29;
			} else {
				day = 30;
			}
		} else { // 平年
			if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12) {
				day = 31;
			} else if (month == 2) {
				day = 28;
			} else {
				day = 30;
			}
		}
		return day;
	}

	// 根据数字生成一个字符串数组
	public static String[] getDayArray(int day) {
		String[] dayArr = new String[day];
		for (int i = 0; i < day; i++) {
			int flag = i + 1;
			if (flag < 10) {
				dayArr[i] = "0" + (i + 1);
			} else {
				dayArr[i] = "" + (i + 1);
			}
		}
		return dayArr;
	}

	// 根据数字生成一个字符串数组
	public static String[] getHMArray(int day) {
		String[] dayArr = new String[day];
		for (int i = 0; i < day; i++) {
			if (i < 10) {
				dayArr[i] = "0" + (i);
			} else {
				dayArr[i] = "" + (i);
			}
		}
		return dayArr;
	}

	// 根据初始值start和step得到一个字符数组，自start起至start+step-1
	public static String[] getYEARArray(int start, int step) {
		String[] dayArr = new String[step];
		for (int i = 0; i < step; i++) {
			dayArr[i] = start + i + "";
		}
		return dayArr;
	}

	public static class MyPop {
		private WheelView yearWV;
		private WheelView monthWV;
		private WheelView dayWV;
		private WheelView hourWV;
		private WheelView minuteWV;

		private PopupWindow popupWindow;

		public MyPop(PopupWindow popupWindow, WheelView yearWV,
				WheelView monthWV, WheelView dayWV, WheelView hourWV,
				WheelView minuteWV) {
			super();
			this.yearWV = yearWV;
			this.monthWV = monthWV;
			this.dayWV = dayWV;
			this.hourWV = hourWV;
			this.minuteWV = minuteWV;
			this.popupWindow = popupWindow;
		}

		public WheelView getYearWV() {
			return yearWV;
		}

		public void setYearWV(WheelView yearWV) {
			this.yearWV = yearWV;
		}

		public WheelView getMonthWV() {
			return monthWV;
		}

		public void setMonthWV(WheelView monthWV) {
			this.monthWV = monthWV;
		}

		public WheelView getDayWV() {
			return dayWV;
		}

		public void setDayWV(WheelView dayWV) {
			this.dayWV = dayWV;
		}

		public WheelView getHourWV() {
			return hourWV;
		}

		public void setHourWV(WheelView hourWV) {
			this.hourWV = hourWV;
		}

		public WheelView getMinuteWV() {
			return minuteWV;
		}

		public void setMinuteWV(WheelView minuteWV) {
			this.minuteWV = minuteWV;
		}

		public PopupWindow getPopupWindow() {
			return popupWindow;
		}

		public void setPopupWindow(PopupWindow popupWindow) {
			this.popupWindow = popupWindow;
		}
	}
}
