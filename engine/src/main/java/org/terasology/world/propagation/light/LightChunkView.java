/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.world.propagation.light;

import org.terasology.math.Vector3i;
import org.terasology.world.ChunkView;
import org.terasology.world.propagation.AbstractChunkView;

/**
 * @author Immortius
 */
public class LightChunkView extends AbstractChunkView {

    public LightChunkView(ChunkView chunkView) {
        super(chunkView);
    }

    @Override
    protected byte getValueAt(ChunkView view, Vector3i pos) {
        return view.getLight(pos);
    }

    @Override
    protected void setValueAt(ChunkView view, Vector3i pos, byte value) {
        view.setLight(pos, value);
    }
}
