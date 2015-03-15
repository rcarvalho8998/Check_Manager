package gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import listeners.DateSetListener;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

public class DateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

	private DateSetListener listener;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        if(getActivity() instanceof DateSetListener){
        	listener = (DateSetListener) getActivity();
        }
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		Calendar c =  Calendar.getInstance();
		c.set(year,monthOfYear,dayOfMonth);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(c.getTime());
		if(listener != null){
			listener.fetchDate(date);
			System.out.println(date+" " + listener);
		}
		
	}

	public void setListener(DateSetListener listener) {
		this.listener = listener;
		System.out.println(listener);
	}
	
	
		
	
	
}
