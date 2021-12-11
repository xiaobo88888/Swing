package liebiaokuang_.Model_;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class MyComboBoxModel extends MyListModel implements ComboBoxModel<BigDecimal> {
    //当前选中条目的索引
    private int selectedId;

    public MyComboBoxModel(BigDecimal start, BigDecimal end, BigDecimal step) {
        super(start, end, step);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof BigDecimal){
            BigDecimal curr = (BigDecimal) anItem;
            selectedId = curr.subtract(super.start).divide(super.step, 2, RoundingMode.HALF_DOWN).intValue();
        }
    }

    @Override
    public Object getSelectedItem() {
        BigDecimal item = new BigDecimal(selectedId).multiply(super.step).add(super.start).setScale(1, RoundingMode.HALF_DOWN);
        return item;
    }
}
