package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<SingleTag> children;


    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = new ArrayList<>();
    }

    public String getTagBody() {
        return tagBody;
    }

    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    public List<SingleTag> getChildren() {
        return children;
    }

    public void setChildren(List<SingleTag> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        if(getAttributes().isEmpty())
            return "<" + getTagName()
                          + super.toString()
                          + ">"
                          + getTagBody()
                          + "</"
                          + getTagName()
                          + ">";
        return "<" + getTagName()
               + " "
               + super.toString()
               + ">"
               + getTagBody()
               + "</"
               + getTagName()
               + ">";
    }
}
// END
