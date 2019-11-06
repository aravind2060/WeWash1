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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class A_DisplayMyProducts extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<D_OrdersData> dOrdersDataArrayList=new ArrayList<>();
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__display_my_products);
        getDataFromFireBase();
    }
    private void findViewByIds()
    {
      recyclerView=findViewById(R.id.RecyclerViewMyOrders);

    }
  private void getDataFromFireBase()
  {
      DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
      databaseReference.orderByKey().equalTo("MyOrders").addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if (dataSnapshot.exists())
              {
                 for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                 {
                     D_OrdersData dOrdersData=dataSnapshot1.getValue(D_OrdersData.class);
                     if (dOrdersData!=null)
                     {
                        dOrdersDataArrayList.add(dOrdersData);
                        Log.e("DisplayAProduct",""+dOrdersDataArrayList.get(0).name);
                     }
                     else
                     {
                         Log.e("DisplayProduct","Null  returned");
                     }
                 }
              }
              else
              {
                  Toast.makeText(A_DisplayMyProducts.this, "No Past Orders", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {

          }
      });
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
