package me.tonatihu.extras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ListasActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        final ListView newsEntryListView = findViewById(R.id.list);
        final NewsEntryAdapter newsEntryAdapter = new NewsEntryAdapter(this, R.layout.news_entry_list_item);
        newsEntryListView.setAdapter(newsEntryAdapter);
        for (final NewsEntry entry : getNewsEntries()) {
            newsEntryAdapter.add(entry);
        }
    }

    private List<NewsEntry> getNewsEntries() {
        final List<NewsEntry> entries = new ArrayList<NewsEntry>();
        for (int i = 1; i < 50; i++) {
            entries.add(
                    new NewsEntry(
                            "Test Entry " + i,
                            "Anonymous Author " + i,
                            new GregorianCalendar(2011, 11, i).getTime(),
                            i % 2 == 0 ? R.drawable.pika : R.drawable.pika
                    )
            );
        }
        return entries;
    }
}