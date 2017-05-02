package sg.edu.rp.c346.classjournal;

/**
 * Created by 15056158 on 2/5/2017.
 */

public class moduleRow {
    String Code;
    String Name;
    String url;

    public moduleRow(String Code, String Name, String url) {
        this.Code = Code;
        this.Name = Name;
        this.url = url;

    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

