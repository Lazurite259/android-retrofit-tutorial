package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<Movie> mData;

    MovieListAdapter(List<Movie> data) {
        this.mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, releaseDateTV, voteTV, overViewTV;
        ImageView movieIV;

        ViewHolder(View itemView) {
            super(itemView);
            movieIV = itemView.findViewById(R.id.ivMovie);
            titleTV = itemView.findViewById(R.id.tvTitle);
            releaseDateTV = itemView.findViewById(R.id.tvReleaseDate);
            voteTV = itemView.findViewById(R.id.tvVote);
            overViewTV = itemView.findViewById(R.id.tvOverview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mData.get(position);
        // display data on the view
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPosterPath()).into(holder.movieIV);
        holder.titleTV.setText(movie.getTitle());
        holder.releaseDateTV.setText(movie.getReleaseDate());
        holder.voteTV.setText(movie.getVoteAverage().toString());
        holder.overViewTV.setText(movie.getOverview());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
