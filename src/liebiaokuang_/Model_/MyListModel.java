package liebiaokuang_.Model_;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*public BigDecimal divide(BigDecimal divisor,
                         int scale,
                         RoundingMode roundingMode)
 返回一个 BigDecimal，其值为 (this / divisor)，其标度为指定标度。如果必须执行舍入，以生成具有指定标度的结果，则应用指定的舍入模式。

参数：
divisor - 此 BigDecimal 要除以的值。
scale - 要返回的 BigDecimal 商的标度。
roundingMode - 要应用的舍入模式。


double doubleValue()
          将此 BigDecimal 转换为 double。


BigDecimal setScale(int newScale)
          返回一个 BigDecimal，其标度为指定值，其值在数值上等于此 BigDecimal 的值。 */


//public class MyListModel implements ListModel<BigDecimal>{
public class MyListModel extends AbstractListModel<BigDecimal>{//继承这个实现类就只需要重写这两个方法了，不需要重写四个方法
    BigDecimal start;
    BigDecimal end;
    BigDecimal step;

    public MyListModel(BigDecimal start, BigDecimal end, BigDecimal step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getSize() {//该方法得到条目个数
        int floor = (int) Math.floor(end.subtract(start).divide(step, 2, RoundingMode.HALF_DOWN).doubleValue());
        return floor + 1;
    }

    @Override
    public BigDecimal getElementAt(int index) {//该方法通过索引得到条目
        BigDecimal ele = new BigDecimal(index).multiply(step).add(start).setScale(2, RoundingMode.HALF_DOWN);
        return ele;
    }
}