package com.example.wewash.MyOrders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wewash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class A_InsertMyOrders extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout NameLayout,PhoneNumberLayout,EmailLayout,AddressLayout;
    TextInputEditText Name,Phone,Email,Address;
    Spinner NoOfClothes,PickUpTime,Area;
    Button BookNow,PickUpDate;
    private int mYear, mMonth, mDay;
    int noOfPreviousOrders=0;
    String noOfClothes,mtime;
    String mArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__insert_my_orders);
      findViewByIds();
    }

    private void findViewByIds()
    {
        NameLayout=findViewById(R.id.Txt_Input_Layout_MyOrders1);
        Name=findViewById(R.id.Txt_Input_EditText_Name);
        PhoneNumberLayout=findViewById(R.id.Txt_Input_Layout_MyOrders2);
        Phone=findViewById(R.id.Txt_Input_EditText_PhoneNumber);
        EmailLayout=findViewById(R.id.Txt_Input_Layout_MyOrders3);
        Email=findViewById(R.id.Txt_Input_EditText_Email);
        AddressLayout=findViewById(R.id.Txt_Input_Layout_MyOrders4);
        Address=findViewById(R.id.Address);
        PickUpDate=findViewById(R.id.PickUpDate);
        NoOfClothes=findViewById(R.id.total);
        PickUpTime=findViewById(R.id.time);
        Area=findViewById(R.id.area);
        BookNow=findViewById(R.id.booknow);
        BookNow.setOnClickListener(this);

        setSpinnerArea();
        //setSpinnerPickUpDate();
        setSpinnerPickTime();
        setSpinnerNoOfClothes();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.booknow)
        {
          if (checkName(Name.getEditableText().toString()) && checkPhone(Phone.getEditableText().toString()) && checkEmail(Email.getEditableText().toString()) && checkAddress(Address.getEditableText().toString())  && checkNoOfClothes(noOfClothes) && checkPickUpTime(mtime))
          {
              DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("MyOrders");

              D_OrdersData d_ordersData=new D_OrdersData(Name.getEditableText().toString(),Address.getEditableText().toString(),Phone.getEditableText().toString(),"6-05-2019",""+mtime,""+noOfClothes);
              databaseReference.push().setValue(d_ordersData).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                      if (task.isSuccessful())
                      {
                          Toast.makeText(getApplicationContext(), "order Placed Successfully ", Toast.LENGTH_LONG).show();
                           onBackPressed();
                      }
                      else
                          Toast.makeText(A_InsertMyOrders.this, "Unable to Place Order", Toast.LENGTH_SHORT).show();
                  }
              });
          }
        }
    }


    private boolean checkName(String name) {
        if (!TextUtils.isEmpty(name)) {
            NameLayout.setError(null);
            return true;
        } else {
           NameLayout.setError("Name cannot be empty!");
            return false;
        }
    }
    private boolean checkPhone(String phone) {
        if (phone.length()==10)
        {
            PhoneNumberLayout.setError(null);
            return true;
        }
        else
        {
            PhoneNumberLayout.setError("Some thing Wrong");
            return false;
        }
    }
    private boolean checkEmail(String email) {
        if (!TextUtils.isEmpty(email)) {
            EmailLayout.setError(null);
            return true;
        } else {
            EmailLayout.setError("Email cannot be empty!");
            return false;
        }
    }
    private boolean checkAddress(String address) {
        if (!TextUtils.isEmpty(address)) {
            AddressLayout.setError(null);
            return true;
        } else {
            AddressLayout.setError("Address cannot be empty!");
            return false;
        }
    }
//    private boolean checkDate(int year,int month,int date)
//    {
//        if (year==0 || month==0 || date==0) {
//            Toast.makeText(A_InsertMyOrders.this, "Please select Date", Toast.LENGTH_SHORT).show();
//           return false;
//        }
//        else
//            return true;
//    }
    private boolean checkNoOfClothes(String noofclothes)
    {
        if (TextUtils.isEmpty(noofclothes)) {
            Toast.makeText(A_InsertMyOrders.this, "Please select No.of Clothes", Toast.LENGTH_SHORT).show();
            return false;
        }
            else
                return true;
    }

    private boolean checkPickUpTime(String time) {
        if (TextUtils.isEmpty(time)) {
            Toast.makeText(A_InsertMyOrders.this, "Please Select Time", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            mtime =time;
            return true;
        }
    }

   private void setSpinnerArea()
   {
       ArrayAdapter<CharSequence>arrayAdapter=ArrayAdapter.createFromResource(this,R.array.AreaList,android.R.layout.simple_spinner_item);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       Area.setAdapter(arrayAdapter);

       Area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               mArea=parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
   }

   private void setSpinnerPickTime()
   {
       ArrayAdapter<CharSequence>arrayAdapter=ArrayAdapter.createFromResource(this,R.array.PickUpTime,android.R.layout.simple_spinner_item);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       PickUpTime.setAdapter(arrayAdapter);

       PickUpTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               mtime=parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
   }

   private void setSpinnerPickUpDate()
   {
       PickUpDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final Calendar c = Calendar.getInstance();
               mYear = c.get(Calendar.YEAR);
               mMonth = c.get(Calendar.MONTH);
               mDay = c.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {

                   @Override
                   public void onDateSet(DatePicker view, int year,
                                         int monthOfYear, int dayOfMonth) {

                       //PickUpDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                   }
               }, mYear, mMonth, mDay);
               datePickerDialog.show();
               datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
               datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 604800000);

           }
       });
   }

   private void setSpinnerNoOfClothes()
   {
       ArrayAdapter<CharSequence>arrayAdapter=ArrayAdapter.createFromResource(this,R.array.NoOfClothes,android.R.layout.simple_spinner_item);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      NoOfClothes.setAdapter(arrayAdapter);

       NoOfClothes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               noOfClothes=parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
   }


}
