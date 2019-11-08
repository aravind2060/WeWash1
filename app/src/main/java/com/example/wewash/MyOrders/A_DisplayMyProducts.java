package com.example.wewash.MyOrders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wewash.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class A_DisplayMyProducts extends AppCompatActivity {

    RecyclerView recyclerView;
    List<D_OrdersData> dOrdersDataArrayList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__display_my_products);
       dOrdersDataArrayList= getDataFromFireBase();

       Log.e("DisplayProduct ","Size in oncreate:"+dOrdersDataArrayList.size());
        Toast.makeText(this, "Size :"+dOrdersDataArrayList.size(), Toast.LENGTH_SHORT).show();
    }
    private void findViewByIds()
    {
      recyclerView=findViewById(R.id.RecyclerViewMyOrders);

    }
  private ArrayList<D_OrdersData> getDataFromFireBase()
  {
      final ArrayList<D_OrdersData> arrayList=new ArrayList<>();
      DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
      databaseReference.child("MyOrders").addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    if (dataSnapshot1.exists()) {
                        String address = dataSnapshot1.child("address").getValue(String.class);
                        String dateBooked = dataSnapshot1.child("dateBooked").getValue(String.class);
                        String expectedDeliveryTime = dataSnapshot1.child("expectedDeliveryTime").getValue(String.class);
                        String name = dataSnapshot1.child("name").getValue(String.class);
                        String noOfClothes = dataSnapshot1.child("noOfClothes").getValue(String.class);
                        String orderId = dataSnapshot1.child("orderId").getValue(String.class);
                        String phone = dataSnapshot1.child("phone").getValue(String.class);
                        String status = dataSnapshot1.child("status").getValue(String.class);
                        arrayList.add( new D_OrdersData(address, dateBooked, expectedDeliveryTime, name, noOfClothes, orderId, phone, status));
                         //dOrdersDataArrayList.add( dataSnapshot1.getValue(D_OrdersData.class));
                         Log.e("DisplayProduct","Going inside");
                    }
                    else
                        Log.e("DisplayProduct","Snapshot does not exist");
                }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {

          }
      });

      return arrayList;
  }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderClass>
    {

        @NonNull
        @Override
        public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {

        }

        private class ViewHolderClass extends RecyclerView.ViewHolder {

            public ViewHolderClass(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

//    class AsyncTaskToFetchPastOrders extends AsyncTask<Void,Void,Void>
//    {
//       ArrayList<D_OrdersData> arrayList=new ArrayList<>();
//        @Override
//        protected Void doInBackground(Void... voids) {
//            DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//            databaseReference.orderByKey().equalTo("MyOrders").addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.exists()) {
//                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                            D_OrdersData dOrdersData = dataSnapshot1.getValue(D_OrdersData.class);
//                            if (dOrdersData != null) {
//                                arrayList.add(dOrdersData);
//                                Log.e("DisplayMyProducts",""+arrayList.get(0).name);
//                            }
//                                else
//                                Log.e("A_DisplayMyProducts", "Unable to get past orders");
//                        }
//                    }
//                    else
//                        return;
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//            return null;
//        }
//    }
}
