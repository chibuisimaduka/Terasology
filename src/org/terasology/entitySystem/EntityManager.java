package org.terasology.entitySystem;

import org.terasology.components.LocationComponent;
import org.terasology.components.MeshComponent;

import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Immortius <immortius@gmail.com>
 */
public interface EntityManager {

    void registerComponentClass(Class<? extends Component> componentClass);

    public enum SaveFormat {
        Binary,
        Text,
        JSON
    }

    void save(File file, SaveFormat format) throws IOException;
    void load(File file, SaveFormat format) throws IOException;
    void clear();

    // Entity Management

    /**
     * @return A references to a new, unused entity
     */
    EntityRef create();

    /**
     * @param componentClass
     * @return The number of entities with this component class
     */
    int getComponentCount(Class<? extends Component> componentClass);

    Iterable<EntityRef> iteratorEntities(Class<? extends Component> ...  componentClasses);

    <T extends Component> Iterable<Map.Entry<EntityRef,T>> iterateComponents(Class<T> componentClass);

    EventSystem getEventSystem();
    void setEventSystem(EventSystem system);

}
