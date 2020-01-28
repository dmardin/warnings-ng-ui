package edu.hm.hafner.warningsngui.echart;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BarSeries {
    private final static String NONE_STACK = "";
    private final String name;
    @SuppressFBWarnings("SS_SHOULD_BE_STATIC")
    private final String type = "bar";
    @SuppressFBWarnings("SS_SHOULD_BE_STATIC")
    private final List<Integer> data = new ArrayList<>();
    private final String stack;
    private final Optional<ItemStyle> itemStyle;

    public BarSeries(final String name) {
        this(name, NONE_STACK);
    }

    public BarSeries(final String name, final String stack) {
        this.name = name;
        this.stack = stack;
        if(name.isEmpty()){
            itemStyle = Optional.of(new ItemStyle(ItemStyle.TRANSPARENT,ItemStyle.TRANSPARENT));
        }
        else
            itemStyle = Optional.empty();
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStack() {
        return stack;
    }

    public Optional<ItemStyle> getItemStyle() {
        return itemStyle;
    }

    public List<Integer> getData() {
        return data;
    }

    public void add(final int value) {
        data.add(0, value);
    }

    public void addAll(final List<Integer> values) {
        data.addAll(values);
    }
}