package A3;

/**
 * Created by School on 11/18/15.
 */
public interface ICollider {

    boolean collidesWith(GameObject otherObject);
    void handleCollision(GameObject otherObject);
}

