package de.guntram.mcmod.statssearch.mixins;
    
import de.guntram.mcmod.statssearch.NamedStatEntry;
import de.guntram.mcmod.statssearch.StatsSearch;
import net.minecraft.client.gui.screen.StatsScreen;
import net.minecraft.client.gui.screen.StatsScreen.GeneralStatsListWidget;
import net.minecraft.client.gui.widget.EntryListWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets="net.minecraft.client.gui.screen.StatsScreen$GeneralStatsListWidget")
public class GeneralStatsListWidgetMixin {
    @Redirect(method="<init>", at=@At(value="INVOKE", 
            target="Lnet/minecraft/client/gui/screen/StatsScreen$GeneralStatsListWidget;addEntry(Lnet/minecraft/client/gui/widget/EntryListWidget$Entry;)I"))
    private int possiblyAddEntry(GeneralStatsListWidget self, 
            EntryListWidget.Entry entry) {
        if (((NamedStatEntry)entry).matchesSelection(StatsSearch.getSearchString())) {
            self.addEntry((StatsScreen.GeneralStatsListWidget.Entry)entry);
        }
        return 0; // should return number of children but the value is ignored by the caller anyway
    }
}
