package webix.example.skalim.contest11.Adater;


        import android.app.Application;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

        import webix.example.skalim.contest11.Contest11InnerPage;
        import webix.example.skalim.contest11.CreateTeam;
        import webix.example.skalim.contest11.CreateTeamMainActivity;
        import webix.example.skalim.contest11.R;

        import static com.facebook.FacebookSdk.getApplicationContext;

public class ContestInnerAdapter extends RecyclerView.Adapter<ContestInnerAdapter.MyViewHolder>
{
    ArrayList text1;
    ArrayList text3;
    Context context;
    private int[] mResources1;
    private int[] mResources2;


    public ContestInnerAdapter(Context context,ArrayList text1,ArrayList text3,int[] resources1,int[] resources2) {
        this.text1 = text1;
        this.text3 = text3;
        this.context = context;
        this.mResources1 = resources1;
        this.mResources2 = resources2;

    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contestinneritem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        /*ListItem listItem = name.get(position);
        holder.text1.setText(listItem.getText());*/
        holder.text1.setText((CharSequence) text1.get(position));


        holder.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,CreateTeamMainActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return text1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        public TextView text1,join;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            text1=(TextView)itemView.findViewById(R.id.example);

            join=(TextView)itemView.findViewById(R.id.join);

        }
        @Override
        public void onClick(View v) {

        }

        public void setItemClickListener(ItemClickListener ic)
        {


        }


    }
}

/*
public class ContestInnerAdapter extends RecyclerView.Adapter {
    ArrayList name, image;
    TabActivity_1 context;

    public ContestInnerAdapter(TabActivity_1 context, ArrayList name, ArrayList image) {

        this.context = context;
        this.name = name;
        this.image = image;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabfirstitems, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       MyViewHolder.name.setText((Integer) name.get(position));
        MyViewHolder.image.setImageResource((Integer) image.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                */
/*Toast.makeText(context, name.get(position), Toast.LENGTH_SHORT).show();*//*

            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
       static TextView name;
       static ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }

}
*/



/*
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabfirstitems, parent, false);

        return new ContestInnerAdapter.MyViewHolder(view);
    }



    @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //set the data in items
            holder.name.setText(name.get(position));
            holder.image.setImageResource(image.get(position));
// implement setOnClickListener event on item view.
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
// open another activity on item click
               *//* Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent*//*
                }
            });


        }

        @Override
        public int getItemCount() {
            return name.size();
        }*/












