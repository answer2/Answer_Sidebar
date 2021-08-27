package ;
import android.content.Context;
import android.widget.PopupWindow;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.Gravity;
import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;
import java.util.ArrayList;
import View.LTextView;

	public class Sidebar {
		private ArrayList list;
		private static Context context;
		private PopupWindow BarPop;
		private LinearLayout lineBar;
		public Sidebar(Context ct,String title){
			this.context = ct;
			list = new ArrayList();
			BarPop = new PopupWindow(context);
			BarPop.setTouchable(false);
			//显示右边栏
			lineBar = new LinearLayout(context);
			lineBar.setOrientation(1);
			lineBar.setBackgroundColor(0);
			LTextView tx = new LTextView(context);
			tx.setText(title);
			tx.setTextSize(16);
			lineBar.addView(tx);
			BarPop.setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
			//加载SideBar界面
			BarPop.setContentView(lineBar);
			BarPop.showAtLocation(lineBar,Gravity.TOP|Gravity.RIGHT,(int)(W()*0.1),(int)(H()*0.13));
		}
		
		//增加右边栏内容
		public void addSideBar(String str){
			LTextView tx1 = new LTextView(context);
			tx1.setText(str);
			list.add(str);
			lineBar.addView(tx1);
		}
		//移除右边栏内容
		public void removeSideBar(String str){
			for (int i = 0;i < list.size();i++){
				if (list.get(i).toString().equals(str)){
					lineBar.removeViewAt(i + 1);
					list.remove(i);
					break;
				}
			}
		}
    public static int W(){
        return (int) (context.getResources().getDisplayMetrics().widthPixels);
    }
    public static int H(){
        return (int) (context.getResources().getDisplayMetrics().heightPixels);
    }
}
