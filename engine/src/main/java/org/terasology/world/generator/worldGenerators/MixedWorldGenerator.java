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
package org.terasology.world.generator.worldGenerators;

import org.terasology.engine.SimpleUri;
import org.terasology.logic.generators.DefaultGenerators;
import org.terasology.world.generator.AbstractBaseWorldGenerator;
import org.terasology.world.generator.RegisterWorldGenerator;
import org.terasology.world.generator.chunkGenerators.FloraGenerator;
import org.terasology.world.generator.chunkGenerators.ForestGenerator;
import org.terasology.world.generator.chunkGenerators.MultiTerrainGenerator;
import org.terasology.world.liquid.LiquidsGenerator;

/**
 * @author Immortius
 */
@RegisterWorldGenerator(id = "mixed", displayName = "Mixed", description = "A world generator that uses a mixture of techniques")
public class MixedWorldGenerator extends AbstractBaseWorldGenerator {

    public MixedWorldGenerator(SimpleUri uri) {
        super(uri);
        register(new MultiTerrainGenerator());
        register(new FloraGenerator());
        register(new LiquidsGenerator());
        ForestGenerator forestGenerator = new ForestGenerator();
        new DefaultGenerators(forestGenerator);
        register(forestGenerator);
    }
}
