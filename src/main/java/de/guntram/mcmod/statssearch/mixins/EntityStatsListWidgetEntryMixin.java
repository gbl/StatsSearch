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

@Mixin(targets="net.minecraft.client.gui.screen.StatsScreen$EntityStatsListWidget$Entry")
public class EntityStatsListWidgetEntryMixin implements NamedStatEntry {
    
    @Shadow @Final Text entityTypeName;
    
    @Inject(method="render(Lnet/minecraft/client/util/math/MatrixStack;IIIIIIIZF)V", at=@At("HEAD"))
    public void renderStatsListBackground(MatrixStack matrices, int index,
            int y, int x, int entryWidth, int entryHeight, 
            int mouseX, int mouseY, boolean hovered,
            float tickDelta, CallbackInfo ci) {
    }
    
    @Override
    public boolean matchesSelection(String selection) {
        // System.out.printf("see if %s matches %s\n", entityTypeName.getString(), selection);
        return entityTypeName.getString().toLowerCase().contains(selection);
    }
}
