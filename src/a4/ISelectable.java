package a4;

/**
 * Created by School on 11/25/15.
 */

import java.awt.*;

public interface ISelectable {
    public void setSelected(boolean select);
    public boolean isSelected();
    public boolean contains(Point p);
    public void draw(Graphics g);
}
