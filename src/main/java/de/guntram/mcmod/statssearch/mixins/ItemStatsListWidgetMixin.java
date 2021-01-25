package de.guntram.mcmod.statssearch.mixins;

import de.guntram.mcmod.statssearch.StatsSearch;
import java.util.Iterator;
import java.util.List;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(targets="net.minecraft.client.gui.screen.StatsScreen$ItemStatsListWidget")
public class ItemStatsListWidgetMixin {
    
    @Shadow @Final protected List<Item> items;
    
    @Inject(method="<init>", at=@At(value="INVOKE_ASSIGN", 
            target="Lcom/google/common/collect/Lists;newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;",
            shift=At.Shift.AFTER))
    private void patchItems(CallbackInfo ci) {
        String s = StatsSearch.getSearchString();
        if (s.isEmpty()) {
            return;
        }
        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item item = iter.next();
            if (!item.getName().getString().toLowerCase().contains(s)) {
                iter.remove();
            }
        }
    }
}
