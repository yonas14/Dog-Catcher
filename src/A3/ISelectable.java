package A3;

/**
 * Created by School on 11/25/15.
 */

import java.awt.Graphics;
import java.awt.Point;

public interface ISelectable {
    public void setSelected(boolean select);
    public boolean isSelected();
    public boolean contains(Point p);
    public void draw(Graphics g);
}
