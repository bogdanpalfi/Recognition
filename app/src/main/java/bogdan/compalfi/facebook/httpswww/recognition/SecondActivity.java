package bogdan.compalfi.facebook.httpswww.recognition;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    private Spinner spinner1;
    private TextView showFromTime;

    //when the button "from" is clicked a TimePickerDialog appears and is letting you select the time.
    Button buttonFromTime;
    static final int DIALOG_ID=0;
    int hourFrom;
    int minuteFrom;

    public void showTimePickerDialog(){
        buttonFromTime=(Button) findViewById(R.id.fromTime);
        buttonFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID)
            return new TimePickerDialog(SecondActivity.this, kTimePickerListener,hourFrom,minuteFrom,false);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener kTimePickerListener=
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hourFrom=hourOfDay;
                    minuteFrom=minute;
                    //Toast.makeText(SecondActivity.this, hourFrom+":"+minuteFrom,Toast.LENGTH_SHORT).show();
                    updateDisplay();
                }
            };

    private void updateDisplay() {
        showFromTime.setText(
                new StringBuilder()
                        .append(pad(hourFrom)).append(":")
                        .append(pad(minuteFrom)));
    }
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    private static final String[]paths = {"1","2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showFromTime=(TextView) findViewById(R.id.showFromTime);
        showTimePickerDialog();
        updateDisplay();


        /*spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(SecondActivity.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
*/

        //addListenerOnSpinnerItemSelection();
    }
    /*public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);

    }*/
    public void doneSettings(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
