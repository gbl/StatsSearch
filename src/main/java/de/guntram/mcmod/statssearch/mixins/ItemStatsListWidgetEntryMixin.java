package de.guntram.mcmod.statssearch.mixins;

import de.guntram.mcmod.statssearch.NamedStatEntry;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.StatsScreen.ItemStatsListWidget.Entry.class)
public class ItemStatsListWidgetEntryMixin implements NamedStatEntry {
    
    @Shadow @Final Item item;
    
    @Inject(method="render(Lnet/minecraft/client/util/math/MatrixStack;IIIIIIIZF)V", at=@At("HEAD"))
    public void renderStatsListBackground(MatrixStack matrices, int index,
            int y, int x, int entryWidth, int entryHeight, 
            int mouseX, int mouseY, boolean hovered,
            float tickDelta, CallbackInfo ci) {
        // Don't do this here; the mixin is still there for similarity to General and Entity.
        // The real mixin is in StatsScreen#renderStatItem.
    }

    @Override
    public boolean matchesSelection(String selection) {
        // System.out.printf("see if %s matches %s\n", entityTypeName.getString(), selection);
        I18n.translate(item.getTranslationKey());
        return I18n.translate(item.getTranslationKey()).toLowerCase().contains(selection);
    }    
}
