package de.guntram.mcmod.statssearch.mixins;

import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets="net.minecraft.client.gui.screen.StatsScreen$ItemStatsListWidget$Entry")
public class ItemStatsListWidgetEntryMixin {
    
    @Inject(method="render(Lnet/minecraft/client/util/math/MatrixStack;IIIIIIIZF)V", at=@At("HEAD"))
    public void renderStatsListBackground(MatrixStack matrices, int index,
            int y, int x, int entryWidth, int entryHeight, 
            int mouseX, int mouseY, boolean hovered,
            float tickDelta, CallbackInfo ci) {
        // Don't do this here; the mixin is still there for similarity to General and Entity.
        // The real mixin is in StatsScreen#renderStatItem.
        // System.out.printf("rSLB: x=%d y=%d width=%d height=%d\n", x, y, entryWidth, entryHeight);
        //String match = StatsSearch.getSearchString();
        //if (!match.isEmpty() && field_26548.getString().toLowerCase().contains(match)) {
            // fill(matrices, x, y, x+entryWidth, y+entryHeight, 0xff000080);
        //}
    }
}
