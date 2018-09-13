package module;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.tzj.ali.feedback.R;
import com.tzj.ali.feedback.util.UtilFeedBack;

import org.json.JSONObject;

public class ModuleActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
    }

    @Override
    protected void onResume() {
        super.onResume();
        UtilFeedBack.getUnreadCount(new UtilFeedBack.IUnreadCountCallback() {
            @Override
            public void onSuccess(final int i) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView num = findViewById(R.id.msg);
                        num.setText(i>0?"●":"");
                    }
                });
            }
            @Override
            public void onError(int var1, String var2) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        try {
            JSONObject extInfo = new JSONObject();
            extInfo.put("phone", "phone");
            extInfo.put("name", "name");
            extInfo.put("idNo", "idNo");
            FeedbackAPI.setAppExtInfo(extInfo);
        } catch (Exception e) {
        }
        FeedbackAPI.openFeedbackActivity();
    }
}
