package personal.practices.hbase.beans;

/**
 * Created by CBStubborn on 2017/11/7.
 * <p>
 * 图书信息
 * </p>
 */
public class Record {

    public long timestamp;  //出版年月

    public long id;  //图书编号

    public String press;  //出版社

    public String title;  //图书名称

    public String author;  //作者

    public int words;  //字数

    public int edition;  //版本号

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Record{" +
                "timestamp='" + timestamp + '\'' +
                ", id=" + id +
                ", press='" + press + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", words=" + words +
                ", edition=" + edition +
                '}';
    }
}
