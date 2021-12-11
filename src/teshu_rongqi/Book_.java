package teshu_rongqi;

import javax.swing.*;

public class Book_ {
    private String name;
    private Icon icon;
    private String desc;

    public Book_(String name, Icon icon, String desc) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //这里需要重写toString方法，因为在JList中，传递一个类型的数组，在窗口中显示的是该类中toSting方法中返回的值
    @Override
    public String toString() {
        return name;
    }
}
