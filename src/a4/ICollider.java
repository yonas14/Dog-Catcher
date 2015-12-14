package a4;

/**
 * Created by School on 11/18/15.
 */
public interface ICollider {

    boolean collidesWith(ICollider otherObject);
    void handleCollision(ICollider otherObject);
}

