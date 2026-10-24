package com.example.aimovierecommender;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etMovieName;
    Button btnRecommend;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    Map<String, String[]> movieDataset = new HashMap<>();
    List<MovieItem> recommendationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovieName = findViewById(R.id.etMovieName);
        btnRecommend = findViewById(R.id.btnRecommend);
        recyclerView = findViewById(R.id.recyclerViewResults);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(recommendationList);
        recyclerView.setAdapter(movieAdapter);

        // Populate AI Dataset with genres
        movieDataset.put("The Matrix", new String[]{"Sci-Fi", "Action", "AI"});
        movieDataset.put("Inception", new String[]{"Sci-Fi", "Mind-bending", "Dreams"});
        movieDataset.put("Interstellar", new String[]{"Sci-Fi", "Space", "Exploration"});
        movieDataset.put("Avatar", new String[]{"Sci-Fi", "Action", "Alien"});
        movieDataset.put("Cyberpunk World", new String[]{"Sci-Fi", "AI", "Future"});

        btnRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputMovie = etMovieName.getText().toString().trim();
                if (inputMovie.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a movie name", Toast.LENGTH_SHORT).show();
                    return;
                }

                updateRecommendations(inputMovie);
            }
        });
    }

    private void updateRecommendations(String targetMovie) {
        recommendationList.clear();
        String matchedKey = null;

        for (String key : movieDataset.keySet()) {
            if (key.equalsIgnoreCase(targetMovie)) {
                matchedKey = key;
                break;
            }
        }

        if (matchedKey == null) {
            Toast.makeText(this, "Movie not found in AI Database!", Toast.LENGTH_SHORT).show();
            movieAdapter.notifyDataSetChanged();
            return;
        }

        String[] targetTags = movieDataset.get(matchedKey);

        for (Map.Entry<String, String[]> entry : movieDataset.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(matchedKey)) continue;

            int matchScore = 0;
            for (String tag : entry.getValue()) {
                for (String tTag : targetTags) {
                    if (tag.equalsIgnoreCase(tTag)) matchScore++;
                }
            }

            if (matchScore > 0) {
                StringBuilder genresStr = new StringBuilder("Genres: ");
                for (int i = 0; i < entry.getValue().length; i++) {
                    genresStr.append(entry.getValue()[i]);
                    if (i < entry.getValue().length - 1) genresStr.append(", ");
                }
                recommendationList.add(new MovieItem(entry.getKey(), genresStr.toString()));
            }
        }

        movieAdapter.notifyDataSetChanged();
        if (recommendationList.isEmpty()) {
            Toast.makeText(this, "No recommendations found.", Toast.LENGTH_SHORT).show();
        }
    }

    // Data Class & Adapter for RecyclerView
    public static class MovieItem {
        String title, genres;
        public MovieItem(String title, String genres) {
            this.title = title;
            this.genres = genres;
        }
    }

    public static class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
        List<MovieItem> items;
        public MovieAdapter(List<MovieItem> items) { this.items = items; }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            MovieItem item = items.get(position);
            holder.title.setText("-> " + item.title);
            holder.genres.setText(item.genres);
        }

        @Override
        public int getItemCount() { return items.size(); }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView title, genres;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.tvMovieTitle);
                genres = itemView.findViewById(R.id.tvMovieGenres);
            }
        }
    }
}