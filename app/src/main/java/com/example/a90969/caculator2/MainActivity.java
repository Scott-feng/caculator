package com.example.a90969.caculator2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    private Button btn_point;
    private Button btn_divide;
    private Button btn_multiply;
    private Button btn_minus;
    private Button btn_plus;
    private Button btn_equal;

    private Button btn_clear;
    private Button btn_del;
    private EditText et_input;
    private boolean clear_flag;
    private double result=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);

        btn_point=(Button) findViewById(R.id.btn_point);
        btn_divide=(Button) findViewById(R.id.btn_divide);
        btn_0=(Button) findViewById(R.id.btn_0);
        btn_multiply=(Button) findViewById(R.id.btn_multiply);
        btn_minus=(Button) findViewById(R.id.btn_minus);
        btn_plus=(Button) findViewById(R.id.btn_plus);
        btn_equal=(Button) findViewById(R.id.btn_equal);

        btn_clear=(Button) findViewById(R.id.btn_clear);
        btn_del=(Button) findViewById(R.id.btn_del);
        et_input=(EditText) findViewById(R.id.et_input);
        et_input.setKeyListener(null);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_point.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String str=et_input.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag){
                    clear_flag=false;

                    et_input.setText("");
                }
                else{et_input.setText(str+((Button)v).getText());}
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag){
                    clear_flag=false;
                    et_input.setText("");
                }
                else{et_input.setText(str+" "+((Button)v).getText()+" ");}
                break;
            case R.id.btn_del:
                if (clear_flag){
                    clear_flag=false;
                    et_input.setText("");
                }else if(str!=null&& !str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_clear:
                clear_flag=false;
                et_input.setText("");
                break;
            case R.id.btn_equal:
                if (clear_flag){
                    clear_flag=false;
                    et_input.setText("");
                    Log.d("MainActivity","equal_fasle");}
                else{getResult();
                    Log.d("MainActivity","get_true");}
                break;
            default:
                break;
        }

    }
    private void getResult(){

        String exp=et_input.getText().toString();
        clear_flag=true;
        if(exp.equals("")&&exp==null){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        if(!s1.equals("")&& !s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=d1+d2;
            }else if (op.equals("-")){
                result=d1-d2;
            }else if(op.equals("X")){
                result=d1*d2;
            }else if(op.equals("/")){
                if(d2==0){
                    result=0;
                }else{
                    result=d1/d2;
                }
            }
            if(!s1.contains(".") && !s2.contains(".") && !op.equals("/")){
                int r=(int)result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result+"");
            }
        }else if(!s1.equals("") && s2.equals("")){
            et_input.setText(exp);
        }else{
            et_input.setText("");
        }
    }
}
