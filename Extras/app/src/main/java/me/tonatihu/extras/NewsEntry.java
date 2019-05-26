package me.tonatihu.extras;

import java.util.Date;

/**
 * @author tonatihu
 * Created on 5/26/19
 */
public final class NewsEntry {
    private final String title;
    private final String author;
    private final Date postDate;
    private final int icon;
    public NewsEntry(final String title, final String author,
                     final Date postDate, final int icon) {
        this.title = title;
        this.author = author;
        this.postDate = postDate;
        this.icon = icon;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Date getPostDate() {
        return postDate;
    }
    public int getIcon() {
        return icon;
    }
}
