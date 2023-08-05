package gg.moonflower.etched.common.network.play;

import gg.moonflower.etched.api.record.PlayableRecord;
import gg.moonflower.etched.api.record.TrackData;
import gg.moonflower.etched.common.network.play.handler.EtchedClientPlayPacketHandler;
import gg.moonflower.pollen.api.network.packet.PollinatedPacket;
import gg.moonflower.pollen.api.network.packet.PollinatedPacketContext;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

/**
 * @author CStampler
 */
public class ClientboundPlayMusicPacket implements PollinatedPacket<EtchedClientPlayPacketHandler> {

    private final ItemStack record;
    private final BlockPos pos;

    public ClientboundPlayMusicPacket(ItemStack record, BlockPos pos) {
        this.record = record;
        this.pos = pos;
    }

    public ClientboundPlayMusicPacket(FriendlyByteBuf buf) {
        this.record = buf.readItem();
        this.pos = buf.readBlockPos();
    }

    @Override
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeItem(this.record);
        buf.writeBlockPos(this.pos);
    }

    @Override
    public void processPacket(EtchedClientPlayPacketHandler handler, PollinatedPacketContext ctx) {
        handler.handlePlayMusicPacket(this, ctx);
    }

    /**
     * @return The tracks to play in sequence
     */
    public TrackData[] getTracks() {
        return PlayableRecord.getStackMusic(this.record).orElseGet(() -> new TrackData[0]);
    }

    /**
     * @return The position the music disk is playing at
     */
    public BlockPos getPos() {
        return pos;
    }
}
