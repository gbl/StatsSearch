package de.guntram.mcmod.statssearch.mixins;

import de.guntram.mcmod.statssearch.NamedStatEntry;
import net.minecraft.client.gui.DrawContext;
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

    @Override
    public boolean matchesSelection(String selection) {
        // System.out.printf("see if %s matches %s\n", entityTypeName.getString(), selection);
        I18n.translate(item.getTranslationKey());
        return I18n.translate(item.getTranslationKey()).toLowerCase().contains(selection);
    }    
}
