package mold.ui;

import java.util.Comparator;

public class GenericItem {
    public static Comparator<GenericItem> COMPARE_BY_LABEL_ASCENDING =
            new Comparator<GenericItem>() {
                @Override
                public int compare(GenericItem a, GenericItem b) {
                    return a.label.compareTo(b.label); // sort ascending
                }
            };
    public static Comparator<GenericItem> COMPARE_BY_LABEL_DECENDING =
            new Comparator<GenericItem>() {
                @Override
                public int compare(GenericItem a, GenericItem b) {
                    return b.label.compareTo(a.label); // sort descending
                }
            };
    private Integer id;
    private String label;

    public GenericItem(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
