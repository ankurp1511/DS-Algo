import java.util.Collections;
import java.util.List;

public class ImmutableClass {


    private String str;
    private final List<Integer> list;

    public ImmutableClass(String str, List<Integer> list) {
        this.str = str;
        this.list = list;
    }

    public String getStr() {
        return str;
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(list);
    }
}
