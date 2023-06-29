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
    
    @Override
    public boolean matchesSelection(String selection) {
        // System.out.printf("see if %s matches %s\n", displayName.getString(), selection);
        return displayName.getString().toLowerCase().contains(selection);
    }
    
}
