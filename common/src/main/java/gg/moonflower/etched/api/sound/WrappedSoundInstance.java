package gg.moonflower.etched.api.sound;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.AudioStream;
import net.minecraft.client.sounds.SoundBufferLibrary;

import java.util.concurrent.CompletableFuture;

/**
 * Provides the source sound instance for a wrapped sound instance
 * @author CStampler
 */
public interface WrappedSoundInstance {

    /**
     * @return The parent sound instance
     */
    SoundInstance getParent();


    /**
     * Get the audio stream for the sound.
     *
     * @param soundBuffers The sound buffer library.
     * @param sound        The sound to get the stream for.
     * @param looping      Whether the sound should loop.
     * @return A CompletableFuture containing the audio stream.
     */
    }

