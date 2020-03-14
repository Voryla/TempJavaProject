package analysisXMLFile.analysisWebXMLFile;

import java.util.HashSet;
import java.util.Set;

public class Pattern {
    private String name;
    private Set<String> url;

    public Pattern() {
        url=new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Set<String> getUrl() {
        return url;
    }

    public void addUrl(String url) {
        this.url.add(url);
    }
}
