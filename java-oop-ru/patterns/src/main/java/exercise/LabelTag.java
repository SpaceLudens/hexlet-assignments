package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface tagInterface;

    public LabelTag(String tag, TagInterface tagInterface) {
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    public String getTag() {
        return tag;
    }

    public TagInterface getTagInterface() {
        return tagInterface;
    }

    @Override
    public String render() {
        return "<label>" + getTag()
                + tagInterface.render()
                + "</label>";
    }
}
// END
