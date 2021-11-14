package de.guntram.mcmod.statssearch.mixins;

import de.guntram.mcmod.statssearch.NamedStatEntry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.StatsScreen.GeneralStatsListWidget.Entry.class)
public class GeneralStatsListWidgetEntryMixin implements NamedStatEntry {

    @Shadow @Final Text displayName;
    
    @Inject(method="render(Lnet/minecraft/client/util/math/MatrixStack;IIIIIIIZF)V", at=@At("HEAD"))
    public void renderStatsListBackground(MatrixStack matrices, int index,
            int y, int x, int entryWidth, int entryHeight, 
            int mouseX, int mouseY, boolean hovered,
            float tickDelta, CallbackInfo ci) {
        /* 
        String match = StatsSearch.getSearchString();
        if (!match.isEmpty() && displayName.getString().toLowerCase().contains(match)) {
            fill(matrices, x, y, x+entryWidth, y+entryHeight+2, 0xff000080);
        }
        */
    }
    
    @Override
    public boolean matchesSelection(String selection) {
        // System.out.printf("see if %s matches %s\n", displayName.getString(), selection);
        return displayName.getString().toLowerCase().contains(selection);
    }
    
}
